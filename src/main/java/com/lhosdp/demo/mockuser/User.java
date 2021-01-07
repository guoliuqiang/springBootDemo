package com.lhosdp.demo.mockuser;

import lombok.Data;

@Data
public class User {

    private String certType;
    private String userIdList;
    private String channel;
    private String ecifId;
    private String userName;
    private String userId;
    private String channelState;
    private String frozenDate;
    private String certNo;
    private String customerType;
    private String customerManagerNumber;
    private String signPhone;

    @Override
    public String toString() {
        return "User{" +
                "ertType='" + certType + '\'' +
                ", userIdList='" + userIdList + '\'' +
                ", channel='" + channel + '\'' +
                ", ecifId='" + ecifId + '\'' +
                ", userName='" + userName + '\'' +
                ", userId='" + userId + '\'' +
                ", channelState='" + channelState + '\'' +
                ", frozenDate='" + frozenDate + '\'' +
                ", certNo='" + certNo + '\'' +
                ", customerType='" + customerType + '\'' +
                ", customerManagerNumber='" + customerManagerNumber + '\'' +
                ", signPhone='" + signPhone + '\'' +
                '}';
    }

    public String getCertType() {
        return certType;
    }

    public void setCertType(String certType) {
        this.certType = certType;
    }

    public String getUserIdList() {
        return userIdList;
    }

    public void setUserIdList(String userIdList) {
        this.userIdList = userIdList;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getEcifId() {
        return ecifId;
    }

    public void setEcifId(String ecifId) {
        this.ecifId = ecifId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getChannelState() {
        return channelState;
    }

    public void setChannelState(String channelState) {
        this.channelState = channelState;
    }

    public String getFrozenDate() {
        return frozenDate;
    }

    public void setFrozenDate(String frozenDate) {
        this.frozenDate = frozenDate;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getCustomerManagerNumber() {
        return customerManagerNumber;
    }

    public void setCustomerManagerNumber(String customerManagerNumber) {
        this.customerManagerNumber = customerManagerNumber;
    }

    public String getSignPhone() {
        return signPhone;
    }

    public void setSignPhone(String signPhone) {
        this.signPhone = signPhone;
    }

    public User() {
    }

    public User(String certType, String userIdList, String channel, String ecifId, String userName, String userId, String channelState, String frozenDate, String certNo, String customerType, String customerManagerNumber, String signPhone) {
        this.certType = certType;
        this.userIdList = userIdList;
        this.channel = channel;
        this.ecifId = ecifId;
        this.userName = userName;
        this.userId = userId;
        this.channelState = channelState;
        this.frozenDate = frozenDate;
        this.certNo = certNo;
        this.customerType = customerType;
        this.customerManagerNumber = customerManagerNumber;
        this.signPhone = signPhone;
    }
}
