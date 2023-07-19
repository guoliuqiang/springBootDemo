export var START_EVENT = [
  {
    label: '开始事件',
    actionName: 'replace-with-none-start',
    className: 'bpmn-icon-start-event-none',
    target: {
      type: 'bpmn:StartEvent'
    }
  }
];

export var START_EVENT_SUB_PROCESS = [
  {
    label: '开始事件',
    actionName: 'replace-with-none-start',
    className: 'bpmn-icon-start-event-none',
    target: {
      type: 'bpmn:StartEvent'
    }
  },
  {
    label: '中间事件',
    actionName: 'replace-with-none-intermediate-throwing',
    className: 'bpmn-icon-intermediate-event-none',
    target: {
      type: 'bpmn:IntermediateThrowEvent'
    }
  },
  {
    label: '结束事件',
    actionName: 'replace-with-none-end',
    className: 'bpmn-icon-end-event-none',
    target: {
      type: 'bpmn:EndEvent'
    }
  }
];

export var INTERMEDIATE_EVENT = [
  {
    label: '消息中间捕获事件',
    actionName: 'replace-with-message-intermediate-catch',
    className: 'bpmn-icon-intermediate-event-catch-message',
    target: {
      type: 'bpmn:IntermediateCatchEvent',
      eventDefinitionType: 'bpmn:MessageEventDefinition'
    }
  }
];

export var END_EVENT = [
  {
    label: '结束事件',
    actionName: 'replace-with-none-end',
    className: 'bpmn-icon-end-event-none',
    target: {
      type: 'bpmn:EndEvent'
    }
  }
];

export var GATEWAY = [
  {
    label: '互斥网关',
    actionName: 'replace-with-exclusive-gateway',
    className: 'bpmn-icon-gateway-xor',
    target: {
      type: 'bpmn:ExclusiveGateway'
    }
  },
  {
    label: '并行网关',
    actionName: 'replace-with-parallel-gateway',
    className: 'bpmn-icon-gateway-parallel',
    target: {
      type: 'bpmn:ParallelGateway'
    }
  },
  {
    label: '相容网关',
    actionName: 'replace-with-inclusive-gateway',
    className: 'bpmn-icon-gateway-or',
    target: {
      type: 'bpmn:InclusiveGateway'
    }
  }


  // Gateways deactivated until https://github.com/bpmn-io/bpmn-js/issues/194
  // {
  //   label: 'Event based instantiating Gateway',
  //   actionName: 'replace-with-exclusive-event-based-gateway',
  //   className: 'bpmn-icon-exclusive-event-based',
  //   target: {
  //     type: 'bpmn:EventBasedGateway'
  //   },
  //   options: {
  //     businessObject: { instantiate: true, eventGatewayType: 'Exclusive' }
  //   }
  // },
  // {
  //   label: 'Parallel Event based instantiating Gateway',
  //   actionName: 'replace-with-parallel-event-based-instantiate-gateway',
  //   className: 'bpmn-icon-parallel-event-based-instantiate-gateway',
  //   target: {
  //     type: 'bpmn:EventBasedGateway'
  //   },
  //   options: {
  //     businessObject: { instantiate: true, eventGatewayType: 'Parallel' }
  //   }
  // }
];

export var SUBPROCESS_EXPANDED = [
  {
    label: '转运',
    actionName: 'replace-with-transaction',
    className: 'bpmn-icon-transaction',
    target: {
      type: 'bpmn:Transaction',
      isExpanded: true
    }
  },
  {
    label: '事件子流程',
    actionName: 'replace-with-event-subprocess',
    className: 'bpmn-icon-event-subprocess-expanded',
    target: {
      type: 'bpmn:SubProcess',
      triggeredByEvent: true,
      isExpanded: true
    }
  },
  {
    label: '事件子流程(折叠)',
    actionName: 'replace-with-collapsed-subprocess',
    className: 'bpmn-icon-subprocess-collapsed',
    target: {
      type: 'bpmn:SubProcess',
      isExpanded: false
    }
  }
];

export var TRANSACTION = [
  {
    label: 'Sub Process',
    actionName: 'replace-with-subprocess',
    className: 'bpmn-icon-subprocess-expanded',
    target: {
      type: 'bpmn:SubProcess',
      isExpanded: true
    }
  },
  {
    label: 'Event Sub Process',
    actionName: 'replace-with-event-subprocess',
    className: 'bpmn-icon-event-subprocess-expanded',
    target: {
      type: 'bpmn:SubProcess',
      triggeredByEvent: true,
      isExpanded: true
    }
  }
];

export var EVENT_SUB_PROCESS = [
  {
    label: '子流程',
    actionName: 'replace-with-subprocess',
    className: 'bpmn-icon-subprocess-expanded',
    target: {
      type: 'bpmn:SubProcess',
      isExpanded: true
    }
  },
  {
    label: '转运',
    actionName: 'replace-with-transaction',
    className: 'bpmn-icon-transaction',
    target: {
      type: 'bpmn:Transaction',
      isExpanded: true
    }
  }
];

