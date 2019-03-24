package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpphead批改信息表的数据传输对象基类<br>
 * 创建于 2004-11-22 15:24:12.687<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpPheadDtoBase implements Serializable{
    /** 属性批单号码 */
    private String endorseNo = "";
    /** 属性保单号码 */
    private String policyNo = "";
    /** 属性批单印刷号 */
    private String printNo = "";
    /** 属性险类代码 */
    private String classCode = "";
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性保单批改次数 */
    private int endorseTimes = 0;
    /** 属性出单机构代码 */
    private String makeCom = "";
    /** 属性赔款计算书号 */
    private String compensateNo = "";
    /** 属性被保险人代码 */
    private String insuredCode = "";
    /** 属性被保险人姓名 */
    private String insuredName = "";
    /** 属性中/英文 */
    private String language = "";
    /** 属性保单类型 */
    private String policyType = "";
    /** 属性批改类型 */
    private String endorType = "";
    /** 属性批改日期 */
    private DateTime endorDate = new DateTime();
    /** 属性生效日期 */
    private DateTime validDate = new DateTime();
    /** 属性生效小时 */
    private int validHour = 0;
    /** 属性经办人代码 */
    private String handlerCode = "";
    /** 属性归属业务员代码 */
    private String handler1Code = "";
    /** 属性复核人代码 */
    private String approverCode = "";
    /** 属性最终核批人代码 */
    private String underWriteCode = "";
    /** 属性最终核批人名称 */
    private String underWriteName = "";
    /** 属性操作员代码 */
    private String operatorCode = "";
    /** 属性计算机输单日期 */
    private DateTime inputDate = new DateTime();
    /** 属性计算机输单小时 */
    private int inputHour = 0;
    /** 属性业务归属机构代码 */
    private String comCode = "";
    /** 属性代理人代码 */
    private String agentCode = "";
    /** 属性批单统计年月 */
    private DateTime statisticsYM = new DateTime();
    /** 属性核批完成日期 */
    private DateTime underWriteEndDate = new DateTime();
    /** 属性核批标志 */
    private String underWriteFlag = "";
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpPheadDtoBase对象
     */
    public PrpPheadDtoBase(){
    }

    /**
     * 设置属性批单号码
     * @param endorseNo 待设置的属性批单号码的值
     */
    public void setEndorseNo(String endorseNo){
        this.endorseNo = StringUtils.rightTrim(endorseNo);
    }

    /**
     * 获取属性批单号码
     * @return 属性批单号码的值
     */
    public String getEndorseNo(){
        return endorseNo;
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
     * 设置属性批单印刷号
     * @param printNo 待设置的属性批单印刷号的值
     */
    public void setPrintNo(String printNo){
        this.printNo = StringUtils.rightTrim(printNo);
    }

    /**
     * 获取属性批单印刷号
     * @return 属性批单印刷号的值
     */
    public String getPrintNo(){
        return printNo;
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
     * 设置属性保单批改次数
     * @param endorseTimes 待设置的属性保单批改次数的值
     */
    public void setEndorseTimes(int endorseTimes){
        this.endorseTimes = endorseTimes;
    }

    /**
     * 获取属性保单批改次数
     * @return 属性保单批改次数的值
     */
    public int getEndorseTimes(){
        return endorseTimes;
    }

    /**
     * 设置属性出单机构代码
     * @param makeCom 待设置的属性出单机构代码的值
     */
    public void setMakeCom(String makeCom){
        this.makeCom = StringUtils.rightTrim(makeCom);
    }

    /**
     * 获取属性出单机构代码
     * @return 属性出单机构代码的值
     */
    public String getMakeCom(){
        return makeCom;
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
     * 设置属性被保险人姓名
     * @param insuredName 待设置的属性被保险人姓名的值
     */
    public void setInsuredName(String insuredName){
        this.insuredName = StringUtils.rightTrim(insuredName);
    }

    /**
     * 获取属性被保险人姓名
     * @return 属性被保险人姓名的值
     */
    public String getInsuredName(){
        return insuredName;
    }

    /**
     * 设置属性中/英文
     * @param language 待设置的属性中/英文的值
     */
    public void setLanguage(String language){
        this.language = StringUtils.rightTrim(language);
    }

    /**
     * 获取属性中/英文
     * @return 属性中/英文的值
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
     * 设置属性批改类型
     * @param endorType 待设置的属性批改类型的值
     */
    public void setEndorType(String endorType){
        this.endorType = StringUtils.rightTrim(endorType);
    }

    /**
     * 获取属性批改类型
     * @return 属性批改类型的值
     */
    public String getEndorType(){
        return endorType;
    }

    /**
     * 设置属性批改日期
     * @param endorDate 待设置的属性批改日期的值
     */
    public void setEndorDate(DateTime endorDate){
        this.endorDate = endorDate;
    }

    /**
     * 获取属性批改日期
     * @return 属性批改日期的值
     */
    public DateTime getEndorDate(){
        return endorDate;
    }

    /**
     * 设置属性生效日期
     * @param validDate 待设置的属性生效日期的值
     */
    public void setValidDate(DateTime validDate){
        this.validDate = validDate;
    }

    /**
     * 获取属性生效日期
     * @return 属性生效日期的值
     */
    public DateTime getValidDate(){
        return validDate;
    }

    /**
     * 设置属性生效小时
     * @param validHour 待设置的属性生效小时的值
     */
    public void setValidHour(int validHour){
        this.validHour = validHour;
    }

    /**
     * 获取属性生效小时
     * @return 属性生效小时的值
     */
    public int getValidHour(){
        return validHour;
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
     * 设置属性复核人代码
     * @param approverCode 待设置的属性复核人代码的值
     */
    public void setApproverCode(String approverCode){
        this.approverCode = StringUtils.rightTrim(approverCode);
    }

    /**
     * 获取属性复核人代码
     * @return 属性复核人代码的值
     */
    public String getApproverCode(){
        return approverCode;
    }

    /**
     * 设置属性最终核批人代码
     * @param underWriteCode 待设置的属性最终核批人代码的值
     */
    public void setUnderWriteCode(String underWriteCode){
        this.underWriteCode = StringUtils.rightTrim(underWriteCode);
    }

    /**
     * 获取属性最终核批人代码
     * @return 属性最终核批人代码的值
     */
    public String getUnderWriteCode(){
        return underWriteCode;
    }

    /**
     * 设置属性最终核批人名称
     * @param underWriteName 待设置的属性最终核批人名称的值
     */
    public void setUnderWriteName(String underWriteName){
        this.underWriteName = StringUtils.rightTrim(underWriteName);
    }

    /**
     * 获取属性最终核批人名称
     * @return 属性最终核批人名称的值
     */
    public String getUnderWriteName(){
        return underWriteName;
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
     * 设置属性计算机输单小时
     * @param inputHour 待设置的属性计算机输单小时的值
     */
    public void setInputHour(int inputHour){
        this.inputHour = inputHour;
    }

    /**
     * 获取属性计算机输单小时
     * @return 属性计算机输单小时的值
     */
    public int getInputHour(){
        return inputHour;
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
     * 设置属性批单统计年月
     * @param statisticsYM 待设置的属性批单统计年月的值
     */
    public void setStatisticsYM(DateTime statisticsYM){
        this.statisticsYM = statisticsYM;
    }

    /**
     * 获取属性批单统计年月
     * @return 属性批单统计年月的值
     */
    public DateTime getStatisticsYM(){
        return statisticsYM;
    }

    /**
     * 设置属性核批完成日期
     * @param underWriteEndDate 待设置的属性核批完成日期的值
     */
    public void setUnderWriteEndDate(DateTime underWriteEndDate){
        this.underWriteEndDate = underWriteEndDate;
    }

    /**
     * 获取属性核批完成日期
     * @return 属性核批完成日期的值
     */
    public DateTime getUnderWriteEndDate(){
        return underWriteEndDate;
    }

    /**
     * 设置属性核批标志
     * @param underWriteFlag 待设置的属性核批标志的值
     */
    public void setUnderWriteFlag(String underWriteFlag){
        this.underWriteFlag = StringUtils.rightTrim(underWriteFlag);
    }

    /**
     * 获取属性核批标志
     * @return 属性核批标志的值
     */
    public String getUnderWriteFlag(){
        return underWriteFlag;
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
