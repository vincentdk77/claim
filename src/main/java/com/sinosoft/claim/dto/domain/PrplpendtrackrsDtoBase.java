package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLPENDTRACKRS�����ݴ���������<br>
 */
public class PrplpendtrackrsDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����REGISTNO ������*/
    private String registno = "";
    /** ����LOGNO ���*/
    private String logno = "";
    /** ����NODETYPE ��Ӧ�����������鿱�����˲鿱����֤)*/
    private String nodetype = "";
    /** ����KINDCODE �漰�ձ�*/
    private String kindcode = "";
    /** ����NAME ��������*/
    private String name = "";
    /** ����TREATMENT �������*/
    private String treatment = "";
    /** ����COST �Ѳ�������*/
    private String cost = "";
    /** ����REMARK ����˵��*/
    private String remark = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrplpendtrackrsDtoBase����
     */
    public PrplpendtrackrsDtoBase(){
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
     * ��������LOGNO
     * @param logno �����õ�����LOGNO��ֵ
     */
    public void setLogno(String logno){
        this.logno = StringUtils.rightTrim(logno);
    }

    /**
     * ��ȡ����LOGNO
     * @return ����LOGNO��ֵ
     */
    public String getLogno(){
        return logno;
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
     * ��������TREATMENT
     * @param treatment �����õ�����TREATMENT��ֵ
     */
    public void setTreatment(String treatment){
        this.treatment = StringUtils.rightTrim(treatment);
    }

    /**
     * ��ȡ����TREATMENT
     * @return ����TREATMENT��ֵ
     */
    public String getTreatment(){
        return treatment;
    }

    /**
     * ��������COST
     * @param cost �����õ�����COST��ֵ
     */
    public void setCost(String cost){
        this.cost = StringUtils.rightTrim(cost);
    }

    /**
     * ��ȡ����COST
     * @return ����COST��ֵ
     */
    public String getCost(){
        return cost;
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
}
