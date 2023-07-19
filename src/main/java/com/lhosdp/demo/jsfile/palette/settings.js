
let statusList = [
    {value: 'AUDIT', label: '待审核'},
    {value: 'AUDITFAILED', label: '审核未通过'},
    {value: 'NORMAL', label: '正常'},
    {value: 'DOWN', label: '停用'}
    ];

let planStatusList = [
    {value: 'INIT', label: '未发布'},
    {value: 'AUDIT', label: '待审核/审核中'},
    {value: 'AUDITFAILED', label: '审核不通过'},
    {value: 'UP', label: '进行中'},
    {value: 'DOWN', label: '已终止'}
];

module.exports = {
    title: 'flow-admin',

    /**
     * @type {boolean} true | false
     * @description Whether show the settings right-panel
     */
    showSettings: true,

    /**
     * @type {boolean} true | false
     * @description Whether need tagsView
     */
    tagsView: true,

    /**
     * @type {boolean} true | false
     * @description Whether fix the header
     */
    fixedHeader: false,

    /**
     * @type {boolean} true | false
     * @description Whether show the logo in sidebar
     */
    sidebarLogo: false,

    /**
     * @type {string | array} 'production' | ['production', 'development']
     * @description Need show err logs component.
     * The default is only used in the production env
     * If you want to also use it in dev, you can pass ['production', 'development']
     */
    errorLog: 'production',

    //fileSeverUrl: 'http://111.204.125.243:8085/inmanage-web-uat/fastdfs/',
    fileSeverUrl: 'https://dev.lbapp.cn/fastdfs/',

    scenes: [
    ],
    priorities: [
      { value: "HIGH", label: "高" },
      { value: "NORMAL", label: "正常" },
      { value: "LOW", label: "低" },
    ],
    businessTypes: [
      { value: "Financing", label: "购买理财" },
      { value: "Loan", label: "贷款" },
      {
        value: "CreditCard",
        label: "信用卡消费",
      },
      { value: "fund", label: "购买基金" },
    ],
    allbusinessTypes: [
      { value: "Financing", label: "购买理财" },
      { value: "Loan", label: "贷款" },
      {
        value: "CreditCard",
        label: "信用卡消费",
      },
      { value: "Fund", label: "购买基金" },
    ],
    channels: [
      { value: "mobile", label: "手机银行" },
      { value: "net", label: "网上银行" },
      { value: "creditCard", label: "信用卡APP", },
    ],
    userContentTypes: [
      { value: "SimpleRegistration", label: "简易注册用户", unit: "人" },
      { value: "RealName", label: "实名用户", unit: "人" },
      { value: "BindCard", label: "绑卡用户", unit: "人" },
      { value: "LocalBank", label: "本行用户", unit: "人" },
      { value: "ActiveRate", label: "活跃用户率", unit: "%" },
    ],
    businessContentTypes: [
      { value: "tradeCount", label: "交易次数", unit: "次" },
      { value: "tradeAmount", label: "交易总金额", unit: "元" },
      { value: "amount", label: "单笔交易金额", unit: "元" },
      { value: "repurchaseRate", label: "复购率", unit: "%" },
      { value: "repurchaseCountPerUser", label: "人均复购次数", unit: "次" },
    ],
    statusList: statusList,
    planStatusList: planStatusList,
    displayStatus: function(item) {
      let type = statusList.find((x) => {return x.value == item.strategyFlowStatus});
      if (type) {
          return type.label;
      }
      return "-";
    },
    displayStrategyState(state){
        if(state == "INIT"){
            return "未投放";
        }else if(state == "DOING"){
            return "已投放";
        }else if(state == "CANCELDO"){
            return "已取消";
        }else if(state == "DOSUCCESS"){
            return "已投放";
        }
    },
    displayCustomerType(item, customerGroupOptions) {
        // console.log("过滤数据", item)
        // console.log("元数据", customerGroupOptions)
      let type = customerGroupOptions.find((x) => {return x.groupId == item.customerGroup});
      if (type) {
          // let group = type.children.find((x) => {return x.value == item.customerGroup});
          // if (group) {
          //     return type.label + '/' + group.label;
          // }

          return type.name
      }
      return "-";
  },
  displayResources(item, deliverResourcesOptions) {
        if(item.distributionPolicy === undefined){
            return "-";
        }
      let type = deliverResourcesOptions.find((x) => {return x.value == item.distributionPolicy.resourceType});
      if (type) {
          let group = type.children.find((x) => {return x.value == item.distributionPolicy.resourceId});
          if (group) {
              return type.label + '/' + group.label;
          }
      }
      return "-";
  },
  displayAutoFlow(item, autoProcessOptions) {
      let type = autoProcessOptions.find((x) => {return x.businessKey == item.businessKey});
      if (type) {
          return type.name;
      }
      return "-";
  },

  displayChannel(item, channelOptions) {
      if(item.distributionPolicy === undefined){
          return "-";
      }
      let type = channelOptions.find((x) => {return x.value == item.distributionPolicy.channel});
      if (type) {
          let group = type.children.find((x) => {return x.value == item.distributionPolicy.page});
          if (group) {
              let field = group.children.find((x) => {return x.value == item.distributionPolicy.field});
              if (field) {
                  return type.label + '/' + group.label + '/' + field.label;
              }
          }
      }
      return "-";
  },
    divisionMethod(var1, var2){
       // console.log("除法", var1, var2)
        var result = 0;
        if(var2 == 0){
            result = 0;
        }else if(typeof var2 == 'undefined'){
            result =  0;
        }else if(typeof var1 != 'undefined' && typeof var2 != 'undefined'&& var1 != 0 && var2 != 0){
            result = var1/var2;
        }
        return result.toFixed(2);
    },
    displayAuditstate(row){
        var state = row.state
        if("PASS" == state){
            return "审核通过";
        }else if("NOPASS" == state){
            return "审核不通过"
        }
    },
    generateUUID(){
        var d = new Date().getTime();
        if (window.performance && typeof window.performance.now === "function") {
            d += performance.now(); //use high-precision timer if available
        }
        var uuid = 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function (c) {
            var r = (d + Math.random() * 16) % 16 | 0;
            d = Math.floor(d / 16);
            return (c == 'x' ? r : (r & 0x3 | 0x8)).toString(16);
        });
        return uuid;
    },
    checkState(state){
        if(state == "INIT"){
            return "未投放";
        }else if(state == "DOING"){
            return "已投放";
        }else if(state == "CANCELDO"){
            return "已取消";
        }else if(state == "DOSUCCESS"){
            return "已投放";
        }
    },
    displaytime(policy){
        if(policy == null){
            return "";
        }
        var result = "";
        var isR= policy.isRepeated
        if(isR){
            result = policy.startTime + "--" + policy.endTime
            //重复
            if(policy.period == "WEEK"){
                result = result + ",每周" + policy.periodDay
            }else if(policy.period == "MONTH"){
                result = result + ",每月" + policy.periodDay
            }
            return result;
        }else{
            //不重复
            return policy.startTime
        }
    },


}
