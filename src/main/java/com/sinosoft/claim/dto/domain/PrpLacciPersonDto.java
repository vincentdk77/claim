package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.ArrayList;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLacciPerson的数据传输对象类<br>
 * 创建于 JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class PrpLacciPersonDto extends PrpLacciPersonDtoBase implements Serializable{

    private static final long serialVersionUID = PrpLacciPersonDto.class.getName().hashCode();
    /**
     *  默认构造方法,构造一个默认的PrpLacciPersonDto对象
     */
    
    private String phone = "";
    private String address = "";
    private String relationCode = "";
    private String relationName= "";
    private ArrayList<PrpLacciPersonDto> prpLacciPersonList ; //索赔申请人
    private ArrayList<PrpLacciPersonDto> prpLacciBenPersonList ; //事故者信息
    private ArrayList<PrpLacciPersonDto> prpLagriPersonList ; //农险赔付被保险人信息
    
    /**大病医疗接口使用*/
    private double hisPaid = 0d;//历史赔付金额
    private double amountPaid = 0d;//赔付最大限额
    
    public PrpLacciPersonDto(){
    }
    
    

       public void setPhone(String phone){
        this.phone = StringUtils.rightTrim(phone);
    }

     public String getPhone(){
        return phone;
    }
  
    public void setAddress(String address){
        this.address = StringUtils.rightTrim(address);
    }

     public String getAddress(){
        return address;
    }
     
     public void setRelationCode(String relationCode){
        this.relationCode = StringUtils.rightTrim(relationCode);
    }

     public String getRelationCode(){
        return relationCode;
    }
     
     public void setRelationName(String relationName){
        this.relationName = StringUtils.rightTrim(relationName);
    }

     public String getRelationName(){
        return relationName;
    }    
     
     
     
	public double getHisPaid() {
		return hisPaid;
	}



	public void setHisPaid(double hisPaid) {
		this.hisPaid = hisPaid;
	}



	public ArrayList<PrpLacciPersonDto> getPrpLacciPersonList() {
		return prpLacciPersonList;
	}



	public void setPrpLacciPersonList(
			ArrayList<PrpLacciPersonDto> prpLacciPersonList) {
		this.prpLacciPersonList = prpLacciPersonList;
	}



	public ArrayList<PrpLacciPersonDto> getPrpLacciBenPersonList() {
		return prpLacciBenPersonList;
	}



	public void setPrpLacciBenPersonList(
			ArrayList<PrpLacciPersonDto> prpLacciBenPersonList) {
		this.prpLacciBenPersonList = prpLacciBenPersonList;
	}



	public ArrayList<PrpLacciPersonDto> getPrpLagriPersonList() {
		return prpLagriPersonList;
	}



	public void setPrpLagriPersonList(
			ArrayList<PrpLacciPersonDto> prpLagriPersonList) {
		this.prpLagriPersonList = prpLagriPersonList;
	}



	public double getAmountPaid() {
		return amountPaid;
	}



	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}
}
