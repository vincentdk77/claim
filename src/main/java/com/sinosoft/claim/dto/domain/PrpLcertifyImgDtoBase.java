package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLcertifyImg-理赔图片上传路径的数据传输对象基类<br>
 * 创建于 2005-03-23 16:36:55.078<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLcertifyImgDtoBase implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 属性业务号码 */
    private String businessNo = "";
    /** 属性序号 */
    private int serialNo = 0;
    /** 属性标的代码 */
    private String lossItemCode = "";
    /** 属性标的名称 */
    private String lossItemName = "";
    /** 属性单证类型或图片类型 */
    private String typeCode = "";
    /** 属性图片名称 */
    private String picName = "";
    /** 属性签收日期 */
    private DateTime signInDate = new DateTime();
    /** 属性第三方传送图片代码（如易保代码） */
    private String thirdPartyCode = "";
    /** 属性上传时文件名 */
    private String uploadFileName = "";
    /** 属性影象文件名
--** 命名规则
--** :BusinessNo+TypeCode+SerialNo */
    private String imgFileName = "";
    /** 属性图片存放路径 */
    private String picPath = "";
    /** 属性收集者 */
    private String collectorName = "";
    /** 属性接收状态(0:未接收，1：接收到) */
    private String receiveStatus = "";
    /** 属性标志位 */
    private String flag = "";
    /** 属性上传图片字节数大小 */
    private double imgSize = 0d;
    /** 属性上传图片的节点位置 */
    private String uploadNodeFlag = "";
    /** 属性显示名称 */
    private String displayName = "";
    /** 属性保单号码 */
    private String policyNo = "";
    /** 属性有效标志 */
    private String validStatus = "";
    /** 属性注销日期 (add by liyanjie 20051109) */
    private DateTime cancelDate = new DateTime();

    /**
     *  默认构造方法,构造一个默认的PrpLcertifyImgDtoBase对象
     */
    public PrpLcertifyImgDtoBase(){
    }

    /**
     * 设置属性业务号码
     * @param businessNo 待设置的属性业务号码的值
     */
    public void setBusinessNo(String businessNo){
        this.businessNo = StringUtils.rightTrim(businessNo);
    }

    /**
     * 获取属性业务号码
     * @return 属性业务号码的值
     */
    public String getBusinessNo(){
        return businessNo;
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
     * 设置属性标的代码
     * @param lossItemCode 待设置的属性标的代码的值
     */
    public void setLossItemCode(String lossItemCode){
        this.lossItemCode = StringUtils.rightTrim(lossItemCode);
    }

    /**
     * 获取属性标的代码
     * @return 属性标的代码的值
     */
    public String getLossItemCode(){
        return lossItemCode;
    }

    /**
     * 设置属性标的名称
     * @param lossItemName 待设置的属性标的名称的值
     */
    public void setLossItemName(String lossItemName){
        this.lossItemName = StringUtils.rightTrim(lossItemName);
    }

    /**
     * 获取属性标的名称
     * @return 属性标的名称的值
     */
    public String getLossItemName(){
        return lossItemName;
    }

    /**
     * 设置属性单证类型或图片类型
     * @param typeCode 待设置的属性单证类型或图片类型的值
     */
    public void setTypeCode(String typeCode){
        this.typeCode = StringUtils.rightTrim(typeCode);
    }

    /**
     * 获取属性单证类型或图片类型
     * @return 属性单证类型或图片类型的值
     */
    public String getTypeCode(){
        return typeCode;
    }

    /**
     * 设置属性图片名称
     * @param picName 待设置的属性图片名称的值
     */
    public void setPicName(String picName){
        this.picName = StringUtils.rightTrim(picName);
    }

    /**
     * 获取属性图片名称
     * @return 属性图片名称的值
     */
    public String getPicName(){
        return picName;
    }

    /**
     * 设置属性签收日期
     * @param signInDate 待设置的属性签收日期的值
     */
    public void setSignInDate(DateTime signInDate){
        this.signInDate = signInDate;
    }

    /**
     * 获取属性签收日期
     * @return 属性签收日期的值
     */
    public DateTime getSignInDate(){
        return signInDate;
    }

    /**
     * 设置属性第三方传送图片代码（如易保代码）
     * @param thirdPartyCode 待设置的属性第三方传送图片代码（如易保代码）的值
     */
    public void setThirdPartyCode(String thirdPartyCode){
        this.thirdPartyCode = StringUtils.rightTrim(thirdPartyCode);
    }

    /**
     * 获取属性第三方传送图片代码（如易保代码）
     * @return 属性第三方传送图片代码（如易保代码）的值
     */
    public String getThirdPartyCode(){
        return thirdPartyCode;
    }

    /**
     * 设置属性上传时文件名
     * @param uploadFileName 待设置的属性上传时文件名的值
     */
    public void setUploadFileName(String uploadFileName){
        this.uploadFileName = StringUtils.rightTrim(uploadFileName);
    }

    /**
     * 获取属性上传时文件名
     * @return 属性上传时文件名的值
     */
    public String getUploadFileName(){
        return uploadFileName;
    }

    /**
     * 设置属性影象文件名
--** 命名规则
--** :BusinessNo+TypeCode+SerialNo
     * @param imgFileName 待设置的属性影象文件名
--** 命名规则
--** :BusinessNo+TypeCode+SerialNo的值
     */
    public void setImgFileName(String imgFileName){
        this.imgFileName = StringUtils.rightTrim(imgFileName);
    }

    /**
     * 获取属性影象文件名
--** 命名规则
--** :BusinessNo+TypeCode+SerialNo
     * @return 属性影象文件名
--** 命名规则
--** :BusinessNo+TypeCode+SerialNo的值
     */
    public String getImgFileName(){
        return imgFileName;
    }

    /**
     * 设置属性图片存放路径
     * @param picPath 待设置的属性图片存放路径的值
     */
    public void setPicPath(String picPath){
        this.picPath = StringUtils.rightTrim(picPath);
    }

    /**
     * 获取属性图片存放路径
     * @return 属性图片存放路径的值
     */
    public String getPicPath(){
        return picPath;
    }

    /**
     * 设置属性收集者
     * @param collectorName 待设置的属性收集者的值
     */
    public void setCollectorName(String collectorName){
        this.collectorName = StringUtils.rightTrim(collectorName);
    }

    /**
     * 获取属性收集者
     * @return 属性收集者的值
     */
    public String getCollectorName(){
        return collectorName;
    }

    /**
     * 设置属性接收状态(0:未接收，1：接收到)
     * @param receiveStatus 待设置的属性接收状态(0:未接收，1：接收到)的值
     */
    public void setReceiveStatus(String receiveStatus){
        this.receiveStatus = StringUtils.rightTrim(receiveStatus);
    }

    /**
     * 获取属性接收状态(0:未接收，1：接收到)
     * @return 属性接收状态(0:未接收，1：接收到)的值
     */
    public String getReceiveStatus(){
        return receiveStatus;
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

    /**
     * 设置属性上传图片字节数大小
     * @param imgSize 待设置的属性上传图片字节数大小的值
     */
    public void setImgSize(double imgSize){
        this.imgSize = imgSize;
    }

    /**
     * 获取属性上传图片字节数大小
     * @return 属性上传图片字节数大小的值
     */
    public double getImgSize(){
        return imgSize;
    }

    /**
     * 设置属性上传图片的节点位置
     * @param uploadNodeFlag 待设置的属性上传图片的节点位置的值
     */
    public void setUploadNodeFlag(String uploadNodeFlag){
        this.uploadNodeFlag = StringUtils.rightTrim(uploadNodeFlag);
    }

    /**
     * 获取属性上传图片的节点位置
     * @return 属性上传图片的节点位置的值
     */
    public String getUploadNodeFlag(){
        return uploadNodeFlag;
    }

    /**
     * 设置属性显示名称
     * @param displayName 待设置的属性显示名称的值
     */
    public void setDisplayName(String displayName){
        this.displayName = StringUtils.rightTrim(displayName);
    }

    /**
     * 获取属性显示名称
     * @return 属性显示名称的值
     */
    public String getDisplayName(){
        return displayName;
    }

    /**
     * 设置属性保单号码
     * @param policyNo 待设置的属性保单号码的值
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * 获取属性保单号码
     * @return 属性保单号码的值
     */
    public String getPolicyNo(){
        return policyNo;
    }
    /**
     * 设置属性有效标志
     * @param validStatus 待设置的属性有效标志的值
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * 获取属性有效标志
     * @return 属性有效标志的值
     */
    public String getValidStatus(){
        return validStatus;
    }
    
    /**
     * 设置属性删除日期
     * @param cancelDate 待设置的属性删除日期的值
     */
    public void setCancelDate(DateTime cancelDate){
        this.cancelDate = cancelDate;
    }

    /**
     * 获取属性删除日期
     * @return 属性删除日期的值
     */
    public DateTime getCancelDate(){
        return cancelDate;
    }	
}
