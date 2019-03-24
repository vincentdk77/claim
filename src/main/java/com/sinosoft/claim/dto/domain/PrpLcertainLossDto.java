package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpcaddress���յ�ַ������ݴ��������<br>
 * ������ 2004-4-5 15:31:56<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLcertainLossDto extends PrpLcertainLossDtoBase implements Serializable{
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpCaddressDto����
     */
    public PrpLcertainLossDto(){
    }

    /** ���� **/
    Collection certainLossList;
    /** �༭���� */
    private String editType = "";
    /** �������Ĳ���״̬ 1��δ���� 2�����ڴ��� 3������� 4�����ύ 5�� ���� */
    private String status ="";  //Modify By Sunhao,2004-08-24
    /** ���Գ��մ��� */
    private int perilCount = 0;
    
    

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
    public Collection getCertainLossList() {
      return  certainLossList;
    }
    
    /**���õ�֤����
    * @param certainLossList ��֤����
    */
    public void setCertainLossList(Collection certainLossList) {
      this.certainLossList = certainLossList;
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
    
}
