package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpPcontractpause中止保险合同信息表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:32:06<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpPcontractpauseDtoBase implements Serializable{
    /** 属性批单号 */
    private String endorseNo = "";
    /** 属性保单号 */
    private String policyNo = "";
    /** 属性原起保日期 */
    private DateTime startDate = new DateTime();
    /** 属性原起保小时 */
    private int startHour = 0;
    /** 属性原终保日期 */
    private DateTime endDate = new DateTime();
    /** 属性原终保小时 */
    private int endHour = 0;
    /** 属性失效起始日期 */
    private DateTime invalidStartDate = new DateTime();
    /** 属性失效起始小时 */
    private int invalidStartHour = 0;
    /** 属性失效终止日期 */
    private DateTime invalidEndDate = new DateTime();
    /** 属性失效终止小时 */
    private int invalidEndHour = 0;
    /** 属性标志位 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpPcontractpauseDtoBase对象
     */
    public PrpPcontractpauseDtoBase(){
    }

    /**
     * 设置属性批单号
     * @param endorseNo 待设置的属性批单号的值
     */
    public void setEndorseNo(String endorseNo){
        this.endorseNo = StringUtils.rightTrim(endorseNo);
    }

    /**
     * 获取属性批单号
     * @return 属性批单号的值
     */
    public String getEndorseNo(){
        return endorseNo;
    }

    /**
     * 设置属性保单号
     * @param policyNo 待设置的属性保单号的值
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * 获取属性保单号
     * @return 属性保单号的值
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * 设置属性原起保日期
     * @param startDate 待设置的属性原起保日期的值
     */
    public void setStartDate(DateTime startDate){
        this.startDate = startDate;
    }

    /**
     * 获取属性原起保日期
     * @return 属性原起保日期的值
     */
    public DateTime getStartDate(){
        return startDate;
    }

    /**
     * 设置属性原起保小时
     * @param startHour 待设置的属性原起保小时的值
     */
    public void setStartHour(int startHour){
        this.startHour = startHour;
    }

    /**
     * 获取属性原起保小时
     * @return 属性原起保小时的值
     */
    public int getStartHour(){
        return startHour;
    }

    /**
     * 设置属性原终保日期
     * @param endDate 待设置的属性原终保日期的值
     */
    public void setEndDate(DateTime endDate){
        this.endDate = endDate;
    }

    /**
     * 获取属性原终保日期
     * @return 属性原终保日期的值
     */
    public DateTime getEndDate(){
        return endDate;
    }

    /**
     * 设置属性原终保小时
     * @param endHour 待设置的属性原终保小时的值
     */
    public void setEndHour(int endHour){
        this.endHour = endHour;
    }

    /**
     * 获取属性原终保小时
     * @return 属性原终保小时的值
     */
    public int getEndHour(){
        return endHour;
    }

    /**
     * 设置属性失效起始日期
     * @param invalidStartDate 待设置的属性失效起始日期的值
     */
    public void setInvalidStartDate(DateTime invalidStartDate){
        this.invalidStartDate = invalidStartDate;
    }

    /**
     * 获取属性失效起始日期
     * @return 属性失效起始日期的值
     */
    public DateTime getInvalidStartDate(){
        return invalidStartDate;
    }

    /**
     * 设置属性失效起始小时
     * @param invalidStartHour 待设置的属性失效起始小时的值
     */
    public void setInvalidStartHour(int invalidStartHour){
        this.invalidStartHour = invalidStartHour;
    }

    /**
     * 获取属性失效起始小时
     * @return 属性失效起始小时的值
     */
    public int getInvalidStartHour(){
        return invalidStartHour;
    }

    /**
     * 设置属性失效终止日期
     * @param invalidEndDate 待设置的属性失效终止日期的值
     */
    public void setInvalidEndDate(DateTime invalidEndDate){
        this.invalidEndDate = invalidEndDate;
    }

    /**
     * 获取属性失效终止日期
     * @return 属性失效终止日期的值
     */
    public DateTime getInvalidEndDate(){
        return invalidEndDate;
    }

    /**
     * 设置属性失效终止小时
     * @param invalidEndHour 待设置的属性失效终止小时的值
     */
    public void setInvalidEndHour(int invalidEndHour){
        this.invalidEndHour = invalidEndHour;
    }

    /**
     * 获取属性失效终止小时
     * @return 属性失效终止小时的值
     */
    public int getInvalidEndHour(){
        return invalidEndHour;
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
