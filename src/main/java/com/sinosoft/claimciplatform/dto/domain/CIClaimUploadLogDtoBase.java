package com.sinosoft.claimciplatform.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是CIClaimUploadLog-理赔信息上传平台日志表的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class CIClaimUploadLogDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性上传序号 */
    private String uploadNo = "";
    /** 属性序号 */
    private int serialNo = 0;
    /** 属性理赔编码 */
    private String claimCode = "";
    /** 属性业务号 */
    private String businessNo = "";
    /** 属性上传类型 */
    private String uploadType = "";
    /** 属性上传时间 */
    private DateTime uploadDate = new DateTime();
    /** 属性标志 */
    private int flag = 0;
    /** 属性错误代码 */
    private String errorCode = "";
    /** 属性错误名称 */
    private String errorname = "";
    /** 属性上传方式 */
    private String uploadWay = "";

    
    /**
	 * 获取属性 uploadNo
	 * @return the uploadNo
	 */
	public String getUploadNo() {
		return uploadNo;
	}

	/**
	 * 设置属性 uploadNo
	 * @param uploadNo the uploadNo to set
	 */
	public void setUploadNo(String uploadNo) {
		this.uploadNo = uploadNo;
	}

	/**
     *  默认构造方法,构造一个默认的CIClaimUploadLogDtoBase对象
     */
    public CIClaimUploadLogDtoBase(){
    }

    /**
     * 设置属性顺序号
     * @param serialNo 待设置的属性顺序号的值
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性顺序号
     * @return 属性顺序号的值
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * 设置属性理赔编码
     * @param claimCode 待设置的属性理赔编码的值
     */
    public void setClaimCode(String claimCode){
        this.claimCode = StringUtils.rightTrim(claimCode);
    }

    /**
     * 获取属性理赔编码
     * @return 属性理赔编码的值
     */
    public String getClaimCode(){
        return claimCode;
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
     * 设置属性上传时间
     * @param uploadDate 待设置的属性上传时间的值
     */
    public void setUploadDate(DateTime uploadDate){
        this.uploadDate = uploadDate;
    }

    /**
     * 获取属性上传时间
     * @return 属性上传时间的值
     */
    public DateTime getUploadDate(){
        return uploadDate;
    }

    /**
     * 设置属性标志
     * @param flag 待设置的属性标志的值
     */
    public void setFlag(int flag){
        this.flag = flag;
    }

    /**
     * 获取属性标志
     * @return 属性标志的值
     */
    public int getFlag(){
        return flag;
    }

	/**
	 * 获取属性 errorCode
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * 设置属性 errorCode
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * 获取属性 errorname
	 * @return the errorname
	 */
	public String getErrorname() {
		return errorname;
	}

	/**
	 * 设置属性 errorname
	 * @param errorname the errorname to set
	 */
	public void setErrorname(String errorname) {
		this.errorname = errorname;
	}

	/**
	 * 获取属性 uploadWay
	 * @return the uploadWay
	 */
	public String getUploadWay() {
		return uploadWay;
	}

	/**
	 * 设置属性 uploadWay
	 * @param uploadWay the uploadWay to set
	 */
	public void setUploadWay(String uploadWay) {
		this.uploadWay = uploadWay;
	}

	/**
	 * 获取属性 serialVersionUID
	 * @return the serialVersionUID
	 */
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	
}
