package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdstatitype����ͳ�Ʒ��������ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDstatiTypeDtoBase implements Serializable{
    /** �������� */
    private String riskCode = "";
    /** �����ձ� */
    private String kindCode = "";
    /** ����ͳ������ */
    private String belongType = "";
    /** ������Ч���� */
    private DateTime validDate = new DateTime();
    /** ����Ԥ����־ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDstatiTypeDtoBase����
     */
    public PrpDstatiTypeDtoBase(){
    }

    /**
     * ������������
     * @param riskCode �����õ��������ֵ�ֵ
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * ��ȡ��������
     * @return �������ֵ�ֵ
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * ���������ձ�
     * @param kindCode �����õ������ձ��ֵ
     */
    public void setKindCode(String kindCode){
        this.kindCode = StringUtils.rightTrim(kindCode);
    }

    /**
     * ��ȡ�����ձ�
     * @return �����ձ��ֵ
     */
    public String getKindCode(){
        return kindCode;
    }

    /**
     * ��������ͳ������
     * @param belongType �����õ�����ͳ�����͵�ֵ
     */
    public void setBelongType(String belongType){
        this.belongType = StringUtils.rightTrim(belongType);
    }

    /**
     * ��ȡ����ͳ������
     * @return ����ͳ�����͵�ֵ
     */
    public String getBelongType(){
        return belongType;
    }

    /**
     * ����������Ч����
     * @param validDate �����õ�������Ч���ڵ�ֵ
     */
    public void setValidDate(DateTime validDate){
        this.validDate = validDate;
    }

    /**
     * ��ȡ������Ч����
     * @return ������Ч���ڵ�ֵ
     */
    public DateTime getValidDate(){
        return validDate;
    }

    /**
     * ��������Ԥ����־
     * @param flag �����õ�����Ԥ����־��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ����Ԥ����־
     * @return ����Ԥ����־��ֵ
     */
    public String getFlag(){
        return flag;
    }
}
