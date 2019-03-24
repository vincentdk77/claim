package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLthirdpartyStatus-���������ҵ��Ϣ������Ϣ״̬������ݴ���������<br>
 * ������ 2005-03-18 17:53:35.531<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLthirdpartyStatusDtoBase implements Serializable{
    /** ���Խ���ҵ����� */
    private String businessNo = "";
    /** ����Ӧ������ */
    private String bUSINESSTYPE = "";
    /** ������� */
    private int serialNo = 0;
    /** ���Խ�������  1:���� 2������ */
    private String aLTERNATETYPE = "";
    /** ���Խ���״̬��־��-- 0������ʧ��-- 1�����ͳɹ� */
    private String aLTERNATEFLAG = "";
    /** ���Է�������ʱ�Ĵ������ */
    private String eRRORNO = "";
    /** ���Խ���ʱ�� */
    private DateTime aLTERNATEDATE = new DateTime();
    /** ���Խ���Сʱ */
    private int aLTERNATEHOUR = 0;
    /** ���Դ������� */
    private String eRRORMESSAGE = "";
    /** ���Ա�־λ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLthirdpartyStatusDtoBase����
     */
    public PrpLthirdpartyStatusDtoBase(){
    }

    /**
     * �������Խ���ҵ�����
     * @param businessNo �����õ����Խ���ҵ������ֵ
     */
    public void setBusinessNo(String businessNo){
        this.businessNo = StringUtils.rightTrim(businessNo);
    }

    /**
     * ��ȡ���Խ���ҵ�����
     * @return ���Խ���ҵ������ֵ
     */
    public String getBusinessNo(){
        return businessNo;
    }

    /**
     * ��������Ӧ������
     * @param bUSINESSTYPE �����õ�����Ӧ�����͵�ֵ
     */
    public void setBUSINESSTYPE(String bUSINESSTYPE){
        this.bUSINESSTYPE = StringUtils.rightTrim(bUSINESSTYPE);
    }

    /**
     * ��ȡ����Ӧ������
     * @return ����Ӧ�����͵�ֵ
     */
    public String getBUSINESSTYPE(){
        return bUSINESSTYPE;
    }

    /**
     * �����������
     * @param serialNo �����õ�������ŵ�ֵ
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ�������
     * @return ������ŵ�ֵ
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * �������Խ�������  1:���� 2������
     * @param aLTERNATETYPE �����õ����Խ�������  1:���� 2�����յ�ֵ
     */
    public void setALTERNATETYPE(String aLTERNATETYPE){
        this.aLTERNATETYPE = StringUtils.rightTrim(aLTERNATETYPE);
    }

    /**
     * ��ȡ���Խ�������  1:���� 2������
     * @return ���Խ�������  1:���� 2�����յ�ֵ
     */
    public String getALTERNATETYPE(){
        return aLTERNATETYPE;
    }

    /**
     * �������Խ���״̬��־��-- 0������ʧ��-- 1�����ͳɹ�
     * @param aLTERNATEFLAG �����õ����Խ���״̬��־��-- 0������ʧ��-- 1�����ͳɹ���ֵ
     */
    public void setALTERNATEFLAG(String aLTERNATEFLAG){
        this.aLTERNATEFLAG = StringUtils.rightTrim(aLTERNATEFLAG);
    }

    /**
     * ��ȡ���Խ���״̬��־��-- 0������ʧ��-- 1�����ͳɹ�
     * @return ���Խ���״̬��־��-- 0������ʧ��-- 1�����ͳɹ���ֵ
     */
    public String getALTERNATEFLAG(){
        return aLTERNATEFLAG;
    }

    /**
     * �������Է�������ʱ�Ĵ������
     * @param eRRORNO �����õ����Է�������ʱ�Ĵ�������ֵ
     */
    public void setERRORNO(String eRRORNO){
        this.eRRORNO = StringUtils.rightTrim(eRRORNO);
    }

    /**
     * ��ȡ���Է�������ʱ�Ĵ������
     * @return ���Է�������ʱ�Ĵ�������ֵ
     */
    public String getERRORNO(){
        return eRRORNO;
    }

    /**
     * �������Խ���ʱ��
     * @param aLTERNATEDATE �����õ����Խ���ʱ���ֵ
     */
    public void setALTERNATEDATE(DateTime aLTERNATEDATE){
        this.aLTERNATEDATE = aLTERNATEDATE;
    }

    /**
     * ��ȡ���Խ���ʱ��
     * @return ���Խ���ʱ���ֵ
     */
    public DateTime getALTERNATEDATE(){
        return aLTERNATEDATE;
    }

    /**
     * �������Խ���Сʱ
     * @param aLTERNATEHOUR �����õ����Խ���Сʱ��ֵ
     */
    public void setALTERNATEHOUR(int aLTERNATEHOUR){
        this.aLTERNATEHOUR = aLTERNATEHOUR;
    }

    /**
     * ��ȡ���Խ���Сʱ
     * @return ���Խ���Сʱ��ֵ
     */
    public int getALTERNATEHOUR(){
        return aLTERNATEHOUR;
    }

    /**
     * �������Դ�������
     * @param eRRORMESSAGE �����õ����Դ���������ֵ
     */
    public void setERRORMESSAGE(String eRRORMESSAGE){
        this.eRRORMESSAGE = StringUtils.rightTrim(eRRORMESSAGE);
    }

    /**
     * ��ȡ���Դ�������
     * @return ���Դ���������ֵ
     */
    public String getERRORMESSAGE(){
        return eRRORMESSAGE;
    }

    /**
     * �������Ա�־λ
     * @param flag �����õ����Ա�־λ��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ���Ա�־λ
     * @return ���Ա�־λ��ֵ
     */
    public String getFlag(){
        return flag;
    }
}
