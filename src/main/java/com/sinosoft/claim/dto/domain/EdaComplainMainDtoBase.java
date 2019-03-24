package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����EdaComplainMainͶ����Ϣ������ݴ���������<br>
 * ������ 2005-08-20 17:55:58.190<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class EdaComplainMainDtoBase implements Serializable{
    /** ����Ͷ�ߵǼǺ� */
    private int acceptNo = 0;
    /** ����Ͷ�߿ͻ����� */
    private String customerCode = "";
    /** ����Ͷ�߿ͻ�����(1����/2����) */
    private String customerType = "";
    /** ����Ͷ�߿ͻ����� */
    private String customerName = "";
    /** ����Ͷ�߶��󣨲��Ŵ��룩 */
    private String comCode = "";
    /** ����Ͷ�߶��󣨲������ƣ� */
    private String comName = "";
    /** ����Ͷ�߶���Ա�����룩 */
    private String userCode = "";
    /** ����Ͷ�߶���Ա�������� */
    private String userName = "";
    /** ������ϵ������ */
    private String linkerName = "";
    /** ����ͨ�ŵ�ַ */
    private String postAddress = "";
    /** ������������ */
    private String postCode = "";
    /** ���Ե绰 */
    private String phoneNumber = "";
    /** �����ƶ��绰 */
    private String mobile = "";
    /** ���Ե����ʼ� */
    private String email = "";
    /** ���Խ������� */
    private String transType = "";
    /** ���������ļ����� */
    private String voiceFile = "";
    /** ���Դ����� */
    private String handleUnit = "";
    /** ���Դ�����Ա���� */
    private String handlerCode = "";
    /** ���Դ�����Ա���� */
    private String handlerName = "";
    /** ���Դ������� */
    private DateTime handleDate = new DateTime();
    /** ���Դ���ʱ�� */
    private String handleTime = "";
    /** ���Դ���״̬ */
    private String handleStatus = "";
    /** ���Խ���Ͷ������ */
    private DateTime listenDate = new DateTime();
    /** ���Խ���Ͷ��ʱ�� */
    private String listenTime = "";
    /** ���Խ�����ϯ���� */
    private String listenAgent = "";
    /** ��������״̬ */
    private String listenStatus = "";
    /** �����Զ������������� */
    private DateTime cleanDate = new DateTime();
    /** �����Զ���������ʱ�� */
    private String cleanTime = "";
    /** �����Զ�����������ϯ���� */
    private String cleanAgent = "";
    /** ���Ա�ע */
    private String remark = "";
    /** ����״̬ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�EdaComplainMainDtoBase����
     */
    public EdaComplainMainDtoBase(){
    }

    /**
     * ��������Ͷ�ߵǼǺ�
     * @param acceptNo �����õ�����Ͷ�ߵǼǺŵ�ֵ
     */
    public void setAcceptNo(int acceptNo){
        this.acceptNo = acceptNo;
    }

    /**
     * ��ȡ����Ͷ�ߵǼǺ�
     * @return ����Ͷ�ߵǼǺŵ�ֵ
     */
    public int getAcceptNo(){
        return acceptNo;
    }

    /**
     * ��������Ͷ�߿ͻ�����
     * @param customerCode �����õ�����Ͷ�߿ͻ������ֵ
     */
    public void setCustomerCode(String customerCode){
        this.customerCode = StringUtils.rightTrim(customerCode);
    }

    /**
     * ��ȡ����Ͷ�߿ͻ�����
     * @return ����Ͷ�߿ͻ������ֵ
     */
    public String getCustomerCode(){
        return customerCode;
    }

    /**
     * ��������Ͷ�߿ͻ�����(1����/2����)
     * @param customerType �����õ�����Ͷ�߿ͻ�����(1����/2����)��ֵ
     */
    public void setCustomerType(String customerType){
        this.customerType = StringUtils.rightTrim(customerType);
    }

    /**
     * ��ȡ����Ͷ�߿ͻ�����(1����/2����)
     * @return ����Ͷ�߿ͻ�����(1����/2����)��ֵ
     */
    public String getCustomerType(){
        return customerType;
    }

    /**
     * ��������Ͷ�߿ͻ�����
     * @param customerName �����õ�����Ͷ�߿ͻ����Ƶ�ֵ
     */
    public void setCustomerName(String customerName){
        this.customerName = StringUtils.rightTrim(customerName);
    }

    /**
     * ��ȡ����Ͷ�߿ͻ�����
     * @return ����Ͷ�߿ͻ����Ƶ�ֵ
     */
    public String getCustomerName(){
        return customerName;
    }

    /**
     * ��������Ͷ�߶��󣨲��Ŵ��룩
     * @param comCode �����õ�����Ͷ�߶��󣨲��Ŵ��룩��ֵ
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * ��ȡ����Ͷ�߶��󣨲��Ŵ��룩
     * @return ����Ͷ�߶��󣨲��Ŵ��룩��ֵ
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * ��������Ͷ�߶��󣨲������ƣ�
     * @param comName �����õ�����Ͷ�߶��󣨲������ƣ���ֵ
     */
    public void setComName(String comName){
        this.comName = StringUtils.rightTrim(comName);
    }

    /**
     * ��ȡ����Ͷ�߶��󣨲������ƣ�
     * @return ����Ͷ�߶��󣨲������ƣ���ֵ
     */
    public String getComName(){
        return comName;
    }

    /**
     * ��������Ͷ�߶���Ա�����룩
     * @param userCode �����õ�����Ͷ�߶���Ա�����룩��ֵ
     */
    public void setUserCode(String userCode){
        this.userCode = StringUtils.rightTrim(userCode);
    }

    /**
     * ��ȡ����Ͷ�߶���Ա�����룩
     * @return ����Ͷ�߶���Ա�����룩��ֵ
     */
    public String getUserCode(){
        return userCode;
    }

    /**
     * ��������Ͷ�߶���Ա��������
     * @param userName �����õ�����Ͷ�߶���Ա����������ֵ
     */
    public void setUserName(String userName){
        this.userName = StringUtils.rightTrim(userName);
    }

    /**
     * ��ȡ����Ͷ�߶���Ա��������
     * @return ����Ͷ�߶���Ա����������ֵ
     */
    public String getUserName(){
        return userName;
    }

    /**
     * ����������ϵ������
     * @param linkerName �����õ�������ϵ�����Ƶ�ֵ
     */
    public void setLinkerName(String linkerName){
        this.linkerName = StringUtils.rightTrim(linkerName);
    }

    /**
     * ��ȡ������ϵ������
     * @return ������ϵ�����Ƶ�ֵ
     */
    public String getLinkerName(){
        return linkerName;
    }

    /**
     * ��������ͨ�ŵ�ַ
     * @param postAddress �����õ�����ͨ�ŵ�ַ��ֵ
     */
    public void setPostAddress(String postAddress){
        this.postAddress = StringUtils.rightTrim(postAddress);
    }

    /**
     * ��ȡ����ͨ�ŵ�ַ
     * @return ����ͨ�ŵ�ַ��ֵ
     */
    public String getPostAddress(){
        return postAddress;
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
     * �������Ե绰
     * @param phoneNumber �����õ����Ե绰��ֵ
     */
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = StringUtils.rightTrim(phoneNumber);
    }

    /**
     * ��ȡ���Ե绰
     * @return ���Ե绰��ֵ
     */
    public String getPhoneNumber(){
        return phoneNumber;
    }

    /**
     * ���������ƶ��绰
     * @param mobile �����õ������ƶ��绰��ֵ
     */
    public void setMobile(String mobile){
        this.mobile = StringUtils.rightTrim(mobile);
    }

    /**
     * ��ȡ�����ƶ��绰
     * @return �����ƶ��绰��ֵ
     */
    public String getMobile(){
        return mobile;
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
     * �������Խ�������
     * @param transType �����õ����Խ������͵�ֵ
     */
    public void setTransType(String transType){
        this.transType = StringUtils.rightTrim(transType);
    }

    /**
     * ��ȡ���Խ�������
     * @return ���Խ������͵�ֵ
     */
    public String getTransType(){
        return transType;
    }

    /**
     * �������������ļ�����
     * @param voiceFile �����õ����������ļ����Ƶ�ֵ
     */
    public void setVoiceFile(String voiceFile){
        this.voiceFile = StringUtils.rightTrim(voiceFile);
    }

    /**
     * ��ȡ���������ļ�����
     * @return ���������ļ����Ƶ�ֵ
     */
    public String getVoiceFile(){
        return voiceFile;
    }

    /**
     * �������Դ�����
     * @param handleUnit �����õ����Դ����ŵ�ֵ
     */
    public void setHandleUnit(String handleUnit){
        this.handleUnit = StringUtils.rightTrim(handleUnit);
    }

    /**
     * ��ȡ���Դ�����
     * @return ���Դ����ŵ�ֵ
     */
    public String getHandleUnit(){
        return handleUnit;
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
     * �������Դ�������
     * @param handleDate �����õ����Դ������ڵ�ֵ
     */
    public void setHandleDate(DateTime handleDate){
        this.handleDate = handleDate;
    }

    /**
     * ��ȡ���Դ�������
     * @return ���Դ������ڵ�ֵ
     */
    public DateTime getHandleDate(){
        return handleDate;
    }

    /**
     * �������Դ���ʱ��
     * @param handleTime �����õ����Դ���ʱ���ֵ
     */
    public void setHandleTime(String handleTime){
        this.handleTime = StringUtils.rightTrim(handleTime);
    }

    /**
     * ��ȡ���Դ���ʱ��
     * @return ���Դ���ʱ���ֵ
     */
    public String getHandleTime(){
        return handleTime;
    }

    /**
     * �������Դ���״̬
     * @param handleStatus �����õ����Դ���״̬��ֵ
     */
    public void setHandleStatus(String handleStatus){
        this.handleStatus = StringUtils.rightTrim(handleStatus);
    }

    /**
     * ��ȡ���Դ���״̬
     * @return ���Դ���״̬��ֵ
     */
    public String getHandleStatus(){
        return handleStatus;
    }

    /**
     * �������Խ���Ͷ������
     * @param listenDate �����õ����Խ���Ͷ�����ڵ�ֵ
     */
    public void setListenDate(DateTime listenDate){
        this.listenDate = listenDate;
    }

    /**
     * ��ȡ���Խ���Ͷ������
     * @return ���Խ���Ͷ�����ڵ�ֵ
     */
    public DateTime getListenDate(){
        return listenDate;
    }

    /**
     * �������Խ���Ͷ��ʱ��
     * @param listenTime �����õ����Խ���Ͷ��ʱ���ֵ
     */
    public void setListenTime(String listenTime){
        this.listenTime = StringUtils.rightTrim(listenTime);
    }

    /**
     * ��ȡ���Խ���Ͷ��ʱ��
     * @return ���Խ���Ͷ��ʱ���ֵ
     */
    public String getListenTime(){
        return listenTime;
    }

    /**
     * �������Խ�����ϯ����
     * @param listenAgent �����õ����Խ�����ϯ�����ֵ
     */
    public void setListenAgent(String listenAgent){
        this.listenAgent = StringUtils.rightTrim(listenAgent);
    }

    /**
     * ��ȡ���Խ�����ϯ����
     * @return ���Խ�����ϯ�����ֵ
     */
    public String getListenAgent(){
        return listenAgent;
    }

    /**
     * ������������״̬
     * @param listenStatus �����õ���������״̬��ֵ
     */
    public void setListenStatus(String listenStatus){
        this.listenStatus = StringUtils.rightTrim(listenStatus);
    }

    /**
     * ��ȡ��������״̬
     * @return ��������״̬��ֵ
     */
    public String getListenStatus(){
        return listenStatus;
    }

    /**
     * ���������Զ�������������
     * @param cleanDate �����õ������Զ������������ڵ�ֵ
     */
    public void setCleanDate(DateTime cleanDate){
        this.cleanDate = cleanDate;
    }

    /**
     * ��ȡ�����Զ�������������
     * @return �����Զ������������ڵ�ֵ
     */
    public DateTime getCleanDate(){
        return cleanDate;
    }

    /**
     * ���������Զ���������ʱ��
     * @param cleanTime �����õ������Զ���������ʱ���ֵ
     */
    public void setCleanTime(String cleanTime){
        this.cleanTime = StringUtils.rightTrim(cleanTime);
    }

    /**
     * ��ȡ�����Զ���������ʱ��
     * @return �����Զ���������ʱ���ֵ
     */
    public String getCleanTime(){
        return cleanTime;
    }

    /**
     * ���������Զ�����������ϯ����
     * @param cleanAgent �����õ������Զ�����������ϯ�����ֵ
     */
    public void setCleanAgent(String cleanAgent){
        this.cleanAgent = StringUtils.rightTrim(cleanAgent);
    }

    /**
     * ��ȡ�����Զ�����������ϯ����
     * @return �����Զ�����������ϯ�����ֵ
     */
    public String getCleanAgent(){
        return cleanAgent;
    }

    /**
     * �������Ա�ע
     * @param remark �����õ����Ա�ע��ֵ
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * ��ȡ���Ա�ע
     * @return ���Ա�ע��ֵ
     */
    public String getRemark(){
        return remark;
    }

    /**
     * ��������״̬
     * @param flag �����õ�����״̬��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ����״̬
     * @return ����״̬��ֵ
     */
    public String getFlag(){
        return flag;
    }
}
