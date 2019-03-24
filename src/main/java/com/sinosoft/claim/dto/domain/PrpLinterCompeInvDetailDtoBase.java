package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是大病医疗接口参数中间表子表计算书清单信息明细表的数据传输对象基类<br>
 */
public class PrpLinterCompeInvDetailDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性主键pk */
    private String id = "";
    /** 属性清单主表序号 */
    private int serialNo = 0;
    /** 属性清单明细序号 */
    private int detilSerialNo = 0;
    /** 属性被保险人名称 */
    private String name = "";
    /** 属性医保编号 */
    private String medicalCard = "";
    /** 属性身份证号码 */
    private String idCard = "";
    /** 属性发票金额 */
    private double sumInsured = 0D;
    /** 属性赔付金额 */
    private double settleSum = 0D;
    /** 属性户名 */
    private String medicalFamily = "";
    /** 属性开户行 */
    private String bank = "";
    /** 属性银行账户 */
    private String creditCard = "";

    /**
     *  默认构造方法,构造一个默认的PrpLinterCompeInvDetailDtoBase对象
     */
    public PrpLinterCompeInvDetailDtoBase(){
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
     * 设置属性清单主表序号
     * @param serialNo 待设置的属性清单主表序号的值
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性清单主表序号
     * @return 属性清单主表序号的值
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * 设置属性清单明细序号
     * @param detilSerialNo 待设置的属性清单明细序号的值
     */
    public void setDetilSerialNo(int detilSerialNo){
        this.detilSerialNo = detilSerialNo;
    }

    /**
     * 获取属性清单明细序号
     * @return 属性清单明细序号的值
     */
    public int getDetilSerialNo(){
        return detilSerialNo;
    }

    /**
     * 设置属性被保险人名称
     * @param name 待设置的属性被保险人名称的值
     */
    public void setName(String name){
        this.name = StringUtils.rightTrim(name);
    }

    /**
     * 获取属性被保险人名称
     * @return 属性被保险人名称的值
     */
    public String getName(){
        return name;
    }

    /**
     * 设置属性医保编号
     * @param medicalCard 待设置的属性医保编号的值
     */
    public void setMedicalCard(String medicalCard){
        this.medicalCard = StringUtils.rightTrim(medicalCard);
    }

    /**
     * 获取属性医保编号
     * @return 属性医保编号的值
     */
    public String getMedicalCard(){
        return medicalCard;
    }

    /**
     * 设置属性身份证号码
     * @param idCard 待设置的属性身份证号码的值
     */
    public void setIdCard(String idCard){
        this.idCard = StringUtils.rightTrim(idCard);
    }

    /**
     * 获取属性身份证号码
     * @return 属性身份证号码的值
     */
    public String getIdCard(){
        return idCard;
    }

    /**
     * 设置属性发票金额
     * @param sumInsured 待设置的属性发票金额的值
     */
    public void setSumInsured(double sumInsured){
        this.sumInsured = sumInsured;
    }

    /**
     * 获取属性发票金额
     * @return 属性发票金额的值
     */
    public double getSumInsured(){
        return sumInsured;
    }

    /**
     * 设置属性赔付金额
     * @param settleSum 待设置的属性赔付金额的值
     */
    public void setSettleSum(double settleSum){
        this.settleSum = settleSum;
    }

    /**
     * 获取属性赔付金额
     * @return 属性赔付金额的值
     */
    public double getSettleSum(){
        return settleSum;
    }

    /**
     * 设置属性户名
     * @param medicalFamily 待设置的属性户名的值
     */
    public void setMedicalFamily(String medicalFamily){
        this.medicalFamily = StringUtils.rightTrim(medicalFamily);
    }

    /**
     * 获取属性户名
     * @return 属性户名的值
     */
    public String getMedicalFamily(){
        return medicalFamily;
    }

    /**
     * 设置属性开户行
     * @param bank 待设置的属性开户行的值
     */
    public void setBank(String bank){
        this.bank = StringUtils.rightTrim(bank);
    }

    /**
     * 获取属性开户行
     * @return 属性开户行的值
     */
    public String getBank(){
        return bank;
    }

    /**
     * 设置属性银行账户
     * @param creditCard 待设置的属性银行账户的值
     */
    public void setCreditCard(String creditCard){
        this.creditCard = StringUtils.rightTrim(creditCard);
    }

    /**
     * 获取属性银行账户
     * @return 属性银行账户的值
     */
    public String getCreditCard(){
        return creditCard;
    }
}
