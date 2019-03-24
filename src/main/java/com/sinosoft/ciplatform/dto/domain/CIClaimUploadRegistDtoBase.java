package com.sinosoft.ciplatform.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是理赔信息平台上传注册表的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class CIClaimUploadRegistDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性上传序号 */
    private String uploadNo = "";
    /** 属性业务号 */
    private String businessNo = "";
    /** 属性上传类型 */
    private String uploadType = "";
    /** 属性注册时间 */
    private DateTime registDate = new DateTime();
    /** 属性上传失败次数 */
    private int failTimes = 0;
    /** 补传标志 */
    private String uploadFlag = "";
    /** 属性触发方式 */
    private String triggerMode = "";
    /** 重开序号 */
    private int serlalNo =0;
    /**
     *  默认构造方法,构造一个默认的CIClaimUploadRegistDtoBase对象
     */
    public CIClaimUploadRegistDtoBase(){
    }

    /**
     * 设置属性上传序号
     * @param uploadNo 待设置的属性上传序号的值
     */
    public void setUploadNo(String uploadNo){
        this.uploadNo = StringUtils.rightTrim(uploadNo);
    }

    /**
     * 获取属性上传序号
     * @return 属性上传序号的值
     */
    public String getUploadNo(){
        return uploadNo;
    }

    /**
     * 设置属性业务号
     * @param businessNo 待设置的属性业务号的值
     */
    public void setBusinessNo(String businessNo){
        this.businessNo = StringUtils.rightTrim(businessNo);
    }

    /**
     * 获取属性业务号
     * @return 属性业务号的值
     */
    public String getBusinessNo(){
        return businessNo;
    }

    /**
     * 设置属性上传类型
     * @param uploadType 待设置的属性上传类型的值
     */
    public void setUploadType(String uploadType){
        this.uploadType = StringUtils.rightTrim(uploadType);
    }

    /**
     * 获取属性上传类型
     * @return 属性上传类型的值
     */
    public String getUploadType(){
        return uploadType;
    }

    /**
     * 设置属性注册时间
     * @param registDate 待设置的属性注册时间的值
     */
    public void setRegistDate(DateTime registDate){
        this.registDate = registDate;
    }

    /**
     * 获取属性注册时间
     * @return 属性注册时间的值
     */
    public DateTime getRegistDate(){
        return registDate;
    }

    /**
     * 设置属性上传失败次数
     * @param failTimes 待设置的属性上传失败次数的值
     */
    public void setFailTimes(int failTimes){
        this.failTimes = failTimes;
    }

    /**
     * 获取属性上传失败次数
     * @return 属性上传失败次数的值
     */
    public int getFailTimes(){
        return failTimes;
    }

    /**
     * 设置属性触发方式
     * @param triggerMode 待设置的属性触发方式的值
     */
    public void setTriggerMode(String triggerMode){
        this.triggerMode = StringUtils.rightTrim(triggerMode);
    }

    /**
     * 获取属性触发方式
     * @return 属性触发方式的值
     */
    public String getTriggerMode(){
        return triggerMode;
    }

	/**
	 * @return the uploadFlag
	 */
	public String getUploadFlag() {
		return uploadFlag;
	}

	/**
	 * @param uploadFlag the uploadFlag to set
	 */
	public void setUploadFlag(String uploadFlag) {
		this.uploadFlag = uploadFlag;
	}

	/**
	 * @return the serlalNo
	 */
	public int getSerlalNo() {
		return serlalNo;
	}

	/**
	 * @param serlalNo the serlalNo to set
	 */
	public void setSerlalNo(int serlalNo) {
		this.serlalNo = serlalNo;
	}
}
