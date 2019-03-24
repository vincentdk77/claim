package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdship������������ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDshipDtoBase implements Serializable{
    /** ���Դ������� */
    private String shipCode = "";
    /** ���Դ���(����) */
    private String shipCName = "";
    /** ���Դ���(Ӣ��) */
    private String shipEName = "";
    /** ���������� */
    private String oldShipName = "";
    /** ���Դ��� */
    private String shipOwner = "";
    /** ����ԭ���� */
    private String oldShipOwner = "";
    /** ���Ա���Э�� */
    private String associate = "";
    /** ���Խ������� */
    private DateTime makeYearMonth = new DateTime();
    /** ���Թ��Ҵ��� */
    private String countryCode = "";
    /** �������쳧�� */
    private String makeFactory = "";
    /** ���Խ��촬�����Ƽ���ַ */
    private String makeDock = "";
    /** ���Դ��� */
    private String stepHull = "";
    /** ����ԭ���� */
    private String oldStepHull = "";
    /** ���Դ��� */
    private String shipFlag = "";
    /** ���Դ���������� */
    private String shipType = "";
    /** ���Դ���ʹ�����ʴ��� */
    private String useNature = "";
    /** ���Դ�����; */
    private String shipUsage = "";
    /** ���Դ��ʽṹ���� */
    private String shipStruct = "";
    /** ����ע��ص� */
    private String registrySite = "";
    /** �����ܶ�λ */
    private double tonCount = 0d;
    /** ���Ծ���λ */
    private double netTonCount = 0d;
    /** ���Թ��� */
    private double horsePower = 0d;
    /** ���Թ��ʵ�λ */
    private String powerUnit = "";
    /** ���Կ�λ */
    private int seatCount = 0;
    /** �������ض� */
    private double loadTon = 0d;
    /** �����ܳ� */
    private double shipLength = 0d;
    /** �����Ϳ� */
    private double shipWidth = 0d;
    /** �������� */
    private double shipDepth = 0d;
    /** ���Դ�����ֵ */
    private double shipValue = 0d;
    /** ���Դ���֤���������������� */
    private String certificateOwner = "";
    /** ����ʵ�������� */
    private String actualOwner = "";
    /** ���Ծ�Ӫ������ */
    private String proprietorName = "";
    /** ���Ծ�Ӫ��ʽ */
    private String manageType = "";
    /** ���Ծ�Ӫˮ·�������֤����Ч���� */
    private DateTime manageStartDate = new DateTime();
    /** ���Ծ�Ӫˮ·�������֤����Чֹ�� */
    private DateTime manageEndDate = new DateTime();
    /** ���Դ�������֤����Ч���� */
    private DateTime checkStartDate = new DateTime();
    /** ���Դ�������֤����Чֹ�� */
    private DateTime checkEndDate = new DateTime();
    /** ���Դ���ծ��� */
    private int debtAmount = 0;
    /** ���Ե�Ѻ��־(0/1) */
    private String pledge = "";
    /** ���Դ����Ľ���λ */
    private String rebuildCompany = "";
    /** ���Դ����Ľ�ʱ�� */
    private DateTime rebuildDate = new DateTime();
    /** �����µĴ������� */
    private String newShipCode = "";
    /** ����Ч��״̬ */
    private String validStatus = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDshipDtoBase����
     */
    public PrpDshipDtoBase(){
    }

    /**
     * �������Դ�������
     * @param shipCode �����õ����Դ��������ֵ
     */
    public void setShipCode(String shipCode){
        this.shipCode = StringUtils.rightTrim(shipCode);
    }

    /**
     * ��ȡ���Դ�������
     * @return ���Դ��������ֵ
     */
    public String getShipCode(){
        return shipCode;
    }

    /**
     * �������Դ���(����)
     * @param shipCName �����õ����Դ���(����)��ֵ
     */
    public void setShipCName(String shipCName){
        this.shipCName = StringUtils.rightTrim(shipCName);
    }

    /**
     * ��ȡ���Դ���(����)
     * @return ���Դ���(����)��ֵ
     */
    public String getShipCName(){
        return shipCName;
    }

    /**
     * �������Դ���(Ӣ��)
     * @param shipEName �����õ����Դ���(Ӣ��)��ֵ
     */
    public void setShipEName(String shipEName){
        this.shipEName = StringUtils.rightTrim(shipEName);
    }

    /**
     * ��ȡ���Դ���(Ӣ��)
     * @return ���Դ���(Ӣ��)��ֵ
     */
    public String getShipEName(){
        return shipEName;
    }

    /**
     * ��������������
     * @param oldShipName �����õ�������������ֵ
     */
    public void setOldShipName(String oldShipName){
        this.oldShipName = StringUtils.rightTrim(oldShipName);
    }

    /**
     * ��ȡ����������
     * @return ������������ֵ
     */
    public String getOldShipName(){
        return oldShipName;
    }

    /**
     * �������Դ���
     * @param shipOwner �����õ����Դ�����ֵ
     */
    public void setShipOwner(String shipOwner){
        this.shipOwner = StringUtils.rightTrim(shipOwner);
    }

    /**
     * ��ȡ���Դ���
     * @return ���Դ�����ֵ
     */
    public String getShipOwner(){
        return shipOwner;
    }

    /**
     * ��������ԭ����
     * @param oldShipOwner �����õ�����ԭ������ֵ
     */
    public void setOldShipOwner(String oldShipOwner){
        this.oldShipOwner = StringUtils.rightTrim(oldShipOwner);
    }

    /**
     * ��ȡ����ԭ����
     * @return ����ԭ������ֵ
     */
    public String getOldShipOwner(){
        return oldShipOwner;
    }

    /**
     * �������Ա���Э��
     * @param associate �����õ����Ա���Э���ֵ
     */
    public void setAssociate(String associate){
        this.associate = StringUtils.rightTrim(associate);
    }

    /**
     * ��ȡ���Ա���Э��
     * @return ���Ա���Э���ֵ
     */
    public String getAssociate(){
        return associate;
    }

    /**
     * �������Խ�������
     * @param makeYearMonth �����õ����Խ������µ�ֵ
     */
    public void setMakeYearMonth(DateTime makeYearMonth){
        this.makeYearMonth = makeYearMonth;
    }

    /**
     * ��ȡ���Խ�������
     * @return ���Խ������µ�ֵ
     */
    public DateTime getMakeYearMonth(){
        return makeYearMonth;
    }

    /**
     * �������Թ��Ҵ���
     * @param countryCode �����õ����Թ��Ҵ����ֵ
     */
    public void setCountryCode(String countryCode){
        this.countryCode = StringUtils.rightTrim(countryCode);
    }

    /**
     * ��ȡ���Թ��Ҵ���
     * @return ���Թ��Ҵ����ֵ
     */
    public String getCountryCode(){
        return countryCode;
    }

    /**
     * �����������쳧��
     * @param makeFactory �����õ��������쳧�ҵ�ֵ
     */
    public void setMakeFactory(String makeFactory){
        this.makeFactory = StringUtils.rightTrim(makeFactory);
    }

    /**
     * ��ȡ�������쳧��
     * @return �������쳧�ҵ�ֵ
     */
    public String getMakeFactory(){
        return makeFactory;
    }

    /**
     * �������Խ��촬�����Ƽ���ַ
     * @param makeDock �����õ����Խ��촬�����Ƽ���ַ��ֵ
     */
    public void setMakeDock(String makeDock){
        this.makeDock = StringUtils.rightTrim(makeDock);
    }

    /**
     * ��ȡ���Խ��촬�����Ƽ���ַ
     * @return ���Խ��촬�����Ƽ���ַ��ֵ
     */
    public String getMakeDock(){
        return makeDock;
    }

    /**
     * �������Դ���
     * @param stepHull �����õ����Դ�����ֵ
     */
    public void setStepHull(String stepHull){
        this.stepHull = StringUtils.rightTrim(stepHull);
    }

    /**
     * ��ȡ���Դ���
     * @return ���Դ�����ֵ
     */
    public String getStepHull(){
        return stepHull;
    }

    /**
     * ��������ԭ����
     * @param oldStepHull �����õ�����ԭ������ֵ
     */
    public void setOldStepHull(String oldStepHull){
        this.oldStepHull = StringUtils.rightTrim(oldStepHull);
    }

    /**
     * ��ȡ����ԭ����
     * @return ����ԭ������ֵ
     */
    public String getOldStepHull(){
        return oldStepHull;
    }

    /**
     * �������Դ���
     * @param shipFlag �����õ����Դ����ֵ
     */
    public void setShipFlag(String shipFlag){
        this.shipFlag = StringUtils.rightTrim(shipFlag);
    }

    /**
     * ��ȡ���Դ���
     * @return ���Դ����ֵ
     */
    public String getShipFlag(){
        return shipFlag;
    }

    /**
     * �������Դ����������
     * @param shipType �����õ����Դ�����������ֵ
     */
    public void setShipType(String shipType){
        this.shipType = StringUtils.rightTrim(shipType);
    }

    /**
     * ��ȡ���Դ����������
     * @return ���Դ�����������ֵ
     */
    public String getShipType(){
        return shipType;
    }

    /**
     * �������Դ���ʹ�����ʴ���
     * @param useNature �����õ����Դ���ʹ�����ʴ����ֵ
     */
    public void setUseNature(String useNature){
        this.useNature = StringUtils.rightTrim(useNature);
    }

    /**
     * ��ȡ���Դ���ʹ�����ʴ���
     * @return ���Դ���ʹ�����ʴ����ֵ
     */
    public String getUseNature(){
        return useNature;
    }

    /**
     * �������Դ�����;
     * @param shipUsage �����õ����Դ�����;��ֵ
     */
    public void setShipUsage(String shipUsage){
        this.shipUsage = StringUtils.rightTrim(shipUsage);
    }

    /**
     * ��ȡ���Դ�����;
     * @return ���Դ�����;��ֵ
     */
    public String getShipUsage(){
        return shipUsage;
    }

    /**
     * �������Դ��ʽṹ����
     * @param shipStruct �����õ����Դ��ʽṹ�����ֵ
     */
    public void setShipStruct(String shipStruct){
        this.shipStruct = StringUtils.rightTrim(shipStruct);
    }

    /**
     * ��ȡ���Դ��ʽṹ����
     * @return ���Դ��ʽṹ�����ֵ
     */
    public String getShipStruct(){
        return shipStruct;
    }

    /**
     * ��������ע��ص�
     * @param registrySite �����õ�����ע��ص��ֵ
     */
    public void setRegistrySite(String registrySite){
        this.registrySite = StringUtils.rightTrim(registrySite);
    }

    /**
     * ��ȡ����ע��ص�
     * @return ����ע��ص��ֵ
     */
    public String getRegistrySite(){
        return registrySite;
    }

    /**
     * ���������ܶ�λ
     * @param tonCount �����õ������ܶ�λ��ֵ
     */
    public void setTonCount(double tonCount){
        this.tonCount = tonCount;
    }

    /**
     * ��ȡ�����ܶ�λ
     * @return �����ܶ�λ��ֵ
     */
    public double getTonCount(){
        return tonCount;
    }

    /**
     * �������Ծ���λ
     * @param netTonCount �����õ����Ծ���λ��ֵ
     */
    public void setNetTonCount(double netTonCount){
        this.netTonCount = netTonCount;
    }

    /**
     * ��ȡ���Ծ���λ
     * @return ���Ծ���λ��ֵ
     */
    public double getNetTonCount(){
        return netTonCount;
    }

    /**
     * �������Թ���
     * @param horsePower �����õ����Թ��ʵ�ֵ
     */
    public void setHorsePower(double horsePower){
        this.horsePower = horsePower;
    }

    /**
     * ��ȡ���Թ���
     * @return ���Թ��ʵ�ֵ
     */
    public double getHorsePower(){
        return horsePower;
    }

    /**
     * �������Թ��ʵ�λ
     * @param powerUnit �����õ����Թ��ʵ�λ��ֵ
     */
    public void setPowerUnit(String powerUnit){
        this.powerUnit = StringUtils.rightTrim(powerUnit);
    }

    /**
     * ��ȡ���Թ��ʵ�λ
     * @return ���Թ��ʵ�λ��ֵ
     */
    public String getPowerUnit(){
        return powerUnit;
    }

    /**
     * �������Կ�λ
     * @param seatCount �����õ����Կ�λ��ֵ
     */
    public void setSeatCount(int seatCount){
        this.seatCount = seatCount;
    }

    /**
     * ��ȡ���Կ�λ
     * @return ���Կ�λ��ֵ
     */
    public int getSeatCount(){
        return seatCount;
    }

    /**
     * �����������ض�
     * @param loadTon �����õ��������ضֵ�ֵ
     */
    public void setLoadTon(double loadTon){
        this.loadTon = loadTon;
    }

    /**
     * ��ȡ�������ض�
     * @return �������ضֵ�ֵ
     */
    public double getLoadTon(){
        return loadTon;
    }

    /**
     * ���������ܳ�
     * @param shipLength �����õ������ܳ���ֵ
     */
    public void setShipLength(double shipLength){
        this.shipLength = shipLength;
    }

    /**
     * ��ȡ�����ܳ�
     * @return �����ܳ���ֵ
     */
    public double getShipLength(){
        return shipLength;
    }

    /**
     * ���������Ϳ�
     * @param shipWidth �����õ������Ϳ��ֵ
     */
    public void setShipWidth(double shipWidth){
        this.shipWidth = shipWidth;
    }

    /**
     * ��ȡ�����Ϳ�
     * @return �����Ϳ��ֵ
     */
    public double getShipWidth(){
        return shipWidth;
    }

    /**
     * ������������
     * @param shipDepth �����õ����������ֵ
     */
    public void setShipDepth(double shipDepth){
        this.shipDepth = shipDepth;
    }

    /**
     * ��ȡ��������
     * @return ���������ֵ
     */
    public double getShipDepth(){
        return shipDepth;
    }

    /**
     * �������Դ�����ֵ
     * @param shipValue �����õ����Դ�����ֵ��ֵ
     */
    public void setShipValue(double shipValue){
        this.shipValue = shipValue;
    }

    /**
     * ��ȡ���Դ�����ֵ
     * @return ���Դ�����ֵ��ֵ
     */
    public double getShipValue(){
        return shipValue;
    }

    /**
     * �������Դ���֤����������������
     * @param certificateOwner �����õ����Դ���֤���������������˵�ֵ
     */
    public void setCertificateOwner(String certificateOwner){
        this.certificateOwner = StringUtils.rightTrim(certificateOwner);
    }

    /**
     * ��ȡ���Դ���֤����������������
     * @return ���Դ���֤���������������˵�ֵ
     */
    public String getCertificateOwner(){
        return certificateOwner;
    }

    /**
     * ��������ʵ��������
     * @param actualOwner �����õ�����ʵ�������˵�ֵ
     */
    public void setActualOwner(String actualOwner){
        this.actualOwner = StringUtils.rightTrim(actualOwner);
    }

    /**
     * ��ȡ����ʵ��������
     * @return ����ʵ�������˵�ֵ
     */
    public String getActualOwner(){
        return actualOwner;
    }

    /**
     * �������Ծ�Ӫ������
     * @param proprietorName �����õ����Ծ�Ӫ�����Ƶ�ֵ
     */
    public void setProprietorName(String proprietorName){
        this.proprietorName = StringUtils.rightTrim(proprietorName);
    }

    /**
     * ��ȡ���Ծ�Ӫ������
     * @return ���Ծ�Ӫ�����Ƶ�ֵ
     */
    public String getProprietorName(){
        return proprietorName;
    }

    /**
     * �������Ծ�Ӫ��ʽ
     * @param manageType �����õ����Ծ�Ӫ��ʽ��ֵ
     */
    public void setManageType(String manageType){
        this.manageType = StringUtils.rightTrim(manageType);
    }

    /**
     * ��ȡ���Ծ�Ӫ��ʽ
     * @return ���Ծ�Ӫ��ʽ��ֵ
     */
    public String getManageType(){
        return manageType;
    }

    /**
     * �������Ծ�Ӫˮ·�������֤����Ч����
     * @param manageStartDate �����õ����Ծ�Ӫˮ·�������֤����Ч���ڵ�ֵ
     */
    public void setManageStartDate(DateTime manageStartDate){
        this.manageStartDate = manageStartDate;
    }

    /**
     * ��ȡ���Ծ�Ӫˮ·�������֤����Ч����
     * @return ���Ծ�Ӫˮ·�������֤����Ч���ڵ�ֵ
     */
    public DateTime getManageStartDate(){
        return manageStartDate;
    }

    /**
     * �������Ծ�Ӫˮ·�������֤����Чֹ��
     * @param manageEndDate �����õ����Ծ�Ӫˮ·�������֤����Чֹ�ڵ�ֵ
     */
    public void setManageEndDate(DateTime manageEndDate){
        this.manageEndDate = manageEndDate;
    }

    /**
     * ��ȡ���Ծ�Ӫˮ·�������֤����Чֹ��
     * @return ���Ծ�Ӫˮ·�������֤����Чֹ�ڵ�ֵ
     */
    public DateTime getManageEndDate(){
        return manageEndDate;
    }

    /**
     * �������Դ�������֤����Ч����
     * @param checkStartDate �����õ����Դ�������֤����Ч���ڵ�ֵ
     */
    public void setCheckStartDate(DateTime checkStartDate){
        this.checkStartDate = checkStartDate;
    }

    /**
     * ��ȡ���Դ�������֤����Ч����
     * @return ���Դ�������֤����Ч���ڵ�ֵ
     */
    public DateTime getCheckStartDate(){
        return checkStartDate;
    }

    /**
     * �������Դ�������֤����Чֹ��
     * @param checkEndDate �����õ����Դ�������֤����Чֹ�ڵ�ֵ
     */
    public void setCheckEndDate(DateTime checkEndDate){
        this.checkEndDate = checkEndDate;
    }

    /**
     * ��ȡ���Դ�������֤����Чֹ��
     * @return ���Դ�������֤����Чֹ�ڵ�ֵ
     */
    public DateTime getCheckEndDate(){
        return checkEndDate;
    }

    /**
     * �������Դ���ծ���
     * @param debtAmount �����õ����Դ���ծ����ֵ
     */
    public void setDebtAmount(int debtAmount){
        this.debtAmount = debtAmount;
    }

    /**
     * ��ȡ���Դ���ծ���
     * @return ���Դ���ծ����ֵ
     */
    public int getDebtAmount(){
        return debtAmount;
    }

    /**
     * �������Ե�Ѻ��־(0/1)
     * @param pledge �����õ����Ե�Ѻ��־(0/1)��ֵ
     */
    public void setPledge(String pledge){
        this.pledge = StringUtils.rightTrim(pledge);
    }

    /**
     * ��ȡ���Ե�Ѻ��־(0/1)
     * @return ���Ե�Ѻ��־(0/1)��ֵ
     */
    public String getPledge(){
        return pledge;
    }

    /**
     * �������Դ����Ľ���λ
     * @param rebuildCompany �����õ����Դ����Ľ���λ��ֵ
     */
    public void setRebuildCompany(String rebuildCompany){
        this.rebuildCompany = StringUtils.rightTrim(rebuildCompany);
    }

    /**
     * ��ȡ���Դ����Ľ���λ
     * @return ���Դ����Ľ���λ��ֵ
     */
    public String getRebuildCompany(){
        return rebuildCompany;
    }

    /**
     * �������Դ����Ľ�ʱ��
     * @param rebuildDate �����õ����Դ����Ľ�ʱ���ֵ
     */
    public void setRebuildDate(DateTime rebuildDate){
        this.rebuildDate = rebuildDate;
    }

    /**
     * ��ȡ���Դ����Ľ�ʱ��
     * @return ���Դ����Ľ�ʱ���ֵ
     */
    public DateTime getRebuildDate(){
        return rebuildDate;
    }

    /**
     * ���������µĴ�������
     * @param newShipCode �����õ������µĴ��������ֵ
     */
    public void setNewShipCode(String newShipCode){
        this.newShipCode = StringUtils.rightTrim(newShipCode);
    }

    /**
     * ��ȡ�����µĴ�������
     * @return �����µĴ��������ֵ
     */
    public String getNewShipCode(){
        return newShipCode;
    }

    /**
     * ��������Ч��״̬
     * @param validStatus �����õ�����Ч��״̬��ֵ
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * ��ȡ����Ч��״̬
     * @return ����Ч��״̬��ֵ
     */
    public String getValidStatus(){
        return validStatus;
    }

    /**
     * �������Ա�־�ֶ�
     * @param flag �����õ����Ա�־�ֶε�ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ���Ա�־�ֶ�
     * @return ���Ա�־�ֶε�ֵ
     */
    public String getFlag(){
        return flag;
    }
}
