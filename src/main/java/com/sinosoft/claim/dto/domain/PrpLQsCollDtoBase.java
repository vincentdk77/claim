package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLQs_coll清算中心通赔结算汇总表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLQsCollDtoBase implements Serializable{
    /** 属性总批次号 */
    private String batchNo = "";
    /** 属性公司代码  出险承保 */
    private String procComCode = "";
    /** 属性公司名称 */
    private String procComCName = "";
    /** 属性结算单批次号 */
    private String procNo = "";
    /** 属性代赔案件数 */
    private int checkAgntD1 = 0;
    /** 属性代查勘费=代赔案件数×500 */
    private double checkAgntFee1 = 0d;
    /** 属性代查案件数 */
    private int checkAgntD2 = 0;
    /** 属性代查勘费  =代查案件数×300 */
    private double checkAgntFee2 = 0d;
    /** 属性代定案件数 */
    private int checkAgntD3 = 0;
    /** 属性代查勘费  =代定案件数×500 */
    private double checkAgntFee3 = 0d;
    /** 属性代赔金额 */
    private double claimAgntFee = 0d;
    /** 属性退案笔数 */
    private int refundAgntNo = 0;
    /** 属性退案金额 */
    private double refundAgntFee = 0d;
    /** 属性实付案件数 */
    private int realPayAgntFee = 0;
    /** 属性实付代查勘费小计 */
    private double realCheckAgntFee = 0d;
    /** 属性实付总金额 */
    private double realPaySumFee = 0d;
    /** 属性划款日期 */
    private DateTime balDate = new DateTime();
    /** 属性清算日期 */
    private DateTime procDate = new DateTime();
    /** 属性清算操作员 */
    private String operatorCode = "";
    /** 属性公司代码  清算 */
    private String comCode = "";
    /** 属性备注 */
    private String remark = "";
    /** 属性标志位 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpLQs_collDtoBase对象
     */
    public PrpLQsCollDtoBase(){
    }

    /**
     * 设置属性总批次号
     * @param batchNo 待设置的属性总批次号的值
     */
    public void setBatchNo(String batchNo){
        this.batchNo = StringUtils.rightTrim(batchNo);
    }

    /**
     * 获取属性总批次号
     * @return 属性总批次号的值
     */
    public String getBatchNo(){
        return batchNo;
    }

    /**
     * 设置属性公司代码  出险承保
     * @param procComCode 待设置的属性公司代码  出险承保的值
     */
    public void setProcComCode(String procComCode){
        this.procComCode = StringUtils.rightTrim(procComCode);
    }

    /**
     * 获取属性公司代码  出险承保
     * @return 属性公司代码  出险承保的值
     */
    public String getProcComCode(){
        return procComCode;
    }

    /**
     * 设置属性公司名称
     * @param procComCName 待设置的属性公司名称的值
     */
    public void setProcComCName(String procComCName){
        this.procComCName = StringUtils.rightTrim(procComCName);
    }

    /**
     * 获取属性公司名称
     * @return 属性公司名称的值
     */
    public String getProcComCName(){
        return procComCName;
    }

    /**
     * 设置属性结算单批次号
     * @param procNo 待设置的属性结算单批次号的值
     */
    public void setProcNo(String procNo){
        this.procNo = StringUtils.rightTrim(procNo);
    }

    /**
     * 获取属性结算单批次号
     * @return 属性结算单批次号的值
     */
    public String getProcNo(){
        return procNo;
    }

    /**
     * 设置属性代赔案件数
     * @param checkAgntD1 待设置的属性代赔案件数的值
     */
    public void setCheckAgntD1(int checkAgntD1){
        this.checkAgntD1 = checkAgntD1;
    }

    /**
     * 获取属性代赔案件数
     * @return 属性代赔案件数的值
     */
    public int getCheckAgntD1(){
        return checkAgntD1;
    }

    /**
     * 设置属性代查勘费=代赔案件数×500
     * @param checkAgntFee1 待设置的属性代查勘费=代赔案件数×500的值
     */
    public void setCheckAgntFee1(double checkAgntFee1){
        this.checkAgntFee1 = checkAgntFee1;
    }

    /**
     * 获取属性代查勘费=代赔案件数×500
     * @return 属性代查勘费=代赔案件数×500的值
     */
    public double getCheckAgntFee1(){
        return checkAgntFee1;
    }

    /**
     * 设置属性代查案件数
     * @param checkAgntD2 待设置的属性代查案件数的值
     */
    public void setCheckAgntD2(int checkAgntD2){
        this.checkAgntD2 = checkAgntD2;
    }

    /**
     * 获取属性代查案件数
     * @return 属性代查案件数的值
     */
    public int getCheckAgntD2(){
        return checkAgntD2;
    }

    /**
     * 设置属性代查勘费  =代查案件数×300
     * @param checkAgntFee2 待设置的属性代查勘费  =代查案件数×300的值
     */
    public void setCheckAgntFee2(double checkAgntFee2){
        this.checkAgntFee2 = checkAgntFee2;
    }

    /**
     * 获取属性代查勘费  =代查案件数×300
     * @return 属性代查勘费  =代查案件数×300的值
     */
    public double getCheckAgntFee2(){
        return checkAgntFee2;
    }

    /**
     * 设置属性代定案件数
     * @param checkAgntD3 待设置的属性代定案件数的值
     */
    public void setCheckAgntD3(int checkAgntD3){
        this.checkAgntD3 = checkAgntD3;
    }

    /**
     * 获取属性代定案件数
     * @return 属性代定案件数的值
     */
    public int getCheckAgntD3(){
        return checkAgntD3;
    }

    /**
     * 设置属性代查勘费  =代定案件数×500
     * @param checkAgntFee3 待设置的属性代查勘费  =代定案件数×500的值
     */
    public void setCheckAgntFee3(double checkAgntFee3){
        this.checkAgntFee3 = checkAgntFee3;
    }

    /**
     * 获取属性代查勘费  =代定案件数×500
     * @return 属性代查勘费  =代定案件数×500的值
     */
    public double getCheckAgntFee3(){
        return checkAgntFee3;
    }

    /**
     * 设置属性代赔金额
     * @param claimAgntFee 待设置的属性代赔金额的值
     */
    public void setClaimAgntFee(double claimAgntFee){
        this.claimAgntFee = claimAgntFee;
    }

    /**
     * 获取属性代赔金额
     * @return 属性代赔金额的值
     */
    public double getClaimAgntFee(){
        return claimAgntFee;
    }

    /**
     * 设置属性退案笔数
     * @param refundAgntNo 待设置的属性退案笔数的值
     */
    public void setRefundAgntNo(int refundAgntNo){
        this.refundAgntNo = refundAgntNo;
    }

    /**
     * 获取属性退案笔数
     * @return 属性退案笔数的值
     */
    public int getRefundAgntNo(){
        return refundAgntNo;
    }

    /**
     * 设置属性退案金额
     * @param refundAgntFee 待设置的属性退案金额的值
     */
    public void setRefundAgntFee(double refundAgntFee){
        this.refundAgntFee = refundAgntFee;
    }

    /**
     * 获取属性退案金额
     * @return 属性退案金额的值
     */
    public double getRefundAgntFee(){
        return refundAgntFee;
    }

    /**
     * 设置属性实付案件数
     * @param realPayAgntFee 待设置的属性实付案件数的值
     */
    public void setRealPayAgntFee(int realPayAgntFee){
        this.realPayAgntFee = realPayAgntFee;
    }

    /**
     * 获取属性实付案件数
     * @return 属性实付案件数的值
     */
    public int getRealPayAgntFee(){
        return realPayAgntFee;
    }

    /**
     * 设置属性实付代查勘费小计
     * @param realCheckAgntFee 待设置的属性实付代查勘费小计的值
     */
    public void setRealCheckAgntFee(double realCheckAgntFee){
        this.realCheckAgntFee = realCheckAgntFee;
    }

    /**
     * 获取属性实付代查勘费小计
     * @return 属性实付代查勘费小计的值
     */
    public double getRealCheckAgntFee(){
        return realCheckAgntFee;
    }

    /**
     * 设置属性实付总金额
     * @param realPaySumFee 待设置的属性实付总金额的值
     */
    public void setRealPaySumFee(double realPaySumFee){
        this.realPaySumFee = realPaySumFee;
    }

    /**
     * 获取属性实付总金额
     * @return 属性实付总金额的值
     */
    public double getRealPaySumFee(){
        return realPaySumFee;
    }

    /**
     * 设置属性划款日期
     * @param balDate 待设置的属性划款日期的值
     */
    public void setBalDate(DateTime balDate){
        this.balDate = balDate;
    }

    /**
     * 获取属性划款日期
     * @return 属性划款日期的值
     */
    public DateTime getBalDate(){
        return balDate;
    }

    /**
     * 设置属性清算日期
     * @param procDate 待设置的属性清算日期的值
     */
    public void setProcDate(DateTime procDate){
        this.procDate = procDate;
    }

    /**
     * 获取属性清算日期
     * @return 属性清算日期的值
     */
    public DateTime getProcDate(){
        return procDate;
    }

    /**
     * 设置属性清算操作员
     * @param operatorCode 待设置的属性清算操作员的值
     */
    public void setOperatorCode(String operatorCode){
        this.operatorCode = StringUtils.rightTrim(operatorCode);
    }

    /**
     * 获取属性清算操作员
     * @return 属性清算操作员的值
     */
    public String getOperatorCode(){
        return operatorCode;
    }

    /**
     * 设置属性公司代码  清算
     * @param comCode 待设置的属性公司代码  清算的值
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * 获取属性公司代码  清算
     * @return 属性公司代码  清算的值
     */
    public String getComCode(){
        return comCode;
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
     * 设置属性标志位
     * @param flag 待设置的属性标志位的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性标志位
     * @return 属性标志位的值
     */
    public String getFlag(){
        return flag;
    }
}
