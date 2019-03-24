package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是大病医疗接口重开赔案流程状态表的数据传输对象基类<br>
 */
public class PrpLinterRecaseDetailDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性主键pk */
    private String id = "";
    /** 属性报案号码 */
    private String registNo = "";
    /** 属性保单号码 */
    private String policyNo = "";
    /** 属性立案号码 */
    private String claimNo = "";
    /** 属性计算书号码 */
    private String compensateNo = "";
    /** 属性重开次数 */
    private int recaseTime = 0;
    /** 属性重开申请成功(1成功) */
    private String recaseSuccFlag = "";
    /** 属性重开审批成功(1成功) */
    private String appovlSuccFlag = "";
    /** 属性重开理算成功(1成功) */
    private String comppSuccFlag = "";
    /** 属性重开核赔成功(1成功) */
    private String vericSuccFlag = "";
    /** 属性重开结案成功(1成功) */
    private String endcaSuccFlag = "";
    /** 属性返回信息(成功/error) */
    private String remark = "";

    /**
     *  默认构造方法,构造一个默认的PrpLinterRecaseDetailDtoBase对象
     */
    public PrpLinterRecaseDetailDtoBase(){
    }

    /**
     * 设置属性主键pk
     * @param id 待设置的属性主键pk的值
     */
    public void setId(String id){
        this.id = StringUtils.rightTrim(id);
    }

    /**
     * 获取属性主键pk
     * @return 属性主键pk的值
     */
    public String getId(){
        return id;
    }

    /**
     * 设置属性报案号码
     * @param registNo 待设置的属性报案号码的值
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * 获取属性报案号码
     * @return 属性报案号码的值
     */
    public String getRegistNo(){
        return registNo;
    }

    /**
     * 设置属性保单号码
     * @param policyNo 待设置的属性保单号码的值
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * 获取属性保单号码
     * @return 属性保单号码的值
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * 设置属性立案号码
     * @param claimNo 待设置的属性立案号码的值
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * 获取属性立案号码
     * @return 属性立案号码的值
     */
    public String getClaimNo(){
        return claimNo;
    }

    /**
     * 设置属性计算书号码
     * @param compensateNo 待设置的属性计算书号码的值
     */
    public void setCompensateNo(String compensateNo){
        this.compensateNo = StringUtils.rightTrim(compensateNo);
    }

    /**
     * 获取属性计算书号码
     * @return 属性计算书号码的值
     */
    public String getCompensateNo(){
        return compensateNo;
    }

    /**
     * 设置属性重开次数
     * @param recaseTime 待设置的属性重开次数的值
     */
    public void setRecaseTime(int recaseTime){
        this.recaseTime = recaseTime;
    }

    /**
     * 获取属性重开次数
     * @return 属性重开次数的值
     */
    public int getRecaseTime(){
        return recaseTime;
    }

    /**
     * 设置属性重开申请成功(1成功)
     * @param recaseSuccFlag 待设置的属性重开申请成功(1成功)的值
     */
    public void setRecaseSuccFlag(String recaseSuccFlag){
        this.recaseSuccFlag = StringUtils.rightTrim(recaseSuccFlag);
    }

    /**
     * 获取属性重开申请成功(1成功)
     * @return 属性重开申请成功(1成功)的值
     */
    public String getRecaseSuccFlag(){
        return recaseSuccFlag;
    }

    /**
     * 设置属性重开审批成功(1成功)
     * @param appovlSuccFlag 待设置的属性重开审批成功(1成功)的值
     */
    public void setAppovlSuccFlag(String appovlSuccFlag){
        this.appovlSuccFlag = StringUtils.rightTrim(appovlSuccFlag);
    }

    /**
     * 获取属性重开审批成功(1成功)
     * @return 属性重开审批成功(1成功)的值
     */
    public String getAppovlSuccFlag(){
        return appovlSuccFlag;
    }

    /**
     * 设置属性重开理算成功(1成功)
     * @param comppSuccFlag 待设置的属性重开理算成功(1成功)的值
     */
    public void setComppSuccFlag(String comppSuccFlag){
        this.comppSuccFlag = StringUtils.rightTrim(comppSuccFlag);
    }

    /**
     * 获取属性重开理算成功(1成功)
     * @return 属性重开理算成功(1成功)的值
     */
    public String getComppSuccFlag(){
        return comppSuccFlag;
    }

    /**
     * 设置属性重开核赔成功(1成功)
     * @param vericSuccFlag 待设置的属性重开核赔成功(1成功)的值
     */
    public void setVericSuccFlag(String vericSuccFlag){
        this.vericSuccFlag = StringUtils.rightTrim(vericSuccFlag);
    }

    /**
     * 获取属性重开核赔成功(1成功)
     * @return 属性重开核赔成功(1成功)的值
     */
    public String getVericSuccFlag(){
        return vericSuccFlag;
    }

    /**
     * 设置属性重开结案成功(1成功)
     * @param endcaSuccFlag 待设置的属性重开结案成功(1成功)的值
     */
    public void setEndcaSuccFlag(String endcaSuccFlag){
        this.endcaSuccFlag = StringUtils.rightTrim(endcaSuccFlag);
    }

    /**
     * 获取属性重开结案成功(1成功)
     * @return 属性重开结案成功(1成功)的值
     */
    public String getEndcaSuccFlag(){
        return endcaSuccFlag;
    }

    /**
     * 设置属性返回信息(成功/error)
     * @param remark 待设置的属性返回信息(成功/error)的值
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * 获取属性返回信息(成功/error)
     * @return 属性返回信息(成功/error)的值
     */
    public String getRemark(){
        return remark;
    }
}
