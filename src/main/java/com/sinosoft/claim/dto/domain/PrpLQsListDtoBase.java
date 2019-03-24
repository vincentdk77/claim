package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLQs_list清算中心通赔结算明细清单的数据传输对象基类<br>
 * 创建于 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLQsListDtoBase implements Serializable{
    /** 属性结算单批次号 */
    private String procNo = "";
    /** 属性本次结算顺序号 */
    private int serialNo = 0;
    /** 属性出险日期 */
    private DateTime damageDate = new DateTime();
    /** 属性承保地公司代码 */
    private String cbComCode = "";
    /** 属性承保地公司名称 */
    private String cbComCName = "";
    /** 属性出险地公司代码 */
    private String lpComCode = "";
    /** 属性出险地公司名称 */
    private String lpComCName = "";
    /** 属性保单号 */
    private String policyNo = "";
    /** 属性车牌号码 */
    private String licenseNo = "";
    /** 属性被保险人名称 */
    private String insuredName = "";
    /** 属性代赔赔案号 */
    private String claimAgntNo = "";
    /** 属性事件性质代码 */
    private String agntTypeCode = "";
    /** 属性赔款收据铅印号 */
    private String reciptNo = "";
    /** 属性赔款金额 */
    private double claimAgntFee = 0d;
    /** 属性实付金额 */
    private double realPayFee = 0d;
    /** 属性赔款经手人 */
    private String handlerCode = "";
    /** 属性清算日期 */
    private DateTime procDate = new DateTime();
    /** 属性清算操作员 */
    private String operatorCode = "";
    /** 属性结算单位代码 */
    private String comCode = "";
    /** 属性备注 */
    private String remark = "";
    /** 属性代码标志位 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpLQs_listDtoBase对象
     */
    public PrpLQsListDtoBase(){
    }

    /**
     * 设置属性结算单批次号
     * @param procNo 待设置的属性结算单批次号的值
     */
    public void setProcNo(String procNo){
        this.procNo = StringUtils.rightTrim(procNo);
    }

    /**
     * 获取属性结算单批次号
     * @return 属性结算单批次号的值
     */
    public String getProcNo(){
        return procNo;
    }

    /**
     * 设置属性本次结算顺序号
     * @param serialNo 待设置的属性本次结算顺序号的值
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性本次结算顺序号
     * @return 属性本次结算顺序号的值
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * 设置属性出险日期
     * @param damageDate 待设置的属性出险日期的值
     */
    public void setDamageDate(DateTime damageDate){
        this.damageDate = damageDate;
    }

    /**
     * 获取属性出险日期
     * @return 属性出险日期的值
     */
    public DateTime getDamageDate(){
        return damageDate;
    }

    /**
     * 设置属性承保地公司代码
     * @param cbComCode 待设置的属性承保地公司代码的值
     */
    public void setCbComCode(String cbComCode){
        this.cbComCode = StringUtils.rightTrim(cbComCode);
    }

    /**
     * 获取属性承保地公司代码
     * @return 属性承保地公司代码的值
     */
    public String getCbComCode(){
        return cbComCode;
    }

    /**
     * 设置属性承保地公司名称
     * @param cbComCName 待设置的属性承保地公司名称的值
     */
    public void setCbComCName(String cbComCName){
        this.cbComCName = StringUtils.rightTrim(cbComCName);
    }

    /**
     * 获取属性承保地公司名称
     * @return 属性承保地公司名称的值
     */
    public String getCbComCName(){
        return cbComCName;
    }

    /**
     * 设置属性出险地公司代码
     * @param lpComCode 待设置的属性出险地公司代码的值
     */
    public void setLpComCode(String lpComCode){
        this.lpComCode = StringUtils.rightTrim(lpComCode);
    }

    /**
     * 获取属性出险地公司代码
     * @return 属性出险地公司代码的值
     */
    public String getLpComCode(){
        return lpComCode;
    }

    /**
     * 设置属性出险地公司名称
     * @param lpComCName 待设置的属性出险地公司名称的值
     */
    public void setLpComCName(String lpComCName){
        this.lpComCName = StringUtils.rightTrim(lpComCName);
    }

    /**
     * 获取属性出险地公司名称
     * @return 属性出险地公司名称的值
     */
    public String getLpComCName(){
        return lpComCName;
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
     * 设置属性车牌号码
     * @param licenseNo 待设置的属性车牌号码的值
     */
    public void setLicenseNo(String licenseNo){
        this.licenseNo = StringUtils.rightTrim(licenseNo);
    }

    /**
     * 获取属性车牌号码
     * @return 属性车牌号码的值
     */
    public String getLicenseNo(){
        return licenseNo;
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
     * 设置属性代赔赔案号
     * @param claimAgntNo 待设置的属性代赔赔案号的值
     */
    public void setClaimAgntNo(String claimAgntNo){
        this.claimAgntNo = StringUtils.rightTrim(claimAgntNo);
    }

    /**
     * 获取属性代赔赔案号
     * @return 属性代赔赔案号的值
     */
    public String getClaimAgntNo(){
        return claimAgntNo;
    }

    /**
     * 设置属性事件性质代码
     * @param agntTypeCode 待设置的属性事件性质代码的值
     */
    public void setAgntTypeCode(String agntTypeCode){
        this.agntTypeCode = StringUtils.rightTrim(agntTypeCode);
    }

    /**
     * 获取属性事件性质代码
     * @return 属性事件性质代码的值
     */
    public String getAgntTypeCode(){
        return agntTypeCode;
    }

    /**
     * 设置属性赔款收据铅印号
     * @param reciptNo 待设置的属性赔款收据铅印号的值
     */
    public void setReciptNo(String reciptNo){
        this.reciptNo = StringUtils.rightTrim(reciptNo);
    }

    /**
     * 获取属性赔款收据铅印号
     * @return 属性赔款收据铅印号的值
     */
    public String getReciptNo(){
        return reciptNo;
    }

    /**
     * 设置属性赔款金额
     * @param claimAgntFee 待设置的属性赔款金额的值
     */
    public void setClaimAgntFee(double claimAgntFee){
        this.claimAgntFee = claimAgntFee;
    }

    /**
     * 获取属性赔款金额
     * @return 属性赔款金额的值
     */
    public double getClaimAgntFee(){
        return claimAgntFee;
    }

    /**
     * 设置属性实付金额
     * @param realPayFee 待设置的属性实付金额的值
     */
    public void setRealPayFee(double realPayFee){
        this.realPayFee = realPayFee;
    }

    /**
     * 获取属性实付金额
     * @return 属性实付金额的值
     */
    public double getRealPayFee(){
        return realPayFee;
    }

    /**
     * 设置属性赔款经手人
     * @param handlerCode 待设置的属性赔款经手人的值
     */
    public void setHandlerCode(String handlerCode){
        this.handlerCode = StringUtils.rightTrim(handlerCode);
    }

    /**
     * 获取属性赔款经手人
     * @return 属性赔款经手人的值
     */
    public String getHandlerCode(){
        return handlerCode;
    }

    /**
     * 设置属性清算日期
     * @param procDate 待设置的属性清算日期的值
     */
    public void setProcDate(DateTime procDate){
        this.procDate = procDate;
    }

    /**
     * 获取属性清算日期
     * @return 属性清算日期的值
     */
    public DateTime getProcDate(){
        return procDate;
    }

    /**
     * 设置属性清算操作员
     * @param operatorCode 待设置的属性清算操作员的值
     */
    public void setOperatorCode(String operatorCode){
        this.operatorCode = StringUtils.rightTrim(operatorCode);
    }

    /**
     * 获取属性清算操作员
     * @return 属性清算操作员的值
     */
    public String getOperatorCode(){
        return operatorCode;
    }

    /**
     * 设置属性结算单位代码
     * @param comCode 待设置的属性结算单位代码的值
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * 获取属性结算单位代码
     * @return 属性结算单位代码的值
     */
    public String getComCode(){
        return comCode;
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
     * 设置属性代码标志位
     * @param flag 待设置的属性代码标志位的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性代码标志位
     * @return 属性代码标志位的值
     */
    public String getFlag(){
        return flag;
    }
}
