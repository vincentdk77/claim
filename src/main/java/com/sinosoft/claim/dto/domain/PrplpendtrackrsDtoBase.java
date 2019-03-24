package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPLPENDTRACKRS的数据传输对象基类<br>
 */
public class PrplpendtrackrsDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性REGISTNO 报案号*/
    private String registno = "";
    /** 属性LOGNO 序号*/
    private String logno = "";
    /** 属性NODETYPE 对应结点名（车物查勘、人伤查勘、单证)*/
    private String nodetype = "";
    /** 属性KINDCODE 涉及险别*/
    private String kindcode = "";
    /** 属性NAME 伤者姓名*/
    private String name = "";
    /** 属性TREATMENT 治疗情况*/
    private String treatment = "";
    /** 属性COST 已产生费用*/
    private String cost = "";
    /** 属性REMARK 跟踪说明*/
    private String remark = "";

    /**
     *  默认构造方法,构造一个默认的PrplpendtrackrsDtoBase对象
     */
    public PrplpendtrackrsDtoBase(){
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
     * 设置属性LOGNO
     * @param logno 待设置的属性LOGNO的值
     */
    public void setLogno(String logno){
        this.logno = StringUtils.rightTrim(logno);
    }

    /**
     * 获取属性LOGNO
     * @return 属性LOGNO的值
     */
    public String getLogno(){
        return logno;
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
     * 设置属性KINDCODE
     * @param kindcode 待设置的属性KINDCODE的值
     */
    public void setKindcode(String kindcode){
        this.kindcode = StringUtils.rightTrim(kindcode);
    }

    /**
     * 获取属性KINDCODE
     * @return 属性KINDCODE的值
     */
    public String getKindcode(){
        return kindcode;
    }

    /**
     * 设置属性NAME
     * @param name 待设置的属性NAME的值
     */
    public void setName(String name){
        this.name = StringUtils.rightTrim(name);
    }

    /**
     * 获取属性NAME
     * @return 属性NAME的值
     */
    public String getName(){
        return name;
    }

    /**
     * 设置属性TREATMENT
     * @param treatment 待设置的属性TREATMENT的值
     */
    public void setTreatment(String treatment){
        this.treatment = StringUtils.rightTrim(treatment);
    }

    /**
     * 获取属性TREATMENT
     * @return 属性TREATMENT的值
     */
    public String getTreatment(){
        return treatment;
    }

    /**
     * 设置属性COST
     * @param cost 待设置的属性COST的值
     */
    public void setCost(String cost){
        this.cost = StringUtils.rightTrim(cost);
    }

    /**
     * 获取属性COST
     * @return 属性COST的值
     */
    public String getCost(){
        return cost;
    }

    /**
     * 设置属性REMARK
     * @param remark 待设置的属性REMARK的值
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * 获取属性REMARK
     * @return 属性REMARK的值
     */
    public String getRemark(){
        return remark;
    }
}
