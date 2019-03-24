package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpgroup�����ݴ���������<br>
 * ������ 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpGroupDtoBase implements Serializable{
    /** ����groupno */
    private String groupNo = "";
    /** ����subgroupno */
    private String subGroupNo = "";
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpGroupDtoBase����
     */
    public PrpGroupDtoBase(){
    }

    /**
     * ��������groupno
     * @param groupNo �����õ�����groupno��ֵ
     */
    public void setGroupNo(String groupNo){
        this.groupNo = StringUtils.rightTrim(groupNo);
    }

    /**
     * ��ȡ����groupno
     * @return ����groupno��ֵ
     */
    public String getGroupNo(){
        return groupNo;
    }

    /**
     * ��������subgroupno
     * @param subGroupNo �����õ�����subgroupno��ֵ
     */
    public void setSubGroupNo(String subGroupNo){
        this.subGroupNo = StringUtils.rightTrim(subGroupNo);
    }

    /**
     * ��ȡ����subgroupno
     * @return ����subgroupno��ֵ
     */
    public String getSubGroupNo(){
        return subGroupNo;
    }

    /**
     * ��������flag
     * @param flag �����õ�����flag��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ����flag
     * @return ����flag��ֵ
     */
    public String getFlag(){
        return flag;
    }
}
