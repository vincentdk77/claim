package com.sinosoft.claimprop.common.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����CiClaimPropUploadLog�����ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class CiClaimPropUploadLogDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����businessNo */
    private String businessNo = "";
    /** ����serialNo */
    private int serialNo = 0;
    /** ����uploadType */
    private String uploadType = "";
    /** ����claimStatus */
    private String claimStatus = "";
    /** ����uploadDate */
    private DateTime uploadDate = new DateTime();
    /** ����flag */
    private int flag = 0;
    /** ����sendContext */
    private String sendContext = "";
    /** ����returnContext */
    private String returnContext = "";
    /** ����failReson */
    private String failReson = "";
    /** ����triggerMode */
    private String triggerMode = "";
    /** ����claimCode */
    private String claimCode = "";
    /** ����policyNo */
    private String policyNo = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�CiClaimPropUploadLogDtoBase����
     */
    public CiClaimPropUploadLogDtoBase(){
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
     * ��������serialNo
     * @param serialNo �����õ�����serialNo��ֵ
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ����serialNo
     * @return ����serialNo��ֵ
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * ��������uploadType
     * @param uploadType �����õ�����uploadType��ֵ
     */
    public void setUploadType(String uploadType){
        this.uploadType = StringUtils.rightTrim(uploadType);
    }

    /**
     * ��ȡ����uploadType
     * @return ����uploadType��ֵ
     */
    public String getUploadType(){
        return uploadType;
    }

    /**
     * ��������claimStatus
     * @param claimStatus �����õ�����claimStatus��ֵ
     */
    public void setClaimStatus(String claimStatus){
        this.claimStatus = StringUtils.rightTrim(claimStatus);
    }

    /**
     * ��ȡ����claimStatus
     * @return ����claimStatus��ֵ
     */
    public String getClaimStatus(){
        return claimStatus;
    }

    /**
     * ��������uploadDate
     * @param uploadDate �����õ�����uploadDate��ֵ
     */
    public void setUploadDate(DateTime uploadDate){
        this.uploadDate = uploadDate;
    }

    /**
     * ��ȡ����uploadDate
     * @return ����uploadDate��ֵ
     */
    public DateTime getUploadDate(){
        return uploadDate;
    }

    /**
     * ��������flag
     * @param flag �����õ�����flag��ֵ
     */
    public void setFlag(int flag){
        this.flag = flag;
    }

    /**
     * ��ȡ����flag
     * @return ����flag��ֵ
     */
    public int getFlag(){
        return flag;
    }

    /**
     * ��������sendContext
     * @param sendContext �����õ�����sendContext��ֵ
     */
    public void setSendContext(String sendContext){
        this.sendContext = StringUtils.rightTrim(sendContext);
    }

    /**
     * ��ȡ����sendContext
     * @return ����sendContext��ֵ
     */
    public String getSendContext(){
        return sendContext;
    }

    /**
     * ��������returnContext
     * @param returnContext �����õ�����returnContext��ֵ
     */
    public void setReturnContext(String returnContext){
        this.returnContext = StringUtils.rightTrim(returnContext);
    }

    /**
     * ��ȡ����returnContext
     * @return ����returnContext��ֵ
     */
    public String getReturnContext(){
        return returnContext;
    }

    /**
     * ��������failReson
     * @param failReson �����õ�����failReson��ֵ
     */
    public void setFailReson(String failReson){
        this.failReson = StringUtils.rightTrim(failReson);
    }

    /**
     * ��ȡ����failReson
     * @return ����failReson��ֵ
     */
    public String getFailReson(){
        return failReson;
    }

    /**
     * ��������triggerMode
     * @param triggerMode �����õ�����triggerMode��ֵ
     */
    public void setTriggerMode(String triggerMode){
        this.triggerMode = StringUtils.rightTrim(triggerMode);
    }

    /**
     * ��ȡ����triggerMode
     * @return ����triggerMode��ֵ
     */
    public String getTriggerMode(){
        return triggerMode;
    }

    /**
     * ��������claimCode
     * @param claimCode �����õ�����claimCode��ֵ
     */
    public void setClaimCode(String claimCode){
        this.claimCode = StringUtils.rightTrim(claimCode);
    }

    /**
     * ��ȡ����claimCode
     * @return ����claimCode��ֵ
     */
    public String getClaimCode(){
        return claimCode;
    }

    /**
     * ��������policyNo
     * @param policyNo �����õ�����policyNo��ֵ
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * ��ȡ����policyNo
     * @return ����policyNo��ֵ
     */
    public String getPolicyNo(){
        return policyNo;
    }
}
