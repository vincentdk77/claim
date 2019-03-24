package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLREGISTHIS�����ݴ���������<br>
 */
public class PrplregisthisDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����REGISTNO */
    private String registno = "";
    /** ����SERIALNO */
    private int serialno = 0;
    /** ����INPUTDATE */
    private String inputdate = "";
    /** ����OPERATORCODE */
    private String operatorcode = "";
    /** ����OPERATORNAME */
    private String operatorname = "";
    /** ����COMCODE */
    private String comcode = "";
    /** ����MODIFYTYPE */
    private String modifytype = "";
    /** ����NODETYPE */
    private String nodetype = "";
    /** ����CONTEXT */
    private String context = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrplregisthisDtoBase����
     */
    public PrplregisthisDtoBase(){
    }

    /**
     * ��������REGISTNO
     * @param registno �����õ�����REGISTNO��ֵ
     */
    public void setRegistno(String registno){
        this.registno = StringUtils.rightTrim(registno);
    }

    /**
     * ��ȡ����REGISTNO
     * @return ����REGISTNO��ֵ
     */
    public String getRegistno(){
        return registno;
    }

    /**
     * ��������SERIALNO
     * @param serialno �����õ�����SERIALNO��ֵ
     */
    public void setSerialno(int serialno){
        this.serialno = serialno;
    }

    /**
     * ��ȡ����SERIALNO
     * @return ����SERIALNO��ֵ
     */
    public int getSerialno(){
        return serialno;
    }

    /**
     * ��������INPUTDATE
     * @param inputdate �����õ�����INPUTDATE��ֵ
     */
    public void setInputdate(String inputdate){
        this.inputdate = inputdate;
    }

    /**
     * ��ȡ����INPUTDATE
     * @return ����INPUTDATE��ֵ
     */
    public String getInputdate(){
        return inputdate;
    }

    /**
     * ��������OPERATORCODE
     * @param operatorcode �����õ�����OPERATORCODE��ֵ
     */
    public void setOperatorcode(String operatorcode){
        this.operatorcode = StringUtils.rightTrim(operatorcode);
    }

    /**
     * ��ȡ����OPERATORCODE
     * @return ����OPERATORCODE��ֵ
     */
    public String getOperatorcode(){
        return operatorcode;
    }

    /**
     * ��������OPERATORNAME
     * @param operatorname �����õ�����OPERATORNAME��ֵ
     */
    public void setOperatorname(String operatorname){
        this.operatorname = StringUtils.rightTrim(operatorname);
    }

    /**
     * ��ȡ����OPERATORNAME
     * @return ����OPERATORNAME��ֵ
     */
    public String getOperatorname(){
        return operatorname;
    }

    /**
     * ��������COMCODE
     * @param comcode �����õ�����COMCODE��ֵ
     */
    public void setComcode(String comcode){
        this.comcode = StringUtils.rightTrim(comcode);
    }

    /**
     * ��ȡ����COMCODE
     * @return ����COMCODE��ֵ
     */
    public String getComcode(){
        return comcode;
    }

    /**
     * ��������MODIFYTYPE
     * @param modifytype �����õ�����MODIFYTYPE��ֵ
     */
    public void setModifytype(String modifytype){
        this.modifytype = StringUtils.rightTrim(modifytype);
    }

    /**
     * ��ȡ����MODIFYTYPE
     * @return ����MODIFYTYPE��ֵ
     */
    public String getModifytype(){
        return modifytype;
    }

    /**
     * ��������NODETYPE
     * @param nodetype �����õ�����NODETYPE��ֵ
     */
    public void setNodetype(String nodetype){
        this.nodetype = StringUtils.rightTrim(nodetype);
    }

    /**
     * ��ȡ����NODETYPE
     * @return ����NODETYPE��ֵ
     */
    public String getNodetype(){
        return nodetype;
    }

    /**
     * ��������CONTEXT
     * @param context �����õ�����CONTEXT��ֵ
     */
    public void setContext(String context){
        this.context = StringUtils.rightTrim(context);
    }

    /**
     * ��ȡ����CONTEXT
     * @return ����CONTEXT��ֵ
     */
    public String getContext(){
        return context;
    }
}
