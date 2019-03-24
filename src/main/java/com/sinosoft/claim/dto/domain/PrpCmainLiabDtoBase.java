package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPTMAINLIAB-责任险保单信息的数据传输对象基类<br>
 * 创建于 JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class PrpCmainLiabDtoBase implements Serializable{

    private static final long serialVersionUID = PrpCmainLiabDtoBase.class.getName().hashCode();
    /** 属性投保单号码 */
    private String proposalNo = "";
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性风险类别 */
    private String riskKind = "";
    /** 属性证号
--** 职业责任险：许可证号
--** 餐饮场所保险：卫生许可证号
--** 个体工商户保险：营业执照
--**ZBB风险名胜区责任险：业务经--**                营许可证号码 */
    private String certificateNo = "";
    /** 属性发证日期 */
    private DateTime certificateDate = new DateTime();
    /** 属性发证机构 */
    private String certificateDepart = "";
    /** 属性BUSINESSCODE */
    private String businessCode = "";
    /** 属性开业日期 */
    private DateTime practiceDate = new DateTime();
    /** 属性营业性质/主要业务范围 */
    private String businessDetail = "";
    /** 属性营业处所
--**ZBB风险名胜区责任险：风景名--**                    胜区地址 */
    private String businessSite = "";
    /** 属性承保区域范围
--**ZBB风险名胜区责任险：风景名--**                    胜区面积 */
    private String insureArea = "";
    /** 属性销售区域范围 */
    private String saleArea = "";
    /** 属性律师职业责任险：事务所类型 
--** 医疗机构类型/供电所类型/ */
    private String officeType = "";
    /** 属性OFFICEGRADE */
    private String officeGrade = "";
    /** 属性追溯起始日期 */
    private DateTime bkWardStartDate = new DateTime();
    /** 属性追溯终止日期 */
    private DateTime bkWardEndDate = new DateTime();
    /** 属性员工人数 */
    private long staffCount = 0L;
    /** 属性上年度营业额 */
    private double preTurnOver = 0D;
    /** 属性本年度营业额/销售额
--**ZBB风险名胜区责任险：风景名--**              胜区年旅游人次 */
    private double nowTurnOver = 0D;
    /** 属性供电量 */
    private double electricPower = 0D;
    /** 属性备注 */
    private String remark = "";
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpTmainLiabDtoBase对象
     */
    public PrpCmainLiabDtoBase(){
    }

    /**
     * 设置属性投保单号码
     * @param proposalNo 待设置的属性投保单号码的值
     */
    public void setPolicyNo(String proposalNo){
        this.proposalNo = StringUtils.rightTrim(proposalNo);
    }

    /**
     * 获取属性投保单号码
     * @return 属性投保单号码的值
     */
    public String getPolicyNo(){
        return proposalNo;
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
     * 设置属性风险类别
     * @param riskKind 待设置的属性风险类别的值
     */
    public void setRiskKind(String riskKind){
        this.riskKind = StringUtils.rightTrim(riskKind);
    }

    /**
     * 获取属性风险类别
     * @return 属性风险类别的值
     */
    public String getRiskKind(){
        return riskKind;
    }

    /**
     * 设置属性证号
--** 职业责任险：许可证号
--** 餐饮场所保险：卫生许可证号
--** 个体工商户保险：营业执照
--**ZBB风险名胜区责任险：业务经--**                营许可证号码
     * @param certificateNo 待设置的属性证号
--** 职业责任险：许可证号
--** 餐饮场所保险：卫生许可证号
--** 个体工商户保险：营业执照
--**ZBB风险名胜区责任险：业务经--**                营许可证号码的值
     */
    public void setCertificateNo(String certificateNo){
        this.certificateNo = StringUtils.rightTrim(certificateNo);
    }

    /**
     * 获取属性证号
--** 职业责任险：许可证号
--** 餐饮场所保险：卫生许可证号
--** 个体工商户保险：营业执照
--**ZBB风险名胜区责任险：业务经--**                营许可证号码
     * @return 属性证号
--** 职业责任险：许可证号
--** 餐饮场所保险：卫生许可证号
--** 个体工商户保险：营业执照
--**ZBB风险名胜区责任险：业务经--**                营许可证号码的值
     */
    public String getCertificateNo(){
        return certificateNo;
    }

    /**
     * 设置属性发证日期
     * @param certificateDate 待设置的属性发证日期的值
     */
    public void setCertificateDate(DateTime certificateDate){
        this.certificateDate = certificateDate;
    }

    /**
     * 获取属性发证日期
     * @return 属性发证日期的值
     */
    public DateTime getCertificateDate(){
        return certificateDate;
    }

    /**
     * 设置属性发证机构
     * @param certificateDepart 待设置的属性发证机构的值
     */
    public void setCertificateDepart(String certificateDepart){
        this.certificateDepart = StringUtils.rightTrim(certificateDepart);
    }

    /**
     * 获取属性发证机构
     * @return 属性发证机构的值
     */
    public String getCertificateDepart(){
        return certificateDepart;
    }

    /**
     * 设置属性BUSINESSCODE
     * @param businessCode 待设置的属性BUSINESSCODE的值
     */
    public void setBusinessCode(String businessCode){
        this.businessCode = StringUtils.rightTrim(businessCode);
    }

    /**
     * 获取属性BUSINESSCODE
     * @return 属性BUSINESSCODE的值
     */
    public String getBusinessCode(){
        return businessCode;
    }

    /**
     * 设置属性开业日期
     * @param practiceDate 待设置的属性开业日期的值
     */
    public void setPracticeDate(DateTime practiceDate){
        this.practiceDate = practiceDate;
    }

    /**
     * 获取属性开业日期
     * @return 属性开业日期的值
     */
    public DateTime getPracticeDate(){
        return practiceDate;
    }

    /**
     * 设置属性营业性质/主要业务范围
     * @param businessDetail 待设置的属性营业性质/主要业务范围的值
     */
    public void setBusinessDetail(String businessDetail){
        this.businessDetail = StringUtils.rightTrim(businessDetail);
    }

    /**
     * 获取属性营业性质/主要业务范围
     * @return 属性营业性质/主要业务范围的值
     */
    public String getBusinessDetail(){
        return businessDetail;
    }

    /**
     * 设置属性营业处所
--**ZBB风险名胜区责任险：风景名--**                    胜区地址
     * @param businessSite 待设置的属性营业处所
--**ZBB风险名胜区责任险：风景名--**                    胜区地址的值
     */
    public void setBusinessSite(String businessSite){
        this.businessSite = StringUtils.rightTrim(businessSite);
    }

    /**
     * 获取属性营业处所
--**ZBB风险名胜区责任险：风景名--**                    胜区地址
     * @return 属性营业处所
--**ZBB风险名胜区责任险：风景名--**                    胜区地址的值
     */
    public String getBusinessSite(){
        return businessSite;
    }

    /**
     * 设置属性承保区域范围
--**ZBB风险名胜区责任险：风景名--**                    胜区面积
     * @param insureArea 待设置的属性承保区域范围
--**ZBB风险名胜区责任险：风景名--**                    胜区面积的值
     */
    public void setInsureArea(String insureArea){
        this.insureArea = StringUtils.rightTrim(insureArea);
    }

    /**
     * 获取属性承保区域范围
--**ZBB风险名胜区责任险：风景名--**                    胜区面积
     * @return 属性承保区域范围
--**ZBB风险名胜区责任险：风景名--**                    胜区面积的值
     */
    public String getInsureArea(){
        return insureArea;
    }

    /**
     * 设置属性销售区域范围
     * @param saleArea 待设置的属性销售区域范围的值
     */
    public void setSaleArea(String saleArea){
        this.saleArea = StringUtils.rightTrim(saleArea);
    }

    /**
     * 获取属性销售区域范围
     * @return 属性销售区域范围的值
     */
    public String getSaleArea(){
        return saleArea;
    }

    /**
     * 设置属性律师职业责任险：事务所类型 
--** 医疗机构类型/供电所类型/
     * @param officeType 待设置的属性律师职业责任险：事务所类型 
--** 医疗机构类型/供电所类型/的值
     */
    public void setOfficeType(String officeType){
        this.officeType = StringUtils.rightTrim(officeType);
    }

    /**
     * 获取属性律师职业责任险：事务所类型 
--** 医疗机构类型/供电所类型/
     * @return 属性律师职业责任险：事务所类型 
--** 医疗机构类型/供电所类型/的值
     */
    public String getOfficeType(){
        return officeType;
    }

    /**
     * 设置属性OFFICEGRADE
     * @param officeGrade 待设置的属性OFFICEGRADE的值
     */
    public void setOfficeGrade(String officeGrade){
        this.officeGrade = StringUtils.rightTrim(officeGrade);
    }

    /**
     * 获取属性OFFICEGRADE
     * @return 属性OFFICEGRADE的值
     */
    public String getOfficeGrade(){
        return officeGrade;
    }

    /**
     * 设置属性追溯起始日期
     * @param bkWardStartDate 待设置的属性追溯起始日期的值
     */
    public void setBkWardStartDate(DateTime bkWardStartDate){
        this.bkWardStartDate = bkWardStartDate;
    }

    /**
     * 获取属性追溯起始日期
     * @return 属性追溯起始日期的值
     */
    public DateTime getBkWardStartDate(){
        return bkWardStartDate;
    }

    /**
     * 设置属性追溯终止日期
     * @param bkWardEndDate 待设置的属性追溯终止日期的值
     */
    public void setBkWardEndDate(DateTime bkWardEndDate){
        this.bkWardEndDate = bkWardEndDate;
    }

    /**
     * 获取属性追溯终止日期
     * @return 属性追溯终止日期的值
     */
    public DateTime getBkWardEndDate(){
        return bkWardEndDate;
    }

    /**
     * 设置属性员工人数
     * @param staffCount 待设置的属性员工人数的值
     */
    public void setStaffCount(long staffCount){
        this.staffCount = staffCount;
    }

    /**
     * 获取属性员工人数
     * @return 属性员工人数的值
     */
    public long getStaffCount(){
        return staffCount;
    }

    /**
     * 设置属性上年度营业额
     * @param preTurnOver 待设置的属性上年度营业额的值
     */
    public void setPreTurnOver(double preTurnOver){
        this.preTurnOver = preTurnOver;
    }

    /**
     * 获取属性上年度营业额
     * @return 属性上年度营业额的值
     */
    public double getPreTurnOver(){
        return preTurnOver;
    }

    /**
     * 设置属性本年度营业额/销售额
--**ZBB风险名胜区责任险：风景名--**              胜区年旅游人次
     * @param nowTurnOver 待设置的属性本年度营业额/销售额
--**ZBB风险名胜区责任险：风景名--**              胜区年旅游人次的值
     */
    public void setNowTurnOver(double nowTurnOver){
        this.nowTurnOver = nowTurnOver;
    }

    /**
     * 获取属性本年度营业额/销售额
--**ZBB风险名胜区责任险：风景名--**              胜区年旅游人次
     * @return 属性本年度营业额/销售额
--**ZBB风险名胜区责任险：风景名--**              胜区年旅游人次的值
     */
    public double getNowTurnOver(){
        return nowTurnOver;
    }

    /**
     * 设置属性供电量
     * @param electricPower 待设置的属性供电量的值
     */
    public void setElectricPower(double electricPower){
        this.electricPower = electricPower;
    }

    /**
     * 获取属性供电量
     * @return 属性供电量的值
     */
    public double getElectricPower(){
        return electricPower;
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
