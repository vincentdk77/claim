package com.sinosoft.workbench.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

import com.sinosoft.claim.dto.custom.CompensateFeeDto;
import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prplregist������Ϣ������ݴ��������<br>
 * ������ 2004-4-5 15:31:56<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLregistDto extends PrpLregistDtoBase implements Serializable{
	
    private int countdate=0;
	 /** ���Ա�����־ */  
    private String registFlag = "";
    /** ���Ծ��������� */  
    private String handlerName = "";
    /** ���Ծ��������� */
    private String handler1Name = "";
    /** ���Բ������� */
    private String comName = "";
    /** ������������ */
    private String startDate = "";
    /** ���Բ���Ա���� */
    private String operatorName = "";
    /** ��������Ǽǻ��� */
    private String makeComName = "";
    /** �����ձ����� */
    private String endDate = "";
    /** ������������ */
    private String clauseName = "";
    /** ���Գ��տ�ʼ���� */
    private String damageStartMinute = "";
    /** ���Դ���λ���� */
    private String handleUnitName = "";
    /** ���ԽӰ��˴��� */
    private String receiverCode = "";
    /** �����¹����漰���� */
    private String referKind = "";
    /** �༭���� */
    private String editType = "";
    /** ���Ա������� */
    private String reportMinute = "";
    /** ������� */
    private String payFlag = "";
    /** ���� */
    private String certiNo = "";
    /** �������� */
    private String certiType = "";
    /** ������������ */
    private long personDeathB = 0;
    /** ������������ */
    private long personInjureB = 0;
    /** ������Ա������ */
    private long personDeathD1 = 0;
    /** ������Ա������ */
    private long personInjureD1 = 0;

    /**���Դ˱����Ĳ���״̬ 1��δ���� 2�����ڴ��� 3������� 4�����ύ 5�� ���� */
    private String status = "";//Modify By Sunhao,2004-08-24
    /**�ұ������*/
    private String estiCurrencyName="";
    
    /**�����������*/
    private String customerType = "";

    /**���Դ˱����Ĳ���ʱ��*/
    private DateTime operateDate = new DateTime();//Modify By Sunhao,2004-08-24

    /** ���Գ��մ��� */
    private int perilCount = 0;
    /** �������N����մ��� */
    private int recentCount = 0;
    /** �������̱�� */
    private String flowID = "";

    /**���м�¼�ı��*/
    private int serialNo=0;

    /** ���ȱ�ĵ���ϸ����*/
    private String scheduleItemNote="";

    /**����ԭ�����*/
    private String prpLregistDamageCode = "";

    /**�¹�ԭ�����*/
    private String prpLregistDamageTypeCode = "";
    
    /**�¹�����Ԥ������*/
    private String indemnityDuty = "";
      /** ���Ա����� */
    private String lossItemCode = "";
    /** �б�*/ 
   Collection registList ;
    /** һҳ����*/
   TurnPageDto turnPageDto = null ;
   /**���ս��*/
   private double sumAmount = 0D;
  
   //mdoify by qinyongli  add begin  20050719   
   /**������Ϣ*/
   private String coinsFlag = "";
   //modify end
   
   //mdoify by wangli  add start 20050416  
   /** ���Դ����˴���*/
   private String agentCode = "";
   
   /** ���Դ���������*/
   private String agentName = "";
   
   /** ����ϵͳʱ�� */
   private  DateTime flowInTime = new DateTime();
   
   private  DateTime signDate = new DateTime();
   private  DateTime underWriteEndDate = new DateTime();
   private String othFlag = ""; 
   
   /** ���Ա���������ʾ���� */
   private String insuredNameShow = "";
   
   /** ����Ͷ���˵�λ��ʾ���� */
   private String appliNameShow = "";
   
   
   //modify by liuyanmei add 20051114 start
   private int startHour = 0;
   private int endHour = 0;
   
   private CompensateFeeDto compensateFeeDto;
   
   //��Ӧ�Ĺ�����ID
   private String workFlowId;
   
   //�����ֶι�������
   //add by zhouliu start at 2006-6-9
   //reason:ǿ����ѯ
   private Collection relatepolicyNo=null;
   //add by zhouliu end at 2006-6-9
   
   //add by wunier 20071228
   //reason:����ũ��ͳ���е��⸶�����Լ���Ӧ��������λ
   private String lossesUnitCode;
   private double lossesNumber;
   //end by wunier 20071228
   private String businessType;
   private String businessType1;
   //�����־��0��ֱ��ҵ��1������ҵ��
   private String businessFlag = "";
   //������־����Ӧprpcmain�е�otherFlag��
   private String otherFlag = ""; 
   //�ⰸ�������
   private String claimTypeName = "";
   /**
    * �������Ա�����������
    * @param insuredName �����õ����Ա����������Ƶ�ֵ
    */
   public void setInsuredNameShow(String insuredNameShow){
       this.insuredNameShow = StringUtils.rightTrim(insuredNameShow);
   }

   /**
    * ��ȡ���Ա�����������
    * @return ���Ա����������Ƶ�ֵ
    */
   public String getInsuredNameShow(){
       return insuredNameShow;
   }
   
   /**
    * ��������Ͷ���˵�λ����
    * @param insuredName �����õ�����Ͷ���˵�λ���Ƶ�ֵ
    */
   public void setAppliNameShow(String appliNameShow){
       this.appliNameShow = StringUtils.rightTrim(appliNameShow);
   }

   /**
    * ��ȡ����Ͷ���˵�λ����
    * @return ����Ͷ���˵�λ���Ƶ�ֵ
    */
   public String getAppliNameShow(){
       return appliNameShow;
   }
   
   //�ձ�ʱ��
   public void setEndHour(int endHour){
    this.endHour = endHour;
    }

   public int getEndHour(){
    return endHour;
   }
   //��ʱ��
   public void setStartHour(int startHour){
    this.startHour = startHour;
   }

   public int getStartHour(){
    return startHour;
   }
   
   //modify by liuyanmei add 20051114 end 
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
   
   /**
    * @return Returns the flowInTime.
    */
   public DateTime getFlowInTime() {
   	return flowInTime;
   }
   /**
    * @param flowInTime The flowInTime to set.
    */
   public void setFlowInTime(DateTime flowInTime) {
   	this.flowInTime = flowInTime;
   }
   
  //mdoify by wangli  add end 20050416  
 
  
   
   
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLregistDto����
     */


    public PrpLregistDto(){
    }

    /**
     * �������Բ���Ա����
     * @param makeComName �����õ����Բ���Ա���Ƶ�ֵ
     */
    public void setMakeComName(String makeComName){
        this.makeComName = StringUtils.rightTrim(makeComName);
    }

    /**
     * ��ȡ��������Ǽǻ���
     * @return ��������Ǽǻ�����ֵ
     */
    public String getMakeComName(){
        return makeComName;
    }

    /**
     * ��������Ǽǻ���
     * @param operatorName �����õ���������Ǽǻ������Ƶ�ֵ
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
     * �������Ծ����˴���
     * @param handlerCode �����õ����Ծ����˴����ֵ
     */
    public void setHandlerName(String handlerName){
        this.handlerName = StringUtils.rightTrim(handlerName);
    }

    /**
     * ��ȡ���Ծ����˴���
     * @return ���Ծ����˴����ֵ
     */
    public String getHandler1Name(){
        return handler1Name;
    }

    /**
     * �������Ծ����˴���
     * @param handlerCode �����õ����Ծ����˴����ֵ
     */
    public void setHandler1Name(String handler1Name){
        this.handler1Name = StringUtils.rightTrim(handler1Name);
    }

    /**
     * ��ȡ���Ծ����˴���
     * @return ���Ծ����˴����ֵ
     */
    public String getHandlerName(){
        return handlerName;
    }

    /**
     * �������Բ���
     * @param comName �����õ����Բ��ŵ�ֵ
     */
    public void setComName(String comName){
        this.comName = StringUtils.rightTrim(comName);
    }

    /**
     * ��ȡ���Բ���
     * @return ���Բ��ŵ�ֵ
     */
    public String getComName(){
        return comName;
    }

    /**
     * ����������������
     * @param startDate �����õ������������ڵ�ֵ
     */
    public void setStartDate(String startDate){
        this.startDate = StringUtils.rightTrim(startDate);
    }

    /**
     * ��ȡ������������
     * @return �����������ڵ�ֵ
     */
    public String getStartDate(){
        return startDate;
    }

    /**
     * ���������ձ�����
     * @param endDate �����õ������ձ����ڵ�ֵ
     */
    public void setEndDate(String endDate){
        this.endDate = StringUtils.rightTrim(endDate);
    }

    /**
     * ��ȡ�����ձ�����
     * @return �����ձ����ڵ�ֵ
     */
    public String getEndDate(){
        return endDate;
    }

    /**
     * ����������������
     * @param clauseName �����õ������������Ƶ�ֵ
     */
    public void setClauseName(String clauseName){
        this.clauseName = StringUtils.rightTrim(clauseName);
    }

    /**
     * ��ȡ������������
     * @return �����������Ƶ�ֵ
     */
    public String getClauseName(){
        return clauseName;
    }

    /**
     * �������Գ��տ�ʼ����
     * @param damageStartMinute �����õ����Գ��տ�ʼ���ӵ�ֵ
     */
    public void setDamageStartMinute(String damageStartMinute){
        this.damageStartMinute = StringUtils.rightTrim(damageStartMinute);
    }

    /**
     * ��ȡ���Գ��տ�ʼ����
     * @return ���Գ��տ�ʼ���ӵ�ֵ
     */
    public String getDamageStartMinute(){
        return damageStartMinute;
    }

    /**
     * �������ԽӰ��˴���
     * @param receiverCode �����õ����ԽӰ��˴����ֵ
     */
    public void setReceiverCode(String receiverCode){
        this.receiverCode = StringUtils.rightTrim(receiverCode);
    }

    /**
     * ��ȡ���ԽӰ��˴���
     * @return ���ԽӰ��˴����ֵ
     */
    public String getReceiverCode(){
        return receiverCode;
    }

    /**
     * �������Դ���λ����
     * @param handleUnitName �����õ����Դ���λ���Ƶ�ֵ
     */
    public void setHandleUnitName(String handleUnitName){
        this.handleUnitName = StringUtils.rightTrim(handleUnitName);
    }

    /**
     * ��ȡ���Դ���λ����
     * @return ���Դ���λ����
     */
    public String getHandleUnitName(){
        return handleUnitName;
    }
      /**
     * ���ñ༭����
     * @param editType �����õı༭���͵�ֵ
     */
    public void setEditType(String editType){
        this.editType = StringUtils.rightTrim(editType);
    }

    /**
     * ��ȡ�༭����
     * @return ���Ա༭����
     */
    public String getEditType(){
        return editType;
    }

    /**
     * ��ȡ�б�
     * @return �����б�
     */
    public Collection getRegistList(){
      return registList;
    }

    /**
     * �����б�
     * @param registList �����õ��б�
     */
    public void setRegistList(Collection registList) {
      this.registList = registList;
    }

    /**
     * �������Բ���״̬
     * @param status �����õ����Բ���״̬
     * Modify By Sunhao,2004-08-24
     */
    public void setStatus(String status){
        this.status = StringUtils.rightTrim(status);
    }

    /**
     * ��ȡ���Բ���״̬
     * @return ���Բ���״̬
     * Modify By Sunhao,2004-08-24
     */
    public String getStatus(){
        return status;
    }

   /**
    * �������Բ���ʱ��
    * @param operateDate �����õ����Բ���ʱ��
    * Modify By Sunhao,2004-08-24
    */
    public void setOperateDate(DateTime operateDate){
        this.operateDate = operateDate;
    }

    public void setReportMinute(String reportMinute) {
      this.reportMinute = reportMinute;
    }

  /**
     * ��ȡ���Բ���ʱ������
     * @param status �����õ����Բ���ʱ��
     * Modify By Sunhao,2004-08-24
     */

    public DateTime getOperateDate(){
         return operateDate;
     }

     public String getReportMinute() {
       return reportMinute;
     }


     /**
     * �������Աұ�����
     * @param estiCurrencyName �����õ����Աұ����Ƶ�ֵ
     */
    public void setEstiCurrencyName(String estiCurrencyName){
        this.estiCurrencyName = StringUtils.rightTrim(estiCurrencyName);
    }

    /**
     * ��ȡ���Աұ�����
     * @return ���Աұ�����
     */
    public String getEstiCurrencyName(){
        return estiCurrencyName;
    }
    
    /**
     * �������Ա����������
     * @param customerType �����õ����Ա�����������ֵ
     */
    public void setCustomerType(String customerType){
        this.customerType = StringUtils.rightTrim(customerType);
    }

    /**
     * ��ȡ���Ա����������
     * @return ���Ա����������
     */
    public String getCustomerType(){
        return customerType;
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
     * ���������¹����漰����
     * @param referKind �����õ������¹����漰���ֵ�ֵ
     */
    public void setReferKind(String referKind){
        this.referKind = StringUtils.rightTrim(referKind);
    }

    /**
     * ��ȡ�����¹����漰����
     * @return �����¹����漰���ֵ�ֵ
     */
    public String getReferKind(){
        return referKind;
    }

	public void setPayFlag(String payFlag) {
      this.payFlag = payFlag;
    }

  public void setFlowID(String flowID) {
    this.flowID = flowID;
  }

  public String getPayFlag() {
      return payFlag;
    }

  public String getFlowID() {
    return flowID;
  }

     /**
     * �����������м�¼�ı��
     * @param serialNo �����õ��������м�¼�ı�ŵ�ֵ
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

  public void setTurnPageDto(TurnPageDto turnPageDto) {
    this.turnPageDto = turnPageDto;
  }

  /**
     * ��ȡ�������м�¼�ı��
     * @return �������м�¼�ı��
     */
    public int getSerialNo(){
        return serialNo;
    }

  public TurnPageDto getTurnPageDto() {
    return turnPageDto;
  }

  /**
     * �������Ե��ȱ�ĵ���ϸ����
     * @param scheduleItemNote �����õ����Ե��ȱ�ĵ���ϸ���ݵ�ֵ
     */
    public void setScheduleItemNote(String scheduleItemNote){
        this.scheduleItemNote = StringUtils.rightTrim(scheduleItemNote);
    }

    /**
     * ��ȡ���Ե��ȱ�ĵ���ϸ����
     * @return ���Ե��ȱ�ĵ���ϸ����
     */
    public String getScheduleItemNote(){
        return scheduleItemNote;
    }

    /**
    * �������Գ���ԭ��������ϸ����
    * @param prpLregistDamageCode �����õ����Գ���ԭ��������ϸ���ݵ�ֵ
    */
   public void setPrpLregistDamageCode(String prpLregistDamageCode){
       this.prpLregistDamageCode = StringUtils.rightTrim(prpLregistDamageCode);
   }

   /**
    * ��ȡ���Գ���ԭ��������ϸ����
    * @return ���Գ���ԭ��������ϸ����
    */
   public String getPrpLregistDamageCode(){
       return prpLregistDamageCode;
   }

   /**
    * ���������¹�ԭ��������ϸ����
    * @param prpLregistDamageTypeCode �����õ������¹�ԭ��������ϸ���ݵ�ֵ
    */
   public void setPrpLregistDamageTypeCode(String prpLregistDamageTypeCode){
     this.prpLregistDamageTypeCode = StringUtils.rightTrim(prpLregistDamageTypeCode);
   }

  /**
   * ��ȡ�����¹�ԭ��������ϸ����
   * @return �����¹�ԭ��������ϸ����
   */
   public String getPrpLregistDamageTypeCode(){
     return prpLregistDamageTypeCode;
   }
   
     /**
    * �����¹�����Ԥ���������ϸ����
    * @param prpLregistDamageTypeCode �����õ��¹�����Ԥ���������ϸ���ݵ�ֵ
    */
   public void setIndemnityDuty(String indemnityDuty){
     this.indemnityDuty = StringUtils.rightTrim(indemnityDuty);
   }

  /**
   * ��ȡ�����¹�����Ԥ���������ϸ����
   * @return �����¹�����Ԥ���������ϸ����
   */
   public String getIndemnityDuty(){
     return indemnityDuty;
   }
   
   /**
     * �������Ա�����
     * @param lossItemCode �����õ����Ա����ŵ�ֵ
     */
    public void setLossItemCode(String lossItemCode){
        this.lossItemCode = StringUtils.rightTrim(lossItemCode);
    }

    /**
     * ��ȡ���Ա�����
     * @return ���Ա����ŵ�ֵ
     */
    public String getLossItemCode(){
        return lossItemCode;
    }


	/**
	 * @return Returns the recentCount.
	 */
	public int getRecentCount() {
		return recentCount;
	} 
	/**
	 * @param recentCount The recentCount to set.
	 */
	public void setRecentCount(int recentCount) {
		this.recentCount = recentCount;
	}
	
	//modify by wangwei add start 2005-06-08
	//ԭ������յı���������Ҫ��ʾ�����еı��ս��
	/**
	 * �������Եı��ս��
	 * @param sumAmount ���������Եı��ս��*/
	public void setSumAmount(double sumAmount) {
		this.sumAmount = sumAmount;
	}	
	/**
	 * ������Եı��ս��
	 * @return ���Եı��ս��*/
	public double getSumAmount() {
		return this.sumAmount;
	}
	//modify by wangwei add end 2005-06-08
	
	/**
     * ���õ���
     * @param certiNo ����
     */
	public void setCertiNo(String certiNo){
		this.certiNo = certiNo;
	}
	/**
     * ��ȡ����
     * @return ����
     */
	public String getCertiNo(){
		return certiNo;
	}
	/**
     * ���õ�������
     * @param certiType ��������
     */
	public void setCertiType(String certiType){
		this.certiType = certiType;
	}
	/**
     * ��ȡ���Ե�������
     * @return ���Ե�������
     */
	public String getCertiType(){
		return certiType;
	}
	/**
     * �������Ե�����������
     * @param personDeathB ������������
     */
	public void setPersonDeathB(long personDeathB){
		this.personDeathB = personDeathB;
	}
	/**
     * ��ȡ���Ե�����������
     * @return ���Ե�����������
     */
	public long getPersonDeathB(){
		return personDeathB;
	}
	/**
     * �������Ե�����������
     * @param personInjureB ������������
     */
	public void setPersonInjureB(long personInjureB){
		this.personInjureB = personInjureB;
	}
	/**
     * ��ȡ���Ե�����������
     * @return ���Ե�����������
     */
	public long getPersonInjureB(){
		return personInjureB;
	}
	/**
     * �������Գ�����Ա������
     * @param personDeathD1 ������Ա������
     */
	public void setPersonDeathD1(long personDeathD1){
		this.personDeathD1 = personDeathD1;
	}
	/**
     * ��ȡ���Գ�����Ա������
     * @return ���Գ�����Ա������
     */
	public long getPersonDeathD1(){
		return personDeathD1;
	}
	/**
     * �������Գ�����Ա������
     * @param personInjureD1 ������Ա������
     */
	public void setPersonInjureD1(long personInjureD1){
		this.personInjureD1 = personInjureD1;
	}
	/**
     * ��ȡ���Գ�����Ա������
     * @return ���Գ�����Ա������
     */
	public long getPersonInjureD1(){
		return personInjureD1;
	}
    public DateTime getSignDate() {
        return signDate;
    }
    public void setSignDate(DateTime signDate) {
        this.signDate = signDate;
    }
    
    public DateTime getUnderWriteEndDate() {
        return underWriteEndDate;
    }
    public void setUnderWriteEndDate(DateTime underWriteEndDate) {
        this.underWriteEndDate = underWriteEndDate;
    }
    
    public String getOthFlag() {
        return othFlag;
    }
    public void setOthFlag(String othFlag) {
        this.othFlag = othFlag;
    }
    //������־
    public String getCoinsFlag() {
        return coinsFlag;
    }
    public void setCoinsFlag(String coinsFlag) {
        this.coinsFlag = coinsFlag;
    }

	public CompensateFeeDto getCompensateFeeDto() {
		return compensateFeeDto;
	}

	public void setCompensateFeeDto(CompensateFeeDto compensateFeeDto) {
		this.compensateFeeDto = compensateFeeDto;
	}

	public String getWorkFlowId() {
		return workFlowId;
	}

	public void setWorkFlowId(String workFlowId) {
		this.workFlowId = workFlowId;
	}

	//add by zhouliu start at 2006-6-9
	//reason:ǿ����ѯ
	public Collection getRelatepolicyNo() {
		return relatepolicyNo;
	}

	public void setRelatepolicyNo(Collection relatepolicyNo) {
		this.relatepolicyNo = relatepolicyNo;
	}
	//add by zhouliu end at 2006-6-9
	

	public String getLossesUnitCode() {
		return lossesUnitCode;
	}

	public void setLossesUnitCode(String lossesUnitCode) {
		this.lossesUnitCode = lossesUnitCode;
	}

	public double getLossesNumber() {
		return lossesNumber;
	}

	public void setLossesNumber(double lossesNumber) {
		this.lossesNumber = lossesNumber;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getBusinessType1() {
		return businessType1;
	}

	public void setBusinessType1(String businessType1) {
		this.businessType1 = businessType1;
	}

	/**
	 * @return the claimTypeName
	 */
	public String getClaimTypeName() {
		return claimTypeName;
	}

	/**
	 * @param claimTypeName the claimTypeName to set
	 */
	public void setClaimTypeName(String claimTypeName) {
		this.claimTypeName = claimTypeName;
	}

	public String getBusinessFlag() {
		return businessFlag;
	}

	public void setBusinessFlag(String businessFlag) {
		this.businessFlag = businessFlag;
	}

	public String getOtherFlag() {
		return otherFlag;
	}

	public void setOtherFlag(String otherFlag) {
		this.otherFlag = otherFlag;
	}

	public String getRegistFlag() {
		return registFlag;
	}

	public void setRegistFlag(String registFlag) {
		this.registFlag = registFlag;
	}

    public int getCountdate() {
        return countdate;
    }

    public void setCountdate(int countdate) {
        this.countdate = countdate;
    }


	
}



