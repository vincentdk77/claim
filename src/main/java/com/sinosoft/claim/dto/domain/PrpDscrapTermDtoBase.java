package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdscrapterm�������ϱ�׼������ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDscrapTermDtoBase implements Serializable{
    /** ���Գ���������� */
    private String carKindCode = "";
    /** ����ʹ������ */
    private int useYear = 0;
    /** ���������ӳ����� */
    private int proLongYear = 0;
    /** ���Ա�־ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDscrapTermDtoBase����
     */
    public PrpDscrapTermDtoBase(){
    }

    /**
     * �������Գ����������
     * @param carKindCode �����õ����Գ�����������ֵ
     */
    public void setCarKindCode(String carKindCode){
        this.carKindCode = StringUtils.rightTrim(carKindCode);
    }

    /**
     * ��ȡ���Գ����������
     * @return ���Գ�����������ֵ
     */
    public String getCarKindCode(){
        return carKindCode;
    }

    /**
     * ��������ʹ������
     * @param useYear �����õ�����ʹ�����޵�ֵ
     */
    public void setUseYear(int useYear){
        this.useYear = useYear;
    }

    /**
     * ��ȡ����ʹ������
     * @return ����ʹ�����޵�ֵ
     */
    public int getUseYear(){
        return useYear;
    }

    /**
     * �������������ӳ�����
     * @param proLongYear �����õ����������ӳ����޵�ֵ
     */
    public void setProLongYear(int proLongYear){
        this.proLongYear = proLongYear;
    }

    /**
     * ��ȡ���������ӳ�����
     * @return ���������ӳ����޵�ֵ
     */
    public int getProLongYear(){
        return proLongYear;
    }

    /**
     * �������Ա�־
     * @param flag �����õ����Ա�־��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ���Ա�־
     * @return ���Ա�־��ֵ
     */
    public String getFlag(){
        return flag;
    }
}
