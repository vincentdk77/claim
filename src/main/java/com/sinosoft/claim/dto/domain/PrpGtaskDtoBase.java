package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpgtask�˱�����������־������ݴ���������<br>
 * ������ 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpGtaskDtoBase implements Serializable{
    /** ������������ */
    private String taskType = "";
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
    /** ���Դ��� */
    private int times = 0;
    /** ������󼶱� */
    private int maxGrade = 0;
    /** ��������˵�� */
    private String taskExplain = "";
    /** ����ϵͳʱ�� */
    private DateTime sysTime = new DateTime();
    /** ���Ե�ǰ���� */
    private int currentNode = 0;
    /** ���Ե�ǰ���� */
    private int currentGrade = 0;
    /** ���Դ�����Ա���� */
    private String underWriteCode = "";
    /** ���Դ���ʱ�� */
    private DateTime dealDate = new DateTime();
    /** ���Դ����� */
    private String dealResult = "";
    /** ���Դ����ı� */
    private String handleText = "";
    /** ����ת��һ���� */
    private int nextGrade = 0;
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpGtaskDtoBase����
     */
    public PrpGtaskDtoBase(){
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
     * ������������˵��
     * @param taskExplain �����õ���������˵����ֵ
     */
    public void setTaskExplain(String taskExplain){
        this.taskExplain = StringUtils.rightTrim(taskExplain);
    }

    /**
     * ��ȡ��������˵��
     * @return ��������˵����ֵ
     */
    public String getTaskExplain(){
        return taskExplain;
    }

    /**
     * ��������ϵͳʱ��
     * @param sysTime �����õ�����ϵͳʱ���ֵ
     */
    public void setSysTime(DateTime sysTime){
        this.sysTime = sysTime;
    }

    /**
     * ��ȡ����ϵͳʱ��
     * @return ����ϵͳʱ���ֵ
     */
    public DateTime getSysTime(){
        return sysTime;
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
     * �������Ե�ǰ����
     * @param currentGrade �����õ����Ե�ǰ�����ֵ
     */
    public void setCurrentGrade(int currentGrade){
        this.currentGrade = currentGrade;
    }

    /**
     * ��ȡ���Ե�ǰ����
     * @return ���Ե�ǰ�����ֵ
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
     * �������Դ�����
     * @param dealResult �����õ����Դ�������ֵ
     */
    public void setDealResult(String dealResult){
        this.dealResult = StringUtils.rightTrim(dealResult);
    }

    /**
     * ��ȡ���Դ�����
     * @return ���Դ�������ֵ
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
     * ��������ת��һ����
     * @param nextGrade �����õ�����ת��һ�����ֵ
     */
    public void setNextGrade(int nextGrade){
        this.nextGrade = nextGrade;
    }

    /**
     * ��ȡ����ת��һ����
     * @return ����ת��һ�����ֵ
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
