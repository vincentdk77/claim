package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是传入参数主表的数据传输对象基类<br>
 */
public class PrpLinterPayRequestDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性主键id PK */
    private String id = "";
    /** 属性客户端数据主键 */
    private String outId = "";
    /** 属性操作类型 A：新增支付U:更新支付信息 */
    private String operateType = "";
    /** 属性收付编号 */
    private String paymentNo = "";
    /** 属性领款人类型代码 */
    private String receiverTypeOther = "";
    /** 属性领款人类别名称 */
    private String receiverTypeOtherName = "";
    /** 属性领款人名称 */
    private String receiverFullName = "";
    /** 属性领款人证件类型 */
    private String certifType = "";
    /** 属性领款人证件类型名称 */
    private String certifTypeName = "";
    /** 属性证件号码 */
    private String certifNo = "";
    /** 属性紧急程度 */
    private String urgentType = "";
    /** 属性紧急程度名称 */
    private String urgentTypeName = "";
    /** 属性省份名称 */
    private String provinceCode = "";
    /** 属性城市名称 */
    private String cityCode = "";
    /** 属性账号属性(个人账号：1，单位账号：2) */
    private String accountType = "";
    /** 属性银行大类 */
    private String bankType = "";
    /** 属性开户银行 */
    private String bank = "";
    /** 属性银行账号 */
    private String bankAccount = "";
    /** 属性账号确认，需要跟银行账号一致 */
    private String bankAccount2 = "";
    /** 属性手机号码 */
    private String mobilePhone = "";
    /** 属性家庭电话 */
    private String familyPhone = "";
    /** 属性办公电话 */
    private String officePhone = "";
    /** 属性详细地址 */
    private String address = "";
    /** 属性QQ号码 */
    private String qqNumber = "";
    /** 属性电子邮件 */
    private String email = "";
    /** 属性单位联系人员 */
    private String unitLink = "";
    /** 属性邮政编码 */
    private String postCode = "";
    /** 属性支付方式(第三方支付：1，传统方式支付：2) */
    private String payWay = "";
    /** 属性支付原因 */
    private String payReason = "";
    /** 属性用途说明 */
    private String payPurpose = "";
    /** 属性操作人代码 */
    private String operatorCode = "";
    /** 属性操作人名称 */
    private String operatorName = "";
    /** 属性操作人机构代码 */
    private String makeCom = "";
    /** 属性操作人机构名称 */
    private String makeComName = "";
    /** 属性操作时间 */
    private DateTime operatorDate = new DateTime();
    /** 属性支付审批意见 */
    private String handleText = "";
    /** 属性输入时间 */
    private DateTime inputDate = new DateTime();
    /** 属性账号类型(00:银行卡,01:存折,02:信用卡) */
    private String accountFlag = "";
    /** 属性接口类型*/
    private String seriousInterType = "";
    private String autoFlag = "";
    /**支付审批通过时间 */
    private DateTime handleDate= new DateTime();
    /**支付审批人员代码*/
    private String  handleCode;

    /**
     *  默认构造方法,构造一个默认的PrpLinterPayRequestDtoBase对象
     */
    public PrpLinterPayRequestDtoBase(){
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
     * 设置属性客户端数据主键
     * @param outId 待设置的属性客户端数据主键的值
     */
    public void setOutId(String outId){
        this.outId = StringUtils.rightTrim(outId);
    }

    /**
     * 获取属性客户端数据主键
     * @return 属性客户端数据主键的值
     */
    public String getOutId(){
        return outId;
    }

    /**
     * 设置属性操作类型 A：新增支付U:更新支付信息
     * @param operateType 待设置的属性操作类型 A：新增支付U:更新支付信息的值
     */
    public void setOperateType(String operateType){
        this.operateType = StringUtils.rightTrim(operateType);
    }

    /**
     * 获取属性操作类型 A：新增支付U:更新支付信息
     * @return 属性操作类型 A：新增支付U:更新支付信息的值
     */
    public String getOperateType(){
        return operateType;
    }

    /**
     * 设置属性收付编号
     * @param paymentNo 待设置的属性收付编号的值
     */
    public void setPaymentNo(String paymentNo){
        this.paymentNo = StringUtils.rightTrim(paymentNo);
    }

    /**
     * 获取属性收付编号
     * @return 属性收付编号的值
     */
    public String getPaymentNo(){
        return paymentNo;
    }

    /**
     * 设置属性领款人类型代码
     * @param receiverTypeOther 待设置的属性领款人类型代码的值
     */
    public void setReceiverTypeOther(String receiverTypeOther){
        this.receiverTypeOther = StringUtils.rightTrim(receiverTypeOther);
    }

    /**
     * 获取属性领款人类型代码
     * @return 属性领款人类型代码的值
     */
    public String getReceiverTypeOther(){
        return receiverTypeOther;
    }

    /**
     * 设置属性领款人类别名称
     * @param receiverTypeOtherName 待设置的属性领款人类别名称的值
     */
    public void setReceiverTypeOtherName(String receiverTypeOtherName){
        this.receiverTypeOtherName = StringUtils.rightTrim(receiverTypeOtherName);
    }

    /**
     * 获取属性领款人类别名称
     * @return 属性领款人类别名称的值
     */
    public String getReceiverTypeOtherName(){
        return receiverTypeOtherName;
    }

    /**
     * 设置属性领款人名称
     * @param receiverFullName 待设置的属性领款人名称的值
     */
    public void setReceiverFullName(String receiverFullName){
        this.receiverFullName = StringUtils.rightTrim(receiverFullName);
    }

    /**
     * 获取属性领款人名称
     * @return 属性领款人名称的值
     */
    public String getReceiverFullName(){
        return receiverFullName;
    }

    /**
     * 设置属性领款人证件类型
     * @param certifType 待设置的属性领款人证件类型的值
     */
    public void setCertifType(String certifType){
        this.certifType = StringUtils.rightTrim(certifType);
    }

    /**
     * 获取属性领款人证件类型
     * @return 属性领款人证件类型的值
     */
    public String getCertifType(){
        return certifType;
    }

    /**
     * 设置属性领款人证件类型名称
     * @param certifTypeName 待设置的属性领款人证件类型名称的值
     */
    public void setCertifTypeName(String certifTypeName){
        this.certifTypeName = StringUtils.rightTrim(certifTypeName);
    }

    /**
     * 获取属性领款人证件类型名称
     * @return 属性领款人证件类型名称的值
     */
    public String getCertifTypeName(){
        return certifTypeName;
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
     * 设置属性紧急程度
     * @param urgentType 待设置的属性紧急程度的值
     */
    public void setUrgentType(String urgentType){
        this.urgentType = StringUtils.rightTrim(urgentType);
    }

    /**
     * 获取属性紧急程度
     * @return 属性紧急程度的值
     */
    public String getUrgentType(){
        return urgentType;
    }

    /**
     * 设置属性紧急程度名称
     * @param urgentTypeName 待设置的属性紧急程度名称的值
     */
    public void setUrgentTypeName(String urgentTypeName){
        this.urgentTypeName = StringUtils.rightTrim(urgentTypeName);
    }

    /**
     * 获取属性紧急程度名称
     * @return 属性紧急程度名称的值
     */
    public String getUrgentTypeName(){
        return urgentTypeName;
    }

    /**
     * 设置属性省份名称
     * @param provinceCode 待设置的属性省份名称的值
     */
    public void setProvinceCode(String provinceCode){
        this.provinceCode = StringUtils.rightTrim(provinceCode);
    }

    /**
     * 获取属性省份名称
     * @return 属性省份名称的值
     */
    public String getProvinceCode(){
        return provinceCode;
    }

    /**
     * 设置属性城市名称
     * @param cityCode 待设置的属性城市名称的值
     */
    public void setCityCode(String cityCode){
        this.cityCode = StringUtils.rightTrim(cityCode);
    }

    /**
     * 获取属性城市名称
     * @return 属性城市名称的值
     */
    public String getCityCode(){
        return cityCode;
    }

    /**
     * 设置属性账号属性(个人账号：1，单位账号：2)
     * @param accountType 待设置的属性账号属性(个人账号：1，单位账号：2)的值
     */
    public void setAccountType(String accountType){
        this.accountType = StringUtils.rightTrim(accountType);
    }

    /**
     * 获取属性账号属性(个人账号：1，单位账号：2)
     * @return 属性账号属性(个人账号：1，单位账号：2)的值
     */
    public String getAccountType(){
        return accountType;
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
     * 设置属性账号确认，需要跟银行账号一致
     * @param bankAccount2 待设置的属性账号确认，需要跟银行账号一致的值
     */
    public void setBankAccount2(String bankAccount2){
        this.bankAccount2 = StringUtils.rightTrim(bankAccount2);
    }

    /**
     * 获取属性账号确认，需要跟银行账号一致
     * @return 属性账号确认，需要跟银行账号一致的值
     */
    public String getBankAccount2(){
        return bankAccount2;
    }

    /**
     * 设置属性手机号码
     * @param mobilePhone 待设置的属性手机号码的值
     */
    public void setMobilePhone(String mobilePhone){
        this.mobilePhone = StringUtils.rightTrim(mobilePhone);
    }

    /**
     * 获取属性手机号码
     * @return 属性手机号码的值
     */
    public String getMobilePhone(){
        return mobilePhone;
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
     * 设置属性QQ号码
     * @param qqNumber 待设置的属性QQ号码的值
     */
    public void setQqNumber(String qqNumber){
        this.qqNumber = StringUtils.rightTrim(qqNumber);
    }

    /**
     * 获取属性QQ号码
     * @return 属性QQ号码的值
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
     * 设置属性单位联系人员
     * @param unitLink 待设置的属性单位联系人员的值
     */
    public void setUnitLink(String unitLink){
        this.unitLink = StringUtils.rightTrim(unitLink);
    }

    /**
     * 获取属性单位联系人员
     * @return 属性单位联系人员的值
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
     * 设置属性支付方式(第三方支付：1，传统方式支付：2)
     * @param payWay 待设置的属性支付方式(第三方支付：1，传统方式支付：2)的值
     */
    public void setPayWay(String payWay){
        this.payWay = StringUtils.rightTrim(payWay);
    }

    /**
     * 获取属性支付方式(第三方支付：1，传统方式支付：2)
     * @return 属性支付方式(第三方支付：1，传统方式支付：2)的值
     */
    public String getPayWay(){
        return payWay;
    }

    /**
     * 设置属性支付原因
     * @param payReason 待设置的属性支付原因的值
     */
    public void setPayReason(String payReason){
        this.payReason = StringUtils.rightTrim(payReason);
    }

    /**
     * 获取属性支付原因
     * @return 属性支付原因的值
     */
    public String getPayReason(){
        return payReason;
    }

    /**
     * 设置属性用途说明
     * @param payPurpose 待设置的属性用途说明的值
     */
    public void setPayPurpose(String payPurpose){
        this.payPurpose = StringUtils.rightTrim(payPurpose);
    }

    /**
     * 获取属性用途说明
     * @return 属性用途说明的值
     */
    public String getPayPurpose(){
        return payPurpose;
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
     * 设置属性操作人机构代码
     * @param makeCom 待设置的属性操作人机构代码的值
     */
    public void setMakeCom(String makeCom){
        this.makeCom = StringUtils.rightTrim(makeCom);
    }

    /**
     * 获取属性操作人机构代码
     * @return 属性操作人机构代码的值
     */
    public String getMakeCom(){
        return makeCom;
    }

    /**
     * 设置属性操作人机构名称
     * @param makeComName 待设置的属性操作人机构名称的值
     */
    public void setMakeComName(String makeComName){
        this.makeComName = StringUtils.rightTrim(makeComName);
    }

    /**
     * 获取属性操作人机构名称
     * @return 属性操作人机构名称的值
     */
    public String getMakeComName(){
        return makeComName;
    }

    /**
     * 设置属性操作时间
     * @param operatorDate 待设置的属性操作时间的值
     */
    public void setOperatorDate(DateTime operatorDate){
        this.operatorDate = operatorDate;
    }

    /**
     * 获取属性操作时间
     * @return 属性操作时间的值
     */
    public DateTime getOperatorDate(){
        return operatorDate;
    }

    /**
     * 设置属性支付审批意见
     * @param handleText 待设置的属性支付审批意见的值
     */
    public void setHandleText(String handleText){
        this.handleText = StringUtils.rightTrim(handleText);
    }

    /**
     * 获取属性支付审批意见
     * @return 属性支付审批意见的值
     */
    public String getHandleText(){
        return handleText;
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
     * 设置属性账号类型(00:银行卡,01:存折,02:信用卡)
     * @param accountFlag 待设置的属性账号类型(00:银行卡,01:存折,02:信用卡)的值
     */
    public void setAccountFlag(String accountFlag){
        this.accountFlag = StringUtils.rightTrim(accountFlag);
    }

    /**
     * 获取属性账号类型(00:银行卡,01:存折,02:信用卡)
     * @return 属性账号类型(00:银行卡,01:存折,02:信用卡)的值
     */
    public String getAccountFlag(){
        return accountFlag;
    }

    /**
     * 获取属性接口类型  1大病即时即报接口
     * @return 属性接口类型
     */
	public String getSeriousInterType() {
		return seriousInterType;
	}

	/**
     * 设置属性接口类型 1大病即时即报接口
     * @param seriousInterType
     */
	public void setSeriousInterType(String seriousInterType) {
		this.seriousInterType = seriousInterType;
	}

	public String getAutoFlag() {
		return autoFlag;
	}

	public void setAutoFlag(String autoFlag) {
		this.autoFlag = autoFlag;
	}

	public DateTime getHandleDate() {
		return handleDate;
	}

	public void setHandleDate(DateTime handleDate) {
		this.handleDate = handleDate;
	}

	public String getHandleCode() {
		return handleCode;
	}

	public void setHandleCode(String handleCode) {
		this.handleCode = handleCode;
	}
    
    
}
