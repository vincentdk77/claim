package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是大病医疗接口支付退回流程轨迹表的数据传输对象基类<br>
 */
public class PrplinterPayBackDetailDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性主键pk */
    private String id = "";
    /** 属性支付申请接口关联id */
    private String relationId = "";
    /** 属性客户端关联主键 */
    private String outId = "";
    /** 属性支付编号 */
    private String paymentNo = "";
    /** 属性退回人员代码 */
    private String operatorCode = "";
    /** 属性退回机构代码 */
    private String backComCode = "";
    /** 属性退回原因 */
    private String backReason = "";
    /** 属性中间表保存成功(1成功) */
    private String saveSuccFlag = "";
    /** 属性数据交互成功(1成功) */
    private String mutualSuccFlag = "";
    /** 属性输入时间 */
    private DateTime inputDate = new DateTime();
    /** 属性返回信息(成功/error) */
    private String remark = "";

    /**
     *  默认构造方法,构造一个默认的PrplinterPayBackDetailDtoBase对象
     */
    public PrplinterPayBackDetailDtoBase(){
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
     * 设置属性支付申请接口关联id
     * @param relationId 待设置的属性支付申请接口关联id的值
     */
    public void setRelationId(String relationId){
        this.relationId = StringUtils.rightTrim(relationId);
    }

    /**
     * 获取属性支付申请接口关联id
     * @return 属性支付申请接口关联id的值
     */
    public String getRelationId(){
        return relationId;
    }

    /**
     * 设置属性客户端关联主键
     * @param outId 待设置的属性客户端关联主键的值
     */
    public void setOutId(String outId){
        this.outId = StringUtils.rightTrim(outId);
    }

    /**
     * 获取属性客户端关联主键
     * @return 属性客户端关联主键的值
     */
    public String getOutId(){
        return outId;
    }

    /**
     * 设置属性支付编号
     * @param paymentNo 待设置的属性支付编号的值
     */
    public void setPaymentNo(String paymentNo){
        this.paymentNo = StringUtils.rightTrim(paymentNo);
    }

    /**
     * 获取属性支付编号
     * @return 属性支付编号的值
     */
    public String getPaymentNo(){
        return paymentNo;
    }

    /**
     * 设置属性退回人员代码
     * @param operatorCode 待设置的属性退回人员代码的值
     */
    public void setOperatorCode(String operatorCode){
        this.operatorCode = StringUtils.rightTrim(operatorCode);
    }

    /**
     * 获取属性退回人员代码
     * @return 属性退回人员代码的值
     */
    public String getOperatorCode(){
        return operatorCode;
    }

    /**
     * 设置属性退回机构代码
     * @param backComCode 待设置的属性退回机构代码的值
     */
    public void setBackComCode(String backComCode){
        this.backComCode = StringUtils.rightTrim(backComCode);
    }

    /**
     * 获取属性退回机构代码
     * @return 属性退回机构代码的值
     */
    public String getBackComCode(){
        return backComCode;
    }

    /**
     * 设置属性退回原因
     * @param backReason 待设置的属性退回原因的值
     */
    public void setBackReason(String backReason){
        this.backReason = StringUtils.rightTrim(backReason);
    }

    /**
     * 获取属性退回原因
     * @return 属性退回原因的值
     */
    public String getBackReason(){
        return backReason;
    }

    /**
     * 设置属性中间表保存成功(1成功)
     * @param saveSuccFlag 待设置的属性中间表保存成功(1成功)的值
     */
    public void setSaveSuccFlag(String saveSuccFlag){
        this.saveSuccFlag = StringUtils.rightTrim(saveSuccFlag);
    }

    /**
     * 获取属性中间表保存成功(1成功)
     * @return 属性中间表保存成功(1成功)的值
     */
    public String getSaveSuccFlag(){
        return saveSuccFlag;
    }

    /**
     * 设置属性数据交互成功(1成功)
     * @param mutualSuccFlag 待设置的属性数据交互成功(1成功)的值
     */
    public void setMutualSuccFlag(String mutualSuccFlag){
        this.mutualSuccFlag = StringUtils.rightTrim(mutualSuccFlag);
    }

    /**
     * 获取属性数据交互成功(1成功)
     * @return 属性数据交互成功(1成功)的值
     */
    public String getMutualSuccFlag(){
        return mutualSuccFlag;
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

    /**
     * 设置属性返回信息(成功/error)
     * @param remark 待设置的属性返回信息(成功/error)的值
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * 获取属性返回信息(成功/error)
     * @return 属性返回信息(成功/error)的值
     */
    public String getRemark(){
        return remark;
    }
}
