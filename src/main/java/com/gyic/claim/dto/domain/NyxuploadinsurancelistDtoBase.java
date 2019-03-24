package com.gyic.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����NYXUPLOADINSURANCELIST�����ݴ���������<br>
 */
public class NyxuploadinsurancelistDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����INUSRELISTCODE */
    private String inusrelistcode = "";
    /** ����BUSINESSNO */
    private String businessno = "";
    /** ����FCODE */
    private String fcode = "";
    /** ����PHONE */
    private String phone = "";
    /** ����ZHIBUKA */
    private String zhibuka = "";
    /** ����BREEDINGAREANAME */
    private String breedingareaname = "";
    /** ����INSURENUMBER */
    private long insurenumber = 0L;
    /** ����SPECIES */
    private String species = "";
    /** ����BANK */
    private String bank = "";
    /** ����BANKCARD */
    private String bankcard = "";
    /** ����BREEDINGKIND */
    private String breedingkind = "";
    /** ����FNAME */
    private String fname = "";
    /** ����FLAG */
    private String flag = "";
    /** ����TAXAREA */
    private double taxarea = 0D;
    /** ����FIDCARD */
    private String fidcard = "";
    /** ����INSUREAREA */
    private double insurearea = 0D;
    /** ����REMARK */
    private String remark = "";
    /** ����TEAMNAME */
    private String teamname = "";
    /** ����FIELDSOURCE */
    private String fieldsource = "";
    /** ����INDEXCODE */
    private String indexcode = "";
    /** ����BREEDINGAREACODE */
    private String breedingareacode = "";
    /** ����AREANUMBER */
    private double areanumber = 0D;
    /** ����FLAG1 */
    private String flag1 = "";
    /** ����OPERATEDATE */
    private DateTime operatedate = new DateTime();
    /** ����ATAREA */
    private String atarea = "";
    /** ����LITTLEAREANAME */
    private String littleareaname = "";
    /** ����WARRANT */
    private String warrant = "";
    /** ����LITTERAREA */
    private String litterarea = "";
    /** ����MULCHDATE */
    private String mulchdate = "";
    /** ����MULCHTYPE */
    private String mulchtype = "";
    /** ����TEMP1 */
    private String temp1 = "";
    /** ����TEMP2 */
    private String temp2 = "";
    /** ����TEMP3 */
    private String temp3 = "";
    /** ����TEMP4 */
    private String temp4 = "";
    /** ����TEMP5 */
    private String temp5 = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�NyxuploadinsurancelistDtoBase����
     */
    public NyxuploadinsurancelistDtoBase(){
    }

    /**
     * ��������INUSRELISTCODE
     * @param inusrelistcode �����õ�����INUSRELISTCODE��ֵ
     */
    public void setInusrelistcode(String inusrelistcode){
        this.inusrelistcode = StringUtils.rightTrim(inusrelistcode);
    }

    /**
     * ��ȡ����INUSRELISTCODE
     * @return ����INUSRELISTCODE��ֵ
     */
    public String getInusrelistcode(){
        return inusrelistcode;
    }

    /**
     * ��������BUSINESSNO
     * @param businessno �����õ�����BUSINESSNO��ֵ
     */
    public void setBusinessno(String businessno){
        this.businessno = StringUtils.rightTrim(businessno);
    }

    /**
     * ��ȡ����BUSINESSNO
     * @return ����BUSINESSNO��ֵ
     */
    public String getBusinessno(){
        return businessno;
    }

    /**
     * ��������FCODE
     * @param fcode �����õ�����FCODE��ֵ
     */
    public void setFcode(String fcode){
        this.fcode = StringUtils.rightTrim(fcode);
    }

    /**
     * ��ȡ����FCODE
     * @return ����FCODE��ֵ
     */
    public String getFcode(){
        return fcode;
    }

    /**
     * ��������PHONE
     * @param phone �����õ�����PHONE��ֵ
     */
    public void setPhone(String phone){
        this.phone = StringUtils.rightTrim(phone);
    }

    /**
     * ��ȡ����PHONE
     * @return ����PHONE��ֵ
     */
    public String getPhone(){
        return phone;
    }

    /**
     * ��������ZHIBUKA
     * @param zhibuka �����õ�����ZHIBUKA��ֵ
     */
    public void setZhibuka(String zhibuka){
        this.zhibuka = StringUtils.rightTrim(zhibuka);
    }

    /**
     * ��ȡ����ZHIBUKA
     * @return ����ZHIBUKA��ֵ
     */
    public String getZhibuka(){
        return zhibuka;
    }

    /**
     * ��������BREEDINGAREANAME
     * @param breedingareaname �����õ�����BREEDINGAREANAME��ֵ
     */
    public void setBreedingareaname(String breedingareaname){
        this.breedingareaname = StringUtils.rightTrim(breedingareaname);
    }

    /**
     * ��ȡ����BREEDINGAREANAME
     * @return ����BREEDINGAREANAME��ֵ
     */
    public String getBreedingareaname(){
        return breedingareaname;
    }

    /**
     * ��������INSURENUMBER
     * @param insurenumber �����õ�����INSURENUMBER��ֵ
     */
    public void setInsurenumber(long insurenumber){
        this.insurenumber = insurenumber;
    }

    /**
     * ��ȡ����INSURENUMBER
     * @return ����INSURENUMBER��ֵ
     */
    public long getInsurenumber(){
        return insurenumber;
    }

    /**
     * ��������SPECIES
     * @param species �����õ�����SPECIES��ֵ
     */
    public void setSpecies(String species){
        this.species = StringUtils.rightTrim(species);
    }

    /**
     * ��ȡ����SPECIES
     * @return ����SPECIES��ֵ
     */
    public String getSpecies(){
        return species;
    }

    /**
     * ��������BANK
     * @param bank �����õ�����BANK��ֵ
     */
    public void setBank(String bank){
        this.bank = StringUtils.rightTrim(bank);
    }

    /**
     * ��ȡ����BANK
     * @return ����BANK��ֵ
     */
    public String getBank(){
        return bank;
    }

    /**
     * ��������BANKCARD
     * @param bankcard �����õ�����BANKCARD��ֵ
     */
    public void setBankcard(String bankcard){
        this.bankcard = StringUtils.rightTrim(bankcard);
    }

    /**
     * ��ȡ����BANKCARD
     * @return ����BANKCARD��ֵ
     */
    public String getBankcard(){
        return bankcard;
    }

    /**
     * ��������BREEDINGKIND
     * @param breedingkind �����õ�����BREEDINGKIND��ֵ
     */
    public void setBreedingkind(String breedingkind){
        this.breedingkind = StringUtils.rightTrim(breedingkind);
    }

    /**
     * ��ȡ����BREEDINGKIND
     * @return ����BREEDINGKIND��ֵ
     */
    public String getBreedingkind(){
        return breedingkind;
    }

    /**
     * ��������FNAME
     * @param fname �����õ�����FNAME��ֵ
     */
    public void setFname(String fname){
        this.fname = StringUtils.rightTrim(fname);
    }

    /**
     * ��ȡ����FNAME
     * @return ����FNAME��ֵ
     */
    public String getFname(){
        return fname;
    }

    /**
     * ��������FLAG
     * @param flag �����õ�����FLAG��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ����FLAG
     * @return ����FLAG��ֵ
     */
    public String getFlag(){
        return flag;
    }

    /**
     * ��������TAXAREA
     * @param taxarea �����õ�����TAXAREA��ֵ
     */
    public void setTaxarea(double taxarea){
        this.taxarea = taxarea;
    }

    /**
     * ��ȡ����TAXAREA
     * @return ����TAXAREA��ֵ
     */
    public double getTaxarea(){
        return taxarea;
    }

    /**
     * ��������FIDCARD
     * @param fidcard �����õ�����FIDCARD��ֵ
     */
    public void setFidcard(String fidcard){
        this.fidcard = StringUtils.rightTrim(fidcard);
    }

    /**
     * ��ȡ����FIDCARD
     * @return ����FIDCARD��ֵ
     */
    public String getFidcard(){
        return fidcard;
    }

    /**
     * ��������INSUREAREA
     * @param insurearea �����õ�����INSUREAREA��ֵ
     */
    public void setInsurearea(double insurearea){
        this.insurearea = insurearea;
    }

    /**
     * ��ȡ����INSUREAREA
     * @return ����INSUREAREA��ֵ
     */
    public double getInsurearea(){
        return insurearea;
    }

    /**
     * ��������REMARK
     * @param remark �����õ�����REMARK��ֵ
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * ��ȡ����REMARK
     * @return ����REMARK��ֵ
     */
    public String getRemark(){
        return remark;
    }

    /**
     * ��������TEAMNAME
     * @param teamname �����õ�����TEAMNAME��ֵ
     */
    public void setTeamname(String teamname){
        this.teamname = StringUtils.rightTrim(teamname);
    }

    /**
     * ��ȡ����TEAMNAME
     * @return ����TEAMNAME��ֵ
     */
    public String getTeamname(){
        return teamname;
    }

    /**
     * ��������FIELDSOURCE
     * @param fieldsource �����õ�����FIELDSOURCE��ֵ
     */
    public void setFieldsource(String fieldsource){
        this.fieldsource = StringUtils.rightTrim(fieldsource);
    }

    /**
     * ��ȡ����FIELDSOURCE
     * @return ����FIELDSOURCE��ֵ
     */
    public String getFieldsource(){
        return fieldsource;
    }

    /**
     * ��������INDEXCODE
     * @param indexcode �����õ�����INDEXCODE��ֵ
     */
    public void setIndexcode(String indexcode){
        this.indexcode = StringUtils.rightTrim(indexcode);
    }

    /**
     * ��ȡ����INDEXCODE
     * @return ����INDEXCODE��ֵ
     */
    public String getIndexcode(){
        return indexcode;
    }

    /**
     * ��������BREEDINGAREACODE
     * @param breedingareacode �����õ�����BREEDINGAREACODE��ֵ
     */
    public void setBreedingareacode(String breedingareacode){
        this.breedingareacode = StringUtils.rightTrim(breedingareacode);
    }

    /**
     * ��ȡ����BREEDINGAREACODE
     * @return ����BREEDINGAREACODE��ֵ
     */
    public String getBreedingareacode(){
        return breedingareacode;
    }

    /**
     * ��������AREANUMBER
     * @param areanumber �����õ�����AREANUMBER��ֵ
     */
    public void setAreanumber(double areanumber){
        this.areanumber = areanumber;
    }

    /**
     * ��ȡ����AREANUMBER
     * @return ����AREANUMBER��ֵ
     */
    public double getAreanumber(){
        return areanumber;
    }

    /**
     * ��������FLAG1
     * @param flag1 �����õ�����FLAG1��ֵ
     */
    public void setFlag1(String flag1){
        this.flag1 = StringUtils.rightTrim(flag1);
    }

    /**
     * ��ȡ����FLAG1
     * @return ����FLAG1��ֵ
     */
    public String getFlag1(){
        return flag1;
    }

    /**
     * ��������OPERATEDATE
     * @param operatedate �����õ�����OPERATEDATE��ֵ
     */
    public void setOperatedate(DateTime operatedate){
        this.operatedate = operatedate;
    }

    /**
     * ��ȡ����OPERATEDATE
     * @return ����OPERATEDATE��ֵ
     */
    public DateTime getOperatedate(){
        return operatedate;
    }

    /**
     * ��������ATAREA
     * @param atarea �����õ�����ATAREA��ֵ
     */
    public void setAtarea(String atarea){
        this.atarea = StringUtils.rightTrim(atarea);
    }

    /**
     * ��ȡ����ATAREA
     * @return ����ATAREA��ֵ
     */
    public String getAtarea(){
        return atarea;
    }

    /**
     * ��������LITTLEAREANAME
     * @param littleareaname �����õ�����LITTLEAREANAME��ֵ
     */
    public void setLittleareaname(String littleareaname){
        this.littleareaname = StringUtils.rightTrim(littleareaname);
    }

    /**
     * ��ȡ����LITTLEAREANAME
     * @return ����LITTLEAREANAME��ֵ
     */
    public String getLittleareaname(){
        return littleareaname;
    }

    /**
     * ��������WARRANT
     * @param warrant �����õ�����WARRANT��ֵ
     */
    public void setWarrant(String warrant){
        this.warrant = StringUtils.rightTrim(warrant);
    }

    /**
     * ��ȡ����WARRANT
     * @return ����WARRANT��ֵ
     */
    public String getWarrant(){
        return warrant;
    }

    /**
     * ��������LITTERAREA
     * @param litterarea �����õ�����LITTERAREA��ֵ
     */
    public void setLitterarea(String litterarea){
        this.litterarea = StringUtils.rightTrim(litterarea);
    }

    /**
     * ��ȡ����LITTERAREA
     * @return ����LITTERAREA��ֵ
     */
    public String getLitterarea(){
        return litterarea;
    }

    /**
     * ��������MULCHDATE
     * @param mulchdate �����õ�����MULCHDATE��ֵ
     */
    public void setMulchdate(String mulchdate){
        this.mulchdate = StringUtils.rightTrim(mulchdate);
    }

    /**
     * ��ȡ����MULCHDATE
     * @return ����MULCHDATE��ֵ
     */
    public String getMulchdate(){
        return mulchdate;
    }

    /**
     * ��������MULCHTYPE
     * @param mulchtype �����õ�����MULCHTYPE��ֵ
     */
    public void setMulchtype(String mulchtype){
        this.mulchtype = StringUtils.rightTrim(mulchtype);
    }

    /**
     * ��ȡ����MULCHTYPE
     * @return ����MULCHTYPE��ֵ
     */
    public String getMulchtype(){
        return mulchtype;
    }

    /**
     * ��������TEMP1
     * @param temp1 �����õ�����TEMP1��ֵ
     */
    public void setTemp1(String temp1){
        this.temp1 = StringUtils.rightTrim(temp1);
    }

    /**
     * ��ȡ����TEMP1
     * @return ����TEMP1��ֵ
     */
    public String getTemp1(){
        return temp1;
    }

    /**
     * ��������TEMP2
     * @param temp2 �����õ�����TEMP2��ֵ
     */
    public void setTemp2(String temp2){
        this.temp2 = StringUtils.rightTrim(temp2);
    }

    /**
     * ��ȡ����TEMP2
     * @return ����TEMP2��ֵ
     */
    public String getTemp2(){
        return temp2;
    }

    /**
     * ��������TEMP3
     * @param temp3 �����õ�����TEMP3��ֵ
     */
    public void setTemp3(String temp3){
        this.temp3 = StringUtils.rightTrim(temp3);
    }

    /**
     * ��ȡ����TEMP3
     * @return ����TEMP3��ֵ
     */
    public String getTemp3(){
        return temp3;
    }

    /**
     * ��������TEMP4
     * @param temp4 �����õ�����TEMP4��ֵ
     */
    public void setTemp4(String temp4){
        this.temp4 = StringUtils.rightTrim(temp4);
    }

    /**
     * ��ȡ����TEMP4
     * @return ����TEMP4��ֵ
     */
    public String getTemp4(){
        return temp4;
    }

    /**
     * ��������TEMP5
     * @param temp5 �����õ�����TEMP5��ֵ
     */
    public void setTemp5(String temp5){
        this.temp5 = StringUtils.rightTrim(temp5);
    }

    /**
     * ��ȡ����TEMP5
     * @return ����TEMP5��ֵ
     */
    public String getTemp5(){
        return temp5;
    }
}
