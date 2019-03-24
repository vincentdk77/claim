package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����SwfPackage��������־ҵ����Ϣ�������������ݴ���������<br>
 * ������ 2005-03-18 17:53:35.843<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class SwfPackageDtoBase implements Serializable{
    /** ���Թ�������Ϣ��ID */
    private String packageID = "";
    /** ������ϸ����� */
    private int detailNo = 0;
    /** ������ϸ������ */
    private String detailContent = "";
    /** ���Ա��ñ�־ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�SwfPackageDtoBase����
     */
    public SwfPackageDtoBase(){
    }

    /**
     * �������Թ�������Ϣ��ID
     * @param packageID �����õ����Թ�������Ϣ��ID��ֵ
     */
    public void setPackageID(String packageID){
        this.packageID = StringUtils.rightTrim(packageID);
    }

    /**
     * ��ȡ���Թ�������Ϣ��ID
     * @return ���Թ�������Ϣ��ID��ֵ
     */
    public String getPackageID(){
        return packageID;
    }

    /**
     * ����������ϸ�����
     * @param detailNo �����õ�������ϸ����ŵ�ֵ
     */
    public void setDetailNo(int detailNo){
        this.detailNo = detailNo;
    }

    /**
     * ��ȡ������ϸ�����
     * @return ������ϸ����ŵ�ֵ
     */
    public int getDetailNo(){
        return detailNo;
    }

    /**
     * ����������ϸ������
     * @param detailContent �����õ�������ϸ�����ݵ�ֵ
     */
    public void setDetailContent(String detailContent){
        this.detailContent = StringUtils.rightTrim(detailContent);
    }

    /**
     * ��ȡ������ϸ������
     * @return ������ϸ�����ݵ�ֵ
     */
    public String getDetailContent(){
        return detailContent;
    }

    /**
     * �������Ա��ñ�־
     * @param flag �����õ����Ա��ñ�־��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ���Ա��ñ�־
     * @return ���Ա��ñ�־��ֵ
     */
    public String getFlag(){
        return flag;
    }
}
