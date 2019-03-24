package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLclaimAgent-代理赔保单信息表的数据传输对象基类<br>
 * 创建于 2005-03-18 17:53:35.625<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLclaimAgenttgDtoBase implements Serializable{
    /** 属性赔案号 */
    private String claimNo = "";
    /** 属性保单号 */
    private String policyNo = "";
    /** 属性承保地区编码 */
    private String centreCode = "";
    /** 属性承保地区名称 */
    private String centreName = "";
    /** 属性承保公司编码 */
    private String unitCode = "";
    /** 属性承保公司名称 */
    private String unitName = "";
    /** 属性签单日期 */
    private DateTime operateDate = new DateTime();
    /** 属性运输方式 */
    private String conveyance = "";
    /** 属性启运地编码 */
    private String startSiteCode = "";
    /** 属性启运地名称 */
    private String startSiteName = "";
    /** 属性中转地编码 */
    private String viaSiteCode = "";
    /** 属性中转地名称 */
    private String viaSiteName = "";
    /** 属性目的地编码 */
    private String endSiteCode = "";
    /** 属性目的地名称 */
    private String endSiteName = "";
    /** 属性FLAG */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpLclaimAgenttgDtoBase对象
     */
    public PrpLclaimAgenttgDtoBase(){
    }

    /**
     * 设置属性赔案号
     * @param claimNo 待设置的属性赔案号的值
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * 获取属性赔案号
     * @return 属性赔案号的值
     */
    public String getClaimNo(){
        return claimNo;
    }

    /**
     * 设置属性保单号
     * @param policyNo 待设置的属性保单号的值
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * 获取属性保单号
     * @return 属性保单号的值
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * 设置属性承保地区编码
     * @param centreCode 待设置的属性承保地区编码的值
     */
    public void setCentreCode(String centreCode){
        this.centreCode = StringUtils.rightTrim(centreCode);
    }

    /**
     * 获取属性承保地区编码
     * @return 属性承保地区编码的值
     */
    public String getCentreCode(){
        return centreCode;
    }

    /**
     * 设置属性承保地区名称
     * @param centreName 待设置的属性承保地区名称的值
     */
    public void setCentreName(String centreName){
        this.centreName = StringUtils.rightTrim(centreName);
    }

    /**
     * 获取属性承保地区名称
     * @return 属性承保地区名称的值
     */
    public String getCentreName(){
        return centreName;
    }

    /**
     * 设置属性承保公司编码
     * @param unitCode 待设置的属性承保公司编码的值
     */
    public void setUnitCode(String unitCode){
        this.unitCode = StringUtils.rightTrim(unitCode);
    }

    /**
     * 获取属性承保公司编码
     * @return 属性承保公司编码的值
     */
    public String getUnitCode(){
        return unitCode;
    }

    /**
     * 设置属性承保公司名称
     * @param unitName 待设置的属性承保公司名称的值
     */
    public void setUnitName(String unitName){
        this.unitName = StringUtils.rightTrim(unitName);
    }

    /**
     * 获取属性承保公司名称
     * @return 属性承保公司名称的值
     */
    public String getUnitName(){
        return unitName;
    }

    /**
     * 设置属性签单日期
     * @param operateDate 待设置的属性签单日期的值
     */
    public void setOperateDate(DateTime operateDate){
        this.operateDate = operateDate;
    }

    /**
     * 获取属性签单日期
     * @return 属性签单日期的值
     */
    public DateTime getOperateDate(){
        return operateDate;
    }

    /**
     * 设置属性运输方式
     * @param conveyance 待设置的属性运输方式的值
     */
    public void setConveyance(String conveyance){
        this.conveyance = StringUtils.rightTrim(conveyance);
    }

    /**
     * 获取属性运输方式
     * @return 属性运输方式的值
     */
    public String getConveyance(){
        return conveyance;
    }

    /**
     * 设置属性启运地编码
     * @param startSiteCode 待设置的属性启运地编码的值
     */
    public void setStartSiteCode(String startSiteCode){
        this.startSiteCode = StringUtils.rightTrim(startSiteCode);
    }

    /**
     * 获取属性启运地编码
     * @return 属性启运地编码的值
     */
    public String getStartSiteCode(){
        return startSiteCode;
    }

    /**
     * 设置属性启运地名称
     * @param startSiteName 待设置的属性启运地名称的值
     */
    public void setStartSiteName(String startSiteName){
        this.startSiteName = StringUtils.rightTrim(startSiteName);
    }

    /**
     * 获取属性启运地名称
     * @return 属性启运地名称的值
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
     * 设置属性目的地编码
     * @param endSiteCode 待设置的属性目的地编码的值
     */
    public void setEndSiteCode(String endSiteCode){
        this.endSiteCode = StringUtils.rightTrim(endSiteCode);
    }

    /**
     * 获取属性目的地编码
     * @return 属性目的地编码的值
     */
    public String getEndSiteCode(){
        return endSiteCode;
    }

    /**
     * 设置属性目的地名称
     * @param endSiteName 待设置的属性目的地名称的值
     */
    public void setEndSiteName(String endSiteName){
        this.endSiteName = StringUtils.rightTrim(endSiteName);
    }

    /**
     * 获取属性目的地名称
     * @return 属性目的地名称的值
     */
    public String getEndSiteName(){
        return endSiteName;
    }

    /**
     * 设置属性FLAG
     * @param flag 待设置的属性FLAG的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性FLAG
     * @return 属性FLAG的值
     */
    public String getFlag(){
        return flag;
    }
}
