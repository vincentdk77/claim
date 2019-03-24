package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPLCOMPENSATEHOUSE的数据传输对象基类<br>
 */
public class PrplcompensatehousetgDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性IDCARD */
    private String idcard = "";
    /** 属性POLICYNO */
    private String policyno = "";
    /** 属性REGISTNO */
    private String registno = "";
    /** 属性CLAIMNO */
    private String claimno = "";
    /** 属性COMPENSATENO */
    private String compensateno = "";
    /** 属性CASENO */
    private String caseno = "";
    /** 属性DAMAGESTARTDATE */
    private DateTime damagestartdate = new DateTime();
    /** 属性DAMAGECODE */
    private String damagecode = "";
    /** 属性DAMAGENAME */
    private String damagename = "";
    /** 属性NAME */
    private String name = "";
    /** 属性NODENO */
    private int nodeno = 0;
    /** 属性NODETYPE */
    private String nodetype = "";
    /** 属性KINDCODE */
    private String kindcode = "";
    /** 属性PHONE */
    private String phone = "";
    /** 属性ADDRESS */
    private String address = "";
    /** 属性REMARK */
    private String remark = "";
    /** 属性HUKOUBU */
    private String hukoubu = "";
    /** 属性ESTIMATELOSS */
    private double estimateloss = 0D;
    /** 属性BUSINESSNO */
    private String businessno = "";
    
    /** 属性FLOOR */
    private String floor = "";
    /** 属性BUILDINGNUMBER */
    private String buildingnumber = "";
    /** 属性ZHUANNUMBER */
    private String zhuannumber = "";
    /** 属性WANUMBER */
    private String wanumber = "";
    /** 属性KITCHENNUMBER */
    private String kitchennumber = "";
    /** 属性OTHERNUMBER */
    private String othernumber = "";

    /**
     *  默认构造方法,构造一个默认的PrplcompensatehousetgDtoBase对象
     */
    public PrplcompensatehousetgDtoBase(){
    }

    /**
     * 设置属性IDCARD
     * @param idcard 待设置的属性IDCARD的值
     */
    public void setIdcard(String idcard){
        this.idcard = StringUtils.rightTrim(idcard);
    }

    /**
     * 获取属性IDCARD
     * @return 属性IDCARD的值
     */
    public String getIdcard(){
        return idcard;
    }

    /**
     * 设置属性POLICYNO
     * @param policyno 待设置的属性POLICYNO的值
     */
    public void setPolicyno(String policyno){
        this.policyno = StringUtils.rightTrim(policyno);
    }

    /**
     * 获取属性POLICYNO
     * @return 属性POLICYNO的值
     */
    public String getPolicyno(){
        return policyno;
    }

    /**
     * 设置属性REGISTNO
     * @param registno 待设置的属性REGISTNO的值
     */
    public void setRegistno(String registno){
        this.registno = StringUtils.rightTrim(registno);
    }

    /**
     * 获取属性REGISTNO
     * @return 属性REGISTNO的值
     */
    public String getRegistno(){
        return registno;
    }

    /**
     * 设置属性CLAIMNO
     * @param claimno 待设置的属性CLAIMNO的值
     */
    public void setClaimno(String claimno){
        this.claimno = StringUtils.rightTrim(claimno);
    }

    /**
     * 获取属性CLAIMNO
     * @return 属性CLAIMNO的值
     */
    public String getClaimno(){
        return claimno;
    }

    /**
     * 设置属性COMPENSATENO
     * @param compensateno 待设置的属性COMPENSATENO的值
     */
    public void setCompensateno(String compensateno){
        this.compensateno = StringUtils.rightTrim(compensateno);
    }

    /**
     * 获取属性COMPENSATENO
     * @return 属性COMPENSATENO的值
     */
    public String getCompensateno(){
        return compensateno;
    }

    /**
     * 设置属性CASENO
     * @param caseno 待设置的属性CASENO的值
     */
    public void setCaseno(String caseno){
        this.caseno = StringUtils.rightTrim(caseno);
    }

    /**
     * 获取属性CASENO
     * @return 属性CASENO的值
     */
    public String getCaseno(){
        return caseno;
    }

    /**
     * 设置属性DAMAGESTARTDATE
     * @param damagestartdate 待设置的属性DAMAGESTARTDATE的值
     */
    public void setDamagestartdate(DateTime damagestartdate){
        this.damagestartdate = damagestartdate;
    }

    /**
     * 获取属性DAMAGESTARTDATE
     * @return 属性DAMAGESTARTDATE的值
     */
    public DateTime getDamagestartdate(){
        return damagestartdate;
    }

    /**
     * 设置属性DAMAGECODE
     * @param damagecode 待设置的属性DAMAGECODE的值
     */
    public void setDamagecode(String damagecode){
        this.damagecode = StringUtils.rightTrim(damagecode);
    }

    /**
     * 获取属性DAMAGECODE
     * @return 属性DAMAGECODE的值
     */
    public String getDamagecode(){
        return damagecode;
    }

    /**
     * 设置属性DAMAGENAME
     * @param damagename 待设置的属性DAMAGENAME的值
     */
    public void setDamagename(String damagename){
        this.damagename = StringUtils.rightTrim(damagename);
    }

    /**
     * 获取属性DAMAGENAME
     * @return 属性DAMAGENAME的值
     */
    public String getDamagename(){
        return damagename;
    }

    /**
     * 设置属性NAME
     * @param name 待设置的属性NAME的值
     */
    public void setName(String name){
        this.name = StringUtils.rightTrim(name);
    }

    /**
     * 获取属性NAME
     * @return 属性NAME的值
     */
    public String getName(){
        return name;
    }

    /**
     * 设置属性NODENO
     * @param nodeno 待设置的属性NODENO的值
     */
    public void setNodeno(int nodeno){
        this.nodeno = nodeno;
    }

    /**
     * 获取属性NODENO
     * @return 属性NODENO的值
     */
    public int getNodeno(){
        return nodeno;
    }

    /**
     * 设置属性NODETYPE
     * @param nodetype 待设置的属性NODETYPE的值
     */
    public void setNodetype(String nodetype){
        this.nodetype = StringUtils.rightTrim(nodetype);
    }

    /**
     * 获取属性NODETYPE
     * @return 属性NODETYPE的值
     */
    public String getNodetype(){
        return nodetype;
    }

    /**
     * 设置属性KINDCODE
     * @param kindcode 待设置的属性KINDCODE的值
     */
    public void setKindcode(String kindcode){
        this.kindcode = StringUtils.rightTrim(kindcode);
    }

    /**
     * 获取属性KINDCODE
     * @return 属性KINDCODE的值
     */
    public String getKindcode(){
        return kindcode;
    }

    /**
     * 设置属性PHONE
     * @param phone 待设置的属性PHONE的值
     */
    public void setPhone(String phone){
        this.phone = StringUtils.rightTrim(phone);
    }

    /**
     * 获取属性PHONE
     * @return 属性PHONE的值
     */
    public String getPhone(){
        return phone;
    }

    /**
     * 设置属性ADDRESS
     * @param address 待设置的属性ADDRESS的值
     */
    public void setAddress(String address){
        this.address = StringUtils.rightTrim(address);
    }

    /**
     * 获取属性ADDRESS
     * @return 属性ADDRESS的值
     */
    public String getAddress(){
        return address;
    }

    /**
     * 设置属性REMARK
     * @param remark 待设置的属性REMARK的值
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * 获取属性REMARK
     * @return 属性REMARK的值
     */
    public String getRemark(){
        return remark;
    }

    /**
     * 设置属性HUKOUBU
     * @param hukoubu 待设置的属性HUKOUBU的值
     */
    public void setHukoubu(String hukoubu){
        this.hukoubu = StringUtils.rightTrim(hukoubu);
    }

    /**
     * 获取属性HUKOUBU
     * @return 属性HUKOUBU的值
     */
    public String getHukoubu(){
        return hukoubu;
    }

    /**
     * 设置属性ESTIMATELOSS
     * @param estimateloss 待设置的属性ESTIMATELOSS的值
     */
    public void setEstimateloss(double estimateloss){
        this.estimateloss = estimateloss;
    }

    /**
     * 获取属性ESTIMATELOSS
     * @return 属性ESTIMATELOSS的值
     */
    public double getEstimateloss(){
        return estimateloss;
    }

    /**
     * 设置属性BUSINESSNO
     * @param businessno 待设置的属性BUSINESSNO的值
     */
    public void setBusinessno(String businessno){
        this.businessno = StringUtils.rightTrim(businessno);
    }

    /**
     * 获取属性BUSINESSNO
     * @return 属性BUSINESSNO的值
     */
    public String getBusinessno(){
        return businessno;
    }
    
    /**
     * 设置属性FLOOR
     * @param floor 待设置的属性FLOOR的值
     */
    public void setFloor(String floor){
        this.floor = StringUtils.rightTrim(floor);
    }

    /**
     * 获取属性FLOOR
     * @return 属性FLOOR的值
     */
    public String getFloor(){
        return floor;
    }

    /**
     * 设置属性BUILDINGNUMBER
     * @param buildingnumber 待设置的属性BUILDINGNUMBER的值
     */
    public void setBuildingnumber(String buildingnumber){
        this.buildingnumber = StringUtils.rightTrim(buildingnumber);
    }

    /**
     * 获取属性BUILDINGNUMBER
     * @return 属性BUILDINGNUMBER的值
     */
    public String getBuildingnumber(){
        return buildingnumber;
    }

    /**
     * 设置属性ZHUANNUMBER
     * @param zhuannumber 待设置的属性ZHUANNUMBER的值
     */
    public void setZhuannumber(String zhuannumber){
        this.zhuannumber = StringUtils.rightTrim(zhuannumber);
    }

    /**
     * 获取属性ZHUANNUMBER
     * @return 属性ZHUANNUMBER的值
     */
    public String getZhuannumber(){
        return zhuannumber;
    }

    /**
     * 设置属性WANUMBER
     * @param wanumber 待设置的属性WANUMBER的值
     */
    public void setWanumber(String wanumber){
        this.wanumber = StringUtils.rightTrim(wanumber);
    }

    /**
     * 获取属性WANUMBER
     * @return 属性WANUMBER的值
     */
    public String getWanumber(){
        return wanumber;
    }

    /**
     * 设置属性KITCHENNUMBER
     * @param kitchennumber 待设置的属性KITCHENNUMBER的值
     */
    public void setKitchennumber(String kitchennumber){
        this.kitchennumber = StringUtils.rightTrim(kitchennumber);
    }

    /**
     * 获取属性KITCHENNUMBER
     * @return 属性KITCHENNUMBER的值
     */
    public String getKitchennumber(){
        return kitchennumber;
    }

    /**
     * 设置属性OTHERNUMBER
     * @param othernumber 待设置的属性OTHERNUMBER的值
     */
    public void setOthernumber(String othernumber){
        this.othernumber = StringUtils.rightTrim(othernumber);
    }

    /**
     * 获取属性OTHERNUMBER
     * @return 属性OTHERNUMBER的值
     */
    public String getOthernumber(){
        return othernumber;
    }
}
