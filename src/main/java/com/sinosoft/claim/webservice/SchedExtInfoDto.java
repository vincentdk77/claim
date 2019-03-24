package com.sinosoft.claim.webservice;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

public class SchedExtInfoDto implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性序号 pk */
    private int serialNo = 0;
    /** 属性操作人代码 */
    private String operatorCode = "";
    /** 属性内容 */
    private String context = "";

    /**
     *  默认构造方法,构造一个默认的SchedExtInfoDto对象
     */
    public SchedExtInfoDto(){
    }

    /**
     * 设置属性序号 pk
     * @param serialNo 待设置的属性序号 pk的值
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性序号 pk
     * @return 属性序号 pk的值
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * 设置属性操作人代码
     * @param operatorCode 待设置的属性操作人代码的值
     */
    public void setOperatorCode(String operatorCode){
        this.operatorCode = StringUtils.rightTrim(operatorCode);
    }

    /**
     * 获取属性操作人代码
     * @return 属性操作人代码的值
     */
    public String getOperatorCode(){
        return operatorCode;
    }

    /**
     * 设置属性内容
     * @param context 待设置的属性内容的值
     */
    public void setContext(String context){
        this.context = StringUtils.rightTrim(context);
    }

    /**
     * 获取属性内容
     * @return 属性内容的值
     */
    public String getContext(){
        return context;
    }

}
