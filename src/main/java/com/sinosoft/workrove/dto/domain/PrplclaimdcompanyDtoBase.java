package com.sinosoft.workrove.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLCLAIMDCOMPANY�����ݴ���������<br>
 */
public class PrplclaimdcompanyDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����NODETYPE */
    private String nodetype = "";
    /** ����COMCODE */
    private String comcode = "";
    /** ����COMNAME */
    private String comname = "";
    /** ����UPPERCOMCODE */
    private String uppercomcode = "";
    /** ����LIMITFLAG */
    private String limitflag = "";
    /** ����SCHEDULECOMFLAG */
    private String schedulecomflag = "";
    /** ����MONEYLIMIT */
    private double moneylimit = 0D;
    /** ����ISCOMMIT */
    private String iscommit = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrplclaimdcompanyDtoBase����
     */
    public PrplclaimdcompanyDtoBase(){
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
     * ��������COMCODE
     * @param comcode �����õ�����COMCODE��ֵ
     */
    public void setComcode(String comcode){
        this.comcode = StringUtils.rightTrim(comcode);
    }

    /**
     * ��ȡ����COMCODE
     * @return ����COMCODE��ֵ
     */
    public String getComcode(){
        return comcode;
    }

    /**
     * ��������COMNAME
     * @param comname �����õ�����COMNAME��ֵ
     */
    public void setComname(String comname){
        this.comname = StringUtils.rightTrim(comname);
    }

    /**
     * ��ȡ����COMNAME
     * @return ����COMNAME��ֵ
     */
    public String getComname(){
        return comname;
    }

    /**
     * ��������UPPERCOMCODE
     * @param uppercomcode �����õ�����UPPERCOMCODE��ֵ
     */
    public void setUppercomcode(String uppercomcode){
        this.uppercomcode = StringUtils.rightTrim(uppercomcode);
    }

    /**
     * ��ȡ����UPPERCOMCODE
     * @return ����UPPERCOMCODE��ֵ
     */
    public String getUppercomcode(){
        return uppercomcode;
    }

    /**
     * ��������LIMITFLAG
     * @param limitflag �����õ�����LIMITFLAG��ֵ
     */
    public void setLimitflag(String limitflag){
        this.limitflag = StringUtils.rightTrim(limitflag);
    }

    /**
     * ��ȡ����LIMITFLAG
     * @return ����LIMITFLAG��ֵ
     */
    public String getLimitflag(){
        return limitflag;
    }

    /**
     * ��������SCHEDULECOMFLAG
     * @param schedulecomflag �����õ�����SCHEDULECOMFLAG��ֵ
     */
    public void setSchedulecomflag(String schedulecomflag){
        this.schedulecomflag = StringUtils.rightTrim(schedulecomflag);
    }

    /**
     * ��ȡ����SCHEDULECOMFLAG
     * @return ����SCHEDULECOMFLAG��ֵ
     */
    public String getSchedulecomflag(){
        return schedulecomflag;
    }

    /**
     * ��������MONEYLIMIT
     * @param moneylimit �����õ�����MONEYLIMIT��ֵ
     */
    public void setMoneylimit(double moneylimit){
        this.moneylimit = moneylimit;
    }

    /**
     * ��ȡ����MONEYLIMIT
     * @return ����MONEYLIMIT��ֵ
     */
    public double getMoneylimit(){
        return moneylimit;
    }

    /**
     * ��������ISCOMMIT
     * @param iscommit �����õ�����ISCOMMIT��ֵ
     */
    public void setIscommit(String iscommit){
        this.iscommit = StringUtils.rightTrim(iscommit);
    }

    /**
     * ��ȡ����ISCOMMIT
     * @return ����ISCOMMIT��ֵ
     */
    public String getIscommit(){
        return iscommit;
    }
}
