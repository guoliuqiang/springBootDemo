package com.lhosdp.demo.rocket;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


/**
 * @author guoliuqaing
 */
//@Component
public class RocketMQConsumer {
    private static Logger logger = LoggerFactory.getLogger(RocketMQConsumer.class.getName());

    @Autowired
    private Environment environment;


    @PostConstruct
    public void init() {

        String rocketGroup = "CID_market_guguugugugugu";
        String rocketServer = "192.168.65.169:98762222222";
        String rocketTopic= "TP_market";
        String tag = "tag_send_prize";
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
