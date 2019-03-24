package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLthirdpartyStatus-与第三方企业信息交互信息状态表的数据传输对象基类<br>
 * 创建于 2005-03-18 17:53:35.531<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLthirdpartyStatusDtoBase implements Serializable{
    /** 属性交互业务代码 */
    private String businessNo = "";
    /** 属性应用类型 */
    private String bUSINESSTYPE = "";
    /** 属性序号 */
    private int serialNo = 0;
    /** 属性交互类型  1:发送 2：接收 */
    private String aLTERNATETYPE = "";
    /** 属性交互状态标志：-- 0：传送失败-- 1：传送成功 */
    private String aLTERNATEFLAG = "";
    /** 属性发生错误时的错误代码 */
    private String eRRORNO = "";
    /** 属性交互时间 */
    private DateTime aLTERNATEDATE = new DateTime();
    /** 属性交互小时 */
    private int aLTERNATEHOUR = 0;
    /** 属性错误描述 */
    private String eRRORMESSAGE = "";
    /** 属性标志位 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpLthirdpartyStatusDtoBase对象
     */
    public PrpLthirdpartyStatusDtoBase(){
    }

    /**
     * 设置属性交互业务代码
     * @param businessNo 待设置的属性交互业务代码的值
     */
    public void setBusinessNo(String businessNo){
        this.businessNo = StringUtils.rightTrim(businessNo);
    }

    /**
     * 获取属性交互业务代码
     * @return 属性交互业务代码的值
     */
    public String getBusinessNo(){
        return businessNo;
    }

    /**
     * 设置属性应用类型
     * @param bUSINESSTYPE 待设置的属性应用类型的值
     */
    public void setBUSINESSTYPE(String bUSINESSTYPE){
        this.bUSINESSTYPE = StringUtils.rightTrim(bUSINESSTYPE);
    }

    /**
     * 获取属性应用类型
     * @return 属性应用类型的值
     */
    public String getBUSINESSTYPE(){
        return bUSINESSTYPE;
    }

    /**
     * 设置属性序号
     * @param serialNo 待设置的属性序号的值
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性序号
     * @return 属性序号的值
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * 设置属性交互类型  1:发送 2：接收
     * @param aLTERNATETYPE 待设置的属性交互类型  1:发送 2：接收的值
     */
    public void setALTERNATETYPE(String aLTERNATETYPE){
        this.aLTERNATETYPE = StringUtils.rightTrim(aLTERNATETYPE);
    }

    /**
     * 获取属性交互类型  1:发送 2：接收
     * @return 属性交互类型  1:发送 2：接收的值
     */
    public String getALTERNATETYPE(){
        return aLTERNATETYPE;
    }

    /**
     * 设置属性交互状态标志：-- 0：传送失败-- 1：传送成功
     * @param aLTERNATEFLAG 待设置的属性交互状态标志：-- 0：传送失败-- 1：传送成功的值
     */
    public void setALTERNATEFLAG(String aLTERNATEFLAG){
        this.aLTERNATEFLAG = StringUtils.rightTrim(aLTERNATEFLAG);
    }

    /**
     * 获取属性交互状态标志：-- 0：传送失败-- 1：传送成功
     * @return 属性交互状态标志：-- 0：传送失败-- 1：传送成功的值
     */
    public String getALTERNATEFLAG(){
        return aLTERNATEFLAG;
    }

    /**
     * 设置属性发生错误时的错误代码
     * @param eRRORNO 待设置的属性发生错误时的错误代码的值
     */
    public void setERRORNO(String eRRORNO){
        this.eRRORNO = StringUtils.rightTrim(eRRORNO);
    }

    /**
     * 获取属性发生错误时的错误代码
     * @return 属性发生错误时的错误代码的值
     */
    public String getERRORNO(){
        return eRRORNO;
    }

    /**
     * 设置属性交互时间
     * @param aLTERNATEDATE 待设置的属性交互时间的值
     */
    public void setALTERNATEDATE(DateTime aLTERNATEDATE){
        this.aLTERNATEDATE = aLTERNATEDATE;
    }

    /**
     * 获取属性交互时间
     * @return 属性交互时间的值
     */
    public DateTime getALTERNATEDATE(){
        return aLTERNATEDATE;
    }

    /**
     * 设置属性交互小时
     * @param aLTERNATEHOUR 待设置的属性交互小时的值
     */
    public void setALTERNATEHOUR(int aLTERNATEHOUR){
        this.aLTERNATEHOUR = aLTERNATEHOUR;
    }

    /**
     * 获取属性交互小时
     * @return 属性交互小时的值
     */
    public int getALTERNATEHOUR(){
        return aLTERNATEHOUR;
    }

    /**
     * 设置属性错误描述
     * @param eRRORMESSAGE 待设置的属性错误描述的值
     */
    public void setERRORMESSAGE(String eRRORMESSAGE){
        this.eRRORMESSAGE = StringUtils.rightTrim(eRRORMESSAGE);
    }

    /**
     * 获取属性错误描述
     * @return 属性错误描述的值
     */
    public String getERRORMESSAGE(){
        return eRRORMESSAGE;
    }

    /**
     * 设置属性标志位
     * @param flag 待设置的属性标志位的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性标志位
     * @return 属性标志位的值
     */
    public String getFlag(){
        return flag;
    }
}
