package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是大病医疗接口参数中间表子表计算书清单信息表的数据传输对象基类<br>
 */
public class PrpLinterCompeInvMainDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性主键pk */
    private String id = "";
    /** 属性序号 PK */
    private int serialNo = 0;
    /** 属性赔付清单编码 */
    private String settleListCode = "";
    /** 属性报案号码 */
    private String registNo = "";
    /** 属性立案号码 */
    private String claimNo = "";
    /** 属性计算书号码 */
    private String compensateNo = "";
    /** 属性数据来源 */
    private String dateSourceName = "";

    /**
     *  默认构造方法,构造一个默认的PrpLinterCompeInvMainDtoBase对象
     */
    public PrpLinterCompeInvMainDtoBase(){
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
     * 设置属性序号 PK
     * @param serialNo 待设置的属性序号 PK的值
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性序号 PK
     * @return 属性序号 PK的值
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * 设置属性赔付清单编码
     * @param settleListCode 待设置的属性赔付清单编码的值
     */
    public void setSettleListCode(String settleListCode){
        this.settleListCode = StringUtils.rightTrim(settleListCode);
    }

    /**
     * 获取属性赔付清单编码
     * @return 属性赔付清单编码的值
     */
    public String getSettleListCode(){
        return settleListCode;
    }

    /**
     * 设置属性报案号码
     * @param registNo 待设置的属性报案号码的值
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * 获取属性报案号码
     * @return 属性报案号码的值
     */
    public String getRegistNo(){
        return registNo;
    }

    /**
     * 设置属性立案号码
     * @param claimNo 待设置的属性立案号码的值
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * 获取属性立案号码
     * @return 属性立案号码的值
     */
    public String getClaimNo(){
        return claimNo;
    }

    /**
     * 设置属性计算书号码
     * @param compensateNo 待设置的属性计算书号码的值
     */
    public void setCompensateNo(String compensateNo){
        this.compensateNo = StringUtils.rightTrim(compensateNo);
    }

    /**
     * 获取属性计算书号码
     * @return 属性计算书号码的值
     */
    public String getCompensateNo(){
        return compensateNo;
    }

    /**
     * 设置属性数据来源
     * @param dateSourceName 待设置的属性数据来源的值
     */
    public void setDateSourceName(String dateSourceName){
        this.dateSourceName = StringUtils.rightTrim(dateSourceName);
    }

    /**
     * 获取属性数据来源
     * @return 属性数据来源的值
     */
    public String getDateSourceName(){
        return dateSourceName;
    }
}
