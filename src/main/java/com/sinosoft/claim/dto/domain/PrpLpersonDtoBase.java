package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLperson－人员伤亡明细信息表的数据传输对象基类<br>
 * 创建于 2006-04-24 10:56:38.422<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLpersonDtoBase implements Serializable{
    /** 属性立案号 */
    private String claimNo = "";
    /** 属性险种 */
    private String riskCode = "";
    /** 属性保单号 */
    private String policyNo = "";
    /** 属性序号 */
    private int serialNo = 0;
    /** 属性报案号 */
    private String registNo = "";
    /** 属性保单标的子险序号 */
    private int itemKindNo = 0;
    /** 属性分户序号(车险序列号) */
    private int familyNo = 0;
    /** 属性分户名称(车险车牌号) */
    private String familyName = "";
    /** 属性险别代码 */
    private String kindCode = "";
    /** 属性保单标的项目代码 */
    private String itemCode = "";
    /** 属性所在地区代码 */
    private String areaCode = "";
    /** 属性固定收入标志 */
    private String fixedIncomeFlag = "";
    /** 属性雇员工种代码 */
    private String jobCode = "";
    /** 属性雇员工种名称 */
    private String jobName = "";
    /** 属性赔付人员类型 */
    private String payPersonType = "";
    /** 属性各种费用代码 */
    private String feeTypeCode = "";
    /** 属性费用名称 */
    private String feeTypeName = "";
    /** 属性人员序号 */
    private int personNo = 0;
    /** 属性人员姓名 */
    private String personName = "";
    /** 属性性别 */
    private String personSex = "";
    /** 属性年龄 */
    private int personAge = 0;
    /** 属性币别 */
    private String currency = "";
    /** 属性身份证号码 */
    private String identifyNumber = "";
    /** 属性工作单位 */
    private String jobUnit = "";
    /** 属性标准工资 */
    private double monthStdWage = 0d;
    /** 属性月奖金 */
    private double monthBonus = 0d;
    /** 属性津贴 */
    private double allowance = 0d;
    /** 属性月收入 */
    private double monthWage = 0d;
    /** 属性就诊医院 */
    private String hospital = "";
    /** 属性需要护理人数 */
    private int nursePersons = 0;
    /** 属性需要护理天数 */
    private int nurseDays = 0;
    /** 属性诊断结果 */
    private String diagnose = "";
    /** 属性伤势程度 */
    private String woundGrade = "";
    /** 属性拟住院天数 */
    private int hospitalDays = 0;
    /** 属性拟治疗天数 */
    private int cureDays = 0;
    /** 属性是否需要转院治疗 */
    private String changeHospital = "";
    /** 属性关联人员序号 */
    private int relatePersonNo = 0;
    /** 属性单位金额 */
    private double unitLoss = 0d;
    /** 属性数量 */
    private double quantity = 0d;
    /** 属性数量单位 */
    private String unit = "";
    /** 属性倍数 */
    private double times = 0d;
    /** 属性受损金额 */
    private double sumLoss = 0d;
    /** 属性剔除金额 */
    private double sumReject = 0d;
    /** 属性剔除原因 */
    private String rejectReason = "";
    /** 属性赔偿比例 */
    private double lossRate = 0d;
    /** 属性核定损金额 */
    private double sumDefLoss = 0d;
    /** 属性备注 */
    private String remark = "";
    /** 属性单位金额(核损) */
    private double veriUnitLoss = 0d;
    /** 属性数量(核损) */
    private double veriQuantity = 0d;
    /** 属性数量单位(核损) */
    private String veriUnit = "";
    /** 属性倍数(核损) */
    private double veriTimes = 0d;
    /** 属性受损金额(核损) */
    private double veriSumLoss = 0d;
    /** 属性剔除金额(核损) */
    private double veriSumReject = 0d;
    /** 属性剔除原因(核损) */
    private String veriRejectReason = "";
    /** 属性赔偿比例(核损) */
    private double veriLossRate = 0d;
    /** 属性核定损金额(核损) */
    private double veriSumDefLoss = 0d;
    /** 属性备注1 */
    private String veriRemark = "";
    /** 属性标志字段 */
    private String flag = "";
    /** 属性继医情况说明 */
    private String fllowHospRemark = "";
    /** 属性入院日期 */
    private DateTime inHospDate = new DateTime();
    /** 属性出院日期 */
    private DateTime outHospDate = new DateTime();
    /** 属性定残日期 */
    private DateTime restDate = new DateTime();
    /** 属性原有换件标记 */
    private String compensateBackFlag = "";

    /**
     *  默认构造方法,构造一个默认的PrpLpersonDtoBase对象
     */
    public PrpLpersonDtoBase(){
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
     * 设置属性险种
     * @param riskCode 待设置的属性险种的值
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * 获取属性险种
     * @return 属性险种的值
     */
    public String getRiskCode(){
        return riskCode;
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
     * 设置属性报案号
     * @param registNo 待设置的属性报案号的值
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * 获取属性报案号
     * @return 属性报案号的值
     */
    public String getRegistNo(){
        return registNo;
    }

    /**
     * 设置属性保单标的子险序号
     * @param itemKindNo 待设置的属性保单标的子险序号的值
     */
    public void setItemKindNo(int itemKindNo){
        this.itemKindNo = itemKindNo;
    }

    /**
     * 获取属性保单标的子险序号
     * @return 属性保单标的子险序号的值
     */
    public int getItemKindNo(){
        return itemKindNo;
    }

    /**
     * 设置属性分户序号(车险序列号)
     * @param familyNo 待设置的属性分户序号(车险序列号)的值
     */
    public void setFamilyNo(int familyNo){
        this.familyNo = familyNo;
    }

    /**
     * 获取属性分户序号(车险序列号)
     * @return 属性分户序号(车险序列号)的值
     */
    public int getFamilyNo(){
        return familyNo;
    }

    /**
     * 设置属性分户名称(车险车牌号)
     * @param familyName 待设置的属性分户名称(车险车牌号)的值
     */
    public void setFamilyName(String familyName){
        this.familyName = StringUtils.rightTrim(familyName);
    }

    /**
     * 获取属性分户名称(车险车牌号)
     * @return 属性分户名称(车险车牌号)的值
     */
    public String getFamilyName(){
        return familyName;
    }

    /**
     * 设置属性险别代码
     * @param kindCode 待设置的属性险别代码的值
     */
    public void setKindCode(String kindCode){
        this.kindCode = StringUtils.rightTrim(kindCode);
    }

    /**
     * 获取属性险别代码
     * @return 属性险别代码的值
     */
    public String getKindCode(){
        return kindCode;
    }

    /**
     * 设置属性保单标的项目代码
     * @param itemCode 待设置的属性保单标的项目代码的值
     */
    public void setItemCode(String itemCode){
        this.itemCode = StringUtils.rightTrim(itemCode);
    }

    /**
     * 获取属性保单标的项目代码
     * @return 属性保单标的项目代码的值
     */
    public String getItemCode(){
        return itemCode;
    }

    /**
     * 设置属性所在地区代码
     * @param areaCode 待设置的属性所在地区代码的值
     */
    public void setAreaCode(String areaCode){
        this.areaCode = StringUtils.rightTrim(areaCode);
    }

    /**
     * 获取属性所在地区代码
     * @return 属性所在地区代码的值
     */
    public String getAreaCode(){
        return areaCode;
    }

    /**
     * 设置属性固定收入标志
     * @param fixedIncomeFlag 待设置的属性固定收入标志的值
     */
    public void setFixedIncomeFlag(String fixedIncomeFlag){
        this.fixedIncomeFlag = StringUtils.rightTrim(fixedIncomeFlag);
    }

    /**
     * 获取属性固定收入标志
     * @return 属性固定收入标志的值
     */
    public String getFixedIncomeFlag(){
        return fixedIncomeFlag;
    }

    /**
     * 设置属性雇员工种代码
     * @param jobCode 待设置的属性雇员工种代码的值
     */
    public void setJobCode(String jobCode){
        this.jobCode = StringUtils.rightTrim(jobCode);
    }

    /**
     * 获取属性雇员工种代码
     * @return 属性雇员工种代码的值
     */
    public String getJobCode(){
        return jobCode;
    }

    /**
     * 设置属性雇员工种名称
     * @param jobName 待设置的属性雇员工种名称的值
     */
    public void setJobName(String jobName){
        this.jobName = StringUtils.rightTrim(jobName);
    }

    /**
     * 获取属性雇员工种名称
     * @return 属性雇员工种名称的值
     */
    public String getJobName(){
        return jobName;
    }

    /**
     * 设置属性赔付人员类型
     * @param payPersonType 待设置的属性赔付人员类型的值
     */
    public void setPayPersonType(String payPersonType){
        this.payPersonType = StringUtils.rightTrim(payPersonType);
    }

    /**
     * 获取属性赔付人员类型
     * @return 属性赔付人员类型的值
     */
    public String getPayPersonType(){
        return payPersonType;
    }

    /**
     * 设置属性各种费用代码
     * @param feeTypeCode 待设置的属性各种费用代码的值
     */
    public void setFeeTypeCode(String feeTypeCode){
        this.feeTypeCode = StringUtils.rightTrim(feeTypeCode);
    }

    /**
     * 获取属性各种费用代码
     * @return 属性各种费用代码的值
     */
    public String getFeeTypeCode(){
        return feeTypeCode;
    }

    /**
     * 设置属性费用名称
     * @param feeTypeName 待设置的属性费用名称的值
     */
    public void setFeeTypeName(String feeTypeName){
        this.feeTypeName = StringUtils.rightTrim(feeTypeName);
    }

    /**
     * 获取属性费用名称
     * @return 属性费用名称的值
     */
    public String getFeeTypeName(){
        return feeTypeName;
    }

    /**
     * 设置属性人员序号
     * @param personNo 待设置的属性人员序号的值
     */
    public void setPersonNo(int personNo){
        this.personNo = personNo;
    }

    /**
     * 获取属性人员序号
     * @return 属性人员序号的值
     */
    public int getPersonNo(){
        return personNo;
    }

    /**
     * 设置属性人员姓名
     * @param personName 待设置的属性人员姓名的值
     */
    public void setPersonName(String personName){
        this.personName = StringUtils.rightTrim(personName);
    }

    /**
     * 获取属性人员姓名
     * @return 属性人员姓名的值
     */
    public String getPersonName(){
        return personName;
    }

    /**
     * 设置属性性别
     * @param personSex 待设置的属性性别的值
     */
    public void setPersonSex(String personSex){
        this.personSex = StringUtils.rightTrim(personSex);
    }

    /**
     * 获取属性性别
     * @return 属性性别的值
     */
    public String getPersonSex(){
        return personSex;
    }

    /**
     * 设置属性年龄
     * @param personAge 待设置的属性年龄的值
     */
    public void setPersonAge(int personAge){
        this.personAge = personAge;
    }

    /**
     * 获取属性年龄
     * @return 属性年龄的值
     */
    public int getPersonAge(){
        return personAge;
    }

    /**
     * 设置属性币别
     * @param currency 待设置的属性币别的值
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * 获取属性币别
     * @return 属性币别的值
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * 设置属性身份证号码
     * @param identifyNumber 待设置的属性身份证号码的值
     */
    public void setIdentifyNumber(String identifyNumber){
        this.identifyNumber = StringUtils.rightTrim(identifyNumber);
    }

    /**
     * 获取属性身份证号码
     * @return 属性身份证号码的值
     */
    public String getIdentifyNumber(){
        return identifyNumber;
    }

    /**
     * 设置属性工作单位
     * @param jobUnit 待设置的属性工作单位的值
     */
    public void setJobUnit(String jobUnit){
        this.jobUnit = StringUtils.rightTrim(jobUnit);
    }

    /**
     * 获取属性工作单位
     * @return 属性工作单位的值
     */
    public String getJobUnit(){
        return jobUnit;
    }

    /**
     * 设置属性标准工资
     * @param monthStdWage 待设置的属性标准工资的值
     */
    public void setMonthStdWage(double monthStdWage){
        this.monthStdWage = monthStdWage;
    }

    /**
     * 获取属性标准工资
     * @return 属性标准工资的值
     */
    public double getMonthStdWage(){
        return monthStdWage;
    }

    /**
     * 设置属性月奖金
     * @param monthBonus 待设置的属性月奖金的值
     */
    public void setMonthBonus(double monthBonus){
        this.monthBonus = monthBonus;
    }

    /**
     * 获取属性月奖金
     * @return 属性月奖金的值
     */
    public double getMonthBonus(){
        return monthBonus;
    }

    /**
     * 设置属性津贴
     * @param allowance 待设置的属性津贴的值
     */
    public void setAllowance(double allowance){
        this.allowance = allowance;
    }

    /**
     * 获取属性津贴
     * @return 属性津贴的值
     */
    public double getAllowance(){
        return allowance;
    }

    /**
     * 设置属性月收入
     * @param monthWage 待设置的属性月收入的值
     */
    public void setMonthWage(double monthWage){
        this.monthWage = monthWage;
    }

    /**
     * 获取属性月收入
     * @return 属性月收入的值
     */
    public double getMonthWage(){
        return monthWage;
    }

    /**
     * 设置属性就诊医院
     * @param hospital 待设置的属性就诊医院的值
     */
    public void setHospital(String hospital){
        this.hospital = StringUtils.rightTrim(hospital);
    }

    /**
     * 获取属性就诊医院
     * @return 属性就诊医院的值
     */
    public String getHospital(){
        return hospital;
    }

    /**
     * 设置属性需要护理人数
     * @param nursePersons 待设置的属性需要护理人数的值
     */
    public void setNursePersons(int nursePersons){
        this.nursePersons = nursePersons;
    }

    /**
     * 获取属性需要护理人数
     * @return 属性需要护理人数的值
     */
    public int getNursePersons(){
        return nursePersons;
    }

    /**
     * 设置属性需要护理天数
     * @param nurseDays 待设置的属性需要护理天数的值
     */
    public void setNurseDays(int nurseDays){
        this.nurseDays = nurseDays;
    }

    /**
     * 获取属性需要护理天数
     * @return 属性需要护理天数的值
     */
    public int getNurseDays(){
        return nurseDays;
    }

    /**
     * 设置属性诊断结果
     * @param diagnose 待设置的属性诊断结果的值
     */
    public void setDiagnose(String diagnose){
        this.diagnose = StringUtils.rightTrim(diagnose);
    }

    /**
     * 获取属性诊断结果
     * @return 属性诊断结果的值
     */
    public String getDiagnose(){
        return diagnose;
    }

    /**
     * 设置属性伤势程度
     * @param woundGrade 待设置的属性伤势程度的值
     */
    public void setWoundGrade(String woundGrade){
        this.woundGrade = StringUtils.rightTrim(woundGrade);
    }

    /**
     * 获取属性伤势程度
     * @return 属性伤势程度的值
     */
    public String getWoundGrade(){
        return woundGrade;
    }

    /**
     * 设置属性拟住院天数
     * @param hospitalDays 待设置的属性拟住院天数的值
     */
    public void setHospitalDays(int hospitalDays){
        this.hospitalDays = hospitalDays;
    }

    /**
     * 获取属性拟住院天数
     * @return 属性拟住院天数的值
     */
    public int getHospitalDays(){
        return hospitalDays;
    }

    /**
     * 设置属性拟治疗天数
     * @param cureDays 待设置的属性拟治疗天数的值
     */
    public void setCureDays(int cureDays){
        this.cureDays = cureDays;
    }

    /**
     * 获取属性拟治疗天数
     * @return 属性拟治疗天数的值
     */
    public int getCureDays(){
        return cureDays;
    }

    /**
     * 设置属性是否需要转院治疗
     * @param changeHospital 待设置的属性是否需要转院治疗的值
     */
    public void setChangeHospital(String changeHospital){
        this.changeHospital = StringUtils.rightTrim(changeHospital);
    }

    /**
     * 获取属性是否需要转院治疗
     * @return 属性是否需要转院治疗的值
     */
    public String getChangeHospital(){
        return changeHospital;
    }

    /**
     * 设置属性关联人员序号
     * @param relatePersonNo 待设置的属性关联人员序号的值
     */
    public void setRelatePersonNo(int relatePersonNo){
        this.relatePersonNo = relatePersonNo;
    }

    /**
     * 获取属性关联人员序号
     * @return 属性关联人员序号的值
     */
    public int getRelatePersonNo(){
        return relatePersonNo;
    }

    /**
     * 设置属性单位金额
     * @param unitLoss 待设置的属性单位金额的值
     */
    public void setUnitLoss(double unitLoss){
        this.unitLoss = unitLoss;
    }

    /**
     * 获取属性单位金额
     * @return 属性单位金额的值
     */
    public double getUnitLoss(){
        return unitLoss;
    }

    /**
     * 设置属性数量
     * @param quantity 待设置的属性数量的值
     */
    public void setQuantity(double quantity){
        this.quantity = quantity;
    }

    /**
     * 获取属性数量
     * @return 属性数量的值
     */
    public double getQuantity(){
        return quantity;
    }

    /**
     * 设置属性数量单位
     * @param unit 待设置的属性数量单位的值
     */
    public void setUnit(String unit){
        this.unit = StringUtils.rightTrim(unit);
    }

    /**
     * 获取属性数量单位
     * @return 属性数量单位的值
     */
    public String getUnit(){
        return unit;
    }

    /**
     * 设置属性倍数
     * @param times 待设置的属性倍数的值
     */
    public void setTimes(double times){
        this.times = times;
    }

    /**
     * 获取属性倍数
     * @return 属性倍数的值
     */
    public double getTimes(){
        return times;
    }

    /**
     * 设置属性受损金额
     * @param sumLoss 待设置的属性受损金额的值
     */
    public void setSumLoss(double sumLoss){
        this.sumLoss = sumLoss;
    }

    /**
     * 获取属性受损金额
     * @return 属性受损金额的值
     */
    public double getSumLoss(){
        return sumLoss;
    }

    /**
     * 设置属性剔除金额
     * @param sumReject 待设置的属性剔除金额的值
     */
    public void setSumReject(double sumReject){
        this.sumReject = sumReject;
    }

    /**
     * 获取属性剔除金额
     * @return 属性剔除金额的值
     */
    public double getSumReject(){
        return sumReject;
    }

    /**
     * 设置属性剔除原因
     * @param rejectReason 待设置的属性剔除原因的值
     */
    public void setRejectReason(String rejectReason){
        this.rejectReason = StringUtils.rightTrim(rejectReason);
    }

    /**
     * 获取属性剔除原因
     * @return 属性剔除原因的值
     */
    public String getRejectReason(){
        return rejectReason;
    }

    /**
     * 设置属性赔偿比例
     * @param lossRate 待设置的属性赔偿比例的值
     */
    public void setLossRate(double lossRate){
        this.lossRate = lossRate;
    }

    /**
     * 获取属性赔偿比例
     * @return 属性赔偿比例的值
     */
    public double getLossRate(){
        return lossRate;
    }

    /**
     * 设置属性核定损金额
     * @param sumDefLoss 待设置的属性核定损金额的值
     */
    public void setSumDefLoss(double sumDefLoss){
        this.sumDefLoss = sumDefLoss;
    }

    /**
     * 获取属性核定损金额
     * @return 属性核定损金额的值
     */
    public double getSumDefLoss(){
        return sumDefLoss;
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
     * 设置属性单位金额(核损)
     * @param veriUnitLoss 待设置的属性单位金额(核损)的值
     */
    public void setVeriUnitLoss(double veriUnitLoss){
        this.veriUnitLoss = veriUnitLoss;
    }

    /**
     * 获取属性单位金额(核损)
     * @return 属性单位金额(核损)的值
     */
    public double getVeriUnitLoss(){
        return veriUnitLoss;
    }

    /**
     * 设置属性数量(核损)
     * @param veriQuantity 待设置的属性数量(核损)的值
     */
    public void setVeriQuantity(double veriQuantity){
        this.veriQuantity = veriQuantity;
    }

    /**
     * 获取属性数量(核损)
     * @return 属性数量(核损)的值
     */
    public double getVeriQuantity(){
        return veriQuantity;
    }

    /**
     * 设置属性数量单位(核损)
     * @param veriUnit 待设置的属性数量单位(核损)的值
     */
    public void setVeriUnit(String veriUnit){
        this.veriUnit = StringUtils.rightTrim(veriUnit);
    }

    /**
     * 获取属性数量单位(核损)
     * @return 属性数量单位(核损)的值
     */
    public String getVeriUnit(){
        return veriUnit;
    }

    /**
     * 设置属性倍数(核损)
     * @param veriTimes 待设置的属性倍数(核损)的值
     */
    public void setVeriTimes(double veriTimes){
        this.veriTimes = veriTimes;
    }

    /**
     * 获取属性倍数(核损)
     * @return 属性倍数(核损)的值
     */
    public double getVeriTimes(){
        return veriTimes;
    }

    /**
     * 设置属性受损金额(核损)
     * @param veriSumLoss 待设置的属性受损金额(核损)的值
     */
    public void setVeriSumLoss(double veriSumLoss){
        this.veriSumLoss = veriSumLoss;
    }

    /**
     * 获取属性受损金额(核损)
     * @return 属性受损金额(核损)的值
     */
    public double getVeriSumLoss(){
        return veriSumLoss;
    }

    /**
     * 设置属性剔除金额(核损)
     * @param veriSumReject 待设置的属性剔除金额(核损)的值
     */
    public void setVeriSumReject(double veriSumReject){
        this.veriSumReject = veriSumReject;
    }

    /**
     * 获取属性剔除金额(核损)
     * @return 属性剔除金额(核损)的值
     */
    public double getVeriSumReject(){
        return veriSumReject;
    }

    /**
     * 设置属性剔除原因(核损)
     * @param veriRejectReason 待设置的属性剔除原因(核损)的值
     */
    public void setVeriRejectReason(String veriRejectReason){
        this.veriRejectReason = StringUtils.rightTrim(veriRejectReason);
    }

    /**
     * 获取属性剔除原因(核损)
     * @return 属性剔除原因(核损)的值
     */
    public String getVeriRejectReason(){
        return veriRejectReason;
    }

    /**
     * 设置属性赔偿比例(核损)
     * @param veriLossRate 待设置的属性赔偿比例(核损)的值
     */
    public void setVeriLossRate(double veriLossRate){
        this.veriLossRate = veriLossRate;
    }

    /**
     * 获取属性赔偿比例(核损)
     * @return 属性赔偿比例(核损)的值
     */
    public double getVeriLossRate(){
        return veriLossRate;
    }

    /**
     * 设置属性核定损金额(核损)
     * @param veriSumDefLoss 待设置的属性核定损金额(核损)的值
     */
    public void setVeriSumDefLoss(double veriSumDefLoss){
        this.veriSumDefLoss = veriSumDefLoss;
    }

    /**
     * 获取属性核定损金额(核损)
     * @return 属性核定损金额(核损)的值
     */
    public double getVeriSumDefLoss(){
        return veriSumDefLoss;
    }

    /**
     * 设置属性备注1
     * @param veriRemark 待设置的属性备注1的值
     */
    public void setVeriRemark(String veriRemark){
        this.veriRemark = StringUtils.rightTrim(veriRemark);
    }

    /**
     * 获取属性备注1
     * @return 属性备注1的值
     */
    public String getVeriRemark(){
        return veriRemark;
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
     * 设置属性继医情况说明
     * @param fllowHospRemark 待设置的属性继医情况说明的值
     */
    public void setFllowHospRemark(String fllowHospRemark){
        this.fllowHospRemark = StringUtils.rightTrim(fllowHospRemark);
    }

    /**
     * 获取属性继医情况说明
     * @return 属性继医情况说明的值
     */
    public String getFllowHospRemark(){
        return fllowHospRemark;
    }

    /**
     * 设置属性入院日期
     * @param inHospDate 待设置的属性入院日期的值
     */
    public void setInHospDate(DateTime inHospDate){
        this.inHospDate = inHospDate;
    }

    /**
     * 获取属性入院日期
     * @return 属性入院日期的值
     */
    public DateTime getInHospDate(){
        return inHospDate;
    }

    /**
     * 设置属性出院日期
     * @param outHospDate 待设置的属性出院日期的值
     */
    public void setOutHospDate(DateTime outHospDate){
        this.outHospDate = outHospDate;
    }

    /**
     * 获取属性出院日期
     * @return 属性出院日期的值
     */
    public DateTime getOutHospDate(){
        return outHospDate;
    }

    /**
     * 设置属性定残日期
     * @param restDate 待设置的属性定残日期的值
     */
    public void setRestDate(DateTime restDate){
        this.restDate = restDate;
    }

    /**
     * 获取属性定残日期
     * @return 属性定残日期的值
     */
    public DateTime getRestDate(){
        return restDate;
    }

    /**
     * 设置属性原有换件标记
     * @param compensateBackFlag 待设置的属性原有换件标记的值
     */
    public void setCompensateBackFlag(String compensateBackFlag){
        this.compensateBackFlag = StringUtils.rightTrim(compensateBackFlag);
    }

    /**
     * 获取属性原有换件标记
     * @return 属性原有换件标记的值
     */
    public String getCompensateBackFlag(){
        return compensateBackFlag;
    }
}
