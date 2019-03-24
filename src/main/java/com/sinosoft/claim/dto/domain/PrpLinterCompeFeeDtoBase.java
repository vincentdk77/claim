package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是计算书费用信息的数据传输对象基类<br>
 */
public class PrpLinterCompeFeeDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性主键pk */
    private String id = "";
    /** 属性主键序号pk */
    private int serialNo = 0;
    /** 属性标的序号 */
    private long itemKindNo = 0L;
    /** 属性险别代码 */
    private String kindCode = "";
    /** 属性险别名称 */
    private String kindName = "";
    /** 属性币别代码 */
    private String currency = "";
    /** 属性申请金额 */
    private double sumLoss = 0D;
    /** 属性自费金额 */
    private double sumRest = 0D;
    /** 属性免陪额 */
    private double deductible = 0D;
    /** 属性赔偿比例% */
    private double claimRete = 0D;
    /** 属性给付金额 */
    private double sumRealPay = 0D;
    /** 属性备注 */
    private String remark = "";

    /**
     *  默认构造方法,构造一个默认的PrpLinterCompeFeeDtoBase对象
     */
    public PrpLinterCompeFeeDtoBase(){
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
     * 设置属性主键序号pk
     * @param serialNo 待设置的属性主键序号pk的值
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性主键序号pk
     * @return 属性主键序号pk的值
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * 设置属性标的序号
     * @param itemKindNo 待设置的属性标的序号的值
     */
    public void setItemKindNo(long itemKindNo){
        this.itemKindNo = itemKindNo;
    }

    /**
     * 获取属性标的序号
     * @return 属性标的序号的值
     */
    public long getItemKindNo(){
        return itemKindNo;
    }

    /**
     * 设置属性险别代码
     * @param kindCode 待设置的属性险别代码的值
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

    /**
     * 设置属性险别名称
     * @param kindName 待设置的属性险别名称的值
     */
    public void setKindName(String kindName){
        this.kindName = StringUtils.rightTrim(kindName);
    }

    /**
     * 获取属性险别名称
     * @return 属性险别名称的值
     */
    public String getKindName(){
        return kindName;
    }

    /**
     * 设置属性币别代码
     * @param currency 待设置的属性币别代码的值
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * 获取属性币别代码
     * @return 属性币别代码的值
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * 设置属性申请金额
     * @param sumLoss 待设置的属性申请金额的值
     */
    public void setSumLoss(double sumLoss){
        this.sumLoss = sumLoss;
    }

    /**
     * 获取属性申请金额
     * @return 属性申请金额的值
     */
    public double getSumLoss(){
        return sumLoss;
    }

    /**
     * 设置属性自费金额
     * @param sumRest 待设置的属性自费金额的值
     */
    public void setSumRest(double sumRest){
        this.sumRest = sumRest;
    }

    /**
     * 获取属性自费金额
     * @return 属性自费金额的值
     */
    public double getSumRest(){
        return sumRest;
    }

    /**
     * 设置属性免陪额
     * @param deductible 待设置的属性免陪额的值
     */
    public void setDeductible(double deductible){
        this.deductible = deductible;
    }

    /**
     * 获取属性免陪额
     * @return 属性免陪额的值
     */
    public double getDeductible(){
        return deductible;
    }

    /**
     * 设置属性赔偿比例%
     * @param claimRete 待设置的属性赔偿比例%的值
     */
    public void setClaimRete(double claimRete){
        this.claimRete = claimRete;
    }

    /**
     * 获取属性赔偿比例%
     * @return 属性赔偿比例%的值
     */
    public double getClaimRete(){
        return claimRete;
    }

    /**
     * 设置属性给付金额
     * @param sumRealPay 待设置的属性给付金额的值
     */
    public void setSumRealPay(double sumRealPay){
        this.sumRealPay = sumRealPay;
    }

    /**
     * 获取属性给付金额
     * @return 属性给付金额的值
     */
    public double getSumRealPay(){
        return sumRealPay;
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
}
