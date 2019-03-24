package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是中间表关联报案号的数据传输对象基类<br>
 */
public class PrplinterrelationDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性主键id */
    private String id = "";
    /** 属性客户端主键 */
    private String outId = "";
    /** 属性输入时间 */
    private DateTime inputDate = new DateTime();
    /** 属性核心同步标示 */
    private String synchronFlag = "";
    /** 属性关联报案号码 */
    private String relationRegistNo = "";
    /** 属性客户端报案流水号 */
    private String outRigstNo = "";

    /**
     *  默认构造方法,构造一个默认的PrplinterrelationDtoBase对象
     */
    public PrplinterrelationDtoBase(){
    }

    /**
     * 设置属性主键id
     * @param id 待设置的属性主键id的值
     */
    public void setId(String id){
        this.id = StringUtils.rightTrim(id);
    }

    /**
     * 获取属性主键id
     * @return 属性主键id的值
     */
    public String getId(){
        return id;
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
     * 设置属性输入时间
     * @param inputDate 待设置的属性输入时间的值
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * 获取属性输入时间
     * @return 属性输入时间的值
     */
    public DateTime getInputDate(){
        return inputDate;
    }

    /**
     * 设置属性核心同步标示
     * @param synchronFlag 待设置的属性核心同步标示的值
     */
    public void setSynchronFlag(String synchronFlag){
        this.synchronFlag = StringUtils.rightTrim(synchronFlag);
    }

    /**
     * 获取属性核心同步标示
     * @return 属性核心同步标示的值
     */
    public String getSynchronFlag(){
        return synchronFlag;
    }

    /**
     * 设置属性关联报案号码
     * @param relationRegistNo 待设置的属性关联报案号码的值
     */
    public void setRelationRegistNo(String relationRegistNo){
        this.relationRegistNo = StringUtils.rightTrim(relationRegistNo);
    }

    /**
     * 获取属性关联报案号码
     * @return 属性关联报案号码的值
     */
    public String getRelationRegistNo(){
        return relationRegistNo;
    }

	public String getOutRigstNo() {
		return outRigstNo;
	}

	public void setOutRigstNo(String outRigstNo) {
		this.outRigstNo = outRigstNo;
	}
}
