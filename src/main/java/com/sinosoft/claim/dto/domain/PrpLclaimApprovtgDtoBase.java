package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLclaimApprov-代赔数据转出确认表的数据传输对象基类<br>
 * 创建于 2005-03-18 17:53:35.625<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLclaimApprovtgDtoBase implements Serializable{
    /** 属性报案号 */
    private String registNo = "";
    /** 属性确认人代码 */
    private String approverCode = "";
    /** 属性确认日期 */
    private DateTime approvDate = new DateTime();
    /** 属性是否转出标志
--** 0：初始值 1：已转出 */
    private String transferStatus = "";
    /** 属性标志位 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpLclaimApprovtgDtoBase对象
     */
    public PrpLclaimApprovtgDtoBase(){
    }

    /**
     * 设置属性报案号
     * @param registNo 待设置的属性报案号的值
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * 获取属性报案号
     * @return 属性报案号的值
     */
    public String getRegistNo(){
        return registNo;
    }

    /**
     * 设置属性确认人代码
     * @param approverCode 待设置的属性确认人代码的值
     */
    public void setApproverCode(String approverCode){
        this.approverCode = StringUtils.rightTrim(approverCode);
    }

    /**
     * 获取属性确认人代码
     * @return 属性确认人代码的值
     */
    public String getApproverCode(){
        return approverCode;
    }

    /**
     * 设置属性确认日期
     * @param approvDate 待设置的属性确认日期的值
     */
    public void setApprovDate(DateTime approvDate){
        this.approvDate = approvDate;
    }

    /**
     * 获取属性确认日期
     * @return 属性确认日期的值
     */
    public DateTime getApprovDate(){
        return approvDate;
    }

    /**
     * 设置属性是否转出标志
--** 0：初始值 1：已转出
     * @param transferStatus 待设置的属性是否转出标志
--** 0：初始值 1：已转出的值
     */
    public void setTransferStatus(String transferStatus){
        this.transferStatus = StringUtils.rightTrim(transferStatus);
    }

    /**
     * 获取属性是否转出标志
--** 0：初始值 1：已转出
     * @return 属性是否转出标志
--** 0：初始值 1：已转出的值
     */
    public String getTransferStatus(){
        return transferStatus;
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
