package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLcertifyCollect�����ݴ��������<br>
 * ������ 2004-07-05 17:15:52.378<br>
 * JToolpad(1.2.12-RC8) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLcertifyCollectDto extends PrpLcertifyCollectDtoBase implements Serializable{
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLcertifyCollectDto����
     */
    public PrpLcertifyCollectDto(){
    }  

    /** ���� **/
    Collection certifyCollectList;
    /** �༭���� */
    private String editType = "";
    /** �������Ĳ���״̬ 1��δ���� 2�����ڴ��� 3������� 4�����ύ 5�� ���� */
    private String status ="";  // Modify By Sunhao,2004-08-24
    /**���Դ˰����Ĳ���ʱ��*/
    private DateTime operateDate = new DateTime(); // Modify By Sunhao,2004-08-24
    /**�ȱ��ձ�*/
    private String riskCode = "";
    /** ���Գ��մ��� */
    private int perilCount = 0;
    /**���ܹ��ύ����ʾ��Ϣ,���Ϊ'',�����ύ��֤�ڵ�*/
    private String noSubmitMsg = "";
    
    //add by zhaolu 20060803 start
    TurnPageDto turnPageDto = null;
    //add by zhaolu 20060803 end

    public TurnPageDto getTurnPageDto() {
		return turnPageDto;
	}

	public void setTurnPageDto(TurnPageDto turnPageDto) {
		this.turnPageDto = turnPageDto;
	}

	/**���õ�֤�Ĳ���״̬
    * @param status ��֤�Ĳ���״̬
    * Modify By Sunhao,2004-08-24
    */
     public void setStatus(String status) {
       this.status = status;
     }

   /**�õ���֤�Ĳ���״̬
    * @return ��֤�Ĳ���״̬
    * Modify By Sunhao,2004-08-24
    */
     public String getStatus() {
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

     /**
      * ��ȡ���Բ���ʱ������
      * @param status �����õ����Բ���ʱ��
      * Modify By Sunhao,2004-08-24
      */

     public DateTime getOperateDate(){
          return operateDate;
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

    /**�õ���֤����
    * @return ��֤������Ϣ
    */
    public Collection getCertifyCollectList() {
      return  certifyCollectList;
    }

  public String getRiskCode() {
    return riskCode;
  }

  /**���õ�֤����
    * @param certifyCollectList ��֤����
    */
    public void setCertifyCollectList(Collection certifyCollectList) {
      this.certifyCollectList = certifyCollectList;
    }

  public void setRiskCode(String riskCode) {
    this.riskCode = riskCode;
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
    
     /**���ò��ܹ��ύ����ʾ��Ϣ
    * @param noSubmitMsg ���ܹ��ύ����ʾ��Ϣ
    * 
    */
     public void setNoSubmitMsg(String noSubmitMsg) {
       this.noSubmitMsg = noSubmitMsg;
     }

   /**�õ����ܹ��ύ����ʾ��Ϣ
    * @return ���ܹ��ύ����ʾ��Ϣ
    * 
    */
     public String getNoSubmitMsg() {
       return noSubmitMsg;
     }

}
