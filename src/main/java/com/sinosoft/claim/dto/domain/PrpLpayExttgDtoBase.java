package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是支付处理意见表的数据传输对象基类<br>
 */
public class PrpLpayExttgDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性收付编号 */
    private String paymentNo = "";
    /** 属性序号 */
    private int serialNo = 0;
    /** 属性处理时间 */
    private DateTime inputDate = new DateTime();
    /** 属性处理人代码 */
    private String operatorCode = "";
    /** 属性意见内容 */
    private String context = "";
    /** 属性处理机构 */
    private String comCode = "";
    /** 属性处理节点 */
    private String nodeType = "";
    /** 属性处理节点名称 */
    private String nodeName = "";
    /** 属性处理意见代码 */
    private String notionCode = "";
    /** 属性处理意见名字 */
    private String notionName = "";
    /** 属性暂存标志(N/暂存;Y/完成) */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpLpayExttgDtoBase对象
     */
    public PrpLpayExttgDtoBase(){
    }

    /**
     * 设置属性收付编号
     * @param paymentNo 待设置的属性收付编号的值
     */
    public void setPaymentNo(String paymentNo){
        this.paymentNo = StringUtils.rightTrim(paymentNo);
    }

    /**
     * 获取属性收付编号
     * @return 属性收付编号的值
     */
    public String getPaymentNo(){
        return paymentNo;
    }

    /**
     * 设置属性序号
     * @param serialNo 待设置的属性序号的值
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性序号
     * @return 属性序号的值
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * 设置属性处理时间
     * @param inputDate 待设置的属性处理时间的值
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * 获取属性处理时间
     * @return 属性处理时间的值
     */
    public DateTime getInputDate(){
        return inputDate;
    }

    /**
     * 设置属性处理人代码
     * @param operatorCode 待设置的属性处理人代码的值
     */
    public void setOperatorCode(String operatorCode){
        this.operatorCode = StringUtils.rightTrim(operatorCode);
    }

    /**
     * 获取属性处理人代码
     * @return 属性处理人代码的值
     */
    public String getOperatorCode(){
        return operatorCode;
    }

    /**
     * 设置属性意见内容
     * @param context 待设置的属性意见内容的值
     */
    public void setContext(String context){
        this.context = StringUtils.rightTrim(context);
    }

    /**
     * 获取属性意见内容
     * @return 属性意见内容的值
     */
    public String getContext(){
        return context;
    }

    /**
     * 设置属性处理机构
     * @param comCode 待设置的属性处理机构的值
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * 获取属性处理机构
     * @return 属性处理机构的值
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * 设置属性处理节点
     * @param nodeType 待设置的属性处理节点的值
     */
    public void setNodeType(String nodeType){
        this.nodeType = StringUtils.rightTrim(nodeType);
    }

    /**
     * 获取属性处理节点
     * @return 属性处理节点的值
     */
    public String getNodeType(){
        return nodeType;
    }

    /**
     * 设置属性处理节点名称
     * @param nodeName 待设置的属性处理节点名称的值
     */
    public void setNodeName(String nodeName){
        this.nodeName = StringUtils.rightTrim(nodeName);
    }

    /**
     * 获取属性处理节点名称
     * @return 属性处理节点名称的值
     */
    public String getNodeName(){
        return nodeName;
    }

    /**
     * 设置属性处理意见代码
     * @param notionCode 待设置的属性处理意见代码的值
     */
    public void setNotionCode(String notionCode){
        this.notionCode = StringUtils.rightTrim(notionCode);
    }

    /**
     * 获取属性处理意见代码
     * @return 属性处理意见代码的值
     */
    public String getNotionCode(){
        return notionCode;
    }

    /**
     * 设置属性处理意见名字
     * @param notionName 待设置的属性处理意见名字的值
     */
    public void setNotionName(String notionName){
        this.notionName = StringUtils.rightTrim(notionName);
    }

    /**
     * 获取属性处理意见名字
     * @return 属性处理意见名字的值
     */
    public String getNotionName(){
        return notionName;
    }

    /**
     * 设置属性暂存标志(N/暂存;Y/完成)
     * @param flag 待设置的属性暂存标志(N/暂存;Y/完成)的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性暂存标志(N/暂存;Y/完成)
     * @return 属性暂存标志(N/暂存;Y/完成)的值
     */
    public String getFlag(){
        return flag;
    }
}
