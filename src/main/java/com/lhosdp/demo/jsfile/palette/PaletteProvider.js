import {
  assign
} from 'min-dash';


/**
 * A palette provider for BPMN 2.0 elements.
 */
export default function PaletteProvider(
    palette, create, elementFactory,
    spaceTool, lassoTool, handTool,
    globalConnect, translate) {

  this._palette = palette;
  this._create = create;
  this._elementFactory = elementFactory;
  this._spaceTool = spaceTool;
  this._lassoTool = lassoTool;
  this._handTool = handTool;
  this._globalConnect = globalConnect;
  this._translate = translate;

  palette.registerProvider(this);
}

PaletteProvider.$inject = [
  'palette',
  'create',
  'elementFactory',
  'spaceTool',
  'lassoTool',
  'handTool',
  'globalConnect',
  'translate'
];


PaletteProvider.prototype.getPaletteEntries = function(element) {

  var actions = {},
      create = this._create,
      elementFactory = this._elementFactory,
      spaceTool = this._spaceTool,
      lassoTool = this._lassoTool,
      handTool = this._handTool,
      globalConnect = this._globalConnect,
      translate = this._translate;

  function createAction(type, group, className, title, options) {

    function createListener(event) {
      var shape = elementFactory.createShape(assign({ type: type }, options));

      if (options) {
        shape.businessObject.di.isExpanded = options.isExpanded;
        if (options.name)
          shape.businessObject.name = options.name;
      }

      create.start(event, shape);
    }

    var shortType = type.replace(/^bpmn:/, '');

    return {
      group: group,
      className: className,
      title: title || translate('Create {type}', { type: shortType }),
      action: {
        dragstart: createListener,
        click: createListener
      }
    };
  }

  function createSubprocess(event) {
    var subProcess = elementFactory.createShape({
      type: 'bpmn:SubProcess',
      x: 0,
      y: 0,
      isExpanded: true
    });

    var startEvent = elementFactory.createShape({
      type: 'bpmn:StartEvent',
      x: 40,
      y: 82,
      parent: subProcess
    });

    create.start(event, [ subProcess, startEvent ], {
      hints: {
        autoSelect: [ startEvent ]
      }
    });
  }

  function createParticipant(event) {
    create.start(event, elementFactory.createParticipantShape());
  }

  assign(actions, {
//    'create.start-event-timer': createAction(
//      'bpmn:StartEvent', 'event', 'bpmn-icon-start-event-message',
//      '启动事件监听', {eventDefinitionType: 'bpmn:MessageEventDefinition'}
//    ),
    'create.start-event': createAction(
      'bpmn:StartEvent', 'event', 'bpmn-icon-start-event-none',
      '开始'
    ),
    // 'create.intermediate-event': createAction(
    //   'bpmn:IntermediateThrowEvent', 'event', 'bpmn-icon-intermediate-event-none',
    //   '中间'
    // ),
    'create.intermediate-event-timer': createAction(
      'bpmn:IntermediateCatchEvent', 'event', 'bpmn-icon-intermediate-event-catch-message',
      '中间事件监听', {eventDefinitionType: 'bpmn:MessageEventDefinition'}
    ),
    'create.end-event': createAction(
      'bpmn:EndEvent', 'event', 'bpmn-icon-end-event-none',
      '结束'
    ),
    'create.handoutTask': createAction(
      'bpmn:ServiceTask', 'activity', 'bpmn-icon-service',
      '给用户发权益', {customType: 'handoutRight', name: '给用户发权益'}
    ),
    'create.queryRight': createAction(
      'bpmn:ServiceTask', 'activity', 'bpmn-icon-service',
      '查询权益使用', {customType: 'queryRight', name: '查询权益使用'}
    ),
//    'create.sendMessage': createAction(
//      'bpmn:ServiceTask', 'activity', 'bpmn-icon-service',
//      '推送消息', {customType: 'sendMessage', name: '推送消息'}
//    ),
    'create.distributeAD': createAction(
      'bpmn:ServiceTask', 'activity', 'bpmn-icon-service',
      '投放广告', {customType: 'distributeAD', name: '投放广告'}
     ),
    'create.userTag': createAction(
        'bpmn:ServiceTask', 'activity', 'bpmn-icon-service',
        '标签设置', {customType: 'userTag', name: '标签设置'}
    ),
//    'create.winning': createAction(
//        'bpmn:IntermediateCatchEvent',
//        'activity',
//        'bpmn-icon-intermediate-event-catch-message',
//        '监听中奖消息',
//        {customType: 'sendMessage', name: '监听中奖消息', eventDefinitionType:'bpmn:MessageEventDefinition'}
//    ),
//    'create.queryWinning': createAction(
//        'bpmn:ServiceTask',
//        'activity',
//        'bpmn-icon-service',
//        '查询用户中奖',
//        {customType: 'queryWinning', name: '查询用户中奖'}
//    ),
    // 'create.syncTask': createAction(
    //   'bpmn:ServiceTask', 'activity', 'bpmn-icon-service',
    //   '同步服务调用', {customType: 'syncService'}
    // ),
    // 'create.asyncTask': createAction(
    //   'bpmn:ServiceTask', 'activity', 'bpmn-icon-service',
    //   '异步服务调用', {customType: 'asyncService'}
    // ),
    'create.intermediate-event': createAction(
      'bpmn:IntermediateCatchEvent', 'event', 'bpmn-icon-intermediate-event-catch-timer',
      '延时处理', {eventDefinitionType: 'bpmn:TimerEventDefinition'}
    ),
    'create.exclusive-gateway': createAction(
      'bpmn:ExclusiveGateway', 'gateway', 'bpmn-icon-gateway-none',
      '网关'
    ),
    // 'create.task': createAction(
    //   'bpmn:Task', 'activity', 'bpmn-icon-task',
    //   '任务'
    // ),
    // 'create.data-object': createAction(
    //   'bpmn:DataObjectReference', 'data-object', 'bpmn-icon-data-object',
    //   '数据对象'
    // ),
    // 'create.data-store': createAction(
    //   'bpmn:DataStoreReference', 'data-store', 'bpmn-icon-data-store',
    //   '数据存储'
    // ),
    // 'create.subprocess-expanded': {
    //   group: 'activity',
    //   className: 'bpmn-icon-subprocess-expanded',
    //   title: '子流程',
    //   action: {
    //     dragstart: createSubprocess,
    //     click: createSubprocess
    //   }
    // },
    // 'create.participant-expanded': {
    //   group: 'collaboration',
    //   className: 'bpmn-icon-participant',
    //   title: '扩展流程',
    //   action: {
    //     dragstart: createParticipant,
    //     click: createParticipant
    //   }
    // },
    // 'create.group': createAction(
    //   'bpmn:Group', 'artifact', 'bpmn-icon-group',
    //   '分组'
    // ),
  });

  return actions;
};
