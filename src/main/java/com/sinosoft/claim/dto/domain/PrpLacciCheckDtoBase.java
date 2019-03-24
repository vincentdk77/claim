package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLacciCheck--意健险调查主表的数据传输对象基类<br>
 * 创建于 JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class PrpLacciCheckDtoBase implements Serializable{

    private static final long serialVersionUID = PrpLacciCheckDtoBase.class.getName().hashCode();
    /** 属性报案号码 */
    private String registNo = "";
    /** 属性调查次数 */
    private int times = 0;
    /** 属性调查号 */
    private String checkNo = "";
    /** 属性发起节点 */
    private String certiType = "";
    /** 属性发起节点的业务号码 */
    private String certiNo = "";
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性保单号码 */
    private String policyNo = "";
    /** 属性调查类型 */
    private String checkType = "";
    /** 属性调查内容简要描述 */
    private String checkContext = "";
    /** 属性调查对象 */
    private String checkObject = "";
    /** 属性调查对象描述 */
    private String checkObjectDesc = "";
    /** 属性调查方式 */
    private String checkNature = "";
    /** 属性调查起始日期 */
    private DateTime checkDate = new DateTime();
    /** 属性调查起始时间 */
    private String checkHour = "";
    /** 属性调查结束日期 */
    private DateTime checkEndDate = new DateTime();
    /** 属性调查结束时间 */
    private String checkEndHour = "";
    /** 属性调查地点 */
    private String checkSite = "";
    /** 属性事故原因代码 */
    private String damageCode = "";
    /** 属性事故原因说明 */
    private String damageName = "";
    /** 属性事故类型代码 */
    private String damageTypeCode = "";
    /** 属性事故类型说明 */
    private String damageTypeName = "";
    /** 属性调查人代码 */
    private String checkerCode = "";
    /** 属性审核人代码 */
    private String approverCode = "";
    /** 属性审核日期 */
    private DateTime approverDate = new DateTime();
    /** 属性审核状态 */
    private String approverStatus = "";
    /** 属性备注 */
    private String remark = "";
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpLacciCheckDtoBase对象
     */
    public PrpLacciCheckDtoBase(){
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
     * 设置属性调查次数
     * @param times 待设置的属性调查次数的值
     */
    public void setTimes(int times){
        this.times = times;
    }

    /**
     * 获取属性调查次数
     * @return 属性调查次数的值
     */
    public int getTimes(){
        return times;
    }

    /**
     * 设置属性调查号
     * @param checkNo 待设置的属性调查号的值
     */
    public void setCheckNo(String checkNo){
        this.checkNo = StringUtils.rightTrim(checkNo);
    }

    /**
     * 获取属性调查号
     * @return 属性调查号的值
     */
    public String getCheckNo(){
        return checkNo;
    }

    /**
     * 设置属性发起节点
     * @param certiType 待设置的属性发起节点的值
     */
    public void setCertiType(String certiType){
        this.certiType = StringUtils.rightTrim(certiType);
    }

    /**
     * 获取属性发起节点
     * @return 属性发起节点的值
     */
    public String getCertiType(){
        return certiType;
    }

    /**
     * 设置属性发起节点的业务号码
     * @param certiNo 待设置的属性发起节点的业务号码的值
     */
    public void setCertiNo(String certiNo){
        this.certiNo = StringUtils.rightTrim(certiNo);
    }

    /**
     * 获取属性发起节点的业务号码
     * @return 属性发起节点的业务号码的值
     */
    public String getCertiNo(){
        return certiNo;
    }

    /**
     * 设置属性险种代码
     * @param riskCode 待设置的属性险种代码的值
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * 获取属性险种代码
     * @return 属性险种代码的值
     */
    public String getRiskCode(){
        return riskCode;
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
     * 设置属性调查类型
     * @param checkType 待设置的属性调查类型的值
     */
    public void setCheckType(String checkType){
        this.checkType = StringUtils.rightTrim(checkType);
    }

    /**
     * 获取属性调查类型
     * @return 属性调查类型的值
     */
    public String getCheckType(){
        return checkType;
    }

    /**
     * 设置属性调查内容简要描述
     * @param checkContext 待设置的属性调查内容简要描述的值
     */
    public void setCheckContext(String checkContext){
        this.checkContext = StringUtils.rightTrim(checkContext);
    }

    /**
     * 获取属性调查内容简要描述
     * @return 属性调查内容简要描述的值
     */
    public String getCheckContext(){
        return checkContext;
    }

    /**
     * 设置属性调查对象
     * @param checkObject 待设置的属性调查对象的值
     */
    public void setCheckObject(String checkObject){
        this.checkObject = StringUtils.rightTrim(checkObject);
    }

    /**
     * 获取属性调查对象
     * @return 属性调查对象的值
     */
    public String getCheckObject(){
        return checkObject;
    }

    /**
     * 设置属性调查对象描述
     * @param checkObjectDesc 待设置的属性调查对象描述的值
     */
    public void setCheckObjectDesc(String checkObjectDesc){
        this.checkObjectDesc = StringUtils.rightTrim(checkObjectDesc);
    }

    /**
     * 获取属性调查对象描述
     * @return 属性调查对象描述的值
     */
    public String getCheckObjectDesc(){
        return checkObjectDesc;
    }

    /**
     * 设置属性调查方式
     * @param checkNature 待设置的属性调查方式的值
     */
    public void setCheckNature(String checkNature){
        this.checkNature = StringUtils.rightTrim(checkNature);
    }

    /**
     * 获取属性调查方式
     * @return 属性调查方式的值
     */
    public String getCheckNature(){
        return checkNature;
    }

    /**
     * 设置属性调查起始日期
     * @param checkDate 待设置的属性调查起始日期的值
     */
    public void setCheckDate(DateTime checkDate){
        this.checkDate = checkDate;
    }

    /**
     * 获取属性调查起始日期
     * @return 属性调查起始日期的值
     */
    public DateTime getCheckDate(){
        return checkDate;
    }

    /**
     * 设置属性调查起始时间
     * @param checkHour 待设置的属性调查起始时间的值
     */
    public void setCheckHour(String checkHour){
        this.checkHour = StringUtils.rightTrim(checkHour);
    }

    /**
     * 获取属性调查起始时间
     * @return 属性调查起始时间的值
     */
    public String getCheckHour(){
        return checkHour;
    }

    /**
     * 设置属性调查结束日期
     * @param checkEndDate 待设置的属性调查结束日期的值
     */
    public void setCheckEndDate(DateTime checkEndDate){
        this.checkEndDate = checkEndDate;
    }

    /**
     * 获取属性调查结束日期
     * @return 属性调查结束日期的值
     */
    public DateTime getCheckEndDate(){
        return checkEndDate;
    }

    /**
     * 设置属性调查结束时间
     * @param checkEndHour 待设置的属性调查结束时间的值
     */
    public void setCheckEndHour(String checkEndHour){
        this.checkEndHour = StringUtils.rightTrim(checkEndHour);
    }

    /**
     * 获取属性调查结束时间
     * @return 属性调查结束时间的值
     */
    public String getCheckEndHour(){
        return checkEndHour;
    }

    /**
     * 设置属性调查地点
     * @param checkSite 待设置的属性调查地点的值
     */
    public void setCheckSite(String checkSite){
        this.checkSite = StringUtils.rightTrim(checkSite);
    }

    /**
     * 获取属性调查地点
     * @return 属性调查地点的值
     */
    public String getCheckSite(){
        return checkSite;
    }

    /**
     * 设置属性事故原因代码
     * @param damageCode 待设置的属性事故原因代码的值
     */
    public void setDamageCode(String damageCode){
        this.damageCode = StringUtils.rightTrim(damageCode);
    }

    /**
     * 获取属性事故原因代码
     * @return 属性事故原因代码的值
     */
    public String getDamageCode(){
        return damageCode;
    }

    /**
     * 设置属性事故原因说明
     * @param damageName 待设置的属性事故原因说明的值
     */
    public void setDamageName(String damageName){
        this.damageName = StringUtils.rightTrim(damageName);
    }

    /**
     * 获取属性事故原因说明
     * @return 属性事故原因说明的值
     */
    public String getDamageName(){
        return damageName;
    }

    /**
     * 设置属性事故类型代码
     * @param damageTypeCode 待设置的属性事故类型代码的值
     */
    public void setDamageTypeCode(String damageTypeCode){
        this.damageTypeCode = StringUtils.rightTrim(damageTypeCode);
    }

    /**
     * 获取属性事故类型代码
     * @return 属性事故类型代码的值
     */
    public String getDamageTypeCode(){
        return damageTypeCode;
    }

    /**
     * 设置属性事故类型说明
     * @param damageTypeName 待设置的属性事故类型说明的值
     */
    public void setDamageTypeName(String damageTypeName){
        this.damageTypeName = StringUtils.rightTrim(damageTypeName);
    }

    /**
     * 获取属性事故类型说明
     * @return 属性事故类型说明的值
     */
    public String getDamageTypeName(){
        return damageTypeName;
    }

    /**
     * 设置属性调查人代码
     * @param checkerCode 待设置的属性调查人代码的值
     */
    public void setCheckerCode(String checkerCode){
        this.checkerCode = StringUtils.rightTrim(checkerCode);
    }

    /**
     * 获取属性调查人代码
     * @return 属性调查人代码的值
     */
    public String getCheckerCode(){
        return checkerCode;
    }

    /**
     * 设置属性审核人代码
     * @param approverCode 待设置的属性审核人代码的值
     */
    public void setApproverCode(String approverCode){
        this.approverCode = StringUtils.rightTrim(approverCode);
    }

    /**
     * 获取属性审核人代码
     * @return 属性审核人代码的值
     */
    public String getApproverCode(){
        return approverCode;
    }

    /**
     * 设置属性审核日期
     * @param approverDate 待设置的属性审核日期的值
     */
    public void setApproverDate(DateTime approverDate){
        this.approverDate = approverDate;
    }

    /**
     * 获取属性审核日期
     * @return 属性审核日期的值
     */
    public DateTime getApproverDate(){
        return approverDate;
    }

    /**
     * 设置属性审核状态
     * @param approverStatus 待设置的属性审核状态的值
     */
    public void setApproverStatus(String approverStatus){
        this.approverStatus = StringUtils.rightTrim(approverStatus);
    }

    /**
     * 获取属性审核状态
     * @return 属性审核状态的值
     */
    public String getApproverStatus(){
        return approverStatus;
    }

    /**
     * 设置属性备注
     * @param remark 待设置的属性备注的值
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * 获取属性备注
     * @return 属性备注的值
     */
    public String getRemark(){
        return remark;
    }

    /**
     * 设置属性标志字段
     * @param flag 待设置的属性标志字段的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性标志字段
     * @return 属性标志字段的值
     */
    public String getFlag(){
        return flag;
    }
}
