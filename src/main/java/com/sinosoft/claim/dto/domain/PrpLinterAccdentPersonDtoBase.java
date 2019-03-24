package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是理算接口事故者信息的数据传输对象基类<br>
 */
public class PrpLinterAccdentPersonDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性主键id PK */
    private String id = "";
    /** 属性序号 PK */
    private int serialNo = 0;
    /** 属性事故者代码 */
    private String acciCode = "";
    /** 属性事故者名称 */
    private String acciName = "";
    /** 属性性别(9未知1男2女) */
    private String sex = "";
    /** 属性年龄 */
    private int age = 0;
    /** 属性身份证号码 */
    private String identifyNumber = "";
    /** 属性受益人信息 */
    private String perilContext = "";
    /** 属性保益信息 */
    private String beneRiskContext = "";

    /**
     *  默认构造方法,构造一个默认的PrpLinterAccdentPersonDtoBase对象
     */
    public PrpLinterAccdentPersonDtoBase(){
    }

    /**
     * 设置属性主键id PK
     * @param id 待设置的属性主键id PK的值
     */
    public void setId(String id){
        this.id = StringUtils.rightTrim(id);
    }

    /**
     * 获取属性主键id PK
     * @return 属性主键id PK的值
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
     * 设置属性事故者代码
     * @param acciCode 待设置的属性事故者代码的值
     */
    public void setAcciCode(String acciCode){
        this.acciCode = StringUtils.rightTrim(acciCode);
    }

    /**
     * 获取属性事故者代码
     * @return 属性事故者代码的值
     */
    public String getAcciCode(){
        return acciCode;
    }

    /**
     * 设置属性事故者名称
     * @param acciName 待设置的属性事故者名称的值
     */
    public void setAcciName(String acciName){
        this.acciName = StringUtils.rightTrim(acciName);
    }

    /**
     * 获取属性事故者名称
     * @return 属性事故者名称的值
     */
    public String getAcciName(){
        return acciName;
    }

    /**
     * 设置属性性别(9未知1男2女)
     * @param sex 待设置的属性性别(9未知1男2女)的值
     */
    public void setSex(String sex){
        this.sex = StringUtils.rightTrim(sex);
    }

    /**
     * 获取属性性别(9未知1男2女)
     * @return 属性性别(9未知1男2女)的值
     */
    public String getSex(){
        return sex;
    }

    /**
     * 设置属性年龄
     * @param age 待设置的属性年龄的值
     */
    public void setAge(int age){
        this.age = age;
    }

    /**
     * 获取属性年龄
     * @return 属性年龄的值
     */
    public int getAge(){
        return age;
    }

    /**
     * 设置属性身份证号码
     * @param identifyNumber 待设置的属性身份证号码的值
     */
    public void setIdentifyNumber(String identifyNumber){
        this.identifyNumber = StringUtils.rightTrim(identifyNumber);
    }

    /**
     * 获取属性身份证号码
     * @return 属性身份证号码的值
     */
    public String getIdentifyNumber(){
        return identifyNumber;
    }

    /**
     * 设置属性受益人信息
     * @param perilContext 待设置的属性受益人信息的值
     */
    public void setPerilContext(String perilContext){
        this.perilContext = StringUtils.rightTrim(perilContext);
    }

    /**
     * 获取属性受益人信息
     * @return 属性受益人信息的值
     */
    public String getPerilContext(){
        return perilContext;
    }

    /**
     * 设置属性保益信息
     * @param beneRiskContext 待设置的属性保益信息的值
     */
    public void setBeneRiskContext(String beneRiskContext){
        this.beneRiskContext = StringUtils.rightTrim(beneRiskContext);
    }

    /**
     * 获取属性保益信息
     * @return 属性保益信息的值
     */
    public String getBeneRiskContext(){
        return beneRiskContext;
    }
}
