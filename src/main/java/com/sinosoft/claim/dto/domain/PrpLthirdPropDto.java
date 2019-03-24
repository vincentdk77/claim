package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLthirdProp-财产损失部位表的数据传输对象类<br>
 * 创建于 2005-04-12 11:37:47.312<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLthirdPropDto extends PrpLthirdPropDtoBase implements Serializable{
    /**
     *  默认构造方法,构造一个默认的PrpLthirdPropDto对象
     */
    public PrpLthirdPropDto(){
    }

    /** 属性显示列表*/
    private Collection thirdPropList;
    
    /** 属性是险别*/
    private String prpLthirdPropKindCode = "";
    
    /** 属性调度处理标志 */
    private String scheduleType = "";

    /** 属性是否选择发送 */
    private String selectSend = "";
     /** 属性是哪个节点的调用 */
    private String nodeType = "";
    
    /**
     * 设置属性险别类型
     * @param prpLthirdPropKindCode 待设置的属性险别类型的值
     */
    public void setPrpLthirdPropKindCode(String prpLthirdPropKindCode){
        this.prpLthirdPropKindCode = StringUtils.rightTrim(prpLthirdPropKindCode);
    }

    /**
     * 获取属性险别类型
     * @return 属性险别类型的值
     */
    public String getPrpLthirdPropKindCode(){
        return prpLthirdPropKindCode;
    }
    
    public void setThirdPropList(Collection thirdPropList) {
      this.thirdPropList = thirdPropList;
    }

    public Collection getThirdPropList() {
      return thirdPropList;
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

}
