package com.lhosdp.aaa;

public enum AgentType {

    SYSTEM("系统默认智能体"),
    SHOP("商店智能体");

    private String name;

    AgentType(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 新增静态方法：根据传入的字符串匹配对应的枚举值
    public static AgentType fromString(String type) {
        for (AgentType agentType : AgentType.values()) {
            if (agentType.name.equalsIgnoreCase(type)) {
                return agentType;
            }
        }
        throw new IllegalArgumentException("No matching enum found for: " + type);
    }

    public static void main(String[] args) {
        String str = "{\"streamType\":\"SYSTEMOUTCONTENT\",\"responseMessageType\":\"Content\",\"content\":\"\\n\\n作为您的工作改进计划智能助手，我能为您提供以下专业支持：\\n\\n1. **工作总结分析** - 可查询您指定日期或时间段的工作日志，进行客户拜访分析、业务指标完成度评估等结构化梳理\\n\\n2. **工作计划优化** - 根据您的工作进度和业务目标，提供当日工作计划调整建议，包括：\\n   • 客户优先级重排\\n   • 营销节奏优化\\n   • 重点产品推荐策略\\n\\n3. **改进建议生成** - 基于您的工作轨迹，提供包含具体行动步骤的改进方案，例如：\\n   • 重点客户关系维护建议\\n   • 存款/理财产品的精准营销策略\\n   • 客户异议处理话术优化\\n\\n是否需要我为您处理具体的工作日志或调整今日工作计划？请提供相关工作要求。\",\"isThinking\":true,\"chatId\":\"7498611051307663372\",\"messageId\":\"7498611053518077988\",\"stepType\":\"message_completed\",\"msgType\":\"answer\",\"msgContentType\":\"text\"}";

        // 判断字符串中是否包含特定的键值对
        boolean containsStepType = str.contains("\"stepType\":\"message_completed\"");
        boolean containsMsgType = str.contains("\"msgType\":\"answer\"");

        if (containsStepType && containsMsgType) {
            System.out.println("字符串中包含 'stepType':'message_completed' 和 'msgType':'answer'");
        } else {
            System.out.println("字符串中不包含 'stepType':'message_completed' 或 'msgType':'answer'");
        }
    }
}