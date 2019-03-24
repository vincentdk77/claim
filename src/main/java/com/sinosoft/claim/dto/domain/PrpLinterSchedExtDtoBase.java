package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是补充说明信息的数据传输对象基类<br>
 */
public class PrpLinterSchedExtDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性主键pk */
    private String id = "";
    /** 属性序号 pk */
    private int serialNo = 0;
    /** 属性操作人代码 */
    private String operatorCode = "";
    /** 属性内容 */
    private String context = "";

    /**
     *  默认构造方法,构造一个默认的PrpLinterSchedExtDtoBase对象
     */
    public PrpLinterSchedExtDtoBase(){
    }

    /**
     * 设置属性主键pk
     * @param id 待设置的属性主键pk的值
     */
    public void setId(String id){
        this.id = StringUtils.rightTrim(id);
    }

    /**
     * 获取属性主键pk
     * @return 属性主键pk的值
     */
    public String getId(){
        return id;
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
