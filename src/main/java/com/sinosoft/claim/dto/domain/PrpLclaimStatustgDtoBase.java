package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLclaimStatus-理赔节点状态表(新增)的数据传输对象基类<br>
 * 创建于 2005-03-18 17:53:35.765<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLclaimStatustgDtoBase implements Serializable{
    /** 属性业务号 */
    private String businessNo = "";
    /** 属性保单号码 */
    private String policyNo = "";
    /** 属性节点种类 */
    private String nodeType = "";
    /** 属性序列号码 */
    private int serialNo = 0;
    /** 属性险种 */
    private String riskCode = "";
    /** 属性操作状态位 */
    private String status = "";
    /** 属性流程编号 */
    private String flowID = "";
    /** 属性办理人员编码 */
    private String handlerCode = "";
    /** 属性计算机输单日期 */
    private DateTime inputDate = new DateTime();
    /** 属性操作日期 */
    private DateTime operateDate = new DateTime();
    /** 属性类型标志 */
    private String typeFlag = "";
    /** 属性标志位 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpLclaimStatustgDtoBase对象
     */
    public PrpLclaimStatustgDtoBase(){
    }

    /**
     * 设置属性业务号
     * @param businessNo 待设置的属性业务号的值
     */
    public void setBusinessNo(String businessNo){
        this.businessNo = StringUtils.rightTrim(businessNo);
    }

    /**
     * 获取属性业务号
     * @return 属性业务号的值
     */
    public String getBusinessNo(){
        return businessNo;
    }

    /**
     * 设置属性保单号码
     * @param policyNo 待设置的属性保单号码的值
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * 获取属性保单号码
     * @return 属性保单号码的值
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * 设置属性节点种类
     * @param nodeType 待设置的属性节点种类的值
     */
    public void setNodeType(String nodeType){
        this.nodeType = StringUtils.rightTrim(nodeType);
    }

    /**
     * 获取属性节点种类
     * @return 属性节点种类的值
     */
    public String getNodeType(){
        return nodeType;
    }

    /**
     * 设置属性序列号码
     * @param serialNo 待设置的属性序列号码的值
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性序列号码
     * @return 属性序列号码的值
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * 设置属性险种
     * @param riskCode 待设置的属性险种的值
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * 获取属性险种
     * @return 属性险种的值
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * 设置属性操作状态位
     * @param status 待设置的属性操作状态位的值
     */
    public void setStatus(String status){
        this.status = StringUtils.rightTrim(status);
    }

    /**
     * 获取属性操作状态位
     * @return 属性操作状态位的值
     */
    public String getStatus(){
        return status;
    }

    /**
     * 设置属性流程编号
     * @param flowID 待设置的属性流程编号的值
     */
    public void setFlowID(String flowID){
        this.flowID = StringUtils.rightTrim(flowID);
    }

    /**
     * 获取属性流程编号
     * @return 属性流程编号的值
     */
    public String getFlowID(){
        return flowID;
    }

    /**
     * 设置属性办理人员编码
     * @param handlerCode 待设置的属性办理人员编码的值
     */
    public void setHandlerCode(String handlerCode){
        this.handlerCode = StringUtils.rightTrim(handlerCode);
    }

    /**
     * 获取属性办理人员编码
     * @return 属性办理人员编码的值
     */
    public String getHandlerCode(){
        return handlerCode;
    }

    /**
     * 设置属性计算机输单日期
     * @param inputDate 待设置的属性计算机输单日期的值
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * 获取属性计算机输单日期
     * @return 属性计算机输单日期的值
     */
    public DateTime getInputDate(){
        return inputDate;
    }

    /**
     * 设置属性操作日期
     * @param operateDate 待设置的属性操作日期的值
     */
    public void setOperateDate(DateTime operateDate){
        this.operateDate = operateDate;
    }

    /**
     * 获取属性操作日期
     * @return 属性操作日期的值
     */
    public DateTime getOperateDate(){
        return operateDate;
    }

    /**
     * 设置属性类型标志
     * @param typeFlag 待设置的属性类型标志的值
     */
    public void setTypeFlag(String typeFlag){
        this.typeFlag = StringUtils.rightTrim(typeFlag);
    }

    /**
     * 获取属性类型标志
     * @return 属性类型标志的值
     */
    public String getTypeFlag(){
        return typeFlag;
    }

    /**
     * 设置属性标志位
     * @param flag 待设置的属性标志位的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性标志位
     * @return 属性标志位的值
     */
    public String getFlag(){
        return flag;
    }
}
