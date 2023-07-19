'use strict';

var cmdHelper = require('../../../../helper/CmdHelper');

var is = require('../../../../../bpmn-js/util/ModelUtil').is,
    domQuery = require('min-dom').query,
    domify = require('min-dom').domify,
    domAttr = require('min-dom').attr;

var forEach = require('lodash/forEach'),
    find = require('lodash/find');

var entryFactory = require('../../../../factory/EntryFactory');
var elementHelper = require('../../../../helper/ElementHelper');
const { getBusinessObject } = require('../../../../../bpmn-js/util/ModelUtil');
var utils = require('../../../../Utils'),
    escapeHTML = utils.escapeHTML;

var distributionTaskExpression = require('../utils').distributionTaskExpression,
    getChannelAndResource = require('../utils').getChannelAndResource;

var selector = 'select[name=selectedElement]';

function getResourceName(data, urlAndText) {
  if (data.subjectOptions) {
    let selected = data.subjectOptions.find(x => x.value === urlAndText.resourceType);
    if (selected) {
      let subSelected = selected.children.find(x => x.value === urlAndText.resourceId);
      if (subSelected) {
        return subSelected.name;
      }
    }
  }
  return urlAndText.resourceId;
}


function getSelectBox(node) {
  return domQuery(selector, node.parentElement);
}

function isConnection(element) {
  return element.waypoints;
}

function findElementById(eventDefinition, type, id) {
  var elements = utils.findRootElementsByType(eventDefinition, type);
  return find(elements, function(element) {
    return element.id === id;
  });
}

function getEventDefinition(eventOrFunction, element, node) {
  if (typeof eventOrFunction === 'function') {
    return timerOrFunction(element, node);
  }

  return eventOrFunction;
}

function getResourceElement(element) {
  if (!element)
    return undefined;
  var bo = getBusinessObject(element);
  if (is(element, 'bpmn:ServiceTask') && (element.customType == 'distributeAD' || bo.get('flowable:customType') == 'distributeAD')) {
    return element;
  }
  var incoming = element.incoming;
  if (incoming && incoming.length > 0) {
    if (isConnection(incoming[0])) {
      var businessObject = getBusinessObject(incoming[0]);
      var sourceObject = businessObject.sourceRef;
      return getResourceElement(sourceObject);
    }
    return getResourceElement(incoming[0])
  } else {
    return undefined;
  }
}

module.exports = function(element, definition, bpmnFactory, data, options) {
  var elementName = options.elementName || '',
      elementType = options.elementType,
      referenceProperty = options.referenceProperty;

  var newElementIdPrefix = options.newElementIdPrefix || 'elem_';

  var label = options.label || '',
      description = options.description || '';

  var root = utils.getRoot(definition);
  var rootId = root.id;
  var entries = [];

  var messageTypeOptions = [];
  var refId = '';
  if(data) {
    refId = data.refId;
    messageTypeOptions = data.messageTypeOptions;
  }

  entries.push(entryFactory.selectBox({
    id: 'event-definitions-' + elementName,
    label: label,
    selectOptions: messageTypeOptions,
    modelProperty: referenceProperty,
    get: function(element) {

      var reference = definition.get(referenceProperty)

      return {
        messageRef: (reference && reference.get('flowable:messageType')) || ''
      };
    },
    set: function(element, values) {
      var selection = values.messageRef;
      var props = {};
      if (!selection || typeof selection === 'undefined') {
        // remove reference to element
        props[referenceProperty] = undefined;
        return cmdHelper.updateBusinessObject(element, definition, props);
      }

      var commands = [];

      var bo = getBusinessObject(element);
      var selectedElement =  bo.eventDefinitions[0].get(referenceProperty);//findElementById(definition, elementType, referenceProperty);
      if (!selectedElement) {
        // create a new element
        selectedElement = elementHelper.createElement(elementType, { name: utils.nextId('message'), 'flowable:messageType': selection,  }, root, bpmnFactory);
        commands.push(cmdHelper.addAndRemoveElementsFromList(element, root, 'rootElements', null, [ selectedElement ]));
      } else {
        selectedElement.set('flowable:messageType', selection)
      }

      props[referenceProperty] = selectedElement;
      commands.push(cmdHelper.updateBusinessObject(element, definition, props));

      return commands;
    },
    validate: function(element, values) {
      return  {};
    }
  }));

  entries.push(entryFactory.selectBox({
    id: 'event-definitions-ref-' + elementName,
    description: description,
    label: '关联ID',
    selectOptions: function(element, node) {
      var reference = definition.get(referenceProperty)
      let selectedType = (reference && reference.get('flowable:messageType')) || '';
      if (selectedType == 'ACTIVITY_VIEW' || selectedType == 'ACTIVITY_PARTICIPATE') {
        var resourceElement = getResourceElement(element);
        if (resourceElement) {
          var delegateExpression = getBusinessObject(resourceElement).get('flowable:expression');
          if (delegateExpression) {
            var urlAndText = getChannelAndResource(delegateExpression, distributionTaskExpression);
            return [{value: urlAndText.resourceId, name: getResourceName(data, urlAndText)}];
          }
        } else {
          return [refId];
        }
      } else {
        let selectedElement = messageTypeOptions.find((x) => x.value === selectedType);
        return selectedElement ? selectedElement.data : [];
      }
    },
    modelProperty: 'refId',
    get: function(element) {
      var reference = definition.get(referenceProperty)
      // let selectedType = (reference && reference.get('flowable:messageType')) || '';
      // if (selectedType == 'ACTIVITY_VIEW' || selectedType == 'ACTIVITY_PARTICIPATE') {
      //   var resourceElement = getResourceElement(element);
      //   if (resourceElement) {
      //     var delegateExpression = getBusinessObject(resourceElement).get('flowable:expression');
      //     if (delegateExpression) {
      //       var urlAndText = getChannelAndResource(delegateExpression, distributionTaskExpression);
      //       return {
      //         refId: urlAndText.resourceId
      //       };
      //     }
      //   } else {
      //     return {
      //       refId: refId.value
      //     };
      //   }
      // } else {
        var reference = definition.get(referenceProperty)
        return {
          refId: (reference && reference.get('flowable:refId')) || ''
        };
      // }
    },

    set: function(element, values) {
      var props = {};
      if (!values || typeof values === 'undefined') {
        // remove reference to element
        props[referenceProperty] = undefined;
        return cmdHelper.updateBusinessObject(element, definition, props);
      }
      var commands = [];

      var bo = getBusinessObject(element);
      var selectedElement =  bo.eventDefinitions[0].get(referenceProperty);//findElementById(definition, elementType, referenceProperty);
      if (!selectedElement) {
        // create a new element
        selectedElement = elementHelper.createElement(elementType, { name: utils.nextId('message'), 'flowable:refId': values.refId,  }, root, bpmnFactory);
        commands.push(cmdHelper.addAndRemoveElementsFromList(element, root, 'rootElements', null, [ selectedElement ]));
      } else {
        selectedElement.set('flowable:refId', values.refId)
      }

      props[referenceProperty] = selectedElement;
      commands.push(cmdHelper.updateBusinessObject(element, definition, props));

      return commands;
    },
    validate: function(element, values) {
      return  {};
    }

  }));

  return entries;

};
