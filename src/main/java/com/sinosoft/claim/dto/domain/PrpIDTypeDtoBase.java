package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpidtype�ӿڴ������ͱ�����ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpIDTypeDtoBase implements Serializable{
    /** ���Խӿڴ������� */
    private String codeType = "";
    /** ���Դ����������� */
    private String codeTypeDesc = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpIDTypeDtoBase����
     */
    public PrpIDTypeDtoBase(){
    }

    /**
     * �������Խӿڴ�������
     * @param codeType �����õ����Խӿڴ������͵�ֵ
     */
    public void setCodeType(String codeType){
        this.codeType = StringUtils.rightTrim(codeType);
    }

    /**
     * ��ȡ���Խӿڴ�������
     * @return ���Խӿڴ������͵�ֵ
     */
    public String getCodeType(){
        return codeType;
    }

    /**
     * �������Դ�����������
     * @param codeTypeDesc �����õ����Դ�������������ֵ
     */
    public void setCodeTypeDesc(String codeTypeDesc){
        this.codeTypeDesc = StringUtils.rightTrim(codeTypeDesc);
    }

    /**
     * ��ȡ���Դ�����������
     * @return ���Դ�������������ֵ
     */
    public String getCodeTypeDesc(){
        return codeTypeDesc;
    }
}
