package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpditem�����ݴ���������<br>
 * ������ 2004-4-5 15:22:07<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDitemDtoBase implements Serializable{
    /** ����riskcode */
    private String riskCode = "";
    /** ����itemcode */
    private String itemCode = "";
    /** ����itemcname */
    private String itemCName = "";
    /** ����itemename */
    private String itemEName = "";
    /** ����itemflag */
    private String itemFlag = "";
    /** ����newitemcode */
    private String newItemCode = "";
    /** ����validstatus */
    private String validStatus = "";
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDitemDtoBase����
     */
    public PrpDitemDtoBase(){
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
     * ��������itemcode
     * @param itemCode �����õ�����itemcode��ֵ
     */
    public void setItemCode(String itemCode){
        this.itemCode = StringUtils.rightTrim(itemCode);
    }

    /**
     * ��ȡ����itemcode
     * @return ����itemcode��ֵ
     */
    public String getItemCode(){
        return itemCode;
    }

    /**
     * ��������itemcname
     * @param itemCName �����õ�����itemcname��ֵ
     */
    public void setItemCName(String itemCName){
        this.itemCName = StringUtils.rightTrim(itemCName);
    }

    /**
     * ��ȡ����itemcname
     * @return ����itemcname��ֵ
     */
    public String getItemCName(){
        return itemCName;
    }

    /**
     * ��������itemename
     * @param itemEName �����õ�����itemename��ֵ
     */
    public void setItemEName(String itemEName){
        this.itemEName = StringUtils.rightTrim(itemEName);
    }

    /**
     * ��ȡ����itemename
     * @return ����itemename��ֵ
     */
    public String getItemEName(){
        return itemEName;
    }

    /**
     * ��������itemflag
     * @param itemFlag �����õ�����itemflag��ֵ
     */
    public void setItemFlag(String itemFlag){
        this.itemFlag = StringUtils.rightTrim(itemFlag);
    }

    /**
     * ��ȡ����itemflag
     * @return ����itemflag��ֵ
     */
    public String getItemFlag(){
        return itemFlag;
    }

    /**
     * ��������newitemcode
     * @param newItemCode �����õ�����newitemcode��ֵ
     */
    public void setNewItemCode(String newItemCode){
        this.newItemCode = StringUtils.rightTrim(newItemCode);
    }

    /**
     * ��ȡ����newitemcode
     * @return ����newitemcode��ֵ
     */
    public String getNewItemCode(){
        return newItemCode;
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
