package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����Ԥ�������Ϣ������ݴ���������<br>
 */
public class PrpLinterPrepayFeeDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** �������� PK */
    private String id = "";
    /** ������� PK */
    private int serialNo = 0;
    /** ���Է��ô��� */
    private String chargeCode = "";
    /** ���Է������� */
    private String chargeName = "";
    /** ���Աұ� */
    private String currency = "";
    /** �����ձ���� */
    private String kindCode = "";
    /** ���Է��ý�� */
    private double chargeReport = 0D;

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLinterPrepayFeeDtoBase����
     */
    public PrpLinterPrepayFeeDtoBase(){
    }

    /**
     * ������������ PK
     * @param id �����õ��������� PK��ֵ
     */
    public void setId(String id){
        this.id = StringUtils.rightTrim(id);
    }

    /**
     * ��ȡ�������� PK
     * @return �������� PK��ֵ
     */
    public String getId(){
        return id;
    }

    /**
     * ����������� PK
     * @param serialNo �����õ�������� PK��ֵ
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ������� PK
     * @return ������� PK��ֵ
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * �������Է��ô���
     * @param chargeCode �����õ����Է��ô����ֵ
     */
    public void setChargeCode(String chargeCode){
        this.chargeCode = StringUtils.rightTrim(chargeCode);
    }

    /**
     * ��ȡ���Է��ô���
     * @return ���Է��ô����ֵ
     */
    public String getChargeCode(){
        return chargeCode;
    }

    /**
     * �������Է�������
     * @param chargeName �����õ����Է������Ƶ�ֵ
     */
    public void setChargeName(String chargeName){
        this.chargeName = StringUtils.rightTrim(chargeName);
    }

    /**
     * ��ȡ���Է�������
     * @return ���Է������Ƶ�ֵ
     */
    public String getChargeName(){
        return chargeName;
    }

    /**
     * �������Աұ�
     * @param currency �����õ����Աұ��ֵ
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * ��ȡ���Աұ�
     * @return ���Աұ��ֵ
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * ���������ձ����
     * @param kindCode �����õ������ձ�����ֵ
     */
    public void setKindCode(String kindCode){
        this.kindCode = StringUtils.rightTrim(kindCode);
    }

    /**
     * ��ȡ�����ձ����
     * @return �����ձ�����ֵ
     */
    public String getKindCode(){
        return kindCode;
    }

    /**
     * �������Է��ý��
     * @param chargeReport �����õ����Է��ý���ֵ
     */
    public void setChargeReport(double chargeReport){
        this.chargeReport = chargeReport;
    }

    /**
     * ��ȡ���Է��ý��
     * @return ���Է��ý���ֵ
     */
    public double getChargeReport(){
        return chargeReport;
    }
}
