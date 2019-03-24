package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.ArrayList;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLacciPerson�����ݴ��������<br>
 * ������ JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class PrpLacciPersonDto extends PrpLacciPersonDtoBase implements Serializable{

    private static final long serialVersionUID = PrpLacciPersonDto.class.getName().hashCode();
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLacciPersonDto����
     */
    
    private String phone = "";
    private String address = "";
    private String relationCode = "";
    private String relationName= "";
    private ArrayList<PrpLacciPersonDto> prpLacciPersonList ; //����������
    private ArrayList<PrpLacciPersonDto> prpLacciBenPersonList ; //�¹�����Ϣ
    private ArrayList<PrpLacciPersonDto> prpLagriPersonList ; //ũ���⸶����������Ϣ
    
    /**��ҽ�ƽӿ�ʹ��*/
    private double hisPaid = 0d;//��ʷ�⸶���
    private double amountPaid = 0d;//�⸶����޶�
    
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
