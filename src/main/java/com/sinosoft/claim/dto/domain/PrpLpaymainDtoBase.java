package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是支付信息主表的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLpaymainDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性支付编号 */
    private String paymentNo = "";
    /** 属性支付类型(p1:预赔，p2:支付，p3:结案支付(原实付)，p4:垫付) */
    private String payType = "";
    /** 属性支付金额 */
    private double payAmount = 0D;
    /** 属性省份 */
    private String provinceCode = "";
    /** 属性城市 */
    private String cityCode = "";
    /** 属性银行大类 */
    private String bankType = "";
    /** 属性开户银行 */
    private String bank = "";
    /** 属性开户行明细 */
    private String bankSite = "";
    /** 属性账号类型（个人、单位） */
    private String accountType = "";
    /** 属性领款人全称 */
    private String receiverFullName = "";
    /** 属性领款人代码 */
    private String receiverFullCode = "";
    /** 属性证件类型（01：居民身份证,02：居民户口薄,04：军官证,05:士兵证,07:中国护照,51:外国护照,71:组织机构代码证,72:税务登记证,73：营业执照） */
    private String certifType = "";
    /** 属性详细地址 */
    private String address = "";
    /** 属性证件号码 */
    private String certifNo = "";
    /** 属性家庭电话 */
    private String familyPhone = "";
    /** 属性办公电话 */
    private String officePhone = "";
    /** 属性手机号 */
    private String mobilePhone = "";
    /** 属性支付说明 */
    private String payRemark = "";
    /** 属性操作员代码 */
    private String operatorCode = "";
    /** 属性输入日期 */
    private DateTime inputDate = new DateTime();
    /** 属性支付日期 */
    private DateTime payDate = new DateTime();
    /** 属性支付员代码 */
    private String payCode = "";
    /** 属性支付标志 */
    private String payFlag = "";
    /** 属性赔款类型 */
    private String paymentType = "";
    /** 属性银行账号 */
    private String bankAccount = "";
    /** 属性节点 */
    private String node = "";
    /** 属性**序号 */
    private String upLoadSerialNo = "";
    /** 属性赔付信息审核平台状态字段:空为未处理，2为正在审核，3为退回，4为通过 */
    private String vflag = "";
    /** 属性机构代码 */
    private String comCode = "";
    /** 属性合并下发标志 */
    private String mergerFlag = "";
    /** 属性总支付金额 */
    private double payTotalAmount = 0D;
    /** 属性紧急程度：30m;1h;2h;3h;4h;8h;24h;48h */
    private String urgentType = "";
    /** 属性领款人类型代码（t1:被保险人、t2:个人代理索赔、t3:单位代理索赔、t4：人民法院、t5:公估公司、t6：机构理赔人员、t7：律师事务所、t8：其他） */
    private String receiverTypeOther = "";
    /** 属性领款人类型名称（t1:被保险人、t2:个人代理索赔、t3:单位代理索赔、t4：人民法院、t5:公估公司、t6：机构理赔人员、t7：律师事务所、t8：其他） */
    private String receiverTypeOtherName = "";
    /** 属性qq号码 */
    private String qqNumber = "";
    /** 属性电子邮件 */
    private String email = "";
    /** 属性单位联系人 */
    private String unitLink = "";
    /** 属性邮政编码 */
    private String postCode = "";
    /** 属性审核方式 0 自动审核 1 人工审核 */
    private String verifyFlag = "";
    /** 属性通知单号 */
    private String noticeNo = "";
    /** 属性退回时间*/
    private DateTime backDate = new DateTime();
    /** 属性退回人*/
    private String backOperatorCode = "";
    /** 属性退回机构*/
    private String backComCode = "";
    /** 属性第三方支付标识*/
    private String thirdPayFlag = "";
    /** 属性支付方式*/
    private String payWay = "";
    /** 属性传统支付原因*/
    private String payReason = "";
    /** 属性用途说明*/
    private String payPurpose = "";
    /** 属性账号类型*/
    private String accountFlag = "";
    /** 属性接口类型 1大病即时即报*/
    private String interType = "";
    /** 属性支付行号*/
    private String routeNum = "";
    /**是否有清单标志*/
    private String billFlag;
    /** 属性第三方支付类型*/
    private String thirdPayType = "";
    /** 属性第三方支付类型*/
    private String noBillFlag = "";
    /** 属性支付渠道*/
    private String realPayWay = "";
    
    /**
     *  默认构造方法,构造一个默认的PrpLpaymainDtoBase对象
     */
    public PrpLpaymainDtoBase(){
    }

    /**
     * 设置属性支付编号
     * @param paymentNo 待设置的属性支付编号的值
     */
    public void setPaymentNo(String paymentNo){
        this.paymentNo = StringUtils.rightTrim(paymentNo);
    }

    /**
     * 获取属性支付编号
     * @return 属性支付编号的值
     */
    public String getPaymentNo(){
        return paymentNo;
    }

    /**
     * 设置属性支付类型(p1:预赔，p2:支付，p3:结案支付(原实付)，p4:垫付)
     * @param payType 待设置的属性支付类型(p1:预赔，p2:支付，p3:结案支付(原实付)，p4:垫付)的值
     */
    public void setPayType(String payType){
        this.payType = StringUtils.rightTrim(payType);
    }

    /**
     * 获取属性支付类型(p1:预赔，p2:支付，p3:结案支付(原实付)，p4:垫付)
     * @return 属性支付类型(p1:预赔，p2:支付，p3:结案支付(原实付)，p4:垫付)的值
     */
    public String getPayType(){
        return payType;
    }

    /**
     * 设置属性支付金额
     * @param payAmount 待设置的属性支付金额的值
     */
    public void setPayAmount(double payAmount){
        this.payAmount = payAmount;
    }

    /**
     * 获取属性支付金额
     * @return 属性支付金额的值
     */
    public double getPayAmount(){
        return payAmount;
    }

    /**
     * 设置属性银行大类
     * @param bankType 待设置的属性银行大类的值
     */
    public void setBankType(String bankType){
        this.bankType = StringUtils.rightTrim(bankType);
    }

    /**
     * 获取属性银行大类
     * @return 属性银行大类的值
     */
    public String getBankType(){
        return bankType;
    }

    /**
     * 设置属性开户银行
     * @param bank 待设置的属性开户银行的值
     */
    public void setBank(String bank){
        this.bank = StringUtils.rightTrim(bank);
    }

    /**
     * 获取属性开户银行
     * @return 属性开户银行的值
     */
    public String getBank(){
        return bank;
    }

    /**
     * 设置属性开户行明细
     * @param bankSite 待设置的属性开户行明细的值
     */
    public void setBankSite(String bankSite){
        this.bankSite = StringUtils.rightTrim(bankSite);
    }

    /**
     * 获取属性开户行明细
     * @return 属性开户行明细的值
     */
    public String getBankSite(){
        return bankSite;
    }

    /**
     * 设置属性账号类型（个人、单位）
     * @param accountType 待设置的属性账号类型（个人、单位）的值
     */
    public void setAccountType(String accountType){
        this.accountType = StringUtils.rightTrim(accountType);
    }

    /**
     * 获取属性账号类型（个人、单位）
     * @return 属性账号类型（个人、单位）的值
     */
    public String getAccountType(){
        return accountType;
    }

    /**
     * 设置属性领款人全称
     * @param receiverFullName 待设置的属性领款人全称的值
     */
    public void setReceiverFullName(String receiverFullName){
        this.receiverFullName = StringUtils.rightTrim(receiverFullName);
    }

    /**
     * 获取属性领款人全称
     * @return 属性领款人全称的值
     */
    public String getReceiverFullName(){
        return receiverFullName;
    }

    /**
     * 设置属性领款人代码
     * @param receiverFullCode 待设置的属性领款人代码的值
     */
    public void setReceiverFullCode(String receiverFullCode){
        this.receiverFullCode = StringUtils.rightTrim(receiverFullCode);
    }

    /**
     * 获取属性领款人代码
     * @return 属性领款人代码的值
     */
    public String getReceiverFullCode(){
        return receiverFullCode;
    }

    /**
     * 设置属性证件类型（01：居民身份证,02：居民户口薄,04：军官证,05:士兵证,07:中国护照,51:外国护照,71:组织机构代码证,72:税务登记证,73：营业执照）
     * @param certifType 待设置的属性证件类型（01：居民身份证,02：居民户口薄,04：军官证,05:士兵证,07:中国护照,51:外国护照,71:组织机构代码证,72:税务登记证,73：营业执照）的值
     */
    public void setCertifType(String certifType){
        this.certifType = StringUtils.rightTrim(certifType);
    }

    /**
     * 获取属性证件类型（01：居民身份证,02：居民户口薄,04：军官证,05:士兵证,07:中国护照,51:外国护照,71:组织机构代码证,72:税务登记证,73：营业执照）
     * @return 属性证件类型（01：居民身份证,02：居民户口薄,04：军官证,05:士兵证,07:中国护照,51:外国护照,71:组织机构代码证,72:税务登记证,73：营业执照）的值
     */
    public String getCertifType(){
        return certifType;
    }

    /**
     * 设置属性详细地址
     * @param address 待设置的属性详细地址的值
     */
    public void setAddress(String address){
        this.address = StringUtils.rightTrim(address);
    }

    /**
     * 获取属性详细地址
     * @return 属性详细地址的值
     */
    public String getAddress(){
        return address;
    }

    /**
     * 设置属性证件号码
     * @param certifNo 待设置的属性证件号码的值
     */
    public void setCertifNo(String certifNo){
        this.certifNo = StringUtils.rightTrim(certifNo);
    }

    /**
     * 获取属性证件号码
     * @return 属性证件号码的值
     */
    public String getCertifNo(){
        return certifNo;
    }

    /**
     * 设置属性家庭电话
     * @param familyPhone 待设置的属性家庭电话的值
     */
    public void setFamilyPhone(String familyPhone){
        this.familyPhone = StringUtils.rightTrim(familyPhone);
    }

    /**
     * 获取属性家庭电话
     * @return 属性家庭电话的值
     */
    public String getFamilyPhone(){
        return familyPhone;
    }

    /**
     * 设置属性办公电话
     * @param officePhone 待设置的属性办公电话的值
     */
    public void setOfficePhone(String officePhone){
        this.officePhone = StringUtils.rightTrim(officePhone);
    }

    /**
     * 获取属性办公电话
     * @return 属性办公电话的值
     */
    public String getOfficePhone(){
        return officePhone;
    }

    /**
     * 设置属性手机号
     * @param mobilePhone 待设置的属性手机号的值
     */
    public void setMobilePhone(String mobilePhone){
        this.mobilePhone = StringUtils.rightTrim(mobilePhone);
    }

    /**
     * 获取属性手机号
     * @return 属性手机号的值
     */
    public String getMobilePhone(){
        return mobilePhone;
    }

    /**
     * 设置属性支付说明
     * @param payRemark 待设置的属性支付说明的值
     */
    public void setPayRemark(String payRemark){
        this.payRemark = StringUtils.rightTrim(payRemark);
    }

    /**
     * 获取属性支付说明
     * @return 属性支付说明的值
     */
    public String getPayRemark(){
        return payRemark;
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
     * 设置属性输入日期
     * @param inputDate 待设置的属性输入日期的值
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * 获取属性输入日期
     * @return 属性输入日期的值
     */
    public DateTime getInputDate(){
        return inputDate;
    }

    /**
     * 设置属性支付日期
     * @param payDate 待设置的属性支付日期的值
     */
    public void setPayDate(DateTime payDate){
        this.payDate = payDate;
    }

    /**
     * 获取属性支付日期
     * @return 属性支付日期的值
     */
    public DateTime getPayDate(){
        return payDate;
    }

    /**
     * 设置属性支付员代码
     * @param payCode 待设置的属性支付员代码的值
     */
    public void setPayCode(String payCode){
        this.payCode = StringUtils.rightTrim(payCode);
    }

    /**
     * 获取属性支付员代码
     * @return 属性支付员代码的值
     */
    public String getPayCode(){
        return payCode;
    }

    /**
     * 设置属性支付标志
     * @param payFlag 待设置的属性支付标志的值
     */
    public void setPayFlag(String payFlag){
        this.payFlag = StringUtils.rightTrim(payFlag);
    }

    /**
     * 获取属性支付标志
     * @return 属性支付标志的值
     */
    public String getPayFlag(){
        return payFlag;
    }

    /**
     * 设置属性赔款类型
     * @param paymentType 待设置的属性赔款类型的值
     */
    public void setPaymentType(String paymentType){
        this.paymentType = StringUtils.rightTrim(paymentType);
    }

    /**
     * 获取属性赔款类型
     * @return 属性赔款类型的值
     */
    public String getPaymentType(){
        return paymentType;
    }

    /**
     * 设置属性银行账号
     * @param bankAccount 待设置的属性银行账号的值
     */
    public void setBankAccount(String bankAccount){
        this.bankAccount = StringUtils.rightTrim(bankAccount);
    }

    /**
     * 获取属性银行账号
     * @return 属性银行账号的值
     */
    public String getBankAccount(){
        return bankAccount;
    }

    /**
     * 设置属性节点
     * @param node 待设置的属性节点的值
     */
    public void setNode(String node){
        this.node = StringUtils.rightTrim(node);
    }

    /**
     * 获取属性节点
     * @return 属性节点的值
     */
    public String getNode(){
        return node;
    }

    /**
     * 设置属性**序号
     * @param upLoadSerialNo 待设置的属性**序号的值
     */
    public void setUpLoadSerialNo(String upLoadSerialNo){
        this.upLoadSerialNo = StringUtils.rightTrim(upLoadSerialNo);
    }

    /**
     * 获取属性**序号
     * @return 属性**序号的值
     */
    public String getUpLoadSerialNo(){
        return upLoadSerialNo;
    }

    /**
     * 设置属性赔付信息审核平台状态字段:空为未处理，2为正在审核，3为退回，4为通过
     * @param vflag 待设置的属性赔付信息审核平台状态字段:空为未处理，2为正在审核，3为退回，4为通过的值
     */
    public void setVflag(String vflag){
        this.vflag = StringUtils.rightTrim(vflag);
    }

    /**
     * 获取属性赔付信息审核平台状态字段:空为未处理，2为正在审核，3为退回，4为通过
     * @return 属性赔付信息审核平台状态字段:空为未处理，2为正在审核，3为退回，4为通过的值
     */
    public String getVflag(){
        return vflag;
    }

    /**
     * 设置属性机构代码
     * @param comCode 待设置的属性机构代码的值
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * 获取属性机构代码
     * @return 属性机构代码的值
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * 设置属性合并下发标志
     * @param mergerFlag 待设置的属性合并下发标志的值
     */
    public void setMergerFlag(String mergerFlag){
        this.mergerFlag = StringUtils.rightTrim(mergerFlag);
    }

    /**
     * 获取属性合并下发标志
     * @return 属性合并下发标志的值
     */
    public String getMergerFlag(){
        return mergerFlag;
    }

    /**
     * 设置属性总支付金额
     * @param payTotalAmount 待设置的属性总支付金额的值
     */
    public void setPayTotalAmount(double payTotalAmount){
        this.payTotalAmount = payTotalAmount;
    }

    /**
     * 获取属性总支付金额
     * @return 属性总支付金额的值
     */
    public double getPayTotalAmount(){
        return payTotalAmount;
    }

    /**
     * 设置属性紧急程度：30m;1h;2h;3h;4h;8h;24h;48h
     * @param urgentType 待设置的属性紧急程度：30m;1h;2h;3h;4h;8h;24h;48h的值
     */
    public void setUrgentType(String urgentType){
        this.urgentType = StringUtils.rightTrim(urgentType);
    }

    /**
     * 获取属性紧急程度：30m;1h;2h;3h;4h;8h;24h;48h
     * @return 属性紧急程度：30m;1h;2h;3h;4h;8h;24h;48h的值
     */
    public String getUrgentType(){
        return urgentType;
    }

    /**
     * 设置属性领款人类型代码（t1:被保险人、t2:个人代理索赔、t3:单位代理索赔、t4：人民法院、t5:公估公司、t6：机构理赔人员、t7：律师事务所、t8：其他）
     * @param receiverTypeOther 待设置的属性领款人类型代码（t1:被保险人、t2:个人代理索赔、t3:单位代理索赔、t4：人民法院、t5:公估公司、t6：机构理赔人员、t7：律师事务所、t8：其他）的值
     */
    public void setReceiverTypeOther(String receiverTypeOther){
        this.receiverTypeOther = StringUtils.rightTrim(receiverTypeOther);
    }

    /**
     * 获取属性领款人类型代码（t1:被保险人、t2:个人代理索赔、t3:单位代理索赔、t4：人民法院、t5:公估公司、t6：机构理赔人员、t7：律师事务所、t8：其他）
     * @return 属性领款人类型代码（t1:被保险人、t2:个人代理索赔、t3:单位代理索赔、t4：人民法院、t5:公估公司、t6：机构理赔人员、t7：律师事务所、t8：其他）的值
     */
    public String getReceiverTypeOther(){
        return receiverTypeOther;
    }

    /**
     * 设置属性领款人类型名称（t1:被保险人、t2:个人代理索赔、t3:单位代理索赔、t4：人民法院、t5:公估公司、t6：机构理赔人员、t7：律师事务所、t8：其他）
     * @param receiverTypeOtherName 待设置的属性领款人类型名称（t1:被保险人、t2:个人代理索赔、t3:单位代理索赔、t4：人民法院、t5:公估公司、t6：机构理赔人员、t7：律师事务所、t8：其他）的值
     */
    public void setReceiverTypeOtherName(String receiverTypeOtherName){
        this.receiverTypeOtherName = StringUtils.rightTrim(receiverTypeOtherName);
    }

    /**
     * 获取属性领款人类型名称（t1:被保险人、t2:个人代理索赔、t3:单位代理索赔、t4：人民法院、t5:公估公司、t6：机构理赔人员、t7：律师事务所、t8：其他）
     * @return 属性领款人类型名称（t1:被保险人、t2:个人代理索赔、t3:单位代理索赔、t4：人民法院、t5:公估公司、t6：机构理赔人员、t7：律师事务所、t8：其他）的值
     */
    public String getReceiverTypeOtherName(){
        return receiverTypeOtherName;
    }

    /**
     * 设置属性qq号码
     * @param qqNumber 待设置的属性qq号码的值
     */
    public void setQqNumber(String qqNumber){
        this.qqNumber = StringUtils.rightTrim(qqNumber);
    }

    /**
     * 获取属性qq号码
     * @return 属性qq号码的值
     */
    public String getQqNumber(){
        return qqNumber;
    }

    /**
     * 设置属性电子邮件
     * @param email 待设置的属性电子邮件的值
     */
    public void setEmail(String email){
        this.email = StringUtils.rightTrim(email);
    }

    /**
     * 获取属性电子邮件
     * @return 属性电子邮件的值
     */
    public String getEmail(){
        return email;
    }

    /**
     * 设置属性单位联系人
     * @param unitLink 待设置的属性单位联系人的值
     */
    public void setUnitLink(String unitLink){
        this.unitLink = StringUtils.rightTrim(unitLink);
    }

    /**
     * 获取属性单位联系人
     * @return 属性单位联系人的值
     */
    public String getUnitLink(){
        return unitLink;
    }

    /**
     * 设置属性邮政编码
     * @param postCode 待设置的属性邮政编码的值
     */
    public void setPostCode(String postCode){
        this.postCode = StringUtils.rightTrim(postCode);
    }

    /**
     * 获取属性邮政编码
     * @return 属性邮政编码的值
     */
    public String getPostCode(){
        return postCode;
    }

    /**
     * 设置属性审核方式 0 自动审核 1 人工审核
     * @param verifyFlag 待设置的属性审核方式 0 自动审核 1 人工审核的值
     */
    public void setVerifyFlag(String verifyFlag){
        this.verifyFlag = StringUtils.rightTrim(verifyFlag);
    }

    /**
     * 获取属性审核方式 0 自动审核 1 人工审核
     * @return 属性审核方式 0 自动审核 1 人工审核的值
     */
    public String getVerifyFlag(){
        return verifyFlag;
    }

    /**
     * 设置属性通知单号
     * @param noticeNo 待设置的属性通知单号的值
     */
    public void setNoticeNo(String noticeNo){
        this.noticeNo = StringUtils.rightTrim(noticeNo);
    }

    /**
     * 获取属性通知单号
     * @return 属性通知单号的值
     */
    public String getNoticeNo(){
        return noticeNo;
    }

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public DateTime getBackDate() {
		return backDate;
	}

	public void setBackDate(DateTime backDate) {
		this.backDate = backDate;
	}

	public String getBackOperatorCode() {
		return backOperatorCode;
	}

	public void setBackOperatorCode(String backOperatorCode) {
		this.backOperatorCode = backOperatorCode;
	}

	public String getBackComCode() {
		return backComCode;
	}

	public void setBackComCode(String backComCode) {
		this.backComCode = backComCode;
	}

	public String getThirdPayFlag() {
		return thirdPayFlag;
	}

	public void setThirdPayFlag(String thirdPayFlag) {
		this.thirdPayFlag = thirdPayFlag;
	}

	public String getPayWay() {
		return payWay;
	}

	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}

	public String getPayReason() {
		return payReason;
	}

	public void setPayReason(String payReason) {
		this.payReason = payReason;
	}

	public String getPayPurpose() {
		return payPurpose;
	}

	public void setPayPurpose(String payPurpose) {
		this.payPurpose = payPurpose;
	}

	public String getAccountFlag() {
		return accountFlag;
	}

	public void setAccountFlag(String accountFlag) {
		this.accountFlag = accountFlag;
	}

	public String getInterType() {
		return interType;
	}

	public void setInterType(String interType) {
		this.interType = interType;
	}

	public String getRouteNum() {
		return routeNum;
	}

	public void setRouteNum(String routeNum) {
		this.routeNum = routeNum;
	}

	public String getBillFlag() {
		return billFlag;
	}

	public void setBillFlag(String billFlag) {
		this.billFlag = billFlag;
	}

	public String getThirdPayType() {
		return thirdPayType;
	}

	public void setThirdPayType(String thirdPayType) {
		this.thirdPayType = thirdPayType;
	}

	public String getNoBillFlag() {
		return noBillFlag;
	}

	public void setNoBillFlag(String noBillFlag) {
		this.noBillFlag = noBillFlag;
	}

	public String getRealPayWay() {
		return realPayWay;
	}

	public void setRealPayWay(String realPayWay) {
		this.realPayWay = realPayWay;
	}
	
}
