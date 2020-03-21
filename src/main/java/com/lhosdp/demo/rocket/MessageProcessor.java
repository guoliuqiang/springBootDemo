package com.lhosdp.demo.rocket;


import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

public class MessageProcessor implements MessageListenerConcurrently {
    private static Logger logger = LoggerFactory.getLogger(MessageProcessor.class.getName());

    //private BonusService bonusService;

//    public MessageProcessor(BonusService bonusService) {
//        this.bonusService = bonusService;
//    }

    public MessageProcessor(){}

    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
        logger.info("msgs size = " + msgs.size());
        try{
            msgs.forEach(msg -> {
                String body = new String(msg.getBody());
                logger.info("receive a message:" + body);
               // RightMessage rightMessage = SmartLifeUtil.parseJson(body, RightMessage.class);
//                RestResponse<BonusDefinitionResponse> bonusDefinitionById = bonusService.getBonusDefinitionById(rightMessage.getEquityId());
//                if("COUPON".equals(rightMessage.getEquityType())){
//                    bonusService.handoutCoupon2Customer(new HandoutCouponRequest(
//                            rightMessage.getGlobalReqSerialNO(),
//                            bonusDefinitionById.getData().getBusinessId(),
//                            bonusDefinitionById.getData().getAssetCode(),
//                            rightMessage.getUserId(),
//                            rightMessage.getWinningNum(),
//                            new Date(rightMessage.getExpiredTime()),
//                            rightMessage.getTitle(),
//                            rightMessage.getActivityId(),
//                            TransactionChannel.NONE,
//                            "",
//                            ""
//                    ));
//                }else if("INTEGRAL".equals(rightMessage.getEquityType())){
//                    bonusService.handoutBonus2Customer(new HandoutBonusRequest(
//                            rightMessage.getGlobalReqSerialNO(),
//                            bonusDefinitionById.getData().getBusinessId(),
//                            bonusDefinitionById.getData().getAssetCode(),
//                            rightMessage.getUserId(),
//                            rightMessage.getWinningNum(),
//                            new Date(rightMessage.getExpiredTime()),
//                            rightMessage.getTitle(),
//                            rightMessage.getActivityId(),
//                            TransactionChannel.NONE,
//                            ""
//                    ));
                //}
            });
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        }catch (Exception e){
            logger.info("consumer message error");
            e.printStackTrace();
            return ConsumeConcurrentlyStatus.RECONSUME_LATER;
        }


    }
}
