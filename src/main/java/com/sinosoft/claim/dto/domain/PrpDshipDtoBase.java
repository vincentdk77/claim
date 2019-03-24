package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdship船舶代码的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDshipDtoBase implements Serializable{
    /** 属性船舶代码 */
    private String shipCode = "";
    /** 属性船名(中文) */
    private String shipCName = "";
    /** 属性船名(英文) */
    private String shipEName = "";
    /** 属性曾用名 */
    private String oldShipName = "";
    /** 属性船东 */
    private String shipOwner = "";
    /** 属性原船东 */
    private String oldShipOwner = "";
    /** 属性保赔协会 */
    private String associate = "";
    /** 属性建造年月 */
    private DateTime makeYearMonth = new DateTime();
    /** 属性国家代码 */
    private String countryCode = "";
    /** 属性制造厂家 */
    private String makeFactory = "";
    /** 属性建造船坞名称及地址 */
    private String makeDock = "";
    /** 属性船级 */
    private String stepHull = "";
    /** 属性原船级 */
    private String oldStepHull = "";
    /** 属性船旗 */
    private String shipFlag = "";
    /** 属性船舶种类代码 */
    private String shipType = "";
    /** 属性船舶使用性质代码 */
    private String useNature = "";
    /** 属性船舶用途 */
    private String shipUsage = "";
    /** 属性船质结构代码 */
    private String shipStruct = "";
    /** 属性注册地点 */
    private String registrySite = "";
    /** 属性总吨位 */
    private double tonCount = 0d;
    /** 属性净吨位 */
    private double netTonCount = 0d;
    /** 属性功率 */
    private double horsePower = 0d;
    /** 属性功率单位 */
    private String powerUnit = "";
    /** 属性客位 */
    private int seatCount = 0;
    /** 属性载重吨 */
    private double loadTon = 0d;
    /** 属性总长 */
    private double shipLength = 0d;
    /** 属性型宽 */
    private double shipWidth = 0d;
    /** 属性型深 */
    private double shipDepth = 0d;
    /** 属性船舶价值 */
    private double shipValue = 0d;
    /** 属性船舶证书上载明的所有人 */
    private String certificateOwner = "";
    /** 属性实际所有人 */
    private String actualOwner = "";
    /** 属性经营者名称 */
    private String proprietorName = "";
    /** 属性经营方式 */
    private String manageType = "";
    /** 属性经营水路运输许可证书有效起期 */
    private DateTime manageStartDate = new DateTime();
    /** 属性经营水路运输许可证书有效止期 */
    private DateTime manageEndDate = new DateTime();
    /** 属性船舶检验证书有效起期 */
    private DateTime checkStartDate = new DateTime();
    /** 属性船舶检验证书有效止期 */
    private DateTime checkEndDate = new DateTime();
    /** 属性船舶债务额 */
    private int debtAmount = 0;
    /** 属性抵押标志(0/1) */
    private String pledge = "";
    /** 属性船舶改建单位 */
    private String rebuildCompany = "";
    /** 属性船舶改建时间 */
    private DateTime rebuildDate = new DateTime();
    /** 属性新的船舶代码 */
    private String newShipCode = "";
    /** 属性效力状态 */
    private String validStatus = "";
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDshipDtoBase对象
     */
    public PrpDshipDtoBase(){
    }

    /**
     * 设置属性船舶代码
     * @param shipCode 待设置的属性船舶代码的值
     */
    public void setShipCode(String shipCode){
        this.shipCode = StringUtils.rightTrim(shipCode);
    }

    /**
     * 获取属性船舶代码
     * @return 属性船舶代码的值
     */
    public String getShipCode(){
        return shipCode;
    }

    /**
     * 设置属性船名(中文)
     * @param shipCName 待设置的属性船名(中文)的值
     */
    public void setShipCName(String shipCName){
        this.shipCName = StringUtils.rightTrim(shipCName);
    }

    /**
     * 获取属性船名(中文)
     * @return 属性船名(中文)的值
     */
    public String getShipCName(){
        return shipCName;
    }

    /**
     * 设置属性船名(英文)
     * @param shipEName 待设置的属性船名(英文)的值
     */
    public void setShipEName(String shipEName){
        this.shipEName = StringUtils.rightTrim(shipEName);
    }

    /**
     * 获取属性船名(英文)
     * @return 属性船名(英文)的值
     */
    public String getShipEName(){
        return shipEName;
    }

    /**
     * 设置属性曾用名
     * @param oldShipName 待设置的属性曾用名的值
     */
    public void setOldShipName(String oldShipName){
        this.oldShipName = StringUtils.rightTrim(oldShipName);
    }

    /**
     * 获取属性曾用名
     * @return 属性曾用名的值
     */
    public String getOldShipName(){
        return oldShipName;
    }

    /**
     * 设置属性船东
     * @param shipOwner 待设置的属性船东的值
     */
    public void setShipOwner(String shipOwner){
        this.shipOwner = StringUtils.rightTrim(shipOwner);
    }

    /**
     * 获取属性船东
     * @return 属性船东的值
     */
    public String getShipOwner(){
        return shipOwner;
    }

    /**
     * 设置属性原船东
     * @param oldShipOwner 待设置的属性原船东的值
     */
    public void setOldShipOwner(String oldShipOwner){
        this.oldShipOwner = StringUtils.rightTrim(oldShipOwner);
    }

    /**
     * 获取属性原船东
     * @return 属性原船东的值
     */
    public String getOldShipOwner(){
        return oldShipOwner;
    }

    /**
     * 设置属性保赔协会
     * @param associate 待设置的属性保赔协会的值
     */
    public void setAssociate(String associate){
        this.associate = StringUtils.rightTrim(associate);
    }

    /**
     * 获取属性保赔协会
     * @return 属性保赔协会的值
     */
    public String getAssociate(){
        return associate;
    }

    /**
     * 设置属性建造年月
     * @param makeYearMonth 待设置的属性建造年月的值
     */
    public void setMakeYearMonth(DateTime makeYearMonth){
        this.makeYearMonth = makeYearMonth;
    }

    /**
     * 获取属性建造年月
     * @return 属性建造年月的值
     */
    public DateTime getMakeYearMonth(){
        return makeYearMonth;
    }

    /**
     * 设置属性国家代码
     * @param countryCode 待设置的属性国家代码的值
     */
    public void setCountryCode(String countryCode){
        this.countryCode = StringUtils.rightTrim(countryCode);
    }

    /**
     * 获取属性国家代码
     * @return 属性国家代码的值
     */
    public String getCountryCode(){
        return countryCode;
    }

    /**
     * 设置属性制造厂家
     * @param makeFactory 待设置的属性制造厂家的值
     */
    public void setMakeFactory(String makeFactory){
        this.makeFactory = StringUtils.rightTrim(makeFactory);
    }

    /**
     * 获取属性制造厂家
     * @return 属性制造厂家的值
     */
    public String getMakeFactory(){
        return makeFactory;
    }

    /**
     * 设置属性建造船坞名称及地址
     * @param makeDock 待设置的属性建造船坞名称及地址的值
     */
    public void setMakeDock(String makeDock){
        this.makeDock = StringUtils.rightTrim(makeDock);
    }

    /**
     * 获取属性建造船坞名称及地址
     * @return 属性建造船坞名称及地址的值
     */
    public String getMakeDock(){
        return makeDock;
    }

    /**
     * 设置属性船级
     * @param stepHull 待设置的属性船级的值
     */
    public void setStepHull(String stepHull){
        this.stepHull = StringUtils.rightTrim(stepHull);
    }

    /**
     * 获取属性船级
     * @return 属性船级的值
     */
    public String getStepHull(){
        return stepHull;
    }

    /**
     * 设置属性原船级
     * @param oldStepHull 待设置的属性原船级的值
     */
    public void setOldStepHull(String oldStepHull){
        this.oldStepHull = StringUtils.rightTrim(oldStepHull);
    }

    /**
     * 获取属性原船级
     * @return 属性原船级的值
     */
    public String getOldStepHull(){
        return oldStepHull;
    }

    /**
     * 设置属性船旗
     * @param shipFlag 待设置的属性船旗的值
     */
    public void setShipFlag(String shipFlag){
        this.shipFlag = StringUtils.rightTrim(shipFlag);
    }

    /**
     * 获取属性船旗
     * @return 属性船旗的值
     */
    public String getShipFlag(){
        return shipFlag;
    }

    /**
     * 设置属性船舶种类代码
     * @param shipType 待设置的属性船舶种类代码的值
     */
    public void setShipType(String shipType){
        this.shipType = StringUtils.rightTrim(shipType);
    }

    /**
     * 获取属性船舶种类代码
     * @return 属性船舶种类代码的值
     */
    public String getShipType(){
        return shipType;
    }

    /**
     * 设置属性船舶使用性质代码
     * @param useNature 待设置的属性船舶使用性质代码的值
     */
    public void setUseNature(String useNature){
        this.useNature = StringUtils.rightTrim(useNature);
    }

    /**
     * 获取属性船舶使用性质代码
     * @return 属性船舶使用性质代码的值
     */
    public String getUseNature(){
        return useNature;
    }

    /**
     * 设置属性船舶用途
     * @param shipUsage 待设置的属性船舶用途的值
     */
    public void setShipUsage(String shipUsage){
        this.shipUsage = StringUtils.rightTrim(shipUsage);
    }

    /**
     * 获取属性船舶用途
     * @return 属性船舶用途的值
     */
    public String getShipUsage(){
        return shipUsage;
    }

    /**
     * 设置属性船质结构代码
     * @param shipStruct 待设置的属性船质结构代码的值
     */
    public void setShipStruct(String shipStruct){
        this.shipStruct = StringUtils.rightTrim(shipStruct);
    }

    /**
     * 获取属性船质结构代码
     * @return 属性船质结构代码的值
     */
    public String getShipStruct(){
        return shipStruct;
    }

    /**
     * 设置属性注册地点
     * @param registrySite 待设置的属性注册地点的值
     */
    public void setRegistrySite(String registrySite){
        this.registrySite = StringUtils.rightTrim(registrySite);
    }

    /**
     * 获取属性注册地点
     * @return 属性注册地点的值
     */
    public String getRegistrySite(){
        return registrySite;
    }

    /**
     * 设置属性总吨位
     * @param tonCount 待设置的属性总吨位的值
     */
    public void setTonCount(double tonCount){
        this.tonCount = tonCount;
    }

    /**
     * 获取属性总吨位
     * @return 属性总吨位的值
     */
    public double getTonCount(){
        return tonCount;
    }

    /**
     * 设置属性净吨位
     * @param netTonCount 待设置的属性净吨位的值
     */
    public void setNetTonCount(double netTonCount){
        this.netTonCount = netTonCount;
    }

    /**
     * 获取属性净吨位
     * @return 属性净吨位的值
     */
    public double getNetTonCount(){
        return netTonCount;
    }

    /**
     * 设置属性功率
     * @param horsePower 待设置的属性功率的值
     */
    public void setHorsePower(double horsePower){
        this.horsePower = horsePower;
    }

    /**
     * 获取属性功率
     * @return 属性功率的值
     */
    public double getHorsePower(){
        return horsePower;
    }

    /**
     * 设置属性功率单位
     * @param powerUnit 待设置的属性功率单位的值
     */
    public void setPowerUnit(String powerUnit){
        this.powerUnit = StringUtils.rightTrim(powerUnit);
    }

    /**
     * 获取属性功率单位
     * @return 属性功率单位的值
     */
    public String getPowerUnit(){
        return powerUnit;
    }

    /**
     * 设置属性客位
     * @param seatCount 待设置的属性客位的值
     */
    public void setSeatCount(int seatCount){
        this.seatCount = seatCount;
    }

    /**
     * 获取属性客位
     * @return 属性客位的值
     */
    public int getSeatCount(){
        return seatCount;
    }

    /**
     * 设置属性载重吨
     * @param loadTon 待设置的属性载重吨的值
     */
    public void setLoadTon(double loadTon){
        this.loadTon = loadTon;
    }

    /**
     * 获取属性载重吨
     * @return 属性载重吨的值
     */
    public double getLoadTon(){
        return loadTon;
    }

    /**
     * 设置属性总长
     * @param shipLength 待设置的属性总长的值
     */
    public void setShipLength(double shipLength){
        this.shipLength = shipLength;
    }

    /**
     * 获取属性总长
     * @return 属性总长的值
     */
    public double getShipLength(){
        return shipLength;
    }

    /**
     * 设置属性型宽
     * @param shipWidth 待设置的属性型宽的值
     */
    public void setShipWidth(double shipWidth){
        this.shipWidth = shipWidth;
    }

    /**
     * 获取属性型宽
     * @return 属性型宽的值
     */
    public double getShipWidth(){
        return shipWidth;
    }

    /**
     * 设置属性型深
     * @param shipDepth 待设置的属性型深的值
     */
    public void setShipDepth(double shipDepth){
        this.shipDepth = shipDepth;
    }

    /**
     * 获取属性型深
     * @return 属性型深的值
     */
    public double getShipDepth(){
        return shipDepth;
    }

    /**
     * 设置属性船舶价值
     * @param shipValue 待设置的属性船舶价值的值
     */
    public void setShipValue(double shipValue){
        this.shipValue = shipValue;
    }

    /**
     * 获取属性船舶价值
     * @return 属性船舶价值的值
     */
    public double getShipValue(){
        return shipValue;
    }

    /**
     * 设置属性船舶证书上载明的所有人
     * @param certificateOwner 待设置的属性船舶证书上载明的所有人的值
     */
    public void setCertificateOwner(String certificateOwner){
        this.certificateOwner = StringUtils.rightTrim(certificateOwner);
    }

    /**
     * 获取属性船舶证书上载明的所有人
     * @return 属性船舶证书上载明的所有人的值
     */
    public String getCertificateOwner(){
        return certificateOwner;
    }

    /**
     * 设置属性实际所有人
     * @param actualOwner 待设置的属性实际所有人的值
     */
    public void setActualOwner(String actualOwner){
        this.actualOwner = StringUtils.rightTrim(actualOwner);
    }

    /**
     * 获取属性实际所有人
     * @return 属性实际所有人的值
     */
    public String getActualOwner(){
        return actualOwner;
    }

    /**
     * 设置属性经营者名称
     * @param proprietorName 待设置的属性经营者名称的值
     */
    public void setProprietorName(String proprietorName){
        this.proprietorName = StringUtils.rightTrim(proprietorName);
    }

    /**
     * 获取属性经营者名称
     * @return 属性经营者名称的值
     */
    public String getProprietorName(){
        return proprietorName;
    }

    /**
     * 设置属性经营方式
     * @param manageType 待设置的属性经营方式的值
     */
    public void setManageType(String manageType){
        this.manageType = StringUtils.rightTrim(manageType);
    }

    /**
     * 获取属性经营方式
     * @return 属性经营方式的值
     */
    public String getManageType(){
        return manageType;
    }

    /**
     * 设置属性经营水路运输许可证书有效起期
     * @param manageStartDate 待设置的属性经营水路运输许可证书有效起期的值
     */
    public void setManageStartDate(DateTime manageStartDate){
        this.manageStartDate = manageStartDate;
    }

    /**
     * 获取属性经营水路运输许可证书有效起期
     * @return 属性经营水路运输许可证书有效起期的值
     */
    public DateTime getManageStartDate(){
        return manageStartDate;
    }

    /**
     * 设置属性经营水路运输许可证书有效止期
     * @param manageEndDate 待设置的属性经营水路运输许可证书有效止期的值
     */
    public void setManageEndDate(DateTime manageEndDate){
        this.manageEndDate = manageEndDate;
    }

    /**
     * 获取属性经营水路运输许可证书有效止期
     * @return 属性经营水路运输许可证书有效止期的值
     */
    public DateTime getManageEndDate(){
        return manageEndDate;
    }

    /**
     * 设置属性船舶检验证书有效起期
     * @param checkStartDate 待设置的属性船舶检验证书有效起期的值
     */
    public void setCheckStartDate(DateTime checkStartDate){
        this.checkStartDate = checkStartDate;
    }

    /**
     * 获取属性船舶检验证书有效起期
     * @return 属性船舶检验证书有效起期的值
     */
    public DateTime getCheckStartDate(){
        return checkStartDate;
    }

    /**
     * 设置属性船舶检验证书有效止期
     * @param checkEndDate 待设置的属性船舶检验证书有效止期的值
     */
    public void setCheckEndDate(DateTime checkEndDate){
        this.checkEndDate = checkEndDate;
    }

    /**
     * 获取属性船舶检验证书有效止期
     * @return 属性船舶检验证书有效止期的值
     */
    public DateTime getCheckEndDate(){
        return checkEndDate;
    }

    /**
     * 设置属性船舶债务额
     * @param debtAmount 待设置的属性船舶债务额的值
     */
    public void setDebtAmount(int debtAmount){
        this.debtAmount = debtAmount;
    }

    /**
     * 获取属性船舶债务额
     * @return 属性船舶债务额的值
     */
    public int getDebtAmount(){
        return debtAmount;
    }

    /**
     * 设置属性抵押标志(0/1)
     * @param pledge 待设置的属性抵押标志(0/1)的值
     */
    public void setPledge(String pledge){
        this.pledge = StringUtils.rightTrim(pledge);
    }

    /**
     * 获取属性抵押标志(0/1)
     * @return 属性抵押标志(0/1)的值
     */
    public String getPledge(){
        return pledge;
    }

    /**
     * 设置属性船舶改建单位
     * @param rebuildCompany 待设置的属性船舶改建单位的值
     */
    public void setRebuildCompany(String rebuildCompany){
        this.rebuildCompany = StringUtils.rightTrim(rebuildCompany);
    }

    /**
     * 获取属性船舶改建单位
     * @return 属性船舶改建单位的值
     */
    public String getRebuildCompany(){
        return rebuildCompany;
    }

    /**
     * 设置属性船舶改建时间
     * @param rebuildDate 待设置的属性船舶改建时间的值
     */
    public void setRebuildDate(DateTime rebuildDate){
        this.rebuildDate = rebuildDate;
    }

    /**
     * 获取属性船舶改建时间
     * @return 属性船舶改建时间的值
     */
    public DateTime getRebuildDate(){
        return rebuildDate;
    }

    /**
     * 设置属性新的船舶代码
     * @param newShipCode 待设置的属性新的船舶代码的值
     */
    public void setNewShipCode(String newShipCode){
        this.newShipCode = StringUtils.rightTrim(newShipCode);
    }

    /**
     * 获取属性新的船舶代码
     * @return 属性新的船舶代码的值
     */
    public String getNewShipCode(){
        return newShipCode;
    }

    /**
     * 设置属性效力状态
     * @param validStatus 待设置的属性效力状态的值
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * 获取属性效力状态
     * @return 属性效力状态的值
     */
    public String getValidStatus(){
        return validStatus;
    }

    /**
     * 设置属性标志字段
     * @param flag 待设置的属性标志字段的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性标志字段
     * @return 属性标志字段的值
     */
    public String getFlag(){
        return flag;
    }
}
