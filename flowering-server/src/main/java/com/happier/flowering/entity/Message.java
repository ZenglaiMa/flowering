package com.happier.flowering.entity;

import java.util.Date;

/**
 * @ClassName Message
 * @Description 私信消息实体类
 * @Author Seven
 * @Date 2020-04-15 09:26
 */
public class Message {

    private Integer messageId; // id
    private Integer userIdSend; // 发送人id
    private Integer userIdRecv; // 接收人id
    private String content; // 私信消息内容, 限制文本
    private Date time; // 发送时间

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public Integer getUserIdSend() {
        return userIdSend;
    }

    public void setUserIdSend(Integer userIdSend) {
        this.userIdSend = userIdSend;
    }

    public Integer getUserIdRecv() {
        return userIdRecv;
    }

    public void setUserIdRecv(Integer userIdRecv) {
        this.userIdRecv = userIdRecv;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
