package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpversion数据库版本信息表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpVersionDtoBase implements Serializable{
    /** 属性项目名称 */
    private String projectName = "";
    /** 属性项目版本号 */
    private String projectVersion = "";
    /** 属性产品标识 */
    private String productID = "";
    /** 属性变更次数 */
    private int times = 0;
    /** 属性客户名称 */
    private String userName = "";
    /** 属性单位名称 */
    private String company = "";
    /** 属性更新日期 */
    private DateTime updateDate = new DateTime();
    /** 属性生机前版本号 */
    private String primaryVersion = "";
    /** 属性扩展字段1 */
    private String flag1 = "";
    /** 属性扩展字段2 */
    private String flag2 = "";
    /** 属性扩展字段3 */
    private String flag3 = "";
    /** 属性扩展字段4 */
    private String flag4 = "";
    /** 属性扩展字段5 */
    private String flag5 = "";

    /**
     *  默认构造方法,构造一个默认的PrpVersionDtoBase对象
     */
    public PrpVersionDtoBase(){
    }

    /**
     * 设置属性项目名称
     * @param projectName 待设置的属性项目名称的值
     */
    public void setProjectName(String projectName){
        this.projectName = StringUtils.rightTrim(projectName);
    }

    /**
     * 获取属性项目名称
     * @return 属性项目名称的值
     */
    public String getProjectName(){
        return projectName;
    }

    /**
     * 设置属性项目版本号
     * @param projectVersion 待设置的属性项目版本号的值
     */
    public void setProjectVersion(String projectVersion){
        this.projectVersion = StringUtils.rightTrim(projectVersion);
    }

    /**
     * 获取属性项目版本号
     * @return 属性项目版本号的值
     */
    public String getProjectVersion(){
        return projectVersion;
    }

    /**
     * 设置属性产品标识
     * @param productID 待设置的属性产品标识的值
     */
    public void setProductID(String productID){
        this.productID = StringUtils.rightTrim(productID);
    }

    /**
     * 获取属性产品标识
     * @return 属性产品标识的值
     */
    public String getProductID(){
        return productID;
    }

    /**
     * 设置属性变更次数
     * @param times 待设置的属性变更次数的值
     */
    public void setTimes(int times){
        this.times = times;
    }

    /**
     * 获取属性变更次数
     * @return 属性变更次数的值
     */
    public int getTimes(){
        return times;
    }

    /**
     * 设置属性客户名称
     * @param userName 待设置的属性客户名称的值
     */
    public void setUserName(String userName){
        this.userName = StringUtils.rightTrim(userName);
    }

    /**
     * 获取属性客户名称
     * @return 属性客户名称的值
     */
    public String getUserName(){
        return userName;
    }

    /**
     * 设置属性单位名称
     * @param company 待设置的属性单位名称的值
     */
    public void setCompany(String company){
        this.company = StringUtils.rightTrim(company);
    }

    /**
     * 获取属性单位名称
     * @return 属性单位名称的值
     */
    public String getCompany(){
        return company;
    }

    /**
     * 设置属性更新日期
     * @param updateDate 待设置的属性更新日期的值
     */
    public void setUpdateDate(DateTime updateDate){
        this.updateDate = updateDate;
    }

    /**
     * 获取属性更新日期
     * @return 属性更新日期的值
     */
    public DateTime getUpdateDate(){
        return updateDate;
    }

    /**
     * 设置属性生机前版本号
     * @param primaryVersion 待设置的属性生机前版本号的值
     */
    public void setPrimaryVersion(String primaryVersion){
        this.primaryVersion = StringUtils.rightTrim(primaryVersion);
    }

    /**
     * 获取属性生机前版本号
     * @return 属性生机前版本号的值
     */
    public String getPrimaryVersion(){
        return primaryVersion;
    }

    /**
     * 设置属性扩展字段1
     * @param flag1 待设置的属性扩展字段1的值
     */
    public void setFlag1(String flag1){
        this.flag1 = StringUtils.rightTrim(flag1);
    }

    /**
     * 获取属性扩展字段1
     * @return 属性扩展字段1的值
     */
    public String getFlag1(){
        return flag1;
    }

    /**
     * 设置属性扩展字段2
     * @param flag2 待设置的属性扩展字段2的值
     */
    public void setFlag2(String flag2){
        this.flag2 = StringUtils.rightTrim(flag2);
    }

    /**
     * 获取属性扩展字段2
     * @return 属性扩展字段2的值
     */
    public String getFlag2(){
        return flag2;
    }

    /**
     * 设置属性扩展字段3
     * @param flag3 待设置的属性扩展字段3的值
     */
    public void setFlag3(String flag3){
        this.flag3 = StringUtils.rightTrim(flag3);
    }

    /**
     * 获取属性扩展字段3
     * @return 属性扩展字段3的值
     */
    public String getFlag3(){
        return flag3;
    }

    /**
     * 设置属性扩展字段4
     * @param flag4 待设置的属性扩展字段4的值
     */
    public void setFlag4(String flag4){
        this.flag4 = StringUtils.rightTrim(flag4);
    }

    /**
     * 获取属性扩展字段4
     * @return 属性扩展字段4的值
     */
    public String getFlag4(){
        return flag4;
    }

    /**
     * 设置属性扩展字段5
     * @param flag5 待设置的属性扩展字段5的值
     */
    public void setFlag5(String flag5){
        this.flag5 = StringUtils.rightTrim(flag5);
    }

    /**
     * 获取属性扩展字段5
     * @return 属性扩展字段5的值
     */
    public String getFlag5(){
        return flag5;
    }
}
