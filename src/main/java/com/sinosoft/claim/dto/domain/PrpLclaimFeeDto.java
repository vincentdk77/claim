package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

import com.sinosoft.sysframework.common.util.StringUtils;
/**
 * ����prplclaimfee�����������ݴ��������<br>
 * ������ 2004-4-5 15:31:56<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLclaimFeeDto extends PrpLclaimFeeDtoBase implements Serializable{
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLclaimFeeDto����
     */
    private Collection claimFeeList ;

    private String currencyName = "";
	
    public PrpLclaimFeeDto(){
    }

    /**
     * ��ȡ�б�
     * @return �����б�
     */
    public Collection getClaimFeeList(){
      return claimFeeList ;
    }
    /**
     * �����б�
     * @param driverList �����õ��б�
     */
    public void setClaimFeeList(Collection claimFeeList ) {
      this.claimFeeList  = claimFeeList ;
    }

    /**
     * �������Աұ�����
     * @param currencyName �����õ����Աұ����Ƶ�ֵ
     */
    public void setCurrencyName(String currencyName){
        this.currencyName = StringUtils.rightTrim(currencyName);
    }

    /**
     * ��ȡ���Աұ�����
     * @return ���Աұ����Ƶ�ֵ
     */
    public String getCurrencyName(){
        return currencyName;
    }
	
	
}
