package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpjallocmid长期险业务保费分摊中间表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpJallocMidDtoBase implements Serializable{
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性保单号 */
    private String policyNo = "";
    /** 属性分摊号 */
    private String allocNo = "";
    /** 属性单证号 */
    private String certiNo = "";
    /** 属性序号 */
    private int serialNo = 0;
    /** 属性分摊最大序号 */
    private int allocSerialNo = 0;
    /** 属性起保日期 */
    private DateTime startDate = new DateTime();
    /** 属性终保日期 */
    private DateTime endDate = new DateTime();
    /** 属性归属机构代码 */
    private String comCode = "";
    /** 属性出单机构代码 */
    private String makeCom = "";
    /** 属性被保人代码 */
    private String insuredCode = "";
    /** 属性被保人名称 */
    private String insuredName = "";
    /** 属性代理人代码 */
    private String agentCode = "";
    /** 属性经办人代码 */
    private String handlerCode = "";
    /** 属性操作员代码 */
    private String operatorCode = "";
    /** 属性币种 */
    private String currency = "";
    /** 属性分摊类型 */
    private String allocType = "";
    /** 属性批改类型 */
    private String endorType = "";
    /** 属性承保年限 */
    private int limityear = 0;
    /** 属性分摊生效年限 */
    private int passYear = 0;
    /** 属性已分摊年限 */
    private int allocYear = 0;
    /** 属性总保费 */
    private double sumFee = 0d;
    /** 属性剩余未摊保费 */
    private double prefee = 0d;
    /** 属性本次分摊金额 */
    private double allocFee = 0d;
    /** 属性累计分摊保费（或手续费变化）金额 */
    private double valueFee = 0d;
    /** 属性分摊日期 */
    private DateTime allocDate = new DateTime();
    /** 属性登记日期 */
    private DateTime inputDate = new DateTime();
    /** 属性上次刷新变化登记日期 */
    private DateTime olddate = new DateTime();
    /** 属性*标志位 */
    private String dealFlag = "";
    /** 属性预留1 */
    private String tcol1 = "";
    /** 属性预留2 */
    private int tcol2 = 0;
    /** 属性预留3 */
    private int tcol3 = 0;

    /**
     *  默认构造方法,构造一个默认的PrpJallocMidDtoBase对象
     */
    public PrpJallocMidDtoBase(){
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
     * 设置属性分摊号
     * @param allocNo 待设置的属性分摊号的值
     */
    public void setAllocNo(String allocNo){
        this.allocNo = StringUtils.rightTrim(allocNo);
    }

    /**
     * 获取属性分摊号
     * @return 属性分摊号的值
     */
    public String getAllocNo(){
        return allocNo;
    }

    /**
     * 设置属性单证号
     * @param certiNo 待设置的属性单证号的值
     */
    public void setCertiNo(String certiNo){
        this.certiNo = StringUtils.rightTrim(certiNo);
    }

    /**
     * 获取属性单证号
     * @return 属性单证号的值
     */
    public String getCertiNo(){
        return certiNo;
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
     * 设置属性分摊最大序号
     * @param allocSerialNo 待设置的属性分摊最大序号的值
     */
    public void setAllocSerialNo(int allocSerialNo){
        this.allocSerialNo = allocSerialNo;
    }

    /**
     * 获取属性分摊最大序号
     * @return 属性分摊最大序号的值
     */
    public int getAllocSerialNo(){
        return allocSerialNo;
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
     * 设置属性归属机构代码
     * @param comCode 待设置的属性归属机构代码的值
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * 获取属性归属机构代码
     * @return 属性归属机构代码的值
     */
    public String getComCode(){
        return comCode;
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
     * 设置属性被保人代码
     * @param insuredCode 待设置的属性被保人代码的值
     */
    public void setInsuredCode(String insuredCode){
        this.insuredCode = StringUtils.rightTrim(insuredCode);
    }

    /**
     * 获取属性被保人代码
     * @return 属性被保人代码的值
     */
    public String getInsuredCode(){
        return insuredCode;
    }

    /**
     * 设置属性被保人名称
     * @param insuredName 待设置的属性被保人名称的值
     */
    public void setInsuredName(String insuredName){
        this.insuredName = StringUtils.rightTrim(insuredName);
    }

    /**
     * 获取属性被保人名称
     * @return 属性被保人名称的值
     */
    public String getInsuredName(){
        return insuredName;
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
     * 设置属性币种
     * @param currency 待设置的属性币种的值
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * 获取属性币种
     * @return 属性币种的值
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * 设置属性分摊类型
     * @param allocType 待设置的属性分摊类型的值
     */
    public void setAllocType(String allocType){
        this.allocType = StringUtils.rightTrim(allocType);
    }

    /**
     * 获取属性分摊类型
     * @return 属性分摊类型的值
     */
    public String getAllocType(){
        return allocType;
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
     * 设置属性承保年限
     * @param limityear 待设置的属性承保年限的值
     */
    public void setLimityear(int limityear){
        this.limityear = limityear;
    }

    /**
     * 获取属性承保年限
     * @return 属性承保年限的值
     */
    public int getLimityear(){
        return limityear;
    }

    /**
     * 设置属性分摊生效年限
     * @param passYear 待设置的属性分摊生效年限的值
     */
    public void setPassYear(int passYear){
        this.passYear = passYear;
    }

    /**
     * 获取属性分摊生效年限
     * @return 属性分摊生效年限的值
     */
    public int getPassYear(){
        return passYear;
    }

    /**
     * 设置属性已分摊年限
     * @param allocYear 待设置的属性已分摊年限的值
     */
    public void setAllocYear(int allocYear){
        this.allocYear = allocYear;
    }

    /**
     * 获取属性已分摊年限
     * @return 属性已分摊年限的值
     */
    public int getAllocYear(){
        return allocYear;
    }

    /**
     * 设置属性总保费
     * @param sumFee 待设置的属性总保费的值
     */
    public void setSumFee(double sumFee){
        this.sumFee = sumFee;
    }

    /**
     * 获取属性总保费
     * @return 属性总保费的值
     */
    public double getSumFee(){
        return sumFee;
    }

    /**
     * 设置属性剩余未摊保费
     * @param prefee 待设置的属性剩余未摊保费的值
     */
    public void setPrefee(double prefee){
        this.prefee = prefee;
    }

    /**
     * 获取属性剩余未摊保费
     * @return 属性剩余未摊保费的值
     */
    public double getPrefee(){
        return prefee;
    }

    /**
     * 设置属性本次分摊金额
     * @param allocFee 待设置的属性本次分摊金额的值
     */
    public void setAllocFee(double allocFee){
        this.allocFee = allocFee;
    }

    /**
     * 获取属性本次分摊金额
     * @return 属性本次分摊金额的值
     */
    public double getAllocFee(){
        return allocFee;
    }

    /**
     * 设置属性累计分摊保费（或手续费变化）金额
     * @param valueFee 待设置的属性累计分摊保费（或手续费变化）金额的值
     */
    public void setValueFee(double valueFee){
        this.valueFee = valueFee;
    }

    /**
     * 获取属性累计分摊保费（或手续费变化）金额
     * @return 属性累计分摊保费（或手续费变化）金额的值
     */
    public double getValueFee(){
        return valueFee;
    }

    /**
     * 设置属性分摊日期
     * @param allocDate 待设置的属性分摊日期的值
     */
    public void setAllocDate(DateTime allocDate){
        this.allocDate = allocDate;
    }

    /**
     * 获取属性分摊日期
     * @return 属性分摊日期的值
     */
    public DateTime getAllocDate(){
        return allocDate;
    }

    /**
     * 设置属性登记日期
     * @param inputDate 待设置的属性登记日期的值
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * 获取属性登记日期
     * @return 属性登记日期的值
     */
    public DateTime getInputDate(){
        return inputDate;
    }

    /**
     * 设置属性上次刷新变化登记日期
     * @param olddate 待设置的属性上次刷新变化登记日期的值
     */
    public void setOlddate(DateTime olddate){
        this.olddate = olddate;
    }

    /**
     * 获取属性上次刷新变化登记日期
     * @return 属性上次刷新变化登记日期的值
     */
    public DateTime getOlddate(){
        return olddate;
    }

    /**
     * 设置属性*标志位
     * @param dealFlag 待设置的属性*标志位的值
     */
    public void setDealFlag(String dealFlag){
        this.dealFlag = StringUtils.rightTrim(dealFlag);
    }

    /**
     * 获取属性*标志位
     * @return 属性*标志位的值
     */
    public String getDealFlag(){
        return dealFlag;
    }

    /**
     * 设置属性预留1
     * @param tcol1 待设置的属性预留1的值
     */
    public void setTcol1(String tcol1){
        this.tcol1 = StringUtils.rightTrim(tcol1);
    }

    /**
     * 获取属性预留1
     * @return 属性预留1的值
     */
    public String getTcol1(){
        return tcol1;
    }

    /**
     * 设置属性预留2
     * @param tcol2 待设置的属性预留2的值
     */
    public void setTcol2(int tcol2){
        this.tcol2 = tcol2;
    }

    /**
     * 获取属性预留2
     * @return 属性预留2的值
     */
    public int getTcol2(){
        return tcol2;
    }

    /**
     * 设置属性预留3
     * @param tcol3 待设置的属性预留3的值
     */
    public void setTcol3(int tcol3){
        this.tcol3 = tcol3;
    }

    /**
     * 获取属性预留3
     * @return 属性预留3的值
     */
    public int getTcol3(){
        return tcol3;
    }
}
