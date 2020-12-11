package org.lby.meiqia.meeting.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 用药提醒表
 * </p>
 *
 * @author jiusan
 * @since 2020-12-08
 */
@TableName("t_remind")
public class Remind implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用药提醒主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 患者ID
     */
    @TableField("patient_id")
    private Long patientId;

    /**
     * 会诊ID
     */
    @TableField("meeting_id")
    private Long meetingId;

    /**
     * 提醒时间
     */
    @TableField("remind_time")
    private Date remindTime;

    /**
     * 提醒文本
     */
    @TableField("remind_text")
    private String remindText;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }
    public Long getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(Long meetingId) {
        this.meetingId = meetingId;
    }
    public Date getRemindTime() {
        return remindTime;
    }

    public void setRemindTime(Date remindTime) {
        this.remindTime = remindTime;
    }
    public String getRemindText() {
        return remindText;
    }

    public void setRemindText(String remindText) {
        this.remindText = remindText;
    }

    @Override
    public String toString() {
        return "Remind{" +
            "id=" + id +
            ", patientId=" + patientId +
            ", meetingId=" + meetingId +
            ", remindTime=" + remindTime +
            ", remindText=" + remindText +
        "}";
    }
}
