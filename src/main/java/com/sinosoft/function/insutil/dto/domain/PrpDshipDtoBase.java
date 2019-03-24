package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdship�����ݴ���������<br>
 * ������ 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDshipDtoBase implements Serializable{
    /** ����shipcode */
    private String shipCode = "";
    /** ����shipcname */
    private String shipCName = "";
    /** ����shipename */
    private String shipEName = "";
    /** ����oldshipname */
    private String oldShipName = "";
    /** ����shipowner */
    private String shipOwner = "";
    /** ����oldshipowner */
    private String oldShipOwner = "";
    /** ����associate */
    private String associate = "";
    /** ����BuildDate */
    private DateTime buildDate = new DateTime();
    /** ����countrycode */
    private String countryCode = "";
    /** ����makefactory */
    private String makeFactory = "";
    /** ����makedock */
    private String makeDock = "";
    /** ����stephull */
    private String stepHull = "";
    /** ����oldstephull */
    private String oldStepHull = "";
    /** ����shipflag */
    private String shipFlag = "";
    /** ����shiptype */
    private String shipType = "";
    /** ����usenature */
    private String useNature = "";
    /** ����shipusage */
    private String shipUsage = "";
    /** ����shipstruct */
    private String shipStruct = "";
    /** ����registrysite */
    private String registrySite = "";
    /** ����toncount */
    private double tonCount = 0d;
    /** ����nettoncount */
    private double netTonCount = 0d;
    /** ����horsepower */
    private double horsePower = 0d;
    /** ����powerunit */
    private String powerUnit = "";
    /** ����seatcount */
    private int seatCount = 0;
    /** ����loadton */
    private double loadTon = 0d;
    /** ����shiplength */
    private double shipLength = 0d;
    /** ����shipwidth */
    private double shipWidth = 0d;
    /** ����shipdepth */
    private double shipDepth = 0d;
    /** ����shipvalue */
    private double shipValue = 0d;
    /** ����certificateowner */
    private String certificateOwner = "";
    /** ����actualowner */
    private String actualOwner = "";
    /** ����proprietorname */
    private String proprietorName = "";
    /** ����managetype */
    private String manageType = "";
    /** ����managestartdate */
    private DateTime manageStartDate = new DateTime();
    /** ����manageenddate */
    private DateTime manageEndDate = new DateTime();
    /** ����checkstartdate */
    private DateTime checkStartDate = new DateTime();
    /** ����checkenddate */
    private DateTime checkEndDate = new DateTime();
    /** ����debtamount */
    private int debtAmount = 0;
    /** ����pledge */
    private String pledge = "";
    /** ����rebuildcompany */
    private String rebuildCompany = "";
    /** ����rebuilddate */
    private DateTime rebuildDate = new DateTime();
    /** ����newshipcode */
    private String newShipCode = "";
    /** ����validstatus */
    private String validStatus = "";
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDshipDtoBase����
     */
    public PrpDshipDtoBase(){
    }

    /**
     * ��������shipcode
     * @param shipCode �����õ�����shipcode��ֵ
     */
    public void setShipCode(String shipCode){
        this.shipCode = StringUtils.rightTrim(shipCode);
    }

    /**
     * ��ȡ����shipcode
     * @return ����shipcode��ֵ
     */
    public String getShipCode(){
        return shipCode;
    }

    /**
     * ��������shipcname
     * @param shipCName �����õ�����shipcname��ֵ
     */
    public void setShipCName(String shipCName){
        this.shipCName = StringUtils.rightTrim(shipCName);
    }

    /**
     * ��ȡ����shipcname
     * @return ����shipcname��ֵ
     */
    public String getShipCName(){
        return shipCName;
    }

    /**
     * ��������shipename
     * @param shipEName �����õ�����shipename��ֵ
     */
    public void setShipEName(String shipEName){
        this.shipEName = StringUtils.rightTrim(shipEName);
    }

    /**
     * ��ȡ����shipename
     * @return ����shipename��ֵ
     */
    public String getShipEName(){
        return shipEName;
    }

    /**
     * ��������oldshipname
     * @param oldShipName �����õ�����oldshipname��ֵ
     */
    public void setOldShipName(String oldShipName){
        this.oldShipName = StringUtils.rightTrim(oldShipName);
    }

    /**
     * ��ȡ����oldshipname
     * @return ����oldshipname��ֵ
     */
    public String getOldShipName(){
        return oldShipName;
    }

    /**
     * ��������shipowner
     * @param shipOwner �����õ�����shipowner��ֵ
     */
    public void setShipOwner(String shipOwner){
        this.shipOwner = StringUtils.rightTrim(shipOwner);
    }

    /**
     * ��ȡ����shipowner
     * @return ����shipowner��ֵ
     */
    public String getShipOwner(){
        return shipOwner;
    }

    /**
     * ��������oldshipowner
     * @param oldShipOwner �����õ�����oldshipowner��ֵ
     */
    public void setOldShipOwner(String oldShipOwner){
        this.oldShipOwner = StringUtils.rightTrim(oldShipOwner);
    }

    /**
     * ��ȡ����oldshipowner
     * @return ����oldshipowner��ֵ
     */
    public String getOldShipOwner(){
        return oldShipOwner;
    }

    /**
     * ��������associate
     * @param associate �����õ�����associate��ֵ
     */
    public void setAssociate(String associate){
        this.associate = StringUtils.rightTrim(associate);
    }

    /**
     * ��ȡ����associate
     * @return ����associate��ֵ
     */
    public String getAssociate(){
        return associate;
    }

    /**
     * ��������BuildDate
     * @param buildDate �����õ�����BuildDate��ֵ
     */
    public void setBuildDate(DateTime buildDate){
        this.buildDate = buildDate;
    }

    /**
     * ��ȡ����BuildDate
     * @return ����BuildDate��ֵ
     */
    public DateTime getBuildDate(){
        return buildDate;
    }

    /**
     * ��������countrycode
     * @param countryCode �����õ�����countrycode��ֵ
     */
    public void setCountryCode(String countryCode){
        this.countryCode = StringUtils.rightTrim(countryCode);
    }

    /**
     * ��ȡ����countrycode
     * @return ����countrycode��ֵ
     */
    public String getCountryCode(){
        return countryCode;
    }

    /**
     * ��������makefactory
     * @param makeFactory �����õ�����makefactory��ֵ
     */
    public void setMakeFactory(String makeFactory){
        this.makeFactory = StringUtils.rightTrim(makeFactory);
    }

    /**
     * ��ȡ����makefactory
     * @return ����makefactory��ֵ
     */
    public String getMakeFactory(){
        return makeFactory;
    }

    /**
     * ��������makedock
     * @param makeDock �����õ�����makedock��ֵ
     */
    public void setMakeDock(String makeDock){
        this.makeDock = StringUtils.rightTrim(makeDock);
    }

    /**
     * ��ȡ����makedock
     * @return ����makedock��ֵ
     */
    public String getMakeDock(){
        return makeDock;
    }

    /**
     * ��������stephull
     * @param stepHull �����õ�����stephull��ֵ
     */
    public void setStepHull(String stepHull){
        this.stepHull = StringUtils.rightTrim(stepHull);
    }

    /**
     * ��ȡ����stephull
     * @return ����stephull��ֵ
     */
    public String getStepHull(){
        return stepHull;
    }

    /**
     * ��������oldstephull
     * @param oldStepHull �����õ�����oldstephull��ֵ
     */
    public void setOldStepHull(String oldStepHull){
        this.oldStepHull = StringUtils.rightTrim(oldStepHull);
    }

    /**
     * ��ȡ����oldstephull
     * @return ����oldstephull��ֵ
     */
    public String getOldStepHull(){
        return oldStepHull;
    }

    /**
     * ��������shipflag
     * @param shipFlag �����õ�����shipflag��ֵ
     */
    public void setShipFlag(String shipFlag){
        this.shipFlag = StringUtils.rightTrim(shipFlag);
    }

    /**
     * ��ȡ����shipflag
     * @return ����shipflag��ֵ
     */
    public String getShipFlag(){
        return shipFlag;
    }

    /**
     * ��������shiptype
     * @param shipType �����õ�����shiptype��ֵ
     */
    public void setShipType(String shipType){
        this.shipType = StringUtils.rightTrim(shipType);
    }

    /**
     * ��ȡ����shiptype
     * @return ����shiptype��ֵ
     */
    public String getShipType(){
        return shipType;
    }

    /**
     * ��������usenature
     * @param useNature �����õ�����usenature��ֵ
     */
    public void setUseNature(String useNature){
        this.useNature = StringUtils.rightTrim(useNature);
    }

    /**
     * ��ȡ����usenature
     * @return ����usenature��ֵ
     */
    public String getUseNature(){
        return useNature;
    }

    /**
     * ��������shipusage
     * @param shipUsage �����õ�����shipusage��ֵ
     */
    public void setShipUsage(String shipUsage){
        this.shipUsage = StringUtils.rightTrim(shipUsage);
    }

    /**
     * ��ȡ����shipusage
     * @return ����shipusage��ֵ
     */
    public String getShipUsage(){
        return shipUsage;
    }

    /**
     * ��������shipstruct
     * @param shipStruct �����õ�����shipstruct��ֵ
     */
    public void setShipStruct(String shipStruct){
        this.shipStruct = StringUtils.rightTrim(shipStruct);
    }

    /**
     * ��ȡ����shipstruct
     * @return ����shipstruct��ֵ
     */
    public String getShipStruct(){
        return shipStruct;
    }

    /**
     * ��������registrysite
     * @param registrySite �����õ�����registrysite��ֵ
     */
    public void setRegistrySite(String registrySite){
        this.registrySite = StringUtils.rightTrim(registrySite);
    }

    /**
     * ��ȡ����registrysite
     * @return ����registrysite��ֵ
     */
    public String getRegistrySite(){
        return registrySite;
    }

    /**
     * ��������toncount
     * @param tonCount �����õ�����toncount��ֵ
     */
    public void setTonCount(double tonCount){
        this.tonCount = tonCount;
    }

    /**
     * ��ȡ����toncount
     * @return ����toncount��ֵ
     */
    public double getTonCount(){
        return tonCount;
    }

    /**
     * ��������nettoncount
     * @param netTonCount �����õ�����nettoncount��ֵ
     */
    public void setNetTonCount(double netTonCount){
        this.netTonCount = netTonCount;
    }

    /**
     * ��ȡ����nettoncount
     * @return ����nettoncount��ֵ
     */
    public double getNetTonCount(){
        return netTonCount;
    }

    /**
     * ��������horsepower
     * @param horsePower �����õ�����horsepower��ֵ
     */
    public void setHorsePower(double horsePower){
        this.horsePower = horsePower;
    }

    /**
     * ��ȡ����horsepower
     * @return ����horsepower��ֵ
     */
    public double getHorsePower(){
        return horsePower;
    }

    /**
     * ��������powerunit
     * @param powerUnit �����õ�����powerunit��ֵ
     */
    public void setPowerUnit(String powerUnit){
        this.powerUnit = StringUtils.rightTrim(powerUnit);
    }

    /**
     * ��ȡ����powerunit
     * @return ����powerunit��ֵ
     */
    public String getPowerUnit(){
        return powerUnit;
    }

    /**
     * ��������seatcount
     * @param seatCount �����õ�����seatcount��ֵ
     */
    public void setSeatCount(int seatCount){
        this.seatCount = seatCount;
    }

    /**
     * ��ȡ����seatcount
     * @return ����seatcount��ֵ
     */
    public int getSeatCount(){
        return seatCount;
    }

    /**
     * ��������loadton
     * @param loadTon �����õ�����loadton��ֵ
     */
    public void setLoadTon(double loadTon){
        this.loadTon = loadTon;
    }

    /**
     * ��ȡ����loadton
     * @return ����loadton��ֵ
     */
    public double getLoadTon(){
        return loadTon;
    }

    /**
     * ��������shiplength
     * @param shipLength �����õ�����shiplength��ֵ
     */
    public void setShipLength(double shipLength){
        this.shipLength = shipLength;
    }

    /**
     * ��ȡ����shiplength
     * @return ����shiplength��ֵ
     */
    public double getShipLength(){
        return shipLength;
    }

    /**
     * ��������shipwidth
     * @param shipWidth �����õ�����shipwidth��ֵ
     */
    public void setShipWidth(double shipWidth){
        this.shipWidth = shipWidth;
    }

    /**
     * ��ȡ����shipwidth
     * @return ����shipwidth��ֵ
     */
    public double getShipWidth(){
        return shipWidth;
    }

    /**
     * ��������shipdepth
     * @param shipDepth �����õ�����shipdepth��ֵ
     */
    public void setShipDepth(double shipDepth){
        this.shipDepth = shipDepth;
    }

    /**
     * ��ȡ����shipdepth
     * @return ����shipdepth��ֵ
     */
    public double getShipDepth(){
        return shipDepth;
    }

    /**
     * ��������shipvalue
     * @param shipValue �����õ�����shipvalue��ֵ
     */
    public void setShipValue(double shipValue){
        this.shipValue = shipValue;
    }

    /**
     * ��ȡ����shipvalue
     * @return ����shipvalue��ֵ
     */
    public double getShipValue(){
        return shipValue;
    }

    /**
     * ��������certificateowner
     * @param certificateOwner �����õ�����certificateowner��ֵ
     */
    public void setCertificateOwner(String certificateOwner){
        this.certificateOwner = StringUtils.rightTrim(certificateOwner);
    }

    /**
     * ��ȡ����certificateowner
     * @return ����certificateowner��ֵ
     */
    public String getCertificateOwner(){
        return certificateOwner;
    }

    /**
     * ��������actualowner
     * @param actualOwner �����õ�����actualowner��ֵ
     */
    public void setActualOwner(String actualOwner){
        this.actualOwner = StringUtils.rightTrim(actualOwner);
    }

    /**
     * ��ȡ����actualowner
     * @return ����actualowner��ֵ
     */
    public String getActualOwner(){
        return actualOwner;
    }

    /**
     * ��������proprietorname
     * @param proprietorName �����õ�����proprietorname��ֵ
     */
    public void setProprietorName(String proprietorName){
        this.proprietorName = StringUtils.rightTrim(proprietorName);
    }

    /**
     * ��ȡ����proprietorname
     * @return ����proprietorname��ֵ
     */
    public String getProprietorName(){
        return proprietorName;
    }

    /**
     * ��������managetype
     * @param manageType �����õ�����managetype��ֵ
     */
    public void setManageType(String manageType){
        this.manageType = StringUtils.rightTrim(manageType);
    }

    /**
     * ��ȡ����managetype
     * @return ����managetype��ֵ
     */
    public String getManageType(){
        return manageType;
    }

    /**
     * ��������managestartdate
     * @param manageStartDate �����õ�����managestartdate��ֵ
     */
    public void setManageStartDate(DateTime manageStartDate){
        this.manageStartDate = manageStartDate;
    }

    /**
     * ��ȡ����managestartdate
     * @return ����managestartdate��ֵ
     */
    public DateTime getManageStartDate(){
        return manageStartDate;
    }

    /**
     * ��������manageenddate
     * @param manageEndDate �����õ�����manageenddate��ֵ
     */
    public void setManageEndDate(DateTime manageEndDate){
        this.manageEndDate = manageEndDate;
    }

    /**
     * ��ȡ����manageenddate
     * @return ����manageenddate��ֵ
     */
    public DateTime getManageEndDate(){
        return manageEndDate;
    }

    /**
     * ��������checkstartdate
     * @param checkStartDate �����õ�����checkstartdate��ֵ
     */
    public void setCheckStartDate(DateTime checkStartDate){
        this.checkStartDate = checkStartDate;
    }

    /**
     * ��ȡ����checkstartdate
     * @return ����checkstartdate��ֵ
     */
    public DateTime getCheckStartDate(){
        return checkStartDate;
    }

    /**
     * ��������checkenddate
     * @param checkEndDate �����õ�����checkenddate��ֵ
     */
    public void setCheckEndDate(DateTime checkEndDate){
        this.checkEndDate = checkEndDate;
    }

    /**
     * ��ȡ����checkenddate
     * @return ����checkenddate��ֵ
     */
    public DateTime getCheckEndDate(){
        return checkEndDate;
    }

    /**
     * ��������debtamount
     * @param debtAmount �����õ�����debtamount��ֵ
     */
    public void setDebtAmount(int debtAmount){
        this.debtAmount = debtAmount;
    }

    /**
     * ��ȡ����debtamount
     * @return ����debtamount��ֵ
     */
    public int getDebtAmount(){
        return debtAmount;
    }

    /**
     * ��������pledge
     * @param pledge �����õ�����pledge��ֵ
     */
    public void setPledge(String pledge){
        this.pledge = StringUtils.rightTrim(pledge);
    }

    /**
     * ��ȡ����pledge
     * @return ����pledge��ֵ
     */
    public String getPledge(){
        return pledge;
    }

    /**
     * ��������rebuildcompany
     * @param rebuildCompany �����õ�����rebuildcompany��ֵ
     */
    public void setRebuildCompany(String rebuildCompany){
        this.rebuildCompany = StringUtils.rightTrim(rebuildCompany);
    }

    /**
     * ��ȡ����rebuildcompany
     * @return ����rebuildcompany��ֵ
     */
    public String getRebuildCompany(){
        return rebuildCompany;
    }

    /**
     * ��������rebuilddate
     * @param rebuildDate �����õ�����rebuilddate��ֵ
     */
    public void setRebuildDate(DateTime rebuildDate){
        this.rebuildDate = rebuildDate;
    }

    /**
     * ��ȡ����rebuilddate
     * @return ����rebuilddate��ֵ
     */
    public DateTime getRebuildDate(){
        return rebuildDate;
    }

    /**
     * ��������newshipcode
     * @param newShipCode �����õ�����newshipcode��ֵ
     */
    public void setNewShipCode(String newShipCode){
        this.newShipCode = StringUtils.rightTrim(newShipCode);
    }

    /**
     * ��ȡ����newshipcode
     * @return ����newshipcode��ֵ
     */
    public String getNewShipCode(){
        return newShipCode;
    }

    /**
     * ��������validstatus
     * @param validStatus �����õ�����validstatus��ֵ
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * ��ȡ����validstatus
     * @return ����validstatus��ֵ
     */
    public String getValidStatus(){
        return validStatus;
    }

    /**
     * ��������flag
     * @param flag �����õ�����flag��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ����flag
     * @return ����flag��ֵ
     */
    public String getFlag(){
        return flag;
    }
}
