package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLdoc-索赔单证信息表的数据传输对象基类<br>
 * 创建于 2005-03-18 17:53:35.312<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLdocDtoBase implements Serializable{
    /** 属性赔案号码 */
    private String claimNo = "";
    /** 属性单证代码 */
    private String docCode = "";
    /** 属性单证名称 */
    private String docName = "";
    /** 属性单证份数 */
    private int docCount = 0;
    /** 属性签收日期 */
    private DateTime signInDate = new DateTime();
    /** 属性标志字段
--** [1] 单证扫描情况 
--** 0:未扫描，1：已扫描 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpLdocDtoBase对象
     */
    public PrpLdocDtoBase(){
    }

    /**
     * 设置属性赔案号码
     * @param claimNo 待设置的属性赔案号码的值
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * 获取属性赔案号码
     * @return 属性赔案号码的值
     */
    public String getClaimNo(){
        return claimNo;
    }

    /**
     * 设置属性单证代码
     * @param docCode 待设置的属性单证代码的值
     */
    public void setDocCode(String docCode){
        this.docCode = StringUtils.rightTrim(docCode);
    }

    /**
     * 获取属性单证代码
     * @return 属性单证代码的值
     */
    public String getDocCode(){
        return docCode;
    }

    /**
     * 设置属性单证名称
     * @param docName 待设置的属性单证名称的值
     */
    public void setDocName(String docName){
        this.docName = StringUtils.rightTrim(docName);
    }

    /**
     * 获取属性单证名称
     * @return 属性单证名称的值
     */
    public String getDocName(){
        return docName;
    }

    /**
     * 设置属性单证份数
     * @param docCount 待设置的属性单证份数的值
     */
    public void setDocCount(int docCount){
        this.docCount = docCount;
    }

    /**
     * 获取属性单证份数
     * @return 属性单证份数的值
     */
    public int getDocCount(){
        return docCount;
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
     * 设置属性标志字段
--** [1] 单证扫描情况 
--** 0:未扫描，1：已扫描
     * @param flag 待设置的属性标志字段
--** [1] 单证扫描情况 
--** 0:未扫描，1：已扫描的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性标志字段
--** [1] 单证扫描情况 
--** 0:未扫描，1：已扫描
     * @return 属性标志字段
--** [1] 单证扫描情况 
--** 0:未扫描，1：已扫描的值
     */
    public String getFlag(){
        return flag;
    }
}
