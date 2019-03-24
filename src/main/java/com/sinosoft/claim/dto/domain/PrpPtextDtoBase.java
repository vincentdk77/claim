package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpptext����������Ϣ�����ݴ���������<br>
 * ������ 2004-11-22 15:24:13.093<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpPtextDtoBase implements Serializable{
    /** ���������Ŵ� */
    private String endorseNo = "";
    /** ���Ա��յ��Ŵ� */
    private String policyNo = "";
    /** �������ĵ��к� */
    private int lineNo = 0;
    /** ������������ */
    private String endorseText = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpPtextDtoBase����
     */
    public PrpPtextDtoBase(){
    }

    /**
     * �������������Ŵ�
     * @param endorseNo �����õ����������Ŵε�ֵ
     */
    public void setEndorseNo(String endorseNo){
        this.endorseNo = StringUtils.rightTrim(endorseNo);
    }

    /**
     * ��ȡ���������Ŵ�
     * @return ���������Ŵε�ֵ
     */
    public String getEndorseNo(){
        return endorseNo;
    }

    /**
     * �������Ա��յ��Ŵ�
     * @param policyNo �����õ����Ա��յ��Ŵε�ֵ
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * ��ȡ���Ա��յ��Ŵ�
     * @return ���Ա��յ��Ŵε�ֵ
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * �����������ĵ��к�
     * @param lineNo �����õ��������ĵ��кŵ�ֵ
     */
    public void setLineNo(int lineNo){
        this.lineNo = lineNo;
    }

    /**
     * ��ȡ�������ĵ��к�
     * @return �������ĵ��кŵ�ֵ
     */
    public int getLineNo(){
        return lineNo;
    }

    /**
     * ����������������
     * @param endorseText �����õ������������ݵ�ֵ
     */
    public void setEndorseText(String endorseText){
        this.endorseText = StringUtils.rightTrim(endorseText);
    }

    /**
     * ��ȡ������������
     * @return �����������ݵ�ֵ
     */
    public String getEndorseText(){
        return endorseText;
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
