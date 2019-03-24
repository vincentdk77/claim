package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLpersonTrace ���˸��ٱ�����ݴ��������<br>
 * ������ 2005-02-18 10:21:16.171<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLpersonTraceDto extends PrpLpersonTraceDtoBase implements Serializable{

    private Collection personTraceList ;
        /** ���Ե��ȴ����־ */
    private String scheduleType = "";

    /** �����Ƿ�ѡ���� */
    private String selectSend = "";
     /** �������ĸ��ڵ�ĵ��� */
    private String nodeType = "";

    /** �ձ�*/
    private String prpLpersonTraceReferKind;


    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLpersonTraceDto����
     */
    public PrpLpersonTraceDto(){
    }

     /**
     * ��ȡ�б�
     * @return �����б�
     */
    public Collection getPersonTraceList(){
      return personTraceList ;
    }
    /**
     * �����б�
     * @param driverList �����õ��б�
     */
    public void setPersonTraceList(Collection personTraceList ) {
      this.personTraceList  = personTraceList ;
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

  /**
    * ��ȡ�����ձ����
    * @return �����ձ����
    */
    public String getPrpLpersonTraceReferKind()
    {
      return this.prpLpersonTraceReferKind;
    }

  /**
    * ���������ձ����
    * @param prpLpersonTraceReferKind �����õ������ձ����
    */
    public void setPrpLpersonTraceReferKind(String prpLpersonTraceReferKind)
    {
      this.prpLpersonTraceReferKind = prpLpersonTraceReferKind;
    }
}
