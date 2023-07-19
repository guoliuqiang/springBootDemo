package com.lhosdp.demotwo;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LogKafkaMessage {

  /*
  {
    "service":"kafka.servers_IS_UNDEFINED",
    "date":"2023-07-10 15:14:34",
    "level":"INFO",
    "thread": "http-nio-8088-exec-1",
    "logger": "c.b.daw.service.impl.TaskServiceImpl",
    "msg":"休眠三分钟"
    }
   */

    private String service;
    private String date;
    private String level;
    private String thread;
    private String logger;
    private JsonNode msg;


}
