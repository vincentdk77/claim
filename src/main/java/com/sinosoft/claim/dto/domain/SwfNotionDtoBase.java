package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是工作流意见处理表的数据传输对象基类<br>
 * 创建于 2005-04-05 10:45:00.265<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class SwfNotionDtoBase implements Serializable{
    /** 属性工作流ID */
    private String flowID = "";
    /** 属性日志序号 */
    private int logNo = 0;
    /** 属性行号 */
    private int lineNo = 0;
    /** 属性处理意见 */
    private String handleText = "";
    /** 属性备用标志 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的SwfNotionDtoBase对象
     */
    public SwfNotionDtoBase(){
    }

    /**
     * 设置属性工作流ID
     * @param flowID 待设置的属性工作流ID的值
     */
    public void setFlowID(String flowID){
        this.flowID = StringUtils.rightTrim(flowID);
    }

    /**
     * 获取属性工作流ID
     * @return 属性工作流ID的值
     */
    public String getFlowID(){
        return flowID;
    }

    /**
     * 设置属性日志序号
     * @param logNo 待设置的属性日志序号的值
     */
    public void setLogNo(int logNo){
        this.logNo = logNo;
    }

    /**
     * 获取属性日志序号
     * @return 属性日志序号的值
     */
    public int getLogNo(){
        return logNo;
    }

    /**
     * 设置属性行号
     * @param lineNo 待设置的属性行号的值
     */
    public void setLineNo(int lineNo){
        this.lineNo = lineNo;
    }

    /**
     * 获取属性行号
     * @return 属性行号的值
     */
    public int getLineNo(){
        return lineNo;
    }

    /**
     * 设置属性处理意见
     * @param handleText 待设置的属性处理意见的值
     */
    public void setHandleText(String handleText){
        this.handleText = StringUtils.rightTrim(handleText);
    }

    /**
     * 获取属性处理意见
     * @return 属性处理意见的值
     */
    public String getHandleText(){
        return handleText;
    }

    /**
     * 设置属性备用标志
     * @param flag 待设置的属性备用标志的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性备用标志
     * @return 属性备用标志的值
     */
    public String getFlag(){
        return flag;
    }
}
