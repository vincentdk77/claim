package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ���Ǵ�������ӱ�------������������ݴ���������<br>
 */
public class PrpLinterPayExtDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ��������id PK */
    private String id = "";
    /** ����������� PK */
    private int serialNo = 0;
    /** ���Բ����� */
    private String operatorCodeName = "";
    /** �������� */
    private String context = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLinterPayExtDtoBase����
     */
    public PrpLinterPayExtDtoBase(){
    }

    /**
     * ������������id PK
     * @param id �����õ���������id PK��ֵ
     */
    public void setId(String id){
        this.id = StringUtils.rightTrim(id);
    }

    /**
     * ��ȡ��������id PK
     * @return ��������id PK��ֵ
     */
    public String getId(){
        return id;
    }

    /**
     * ��������������� PK
     * @param serialNo �����õ������������ PK��ֵ
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ����������� PK
     * @return ����������� PK��ֵ
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * �������Բ�����
     * @param operatorCodeName �����õ����Բ����˵�ֵ
     */
    public void setOperatorCodeName(String operatorCodeName){
        this.operatorCodeName = StringUtils.rightTrim(operatorCodeName);
    }

    /**
     * ��ȡ���Բ�����
     * @return ���Բ����˵�ֵ
     */
    public String getOperatorCodeName(){
        return operatorCodeName;
    }

    /**
     * ������������
     * @param context �����õ��������ݵ�ֵ
     */
    public void setContext(String context){
        this.context = StringUtils.rightTrim(context);
    }

    /**
     * ��ȡ��������
     * @return �������ݵ�ֵ
     */
    public String getContext(){
        return context;
    }
}
