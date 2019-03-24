package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdagent代理人代码表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDagentDtoBase implements Serializable{
    /** 属性代理人代码 */
    private String agentCode = "";
    /** 属性代理人名称 */
    private String agentName = "";
    /** 属性代理人地址 */
    private String addressName = "";
    /** 属性邮政编码 */
    private String postCode = "";
    /** 属性代理人类型 */
    private String agentType = "";
    /** 属性许可证号 */
    private String permitNo = "";
    /** 属性联系人 */
    private String linkerName = "";
    /** 属性合同期 */
    private DateTime bargainDate = new DateTime();
    /** 属性电话 */
    private String phoneNumber = "";
    /** 属性传真 */
    private String faxNumber = "";
    /** 属性归属机构代码 */
    private String comCode = "";
    /** 属性上级代理人代码 */
    private String upperAgentCode = "";
    /** 属性新的代理人代码 */
    private String newAgentCode = "";
    /** 属性效力状态(0失效/1有效) */
    private String validStatus = "";
    /** 属性专项代码(对应会计科目) */
    private String articleCode = "";
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDagentDtoBase对象
     */
    public PrpDagentDtoBase(){
    }

    /**
     * 设置属性代理人代码
     * @param agentCode 待设置的属性代理人代码的值
     */
    public void setAgentCode(String agentCode){
        this.agentCode = StringUtils.rightTrim(agentCode);
    }

    /**
     * 获取属性代理人代码
     * @return 属性代理人代码的值
     */
    public String getAgentCode(){
        return agentCode;
    }

    /**
     * 设置属性代理人名称
     * @param agentName 待设置的属性代理人名称的值
     */
    public void setAgentName(String agentName){
        this.agentName = StringUtils.rightTrim(agentName);
    }

    /**
     * 获取属性代理人名称
     * @return 属性代理人名称的值
     */
    public String getAgentName(){
        return agentName;
    }

    /**
     * 设置属性代理人地址
     * @param addressName 待设置的属性代理人地址的值
     */
    public void setAddressName(String addressName){
        this.addressName = StringUtils.rightTrim(addressName);
    }

    /**
     * 获取属性代理人地址
     * @return 属性代理人地址的值
     */
    public String getAddressName(){
        return addressName;
    }

    /**
     * 设置属性邮政编码
     * @param postCode 待设置的属性邮政编码的值
     */
    public void setPostCode(String postCode){
        this.postCode = StringUtils.rightTrim(postCode);
    }

    /**
     * 获取属性邮政编码
     * @return 属性邮政编码的值
     */
    public String getPostCode(){
        return postCode;
    }

    /**
     * 设置属性代理人类型
     * @param agentType 待设置的属性代理人类型的值
     */
    public void setAgentType(String agentType){
        this.agentType = StringUtils.rightTrim(agentType);
    }

    /**
     * 获取属性代理人类型
     * @return 属性代理人类型的值
     */
    public String getAgentType(){
        return agentType;
    }

    /**
     * 设置属性许可证号
     * @param permitNo 待设置的属性许可证号的值
     */
    public void setPermitNo(String permitNo){
        this.permitNo = StringUtils.rightTrim(permitNo);
    }

    /**
     * 获取属性许可证号
     * @return 属性许可证号的值
     */
    public String getPermitNo(){
        return permitNo;
    }

    /**
     * 设置属性联系人
     * @param linkerName 待设置的属性联系人的值
     */
    public void setLinkerName(String linkerName){
        this.linkerName = StringUtils.rightTrim(linkerName);
    }

    /**
     * 获取属性联系人
     * @return 属性联系人的值
     */
    public String getLinkerName(){
        return linkerName;
    }

    /**
     * 设置属性合同期
     * @param bargainDate 待设置的属性合同期的值
     */
    public void setBargainDate(DateTime bargainDate){
        this.bargainDate = bargainDate;
    }

    /**
     * 获取属性合同期
     * @return 属性合同期的值
     */
    public DateTime getBargainDate(){
        return bargainDate;
    }

    /**
     * 设置属性电话
     * @param phoneNumber 待设置的属性电话的值
     */
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = StringUtils.rightTrim(phoneNumber);
    }

    /**
     * 获取属性电话
     * @return 属性电话的值
     */
    public String getPhoneNumber(){
        return phoneNumber;
    }

    /**
     * 设置属性传真
     * @param faxNumber 待设置的属性传真的值
     */
    public void setFaxNumber(String faxNumber){
        this.faxNumber = StringUtils.rightTrim(faxNumber);
    }

    /**
     * 获取属性传真
     * @return 属性传真的值
     */
    public String getFaxNumber(){
        return faxNumber;
    }

    /**
     * 设置属性归属机构代码
     * @param comCode 待设置的属性归属机构代码的值
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * 获取属性归属机构代码
     * @return 属性归属机构代码的值
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * 设置属性上级代理人代码
     * @param upperAgentCode 待设置的属性上级代理人代码的值
     */
    public void setUpperAgentCode(String upperAgentCode){
        this.upperAgentCode = StringUtils.rightTrim(upperAgentCode);
    }

    /**
     * 获取属性上级代理人代码
     * @return 属性上级代理人代码的值
     */
    public String getUpperAgentCode(){
        return upperAgentCode;
    }

    /**
     * 设置属性新的代理人代码
     * @param newAgentCode 待设置的属性新的代理人代码的值
     */
    public void setNewAgentCode(String newAgentCode){
        this.newAgentCode = StringUtils.rightTrim(newAgentCode);
    }

    /**
     * 获取属性新的代理人代码
     * @return 属性新的代理人代码的值
     */
    public String getNewAgentCode(){
        return newAgentCode;
    }

    /**
     * 设置属性效力状态(0失效/1有效)
     * @param validStatus 待设置的属性效力状态(0失效/1有效)的值
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * 获取属性效力状态(0失效/1有效)
     * @return 属性效力状态(0失效/1有效)的值
     */
    public String getValidStatus(){
        return validStatus;
    }

    /**
     * 设置属性专项代码(对应会计科目)
     * @param articleCode 待设置的属性专项代码(对应会计科目)的值
     */
    public void setArticleCode(String articleCode){
        this.articleCode = StringUtils.rightTrim(articleCode);
    }

    /**
     * 获取属性专项代码(对应会计科目)
     * @return 属性专项代码(对应会计科目)的值
     */
    public String getArticleCode(){
        return articleCode;
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
