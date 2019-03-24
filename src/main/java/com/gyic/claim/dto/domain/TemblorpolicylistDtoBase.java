package com.gyic.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是TEMBLORPOLICYLIST的数据传输对象基类<br>
 */
public class TemblorpolicylistDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性INUSRELISTCODE */
    private String inusrelistcode = "";
    /** 属性BUSINESSNO */
    private String businessno = "";
    /** 属性KINDCODE */
    private String kindcode = "";
    /** 属性ITEMCODE */
    private String itemcode = "";
    /** 属性INDEXCODE */
    private String indexcode = "";
    /** 属性COUNTRYCODE */
    private String countrycode = "";
    /** 属性CITYCODE */
    private String citycode = "";
    /** 属性ADDRESS */
    private String address = "";
    /** 属性ZIPCODE */
    private String zipcode = "";
    /** 属性LONGITUDE */
    private double longitude = 0D;
    /** 属性LATITUDE */
    private double latitude = 0D;
    /** 属性ITEMTYPE */
    private String itemtype = "";
    /** 属性BUILDING */
    private String building = "";
    /** 属性FLOOR */
    private int floor = 0;
    /** 属性ARCHITECTURE */
    private String architecture = "";
    /** 属性REMARK */
    private String remark = "";
    /** 属性AREA */
    private double area = 0D;
    /** 属性BUILDTIME */
    private String buildtime = "";
    /** 属性REPAIR */
    private String repair = "";
    /** 属性REPAIRTIME */
    private String repairtime = "";
    /** 属性PROPCERTTYPE */
    private String propcerttype = "";
    /** 属性PROPCERTNO */
    private String propcertno = "";
    /** 属性CLASSCODE */
    private String classcode = "";
    /** 属性RISKCODE */
    private String riskcode = "";
    /** 属性AMOUNT */
    private double amount = 0D;
    /** 属性RATE */
    private double rate = 0D;
    /** 属性PREMIUM */
    private double premium = 0D;
    /** 属性SHORTRATEFLAG */
    private String shortrateflag = "";
    /** 属性SHORTRATE */
    private double shortrate = 0D;
    /** 属性SUMAMOUNT */
    private double sumamount = 0D;
    /** 属性SUMPREMIUM */
    private double sumpremium = 0D;
    /** 属性STARTDATE */
    private DateTime startdate = new DateTime();
    /** 属性ENDDATE */
    private DateTime enddate = new DateTime();
    /** 属性STARTTIME */
    private String starttime = "";
    /** 属性ENDTIME */
    private String endtime = "";
    /** 属性CALCULATEFLAG */
    private String calculateflag = "";
    /** 属性OPCODE */
    private String opcode = "";
    /** 属性OPTIME */
    private DateTime optime = new DateTime();
    /** 属性VALIDITY */
    private String validity = "";
    /** 属性FPREMIUM */
    private double fpremium = 0D;
    /** 属性CENTRALPREMIUM */
    private double centralpremium = 0D;
    /** 属性PROVINCEPREMIUM */
    private double provincepremium = 0D;
    /** 属性CITYPREMIUM */
    private double citypremium = 0D;
    /** 属性TOWNPREMIUM */
    private double townpremium = 0D;
    /** 属性OTHERPREMIUM */
    private double otherpremium = 0D;
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
    /** 属性CARDTYPE */
    private String cardtype = "";
    /** 属性IDCARD */
    private String idcard = "";
    /** 属性NAME */
    private String name = "";
    /** 属性RATEADJUST1 */
    private double rateadjust1 = 0D;
    /** 属性RATEADJUST2 */
    private double rateadjust2 = 0D;

    /**
     *  默认构造方法,构造一个默认的TemblorpolicylistDtoBase对象
     */
    public TemblorpolicylistDtoBase(){
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
     * 设置属性KINDCODE
     * @param kindcode 待设置的属性KINDCODE的值
     */
    public void setKindcode(String kindcode){
        this.kindcode = StringUtils.rightTrim(kindcode);
    }

    /**
     * 获取属性KINDCODE
     * @return 属性KINDCODE的值
     */
    public String getKindcode(){
        return kindcode;
    }

    /**
     * 设置属性ITEMCODE
     * @param itemcode 待设置的属性ITEMCODE的值
     */
    public void setItemcode(String itemcode){
        this.itemcode = StringUtils.rightTrim(itemcode);
    }

    /**
     * 获取属性ITEMCODE
     * @return 属性ITEMCODE的值
     */
    public String getItemcode(){
        return itemcode;
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
     * 设置属性COUNTRYCODE
     * @param countrycode 待设置的属性COUNTRYCODE的值
     */
    public void setCountrycode(String countrycode){
        this.countrycode = StringUtils.rightTrim(countrycode);
    }

    /**
     * 获取属性COUNTRYCODE
     * @return 属性COUNTRYCODE的值
     */
    public String getCountrycode(){
        return countrycode;
    }

    /**
     * 设置属性CITYCODE
     * @param citycode 待设置的属性CITYCODE的值
     */
    public void setCitycode(String citycode){
        this.citycode = StringUtils.rightTrim(citycode);
    }

    /**
     * 获取属性CITYCODE
     * @return 属性CITYCODE的值
     */
    public String getCitycode(){
        return citycode;
    }

    /**
     * 设置属性ADDRESS
     * @param address 待设置的属性ADDRESS的值
     */
    public void setAddress(String address){
        this.address = StringUtils.rightTrim(address);
    }

    /**
     * 获取属性ADDRESS
     * @return 属性ADDRESS的值
     */
    public String getAddress(){
        return address;
    }

    /**
     * 设置属性ZIPCODE
     * @param zipcode 待设置的属性ZIPCODE的值
     */
    public void setZipcode(String zipcode){
        this.zipcode = StringUtils.rightTrim(zipcode);
    }

    /**
     * 获取属性ZIPCODE
     * @return 属性ZIPCODE的值
     */
    public String getZipcode(){
        return zipcode;
    }

    /**
     * 设置属性LONGITUDE
     * @param longitude 待设置的属性LONGITUDE的值
     */
    public void setLongitude(double longitude){
        this.longitude = longitude;
    }

    /**
     * 获取属性LONGITUDE
     * @return 属性LONGITUDE的值
     */
    public double getLongitude(){
        return longitude;
    }

    /**
     * 设置属性LATITUDE
     * @param latitude 待设置的属性LATITUDE的值
     */
    public void setLatitude(double latitude){
        this.latitude = latitude;
    }

    /**
     * 获取属性LATITUDE
     * @return 属性LATITUDE的值
     */
    public double getLatitude(){
        return latitude;
    }

    /**
     * 设置属性ITEMTYPE
     * @param itemtype 待设置的属性ITEMTYPE的值
     */
    public void setItemtype(String itemtype){
        this.itemtype = StringUtils.rightTrim(itemtype);
    }

    /**
     * 获取属性ITEMTYPE
     * @return 属性ITEMTYPE的值
     */
    public String getItemtype(){
        return itemtype;
    }

    /**
     * 设置属性BUILDING
     * @param building 待设置的属性BUILDING的值
     */
    public void setBuilding(String building){
        this.building = StringUtils.rightTrim(building);
    }

    /**
     * 获取属性BUILDING
     * @return 属性BUILDING的值
     */
    public String getBuilding(){
        return building;
    }

    /**
     * 设置属性FLOOR
     * @param floor 待设置的属性FLOOR的值
     */
    public void setFloor(int floor){
        this.floor = floor;
    }

    /**
     * 获取属性FLOOR
     * @return 属性FLOOR的值
     */
    public int getFloor(){
        return floor;
    }

    /**
     * 设置属性ARCHITECTURE
     * @param architecture 待设置的属性ARCHITECTURE的值
     */
    public void setArchitecture(String architecture){
        this.architecture = StringUtils.rightTrim(architecture);
    }

    /**
     * 获取属性ARCHITECTURE
     * @return 属性ARCHITECTURE的值
     */
    public String getArchitecture(){
        return architecture;
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
     * 设置属性AREA
     * @param area 待设置的属性AREA的值
     */
    public void setArea(double area){
        this.area = area;
    }

    /**
     * 获取属性AREA
     * @return 属性AREA的值
     */
    public double getArea(){
        return area;
    }

    /**
     * 设置属性BUILDTIME
     * @param buildtime 待设置的属性BUILDTIME的值
     */
    public void setBuildtime(String buildtime){
        this.buildtime = StringUtils.rightTrim(buildtime);
    }

    /**
     * 获取属性BUILDTIME
     * @return 属性BUILDTIME的值
     */
    public String getBuildtime(){
        return buildtime;
    }

    /**
     * 设置属性REPAIR
     * @param repair 待设置的属性REPAIR的值
     */
    public void setRepair(String repair){
        this.repair = StringUtils.rightTrim(repair);
    }

    /**
     * 获取属性REPAIR
     * @return 属性REPAIR的值
     */
    public String getRepair(){
        return repair;
    }

    /**
     * 设置属性REPAIRTIME
     * @param repairtime 待设置的属性REPAIRTIME的值
     */
    public void setRepairtime(String repairtime){
        this.repairtime = StringUtils.rightTrim(repairtime);
    }

    /**
     * 获取属性REPAIRTIME
     * @return 属性REPAIRTIME的值
     */
    public String getRepairtime(){
        return repairtime;
    }

    /**
     * 设置属性PROPCERTTYPE
     * @param propcerttype 待设置的属性PROPCERTTYPE的值
     */
    public void setPropcerttype(String propcerttype){
        this.propcerttype = StringUtils.rightTrim(propcerttype);
    }

    /**
     * 获取属性PROPCERTTYPE
     * @return 属性PROPCERTTYPE的值
     */
    public String getPropcerttype(){
        return propcerttype;
    }

    /**
     * 设置属性PROPCERTNO
     * @param propcertno 待设置的属性PROPCERTNO的值
     */
    public void setPropcertno(String propcertno){
        this.propcertno = StringUtils.rightTrim(propcertno);
    }

    /**
     * 获取属性PROPCERTNO
     * @return 属性PROPCERTNO的值
     */
    public String getPropcertno(){
        return propcertno;
    }

    /**
     * 设置属性CLASSCODE
     * @param classcode 待设置的属性CLASSCODE的值
     */
    public void setClasscode(String classcode){
        this.classcode = StringUtils.rightTrim(classcode);
    }

    /**
     * 获取属性CLASSCODE
     * @return 属性CLASSCODE的值
     */
    public String getClasscode(){
        return classcode;
    }

    /**
     * 设置属性RISKCODE
     * @param riskcode 待设置的属性RISKCODE的值
     */
    public void setRiskcode(String riskcode){
        this.riskcode = StringUtils.rightTrim(riskcode);
    }

    /**
     * 获取属性RISKCODE
     * @return 属性RISKCODE的值
     */
    public String getRiskcode(){
        return riskcode;
    }

    /**
     * 设置属性AMOUNT
     * @param amount 待设置的属性AMOUNT的值
     */
    public void setAmount(double amount){
        this.amount = amount;
    }

    /**
     * 获取属性AMOUNT
     * @return 属性AMOUNT的值
     */
    public double getAmount(){
        return amount;
    }

    /**
     * 设置属性RATE
     * @param rate 待设置的属性RATE的值
     */
    public void setRate(double rate){
        this.rate = rate;
    }

    /**
     * 获取属性RATE
     * @return 属性RATE的值
     */
    public double getRate(){
        return rate;
    }

    /**
     * 设置属性PREMIUM
     * @param premium 待设置的属性PREMIUM的值
     */
    public void setPremium(double premium){
        this.premium = premium;
    }

    /**
     * 获取属性PREMIUM
     * @return 属性PREMIUM的值
     */
    public double getPremium(){
        return premium;
    }

    /**
     * 设置属性SHORTRATEFLAG
     * @param shortrateflag 待设置的属性SHORTRATEFLAG的值
     */
    public void setShortrateflag(String shortrateflag){
        this.shortrateflag = StringUtils.rightTrim(shortrateflag);
    }

    /**
     * 获取属性SHORTRATEFLAG
     * @return 属性SHORTRATEFLAG的值
     */
    public String getShortrateflag(){
        return shortrateflag;
    }

    /**
     * 设置属性SHORTRATE
     * @param shortrate 待设置的属性SHORTRATE的值
     */
    public void setShortrate(double shortrate){
        this.shortrate = shortrate;
    }

    /**
     * 获取属性SHORTRATE
     * @return 属性SHORTRATE的值
     */
    public double getShortrate(){
        return shortrate;
    }

    /**
     * 设置属性SUMAMOUNT
     * @param sumamount 待设置的属性SUMAMOUNT的值
     */
    public void setSumamount(double sumamount){
        this.sumamount = sumamount;
    }

    /**
     * 获取属性SUMAMOUNT
     * @return 属性SUMAMOUNT的值
     */
    public double getSumamount(){
        return sumamount;
    }

    /**
     * 设置属性SUMPREMIUM
     * @param sumpremium 待设置的属性SUMPREMIUM的值
     */
    public void setSumpremium(double sumpremium){
        this.sumpremium = sumpremium;
    }

    /**
     * 获取属性SUMPREMIUM
     * @return 属性SUMPREMIUM的值
     */
    public double getSumpremium(){
        return sumpremium;
    }

    /**
     * 设置属性STARTDATE
     * @param startdate 待设置的属性STARTDATE的值
     */
    public void setStartdate(DateTime startdate){
        this.startdate = startdate;
    }

    /**
     * 获取属性STARTDATE
     * @return 属性STARTDATE的值
     */
    public DateTime getStartdate(){
        return startdate;
    }

    /**
     * 设置属性ENDDATE
     * @param enddate 待设置的属性ENDDATE的值
     */
    public void setEnddate(DateTime enddate){
        this.enddate = enddate;
    }

    /**
     * 获取属性ENDDATE
     * @return 属性ENDDATE的值
     */
    public DateTime getEnddate(){
        return enddate;
    }

    /**
     * 设置属性STARTTIME
     * @param starttime 待设置的属性STARTTIME的值
     */
    public void setStarttime(String starttime){
        this.starttime = StringUtils.rightTrim(starttime);
    }

    /**
     * 获取属性STARTTIME
     * @return 属性STARTTIME的值
     */
    public String getStarttime(){
        return starttime;
    }

    /**
     * 设置属性ENDTIME
     * @param endtime 待设置的属性ENDTIME的值
     */
    public void setEndtime(String endtime){
        this.endtime = StringUtils.rightTrim(endtime);
    }

    /**
     * 获取属性ENDTIME
     * @return 属性ENDTIME的值
     */
    public String getEndtime(){
        return endtime;
    }

    /**
     * 设置属性CALCULATEFLAG
     * @param calculateflag 待设置的属性CALCULATEFLAG的值
     */
    public void setCalculateflag(String calculateflag){
        this.calculateflag = StringUtils.rightTrim(calculateflag);
    }

    /**
     * 获取属性CALCULATEFLAG
     * @return 属性CALCULATEFLAG的值
     */
    public String getCalculateflag(){
        return calculateflag;
    }

    /**
     * 设置属性OPCODE
     * @param opcode 待设置的属性OPCODE的值
     */
    public void setOpcode(String opcode){
        this.opcode = StringUtils.rightTrim(opcode);
    }

    /**
     * 获取属性OPCODE
     * @return 属性OPCODE的值
     */
    public String getOpcode(){
        return opcode;
    }

    /**
     * 设置属性OPTIME
     * @param optime 待设置的属性OPTIME的值
     */
    public void setOptime(DateTime optime){
        this.optime = optime;
    }

    /**
     * 获取属性OPTIME
     * @return 属性OPTIME的值
     */
    public DateTime getOptime(){
        return optime;
    }

    /**
     * 设置属性VALIDITY
     * @param validity 待设置的属性VALIDITY的值
     */
    public void setValidity(String validity){
        this.validity = StringUtils.rightTrim(validity);
    }

    /**
     * 获取属性VALIDITY
     * @return 属性VALIDITY的值
     */
    public String getValidity(){
        return validity;
    }

    /**
     * 设置属性FPREMIUM
     * @param fpremium 待设置的属性FPREMIUM的值
     */
    public void setFpremium(double fpremium){
        this.fpremium = fpremium;
    }

    /**
     * 获取属性FPREMIUM
     * @return 属性FPREMIUM的值
     */
    public double getFpremium(){
        return fpremium;
    }

    /**
     * 设置属性CENTRALPREMIUM
     * @param centralpremium 待设置的属性CENTRALPREMIUM的值
     */
    public void setCentralpremium(double centralpremium){
        this.centralpremium = centralpremium;
    }

    /**
     * 获取属性CENTRALPREMIUM
     * @return 属性CENTRALPREMIUM的值
     */
    public double getCentralpremium(){
        return centralpremium;
    }

    /**
     * 设置属性PROVINCEPREMIUM
     * @param provincepremium 待设置的属性PROVINCEPREMIUM的值
     */
    public void setProvincepremium(double provincepremium){
        this.provincepremium = provincepremium;
    }

    /**
     * 获取属性PROVINCEPREMIUM
     * @return 属性PROVINCEPREMIUM的值
     */
    public double getProvincepremium(){
        return provincepremium;
    }

    /**
     * 设置属性CITYPREMIUM
     * @param citypremium 待设置的属性CITYPREMIUM的值
     */
    public void setCitypremium(double citypremium){
        this.citypremium = citypremium;
    }

    /**
     * 获取属性CITYPREMIUM
     * @return 属性CITYPREMIUM的值
     */
    public double getCitypremium(){
        return citypremium;
    }

    /**
     * 设置属性TOWNPREMIUM
     * @param townpremium 待设置的属性TOWNPREMIUM的值
     */
    public void setTownpremium(double townpremium){
        this.townpremium = townpremium;
    }

    /**
     * 获取属性TOWNPREMIUM
     * @return 属性TOWNPREMIUM的值
     */
    public double getTownpremium(){
        return townpremium;
    }

    /**
     * 设置属性OTHERPREMIUM
     * @param otherpremium 待设置的属性OTHERPREMIUM的值
     */
    public void setOtherpremium(double otherpremium){
        this.otherpremium = otherpremium;
    }

    /**
     * 获取属性OTHERPREMIUM
     * @return 属性OTHERPREMIUM的值
     */
    public double getOtherpremium(){
        return otherpremium;
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

    /**
     * 设置属性CARDTYPE
     * @param cardtype 待设置的属性CARDTYPE的值
     */
    public void setCardtype(String cardtype){
        this.cardtype = StringUtils.rightTrim(cardtype);
    }

    /**
     * 获取属性CARDTYPE
     * @return 属性CARDTYPE的值
     */
    public String getCardtype(){
        return cardtype;
    }

    /**
     * 设置属性IDCARD
     * @param idcard 待设置的属性IDCARD的值
     */
    public void setIdcard(String idcard){
        this.idcard = StringUtils.rightTrim(idcard);
    }

    /**
     * 获取属性IDCARD
     * @return 属性IDCARD的值
     */
    public String getIdcard(){
        return idcard;
    }

    /**
     * 设置属性NAME
     * @param name 待设置的属性NAME的值
     */
    public void setName(String name){
        this.name = StringUtils.rightTrim(name);
    }

    /**
     * 获取属性NAME
     * @return 属性NAME的值
     */
    public String getName(){
        return name;
    }

    /**
     * 设置属性RATEADJUST1
     * @param rateadjust1 待设置的属性RATEADJUST1的值
     */
    public void setRateadjust1(double rateadjust1){
        this.rateadjust1 = rateadjust1;
    }

    /**
     * 获取属性RATEADJUST1
     * @return 属性RATEADJUST1的值
     */
    public double getRateadjust1(){
        return rateadjust1;
    }

    /**
     * 设置属性RATEADJUST2
     * @param rateadjust2 待设置的属性RATEADJUST2的值
     */
    public void setRateadjust2(double rateadjust2){
        this.rateadjust2 = rateadjust2;
    }

    /**
     * 获取属性RATEADJUST2
     * @return 属性RATEADJUST2的值
     */
    public double getRateadjust2(){
        return rateadjust2;
    }
}
