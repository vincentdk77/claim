package com.sinosoft.claim.dto.custom;

import java.io.Serializable;
import java.util.Collection;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �Զ���ͳ�����ݴ������
 * <p>Title: ��������ͳ��DTO</p>
 * <p>Description: ��������ͳ����������</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class StatStatusDto implements Serializable
{
    /** ���Խڵ����� */
    private String nodeType = "";
    /** ���Խڵ��������� */
    private String nodeTypeName = "";
    /** ���Բ���״̬λ */
    private String status = "";
    /** ���Բ���״̬���� */
    private String statusName = "";
    /** ����ͳ������ */
    int count = 0;
    /** ���Ա�־λ */
    private String flag = "";
    /** ���Ա�ע */
    private String remark = "";
    /** ͳ�Ƽ���*/
    private Collection statStatusList;
    /** �û�����*/
    private String userCode;
    /** �û�����*/
    private String userName;
    /** �༭����*/
    private String editType;

     /** ͳ�ƿ�ʼ����*/
    private String startDate;

    /** ͳ�ƽ�������*/
    private String endDate;

    /** ״̬����ֵ*/
    private int waitStatusCount = 0;
    /** ״̬����ֵ*/
    private int procStatusCount = 0;
    /** ״̬����ֵ*/
    private int noSubmitStatusCount = 0;
    /** ״̬����ֵ*/
    private int submitStatusCount = 0;
    /** ״̬����ֵ*/
    private int backStatusCount = 0;



   /**�õ����Խڵ���������
    * @return ���Խڵ���������
    */
    public String getNodeTypeName() {
      return nodeTypeName;
    }

    /**�õ�����ͳ������
     * @return ����ͳ������
     */
    public int getCount() {
      return count;
    }

    /**�õ����Ա�ע
     * @return ���Ա�ע
     */
    public String getRemark() {
      return remark;
    }

    /**�õ����Բ���״̬λ
     * @return ���Բ���״̬λ
     */
    public String getStatus() {
      return status;
    }

    /**�õ�ͳ�Ƽ���
     * @return ͳ�Ƽ���
     */
    public Collection getStatStatusList() {
      return statStatusList;
    }

    /**�õ����Բ���״̬����
     * @return ���Բ���״̬����
     */
    public String getStatusName() {
      return statusName;
    }

    /**�õ����Խڵ�����
     * @return ���Խڵ�����
     */
    public String getNodeType() {
      return nodeType;
    }

   /**�������Ա�־λ
    * @param flag ���Ա�־λ
    */
    public void setFlag(String flag) {
      this.flag = StringUtils.rightTrim(flag);
    }

   /**�������Խڵ���������
    * @param nodeTypeName ���Խڵ���������
    */
    public void setNodeTypeName(String nodeTypeName) {
      this.nodeTypeName = StringUtils.rightTrim(nodeTypeName);
    }

   /**��������ͳ������
    * @param count ����ͳ������
    */
    public void setCount(int count) {
      this.count = count;
    }

   /**�������Ա�ע
    * @param remark ���Ա�ע
    */
    public void setRemark(String remark) {
      this.remark = StringUtils.rightTrim(remark);
    }

   /**�������Բ���״̬λ
    * @param status ���Բ���״̬λ
    */
    public void setStatus(String status) {
      this.status = StringUtils.rightTrim(status);
    }

   /**����ͳ�Ƽ���
    * @param statStatusList ͳ�Ƽ���
    */
    public void setStatStatusList(Collection statStatusList) {
      this.statStatusList = statStatusList;
    }

   /**�������Բ���״̬����
    * @param statusName ���Բ���״̬����
    */
    public void setStatusName(String statusName) {
      this.statusName = StringUtils.rightTrim(statusName);
    }

   /**�������Խڵ�����
    * @param nodeType ���Խڵ�����
    */
    public void setNodeType(String nodeType) {
      this.nodeType = StringUtils.rightTrim(nodeType);
    }

   /**�����û�����
    * @param userCode �û�����
    */
    public void setUserCode(String userCode) {
      this.userCode = StringUtils.rightTrim(userCode);
    }

   /**���ñ༭����
    * @param editType �༭����
    */
    public void setEditType(String editType) {
      this.editType = StringUtils.rightTrim(editType);
    }

   /**�����û�����
    * @param userName �û�����
    */
    public void setUserName(String userName) {
      this.userName = StringUtils.rightTrim(userName);
    }

    /**�õ����Ա�־λ
     * @return  ���Ա�־λ
     */
    public String getFlag() {
      return flag;
    }

    /**�õ��û�����
     * @return  �û�����
     */
    public String getUserCode() {
      return userCode;
    }

    /**�õ��༭����
     * @return  �༭����
     */
    public String getEditType() {
      return editType;
    }

    /**�õ��û�����
     * @return  �û�����
     */
    public String getUserName() {
      return userName;
    }

    public StatStatusDto()
    {
    }



    /**�õ�����ͳ�ƿ�ʼ����
     * @return ����ͳ�ƿ�ʼ����
     */
    public String getStartDate() {
      return startDate;
    }

    /**��������ͳ�ƿ�ʼ����
    * @param startDate ����ͳ�ƿ�ʼ����
    */
    public void setStartDate(String startDate) {
      this.startDate = StringUtils.rightTrim(startDate);
    }

    /**�õ�����ͳ�ƽ�������
     * @return ����ͳ�ƽ�������
     */
    public String getEndDate() {
      return endDate;
    }

    /**��������ͳ�ƽ�������
    * @param endDate ����ͳ�ƽ�������
    */
    public void setEndDate(String endDate) {
      this.endDate = StringUtils.rightTrim(endDate);
    }


    /**
     * ��������״̬����
     * @param waitstatuscount  ״̬����ֵ
     */
    public void setWaitStatusCount (int waitStatusCount ){
        this.waitStatusCount  = waitStatusCount ;
    }

    /**
     * ��ȡ����״̬����
     * @return ״̬����
     */
    public int getWaitStatusCount (){
        return waitStatusCount ;
    }


    /**
     * ��������״̬����
     * @param procstatuscount  ״̬����ֵ
     */
    public void setProcStatusCount (int procStatusCount ){
        this.procStatusCount  = procStatusCount ;
    }

    /**
     * ��ȡ����״̬����
     * @return ״̬����
     */
    public int getProcStatusCount (){
        return procStatusCount ;
    }

    /**
     * ��������״̬����
     * @param nosubmitstatuscount  ״̬����ֵ
     */
    public void setNoSubmitStatusCount (int noSubmitStatusCount ){
        this.noSubmitStatusCount  = noSubmitStatusCount ;
    }

    /**
     * ��ȡ����״̬����
     * @return ״̬����
     */
    public int getNoSubmitStatusCount (){
        return noSubmitStatusCount ;
    }

    /**
     * ��������״̬����
     * @param submitstatuscount  ״̬����ֵ
     */
    public void setSubmitStatusCount (int submitStatusCount ){
        this.submitStatusCount  = submitStatusCount ;
    }

    /**
     * ��ȡ����״̬����
     * @return ״̬����
     */
    public int getSubmitStatusCount (){
        return submitStatusCount ;
    }

    /**
     * ��������״̬����
     * @param backstatuscount  ״̬����ֵ
     */
    public void setBackStatusCount (int backStatusCount ){
        this.backStatusCount  = backStatusCount ;
    }

    /**
     * ��ȡ����״̬����
     * @return ״̬����
     */
    public int getBackStatusCount (){
        return backStatusCount ;
    }


}


