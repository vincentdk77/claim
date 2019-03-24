package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpgtask1������־������ݴ���������<br>
 * ������ 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpGtask1DtoBase implements Serializable{
    /** ������������ */
    private String taskType = "";
    /** ����ģ��� */
    private int modelNo = 0;
    /** ���԰�����ʶ�� */
    private String caseIdNo = "";
    /** ����ҵ��������� */
    private String classCode = "";
    /** �������ִ��� */
    private String riskCode = "";
    /** ���Թ����������� */
    private String comCode = "";
    /** ���Գ����������� */
    private String makeCom = "";
    /** ���Գ�����Ա���� */
    private String operatorCode = "";
    /** ���Ե�֤���� */
    private String certiType = "";
    /** ���Ե�֤���� */
    private String certiNo = "";
    /** ������� */
    private int serialNo = 0;
    /** ���Դ��� */
    private int times = 0;
    /** ������󼶱� */
    private int maxGrade = 0;
    /** ���Խڵ����� */
    private String taskExplain = "";
    /** ��������ʱ�� */
    private DateTime sysTime = new DateTime();
    /** ���Ը��ڵ�� */
    private int fatherNode = 0;
    /** ���Ե�ǰ���� */
    private int currentNode = 0;
    /** �����ӽ��� */
    private int sonNode = 0;
    /** ����Ԥ��ʱ�� */
    private int limitDay = 0;
    /** ����currentgrade */
    private int currentGrade = 0;
    /** ���Դ�����Ա���� */
    private String underWriteCode = "";
    /** ���Դ���ʱ�� */
    private DateTime dealDate = new DateTime();
    /** ���Խڵ�״̬ */
    private String dealResult = "";
    /** ���Դ����ı� */
    private String handleText = "";
    /** ����nextgrade */
    private int nextGrade = 0;
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpGtask1DtoBase����
     */
    public PrpGtask1DtoBase(){
    }

    /**
     * ����������������
     * @param taskType �����õ������������͵�ֵ
     */
    public void setTaskType(String taskType){
        this.taskType = StringUtils.rightTrim(taskType);
    }

    /**
     * ��ȡ������������
     * @return �����������͵�ֵ
     */
    public String getTaskType(){
        return taskType;
    }

    /**
     * ��������ģ���
     * @param modelNo �����õ�����ģ��ŵ�ֵ
     */
    public void setModelNo(int modelNo){
        this.modelNo = modelNo;
    }

    /**
     * ��ȡ����ģ���
     * @return ����ģ��ŵ�ֵ
     */
    public int getModelNo(){
        return modelNo;
    }

    /**
     * �������԰�����ʶ��
     * @param caseIdNo �����õ����԰�����ʶ�ŵ�ֵ
     */
    public void setCaseIdNo(String caseIdNo){
        this.caseIdNo = StringUtils.rightTrim(caseIdNo);
    }

    /**
     * ��ȡ���԰�����ʶ��
     * @return ���԰�����ʶ�ŵ�ֵ
     */
    public String getCaseIdNo(){
        return caseIdNo;
    }

    /**
     * ��������ҵ���������
     * @param classCode �����õ�����ҵ����������ֵ
     */
    public void setClassCode(String classCode){
        this.classCode = StringUtils.rightTrim(classCode);
    }

    /**
     * ��ȡ����ҵ���������
     * @return ����ҵ����������ֵ
     */
    public String getClassCode(){
        return classCode;
    }

    /**
     * �����������ִ���
     * @param riskCode �����õ��������ִ����ֵ
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * ��ȡ�������ִ���
     * @return �������ִ����ֵ
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * �������Թ�����������
     * @param comCode �����õ����Թ������������ֵ
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * ��ȡ���Թ�����������
     * @return ���Թ������������ֵ
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * �������Գ�����������
     * @param makeCom �����õ����Գ������������ֵ
     */
    public void setMakeCom(String makeCom){
        this.makeCom = StringUtils.rightTrim(makeCom);
    }

    /**
     * ��ȡ���Գ�����������
     * @return ���Գ������������ֵ
     */
    public String getMakeCom(){
        return makeCom;
    }

    /**
     * �������Գ�����Ա����
     * @param operatorCode �����õ����Գ�����Ա�����ֵ
     */
    public void setOperatorCode(String operatorCode){
        this.operatorCode = StringUtils.rightTrim(operatorCode);
    }

    /**
     * ��ȡ���Գ�����Ա����
     * @return ���Գ�����Ա�����ֵ
     */
    public String getOperatorCode(){
        return operatorCode;
    }

    /**
     * �������Ե�֤����
     * @param certiType �����õ����Ե�֤���͵�ֵ
     */
    public void setCertiType(String certiType){
        this.certiType = StringUtils.rightTrim(certiType);
    }

    /**
     * ��ȡ���Ե�֤����
     * @return ���Ե�֤���͵�ֵ
     */
    public String getCertiType(){
        return certiType;
    }

    /**
     * �������Ե�֤����
     * @param certiNo �����õ����Ե�֤�����ֵ
     */
    public void setCertiNo(String certiNo){
        this.certiNo = StringUtils.rightTrim(certiNo);
    }

    /**
     * ��ȡ���Ե�֤����
     * @return ���Ե�֤�����ֵ
     */
    public String getCertiNo(){
        return certiNo;
    }

    /**
     * �����������
     * @param serialNo �����õ�������ŵ�ֵ
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ�������
     * @return ������ŵ�ֵ
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * �������Դ���
     * @param times �����õ����Դ�����ֵ
     */
    public void setTimes(int times){
        this.times = times;
    }

    /**
     * ��ȡ���Դ���
     * @return ���Դ�����ֵ
     */
    public int getTimes(){
        return times;
    }

    /**
     * ����������󼶱�
     * @param maxGrade �����õ�������󼶱��ֵ
     */
    public void setMaxGrade(int maxGrade){
        this.maxGrade = maxGrade;
    }

    /**
     * ��ȡ������󼶱�
     * @return ������󼶱��ֵ
     */
    public int getMaxGrade(){
        return maxGrade;
    }

    /**
     * �������Խڵ�����
     * @param taskExplain �����õ����Խڵ����Ƶ�ֵ
     */
    public void setTaskExplain(String taskExplain){
        this.taskExplain = StringUtils.rightTrim(taskExplain);
    }

    /**
     * ��ȡ���Խڵ�����
     * @return ���Խڵ����Ƶ�ֵ
     */
    public String getTaskExplain(){
        return taskExplain;
    }

    /**
     * ������������ʱ��
     * @param sysTime �����õ���������ʱ���ֵ
     */
    public void setSysTime(DateTime sysTime){
        this.sysTime = sysTime;
    }

    /**
     * ��ȡ��������ʱ��
     * @return ��������ʱ���ֵ
     */
    public DateTime getSysTime(){
        return sysTime;
    }

    /**
     * �������Ը��ڵ��
     * @param fatherNode �����õ����Ը��ڵ�ŵ�ֵ
     */
    public void setFatherNode(int fatherNode){
        this.fatherNode = fatherNode;
    }

    /**
     * ��ȡ���Ը��ڵ��
     * @return ���Ը��ڵ�ŵ�ֵ
     */
    public int getFatherNode(){
        return fatherNode;
    }

    /**
     * �������Ե�ǰ����
     * @param currentNode �����õ����Ե�ǰ���ŵ�ֵ
     */
    public void setCurrentNode(int currentNode){
        this.currentNode = currentNode;
    }

    /**
     * ��ȡ���Ե�ǰ����
     * @return ���Ե�ǰ���ŵ�ֵ
     */
    public int getCurrentNode(){
        return currentNode;
    }

    /**
     * ���������ӽ���
     * @param sonNode �����õ������ӽ��ŵ�ֵ
     */
    public void setSonNode(int sonNode){
        this.sonNode = sonNode;
    }

    /**
     * ��ȡ�����ӽ���
     * @return �����ӽ��ŵ�ֵ
     */
    public int getSonNode(){
        return sonNode;
    }

    /**
     * ��������Ԥ��ʱ��
     * @param limitDay �����õ�����Ԥ��ʱ�޵�ֵ
     */
    public void setLimitDay(int limitDay){
        this.limitDay = limitDay;
    }

    /**
     * ��ȡ����Ԥ��ʱ��
     * @return ����Ԥ��ʱ�޵�ֵ
     */
    public int getLimitDay(){
        return limitDay;
    }

    /**
     * ��������currentgrade
     * @param currentGrade �����õ�����currentgrade��ֵ
     */
    public void setCurrentGrade(int currentGrade){
        this.currentGrade = currentGrade;
    }

    /**
     * ��ȡ����currentgrade
     * @return ����currentgrade��ֵ
     */
    public int getCurrentGrade(){
        return currentGrade;
    }

    /**
     * �������Դ�����Ա����
     * @param underWriteCode �����õ����Դ�����Ա�����ֵ
     */
    public void setUnderWriteCode(String underWriteCode){
        this.underWriteCode = StringUtils.rightTrim(underWriteCode);
    }

    /**
     * ��ȡ���Դ�����Ա����
     * @return ���Դ�����Ա�����ֵ
     */
    public String getUnderWriteCode(){
        return underWriteCode;
    }

    /**
     * �������Դ���ʱ��
     * @param dealDate �����õ����Դ���ʱ���ֵ
     */
    public void setDealDate(DateTime dealDate){
        this.dealDate = dealDate;
    }

    /**
     * ��ȡ���Դ���ʱ��
     * @return ���Դ���ʱ���ֵ
     */
    public DateTime getDealDate(){
        return dealDate;
    }

    /**
     * �������Խڵ�״̬
     * @param dealResult �����õ����Խڵ�״̬��ֵ
     */
    public void setDealResult(String dealResult){
        this.dealResult = StringUtils.rightTrim(dealResult);
    }

    /**
     * ��ȡ���Խڵ�״̬
     * @return ���Խڵ�״̬��ֵ
     */
    public String getDealResult(){
        return dealResult;
    }

    /**
     * �������Դ����ı�
     * @param handleText �����õ����Դ����ı���ֵ
     */
    public void setHandleText(String handleText){
        this.handleText = StringUtils.rightTrim(handleText);
    }

    /**
     * ��ȡ���Դ����ı�
     * @return ���Դ����ı���ֵ
     */
    public String getHandleText(){
        return handleText;
    }

    /**
     * ��������nextgrade
     * @param nextGrade �����õ�����nextgrade��ֵ
     */
    public void setNextGrade(int nextGrade){
        this.nextGrade = nextGrade;
    }

    /**
     * ��ȡ����nextgrade
     * @return ����nextgrade��ֵ
     */
    public int getNextGrade(){
        return nextGrade;
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
