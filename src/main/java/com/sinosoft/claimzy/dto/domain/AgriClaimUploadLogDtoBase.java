package com.sinosoft.claimzy.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是AgriClaimUploadLogDto的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class AgriClaimUploadLogDtoBase implements Serializable{
	private static final long serialVersionUID = 1L;
    /** 属性理赔编码 */
    private String claimCode = "";
    /** 属性立案号 */
    private String claimNo = "";
    /** 属性赔案号 */
    private String caseNo = "";
    /** 属性预赔案号 */
    private String preCompensateNo = "";
    /** 属性响应代码 */
    private String responseCode = "";
    /** 属性错误代码 */
    private String errorCode = "";
    /** 属性批次号 */
    private String batchNo = "";
    /** 属性错误描述 */
    private String errorDesc = "";
    /** 属性上传日期 */
    private DateTime uploadDate = new DateTime();
    /** 属性标志位 */
    private int flag = 0;
    /**属性响应代码（明细）*/
    private String responseMXCode = "";
    /**属性错误代码（明细）*/
    private String errorMXCode = "";
    /**属性错误说明代码（明细）*/
    private String errorMXDesc = "";
    /**
     *  默认构造方法,构造一个默认的AgriClaimUploadLogDtoBase对象
     */
    public AgriClaimUploadLogDtoBase(){
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
     * 设置属性立案号
     * @param claimNo 待设置的属性立案号的值
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * 获取属性立案号
     * @return 属性立案号的值
     */
    public String getClaimNo(){
        return claimNo;
    }

    /**
     * 设置属性赔案号
     * @param caseNo 待设置的属性赔案号的值
     */
    public void setCaseNo(String caseNo){
        this.caseNo = StringUtils.rightTrim(caseNo);
    }

    /**
     * 获取属性赔案号
     * @return 属性赔案号的值
     */
    public String getCaseNo(){
        return caseNo;
    }

    /**
     * 设置属性预赔案号
     * @param preCompensateNo 待设置的属性预赔案号的值
     */
    public void setPreCompensateNo(String preCompensateNo){
        this.preCompensateNo = StringUtils.rightTrim(preCompensateNo);
    }

    /**
     * 获取属性预赔案号
     * @return 属性预赔案号的值
     */
    public String getPreCompensateNo(){
        return preCompensateNo;
    }

    /**
     * 设置属性相应代码
     * @param responseCode 待设置的属性相应代码的值
     */
    public void setResponseCode(String responseCode){
        this.responseCode = StringUtils.rightTrim(responseCode);
    }

    /**
     * 获取属性相应代码
     * @return 属性相应代码的值
     */
    public String getResponseCode(){
        return responseCode;
    }

    /**
     * 设置属性错误代码
     * @param errorCode 待设置的属性错误代码的值
     */
    public void setErrorCode(String errorCode){
        this.errorCode = StringUtils.rightTrim(errorCode);
    }

    /**
     * 获取属性错误代码
     * @return 属性错误代码的值
     */
    public String getErrorCode(){
        return errorCode;
    }

    /**
     * 设置属性批次号
     * @param batchNo 待设置的属性批次号的值
     */
    public void setBatchNo(String batchNo){
        this.batchNo = StringUtils.rightTrim(batchNo);
    }

    /**
     * 获取属性批次号
     * @return 属性批次号的值
     */
    public String getBatchNo(){
        return batchNo;
    }

    /**
     * 设置属性错误描述
     * @param errorDesc 待设置的属性错误描述的值
     */
    public void setErrorDesc(String errorDesc){
        this.errorDesc = StringUtils.rightTrim(errorDesc);
    }

    /**
     * 获取属性错误描述
     * @return 属性错误描述的值
     */
    public String getErrorDesc(){
        return errorDesc;
    }

    /**
     * 设置属性上传日期
     * @param Date 待设置的属性上传日期的值
     */
    public void setUploadDate(DateTime uploadDate){
        this.uploadDate = uploadDate;
        }

    /**
     * 获取属性上传日期
     * @return 属性上传日期的值
     */
    public DateTime getUploadDate(){
        return uploadDate;
    }


    /**
     * 设置属性标志位
     * @param flag 待设置的属性标志位的值
     */
    public void setFlag(int flag){
        this.flag = flag;
    }

    /**
     * 获取属性标志位
     * @return 属性标志位的值
     */
    public int getFlag(){
        return flag;
    }

	public String getResponseMXCode() {
		return responseMXCode;
	}

	public void setResponseMXCode(String responseMXCode) {
		this.responseMXCode = StringUtils.rightTrim(responseMXCode);
	}

	public String getErrorMXCode() {
		return errorMXCode;
	}

	public void setErrorMXCode(String errorMXCode) {
		this.errorMXCode = StringUtils.rightTrim(errorMXCode);
	}

	public String getErrorMXDesc() {
		return errorMXDesc;
	}

	public void setErrorMXDesc(String errorMXDesc) {
		this.errorMXDesc = StringUtils.rightTrim(errorMXDesc);
	}
    
}
