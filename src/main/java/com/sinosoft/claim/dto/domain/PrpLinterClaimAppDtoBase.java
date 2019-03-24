package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����������������Ϣ�����ݴ���������<br>
 */
public class PrpLinterClaimAppDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ��������pk */
    private String id = "";
    /** ������� PK */
    private int serialNo = 0;
    /** �������� */
    private String acciName = "";
    /** �������֤���� */
    private String identifyNumber = "";
    /** �������¹��߹�ϵ */
    private String relationCode = "";
    /** ������ϵ�绰 */
    private String phone = "";
    /** ����ͨѶ��ַ */
    private String proposerAddress = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLinterClaimAppDtoBase����
     */
    public PrpLinterClaimAppDtoBase(){
    }

    /**
     * ������������pk
     * @param id �����õ���������pk��ֵ
     */
    public void setId(String id){
        this.id = StringUtils.rightTrim(id);
    }

    /**
     * ��ȡ��������pk
     * @return ��������pk��ֵ
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
     * ������������
     * @param acciName �����õ�����������ֵ
     */
    public void setAcciName(String acciName){
        this.acciName = StringUtils.rightTrim(acciName);
    }

    /**
     * ��ȡ��������
     * @return ����������ֵ
     */
    public String getAcciName(){
        return acciName;
    }

    /**
     * �����������֤����
     * @param identifyNumber �����õ��������֤�����ֵ
     */
    public void setIdentifyNumber(String identifyNumber){
        this.identifyNumber = StringUtils.rightTrim(identifyNumber);
    }

    /**
     * ��ȡ�������֤����
     * @return �������֤�����ֵ
     */
    public String getIdentifyNumber(){
        return identifyNumber;
    }

    /**
     * �����������¹��߹�ϵ
     * @param relationCode �����õ��������¹��߹�ϵ��ֵ
     */
    public void setRelationCode(String relationCode){
        this.relationCode = StringUtils.rightTrim(relationCode);
    }

    /**
     * ��ȡ�������¹��߹�ϵ
     * @return �������¹��߹�ϵ��ֵ
     */
    public String getRelationCode(){
        return relationCode;
    }

    /**
     * ����������ϵ�绰
     * @param phone �����õ�������ϵ�绰��ֵ
     */
    public void setPhone(String phone){
        this.phone = StringUtils.rightTrim(phone);
    }

    /**
     * ��ȡ������ϵ�绰
     * @return ������ϵ�绰��ֵ
     */
    public String getPhone(){
        return phone;
    }

    /**
     * ��������ͨѶ��ַ
     * @param proposerAddress �����õ�����ͨѶ��ַ��ֵ
     */
    public void setProposerAddress(String proposerAddress){
        this.proposerAddress = StringUtils.rightTrim(proposerAddress);
    }

    /**
     * ��ȡ����ͨѶ��ַ
     * @return ����ͨѶ��ַ��ֵ
     */
    public String getProposerAddress(){
        return proposerAddress;
    }
}
