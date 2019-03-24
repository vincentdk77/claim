package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLbackVisitText--回访备注表的数据传输对象基类<br>
 * 创建于 2005-03-23 09:00:34.781<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLbackVisitTextDtoBase implements Serializable{
    /** 属性客户回访记录ID */
    private int backVisitID = 0;
    /** 属性报案号码 */
    private String registNo = "";
    /** 属性业务类型 */
    private String backVisitType = "";
    /** 属性行序号 */
    private int lineNo = 0;
    /** 属性操作员代码 */
    private String operatorCode = "";
    /** 属性反馈/回访内容 */
    private String content = "";
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpLbackVisitTextDtoBase对象
     */
    public PrpLbackVisitTextDtoBase(){
    }

    /**
     * 设置属性客户回访记录ID
     * @param backVisitID 待设置的属性客户回访记录ID的值
     */
    public void setBackVisitID(int backVisitID){
        this.backVisitID = backVisitID;
    }

    /**
     * 获取属性客户回访记录ID
     * @return 属性客户回访记录ID的值
     */
    public int getBackVisitID(){
        return backVisitID;
    }

    /**
     * 设置属性报案号码
     * @param registNo 待设置的属性报案号码的值
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * 获取属性报案号码
     * @return 属性报案号码的值
     */
    public String getRegistNo(){
        return registNo;
    }

    /**
     * 设置属性业务类型
     * @param backVisitType 待设置的属性业务类型的值
     */
    public void setBackVisitType(String backVisitType){
        this.backVisitType = StringUtils.rightTrim(backVisitType);
    }

    /**
     * 获取属性业务类型
     * @return 属性业务类型的值
     */
    public String getBackVisitType(){
        return backVisitType;
    }

    /**
     * 设置属性行序号
     * @param lineNo 待设置的属性行序号的值
     */
    public void setLineNo(int lineNo){
        this.lineNo = lineNo;
    }

    /**
     * 获取属性行序号
     * @return 属性行序号的值
     */
    public int getLineNo(){
        return lineNo;
    }

    /**
     * 设置属性操作员代码
     * @param operatorCode 待设置的属性操作员代码的值
     */
    public void setOperatorCode(String operatorCode){
        this.operatorCode = StringUtils.rightTrim(operatorCode);
    }

    /**
     * 获取属性操作员代码
     * @return 属性操作员代码的值
     */
    public String getOperatorCode(){
        return operatorCode;
    }

    /**
     * 设置属性反馈/回访内容
     * @param content 待设置的属性反馈/回访内容的值
     */
    public void setContent(String content){
        this.content = StringUtils.rightTrim(content);
    }

    /**
     * 获取属性反馈/回访内容
     * @return 属性反馈/回访内容的值
     */
    public String getContent(){
        return content;
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
