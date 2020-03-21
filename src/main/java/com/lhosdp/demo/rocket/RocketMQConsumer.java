package com.lhosdp.demo.rocket;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class RocketMQConsumer {
    private static Logger logger = LoggerFactory.getLogger(RocketMQConsumer.class.getName());

    @Autowired
    private Environment environment;


    @PostConstruct
    public void init() {

//        String rocketGroup = environment.getProperty("mq.rocket.group");
//        String rocketServer = environment.getProperty("mq.rocket.server");
//        String rocketTopic= environment.getProperty("mq.rocket.rocketTopic");
//        String tag = environment.getProperty("mq.rocket.tag");
        String rocketGroup = "CID_market";
        String rocketServer = "192.168.65.169:9876";
        String rocketTopic= "TP_market";
        String tag = "tag_send_prize";
//        String accessKey = environment.getProperty("mq.rocket.accessKey");
//        String secretKey = environment.getProperty("mq.rocket.secretKey");
        String secretKey = "secreKey";
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(rocketGroup);

        // Specify name server addresses.
        consumer.setNamesrvAddr(rocketServer);


        // Subscribe one more more topics to consume.
        try {
            consumer.subscribe(rocketTopic, tag);
            MessageProcessor messageProcessor = new MessageProcessor();
            // Register callback to execute on arrival of messages fetched from brokers.
            consumer.registerMessageListener(messageProcessor);
            //Launch the consumer instance.
            consumer.start();
            logger.info("Consumer Started.");
        } catch (MQClientException e) {
            logger.error("failed to start rocketMQ consumer", e);
        }

    }
}
