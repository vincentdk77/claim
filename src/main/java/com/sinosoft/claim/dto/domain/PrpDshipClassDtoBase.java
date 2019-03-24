package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdshipclass船舶船级社对照的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDshipClassDtoBase implements Serializable{
    /** 属性船舶代码 */
    private String shipCode = "";
    /** 属性序号 */
    private int serialNo = 0;
    /** 属性船级社名称 */
    private String classification = "";
    /** 属性发证日期 */
    private DateTime issuedonDate = new DateTime();
    /** 属性终止日期 */
    private DateTime closingDate = new DateTime();
    /** 属性备注 */
    private String remark = "";
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDshipClassDtoBase对象
     */
    public PrpDshipClassDtoBase(){
    }

    /**
     * 设置属性船舶代码
     * @param shipCode 待设置的属性船舶代码的值
     */
    public void setShipCode(String shipCode){
        this.shipCode = StringUtils.rightTrim(shipCode);
    }

    /**
     * 获取属性船舶代码
     * @return 属性船舶代码的值
     */
    public String getShipCode(){
        return shipCode;
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
     * 设置属性船级社名称
     * @param classification 待设置的属性船级社名称的值
     */
    public void setClassification(String classification){
        this.classification = StringUtils.rightTrim(classification);
    }

    /**
     * 获取属性船级社名称
     * @return 属性船级社名称的值
     */
    public String getClassification(){
        return classification;
    }

    /**
     * 设置属性发证日期
     * @param issuedonDate 待设置的属性发证日期的值
     */
    public void setIssuedonDate(DateTime issuedonDate){
        this.issuedonDate = issuedonDate;
    }

    /**
     * 获取属性发证日期
     * @return 属性发证日期的值
     */
    public DateTime getIssuedonDate(){
        return issuedonDate;
    }

    /**
     * 设置属性终止日期
     * @param closingDate 待设置的属性终止日期的值
     */
    public void setClosingDate(DateTime closingDate){
        this.closingDate = closingDate;
    }

    /**
     * 获取属性终止日期
     * @return 属性终止日期的值
     */
    public DateTime getClosingDate(){
        return closingDate;
    }

    /**
     * 设置属性备注
     * @param remark 待设置的属性备注的值
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * 获取属性备注
     * @return 属性备注的值
     */
    public String getRemark(){
        return remark;
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
