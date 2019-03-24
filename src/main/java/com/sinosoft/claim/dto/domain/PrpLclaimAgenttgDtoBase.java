package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLclaimAgent-�����Ᵽ����Ϣ������ݴ���������<br>
 * ������ 2005-03-18 17:53:35.625<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLclaimAgenttgDtoBase implements Serializable{
    /** �����ⰸ�� */
    private String claimNo = "";
    /** ���Ա����� */
    private String policyNo = "";
    /** ���Գб��������� */
    private String centreCode = "";
    /** ���Գб��������� */
    private String centreName = "";
    /** ���Գб���˾���� */
    private String unitCode = "";
    /** ���Գб���˾���� */
    private String unitName = "";
    /** ����ǩ������ */
    private DateTime operateDate = new DateTime();
    /** �������䷽ʽ */
    private String conveyance = "";
    /** �������˵ر��� */
    private String startSiteCode = "";
    /** �������˵����� */
    private String startSiteName = "";
    /** ������ת�ر��� */
    private String viaSiteCode = "";
    /** ������ת������ */
    private String viaSiteName = "";
    /** ����Ŀ�ĵر��� */
    private String endSiteCode = "";
    /** ����Ŀ�ĵ����� */
    private String endSiteName = "";
    /** ����FLAG */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLclaimAgenttgDtoBase����
     */
    public PrpLclaimAgenttgDtoBase(){
    }

    /**
     * ���������ⰸ��
     * @param claimNo �����õ������ⰸ�ŵ�ֵ
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * ��ȡ�����ⰸ��
     * @return �����ⰸ�ŵ�ֵ
     */
    public String getClaimNo(){
        return claimNo;
    }

    /**
     * �������Ա�����
     * @param policyNo �����õ����Ա����ŵ�ֵ
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * ��ȡ���Ա�����
     * @return ���Ա����ŵ�ֵ
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * �������Գб���������
     * @param centreCode �����õ����Գб����������ֵ
     */
    public void setCentreCode(String centreCode){
        this.centreCode = StringUtils.rightTrim(centreCode);
    }

    /**
     * ��ȡ���Գб���������
     * @return ���Գб����������ֵ
     */
    public String getCentreCode(){
        return centreCode;
    }

    /**
     * �������Գб���������
     * @param centreName �����õ����Գб��������Ƶ�ֵ
     */
    public void setCentreName(String centreName){
        this.centreName = StringUtils.rightTrim(centreName);
    }

    /**
     * ��ȡ���Գб���������
     * @return ���Գб��������Ƶ�ֵ
     */
    public String getCentreName(){
        return centreName;
    }

    /**
     * �������Գб���˾����
     * @param unitCode �����õ����Գб���˾�����ֵ
     */
    public void setUnitCode(String unitCode){
        this.unitCode = StringUtils.rightTrim(unitCode);
    }

    /**
     * ��ȡ���Գб���˾����
     * @return ���Գб���˾�����ֵ
     */
    public String getUnitCode(){
        return unitCode;
    }

    /**
     * �������Գб���˾����
     * @param unitName �����õ����Գб���˾���Ƶ�ֵ
     */
    public void setUnitName(String unitName){
        this.unitName = StringUtils.rightTrim(unitName);
    }

    /**
     * ��ȡ���Գб���˾����
     * @return ���Գб���˾���Ƶ�ֵ
     */
    public String getUnitName(){
        return unitName;
    }

    /**
     * ��������ǩ������
     * @param operateDate �����õ�����ǩ�����ڵ�ֵ
     */
    public void setOperateDate(DateTime operateDate){
        this.operateDate = operateDate;
    }

    /**
     * ��ȡ����ǩ������
     * @return ����ǩ�����ڵ�ֵ
     */
    public DateTime getOperateDate(){
        return operateDate;
    }

    /**
     * �����������䷽ʽ
     * @param conveyance �����õ��������䷽ʽ��ֵ
     */
    public void setConveyance(String conveyance){
        this.conveyance = StringUtils.rightTrim(conveyance);
    }

    /**
     * ��ȡ�������䷽ʽ
     * @return �������䷽ʽ��ֵ
     */
    public String getConveyance(){
        return conveyance;
    }

    /**
     * �����������˵ر���
     * @param startSiteCode �����õ��������˵ر����ֵ
     */
    public void setStartSiteCode(String startSiteCode){
        this.startSiteCode = StringUtils.rightTrim(startSiteCode);
    }

    /**
     * ��ȡ�������˵ر���
     * @return �������˵ر����ֵ
     */
    public String getStartSiteCode(){
        return startSiteCode;
    }

    /**
     * �����������˵�����
     * @param startSiteName �����õ��������˵����Ƶ�ֵ
     */
    public void setStartSiteName(String startSiteName){
        this.startSiteName = StringUtils.rightTrim(startSiteName);
    }

    /**
     * ��ȡ�������˵�����
     * @return �������˵����Ƶ�ֵ
     */
    public String getStartSiteName(){
        return startSiteName;
    }

    /**
     * ����������ת�ر���
     * @param viaSiteCode �����õ�������ת�ر����ֵ
     */
    public void setViaSiteCode(String viaSiteCode){
        this.viaSiteCode = StringUtils.rightTrim(viaSiteCode);
    }

    /**
     * ��ȡ������ת�ر���
     * @return ������ת�ر����ֵ
     */
    public String getViaSiteCode(){
        return viaSiteCode;
    }

    /**
     * ����������ת������
     * @param viaSiteName �����õ�������ת�����Ƶ�ֵ
     */
    public void setViaSiteName(String viaSiteName){
        this.viaSiteName = StringUtils.rightTrim(viaSiteName);
    }

    /**
     * ��ȡ������ת������
     * @return ������ת�����Ƶ�ֵ
     */
    public String getViaSiteName(){
        return viaSiteName;
    }

    /**
     * ��������Ŀ�ĵر���
     * @param endSiteCode �����õ�����Ŀ�ĵر����ֵ
     */
    public void setEndSiteCode(String endSiteCode){
        this.endSiteCode = StringUtils.rightTrim(endSiteCode);
    }

    /**
     * ��ȡ����Ŀ�ĵر���
     * @return ����Ŀ�ĵر����ֵ
     */
    public String getEndSiteCode(){
        return endSiteCode;
    }

    /**
     * ��������Ŀ�ĵ�����
     * @param endSiteName �����õ�����Ŀ�ĵ����Ƶ�ֵ
     */
    public void setEndSiteName(String endSiteName){
        this.endSiteName = StringUtils.rightTrim(endSiteName);
    }

    /**
     * ��ȡ����Ŀ�ĵ�����
     * @return ����Ŀ�ĵ����Ƶ�ֵ
     */
    public String getEndSiteName(){
        return endSiteName;
    }

    /**
     * ��������FLAG
     * @param flag �����õ�����FLAG��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ����FLAG
     * @return ����FLAG��ֵ
     */
    public String getFlag(){
        return flag;
    }
}
