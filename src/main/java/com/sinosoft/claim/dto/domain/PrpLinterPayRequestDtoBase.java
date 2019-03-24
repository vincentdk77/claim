package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ���Ǵ��������������ݴ���������<br>
 */
public class PrpLinterPayRequestDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ��������id PK */
    private String id = "";
    /** ���Կͻ����������� */
    private String outId = "";
    /** ���Բ������� A������֧��U:����֧����Ϣ */
    private String operateType = "";
    /** �����ո���� */
    private String paymentNo = "";
    /** ������������ʹ��� */
    private String receiverTypeOther = "";
    /** ���������������� */
    private String receiverTypeOtherName = "";
    /** ������������� */
    private String receiverFullName = "";
    /** ���������֤������ */
    private String certifType = "";
    /** ���������֤���������� */
    private String certifTypeName = "";
    /** ����֤������ */
    private String certifNo = "";
    /** ���Խ����̶� */
    private String urgentType = "";
    /** ���Խ����̶����� */
    private String urgentTypeName = "";
    /** ����ʡ������ */
    private String provinceCode = "";
    /** ���Գ������� */
    private String cityCode = "";
    /** �����˺�����(�����˺ţ�1����λ�˺ţ�2) */
    private String accountType = "";
    /** �������д��� */
    private String bankType = "";
    /** ���Կ������� */
    private String bank = "";
    /** ���������˺� */
    private String bankAccount = "";
    /** �����˺�ȷ�ϣ���Ҫ�������˺�һ�� */
    private String bankAccount2 = "";
    /** �����ֻ����� */
    private String mobilePhone = "";
    /** ���Լ�ͥ�绰 */
    private String familyPhone = "";
    /** ���԰칫�绰 */
    private String officePhone = "";
    /** ������ϸ��ַ */
    private String address = "";
    /** ����QQ���� */
    private String qqNumber = "";
    /** ���Ե����ʼ� */
    private String email = "";
    /** ���Ե�λ��ϵ��Ա */
    private String unitLink = "";
    /** ������������ */
    private String postCode = "";
    /** ����֧����ʽ(������֧����1����ͳ��ʽ֧����2) */
    private String payWay = "";
    /** ����֧��ԭ�� */
    private String payReason = "";
    /** ������;˵�� */
    private String payPurpose = "";
    /** ���Բ����˴��� */
    private String operatorCode = "";
    /** ���Բ��������� */
    private String operatorName = "";
    /** ���Բ����˻������� */
    private String makeCom = "";
    /** ���Բ����˻������� */
    private String makeComName = "";
    /** ���Բ���ʱ�� */
    private DateTime operatorDate = new DateTime();
    /** ����֧��������� */
    private String handleText = "";
    /** ��������ʱ�� */
    private DateTime inputDate = new DateTime();
    /** �����˺�����(00:���п�,01:����,02:���ÿ�) */
    private String accountFlag = "";
    /** ���Խӿ�����*/
    private String seriousInterType = "";
    private String autoFlag = "";
    /**֧������ͨ��ʱ�� */
    private DateTime handleDate= new DateTime();
    /**֧��������Ա����*/
    private String  handleCode;

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLinterPayRequestDtoBase����
     */
    public PrpLinterPayRequestDtoBase(){
    }

    /**
     * ������������id PK
     * @param id �����õ���������id PK��ֵ
     */
    public void setId(String id){
        this.id = StringUtils.rightTrim(id);
    }

    /**
     * ��ȡ��������id PK
     * @return ��������id PK��ֵ
     */
    public String getId(){
        return id;
    }

    /**
     * �������Կͻ�����������
     * @param outId �����õ����Կͻ�������������ֵ
     */
    public void setOutId(String outId){
        this.outId = StringUtils.rightTrim(outId);
    }

    /**
     * ��ȡ���Կͻ�����������
     * @return ���Կͻ�������������ֵ
     */
    public String getOutId(){
        return outId;
    }

    /**
     * �������Բ������� A������֧��U:����֧����Ϣ
     * @param operateType �����õ����Բ������� A������֧��U:����֧����Ϣ��ֵ
     */
    public void setOperateType(String operateType){
        this.operateType = StringUtils.rightTrim(operateType);
    }

    /**
     * ��ȡ���Բ������� A������֧��U:����֧����Ϣ
     * @return ���Բ������� A������֧��U:����֧����Ϣ��ֵ
     */
    public String getOperateType(){
        return operateType;
    }

    /**
     * ���������ո����
     * @param paymentNo �����õ������ո���ŵ�ֵ
     */
    public void setPaymentNo(String paymentNo){
        this.paymentNo = StringUtils.rightTrim(paymentNo);
    }

    /**
     * ��ȡ�����ո����
     * @return �����ո���ŵ�ֵ
     */
    public String getPaymentNo(){
        return paymentNo;
    }

    /**
     * ����������������ʹ���
     * @param receiverTypeOther �����õ�������������ʹ����ֵ
     */
    public void setReceiverTypeOther(String receiverTypeOther){
        this.receiverTypeOther = StringUtils.rightTrim(receiverTypeOther);
    }

    /**
     * ��ȡ������������ʹ���
     * @return ������������ʹ����ֵ
     */
    public String getReceiverTypeOther(){
        return receiverTypeOther;
    }

    /**
     * ��������������������
     * @param receiverTypeOtherName �����õ����������������Ƶ�ֵ
     */
    public void setReceiverTypeOtherName(String receiverTypeOtherName){
        this.receiverTypeOtherName = StringUtils.rightTrim(receiverTypeOtherName);
    }

    /**
     * ��ȡ����������������
     * @return ���������������Ƶ�ֵ
     */
    public String getReceiverTypeOtherName(){
        return receiverTypeOtherName;
    }

    /**
     * �����������������
     * @param receiverFullName �����õ�������������Ƶ�ֵ
     */
    public void setReceiverFullName(String receiverFullName){
        this.receiverFullName = StringUtils.rightTrim(receiverFullName);
    }

    /**
     * ��ȡ�������������
     * @return ������������Ƶ�ֵ
     */
    public String getReceiverFullName(){
        return receiverFullName;
    }

    /**
     * �������������֤������
     * @param certifType �����õ����������֤�����͵�ֵ
     */
    public void setCertifType(String certifType){
        this.certifType = StringUtils.rightTrim(certifType);
    }

    /**
     * ��ȡ���������֤������
     * @return ���������֤�����͵�ֵ
     */
    public String getCertifType(){
        return certifType;
    }

    /**
     * �������������֤����������
     * @param certifTypeName �����õ����������֤���������Ƶ�ֵ
     */
    public void setCertifTypeName(String certifTypeName){
        this.certifTypeName = StringUtils.rightTrim(certifTypeName);
    }

    /**
     * ��ȡ���������֤����������
     * @return ���������֤���������Ƶ�ֵ
     */
    public String getCertifTypeName(){
        return certifTypeName;
    }

    /**
     * ��������֤������
     * @param certifNo �����õ�����֤�������ֵ
     */
    public void setCertifNo(String certifNo){
        this.certifNo = StringUtils.rightTrim(certifNo);
    }

    /**
     * ��ȡ����֤������
     * @return ����֤�������ֵ
     */
    public String getCertifNo(){
        return certifNo;
    }

    /**
     * �������Խ����̶�
     * @param urgentType �����õ����Խ����̶ȵ�ֵ
     */
    public void setUrgentType(String urgentType){
        this.urgentType = StringUtils.rightTrim(urgentType);
    }

    /**
     * ��ȡ���Խ����̶�
     * @return ���Խ����̶ȵ�ֵ
     */
    public String getUrgentType(){
        return urgentType;
    }

    /**
     * �������Խ����̶�����
     * @param urgentTypeName �����õ����Խ����̶����Ƶ�ֵ
     */
    public void setUrgentTypeName(String urgentTypeName){
        this.urgentTypeName = StringUtils.rightTrim(urgentTypeName);
    }

    /**
     * ��ȡ���Խ����̶�����
     * @return ���Խ����̶����Ƶ�ֵ
     */
    public String getUrgentTypeName(){
        return urgentTypeName;
    }

    /**
     * ��������ʡ������
     * @param provinceCode �����õ�����ʡ�����Ƶ�ֵ
     */
    public void setProvinceCode(String provinceCode){
        this.provinceCode = StringUtils.rightTrim(provinceCode);
    }

    /**
     * ��ȡ����ʡ������
     * @return ����ʡ�����Ƶ�ֵ
     */
    public String getProvinceCode(){
        return provinceCode;
    }

    /**
     * �������Գ�������
     * @param cityCode �����õ����Գ������Ƶ�ֵ
     */
    public void setCityCode(String cityCode){
        this.cityCode = StringUtils.rightTrim(cityCode);
    }

    /**
     * ��ȡ���Գ�������
     * @return ���Գ������Ƶ�ֵ
     */
    public String getCityCode(){
        return cityCode;
    }

    /**
     * ���������˺�����(�����˺ţ�1����λ�˺ţ�2)
     * @param accountType �����õ������˺�����(�����˺ţ�1����λ�˺ţ�2)��ֵ
     */
    public void setAccountType(String accountType){
        this.accountType = StringUtils.rightTrim(accountType);
    }

    /**
     * ��ȡ�����˺�����(�����˺ţ�1����λ�˺ţ�2)
     * @return �����˺�����(�����˺ţ�1����λ�˺ţ�2)��ֵ
     */
    public String getAccountType(){
        return accountType;
    }

    /**
     * �����������д���
     * @param bankType �����õ��������д����ֵ
     */
    public void setBankType(String bankType){
        this.bankType = StringUtils.rightTrim(bankType);
    }

    /**
     * ��ȡ�������д���
     * @return �������д����ֵ
     */
    public String getBankType(){
        return bankType;
    }

    /**
     * �������Կ�������
     * @param bank �����õ����Կ������е�ֵ
     */
    public void setBank(String bank){
        this.bank = StringUtils.rightTrim(bank);
    }

    /**
     * ��ȡ���Կ�������
     * @return ���Կ������е�ֵ
     */
    public String getBank(){
        return bank;
    }

    /**
     * �������������˺�
     * @param bankAccount �����õ����������˺ŵ�ֵ
     */
    public void setBankAccount(String bankAccount){
        this.bankAccount = StringUtils.rightTrim(bankAccount);
    }

    /**
     * ��ȡ���������˺�
     * @return ���������˺ŵ�ֵ
     */
    public String getBankAccount(){
        return bankAccount;
    }

    /**
     * ���������˺�ȷ�ϣ���Ҫ�������˺�һ��
     * @param bankAccount2 �����õ������˺�ȷ�ϣ���Ҫ�������˺�һ�µ�ֵ
     */
    public void setBankAccount2(String bankAccount2){
        this.bankAccount2 = StringUtils.rightTrim(bankAccount2);
    }

    /**
     * ��ȡ�����˺�ȷ�ϣ���Ҫ�������˺�һ��
     * @return �����˺�ȷ�ϣ���Ҫ�������˺�һ�µ�ֵ
     */
    public String getBankAccount2(){
        return bankAccount2;
    }

    /**
     * ���������ֻ�����
     * @param mobilePhone �����õ������ֻ������ֵ
     */
    public void setMobilePhone(String mobilePhone){
        this.mobilePhone = StringUtils.rightTrim(mobilePhone);
    }

    /**
     * ��ȡ�����ֻ�����
     * @return �����ֻ������ֵ
     */
    public String getMobilePhone(){
        return mobilePhone;
    }

    /**
     * �������Լ�ͥ�绰
     * @param familyPhone �����õ����Լ�ͥ�绰��ֵ
     */
    public void setFamilyPhone(String familyPhone){
        this.familyPhone = StringUtils.rightTrim(familyPhone);
    }

    /**
     * ��ȡ���Լ�ͥ�绰
     * @return ���Լ�ͥ�绰��ֵ
     */
    public String getFamilyPhone(){
        return familyPhone;
    }

    /**
     * �������԰칫�绰
     * @param officePhone �����õ����԰칫�绰��ֵ
     */
    public void setOfficePhone(String officePhone){
        this.officePhone = StringUtils.rightTrim(officePhone);
    }

    /**
     * ��ȡ���԰칫�绰
     * @return ���԰칫�绰��ֵ
     */
    public String getOfficePhone(){
        return officePhone;
    }

    /**
     * ����������ϸ��ַ
     * @param address �����õ�������ϸ��ַ��ֵ
     */
    public void setAddress(String address){
        this.address = StringUtils.rightTrim(address);
    }

    /**
     * ��ȡ������ϸ��ַ
     * @return ������ϸ��ַ��ֵ
     */
    public String getAddress(){
        return address;
    }

    /**
     * ��������QQ����
     * @param qqNumber �����õ�����QQ�����ֵ
     */
    public void setQqNumber(String qqNumber){
        this.qqNumber = StringUtils.rightTrim(qqNumber);
    }

    /**
     * ��ȡ����QQ����
     * @return ����QQ�����ֵ
     */
    public String getQqNumber(){
        return qqNumber;
    }

    /**
     * �������Ե����ʼ�
     * @param email �����õ����Ե����ʼ���ֵ
     */
    public void setEmail(String email){
        this.email = StringUtils.rightTrim(email);
    }

    /**
     * ��ȡ���Ե����ʼ�
     * @return ���Ե����ʼ���ֵ
     */
    public String getEmail(){
        return email;
    }

    /**
     * �������Ե�λ��ϵ��Ա
     * @param unitLink �����õ����Ե�λ��ϵ��Ա��ֵ
     */
    public void setUnitLink(String unitLink){
        this.unitLink = StringUtils.rightTrim(unitLink);
    }

    /**
     * ��ȡ���Ե�λ��ϵ��Ա
     * @return ���Ե�λ��ϵ��Ա��ֵ
     */
    public String getUnitLink(){
        return unitLink;
    }

    /**
     * ����������������
     * @param postCode �����õ��������������ֵ
     */
    public void setPostCode(String postCode){
        this.postCode = StringUtils.rightTrim(postCode);
    }

    /**
     * ��ȡ������������
     * @return �������������ֵ
     */
    public String getPostCode(){
        return postCode;
    }

    /**
     * ��������֧����ʽ(������֧����1����ͳ��ʽ֧����2)
     * @param payWay �����õ�����֧����ʽ(������֧����1����ͳ��ʽ֧����2)��ֵ
     */
    public void setPayWay(String payWay){
        this.payWay = StringUtils.rightTrim(payWay);
    }

    /**
     * ��ȡ����֧����ʽ(������֧����1����ͳ��ʽ֧����2)
     * @return ����֧����ʽ(������֧����1����ͳ��ʽ֧����2)��ֵ
     */
    public String getPayWay(){
        return payWay;
    }

    /**
     * ��������֧��ԭ��
     * @param payReason �����õ�����֧��ԭ���ֵ
     */
    public void setPayReason(String payReason){
        this.payReason = StringUtils.rightTrim(payReason);
    }

    /**
     * ��ȡ����֧��ԭ��
     * @return ����֧��ԭ���ֵ
     */
    public String getPayReason(){
        return payReason;
    }

    /**
     * ����������;˵��
     * @param payPurpose �����õ�������;˵����ֵ
     */
    public void setPayPurpose(String payPurpose){
        this.payPurpose = StringUtils.rightTrim(payPurpose);
    }

    /**
     * ��ȡ������;˵��
     * @return ������;˵����ֵ
     */
    public String getPayPurpose(){
        return payPurpose;
    }

    /**
     * �������Բ����˴���
     * @param operatorCode �����õ����Բ����˴����ֵ
     */
    public void setOperatorCode(String operatorCode){
        this.operatorCode = StringUtils.rightTrim(operatorCode);
    }

    /**
     * ��ȡ���Բ����˴���
     * @return ���Բ����˴����ֵ
     */
    public String getOperatorCode(){
        return operatorCode;
    }

    /**
     * �������Բ���������
     * @param operatorName �����õ����Բ��������Ƶ�ֵ
     */
    public void setOperatorName(String operatorName){
        this.operatorName = StringUtils.rightTrim(operatorName);
    }

    /**
     * ��ȡ���Բ���������
     * @return ���Բ��������Ƶ�ֵ
     */
    public String getOperatorName(){
        return operatorName;
    }

    /**
     * �������Բ����˻�������
     * @param makeCom �����õ����Բ����˻��������ֵ
     */
    public void setMakeCom(String makeCom){
        this.makeCom = StringUtils.rightTrim(makeCom);
    }

    /**
     * ��ȡ���Բ����˻�������
     * @return ���Բ����˻��������ֵ
     */
    public String getMakeCom(){
        return makeCom;
    }

    /**
     * �������Բ����˻�������
     * @param makeComName �����õ����Բ����˻������Ƶ�ֵ
     */
    public void setMakeComName(String makeComName){
        this.makeComName = StringUtils.rightTrim(makeComName);
    }

    /**
     * ��ȡ���Բ����˻�������
     * @return ���Բ����˻������Ƶ�ֵ
     */
    public String getMakeComName(){
        return makeComName;
    }

    /**
     * �������Բ���ʱ��
     * @param operatorDate �����õ����Բ���ʱ���ֵ
     */
    public void setOperatorDate(DateTime operatorDate){
        this.operatorDate = operatorDate;
    }

    /**
     * ��ȡ���Բ���ʱ��
     * @return ���Բ���ʱ���ֵ
     */
    public DateTime getOperatorDate(){
        return operatorDate;
    }

    /**
     * ��������֧���������
     * @param handleText �����õ�����֧�����������ֵ
     */
    public void setHandleText(String handleText){
        this.handleText = StringUtils.rightTrim(handleText);
    }

    /**
     * ��ȡ����֧���������
     * @return ����֧�����������ֵ
     */
    public String getHandleText(){
        return handleText;
    }

    /**
     * ������������ʱ��
     * @param inputDate �����õ���������ʱ���ֵ
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * ��ȡ��������ʱ��
     * @return ��������ʱ���ֵ
     */
    public DateTime getInputDate(){
        return inputDate;
    }

    /**
     * ���������˺�����(00:���п�,01:����,02:���ÿ�)
     * @param accountFlag �����õ������˺�����(00:���п�,01:����,02:���ÿ�)��ֵ
     */
    public void setAccountFlag(String accountFlag){
        this.accountFlag = StringUtils.rightTrim(accountFlag);
    }

    /**
     * ��ȡ�����˺�����(00:���п�,01:����,02:���ÿ�)
     * @return �����˺�����(00:���п�,01:����,02:���ÿ�)��ֵ
     */
    public String getAccountFlag(){
        return accountFlag;
    }

    /**
     * ��ȡ���Խӿ�����  1�󲡼�ʱ�����ӿ�
     * @return ���Խӿ�����
     */
	public String getSeriousInterType() {
		return seriousInterType;
	}

	/**
     * �������Խӿ����� 1�󲡼�ʱ�����ӿ�
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
