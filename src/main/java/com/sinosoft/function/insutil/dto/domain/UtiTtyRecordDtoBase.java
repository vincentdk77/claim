package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����utittyrecord�����ݴ���������<br>
 * ������ 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiTtyRecordDtoBase implements Serializable{
    /** ����ttycode */
    private String ttyCode = "";
    /** ����usercode */
    private String userCode = "";
    /** ����username */
    private String userName = "";
    /** ����ipaddress */
    private String iPAddress = "";
    /** ����loginname */
    private String loginName = "";
    /** ����comcode */
    private String comCode = "";
    /** ����makecom */
    private String makeCom = "";
    /** ����year */
    private String year = "";
    /** ����riskcode */
    private String riskCode = "";
    /** ����logindate */
    private DateTime loginDate = new DateTime();
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�UtiTtyRecordDtoBase����
     */
    public UtiTtyRecordDtoBase(){
    }

    /**
     * ��������ttycode
     * @param ttyCode �����õ�����ttycode��ֵ
     */
    public void setTtyCode(String ttyCode){
        this.ttyCode = StringUtils.rightTrim(ttyCode);
    }

    /**
     * ��ȡ����ttycode
     * @return ����ttycode��ֵ
     */
    public String getTtyCode(){
        return ttyCode;
    }

    /**
     * ��������usercode
     * @param userCode �����õ�����usercode��ֵ
     */
    public void setUserCode(String userCode){
        this.userCode = StringUtils.rightTrim(userCode);
    }

    /**
     * ��ȡ����usercode
     * @return ����usercode��ֵ
     */
    public String getUserCode(){
        return userCode;
    }

    /**
     * ��������username
     * @param userName �����õ�����username��ֵ
     */
    public void setUserName(String userName){
        this.userName = StringUtils.rightTrim(userName);
    }

    /**
     * ��ȡ����username
     * @return ����username��ֵ
     */
    public String getUserName(){
        return userName;
    }

    /**
     * ��������ipaddress
     * @param iPAddress �����õ�����ipaddress��ֵ
     */
    public void setIPAddress(String iPAddress){
        this.iPAddress = StringUtils.rightTrim(iPAddress);
    }

    /**
     * ��ȡ����ipaddress
     * @return ����ipaddress��ֵ
     */
    public String getIPAddress(){
        return iPAddress;
    }

    /**
     * ��������loginname
     * @param loginName �����õ�����loginname��ֵ
     */
    public void setLoginName(String loginName){
        this.loginName = StringUtils.rightTrim(loginName);
    }

    /**
     * ��ȡ����loginname
     * @return ����loginname��ֵ
     */
    public String getLoginName(){
        return loginName;
    }

    /**
     * ��������comcode
     * @param comCode �����õ�����comcode��ֵ
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * ��ȡ����comcode
     * @return ����comcode��ֵ
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * ��������makecom
     * @param makeCom �����õ�����makecom��ֵ
     */
    public void setMakeCom(String makeCom){
        this.makeCom = StringUtils.rightTrim(makeCom);
    }

    /**
     * ��ȡ����makecom
     * @return ����makecom��ֵ
     */
    public String getMakeCom(){
        return makeCom;
    }

    /**
     * ��������year
     * @param year �����õ�����year��ֵ
     */
    public void setYear(String year){
        this.year = StringUtils.rightTrim(year);
    }

    /**
     * ��ȡ����year
     * @return ����year��ֵ
     */
    public String getYear(){
        return year;
    }

    /**
     * ��������riskcode
     * @param riskCode �����õ�����riskcode��ֵ
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * ��ȡ����riskcode
     * @return ����riskcode��ֵ
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * ��������logindate
     * @param loginDate �����õ�����logindate��ֵ
     */
    public void setLoginDate(DateTime loginDate){
        this.loginDate = loginDate;
    }

    /**
     * ��ȡ����logindate
     * @return ����logindate��ֵ
     */
    public DateTime getLoginDate(){
        return loginDate;
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
