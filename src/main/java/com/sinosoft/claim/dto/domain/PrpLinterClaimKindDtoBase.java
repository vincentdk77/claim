package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是立案估损金额信息的数据传输对象基类<br>
 */
public class PrpLinterClaimKindDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性主键 PK */
    private String id = "";
    /** 属性序号 PK */
    private int serialNo = 0;
    /** 属性事故者名称 */
    private String familyName = "";
    /** 属性标的序号 */
    private int itemKindNo = 0;
    /** 属性险别代码 */
    private String kindCode = "";
    /** 属性险别名称 */
    private String kindName = "";
    /** 属性币别代码 */
    private String currency = "";
    /** 属性预计给付金额 */
    private double sumClaim = 0D;
    /** 属性类别:p赔款z费用 */
    private String lossFeeType = "";
    /** 属性残值 */
    private double kindRest = 0D;

    /**
     *  默认构造方法,构造一个默认的PrpLinterClaimKindDtoBase对象
     */
    public PrpLinterClaimKindDtoBase(){
    }

    /**
     * 设置属性主键 PK
     * @param id 待设置的属性主键 PK的值
     */
    public void setId(String id){
        this.id = StringUtils.rightTrim(id);
    }

    /**
     * 获取属性主键 PK
     * @return 属性主键 PK的值
     */
    public String getId(){
        return id;
    }

    /**
     * 设置属性序号 PK
     * @param serialNo 待设置的属性序号 PK的值
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性序号 PK
     * @return 属性序号 PK的值
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * 设置属性事故者名称
     * @param familyName 待设置的属性事故者名称的值
     */
    public void setFamilyName(String familyName){
        this.familyName = StringUtils.rightTrim(familyName);
    }

    /**
     * 获取属性事故者名称
     * @return 属性事故者名称的值
     */
    public String getFamilyName(){
        return familyName;
    }

    /**
     * 设置属性标的序号
     * @param itemKindNo 待设置的属性标的序号的值
     */
    public void setItemKindNo(int itemKindNo){
        this.itemKindNo = itemKindNo;
    }

    /**
     * 获取属性标的序号
     * @return 属性标的序号的值
     */
    public int getItemKindNo(){
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
     * 设置属性预计给付金额
     * @param sumClaim 待设置的属性预计给付金额的值
     */
    public void setSumClaim(double sumClaim){
        this.sumClaim = sumClaim;
    }

    /**
     * 获取属性预计给付金额
     * @return 属性预计给付金额的值
     */
    public double getSumClaim(){
        return sumClaim;
    }

    /**
     * 设置属性类别:p赔款z费用
     * @param lossFeeType 待设置的属性类别:p赔款z费用的值
     */
    public void setLossFeeType(String lossFeeType){
        this.lossFeeType = StringUtils.rightTrim(lossFeeType);
    }

    /**
     * 获取属性类别:p赔款z费用
     * @return 属性类别:p赔款z费用的值
     */
    public String getLossFeeType(){
        return lossFeeType;
    }

    /**
     * 设置属性残值
     * @param kindRest 待设置的属性残值的值
     */
    public void setKindRest(double kindRest){
        this.kindRest = kindRest;
    }

    /**
     * 获取属性残值
     * @return 属性残值的值
     */
    public double getKindRest(){
        return kindRest;
    }
}
