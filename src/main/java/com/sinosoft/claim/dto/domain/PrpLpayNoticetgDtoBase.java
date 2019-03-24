package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是通知单表的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLpayNoticetgDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性通知单号 */
    private String noticeNo = "";
    /** 属性通知单号类型(0,单支付；1,合并支付) */
    private String noticeType = "";
    /** 属性操作日期 */
    private DateTime opreateDate = new DateTime();
    /** 属性操作人代码 */
    private String opreateCode = "";
    /** 属性领款人名称 */
    private String receiverFullName = "";

    /**
     *  默认构造方法,构造一个默认的PrpLpayNoticetgDtoBase对象
     */
    public PrpLpayNoticetgDtoBase(){
    }

    /**
     * 设置属性通知单号
     * @param noticeNo 待设置的属性通知单号的值
     */
    public void setNoticeNo(String noticeNo){
        this.noticeNo = StringUtils.rightTrim(noticeNo);
    }

    /**
     * 获取属性通知单号
     * @return 属性通知单号的值
     */
    public String getNoticeNo(){
        return noticeNo;
    }

    /**
     * 设置属性通知单号类型(0,单支付；1,合并支付)
     * @param noticeType 待设置的属性通知单号类型(0,单支付；1,合并支付)的值
     */
    public void setNoticeType(String noticeType){
        this.noticeType = StringUtils.rightTrim(noticeType);
    }

    /**
     * 获取属性通知单号类型(0,单支付；1,合并支付)
     * @return 属性通知单号类型(0,单支付；1,合并支付)的值
     */
    public String getNoticeType(){
        return noticeType;
    }

    /**
     * 设置属性操作日期
     * @param opreateDate 待设置的属性操作日期的值
     */
    public void setOpreateDate(DateTime opreateDate){
        this.opreateDate = opreateDate;
    }

    /**
     * 获取属性操作日期
     * @return 属性操作日期的值
     */
    public DateTime getOpreateDate(){
        return opreateDate;
    }

    /**
     * 设置属性操作人代码
     * @param opreateCode 待设置的属性操作人代码的值
     */
    public void setOpreateCode(String opreateCode){
        this.opreateCode = StringUtils.rightTrim(opreateCode);
    }

    /**
     * 获取属性操作人代码
     * @return 属性操作人代码的值
     */
    public String getOpreateCode(){
        return opreateCode;
    }

    /**
     * 设置属性领款人名称
     * @param receiverFullName 待设置的属性领款人名称的值
     */
    public void setReceiverFullName(String receiverFullName){
        this.receiverFullName = StringUtils.rightTrim(receiverFullName);
    }

    /**
     * 获取属性领款人名称
     * @return 属性领款人名称的值
     */
    public String getReceiverFullName(){
        return receiverFullName;
    }
}
