package com.sinosoft.claim.dto.custom;

import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是一个用于传输报案信息和立案信息的DTO对象
 * @author wangwei
 * @version 1.0 2005-06-05
 * */

public class RegistClaimInfoDto extends PrpLregistDto {
    /**赔付金额*/
    private double sumPaidShow = 0D;
    /**属性赔案号码 */
    private String claimNo = "";
    /**属性保险损失金额(同保单币别) */
    private double sumClaim = 0d;
    
    //modify by wangwei add start 2005-06-14
    //原因：添加出险原因
    private String compName;
    
    /**
     * 设置属性出险原因
     * @param compName 出险原因*/
    public void setCompName(String compName) {
    	this.compName = compName;
    }
    
    /**
     * 获得属性出险原因
     * @return 出险原因
     */
    public String getCompName() {
    	return this.compName;
    }
    //modify by wangwei add end 2005-06-14
    
    /**
     * 设置属性赔付金额
     * @param sumPaidShow 赔付金额
     */
    public void setSumPaidShow(double sumPaidShow) {
    	this.sumPaidShow = sumPaidShow;
    }
    
    /**
     * 获得属性赔付金额
     * @return  赔付金额
     */
    public double getSumPaidShow() {
    	return this.sumPaidShow;
    }
    
    /**
     * 设置属性赔案号码
     * @param claimNo 待设置的属性赔案号码的值
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * 获取属性赔案号码
     * @return 属性赔案号码的值
     */
    public String getClaimNo(){
        return claimNo;
    }
    
    /**
     * 设置属性保险损失金额(同保单币别)
     * @param sumClaim 待设置的属性保险损失金额(同保单币别)的值
     */
    public void setSumClaim(double sumClaim){
        this.sumClaim = sumClaim;
    }

    /**
     * 获取属性保险损失金额(同保单币别)
     * @return 属性保险损失金额(同保单币别)的值
     */
    public double getSumClaim(){
        return sumClaim;
    }
}