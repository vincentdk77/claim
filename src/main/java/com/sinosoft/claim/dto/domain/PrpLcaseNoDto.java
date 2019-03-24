package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prplcaseno�ⰸ�ű�����ݴ��������<br>
 * ������ 2004-4-5 15:31:57<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLcaseNoDto extends PrpLcaseNoDtoBase implements Serializable{

	//add by zhaolu 20060803 start
	TurnPageDto turnPageDto = null;
	//add by zhaolu 20060803 end
	
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLcaseNoDto����
     */
    public PrpLcaseNoDto(){
    }

    /** Dto����ʱ�ı༭״̬����Eidt,Add�ȵ� */
    private String editType ="";
    /** �˲鿱�Ĳ���״̬ 1��δ���� 2�����ڴ��� 3������� 4�����ύ 5�� ���� */
    private String status ="";
    /** ���Ա������� */
    private String policyNo = "";
    /** �������⸶��� */
    private double sumPaid = 0d;
    /** ���Խ᰸Ա����*/
    private String endCaserCode = "";
    /** ���Խ᰸ʱ��*/
    private DateTime endCaseDate = new DateTime();
    /**���Գ��ƺ���  */
    private String licenseNo = "";//Modify By sunhao 2004-08-24
    /**���Դ˰����Ĳ���ʱ��*/
    private DateTime operateDate = new DateTime();//Modify By Sunhao,2004-08-24
    /** ���� **/
    Collection caseList;
    /**�ȱ��ձ�*/
    private String riskCode="";
     //modify by zhaozhuo add 20050331 start
    //reason: ����Ԥ��ǼǺź������������
     /** ����Ԥ��ǼǺ� */
    private String preCompensateNo = "";
    /** ��������������� */
    private String compensateNo = "";
    //modify by zhaozhuo add 20050331 end

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
     * �����������⸶���
     * @param sumPaid �����õ��������⸶����ֵ
     */
    public void setSumPaid(double sumPaid){
        this.sumPaid = sumPaid;
    }

    /**
     * ��ȡ�������⸶���
     * @return �������⸶����ֵ
     */
    public double getSumPaid(){
        return sumPaid;
    }

   /**�õ��᰸����
   * @return �᰸������Ϣ
   */
    public Collection getCaseList() {
      return caseList;
    }

   /**���ý᰸����
   * @param caseList �᰸����
   */
    public void setCaseList(Collection caseList) {
      this.caseList = caseList;
    }

   /**�õ��᰸�Ĳ���״̬
   * @return �᰸�Ĳ���״̬
   */
    public String getStatus() {
      return status;
    }

   /**���ý᰸�Ĳ���״̬
   * @param status �᰸�Ĳ���״̬
   */
    public void setStatus(String status) {
      this.status = status;
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
     * �������Խ᰸Ա����
     * @param policyNo �����õ����Խ᰸Ա�����ֵ
     */
    public void setEndCaserCode(String endCaserCode){
        this.endCaserCode = StringUtils.rightTrim(endCaserCode);
    }

    /**
     * �������Խ᰸ʱ��
     * @param policyNo �����õ����Խ᰸ʱ���ֵ
     */
    public void setEndCaseDate(DateTime endCaseDate){
        this.endCaseDate = endCaseDate;
    }

    /**
     * ��ȡ���Խ᰸Ա����
     * @return ���Խ᰸Ա�����ֵ
     */
    public String getEndCaserCode(){
        return endCaserCode;
    }

    /**
     * ��ȡ���Խ᰸ʱ��
     * @return ���Խ᰸ʱ���ֵ
     */
    public DateTime getEndCaseDate(){
        return endCaseDate;
    }

    /**
     * �������Գ��ƺ���
     * @param licenseNo �����õ����Գ��ƺ����ֵ
     * Modify By sunhao 2004-08-24
     */
    public void setLicenseNo(String licenseNo){
        this.licenseNo = StringUtils.rightTrim(licenseNo);
    }

    /**
     * ��ȡ���Գ��ƺ���
     * @return ���Գ��ƺ����ֵ
     * Modify By sunhao 2004-08-24
     */
    public String getLicenseNo(){
        return licenseNo;
    }

   /**
    * �������Բ���ʱ��
    * @param operateDate �����õ����Բ���ʱ��
    * Modify By Sunhao,2004-08-24
    */
    public void setOperateDate(DateTime operateDate){
        this.operateDate = operateDate;
    }

  public void setRiskCode(String riskCode) {
    this.riskCode = riskCode;
  }

  /**
     * ��ȡ���Բ���ʱ������
     * @param status �����õ����Բ���ʱ��
     * Modify By Sunhao,2004-08-24
     */

    public DateTime getOperateDate(){
         return operateDate;
     }

  public String getRiskCode() {
    return riskCode;
  }
//modify by zhaozhuo add 20050331 start

    /**
     * ��������Ԥ��ǼǺ�
     * @param preCompensateNo �����õ�����Ԥ��ǼǺŵ�ֵ
     */
    public void setPreCompensateNo(String preCompensateNo){
        this.preCompensateNo = StringUtils.rightTrim(preCompensateNo);
    }

    /**
     * ��ȡ����Ԥ��ǼǺ�
     * @return ����Ԥ��ǼǺŵ�ֵ
     */
    public String getPreCompensateNo(){
        return preCompensateNo;
    }
    /**
    * �������������������
    * @param compensateNo �����õ�����������������ֵ
    */
   public void setCompensateNo(String compensateNo){
       this.compensateNo = StringUtils.rightTrim(compensateNo);
   }

   /**
    * ��ȡ���������������
    * @return ����������������ֵ
    */
   public String getCompensateNo(){
       return compensateNo;
    }
    //modify by zhaozhuo add 20050331 end

public TurnPageDto getTurnPageDto() {
	return turnPageDto;
}

public void setTurnPageDto(TurnPageDto turnPageDto) {
	this.turnPageDto = turnPageDto;
}
}
