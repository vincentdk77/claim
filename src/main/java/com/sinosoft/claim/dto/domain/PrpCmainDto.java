package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.*;

/**
 * ����prpcmain����������Ϣ������ݴ��������<br>
 * ������ 2004-4-5 15:31:56<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpCmainDto extends PrpCmainDtoBase implements Serializable{
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpCmainDto����
     */
    public PrpCmainDto(){
    }
    /**���ƺ���  */
    private String licenseNo = "";
    /** ���Գ����ͺ� */
    private String brandName = "";
    /** ������� */
    private String payFlag = "";
    /** ��ʾ�ı�־����ǰ���ڳ����ձ����ڣ���������ʾΪ��ɫ��������δ��/�ѽ�δ��ȫҲ��ʾ��ɫ */
    private String colorFlag = ""; 
    
    private String damageDate = ""; 
    private String damageHour = ""; 
    private String businessType;
    private String businessType1;
    /**�б�����*/
    private int sumInsured;
    /** ����ר��ҵ������ ������ר��*/
    private String articleType = "";
    //��������ʡ
    private  String     businessProvince      ="";
    //����������
    private  String     businessTown          ="";
    //����������
    private  String     businessCounty        ="";
    //������������
    private  String     businessAreaName      ="";
    /**
     * ��ֳ�� �б�����
     */
    private double statQuantity;
    /**
     * ϵͳ��Դ
     */
    private String systemFlag;
    
	/**
     * �������Գ��ƺ���
     * @param licenseNo �����õ����Գ��ƺ����ֵ
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
     * ��ȡ���Գ��ƺ���
     * @return ���Գ��ƺ����ֵ
     */
    public String getLicenseNo(){
        return licenseNo;
    }
    
    
    /**
     * ��ȡ����ʱ��
     * @return ���Գ��ƺ����ֵ
     */
    public String getDamageDate(){
        return damageDate;
    }
    
     /**
     * ���ó���ʱ��
     * @param damageDate 
     */
    public void setDamageDate(String damageDate){
        this.damageDate = StringUtils.rightTrim(damageDate);
    }
    
     /**
     * ��ȡ����ʱ��
     * @return ���Գ��ƺ����ֵ
     */
    public String getDamageHour(){
        return damageHour;
    }
    
     /**
     * ���ó���ʱ��
     * @param damageHour
     */
    public void setDamageHour(String damageHour){
        this.damageHour = StringUtils.rightTrim(damageHour);
    }
    
    
    
    /**
     * �������Գ����ͺ�
     * @param brandName �����õ����Գ����ͺŵ�ֵ
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
     * ��ȡ���Գ����ͺ�
     * @return ���Գ����ͺŵ�ֵ
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
	 * ��ȡ����ר��ҵ������
	 * @return
	 */
	public String getArticleType() {
		return articleType;
	}

	/**
	 * ��������ר��ҵ������
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
	 * �������Գа�����
	 * @return
	 */
	public int getSumInsured() {
		return sumInsured;
	}

	/**
	 * �������Գа�����
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