export var TASK = [
  {
    label: '给用户发权益',
    actionName: 'replace-with-handout-right',
    className: 'bpmn-icon-service',
    customType: 'handoutRight',
    target: {
      type: 'bpmn:ServiceTask'
    }
  },
  {
    label: '查询权益使用',
    actionName: 'replace-with-query-right',
    className: 'bpmn-icon-service',
    customType: 'queryRight',
    target: {
      type: 'bpmn:ServiceTask'
    },
  },
  {
    label: '推送消息',
    actionName: 'replace-with-send-message',
    className: 'bpmn-icon-service',
    customType: 'sendMessage',
    target: {
      type: 'bpmn:ServiceTask'
    }
  },
  {
      label: '投放广告',
      actionName: 'replace-with-distribute-ad',
      className: 'bpmn-icon-service',
      customType: 'distributeAD',
      target: {
        type: 'bpmn:ServiceTask'
      }
    },
  {
    label: '为用户设置标签',
    actionName: 'replace-with-user-tag',
    className: 'bpmn-icon-service',
    customType: 'userTag',
    target: {
      type: 'bpmn:ServiceTask'
    }
  },
];

export var BOUNDARY_EVENT = [
  {
    label: '消息边界事件',
    actionName: 'replace-with-message-boundary',
    className: 'bpmn-icon-intermediate-event-catch-message',
    target: {
      type: 'bpmn:BoundaryEvent',
      eventDefinitionType: 'bpmn:MessageEventDefinition'
    }
  },
  {
    label: '定时边界事件',
    actionName: 'replace-with-timer-boundary',
    className: 'bpmn-icon-intermediate-event-catch-timer',
    target: {
      type: 'bpmn:BoundaryEvent',
      eventDefinitionType: 'bpmn:TimerEventDefinition'
    }
  },
  {
    label: '升级边界事件',
    actionName: 'replace-with-escalation-boundary',
    className: 'bpmn-icon-intermediate-event-catch-escalation',
    target: {
      type: 'bpmn:BoundaryEvent',
      eventDefinitionType: 'bpmn:EscalationEventDefinition'
    }
  },
  {
    label: '条件边界事件',
    actionName: 'replace-with-conditional-boundary',
    className: 'bpmn-icon-intermediate-event-catch-condition',
    target: {
      type: 'bpmn:BoundaryEvent',
      eventDefinitionType: 'bpmn:ConditionalEventDefinition'
    }
  },
  {
    label: '错误边界事件',
    actionName: 'replace-with-error-boundary',
    className: 'bpmn-icon-intermediate-event-catch-error',
    target: {
      type: 'bpmn:BoundaryEvent',
      eventDefinitionType: 'bpmn:ErrorEventDefinition'
    }
  },
  {
    label: '取消边界事件',
    actionName: 'replace-with-cancel-boundary',
    className: 'bpmn-icon-intermediate-event-catch-cancel',
    target: {
      type: 'bpmn:BoundaryEvent',
      eventDefinitionType: 'bpmn:CancelEventDefinition'
    }
  },
  {
    label: '信号边界事件',
    actionName: 'replace-with-signal-boundary',
    className: 'bpmn-icon-intermediate-event-catch-signal',
    target: {
      type: 'bpmn:BoundaryEvent',
      eventDefinitionType: 'bpmn:SignalEventDefinition'
    }
  },
  {
    label: '补偿边界事件',
    actionName: 'replace-with-compensation-boundary',
    className: 'bpmn-icon-intermediate-event-catch-compensation',
    target: {
      type: 'bpmn:BoundaryEvent',
      eventDefinitionType: 'bpmn:CompensateEventDefinition'
    }
  },
  {
    label: '消息边界事件（非中断）',
    actionName: 'replace-with-non-interrupting-message-boundary',
    className: 'bpmn-icon-intermediate-event-catch-non-interrupting-message',
    target: {
      type: 'bpmn:BoundaryEvent',
      eventDefinitionType: 'bpmn:MessageEventDefinition',
      cancelActivity: false
    }
  },
  {
    label: '定时边界事件（非中断）',
    actionName: 'replace-with-non-interrupting-timer-boundary',
    className: 'bpmn-icon-intermediate-event-catch-non-interrupting-timer',
    target: {
      type: 'bpmn:BoundaryEvent',
      eventDefinitionType: 'bpmn:TimerEventDefinition',
      cancelActivity: false
    }
  },
  {
    label: '升级边界事件（非中断）',
    actionName: 'replace-with-non-interrupting-escalation-boundary',
    className: 'bpmn-icon-intermediate-event-catch-non-interrupting-escalation',
    target: {
      type: 'bpmn:BoundaryEvent',
      eventDefinitionType: 'bpmn:EscalationEventDefinition',
      cancelActivity: false
    }
  },
  {
    label: '条件边界事件（非中断）',
    actionName: 'replace-with-non-interrupting-conditional-boundary',
    className: 'bpmn-icon-intermediate-event-catch-non-interrupting-condition',
    target: {
      type: 'bpmn:BoundaryEvent',
      eventDefinitionType: 'bpmn:ConditionalEventDefinition',
      cancelActivity: false
    }
  },
  {
    label: '信号边界事件（非中断）',
    actionName: 'replace-with-non-interrupting-signal-boundary',
    className: 'bpmn-icon-intermediate-event-catch-non-interrupting-signal',
    target: {
      type: 'bpmn:BoundaryEvent',
      eventDefinitionType: 'bpmn:SignalEventDefinition',
      cancelActivity: false
    }
  }
];

