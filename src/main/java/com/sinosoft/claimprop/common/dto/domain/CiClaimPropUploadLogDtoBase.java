package com.sinosoft.claimprop.common.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是CiClaimPropUploadLog的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class CiClaimPropUploadLogDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性businessNo */
    private String businessNo = "";
    /** 属性serialNo */
    private int serialNo = 0;
    /** 属性uploadType */
    private String uploadType = "";
    /** 属性claimStatus */
    private String claimStatus = "";
    /** 属性uploadDate */
    private DateTime uploadDate = new DateTime();
    /** 属性flag */
    private int flag = 0;
    /** 属性sendContext */
    private String sendContext = "";
    /** 属性returnContext */
    private String returnContext = "";
    /** 属性failReson */
    private String failReson = "";
    /** 属性triggerMode */
    private String triggerMode = "";
    /** 属性claimCode */
    private String claimCode = "";
    /** 属性policyNo */
    private String policyNo = "";

    /**
     *  默认构造方法,构造一个默认的CiClaimPropUploadLogDtoBase对象
     */
    public CiClaimPropUploadLogDtoBase(){
    }

    /**
     * 设置属性businessNo
     * @param businessNo 待设置的属性businessNo的值
     */
    public void setBusinessNo(String businessNo){
        this.businessNo = StringUtils.rightTrim(businessNo);
    }

    /**
     * 获取属性businessNo
     * @return 属性businessNo的值
     */
    public String getBusinessNo(){
        return businessNo;
    }

    /**
     * 设置属性serialNo
     * @param serialNo 待设置的属性serialNo的值
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性serialNo
     * @return 属性serialNo的值
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * 设置属性uploadType
     * @param uploadType 待设置的属性uploadType的值
     */
    public void setUploadType(String uploadType){
        this.uploadType = StringUtils.rightTrim(uploadType);
    }

    /**
     * 获取属性uploadType
     * @return 属性uploadType的值
     */
    public String getUploadType(){
        return uploadType;
    }

    /**
     * 设置属性claimStatus
     * @param claimStatus 待设置的属性claimStatus的值
     */
    public void setClaimStatus(String claimStatus){
        this.claimStatus = StringUtils.rightTrim(claimStatus);
    }

    /**
     * 获取属性claimStatus
     * @return 属性claimStatus的值
     */
    public String getClaimStatus(){
        return claimStatus;
    }

    /**
     * 设置属性uploadDate
     * @param uploadDate 待设置的属性uploadDate的值
     */
    public void setUploadDate(DateTime uploadDate){
        this.uploadDate = uploadDate;
    }

    /**
     * 获取属性uploadDate
     * @return 属性uploadDate的值
     */
    public DateTime getUploadDate(){
        return uploadDate;
    }

    /**
     * 设置属性flag
     * @param flag 待设置的属性flag的值
     */
    public void setFlag(int flag){
        this.flag = flag;
    }

    /**
     * 获取属性flag
     * @return 属性flag的值
     */
    public int getFlag(){
        return flag;
    }

    /**
     * 设置属性sendContext
     * @param sendContext 待设置的属性sendContext的值
     */
    public void setSendContext(String sendContext){
        this.sendContext = StringUtils.rightTrim(sendContext);
    }

    /**
     * 获取属性sendContext
     * @return 属性sendContext的值
     */
    public String getSendContext(){
        return sendContext;
    }

    /**
     * 设置属性returnContext
     * @param returnContext 待设置的属性returnContext的值
     */
    public void setReturnContext(String returnContext){
        this.returnContext = StringUtils.rightTrim(returnContext);
    }

    /**
     * 获取属性returnContext
     * @return 属性returnContext的值
     */
    public String getReturnContext(){
        return returnContext;
    }

    /**
     * 设置属性failReson
     * @param failReson 待设置的属性failReson的值
     */
    public void setFailReson(String failReson){
        this.failReson = StringUtils.rightTrim(failReson);
    }

    /**
     * 获取属性failReson
     * @return 属性failReson的值
     */
    public String getFailReson(){
        return failReson;
    }

    /**
     * 设置属性triggerMode
     * @param triggerMode 待设置的属性triggerMode的值
     */
    public void setTriggerMode(String triggerMode){
        this.triggerMode = StringUtils.rightTrim(triggerMode);
    }

    /**
     * 获取属性triggerMode
     * @return 属性triggerMode的值
     */
    public String getTriggerMode(){
        return triggerMode;
    }

    /**
     * 设置属性claimCode
     * @param claimCode 待设置的属性claimCode的值
     */
    public void setClaimCode(String claimCode){
        this.claimCode = StringUtils.rightTrim(claimCode);
    }

    /**
     * 获取属性claimCode
     * @return 属性claimCode的值
     */
    public String getClaimCode(){
        return claimCode;
    }

    /**
     * 设置属性policyNo
     * @param policyNo 待设置的属性policyNo的值
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * 获取属性policyNo
     * @return 属性policyNo的值
     */
    public String getPolicyNo(){
        return policyNo;
    }
}
