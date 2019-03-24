package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLbackVisit--�ط���Ϣ��������ݴ���������<br>
 * ������ 2005-03-25 20:44:41.906<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLbackVisitDtoBase implements Serializable{
    /** ���Կͻ��طü�¼ID */
    private int backVisitID = 0;
    /** ���Ա������� */
    private String registNo = "";
    /** ����ҵ������ */
    private String backVisitType = "";
    /** ���Ա������� */
    private String policyNo = "";
    /** ���Գ��ƺ��� */
    private String licenseNo = "";
    /** ���Ա������˴��� */
    private String insuredCode = "";
    /** ���Ա����������� */
    private String insuredName = "";
    /** ���Կͻ����� */
    private String customType = "";
    /** ������ϵ�绰 */
    private String phone = "";
    /** ���Դ��� */
    private String fax = "";
    /** ������������ */
    private String postCode = "";
    /** ���Ե����ʼ� */
    private String email = "";
    /** ������ϵ�� */
    private String linkerName = "";
    /** ������ϵ��ַ */
    private String address = "";
    /** ���Դ�����Ա���� */
    private String handlerCode = "";
    /** ���Դ�����Ա���� */
    private String handlerName = "";
    /** ���Դ����� */
    private String handleDept = "";
    /** ���Իط�ʱ�� */
    private String backVisitTime = "";
    /** ���Կͻ������ */
    private String customOpinion = "";
    /** ����ת�Ӳ��� */
    private String deliverDepart = "";
    /** ����ת��ʱ�� */
    private String deliverTime = "";
    /** ����ת�Ӿ����� */
    private String deliverPerson = "";
    /** ���Է���ʱ�� */
    private String deliverBackTime = "";
    /** ���Դ𸴿ͻ�ʱ�� */
    private String backCustomTime = "";
    /** ���Դ߰��־ */
    private String hurryFlag = "";
    /** ���Իط�״̬ */
    private String status = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLbackVisitDtoBase����
     */
    public PrpLbackVisitDtoBase(){
    }

    /**
     * �������Կͻ��طü�¼ID
     * @param backVisitID �����õ����Կͻ��طü�¼ID��ֵ
     */
    public void setBackVisitID(int backVisitID){
        this.backVisitID = backVisitID;
    }

    /**
     * ��ȡ���Կͻ��طü�¼ID
     * @return ���Կͻ��طü�¼ID��ֵ
     */
    public int getBackVisitID(){
        return backVisitID;
    }

    /**
     * �������Ա�������
     * @param registNo �����õ����Ա��������ֵ
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * ��ȡ���Ա�������
     * @return ���Ա��������ֵ
     */
    public String getRegistNo(){
        return registNo;
    }

    /**
     * ��������ҵ������
     * @param backVisitType �����õ�����ҵ�����͵�ֵ
     */
    public void setBackVisitType(String backVisitType){
        this.backVisitType = StringUtils.rightTrim(backVisitType);
    }

    /**
     * ��ȡ����ҵ������
     * @return ����ҵ�����͵�ֵ
     */
    public String getBackVisitType(){
        return backVisitType;
    }

    /**
     * �������Ա�������
     * @param policyNo �����õ����Ա��������ֵ
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * ��ȡ���Ա�������
     * @return ���Ա��������ֵ
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * �������Գ��ƺ���
     * @param licenseNo �����õ����Գ��ƺ����ֵ
     */
    public void setLicenseNo(String licenseNo){
        this.licenseNo = StringUtils.rightTrim(licenseNo);
    }

    /**
     * ��ȡ���Գ��ƺ���
     * @return ���Գ��ƺ����ֵ
     */
    public String getLicenseNo(){
        return licenseNo;
    }

    /**
     * �������Ա������˴���
     * @param insuredCode �����õ����Ա������˴����ֵ
     */
    public void setInsuredCode(String insuredCode){
        this.insuredCode = StringUtils.rightTrim(insuredCode);
    }

    /**
     * ��ȡ���Ա������˴���
     * @return ���Ա������˴����ֵ
     */
    public String getInsuredCode(){
        return insuredCode;
    }

    /**
     * �������Ա�����������
     * @param insuredName �����õ����Ա����������Ƶ�ֵ
     */
    public void setInsuredName(String insuredName){
        this.insuredName = StringUtils.rightTrim(insuredName);
    }

    /**
     * ��ȡ���Ա�����������
     * @return ���Ա����������Ƶ�ֵ
     */
    public String getInsuredName(){
        return insuredName;
    }

    /**
     * �������Կͻ�����
     * @param customType �����õ����Կͻ����͵�ֵ
     */
    public void setCustomType(String customType){
        this.customType = StringUtils.rightTrim(customType);
    }

    /**
     * ��ȡ���Կͻ�����
     * @return ���Կͻ����͵�ֵ
     */
    public String getCustomType(){
        return customType;
    }

    /**
     * ����������ϵ�绰
     * @param phone �����õ�������ϵ�绰��ֵ
     */
    public void setPhone(String phone){
        this.phone = StringUtils.rightTrim(phone);
    }

    /**
     * ��ȡ������ϵ�绰
     * @return ������ϵ�绰��ֵ
     */
    public String getPhone(){
        return phone;
    }

    /**
     * �������Դ���
     * @param fax �����õ����Դ����ֵ
     */
    public void setFax(String fax){
        this.fax = StringUtils.rightTrim(fax);
    }

    /**
     * ��ȡ���Դ���
     * @return ���Դ����ֵ
     */
    public String getFax(){
        return fax;
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
     * ����������ϵ��
     * @param linkerName �����õ�������ϵ�˵�ֵ
     */
    public void setLinkerName(String linkerName){
        this.linkerName = StringUtils.rightTrim(linkerName);
    }

    /**
     * ��ȡ������ϵ��
     * @return ������ϵ�˵�ֵ
     */
    public String getLinkerName(){
        return linkerName;
    }

    /**
     * ����������ϵ��ַ
     * @param address �����õ�������ϵ��ַ��ֵ
     */
    public void setAddress(String address){
        this.address = StringUtils.rightTrim(address);
    }

    /**
     * ��ȡ������ϵ��ַ
     * @return ������ϵ��ַ��ֵ
     */
    public String getAddress(){
        return address;
    }

    /**
     * �������Դ�����Ա����
     * @param handlerCode �����õ����Դ�����Ա�����ֵ
     */
    public void setHandlerCode(String handlerCode){
        this.handlerCode = StringUtils.rightTrim(handlerCode);
    }

    /**
     * ��ȡ���Դ�����Ա����
     * @return ���Դ�����Ա�����ֵ
     */
    public String getHandlerCode(){
        return handlerCode;
    }

    /**
     * �������Դ�����Ա����
     * @param handlerName �����õ����Դ�����Ա���Ƶ�ֵ
     */
    public void setHandlerName(String handlerName){
        this.handlerName = StringUtils.rightTrim(handlerName);
    }

    /**
     * ��ȡ���Դ�����Ա����
     * @return ���Դ�����Ա���Ƶ�ֵ
     */
    public String getHandlerName(){
        return handlerName;
    }

    /**
     * �������Դ�����
     * @param handleDept �����õ����Դ����ŵ�ֵ
     */
    public void setHandleDept(String handleDept){
        this.handleDept = StringUtils.rightTrim(handleDept);
    }

    /**
     * ��ȡ���Դ�����
     * @return ���Դ����ŵ�ֵ
     */
    public String getHandleDept(){
        return handleDept;
    }

    /**
     * �������Իط�ʱ��
     * @param backVisitTime �����õ����Իط�ʱ���ֵ
     */
    public void setBackVisitTime(String backVisitTime){
        this.backVisitTime = StringUtils.rightTrim(backVisitTime);
    }

    /**
     * ��ȡ���Իط�ʱ��
     * @return ���Իط�ʱ���ֵ
     */
    public String getBackVisitTime(){
        return backVisitTime;
    }

    /**
     * �������Կͻ������
     * @param customOpinion �����õ����Կͻ�����ȵ�ֵ
     */
    public void setCustomOpinion(String customOpinion){
        this.customOpinion = StringUtils.rightTrim(customOpinion);
    }

    /**
     * ��ȡ���Կͻ������
     * @return ���Կͻ�����ȵ�ֵ
     */
    public String getCustomOpinion(){
        return customOpinion;
    }

    /**
     * ��������ת�Ӳ���
     * @param deliverDepart �����õ�����ת�Ӳ��ŵ�ֵ
     */
    public void setDeliverDepart(String deliverDepart){
        this.deliverDepart = StringUtils.rightTrim(deliverDepart);
    }

    /**
     * ��ȡ����ת�Ӳ���
     * @return ����ת�Ӳ��ŵ�ֵ
     */
    public String getDeliverDepart(){
        return deliverDepart;
    }

    /**
     * ��������ת��ʱ��
     * @param deliverTime �����õ�����ת��ʱ���ֵ
     */
    public void setDeliverTime(String deliverTime){
        this.deliverTime = StringUtils.rightTrim(deliverTime);
    }

    /**
     * ��ȡ����ת��ʱ��
     * @return ����ת��ʱ���ֵ
     */
    public String getDeliverTime(){
        return deliverTime;
    }

    /**
     * ��������ת�Ӿ�����
     * @param deliverPerson �����õ�����ת�Ӿ����˵�ֵ
     */
    public void setDeliverPerson(String deliverPerson){
        this.deliverPerson = StringUtils.rightTrim(deliverPerson);
    }

    /**
     * ��ȡ����ת�Ӿ�����
     * @return ����ת�Ӿ����˵�ֵ
     */
    public String getDeliverPerson(){
        return deliverPerson;
    }

    /**
     * �������Է���ʱ��
     * @param deliverBackTime �����õ����Է���ʱ���ֵ
     */
    public void setDeliverBackTime(String deliverBackTime){
        this.deliverBackTime = StringUtils.rightTrim(deliverBackTime);
    }

    /**
     * ��ȡ���Է���ʱ��
     * @return ���Է���ʱ���ֵ
     */
    public String getDeliverBackTime(){
        return deliverBackTime;
    }

    /**
     * �������Դ𸴿ͻ�ʱ��
     * @param backCustomTime �����õ����Դ𸴿ͻ�ʱ���ֵ
     */
    public void setBackCustomTime(String backCustomTime){
        this.backCustomTime = StringUtils.rightTrim(backCustomTime);
    }

    /**
     * ��ȡ���Դ𸴿ͻ�ʱ��
     * @return ���Դ𸴿ͻ�ʱ���ֵ
     */
    public String getBackCustomTime(){
        return backCustomTime;
    }

    /**
     * �������Դ߰��־
     * @param hurryFlag �����õ����Դ߰��־��ֵ
     */
    public void setHurryFlag(String hurryFlag){
        this.hurryFlag = StringUtils.rightTrim(hurryFlag);
    }

    /**
     * ��ȡ���Դ߰��־
     * @return ���Դ߰��־��ֵ
     */
    public String getHurryFlag(){
        return hurryFlag;
    }

    /**
     * �������Իط�״̬
     * @param status �����õ����Իط�״̬��ֵ
     */
    public void setStatus(String status){
        this.status = StringUtils.rightTrim(status);
    }

    /**
     * ��ȡ���Իط�״̬
     * @return ���Իط�״̬��ֵ
     */
    public String getStatus(){
        return status;
    }

    /**
     * �������Ա�־�ֶ�
     * @param flag �����õ����Ա�־�ֶε�ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ���Ա�־�ֶ�
     * @return ���Ա�־�ֶε�ֵ
     */
    public String getFlag(){
        return flag;
    }
}
