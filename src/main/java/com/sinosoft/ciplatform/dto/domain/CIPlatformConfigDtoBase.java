package com.sinosoft.ciplatform.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����CIPlatformConfig�����ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class CIPlatformConfigDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����configCode */
    private String configCode = "";
    /** ����configName */
    private String configName = "";
    /** ����comCode */
    private String comCode = "";
    /** ����riskCode */
    private String riskCode = "";
    /** ����version */
    private String version = "";
    /** ����url */
    private String url = "";
    /** ����userName */
    private String userName = "";
    /** ����pwd */
    private String pwd = "";
    /** ����configValue */
    private String configValue = "";
    /** ����configValueDes */
    private String configValueDes = "";
    /** ����validStatus */
    private String validStatus = "";
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�CIPlatformConfigDtoBase����
     */
    public CIPlatformConfigDtoBase(){
    }

    /**
     * ��������configCode
     * @param configCode �����õ�����configCode��ֵ
     */
    public void setConfigCode(String configCode){
        this.configCode = StringUtils.rightTrim(configCode);
    }

    /**
     * ��ȡ����configCode
     * @return ����configCode��ֵ
     */
    public String getConfigCode(){
        return configCode;
    }

    /**
     * ��������configName
     * @param configName �����õ�����configName��ֵ
     */
    public void setConfigName(String configName){
        this.configName = StringUtils.rightTrim(configName);
    }

    /**
     * ��ȡ����configName
     * @return ����configName��ֵ
     */
    public String getConfigName(){
        return configName;
    }

    /**
     * ��������comCode
     * @param comCode �����õ�����comCode��ֵ
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * ��ȡ����comCode
     * @return ����comCode��ֵ
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * ��������riskCode
     * @param riskCode �����õ�����riskCode��ֵ
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * ��ȡ����riskCode
     * @return ����riskCode��ֵ
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * ��������version
     * @param version �����õ�����version��ֵ
     */
    public void setVersion(String version){
        this.version = StringUtils.rightTrim(version);
    }

    /**
     * ��ȡ����version
     * @return ����version��ֵ
     */
    public String getVersion(){
        return version;
    }

    /**
     * ��������url
     * @param url �����õ�����url��ֵ
     */
    public void setUrl(String url){
        this.url = StringUtils.rightTrim(url);
    }

    /**
     * ��ȡ����url
     * @return ����url��ֵ
     */
    public String getUrl(){
        return url;
    }

    /**
     * ��������userName
     * @param userName �����õ�����userName��ֵ
     */
    public void setUserName(String userName){
        this.userName = StringUtils.rightTrim(userName);
    }

    /**
     * ��ȡ����userName
     * @return ����userName��ֵ
     */
    public String getUserName(){
        return userName;
    }

    /**
     * ��������pwd
     * @param pwd �����õ�����pwd��ֵ
     */
    public void setPwd(String pwd){
        this.pwd = StringUtils.rightTrim(pwd);
    }

    /**
     * ��ȡ����pwd
     * @return ����pwd��ֵ
     */
    public String getPwd(){
        return pwd;
    }

    /**
     * ��������configValue
     * @param configValue �����õ�����configValue��ֵ
     */
    public void setConfigValue(String configValue){
        this.configValue = StringUtils.rightTrim(configValue);
    }

    /**
     * ��ȡ����configValue
     * @return ����configValue��ֵ
     */
    public String getConfigValue(){
        return configValue;
    }

    /**
     * ��������configValueDes
     * @param configValueDes �����õ�����configValueDes��ֵ
     */
    public void setConfigValueDes(String configValueDes){
        this.configValueDes = StringUtils.rightTrim(configValueDes);
    }

    /**
     * ��ȡ����configValueDes
     * @return ����configValueDes��ֵ
     */
    public String getConfigValueDes(){
        return configValueDes;
    }

    /**
     * ��������validStatus
     * @param validStatus �����õ�����validStatus��ֵ
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * ��ȡ����validStatus
     * @return ����validStatus��ֵ
     */
    public String getValidStatus(){
        return validStatus;
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
