package com.lhosdp.demo.mockuser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ConvertUserMock {

    public static void main(String[] args) {
        String data = "[{\"certType\":\"10\",\"userIdList\":\"\",\"channel\":\"MB\",\"ecifId\":\"200000001411\",\"userName\":\"柳华明\",\"userId\":\"200000001411\",\"channelState\":\"00\",\"frozenDate\":\"\",\"certNo\":\"420111197707057313\",\"customerType\":\"40\",\"customerManagerNumber\":\"\",\"signPhone\":\"18112595600\"},{\"certType\":\"10\",\"userIdList\":\"\",\"channel\":\"MB\",\"ecifId\":\"200000001410\",\"userName\":\"卢玥\",\"userId\":\"200000001410\",\"channelState\":\"00\",\"frozenDate\":\"\",\"certNo\":\"230281199308300628\",\"customerType\":\"40\",\"customerManagerNumber\":\"\",\"signPhone\":\"15111112222\"},{\"certType\":\"10\",\"userIdList\":\"\",\"channel\":\"MB\",\"ecifId\":\"200000001404\",\"userName\":\"卢玥\",\"userId\":\"200000001404\",\"channelState\":\"00\",\"frozenDate\":\"\",\"certNo\":\"230281199308300628\",\"customerType\":\"40\",\"customerManagerNumber\":\"\",\"signPhone\":\"17682484250\"},{\"certType\":\"10\",\"userIdList\":\"\",\"channel\":\"MB\",\"ecifId\":\"200000001403\",\"userName\":\"周秀明\",\"userId\":\"200000001403\",\"channelState\":\"00\",\"frozenDate\":\"\",\"certNo\":\"330821199207223635\",\"customerType\":\"40\",\"customerManagerNumber\":\"\",\"signPhone\":\"15100003333\"},{\"certType\":\"10\",\"userIdList\":\"\",\"channel\":\"MB\",\"ecifId\":\"200000001402\",\"userName\":\"周秀明\",\"userId\":\"200000001402\",\"channelState\":\"00\",\"frozenDate\":\"\",\"certNo\":\"330821199207223635\",\"customerType\":\"40\",\"customerManagerNumber\":\"\",\"signPhone\":\"15100002222\"},{\"certType\":\"10\",\"userIdList\":\"\",\"channel\":\"MB\",\"ecifId\":\"200000001401\",\"userName\":\"周秀明\",\"userId\":\"200000001401\",\"channelState\":\"00\",\"frozenDate\":\"\",\"certNo\":\"330821199207223635\",\"customerType\":\"40\",\"customerManagerNumber\":\"\",\"signPhone\":\"15100001111\"},{\"certType\":\"10\",\"userIdList\":\"\",\"channel\":\"MB\",\"ecifId\":\"100000001551\",\"userName\":\"黄傲\",\"userId\":\"100000001551\",\"channelState\":\"00\",\"frozenDate\":\"\",\"certNo\":\"430624198904036517\",\"customerType\":\"40\",\"customerManagerNumber\":\"\",\"signPhone\":\"18620071783\"},{\"certType\":\"10\",\"userIdList\":\"\",\"channel\":\"MB\",\"ecifId\":\"200000001372\",\"userName\":\"钟华\",\"userId\":\"200000001372\",\"channelState\":\"00\",\"frozenDate\":\"\",\"certNo\":\"150430199605200923\",\"customerType\":\"30\",\"customerManagerNumber\":\"\",\"signPhone\":\"18447070469\"},{\"certType\":\"10\",\"userIdList\":\"\",\"channel\":\"MB\",\"ecifId\":\"200000001364\",\"userName\":\"潮升\",\"userId\":\"200000001364\",\"channelState\":\"00\",\"frozenDate\":\"\",\"certNo\":\"340822199004011470\",\"customerType\":\"40\",\"customerManagerNumber\":\"\",\"signPhone\":\"18605561372\"},{\"certType\":\"10\",\"userIdList\":\"\",\"channel\":\"MB\",\"ecifId\":\"200000001360\",\"userName\":\"王赛\",\"userId\":\"200000001360\",\"channelState\":\"00\",\"frozenDate\":\"\",\"certNo\":\"410725199109071252\",\"customerType\":\"40\",\"customerManagerNumber\":\"\",\"signPhone\":\"17600223080\"},{\"certType\":\"10\",\"userIdList\":\"\",\"channel\":\"MB\",\"ecifId\":\"200000001346\",\"userName\":\"李尧\",\"userId\":\"200000001346\",\"channelState\":\"00\",\"frozenDate\":\"\",\"certNo\":\"340521199209271812\",\"customerType\":\"40\",\"customerManagerNumber\":\"\",\"signPhone\":\"15551200113\"},{\"certType\":\"10\",\"userIdList\":\"\",\"channel\":\"MB\",\"ecifId\":\"200000001345\",\"userName\":\"李尧\",\"userId\":\"200000001345\",\"channelState\":\"00\",\"frozenDate\":\"\",\"certNo\":\"340521199209271812\",\"customerType\":\"40\",\"customerManagerNumber\":\"\",\"signPhone\":\"15551200112\"},{\"certType\":\"10\",\"userIdList\":\"\",\"channel\":\"MB\",\"ecifId\":\"200000001344\",\"userName\":\"李尧\",\"userId\":\"200000001344\",\"channelState\":\"00\",\"frozenDate\":\"\",\"certNo\":\"340521199209271812\",\"customerType\":\"40\",\"customerManagerNumber\":\"\",\"signPhone\":\"15551200111\"},{\"certType\":\"10\",\"userIdList\":\"\",\"channel\":\"MB\",\"ecifId\":\"200000001340\",\"userName\":\"陈方月\",\"userId\":\"200000001340\",\"channelState\":\"00\",\"frozenDate\":\"\",\"certNo\":\"230882199208012927\",\"customerType\":\"40\",\"customerManagerNumber\":\"\",\"signPhone\":\"17644445555\"},{\"certType\":\"10\",\"userIdList\":\"\",\"channel\":\"MB\",\"ecifId\":\"200000001337\",\"userName\":\"李尧\",\"userId\":\"200000001337\",\"channelState\":\"00\",\"frozenDate\":\"\",\"certNo\":\"340521199209271812\",\"customerType\":\"30\",\"customerManagerNumber\":\"\",\"signPhone\":\"15551200003\"},{\"certType\":\"10\",\"userIdList\":\"\",\"channel\":\"MB\",\"ecifId\":\"200000001336\",\"userName\":\"李尧\",\"userId\":\"200000001336\",\"channelState\":\"00\",\"frozenDate\":\"\",\"certNo\":\"340521199209271812\",\"customerType\":\"30\",\"customerManagerNumber\":\"\",\"signPhone\":\"15551200002\"},{\"certType\":\"10\",\"userIdList\":\"\",\"channel\":\"MB\",\"ecifId\":\"200000001335\",\"userName\":\"李尧\",\"userId\":\"200000001335\",\"channelState\":\"00\",\"frozenDate\":\"\",\"certNo\":\"340521199209271812\",\"customerType\":\"30\",\"customerManagerNumber\":\"\",\"signPhone\":\"15551200001\"},{\"certType\":\"10\",\"userIdList\":\"\",\"channel\":\"MB\",\"ecifId\":\"200000001334\",\"userName\":\"王贤坤\",\"userId\":\"200000001334\",\"channelState\":\"00\",\"frozenDate\":\"\",\"certNo\":\"371121199411042516\",\"customerType\":\"30\",\"customerManagerNumber\":\"\",\"signPhone\":\"13165080767\"},{\"certType\":\"10\",\"userIdList\":\"\",\"channel\":\"MB\",\"ecifId\":\"200000001333\",\"userName\":\"曲南南\",\"userId\":\"200000001333\",\"channelState\":\"00\",\"frozenDate\":\"\",\"certNo\":\"231182198911192323\",\"customerType\":\"30\",\"customerManagerNumber\":\"\",\"signPhone\":\"18101062251\"},{\"certType\":\"10\",\"userIdList\":\"\",\"channel\":\"MB\",\"ecifId\":\"200000001330\",\"userName\":\"孙振\",\"userId\":\"200000001330\",\"channelState\":\"00\",\"frozenDate\":\"\",\"certNo\":\"370281199307076012\",\"customerType\":\"30\",\"customerManagerNumber\":\"\",\"signPhone\":\"17600566707\"},{\"certType\":\"10\",\"userIdList\":\"\",\"channel\":\"MB\",\"ecifId\":\"200000001326\",\"userName\":\"赖双波\",\"userId\":\"200000001326\",\"channelState\":\"00\",\"frozenDate\":\"\",\"certNo\":\"330326198910315435\",\"customerType\":\"40\",\"customerManagerNumber\":\"\",\"signPhone\":\"13868569119\"},{\"certType\":\"10\",\"userIdList\":\"\",\"channel\":\"MB\",\"ecifId\":\"200000001321\",\"userName\":\"朱智颖\",\"userId\":\"200000001321\",\"channelState\":\"00\",\"frozenDate\":\"\",\"certNo\":\"370684199207170010\",\"customerType\":\"40\",\"customerManagerNumber\":\"\",\"signPhone\":\"17615835717\"},{\"certType\":\"10\",\"userIdList\":\"\",\"channel\":\"MB\",\"ecifId\":\"200000001306\",\"userName\":\"李尧\",\"userId\":\"200000001306\",\"channelState\":\"00\",\"frozenDate\":\"\",\"certNo\":\"340521199209271812\",\"customerType\":\"40\",\"customerManagerNumber\":\"\",\"signPhone\":\"18555131016\"},{\"certType\":\"10\",\"userIdList\":\"\",\"channel\":\"MB\",\"ecifId\":\"200000001304\",\"userName\":\"孙元刚\",\"userId\":\"200000001304\",\"channelState\":\"00\",\"frozenDate\":\"\",\"certNo\":\"370281199001277639\",\"customerType\":\"40\",\"customerManagerNumber\":\"\",\"signPhone\":\"15264299715\"},{\"certType\":\"10\",\"userIdList\":\"\",\"channel\":\"MB\",\"ecifId\":\"200000001301\",\"userName\":\"孙左一\",\"userId\":\"200000001301\",\"channelState\":\"00\",\"frozenDate\":\"\",\"certNo\":\"230103199401180611\",\"customerType\":\"40\",\"customerManagerNumber\":\"\",\"signPhone\":\"18699990001\"},{\"certType\":\"10\",\"userIdList\":\"\",\"channel\":\"MB\",\"ecifId\":\"200000001299\",\"userName\":\"黄俊超\",\"userId\":\"200000001299\",\"channelState\":\"00\",\"frozenDate\":\"\",\"certNo\":\"370282199401271312\",\"customerType\":\"30\",\"customerManagerNumber\":\"\",\"signPhone\":\"17667568192\"},{\"certType\":\"10\",\"userIdList\":\"\",\"channel\":\"MB\",\"ecifId\":\"200000001281\",\"userName\":\"周秀明\",\"userId\":\"200000001281\",\"channelState\":\"00\",\"frozenDate\":\"\",\"certNo\":\"330821199207223635\",\"customerType\":\"40\",\"customerManagerNumber\":\"\",\"signPhone\":\"15512341234\"},{\"certType\":\"10\",\"userIdList\":\"\",\"channel\":\"MB\",\"ecifId\":\"200000001269\",\"userName\":\"卢玥\",\"userId\":\"200000001269\",\"channelState\":\"00\",\"frozenDate\":\"\",\"certNo\":\"230281199308300628\",\"customerType\":\"30\",\"customerManagerNumber\":\"\",\"signPhone\":\"15111111166\"},{\"certType\":\"10\",\"userIdList\":\"\",\"channel\":\"MB\",\"ecifId\":\"200000001261\",\"userName\":\"蔡盛威\",\"userId\":\"200000001261\",\"channelState\":\"00\",\"frozenDate\":\"\",\"certNo\":\"330327199307200853\",\"customerType\":\"30\",\"customerManagerNumber\":\"\",\"signPhone\":\"15444444446\"},{\"certType\":\"10\",\"userIdList\":\"\",\"channel\":\"MB\",\"ecifId\":\"200000001260\",\"userName\":\"卢玥\",\"userId\":\"200000001260\",\"channelState\":\"00\",\"frozenDate\":\"\",\"certNo\":\"230281199308300628\",\"customerType\":\"30\",\"customerManagerNumber\":\"\",\"signPhone\":\"15111111198\"},{\"certType\":\"10\",\"userIdList\":\"\",\"channel\":\"MB\",\"ecifId\":\"200000001241\",\"userName\":\"李少柏\",\"userId\":\"200000001241\",\"channelState\":\"00\",\"frozenDate\":\"\",\"certNo\":\"431028198608042414\",\"customerType\":\"40\",\"customerManagerNumber\":\"\",\"signPhone\":\"13907357650\"},{\"certType\":\"10\",\"userIdList\":\"\",\"channel\":\"MB\",\"ecifId\":\"200000001240\",\"userName\":\"周秀明\",\"userId\":\"200000001240\",\"channelState\":\"00\",\"frozenDate\":\"\",\"certNo\":\"330821199207223635\",\"customerType\":\"40\",\"customerManagerNumber\":\"\",\"signPhone\":\"19999999999\"},{\"certType\":\"10\",\"userIdList\":\"\",\"channel\":\"MB\",\"ecifId\":\"200000001162\",\"userName\":\"黄颖涛\",\"userId\":\"200000001162\",\"channelState\":\"00\",\"frozenDate\":\"\",\"certNo\":\"440281199703040431\",\"customerType\":\"40\",\"customerManagerNumber\":\"\",\"signPhone\":\"15521149153\"},{\"certType\":\"10\",\"userIdList\":\"\",\"channel\":\"MB\",\"ecifId\":\"200000001151\",\"userName\":\"夏蔚\",\"userId\":\"200000001151\",\"channelState\":\"00\",\"frozenDate\":\"\",\"certNo\":\"510215197308172325\",\"customerType\":\"40\",\"customerManagerNumber\":\"\",\"signPhone\":\"18618288540\"},{\"certType\":\"10\",\"userIdList\":\"\",\"channel\":\"MB\",\"ecifId\":\"200000001148\",\"userName\":\"韦颖琪\",\"userId\":\"200000001148\",\"channelState\":\"00\",\"frozenDate\":\"\",\"certNo\":\"452702198703254369\",\"customerType\":\"40\",\"customerManagerNumber\":\"\",\"signPhone\":\"18925011301\"},{\"certType\":\"10\",\"userIdList\":\"\",\"channel\":\"MB\",\"ecifId\":\"200000001143\",\"userName\":\"沈瑶\",\"userId\":\"200000001143\",\"channelState\":\"00\",\"frozenDate\":\"\",\"certNo\":\"42900619850707123X\",\"customerType\":\"40\",\"customerManagerNumber\":\"\",\"signPhone\":\"18664270202\"},{\"certType\":\"10\",\"userIdList\":\"\",\"channel\":\"MB\",\"ecifId\":\"200000001128\",\"userName\":\"齐睿\",\"userId\":\"200000001128\",\"channelState\":\"00\",\"frozenDate\":\"\",\"certNo\":\"142723198309164110\",\"customerType\":\"30\",\"customerManagerNumber\":\"\",\"signPhone\":\"13609068269\"},{\"certType\":\"10\",\"userIdList\":\"\",\"channel\":\"MB\",\"ecifId\":\"200000001067\",\"userName\":\"沈煜\",\"userId\":\"200000001067\",\"channelState\":\"00\",\"frozenDate\":\"\",\"certNo\":\"142631199308100712\",\"customerType\":\"40\",\"customerManagerNumber\":\"\",\"signPhone\":\"17610893656\"},{\"certType\":\"10\",\"userIdList\":\"\",\"channel\":\"MB\",\"ecifId\":\"200000001066\",\"userName\":\"卢玥\",\"userId\":\"200000001066\",\"channelState\":\"00\",\"frozenDate\":\"\",\"certNo\":\"230281199308300628\",\"customerType\":\"40\",\"customerManagerNumber\":\"\",\"signPhone\":\"13869081230\"},{\"certType\":\"10\",\"userIdList\":\"\",\"channel\":\"MB\",\"ecifId\":\"200000001062\",\"userName\":\"李尧\",\"userId\":\"200000001062\",\"channelState\":\"00\",\"frozenDate\":\"\",\"certNo\":\"340521199209271812\",\"customerType\":\"30\",\"customerManagerNumber\":\"\",\"signPhone\":\"18611111122\"},{\"certType\":\"10\",\"userIdList\":\"\",\"channel\":\"MB\",\"ecifId\":\"200000001060\",\"userName\":\"黄文杰\",\"userId\":\"200000001060\",\"channelState\":\"00\",\"frozenDate\":\"\",\"certNo\":\"360402198611133850\",\"customerType\":\"40\",\"customerManagerNumber\":\"\",\"signPhone\":\"13246822582\"}]";
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonParser parser = objectMapper.getFactory().createParser(data);
            Object o = objectMapper.readValue(parser, objectMapper.getTypeFactory().constructCollectionType(List.class, User.class));
            ArrayList<User> list = (ArrayList<User>)o;
            HashMap<String, String> userandIpnone = new HashMap<>();
            for (User s : list) {
                userandIpnone.put(s.getSignPhone(), s.getUserId());
                System.out.println("'"+s.getSignPhone()+"'->'"+s.getUserId()+"'," + s.getUserName());
            }
            //System.out.println(userandIpnone.toString());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("failed");
        }



    }

    private  <T> List<T> parseJsonList(String json, Class<T> type){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonParser parser = objectMapper.getFactory().createParser(json);
            return objectMapper.readValue(parser, objectMapper.getTypeFactory().constructCollectionType(List.class, type));
        } catch (Exception e) {
            System.out.println("failed");
        }
        return null;
    }
}
