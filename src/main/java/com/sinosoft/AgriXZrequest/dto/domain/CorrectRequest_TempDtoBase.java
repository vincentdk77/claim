package com.sinosoft.AgriXZrequest.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����CorrectRequest_Temp�����ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class CorrectRequest_TempDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����batchNo */
    private String batchNo = "";
    /** ����businessNo */
    private String businessNo = "";
    /** ����flag */
    private String flag = "";
    /** ����businessType */
    private String businessType = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�CorrectRequest_TempDtoBase����
     */
    public CorrectRequest_TempDtoBase(){
    }

    /**
     * ��������batchNo
     * @param batchNo �����õ�����batchNo��ֵ
     */
    public void setBatchNo(String batchNo){
        this.batchNo = StringUtils.rightTrim(batchNo);
    }

    /**
     * ��ȡ����batchNo
     * @return ����batchNo��ֵ
     */
    public String getBatchNo(){
        return batchNo;
    }

    /**
     * ��������businessNo
     * @param businessNo �����õ�����businessNo��ֵ
     */
    public void setBusinessNo(String businessNo){
        this.businessNo = StringUtils.rightTrim(businessNo);
    }

    /**
     * ��ȡ����businessNo
     * @return ����businessNo��ֵ
     */
    public String getBusinessNo(){
        return businessNo;
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

    /**
     * ��������businessType
     * @param businessType �����õ�����businessType��ֵ
     */
    public void setBusinessType(String businessType){
        this.businessType = StringUtils.rightTrim(businessType);
    }

    /**
     * ��ȡ����businessType
     * @return ����businessType��ֵ
     */
    public String getBusinessType(){
        return businessType;
    }
}
