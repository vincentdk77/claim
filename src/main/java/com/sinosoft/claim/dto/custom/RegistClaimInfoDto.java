package com.sinosoft.claim.dto.custom;

import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����һ�����ڴ��䱨����Ϣ��������Ϣ��DTO����
 * @author wangwei
 * @version 1.0 2005-06-05
 * */

public class RegistClaimInfoDto extends PrpLregistDto {
    /**�⸶���*/
    private double sumPaidShow = 0D;
    /**�����ⰸ���� */
    private String claimNo = "";
    /**���Ա�����ʧ���(ͬ�����ұ�) */
    private double sumClaim = 0d;
    
    //modify by wangwei add start 2005-06-14
    //ԭ����ӳ���ԭ��
    private String compName;
    
    /**
     * �������Գ���ԭ��
     * @param compName ����ԭ��*/
    public void setCompName(String compName) {
    	this.compName = compName;
    }
    
    /**
     * ������Գ���ԭ��
     * @return ����ԭ��
     */
    public String getCompName() {
    	return this.compName;
    }
    //modify by wangwei add end 2005-06-14
    
    /**
     * ���������⸶���
     * @param sumPaidShow �⸶���
     */
    public void setSumPaidShow(double sumPaidShow) {
    	this.sumPaidShow = sumPaidShow;
    }
    
    /**
     * ��������⸶���
     * @return  �⸶���
     */
    public double getSumPaidShow() {
    	return this.sumPaidShow;
    }
    
    /**
     * ���������ⰸ����
     * @param claimNo �����õ������ⰸ�����ֵ
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * ��ȡ�����ⰸ����
     * @return �����ⰸ�����ֵ
     */
    public String getClaimNo(){
        return claimNo;
    }
    
    /**
     * �������Ա�����ʧ���(ͬ�����ұ�)
     * @param sumClaim �����õ����Ա�����ʧ���(ͬ�����ұ�)��ֵ
     */
    public void setSumClaim(double sumClaim){
        this.sumClaim = sumClaim;
    }

    /**
     * ��ȡ���Ա�����ʧ���(ͬ�����ұ�)
     * @return ���Ա�����ʧ���(ͬ�����ұ�)��ֵ
     */
    public double getSumClaim(){
        return sumClaim;
    }
}