package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.*;

/**
 * 这是prpcmain保单基本信息表的数据传输对象类<br>
 * 创建于 2004-4-5 15:31:56<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpCmainDto extends PrpCmainDtoBase implements Serializable{
    /**
     *  默认构造方法,构造一个默认的PrpCmainDto对象
     */
    public PrpCmainDto(){
    }
    /**号牌号码  */
    private String licenseNo = "";
    /** 属性厂牌型号 */
    private String brandName = "";
    /** 交费情况 */
    private String payFlag = "";
    /** 显示的标志，当前日期超过终保日期，此行字显示为红色，若保费未缴/已缴未缴全也显示红色 */
    private String colorFlag = ""; 
    
    private String damageDate = ""; 
    private String damageHour = ""; 
    private String businessType;
    private String businessType1;
    /**承保户次*/
    private int sumInsured;
    /** 属性专项业务类型 健康险专用*/
    private String articleType = "";
    //归属区域省
    private  String     businessProvince      ="";
    //归属区域市
    private  String     businessTown          ="";
    //归属区域县
    private  String     businessCounty        ="";
    //归属区域乡镇
    private  String     businessAreaName      ="";
    /**
     * 养殖险 承保数量
     */
    private double statQuantity;
    /**
     * 系统来源
     */
    private String systemFlag;
    
	/**
     * 设置属性车牌号码
     * @param licenseNo 待设置的属性车牌号码的值
     */
    public void setLicenseNo(String licenseNo){
        this.licenseNo = StringUtils.rightTrim(licenseNo);
    }

    public String getSystemFlag() {
		return systemFlag;
	}

	public void setSystemFlag(String systemFlag) {
		this.systemFlag = systemFlag;
	}

	/**
     * 获取属性车牌号码
     * @return 属性车牌号码的值
     */
    public String getLicenseNo(){
        return licenseNo;
    }
    
    
    /**
     * 获取出险时间
     * @return 属性车牌号码的值
     */
    public String getDamageDate(){
        return damageDate;
    }
    
     /**
     * 设置出险时间
     * @param damageDate 
     */
    public void setDamageDate(String damageDate){
        this.damageDate = StringUtils.rightTrim(damageDate);
    }
    
     /**
     * 获取出险时间
     * @return 属性车牌号码的值
     */
    public String getDamageHour(){
        return damageHour;
    }
    
     /**
     * 设置出险时间
     * @param damageHour
     */
    public void setDamageHour(String damageHour){
        this.damageHour = StringUtils.rightTrim(damageHour);
    }
    
    
    
    /**
     * 设置属性厂牌型号
     * @param brandName 待设置的属性厂牌型号的值
     */
    public void setBrandName(String brandName){
        this.brandName = StringUtils.rightTrim(brandName);
    }

    public void setColorFlag(String colorFlag) {
      this.colorFlag = colorFlag;
    }

    public void setPayFlag(String payFlag) {
      this.payFlag = payFlag;
    }

  /**
     * 获取属性厂牌型号
     * @return 属性厂牌型号的值
     */
    public String getBrandName(){
        return brandName;
    }

    public String getColorFlag() {
      return colorFlag;
    }

    public String getPayFlag() {
      return payFlag;
    }

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getBusinessType1() {
		return businessType1;
	}

	public void setBusinessType1(String businessType1) {
		this.businessType1 = businessType1;
	}
	/**
	 * 获取属性专项业务类型
	 * @return
	 */
	public String getArticleType() {
		return articleType;
	}

	/**
	 * 设置属性专项业务类型
	 * @param articleType
	 */
	public void setArticleType(String articleType) {
		this.articleType = articleType;
	}
	public double getStatQuantity() {
		return statQuantity;
	}

	public void setStatQuantity(double statQuantity) {
		this.statQuantity = statQuantity;
	}

	/**
	 * 设置属性承包户次
	 * @return
	 */
	public int getSumInsured() {
		return sumInsured;
	}

	/**
	 * 设置属性承包户次
	 * @return
	 */
	public void setSumInsured(int sumInsured) {
		this.sumInsured = sumInsured;
	}

	public String getBusinessProvince() {
		return businessProvince;
	}

	public void setBusinessProvince(String businessProvince) {
		this.businessProvince = businessProvince;
	}

	public String getBusinessTown() {
		return businessTown;
	}

	public void setBusinessTown(String businessTown) {
		this.businessTown = businessTown;
	}

	public String getBusinessCounty() {
		return businessCounty;
	}

	public void setBusinessCounty(String businessCounty) {
		this.businessCounty = businessCounty;
	}

	public String getBusinessAreaName() {
		return businessAreaName;
	}

	public void setBusinessAreaName(String businessAreaName) {
		this.businessAreaName = businessAreaName;
	}
	
	
}
