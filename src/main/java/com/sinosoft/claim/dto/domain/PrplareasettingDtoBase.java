package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPLAREASETTING的数据传输对象基类<br>
 */
public class PrplareasettingDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性ID */
    private String id = "";
    /** 属性HANDLERCODE */
    private String handlercode = "";
    /** 属性HANDLEDEPT */
    private String handledept = "";
    /** 属性HANDLERNAME */
    private String handlername = "";
    /** 属性AREA */
    private String area = "";
    /** 属性TEL */
    private String tel = "";
    /** 属性OPERATOR */
    private String operator = "";
    /** 属性OPERATORID */
    private String operatorid = "";
    /** 属性FLOWINTIME */
    private String flowintime = "";
    /** 属性MODIFYTIME */
    private String modifytime = "";
    /** 属性CLASSCODE */
    private String classcode = "";

    /**
     *  默认构造方法,构造一个默认的PrplareasettingDtoBase对象
     */
    public PrplareasettingDtoBase(){
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
     * 设置属性AREA
     * @param area 待设置的属性AREA的值
     */
    public void setArea(String area){
        this.area = StringUtils.rightTrim(area);
    }

    /**
     * 获取属性AREA
     * @return 属性AREA的值
     */
    public String getArea(){
        return area;
    }

    /**
     * 设置属性TEL
     * @param tel 待设置的属性TEL的值
     */
    public void setTel(String tel){
        this.tel = StringUtils.rightTrim(tel);
    }

    /**
     * 获取属性TEL
     * @return 属性TEL的值
     */
    public String getTel(){
        return tel;
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
}
