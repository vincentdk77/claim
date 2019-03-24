package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdship的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDshipDtoBase implements Serializable{
    /** 属性shipcode */
    private String shipCode = "";
    /** 属性shipcname */
    private String shipCName = "";
    /** 属性shipename */
    private String shipEName = "";
    /** 属性oldshipname */
    private String oldShipName = "";
    /** 属性shipowner */
    private String shipOwner = "";
    /** 属性oldshipowner */
    private String oldShipOwner = "";
    /** 属性associate */
    private String associate = "";
    /** 属性BuildDate */
    private DateTime buildDate = new DateTime();
    /** 属性countrycode */
    private String countryCode = "";
    /** 属性makefactory */
    private String makeFactory = "";
    /** 属性makedock */
    private String makeDock = "";
    /** 属性stephull */
    private String stepHull = "";
    /** 属性oldstephull */
    private String oldStepHull = "";
    /** 属性shipflag */
    private String shipFlag = "";
    /** 属性shiptype */
    private String shipType = "";
    /** 属性usenature */
    private String useNature = "";
    /** 属性shipusage */
    private String shipUsage = "";
    /** 属性shipstruct */
    private String shipStruct = "";
    /** 属性registrysite */
    private String registrySite = "";
    /** 属性toncount */
    private double tonCount = 0d;
    /** 属性nettoncount */
    private double netTonCount = 0d;
    /** 属性horsepower */
    private double horsePower = 0d;
    /** 属性powerunit */
    private String powerUnit = "";
    /** 属性seatcount */
    private int seatCount = 0;
    /** 属性loadton */
    private double loadTon = 0d;
    /** 属性shiplength */
    private double shipLength = 0d;
    /** 属性shipwidth */
    private double shipWidth = 0d;
    /** 属性shipdepth */
    private double shipDepth = 0d;
    /** 属性shipvalue */
    private double shipValue = 0d;
    /** 属性certificateowner */
    private String certificateOwner = "";
    /** 属性actualowner */
    private String actualOwner = "";
    /** 属性proprietorname */
    private String proprietorName = "";
    /** 属性managetype */
    private String manageType = "";
    /** 属性managestartdate */
    private DateTime manageStartDate = new DateTime();
    /** 属性manageenddate */
    private DateTime manageEndDate = new DateTime();
    /** 属性checkstartdate */
    private DateTime checkStartDate = new DateTime();
    /** 属性checkenddate */
    private DateTime checkEndDate = new DateTime();
    /** 属性debtamount */
    private int debtAmount = 0;
    /** 属性pledge */
    private String pledge = "";
    /** 属性rebuildcompany */
    private String rebuildCompany = "";
    /** 属性rebuilddate */
    private DateTime rebuildDate = new DateTime();
    /** 属性newshipcode */
    private String newShipCode = "";
    /** 属性validstatus */
    private String validStatus = "";
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDshipDtoBase对象
     */
    public PrpDshipDtoBase(){
    }

    /**
     * 设置属性shipcode
     * @param shipCode 待设置的属性shipcode的值
     */
    public void setShipCode(String shipCode){
        this.shipCode = StringUtils.rightTrim(shipCode);
    }

    /**
     * 获取属性shipcode
     * @return 属性shipcode的值
     */
    public String getShipCode(){
        return shipCode;
    }

    /**
     * 设置属性shipcname
     * @param shipCName 待设置的属性shipcname的值
     */
    public void setShipCName(String shipCName){
        this.shipCName = StringUtils.rightTrim(shipCName);
    }

    /**
     * 获取属性shipcname
     * @return 属性shipcname的值
     */
    public String getShipCName(){
        return shipCName;
    }

    /**
     * 设置属性shipename
     * @param shipEName 待设置的属性shipename的值
     */
    public void setShipEName(String shipEName){
        this.shipEName = StringUtils.rightTrim(shipEName);
    }

    /**
     * 获取属性shipename
     * @return 属性shipename的值
     */
    public String getShipEName(){
        return shipEName;
    }

    /**
     * 设置属性oldshipname
     * @param oldShipName 待设置的属性oldshipname的值
     */
    public void setOldShipName(String oldShipName){
        this.oldShipName = StringUtils.rightTrim(oldShipName);
    }

    /**
     * 获取属性oldshipname
     * @return 属性oldshipname的值
     */
    public String getOldShipName(){
        return oldShipName;
    }

    /**
     * 设置属性shipowner
     * @param shipOwner 待设置的属性shipowner的值
     */
    public void setShipOwner(String shipOwner){
        this.shipOwner = StringUtils.rightTrim(shipOwner);
    }

    /**
     * 获取属性shipowner
     * @return 属性shipowner的值
     */
    public String getShipOwner(){
        return shipOwner;
    }

    /**
     * 设置属性oldshipowner
     * @param oldShipOwner 待设置的属性oldshipowner的值
     */
    public void setOldShipOwner(String oldShipOwner){
        this.oldShipOwner = StringUtils.rightTrim(oldShipOwner);
    }

    /**
     * 获取属性oldshipowner
     * @return 属性oldshipowner的值
     */
    public String getOldShipOwner(){
        return oldShipOwner;
    }

    /**
     * 设置属性associate
     * @param associate 待设置的属性associate的值
     */
    public void setAssociate(String associate){
        this.associate = StringUtils.rightTrim(associate);
    }

    /**
     * 获取属性associate
     * @return 属性associate的值
     */
    public String getAssociate(){
        return associate;
    }

    /**
     * 设置属性BuildDate
     * @param buildDate 待设置的属性BuildDate的值
     */
    public void setBuildDate(DateTime buildDate){
        this.buildDate = buildDate;
    }

    /**
     * 获取属性BuildDate
     * @return 属性BuildDate的值
     */
    public DateTime getBuildDate(){
        return buildDate;
    }

    /**
     * 设置属性countrycode
     * @param countryCode 待设置的属性countrycode的值
     */
    public void setCountryCode(String countryCode){
        this.countryCode = StringUtils.rightTrim(countryCode);
    }

    /**
     * 获取属性countrycode
     * @return 属性countrycode的值
     */
    public String getCountryCode(){
        return countryCode;
    }

    /**
     * 设置属性makefactory
     * @param makeFactory 待设置的属性makefactory的值
     */
    public void setMakeFactory(String makeFactory){
        this.makeFactory = StringUtils.rightTrim(makeFactory);
    }

    /**
     * 获取属性makefactory
     * @return 属性makefactory的值
     */
    public String getMakeFactory(){
        return makeFactory;
    }

    /**
     * 设置属性makedock
     * @param makeDock 待设置的属性makedock的值
     */
    public void setMakeDock(String makeDock){
        this.makeDock = StringUtils.rightTrim(makeDock);
    }

    /**
     * 获取属性makedock
     * @return 属性makedock的值
     */
    public String getMakeDock(){
        return makeDock;
    }

    /**
     * 设置属性stephull
     * @param stepHull 待设置的属性stephull的值
     */
    public void setStepHull(String stepHull){
        this.stepHull = StringUtils.rightTrim(stepHull);
    }

    /**
     * 获取属性stephull
     * @return 属性stephull的值
     */
    public String getStepHull(){
        return stepHull;
    }

    /**
     * 设置属性oldstephull
     * @param oldStepHull 待设置的属性oldstephull的值
     */
    public void setOldStepHull(String oldStepHull){
        this.oldStepHull = StringUtils.rightTrim(oldStepHull);
    }

    /**
     * 获取属性oldstephull
     * @return 属性oldstephull的值
     */
    public String getOldStepHull(){
        return oldStepHull;
    }

    /**
     * 设置属性shipflag
     * @param shipFlag 待设置的属性shipflag的值
     */
    public void setShipFlag(String shipFlag){
        this.shipFlag = StringUtils.rightTrim(shipFlag);
    }

    /**
     * 获取属性shipflag
     * @return 属性shipflag的值
     */
    public String getShipFlag(){
        return shipFlag;
    }

    /**
     * 设置属性shiptype
     * @param shipType 待设置的属性shiptype的值
     */
    public void setShipType(String shipType){
        this.shipType = StringUtils.rightTrim(shipType);
    }

    /**
     * 获取属性shiptype
     * @return 属性shiptype的值
     */
    public String getShipType(){
        return shipType;
    }

    /**
     * 设置属性usenature
     * @param useNature 待设置的属性usenature的值
     */
    public void setUseNature(String useNature){
        this.useNature = StringUtils.rightTrim(useNature);
    }

    /**
     * 获取属性usenature
     * @return 属性usenature的值
     */
    public String getUseNature(){
        return useNature;
    }

    /**
     * 设置属性shipusage
     * @param shipUsage 待设置的属性shipusage的值
     */
    public void setShipUsage(String shipUsage){
        this.shipUsage = StringUtils.rightTrim(shipUsage);
    }

    /**
     * 获取属性shipusage
     * @return 属性shipusage的值
     */
    public String getShipUsage(){
        return shipUsage;
    }

    /**
     * 设置属性shipstruct
     * @param shipStruct 待设置的属性shipstruct的值
     */
    public void setShipStruct(String shipStruct){
        this.shipStruct = StringUtils.rightTrim(shipStruct);
    }

    /**
     * 获取属性shipstruct
     * @return 属性shipstruct的值
     */
    public String getShipStruct(){
        return shipStruct;
    }

    /**
     * 设置属性registrysite
     * @param registrySite 待设置的属性registrysite的值
     */
    public void setRegistrySite(String registrySite){
        this.registrySite = StringUtils.rightTrim(registrySite);
    }

    /**
     * 获取属性registrysite
     * @return 属性registrysite的值
     */
    public String getRegistrySite(){
        return registrySite;
    }

    /**
     * 设置属性toncount
     * @param tonCount 待设置的属性toncount的值
     */
    public void setTonCount(double tonCount){
        this.tonCount = tonCount;
    }

    /**
     * 获取属性toncount
     * @return 属性toncount的值
     */
    public double getTonCount(){
        return tonCount;
    }

    /**
     * 设置属性nettoncount
     * @param netTonCount 待设置的属性nettoncount的值
     */
    public void setNetTonCount(double netTonCount){
        this.netTonCount = netTonCount;
    }

    /**
     * 获取属性nettoncount
     * @return 属性nettoncount的值
     */
    public double getNetTonCount(){
        return netTonCount;
    }

    /**
     * 设置属性horsepower
     * @param horsePower 待设置的属性horsepower的值
     */
    public void setHorsePower(double horsePower){
        this.horsePower = horsePower;
    }

    /**
     * 获取属性horsepower
     * @return 属性horsepower的值
     */
    public double getHorsePower(){
        return horsePower;
    }

    /**
     * 设置属性powerunit
     * @param powerUnit 待设置的属性powerunit的值
     */
    public void setPowerUnit(String powerUnit){
        this.powerUnit = StringUtils.rightTrim(powerUnit);
    }

    /**
     * 获取属性powerunit
     * @return 属性powerunit的值
     */
    public String getPowerUnit(){
        return powerUnit;
    }

    /**
     * 设置属性seatcount
     * @param seatCount 待设置的属性seatcount的值
     */
    public void setSeatCount(int seatCount){
        this.seatCount = seatCount;
    }

    /**
     * 获取属性seatcount
     * @return 属性seatcount的值
     */
    public int getSeatCount(){
        return seatCount;
    }

    /**
     * 设置属性loadton
     * @param loadTon 待设置的属性loadton的值
     */
    public void setLoadTon(double loadTon){
        this.loadTon = loadTon;
    }

    /**
     * 获取属性loadton
     * @return 属性loadton的值
     */
    public double getLoadTon(){
        return loadTon;
    }

    /**
     * 设置属性shiplength
     * @param shipLength 待设置的属性shiplength的值
     */
    public void setShipLength(double shipLength){
        this.shipLength = shipLength;
    }

    /**
     * 获取属性shiplength
     * @return 属性shiplength的值
     */
    public double getShipLength(){
        return shipLength;
    }

    /**
     * 设置属性shipwidth
     * @param shipWidth 待设置的属性shipwidth的值
     */
    public void setShipWidth(double shipWidth){
        this.shipWidth = shipWidth;
    }

    /**
     * 获取属性shipwidth
     * @return 属性shipwidth的值
     */
    public double getShipWidth(){
        return shipWidth;
    }

    /**
     * 设置属性shipdepth
     * @param shipDepth 待设置的属性shipdepth的值
     */
    public void setShipDepth(double shipDepth){
        this.shipDepth = shipDepth;
    }

    /**
     * 获取属性shipdepth
     * @return 属性shipdepth的值
     */
    public double getShipDepth(){
        return shipDepth;
    }

    /**
     * 设置属性shipvalue
     * @param shipValue 待设置的属性shipvalue的值
     */
    public void setShipValue(double shipValue){
        this.shipValue = shipValue;
    }

    /**
     * 获取属性shipvalue
     * @return 属性shipvalue的值
     */
    public double getShipValue(){
        return shipValue;
    }

    /**
     * 设置属性certificateowner
     * @param certificateOwner 待设置的属性certificateowner的值
     */
    public void setCertificateOwner(String certificateOwner){
        this.certificateOwner = StringUtils.rightTrim(certificateOwner);
    }

    /**
     * 获取属性certificateowner
     * @return 属性certificateowner的值
     */
    public String getCertificateOwner(){
        return certificateOwner;
    }

    /**
     * 设置属性actualowner
     * @param actualOwner 待设置的属性actualowner的值
     */
    public void setActualOwner(String actualOwner){
        this.actualOwner = StringUtils.rightTrim(actualOwner);
    }

    /**
     * 获取属性actualowner
     * @return 属性actualowner的值
     */
    public String getActualOwner(){
        return actualOwner;
    }

    /**
     * 设置属性proprietorname
     * @param proprietorName 待设置的属性proprietorname的值
     */
    public void setProprietorName(String proprietorName){
        this.proprietorName = StringUtils.rightTrim(proprietorName);
    }

    /**
     * 获取属性proprietorname
     * @return 属性proprietorname的值
     */
    public String getProprietorName(){
        return proprietorName;
    }

    /**
     * 设置属性managetype
     * @param manageType 待设置的属性managetype的值
     */
    public void setManageType(String manageType){
        this.manageType = StringUtils.rightTrim(manageType);
    }

    /**
     * 获取属性managetype
     * @return 属性managetype的值
     */
    public String getManageType(){
        return manageType;
    }

    /**
     * 设置属性managestartdate
     * @param manageStartDate 待设置的属性managestartdate的值
     */
    public void setManageStartDate(DateTime manageStartDate){
        this.manageStartDate = manageStartDate;
    }

    /**
     * 获取属性managestartdate
     * @return 属性managestartdate的值
     */
    public DateTime getManageStartDate(){
        return manageStartDate;
    }

    /**
     * 设置属性manageenddate
     * @param manageEndDate 待设置的属性manageenddate的值
     */
    public void setManageEndDate(DateTime manageEndDate){
        this.manageEndDate = manageEndDate;
    }

    /**
     * 获取属性manageenddate
     * @return 属性manageenddate的值
     */
    public DateTime getManageEndDate(){
        return manageEndDate;
    }

    /**
     * 设置属性checkstartdate
     * @param checkStartDate 待设置的属性checkstartdate的值
     */
    public void setCheckStartDate(DateTime checkStartDate){
        this.checkStartDate = checkStartDate;
    }

    /**
     * 获取属性checkstartdate
     * @return 属性checkstartdate的值
     */
    public DateTime getCheckStartDate(){
        return checkStartDate;
    }

    /**
     * 设置属性checkenddate
     * @param checkEndDate 待设置的属性checkenddate的值
     */
    public void setCheckEndDate(DateTime checkEndDate){
        this.checkEndDate = checkEndDate;
    }

    /**
     * 获取属性checkenddate
     * @return 属性checkenddate的值
     */
    public DateTime getCheckEndDate(){
        return checkEndDate;
    }

    /**
     * 设置属性debtamount
     * @param debtAmount 待设置的属性debtamount的值
     */
    public void setDebtAmount(int debtAmount){
        this.debtAmount = debtAmount;
    }

    /**
     * 获取属性debtamount
     * @return 属性debtamount的值
     */
    public int getDebtAmount(){
        return debtAmount;
    }

    /**
     * 设置属性pledge
     * @param pledge 待设置的属性pledge的值
     */
    public void setPledge(String pledge){
        this.pledge = StringUtils.rightTrim(pledge);
    }

    /**
     * 获取属性pledge
     * @return 属性pledge的值
     */
    public String getPledge(){
        return pledge;
    }

    /**
     * 设置属性rebuildcompany
     * @param rebuildCompany 待设置的属性rebuildcompany的值
     */
    public void setRebuildCompany(String rebuildCompany){
        this.rebuildCompany = StringUtils.rightTrim(rebuildCompany);
    }

    /**
     * 获取属性rebuildcompany
     * @return 属性rebuildcompany的值
     */
    public String getRebuildCompany(){
        return rebuildCompany;
    }

    /**
     * 设置属性rebuilddate
     * @param rebuildDate 待设置的属性rebuilddate的值
     */
    public void setRebuildDate(DateTime rebuildDate){
        this.rebuildDate = rebuildDate;
    }

    /**
     * 获取属性rebuilddate
     * @return 属性rebuilddate的值
     */
    public DateTime getRebuildDate(){
        return rebuildDate;
    }

    /**
     * 设置属性newshipcode
     * @param newShipCode 待设置的属性newshipcode的值
     */
    public void setNewShipCode(String newShipCode){
        this.newShipCode = StringUtils.rightTrim(newShipCode);
    }

    /**
     * 获取属性newshipcode
     * @return 属性newshipcode的值
     */
    public String getNewShipCode(){
        return newShipCode;
    }

    /**
     * 设置属性validstatus
     * @param validStatus 待设置的属性validstatus的值
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * 获取属性validstatus
     * @return 属性validstatus的值
     */
    public String getValidStatus(){
        return validStatus;
    }

    /**
     * 设置属性flag
     * @param flag 待设置的属性flag的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性flag
     * @return 属性flag的值
     */
    public String getFlag(){
        return flag;
    }
}
