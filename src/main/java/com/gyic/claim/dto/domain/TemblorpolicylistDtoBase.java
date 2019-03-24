package com.gyic.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����TEMBLORPOLICYLIST�����ݴ���������<br>
 */
public class TemblorpolicylistDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����INUSRELISTCODE */
    private String inusrelistcode = "";
    /** ����BUSINESSNO */
    private String businessno = "";
    /** ����KINDCODE */
    private String kindcode = "";
    /** ����ITEMCODE */
    private String itemcode = "";
    /** ����INDEXCODE */
    private String indexcode = "";
    /** ����COUNTRYCODE */
    private String countrycode = "";
    /** ����CITYCODE */
    private String citycode = "";
    /** ����ADDRESS */
    private String address = "";
    /** ����ZIPCODE */
    private String zipcode = "";
    /** ����LONGITUDE */
    private double longitude = 0D;
    /** ����LATITUDE */
    private double latitude = 0D;
    /** ����ITEMTYPE */
    private String itemtype = "";
    /** ����BUILDING */
    private String building = "";
    /** ����FLOOR */
    private int floor = 0;
    /** ����ARCHITECTURE */
    private String architecture = "";
    /** ����REMARK */
    private String remark = "";
    /** ����AREA */
    private double area = 0D;
    /** ����BUILDTIME */
    private String buildtime = "";
    /** ����REPAIR */
    private String repair = "";
    /** ����REPAIRTIME */
    private String repairtime = "";
    /** ����PROPCERTTYPE */
    private String propcerttype = "";
    /** ����PROPCERTNO */
    private String propcertno = "";
    /** ����CLASSCODE */
    private String classcode = "";
    /** ����RISKCODE */
    private String riskcode = "";
    /** ����AMOUNT */
    private double amount = 0D;
    /** ����RATE */
    private double rate = 0D;
    /** ����PREMIUM */
    private double premium = 0D;
    /** ����SHORTRATEFLAG */
    private String shortrateflag = "";
    /** ����SHORTRATE */
    private double shortrate = 0D;
    /** ����SUMAMOUNT */
    private double sumamount = 0D;
    /** ����SUMPREMIUM */
    private double sumpremium = 0D;
    /** ����STARTDATE */
    private DateTime startdate = new DateTime();
    /** ����ENDDATE */
    private DateTime enddate = new DateTime();
    /** ����STARTTIME */
    private String starttime = "";
    /** ����ENDTIME */
    private String endtime = "";
    /** ����CALCULATEFLAG */
    private String calculateflag = "";
    /** ����OPCODE */
    private String opcode = "";
    /** ����OPTIME */
    private DateTime optime = new DateTime();
    /** ����VALIDITY */
    private String validity = "";
    /** ����FPREMIUM */
    private double fpremium = 0D;
    /** ����CENTRALPREMIUM */
    private double centralpremium = 0D;
    /** ����PROVINCEPREMIUM */
    private double provincepremium = 0D;
    /** ����CITYPREMIUM */
    private double citypremium = 0D;
    /** ����TOWNPREMIUM */
    private double townpremium = 0D;
    /** ����OTHERPREMIUM */
    private double otherpremium = 0D;
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
    /** ����CARDTYPE */
    private String cardtype = "";
    /** ����IDCARD */
    private String idcard = "";
    /** ����NAME */
    private String name = "";
    /** ����RATEADJUST1 */
    private double rateadjust1 = 0D;
    /** ����RATEADJUST2 */
    private double rateadjust2 = 0D;

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�TemblorpolicylistDtoBase����
     */
    public TemblorpolicylistDtoBase(){
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
     * ��������KINDCODE
     * @param kindcode �����õ�����KINDCODE��ֵ
     */
    public void setKindcode(String kindcode){
        this.kindcode = StringUtils.rightTrim(kindcode);
    }

    /**
     * ��ȡ����KINDCODE
     * @return ����KINDCODE��ֵ
     */
    public String getKindcode(){
        return kindcode;
    }

    /**
     * ��������ITEMCODE
     * @param itemcode �����õ�����ITEMCODE��ֵ
     */
    public void setItemcode(String itemcode){
        this.itemcode = StringUtils.rightTrim(itemcode);
    }

    /**
     * ��ȡ����ITEMCODE
     * @return ����ITEMCODE��ֵ
     */
    public String getItemcode(){
        return itemcode;
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
     * ��������COUNTRYCODE
     * @param countrycode �����õ�����COUNTRYCODE��ֵ
     */
    public void setCountrycode(String countrycode){
        this.countrycode = StringUtils.rightTrim(countrycode);
    }

    /**
     * ��ȡ����COUNTRYCODE
     * @return ����COUNTRYCODE��ֵ
     */
    public String getCountrycode(){
        return countrycode;
    }

    /**
     * ��������CITYCODE
     * @param citycode �����õ�����CITYCODE��ֵ
     */
    public void setCitycode(String citycode){
        this.citycode = StringUtils.rightTrim(citycode);
    }

    /**
     * ��ȡ����CITYCODE
     * @return ����CITYCODE��ֵ
     */
    public String getCitycode(){
        return citycode;
    }

    /**
     * ��������ADDRESS
     * @param address �����õ�����ADDRESS��ֵ
     */
    public void setAddress(String address){
        this.address = StringUtils.rightTrim(address);
    }

    /**
     * ��ȡ����ADDRESS
     * @return ����ADDRESS��ֵ
     */
    public String getAddress(){
        return address;
    }

    /**
     * ��������ZIPCODE
     * @param zipcode �����õ�����ZIPCODE��ֵ
     */
    public void setZipcode(String zipcode){
        this.zipcode = StringUtils.rightTrim(zipcode);
    }

    /**
     * ��ȡ����ZIPCODE
     * @return ����ZIPCODE��ֵ
     */
    public String getZipcode(){
        return zipcode;
    }

    /**
     * ��������LONGITUDE
     * @param longitude �����õ�����LONGITUDE��ֵ
     */
    public void setLongitude(double longitude){
        this.longitude = longitude;
    }

    /**
     * ��ȡ����LONGITUDE
     * @return ����LONGITUDE��ֵ
     */
    public double getLongitude(){
        return longitude;
    }

    /**
     * ��������LATITUDE
     * @param latitude �����õ�����LATITUDE��ֵ
     */
    public void setLatitude(double latitude){
        this.latitude = latitude;
    }

    /**
     * ��ȡ����LATITUDE
     * @return ����LATITUDE��ֵ
     */
    public double getLatitude(){
        return latitude;
    }

    /**
     * ��������ITEMTYPE
     * @param itemtype �����õ�����ITEMTYPE��ֵ
     */
    public void setItemtype(String itemtype){
        this.itemtype = StringUtils.rightTrim(itemtype);
    }

    /**
     * ��ȡ����ITEMTYPE
     * @return ����ITEMTYPE��ֵ
     */
    public String getItemtype(){
        return itemtype;
    }

    /**
     * ��������BUILDING
     * @param building �����õ�����BUILDING��ֵ
     */
    public void setBuilding(String building){
        this.building = StringUtils.rightTrim(building);
    }

    /**
     * ��ȡ����BUILDING
     * @return ����BUILDING��ֵ
     */
    public String getBuilding(){
        return building;
    }

    /**
     * ��������FLOOR
     * @param floor �����õ�����FLOOR��ֵ
     */
    public void setFloor(int floor){
        this.floor = floor;
    }

    /**
     * ��ȡ����FLOOR
     * @return ����FLOOR��ֵ
     */
    public int getFloor(){
        return floor;
    }

    /**
     * ��������ARCHITECTURE
     * @param architecture �����õ�����ARCHITECTURE��ֵ
     */
    public void setArchitecture(String architecture){
        this.architecture = StringUtils.rightTrim(architecture);
    }

    /**
     * ��ȡ����ARCHITECTURE
     * @return ����ARCHITECTURE��ֵ
     */
    public String getArchitecture(){
        return architecture;
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
     * ��������AREA
     * @param area �����õ�����AREA��ֵ
     */
    public void setArea(double area){
        this.area = area;
    }

    /**
     * ��ȡ����AREA
     * @return ����AREA��ֵ
     */
    public double getArea(){
        return area;
    }

    /**
     * ��������BUILDTIME
     * @param buildtime �����õ�����BUILDTIME��ֵ
     */
    public void setBuildtime(String buildtime){
        this.buildtime = StringUtils.rightTrim(buildtime);
    }

    /**
     * ��ȡ����BUILDTIME
     * @return ����BUILDTIME��ֵ
     */
    public String getBuildtime(){
        return buildtime;
    }

    /**
     * ��������REPAIR
     * @param repair �����õ�����REPAIR��ֵ
     */
    public void setRepair(String repair){
        this.repair = StringUtils.rightTrim(repair);
    }

    /**
     * ��ȡ����REPAIR
     * @return ����REPAIR��ֵ
     */
    public String getRepair(){
        return repair;
    }

    /**
     * ��������REPAIRTIME
     * @param repairtime �����õ�����REPAIRTIME��ֵ
     */
    public void setRepairtime(String repairtime){
        this.repairtime = StringUtils.rightTrim(repairtime);
    }

    /**
     * ��ȡ����REPAIRTIME
     * @return ����REPAIRTIME��ֵ
     */
    public String getRepairtime(){
        return repairtime;
    }

    /**
     * ��������PROPCERTTYPE
     * @param propcerttype �����õ�����PROPCERTTYPE��ֵ
     */
    public void setPropcerttype(String propcerttype){
        this.propcerttype = StringUtils.rightTrim(propcerttype);
    }

    /**
     * ��ȡ����PROPCERTTYPE
     * @return ����PROPCERTTYPE��ֵ
     */
    public String getPropcerttype(){
        return propcerttype;
    }

    /**
     * ��������PROPCERTNO
     * @param propcertno �����õ�����PROPCERTNO��ֵ
     */
    public void setPropcertno(String propcertno){
        this.propcertno = StringUtils.rightTrim(propcertno);
    }

    /**
     * ��ȡ����PROPCERTNO
     * @return ����PROPCERTNO��ֵ
     */
    public String getPropcertno(){
        return propcertno;
    }

    /**
     * ��������CLASSCODE
     * @param classcode �����õ�����CLASSCODE��ֵ
     */
    public void setClasscode(String classcode){
        this.classcode = StringUtils.rightTrim(classcode);
    }

    /**
     * ��ȡ����CLASSCODE
     * @return ����CLASSCODE��ֵ
     */
    public String getClasscode(){
        return classcode;
    }

    /**
     * ��������RISKCODE
     * @param riskcode �����õ�����RISKCODE��ֵ
     */
    public void setRiskcode(String riskcode){
        this.riskcode = StringUtils.rightTrim(riskcode);
    }

    /**
     * ��ȡ����RISKCODE
     * @return ����RISKCODE��ֵ
     */
    public String getRiskcode(){
        return riskcode;
    }

    /**
     * ��������AMOUNT
     * @param amount �����õ�����AMOUNT��ֵ
     */
    public void setAmount(double amount){
        this.amount = amount;
    }

    /**
     * ��ȡ����AMOUNT
     * @return ����AMOUNT��ֵ
     */
    public double getAmount(){
        return amount;
    }

    /**
     * ��������RATE
     * @param rate �����õ�����RATE��ֵ
     */
    public void setRate(double rate){
        this.rate = rate;
    }

    /**
     * ��ȡ����RATE
     * @return ����RATE��ֵ
     */
    public double getRate(){
        return rate;
    }

    /**
     * ��������PREMIUM
     * @param premium �����õ�����PREMIUM��ֵ
     */
    public void setPremium(double premium){
        this.premium = premium;
    }

    /**
     * ��ȡ����PREMIUM
     * @return ����PREMIUM��ֵ
     */
    public double getPremium(){
        return premium;
    }

    /**
     * ��������SHORTRATEFLAG
     * @param shortrateflag �����õ�����SHORTRATEFLAG��ֵ
     */
    public void setShortrateflag(String shortrateflag){
        this.shortrateflag = StringUtils.rightTrim(shortrateflag);
    }

    /**
     * ��ȡ����SHORTRATEFLAG
     * @return ����SHORTRATEFLAG��ֵ
     */
    public String getShortrateflag(){
        return shortrateflag;
    }

    /**
     * ��������SHORTRATE
     * @param shortrate �����õ�����SHORTRATE��ֵ
     */
    public void setShortrate(double shortrate){
        this.shortrate = shortrate;
    }

    /**
     * ��ȡ����SHORTRATE
     * @return ����SHORTRATE��ֵ
     */
    public double getShortrate(){
        return shortrate;
    }

    /**
     * ��������SUMAMOUNT
     * @param sumamount �����õ�����SUMAMOUNT��ֵ
     */
    public void setSumamount(double sumamount){
        this.sumamount = sumamount;
    }

    /**
     * ��ȡ����SUMAMOUNT
     * @return ����SUMAMOUNT��ֵ
     */
    public double getSumamount(){
        return sumamount;
    }

    /**
     * ��������SUMPREMIUM
     * @param sumpremium �����õ�����SUMPREMIUM��ֵ
     */
    public void setSumpremium(double sumpremium){
        this.sumpremium = sumpremium;
    }

    /**
     * ��ȡ����SUMPREMIUM
     * @return ����SUMPREMIUM��ֵ
     */
    public double getSumpremium(){
        return sumpremium;
    }

    /**
     * ��������STARTDATE
     * @param startdate �����õ�����STARTDATE��ֵ
     */
    public void setStartdate(DateTime startdate){
        this.startdate = startdate;
    }

    /**
     * ��ȡ����STARTDATE
     * @return ����STARTDATE��ֵ
     */
    public DateTime getStartdate(){
        return startdate;
    }

    /**
     * ��������ENDDATE
     * @param enddate �����õ�����ENDDATE��ֵ
     */
    public void setEnddate(DateTime enddate){
        this.enddate = enddate;
    }

    /**
     * ��ȡ����ENDDATE
     * @return ����ENDDATE��ֵ
     */
    public DateTime getEnddate(){
        return enddate;
    }

    /**
     * ��������STARTTIME
     * @param starttime �����õ�����STARTTIME��ֵ
     */
    public void setStarttime(String starttime){
        this.starttime = StringUtils.rightTrim(starttime);
    }

    /**
     * ��ȡ����STARTTIME
     * @return ����STARTTIME��ֵ
     */
    public String getStarttime(){
        return starttime;
    }

    /**
     * ��������ENDTIME
     * @param endtime �����õ�����ENDTIME��ֵ
     */
    public void setEndtime(String endtime){
        this.endtime = StringUtils.rightTrim(endtime);
    }

    /**
     * ��ȡ����ENDTIME
     * @return ����ENDTIME��ֵ
     */
    public String getEndtime(){
        return endtime;
    }

    /**
     * ��������CALCULATEFLAG
     * @param calculateflag �����õ�����CALCULATEFLAG��ֵ
     */
    public void setCalculateflag(String calculateflag){
        this.calculateflag = StringUtils.rightTrim(calculateflag);
    }

    /**
     * ��ȡ����CALCULATEFLAG
     * @return ����CALCULATEFLAG��ֵ
     */
    public String getCalculateflag(){
        return calculateflag;
    }

    /**
     * ��������OPCODE
     * @param opcode �����õ�����OPCODE��ֵ
     */
    public void setOpcode(String opcode){
        this.opcode = StringUtils.rightTrim(opcode);
    }

    /**
     * ��ȡ����OPCODE
     * @return ����OPCODE��ֵ
     */
    public String getOpcode(){
        return opcode;
    }

    /**
     * ��������OPTIME
     * @param optime �����õ�����OPTIME��ֵ
     */
    public void setOptime(DateTime optime){
        this.optime = optime;
    }

    /**
     * ��ȡ����OPTIME
     * @return ����OPTIME��ֵ
     */
    public DateTime getOptime(){
        return optime;
    }

    /**
     * ��������VALIDITY
     * @param validity �����õ�����VALIDITY��ֵ
     */
    public void setValidity(String validity){
        this.validity = StringUtils.rightTrim(validity);
    }

    /**
     * ��ȡ����VALIDITY
     * @return ����VALIDITY��ֵ
     */
    public String getValidity(){
        return validity;
    }

    /**
     * ��������FPREMIUM
     * @param fpremium �����õ�����FPREMIUM��ֵ
     */
    public void setFpremium(double fpremium){
        this.fpremium = fpremium;
    }

    /**
     * ��ȡ����FPREMIUM
     * @return ����FPREMIUM��ֵ
     */
    public double getFpremium(){
        return fpremium;
    }

    /**
     * ��������CENTRALPREMIUM
     * @param centralpremium �����õ�����CENTRALPREMIUM��ֵ
     */
    public void setCentralpremium(double centralpremium){
        this.centralpremium = centralpremium;
    }

    /**
     * ��ȡ����CENTRALPREMIUM
     * @return ����CENTRALPREMIUM��ֵ
     */
    public double getCentralpremium(){
        return centralpremium;
    }

    /**
     * ��������PROVINCEPREMIUM
     * @param provincepremium �����õ�����PROVINCEPREMIUM��ֵ
     */
    public void setProvincepremium(double provincepremium){
        this.provincepremium = provincepremium;
    }

    /**
     * ��ȡ����PROVINCEPREMIUM
     * @return ����PROVINCEPREMIUM��ֵ
     */
    public double getProvincepremium(){
        return provincepremium;
    }

    /**
     * ��������CITYPREMIUM
     * @param citypremium �����õ�����CITYPREMIUM��ֵ
     */
    public void setCitypremium(double citypremium){
        this.citypremium = citypremium;
    }

    /**
     * ��ȡ����CITYPREMIUM
     * @return ����CITYPREMIUM��ֵ
     */
    public double getCitypremium(){
        return citypremium;
    }

    /**
     * ��������TOWNPREMIUM
     * @param townpremium �����õ�����TOWNPREMIUM��ֵ
     */
    public void setTownpremium(double townpremium){
        this.townpremium = townpremium;
    }

    /**
     * ��ȡ����TOWNPREMIUM
     * @return ����TOWNPREMIUM��ֵ
     */
    public double getTownpremium(){
        return townpremium;
    }

    /**
     * ��������OTHERPREMIUM
     * @param otherpremium �����õ�����OTHERPREMIUM��ֵ
     */
    public void setOtherpremium(double otherpremium){
        this.otherpremium = otherpremium;
    }

    /**
     * ��ȡ����OTHERPREMIUM
     * @return ����OTHERPREMIUM��ֵ
     */
    public double getOtherpremium(){
        return otherpremium;
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

    /**
     * ��������CARDTYPE
     * @param cardtype �����õ�����CARDTYPE��ֵ
     */
    public void setCardtype(String cardtype){
        this.cardtype = StringUtils.rightTrim(cardtype);
    }

    /**
     * ��ȡ����CARDTYPE
     * @return ����CARDTYPE��ֵ
     */
    public String getCardtype(){
        return cardtype;
    }

    /**
     * ��������IDCARD
     * @param idcard �����õ�����IDCARD��ֵ
     */
    public void setIdcard(String idcard){
        this.idcard = StringUtils.rightTrim(idcard);
    }

    /**
     * ��ȡ����IDCARD
     * @return ����IDCARD��ֵ
     */
    public String getIdcard(){
        return idcard;
    }

    /**
     * ��������NAME
     * @param name �����õ�����NAME��ֵ
     */
    public void setName(String name){
        this.name = StringUtils.rightTrim(name);
    }

    /**
     * ��ȡ����NAME
     * @return ����NAME��ֵ
     */
    public String getName(){
        return name;
    }

    /**
     * ��������RATEADJUST1
     * @param rateadjust1 �����õ�����RATEADJUST1��ֵ
     */
    public void setRateadjust1(double rateadjust1){
        this.rateadjust1 = rateadjust1;
    }

    /**
     * ��ȡ����RATEADJUST1
     * @return ����RATEADJUST1��ֵ
     */
    public double getRateadjust1(){
        return rateadjust1;
    }

    /**
     * ��������RATEADJUST2
     * @param rateadjust2 �����õ�����RATEADJUST2��ֵ
     */
    public void setRateadjust2(double rateadjust2){
        this.rateadjust2 = rateadjust2;
    }

    /**
     * ��ȡ����RATEADJUST2
     * @return ����RATEADJUST2��ֵ
     */
    public double getRateadjust2(){
        return rateadjust2;
    }
}
