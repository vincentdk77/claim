package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是传入参数子表------处理意见的数据传输对象基类<br>
 */
public class PrpLinterPayExtDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性主键id PK */
    private String id = "";
    /** 属性主键序号 PK */
    private int serialNo = 0;
    /** 属性操作人 */
    private String operatorCodeName = "";
    /** 属性内容 */
    private String context = "";

    /**
     *  默认构造方法,构造一个默认的PrpLinterPayExtDtoBase对象
     */
    public PrpLinterPayExtDtoBase(){
    }

    /**
     * 设置属性主键id PK
     * @param id 待设置的属性主键id PK的值
     */
    public void setId(String id){
        this.id = StringUtils.rightTrim(id);
    }

    /**
     * 获取属性主键id PK
     * @return 属性主键id PK的值
     */
    public String getId(){
        return id;
    }

    /**
     * 设置属性主键序号 PK
     * @param serialNo 待设置的属性主键序号 PK的值
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性主键序号 PK
     * @return 属性主键序号 PK的值
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * 设置属性操作人
     * @param operatorCodeName 待设置的属性操作人的值
     */
    public void setOperatorCodeName(String operatorCodeName){
        this.operatorCodeName = StringUtils.rightTrim(operatorCodeName);
    }

    /**
     * 获取属性操作人
     * @return 属性操作人的值
     */
    public String getOperatorCodeName(){
        return operatorCodeName;
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
