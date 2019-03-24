package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLcertifyImg-����ͼƬ�ϴ�·�������ݴ���������<br>
 * ������ 2005-03-23 16:36:55.078<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLcertifyImgDtoBase implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** ����ҵ����� */
    private String businessNo = "";
    /** ������� */
    private int serialNo = 0;
    /** ���Ա�Ĵ��� */
    private String lossItemCode = "";
    /** ���Ա������ */
    private String lossItemName = "";
    /** ���Ե�֤���ͻ�ͼƬ���� */
    private String typeCode = "";
    /** ����ͼƬ���� */
    private String picName = "";
    /** ����ǩ������ */
    private DateTime signInDate = new DateTime();
    /** ���Ե���������ͼƬ���루���ױ����룩 */
    private String thirdPartyCode = "";
    /** �����ϴ�ʱ�ļ��� */
    private String uploadFileName = "";
    /** ����Ӱ���ļ���
--** ��������
--** :BusinessNo+TypeCode+SerialNo */
    private String imgFileName = "";
    /** ����ͼƬ���·�� */
    private String picPath = "";
    /** �����ռ��� */
    private String collectorName = "";
    /** ���Խ���״̬(0:δ���գ�1�����յ�) */
    private String receiveStatus = "";
    /** ���Ա�־λ */
    private String flag = "";
    /** �����ϴ�ͼƬ�ֽ�����С */
    private double imgSize = 0d;
    /** �����ϴ�ͼƬ�Ľڵ�λ�� */
    private String uploadNodeFlag = "";
    /** ������ʾ���� */
    private String displayName = "";
    /** ���Ա������� */
    private String policyNo = "";
    /** ������Ч��־ */
    private String validStatus = "";
    /** ����ע������ (add by liyanjie 20051109) */
    private DateTime cancelDate = new DateTime();

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLcertifyImgDtoBase����
     */
    public PrpLcertifyImgDtoBase(){
    }

    /**
     * ��������ҵ�����
     * @param businessNo �����õ�����ҵ������ֵ
     */
    public void setBusinessNo(String businessNo){
        this.businessNo = StringUtils.rightTrim(businessNo);
    }

    /**
     * ��ȡ����ҵ�����
     * @return ����ҵ������ֵ
     */
    public String getBusinessNo(){
        return businessNo;
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
     * �������Ա�Ĵ���
     * @param lossItemCode �����õ����Ա�Ĵ����ֵ
     */
    public void setLossItemCode(String lossItemCode){
        this.lossItemCode = StringUtils.rightTrim(lossItemCode);
    }

    /**
     * ��ȡ���Ա�Ĵ���
     * @return ���Ա�Ĵ����ֵ
     */
    public String getLossItemCode(){
        return lossItemCode;
    }

    /**
     * �������Ա������
     * @param lossItemName �����õ����Ա�����Ƶ�ֵ
     */
    public void setLossItemName(String lossItemName){
        this.lossItemName = StringUtils.rightTrim(lossItemName);
    }

    /**
     * ��ȡ���Ա������
     * @return ���Ա�����Ƶ�ֵ
     */
    public String getLossItemName(){
        return lossItemName;
    }

    /**
     * �������Ե�֤���ͻ�ͼƬ����
     * @param typeCode �����õ����Ե�֤���ͻ�ͼƬ���͵�ֵ
     */
    public void setTypeCode(String typeCode){
        this.typeCode = StringUtils.rightTrim(typeCode);
    }

    /**
     * ��ȡ���Ե�֤���ͻ�ͼƬ����
     * @return ���Ե�֤���ͻ�ͼƬ���͵�ֵ
     */
    public String getTypeCode(){
        return typeCode;
    }

    /**
     * ��������ͼƬ����
     * @param picName �����õ�����ͼƬ���Ƶ�ֵ
     */
    public void setPicName(String picName){
        this.picName = StringUtils.rightTrim(picName);
    }

    /**
     * ��ȡ����ͼƬ����
     * @return ����ͼƬ���Ƶ�ֵ
     */
    public String getPicName(){
        return picName;
    }

    /**
     * ��������ǩ������
     * @param signInDate �����õ�����ǩ�����ڵ�ֵ
     */
    public void setSignInDate(DateTime signInDate){
        this.signInDate = signInDate;
    }

    /**
     * ��ȡ����ǩ������
     * @return ����ǩ�����ڵ�ֵ
     */
    public DateTime getSignInDate(){
        return signInDate;
    }

    /**
     * �������Ե���������ͼƬ���루���ױ����룩
     * @param thirdPartyCode �����õ����Ե���������ͼƬ���루���ױ����룩��ֵ
     */
    public void setThirdPartyCode(String thirdPartyCode){
        this.thirdPartyCode = StringUtils.rightTrim(thirdPartyCode);
    }

    /**
     * ��ȡ���Ե���������ͼƬ���루���ױ����룩
     * @return ���Ե���������ͼƬ���루���ױ����룩��ֵ
     */
    public String getThirdPartyCode(){
        return thirdPartyCode;
    }

    /**
     * ���������ϴ�ʱ�ļ���
     * @param uploadFileName �����õ������ϴ�ʱ�ļ�����ֵ
     */
    public void setUploadFileName(String uploadFileName){
        this.uploadFileName = StringUtils.rightTrim(uploadFileName);
    }

    /**
     * ��ȡ�����ϴ�ʱ�ļ���
     * @return �����ϴ�ʱ�ļ�����ֵ
     */
    public String getUploadFileName(){
        return uploadFileName;
    }

    /**
     * ��������Ӱ���ļ���
--** ��������
--** :BusinessNo+TypeCode+SerialNo
     * @param imgFileName �����õ�����Ӱ���ļ���
--** ��������
--** :BusinessNo+TypeCode+SerialNo��ֵ
     */
    public void setImgFileName(String imgFileName){
        this.imgFileName = StringUtils.rightTrim(imgFileName);
    }

    /**
     * ��ȡ����Ӱ���ļ���
--** ��������
--** :BusinessNo+TypeCode+SerialNo
     * @return ����Ӱ���ļ���
--** ��������
--** :BusinessNo+TypeCode+SerialNo��ֵ
     */
    public String getImgFileName(){
        return imgFileName;
    }

    /**
     * ��������ͼƬ���·��
     * @param picPath �����õ�����ͼƬ���·����ֵ
     */
    public void setPicPath(String picPath){
        this.picPath = StringUtils.rightTrim(picPath);
    }

    /**
     * ��ȡ����ͼƬ���·��
     * @return ����ͼƬ���·����ֵ
     */
    public String getPicPath(){
        return picPath;
    }

    /**
     * ���������ռ���
     * @param collectorName �����õ������ռ��ߵ�ֵ
     */
    public void setCollectorName(String collectorName){
        this.collectorName = StringUtils.rightTrim(collectorName);
    }

    /**
     * ��ȡ�����ռ���
     * @return �����ռ��ߵ�ֵ
     */
    public String getCollectorName(){
        return collectorName;
    }

    /**
     * �������Խ���״̬(0:δ���գ�1�����յ�)
     * @param receiveStatus �����õ����Խ���״̬(0:δ���գ�1�����յ�)��ֵ
     */
    public void setReceiveStatus(String receiveStatus){
        this.receiveStatus = StringUtils.rightTrim(receiveStatus);
    }

    /**
     * ��ȡ���Խ���״̬(0:δ���գ�1�����յ�)
     * @return ���Խ���״̬(0:δ���գ�1�����յ�)��ֵ
     */
    public String getReceiveStatus(){
        return receiveStatus;
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

    /**
     * ���������ϴ�ͼƬ�ֽ�����С
     * @param imgSize �����õ������ϴ�ͼƬ�ֽ�����С��ֵ
     */
    public void setImgSize(double imgSize){
        this.imgSize = imgSize;
    }

    /**
     * ��ȡ�����ϴ�ͼƬ�ֽ�����С
     * @return �����ϴ�ͼƬ�ֽ�����С��ֵ
     */
    public double getImgSize(){
        return imgSize;
    }

    /**
     * ���������ϴ�ͼƬ�Ľڵ�λ��
     * @param uploadNodeFlag �����õ������ϴ�ͼƬ�Ľڵ�λ�õ�ֵ
     */
    public void setUploadNodeFlag(String uploadNodeFlag){
        this.uploadNodeFlag = StringUtils.rightTrim(uploadNodeFlag);
    }

    /**
     * ��ȡ�����ϴ�ͼƬ�Ľڵ�λ��
     * @return �����ϴ�ͼƬ�Ľڵ�λ�õ�ֵ
     */
    public String getUploadNodeFlag(){
        return uploadNodeFlag;
    }

    /**
     * ����������ʾ����
     * @param displayName �����õ�������ʾ���Ƶ�ֵ
     */
    public void setDisplayName(String displayName){
        this.displayName = StringUtils.rightTrim(displayName);
    }

    /**
     * ��ȡ������ʾ����
     * @return ������ʾ���Ƶ�ֵ
     */
    public String getDisplayName(){
        return displayName;
    }

    /**
     * �������Ա�������
     * @param policyNo �����õ����Ա��������ֵ
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * ��ȡ���Ա�������
     * @return ���Ա��������ֵ
     */
    public String getPolicyNo(){
        return policyNo;
    }
    /**
     * ����������Ч��־
     * @param validStatus �����õ�������Ч��־��ֵ
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * ��ȡ������Ч��־
     * @return ������Ч��־��ֵ
     */
    public String getValidStatus(){
        return validStatus;
    }
    
    /**
     * ��������ɾ������
     * @param cancelDate �����õ�����ɾ�����ڵ�ֵ
     */
    public void setCancelDate(DateTime cancelDate){
        this.cancelDate = cancelDate;
    }

    /**
     * ��ȡ����ɾ������
     * @return ����ɾ�����ڵ�ֵ
     */
    public DateTime getCancelDate(){
        return cancelDate;
    }	
}
