package com.ynet.coze.assistant.dtos;

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
        String type = "系统默认智能体";
        AgentType agentType = AgentType.fromString(type);
        System.out.println(agentType.name);
    }
}