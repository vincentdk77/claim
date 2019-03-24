package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLcheck－查勘/代查勘信息表的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLcheckDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性报案号码 */
    private String registNo = "";
    /** 属性立案号码 */
    private String claimNo = "";
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性保单号码 */
    private String policyNo = "";
    /** 属性查勘类型 */
    private String checkType = "";
    /** 属性查勘/代查勘性质 */
    private String checkNature = "";
    /** 属性查勘/代查勘日期 */
    private DateTime checkDate = new DateTime();
    /** 属性查勘/代查勘地点 */
    private String checkSite = "";
    /** 属性是否第一现场 */
    private String firstSiteFlag = "";
    /** 属性案件类型 */
    private String claimType = "";
    /** 属性出险原因代码 */
    private String damageCode = "";
    /** 属性出险原因说明 */
    private String damageName = "";
    /** 属性事故类型代码 */
    private String damageTypeCode = "";
    /** 属性事故类型说明 */
    private String damageTypeName = "";
    /** 属性事故所涉及险种 */
    private String referKind = "";
    /** 属性出险区域代码 */
    private String damageAreaCode = "";
    /** 属性出险地点分类 */
    private String damageAddressType = "";
    /** 属性赔偿责任代码 */
    private String indemnityDuty = "";
    /** 属性是否属于保险责任 */
    private String claimFlag = "";
    /** 属性查勘/代查勘人1 */
    private String checker1 = "";
    /** 属性查勘/代查勘人2 */
    private String checker2 = "";
    /** 属性查勘/代查勘单位名称 */
    private String checkUnitName = "";
    /** 属性事故处理部门 */
    private String handleUnit = "";
    /** 属性备注 */
    private String remark = "";
    /** 属性标志字段 */
    private String flag = "";
    /** 属性关联理赔车辆序号 */
    private int referSerialNo = 0;
    /** 属性是否为本保单车辆 */
    private String insureCarFlag = "";
    /** 属性是否向别的保险公司投保(Y/N) */
    private String repeatInsureFlag = "";
    /** 属性事故处理部门代码 */
    private String handleUnitCode = "";
    /** 属性单位类型 */
    private String unitType = "";
    /** 属性未决赔款准备金 */
    private double estimateFee = 0D;
    /** 属性估损金额 */
    private double estimateLoss = 0D;
    /** 属性出险日期 */
    private DateTime damageStartDate = new DateTime();
    /** 属性出险小时 */
    private String damageStartHour = "";
    /** 属性出险地点 */
    private String damageAddress = "";
    /** 属性查勘参与人 */
    private String checkLinker = "";

    /**
     *  默认构造方法,构造一个默认的PrpLcheckDtoBase对象
     */
    public PrpLcheckDtoBase(){
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
     * 设置属性查勘类型
     * @param checkType 待设置的属性查勘类型的值
     */
    public void setCheckType(String checkType){
        this.checkType = StringUtils.rightTrim(checkType);
    }

    /**
     * 获取属性查勘类型
     * @return 属性查勘类型的值
     */
    public String getCheckType(){
        return checkType;
    }

    /**
     * 设置属性查勘/代查勘性质
     * @param checkNature 待设置的属性查勘/代查勘性质的值
     */
    public void setCheckNature(String checkNature){
        this.checkNature = StringUtils.rightTrim(checkNature);
    }

    /**
     * 获取属性查勘/代查勘性质
     * @return 属性查勘/代查勘性质的值
     */
    public String getCheckNature(){
        return checkNature;
    }

    /**
     * 设置属性查勘/代查勘日期
     * @param checkDate 待设置的属性查勘/代查勘日期的值
     */
    public void setCheckDate(DateTime checkDate){
        this.checkDate = checkDate;
    }

    /**
     * 获取属性查勘/代查勘日期
     * @return 属性查勘/代查勘日期的值
     */
    public DateTime getCheckDate(){
        return checkDate;
    }

    /**
     * 设置属性查勘/代查勘地点
     * @param checkSite 待设置的属性查勘/代查勘地点的值
     */
    public void setCheckSite(String checkSite){
        this.checkSite = StringUtils.rightTrim(checkSite);
    }

    /**
     * 获取属性查勘/代查勘地点
     * @return 属性查勘/代查勘地点的值
     */
    public String getCheckSite(){
        return checkSite;
    }

    /**
     * 设置属性是否第一现场
     * @param firstSiteFlag 待设置的属性是否第一现场的值
     */
    public void setFirstSiteFlag(String firstSiteFlag){
        this.firstSiteFlag = StringUtils.rightTrim(firstSiteFlag);
    }

    /**
     * 获取属性是否第一现场
     * @return 属性是否第一现场的值
     */
    public String getFirstSiteFlag(){
        return firstSiteFlag;
    }

    /**
     * 设置属性案件类型
     * @param claimType 待设置的属性案件类型的值
     */
    public void setClaimType(String claimType){
        this.claimType = StringUtils.rightTrim(claimType);
    }

    /**
     * 获取属性案件类型
     * @return 属性案件类型的值
     */
    public String getClaimType(){
        return claimType;
    }

    /**
     * 设置属性出险原因代码
     * @param damageCode 待设置的属性出险原因代码的值
     */
    public void setDamageCode(String damageCode){
        this.damageCode = StringUtils.rightTrim(damageCode);
    }

    /**
     * 获取属性出险原因代码
     * @return 属性出险原因代码的值
     */
    public String getDamageCode(){
        return damageCode;
    }

    /**
     * 设置属性出险原因说明
     * @param damageName 待设置的属性出险原因说明的值
     */
    public void setDamageName(String damageName){
        this.damageName = StringUtils.rightTrim(damageName);
    }

    /**
     * 获取属性出险原因说明
     * @return 属性出险原因说明的值
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
     * 设置属性事故所涉及险种
     * @param referKind 待设置的属性事故所涉及险种的值
     */
    public void setReferKind(String referKind){
        this.referKind = StringUtils.rightTrim(referKind);
    }

    /**
     * 获取属性事故所涉及险种
     * @return 属性事故所涉及险种的值
     */
    public String getReferKind(){
        return referKind;
    }

    /**
     * 设置属性出险区域代码
     * @param damageAreaCode 待设置的属性出险区域代码的值
     */
    public void setDamageAreaCode(String damageAreaCode){
        this.damageAreaCode = StringUtils.rightTrim(damageAreaCode);
    }

    /**
     * 获取属性出险区域代码
     * @return 属性出险区域代码的值
     */
    public String getDamageAreaCode(){
        return damageAreaCode;
    }

    /**
     * 设置属性出险地点分类
     * @param damageAddressType 待设置的属性出险地点分类的值
     */
    public void setDamageAddressType(String damageAddressType){
        this.damageAddressType = StringUtils.rightTrim(damageAddressType);
    }

    /**
     * 获取属性出险地点分类
     * @return 属性出险地点分类的值
     */
    public String getDamageAddressType(){
        return damageAddressType;
    }

    /**
     * 设置属性赔偿责任代码
     * @param indemnityDuty 待设置的属性赔偿责任代码的值
     */
    public void setIndemnityDuty(String indemnityDuty){
        this.indemnityDuty = StringUtils.rightTrim(indemnityDuty);
    }

    /**
     * 获取属性赔偿责任代码
     * @return 属性赔偿责任代码的值
     */
    public String getIndemnityDuty(){
        return indemnityDuty;
    }

    /**
     * 设置属性是否属于保险责任
     * @param claimFlag 待设置的属性是否属于保险责任的值
     */
    public void setClaimFlag(String claimFlag){
        this.claimFlag = StringUtils.rightTrim(claimFlag);
    }

    /**
     * 获取属性是否属于保险责任
     * @return 属性是否属于保险责任的值
     */
    public String getClaimFlag(){
        return claimFlag;
    }

    /**
     * 设置属性查勘/代查勘人1
     * @param checker1 待设置的属性查勘/代查勘人1的值
     */
    public void setChecker1(String checker1){
        this.checker1 = StringUtils.rightTrim(checker1);
    }

    /**
     * 获取属性查勘/代查勘人1
     * @return 属性查勘/代查勘人1的值
     */
    public String getChecker1(){
        return checker1;
    }

    /**
     * 设置属性查勘/代查勘人2
     * @param checker2 待设置的属性查勘/代查勘人2的值
     */
    public void setChecker2(String checker2){
        this.checker2 = StringUtils.rightTrim(checker2);
    }

    /**
     * 获取属性查勘/代查勘人2
     * @return 属性查勘/代查勘人2的值
     */
    public String getChecker2(){
        return checker2;
    }

    /**
     * 设置属性查勘/代查勘单位名称
     * @param checkUnitName 待设置的属性查勘/代查勘单位名称的值
     */
    public void setCheckUnitName(String checkUnitName){
        this.checkUnitName = StringUtils.rightTrim(checkUnitName);
    }

    /**
     * 获取属性查勘/代查勘单位名称
     * @return 属性查勘/代查勘单位名称的值
     */
    public String getCheckUnitName(){
        return checkUnitName;
    }

    /**
     * 设置属性事故处理部门
     * @param handleUnit 待设置的属性事故处理部门的值
     */
    public void setHandleUnit(String handleUnit){
        this.handleUnit = StringUtils.rightTrim(handleUnit);
    }

    /**
     * 获取属性事故处理部门
     * @return 属性事故处理部门的值
     */
    public String getHandleUnit(){
        return handleUnit;
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

    /**
     * 设置属性关联理赔车辆序号
     * @param referSerialNo 待设置的属性关联理赔车辆序号的值
     */
    public void setReferSerialNo(int referSerialNo){
        this.referSerialNo = referSerialNo;
    }

    /**
     * 获取属性关联理赔车辆序号
     * @return 属性关联理赔车辆序号的值
     */
    public int getReferSerialNo(){
        return referSerialNo;
    }

    /**
     * 设置属性是否为本保单车辆
     * @param insureCarFlag 待设置的属性是否为本保单车辆的值
     */
    public void setInsureCarFlag(String insureCarFlag){
        this.insureCarFlag = StringUtils.rightTrim(insureCarFlag);
    }

    /**
     * 获取属性是否为本保单车辆
     * @return 属性是否为本保单车辆的值
     */
    public String getInsureCarFlag(){
        return insureCarFlag;
    }

    /**
     * 设置属性是否向别的保险公司投保(Y/N)
     * @param repeatInsureFlag 待设置的属性是否向别的保险公司投保(Y/N)的值
     */
    public void setRepeatInsureFlag(String repeatInsureFlag){
        this.repeatInsureFlag = StringUtils.rightTrim(repeatInsureFlag);
    }

    /**
     * 获取属性是否向别的保险公司投保(Y/N)
     * @return 属性是否向别的保险公司投保(Y/N)的值
     */
    public String getRepeatInsureFlag(){
        return repeatInsureFlag;
    }

    /**
     * 设置属性事故处理部门代码
     * @param handleUnitCode 待设置的属性事故处理部门代码的值
     */
    public void setHandleUnitCode(String handleUnitCode){
        this.handleUnitCode = StringUtils.rightTrim(handleUnitCode);
    }

    /**
     * 获取属性事故处理部门代码
     * @return 属性事故处理部门代码的值
     */
    public String getHandleUnitCode(){
        return handleUnitCode;
    }

    /**
     * 设置属性单位类型
     * @param unitType 待设置的属性单位类型的值
     */
    public void setUnitType(String unitType){
        this.unitType = StringUtils.rightTrim(unitType);
    }

    /**
     * 获取属性单位类型
     * @return 属性单位类型的值
     */
    public String getUnitType(){
        return unitType;
    }

    /**
     * 设置属性未决赔款准备金
     * @param estimateFee 待设置的属性未决赔款准备金的值
     */
    public void setEstimateFee(double estimateFee){
        this.estimateFee = estimateFee;
    }

    /**
     * 获取属性未决赔款准备金
     * @return 属性未决赔款准备金的值
     */
    public double getEstimateFee(){
        return estimateFee;
    }

    /**
     * 设置属性估损金额
     * @param estimateLoss 待设置的属性估损金额的值
     */
    public void setEstimateLoss(double estimateLoss){
        this.estimateLoss = estimateLoss;
    }

    /**
     * 获取属性估损金额
     * @return 属性估损金额的值
     */
    public double getEstimateLoss(){
        return estimateLoss;
    }

    /**
     * 设置属性出险日期
     * @param damageStartDate 待设置的属性出险日期的值
     */
    public void setDamageStartDate(DateTime damageStartDate){
        this.damageStartDate = damageStartDate;
    }

    /**
     * 获取属性出险日期
     * @return 属性出险日期的值
     */
    public DateTime getDamageStartDate(){
        return damageStartDate;
    }

    /**
     * 设置属性出险小时
     * @param damageStartHour 待设置的属性出险小时的值
     */
    public void setDamageStartHour(String damageStartHour){
        this.damageStartHour = StringUtils.rightTrim(damageStartHour);
    }

    /**
     * 获取属性出险小时
     * @return 属性出险小时的值
     */
    public String getDamageStartHour(){
        return damageStartHour;
    }

    /**
     * 设置属性出险地点
     * @param damageAddress 待设置的属性出险地点的值
     */
    public void setDamageAddress(String damageAddress){
        this.damageAddress = StringUtils.rightTrim(damageAddress);
    }

    /**
     * 获取属性出险地点
     * @return 属性出险地点的值
     */
    public String getDamageAddress(){
        return damageAddress;
    }

    /**
     * 设置属性查勘参与人
     * @param checkLinker 待设置的属性查勘参与人的值
     */
    public void setCheckLinker(String checkLinker){
        this.checkLinker = StringUtils.rightTrim(checkLinker);
    }

    /**
     * 获取属性查勘参与人
     * @return 属性查勘参与人的值
     */
    public String getCheckLinker(){
        return checkLinker;
    }
}
