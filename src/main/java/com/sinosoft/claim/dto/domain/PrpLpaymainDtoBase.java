package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����֧����Ϣ��������ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLpaymainDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����֧����� */
    private String paymentNo = "";
    /** ����֧������(p1:Ԥ�⣬p2:֧����p3:�᰸֧��(ԭʵ��)��p4:�渶) */
    private String payType = "";
    /** ����֧����� */
    private double payAmount = 0D;
    /** ����ʡ�� */
    private String provinceCode = "";
    /** ���Գ��� */
    private String cityCode = "";
    /** �������д��� */
    private String bankType = "";
    /** ���Կ������� */
    private String bank = "";
    /** ���Կ�������ϸ */
    private String bankSite = "";
    /** �����˺����ͣ����ˡ���λ�� */
    private String accountType = "";
    /** ���������ȫ�� */
    private String receiverFullName = "";
    /** ��������˴��� */
    private String receiverFullCode = "";
    /** ����֤�����ͣ�01���������֤,02�����񻧿ڱ�,04������֤,05:ʿ��֤,07:�й�����,51:�������,71:��֯��������֤,72:˰��Ǽ�֤,73��Ӫҵִ�գ� */
    private String certifType = "";
    /** ������ϸ��ַ */
    private String address = "";
    /** ����֤������ */
    private String certifNo = "";
    /** ���Լ�ͥ�绰 */
    private String familyPhone = "";
    /** ���԰칫�绰 */
    private String officePhone = "";
    /** �����ֻ��� */
    private String mobilePhone = "";
    /** ����֧��˵�� */
    private String payRemark = "";
    /** ���Բ���Ա���� */
    private String operatorCode = "";
    /** ������������ */
    private DateTime inputDate = new DateTime();
    /** ����֧������ */
    private DateTime payDate = new DateTime();
    /** ����֧��Ա���� */
    private String payCode = "";
    /** ����֧����־ */
    private String payFlag = "";
    /** ����������� */
    private String paymentType = "";
    /** ���������˺� */
    private String bankAccount = "";
    /** ���Խڵ� */
    private String node = "";
    /** ����**��� */
    private String upLoadSerialNo = "";
    /** �����⸶��Ϣ���ƽ̨״̬�ֶ�:��Ϊδ����2Ϊ������ˣ�3Ϊ�˻أ�4Ϊͨ�� */
    private String vflag = "";
    /** ���Ի������� */
    private String comCode = "";
    /** ���Ժϲ��·���־ */
    private String mergerFlag = "";
    /** ������֧����� */
    private double payTotalAmount = 0D;
    /** ���Խ����̶ȣ�30m;1h;2h;3h;4h;8h;24h;48h */
    private String urgentType = "";
    /** ������������ʹ��루t1:�������ˡ�t2:���˴������⡢t3:��λ�������⡢t4������Ժ��t5:������˾��t6������������Ա��t7����ʦ��������t8�������� */
    private String receiverTypeOther = "";
    /** ����������������ƣ�t1:�������ˡ�t2:���˴������⡢t3:��λ�������⡢t4������Ժ��t5:������˾��t6������������Ա��t7����ʦ��������t8�������� */
    private String receiverTypeOtherName = "";
    /** ����qq���� */
    private String qqNumber = "";
    /** ���Ե����ʼ� */
    private String email = "";
    /** ���Ե�λ��ϵ�� */
    private String unitLink = "";
    /** ������������ */
    private String postCode = "";
    /** ������˷�ʽ 0 �Զ���� 1 �˹���� */
    private String verifyFlag = "";
    /** ����֪ͨ���� */
    private String noticeNo = "";
    /** �����˻�ʱ��*/
    private DateTime backDate = new DateTime();
    /** �����˻���*/
    private String backOperatorCode = "";
    /** �����˻ػ���*/
    private String backComCode = "";
    /** ���Ե�����֧����ʶ*/
    private String thirdPayFlag = "";
    /** ����֧����ʽ*/
    private String payWay = "";
    /** ���Դ�ͳ֧��ԭ��*/
    private String payReason = "";
    /** ������;˵��*/
    private String payPurpose = "";
    /** �����˺�����*/
    private String accountFlag = "";
    /** ���Խӿ����� 1�󲡼�ʱ����*/
    private String interType = "";
    /** ����֧���к�*/
    private String routeNum = "";
    /**�Ƿ����嵥��־*/
    private String billFlag;
    /** ���Ե�����֧������*/
    private String thirdPayType = "";
    /** ���Ե�����֧������*/
    private String noBillFlag = "";
    /** ����֧������*/
    private String realPayWay = "";
    
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLpaymainDtoBase����
     */
    public PrpLpaymainDtoBase(){
    }

    /**
     * ��������֧�����
     * @param paymentNo �����õ�����֧����ŵ�ֵ
     */
    public void setPaymentNo(String paymentNo){
        this.paymentNo = StringUtils.rightTrim(paymentNo);
    }

    /**
     * ��ȡ����֧�����
     * @return ����֧����ŵ�ֵ
     */
    public String getPaymentNo(){
        return paymentNo;
    }

    /**
     * ��������֧������(p1:Ԥ�⣬p2:֧����p3:�᰸֧��(ԭʵ��)��p4:�渶)
     * @param payType �����õ�����֧������(p1:Ԥ�⣬p2:֧����p3:�᰸֧��(ԭʵ��)��p4:�渶)��ֵ
     */
    public void setPayType(String payType){
        this.payType = StringUtils.rightTrim(payType);
    }

    /**
     * ��ȡ����֧������(p1:Ԥ�⣬p2:֧����p3:�᰸֧��(ԭʵ��)��p4:�渶)
     * @return ����֧������(p1:Ԥ�⣬p2:֧����p3:�᰸֧��(ԭʵ��)��p4:�渶)��ֵ
     */
    public String getPayType(){
        return payType;
    }

    /**
     * ��������֧�����
     * @param payAmount �����õ�����֧������ֵ
     */
    public void setPayAmount(double payAmount){
        this.payAmount = payAmount;
    }

    /**
     * ��ȡ����֧�����
     * @return ����֧������ֵ
     */
    public double getPayAmount(){
        return payAmount;
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
     * �������Կ�������ϸ
     * @param bankSite �����õ����Կ�������ϸ��ֵ
     */
    public void setBankSite(String bankSite){
        this.bankSite = StringUtils.rightTrim(bankSite);
    }

    /**
     * ��ȡ���Կ�������ϸ
     * @return ���Կ�������ϸ��ֵ
     */
    public String getBankSite(){
        return bankSite;
    }

    /**
     * ���������˺����ͣ����ˡ���λ��
     * @param accountType �����õ������˺����ͣ����ˡ���λ����ֵ
     */
    public void setAccountType(String accountType){
        this.accountType = StringUtils.rightTrim(accountType);
    }

    /**
     * ��ȡ�����˺����ͣ����ˡ���λ��
     * @return �����˺����ͣ����ˡ���λ����ֵ
     */
    public String getAccountType(){
        return accountType;
    }

    /**
     * �������������ȫ��
     * @param receiverFullName �����õ����������ȫ�Ƶ�ֵ
     */
    public void setReceiverFullName(String receiverFullName){
        this.receiverFullName = StringUtils.rightTrim(receiverFullName);
    }

    /**
     * ��ȡ���������ȫ��
     * @return ���������ȫ�Ƶ�ֵ
     */
    public String getReceiverFullName(){
        return receiverFullName;
    }

    /**
     * ������������˴���
     * @param receiverFullCode �����õ���������˴����ֵ
     */
    public void setReceiverFullCode(String receiverFullCode){
        this.receiverFullCode = StringUtils.rightTrim(receiverFullCode);
    }

    /**
     * ��ȡ��������˴���
     * @return ��������˴����ֵ
     */
    public String getReceiverFullCode(){
        return receiverFullCode;
    }

    /**
     * ��������֤�����ͣ�01���������֤,02�����񻧿ڱ�,04������֤,05:ʿ��֤,07:�й�����,51:�������,71:��֯��������֤,72:˰��Ǽ�֤,73��Ӫҵִ�գ�
     * @param certifType �����õ�����֤�����ͣ�01���������֤,02�����񻧿ڱ�,04������֤,05:ʿ��֤,07:�й�����,51:�������,71:��֯��������֤,72:˰��Ǽ�֤,73��Ӫҵִ�գ���ֵ
     */
    public void setCertifType(String certifType){
        this.certifType = StringUtils.rightTrim(certifType);
    }

    /**
     * ��ȡ����֤�����ͣ�01���������֤,02�����񻧿ڱ�,04������֤,05:ʿ��֤,07:�й�����,51:�������,71:��֯��������֤,72:˰��Ǽ�֤,73��Ӫҵִ�գ�
     * @return ����֤�����ͣ�01���������֤,02�����񻧿ڱ�,04������֤,05:ʿ��֤,07:�й�����,51:�������,71:��֯��������֤,72:˰��Ǽ�֤,73��Ӫҵִ�գ���ֵ
     */
    public String getCertifType(){
        return certifType;
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
     * ���������ֻ���
     * @param mobilePhone �����õ������ֻ��ŵ�ֵ
     */
    public void setMobilePhone(String mobilePhone){
        this.mobilePhone = StringUtils.rightTrim(mobilePhone);
    }

    /**
     * ��ȡ�����ֻ���
     * @return �����ֻ��ŵ�ֵ
     */
    public String getMobilePhone(){
        return mobilePhone;
    }

    /**
     * ��������֧��˵��
     * @param payRemark �����õ�����֧��˵����ֵ
     */
    public void setPayRemark(String payRemark){
        this.payRemark = StringUtils.rightTrim(payRemark);
    }

    /**
     * ��ȡ����֧��˵��
     * @return ����֧��˵����ֵ
     */
    public String getPayRemark(){
        return payRemark;
    }

    /**
     * �������Բ���Ա����
     * @param operatorCode �����õ����Բ���Ա�����ֵ
     */
    public void setOperatorCode(String operatorCode){
        this.operatorCode = StringUtils.rightTrim(operatorCode);
    }

    /**
     * ��ȡ���Բ���Ա����
     * @return ���Բ���Ա�����ֵ
     */
    public String getOperatorCode(){
        return operatorCode;
    }

    /**
     * ����������������
     * @param inputDate �����õ������������ڵ�ֵ
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * ��ȡ������������
     * @return �����������ڵ�ֵ
     */
    public DateTime getInputDate(){
        return inputDate;
    }

    /**
     * ��������֧������
     * @param payDate �����õ�����֧�����ڵ�ֵ
     */
    public void setPayDate(DateTime payDate){
        this.payDate = payDate;
    }

    /**
     * ��ȡ����֧������
     * @return ����֧�����ڵ�ֵ
     */
    public DateTime getPayDate(){
        return payDate;
    }

    /**
     * ��������֧��Ա����
     * @param payCode �����õ�����֧��Ա�����ֵ
     */
    public void setPayCode(String payCode){
        this.payCode = StringUtils.rightTrim(payCode);
    }

    /**
     * ��ȡ����֧��Ա����
     * @return ����֧��Ա�����ֵ
     */
    public String getPayCode(){
        return payCode;
    }

    /**
     * ��������֧����־
     * @param payFlag �����õ�����֧����־��ֵ
     */
    public void setPayFlag(String payFlag){
        this.payFlag = StringUtils.rightTrim(payFlag);
    }

    /**
     * ��ȡ����֧����־
     * @return ����֧����־��ֵ
     */
    public String getPayFlag(){
        return payFlag;
    }

    /**
     * ���������������
     * @param paymentType �����õ�����������͵�ֵ
     */
    public void setPaymentType(String paymentType){
        this.paymentType = StringUtils.rightTrim(paymentType);
    }

    /**
     * ��ȡ�����������
     * @return ����������͵�ֵ
     */
    public String getPaymentType(){
        return paymentType;
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
     * �������Խڵ�
     * @param node �����õ����Խڵ��ֵ
     */
    public void setNode(String node){
        this.node = StringUtils.rightTrim(node);
    }

    /**
     * ��ȡ���Խڵ�
     * @return ���Խڵ��ֵ
     */
    public String getNode(){
        return node;
    }

    /**
     * ��������**���
     * @param upLoadSerialNo �����õ�����**��ŵ�ֵ
     */
    public void setUpLoadSerialNo(String upLoadSerialNo){
        this.upLoadSerialNo = StringUtils.rightTrim(upLoadSerialNo);
    }

    /**
     * ��ȡ����**���
     * @return ����**��ŵ�ֵ
     */
    public String getUpLoadSerialNo(){
        return upLoadSerialNo;
    }

    /**
     * ���������⸶��Ϣ���ƽ̨״̬�ֶ�:��Ϊδ����2Ϊ������ˣ�3Ϊ�˻أ�4Ϊͨ��
     * @param vflag �����õ������⸶��Ϣ���ƽ̨״̬�ֶ�:��Ϊδ����2Ϊ������ˣ�3Ϊ�˻أ�4Ϊͨ����ֵ
     */
    public void setVflag(String vflag){
        this.vflag = StringUtils.rightTrim(vflag);
    }

    /**
     * ��ȡ�����⸶��Ϣ���ƽ̨״̬�ֶ�:��Ϊδ����2Ϊ������ˣ�3Ϊ�˻أ�4Ϊͨ��
     * @return �����⸶��Ϣ���ƽ̨״̬�ֶ�:��Ϊδ����2Ϊ������ˣ�3Ϊ�˻أ�4Ϊͨ����ֵ
     */
    public String getVflag(){
        return vflag;
    }

    /**
     * �������Ի�������
     * @param comCode �����õ����Ի��������ֵ
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * ��ȡ���Ի�������
     * @return ���Ի��������ֵ
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * �������Ժϲ��·���־
     * @param mergerFlag �����õ����Ժϲ��·���־��ֵ
     */
    public void setMergerFlag(String mergerFlag){
        this.mergerFlag = StringUtils.rightTrim(mergerFlag);
    }

    /**
     * ��ȡ���Ժϲ��·���־
     * @return ���Ժϲ��·���־��ֵ
     */
    public String getMergerFlag(){
        return mergerFlag;
    }

    /**
     * ����������֧�����
     * @param payTotalAmount �����õ�������֧������ֵ
     */
    public void setPayTotalAmount(double payTotalAmount){
        this.payTotalAmount = payTotalAmount;
    }

    /**
     * ��ȡ������֧�����
     * @return ������֧������ֵ
     */
    public double getPayTotalAmount(){
        return payTotalAmount;
    }

    /**
     * �������Խ����̶ȣ�30m;1h;2h;3h;4h;8h;24h;48h
     * @param urgentType �����õ����Խ����̶ȣ�30m;1h;2h;3h;4h;8h;24h;48h��ֵ
     */
    public void setUrgentType(String urgentType){
        this.urgentType = StringUtils.rightTrim(urgentType);
    }

    /**
     * ��ȡ���Խ����̶ȣ�30m;1h;2h;3h;4h;8h;24h;48h
     * @return ���Խ����̶ȣ�30m;1h;2h;3h;4h;8h;24h;48h��ֵ
     */
    public String getUrgentType(){
        return urgentType;
    }

    /**
     * ����������������ʹ��루t1:�������ˡ�t2:���˴������⡢t3:��λ�������⡢t4������Ժ��t5:������˾��t6������������Ա��t7����ʦ��������t8��������
     * @param receiverTypeOther �����õ�������������ʹ��루t1:�������ˡ�t2:���˴������⡢t3:��λ�������⡢t4������Ժ��t5:������˾��t6������������Ա��t7����ʦ��������t8����������ֵ
     */
    public void setReceiverTypeOther(String receiverTypeOther){
        this.receiverTypeOther = StringUtils.rightTrim(receiverTypeOther);
    }

    /**
     * ��ȡ������������ʹ��루t1:�������ˡ�t2:���˴������⡢t3:��λ�������⡢t4������Ժ��t5:������˾��t6������������Ա��t7����ʦ��������t8��������
     * @return ������������ʹ��루t1:�������ˡ�t2:���˴������⡢t3:��λ�������⡢t4������Ժ��t5:������˾��t6������������Ա��t7����ʦ��������t8����������ֵ
     */
    public String getReceiverTypeOther(){
        return receiverTypeOther;
    }

    /**
     * ��������������������ƣ�t1:�������ˡ�t2:���˴������⡢t3:��λ�������⡢t4������Ժ��t5:������˾��t6������������Ա��t7����ʦ��������t8��������
     * @param receiverTypeOtherName �����õ�����������������ƣ�t1:�������ˡ�t2:���˴������⡢t3:��λ�������⡢t4������Ժ��t5:������˾��t6������������Ա��t7����ʦ��������t8����������ֵ
     */
    public void setReceiverTypeOtherName(String receiverTypeOtherName){
        this.receiverTypeOtherName = StringUtils.rightTrim(receiverTypeOtherName);
    }

    /**
     * ��ȡ����������������ƣ�t1:�������ˡ�t2:���˴������⡢t3:��λ�������⡢t4������Ժ��t5:������˾��t6������������Ա��t7����ʦ��������t8��������
     * @return ����������������ƣ�t1:�������ˡ�t2:���˴������⡢t3:��λ�������⡢t4������Ժ��t5:������˾��t6������������Ա��t7����ʦ��������t8����������ֵ
     */
    public String getReceiverTypeOtherName(){
        return receiverTypeOtherName;
    }

    /**
     * ��������qq����
     * @param qqNumber �����õ�����qq�����ֵ
     */
    public void setQqNumber(String qqNumber){
        this.qqNumber = StringUtils.rightTrim(qqNumber);
    }

    /**
     * ��ȡ����qq����
     * @return ����qq�����ֵ
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
     * �������Ե�λ��ϵ��
     * @param unitLink �����õ����Ե�λ��ϵ�˵�ֵ
     */
    public void setUnitLink(String unitLink){
        this.unitLink = StringUtils.rightTrim(unitLink);
    }

    /**
     * ��ȡ���Ե�λ��ϵ��
     * @return ���Ե�λ��ϵ�˵�ֵ
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
     * ����������˷�ʽ 0 �Զ���� 1 �˹����
     * @param verifyFlag �����õ�������˷�ʽ 0 �Զ���� 1 �˹���˵�ֵ
     */
    public void setVerifyFlag(String verifyFlag){
        this.verifyFlag = StringUtils.rightTrim(verifyFlag);
    }

    /**
     * ��ȡ������˷�ʽ 0 �Զ���� 1 �˹����
     * @return ������˷�ʽ 0 �Զ���� 1 �˹���˵�ֵ
     */
    public String getVerifyFlag(){
        return verifyFlag;
    }

    /**
     * ��������֪ͨ����
     * @param noticeNo �����õ�����֪ͨ���ŵ�ֵ
     */
    public void setNoticeNo(String noticeNo){
        this.noticeNo = StringUtils.rightTrim(noticeNo);
    }

    /**
     * ��ȡ����֪ͨ����
     * @return ����֪ͨ���ŵ�ֵ
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
