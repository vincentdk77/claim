package com.gyic.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����TEMBLORUPLOADINSURANCELIST�����ݴ���������<br>
 */
public class TembloruploadinsurancelistDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����INUSRELISTCODE */
    private String inusrelistcode = "";
    /** ����BUSINESSNO */
    private String businessno = "";
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
    /** ����AMOUNT */
    private double amount = 0D;
    /** ����RATEADJUST1 */
    private double rateadjust1 = 0D;
    /** ����RATEADJUST2 */
    private double rateadjust2 = 0D;
    /** ����RATE */
    private double rate = 0D;

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�TembloruploadinsurancelistDtoBase����
     */
    public TembloruploadinsurancelistDtoBase(){
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
}
