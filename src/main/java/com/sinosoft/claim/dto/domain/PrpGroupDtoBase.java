package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpgroup��֤��������ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpGroupDtoBase implements Serializable{
    /** ���Ժϱ��� */
    private String groupNo = "";
    /** ���Էֱ��� */
    private String subGroupNo = "";
    /** ���Ա�־ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpGroupDtoBase����
     */
    public PrpGroupDtoBase(){
    }

    /**
     * �������Ժϱ���
     * @param groupNo �����õ����Ժϱ����ֵ
     */
    public void setGroupNo(String groupNo){
        this.groupNo = StringUtils.rightTrim(groupNo);
    }

    /**
     * ��ȡ���Ժϱ���
     * @return ���Ժϱ����ֵ
     */
    public String getGroupNo(){
        return groupNo;
    }

    /**
     * �������Էֱ���
     * @param subGroupNo �����õ����Էֱ����ֵ
     */
    public void setSubGroupNo(String subGroupNo){
        this.subGroupNo = StringUtils.rightTrim(subGroupNo);
    }

    /**
     * ��ȡ���Էֱ���
     * @return ���Էֱ����ֵ
     */
    public String getSubGroupNo(){
        return subGroupNo;
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
