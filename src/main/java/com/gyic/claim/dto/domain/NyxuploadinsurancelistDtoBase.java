package com.gyic.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是NYXUPLOADINSURANCELIST的数据传输对象基类<br>
 */
public class NyxuploadinsurancelistDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性INUSRELISTCODE */
    private String inusrelistcode = "";
    /** 属性BUSINESSNO */
    private String businessno = "";
    /** 属性FCODE */
    private String fcode = "";
    /** 属性PHONE */
    private String phone = "";
    /** 属性ZHIBUKA */
    private String zhibuka = "";
    /** 属性BREEDINGAREANAME */
    private String breedingareaname = "";
    /** 属性INSURENUMBER */
    private long insurenumber = 0L;
    /** 属性SPECIES */
    private String species = "";
    /** 属性BANK */
    private String bank = "";
    /** 属性BANKCARD */
    private String bankcard = "";
    /** 属性BREEDINGKIND */
    private String breedingkind = "";
    /** 属性FNAME */
    private String fname = "";
    /** 属性FLAG */
    private String flag = "";
    /** 属性TAXAREA */
    private double taxarea = 0D;
    /** 属性FIDCARD */
    private String fidcard = "";
    /** 属性INSUREAREA */
    private double insurearea = 0D;
    /** 属性REMARK */
    private String remark = "";
    /** 属性TEAMNAME */
    private String teamname = "";
    /** 属性FIELDSOURCE */
    private String fieldsource = "";
    /** 属性INDEXCODE */
    private String indexcode = "";
    /** 属性BREEDINGAREACODE */
    private String breedingareacode = "";
    /** 属性AREANUMBER */
    private double areanumber = 0D;
    /** 属性FLAG1 */
    private String flag1 = "";
    /** 属性OPERATEDATE */
    private DateTime operatedate = new DateTime();
    /** 属性ATAREA */
    private String atarea = "";
    /** 属性LITTLEAREANAME */
    private String littleareaname = "";
    /** 属性WARRANT */
    private String warrant = "";
    /** 属性LITTERAREA */
    private String litterarea = "";
    /** 属性MULCHDATE */
    private String mulchdate = "";
    /** 属性MULCHTYPE */
    private String mulchtype = "";
    /** 属性TEMP1 */
    private String temp1 = "";
    /** 属性TEMP2 */
    private String temp2 = "";
    /** 属性TEMP3 */
    private String temp3 = "";
    /** 属性TEMP4 */
    private String temp4 = "";
    /** 属性TEMP5 */
    private String temp5 = "";

    /**
     *  默认构造方法,构造一个默认的NyxuploadinsurancelistDtoBase对象
     */
    public NyxuploadinsurancelistDtoBase(){
    }

    /**
     * 设置属性INUSRELISTCODE
     * @param inusrelistcode 待设置的属性INUSRELISTCODE的值
     */
    public void setInusrelistcode(String inusrelistcode){
        this.inusrelistcode = StringUtils.rightTrim(inusrelistcode);
    }

    /**
     * 获取属性INUSRELISTCODE
     * @return 属性INUSRELISTCODE的值
     */
    public String getInusrelistcode(){
        return inusrelistcode;
    }

    /**
     * 设置属性BUSINESSNO
     * @param businessno 待设置的属性BUSINESSNO的值
     */
    public void setBusinessno(String businessno){
        this.businessno = StringUtils.rightTrim(businessno);
    }

    /**
     * 获取属性BUSINESSNO
     * @return 属性BUSINESSNO的值
     */
    public String getBusinessno(){
        return businessno;
    }

    /**
     * 设置属性FCODE
     * @param fcode 待设置的属性FCODE的值
     */
    public void setFcode(String fcode){
        this.fcode = StringUtils.rightTrim(fcode);
    }

    /**
     * 获取属性FCODE
     * @return 属性FCODE的值
     */
    public String getFcode(){
        return fcode;
    }

    /**
     * 设置属性PHONE
     * @param phone 待设置的属性PHONE的值
     */
    public void setPhone(String phone){
        this.phone = StringUtils.rightTrim(phone);
    }

    /**
     * 获取属性PHONE
     * @return 属性PHONE的值
     */
    public String getPhone(){
        return phone;
    }

    /**
     * 设置属性ZHIBUKA
     * @param zhibuka 待设置的属性ZHIBUKA的值
     */
    public void setZhibuka(String zhibuka){
        this.zhibuka = StringUtils.rightTrim(zhibuka);
    }

    /**
     * 获取属性ZHIBUKA
     * @return 属性ZHIBUKA的值
     */
    public String getZhibuka(){
        return zhibuka;
    }

    /**
     * 设置属性BREEDINGAREANAME
     * @param breedingareaname 待设置的属性BREEDINGAREANAME的值
     */
    public void setBreedingareaname(String breedingareaname){
        this.breedingareaname = StringUtils.rightTrim(breedingareaname);
    }

    /**
     * 获取属性BREEDINGAREANAME
     * @return 属性BREEDINGAREANAME的值
     */
    public String getBreedingareaname(){
        return breedingareaname;
    }

    /**
     * 设置属性INSURENUMBER
     * @param insurenumber 待设置的属性INSURENUMBER的值
     */
    public void setInsurenumber(long insurenumber){
        this.insurenumber = insurenumber;
    }

    /**
     * 获取属性INSURENUMBER
     * @return 属性INSURENUMBER的值
     */
    public long getInsurenumber(){
        return insurenumber;
    }

    /**
     * 设置属性SPECIES
     * @param species 待设置的属性SPECIES的值
     */
    public void setSpecies(String species){
        this.species = StringUtils.rightTrim(species);
    }

    /**
     * 获取属性SPECIES
     * @return 属性SPECIES的值
     */
    public String getSpecies(){
        return species;
    }

    /**
     * 设置属性BANK
     * @param bank 待设置的属性BANK的值
     */
    public void setBank(String bank){
        this.bank = StringUtils.rightTrim(bank);
    }

    /**
     * 获取属性BANK
     * @return 属性BANK的值
     */
    public String getBank(){
        return bank;
    }

    /**
     * 设置属性BANKCARD
     * @param bankcard 待设置的属性BANKCARD的值
     */
    public void setBankcard(String bankcard){
        this.bankcard = StringUtils.rightTrim(bankcard);
    }

    /**
     * 获取属性BANKCARD
     * @return 属性BANKCARD的值
     */
    public String getBankcard(){
        return bankcard;
    }

    /**
     * 设置属性BREEDINGKIND
     * @param breedingkind 待设置的属性BREEDINGKIND的值
     */
    public void setBreedingkind(String breedingkind){
        this.breedingkind = StringUtils.rightTrim(breedingkind);
    }

    /**
     * 获取属性BREEDINGKIND
     * @return 属性BREEDINGKIND的值
     */
    public String getBreedingkind(){
        return breedingkind;
    }

    /**
     * 设置属性FNAME
     * @param fname 待设置的属性FNAME的值
     */
    public void setFname(String fname){
        this.fname = StringUtils.rightTrim(fname);
    }

    /**
     * 获取属性FNAME
     * @return 属性FNAME的值
     */
    public String getFname(){
        return fname;
    }

    /**
     * 设置属性FLAG
     * @param flag 待设置的属性FLAG的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性FLAG
     * @return 属性FLAG的值
     */
    public String getFlag(){
        return flag;
    }

    /**
     * 设置属性TAXAREA
     * @param taxarea 待设置的属性TAXAREA的值
     */
    public void setTaxarea(double taxarea){
        this.taxarea = taxarea;
    }

    /**
     * 获取属性TAXAREA
     * @return 属性TAXAREA的值
     */
    public double getTaxarea(){
        return taxarea;
    }

    /**
     * 设置属性FIDCARD
     * @param fidcard 待设置的属性FIDCARD的值
     */
    public void setFidcard(String fidcard){
        this.fidcard = StringUtils.rightTrim(fidcard);
    }

    /**
     * 获取属性FIDCARD
     * @return 属性FIDCARD的值
     */
    public String getFidcard(){
        return fidcard;
    }

    /**
     * 设置属性INSUREAREA
     * @param insurearea 待设置的属性INSUREAREA的值
     */
    public void setInsurearea(double insurearea){
        this.insurearea = insurearea;
    }

    /**
     * 获取属性INSUREAREA
     * @return 属性INSUREAREA的值
     */
    public double getInsurearea(){
        return insurearea;
    }

    /**
     * 设置属性REMARK
     * @param remark 待设置的属性REMARK的值
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * 获取属性REMARK
     * @return 属性REMARK的值
     */
    public String getRemark(){
        return remark;
    }

    /**
     * 设置属性TEAMNAME
     * @param teamname 待设置的属性TEAMNAME的值
     */
    public void setTeamname(String teamname){
        this.teamname = StringUtils.rightTrim(teamname);
    }

    /**
     * 获取属性TEAMNAME
     * @return 属性TEAMNAME的值
     */
    public String getTeamname(){
        return teamname;
    }

    /**
     * 设置属性FIELDSOURCE
     * @param fieldsource 待设置的属性FIELDSOURCE的值
     */
    public void setFieldsource(String fieldsource){
        this.fieldsource = StringUtils.rightTrim(fieldsource);
    }

    /**
     * 获取属性FIELDSOURCE
     * @return 属性FIELDSOURCE的值
     */
    public String getFieldsource(){
        return fieldsource;
    }

    /**
     * 设置属性INDEXCODE
     * @param indexcode 待设置的属性INDEXCODE的值
     */
    public void setIndexcode(String indexcode){
        this.indexcode = StringUtils.rightTrim(indexcode);
    }

    /**
     * 获取属性INDEXCODE
     * @return 属性INDEXCODE的值
     */
    public String getIndexcode(){
        return indexcode;
    }

    /**
     * 设置属性BREEDINGAREACODE
     * @param breedingareacode 待设置的属性BREEDINGAREACODE的值
     */
    public void setBreedingareacode(String breedingareacode){
        this.breedingareacode = StringUtils.rightTrim(breedingareacode);
    }

    /**
     * 获取属性BREEDINGAREACODE
     * @return 属性BREEDINGAREACODE的值
     */
    public String getBreedingareacode(){
        return breedingareacode;
    }

    /**
     * 设置属性AREANUMBER
     * @param areanumber 待设置的属性AREANUMBER的值
     */
    public void setAreanumber(double areanumber){
        this.areanumber = areanumber;
    }

    /**
     * 获取属性AREANUMBER
     * @return 属性AREANUMBER的值
     */
    public double getAreanumber(){
        return areanumber;
    }

    /**
     * 设置属性FLAG1
     * @param flag1 待设置的属性FLAG1的值
     */
    public void setFlag1(String flag1){
        this.flag1 = StringUtils.rightTrim(flag1);
    }

    /**
     * 获取属性FLAG1
     * @return 属性FLAG1的值
     */
    public String getFlag1(){
        return flag1;
    }

    /**
     * 设置属性OPERATEDATE
     * @param operatedate 待设置的属性OPERATEDATE的值
     */
    public void setOperatedate(DateTime operatedate){
        this.operatedate = operatedate;
    }

    /**
     * 获取属性OPERATEDATE
     * @return 属性OPERATEDATE的值
     */
    public DateTime getOperatedate(){
        return operatedate;
    }

    /**
     * 设置属性ATAREA
     * @param atarea 待设置的属性ATAREA的值
     */
    public void setAtarea(String atarea){
        this.atarea = StringUtils.rightTrim(atarea);
    }

    /**
     * 获取属性ATAREA
     * @return 属性ATAREA的值
     */
    public String getAtarea(){
        return atarea;
    }

    /**
     * 设置属性LITTLEAREANAME
     * @param littleareaname 待设置的属性LITTLEAREANAME的值
     */
    public void setLittleareaname(String littleareaname){
        this.littleareaname = StringUtils.rightTrim(littleareaname);
    }

    /**
     * 获取属性LITTLEAREANAME
     * @return 属性LITTLEAREANAME的值
     */
    public String getLittleareaname(){
        return littleareaname;
    }

    /**
     * 设置属性WARRANT
     * @param warrant 待设置的属性WARRANT的值
     */
    public void setWarrant(String warrant){
        this.warrant = StringUtils.rightTrim(warrant);
    }

    /**
     * 获取属性WARRANT
     * @return 属性WARRANT的值
     */
    public String getWarrant(){
        return warrant;
    }

    /**
     * 设置属性LITTERAREA
     * @param litterarea 待设置的属性LITTERAREA的值
     */
    public void setLitterarea(String litterarea){
        this.litterarea = StringUtils.rightTrim(litterarea);
    }

    /**
     * 获取属性LITTERAREA
     * @return 属性LITTERAREA的值
     */
    public String getLitterarea(){
        return litterarea;
    }

    /**
     * 设置属性MULCHDATE
     * @param mulchdate 待设置的属性MULCHDATE的值
     */
    public void setMulchdate(String mulchdate){
        this.mulchdate = StringUtils.rightTrim(mulchdate);
    }

    /**
     * 获取属性MULCHDATE
     * @return 属性MULCHDATE的值
     */
    public String getMulchdate(){
        return mulchdate;
    }

    /**
     * 设置属性MULCHTYPE
     * @param mulchtype 待设置的属性MULCHTYPE的值
     */
    public void setMulchtype(String mulchtype){
        this.mulchtype = StringUtils.rightTrim(mulchtype);
    }

    /**
     * 获取属性MULCHTYPE
     * @return 属性MULCHTYPE的值
     */
    public String getMulchtype(){
        return mulchtype;
    }

    /**
     * 设置属性TEMP1
     * @param temp1 待设置的属性TEMP1的值
     */
    public void setTemp1(String temp1){
        this.temp1 = StringUtils.rightTrim(temp1);
    }

    /**
     * 获取属性TEMP1
     * @return 属性TEMP1的值
     */
    public String getTemp1(){
        return temp1;
    }

    /**
     * 设置属性TEMP2
     * @param temp2 待设置的属性TEMP2的值
     */
    public void setTemp2(String temp2){
        this.temp2 = StringUtils.rightTrim(temp2);
    }

    /**
     * 获取属性TEMP2
     * @return 属性TEMP2的值
     */
    public String getTemp2(){
        return temp2;
    }

    /**
     * 设置属性TEMP3
     * @param temp3 待设置的属性TEMP3的值
     */
    public void setTemp3(String temp3){
        this.temp3 = StringUtils.rightTrim(temp3);
    }

    /**
     * 获取属性TEMP3
     * @return 属性TEMP3的值
     */
    public String getTemp3(){
        return temp3;
    }

    /**
     * 设置属性TEMP4
     * @param temp4 待设置的属性TEMP4的值
     */
    public void setTemp4(String temp4){
        this.temp4 = StringUtils.rightTrim(temp4);
    }

    /**
     * 获取属性TEMP4
     * @return 属性TEMP4的值
     */
    public String getTemp4(){
        return temp4;
    }

    /**
     * 设置属性TEMP5
     * @param temp5 待设置的属性TEMP5的值
     */
    public void setTemp5(String temp5){
        this.temp5 = StringUtils.rightTrim(temp5);
    }

    /**
     * 获取属性TEMP5
     * @return 属性TEMP5的值
     */
    public String getTemp5(){
        return temp5;
    }
}
