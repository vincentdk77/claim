package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLCOMPENSATEHOUSE�����ݴ���������<br>
 */
public class PrplcompensatehousetgDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����IDCARD */
    private String idcard = "";
    /** ����POLICYNO */
    private String policyno = "";
    /** ����REGISTNO */
    private String registno = "";
    /** ����CLAIMNO */
    private String claimno = "";
    /** ����COMPENSATENO */
    private String compensateno = "";
    /** ����CASENO */
    private String caseno = "";
    /** ����DAMAGESTARTDATE */
    private DateTime damagestartdate = new DateTime();
    /** ����DAMAGECODE */
    private String damagecode = "";
    /** ����DAMAGENAME */
    private String damagename = "";
    /** ����NAME */
    private String name = "";
    /** ����NODENO */
    private int nodeno = 0;
    /** ����NODETYPE */
    private String nodetype = "";
    /** ����KINDCODE */
    private String kindcode = "";
    /** ����PHONE */
    private String phone = "";
    /** ����ADDRESS */
    private String address = "";
    /** ����REMARK */
    private String remark = "";
    /** ����HUKOUBU */
    private String hukoubu = "";
    /** ����ESTIMATELOSS */
    private double estimateloss = 0D;
    /** ����BUSINESSNO */
    private String businessno = "";
    
    /** ����FLOOR */
    private String floor = "";
    /** ����BUILDINGNUMBER */
    private String buildingnumber = "";
    /** ����ZHUANNUMBER */
    private String zhuannumber = "";
    /** ����WANUMBER */
    private String wanumber = "";
    /** ����KITCHENNUMBER */
    private String kitchennumber = "";
    /** ����OTHERNUMBER */
    private String othernumber = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrplcompensatehousetgDtoBase����
     */
    public PrplcompensatehousetgDtoBase(){
    }

    /**
     * ��������IDCARD
     * @param idcard �����õ�����IDCARD��ֵ
     */
    public void setIdcard(String idcard){
        this.idcard = StringUtils.rightTrim(idcard);
    }

    /**
     * ��ȡ����IDCARD
     * @return ����IDCARD��ֵ
     */
    public String getIdcard(){
        return idcard;
    }

    /**
     * ��������POLICYNO
     * @param policyno �����õ�����POLICYNO��ֵ
     */
    public void setPolicyno(String policyno){
        this.policyno = StringUtils.rightTrim(policyno);
    }

    /**
     * ��ȡ����POLICYNO
     * @return ����POLICYNO��ֵ
     */
    public String getPolicyno(){
        return policyno;
    }

    /**
     * ��������REGISTNO
     * @param registno �����õ�����REGISTNO��ֵ
     */
    public void setRegistno(String registno){
        this.registno = StringUtils.rightTrim(registno);
    }

    /**
     * ��ȡ����REGISTNO
     * @return ����REGISTNO��ֵ
     */
    public String getRegistno(){
        return registno;
    }

    /**
     * ��������CLAIMNO
     * @param claimno �����õ�����CLAIMNO��ֵ
     */
    public void setClaimno(String claimno){
        this.claimno = StringUtils.rightTrim(claimno);
    }

    /**
     * ��ȡ����CLAIMNO
     * @return ����CLAIMNO��ֵ
     */
    public String getClaimno(){
        return claimno;
    }

    /**
     * ��������COMPENSATENO
     * @param compensateno �����õ�����COMPENSATENO��ֵ
     */
    public void setCompensateno(String compensateno){
        this.compensateno = StringUtils.rightTrim(compensateno);
    }

    /**
     * ��ȡ����COMPENSATENO
     * @return ����COMPENSATENO��ֵ
     */
    public String getCompensateno(){
        return compensateno;
    }

    /**
     * ��������CASENO
     * @param caseno �����õ�����CASENO��ֵ
     */
    public void setCaseno(String caseno){
        this.caseno = StringUtils.rightTrim(caseno);
    }

    /**
     * ��ȡ����CASENO
     * @return ����CASENO��ֵ
     */
    public String getCaseno(){
        return caseno;
    }

    /**
     * ��������DAMAGESTARTDATE
     * @param damagestartdate �����õ�����DAMAGESTARTDATE��ֵ
     */
    public void setDamagestartdate(DateTime damagestartdate){
        this.damagestartdate = damagestartdate;
    }

    /**
     * ��ȡ����DAMAGESTARTDATE
     * @return ����DAMAGESTARTDATE��ֵ
     */
    public DateTime getDamagestartdate(){
        return damagestartdate;
    }

    /**
     * ��������DAMAGECODE
     * @param damagecode �����õ�����DAMAGECODE��ֵ
     */
    public void setDamagecode(String damagecode){
        this.damagecode = StringUtils.rightTrim(damagecode);
    }

    /**
     * ��ȡ����DAMAGECODE
     * @return ����DAMAGECODE��ֵ
     */
    public String getDamagecode(){
        return damagecode;
    }

    /**
     * ��������DAMAGENAME
     * @param damagename �����õ�����DAMAGENAME��ֵ
     */
    public void setDamagename(String damagename){
        this.damagename = StringUtils.rightTrim(damagename);
    }

    /**
     * ��ȡ����DAMAGENAME
     * @return ����DAMAGENAME��ֵ
     */
    public String getDamagename(){
        return damagename;
    }

    /**
     * ��������NAME
     * @param name �����õ�����NAME��ֵ
     */
    public void setName(String name){
        this.name = StringUtils.rightTrim(name);
    }

    /**
     * ��ȡ����NAME
     * @return ����NAME��ֵ
     */
    public String getName(){
        return name;
    }

    /**
     * ��������NODENO
     * @param nodeno �����õ�����NODENO��ֵ
     */
    public void setNodeno(int nodeno){
        this.nodeno = nodeno;
    }

    /**
     * ��ȡ����NODENO
     * @return ����NODENO��ֵ
     */
    public int getNodeno(){
        return nodeno;
    }

    /**
     * ��������NODETYPE
     * @param nodetype �����õ�����NODETYPE��ֵ
     */
    public void setNodetype(String nodetype){
        this.nodetype = StringUtils.rightTrim(nodetype);
    }

    /**
     * ��ȡ����NODETYPE
     * @return ����NODETYPE��ֵ
     */
    public String getNodetype(){
        return nodetype;
    }

    /**
     * ��������KINDCODE
     * @param kindcode �����õ�����KINDCODE��ֵ
     */
    public void setKindcode(String kindcode){
        this.kindcode = StringUtils.rightTrim(kindcode);
    }

    /**
     * ��ȡ����KINDCODE
     * @return ����KINDCODE��ֵ
     */
    public String getKindcode(){
        return kindcode;
    }

    /**
     * ��������PHONE
     * @param phone �����õ�����PHONE��ֵ
     */
    public void setPhone(String phone){
        this.phone = StringUtils.rightTrim(phone);
    }

    /**
     * ��ȡ����PHONE
     * @return ����PHONE��ֵ
     */
    public String getPhone(){
        return phone;
    }

    /**
     * ��������ADDRESS
     * @param address �����õ�����ADDRESS��ֵ
     */
    public void setAddress(String address){
        this.address = StringUtils.rightTrim(address);
    }

    /**
     * ��ȡ����ADDRESS
     * @return ����ADDRESS��ֵ
     */
    public String getAddress(){
        return address;
    }

    /**
     * ��������REMARK
     * @param remark �����õ�����REMARK��ֵ
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * ��ȡ����REMARK
     * @return ����REMARK��ֵ
     */
    public String getRemark(){
        return remark;
    }

    /**
     * ��������HUKOUBU
     * @param hukoubu �����õ�����HUKOUBU��ֵ
     */
    public void setHukoubu(String hukoubu){
        this.hukoubu = StringUtils.rightTrim(hukoubu);
    }

    /**
     * ��ȡ����HUKOUBU
     * @return ����HUKOUBU��ֵ
     */
    public String getHukoubu(){
        return hukoubu;
    }

    /**
     * ��������ESTIMATELOSS
     * @param estimateloss �����õ�����ESTIMATELOSS��ֵ
     */
    public void setEstimateloss(double estimateloss){
        this.estimateloss = estimateloss;
    }

    /**
     * ��ȡ����ESTIMATELOSS
     * @return ����ESTIMATELOSS��ֵ
     */
    public double getEstimateloss(){
        return estimateloss;
    }

    /**
     * ��������BUSINESSNO
     * @param businessno �����õ�����BUSINESSNO��ֵ
     */
    public void setBusinessno(String businessno){
        this.businessno = StringUtils.rightTrim(businessno);
    }

    /**
     * ��ȡ����BUSINESSNO
     * @return ����BUSINESSNO��ֵ
     */
    public String getBusinessno(){
        return businessno;
    }
    
    /**
     * ��������FLOOR
     * @param floor �����õ�����FLOOR��ֵ
     */
    public void setFloor(String floor){
        this.floor = StringUtils.rightTrim(floor);
    }

    /**
     * ��ȡ����FLOOR
     * @return ����FLOOR��ֵ
     */
    public String getFloor(){
        return floor;
    }

    /**
     * ��������BUILDINGNUMBER
     * @param buildingnumber �����õ�����BUILDINGNUMBER��ֵ
     */
    public void setBuildingnumber(String buildingnumber){
        this.buildingnumber = StringUtils.rightTrim(buildingnumber);
    }

    /**
     * ��ȡ����BUILDINGNUMBER
     * @return ����BUILDINGNUMBER��ֵ
     */
    public String getBuildingnumber(){
        return buildingnumber;
    }

    /**
     * ��������ZHUANNUMBER
     * @param zhuannumber �����õ�����ZHUANNUMBER��ֵ
     */
    public void setZhuannumber(String zhuannumber){
        this.zhuannumber = StringUtils.rightTrim(zhuannumber);
    }

    /**
     * ��ȡ����ZHUANNUMBER
     * @return ����ZHUANNUMBER��ֵ
     */
    public String getZhuannumber(){
        return zhuannumber;
    }

    /**
     * ��������WANUMBER
     * @param wanumber �����õ�����WANUMBER��ֵ
     */
    public void setWanumber(String wanumber){
        this.wanumber = StringUtils.rightTrim(wanumber);
    }

    /**
     * ��ȡ����WANUMBER
     * @return ����WANUMBER��ֵ
     */
    public String getWanumber(){
        return wanumber;
    }

    /**
     * ��������KITCHENNUMBER
     * @param kitchennumber �����õ�����KITCHENNUMBER��ֵ
     */
    public void setKitchennumber(String kitchennumber){
        this.kitchennumber = StringUtils.rightTrim(kitchennumber);
    }

    /**
     * ��ȡ����KITCHENNUMBER
     * @return ����KITCHENNUMBER��ֵ
     */
    public String getKitchennumber(){
        return kitchennumber;
    }

    /**
     * ��������OTHERNUMBER
     * @param othernumber �����õ�����OTHERNUMBER��ֵ
     */
    public void setOthernumber(String othernumber){
        this.othernumber = StringUtils.rightTrim(othernumber);
    }

    /**
     * ��ȡ����OTHERNUMBER
     * @return ����OTHERNUMBER��ֵ
     */
    public String getOthernumber(){
        return othernumber;
    }
}
