package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPLREGISTHIS的数据传输对象基类<br>
 */
public class PrplregisthisDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性REGISTNO */
    private String registno = "";
    /** 属性SERIALNO */
    private int serialno = 0;
    /** 属性INPUTDATE */
    private String inputdate = "";
    /** 属性OPERATORCODE */
    private String operatorcode = "";
    /** 属性OPERATORNAME */
    private String operatorname = "";
    /** 属性COMCODE */
    private String comcode = "";
    /** 属性MODIFYTYPE */
    private String modifytype = "";
    /** 属性NODETYPE */
    private String nodetype = "";
    /** 属性CONTEXT */
    private String context = "";

    /**
     *  默认构造方法,构造一个默认的PrplregisthisDtoBase对象
     */
    public PrplregisthisDtoBase(){
    }

    /**
     * 设置属性REGISTNO
     * @param registno 待设置的属性REGISTNO的值
     */
    public void setRegistno(String registno){
        this.registno = StringUtils.rightTrim(registno);
    }

    /**
     * 获取属性REGISTNO
     * @return 属性REGISTNO的值
     */
    public String getRegistno(){
        return registno;
    }

    /**
     * 设置属性SERIALNO
     * @param serialno 待设置的属性SERIALNO的值
     */
    public void setSerialno(int serialno){
        this.serialno = serialno;
    }

    /**
     * 获取属性SERIALNO
     * @return 属性SERIALNO的值
     */
    public int getSerialno(){
        return serialno;
    }

    /**
     * 设置属性INPUTDATE
     * @param inputdate 待设置的属性INPUTDATE的值
     */
    public void setInputdate(String inputdate){
        this.inputdate = inputdate;
    }

    /**
     * 获取属性INPUTDATE
     * @return 属性INPUTDATE的值
     */
    public String getInputdate(){
        return inputdate;
    }

    /**
     * 设置属性OPERATORCODE
     * @param operatorcode 待设置的属性OPERATORCODE的值
     */
    public void setOperatorcode(String operatorcode){
        this.operatorcode = StringUtils.rightTrim(operatorcode);
    }

    /**
     * 获取属性OPERATORCODE
     * @return 属性OPERATORCODE的值
     */
    public String getOperatorcode(){
        return operatorcode;
    }

    /**
     * 设置属性OPERATORNAME
     * @param operatorname 待设置的属性OPERATORNAME的值
     */
    public void setOperatorname(String operatorname){
        this.operatorname = StringUtils.rightTrim(operatorname);
    }

    /**
     * 获取属性OPERATORNAME
     * @return 属性OPERATORNAME的值
     */
    public String getOperatorname(){
        return operatorname;
    }

    /**
     * 设置属性COMCODE
     * @param comcode 待设置的属性COMCODE的值
     */
    public void setComcode(String comcode){
        this.comcode = StringUtils.rightTrim(comcode);
    }

    /**
     * 获取属性COMCODE
     * @return 属性COMCODE的值
     */
    public String getComcode(){
        return comcode;
    }

    /**
     * 设置属性MODIFYTYPE
     * @param modifytype 待设置的属性MODIFYTYPE的值
     */
    public void setModifytype(String modifytype){
        this.modifytype = StringUtils.rightTrim(modifytype);
    }

    /**
     * 获取属性MODIFYTYPE
     * @return 属性MODIFYTYPE的值
     */
    public String getModifytype(){
        return modifytype;
    }

    /**
     * 设置属性NODETYPE
     * @param nodetype 待设置的属性NODETYPE的值
     */
    public void setNodetype(String nodetype){
        this.nodetype = StringUtils.rightTrim(nodetype);
    }

    /**
     * 获取属性NODETYPE
     * @return 属性NODETYPE的值
     */
    public String getNodetype(){
        return nodetype;
    }

    /**
     * 设置属性CONTEXT
     * @param context 待设置的属性CONTEXT的值
     */
    public void setContext(String context){
        this.context = StringUtils.rightTrim(context);
    }

    /**
     * 获取属性CONTEXT
     * @return 属性CONTEXT的值
     */
    public String getContext(){
        return context;
    }
}
