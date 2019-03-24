package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLthirdCarLoss-损失部位(新增)的数据传输对象基类<br>
 * 创建于 2005-03-18 17:53:35.718<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLthirdCarLossDtoBase implements Serializable{
    /** 属性报案号码 */
    private String registNo = "";
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性序号 */
    private int serialNo = 0;
    /** 属性损失项目序号 */
    private int itemNo = 0;
    /** 属性车牌号 */
    private String licenseNo = "";
    /** 属性零件(项目)代码 */
    private String compCode = "";
    /** 属性零件(项目)名称 */
    private String compName = "";
    /** 属性损失程度级别 */
    private String lossGrade = "";
    /** 属性损失程度描述 */
    private String lossDesc = "";
    /** 属性标志字段 */
    private String flag = "";

     /** 属性损失部件代码 */
    private String partCode = "";
    /** 属性损失部件名称 */
    private String partName = "";

    /** 属性险别代码 */
    private String kindCode = "";

    /**
     *  默认构造方法,构造一个默认的PrpLthirdCarLossDtoBase对象
     */
    public PrpLthirdCarLossDtoBase(){
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
     * 设置属性险种代码
     * @param riskCode 待设置的属性险种代码的值
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * 获取属性险种代码
     * @return 属性险种代码的值
     */
    public String getRiskCode(){
        return riskCode;
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
     * 设置属性损失项目序号
     * @param itemNo 待设置的属性损失项目序号的值
     */
    public void setItemNo(int itemNo){
        this.itemNo = itemNo;
    }

    /**
     * 获取属性损失项目序号
     * @return 属性损失项目序号的值
     */
    public int getItemNo(){
        return itemNo;
    }

    /**
     * 设置属性车牌号
     * @param licenseNo 待设置的属性车牌号的值
     */
    public void setLicenseNo(String licenseNo){
        this.licenseNo = StringUtils.rightTrim(licenseNo);
    }

    /**
     * 获取属性车牌号
     * @return 属性车牌号的值
     */
    public String getLicenseNo(){
        return licenseNo;
    }

     /**
     * 设置属性零件(项目)代码
     * @param compCode 待设置的属性零件(项目)代码的值
     */
    public void setCompCode(String compCode){
        this.compCode = StringUtils.rightTrim(compCode);
    }

    /**
     * 获取属性零件(项目)代码
     * @return 属性零件(项目)代码的值
     */
    public String getCompCode(){
        return compCode;
    }

    /**
     * 设置属性零件(项目)名称
     * @param compName 待设置的属性零件(项目)名称的值
     */
    public void setCompName(String compName){
        this.compName = StringUtils.rightTrim(compName);
    }

    /**
     * 获取属性零件(项目)名称
     * @return 属性零件(项目)名称的值
     */
    public String getCompName(){
        return compName;
    }

    /**
     * 设置属性损失程度级别
     * @param lossGrade 待设置的属性损失程度级别的值
     */
    public void setLossGrade(String lossGrade){
        this.lossGrade = StringUtils.rightTrim(lossGrade);
    }

    /**
     * 获取属性损失程度级别
     * @return 属性损失程度级别的值
     */
    public String getLossGrade(){
        return lossGrade;
    }

    /**
     * 设置属性损失程度描述
     * @param lossDesc 待设置的属性损失程度描述的值
     */
    public void setLossDesc(String lossDesc){
        this.lossDesc = StringUtils.rightTrim(lossDesc);
    }

    /**
     * 获取属性损失程度描述
     * @return 属性损失程度描述的值
     */
    public String getLossDesc(){
        return lossDesc;
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

     /**
     * 设置属性损失部件代码
     * @param partCode 待设置的属性损失部件代码的值
     */
    public void setPartCode(String partCode){
        this.partCode = StringUtils.rightTrim(partCode);
    }

    /**
     * 获取属性损失部件代码
     * @return 属性损失部件代码的值
     */
    public String getPartCode(){
        return partCode;
    }

    /**
     * 设置属性损失部件名称
     * @param partName 待设置的属性损失部件名称的值
     */
    public void setPartName(String partName){
        this.partName = StringUtils.rightTrim(partName);
    }

    /**
     * 获取属性损失部件名称
     * @return 属性损失部件名称的值
     */
    public String getPartName(){
        return partName;
    }

    /**
    * 设置属性险别代码
    * @param partCode 待设置的属性险别代码的值
    */
   public void setKindCode(String kindCode){
       this.kindCode = StringUtils.rightTrim(kindCode);
   }

   /**
    * 获取属性险别代码
    * @return 属性险别代码的值
    */
   public String getKindCode(){
       return kindCode;
   }

}