export var EVENT_SUB_PROCESS_START_EVENT = [
  {
    label: '消息开始事件',
    actionName: 'replace-with-message-start',
    className: 'bpmn-icon-start-event-message',
    target: {
      type: 'bpmn:StartEvent',
      eventDefinitionType: 'bpmn:MessageEventDefinition'
    }
  },
  {
    label: '定时开始事件',
    actionName: 'replace-with-timer-start',
    className: 'bpmn-icon-start-event-timer',
    target: {
      type: 'bpmn:StartEvent',
      eventDefinitionType: 'bpmn:TimerEventDefinition'
    }
  },
  {
    label: '条件开始事件',
    actionName: 'replace-with-conditional-start',
    className: 'bpmn-icon-start-event-condition',
    target: {
      type: 'bpmn:StartEvent',
      eventDefinitionType: 'bpmn:ConditionalEventDefinition'
    }
  },
  {
    label: '信号开始事件',
    actionName: 'replace-with-signal-start',
    className: 'bpmn-icon-start-event-signal',
    target: {
      type: 'bpmn:StartEvent',
      eventDefinitionType: 'bpmn:SignalEventDefinition'
    }
  },
  {
    label: '错误开始事件',
    actionName: 'replace-with-error-start',
    className: 'bpmn-icon-start-event-error',
    target: {
      type: 'bpmn:StartEvent',
      eventDefinitionType: 'bpmn:ErrorEventDefinition'
    }
  },
  {
    label: '升级开始事件',
    actionName: 'replace-with-escalation-start',
    className: 'bpmn-icon-start-event-escalation',
    target: {
      type: 'bpmn:StartEvent',
      eventDefinitionType: 'bpmn:EscalationEventDefinition'
    }
  },
  {
    label: '补偿开始事件',
    actionName: 'replace-with-compensation-start',
    className: 'bpmn-icon-start-event-compensation',
    target: {
      type: 'bpmn:StartEvent',
      eventDefinitionType: 'bpmn:CompensateEventDefinition'
    }
  },
  {
    label: '消息开始事件（非中断）',
    actionName: 'replace-with-non-interrupting-message-start',
    className: 'bpmn-icon-start-event-non-interrupting-message',
    target: {
      type: 'bpmn:StartEvent',
      eventDefinitionType: 'bpmn:MessageEventDefinition',
      isInterrupting: false
    }
  },
  {
    label: '定时开始事件（非中断）',
    actionName: 'replace-with-non-interrupting-timer-start',
    className: 'bpmn-icon-start-event-non-interrupting-timer',
    target: {
      type: 'bpmn:StartEvent',
      eventDefinitionType: 'bpmn:TimerEventDefinition',
      isInterrupting: false
    }
  },
  {
    label: '条件开始事件（非中断）',
    actionName: 'replace-with-non-interrupting-conditional-start',
    className: 'bpmn-icon-start-event-non-interrupting-condition',
    target: {
      type: 'bpmn:StartEvent',
      eventDefinitionType: 'bpmn:ConditionalEventDefinition',
      isInterrupting: false
    }
  },
  {
    label: '信号开始事件（非中断）',
    actionName: 'replace-with-non-interrupting-signal-start',
    className: 'bpmn-icon-start-event-non-interrupting-signal',
    target: {
      type: 'bpmn:StartEvent',
      eventDefinitionType: 'bpmn:SignalEventDefinition',
      isInterrupting: false
    }
  },
  {
    label: '升级开始事件（非中断）',
    actionName: 'replace-with-non-interrupting-escalation-start',
    className: 'bpmn-icon-start-event-non-interrupting-escalation',
    target: {
      type: 'bpmn:StartEvent',
      eventDefinitionType: 'bpmn:EscalationEventDefinition',
      isInterrupting: false
    }
  }
];

export var SEQUENCE_FLOW = [
  {
    label: 'Sequence Flow',
    actionName: 'replace-with-sequence-flow',
    className: 'bpmn-icon-connection'
  },
  {
    label: 'Default Flow',
    actionName: 'replace-with-default-flow',
    className: 'bpmn-icon-default-flow'
  },
  {
    label: 'Conditional Flow',
    actionName: 'replace-with-conditional-flow',
    className: 'bpmn-icon-conditional-flow'
  }
];

export var PARTICIPANT = [
  {
    label: 'Expanded Pool',
    actionName: 'replace-with-expanded-pool',
    className: 'bpmn-icon-participant',
    target: {
      type: 'bpmn:Participant',
      isExpanded: true
    }
  },
  {
    label: 'Collapsed Pool',
    actionName: 'replace-with-collapsed-pool',

    // TODO(@janstuemmel): maybe design new icon
    className: 'bpmn-icon-lane',
    target: {
      type: 'bpmn:Participant',
      isExpanded: false
    }
  }
];
