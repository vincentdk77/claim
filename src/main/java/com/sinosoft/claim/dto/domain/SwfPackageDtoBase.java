package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是SwfPackage工作流日志业务信息表（新增）的数据传输对象基类<br>
 * 创建于 2005-03-18 17:53:35.843<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class SwfPackageDtoBase implements Serializable{
    /** 属性工作流信息包ID */
    private String packageID = "";
    /** 属性明细项序号 */
    private int detailNo = 0;
    /** 属性明细项内容 */
    private String detailContent = "";
    /** 属性备用标志 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的SwfPackageDtoBase对象
     */
    public SwfPackageDtoBase(){
    }

    /**
     * 设置属性工作流信息包ID
     * @param packageID 待设置的属性工作流信息包ID的值
     */
    public void setPackageID(String packageID){
        this.packageID = StringUtils.rightTrim(packageID);
    }

    /**
     * 获取属性工作流信息包ID
     * @return 属性工作流信息包ID的值
     */
    public String getPackageID(){
        return packageID;
    }

    /**
     * 设置属性明细项序号
     * @param detailNo 待设置的属性明细项序号的值
     */
    public void setDetailNo(int detailNo){
        this.detailNo = detailNo;
    }

    /**
     * 获取属性明细项序号
     * @return 属性明细项序号的值
     */
    public int getDetailNo(){
        return detailNo;
    }

    /**
     * 设置属性明细项内容
     * @param detailContent 待设置的属性明细项内容的值
     */
    public void setDetailContent(String detailContent){
        this.detailContent = StringUtils.rightTrim(detailContent);
    }

    /**
     * 获取属性明细项内容
     * @return 属性明细项内容的值
     */
    public String getDetailContent(){
        return detailContent;
    }

    /**
     * 设置属性备用标志
     * @param flag 待设置的属性备用标志的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性备用标志
     * @return 属性备用标志的值
     */
    public String getFlag(){
        return flag;
    }
}
