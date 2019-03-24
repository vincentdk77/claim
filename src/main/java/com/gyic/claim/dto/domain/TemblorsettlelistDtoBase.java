package com.gyic.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是TEMBLORSETTLELIST的数据传输对象基类<br>
 */
public class TemblorsettlelistDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性SETTLELISTCODE */
    private String settlelistcode = "";
    /** 属性INDEXOFSETTLE */
    private int indexofsettle = 0;
    /** 属性KINDCODE */
    private String kindcode = "";
    /** 属性ITEMCODE */
    private String itemcode = "";
    /** 属性CLASSCODE */
    private String classcode = "";
    /** 属性RISKCODE */
    private String riskcode = "";
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
    /** 属性INUSRELISTCODE */
    private String inusrelistcode = "";
    /** 属性LOSSRATE */
    private double lossrate = 0D;
    /** 属性OPCODE */
    private String opcode = "";
    /** 属性OPTIME */
    private DateTime optime = new DateTime();
    /** 属性VALIDITY */
    private String validity = "";
    /** 属性SETTLEDATE */
    private DateTime settledate = new DateTime();
    /** 属性CLAIMRATE */
    private double claimrate = 0D;
    /** 属性NODETYPE */
    private String nodetype = "";
    /** 属性DAMAGELEVEL */
    private String damagelevel = "";
    /** 属性LOSSAMOUNT */
    private double lossamount = 0D;
    /** 属性SETTLESUM */
    private double settlesum = 0D;
    /** 属性PREPAY */
    private double prepay = 0D;
    /** 属性SUPPLYPREPAY */
    private double supplyprepay = 0D;
    /** 属性CARDTYPE */
    private String cardtype = "";
    /** 属性IDCARD */
    private String idcard = "";
    /** 属性NAME */
    private String name = "";
    
    /** 属性SUMINSURED */
    private double suminsured = 0D;

    /**
     *  默认构造方法,构造一个默认的TemblorsettlelistDtoBase对象
     */
    public TemblorsettlelistDtoBase(){
    }

    /**
     * 设置属性SETTLELISTCODE
     * @param settlelistcode 待设置的属性SETTLELISTCODE的值
     */
    public void setSettlelistcode(String settlelistcode){
        this.settlelistcode = StringUtils.rightTrim(settlelistcode);
    }

    /**
     * 获取属性SETTLELISTCODE
     * @return 属性SETTLELISTCODE的值
     */
    public String getSettlelistcode(){
        return settlelistcode;
    }

    /**
     * 设置属性INDEXOFSETTLE
     * @param indexofsettle 待设置的属性INDEXOFSETTLE的值
     */
    public void setIndexofsettle(int indexofsettle){
        this.indexofsettle = indexofsettle;
    }

    /**
     * 获取属性INDEXOFSETTLE
     * @return 属性INDEXOFSETTLE的值
     */
    public int getIndexofsettle(){
        return indexofsettle;
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
     * 设置属性LOSSRATE
     * @param lossrate 待设置的属性LOSSRATE的值
     */
    public void setLossrate(double lossrate){
        this.lossrate = lossrate;
    }

    /**
     * 获取属性LOSSRATE
     * @return 属性LOSSRATE的值
     */
    public double getLossrate(){
        return lossrate;
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
     * 设置属性SETTLEDATE
     * @param settledate 待设置的属性SETTLEDATE的值
     */
    public void setSettledate(DateTime settledate){
        this.settledate = settledate;
    }

    /**
     * 获取属性SETTLEDATE
     * @return 属性SETTLEDATE的值
     */
    public DateTime getSettledate(){
        return settledate;
    }

    /**
     * 设置属性CLAIMRATE
     * @param claimrate 待设置的属性CLAIMRATE的值
     */
    public void setClaimrate(double claimrate){
        this.claimrate = claimrate;
    }

    /**
     * 获取属性CLAIMRATE
     * @return 属性CLAIMRATE的值
     */
    public double getClaimrate(){
        return claimrate;
    }

    /**
     * 设置属性NODETYPE
     * @param nodetype 待设置的属性NODETYPE的值
     */
    public void setNodetype(String nodetype){
        this.nodetype = StringUtils.rightTrim(nodetype);
    }

    /**
     * 获取属性NODETYPE
     * @return 属性NODETYPE的值
     */
    public String getNodetype(){
        return nodetype;
    }

    /**
     * 设置属性DAMAGELEVEL
     * @param damagelevel 待设置的属性DAMAGELEVEL的值
     */
    public void setDamagelevel(String damagelevel){
        this.damagelevel = StringUtils.rightTrim(damagelevel);
    }

    /**
     * 获取属性DAMAGELEVEL
     * @return 属性DAMAGELEVEL的值
     */
    public String getDamagelevel(){
        return damagelevel;
    }

    /**
     * 设置属性LOSSAMOUNT
     * @param lossamount 待设置的属性LOSSAMOUNT的值
     */
    public void setLossamount(double lossamount){
        this.lossamount = lossamount;
    }

    /**
     * 获取属性LOSSAMOUNT
     * @return 属性LOSSAMOUNT的值
     */
    public double getLossamount(){
        return lossamount;
    }

    /**
     * 设置属性SETTLESUM
     * @param settlesum 待设置的属性SETTLESUM的值
     */
    public void setSettlesum(double settlesum){
        this.settlesum = settlesum;
    }

    /**
     * 获取属性SETTLESUM
     * @return 属性SETTLESUM的值
     */
    public double getSettlesum(){
        return settlesum;
    }

    /**
     * 设置属性PREPAY
     * @param prepay 待设置的属性PREPAY的值
     */
    public void setPrepay(double prepay){
        this.prepay = prepay;
    }

    /**
     * 获取属性PREPAY
     * @return 属性PREPAY的值
     */
    public double getPrepay(){
        return prepay;
    }

    /**
     * 设置属性SUPPLYPREPAY
     * @param supplyprepay 待设置的属性SUPPLYPREPAY的值
     */
    public void setSupplyprepay(double supplyprepay){
        this.supplyprepay = supplyprepay;
    }

    /**
     * 获取属性SUPPLYPREPAY
     * @return 属性SUPPLYPREPAY的值
     */
    public double getSupplyprepay(){
        return supplyprepay;
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
     * 设置属性SUMINSURED
     * @param suminsured 待设置的属性SUMINSURED的值
     */
    public void setSuminsured(double suminsured){
        this.suminsured = suminsured;
    }

    /**
     * 获取属性SUMINSURED
     * @return 属性SUMINSURED的值
     */
    public double getSuminsured(){
        return suminsured;
    }
    
    public TemblorsettlelisttempDto evaluate(String registNo, int index, String timeStamp){
    	TemblorsettlelisttempDto temblorSettleListTempDto = new TemblorsettlelisttempDto();
    	temblorSettleListTempDto.setRegistcode(registNo);
    	temblorSettleListTempDto.setStringtimestamp(timeStamp);
    	temblorSettleListTempDto.setIndexofsettle(index);
    	temblorSettleListTempDto.setCountrycode(countrycode);
    	temblorSettleListTempDto.setKindcode(kindcode);
    	temblorSettleListTempDto.setItemcode(itemcode);
    	temblorSettleListTempDto.setClasscode(classcode);
    	temblorSettleListTempDto.setRiskcode(riskcode);
    	temblorSettleListTempDto.setAddress(address);
    	temblorSettleListTempDto.setZipcode(zipcode);
    	temblorSettleListTempDto.setItemtype(itemtype);
    	temblorSettleListTempDto.setLongitude(longitude);
    	temblorSettleListTempDto.setIdcard(idcard);
    	temblorSettleListTempDto.setLatitude(latitude);
    	temblorSettleListTempDto.setInusrelistcode(inusrelistcode);
    	temblorSettleListTempDto.setBuilding(building);
    	temblorSettleListTempDto.setLossrate(lossrate);
    	temblorSettleListTempDto.setFloor(floor);
    	temblorSettleListTempDto.setSettlesum(settlesum);
    	temblorSettleListTempDto.setOpcode(opcode);
    	temblorSettleListTempDto.setOptime(optime);
    	temblorSettleListTempDto.setRemark(remark);
    	temblorSettleListTempDto.setValidity(validity);
    	temblorSettleListTempDto.setSettledate(settledate);
    	temblorSettleListTempDto.setClaimrate(claimrate);
    	temblorSettleListTempDto.setNodetype(nodetype);
    	temblorSettleListTempDto.setArchitecture(architecture);
    	temblorSettleListTempDto.setArea(area);
    	temblorSettleListTempDto.setBuildtime(buildtime);
    	temblorSettleListTempDto.setRepair(repair);
    	temblorSettleListTempDto.setRepairtime(repairtime);
    	temblorSettleListTempDto.setPropcerttype(propcerttype);
    	temblorSettleListTempDto.setPropcertno(propcertno);
    	temblorSettleListTempDto.setDamagelevel(damagelevel);
    	temblorSettleListTempDto.setLossamount(lossamount);
    	temblorSettleListTempDto.setPrepay(prepay);
    	temblorSettleListTempDto.setSupplyprepay(supplyprepay);
    	temblorSettleListTempDto.setCardtype(cardtype);
    	temblorSettleListTempDto.setName(name);
    	temblorSettleListTempDto.setSuminsured(suminsured);

    	return temblorSettleListTempDto;
    }
}
