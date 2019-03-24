package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpUndoCancel作废或删除操作轨迹主表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:32:06<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpUndoCancelDtoBase implements Serializable{
    /** 属性操作类型 */
    private String operateTypeCode = "";
    /** 属性操作类型名琛 */
    private String operateTypeName = "";
    /** 属性单证号 */
    private String certiNo = "";
    /** 属性序号 */
    private int serialNo = 0;
    /** 属性投保人代码 */
    private String appliCode = "";
    /** 属性投保人名称 */
    private String appliName = "";
    /** 属性业务归属机构代码 */
    private String comCode = "";
    /** 属性出单机构代码 */
    private String makeCom = "";
    /** 属性备注 */
    private String remark = "";
    /** 属性当前操作源代码 */
    private String operatorCode = "";
    /** 属性操作日期 */
    private DateTime operateTime = new DateTime();
    /** 属性标志 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpUndoCancelDtoBase对象
     */
    public PrpUndoCancelDtoBase(){
    }

    /**
     * 设置属性操作类型
     * @param operateTypeCode 待设置的属性操作类型的值
     */
    public void setOperateTypeCode(String operateTypeCode){
        this.operateTypeCode = StringUtils.rightTrim(operateTypeCode);
    }

    /**
     * 获取属性操作类型
     * @return 属性操作类型的值
     */
    public String getOperateTypeCode(){
        return operateTypeCode;
    }

    /**
     * 设置属性操作类型名琛
     * @param operateTypeName 待设置的属性操作类型名琛的值
     */
    public void setOperateTypeName(String operateTypeName){
        this.operateTypeName = StringUtils.rightTrim(operateTypeName);
    }

    /**
     * 获取属性操作类型名琛
     * @return 属性操作类型名琛的值
     */
    public String getOperateTypeName(){
        return operateTypeName;
    }

    /**
     * 设置属性单证号
     * @param certiNo 待设置的属性单证号的值
     */
    public void setCertiNo(String certiNo){
        this.certiNo = StringUtils.rightTrim(certiNo);
    }

    /**
     * 获取属性单证号
     * @return 属性单证号的值
     */
    public String getCertiNo(){
        return certiNo;
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
     * 设置属性投保人代码
     * @param appliCode 待设置的属性投保人代码的值
     */
    public void setAppliCode(String appliCode){
        this.appliCode = StringUtils.rightTrim(appliCode);
    }

    /**
     * 获取属性投保人代码
     * @return 属性投保人代码的值
     */
    public String getAppliCode(){
        return appliCode;
    }

    /**
     * 设置属性投保人名称
     * @param appliName 待设置的属性投保人名称的值
     */
    public void setAppliName(String appliName){
        this.appliName = StringUtils.rightTrim(appliName);
    }

    /**
     * 获取属性投保人名称
     * @return 属性投保人名称的值
     */
    public String getAppliName(){
        return appliName;
    }

    /**
     * 设置属性业务归属机构代码
     * @param comCode 待设置的属性业务归属机构代码的值
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * 获取属性业务归属机构代码
     * @return 属性业务归属机构代码的值
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * 设置属性出单机构代码
     * @param makeCom 待设置的属性出单机构代码的值
     */
    public void setMakeCom(String makeCom){
        this.makeCom = StringUtils.rightTrim(makeCom);
    }

    /**
     * 获取属性出单机构代码
     * @return 属性出单机构代码的值
     */
    public String getMakeCom(){
        return makeCom;
    }

    /**
     * 设置属性备注
     * @param remark 待设置的属性备注的值
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * 获取属性备注
     * @return 属性备注的值
     */
    public String getRemark(){
        return remark;
    }

    /**
     * 设置属性当前操作源代码
     * @param operatorCode 待设置的属性当前操作源代码的值
     */
    public void setOperatorCode(String operatorCode){
        this.operatorCode = StringUtils.rightTrim(operatorCode);
    }

    /**
     * 获取属性当前操作源代码
     * @return 属性当前操作源代码的值
     */
    public String getOperatorCode(){
        return operatorCode;
    }

    /**
     * 设置属性操作日期
     * @param operateTime 待设置的属性操作日期的值
     */
    public void setOperateTime(DateTime operateTime){
        this.operateTime = operateTime;
    }

    /**
     * 获取属性操作日期
     * @return 属性操作日期的值
     */
    public DateTime getOperateTime(){
        return operateTime;
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
}
