package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLclaim-立案基本信息表的数据传输对象基类<br>
 * 创建于 JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class PrpLclaimtgDtoBase implements Serializable{

    private static final long serialVersionUID = PrpLclaimtgDtoBase.class.getName().hashCode();
    /** 属性赔案号码 */
    private String claimNo = "";
    /** 属性理赔类型
--** L：自赔
--** D1: 代赔
--** D2: 代查勘
--** D3: 代定损
--** B1：被代赔
--** B2：被代查勘
--** B3：被代定损 */
    private String lFlag = "";
    /** 属性赔案号 */
    private String caseNo = "";
    /** 属性险类代码 */
    private String classCode = "";
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性报案号码 */
    private String registNo = "";
    /** 属性保单号码 */
    private String policyNo = "";
    /** 属性业务性质 */
    private String businessNature = "";
    /** 属性语种 */
    private String language = "";
    /** 属性保单类型 */
    private String policyType = "";
    /** 属性被保险人代码 */
    private String insuredCode = "";
    /** 属性被保险人名称 */
    private String insuredName = "";
    /** 属性起保日期 */
    private DateTime startDate = new DateTime();
    /** 属性起保小时 */
    private int startHour = 0;
    /** 属性终保日期 */
    private DateTime endDate = new DateTime();
    /** 属性终保小时 */
    private int endHour = 0;
    /** 属性币别代码 */
    private String currency = "";
    /** 属性总保额
--** 需还原到本次理赔时的金额 */
    private double sumAmount = 0D;
    /** 属性总保费 */
    private double sumPremium = 0D;
    /** 属性总数量 */
    private int sumQuantity = 0;
    /** 属性出险日期起 */
    private DateTime damageStartDate = new DateTime();
    /** 属性出险开始小时 */
    private String damageStartHour = "";
    /** 属性出险日期止 */
    private DateTime damageEndDate = new DateTime();
    /** 属性出险终止小时 */
    private String damageEndHour = "";
    /** 属性出险原因代码 */
    private String damageCode = "";
    /** 属性出险原因说明 */
    private String damageName = "";
    /** 属性事故类型代码 */
    private String damageTypeCode = "";
    /** 属性事故类型说明 */
    private String damageTypeName = "";
    /** 属性出险区域代码 */
    private String damageAreaCode = "";
    /** 属性出险区域名称 */
    private String damageAreaName = "";
    /** 属性出险地点分类代码 */
    private String damageAddressType = "";
    /** 属性地址编码 */
    private String addressCode = "";
    /** 属性出险地点 */
    private String damageAddress = "";
    /** 属性受损标的 */
    private String lossName = "";
    /** 属性受损标的数量/出险分户数 */
    private int lossQuantity = 0;
    /** 属性出险险别 */
    private String damageKind = "";
    /** 属性立案日期 */
    private DateTime claimDate = new DateTime();
    /** 属性赔偿责任代码--** 全部/主要/对等/次要/无责任 */
    private String indemnityDuty = "";
    /** 属性责任比例 */
    private double indemnityDutyRate = 0D;
    /** 属性免赔率 */
    private double deductibleRate = 0D;
    /** 属性保险损失金额(同保单币别) */
    private double sumClaim = 0D;
    /** 属性总核定损金额(同保单币别) */
    private double sumDefLoss = 0D;
    /** 属性总赔付金额(同保单币别)--** (实赔+预赔) */
    private double sumPaid = 0D;
    /** 属性总追偿金额(同保单币别) */
    private double sumReplevy = 0D;
    /** 属性备注 */
    private String remark = "";
    /** 属性案件性质--** 赔付/注销/拒赔 */
    private String caseType = "";
    /** 属性理赔登记机构代码 */
    private String makeCom = "";
    /** 属性业务归属机构代码 */
    private String comCode = "";
    /** 属性代理人代码 */
    private String agentCode = "";
    /** 属性经办人代码 */
    private String handlerCode = "";
    /** 属性归属业务员代码 */
    private String handler1Code = "";
    /** 属性统计年月 */
    private DateTime statisticsYM = new DateTime();
    /** 属性操作员代码 */
    private String operatorCode = "";
    /** 属性计算机输单日期 */
    private DateTime inputDate = new DateTime();
    /** 属性结案日期 */
    private DateTime endCaseDate = new DateTime();
    /** 属性结案员代码 */
    private String endCaserCode = "";
    /** 属性注销/拒赔日期 */
    private DateTime cancelDate = new DateTime();
    /** 属性注销/拒赔原因 */
    private String cancelReason = "";
    /** 属性注销/拒赔人代码 */
    private String dealerCode = "";
    /** 属性是否为逃逸案 */
    private String escapeFlag = "";
    /** 属性标志字段 */
    private String flag = "";
    /** 属性是否可能有追偿 */
    private String replevyFlag = "";
    /** 属性是否有其他理赔中介机构 */
    private String thirdComFlag = "";
    /** 属性是否自动结案 */
    private String endCaseFlag = "";
    /** 属性计算书责任比例 */
    private double cIndemnityDutyRate = 0D;
    /** 属性出险地点邮政编码 */
    private String damageAreaPostCode = "";
    /** 属性巨灾一级代码 */
    private String catastropheCode1 = "";
    /** 属性巨灾一级名称 */
    private String catastropheName1 = "";
    /** 属性巨灾二级代码 */
    private String catastropheCode2 = "";
    /** 属性案件类型 */
    private String claimType = "";
    /** 属性巨灾二级名称 */
    private String catastropheName2 = "";
    
    private DateTime claimTime = new DateTime();

    /**
     *  默认构造方法,构造一个默认的PrpLclaimtgDtoBase对象
     */
    public PrpLclaimtgDtoBase(){
    }

    /**
     * 设置属性赔案号码
     * @param claimNo 待设置的属性赔案号码的值
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * 获取属性赔案号码
     * @return 属性赔案号码的值
     */
    public String getClaimNo(){
        return claimNo;
    }

    /**
     * 设置属性理赔类型
--** L：自赔
--** D1: 代赔
--** D2: 代查勘
--** D3: 代定损
--** B1：被代赔
--** B2：被代查勘
--** B3：被代定损
     * @param lFlag 待设置的属性理赔类型
--** L：自赔
--** D1: 代赔
--** D2: 代查勘
--** D3: 代定损
--** B1：被代赔
--** B2：被代查勘
--** B3：被代定损的值
     */
    public void setLFlag(String lFlag){
        this.lFlag = StringUtils.rightTrim(lFlag);
    }

    /**
     * 获取属性理赔类型
--** L：自赔
--** D1: 代赔
--** D2: 代查勘
--** D3: 代定损
--** B1：被代赔
--** B2：被代查勘
--** B3：被代定损
     * @return 属性理赔类型
--** L：自赔
--** D1: 代赔
--** D2: 代查勘
--** D3: 代定损
--** B1：被代赔
--** B2：被代查勘
--** B3：被代定损的值
     */
    public String getLFlag(){
        return lFlag;
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
     * 设置属性险类代码
     * @param classCode 待设置的属性险类代码的值
     */
    public void setClassCode(String classCode){
        this.classCode = StringUtils.rightTrim(classCode);
    }

    /**
     * 获取属性险类代码
     * @return 属性险类代码的值
     */
    public String getClassCode(){
        return classCode;
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
     * 设置属性业务性质
     * @param businessNature 待设置的属性业务性质的值
     */
    public void setBusinessNature(String businessNature){
        this.businessNature = StringUtils.rightTrim(businessNature);
    }

    /**
     * 获取属性业务性质
     * @return 属性业务性质的值
     */
    public String getBusinessNature(){
        return businessNature;
    }

    /**
     * 设置属性语种
     * @param language 待设置的属性语种的值
     */
    public void setLanguage(String language){
        this.language = StringUtils.rightTrim(language);
    }

    /**
     * 获取属性语种
     * @return 属性语种的值
     */
    public String getLanguage(){
        return language;
    }

    /**
     * 设置属性保单类型
     * @param policyType 待设置的属性保单类型的值
     */
    public void setPolicyType(String policyType){
        this.policyType = StringUtils.rightTrim(policyType);
    }

    /**
     * 获取属性保单类型
     * @return 属性保单类型的值
     */
    public String getPolicyType(){
        return policyType;
    }

    /**
     * 设置属性被保险人代码
     * @param insuredCode 待设置的属性被保险人代码的值
     */
    public void setInsuredCode(String insuredCode){
        this.insuredCode = StringUtils.rightTrim(insuredCode);
    }

    /**
     * 获取属性被保险人代码
     * @return 属性被保险人代码的值
     */
    public String getInsuredCode(){
        return insuredCode;
    }

    /**
     * 设置属性被保险人名称
     * @param insuredName 待设置的属性被保险人名称的值
     */
    public void setInsuredName(String insuredName){
        this.insuredName = StringUtils.rightTrim(insuredName);
    }

    /**
     * 获取属性被保险人名称
     * @return 属性被保险人名称的值
     */
    public String getInsuredName(){
        return insuredName;
    }

    /**
     * 设置属性起保日期
     * @param startDate 待设置的属性起保日期的值
     */
    public void setStartDate(DateTime startDate){
        this.startDate = startDate;
    }

    /**
     * 获取属性起保日期
     * @return 属性起保日期的值
     */
    public DateTime getStartDate(){
        return startDate;
    }

    /**
     * 设置属性起保小时
     * @param startHour 待设置的属性起保小时的值
     */
    public void setStartHour(int startHour){
        this.startHour = startHour;
    }

    /**
     * 获取属性起保小时
     * @return 属性起保小时的值
     */
    public int getStartHour(){
        return startHour;
    }

    /**
     * 设置属性终保日期
     * @param endDate 待设置的属性终保日期的值
     */
    public void setEndDate(DateTime endDate){
        this.endDate = endDate;
    }

    /**
     * 获取属性终保日期
     * @return 属性终保日期的值
     */
    public DateTime getEndDate(){
        return endDate;
    }

    /**
     * 设置属性终保小时
     * @param endHour 待设置的属性终保小时的值
     */
    public void setEndHour(int endHour){
        this.endHour = endHour;
    }

    /**
     * 获取属性终保小时
     * @return 属性终保小时的值
     */
    public int getEndHour(){
        return endHour;
    }

    /**
     * 设置属性币别代码
     * @param currency 待设置的属性币别代码的值
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * 获取属性币别代码
     * @return 属性币别代码的值
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * 设置属性总保额
--** 需还原到本次理赔时的金额
     * @param sumAmount 待设置的属性总保额
--** 需还原到本次理赔时的金额的值
     */
    public void setSumAmount(double sumAmount){
        this.sumAmount = sumAmount;
    }

    /**
     * 获取属性总保额
--** 需还原到本次理赔时的金额
     * @return 属性总保额
--** 需还原到本次理赔时的金额的值
     */
    public double getSumAmount(){
        return sumAmount;
    }

    /**
     * 设置属性总保费
     * @param sumPremium 待设置的属性总保费的值
     */
    public void setSumPremium(double sumPremium){
        this.sumPremium = sumPremium;
    }

    /**
     * 获取属性总保费
     * @return 属性总保费的值
     */
    public double getSumPremium(){
        return sumPremium;
    }

    /**
     * 设置属性总数量
     * @param sumQuantity 待设置的属性总数量的值
     */
    public void setSumQuantity(int sumQuantity){
        this.sumQuantity = sumQuantity;
    }

    /**
     * 获取属性总数量
     * @return 属性总数量的值
     */
    public int getSumQuantity(){
        return sumQuantity;
    }

    /**
     * 设置属性出险日期起
     * @param damageStartDate 待设置的属性出险日期起的值
     */
    public void setDamageStartDate(DateTime damageStartDate){
        this.damageStartDate = damageStartDate;
    }

    /**
     * 获取属性出险日期起
     * @return 属性出险日期起的值
     */
    public DateTime getDamageStartDate(){
        return damageStartDate;
    }

    /**
     * 设置属性出险开始小时
     * @param damageStartHour 待设置的属性出险开始小时的值
     */
    public void setDamageStartHour(String damageStartHour){
        this.damageStartHour = StringUtils.rightTrim(damageStartHour);
    }

    /**
     * 获取属性出险开始小时
     * @return 属性出险开始小时的值
     */
    public String getDamageStartHour(){
        return damageStartHour;
    }

    /**
     * 设置属性出险日期止
     * @param damageEndDate 待设置的属性出险日期止的值
     */
    public void setDamageEndDate(DateTime damageEndDate){
        this.damageEndDate = damageEndDate;
    }

    /**
     * 获取属性出险日期止
     * @return 属性出险日期止的值
     */
    public DateTime getDamageEndDate(){
        return damageEndDate;
    }

    /**
     * 设置属性出险终止小时
     * @param damageEndHour 待设置的属性出险终止小时的值
     */
    public void setDamageEndHour(String damageEndHour){
        this.damageEndHour = StringUtils.rightTrim(damageEndHour);
    }

    /**
     * 获取属性出险终止小时
     * @return 属性出险终止小时的值
     */
    public String getDamageEndHour(){
        return damageEndHour;
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
     * 设置属性出险区域名称
     * @param damageAreaName 待设置的属性出险区域名称的值
     */
    public void setDamageAreaName(String damageAreaName){
        this.damageAreaName = StringUtils.rightTrim(damageAreaName);
    }

    /**
     * 获取属性出险区域名称
     * @return 属性出险区域名称的值
     */
    public String getDamageAreaName(){
        return damageAreaName;
    }

    /**
     * 设置属性出险地点分类代码
     * @param damageAddressType 待设置的属性出险地点分类代码的值
     */
    public void setDamageAddressType(String damageAddressType){
        this.damageAddressType = StringUtils.rightTrim(damageAddressType);
    }

    /**
     * 获取属性出险地点分类代码
     * @return 属性出险地点分类代码的值
     */
    public String getDamageAddressType(){
        return damageAddressType;
    }

    /**
     * 设置属性地址编码
     * @param addressCode 待设置的属性地址编码的值
     */
    public void setAddressCode(String addressCode){
        this.addressCode = StringUtils.rightTrim(addressCode);
    }

    /**
     * 获取属性地址编码
     * @return 属性地址编码的值
     */
    public String getAddressCode(){
        return addressCode;
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
     * 设置属性受损标的
     * @param lossName 待设置的属性受损标的的值
     */
    public void setLossName(String lossName){
        this.lossName = StringUtils.rightTrim(lossName);
    }

    /**
     * 获取属性受损标的
     * @return 属性受损标的的值
     */
    public String getLossName(){
        return lossName;
    }

    /**
     * 设置属性受损标的数量/出险分户数
     * @param lossQuantity 待设置的属性受损标的数量/出险分户数的值
     */
    public void setLossQuantity(int lossQuantity){
        this.lossQuantity = lossQuantity;
    }

    /**
     * 获取属性受损标的数量/出险分户数
     * @return 属性受损标的数量/出险分户数的值
     */
    public int getLossQuantity(){
        return lossQuantity;
    }

    /**
     * 设置属性出险险别
     * @param damageKind 待设置的属性出险险别的值
     */
    public void setDamageKind(String damageKind){
        this.damageKind = StringUtils.rightTrim(damageKind);
    }

    /**
     * 获取属性出险险别
     * @return 属性出险险别的值
     */
    public String getDamageKind(){
        return damageKind;
    }

    /**
     * 设置属性立案日期
     * @param claimDate 待设置的属性立案日期的值
     */
    public void setClaimDate(DateTime claimDate){
        this.claimDate = claimDate;
    }

    /**
     * 获取属性立案日期
     * @return 属性立案日期的值
     */
    public DateTime getClaimDate(){
        return claimDate;
    }

    /**
     * 设置属性赔偿责任代码--** 全部/主要/对等/次要/无责任
     * @param indemnityDuty 待设置的属性赔偿责任代码--** 全部/主要/对等/次要/无责任的值
     */
    public void setIndemnityDuty(String indemnityDuty){
        this.indemnityDuty = StringUtils.rightTrim(indemnityDuty);
    }

    /**
     * 获取属性赔偿责任代码--** 全部/主要/对等/次要/无责任
     * @return 属性赔偿责任代码--** 全部/主要/对等/次要/无责任的值
     */
    public String getIndemnityDuty(){
        return indemnityDuty;
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
     * 设置属性保险损失金额(同保单币别)
     * @param sumClaim 待设置的属性保险损失金额(同保单币别)的值
     */
    public void setSumClaim(double sumClaim){
        this.sumClaim = sumClaim;
    }

    /**
     * 获取属性保险损失金额(同保单币别)
     * @return 属性保险损失金额(同保单币别)的值
     */
    public double getSumClaim(){
        return sumClaim;
    }

    /**
     * 设置属性总核定损金额(同保单币别)
     * @param sumDefLoss 待设置的属性总核定损金额(同保单币别)的值
     */
    public void setSumDefLoss(double sumDefLoss){
        this.sumDefLoss = sumDefLoss;
    }

    /**
     * 获取属性总核定损金额(同保单币别)
     * @return 属性总核定损金额(同保单币别)的值
     */
    public double getSumDefLoss(){
        return sumDefLoss;
    }

    /**
     * 设置属性总赔付金额(同保单币别)--** (实赔+预赔)
     * @param sumPaid 待设置的属性总赔付金额(同保单币别)--** (实赔+预赔)的值
     */
    public void setSumPaid(double sumPaid){
        this.sumPaid = sumPaid;
    }

    /**
     * 获取属性总赔付金额(同保单币别)--** (实赔+预赔)
     * @return 属性总赔付金额(同保单币别)--** (实赔+预赔)的值
     */
    public double getSumPaid(){
        return sumPaid;
    }

    /**
     * 设置属性总追偿金额(同保单币别)
     * @param sumReplevy 待设置的属性总追偿金额(同保单币别)的值
     */
    public void setSumReplevy(double sumReplevy){
        this.sumReplevy = sumReplevy;
    }

    /**
     * 获取属性总追偿金额(同保单币别)
     * @return 属性总追偿金额(同保单币别)的值
     */
    public double getSumReplevy(){
        return sumReplevy;
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
     * 设置属性案件性质--** 赔付/注销/拒赔
     * @param caseType 待设置的属性案件性质--** 赔付/注销/拒赔的值
     */
    public void setCaseType(String caseType){
        this.caseType = StringUtils.rightTrim(caseType);
    }

    /**
     * 获取属性案件性质--** 赔付/注销/拒赔
     * @return 属性案件性质--** 赔付/注销/拒赔的值
     */
    public String getCaseType(){
        return caseType;
    }

    /**
     * 设置属性理赔登记机构代码
     * @param makeCom 待设置的属性理赔登记机构代码的值
     */
    public void setMakeCom(String makeCom){
        this.makeCom = StringUtils.rightTrim(makeCom);
    }

    /**
     * 获取属性理赔登记机构代码
     * @return 属性理赔登记机构代码的值
     */
    public String getMakeCom(){
        return makeCom;
    }

    /**
     * 设置属性业务归属机构代码
     * @param comCode 待设置的属性业务归属机构代码的值
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * 获取属性业务归属机构代码
     * @return 属性业务归属机构代码的值
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * 设置属性代理人代码
     * @param agentCode 待设置的属性代理人代码的值
     */
    public void setAgentCode(String agentCode){
        this.agentCode = StringUtils.rightTrim(agentCode);
    }

    /**
     * 获取属性代理人代码
     * @return 属性代理人代码的值
     */
    public String getAgentCode(){
        return agentCode;
    }

    /**
     * 设置属性经办人代码
     * @param handlerCode 待设置的属性经办人代码的值
     */
    public void setHandlerCode(String handlerCode){
        this.handlerCode = StringUtils.rightTrim(handlerCode);
    }

    /**
     * 获取属性经办人代码
     * @return 属性经办人代码的值
     */
    public String getHandlerCode(){
        return handlerCode;
    }

    /**
     * 设置属性归属业务员代码
     * @param handler1Code 待设置的属性归属业务员代码的值
     */
    public void setHandler1Code(String handler1Code){
        this.handler1Code = StringUtils.rightTrim(handler1Code);
    }

    /**
     * 获取属性归属业务员代码
     * @return 属性归属业务员代码的值
     */
    public String getHandler1Code(){
        return handler1Code;
    }

    /**
     * 设置属性统计年月
     * @param statisticsYM 待设置的属性统计年月的值
     */
    public void setStatisticsYM(DateTime statisticsYM){
        this.statisticsYM = statisticsYM;
    }

    /**
     * 获取属性统计年月
     * @return 属性统计年月的值
     */
    public DateTime getStatisticsYM(){
        return statisticsYM;
    }

    /**
     * 设置属性操作员代码
     * @param operatorCode 待设置的属性操作员代码的值
     */
    public void setOperatorCode(String operatorCode){
        this.operatorCode = StringUtils.rightTrim(operatorCode);
    }

    /**
     * 获取属性操作员代码
     * @return 属性操作员代码的值
     */
    public String getOperatorCode(){
        return operatorCode;
    }

    /**
     * 设置属性计算机输单日期
     * @param inputDate 待设置的属性计算机输单日期的值
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * 获取属性计算机输单日期
     * @return 属性计算机输单日期的值
     */
    public DateTime getInputDate(){
        return inputDate;
    }

    /**
     * 设置属性结案日期
     * @param endCaseDate 待设置的属性结案日期的值
     */
    public void setEndCaseDate(DateTime endCaseDate){
        this.endCaseDate = endCaseDate;
    }

    /**
     * 获取属性结案日期
     * @return 属性结案日期的值
     */
    public DateTime getEndCaseDate(){
        return endCaseDate;
    }

    /**
     * 设置属性结案员代码
     * @param endCaserCode 待设置的属性结案员代码的值
     */
    public void setEndCaserCode(String endCaserCode){
        this.endCaserCode = StringUtils.rightTrim(endCaserCode);
    }

    /**
     * 获取属性结案员代码
     * @return 属性结案员代码的值
     */
    public String getEndCaserCode(){
        return endCaserCode;
    }

    /**
     * 设置属性注销/拒赔日期
     * @param cancelDate 待设置的属性注销/拒赔日期的值
     */
    public void setCancelDate(DateTime cancelDate){
        this.cancelDate = cancelDate;
    }

    /**
     * 获取属性注销/拒赔日期
     * @return 属性注销/拒赔日期的值
     */
    public DateTime getCancelDate(){
        return cancelDate;
    }

    /**
     * 设置属性注销/拒赔原因
     * @param cancelReason 待设置的属性注销/拒赔原因的值
     */
    public void setCancelReason(String cancelReason){
        this.cancelReason = StringUtils.rightTrim(cancelReason);
    }

    /**
     * 获取属性注销/拒赔原因
     * @return 属性注销/拒赔原因的值
     */
    public String getCancelReason(){
        return cancelReason;
    }

    /**
     * 设置属性注销/拒赔人代码
     * @param dealerCode 待设置的属性注销/拒赔人代码的值
     */
    public void setDealerCode(String dealerCode){
        this.dealerCode = StringUtils.rightTrim(dealerCode);
    }

    /**
     * 获取属性注销/拒赔人代码
     * @return 属性注销/拒赔人代码的值
     */
    public String getDealerCode(){
        return dealerCode;
    }

    /**
     * 设置属性是否为逃逸案
     * @param escapeFlag 待设置的属性是否为逃逸案的值
     */
    public void setEscapeFlag(String escapeFlag){
        this.escapeFlag = StringUtils.rightTrim(escapeFlag);
    }

    /**
     * 获取属性是否为逃逸案
     * @return 属性是否为逃逸案的值
     */
    public String getEscapeFlag(){
        return escapeFlag;
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
     * 设置属性是否可能有追偿
     * @param replevyFlag 待设置的属性是否可能有追偿的值
     */
    public void setReplevyFlag(String replevyFlag){
        this.replevyFlag = StringUtils.rightTrim(replevyFlag);
    }

    /**
     * 获取属性是否可能有追偿
     * @return 属性是否可能有追偿的值
     */
    public String getReplevyFlag(){
        return replevyFlag;
    }

    /**
     * 设置属性是否有其他理赔中介机构
     * @param thirdComFlag 待设置的属性是否有其他理赔中介机构的值
     */
    public void setThirdComFlag(String thirdComFlag){
        this.thirdComFlag = StringUtils.rightTrim(thirdComFlag);
    }

    /**
     * 获取属性是否有其他理赔中介机构
     * @return 属性是否有其他理赔中介机构的值
     */
    public String getThirdComFlag(){
        return thirdComFlag;
    }

    /**
     * 设置属性是否自动结案
     * @param endCaseFlag 待设置的属性是否自动结案的值
     */
    public void setEndCaseFlag(String endCaseFlag){
        this.endCaseFlag = StringUtils.rightTrim(endCaseFlag);
    }

    /**
     * 获取属性是否自动结案
     * @return 属性是否自动结案的值
     */
    public String getEndCaseFlag(){
        return endCaseFlag;
    }

    /**
     * 设置属性计算书责任比例
     * @param cIndemnityDutyRate 待设置的属性计算书责任比例的值
     */
    public void setCIndemnityDutyRate(double cIndemnityDutyRate){
        this.cIndemnityDutyRate = cIndemnityDutyRate;
    }

    /**
     * 获取属性计算书责任比例
     * @return 属性计算书责任比例的值
     */
    public double getCIndemnityDutyRate(){
        return cIndemnityDutyRate;
    }

    /**
     * 设置属性出险地点邮政编码
     * @param damageAreaPostCode 待设置的属性出险地点邮政编码的值
     */
    public void setDamageAreaPostCode(String damageAreaPostCode){
        this.damageAreaPostCode = StringUtils.rightTrim(damageAreaPostCode);
    }

    /**
     * 获取属性出险地点邮政编码
     * @return 属性出险地点邮政编码的值
     */
    public String getDamageAreaPostCode(){
        return damageAreaPostCode;
    }

    /**
     * 设置属性巨灾一级代码
     * @param catastropheCode1 待设置的属性巨灾一级代码的值
     */
    public void setCatastropheCode1(String catastropheCode1){
        this.catastropheCode1 = StringUtils.rightTrim(catastropheCode1);
    }

    /**
     * 获取属性巨灾一级代码
     * @return 属性巨灾一级代码的值
     */
    public String getCatastropheCode1(){
        return catastropheCode1;
    }

    /**
     * 设置属性巨灾一级名称
     * @param catastropheName1 待设置的属性巨灾一级名称的值
     */
    public void setCatastropheName1(String catastropheName1){
        this.catastropheName1 = StringUtils.rightTrim(catastropheName1);
    }

    /**
     * 获取属性巨灾一级名称
     * @return 属性巨灾一级名称的值
     */
    public String getCatastropheName1(){
        return catastropheName1;
    }

    /**
     * 设置属性巨灾二级代码
     * @param catastropheCode2 待设置的属性巨灾二级代码的值
     */
    public void setCatastropheCode2(String catastropheCode2){
        this.catastropheCode2 = StringUtils.rightTrim(catastropheCode2);
    }

    /**
     * 获取属性巨灾二级代码
     * @return 属性巨灾二级代码的值
     */
    public String getCatastropheCode2(){
        return catastropheCode2;
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
     * 设置属性巨灾二级名称
     * @param catastropheName2 待设置的属性巨灾二级名称的值
     */
    public void setCatastropheName2(String catastropheName2){
        this.catastropheName2 = StringUtils.rightTrim(catastropheName2);
    }

    /**
     * 获取属性巨灾二级名称
     * @return 属性巨灾二级名称的值
     */
    public String getCatastropheName2(){
        return catastropheName2;
    }
    
    /**
     * 设置属性立案日期
     * @param claimDate 待设置的属性立案日期的值
     */
    public void setClaimTime(DateTime claimTime){
        this.claimTime = claimTime;
    }

    /**
     * 获取属性立案日期
     * @return 属性立案日期的值
     */
    public DateTime getClaimTime(){
        return claimTime;
    }
}
