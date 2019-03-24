package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpgrade��λ���������ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpGradeDtoBase implements Serializable{
    /** ���Ը�λ���� */
    private String gradeCode = "";
    /** ���Ը�λ���� */
    private String gradeName = "";
    /** ����Ȩ������ */
    private String power = "";
    /** ���Ա�־λ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpGradeDtoBase����
     */
    public PrpGradeDtoBase(){
    }

    /**
     * �������Ը�λ����
     * @param gradeCode �����õ����Ը�λ�����ֵ
     */
    public void setGradeCode(String gradeCode){
        this.gradeCode = StringUtils.rightTrim(gradeCode);
    }

    /**
     * ��ȡ���Ը�λ����
     * @return ���Ը�λ�����ֵ
     */
    public String getGradeCode(){
        return gradeCode;
    }

    /**
     * �������Ը�λ����
     * @param gradeName �����õ����Ը�λ���Ƶ�ֵ
     */
    public void setGradeName(String gradeName){
        this.gradeName = StringUtils.rightTrim(gradeName);
    }

    /**
     * ��ȡ���Ը�λ����
     * @return ���Ը�λ���Ƶ�ֵ
     */
    public String getGradeName(){
        return gradeName;
    }

    /**
     * ��������Ȩ������
     * @param power �����õ�����Ȩ�����õ�ֵ
     */
    public void setPower(String power){
        this.power = StringUtils.rightTrim(power);
    }

    /**
     * ��ȡ����Ȩ������
     * @return ����Ȩ�����õ�ֵ
     */
    public String getPower(){
        return power;
    }

    /**
     * �������Ա�־λ
     * @param flag �����õ����Ա�־λ��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ���Ա�־λ
     * @return ���Ա�־λ��ֵ
     */
    public String getFlag(){
        return flag;
    }
}
