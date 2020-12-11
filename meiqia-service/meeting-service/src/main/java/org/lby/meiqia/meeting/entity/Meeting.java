package org.lby.meiqia.meeting.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 会诊记录表
 * </p>
 *
 * @author jiusan
 * @since 2020-12-08
 */
@TableName("t_meeting")
public class Meeting implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 会诊记录ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 患者ID
     */
    @TableField("patient_id")
    private Integer patientId;

    /**
     * 医生ID
     */
    @TableField("doctor_id")
    private Integer doctorId;

    /**
     * 会诊开始时间
     */
    @TableField("begin_time")
    private Date beginTime;

    /**
     * 会诊结束时间
     */
    @TableField("end_time")
    private Date endTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }
    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }
    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Meeting{" +
            "id=" + id +
            ", patientId=" + patientId +
            ", doctorId=" + doctorId +
            ", beginTime=" + beginTime +
            ", endTime=" + endTime +
        "}";
    }
}
