package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是EdAgentSysData的数据传输对象基类<br>
 * 创建于 2005-07-19 09:58:46.091<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class EdAgentSysDataDtoBase implements Serializable{
    /** 属性呼叫标识 */
    private String cALLID = "";
    /** 属性主叫号码 */
    private String aNI = "";
    /** 属性业务号码 */
    private String bUSINESSNO = "";
    /** 属性座席工号 */
    private String aGENTID = "";
    /** 属性任务代码 */
    private String tASKCODE = "";
    /** 属性录音标志 */
    private String rECORDFLAG = "";
    /** 属性录入日期 */
    private DateTime iNPUTDATE = new DateTime();
    /** 属性标志位 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的EdAgentSysDataDtoBase对象
     */
    public EdAgentSysDataDtoBase(){
    }

    /**
     * 设置属性呼叫标识
     * @param cALLID 待设置的属性呼叫标识的值
     */
    public void setCALLID(String cALLID){
        this.cALLID = StringUtils.rightTrim(cALLID);
    }

    /**
     * 获取属性呼叫标识
     * @return 属性呼叫标识的值
     */
    public String getCALLID(){
        return cALLID;
    }

    /**
     * 设置属性主叫号码
     * @param aNI 待设置的属性主叫号码的值
     */
    public void setANI(String aNI){
        this.aNI = StringUtils.rightTrim(aNI);
    }

    /**
     * 获取属性主叫号码
     * @return 属性主叫号码的值
     */
    public String getANI(){
        return aNI;
    }

    /**
     * 设置属性业务号码
     * @param bUSINESSNO 待设置的属性业务号码的值
     */
    public void setBUSINESSNO(String bUSINESSNO){
        this.bUSINESSNO = StringUtils.rightTrim(bUSINESSNO);
    }

    /**
     * 获取属性业务号码
     * @return 属性业务号码的值
     */
    public String getBUSINESSNO(){
        return bUSINESSNO;
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
     * 设置属性任务代码
     * @param tASKCODE 待设置的属性任务代码的值
     */
    public void setTASKCODE(String tASKCODE){
        this.tASKCODE = StringUtils.rightTrim(tASKCODE);
    }

    /**
     * 获取属性任务代码
     * @return 属性任务代码的值
     */
    public String getTASKCODE(){
        return tASKCODE;
    }

    /**
     * 设置属性录音标志
     * @param rECORDFLAG 待设置的属性录音标志的值
     */
    public void setRECORDFLAG(String rECORDFLAG){
        this.rECORDFLAG = StringUtils.rightTrim(rECORDFLAG);
    }

    /**
     * 获取属性录音标志
     * @return 属性录音标志的值
     */
    public String getRECORDFLAG(){
        return rECORDFLAG;
    }

    /**
     * 设置属性录入日期
     * @param iNPUTDATE 待设置的属性录入日期的值
     */
    public void setINPUTDATE(DateTime iNPUTDATE){
        this.iNPUTDATE = iNPUTDATE;
    }

    /**
     * 获取属性录入日期
     * @return 属性录入日期的值
     */
    public DateTime getINPUTDATE(){
        return iNPUTDATE;
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
