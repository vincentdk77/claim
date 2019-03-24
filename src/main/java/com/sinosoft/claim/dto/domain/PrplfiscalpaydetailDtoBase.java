package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPLFISCALPAYDETAIL的数据传输对象基类<br>
 */
public class PrplfiscalpaydetailDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性财政打卡文件清单号 */
    private String fiscalno = "";
    /** 属性序号 */
    private String serialno = "";
    /** 属性报案号 */
    private String registno = "";
    /** 属性险类 */
    private String classcode = "";
    /** 属性险种 */
    private String riskcode = "";
    /** 属性保单号 */
    private String policyno = "";
    /** 属性立案号 */
    private String claimno = "";
    /** 属性计算书号 */
    private String compensateno = "";
    /** 属性收付原因 */
    private String paymenttype = "";
    /** 属性支付类型 */
    private String paytype = "";
    /** 属性领款人名称 */
    private String receiverfullname = "";
    /** 属性身份证号 */
    private String identifynumber = "";
    /** 属性农户代码 */
    private String insuredcode = "";
    /** 属性计算书总金额 */
    private double sumamount = 0D;
    /** 属性本次支付金额 */
    private double payamount = 0D;
    /** 属性银行大类 */
    private String banktype = "";
    /** 属性开户支行 */
    private String bank = "";
    /** 属性账号属性 */
    private String accounttype = "";
    /** 属性手机号码 */
    private String mobilephone = "";
    /** 属性支付说明 */
    private String payremark = "";
    /** 属性银行账号 */
    private String bankaccount = "";
    /** 属性VFLAG */
    private String vflag = "";
    /** 属性省 */
    private String provincename = "";
    /** 属性市 */
    private String cityname = "";
    /** 属性账号类型 */
    private String accountflag = "";
    /** 属性支付行号 */
    private String routenum = "";
    /** 机构*/
    private String comcode = "";

    /**
     *  默认构造方法,构造一个默认的PrplfiscalpaydetailDtoBase对象
     */
    public PrplfiscalpaydetailDtoBase(){
    }

    /**
     * 设置属性财政打卡文件清单号
     * @param fiscalno 待设置的属性财政打卡文件清单号的值
     */
    public void setFiscalno(String fiscalno){
        this.fiscalno = StringUtils.rightTrim(fiscalno);
    }

    /**
     * 获取属性财政打卡文件清单号
     * @return 属性财政打卡文件清单号的值
     */
    public String getFiscalno(){
        return fiscalno;
    }

    /**
     * 设置属性序号
     * @param serialno 待设置的属性序号的值
     */
    public void setSerialno(String serialno){
        this.serialno = StringUtils.rightTrim(serialno);
    }

    /**
     * 获取属性序号
     * @return 属性序号的值
     */
    public String getSerialno(){
        return serialno;
    }

    /**
     * 设置属性报案号
     * @param registno 待设置的属性报案号的值
     */
    public void setRegistno(String registno){
        this.registno = StringUtils.rightTrim(registno);
    }

    /**
     * 获取属性报案号
     * @return 属性报案号的值
     */
    public String getRegistno(){
        return registno;
    }

    /**
     * 设置属性险类
     * @param classcode 待设置的属性险类的值
     */
    public void setClasscode(String classcode){
        this.classcode = StringUtils.rightTrim(classcode);
    }

    /**
     * 获取属性险类
     * @return 属性险类的值
     */
    public String getClasscode(){
        return classcode;
    }

    /**
     * 设置属性险种
     * @param riskcode 待设置的属性险种的值
     */
    public void setRiskcode(String riskcode){
        this.riskcode = StringUtils.rightTrim(riskcode);
    }

    /**
     * 获取属性险种
     * @return 属性险种的值
     */
    public String getRiskcode(){
        return riskcode;
    }

    /**
     * 设置属性保单号
     * @param policyno 待设置的属性保单号的值
     */
    public void setPolicyno(String policyno){
        this.policyno = StringUtils.rightTrim(policyno);
    }

    /**
     * 获取属性保单号
     * @return 属性保单号的值
     */
    public String getPolicyno(){
        return policyno;
    }

    /**
     * 设置属性立案号
     * @param claimno 待设置的属性立案号的值
     */
    public void setClaimno(String claimno){
        this.claimno = StringUtils.rightTrim(claimno);
    }

    /**
     * 获取属性立案号
     * @return 属性立案号的值
     */
    public String getClaimno(){
        return claimno;
    }

    /**
     * 设置属性计算书号
     * @param compensateno 待设置的属性计算书号的值
     */
    public void setCompensateno(String compensateno){
        this.compensateno = StringUtils.rightTrim(compensateno);
    }

    /**
     * 获取属性计算书号
     * @return 属性计算书号的值
     */
    public String getCompensateno(){
        return compensateno;
    }

    /**
     * 设置属性收付原因
     * @param paymenttype 待设置的属性收付原因的值
     */
    public void setPaymenttype(String paymenttype){
        this.paymenttype = StringUtils.rightTrim(paymenttype);
    }

    /**
     * 获取属性收付原因
     * @return 属性收付原因的值
     */
    public String getPaymenttype(){
        return paymenttype;
    }

    /**
     * 设置属性支付类型
     * @param paytype 待设置的属性支付类型的值
     */
    public void setPaytype(String paytype){
        this.paytype = StringUtils.rightTrim(paytype);
    }

    /**
     * 获取属性支付类型
     * @return 属性支付类型的值
     */
    public String getPaytype(){
        return paytype;
    }

    /**
     * 设置属性领款人名称
     * @param receiverfullname 待设置的属性领款人名称的值
     */
    public void setReceiverfullname(String receiverfullname){
        this.receiverfullname = StringUtils.rightTrim(receiverfullname);
    }

    /**
     * 获取属性领款人名称
     * @return 属性领款人名称的值
     */
    public String getReceiverfullname(){
        return receiverfullname;
    }

    /**
     * 设置属性身份证号
     * @param identifynumber 待设置的属性身份证号的值
     */
    public void setIdentifynumber(String identifynumber){
        this.identifynumber = StringUtils.rightTrim(identifynumber);
    }

    /**
     * 获取属性身份证号
     * @return 属性身份证号的值
     */
    public String getIdentifynumber(){
        return identifynumber;
    }

    /**
     * 设置属性农户代码
     * @param insuredcode 待设置的属性农户代码的值
     */
    public void setInsuredcode(String insuredcode){
        this.insuredcode = StringUtils.rightTrim(insuredcode);
    }

    /**
     * 获取属性农户代码
     * @return 属性农户代码的值
     */
    public String getInsuredcode(){
        return insuredcode;
    }

    /**
     * 设置属性计算书总金额
     * @param sumamount 待设置的属性计算书总金额的值
     */
    public void setSumamount(double sumamount){
        this.sumamount = sumamount;
    }

    /**
     * 获取属性计算书总金额
     * @return 属性计算书总金额的值
     */
    public double getSumamount(){
        return sumamount;
    }

    /**
     * 设置属性本次支付金额
     * @param payamount 待设置的属性本次支付金额的值
     */
    public void setPayamount(double payamount){
        this.payamount = payamount;
    }

    /**
     * 获取属性本次支付金额
     * @return 属性本次支付金额的值
     */
    public double getPayamount(){
        return payamount;
    }

    /**
     * 设置属性银行大类
     * @param banktype 待设置的属性银行大类的值
     */
    public void setBanktype(String banktype){
        this.banktype = StringUtils.rightTrim(banktype);
    }

    /**
     * 获取属性银行大类
     * @return 属性银行大类的值
     */
    public String getBanktype(){
        return banktype;
    }

    /**
     * 设置属性开户支行
     * @param bank 待设置的属性开户支行的值
     */
    public void setBank(String bank){
        this.bank = StringUtils.rightTrim(bank);
    }

    /**
     * 获取属性开户支行
     * @return 属性开户支行的值
     */
    public String getBank(){
        return bank;
    }

    /**
     * 设置属性账号属性
     * @param accounttype 待设置的属性账号属性的值
     */
    public void setAccounttype(String accounttype){
        this.accounttype = StringUtils.rightTrim(accounttype);
    }

    /**
     * 获取属性账号属性
     * @return 属性账号属性的值
     */
    public String getAccounttype(){
        return accounttype;
    }

    /**
     * 设置属性手机号码
     * @param mobilephone 待设置的属性手机号码的值
     */
    public void setMobilephone(String mobilephone){
        this.mobilephone = StringUtils.rightTrim(mobilephone);
    }

    /**
     * 获取属性手机号码
     * @return 属性手机号码的值
     */
    public String getMobilephone(){
        return mobilephone;
    }

    /**
     * 设置属性支付说明
     * @param payremark 待设置的属性支付说明的值
     */
    public void setPayremark(String payremark){
        this.payremark = StringUtils.rightTrim(payremark);
    }

    /**
     * 获取属性支付说明
     * @return 属性支付说明的值
     */
    public String getPayremark(){
        return payremark;
    }

    /**
     * 设置属性银行账号
     * @param bankaccount 待设置的属性银行账号的值
     */
    public void setBankaccount(String bankaccount){
        this.bankaccount = StringUtils.rightTrim(bankaccount);
    }

    /**
     * 获取属性银行账号
     * @return 属性银行账号的值
     */
    public String getBankaccount(){
        return bankaccount;
    }

    /**
     * 设置属性VFLAG
     * @param vflag 待设置的属性VFLAG的值
     */
    public void setVflag(String vflag){
        this.vflag = StringUtils.rightTrim(vflag);
    }

    /**
     * 获取属性VFLAG
     * @return 属性VFLAG的值
     */
    public String getVflag(){
        return vflag;
    }

    /**
     * 设置属性省
     * @param provincename 待设置的属性省的值
     */
    public void setProvincename(String provincename){
        this.provincename = StringUtils.rightTrim(provincename);
    }

    /**
     * 获取属性省
     * @return 属性省的值
     */
    public String getProvincename(){
        return provincename;
    }

    /**
     * 设置属性市
     * @param cityname 待设置的属性市的值
     */
    public void setCityname(String cityname){
        this.cityname = StringUtils.rightTrim(cityname);
    }

    /**
     * 获取属性市
     * @return 属性市的值
     */
    public String getCityname(){
        return cityname;
    }

    /**
     * 设置属性账号类型
     * @param accountflag 待设置的属性账号类型的值
     */
    public void setAccountflag(String accountflag){
        this.accountflag = StringUtils.rightTrim(accountflag);
    }

    /**
     * 获取属性账号类型
     * @return 属性账号类型的值
     */
    public String getAccountflag(){
        return accountflag;
    }

    /**
     * 设置属性支付行号
     * @param routenum 待设置的属性支付行号的值
     */
    public void setRoutenum(String routenum){
        this.routenum = StringUtils.rightTrim(routenum);
    }

    /**
     * 获取属性支付行号
     * @return 属性支付行号的值
     */
    public String getRoutenum(){
        return routenum;
    }

	public String getComcode() {
		return comcode;
	}

	public void setComcode(String comcode) {
		this.comcode = comcode;
	}
    
}
