package com.lhosdp.demo.kafkademo;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.DescribeTopicsResult;
import org.apache.kafka.clients.admin.TopicDescription;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.KafkaFuture;
import org.apache.kafka.common.Node;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.TopicPartitionInfo;

import java.util.*;

/**
 * 本例子试着读取当前topic每个分区内最新的30条消息(如果topic额分区内有没有30条，就获取实际消息)
 * className: ReceiveLatestMessageMain
 *
 * 读取日志打印中的这一行数据  Leader of partitionId: 0  is 101.251.195.186:9092 (id: 0 rack: null).  expectedOffSet:1，  beginOffset:0, lastOffset:131
 * 关注beginOffset  和 lastOffset的值  last-begin的值设置到COUNT上，只能大，不能小
 *
 * @author EricYang
 * @version 2019/01/10 11:30
 */
public class LookKafkaHistroyMessage {
    //获取的数量
    private static final int COUNT = 50;
    public static void main(String... args) throws Exception {
        Properties props = new Properties();

        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.65.104:9092");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        props.put(ConsumerConfig.GROUP_ID_CONFIG, "flink-strategy-summary" + BelinkUtil.getHostName());
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 20);
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "30000");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
/*
200000001182
200000001311
200000001705
200000001643
 */

        System.out.println("create KafkaConsumer");
        final KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        AdminClient adminClient = AdminClient.create(props);
        //设置topic
        String topic = "new-etl-gateway_8";
        //String topic = "BELINK_BUSINESS";
        //String topic = "BELINK_SOURCE_EVENT";
        //String topic = "BELINK_TODAYDATA";
        adminClient.describeTopics(Arrays.asList(topic));
        try {
            DescribeTopicsResult topicResult = adminClient.describeTopics(Arrays.asList(topic));
            Map<String, KafkaFuture<TopicDescription>> descMap = topicResult.values();
            Iterator<Map.Entry<String, KafkaFuture<TopicDescription>>> itr = descMap.entrySet().iterator();
            while(itr.hasNext()) {
                Map.Entry<String, KafkaFuture<TopicDescription>> entry = itr.next();
                System.out.println("key: " + entry.getKey());
                List<TopicPartitionInfo> topicPartitionInfoList = entry.getValue().get().partitions();
                topicPartitionInfoList.forEach((e) -> {
                    int partitionId = e.partition();
                    Node node  = e.leader();
                    TopicPartition topicPartition = new TopicPartition(topic, partitionId);
                    Map<TopicPartition, Long> mapBeginning = consumer.beginningOffsets(Arrays.asList(topicPartition));
                    Iterator<Map.Entry<TopicPartition, Long>> itr2 = mapBeginning.entrySet().iterator();
                    long beginOffset = 0;
                    //mapBeginning只有一个元素，因为Arrays.asList(topicPartition)只有一个topicPartition
                    while(itr2.hasNext()) {
                        Map.Entry<TopicPartition, Long> tmpEntry = itr2.next();
                        beginOffset =  tmpEntry.getValue();
                    }
                    Map<TopicPartition, Long> mapEnd = consumer.endOffsets(Arrays.asList(topicPartition));
                    Iterator<Map.Entry<TopicPartition, Long>> itr3 = mapEnd.entrySet().iterator();
                    long lastOffset = 0;
                    while(itr3.hasNext()) {
                        Map.Entry<TopicPartition, Long> tmpEntry2 = itr3.next();
                        lastOffset = tmpEntry2.getValue();
                    }
                    long expectedOffSet = lastOffset - COUNT;
                    expectedOffSet = expectedOffSet > 0? expectedOffSet : 1;
                    System.out.println("Leader of partitionId: " + partitionId + "  is " + node + ".  expectedOffSet:"+ expectedOffSet
                            + "，  beginOffset:" + beginOffset + ", lastOffset:" + lastOffset);
                    consumer.commitSync(Collections.singletonMap(topicPartition, new OffsetAndMetadata(expectedOffSet -1 )));
                });
            }

            consumer.subscribe(Arrays.asList(topic));
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(100);
                for (ConsumerRecord<String, String> record : records) {
                    System.out.printf("read offset =%d, key=%s , value= %s, partition=%s\n",
                            record.offset(), record.key(), record.value(), record.partition());
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("when calling kafka output error." + ex.getMessage());
        } finally {
            adminClient.close();
            consumer.close();
        }
    }
}
