package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是座席员工信息表的数据传输对象基类<br>
 * 创建于 2005-07-19 09:58:46.101<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class ED_AGENT_INFODtoBase implements Serializable{
    /** 属性座席工号 */
    private String aGENTID = "";
    /** 属性密码 */
    private String aGENTPSWD = "";
    /** 属性员工类型 */
    private String aGENTTYPE = "";
    /** 属性组号 */
    private String aGENTACD = "";
    /** 属性员工姓名 */
    private String aGENTNAME = "";
    /** 属性性别 */
    private String gENDER = "";
    /** 属性部门 */
    private String dEPT = "";
    /** 属性管理 */
    private String mANAGEQUEUES = "";

    /**
     *  默认构造方法,构造一个默认的ED_AGENT_INFODtoBase对象
     */
    public ED_AGENT_INFODtoBase(){
    }

    /**
     * 设置属性座席工号
     * @param aGENTID 待设置的属性座席工号的值
     */
    public void setAGENTID(String aGENTID){
        this.aGENTID = StringUtils.rightTrim(aGENTID);
    }

    /**
     * 获取属性座席工号
     * @return 属性座席工号的值
     */
    public String getAGENTID(){
        return aGENTID;
    }

    /**
     * 设置属性密码
     * @param aGENTPSWD 待设置的属性密码的值
     */
    public void setAGENTPSWD(String aGENTPSWD){
        this.aGENTPSWD = StringUtils.rightTrim(aGENTPSWD);
    }

    /**
     * 获取属性密码
     * @return 属性密码的值
     */
    public String getAGENTPSWD(){
        return aGENTPSWD;
    }

    /**
     * 设置属性员工类型
     * @param aGENTTYPE 待设置的属性员工类型的值
     */
    public void setAGENTTYPE(String aGENTTYPE){
        this.aGENTTYPE = StringUtils.rightTrim(aGENTTYPE);
    }

    /**
     * 获取属性员工类型
     * @return 属性员工类型的值
     */
    public String getAGENTTYPE(){
        return aGENTTYPE;
    }

    /**
     * 设置属性组号
     * @param aGENTACD 待设置的属性组号的值
     */
    public void setAGENTACD(String aGENTACD){
        this.aGENTACD = StringUtils.rightTrim(aGENTACD);
    }

    /**
     * 获取属性组号
     * @return 属性组号的值
     */
    public String getAGENTACD(){
        return aGENTACD;
    }

    /**
     * 设置属性员工姓名
     * @param aGENTNAME 待设置的属性员工姓名的值
     */
    public void setAGENTNAME(String aGENTNAME){
        this.aGENTNAME = StringUtils.rightTrim(aGENTNAME);
    }

    /**
     * 获取属性员工姓名
     * @return 属性员工姓名的值
     */
    public String getAGENTNAME(){
        return aGENTNAME;
    }

    /**
     * 设置属性性别
     * @param gENDER 待设置的属性性别的值
     */
    public void setGENDER(String gENDER){
        this.gENDER = StringUtils.rightTrim(gENDER);
    }

    /**
     * 获取属性性别
     * @return 属性性别的值
     */
    public String getGENDER(){
        return gENDER;
    }

    /**
     * 设置属性部门
     * @param dEPT 待设置的属性部门的值
     */
    public void setDEPT(String dEPT){
        this.dEPT = StringUtils.rightTrim(dEPT);
    }

    /**
     * 获取属性部门
     * @return 属性部门的值
     */
    public String getDEPT(){
        return dEPT;
    }

    /**
     * 设置属性管理
     * @param mANAGEQUEUES 待设置的属性管理的值
     */
    public void setMANAGEQUEUES(String mANAGEQUEUES){
        this.mANAGEQUEUES = StringUtils.rightTrim(mANAGEQUEUES);
    }

    /**
     * 获取属性管理
     * @return 属性管理的值
     */
    public String getMANAGEQUEUES(){
        return mANAGEQUEUES;
    }
}
