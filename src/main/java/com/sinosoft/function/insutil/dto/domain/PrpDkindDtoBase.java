package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdkind�����ݴ���������<br>
 * ������ 2004-4-5 15:22:07<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDkindDtoBase implements Serializable{
    /** ����riskcode */
    private String riskCode = "";
    /** ����kindcode */
    private String kindCode = "";
    /** ����kindcname */
    private String kindCName = "";
    /** ����kindename */
    private String kindEName = "";
    /** ����calculateflag */
    private String calculateFlag = "";
    /** ����newkindcode */
    private String newKindCode = "";
    /** ����validstatus */
    private String validStatus = "";
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDkindDtoBase����
     */
    public PrpDkindDtoBase(){
    }

    /**
     * ��������riskcode
     * @param riskCode �����õ�����riskcode��ֵ
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * ��ȡ����riskcode
     * @return ����riskcode��ֵ
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * ��������kindcode
     * @param kindCode �����õ�����kindcode��ֵ
     */
    public void setKindCode(String kindCode){
        this.kindCode = StringUtils.rightTrim(kindCode);
    }

    /**
     * ��ȡ����kindcode
     * @return ����kindcode��ֵ
     */
    public String getKindCode(){
        return kindCode;
    }

    /**
     * ��������kindcname
     * @param kindCName �����õ�����kindcname��ֵ
     */
    public void setKindCName(String kindCName){
        this.kindCName = StringUtils.rightTrim(kindCName);
    }

    /**
     * ��ȡ����kindcname
     * @return ����kindcname��ֵ
     */
    public String getKindCName(){
        return kindCName;
    }

    /**
     * ��������kindename
     * @param kindEName �����õ�����kindename��ֵ
     */
    public void setKindEName(String kindEName){
        this.kindEName = StringUtils.rightTrim(kindEName);
    }

    /**
     * ��ȡ����kindename
     * @return ����kindename��ֵ
     */
    public String getKindEName(){
        return kindEName;
    }

    /**
     * ��������calculateflag
     * @param calculateFlag �����õ�����calculateflag��ֵ
     */
    public void setCalculateFlag(String calculateFlag){
        this.calculateFlag = StringUtils.rightTrim(calculateFlag);
    }

    /**
     * ��ȡ����calculateflag
     * @return ����calculateflag��ֵ
     */
    public String getCalculateFlag(){
        return calculateFlag;
    }

    /**
     * ��������newkindcode
     * @param newKindCode �����õ�����newkindcode��ֵ
     */
    public void setNewKindCode(String newKindCode){
        this.newKindCode = StringUtils.rightTrim(newKindCode);
    }

    /**
     * ��ȡ����newkindcode
     * @return ����newkindcode��ֵ
     */
    public String getNewKindCode(){
        return newKindCode;
    }

    /**
     * ��������validstatus
     * @param validStatus �����õ�����validstatus��ֵ
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * ��ȡ����validstatus
     * @return ����validstatus��ֵ
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
