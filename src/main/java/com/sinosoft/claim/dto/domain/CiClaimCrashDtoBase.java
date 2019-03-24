package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是CIClaimCrash 车辆理赔记录的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class CiClaimCrashDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性保单号 */
    private String policyNo = "";
    /** 属性序号 */
    private int serialNo = 0;
    /** 属性理赔受理公司 */
    private String claimCompany = "";
    /** 属性出险时间 */
    private DateTime damageDate = new DateTime();
    /** 属性报案时间 */
    private DateTime reportDate = new DateTime();
    /** 属性立案时间 */
    private DateTime claimDate = new DateTime();
    /** 属性结案时间 */
    private DateTime endCaseDate = new DateTime();
    /** 属性估损金额 */
    private double sumClaim = 0D;
    /** 属性赔款金额 */
    private double sumPaid = 0D;
    /** 属性案件状态 */
    private String claimStatus = "";
    /** 属性事故号 */
    private String accidentNo = "";
    /** 属性甲乙标志 */
    private String actorFlag = "";

    /**
     *  默认构造方法,构造一个默认的CiClaimCrashDtoBase对象
     */
    public CiClaimCrashDtoBase(){
    }

    /**
     * 设置属性保单号
     * @param policyNo 待设置的属性保单号的值
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * 获取属性保单号
     * @return 属性保单号的值
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * 设置属性序号
     * @param serialNo 待设置的属性序号的值
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性序号
     * @return 属性序号的值
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * 设置属性理赔受理公司
     * @param claimCompany 待设置的属性理赔受理公司的值
     */
    public void setClaimCompany(String claimCompany){
        this.claimCompany = StringUtils.rightTrim(claimCompany);
    }

    /**
     * 获取属性理赔受理公司
     * @return 属性理赔受理公司的值
     */
    public String getClaimCompany(){
        return claimCompany;
    }

    /**
     * 设置属性出险时间
     * @param damageDate 待设置的属性出险时间的值
     */
    public void setDamageDate(DateTime damageDate){
        this.damageDate = damageDate;
    }

    /**
     * 获取属性出险时间
     * @return 属性出险时间的值
     */
    public DateTime getDamageDate(){
        return damageDate;
    }

    /**
     * 设置属性报案时间
     * @param reportDate 待设置的属性报案时间的值
     */
    public void setReportDate(DateTime reportDate){
        this.reportDate = reportDate;
    }

    /**
     * 获取属性报案时间
     * @return 属性报案时间的值
     */
    public DateTime getReportDate(){
        return reportDate;
    }

    /**
     * 设置属性立案时间
     * @param claimDate 待设置的属性立案时间的值
     */
    public void setClaimDate(DateTime claimDate){
        this.claimDate = claimDate;
    }

    /**
     * 获取属性立案时间
     * @return 属性立案时间的值
     */
    public DateTime getClaimDate(){
        return claimDate;
    }

    /**
     * 设置属性结案时间
     * @param endCaseDate 待设置的属性结案时间的值
     */
    public void setEndCaseDate(DateTime endCaseDate){
        this.endCaseDate = endCaseDate;
    }

    /**
     * 获取属性结案时间
     * @return 属性结案时间的值
     */
    public DateTime getEndCaseDate(){
        return endCaseDate;
    }

    /**
     * 设置属性估损金额
     * @param sumClaim 待设置的属性估损金额的值
     */
    public void setSumClaim(double sumClaim){
        this.sumClaim = sumClaim;
    }

    /**
     * 获取属性估损金额
     * @return 属性估损金额的值
     */
    public double getSumClaim(){
        return sumClaim;
    }

    /**
     * 设置属性赔款金额
     * @param sumPaid 待设置的属性赔款金额的值
     */
    public void setSumPaid(double sumPaid){
        this.sumPaid = sumPaid;
    }

    /**
     * 获取属性赔款金额
     * @return 属性赔款金额的值
     */
    public double getSumPaid(){
        return sumPaid;
    }

    /**
     * 设置属性案件状态
     * @param claimStatus 待设置的属性案件状态的值
     */
    public void setClaimStatus(String claimStatus){
        this.claimStatus = StringUtils.rightTrim(claimStatus);
    }

    /**
     * 获取属性案件状态
     * @return 属性案件状态的值
     */
    public String getClaimStatus(){
        return claimStatus;
    }

    /**
     * 设置属性事故号
     * @param accidentNo 待设置的属性事故号的值
     */
    public void setAccidentNo(String accidentNo){
        this.accidentNo = StringUtils.rightTrim(accidentNo);
    }

    /**
     * 获取属性事故号
     * @return 属性事故号的值
     */
    public String getAccidentNo(){
        return accidentNo;
    }

    /**
     * 设置属性甲乙标志
     * @param actorFlag 待设置的属性甲乙标志的值
     */
    public void setActorFlag(String actorFlag){
        this.actorFlag = StringUtils.rightTrim(actorFlag);
    }

    /**
     * 获取属性甲乙标志
     * @return 属性甲乙标志的值
     */
    public String getActorFlag(){
        return actorFlag;
    }
}
