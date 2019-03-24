package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLclaimFittings的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLclaimFittingsDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性RegistNo */
    private String registNo = "";
    /** 属性LossItemCode */
    private String lossItemCode = "";
    /** 属性ModelCode */
    private String modelCode = "";
    /** 属性LicenseNo */
    private String licenseNo = "";
    /** 属性ResultType */
    private String resultType = "";
    /** 属性SerialNo */
    private long serialNo = 0L;
    /** 属性KindCode */
    private String kindCode = "";
    /** 属性KindName */
    private String kindName = "";
    /** 属性FittingCode */
    private String fittingCode = "";
    /** 属性FittingName */
    private String fittingName = "";
    /** 属性OriginalID */
    private String originalID = "";
    /** 属性IndId */
    private int indId = 0;
    /** 属性Sys4SPrice */
    private double sys4SPrice = 0D;
    /** 属性SysMarketPrice */
    private double sysMarketPrice = 0D;
    /** 属性SysmatchPrice */
    private double sysmatchPrice = 0D;
    /** 属性Native4SPrice */
    private double native4SPrice = 0D;
    /** 属性NativeMarketPrice */
    private double nativeMarketPrice = 0D;
    /** 属性NativeMatchPrice */
    private double nativeMatchPrice = 0D;
    /** 属性MaxQuantity */
    private long maxQuantity = 0L;
    /** 属性CertaSaved */
    private String certaSaved = "";
    /** 属性CertaPrice */
    private double certaPrice = 0D;
    /** 属性CertaQuantity */
    private long certaQuantity = 0L;
    /** 属性VerifyPrice */
    private double verifyPrice = 0D;
    /** 属性Remark */
    private String remark = "";
    /** 属性Flag */
    private String flag = "";
    /** 属性 定损系统零件唯一ID */
    private String PartId = "";
    /** 属性 零配件原厂名称*/
    private String OriginalName = "";
    /** 属性 配件部位代码 */
    private String PartGroupCode = "";
    /** 属性 配件部位名称*/
    private String PartGroupName = "";
    /** 属性 换件金额小计*/
    private double SumPrice = 0D;
    /** 属性 自定义配件标记*/
    private String SelfConfigFlag  = "";
    /** 属性 修理厂价格*/
    private double RepairSitePrice  = 0D;
    /** 属性 价格方案编码*/
    private String ChgCompSetCode  = "";
    /** 属性 价格方案名称*/
    private String ChgCompSetName  = "";
    /** 属性 价格方案系统价格*/
    private double ChgRefPrice = 0D;
    /** 属性 价格方案本地价格*/
    private double ChgLocPrice = 0D;
    /** 属性 残值*/
    private double Remnant = 0D;
    /** 属性 状态*/
    private String Status = "";
    
    /**
     *  默认构造方法,构造一个默认的PrpLclaimFittingsDtoBase对象
     */
    public PrpLclaimFittingsDtoBase(){
    }

    /**
     * 设置属性RegistNo
     * @param registNo 待设置的属性RegistNo的值
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * 获取属性RegistNo
     * @return 属性RegistNo的值
     */
    public String getRegistNo(){
        return registNo;
    }

    /**
     * 设置属性LossItemCode
     * @param lossItemCode 待设置的属性LossItemCode的值
     */
    public void setLossItemCode(String lossItemCode){
        this.lossItemCode = StringUtils.rightTrim(lossItemCode);
    }

    /**
     * 获取属性LossItemCode
     * @return 属性LossItemCode的值
     */
    public String getLossItemCode(){
        return lossItemCode;
    }

    /**
     * 设置属性ModelCode
     * @param modelCode 待设置的属性ModelCode的值
     */
    public void setModelCode(String modelCode){
        this.modelCode = StringUtils.rightTrim(modelCode);
    }

    /**
     * 获取属性ModelCode
     * @return 属性ModelCode的值
     */
    public String getModelCode(){
        return modelCode;
    }

    /**
     * 设置属性LicenseNo
     * @param licenseNo 待设置的属性LicenseNo的值
     */
    public void setLicenseNo(String licenseNo){
        this.licenseNo = StringUtils.rightTrim(licenseNo);
    }

    /**
     * 获取属性LicenseNo
     * @return 属性LicenseNo的值
     */
    public String getLicenseNo(){
        return licenseNo;
    }

    /**
     * 设置属性ResultType
     * @param resultType 待设置的属性ResultType的值
     */
    public void setResultType(String resultType){
        this.resultType = StringUtils.rightTrim(resultType);
    }

    /**
     * 获取属性ResultType
     * @return 属性ResultType的值
     */
    public String getResultType(){
        return resultType;
    }

    /**
     * 设置属性SerialNo
     * @param serialNo 待设置的属性SerialNo的值
     */
    public void setSerialNo(long serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性SerialNo
     * @return 属性SerialNo的值
     */
    public long getSerialNo(){
        return serialNo;
    }

    /**
     * 设置属性KindCode
     * @param kindCode 待设置的属性KindCode的值
     */
    public void setKindCode(String kindCode){
        this.kindCode = StringUtils.rightTrim(kindCode);
    }

    /**
     * 获取属性KindCode
     * @return 属性KindCode的值
     */
    public String getKindCode(){
        return kindCode;
    }

    /**
     * 设置属性KindName
     * @param kindName 待设置的属性KindName的值
     */
    public void setKindName(String kindName){
        this.kindName = StringUtils.rightTrim(kindName);
    }

    /**
     * 获取属性KindName
     * @return 属性KindName的值
     */
    public String getKindName(){
        return kindName;
    }

    /**
     * 设置属性FittingCode
     * @param fittingCode 待设置的属性FittingCode的值
     */
    public void setFittingCode(String fittingCode){
        this.fittingCode = StringUtils.rightTrim(fittingCode);
    }

    /**
     * 获取属性FittingCode
     * @return 属性FittingCode的值
     */
    public String getFittingCode(){
        return fittingCode;
    }

    /**
     * 设置属性FittingName
     * @param fittingName 待设置的属性FittingName的值
     */
    public void setFittingName(String fittingName){
        this.fittingName = StringUtils.rightTrim(fittingName);
    }

    /**
     * 获取属性FittingName
     * @return 属性FittingName的值
     */
    public String getFittingName(){
        return fittingName;
    }

    /**
     * 设置属性OriginalID
     * @param originalID 待设置的属性OriginalID的值
     */
    public void setOriginalID(String originalID){
        this.originalID = StringUtils.rightTrim(originalID);
    }

    /**
     * 获取属性OriginalID
     * @return 属性OriginalID的值
     */
    public String getOriginalID(){
        return originalID;
    }

    /**
     * 设置属性IndId
     * @param indId 待设置的属性IndId的值
     */
    public void setIndId(int indId){
        this.indId = indId;
    }

    /**
     * 获取属性IndId
     * @return 属性IndId的值
     */
    public int getIndId(){
        return indId;
    }

    /**
     * 设置属性Sys4SPrice
     * @param sys4SPrice 待设置的属性Sys4SPrice的值
     */
    public void setSys4SPrice(double sys4SPrice){
        this.sys4SPrice = sys4SPrice;
    }

    /**
     * 获取属性Sys4SPrice
     * @return 属性Sys4SPrice的值
     */
    public double getSys4SPrice(){
        return sys4SPrice;
    }

    /**
     * 设置属性SysMarketPrice
     * @param sysMarketPrice 待设置的属性SysMarketPrice的值
     */
    public void setSysMarketPrice(double sysMarketPrice){
        this.sysMarketPrice = sysMarketPrice;
    }

    /**
     * 获取属性SysMarketPrice
     * @return 属性SysMarketPrice的值
     */
    public double getSysMarketPrice(){
        return sysMarketPrice;
    }

    /**
     * 设置属性SysmatchPrice
     * @param sysmatchPrice 待设置的属性SysmatchPrice的值
     */
    public void setSysmatchPrice(double sysmatchPrice){
        this.sysmatchPrice = sysmatchPrice;
    }

    /**
     * 获取属性SysmatchPrice
     * @return 属性SysmatchPrice的值
     */
    public double getSysmatchPrice(){
        return sysmatchPrice;
    }

    /**
     * 设置属性Native4SPrice
     * @param native4SPrice 待设置的属性Native4SPrice的值
     */
    public void setNative4SPrice(double native4SPrice){
        this.native4SPrice = native4SPrice;
    }

    /**
     * 获取属性Native4SPrice
     * @return 属性Native4SPrice的值
     */
    public double getNative4SPrice(){
        return native4SPrice;
    }

    /**
     * 设置属性NativeMarketPrice
     * @param nativeMarketPrice 待设置的属性NativeMarketPrice的值
     */
    public void setNativeMarketPrice(double nativeMarketPrice){
        this.nativeMarketPrice = nativeMarketPrice;
    }

    /**
     * 获取属性NativeMarketPrice
     * @return 属性NativeMarketPrice的值
     */
    public double getNativeMarketPrice(){
        return nativeMarketPrice;
    }

    /**
     * 设置属性NativeMatchPrice
     * @param nativeMatchPrice 待设置的属性NativeMatchPrice的值
     */
    public void setNativeMatchPrice(double nativeMatchPrice){
        this.nativeMatchPrice = nativeMatchPrice;
    }

    /**
     * 获取属性NativeMatchPrice
     * @return 属性NativeMatchPrice的值
     */
    public double getNativeMatchPrice(){
        return nativeMatchPrice;
    }

    /**
     * 设置属性MaxQuantity
     * @param maxQuantity 待设置的属性MaxQuantity的值
     */
    public void setMaxQuantity(long maxQuantity){
        this.maxQuantity = maxQuantity;
    }

    /**
     * 获取属性MaxQuantity
     * @return 属性MaxQuantity的值
     */
    public long getMaxQuantity(){
        return maxQuantity;
    }

    /**
     * 设置属性CertaSaved
     * @param certaSaved 待设置的属性CertaSaved的值
     */
    public void setCertaSaved(String certaSaved){
        this.certaSaved = StringUtils.rightTrim(certaSaved);
    }

    /**
     * 获取属性CertaSaved
     * @return 属性CertaSaved的值
     */
    public String getCertaSaved(){
        return certaSaved;
    }

    /**
     * 设置属性CertaPrice
     * @param certaPrice 待设置的属性CertaPrice的值
     */
    public void setCertaPrice(double certaPrice){
        this.certaPrice = certaPrice;
    }

    /**
     * 获取属性CertaPrice
     * @return 属性CertaPrice的值
     */
    public double getCertaPrice(){
        return certaPrice;
    }

    /**
     * 设置属性CertaQuantity
     * @param certaQuantity 待设置的属性CertaQuantity的值
     */
    public void setCertaQuantity(long certaQuantity){
        this.certaQuantity = certaQuantity;
    }

    /**
     * 获取属性CertaQuantity
     * @return 属性CertaQuantity的值
     */
    public long getCertaQuantity(){
        return certaQuantity;
    }

    /**
     * 设置属性VerifyPrice
     * @param verifyPrice 待设置的属性VerifyPrice的值
     */
    public void setVerifyPrice(double verifyPrice){
        this.verifyPrice = verifyPrice;
    }

    /**
     * 获取属性VerifyPrice
     * @return 属性VerifyPrice的值
     */
    public double getVerifyPrice(){
        return verifyPrice;
    }

    /**
     * 设置属性Remark
     * @param remark 待设置的属性Remark的值
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * 获取属性Remark
     * @return 属性Remark的值
     */
    public String getRemark(){
        return remark;
    }

    /**
     * 设置属性Flag
     * @param flag 待设置的属性Flag的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性Flag
     * @return 属性Flag的值
     */
    public String getFlag(){
        return flag;
    }

	public String getPartId() {
		return PartId;
	}

	public void setPartId(String partId) {
		PartId = partId;
	}

	public String getOriginalName() {
		return OriginalName;
	}

	public void setOriginalName(String originalName) {
		OriginalName = originalName;
	}

	public String getPartGroupCode() {
		return PartGroupCode;
	}

	public void setPartGroupCode(String partGroupCode) {
		PartGroupCode = partGroupCode;
	}

	public String getSelfConfigFlag() {
		return SelfConfigFlag;
	}

	public void setSelfConfigFlag(String selfConfigFlag) {
		SelfConfigFlag = selfConfigFlag;
	}

	public String getChgCompSetCode() {
		return ChgCompSetCode;
	}

	public void setChgCompSetCode(String chgCompSetCode) {
		ChgCompSetCode = chgCompSetCode;
	}

	public String getChgCompSetName() {
		return ChgCompSetName;
	}

	public void setChgCompSetName(String chgCompSetName) {
		ChgCompSetName = chgCompSetName;
	}

	public String getStatus() {
		return Status;
	}

	public String getPartGroupName() {
		return PartGroupName;
	}

	public void setPartGroupName(String partGroupName) {
		PartGroupName = partGroupName;
	}

	public double getSumPrice() {
		return SumPrice;
	}

	public void setSumPrice(double sumPrice) {
		SumPrice = sumPrice;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public double getRepairSitePrice() {
		return RepairSitePrice;
	}

	public void setRepairSitePrice(double repairSitePrice) {
		RepairSitePrice = repairSitePrice;
	}

	public double getChgRefPrice() {
		return ChgRefPrice;
	}

	public void setChgRefPrice(double chgRefPrice) {
		ChgRefPrice = chgRefPrice;
	}

	public double getChgLocPrice() {
		return ChgLocPrice;
	}

	public void setChgLocPrice(double chgLocPrice) {
		ChgLocPrice = chgLocPrice;
	}

	public double getRemnant() {
		return Remnant;
	}

	public void setRemnant(double remnant) {
		Remnant = remnant;
	}
}
