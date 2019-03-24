package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.ArrayList;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prplrepairfee��������嵥�����ݴ��������<br>
 * ������ 2004-4-5 15:31:57<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLrepairFeeDto extends PrpLrepairFeeDtoBase implements Serializable{
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLrepairFeeDto����
     */
    public PrpLrepairFeeDto(){
    }

    /** ���� **/
    ArrayList repairFeeList;
    /** �����ձ����� */
    private String kindName = "";
    /** ���Ծ��������� */
    private String handlerName = "";

    private String prpLrepairFeePartCode = "";

    private String prpLrepairFeePartName = "";
    
    private String repairTypeName = "";
   

    /**
    * �������Բ�������
    * @param prpLrepairFeePartCode �����õ����Բ�������
    */
   public void setPrpLrepairFeePartCode(String prpLrepairFeePartCode){
       this.prpLrepairFeePartCode = StringUtils.rightTrim(prpLrepairFeePartCode);
   }

   /**
    * ��ȡ���Բ�������
    * @return ���Բ�������
    */
   public String getPrpLrepairFeePartCode(){
       return prpLrepairFeePartCode;
   }

   /**
    * �������Բ�������
    * @param prpLrepairFeePartCode �����õ����Բ�������
    */
   public void setPrpLrepairFeePartName(String prpLrepairFeePartName){
       this.prpLrepairFeePartName = StringUtils.rightTrim(prpLrepairFeePartName);
   }

   /**
    * ��ȡ���Բ�������
    * @return ���Բ�������
    */
   public String getPrpLrepairFeePartName(){
       return prpLrepairFeePartName;
   }


    /**
     * ���������ձ�����
     * @param kindName �����õ������ձ����Ƶ�ֵ
     */
    public void setKindName(String kindName){
        this.kindName = StringUtils.rightTrim(kindName);
    }

    /**
     * ��ȡ�����ձ�����
     * @return �����ձ����Ƶ�ֵ
     */
    public String getKindName(){
        return kindName;
    }

    /**�õ���������嵥����
    * @return ��������嵥������Ϣ
    */
    public ArrayList getRepairFeeList() {
      return  repairFeeList;
    }

    public String getHandlerName() {
      return handlerName;
    }

  /**������������嵥����
    * @param repairFeeList ��������嵥����
    */
    public void setRepairFeeList(ArrayList repairFeeList) {
      this.repairFeeList = repairFeeList;
    }

    public void setHandlerName(String handlerName) {
      this.handlerName = handlerName;
    }
    
    /**
    * ��ȡ���Բ�������
    * @return ���Բ�������
    */
   public String getRepairTypeName(){
       return repairTypeName;
   }

   /**
    * �������Բ�������
    * @param repairTypeName �����õ����Բ�������
    */
   public void setRepairTypeName(String repairTypeName){
       this.repairTypeName = StringUtils.rightTrim(repairTypeName);
   }
  }
