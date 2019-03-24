package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpJthirdBankMapping�����ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpJthirdBankMappingDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����thirdType */
    private String thirdType = "";
    /** ����thirdbank */
    private String thirdbank = "";
    /** ����gyBank */
    private String gyBank = "";
    /** ����validstatus */
    private String validstatus = "";
    /** ����reMark */
    private String reMark = "";
    /** ����gyBankCode */
    private String gyBankCode = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpJthirdBankMappingDtoBase����
     */
    public PrpJthirdBankMappingDtoBase(){
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
     * ��������thirdbank
     * @param thirdbank �����õ�����thirdbank��ֵ
     */
    public void setThirdbank(String thirdbank){
        this.thirdbank = StringUtils.rightTrim(thirdbank);
    }

    /**
     * ��ȡ����thirdbank
     * @return ����thirdbank��ֵ
     */
    public String getThirdbank(){
        return thirdbank;
    }

    /**
     * ��������gyBank
     * @param gyBank �����õ�����gyBank��ֵ
     */
    public void setGyBank(String gyBank){
        this.gyBank = StringUtils.rightTrim(gyBank);
    }

    /**
     * ��ȡ����gyBank
     * @return ����gyBank��ֵ
     */
    public String getGyBank(){
        return gyBank;
    }

    /**
     * ��������validstatus
     * @param validstatus �����õ�����validstatus��ֵ
     */
    public void setValidstatus(String validstatus){
        this.validstatus = StringUtils.rightTrim(validstatus);
    }

    /**
     * ��ȡ����validstatus
     * @return ����validstatus��ֵ
     */
    public String getValidstatus(){
        return validstatus;
    }

    /**
     * ��������reMark
     * @param reMark �����õ�����reMark��ֵ
     */
    public void setReMark(String reMark){
        this.reMark = StringUtils.rightTrim(reMark);
    }

    /**
     * ��ȡ����reMark
     * @return ����reMark��ֵ
     */
    public String getReMark(){
        return reMark;
    }

    /**
     * ��������gyBankCode
     * @param gyBankCode �����õ�����gyBankCode��ֵ
     */
    public void setGyBankCode(String gyBankCode){
        this.gyBankCode = StringUtils.rightTrim(gyBankCode);
    }

    /**
     * ��ȡ����gyBankCode
     * @return ����gyBankCode��ֵ
     */
    public String getGyBankCode(){
        return gyBankCode;
    }
}
