package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是utittyrecord的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiTtyRecordDtoBase implements Serializable{
    /** 属性ttycode */
    private String ttyCode = "";
    /** 属性usercode */
    private String userCode = "";
    /** 属性username */
    private String userName = "";
    /** 属性ipaddress */
    private String iPAddress = "";
    /** 属性loginname */
    private String loginName = "";
    /** 属性comcode */
    private String comCode = "";
    /** 属性makecom */
    private String makeCom = "";
    /** 属性year */
    private String year = "";
    /** 属性riskcode */
    private String riskCode = "";
    /** 属性logindate */
    private DateTime loginDate = new DateTime();
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的UtiTtyRecordDtoBase对象
     */
    public UtiTtyRecordDtoBase(){
    }

    /**
     * 设置属性ttycode
     * @param ttyCode 待设置的属性ttycode的值
     */
    public void setTtyCode(String ttyCode){
        this.ttyCode = StringUtils.rightTrim(ttyCode);
    }

    /**
     * 获取属性ttycode
     * @return 属性ttycode的值
     */
    public String getTtyCode(){
        return ttyCode;
    }

    /**
     * 设置属性usercode
     * @param userCode 待设置的属性usercode的值
     */
    public void setUserCode(String userCode){
        this.userCode = StringUtils.rightTrim(userCode);
    }

    /**
     * 获取属性usercode
     * @return 属性usercode的值
     */
    public String getUserCode(){
        return userCode;
    }

    /**
     * 设置属性username
     * @param userName 待设置的属性username的值
     */
    public void setUserName(String userName){
        this.userName = StringUtils.rightTrim(userName);
    }

    /**
     * 获取属性username
     * @return 属性username的值
     */
    public String getUserName(){
        return userName;
    }

    /**
     * 设置属性ipaddress
     * @param iPAddress 待设置的属性ipaddress的值
     */
    public void setIPAddress(String iPAddress){
        this.iPAddress = StringUtils.rightTrim(iPAddress);
    }

    /**
     * 获取属性ipaddress
     * @return 属性ipaddress的值
     */
    public String getIPAddress(){
        return iPAddress;
    }

    /**
     * 设置属性loginname
     * @param loginName 待设置的属性loginname的值
     */
    public void setLoginName(String loginName){
        this.loginName = StringUtils.rightTrim(loginName);
    }

    /**
     * 获取属性loginname
     * @return 属性loginname的值
     */
    public String getLoginName(){
        return loginName;
    }

    /**
     * 设置属性comcode
     * @param comCode 待设置的属性comcode的值
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * 获取属性comcode
     * @return 属性comcode的值
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * 设置属性makecom
     * @param makeCom 待设置的属性makecom的值
     */
    public void setMakeCom(String makeCom){
        this.makeCom = StringUtils.rightTrim(makeCom);
    }

    /**
     * 获取属性makecom
     * @return 属性makecom的值
     */
    public String getMakeCom(){
        return makeCom;
    }

    /**
     * 设置属性year
     * @param year 待设置的属性year的值
     */
    public void setYear(String year){
        this.year = StringUtils.rightTrim(year);
    }

    /**
     * 获取属性year
     * @return 属性year的值
     */
    public String getYear(){
        return year;
    }

    /**
     * 设置属性riskcode
     * @param riskCode 待设置的属性riskcode的值
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * 获取属性riskcode
     * @return 属性riskcode的值
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * 设置属性logindate
     * @param loginDate 待设置的属性logindate的值
     */
    public void setLoginDate(DateTime loginDate){
        this.loginDate = loginDate;
    }

    /**
     * 获取属性logindate
     * @return 属性logindate的值
     */
    public DateTime getLoginDate(){
        return loginDate;
    }

    /**
     * 设置属性flag
     * @param flag 待设置的属性flag的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性flag
     * @return 属性flag的值
     */
    public String getFlag(){
        return flag;
    }
}
