package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.ArrayList;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prplcomponent������Ŀ�嵥�����ݴ��������<br>
 * ������ 2004-4-5 15:31:57<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLcomponentDto extends PrpLcomponentDtoBase implements Serializable{
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLcomponentDto����
     */
    public PrpLcomponentDto(){
    }

    /** ���� **/
    ArrayList componentList;
    /** �����ձ����� */
    private String kindName = "";

    /** ���Գ��մ��� */
    private int perilCount = 0;

    /** ���Բ������� */
    private String prpLcomponentPartCode = "";

    /** ���Բ������� */
    private String prpLcomponentPartName = "";

    /** ���Ծ��������� */
    private String handlerName = "";
    
    /**
     * �������Բ�������
     * @param prpLcomponentPartCode �����õ����Բ�������
     */
    public void setPrpLcomponentPartCode(String prpLcomponentPartCode){
        this.prpLcomponentPartCode = StringUtils.rightTrim(prpLcomponentPartCode);
    }

    /**
     * ��ȡ���Բ�������
     * @return ���Բ�������
     */
    public String getPrpLcomponentPartCode(){
        return prpLcomponentPartCode;
    }

    /**
     * �������Բ�������
     * @param prpLcomponentPartName  �����õ����Բ�������
     */
    public void setPrpLcomponentPartName(String prpLcomponentPartName){
        this.prpLcomponentPartName = StringUtils.rightTrim(prpLcomponentPartName);
    }

    /**
     * ��ȡ���Բ�������
     * @return ���Բ�������
     */
    public String getPrpLcomponentPartName(){
        return prpLcomponentPartName;
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

    /**�õ�������Ŀ�嵥����
    * @return ������Ŀ�嵥������Ϣ
    */
    public ArrayList getComponentList() {
      return  componentList;
    }
    /**���û�����Ŀ�嵥����
    * @param componentList ������Ŀ�嵥����
    */
    public void setComponentList(ArrayList componentList) {
      this.componentList = componentList;
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
    
    public String getHandlerName() {
        return handlerName;
      }
    
    public void setHandlerName(String handlerName) {
        this.handlerName = handlerName;
      }
}
