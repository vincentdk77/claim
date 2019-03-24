package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpversion���ݿ�汾��Ϣ������ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpVersionDtoBase implements Serializable{
    /** ������Ŀ���� */
    private String projectName = "";
    /** ������Ŀ�汾�� */
    private String projectVersion = "";
    /** ���Բ�Ʒ��ʶ */
    private String productID = "";
    /** ���Ա������ */
    private int times = 0;
    /** ���Կͻ����� */
    private String userName = "";
    /** ���Ե�λ���� */
    private String company = "";
    /** ���Ը������� */
    private DateTime updateDate = new DateTime();
    /** ��������ǰ�汾�� */
    private String primaryVersion = "";
    /** ������չ�ֶ�1 */
    private String flag1 = "";
    /** ������չ�ֶ�2 */
    private String flag2 = "";
    /** ������չ�ֶ�3 */
    private String flag3 = "";
    /** ������չ�ֶ�4 */
    private String flag4 = "";
    /** ������չ�ֶ�5 */
    private String flag5 = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpVersionDtoBase����
     */
    public PrpVersionDtoBase(){
    }

    /**
     * ����������Ŀ����
     * @param projectName �����õ�������Ŀ���Ƶ�ֵ
     */
    public void setProjectName(String projectName){
        this.projectName = StringUtils.rightTrim(projectName);
    }

    /**
     * ��ȡ������Ŀ����
     * @return ������Ŀ���Ƶ�ֵ
     */
    public String getProjectName(){
        return projectName;
    }

    /**
     * ����������Ŀ�汾��
     * @param projectVersion �����õ�������Ŀ�汾�ŵ�ֵ
     */
    public void setProjectVersion(String projectVersion){
        this.projectVersion = StringUtils.rightTrim(projectVersion);
    }

    /**
     * ��ȡ������Ŀ�汾��
     * @return ������Ŀ�汾�ŵ�ֵ
     */
    public String getProjectVersion(){
        return projectVersion;
    }

    /**
     * �������Բ�Ʒ��ʶ
     * @param productID �����õ����Բ�Ʒ��ʶ��ֵ
     */
    public void setProductID(String productID){
        this.productID = StringUtils.rightTrim(productID);
    }

    /**
     * ��ȡ���Բ�Ʒ��ʶ
     * @return ���Բ�Ʒ��ʶ��ֵ
     */
    public String getProductID(){
        return productID;
    }

    /**
     * �������Ա������
     * @param times �����õ����Ա��������ֵ
     */
    public void setTimes(int times){
        this.times = times;
    }

    /**
     * ��ȡ���Ա������
     * @return ���Ա��������ֵ
     */
    public int getTimes(){
        return times;
    }

    /**
     * �������Կͻ�����
     * @param userName �����õ����Կͻ����Ƶ�ֵ
     */
    public void setUserName(String userName){
        this.userName = StringUtils.rightTrim(userName);
    }

    /**
     * ��ȡ���Կͻ�����
     * @return ���Կͻ����Ƶ�ֵ
     */
    public String getUserName(){
        return userName;
    }

    /**
     * �������Ե�λ����
     * @param company �����õ����Ե�λ���Ƶ�ֵ
     */
    public void setCompany(String company){
        this.company = StringUtils.rightTrim(company);
    }

    /**
     * ��ȡ���Ե�λ����
     * @return ���Ե�λ���Ƶ�ֵ
     */
    public String getCompany(){
        return company;
    }

    /**
     * �������Ը�������
     * @param updateDate �����õ����Ը������ڵ�ֵ
     */
    public void setUpdateDate(DateTime updateDate){
        this.updateDate = updateDate;
    }

    /**
     * ��ȡ���Ը�������
     * @return ���Ը������ڵ�ֵ
     */
    public DateTime getUpdateDate(){
        return updateDate;
    }

    /**
     * ������������ǰ�汾��
     * @param primaryVersion �����õ���������ǰ�汾�ŵ�ֵ
     */
    public void setPrimaryVersion(String primaryVersion){
        this.primaryVersion = StringUtils.rightTrim(primaryVersion);
    }

    /**
     * ��ȡ��������ǰ�汾��
     * @return ��������ǰ�汾�ŵ�ֵ
     */
    public String getPrimaryVersion(){
        return primaryVersion;
    }

    /**
     * ����������չ�ֶ�1
     * @param flag1 �����õ�������չ�ֶ�1��ֵ
     */
    public void setFlag1(String flag1){
        this.flag1 = StringUtils.rightTrim(flag1);
    }

    /**
     * ��ȡ������չ�ֶ�1
     * @return ������չ�ֶ�1��ֵ
     */
    public String getFlag1(){
        return flag1;
    }

    /**
     * ����������չ�ֶ�2
     * @param flag2 �����õ�������չ�ֶ�2��ֵ
     */
    public void setFlag2(String flag2){
        this.flag2 = StringUtils.rightTrim(flag2);
    }

    /**
     * ��ȡ������չ�ֶ�2
     * @return ������չ�ֶ�2��ֵ
     */
    public String getFlag2(){
        return flag2;
    }

    /**
     * ����������չ�ֶ�3
     * @param flag3 �����õ�������չ�ֶ�3��ֵ
     */
    public void setFlag3(String flag3){
        this.flag3 = StringUtils.rightTrim(flag3);
    }

    /**
     * ��ȡ������չ�ֶ�3
     * @return ������չ�ֶ�3��ֵ
     */
    public String getFlag3(){
        return flag3;
    }

    /**
     * ����������չ�ֶ�4
     * @param flag4 �����õ�������չ�ֶ�4��ֵ
     */
    public void setFlag4(String flag4){
        this.flag4 = StringUtils.rightTrim(flag4);
    }

    /**
     * ��ȡ������չ�ֶ�4
     * @return ������չ�ֶ�4��ֵ
     */
    public String getFlag4(){
        return flag4;
    }

    /**
     * ����������չ�ֶ�5
     * @param flag5 �����õ�������չ�ֶ�5��ֵ
     */
    public void setFlag5(String flag5){
        this.flag5 = StringUtils.rightTrim(flag5);
    }

    /**
     * ��ȡ������չ�ֶ�5
     * @return ������չ�ֶ�5��ֵ
     */
    public String getFlag5(){
        return flag5;
    }
}
