package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpLJobLinker�����ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLJobLinkerDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����StaffId */
    private String staffId = "";
    /** ����StaffPosition */
    private String staffPosition = "";
    /** ����StaffUserCode */
    private String staffUserCode = "";
    /** ����StaffName */
    private String staffName = "";
    /** ����StaffPhone */
    private String staffPhone = "";
    /** ����StaffType */
    private String staffType = "";
    /** ����Handledept */
    private String handledept = "";
    /** ����Month */
    private String month = "";
    /** ����FlowinTime */
    private String flowinTime = "";
    /** ����ModifyTime */
    private String modifyTime = "";
    /** ����ClassCode */
    private String classCode = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLJobLinkerDtoBase����
     */
    public PrpLJobLinkerDtoBase(){
    }

    /**
     * ��������StaffId
     * @param staffId �����õ�����StaffId��ֵ
     */
    public void setStaffId(String staffId){
        this.staffId = StringUtils.rightTrim(staffId);
    }

    /**
     * ��ȡ����StaffId
     * @return ����StaffId��ֵ
     */
    public String getStaffId(){
        return staffId;
    }

    /**
     * ��������StaffPosition
     * @param staffPosition �����õ�����StaffPosition��ֵ
     */
    public void setStaffPosition(String staffPosition){
        this.staffPosition = StringUtils.rightTrim(staffPosition);
    }

    /**
     * ��ȡ����StaffPosition
     * @return ����StaffPosition��ֵ
     */
    public String getStaffPosition(){
        return staffPosition;
    }

    /**
     * ��������StaffUserCode
     * @param staffUserCode �����õ�����StaffUserCode��ֵ
     */
    public void setStaffUserCode(String staffUserCode){
        this.staffUserCode = StringUtils.rightTrim(staffUserCode);
    }

    /**
     * ��ȡ����StaffUserCode
     * @return ����StaffUserCode��ֵ
     */
    public String getStaffUserCode(){
        return staffUserCode;
    }

    /**
     * ��������StaffName
     * @param staffName �����õ�����StaffName��ֵ
     */
    public void setStaffName(String staffName){
        this.staffName = StringUtils.rightTrim(staffName);
    }

    /**
     * ��ȡ����StaffName
     * @return ����StaffName��ֵ
     */
    public String getStaffName(){
        return staffName;
    }

    /**
     * ��������StaffPhone
     * @param staffPhone �����õ�����StaffPhone��ֵ
     */
    public void setStaffPhone(String staffPhone){
        this.staffPhone = StringUtils.rightTrim(staffPhone);
    }

    /**
     * ��ȡ����StaffPhone
     * @return ����StaffPhone��ֵ
     */
    public String getStaffPhone(){
        return staffPhone;
    }

    /**
     * ��������StaffType
     * @param staffType �����õ�����StaffType��ֵ
     */
    public void setStaffType(String staffType){
        this.staffType = StringUtils.rightTrim(staffType);
    }

    /**
     * ��ȡ����StaffType
     * @return ����StaffType��ֵ
     */
    public String getStaffType(){
        return staffType;
    }

    /**
     * ��������Handledept
     * @param handledept �����õ�����Handledept��ֵ
     */
    public void setHandledept(String handledept){
        this.handledept = StringUtils.rightTrim(handledept);
    }

    /**
     * ��ȡ����Handledept
     * @return ����Handledept��ֵ
     */
    public String getHandledept(){
        return handledept;
    }

    /**
     * ��������Month
     * @param month �����õ�����Month��ֵ
     */
    public void setMonth(String month){
        this.month = StringUtils.rightTrim(month);
    }

    /**
     * ��ȡ����Month
     * @return ����Month��ֵ
     */
    public String getMonth(){
        return month;
    }

    /**
     * ��������FlowinTime
     * @param flowinTime �����õ�����FlowinTime��ֵ
     */
    public void setFlowinTime(String flowinTime){
        this.flowinTime = StringUtils.rightTrim(flowinTime);
    }

    /**
     * ��ȡ����FlowinTime
     * @return ����FlowinTime��ֵ
     */
    public String getFlowinTime(){
        return flowinTime;
    }

    /**
     * ��������ModifyTime
     * @param modifyTime �����õ�����ModifyTime��ֵ
     */
    public void setModifyTime(String modifyTime){
        this.modifyTime = StringUtils.rightTrim(modifyTime);
    }

    /**
     * ��ȡ����ModifyTime
     * @return ����ModifyTime��ֵ
     */
    public String getModifyTime(){
        return modifyTime;
    }

    /**
     * ��������ClassCode
     * @param classCode �����õ�����ClassCode��ֵ
     */
    public void setClassCode(String classCode){
        this.classCode = StringUtils.rightTrim(classCode);
    }

    /**
     * ��ȡ����ClassCode
     * @return ����ClassCode��ֵ
     */
    public String getClassCode(){
        return classCode;
    }
}
