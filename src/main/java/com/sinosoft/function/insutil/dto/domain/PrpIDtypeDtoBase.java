package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpidtype�����ݴ���������<br>
 * ������ 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpIDtypeDtoBase implements Serializable{
    /** ����codetype */
    private String codeType = "";
    /** ����codetypedesc */
    private String codeTypeDesc = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpIDtypeDtoBase����
     */
    public PrpIDtypeDtoBase(){
    }

    /**
     * ��������codetype
     * @param codeType �����õ�����codetype��ֵ
     */
    public void setCodeType(String codeType){
        this.codeType = StringUtils.rightTrim(codeType);
    }

    /**
     * ��ȡ����codetype
     * @return ����codetype��ֵ
     */
    public String getCodeType(){
        return codeType;
    }

    /**
     * ��������codetypedesc
     * @param codeTypeDesc �����õ�����codetypedesc��ֵ
     */
    public void setCodeTypeDesc(String codeTypeDesc){
        this.codeTypeDesc = StringUtils.rightTrim(codeTypeDesc);
    }

    /**
     * ��ȡ����codetypedesc
     * @return ����codetypedesc��ֵ
     */
    public String getCodeTypeDesc(){
        return codeTypeDesc;
    }
}
