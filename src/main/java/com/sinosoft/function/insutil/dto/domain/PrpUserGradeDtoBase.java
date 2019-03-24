package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpusergrade�����ݴ���������<br>
 * ������ 2004-4-5 15:22:07<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpUserGradeDtoBase implements Serializable{
    /** ����usercode */
    private String userCode = "";
    /** ����groupcode */
    private String groupCode = "";
    /** ����taskcode */
    private String taskCode = "";
    /** ����checkcode */
    private String checkCode = "";
    /** ����value */
    private String value = "";
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpUserGradeDtoBase����
     */
    public PrpUserGradeDtoBase(){
    }

    /**
     * ��������usercode
     * @param userCode �����õ�����usercode��ֵ
     */
    public void setUserCode(String userCode){
        this.userCode = StringUtils.rightTrim(userCode);
    }

    /**
     * ��ȡ����usercode
     * @return ����usercode��ֵ
     */
    public String getUserCode(){
        return userCode;
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
     * ��������taskcode
     * @param taskCode �����õ�����taskcode��ֵ
     */
    public void setTaskCode(String taskCode){
        this.taskCode = StringUtils.rightTrim(taskCode);
    }

    /**
     * ��ȡ����taskcode
     * @return ����taskcode��ֵ
     */
    public String getTaskCode(){
        return taskCode;
    }

    /**
     * ��������checkcode
     * @param checkCode �����õ�����checkcode��ֵ
     */
    public void setCheckCode(String checkCode){
        this.checkCode = StringUtils.rightTrim(checkCode);
    }

    /**
     * ��ȡ����checkcode
     * @return ����checkcode��ֵ
     */
    public String getCheckCode(){
        return checkCode;
    }

    /**
     * ��������value
     * @param value �����õ�����value��ֵ
     */
    public void setValue(String value){
        this.value = StringUtils.rightTrim(value);
    }

    /**
     * ��ȡ����value
     * @return ����value��ֵ
     */
    public String getValue(){
        return value;
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
