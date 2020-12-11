package org.lby.meiqia.meeting.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author jiusan
 * @since 2020-12-08
 */
@TableName("t_session")
public class Session implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 会诊记录ID
     */
    @TableField("meeting_id")
    private Long meetingId;

    /**
     * 发起人ID
     */
    @TableField("initiator_id")
    private Long initiatorId;

    /**
     * 接收人ID
     */
    @TableField("recipient_id")
    private Long recipientId;

    /**
     * 消息类型
     */
    @TableField("msg_type")
    private String msgType;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 是否删除
     */
    @TableField("status")
    private Boolean status;

    public Long getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(Long meetingId) {
        this.meetingId = meetingId;
    }
    public Long getInitiatorId() {
        return initiatorId;
    }

    public void setInitiatorId(Long initiatorId) {
        this.initiatorId = initiatorId;
    }
    public Long getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(Long recipientId) {
        this.recipientId = recipientId;
    }
    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Session{" +
            "meetingId=" + meetingId +
            ", initiatorId=" + initiatorId +
            ", recipientId=" + recipientId +
            ", msgType=" + msgType +
            ", createTime=" + createTime +
            ", status=" + status +
        "}";
    }
}
