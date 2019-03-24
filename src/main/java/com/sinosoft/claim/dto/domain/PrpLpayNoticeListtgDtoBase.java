package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是通知单关联表的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLpayNoticeListtgDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性通知单号 */
    private String noticeNo = "";
    /** 属性收付编号 */
    private String paymentNo = "";

    /**
     *  默认构造方法,构造一个默认的PrpLpayNoticeListtgDtoBase对象
     */
    public PrpLpayNoticeListtgDtoBase(){
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
}
