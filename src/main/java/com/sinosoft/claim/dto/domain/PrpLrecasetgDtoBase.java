package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLrecase-重开赔案表;的数据传输对象基类<br>
 * 创建于 2005-03-18 17:53:35.453<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLrecasetgDtoBase implements Serializable{
    /** 属性赔案号 */
    private String claimNo = "";
    /** 属性重开赔案次数 */
    private int serialNo = 0;
    /** 属性重开赔案人代码 */
    private String openCaseUserCode = "";
    /** 属性重开赔案日期 */
    private DateTime openCaseDate = new DateTime();
    /** 属性本次结案人代码 */
    private String closeCaseUserCode = "";
    /** 属性本次结案日期 */
    private DateTime closeCaseDate = new DateTime();
    /** 属性标志 */
    private String flag = "";
    /** 上传平台是否成功 */
    private String reCaseUploadFlag = "";
    /**
     *  默认构造方法,构造一个默认的PrpLrecasetgDtoBase对象
     */
    public PrpLrecasetgDtoBase(){
    }

    /**
     * 设置属性赔案号
     * @param claimNo 待设置的属性赔案号的值
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * 获取属性赔案号
     * @return 属性赔案号的值
     */
    public String getClaimNo(){
        return claimNo;
    }

    /**
     * 设置属性重开赔案次数
     * @param serialNo 待设置的属性重开赔案次数的值
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性重开赔案次数
     * @return 属性重开赔案次数的值
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * 设置属性重开赔案人代码
     * @param openCaseUserCode 待设置的属性重开赔案人代码的值
     */
    public void setOpenCaseUserCode(String openCaseUserCode){
        this.openCaseUserCode = StringUtils.rightTrim(openCaseUserCode);
    }

    /**
     * 获取属性重开赔案人代码
     * @return 属性重开赔案人代码的值
     */
    public String getOpenCaseUserCode(){
        return openCaseUserCode;
    }

    /**
     * 设置属性重开赔案日期
     * @param openCaseDate 待设置的属性重开赔案日期的值
     */
    public void setOpenCaseDate(DateTime openCaseDate){
        this.openCaseDate = openCaseDate;
    }

    /**
     * 获取属性重开赔案日期
     * @return 属性重开赔案日期的值
     */
    public DateTime getOpenCaseDate(){
        return openCaseDate;
    }

    /**
     * 设置属性本次结案人代码
     * @param closeCaseUserCode 待设置的属性本次结案人代码的值
     */
    public void setCloseCaseUserCode(String closeCaseUserCode){
        this.closeCaseUserCode = StringUtils.rightTrim(closeCaseUserCode);
    }

    /**
     * 获取属性本次结案人代码
     * @return 属性本次结案人代码的值
     */
    public String getCloseCaseUserCode(){
        return closeCaseUserCode;
    }

    /**
     * 设置属性本次结案日期
     * @param closeCaseDate 待设置的属性本次结案日期的值
     */
    public void setCloseCaseDate(DateTime closeCaseDate){
        this.closeCaseDate = closeCaseDate;
    }

    /**
     * 获取属性本次结案日期
     * @return 属性本次结案日期的值
     */
    public DateTime getCloseCaseDate(){
        return closeCaseDate;
    }

    /**
     * 设置属性标志
     * @param flag 待设置的属性标志的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性标志
     * @return 属性标志的值
     */
    public String getFlag(){
        return flag;
    }

	/**
	 * @return the reCaseUploadFlag
	 */
	public String getReCaseUploadFlag() {
		return reCaseUploadFlag;
	}

	/**
	 * @param reCaseUploadFlag the reCaseUploadFlag to set
	 */
	public void setReCaseUploadFlag(String reCaseUploadFlag) {
		this.reCaseUploadFlag = reCaseUploadFlag;
	}
}
