package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����utigroup�����ݴ���������<br>
 * ������ 2004-4-5 15:22:07<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiGroupDtoBase implements Serializable{
    /** ����groupcode */
    private String groupCode = "";
    /** ����groupname */
    private String groupName = "";
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�UtiGroupDtoBase����
     */
    public UtiGroupDtoBase(){
    }

    /**
     * ��������groupcode
     * @param groupCode �����õ�����groupcode��ֵ
     */
    public void setGroupCode(String groupCode){
        this.groupCode = StringUtils.rightTrim(groupCode);
    }

    /**
     * ��ȡ����groupcode
     * @return ����groupcode��ֵ
     */
    public String getGroupCode(){
        return groupCode;
    }

    /**
     * ��������groupname
     * @param groupName �����õ�����groupname��ֵ
     */
    public void setGroupName(String groupName){
        this.groupName = StringUtils.rightTrim(groupName);
    }

    /**
     * ��ȡ����groupname
     * @return ����groupname��ֵ
     */
    public String getGroupName(){
        return groupName;
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
