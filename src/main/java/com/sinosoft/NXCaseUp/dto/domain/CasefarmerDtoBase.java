package com.sinosoft.NXCaseUp.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����CASEFARMER�����ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class CasefarmerDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����FARMERNAME */
    private String farmername = "";
    /** ����FARMERIDNUMBER */
    private String farmeridnumber = "";
    /** ����FARMERPHONE */
    private String farmerphone = "";
    /** ����INSUREOBIECTNUMBER */
    private double insureobiectnumber = 0D;
    /** ����LOSSDEGREE */
    private double lossdegree = 0D;
    /** ����SETTLEAMOUNT */
    private double settleamount = 0D;
    /** ����SETTLESUMAMOUNT */
    private double settlesumamount = 0D;
    /** ����SERINO */
    private long serino = 0L;
    /** ����AFFECTEDAREA */
    private double affectedarea = 0D;
    /** ����DAMAGEDAREA */
    private double damagedarea = 0D;
    /** ����LOSSAREA */
    private double lossarea = 0D;
    /** ����MEASUREMANTUNIT */
    private String measuremantunit = "";
    /** ����CASENO */
    private String caseno = "";
    /** ����FARMERIDTYPE */
    private String farmeridtype = "";
    /** ����SETTLEOBJECTNUMBER */
    private double settleobjectnumber = 0D;
    /** ����PREPAIDAMOUNT */
    private double prepaidamount = 0D;

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�CasefarmerDtoBase����
     */
    public CasefarmerDtoBase(){
    }

    /**
     * ��������FARMERNAME
     * @param farmername �����õ�����FARMERNAME��ֵ
     */
    public void setFarmername(String farmername){
        this.farmername = StringUtils.rightTrim(farmername);
    }

    /**
     * ��ȡ����FARMERNAME
     * @return ����FARMERNAME��ֵ
     */
    public String getFarmername(){
        return farmername;
    }

    /**
     * ��������FARMERIDNUMBER
     * @param farmeridnumber �����õ�����FARMERIDNUMBER��ֵ
     */
    public void setFarmeridnumber(String farmeridnumber){
        this.farmeridnumber = StringUtils.rightTrim(farmeridnumber);
    }

    /**
     * ��ȡ����FARMERIDNUMBER
     * @return ����FARMERIDNUMBER��ֵ
     */
    public String getFarmeridnumber(){
        return farmeridnumber;
    }

    /**
     * ��������FARMERPHONE
     * @param farmerphone �����õ�����FARMERPHONE��ֵ
     */
    public void setFarmerphone(String farmerphone){
        this.farmerphone = StringUtils.rightTrim(farmerphone);
    }

    /**
     * ��ȡ����FARMERPHONE
     * @return ����FARMERPHONE��ֵ
     */
    public String getFarmerphone(){
        return farmerphone;
    }

    /**
     * ��������INSUREOBIECTNUMBER
     * @param insureobiectnumber �����õ�����INSUREOBIECTNUMBER��ֵ
     */
    public void setInsureobiectnumber(double insureobiectnumber){
        this.insureobiectnumber = insureobiectnumber;
    }

    /**
     * ��ȡ����INSUREOBIECTNUMBER
     * @return ����INSUREOBIECTNUMBER��ֵ
     */
    public double getInsureobiectnumber(){
        return insureobiectnumber;
    }

    /**
     * ��������LOSSDEGREE
     * @param lossdegree �����õ�����LOSSDEGREE��ֵ
     */
    public void setLossdegree(double lossdegree){
        this.lossdegree = lossdegree;
    }

    /**
     * ��ȡ����LOSSDEGREE
     * @return ����LOSSDEGREE��ֵ
     */
    public double getLossdegree(){
        return lossdegree;
    }

    /**
     * ��������SETTLEAMOUNT
     * @param settleamount �����õ�����SETTLEAMOUNT��ֵ
     */
    public void setSettleamount(double settleamount){
        this.settleamount = settleamount;
    }

    /**
     * ��ȡ����SETTLEAMOUNT
     * @return ����SETTLEAMOUNT��ֵ
     */
    public double getSettleamount(){
        return settleamount;
    }

    /**
     * ��������SETTLESUMAMOUNT
     * @param settlesumamount �����õ�����SETTLESUMAMOUNT��ֵ
     */
    public void setSettlesumamount(double settlesumamount){
        this.settlesumamount = settlesumamount;
    }

    /**
     * ��ȡ����SETTLESUMAMOUNT
     * @return ����SETTLESUMAMOUNT��ֵ
     */
    public double getSettlesumamount(){
        return settlesumamount;
    }

    /**
     * ��������SERINO
     * @param serino �����õ�����SERINO��ֵ
     */
    public void setSerino(long serino){
        this.serino = serino;
    }

    /**
     * ��ȡ����SERINO
     * @return ����SERINO��ֵ
     */
    public long getSerino(){
        return serino;
    }

    /**
     * ��������AFFECTEDAREA
     * @param affectedarea �����õ�����AFFECTEDAREA��ֵ
     */
    public void setAffectedarea(double affectedarea){
        this.affectedarea = affectedarea;
    }

    /**
     * ��ȡ����AFFECTEDAREA
     * @return ����AFFECTEDAREA��ֵ
     */
    public double getAffectedarea(){
        return affectedarea;
    }

    /**
     * ��������DAMAGEDAREA
     * @param damagedarea �����õ�����DAMAGEDAREA��ֵ
     */
    public void setDamagedarea(double damagedarea){
        this.damagedarea = damagedarea;
    }

    /**
     * ��ȡ����DAMAGEDAREA
     * @return ����DAMAGEDAREA��ֵ
     */
    public double getDamagedarea(){
        return damagedarea;
    }

    /**
     * ��������LOSSAREA
     * @param lossarea �����õ�����LOSSAREA��ֵ
     */
    public void setLossarea(double lossarea){
        this.lossarea = lossarea;
    }

    /**
     * ��ȡ����LOSSAREA
     * @return ����LOSSAREA��ֵ
     */
    public double getLossarea(){
        return lossarea;
    }

    /**
     * ��������MEASUREMANTUNIT
     * @param measuremantunit �����õ�����MEASUREMANTUNIT��ֵ
     */
    public void setMeasuremantunit(String measuremantunit){
        this.measuremantunit = StringUtils.rightTrim(measuremantunit);
    }

    /**
     * ��ȡ����MEASUREMANTUNIT
     * @return ����MEASUREMANTUNIT��ֵ
     */
    public String getMeasuremantunit(){
        return measuremantunit;
    }

    /**
     * ��������CASENO
     * @param caseno �����õ�����CASENO��ֵ
     */
    public void setCaseno(String caseno){
        this.caseno = StringUtils.rightTrim(caseno);
    }

    /**
     * ��ȡ����CASENO
     * @return ����CASENO��ֵ
     */
    public String getCaseno(){
        return caseno;
    }

    /**
     * ��������FARMERIDTYPE
     * @param farmeridtype �����õ�����FARMERIDTYPE��ֵ
     */
    public void setFarmeridtype(String farmeridtype){
        this.farmeridtype = StringUtils.rightTrim(farmeridtype);
    }

    /**
     * ��ȡ����FARMERIDTYPE
     * @return ����FARMERIDTYPE��ֵ
     */
    public String getFarmeridtype(){
        return farmeridtype;
    }

    /**
     * ��������SETTLEOBJECTNUMBER
     * @param settleobjectnumber �����õ�����SETTLEOBJECTNUMBER��ֵ
     */
    public void setSettleobjectnumber(double settleobjectnumber){
        this.settleobjectnumber = settleobjectnumber;
    }

    /**
     * ��ȡ����SETTLEOBJECTNUMBER
     * @return ����SETTLEOBJECTNUMBER��ֵ
     */
    public double getSettleobjectnumber(){
        return settleobjectnumber;
    }

    /**
     * ��������PREPAIDAMOUNT
     * @param prepaidamount �����õ�����PREPAIDAMOUNT��ֵ
     */
    public void setPrepaidamount(double prepaidamount){
        this.prepaidamount = prepaidamount;
    }

    /**
     * ��ȡ����PREPAIDAMOUNT
     * @return ����PREPAIDAMOUNT��ֵ
     */
    public double getPrepaidamount(){
        return prepaidamount;
    }
}
