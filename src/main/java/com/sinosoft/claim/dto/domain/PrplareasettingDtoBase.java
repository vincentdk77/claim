package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLAREASETTING�����ݴ���������<br>
 */
public class PrplareasettingDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����ID */
    private String id = "";
    /** ����HANDLERCODE */
    private String handlercode = "";
    /** ����HANDLEDEPT */
    private String handledept = "";
    /** ����HANDLERNAME */
    private String handlername = "";
    /** ����AREA */
    private String area = "";
    /** ����TEL */
    private String tel = "";
    /** ����OPERATOR */
    private String operator = "";
    /** ����OPERATORID */
    private String operatorid = "";
    /** ����FLOWINTIME */
    private String flowintime = "";
    /** ����MODIFYTIME */
    private String modifytime = "";
    /** ����CLASSCODE */
    private String classcode = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrplareasettingDtoBase����
     */
    public PrplareasettingDtoBase(){
    }

    /**
     * ��������ID
     * @param id �����õ�����ID��ֵ
     */
    public void setId(String id){
        this.id = StringUtils.rightTrim(id);
    }

    /**
     * ��ȡ����ID
     * @return ����ID��ֵ
     */
    public String getId(){
        return id;
    }

    /**
     * ��������HANDLERCODE
     * @param handlercode �����õ�����HANDLERCODE��ֵ
     */
    public void setHandlercode(String handlercode){
        this.handlercode = StringUtils.rightTrim(handlercode);
    }

    /**
     * ��ȡ����HANDLERCODE
     * @return ����HANDLERCODE��ֵ
     */
    public String getHandlercode(){
        return handlercode;
    }

    /**
     * ��������HANDLEDEPT
     * @param handledept �����õ�����HANDLEDEPT��ֵ
     */
    public void setHandledept(String handledept){
        this.handledept = StringUtils.rightTrim(handledept);
    }

    /**
     * ��ȡ����HANDLEDEPT
     * @return ����HANDLEDEPT��ֵ
     */
    public String getHandledept(){
        return handledept;
    }

    /**
     * ��������HANDLERNAME
     * @param handlername �����õ�����HANDLERNAME��ֵ
     */
    public void setHandlername(String handlername){
        this.handlername = StringUtils.rightTrim(handlername);
    }

    /**
     * ��ȡ����HANDLERNAME
     * @return ����HANDLERNAME��ֵ
     */
    public String getHandlername(){
        return handlername;
    }

    /**
     * ��������AREA
     * @param area �����õ�����AREA��ֵ
     */
    public void setArea(String area){
        this.area = StringUtils.rightTrim(area);
    }

    /**
     * ��ȡ����AREA
     * @return ����AREA��ֵ
     */
    public String getArea(){
        return area;
    }

    /**
     * ��������TEL
     * @param tel �����õ�����TEL��ֵ
     */
    public void setTel(String tel){
        this.tel = StringUtils.rightTrim(tel);
    }

    /**
     * ��ȡ����TEL
     * @return ����TEL��ֵ
     */
    public String getTel(){
        return tel;
    }

    /**
     * ��������OPERATOR
     * @param operator �����õ�����OPERATOR��ֵ
     */
    public void setOperator(String operator){
        this.operator = StringUtils.rightTrim(operator);
    }

    /**
     * ��ȡ����OPERATOR
     * @return ����OPERATOR��ֵ
     */
    public String getOperator(){
        return operator;
    }

    /**
     * ��������OPERATORID
     * @param operatorid �����õ�����OPERATORID��ֵ
     */
    public void setOperatorid(String operatorid){
        this.operatorid = StringUtils.rightTrim(operatorid);
    }

    /**
     * ��ȡ����OPERATORID
     * @return ����OPERATORID��ֵ
     */
    public String getOperatorid(){
        return operatorid;
    }

    /**
     * ��������FLOWINTIME
     * @param flowintime �����õ�����FLOWINTIME��ֵ
     */
    public void setFlowintime(String flowintime){
        this.flowintime = StringUtils.rightTrim(flowintime);
    }

    /**
     * ��ȡ����FLOWINTIME
     * @return ����FLOWINTIME��ֵ
     */
    public String getFlowintime(){
        return flowintime;
    }

    /**
     * ��������MODIFYTIME
     * @param modifytime �����õ�����MODIFYTIME��ֵ
     */
    public void setModifytime(String modifytime){
        this.modifytime = StringUtils.rightTrim(modifytime);
    }

    /**
     * ��ȡ����MODIFYTIME
     * @return ����MODIFYTIME��ֵ
     */
    public String getModifytime(){
        return modifytime;
    }

    /**
     * ��������CLASSCODE
     * @param classcode �����õ�����CLASSCODE��ֵ
     */
    public void setClasscode(String classcode){
        this.classcode = StringUtils.rightTrim(classcode);
    }

    /**
     * ��ȡ����CLASSCODE
     * @return ����CLASSCODE��ֵ
     */
    public String getClasscode(){
        return classcode;
    }
}
