package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLthirdProp-�Ʋ���ʧ��λ������ݴ��������<br>
 * ������ 2005-04-12 11:37:47.312<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLthirdPropDto extends PrpLthirdPropDtoBase implements Serializable{
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLthirdPropDto����
     */
    public PrpLthirdPropDto(){
    }

    /** ������ʾ�б�*/
    private Collection thirdPropList;
    
    /** �������ձ�*/
    private String prpLthirdPropKindCode = "";
    
    /** ���Ե��ȴ����־ */
    private String scheduleType = "";

    /** �����Ƿ�ѡ���� */
    private String selectSend = "";
     /** �������ĸ��ڵ�ĵ��� */
    private String nodeType = "";
    
    /**
     * ���������ձ�����
     * @param prpLthirdPropKindCode �����õ������ձ����͵�ֵ
     */
    public void setPrpLthirdPropKindCode(String prpLthirdPropKindCode){
        this.prpLthirdPropKindCode = StringUtils.rightTrim(prpLthirdPropKindCode);
    }

    /**
     * ��ȡ�����ձ�����
     * @return �����ձ����͵�ֵ
     */
    public String getPrpLthirdPropKindCode(){
        return prpLthirdPropKindCode;
    }
    
    public void setThirdPropList(Collection thirdPropList) {
      this.thirdPropList = thirdPropList;
    }

    public Collection getThirdPropList() {
      return thirdPropList;
    }
    
    
            /**
     * �������Ե��ȴ����־
     * @param scheduleType �����õ����Ե��ȴ����־��ֵ
     */
    public void setScheduleType(String scheduleType){
        this.scheduleType = StringUtils.rightTrim(scheduleType);
    }

    /**
     * ��ȡ���Ե��ȴ����־
     * @return ���Ե��ȴ����־��ֵ
     */
    public String getScheduleType(){
        return scheduleType;
    }

    /**
     * ���������Ƿ�ѡ����
     * @param selectSend �����õ������Ƿ�ѡ���͵�ֵ
     */
    public void setSelectSend(String selectSend){
        this.selectSend = StringUtils.rightTrim(selectSend);
    }

    /**
     * ��ȡ�����Ƿ�ѡ����
     * @return �����Ƿ�ѡ���͵�ֵ
     */
    public String getSelectSend(){
        return selectSend;
    }
 /**
     * �������Խڵ�����
     * @param nodeType �����õ����Խڵ����͵�ֵ
     */
    public void setNodeType(String nodeType){
        this.nodeType = StringUtils.rightTrim(nodeType);
    }

    /**
     * ��ȡ���Խڵ�����
     * @return ���Խڵ����͵�ֵ
     */
    public String getNodeType(){
        return nodeType;
    }

}
