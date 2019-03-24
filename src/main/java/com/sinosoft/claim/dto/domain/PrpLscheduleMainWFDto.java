package com.sinosoft.claim.dto.domain;
import java.io.Serializable;
import java.util.Collection;

import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLscheduleMainWF�����ݴ��������<br>
 * ������ 2005-03-18 16:42:18.437<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLscheduleMainWFDto extends PrpLscheduleMainWFDtoBase implements Serializable{
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLscheduleMainWFDto����
     */
    public PrpLscheduleMainWFDto(){
    }
   /** ���Բ������� */
    private String claimComName = "";
    /** ���Բ���Ա���� */
    private String operatorName = "";
    /** ������ϵ�绰 */
   private String phoneNumber = "";
   /** ������ϵ�� */
   private String linkerName = "";
   /**������ϸ���������ժҪ*/
   private String registText = "";
   /**�ڵ�״̬��Ϣ*/
   private String status="";
   /**�鿱����Ա����*/
   private String checkOperatorName = "";//Modify By sunhao 2004-08-24
   /**���ƺ���*/
   private String licenseNo = "";//Modify By sunhao 2004-08-24

   /** ���Գ��մ��� */
    private int perilCount = 0;
    /** �½ڵ��˵Ĵ��� */
    private String newHandlerCode = "";
  
   /**�������� cancel ��ʾ�ǳ����ı��� getback ��ʾ��ȡ�صı��� ������Ϊ��������*/
   private String saveType="";

   /** ������ʾ�б�*/
   private Collection scheduleList ;

   /** ���԰���˫����־ add by liyanjie 2005-12-06*/
   private String commiFlag ;
   
// mdoify by wangli  add start 20050416  
   /** ���Դ����˴���*/
   private String agentCode = "";
   
   /** ���Դ���������*/
   private String agentName = "";

    /** ���Թ����� */
    private double estimateLoss = 0d;
    
      //modify by wangwei add start 205-6-13
    /** ���Թ������ */
    private double estimateFee = 0d;
    
    //add by zhaolu 20060801 start
    TurnPageDto turnPageDto = null;
    //add by zhaolu 20060801 end
    
    
    /**
     * �������Թ������
     * @param estimateFee �����õ����Թ������
     */
    public void setEstimateFee(double estimateFee){
        this.estimateFee = estimateFee;
    }

    /**
     * ��ȡ���Թ������
     * @return �������Թ������
     */
    public double getEstimateFee(){
        return estimateFee;
    }
    //modify by wangwei add end 2005-6-13
   
   
   /**
    * @return Returns the agentCode.
    */
   public String getAgentCode() {
   	return agentCode;
   }
   /**
    * @param agentCode The agentCode to set.
    */
   public void setAgentCode(String agentCode) {
   	this.agentCode = agentCode;
   }
   /**
    * @return Returns the agentName.
    */
   public String getAgentName() {
   	return agentName;
   }
   /**
    * @param agentName The agentName to set.
    */
   public void setAgentName(String agentName) {
   	this.agentName = agentName;
   }
   
  //mdoify by wangli  add end 20050416  
   
    /**
     * �������Բ���
     * @param comName �����õ����Բ��ŵ�ֵ
     */
    public void setClaimComName(String claimComName){
        this.claimComName = StringUtils.rightTrim(claimComName);
    }

    /**
     * ��ȡ���Բ���
     * @return ���Բ��ŵ�ֵ
     */
    public String getClaimComName(){
        return claimComName;
    }

    /**
     * �������Բ���Ա����
     * @param operatorName �����õ����Բ���Ա���Ƶ�ֵ
     */
    public void setOperatorName(String operatorName){
        this.operatorName = StringUtils.rightTrim(operatorName);
    }

    /**
     * ��ȡ���Բ���Ա����
     * @return ���Բ���Ա���Ƶ�ֵ
     */
    public String getOperatorName(){
        return operatorName;
    }

    /**
    * ����������ϵ�绰
    * @param phoneNumber �����õ�������ϵ�绰��ֵ
    */
   public void setPhoneNumber(String phoneNumber){
       this.phoneNumber = StringUtils.rightTrim(phoneNumber);
   }

   /**
    * ��ȡ������ϵ�绰
    * @return ������ϵ�绰��ֵ
    */
   public String getPhoneNumber(){
       return phoneNumber;
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
   * �������Գ�����ϸ���������ժҪ
   * @param registText �����õ����Գ�����ϸ���������ժҪ��ֵ
   */
  public void setRegistText(String registText){
      this.registText = StringUtils.rightTrim(registText);
  }

  /**
   * ��ȡ���Գ�����ϸ���������ժҪ
   * @return ���Գ�����ϸ���������ժҪ��ֵ
   */
  public String getRegistText(){
      return registText;
  }
 /**
     * ��ȡ���Բ���״̬
     * @return ���Բ���״̬
     */
    public String getStatus(){
        return status;
    }

    /**
     * �������Բ���״̬
     * @param status �����õ����Բ���״̬
     */
    public void setStatus(String status){
        this.status = StringUtils.rightTrim(status);
    }

    /**����������ʾ�б�
     * @param prpLctextList ������ʾ�б�
     */
    public void setScheduleList(Collection scheduleList) {
      this.scheduleList = scheduleList;
    }

  /**�õ�������ʾ�б�
  * @return ������ʾ�б�
  */
    public Collection getScheduleList() {
      return scheduleList;
    }
    /**
     * ��ȡ����������״̬
     * @return ����������״̬
     */
    public String getSaveType(){
        return saveType;
    }

    /**
     * ���ñ���������״̬
     * @param saveType �����õı���������״̬
     */
    public void setSaveType(String saveType){
        this.saveType = StringUtils.rightTrim(saveType);
    }

    /**
     * ��ȡ�鿱����Ա����
     * @return �鿱����Ա����
     * Modify By sunhao 2004-08-24
     */
    public String getCheckOperatorName(){
        return checkOperatorName;
    }

    /**
     * ���ò鿱����Ա����
     * @param saveType �����õĲ鿱����Ա����
     * Modify By sunhao 2004-08-24
     */
    public void setCheckOperatorName(String checkOperatorName){
        this.checkOperatorName = StringUtils.rightTrim(checkOperatorName);
    }

    /**
     * ��ȡ���ƺ���
     * @return ���ƺ���
     * Modify By sunhao 2004-08-24
     */
        public String getLicenseNo(){
            return licenseNo;
        }

    /**
     * ���ó��ƺ���
     * @param saveType �����õĳ��ƺ���
     * Modify By sunhao 2004-08-24
     */
    public void setLicenseNo(String licenseNo){
        this.licenseNo = StringUtils.rightTrim(licenseNo);
    }

    /**
     * �������Գ��մ���
     * @param perilCount �����õ����Գ��մ�����ֵ
     */
    public void setPerilCount(int perilCount){
        this.perilCount = perilCount;
    }

    /**
     * ��ȡ���Գ��մ���
     * @return ���Գ��մ�����ֵ
     */
    public int getPerilCount(){
        return perilCount;
    }

    /**
     * ���������½ڵ��˵Ĵ���
     * @param nextHandlerCode �����õ������½ڵ��˵Ĵ����ֵ
     */
    public void setNewHandlerCode(String newHandlerCode){
        this.newHandlerCode = StringUtils.rightTrim(newHandlerCode);
    }

    /**
     * ��ȡ�����½ڵ��˵Ĵ���
     * @return �����½ڵ��˵Ĵ����ֵ
     */
    public String getNewHandlerCode(){
        return newHandlerCode;
    }

    /**
     * �������Թ�����
     * @param estimateLoss �����õ����Թ������ֵ
     */
    public void setEstimateLoss(double estimateLoss){
        this.estimateLoss = estimateLoss;
    }

    /**
     * ��ȡ���Թ�����
     * @return ���Թ������ֵ
     */
    public double getEstimateLoss(){
        return estimateLoss;
    }
    


  public void setTurnPageDto(TurnPageDto turnPageDto) {
    this.turnPageDto = turnPageDto;
  }
 public TurnPageDto getTurnPageDto() {
    return turnPageDto;
  }

 /**
  * �������԰���˫����ʶ
  * @param commiFlag �����õ����԰���˫����ʶ��ֵ
  */
 public void setCommiFlag(String commiFlag){
     this.commiFlag = commiFlag;
 }

 /**
  * ��ȡ���԰���˫����ʶ
  * @return ���԰���˫����ʶ��ֵ
  */
 public String getCommiFlag(){
     return commiFlag;
 }


}
