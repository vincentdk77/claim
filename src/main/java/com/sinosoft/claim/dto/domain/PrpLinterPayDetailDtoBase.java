package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是交互信息关联表------轨迹表的数据传输对象基类<br>
 */
public class PrpLinterPayDetailDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性主键pk */
    private String id = "";
    /** 属性客户端数据主键 */
    private String outId = "";
    /** 属性收付编号 */
    private String paymentNo = "";
    /** 属性支付交互状态(1成功) */
    private String paySuccFlag = "";
    /** 属性双核审批交互状态(1成功) */
    private String vericSuccFlag = "";
    /** 属性支付状态 */
    private String thirdPayFlag = "";
    /** 属性输入时间 */
    private DateTime inputDate = new DateTime();

    /**
     *  默认构造方法,构造一个默认的PrpLinterPayDetailDtoBase对象
     */
    public PrpLinterPayDetailDtoBase(){
    }

    /**
     * 设置属性主键pk
     * @param id 待设置的属性主键pk的值
     */
    public void setId(String id){
        this.id = StringUtils.rightTrim(id);
    }

    /**
     * 获取属性主键pk
     * @return 属性主键pk的值
     */
    public String getId(){
        return id;
    }

    /**
     * 设置属性客户端数据主键
     * @param outId 待设置的属性客户端数据主键的值
     */
    public void setOutId(String outId){
        this.outId = StringUtils.rightTrim(outId);
    }

    /**
     * 获取属性客户端数据主键
     * @return 属性客户端数据主键的值
     */
    public String getOutId(){
        return outId;
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
     * 设置属性支付交互状态(1成功)
     * @param paySuccFlag 待设置的属性支付交互状态(1成功)的值
     */
    public void setPaySuccFlag(String paySuccFlag){
        this.paySuccFlag = StringUtils.rightTrim(paySuccFlag);
    }

    /**
     * 获取属性支付交互状态(1成功)
     * @return 属性支付交互状态(1成功)的值
     */
    public String getPaySuccFlag(){
        return paySuccFlag;
    }

    /**
     * 设置属性双核审批交互状态(1成功)
     * @param vericSuccFlag 待设置的属性双核审批交互状态(1成功)的值
     */
    public void setVericSuccFlag(String vericSuccFlag){
        this.vericSuccFlag = StringUtils.rightTrim(vericSuccFlag);
    }

    /**
     * 获取属性双核审批交互状态(1成功)
     * @return 属性双核审批交互状态(1成功)的值
     */
    public String getVericSuccFlag(){
        return vericSuccFlag;
    }

    /**
     * 设置属性输入时间
     * @param inputDate 待设置的属性输入时间的值
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * 获取属性输入时间
     * @return 属性输入时间的值
     */
    public DateTime getInputDate(){
        return inputDate;
    }
    
    public String getThirdPayFlag() {
		return thirdPayFlag;
	}

	public void setThirdPayFlag(String thirdPayFlag) {
		this.thirdPayFlag = thirdPayFlag;
	}
}
