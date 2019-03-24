package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ������ϯԱ����Ϣ������ݴ���������<br>
 * ������ 2005-07-19 09:58:46.101<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class ED_AGENT_INFODtoBase implements Serializable{
    /** ������ϯ���� */
    private String aGENTID = "";
    /** �������� */
    private String aGENTPSWD = "";
    /** ����Ա������ */
    private String aGENTTYPE = "";
    /** ������� */
    private String aGENTACD = "";
    /** ����Ա������ */
    private String aGENTNAME = "";
    /** �����Ա� */
    private String gENDER = "";
    /** ���Բ��� */
    private String dEPT = "";
    /** ���Թ��� */
    private String mANAGEQUEUES = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�ED_AGENT_INFODtoBase����
     */
    public ED_AGENT_INFODtoBase(){
    }

    /**
     * ����������ϯ����
     * @param aGENTID �����õ�������ϯ���ŵ�ֵ
     */
    public void setAGENTID(String aGENTID){
        this.aGENTID = StringUtils.rightTrim(aGENTID);
    }

    /**
     * ��ȡ������ϯ����
     * @return ������ϯ���ŵ�ֵ
     */
    public String getAGENTID(){
        return aGENTID;
    }

    /**
     * ������������
     * @param aGENTPSWD �����õ����������ֵ
     */
    public void setAGENTPSWD(String aGENTPSWD){
        this.aGENTPSWD = StringUtils.rightTrim(aGENTPSWD);
    }

    /**
     * ��ȡ��������
     * @return ���������ֵ
     */
    public String getAGENTPSWD(){
        return aGENTPSWD;
    }

    /**
     * ��������Ա������
     * @param aGENTTYPE �����õ�����Ա�����͵�ֵ
     */
    public void setAGENTTYPE(String aGENTTYPE){
        this.aGENTTYPE = StringUtils.rightTrim(aGENTTYPE);
    }

    /**
     * ��ȡ����Ա������
     * @return ����Ա�����͵�ֵ
     */
    public String getAGENTTYPE(){
        return aGENTTYPE;
    }

    /**
     * �����������
     * @param aGENTACD �����õ�������ŵ�ֵ
     */
    public void setAGENTACD(String aGENTACD){
        this.aGENTACD = StringUtils.rightTrim(aGENTACD);
    }

    /**
     * ��ȡ�������
     * @return ������ŵ�ֵ
     */
    public String getAGENTACD(){
        return aGENTACD;
    }

    /**
     * ��������Ա������
     * @param aGENTNAME �����õ�����Ա��������ֵ
     */
    public void setAGENTNAME(String aGENTNAME){
        this.aGENTNAME = StringUtils.rightTrim(aGENTNAME);
    }

    /**
     * ��ȡ����Ա������
     * @return ����Ա��������ֵ
     */
    public String getAGENTNAME(){
        return aGENTNAME;
    }

    /**
     * ���������Ա�
     * @param gENDER �����õ������Ա��ֵ
     */
    public void setGENDER(String gENDER){
        this.gENDER = StringUtils.rightTrim(gENDER);
    }

    /**
     * ��ȡ�����Ա�
     * @return �����Ա��ֵ
     */
    public String getGENDER(){
        return gENDER;
    }

    /**
     * �������Բ���
     * @param dEPT �����õ����Բ��ŵ�ֵ
     */
    public void setDEPT(String dEPT){
        this.dEPT = StringUtils.rightTrim(dEPT);
    }

    /**
     * ��ȡ���Բ���
     * @return ���Բ��ŵ�ֵ
     */
    public String getDEPT(){
        return dEPT;
    }

    /**
     * �������Թ���
     * @param mANAGEQUEUES �����õ����Թ����ֵ
     */
    public void setMANAGEQUEUES(String mANAGEQUEUES){
        this.mANAGEQUEUES = StringUtils.rightTrim(mANAGEQUEUES);
    }

    /**
     * ��ȡ���Թ���
     * @return ���Թ����ֵ
     */
    public String getMANAGEQUEUES(){
        return mANAGEQUEUES;
    }
}
