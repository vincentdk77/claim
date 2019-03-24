package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpgrant�����ݴ���������<br>
 * ������ 2004-4-5 15:22:07<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpGrantDtoBase implements Serializable{
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
    /** ����grantstartdate */
    private DateTime grantStartDate = new DateTime();
    /** ����grantenddate */
    private DateTime grantEndDate = new DateTime();
    /** ����condition */
    private String condition = "";
    /** ����remark */
    private String remark = "";
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpGrantDtoBase����
     */
    public PrpGrantDtoBase(){
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
     * ��������grantstartdate
     * @param grantStartDate �����õ�����grantstartdate��ֵ
     */
    public void setGrantStartDate(DateTime grantStartDate){
        this.grantStartDate = grantStartDate;
    }

    /**
     * ��ȡ����grantstartdate
     * @return ����grantstartdate��ֵ
     */
    public DateTime getGrantStartDate(){
        return grantStartDate;
    }

    /**
     * ��������grantenddate
     * @param grantEndDate �����õ�����grantenddate��ֵ
     */
    public void setGrantEndDate(DateTime grantEndDate){
        this.grantEndDate = grantEndDate;
    }

    /**
     * ��ȡ����grantenddate
     * @return ����grantenddate��ֵ
     */
    public DateTime getGrantEndDate(){
        return grantEndDate;
    }

    /**
     * ��������condition
     * @param condition �����õ�����condition��ֵ
     */
    public void setCondition(String condition){
        this.condition = StringUtils.rightTrim(condition);
    }

    /**
     * ��ȡ����condition
     * @return ����condition��ֵ
     */
    public String getCondition(){
        return condition;
    }

    /**
     * ��������remark
     * @param remark �����õ�����remark��ֵ
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * ��ȡ����remark
     * @return ����remark��ֵ
     */
    public String getRemark(){
        return remark;
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
