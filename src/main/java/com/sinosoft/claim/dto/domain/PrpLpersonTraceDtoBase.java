package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLpersonTrace-人伤跟踪表(新增)的数据传输对象基类<br>
 * 创建于 2005-03-18 17:53:35.750<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLpersonTraceDtoBase implements Serializable{
    /** 属性报案号 */
    private String registNo = "";
    /** 属性赔案号 */
    private String claimNo = "";
    /** 属性保单号 */
    private String policyNo = "";
    /** 属性人员序号 */
    private int personNo = 0;
    /** 属性人员姓名 */
    private String personName = "";
    /** 属性性别 */
    private String personSex = "";
    /** 属性年龄 */
    private int personAge = 0;
    /** 属性身份证号码 */
    private String identifyNumber = "";
    /** 属性关联人员序号 */
    private int relatePersonNo = 0;
    /** 属性行业代码 */
    private String jobCode = "";
    /** 属性行业名称 */
    private String jobName = "";
    /** 属性事故所涉及险种 */
    private String referKind = "";
    /** 属性受伤部位描述 */
    private String partDesc = "";
    /** 属性就诊医院 */
    private String hospital = "";
    /** 属性是否自行就医 */
    private String motionFlag = "";
    /** 属性伤情描述 */
    private String woundRemark = "";
    /** 属性备注 */
    private String remark = "";
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpLpersonTraceDtoBase对象
     */
    public PrpLpersonTraceDtoBase(){
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
     * 设置属性保单号
     * @param policyNo 待设置的属性保单号的值
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * 获取属性保单号
     * @return 属性保单号的值
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * 设置属性人员序号
     * @param personNo 待设置的属性人员序号的值
     */
    public void setPersonNo(int personNo){
        this.personNo = personNo;
    }

    /**
     * 获取属性人员序号
     * @return 属性人员序号的值
     */
    public int getPersonNo(){
        return personNo;
    }

    /**
     * 设置属性人员姓名
     * @param personName 待设置的属性人员姓名的值
     */
    public void setPersonName(String personName){
        this.personName = StringUtils.rightTrim(personName);
    }

    /**
     * 获取属性人员姓名
     * @return 属性人员姓名的值
     */
    public String getPersonName(){
        return personName;
    }

    /**
     * 设置属性性别
     * @param personSex 待设置的属性性别的值
     */
    public void setPersonSex(String personSex){
        this.personSex = StringUtils.rightTrim(personSex);
    }

    /**
     * 获取属性性别
     * @return 属性性别的值
     */
    public String getPersonSex(){
        return personSex;
    }

    /**
     * 设置属性年龄
     * @param personAge 待设置的属性年龄的值
     */
    public void setPersonAge(int personAge){
        this.personAge = personAge;
    }

    /**
     * 获取属性年龄
     * @return 属性年龄的值
     */
    public int getPersonAge(){
        return personAge;
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
     * 设置属性关联人员序号
     * @param relatePersonNo 待设置的属性关联人员序号的值
     */
    public void setRelatePersonNo(int relatePersonNo){
        this.relatePersonNo = relatePersonNo;
    }

    /**
     * 获取属性关联人员序号
     * @return 属性关联人员序号的值
     */
    public int getRelatePersonNo(){
        return relatePersonNo;
    }

    /**
     * 设置属性行业代码
     * @param jobCode 待设置的属性行业代码的值
     */
    public void setJobCode(String jobCode){
        this.jobCode = StringUtils.rightTrim(jobCode);
    }

    /**
     * 获取属性行业代码
     * @return 属性行业代码的值
     */
    public String getJobCode(){
        return jobCode;
    }

    /**
     * 设置属性行业名称
     * @param jobName 待设置的属性行业名称的值
     */
    public void setJobName(String jobName){
        this.jobName = StringUtils.rightTrim(jobName);
    }

    /**
     * 获取属性行业名称
     * @return 属性行业名称的值
     */
    public String getJobName(){
        return jobName;
    }

    /**
     * 设置属性事故所涉及险种
     * @param referKind 待设置的属性事故所涉及险种的值
     */
    public void setReferKind(String referKind){
        this.referKind = StringUtils.rightTrim(referKind);
    }

    /**
     * 获取属性事故所涉及险种
     * @return 属性事故所涉及险种的值
     */
    public String getReferKind(){
        return referKind;
    }

    /**
     * 设置属性受伤部位描述
     * @param partDesc 待设置的属性受伤部位描述的值
     */
    public void setPartDesc(String partDesc){
        this.partDesc = StringUtils.rightTrim(partDesc);
    }

    /**
     * 获取属性受伤部位描述
     * @return 属性受伤部位描述的值
     */
    public String getPartDesc(){
        return partDesc;
    }

    /**
     * 设置属性就诊医院
     * @param hospital 待设置的属性就诊医院的值
     */
    public void setHospital(String hospital){
        this.hospital = StringUtils.rightTrim(hospital);
    }

    /**
     * 获取属性就诊医院
     * @return 属性就诊医院的值
     */
    public String getHospital(){
        return hospital;
    }

    /**
     * 设置属性是否自行就医
     * @param motionFlag 待设置的属性是否自行就医的值
     */
    public void setMotionFlag(String motionFlag){
        this.motionFlag = StringUtils.rightTrim(motionFlag);
    }

    /**
     * 获取属性是否自行就医
     * @return 属性是否自行就医的值
     */
    public String getMotionFlag(){
        return motionFlag;
    }

    /**
     * 设置属性伤情描述
     * @param woundRemark 待设置的属性伤情描述的值
     */
    public void setWoundRemark(String woundRemark){
        this.woundRemark = StringUtils.rightTrim(woundRemark);
    }

    /**
     * 获取属性伤情描述
     * @return 属性伤情描述的值
     */
    public String getWoundRemark(){
        return woundRemark;
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
     * 设置属性标志字段
     * @param flag 待设置的属性标志字段的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性标志字段
     * @return 属性标志字段的值
     */
    public String getFlag(){
        return flag;
    }
}
