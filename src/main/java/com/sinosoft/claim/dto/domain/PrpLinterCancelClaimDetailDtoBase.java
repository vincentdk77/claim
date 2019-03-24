package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是交互信息关联表的数据传输对象基类<br>
 */
public class PrpLinterCancelClaimDetailDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性主键id PK */
    private String id = "";
    /** 属性客户端数据主键 */
    private String outId = "";
    /** 属性保单号 */
    private String policyNo = "";
    /** 属性报案号 */
    private String registNo = "";
    /** 属性报案交互状态(1成功) */
    private String registSuccFlag = "";
    /** 属性注销交互状态(1成功) */
    private String cancelSuccFlag = "";
    /** 属性返回信息(成功/error) */
    private String remark = "";
    /** 属性立案注销申请交互状态(1成功) */
    private String claimCancelFlag = "";
    /** 属性立案注销审核交互状态(1成功) */
    private String cancelApprovFlag = "";

    /**
     *  默认构造方法,构造一个默认的PrpLinterCancelClaimDetailDtoBase对象
     */
    public PrpLinterCancelClaimDetailDtoBase(){
    }

    /**
     * 设置属性主键id PK
     * @param id 待设置的属性主键id PK的值
     */
    public void setId(String id){
        this.id = StringUtils.rightTrim(id);
    }

    /**
     * 获取属性主键id PK
     * @return 属性主键id PK的值
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
     * 设置属性报案号
     * @param registNo 待设置的属性报案号的值
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * 获取属性报案号
     * @return 属性报案号的值
     */
    public String getRegistNo(){
        return registNo;
    }

    /**
     * 设置属性报案交互状态(1成功)
     * @param registSuccFlag 待设置的属性报案交互状态(1成功)的值
     */
    public void setRegistSuccFlag(String registSuccFlag){
        this.registSuccFlag = StringUtils.rightTrim(registSuccFlag);
    }

    /**
     * 获取属性报案交互状态(1成功)
     * @return 属性报案交互状态(1成功)的值
     */
    public String getRegistSuccFlag(){
        return registSuccFlag;
    }

    /**
     * 设置属性注销交互状态(1成功)
     * @param cancelSuccFlag 待设置的属性注销交互状态(1成功)的值
     */
    public void setCancelSuccFlag(String cancelSuccFlag){
        this.cancelSuccFlag = StringUtils.rightTrim(cancelSuccFlag);
    }

    /**
     * 获取属性注销交互状态(1成功)
     * @return 属性注销交互状态(1成功)的值
     */
    public String getCancelSuccFlag(){
        return cancelSuccFlag;
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

	public String getClaimCancelFlag() {
		return claimCancelFlag;
	}

	public void setClaimCancelFlag(String claimCancelFlag) {
		this.claimCancelFlag = claimCancelFlag;
	}

	public String getCancelApprovFlag() {
		return cancelApprovFlag;
	}

	public void setCancelApprovFlag(String cancelApprovFlag) {
		this.cancelApprovFlag = cancelApprovFlag;
	}
}
