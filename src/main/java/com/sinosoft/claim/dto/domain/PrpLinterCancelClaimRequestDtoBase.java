package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是立案注销传入参主数的数据传输对象基类<br>
 */
public class PrpLinterCancelClaimRequestDtoBase extends PrpLinterRequestDto implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性主键id PK */
    private String id = "";
    /** 属性客户端主键 */
    private String outId = "";
    /** 属性客户端报案流水号 */
    private String outRegistNo = "";
    /** 属性保单号 */
    private String policyNo = "";
    /** 属性报案号 */
    private String registNo = "";
    /** 属性立案号 */
    private String claimNo = "";
    /** 属性事故日期(yyyy-mm-dd) */
    private DateTime damageStartDate = new DateTime();
    /** 属性事故时分(00:00) */
    private String damageStartHour = "";
    /** 属性事故原因 */
    private String damageCode = "";
    /** 属性报案人 */
    private String reportorName = "";
    /** 属性报案时间(yyyy-mm-dd) */
    private DateTime reportDate = new DateTime();
    /** 属性报案时分(00:00) */
    private String reportHour = "";
    /** 属性报案方式 */
    private String reportType = "";
    /** 属性联系人 */
    private String linkerName = "";
    /** 属性联系电话 */
    private String phoneNumber = "";
    /** 属性联系地址 */
    private String linkerAddress = "";
    /** 属性与事故者关系 */
    private String clauseType = "";
    /** 属性事故地点 */
    private String damageAddress = "";
    /** 属性事故类型 */
    private String damageTypeCode = "";
    /** 属性赔付人次, 默认为0 */
    private double lossesNumber = 0D;
    /** 属性操作人代码 */
    private String operatorCode = "";
    /** 属性操作人名称 */
    private String operatorName = "";
    /** 属性理赔处理机构 */
    private String makeCom = "";
    /** 属性理赔处理机构名称 */
    private String makeComName = "";
    /** 属性输入时间 */
    private DateTime inputDate = new DateTime();
    /** 属性报案备忘录 */
    private String remark = "";
    /** 属性事故经过及其事故者现状 */
    private String context = "";
    /** 属性注销时间 */
    private DateTime cancelDate = new DateTime();
    /** 属性注销人代码 */
    private String dealerCode = "";
    /** 属性注销原因 */
    private String cancelContext = "";
    /** 属性注销/拒赔标志 */
    private String caseType = "";
    /** 属性注销/拒赔原因 */
    private String cancelReson = "";
    /** 属性核赔审批片语 */
    private String notion = "";
    /** 属性核赔签署审批意见 */
    private String handleText = "";

    /**
     *  默认构造方法,构造一个默认的PrpLinterCancelClaimRequestDtoBase对象
     */
    public PrpLinterCancelClaimRequestDtoBase(){
    }

    /**
     * 设置属性主键id PK
     * @param id 待设置的属性主键id PK的值
     */
    public void setId(String id){
        this.id = StringUtils.rightTrim(id);
    }

    /**
     * 获取属性主键id PK
     * @return 属性主键id PK的值
     */
    public String getId(){
        return id;
    }

    /**
     * 设置属性客户端主键
     * @param outId 待设置的属性客户端主键的值
     */
    public void setOutId(String outId){
        this.outId = StringUtils.rightTrim(outId);
    }

    /**
     * 获取属性客户端主键
     * @return 属性客户端主键的值
     */
    public String getOutId(){
        return outId;
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
    public String getPolicyno(){
        return policyNo;
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
     * 设置属性事故日期(yyyy-mm-dd)
     * @param damageStartDate 待设置的属性事故日期(yyyy-mm-dd)的值
     */
    public void setDamageStartDate(DateTime damageStartDate){
        this.damageStartDate = damageStartDate;
    }

    /**
     * 获取属性事故日期(yyyy-mm-dd)
     * @return 属性事故日期(yyyy-mm-dd)的值
     */
    public DateTime getDamageStartDate(){
        return damageStartDate;
    }

    /**
     * 设置属性事故时分(00:00)
     * @param damageStartHour 待设置的属性事故时分(00:00)的值
     */
    public void setDamageStartHour(String damageStartHour){
        this.damageStartHour = StringUtils.rightTrim(damageStartHour);
    }

    /**
     * 获取属性事故时分(00:00)
     * @return 属性事故时分(00:00)的值
     */
    public String getDamageStartHour(){
        return damageStartHour;
    }

    /**
     * 设置属性事故原因
     * @param damageCode 待设置的属性事故原因的值
     */
    public void setDamageCode(String damageCode){
        this.damageCode = StringUtils.rightTrim(damageCode);
    }

    /**
     * 获取属性事故原因
     * @return 属性事故原因的值
     */
    public String getDamageCode(){
        return damageCode;
    }

    /**
     * 设置属性报案人
     * @param reportorName 待设置的属性报案人的值
     */
    public void setReportorName(String reportorName){
        this.reportorName = StringUtils.rightTrim(reportorName);
    }

    /**
     * 获取属性报案人
     * @return 属性报案人的值
     */
    public String getReportorName(){
        return reportorName;
    }

    /**
     * 设置属性报案时间(yyyy-mm-dd)
     * @param reportDate 待设置的属性报案时间(yyyy-mm-dd)的值
     */
    public void setReportDate(DateTime reportDate){
        this.reportDate = reportDate;
    }

    /**
     * 获取属性报案时间(yyyy-mm-dd)
     * @return 属性报案时间(yyyy-mm-dd)的值
     */
    public DateTime getReportDate(){
        return reportDate;
    }

    /**
     * 设置属性报案时分(00:00)
     * @param reportHour 待设置的属性报案时分(00:00)的值
     */
    public void setReportHour(String reportHour){
        this.reportHour = StringUtils.rightTrim(reportHour);
    }

    /**
     * 获取属性报案时分(00:00)
     * @return 属性报案时分(00:00)的值
     */
    public String getReportHour(){
        return reportHour;
    }

    /**
     * 设置属性报案方式
     * @param reportType 待设置的属性报案方式的值
     */
    public void setReportType(String reportType){
        this.reportType = StringUtils.rightTrim(reportType);
    }

    /**
     * 获取属性报案方式
     * @return 属性报案方式的值
     */
    public String getReportType(){
        return reportType;
    }

    /**
     * 设置属性联系人
     * @param linkerName 待设置的属性联系人的值
     */
    public void setLinkerName(String linkerName){
        this.linkerName = StringUtils.rightTrim(linkerName);
    }

    /**
     * 获取属性联系人
     * @return 属性联系人的值
     */
    public String getLinkerName(){
        return linkerName;
    }

    /**
     * 设置属性联系电话
     * @param phoneNumber 待设置的属性联系电话的值
     */
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = StringUtils.rightTrim(phoneNumber);
    }

    /**
     * 获取属性联系电话
     * @return 属性联系电话的值
     */
    public String getPhoneNumber(){
        return phoneNumber;
    }

    /**
     * 设置属性联系地址
     * @param linkerAddress 待设置的属性联系地址的值
     */
    public void setLinkerAddress(String linkerAddress){
        this.linkerAddress = StringUtils.rightTrim(linkerAddress);
    }

    /**
     * 获取属性联系地址
     * @return 属性联系地址的值
     */
    public String getLinkerAddress(){
        return linkerAddress;
    }

    /**
     * 设置属性与事故者关系
     * @param clauseType 待设置的属性与事故者关系的值
     */
    public void setClauseType(String clauseType){
        this.clauseType = StringUtils.rightTrim(clauseType);
    }

    /**
     * 获取属性与事故者关系
     * @return 属性与事故者关系的值
     */
    public String getClauseType(){
        return clauseType;
    }

    /**
     * 设置属性事故地点
     * @param damageAddress 待设置的属性事故地点的值
     */
    public void setDamageAddress(String damageAddress){
        this.damageAddress = StringUtils.rightTrim(damageAddress);
    }

    /**
     * 获取属性事故地点
     * @return 属性事故地点的值
     */
    public String getDamageAddress(){
        return damageAddress;
    }

    /**
     * 设置属性事故类型
     * @param damageTypeCode 待设置的属性事故类型的值
     */
    public void setDamageTypeCode(String damageTypeCode){
        this.damageTypeCode = StringUtils.rightTrim(damageTypeCode);
    }

    /**
     * 获取属性事故类型
     * @return 属性事故类型的值
     */
    public String getDamageTypeCode(){
        return damageTypeCode;
    }

    /**
     * 设置属性赔付人次, 默认为0
     * @param lossesNumber 待设置的属性赔付人次, 默认为0的值
     */
    public void setLossesNumber(double lossesNumber){
        this.lossesNumber = lossesNumber;
    }

    /**
     * 获取属性赔付人次, 默认为0
     * @return 属性赔付人次, 默认为0的值
     */
    public double getLossesNumber(){
        return lossesNumber;
    }

    /**
     * 设置属性操作人代码
     * @param operatorCode 待设置的属性操作人代码的值
     */
    public void setOperatorCode(String operatorCode){
        this.operatorCode = StringUtils.rightTrim(operatorCode);
    }

    /**
     * 获取属性操作人代码
     * @return 属性操作人代码的值
     */
    public String getOperatorCode(){
        return operatorCode;
    }

    /**
     * 设置属性操作人名称
     * @param operatorName 待设置的属性操作人名称的值
     */
    public void setOperatorName(String operatorName){
        this.operatorName = StringUtils.rightTrim(operatorName);
    }

    /**
     * 获取属性操作人名称
     * @return 属性操作人名称的值
     */
    public String getOperatorName(){
        return operatorName;
    }

    /**
     * 设置属性理赔处理机构
     * @param makeCom 待设置的属性理赔处理机构的值
     */
    public void setMakeCom(String makeCom){
        this.makeCom = StringUtils.rightTrim(makeCom);
    }

    /**
     * 获取属性理赔处理机构
     * @return 属性理赔处理机构的值
     */
    public String getMakeCom(){
        return makeCom;
    }

    /**
     * 设置属性理赔处理机构名称
     * @param makeComName 待设置的属性理赔处理机构名称的值
     */
    public void setMakeComName(String makeComName){
        this.makeComName = StringUtils.rightTrim(makeComName);
    }

    /**
     * 获取属性理赔处理机构名称
     * @return 属性理赔处理机构名称的值
     */
    public String getMakeComName(){
        return makeComName;
    }

    /**
     * 设置属性输入时间
     * @param inputDate 待设置的属性输入时间的值
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * 获取属性输入时间
     * @return 属性输入时间的值
     */
    public DateTime getInputDate(){
        return inputDate;
    }

    /**
     * 设置属性报案备忘录
     * @param remark 待设置的属性报案备忘录的值
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * 获取属性报案备忘录
     * @return 属性报案备忘录的值
     */
    public String getRemark(){
        return remark;
    }

    /**
     * 设置属性事故经过及其事故者现状
     * @param context 待设置的属性事故经过及其事故者现状的值
     */
    public void setContext(String context){
        this.context = StringUtils.rightTrim(context);
    }

    /**
     * 获取属性事故经过及其事故者现状
     * @return 属性事故经过及其事故者现状的值
     */
    public String getContext(){
        return context;
    }

    /**
     * 设置属性注销时间
     * @param cancelDate 待设置的属性注销时间的值
     */
    public void setCancelDate(DateTime cancelDate){
        this.cancelDate = cancelDate;
    }

    /**
     * 获取属性注销时间
     * @return 属性注销时间的值
     */
    public DateTime getCancelDate(){
        return cancelDate;
    }

    /**
     * 设置属性注销人代码
     * @param dealerCode 待设置的属性注销人代码的值
     */
    public void setDealerCode(String dealerCode){
        this.dealerCode = StringUtils.rightTrim(dealerCode);
    }

    /**
     * 获取属性注销人代码
     * @return 属性注销人代码的值
     */
    public String getDealerCode(){
        return dealerCode;
    }

    /**
     * 设置属性注销原因
     * @param cancelContext 待设置的属性注销原因的值
     */
    public void setCancelContext(String cancelContext){
        this.cancelContext = StringUtils.rightTrim(cancelContext);
    }

    /**
     * 获取属性注销原因
     * @return 属性注销原因的值
     */
    public String getCancelContext(){
        return cancelContext;
    }

	public String getOutRegistNo() {
		return outRegistNo;
	}

	public void setOutRegistNo(String outRegistNo) {
		this.outRegistNo = outRegistNo;
	}

	public String getCaseType() {
		return caseType;
	}

	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}

	public String getCancelReson() {
		return cancelReson;
	}

	public void setCancelReson(String cancelReson) {
		this.cancelReson = cancelReson;
	}

	public String getNotion() {
		return notion;
	}

	public void setNotion(String notion) {
		this.notion = notion;
	}

	public String getHandleText() {
		return handleText;
	}

	public void setHandleText(String handleText) {
		this.handleText = handleText;
	}

}
