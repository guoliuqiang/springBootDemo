package com.lhosdp.demotwo;

import cn.hutool.core.net.URLDecoder;
import cn.hutool.core.util.URLUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.lhosdp.demo.testRight.SmartLifeUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.util.SocketUtils;
import org.springframework.util.StringUtils;

import java.awt.event.KeyAdapter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@ToString
public class StringDto implements Serializable {

    /**
     * 通知人名单
     */



    public static void main(String[] args) {

       // String kafkaMessage = "{ \"service\":\"kafka.servers_IS_UNDEFINED\", \"date\":\"2023-07-14 14:43:29\", \"level\":\"INFO\", \"thread\": \"http-nio-8089-exec-1\", \"logger\": \"c.b.d.s.impl.FlinkJobServiceImpl\", \"msg\":\"\"{\\\"jobs\\\":[{\\\"jid\\\":\\\"76f26f3b558dbc5d8f9ca5006e2b066c\\\",\\\"name\\\":\\\"dev-market-number-activities-issues\\\",\\\"state\\\":\\\"RUNNING\\\",\\\"start-time\\\":1683278979138,\\\"end-time\\\":-1,\\\"duration\\\":6038001278,\\\"last-modification\\\":1685091971809,\\\"tasks\\\":{\\\"total\\\":3,\\\"created\\\":0,\\\"scheduled\\\":0,\\\"deploying\\\":0,\\\"running\\\":3,\\\"finished\\\":0,\\\"canceling\\\":0,\\\"canceled\\\":0,\\\"failed\\\":0,\\\"reconciling\\\":0,\\\"initializing\\\":0}},{\\\"jid\\\":\\\"d7024f77957e5d5851263acd38760995\\\",\\\"name\\\":\\\"dev-belink-data-message-cleaning\\\",\\\"state\\\":\\\"RUNNING\\\",\\\"start-time\\\":1688710754649,\\\"end-time\\\":-1,\\\"duration\\\":606225768,\\\"last-modification\\\":1688710759255,\\\"tasks\\\":{\\\"total\\\":1,\\\"created\\\":0,\\\"scheduled\\\":0,\\\"deploying\\\":0,\\\"running\\\":1,\\\"finished\\\":0,\\\"canceling\\\":0,\\\"canceled\\\":0,\\\"failed\\\":0,\\\"reconciling\\\":0,\\\"initializing\\\":0}},{\\\"jid\\\":\\\"e71e7742cab808a5c472a6b1c2a621f1\\\",\\\"name\\\":\\\"dev-belink-data-business-cleaning\\\",\\\"state\\\":\\\"RUNNING\\\",\\\"start-time\\\":1688710737863,\\\"end-time\\\":-1,\\\"duration\\\":606242553,\\\"last-modification\\\":1688710742112,\\\"tasks\\\":{\\\"total\\\":6,\\\"created\\\":0,\\\"scheduled\\\":0,\\\"deploying\\\":0,\\\"running\\\":6,\\\"finished\\\":0,\\\"canceling\\\":0,\\\"canceled\\\":0,\\\"failed\\\":0,\\\"reconciling\\\":0,\\\"initializing\\\":0}},{\\\"jid\\\":\\\"a509d5a036cfaf66fa90649891cd6402\\\",\\\"name\\\":\\\"uat-market-number-activities-involved\\\",\\\"state\\\":\\\"RUNNING\\\",\\\"start-time\\\":1686213280116,\\\"end-time\\\":-1,\\\"duration\\\":3103700300,\\\"last-modification\\\":1686213282465,\\\"tasks\\\":{\\\"total\\\":3,\\\"created\\\":0,\\\"scheduled\\\":0,\\\"deploying\\\":0,\\\"running\\\":3,\\\"finished\\\":0,\\\"canceling\\\":0,\\\"canceled\\\":0,\\\"failed\\\":0,\\\"reconciling\\\":0,\\\"initializing\\\":0}},{\\\"jid\\\":\\\"740cb4842b2c14567948ca7f9375b5b0\\\",\\\"name\\\":\\\"uat-market-number-activities-issues\\\",\\\"state\\\":\\\"RUNNING\\\",\\\"start-time\\\":1686213304565,\\\"end-time\\\":-1,\\\"duration\\\":3103675851,\\\"last-modification\\\":1686213306735,\\\"tasks\\\":{\\\"total\\\":3,\\\"created\\\":0,\\\"scheduled\\\":0,\\\"deploying\\\":0,\\\"running\\\":3,\\\"finished\\\":0,\\\"canceling\\\":0,\\\"canceled\\\":0,\\\"failed\\\":0,\\\"reconciling\\\":0,\\\"initializing\\\":0}},{\\\"jid\\\":\\\"198f32a9c70e4ecdc0a00fa5b35cce89\\\",\\\"name\\\":\\\"dev-belink-strategy-todaydata-summary\\\",\\\"state\\\":\\\"RUNNING\\\",\\\"start-time\\\":1688710784833,\\\"end-time\\\":-1,\\\"duration\\\":606195583,\\\"last-modification\\\":1688710788458,\\\"tasks\\\":{\\\"total\\\":4,\\\"created\\\":0,\\\"scheduled\\\":0,\\\"deploying\\\":0,\\\"running\\\":4,\\\"finished\\\":0,\\\"canceling\\\":0,\\\"canceled\\\":0,\\\"failed\\\":0,\\\"reconciling\\\":0,\\\"initializing\\\":0}},{\\\"jid\\\":\\\"f0c59740c4271034dd6d6ff9250a0685\\\",\\\"name\\\":\\\"dev-belink-data-strategy-cleaning\\\",\\\"state\\\":\\\"RUNNING\\\",\\\"start-time\\\":1688710759703,\\\"end-time\\\":-1,\\\"duration\\\":606220713,\\\"last-modification\\\":1688710764446,\\\"tasks\\\":{\\\"total\\\":1,\\\"created\\\":0,\\\"scheduled\\\":0,\\\"deploying\\\":0,\\\"running\\\":1,\\\"finished\\\":0,\\\"canceling\\\":0,\\\"canceled\\\":0,\\\"failed\\\":0,\\\"reconciling\\\":0,\\\"initializing\\\":0}},{\\\"jid\\\":\\\"228b141fafc01b0bb280f2db5bbce3bc\\\",\\\"name\\\":\\\"dev-belink-data-cleaning\\\",\\\"state\\\":\\\"RUNNING\\\",\\\"start-time\\\":1688710743084,\\\"end-time\\\":-1,\\\"duration\\\":606237332,\\\"last-modification\\\":1688710747080,\\\"tasks\\\":{\\\"total\\\":1,\\\"created\\\":0,\\\"scheduled\\\":0,\\\"deploying\\\":0,\\\"running\\\":1,\\\"finished\\\":0,\\\"canceling\\\":0,\\\"canceled\\\":0,\\\"failed\\\":0,\\\"reconciling\\\":0,\\\"initializing\\\":0}},{\\\"jid\\\":\\\"e96fe7a7683a01233ee29ed9931e2027\\\",\\\"name\\\":\\\"dev-market-number-activities-involved\\\",\\\"state\\\":\\\"RUNNING\\\",\\\"start-time\\\":1683278948587,\\\"end-time\\\":-1,\\\"duration\\\":6038031830,\\\"last-modification\\\":1685091968012,\\\"tasks\\\":{\\\"total\\\":3,\\\"created\\\":0,\\\"scheduled\\\":0,\\\"deploying\\\":0,\\\"running\\\":3,\\\"finished\\\":0,\\\"canceling\\\":0,\\\"canceled\\\":0,\\\"failed\\\":0,\\\"reconciling\\\":0,\\\"initializing\\\":0}},{\\\"jid\\\":\\\"35592a760115227499994a321cfc7de2\\\",\\\"name\\\":\\\"dev-belink-data-marketing-cleaning\\\",\\\"state\\\":\\\"RUNNING\\\",\\\"start-time\\\":1688710748235,\\\"end-time\\\":-1,\\\"duration\\\":606232182,\\\"last-modification\\\":1688710752329,\\\"tasks\\\":{\\\"total\\\":5,\\\"created\\\":0,\\\"scheduled\\\":0,\\\"deploying\\\":0,\\\"running\\\":5,\\\"finished\\\":0,\\\"canceling\\\":0,\\\"canceled\\\":0,\\\"failed\\\":0,\\\"reconciling\\\":0,\\\"initializing\\\":0}},{\\\"jid\\\":\\\"f0c24279a9ce31bd7c91080a9ca3d725\\\",\\\"name\\\":\\\"dev-belink-strategy-summary\\\",\\\"state\\\":\\\"RUNNING\\\",\\\"start-time\\\":1688710789903,\\\"end-time\\\":-1,\\\"duration\\\":606190513,\\\"last-modification\\\":1688710793814,\\\"tasks\\\":{\\\"total\\\":2,\\\"created\\\":0,\\\"scheduled\\\":0,\\\"deploying\\\":0,\\\"running\\\":2,\\\"finished\\\":0,\\\"canceling\\\":0,\\\"canceled\\\":0,\\\"failed\\\":0,\\\"reconciling\\\":0,\\\"initializing\\\":0}},{\\\"jid\\\":\\\"6279f4817a42e0ca42bc201e90ae6a6e\\\",\\\"name\\\":\\\"dev-belink-marketing-plan-stream-summary\\\",\\\"state\\\":\\\"RUNNING\\\",\\\"start-time\\\":1688710773295,\\\"end-time\\\":-1,\\\"duration\\\":606207121,\\\"last-modification\\\":1688710777195,\\\"tasks\\\":{\\\"total\\\":4,\\\"created\\\":0,\\\"scheduled\\\":0,\\\"deploying\\\":0,\\\"running\\\":4,\\\"finished\\\":0,\\\"canceling\\\":0,\\\"canceled\\\":0,\\\"failed\\\":0,\\\"reconciling\\\":0,\\\"initializing\\\":0}},{\\\"jid\\\":\\\"506c50aa67c5d9176b80e30f827c41d3\\\",\\\"name\\\":\\\"dev-belink-marketing-plan-summary\\\",\\\"state\\\":\\\"RUNNING\\\",\\\"start-time\\\":1688710764938,\\\"end-time\\\":-1,\\\"duration\\\":606215478,\\\"last-modification\\\":1688710769587,\\\"tasks\\\":{\\\"total\\\":2,\\\"created\\\":0,\\\"scheduled\\\":0,\\\"deploying\\\":0,\\\"running\\\":2,\\\"finished\\\":0,\\\"canceling\\\":0,\\\"canceled\\\":0,\\\"failed\\\":0,\\\"reconciling\\\":0,\\\"initializing\\\":0}}]}\"\" }";

     //   String message = "{ \"service\":\"kafka.servers_IS_UNDEFINED\", \"date\":\"2023-07-14 14:48:00\", \"level\":\"INFO\", \"thread\": \"http-nio-8089-exec-1\", \"logger\": \"c.b.d.s.impl.FlinkJobServiceImpl\", \"msg\":\"{\"jobs\":[{\"jid\":\"230ae66f5dd30d627572476faeef6514\",\"name\":\"insert-into_myhive.bpd_db_uat.t2_act_event_all_a_8_new\",\"state\":\"RUNNING\",\"start-time\":1683196184984,\"end-time\":-1,\"duration\":6121095694,\"last-modification\":1683277100929,\"tasks\":{\"total\":3,\"created\":0,\"scheduled\":0,\"deploying\":0,\"running\":3,\"finished\":0,\"canceling\":0,\"canceled\":0,\"failed\":0,\"reconciling\":0,\"initializing\":0}},{\"jid\":\"046a0e561f54363684cd50898f79ad4b\",\"name\":\"CHANNELDATATRACKINGETLJOB-dev\",\"state\":\"RUNNING\",\"start-time\":1683277904983,\"end-time\":-1,\"duration\":6039375695,\"last-modification\":1683277905140,\"tasks\":{\"total\":1,\"created\":0,\"scheduled\":0,\"deploying\":0,\"running\":1,\"finished\":0,\"canceling\":0,\"canceled\":0,\"failed\":0,\"reconciling\":0,\"initializing\":0}},{\"jid\":\"cc3f7e2c12020efc5bb8e6e2910eb44b\",\"name\":\"insert-into_myhive.bpd_db.t2_act_event_all_a_8_new\",\"state\":\"RUNNING\",\"start-time\":1683280634343,\"end-time\":-1,\"duration\":6036646335,\"last-modification\":1683280634633,\"tasks\":{\"total\":3,\"created\":0,\"scheduled\":0,\"deploying\":0,\"running\":3,\"finished\":0,\"canceling\":0,\"canceled\":0,\"failed\":0,\"reconciling\":0,\"initializing\":0}},{\"jid\":\"6a4026be136cce590d93203a20fffaa8\",\"name\":\"insert-into_applettesthive.bpd_db_uat.t2_buried_point_new\",\"state\":\"RUNNING\",\"start-time\":1683195944195,\"end-time\":-1,\"duration\":6121336483,\"last-modification\":1683277100950,\"tasks\":{\"total\":2,\"created\":0,\"scheduled\":0,\"deploying\":0,\"running\":2,\"finished\":0,\"canceling\":0,\"canceled\":0,\"failed\":0,\"reconciling\":0,\"initializing\":0}},{\"jid\":\"d5fbce1bbb93561f31ff7d17deb7b479\",\"name\":\"FMSDATATRACKINGETLJOB-dev\",\"state\":\"RUNNING\",\"start-time\":1683280144096,\"end-time\":-1,\"duration\":6037136582,\"last-modification\":1683280144494,\"tasks\":{\"total\":1,\"created\":0,\"scheduled\":0,\"deploying\":0,\"running\":1,\"finished\":0,\"canceling\":0,\"canceled\":0,\"failed\":0,\"reconciling\":0,\"initializing\":0}},{\"jid\":\"bb49bc75d8ec98cf62e04000336a7298\",\"name\":\"CHANNELDATATRACKINGETLJOB-uat\",\"state\":\"RUNNING\",\"start-time\":1683196119198,\"end-time\":-1,\"duration\":6121161481,\"last-modification\":1683275894844,\"tasks\":{\"total\":1,\"created\":0,\"scheduled\":0,\"deploying\":0,\"running\":1,\"finished\":0,\"canceling\":0,\"canceled\":0,\"failed\":0,\"reconciling\":0,\"initializing\":0}},{\"jid\":\"17e1ff9c795f27aecf888d0efcfb59b9\",\"name\":\"APPLETDATATRACKINGETLJOB2-dev\",\"state\":\"RUNNING\",\"start-time\":1683276801850,\"end-time\":-1,\"duration\":6040478829,\"last-modification\":1683277016294,\"tasks\":{\"total\":1,\"created\":0,\"scheduled\":0,\"deploying\":0,\"running\":1,\"finished\":0,\"canceling\":0,\"canceled\":0,\"failed\":0,\"reconciling\":0,\"initializing\":0}},{\"jid\":\"0f38ed4f3f67470de88c1536ccc7b65f\",\"name\":\"AppletDataRealtimeDwd job\",\"state\":\"RUNNING\",\"start-time\":1683280499464,\"end-time\":-1,\"duration\":6036781216,\"last-modification\":1689146889391,\"tasks\":{\"total\":4,\"created\":0,\"scheduled\":0,\"deploying\":0,\"running\":4,\"finished\":0,\"canceling\":0,\"canceled\":0,\"failed\":0,\"reconciling\":0,\"initializing\":0}},{\"jid\":\"3b8251340a3ac54d39211d7058ecf972\",\"name\":\"APPLETDATATRACKINGETLJOB2-uat\",\"state\":\"RUNNING\",\"start-time\":1683274602995,\"end-time\":-1,\"duration\":6042677683,\"last-modification\":1683275946427,\"tasks\":{\"total\":1,\"created\":0,\"scheduled\":0,\"deploying\":0,\"running\":1,\"finished\":0,\"canceling\":0,\"canceled\":0,\"failed\":0,\"reconciling\":0,\"initializing\":0}},{\"jid\":\"5105051188bb4aa4343a4e045ca8c022\",\"name\":\"insert-into_applettesthive.bpd_db.t2_buried_point_new\",\"state\":\"RUNNING\",\"start-time\":1683195907772,\"end-time\":-1,\"duration\":6121372907,\"last-modification\":1689317279916,\"tasks\":{\"total\":2,\"created\":0,\"scheduled\":0,\"deploying\":0,\"running\":2,\"finished\":0,\"canceling\":0,\"canceled\":0,\"failed\":0,\"reconciling\":0,\"initializing\":0}}]}\" }";
//        System.out.println(kafkaMessage);
//        System.out.println("==========");
//        System.out.println(kafkaMessage.replaceAll("\n", "").replaceAll("\t\t\t", "").replaceAll("\t\t", ""));
//        String nohuanhang = kafkaMessage.replaceAll("\n", "");

//
//        LogKafkaMessage logKafkaMessage = SmartLifeUtil.parseJson(message, LogKafkaMessage.class);
//        System.out.println(logKafkaMessage.toString());

       // JSONObject jsonObject = JSONUtil.parseObj(kafkaMessage, LogKafkaMessage.class);

//        String param = "[{\"key\":\"date2\",\"value\":\"20220929\"},{\"key\":\"phrase3\",\"value\":\"转账\"}]";
//        JSONArray array = JSONUtil.parseArray(param);
//        int size = array.size();
//        for (int i = 0; i < size; i++) {
//            Object o = array.get(i);
//            JSONObject jsonObject = JSONUtil.parseObj(o);
//            String key = jsonObject.getStr("key");
//            System.out.println(key + "=" + jsonObject.getStr("value"));
//        }

        String paramjson = "%5B%7B%22key%22%3A%22date2%22%2C%22value%22%3A%2220220929%22%7D%2C%7B%22key%22%3A%22phrase3%22%2C%22value%22%3A%22%E8%BD%AC%E8%B4%A6%22%7D%5D";

        String decode = URLUtil.decode(paramjson);
        System.out.println(decode);
    }
}
