package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PRPCMAINCARGO-货运险保单信息的数据传输对象基类<br>
 * 创建于 2005-06-02 10:27:43.000<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpCmainCargoDtoBase implements Serializable{
    /** 属性保单号码 */
    private String policyNo = "";
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性风险类别 */
    private String riskKind = "";
    /** 属性CONVEYDATEDESC */
    private String conveyDateDesc = "";
    /** 属性价格条件 */
    private String priceCondition = "";
    /** 属性提单号 */
    private String ladingNo = "";
    /** 属性发票号 */
    private String invoiceNo = "";
    /** 属性发票金额币别 */
    private String invoiceCurrency = "";
    /** 属性发票金额 */
    private double invoiceAmount = 0d;
    /** 属性加成比例 */
    private double plusRate = 0d;
    /** 属性信用证号 */
    private String creditNo = "";
    /** 属性起运通知书编号 */
    private String shipNoteNo = "";
    /** 属性合同号 */
    private String bargainNo = "";
    /** 属性装载运输工具 */
    private String conveyance = "";
    /** 属性运具名称 */
    private String bLName = "";
    /** 属性货票运单号 */
    private String carryBillNo = "";
    /** 属性转运工具 */
    private String transferConveyance = "";
    /** 属性运具牌号 */
    private String bLNo = "";
    /** 属性航次 */
    private String voyageNo = "";
    /** 属性预留信息 */
    private String preserveInfo = "";
    /** 属性吨位数 */
    private double tonCount = 0d;
    /** 属性起始地编码 */
    private String startSiteCode = "";
    /** 属性起始地名称 */
    private String startSiteName = "";
    /** 属性中转地编码 */
    private String viaSiteCode = "";
    /** 属性中转地名称 */
    private String viaSiteName = "";
    /** 属性转载地名称 */
    private String reshipSiteName = "";
    /** 属性终止地编码 */
    private String endSiteCode = "";
    /** 属性终止地名称 */
    private String endSiteName = "";
    /** 属性具体终止地名称 */
    private String endDetailName = "";
    /** 属性国外检验代理人代码 */
    private String checkAgentCode = "";
    /** 属性赔款偿付地点 */
    private String claimSite = "";
    /** 属性过户银行 */
    private String transferBank = "";
    /** 属性保单正本份数 */
    private double originalCount = 0d;
    /** 属性备注 */
    private String remark = "";
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpCmainCargoDtoBase对象
     */
    public PrpCmainCargoDtoBase(){
    }

    /**
     * 设置属性保单号码
     * @param policyNo 待设置的属性保单号码的值
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * 获取属性保单号码
     * @return 属性保单号码的值
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * 设置属性险种代码
     * @param riskCode 待设置的属性险种代码的值
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * 获取属性险种代码
     * @return 属性险种代码的值
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * 设置属性风险类别
     * @param riskKind 待设置的属性风险类别的值
     */
    public void setRiskKind(String riskKind){
        this.riskKind = StringUtils.rightTrim(riskKind);
    }

    /**
     * 获取属性风险类别
     * @return 属性风险类别的值
     */
    public String getRiskKind(){
        return riskKind;
    }

    /**
     * 设置属性CONVEYDATEDESC
     * @param conveyDateDesc 待设置的属性CONVEYDATEDESC的值
     */
    public void setConveyDateDesc(String conveyDateDesc){
        this.conveyDateDesc = StringUtils.rightTrim(conveyDateDesc);
    }

    /**
     * 获取属性CONVEYDATEDESC
     * @return 属性CONVEYDATEDESC的值
     */
    public String getConveyDateDesc(){
        return conveyDateDesc;
    }

    /**
     * 设置属性价格条件
     * @param priceCondition 待设置的属性价格条件的值
     */
    public void setPriceCondition(String priceCondition){
        this.priceCondition = StringUtils.rightTrim(priceCondition);
    }

    /**
     * 获取属性价格条件
     * @return 属性价格条件的值
     */
    public String getPriceCondition(){
        return priceCondition;
    }

    /**
     * 设置属性提单号
     * @param ladingNo 待设置的属性提单号的值
     */
    public void setLadingNo(String ladingNo){
        this.ladingNo = StringUtils.rightTrim(ladingNo);
    }

    /**
     * 获取属性提单号
     * @return 属性提单号的值
     */
    public String getLadingNo(){
        return ladingNo;
    }

    /**
     * 设置属性发票号
     * @param invoiceNo 待设置的属性发票号的值
     */
    public void setInvoiceNo(String invoiceNo){
        this.invoiceNo = StringUtils.rightTrim(invoiceNo);
    }

    /**
     * 获取属性发票号
     * @return 属性发票号的值
     */
    public String getInvoiceNo(){
        return invoiceNo;
    }

    /**
     * 设置属性发票金额币别
     * @param invoiceCurrency 待设置的属性发票金额币别的值
     */
    public void setInvoiceCurrency(String invoiceCurrency){
        this.invoiceCurrency = StringUtils.rightTrim(invoiceCurrency);
    }

    /**
     * 获取属性发票金额币别
     * @return 属性发票金额币别的值
     */
    public String getInvoiceCurrency(){
        return invoiceCurrency;
    }

    /**
     * 设置属性发票金额
     * @param invoiceAmount 待设置的属性发票金额的值
     */
    public void setInvoiceAmount(double invoiceAmount){
        this.invoiceAmount = invoiceAmount;
    }

    /**
     * 获取属性发票金额
     * @return 属性发票金额的值
     */
    public double getInvoiceAmount(){
        return invoiceAmount;
    }

    /**
     * 设置属性加成比例
     * @param plusRate 待设置的属性加成比例的值
     */
    public void setPlusRate(double plusRate){
        this.plusRate = plusRate;
    }

    /**
     * 获取属性加成比例
     * @return 属性加成比例的值
     */
    public double getPlusRate(){
        return plusRate;
    }

    /**
     * 设置属性信用证号
     * @param creditNo 待设置的属性信用证号的值
     */
    public void setCreditNo(String creditNo){
        this.creditNo = StringUtils.rightTrim(creditNo);
    }

    /**
     * 获取属性信用证号
     * @return 属性信用证号的值
     */
    public String getCreditNo(){
        return creditNo;
    }

    /**
     * 设置属性起运通知书编号
     * @param shipNoteNo 待设置的属性起运通知书编号的值
     */
    public void setShipNoteNo(String shipNoteNo){
        this.shipNoteNo = StringUtils.rightTrim(shipNoteNo);
    }

    /**
     * 获取属性起运通知书编号
     * @return 属性起运通知书编号的值
     */
    public String getShipNoteNo(){
        return shipNoteNo;
    }

    /**
     * 设置属性合同号
     * @param bargainNo 待设置的属性合同号的值
     */
    public void setBargainNo(String bargainNo){
        this.bargainNo = StringUtils.rightTrim(bargainNo);
    }

    /**
     * 获取属性合同号
     * @return 属性合同号的值
     */
    public String getBargainNo(){
        return bargainNo;
    }

    /**
     * 设置属性装载运输工具
     * @param conveyance 待设置的属性装载运输工具的值
     */
    public void setConveyance(String conveyance){
        this.conveyance = StringUtils.rightTrim(conveyance);
    }

    /**
     * 获取属性装载运输工具
     * @return 属性装载运输工具的值
     */
    public String getConveyance(){
        return conveyance;
    }

    /**
     * 设置属性运具名称
     * @param bLName 待设置的属性运具名称的值
     */
    public void setBLName(String bLName){
        this.bLName = StringUtils.rightTrim(bLName);
    }

    /**
     * 获取属性运具名称
     * @return 属性运具名称的值
     */
    public String getBLName(){
        return bLName;
    }

    /**
     * 设置属性货票运单号
     * @param carryBillNo 待设置的属性货票运单号的值
     */
    public void setCarryBillNo(String carryBillNo){
        this.carryBillNo = StringUtils.rightTrim(carryBillNo);
    }

    /**
     * 获取属性货票运单号
     * @return 属性货票运单号的值
     */
    public String getCarryBillNo(){
        return carryBillNo;
    }

    /**
     * 设置属性转运工具
     * @param transferConveyance 待设置的属性转运工具的值
     */
    public void setTransferConveyance(String transferConveyance){
        this.transferConveyance = StringUtils.rightTrim(transferConveyance);
    }

    /**
     * 获取属性转运工具
     * @return 属性转运工具的值
     */
    public String getTransferConveyance(){
        return transferConveyance;
    }

    /**
     * 设置属性运具牌号
     * @param bLNo 待设置的属性运具牌号的值
     */
    public void setBLNo(String bLNo){
        this.bLNo = StringUtils.rightTrim(bLNo);
    }

    /**
     * 获取属性运具牌号
     * @return 属性运具牌号的值
     */
    public String getBLNo(){
        return bLNo;
    }

    /**
     * 设置属性航次
     * @param voyageNo 待设置的属性航次的值
     */
    public void setVoyageNo(String voyageNo){
        this.voyageNo = StringUtils.rightTrim(voyageNo);
    }

    /**
     * 获取属性航次
     * @return 属性航次的值
     */
    public String getVoyageNo(){
        return voyageNo;
    }

    /**
     * 设置属性预留信息
     * @param preserveInfo 待设置的属性预留信息的值
     */
    public void setPreserveInfo(String preserveInfo){
        this.preserveInfo = StringUtils.rightTrim(preserveInfo);
    }

    /**
     * 获取属性预留信息
     * @return 属性预留信息的值
     */
    public String getPreserveInfo(){
        return preserveInfo;
    }

    /**
     * 设置属性吨位数
     * @param tonCount 待设置的属性吨位数的值
     */
    public void setTonCount(double tonCount){
        this.tonCount = tonCount;
    }

    /**
     * 获取属性吨位数
     * @return 属性吨位数的值
     */
    public double getTonCount(){
        return tonCount;
    }

    /**
     * 设置属性起始地编码
     * @param startSiteCode 待设置的属性起始地编码的值
     */
    public void setStartSiteCode(String startSiteCode){
        this.startSiteCode = StringUtils.rightTrim(startSiteCode);
    }

    /**
     * 获取属性起始地编码
     * @return 属性起始地编码的值
     */
    public String getStartSiteCode(){
        return startSiteCode;
    }

    /**
     * 设置属性起始地名称
     * @param startSiteName 待设置的属性起始地名称的值
     */
    public void setStartSiteName(String startSiteName){
        this.startSiteName = StringUtils.rightTrim(startSiteName);
    }

    /**
     * 获取属性起始地名称
     * @return 属性起始地名称的值
     */
    public String getStartSiteName(){
        return startSiteName;
    }

    /**
     * 设置属性中转地编码
     * @param viaSiteCode 待设置的属性中转地编码的值
     */
    public void setViaSiteCode(String viaSiteCode){
        this.viaSiteCode = StringUtils.rightTrim(viaSiteCode);
    }

    /**
     * 获取属性中转地编码
     * @return 属性中转地编码的值
     */
    public String getViaSiteCode(){
        return viaSiteCode;
    }

    /**
     * 设置属性中转地名称
     * @param viaSiteName 待设置的属性中转地名称的值
     */
    public void setViaSiteName(String viaSiteName){
        this.viaSiteName = StringUtils.rightTrim(viaSiteName);
    }

    /**
     * 获取属性中转地名称
     * @return 属性中转地名称的值
     */
    public String getViaSiteName(){
        return viaSiteName;
    }

    /**
     * 设置属性转载地名称
     * @param reshipSiteName 待设置的属性转载地名称的值
     */
    public void setReshipSiteName(String reshipSiteName){
        this.reshipSiteName = StringUtils.rightTrim(reshipSiteName);
    }

    /**
     * 获取属性转载地名称
     * @return 属性转载地名称的值
     */
    public String getReshipSiteName(){
        return reshipSiteName;
    }

    /**
     * 设置属性终止地编码
     * @param endSiteCode 待设置的属性终止地编码的值
     */
    public void setEndSiteCode(String endSiteCode){
        this.endSiteCode = StringUtils.rightTrim(endSiteCode);
    }

    /**
     * 获取属性终止地编码
     * @return 属性终止地编码的值
     */
    public String getEndSiteCode(){
        return endSiteCode;
    }

    /**
     * 设置属性终止地名称
     * @param endSiteName 待设置的属性终止地名称的值
     */
    public void setEndSiteName(String endSiteName){
        this.endSiteName = StringUtils.rightTrim(endSiteName);
    }

    /**
     * 获取属性终止地名称
     * @return 属性终止地名称的值
     */
    public String getEndSiteName(){
        return endSiteName;
    }

    /**
     * 设置属性具体终止地名称
     * @param endDetailName 待设置的属性具体终止地名称的值
     */
    public void setEndDetailName(String endDetailName){
        this.endDetailName = StringUtils.rightTrim(endDetailName);
    }

    /**
     * 获取属性具体终止地名称
     * @return 属性具体终止地名称的值
     */
    public String getEndDetailName(){
        return endDetailName;
    }

    /**
     * 设置属性国外检验代理人代码
     * @param checkAgentCode 待设置的属性国外检验代理人代码的值
     */
    public void setCheckAgentCode(String checkAgentCode){
        this.checkAgentCode = StringUtils.rightTrim(checkAgentCode);
    }

    /**
     * 获取属性国外检验代理人代码
     * @return 属性国外检验代理人代码的值
     */
    public String getCheckAgentCode(){
        return checkAgentCode;
    }

    /**
     * 设置属性赔款偿付地点
     * @param claimSite 待设置的属性赔款偿付地点的值
     */
    public void setClaimSite(String claimSite){
        this.claimSite = StringUtils.rightTrim(claimSite);
    }

    /**
     * 获取属性赔款偿付地点
     * @return 属性赔款偿付地点的值
     */
    public String getClaimSite(){
        return claimSite;
    }

    /**
     * 设置属性过户银行
     * @param transferBank 待设置的属性过户银行的值
     */
    public void setTransferBank(String transferBank){
        this.transferBank = StringUtils.rightTrim(transferBank);
    }

    /**
     * 获取属性过户银行
     * @return 属性过户银行的值
     */
    public String getTransferBank(){
        return transferBank;
    }

    /**
     * 设置属性保单正本份数
     * @param originalCount 待设置的属性保单正本份数的值
     */
    public void setOriginalCount(double originalCount){
        this.originalCount = originalCount;
    }

    /**
     * 获取属性保单正本份数
     * @return 属性保单正本份数的值
     */
    public double getOriginalCount(){
        return originalCount;
    }

    /**
     * 设置属性备注
     * @param remark 待设置的属性备注的值
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * 获取属性备注
     * @return 属性备注的值
     */
    public String getRemark(){
        return remark;
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
