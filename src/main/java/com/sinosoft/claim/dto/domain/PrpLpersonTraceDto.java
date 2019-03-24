package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLpersonTrace 人伤跟踪表的数据传输对象类<br>
 * 创建于 2005-02-18 10:21:16.171<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLpersonTraceDto extends PrpLpersonTraceDtoBase implements Serializable{

    private Collection personTraceList ;
        /** 属性调度处理标志 */
    private String scheduleType = "";

    /** 属性是否选择发送 */
    private String selectSend = "";
     /** 属性是哪个节点的调用 */
    private String nodeType = "";

    /** 险别*/
    private String prpLpersonTraceReferKind;


    /**
     *  默认构造方法,构造一个默认的PrpLpersonTraceDto对象
     */
    public PrpLpersonTraceDto(){
    }

     /**
     * 获取列表
     * @return 属性列表
     */
    public Collection getPersonTraceList(){
      return personTraceList ;
    }
    /**
     * 设置列表
     * @param driverList 待设置的列表
     */
    public void setPersonTraceList(Collection personTraceList ) {
      this.personTraceList  = personTraceList ;
    }
        /**
     * 设置属性调度处理标志
     * @param scheduleType 待设置的属性调度处理标志的值
     */
    public void setScheduleType(String scheduleType){
        this.scheduleType = StringUtils.rightTrim(scheduleType);
    }

    /**
     * 获取属性调度处理标志
     * @return 属性调度处理标志的值
     */
    public String getScheduleType(){
        return scheduleType;
    }

    /**
     * 设置属性是否选择发送
     * @param selectSend 待设置的属性是否选择发送的值
     */
    public void setSelectSend(String selectSend){
        this.selectSend = StringUtils.rightTrim(selectSend);
    }

    /**
     * 获取属性是否选择发送
     * @return 属性是否选择发送的值
     */
    public String getSelectSend(){
        return selectSend;
    }
 /**
     * 设置属性节点类型
     * @param nodeType 待设置的属性节点类型的值
     */
    public void setNodeType(String nodeType){
        this.nodeType = StringUtils.rightTrim(nodeType);
    }

    /**
     * 获取属性节点类型
     * @return 属性节点类型的值
     */
    public String getNodeType(){
        return nodeType;
    }

  /**
    * 获取属性险别代码
    * @return 属性险别代码
    */
    public String getPrpLpersonTraceReferKind()
    {
      return this.prpLpersonTraceReferKind;
    }

  /**
    * 设置属性险别代码
    * @param prpLpersonTraceReferKind 待设置的属性险别代码
    */
    public void setPrpLpersonTraceReferKind(String prpLpersonTraceReferKind)
    {
      this.prpLpersonTraceReferKind = prpLpersonTraceReferKind;
    }
}
