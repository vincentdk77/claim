package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpUndoCancel���ϻ�ɾ�������켣��������ݴ���������<br>
 * ������ 2004-4-5 15:32:06<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpUndoCancelDtoBase implements Serializable{
    /** ���Բ������� */
    private String operateTypeCode = "";
    /** ���Բ���������� */
    private String operateTypeName = "";
    /** ���Ե�֤�� */
    private String certiNo = "";
    /** ������� */
    private int serialNo = 0;
    /** ����Ͷ���˴��� */
    private String appliCode = "";
    /** ����Ͷ�������� */
    private String appliName = "";
    /** ����ҵ������������� */
    private String comCode = "";
    /** ���Գ����������� */
    private String makeCom = "";
    /** ���Ա�ע */
    private String remark = "";
    /** ���Ե�ǰ����Դ���� */
    private String operatorCode = "";
    /** ���Բ������� */
    private DateTime operateTime = new DateTime();
    /** ���Ա�־ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpUndoCancelDtoBase����
     */
    public PrpUndoCancelDtoBase(){
    }

    /**
     * �������Բ�������
     * @param operateTypeCode �����õ����Բ������͵�ֵ
     */
    public void setOperateTypeCode(String operateTypeCode){
        this.operateTypeCode = StringUtils.rightTrim(operateTypeCode);
    }

    /**
     * ��ȡ���Բ�������
     * @return ���Բ������͵�ֵ
     */
    public String getOperateTypeCode(){
        return operateTypeCode;
    }

    /**
     * �������Բ����������
     * @param operateTypeName �����õ����Բ���������衵�ֵ
     */
    public void setOperateTypeName(String operateTypeName){
        this.operateTypeName = StringUtils.rightTrim(operateTypeName);
    }

    /**
     * ��ȡ���Բ����������
     * @return ���Բ���������衵�ֵ
     */
    public String getOperateTypeName(){
        return operateTypeName;
    }

    /**
     * �������Ե�֤��
     * @param certiNo �����õ����Ե�֤�ŵ�ֵ
     */
    public void setCertiNo(String certiNo){
        this.certiNo = StringUtils.rightTrim(certiNo);
    }

    /**
     * ��ȡ���Ե�֤��
     * @return ���Ե�֤�ŵ�ֵ
     */
    public String getCertiNo(){
        return certiNo;
    }

    /**
     * �����������
     * @param serialNo �����õ�������ŵ�ֵ
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ�������
     * @return ������ŵ�ֵ
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * ��������Ͷ���˴���
     * @param appliCode �����õ�����Ͷ���˴����ֵ
     */
    public void setAppliCode(String appliCode){
        this.appliCode = StringUtils.rightTrim(appliCode);
    }

    /**
     * ��ȡ����Ͷ���˴���
     * @return ����Ͷ���˴����ֵ
     */
    public String getAppliCode(){
        return appliCode;
    }

    /**
     * ��������Ͷ��������
     * @param appliName �����õ�����Ͷ�������Ƶ�ֵ
     */
    public void setAppliName(String appliName){
        this.appliName = StringUtils.rightTrim(appliName);
    }

    /**
     * ��ȡ����Ͷ��������
     * @return ����Ͷ�������Ƶ�ֵ
     */
    public String getAppliName(){
        return appliName;
    }

    /**
     * ��������ҵ�������������
     * @param comCode �����õ�����ҵ��������������ֵ
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * ��ȡ����ҵ�������������
     * @return ����ҵ��������������ֵ
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * �������Գ�����������
     * @param makeCom �����õ����Գ������������ֵ
     */
    public void setMakeCom(String makeCom){
        this.makeCom = StringUtils.rightTrim(makeCom);
    }

    /**
     * ��ȡ���Գ�����������
     * @return ���Գ������������ֵ
     */
    public String getMakeCom(){
        return makeCom;
    }

    /**
     * �������Ա�ע
     * @param remark �����õ����Ա�ע��ֵ
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * ��ȡ���Ա�ע
     * @return ���Ա�ע��ֵ
     */
    public String getRemark(){
        return remark;
    }

    /**
     * �������Ե�ǰ����Դ����
     * @param operatorCode �����õ����Ե�ǰ����Դ�����ֵ
     */
    public void setOperatorCode(String operatorCode){
        this.operatorCode = StringUtils.rightTrim(operatorCode);
    }

    /**
     * ��ȡ���Ե�ǰ����Դ����
     * @return ���Ե�ǰ����Դ�����ֵ
     */
    public String getOperatorCode(){
        return operatorCode;
    }

    /**
     * �������Բ�������
     * @param operateTime �����õ����Բ������ڵ�ֵ
     */
    public void setOperateTime(DateTime operateTime){
        this.operateTime = operateTime;
    }

    /**
     * ��ȡ���Բ�������
     * @return ���Բ������ڵ�ֵ
     */
    public DateTime getOperateTime(){
        return operateTime;
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
