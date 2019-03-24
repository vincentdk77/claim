package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpgnode工作流节点模板表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpGnodeDtoBase implements Serializable{
    /** 属性模板号 */
    private int modelNo = 0;
    /** 属性节点号 */
    private int nodeNo = 0;
    /** 属性节点名称 */
    private String nodeName = "";
    /** 属性子节点号 */
    private int sonNodeNo = 0;
    /** 属性子节点名称 */
    private String sonNodeName = "";
    /** 属性预计时限 */
    private int limitDay = 0;
    /** 属性岗位代码 */
    private String gradeCode = "";
    /** 属性归属机构代码 */
    private String comCode = "";
    /** 属性出单机构代码 */
    private String makeCom = "";
    /** 属性节点状态 */
    private String nodeFlag = "";
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpGnodeDtoBase对象
     */
    public PrpGnodeDtoBase(){
    }

    /**
     * 设置属性模板号
     * @param modelNo 待设置的属性模板号的值
     */
    public void setModelNo(int modelNo){
        this.modelNo = modelNo;
    }

    /**
     * 获取属性模板号
     * @return 属性模板号的值
     */
    public int getModelNo(){
        return modelNo;
    }

    /**
     * 设置属性节点号
     * @param nodeNo 待设置的属性节点号的值
     */
    public void setNodeNo(int nodeNo){
        this.nodeNo = nodeNo;
    }

    /**
     * 获取属性节点号
     * @return 属性节点号的值
     */
    public int getNodeNo(){
        return nodeNo;
    }

    /**
     * 设置属性节点名称
     * @param nodeName 待设置的属性节点名称的值
     */
    public void setNodeName(String nodeName){
        this.nodeName = StringUtils.rightTrim(nodeName);
    }

    /**
     * 获取属性节点名称
     * @return 属性节点名称的值
     */
    public String getNodeName(){
        return nodeName;
    }

    /**
     * 设置属性子节点号
     * @param sonNodeNo 待设置的属性子节点号的值
     */
    public void setSonNodeNo(int sonNodeNo){
        this.sonNodeNo = sonNodeNo;
    }

    /**
     * 获取属性子节点号
     * @return 属性子节点号的值
     */
    public int getSonNodeNo(){
        return sonNodeNo;
    }

    /**
     * 设置属性子节点名称
     * @param sonNodeName 待设置的属性子节点名称的值
     */
    public void setSonNodeName(String sonNodeName){
        this.sonNodeName = StringUtils.rightTrim(sonNodeName);
    }

    /**
     * 获取属性子节点名称
     * @return 属性子节点名称的值
     */
    public String getSonNodeName(){
        return sonNodeName;
    }

    /**
     * 设置属性预计时限
     * @param limitDay 待设置的属性预计时限的值
     */
    public void setLimitDay(int limitDay){
        this.limitDay = limitDay;
    }

    /**
     * 获取属性预计时限
     * @return 属性预计时限的值
     */
    public int getLimitDay(){
        return limitDay;
    }

    /**
     * 设置属性岗位代码
     * @param gradeCode 待设置的属性岗位代码的值
     */
    public void setGradeCode(String gradeCode){
        this.gradeCode = StringUtils.rightTrim(gradeCode);
    }

    /**
     * 获取属性岗位代码
     * @return 属性岗位代码的值
     */
    public String getGradeCode(){
        return gradeCode;
    }

    /**
     * 设置属性归属机构代码
     * @param comCode 待设置的属性归属机构代码的值
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * 获取属性归属机构代码
     * @return 属性归属机构代码的值
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * 设置属性出单机构代码
     * @param makeCom 待设置的属性出单机构代码的值
     */
    public void setMakeCom(String makeCom){
        this.makeCom = StringUtils.rightTrim(makeCom);
    }

    /**
     * 获取属性出单机构代码
     * @return 属性出单机构代码的值
     */
    public String getMakeCom(){
        return makeCom;
    }

    /**
     * 设置属性节点状态
     * @param nodeFlag 待设置的属性节点状态的值
     */
    public void setNodeFlag(String nodeFlag){
        this.nodeFlag = StringUtils.rightTrim(nodeFlag);
    }

    /**
     * 获取属性节点状态
     * @return 属性节点状态的值
     */
    public String getNodeFlag(){
        return nodeFlag;
    }

    /**
     * 设置属性标志字段
     * @param flag 待设置的属性标志字段的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性标志字段
     * @return 属性标志字段的值
     */
    public String getFlag(){
        return flag;
    }
}
