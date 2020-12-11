package org.lby.meiqia.meeting.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("t_case_report")
public class CaseReport implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 病例ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 患者ID
     */
    @TableField("patient_id")
    private Long patientId;

    /**
     * 医生ID
     */
    @TableField("doctor_id")
    private Long doctorId;

    /**
     * 会诊ID
     */
    @TableField("meeting_id")
    private Long meetingId;

    /**
     * 病例主体内容
     */
    @TableField("content")
    private String content;

    /**
     * 病例创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 最后一次修改时间
     */
    @TableField("update_time")
    private Date updateTime;

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
    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }
    public Long getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(Long meetingId) {
        this.meetingId = meetingId;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "CaseReport{" +
            "id=" + id +
            ", patientId=" + patientId +
            ", doctorId=" + doctorId +
            ", meetingId=" + meetingId +
            ", content=" + content +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
        "}";
    }
}
