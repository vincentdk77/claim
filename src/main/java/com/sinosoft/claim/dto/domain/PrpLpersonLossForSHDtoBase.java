package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLpersonLoss－人员赔付信息表的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLpersonLossForSHDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性赔款计算书号 */
    private String compensateNo = "";
    /** 属性险种 */
    private String riskCode = "";
    /** 属性保单号 */
    private String policyNo = "";
    /** 属性赔付标的序号 */
    private int serialNo = 0;
    /** 属性人员序号 */
    private int personNo = 0;
    /** 属性人员名称 */
    private String personName = "";
    /** 属性身份证号码 */
    private String identifyNumber = "";
    /** 属性性别 */
    private String sex = "";
    /** 属性年龄 */
    private int age = 0;
    /** 属性标的险别序号 */
    private int itemKindNo = 0;
    /** 属性家庭序号 */
    private int familyNo = 0;
    /** 属性家庭名称 */
    private String familyName = "";
    /** 属性承保险别代码 */
    private String kindCode = "";
    /** 属性责任分类代码 */
    private String liabCode = "";
    /** 属性责任分类名称 */
    private String liabName = "";
    /** 属性雇员工种代码 */
    private String jobCode = "";
    /** 属性雇员工种名称 */
    private String jobName = "";
    /** 属性责任名细分类代码 */
    private String liabDetailCode = "";
    /** 属性责任名细分类名称 */
    private String liabDetailName = "";
    /** 属性受损标的地址 */
    private String itemAddress = "";
    /** 属性人数 */
    private int lossQuantity = 0;
    /** 属性数量单位 */
    private String unit = "";
    /** 属性单位赔偿限额 */
    private double unitAmount = 0D;
    /** 属性币别 */
    private String currency = "";
    /** 属性保险金额 */
    private double amount = 0D;
    /** 属性标的价值币别 */
    private String currency1 = "";
    /** 属性标的价值 */
    private double itemValue = 0D;
    /** 属性受损金额币别 */
    private String currency2 = "";
    /** 属性受损金额 */
    private double sumLoss = 0D;
    /** 属性剔除金额/残值/损余 */
    private double sumRest = 0D;
    /** 属性责任比例 */
    private double indemnityDutyRate = 0D;
    /** 属性赔付比例 */
    private double claimRate = 0D;
    /** 属性免赔额币别 */
    private String currency3 = "";
    /** 属性免赔率 */
    private double deductibleRate = 0D;
    /** 属性免赔额 */
    private double deductible = 0D;
    /** 属性实赔币别 */
    private String currency4 = "";
    /** 属性实赔金额 */
    private double sumRealPay = 0D;
    /** 属性标志字段 */
    private String flag = "";
    /** 属性事故责任免赔率 */
    private double dutyDeductibleRate = 0D;
    /** 属性INJURYGRADE */
    private String injuryGrade = "";
    /** 属性INJURYSCOPEDESC */
    private String injuryScopeDesc = "";
    /** 属性入院日期 */
    private String inHospDate = "";
    /** 属性出院日期 */
    private String outHospDate = "";
    /** 属性就诊医院 */
    private String hospital = "";
    /** 属性住院天数 */
    private int hospitalDays = 0;
    /** 属性剔除原因 */
    private String rejectReason = "";
    /** 属性驾驶员免赔率 */
    private double driverDeductibleRate = 0D;
    /** 属性最高赔付金额 */
    private double maxpaid = 0D;
    /** 属性历史赔付金额 */
    private double hispaid = 0D;
    /** 属性备注 */
    private String remark = "";
    /** 属性协商比例 */
    private double arrangeRate = 0D;
    /** 属性核定赔偿 */
    private double sumDefPay = 0D;
    /** 属性费用范围 */
    private String feeCategory = "";
    
    private double sumAllRealPay = 0d;
    private String hospitalCode = "";
    private String diseaseCode = "";
    
    /**
     *  默认构造方法,构造一个默认的PrpLpersonLossDtoBase对象
     */
    public PrpLpersonLossForSHDtoBase(){
    }

    /**
     * 设置属性赔款计算书号
     * @param compensateNo 待设置的属性赔款计算书号的值
     */
    public void setCompensateNo(String compensateNo){
        this.compensateNo = StringUtils.rightTrim(compensateNo);
    }

    /**
     * 获取属性赔款计算书号
     * @return 属性赔款计算书号的值
     */
    public String getCompensateNo(){
        return compensateNo;
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
     * 设置属性赔付标的序号
     * @param serialNo 待设置的属性赔付标的序号的值
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性赔付标的序号
     * @return 属性赔付标的序号的值
     */
    public int getSerialNo(){
        return serialNo;
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
     * 设置属性人员名称
     * @param personName 待设置的属性人员名称的值
     */
    public void setPersonName(String personName){
        this.personName = StringUtils.rightTrim(personName);
    }

    /**
     * 获取属性人员名称
     * @return 属性人员名称的值
     */
    public String getPersonName(){
        return personName;
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
     * 设置属性性别
     * @param sex 待设置的属性性别的值
     */
    public void setSex(String sex){
        this.sex = StringUtils.rightTrim(sex);
    }

    /**
     * 获取属性性别
     * @return 属性性别的值
     */
    public String getSex(){
        return sex;
    }

    /**
     * 设置属性年龄
     * @param age 待设置的属性年龄的值
     */
    public void setAge(int age){
        this.age = age;
    }

    /**
     * 获取属性年龄
     * @return 属性年龄的值
     */
    public int getAge(){
        return age;
    }

    /**
     * 设置属性标的险别序号
     * @param itemKindNo 待设置的属性标的险别序号的值
     */
    public void setItemKindNo(int itemKindNo){
        this.itemKindNo = itemKindNo;
    }

    /**
     * 获取属性标的险别序号
     * @return 属性标的险别序号的值
     */
    public int getItemKindNo(){
        return itemKindNo;
    }

    /**
     * 设置属性家庭序号
     * @param familyNo 待设置的属性家庭序号的值
     */
    public void setFamilyNo(int familyNo){
        this.familyNo = familyNo;
    }

    /**
     * 获取属性家庭序号
     * @return 属性家庭序号的值
     */
    public int getFamilyNo(){
        return familyNo;
    }

    /**
     * 设置属性家庭名称
     * @param familyName 待设置的属性家庭名称的值
     */
    public void setFamilyName(String familyName){
        this.familyName = StringUtils.rightTrim(familyName);
    }

    /**
     * 获取属性家庭名称
     * @return 属性家庭名称的值
     */
    public String getFamilyName(){
        return familyName;
    }

    /**
     * 设置属性承保险别代码
     * @param kindCode 待设置的属性承保险别代码的值
     */
    public void setKindCode(String kindCode){
        this.kindCode = StringUtils.rightTrim(kindCode);
    }

    /**
     * 获取属性承保险别代码
     * @return 属性承保险别代码的值
     */
    public String getKindCode(){
        return kindCode;
    }

    /**
     * 设置属性责任分类代码
     * @param liabCode 待设置的属性责任分类代码的值
     */
    public void setLiabCode(String liabCode){
        this.liabCode = StringUtils.rightTrim(liabCode);
    }

    /**
     * 获取属性责任分类代码
     * @return 属性责任分类代码的值
     */
    public String getLiabCode(){
        return liabCode;
    }

    /**
     * 设置属性责任分类名称
     * @param liabName 待设置的属性责任分类名称的值
     */
    public void setLiabName(String liabName){
        this.liabName = StringUtils.rightTrim(liabName);
    }

    /**
     * 获取属性责任分类名称
     * @return 属性责任分类名称的值
     */
    public String getLiabName(){
        return liabName;
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
     * 设置属性责任名细分类代码
     * @param liabDetailCode 待设置的属性责任名细分类代码的值
     */
    public void setLiabDetailCode(String liabDetailCode){
        this.liabDetailCode = StringUtils.rightTrim(liabDetailCode);
    }

    /**
     * 获取属性责任名细分类代码
     * @return 属性责任名细分类代码的值
     */
    public String getLiabDetailCode(){
        return liabDetailCode;
    }

    /**
     * 设置属性责任名细分类名称
     * @param liabDetailName 待设置的属性责任名细分类名称的值
     */
    public void setLiabDetailName(String liabDetailName){
        this.liabDetailName = StringUtils.rightTrim(liabDetailName);
    }

    /**
     * 获取属性责任名细分类名称
     * @return 属性责任名细分类名称的值
     */
    public String getLiabDetailName(){
        return liabDetailName;
    }

    /**
     * 设置属性受损标的地址
     * @param itemAddress 待设置的属性受损标的地址的值
     */
    public void setItemAddress(String itemAddress){
        this.itemAddress = StringUtils.rightTrim(itemAddress);
    }

    /**
     * 获取属性受损标的地址
     * @return 属性受损标的地址的值
     */
    public String getItemAddress(){
        return itemAddress;
    }

    /**
     * 设置属性人数
     * @param lossQuantity 待设置的属性人数的值
     */
    public void setLossQuantity(int lossQuantity){
        this.lossQuantity = lossQuantity;
    }

    /**
     * 获取属性人数
     * @return 属性人数的值
     */
    public int getLossQuantity(){
        return lossQuantity;
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
     * 设置属性单位赔偿限额
     * @param unitAmount 待设置的属性单位赔偿限额的值
     */
    public void setUnitAmount(double unitAmount){
        this.unitAmount = unitAmount;
    }

    /**
     * 获取属性单位赔偿限额
     * @return 属性单位赔偿限额的值
     */
    public double getUnitAmount(){
        return unitAmount;
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
     * 设置属性保险金额
     * @param amount 待设置的属性保险金额的值
     */
    public void setAmount(double amount){
        this.amount = amount;
    }

    /**
     * 获取属性保险金额
     * @return 属性保险金额的值
     */
    public double getAmount(){
        return amount;
    }

    /**
     * 设置属性标的价值币别
     * @param currency1 待设置的属性标的价值币别的值
     */
    public void setCurrency1(String currency1){
        this.currency1 = StringUtils.rightTrim(currency1);
    }

    /**
     * 获取属性标的价值币别
     * @return 属性标的价值币别的值
     */
    public String getCurrency1(){
        return currency1;
    }

    /**
     * 设置属性标的价值
     * @param itemValue 待设置的属性标的价值的值
     */
    public void setItemValue(double itemValue){
        this.itemValue = itemValue;
    }

    /**
     * 获取属性标的价值
     * @return 属性标的价值的值
     */
    public double getItemValue(){
        return itemValue;
    }

    /**
     * 设置属性受损金额币别
     * @param currency2 待设置的属性受损金额币别的值
     */
    public void setCurrency2(String currency2){
        this.currency2 = StringUtils.rightTrim(currency2);
    }

    /**
     * 获取属性受损金额币别
     * @return 属性受损金额币别的值
     */
    public String getCurrency2(){
        return currency2;
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
     * 设置属性剔除金额/残值/损余
     * @param sumRest 待设置的属性剔除金额/残值/损余的值
     */
    public void setSumRest(double sumRest){
        this.sumRest = sumRest;
    }

    /**
     * 获取属性剔除金额/残值/损余
     * @return 属性剔除金额/残值/损余的值
     */
    public double getSumRest(){
        return sumRest;
    }

    /**
     * 设置属性责任比例
     * @param indemnityDutyRate 待设置的属性责任比例的值
     */
    public void setIndemnityDutyRate(double indemnityDutyRate){
        this.indemnityDutyRate = indemnityDutyRate;
    }

    /**
     * 获取属性责任比例
     * @return 属性责任比例的值
     */
    public double getIndemnityDutyRate(){
        return indemnityDutyRate;
    }

    /**
     * 设置属性赔付比例
     * @param claimRate 待设置的属性赔付比例的值
     */
    public void setClaimRate(double claimRate){
        this.claimRate = claimRate;
    }

    /**
     * 获取属性赔付比例
     * @return 属性赔付比例的值
     */
    public double getClaimRate(){
        return claimRate;
    }

    /**
     * 设置属性免赔额币别
     * @param currency3 待设置的属性免赔额币别的值
     */
    public void setCurrency3(String currency3){
        this.currency3 = StringUtils.rightTrim(currency3);
    }

    /**
     * 获取属性免赔额币别
     * @return 属性免赔额币别的值
     */
    public String getCurrency3(){
        return currency3;
    }

    /**
     * 设置属性免赔率
     * @param deductibleRate 待设置的属性免赔率的值
     */
    public void setDeductibleRate(double deductibleRate){
        this.deductibleRate = deductibleRate;
    }

    /**
     * 获取属性免赔率
     * @return 属性免赔率的值
     */
    public double getDeductibleRate(){
        return deductibleRate;
    }

    /**
     * 设置属性免赔额
     * @param deductible 待设置的属性免赔额的值
     */
    public void setDeductible(double deductible){
        this.deductible = deductible;
    }

    /**
     * 获取属性免赔额
     * @return 属性免赔额的值
     */
    public double getDeductible(){
        return deductible;
    }

    /**
     * 设置属性实赔币别
     * @param currency4 待设置的属性实赔币别的值
     */
    public void setCurrency4(String currency4){
        this.currency4 = StringUtils.rightTrim(currency4);
    }

    /**
     * 获取属性实赔币别
     * @return 属性实赔币别的值
     */
    public String getCurrency4(){
        return currency4;
    }

    /**
     * 设置属性实赔金额
     * @param sumRealPay 待设置的属性实赔金额的值
     */
    public void setSumRealPay(double sumRealPay){
        this.sumRealPay = sumRealPay;
    }

    /**
     * 获取属性实赔金额
     * @return 属性实赔金额的值
     */
    public double getSumRealPay(){
        return sumRealPay;
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
     * 设置属性事故责任免赔率
     * @param dutyDeductibleRate 待设置的属性事故责任免赔率的值
     */
    public void setDutyDeductibleRate(double dutyDeductibleRate){
        this.dutyDeductibleRate = dutyDeductibleRate;
    }

    /**
     * 获取属性事故责任免赔率
     * @return 属性事故责任免赔率的值
     */
    public double getDutyDeductibleRate(){
        return dutyDeductibleRate;
    }

    /**
     * 设置属性INJURYGRADE
     * @param injuryGrade 待设置的属性INJURYGRADE的值
     */
    public void setInjuryGrade(String injuryGrade){
        this.injuryGrade = StringUtils.rightTrim(injuryGrade);
    }

    /**
     * 获取属性INJURYGRADE
     * @return 属性INJURYGRADE的值
     */
    public String getInjuryGrade(){
        return injuryGrade;
    }

    /**
     * 设置属性INJURYSCOPEDESC
     * @param injuryScopeDesc 待设置的属性INJURYSCOPEDESC的值
     */
    public void setInjuryScopeDesc(String injuryScopeDesc){
        this.injuryScopeDesc = StringUtils.rightTrim(injuryScopeDesc);
    }

    /**
     * 获取属性INJURYSCOPEDESC
     * @return 属性INJURYSCOPEDESC的值
     */
    public String getInjuryScopeDesc(){
        return injuryScopeDesc;
    }

    /**
     * 设置属性入院日期
     * @param inHospDate 待设置的属性入院日期的值
     */
    public void setInHospDate(String inHospDate){
        this.inHospDate = inHospDate;
    }

    /**
     * 获取属性入院日期
     * @return 属性入院日期的值
     */
    public String getInHospDate(){
        return inHospDate;
    }

    /**
     * 设置属性出院日期
     * @param outHospDate 待设置的属性出院日期的值
     */
    public void setOutHospDate(String outHospDate){
        this.outHospDate = outHospDate;
    }

    /**
     * 获取属性出院日期
     * @return 属性出院日期的值
     */
    public String getOutHospDate(){
        return outHospDate;
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
     * 设置属性住院天数
     * @param hospitalDays 待设置的属性住院天数的值
     */
    public void setHospitalDays(int hospitalDays){
        this.hospitalDays = hospitalDays;
    }

    /**
     * 获取属性住院天数
     * @return 属性住院天数的值
     */
    public int getHospitalDays(){
        return hospitalDays;
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
     * 设置属性驾驶员免赔率
     * @param driverDeductibleRate 待设置的属性驾驶员免赔率的值
     */
    public void setDriverDeductibleRate(double driverDeductibleRate){
        this.driverDeductibleRate = driverDeductibleRate;
    }

    /**
     * 获取属性驾驶员免赔率
     * @return 属性驾驶员免赔率的值
     */
    public double getDriverDeductibleRate(){
        return driverDeductibleRate;
    }

    /**
     * 设置属性最高赔付金额
     * @param maxpaid 待设置的属性最高赔付金额的值
     */
    public void setMaxpaid(double maxpaid){
        this.maxpaid = maxpaid;
    }

    /**
     * 获取属性最高赔付金额
     * @return 属性最高赔付金额的值
     */
    public double getMaxpaid(){
        return maxpaid;
    }

    /**
     * 设置属性历史赔付金额
     * @param hispaid 待设置的属性历史赔付金额的值
     */
    public void setHispaid(double hispaid){
        this.hispaid = hispaid;
    }

    /**
     * 获取属性历史赔付金额
     * @return 属性历史赔付金额的值
     */
    public double getHispaid(){
        return hispaid;
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
     * 设置属性协商比例
     * @param arrangeRate 待设置的属性协商比例的值
     */
    public void setArrangeRate(double arrangeRate){
        this.arrangeRate = arrangeRate;
    }

    /**
     * 获取属性协商比例
     * @return 属性协商比例的值
     */
    public double getArrangeRate(){
        return arrangeRate;
    }

    /**
     * 设置属性核定赔偿
     * @param sumDefPay 待设置的属性核定赔偿的值
     */
    public void setSumDefPay(double sumDefPay){
        this.sumDefPay = sumDefPay;
    }

    /**
     * 获取属性核定赔偿
     * @return 属性核定赔偿的值
     */
    public double getSumDefPay(){
        return sumDefPay;
    }

    /**
     * 设置属性费用范围
     * @param feeCategory 待设置的属性费用范围的值
     */
    public void setFeeCategory(String feeCategory){
        this.feeCategory = StringUtils.rightTrim(feeCategory);
    }

    /**
     * 获取属性费用范围
     * @return 属性费用范围的值
     */
    public String getFeeCategory(){
        return feeCategory;
    }

	public double getSumAllRealPay() {
		return sumAllRealPay;
	}

	public void setSumAllRealPay(double sumAllRealPay) {
		this.sumAllRealPay = sumAllRealPay;
	}

	public String getHospitalCode() {
		return hospitalCode;
	}

	public void setHospitalCode(String hospitalCode) {
		this.hospitalCode = hospitalCode;
	}

	public String getDiseaseCode() {
		return diseaseCode;
	}

	public void setDiseaseCode(String diseaseCode) {
		this.diseaseCode = diseaseCode;
	}
	
	
}
