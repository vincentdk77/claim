package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpLclaimFittings�����ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLclaimFittingsDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����RegistNo */
    private String registNo = "";
    /** ����LossItemCode */
    private String lossItemCode = "";
    /** ����ModelCode */
    private String modelCode = "";
    /** ����LicenseNo */
    private String licenseNo = "";
    /** ����ResultType */
    private String resultType = "";
    /** ����SerialNo */
    private long serialNo = 0L;
    /** ����KindCode */
    private String kindCode = "";
    /** ����KindName */
    private String kindName = "";
    /** ����FittingCode */
    private String fittingCode = "";
    /** ����FittingName */
    private String fittingName = "";
    /** ����OriginalID */
    private String originalID = "";
    /** ����IndId */
    private int indId = 0;
    /** ����Sys4SPrice */
    private double sys4SPrice = 0D;
    /** ����SysMarketPrice */
    private double sysMarketPrice = 0D;
    /** ����SysmatchPrice */
    private double sysmatchPrice = 0D;
    /** ����Native4SPrice */
    private double native4SPrice = 0D;
    /** ����NativeMarketPrice */
    private double nativeMarketPrice = 0D;
    /** ����NativeMatchPrice */
    private double nativeMatchPrice = 0D;
    /** ����MaxQuantity */
    private long maxQuantity = 0L;
    /** ����CertaSaved */
    private String certaSaved = "";
    /** ����CertaPrice */
    private double certaPrice = 0D;
    /** ����CertaQuantity */
    private long certaQuantity = 0L;
    /** ����VerifyPrice */
    private double verifyPrice = 0D;
    /** ����Remark */
    private String remark = "";
    /** ����Flag */
    private String flag = "";
    /** ���� ����ϵͳ���ΨһID */
    private String PartId = "";
    /** ���� �����ԭ������*/
    private String OriginalName = "";
    /** ���� �����λ���� */
    private String PartGroupCode = "";
    /** ���� �����λ����*/
    private String PartGroupName = "";
    /** ���� �������С��*/
    private double SumPrice = 0D;
    /** ���� �Զ���������*/
    private String SelfConfigFlag  = "";
    /** ���� �����۸�*/
    private double RepairSitePrice  = 0D;
    /** ���� �۸񷽰�����*/
    private String ChgCompSetCode  = "";
    /** ���� �۸񷽰�����*/
    private String ChgCompSetName  = "";
    /** ���� �۸񷽰�ϵͳ�۸�*/
    private double ChgRefPrice = 0D;
    /** ���� �۸񷽰����ؼ۸�*/
    private double ChgLocPrice = 0D;
    /** ���� ��ֵ*/
    private double Remnant = 0D;
    /** ���� ״̬*/
    private String Status = "";
    
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLclaimFittingsDtoBase����
     */
    public PrpLclaimFittingsDtoBase(){
    }

    /**
     * ��������RegistNo
     * @param registNo �����õ�����RegistNo��ֵ
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * ��ȡ����RegistNo
     * @return ����RegistNo��ֵ
     */
    public String getRegistNo(){
        return registNo;
    }

    /**
     * ��������LossItemCode
     * @param lossItemCode �����õ�����LossItemCode��ֵ
     */
    public void setLossItemCode(String lossItemCode){
        this.lossItemCode = StringUtils.rightTrim(lossItemCode);
    }

    /**
     * ��ȡ����LossItemCode
     * @return ����LossItemCode��ֵ
     */
    public String getLossItemCode(){
        return lossItemCode;
    }

    /**
     * ��������ModelCode
     * @param modelCode �����õ�����ModelCode��ֵ
     */
    public void setModelCode(String modelCode){
        this.modelCode = StringUtils.rightTrim(modelCode);
    }

    /**
     * ��ȡ����ModelCode
     * @return ����ModelCode��ֵ
     */
    public String getModelCode(){
        return modelCode;
    }

    /**
     * ��������LicenseNo
     * @param licenseNo �����õ�����LicenseNo��ֵ
     */
    public void setLicenseNo(String licenseNo){
        this.licenseNo = StringUtils.rightTrim(licenseNo);
    }

    /**
     * ��ȡ����LicenseNo
     * @return ����LicenseNo��ֵ
     */
    public String getLicenseNo(){
        return licenseNo;
    }

    /**
     * ��������ResultType
     * @param resultType �����õ�����ResultType��ֵ
     */
    public void setResultType(String resultType){
        this.resultType = StringUtils.rightTrim(resultType);
    }

    /**
     * ��ȡ����ResultType
     * @return ����ResultType��ֵ
     */
    public String getResultType(){
        return resultType;
    }

    /**
     * ��������SerialNo
     * @param serialNo �����õ�����SerialNo��ֵ
     */
    public void setSerialNo(long serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ����SerialNo
     * @return ����SerialNo��ֵ
     */
    public long getSerialNo(){
        return serialNo;
    }

    /**
     * ��������KindCode
     * @param kindCode �����õ�����KindCode��ֵ
     */
    public void setKindCode(String kindCode){
        this.kindCode = StringUtils.rightTrim(kindCode);
    }

    /**
     * ��ȡ����KindCode
     * @return ����KindCode��ֵ
     */
    public String getKindCode(){
        return kindCode;
    }

    /**
     * ��������KindName
     * @param kindName �����õ�����KindName��ֵ
     */
    public void setKindName(String kindName){
        this.kindName = StringUtils.rightTrim(kindName);
    }

    /**
     * ��ȡ����KindName
     * @return ����KindName��ֵ
     */
    public String getKindName(){
        return kindName;
    }

    /**
     * ��������FittingCode
     * @param fittingCode �����õ�����FittingCode��ֵ
     */
    public void setFittingCode(String fittingCode){
        this.fittingCode = StringUtils.rightTrim(fittingCode);
    }

    /**
     * ��ȡ����FittingCode
     * @return ����FittingCode��ֵ
     */
    public String getFittingCode(){
        return fittingCode;
    }

    /**
     * ��������FittingName
     * @param fittingName �����õ�����FittingName��ֵ
     */
    public void setFittingName(String fittingName){
        this.fittingName = StringUtils.rightTrim(fittingName);
    }

    /**
     * ��ȡ����FittingName
     * @return ����FittingName��ֵ
     */
    public String getFittingName(){
        return fittingName;
    }

    /**
     * ��������OriginalID
     * @param originalID �����õ�����OriginalID��ֵ
     */
    public void setOriginalID(String originalID){
        this.originalID = StringUtils.rightTrim(originalID);
    }

    /**
     * ��ȡ����OriginalID
     * @return ����OriginalID��ֵ
     */
    public String getOriginalID(){
        return originalID;
    }

    /**
     * ��������IndId
     * @param indId �����õ�����IndId��ֵ
     */
    public void setIndId(int indId){
        this.indId = indId;
    }

    /**
     * ��ȡ����IndId
     * @return ����IndId��ֵ
     */
    public int getIndId(){
        return indId;
    }

    /**
     * ��������Sys4SPrice
     * @param sys4SPrice �����õ�����Sys4SPrice��ֵ
     */
    public void setSys4SPrice(double sys4SPrice){
        this.sys4SPrice = sys4SPrice;
    }

    /**
     * ��ȡ����Sys4SPrice
     * @return ����Sys4SPrice��ֵ
     */
    public double getSys4SPrice(){
        return sys4SPrice;
    }

    /**
     * ��������SysMarketPrice
     * @param sysMarketPrice �����õ�����SysMarketPrice��ֵ
     */
    public void setSysMarketPrice(double sysMarketPrice){
        this.sysMarketPrice = sysMarketPrice;
    }

    /**
     * ��ȡ����SysMarketPrice
     * @return ����SysMarketPrice��ֵ
     */
    public double getSysMarketPrice(){
        return sysMarketPrice;
    }

    /**
     * ��������SysmatchPrice
     * @param sysmatchPrice �����õ�����SysmatchPrice��ֵ
     */
    public void setSysmatchPrice(double sysmatchPrice){
        this.sysmatchPrice = sysmatchPrice;
    }

    /**
     * ��ȡ����SysmatchPrice
     * @return ����SysmatchPrice��ֵ
     */
    public double getSysmatchPrice(){
        return sysmatchPrice;
    }

    /**
     * ��������Native4SPrice
     * @param native4SPrice �����õ�����Native4SPrice��ֵ
     */
    public void setNative4SPrice(double native4SPrice){
        this.native4SPrice = native4SPrice;
    }

    /**
     * ��ȡ����Native4SPrice
     * @return ����Native4SPrice��ֵ
     */
    public double getNative4SPrice(){
        return native4SPrice;
    }

    /**
     * ��������NativeMarketPrice
     * @param nativeMarketPrice �����õ�����NativeMarketPrice��ֵ
     */
    public void setNativeMarketPrice(double nativeMarketPrice){
        this.nativeMarketPrice = nativeMarketPrice;
    }

    /**
     * ��ȡ����NativeMarketPrice
     * @return ����NativeMarketPrice��ֵ
     */
    public double getNativeMarketPrice(){
        return nativeMarketPrice;
    }

    /**
     * ��������NativeMatchPrice
     * @param nativeMatchPrice �����õ�����NativeMatchPrice��ֵ
     */
    public void setNativeMatchPrice(double nativeMatchPrice){
        this.nativeMatchPrice = nativeMatchPrice;
    }

    /**
     * ��ȡ����NativeMatchPrice
     * @return ����NativeMatchPrice��ֵ
     */
    public double getNativeMatchPrice(){
        return nativeMatchPrice;
    }

    /**
     * ��������MaxQuantity
     * @param maxQuantity �����õ�����MaxQuantity��ֵ
     */
    public void setMaxQuantity(long maxQuantity){
        this.maxQuantity = maxQuantity;
    }

    /**
     * ��ȡ����MaxQuantity
     * @return ����MaxQuantity��ֵ
     */
    public long getMaxQuantity(){
        return maxQuantity;
    }

    /**
     * ��������CertaSaved
     * @param certaSaved �����õ�����CertaSaved��ֵ
     */
    public void setCertaSaved(String certaSaved){
        this.certaSaved = StringUtils.rightTrim(certaSaved);
    }

    /**
     * ��ȡ����CertaSaved
     * @return ����CertaSaved��ֵ
     */
    public String getCertaSaved(){
        return certaSaved;
    }

    /**
     * ��������CertaPrice
     * @param certaPrice �����õ�����CertaPrice��ֵ
     */
    public void setCertaPrice(double certaPrice){
        this.certaPrice = certaPrice;
    }

    /**
     * ��ȡ����CertaPrice
     * @return ����CertaPrice��ֵ
     */
    public double getCertaPrice(){
        return certaPrice;
    }

    /**
     * ��������CertaQuantity
     * @param certaQuantity �����õ�����CertaQuantity��ֵ
     */
    public void setCertaQuantity(long certaQuantity){
        this.certaQuantity = certaQuantity;
    }

    /**
     * ��ȡ����CertaQuantity
     * @return ����CertaQuantity��ֵ
     */
    public long getCertaQuantity(){
        return certaQuantity;
    }

    /**
     * ��������VerifyPrice
     * @param verifyPrice �����õ�����VerifyPrice��ֵ
     */
    public void setVerifyPrice(double verifyPrice){
        this.verifyPrice = verifyPrice;
    }

    /**
     * ��ȡ����VerifyPrice
     * @return ����VerifyPrice��ֵ
     */
    public double getVerifyPrice(){
        return verifyPrice;
    }

    /**
     * ��������Remark
     * @param remark �����õ�����Remark��ֵ
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * ��ȡ����Remark
     * @return ����Remark��ֵ
     */
    public String getRemark(){
        return remark;
    }

    /**
     * ��������Flag
     * @param flag �����õ�����Flag��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ����Flag
     * @return ����Flag��ֵ
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
