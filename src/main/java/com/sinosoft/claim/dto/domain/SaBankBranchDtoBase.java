package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����SaBankBranch�����ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class SaBankBranchDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����bankCode */
    private String bankCode = "";
    /** ����bankBranchCode */
    private String bankBranchCode = "";
    /** ����bankBranchCName */
    private String bankBranchCName = "";
    /** ����thirdType */
    private String thirdType = "";
    /** ����validStatus */
    private String validStatus = "";
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�SaBankBranchDtoBase����
     */
    public SaBankBranchDtoBase(){
    }

    /**
     * ��������bankCode
     * @param bankCode �����õ�����bankCode��ֵ
     */
    public void setBankCode(String bankCode){
        this.bankCode = StringUtils.rightTrim(bankCode);
    }

    /**
     * ��ȡ����bankCode
     * @return ����bankCode��ֵ
     */
    public String getBankCode(){
        return bankCode;
    }

    /**
     * ��������bankBranchCode
     * @param bankBranchCode �����õ�����bankBranchCode��ֵ
     */
    public void setBankBranchCode(String bankBranchCode){
        this.bankBranchCode = StringUtils.rightTrim(bankBranchCode);
    }

    /**
     * ��ȡ����bankBranchCode
     * @return ����bankBranchCode��ֵ
     */
    public String getBankBranchCode(){
        return bankBranchCode;
    }

    /**
     * ��������bankBranchCName
     * @param bankBranchCName �����õ�����bankBranchCName��ֵ
     */
    public void setBankBranchCName(String bankBranchCName){
        this.bankBranchCName = StringUtils.rightTrim(bankBranchCName);
    }

    /**
     * ��ȡ����bankBranchCName
     * @return ����bankBranchCName��ֵ
     */
    public String getBankBranchCName(){
        return bankBranchCName;
    }

    /**
     * ��������thirdType
     * @param thirdType �����õ�����thirdType��ֵ
     */
    public void setThirdType(String thirdType){
        this.thirdType = StringUtils.rightTrim(thirdType);
    }

    /**
     * ��ȡ����thirdType
     * @return ����thirdType��ֵ
     */
    public String getThirdType(){
        return thirdType;
    }

    /**
     * ��������validStatus
     * @param validStatus �����õ�����validStatus��ֵ
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * ��ȡ����validStatus
     * @return ����validStatus��ֵ
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
