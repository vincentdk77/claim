package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLbackVisitQue--回访问询表的数据传输对象基类<br>
 * 创建于 2005-03-23 09:00:19.125<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLbackVisitQueDtoBase implements Serializable{
    /** 属性客户回访记录ID */
    private int backVisitID = 0;
    /** 属性报案号码 */
    private String registNo = "";
    /** 属性业务类型 */
    private String backVisitType = "";
    /** 属性回访项目代码 */
    private String questionCode = "";
    /** 属性回访项目名称 */
    private String questionName = "";
    /** 属性回访结果 */
    private String questionResult = "";
    /** 属性问题备注 */
    private String questionRemark = "";
    /** 属性问题类型 */
    private String questionType = "";
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpLbackVisitQueDtoBase对象
     */
    public PrpLbackVisitQueDtoBase(){
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
     * 设置属性回访项目代码
     * @param questionCode 待设置的属性回访项目代码的值
     */
    public void setQuestionCode(String questionCode){
        this.questionCode = StringUtils.rightTrim(questionCode);
    }

    /**
     * 获取属性回访项目代码
     * @return 属性回访项目代码的值
     */
    public String getQuestionCode(){
        return questionCode;
    }

    /**
     * 设置属性回访项目名称
     * @param questionName 待设置的属性回访项目名称的值
     */
    public void setQuestionName(String questionName){
        this.questionName = StringUtils.rightTrim(questionName);
    }

    /**
     * 获取属性回访项目名称
     * @return 属性回访项目名称的值
     */
    public String getQuestionName(){
        return questionName;
    }

    /**
     * 设置属性回访结果
     * @param questionResult 待设置的属性回访结果的值
     */
    public void setQuestionResult(String questionResult){
        this.questionResult = StringUtils.rightTrim(questionResult);
    }

    /**
     * 获取属性回访结果
     * @return 属性回访结果的值
     */
    public String getQuestionResult(){
        return questionResult;
    }

    /**
     * 设置属性问题备注
     * @param questionRemark 待设置的属性问题备注的值
     */
    public void setQuestionRemark(String questionRemark){
        this.questionRemark = StringUtils.rightTrim(questionRemark);
    }

    /**
     * 获取属性问题备注
     * @return 属性问题备注的值
     */
    public String getQuestionRemark(){
        return questionRemark;
    }

    /**
     * 设置属性问题类型
     * @param questionType 待设置的属性问题类型的值
     */
    public void setQuestionType(String questionType){
        this.questionType = StringUtils.rightTrim(questionType);
    }

    /**
     * 获取属性问题类型
     * @return 属性问题类型的值
     */
    public String getQuestionType(){
        return questionType;
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
