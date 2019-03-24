package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Date;

import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPLINTERPAYDELETEQUEST的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLinterPayDeleteRequestDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性客户端主键 */
    private String outId = "";
    /** 属性操作人代码 */
    private String operatorCode = "";
    /** 属性操作人名称 */
    private String operatorName = "";
    /** 属性操作人机构代码 */
    private String makeCom = "";
    /** 属性操作人机构名称 */
    private String makeComName = "";
    /** 属性操作时间 */
    private DateTime operatorDate = new DateTime();
    /** 属性删除原因 */
    private String handleText = "";
    private String autoFlag = "";

    /**
     *  默认构造方法,构造一个默认的PRPLINTERPAYDELETEQUESTDtoBase对象
     */
    public PrpLinterPayDeleteRequestDtoBase(){
    }

    /**
     * 设置属性客户端主键
     * @param outId 待设置的属性客户端主键的值
     */
    public void setOutId(String outId){
        this.outId = StringUtils.rightTrim(outId);
    }

    /**
     * 获取属性客户端主键
     * @return 属性客户端主键的值
     */
    public String getOutId(){
        return outId;
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
     * 设置属性操作人名称
     * @param operatorName 待设置的属性操作人名称的值
     */
    public void setOperatorName(String operatorName){
        this.operatorName = StringUtils.rightTrim(operatorName);
    }

    /**
     * 获取属性操作人名称
     * @return 属性操作人名称的值
     */
    public String getOperatorName(){
        return operatorName;
    }

    /**
     * 设置属性操作人机构代码
     * @param makeCom 待设置的属性操作人机构代码的值
     */
    public void setMakeCom(String makeCom){
        this.makeCom = StringUtils.rightTrim(makeCom);
    }

    /**
     * 获取属性操作人机构代码
     * @return 属性操作人机构代码的值
     */
    public String getMakeCom(){
        return makeCom;
    }

    /**
     * 设置属性操作人机构名称
     * @param makeComName 待设置的属性操作人机构名称的值
     */
    public void setMakeComName(String makeComName){
        this.makeComName = StringUtils.rightTrim(makeComName);
    }

    /**
     * 获取属性操作人机构名称
     * @return 属性操作人机构名称的值
     */
    public String getMakeComName(){
        return makeComName;
    }

    /**
     * 设置属性操作时间
     * @param operatorDate 待设置的属性操作时间的值
     */
    public void setOperatorDate(DateTime operatorDate){
        this.operatorDate = operatorDate;
    }

    /**
     * 获取属性操作时间
     * @return 属性操作时间的值
     */
    public DateTime getOperatorDate(){
        return operatorDate;
    }

    /**
     * 设置属性删除原因
     * @param handleText 待设置的属性删除原因的值
     */
    public void setHandleText(String handleText){
        this.handleText = StringUtils.rightTrim(handleText);
    }

    /**
     * 获取属性删除原因
     * @return 属性删除原因的值
     */
    public String getHandleText(){
        return handleText;
    }

	public String getAutoFlag() {
		return autoFlag;
	}

	public void setAutoFlag(String autoFlag) {
		this.autoFlag = autoFlag;
	}
    
}
