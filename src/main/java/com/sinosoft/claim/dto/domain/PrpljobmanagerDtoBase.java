package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLJOBMANAGER�����ݴ���������<br>
 */
public class PrpljobmanagerDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����ID */
    private String id = "";
    /** ����JOBROLE */
    private String jobrole = "";
    /** ����HANDLERCODE */
    private String handlercode = "";
    /** ����HANDLERNAME */
    private String handlername = "";
    /** ����HANDLEDEPT */
    private String handledept = "";
    /** ����DEPTNAME */
    private String deptname = "";
    /** ����FLOWINTIME */
    private String flowintime = "";
    /** ����MODIFYTIME */
    private String modifytime = "";
    /** ����MONTH */
    private String month = "";
    /** ����OPERATOR */
    private String operator = "";
    /** ����OPERATORID */
    private String operatorid = "";
    /** ����CLASSCODE */
    private String classcode = "";
    /** ����SYSTEMCODE */
    private String systemCode = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpljobmanagerDtoBase����
     */
    public PrpljobmanagerDtoBase(){
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
     * ��������JOBROLE
     * @param jobrole �����õ�����JOBROLE��ֵ
     */
    public void setJobrole(String jobrole){
        this.jobrole = StringUtils.rightTrim(jobrole);
    }

    /**
     * ��ȡ����JOBROLE
     * @return ����JOBROLE��ֵ
     */
    public String getJobrole(){
        return jobrole;
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
     * ��������DEPTNAME
     * @param deptname �����õ�����DEPTNAME��ֵ
     */
    public void setDeptname(String deptname){
        this.deptname = StringUtils.rightTrim(deptname);
    }

    /**
     * ��ȡ����DEPTNAME
     * @return ����DEPTNAME��ֵ
     */
    public String getDeptname(){
        return deptname;
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
     * ��������MONTH
     * @param month �����õ�����MONTH��ֵ
     */
    public void setMonth(String month){
        this.month = StringUtils.rightTrim(month);
    }

    /**
     * ��ȡ����MONTH
     * @return ����MONTH��ֵ
     */
    public String getMonth(){
        return month;
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

	public String getSystemCode() {
		return systemCode;
	}

	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	}
    
}
