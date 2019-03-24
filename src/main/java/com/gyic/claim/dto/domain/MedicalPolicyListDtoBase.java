package com.gyic.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;


public class MedicalPolicyListDtoBase {

	private static final long serialVersionUID = 1L;
        private String InusreListCode;
        private String KindCode;
        private String IndexCode;
        private String Phone;
        private String Name;
        private String IdCard;
        private String Age;
        private double BscAmount;
        private double OptAmount;
        private double Rate;
        private String ShortRateFlag;
        private double ShortRate;
        private double SumAmount;
        private double SumPremium;
        private DateTime StartDate;
        private DateTime EndDate;
        private String CalculateFlag;
        private String OpCode;
        private DateTime OpTime;
        private String Validity;
        private String ReMark;
        //属性Flag
        private String Flag="";
        
        
        public MedicalPolicyListDtoBase() { 
    }
    
    public String getInusreListCode(){
        return StringUtils.rightTrim(InusreListCode);
    }



    public void setInusreListCode(String InusreListCode){
        this.InusreListCode = StringUtils.rightTrim(InusreListCode);
    }


    public String getKindCode(){
        return StringUtils.rightTrim(KindCode);
    }



    public void setKindCode(String KindCode){
        this.KindCode = StringUtils.rightTrim(KindCode);
    }


    public String getIndexCode(){
        return StringUtils.rightTrim(IndexCode);
    }



    public void setIndexCode(String IndexCode){
        this.IndexCode = StringUtils.rightTrim(IndexCode);
    }


    public String getPhone(){
        return StringUtils.rightTrim(Phone);
    }



    public void setPhone(String Phone){
        this.Phone = StringUtils.rightTrim(Phone);
    }


    public String getName(){
        return StringUtils.rightTrim(Name);
    }



    public void setName(String Name){
        this.Name = StringUtils.rightTrim(Name);
    }


    public String getIdCard(){
        return StringUtils.rightTrim(IdCard);
    }



    public void setIdCard(String IdCard){
        this.IdCard = StringUtils.rightTrim(IdCard);
    }


    public String getAge(){
        return StringUtils.rightTrim(Age);
    }



    public void setAge(String Age){
        this.Age = StringUtils.rightTrim(Age);
    }


    public double getBscAmount(){
        return BscAmount;
    }



    public void setBscAmount(double BscAmount){
        this.BscAmount = BscAmount;
    }


    public double getOptAmount(){
        return OptAmount;
    }



    public void setOptAmount(double OptAmount){
        this.OptAmount = OptAmount;
    }


    public double getRate(){
        return Rate;
    }



    public void setRate(double Rate){
        this.Rate = Rate;
    }


    public String getShortRateFlag(){
        return StringUtils.rightTrim(ShortRateFlag);
    }



    public void setShortRateFlag(String ShortRateFlag){
        this.ShortRateFlag = StringUtils.rightTrim(ShortRateFlag);
    }


    public double getShortRate(){
        return ShortRate;
    }



    public void setShortRate(double ShortRate){
        this.ShortRate = ShortRate;
    }


    public double getSumAmount(){
        return SumAmount;
    }



    public void setSumAmount(double SumAmount){
        this.SumAmount = SumAmount;
    }


    public double getSumPremium(){
        return SumPremium;
    }



    public void setSumPremium(double SumPremium){
        this.SumPremium = SumPremium;
    }


    public DateTime getStartDate(){
        return StartDate;
    }



    public void setStartDate(DateTime StartDate){
    	this.StartDate = StartDate;
      }


    public DateTime getEndDate(){
        return EndDate;
    }



    public void setEndDate(DateTime EndDate){
    	this.EndDate = EndDate;
      }

    public String getCalculateFlag(){
        return StringUtils.rightTrim(CalculateFlag);
    }



    public void setCalculateFlag(String CalculateFlag){
        this.CalculateFlag = StringUtils.rightTrim(CalculateFlag);
    }


    public String getOpCode(){
        return StringUtils.rightTrim(OpCode);
    }



    public void setOpCode(String OpCode){
        this.OpCode = StringUtils.rightTrim(OpCode);
    }


    public DateTime getOpTime(){
        return OpTime;
    }



    public void setOpTime(DateTime OpTime){
        this.OpTime = OpTime;
    }


    public String getValidity(){
        return StringUtils.rightTrim(Validity);
    }



    public void setValidity(String Validity){
        this.Validity = StringUtils.rightTrim(Validity);
    }


    public String getReMark(){
        return StringUtils.rightTrim(ReMark);
    }



    public void setReMark(String ReMark){
        this.ReMark = StringUtils.rightTrim(ReMark);
    }

    
	/**
     * 获取属性Flag
     * @return Flag
     */
	public String getFlag() {
		return Flag;
	}

	/**
     * 设置属性Flag
     * @param Flag Flag
     */
	public void setFlag(String flag) {
		this.Flag = flag;
	}
	

}

