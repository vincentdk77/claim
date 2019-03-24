package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPLJOBMANAGER的数据传输对象基类<br>
 */
public class PrpljobmanagerDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性ID */
    private String id = "";
    /** 属性JOBROLE */
    private String jobrole = "";
    /** 属性HANDLERCODE */
    private String handlercode = "";
    /** 属性HANDLERNAME */
    private String handlername = "";
    /** 属性HANDLEDEPT */
    private String handledept = "";
    /** 属性DEPTNAME */
    private String deptname = "";
    /** 属性FLOWINTIME */
    private String flowintime = "";
    /** 属性MODIFYTIME */
    private String modifytime = "";
    /** 属性MONTH */
    private String month = "";
    /** 属性OPERATOR */
    private String operator = "";
    /** 属性OPERATORID */
    private String operatorid = "";
    /** 属性CLASSCODE */
    private String classcode = "";
    /** 属性SYSTEMCODE */
    private String systemCode = "";

    /**
     *  默认构造方法,构造一个默认的PrpljobmanagerDtoBase对象
     */
    public PrpljobmanagerDtoBase(){
    }

    /**
     * 设置属性ID
     * @param id 待设置的属性ID的值
     */
    public void setId(String id){
        this.id = StringUtils.rightTrim(id);
    }

    /**
     * 获取属性ID
     * @return 属性ID的值
     */
    public String getId(){
        return id;
    }

    /**
     * 设置属性JOBROLE
     * @param jobrole 待设置的属性JOBROLE的值
     */
    public void setJobrole(String jobrole){
        this.jobrole = StringUtils.rightTrim(jobrole);
    }

    /**
     * 获取属性JOBROLE
     * @return 属性JOBROLE的值
     */
    public String getJobrole(){
        return jobrole;
    }

    /**
     * 设置属性HANDLERCODE
     * @param handlercode 待设置的属性HANDLERCODE的值
     */
    public void setHandlercode(String handlercode){
        this.handlercode = StringUtils.rightTrim(handlercode);
    }

    /**
     * 获取属性HANDLERCODE
     * @return 属性HANDLERCODE的值
     */
    public String getHandlercode(){
        return handlercode;
    }

    /**
     * 设置属性HANDLERNAME
     * @param handlername 待设置的属性HANDLERNAME的值
     */
    public void setHandlername(String handlername){
        this.handlername = StringUtils.rightTrim(handlername);
    }

    /**
     * 获取属性HANDLERNAME
     * @return 属性HANDLERNAME的值
     */
    public String getHandlername(){
        return handlername;
    }

    /**
     * 设置属性HANDLEDEPT
     * @param handledept 待设置的属性HANDLEDEPT的值
     */
    public void setHandledept(String handledept){
        this.handledept = StringUtils.rightTrim(handledept);
    }

    /**
     * 获取属性HANDLEDEPT
     * @return 属性HANDLEDEPT的值
     */
    public String getHandledept(){
        return handledept;
    }

    /**
     * 设置属性DEPTNAME
     * @param deptname 待设置的属性DEPTNAME的值
     */
    public void setDeptname(String deptname){
        this.deptname = StringUtils.rightTrim(deptname);
    }

    /**
     * 获取属性DEPTNAME
     * @return 属性DEPTNAME的值
     */
    public String getDeptname(){
        return deptname;
    }

    /**
     * 设置属性FLOWINTIME
     * @param flowintime 待设置的属性FLOWINTIME的值
     */
    public void setFlowintime(String flowintime){
        this.flowintime = StringUtils.rightTrim(flowintime);
    }

    /**
     * 获取属性FLOWINTIME
     * @return 属性FLOWINTIME的值
     */
    public String getFlowintime(){
        return flowintime;
    }

    /**
     * 设置属性MODIFYTIME
     * @param modifytime 待设置的属性MODIFYTIME的值
     */
    public void setModifytime(String modifytime){
        this.modifytime = StringUtils.rightTrim(modifytime);
    }

    /**
     * 获取属性MODIFYTIME
     * @return 属性MODIFYTIME的值
     */
    public String getModifytime(){
        return modifytime;
    }

    /**
     * 设置属性MONTH
     * @param month 待设置的属性MONTH的值
     */
    public void setMonth(String month){
        this.month = StringUtils.rightTrim(month);
    }

    /**
     * 获取属性MONTH
     * @return 属性MONTH的值
     */
    public String getMonth(){
        return month;
    }

    /**
     * 设置属性OPERATOR
     * @param operator 待设置的属性OPERATOR的值
     */
    public void setOperator(String operator){
        this.operator = StringUtils.rightTrim(operator);
    }

    /**
     * 获取属性OPERATOR
     * @return 属性OPERATOR的值
     */
    public String getOperator(){
        return operator;
    }

    /**
     * 设置属性OPERATORID
     * @param operatorid 待设置的属性OPERATORID的值
     */
    public void setOperatorid(String operatorid){
        this.operatorid = StringUtils.rightTrim(operatorid);
    }

    /**
     * 获取属性OPERATORID
     * @return 属性OPERATORID的值
     */
    public String getOperatorid(){
        return operatorid;
    }

    /**
     * 设置属性CLASSCODE
     * @param classcode 待设置的属性CLASSCODE的值
     */
    public void setClasscode(String classcode){
        this.classcode = StringUtils.rightTrim(classcode);
    }

    /**
     * 获取属性CLASSCODE
     * @return 属性CLASSCODE的值
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
