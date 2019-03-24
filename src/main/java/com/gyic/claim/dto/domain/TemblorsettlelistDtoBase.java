package com.gyic.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����TEMBLORSETTLELIST�����ݴ���������<br>
 */
public class TemblorsettlelistDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����SETTLELISTCODE */
    private String settlelistcode = "";
    /** ����INDEXOFSETTLE */
    private int indexofsettle = 0;
    /** ����KINDCODE */
    private String kindcode = "";
    /** ����ITEMCODE */
    private String itemcode = "";
    /** ����CLASSCODE */
    private String classcode = "";
    /** ����RISKCODE */
    private String riskcode = "";
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
    /** ����INUSRELISTCODE */
    private String inusrelistcode = "";
    /** ����LOSSRATE */
    private double lossrate = 0D;
    /** ����OPCODE */
    private String opcode = "";
    /** ����OPTIME */
    private DateTime optime = new DateTime();
    /** ����VALIDITY */
    private String validity = "";
    /** ����SETTLEDATE */
    private DateTime settledate = new DateTime();
    /** ����CLAIMRATE */
    private double claimrate = 0D;
    /** ����NODETYPE */
    private String nodetype = "";
    /** ����DAMAGELEVEL */
    private String damagelevel = "";
    /** ����LOSSAMOUNT */
    private double lossamount = 0D;
    /** ����SETTLESUM */
    private double settlesum = 0D;
    /** ����PREPAY */
    private double prepay = 0D;
    /** ����SUPPLYPREPAY */
    private double supplyprepay = 0D;
    /** ����CARDTYPE */
    private String cardtype = "";
    /** ����IDCARD */
    private String idcard = "";
    /** ����NAME */
    private String name = "";
    
    /** ����SUMINSURED */
    private double suminsured = 0D;

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�TemblorsettlelistDtoBase����
     */
    public TemblorsettlelistDtoBase(){
    }

    /**
     * ��������SETTLELISTCODE
     * @param settlelistcode �����õ�����SETTLELISTCODE��ֵ
     */
    public void setSettlelistcode(String settlelistcode){
        this.settlelistcode = StringUtils.rightTrim(settlelistcode);
    }

    /**
     * ��ȡ����SETTLELISTCODE
     * @return ����SETTLELISTCODE��ֵ
     */
    public String getSettlelistcode(){
        return settlelistcode;
    }

    /**
     * ��������INDEXOFSETTLE
     * @param indexofsettle �����õ�����INDEXOFSETTLE��ֵ
     */
    public void setIndexofsettle(int indexofsettle){
        this.indexofsettle = indexofsettle;
    }

    /**
     * ��ȡ����INDEXOFSETTLE
     * @return ����INDEXOFSETTLE��ֵ
     */
    public int getIndexofsettle(){
        return indexofsettle;
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
     * ��������LOSSRATE
     * @param lossrate �����õ�����LOSSRATE��ֵ
     */
    public void setLossrate(double lossrate){
        this.lossrate = lossrate;
    }

    /**
     * ��ȡ����LOSSRATE
     * @return ����LOSSRATE��ֵ
     */
    public double getLossrate(){
        return lossrate;
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
     * ��������SETTLEDATE
     * @param settledate �����õ�����SETTLEDATE��ֵ
     */
    public void setSettledate(DateTime settledate){
        this.settledate = settledate;
    }

    /**
     * ��ȡ����SETTLEDATE
     * @return ����SETTLEDATE��ֵ
     */
    public DateTime getSettledate(){
        return settledate;
    }

    /**
     * ��������CLAIMRATE
     * @param claimrate �����õ�����CLAIMRATE��ֵ
     */
    public void setClaimrate(double claimrate){
        this.claimrate = claimrate;
    }

    /**
     * ��ȡ����CLAIMRATE
     * @return ����CLAIMRATE��ֵ
     */
    public double getClaimrate(){
        return claimrate;
    }

    /**
     * ��������NODETYPE
     * @param nodetype �����õ�����NODETYPE��ֵ
     */
    public void setNodetype(String nodetype){
        this.nodetype = StringUtils.rightTrim(nodetype);
    }

    /**
     * ��ȡ����NODETYPE
     * @return ����NODETYPE��ֵ
     */
    public String getNodetype(){
        return nodetype;
    }

    /**
     * ��������DAMAGELEVEL
     * @param damagelevel �����õ�����DAMAGELEVEL��ֵ
     */
    public void setDamagelevel(String damagelevel){
        this.damagelevel = StringUtils.rightTrim(damagelevel);
    }

    /**
     * ��ȡ����DAMAGELEVEL
     * @return ����DAMAGELEVEL��ֵ
     */
    public String getDamagelevel(){
        return damagelevel;
    }

    /**
     * ��������LOSSAMOUNT
     * @param lossamount �����õ�����LOSSAMOUNT��ֵ
     */
    public void setLossamount(double lossamount){
        this.lossamount = lossamount;
    }

    /**
     * ��ȡ����LOSSAMOUNT
     * @return ����LOSSAMOUNT��ֵ
     */
    public double getLossamount(){
        return lossamount;
    }

    /**
     * ��������SETTLESUM
     * @param settlesum �����õ�����SETTLESUM��ֵ
     */
    public void setSettlesum(double settlesum){
        this.settlesum = settlesum;
    }

    /**
     * ��ȡ����SETTLESUM
     * @return ����SETTLESUM��ֵ
     */
    public double getSettlesum(){
        return settlesum;
    }

    /**
     * ��������PREPAY
     * @param prepay �����õ�����PREPAY��ֵ
     */
    public void setPrepay(double prepay){
        this.prepay = prepay;
    }

    /**
     * ��ȡ����PREPAY
     * @return ����PREPAY��ֵ
     */
    public double getPrepay(){
        return prepay;
    }

    /**
     * ��������SUPPLYPREPAY
     * @param supplyprepay �����õ�����SUPPLYPREPAY��ֵ
     */
    public void setSupplyprepay(double supplyprepay){
        this.supplyprepay = supplyprepay;
    }

    /**
     * ��ȡ����SUPPLYPREPAY
     * @return ����SUPPLYPREPAY��ֵ
     */
    public double getSupplyprepay(){
        return supplyprepay;
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
     * ��������SUMINSURED
     * @param suminsured �����õ�����SUMINSURED��ֵ
     */
    public void setSuminsured(double suminsured){
        this.suminsured = suminsured;
    }

    /**
     * ��ȡ����SUMINSURED
     * @return ����SUMINSURED��ֵ
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
