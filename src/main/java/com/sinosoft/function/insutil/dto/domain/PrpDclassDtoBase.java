package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdclass�����ݴ���������<br>
 * ������ 2004-4-5 15:22:07<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDclassDtoBase implements Serializable{
    /** ����classcode */
    private String classCode = "";
    /** ����classname */
    private String className = "";
    /** ����classename */
    private String classEName = "";
    /** ����accCode */
    private String accCode = "";
    /** ����newclasscode */
    private String newClassCode = "";
    /** ����validstatus */
    private String validStatus = "";
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDclassDtoBase����
     */
    public PrpDclassDtoBase(){
    }

    /**
     * ��������classcode
     * @param classCode �����õ�����classcode��ֵ
     */
    public void setClassCode(String classCode){
        this.classCode = StringUtils.rightTrim(classCode);
    }

    /**
     * ��ȡ����classcode
     * @return ����classcode��ֵ
     */
    public String getClassCode(){
        return classCode;
    }

    /**
     * ��������classname
     * @param className �����õ�����classname��ֵ
     */
    public void setClassName(String className){
        this.className = StringUtils.rightTrim(className);
    }

    /**
     * ��ȡ����classname
     * @return ����classname��ֵ
     */
    public String getClassName(){
        return className;
    }

    /**
     * ��������classename
     * @param classEName �����õ�����classename��ֵ
     */
    public void setClassEName(String classEName){
        this.classEName = StringUtils.rightTrim(classEName);
    }

    /**
     * ��ȡ����classename
     * @return ����classename��ֵ
     */
    public String getClassEName(){
        return classEName;
    }

    /**
     * ��������accCode
     * @param accCode �����õ�����accCode��ֵ
     */
    public void setAccCode(String accCode){
        this.accCode = StringUtils.rightTrim(accCode);
    }

    /**
     * ��ȡ����accCode
     * @return ����accCode��ֵ
     */
    public String getAccCode(){
        return accCode;
    }

    /**
     * ��������newclasscode
     * @param newClassCode �����õ�����newclasscode��ֵ
     */
    public void setNewClassCode(String newClassCode){
        this.newClassCode = StringUtils.rightTrim(newClassCode);
    }

    /**
     * ��ȡ����newclasscode
     * @return ����newclasscode��ֵ
     */
    public String getNewClassCode(){
        return newClassCode;
    }

    /**
     * ��������validstatus
     * @param validStatus �����õ�����validstatus��ֵ
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * ��ȡ����validstatus
     * @return ����validstatus��ֵ
     */
    public String getValidStatus(){
        return validStatus;
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
