package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLCOMPLAINT�����ݴ���������<br>
 */
public class PrplcomplaintDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����COMPLAINTNO Ͷ�߱��*/
    private String complaintno = "";
    /** ����COMPLAINTDATE Ͷ��ʱ��*/
    private DateTime complaintdate = new DateTime();
    /** ����COMPLAINTTYPE Ͷ�ߴ���*/
    private String complainttype = "";
    /** ����BYCOMPLAINTCOMCODE ��Ͷ�߻���*/
    private String bycomplaintcomcode = "";
    /** ����BYCOMPLAINTCODE ��Ͷ����*/
    private String bycomplaintcode = "";
    /** ����COMPLAINTNAME Ͷ��������*/
    private String complaintname = "";
    /** ����CALLNO �������*/
    private String callno = "";
    /** ����TELEPHONE ������ϵ�绰*/
    private String telephone = "";
    /** ����COMPLAINTCAUSE Ͷ��ԭ��*/
    private String complaintcause = "";
    /** ����DETAILEDCAUSE Ͷ����ϸԭ��*/
    private String detailedcause = "";
    /** ����WHETHERCOMPLAINT �Ƿ���ЧͶ��*/
    private String whethercomplaint = "";
    /** ����WHETHERTRACK �Ƿ���Ҫ����*/
    private String whethertrack = "";
    /** ����REGISTNO ��������*/
    private String registno = "";
    /** ����RECORDINGNO ¼����ˮ��*/
    private String recordingno = "";
    /** ����HANDLERCODE Ͷ�ߴ�����ID*/
    private String handlercode = "";
    /** ����HANDLERNAME Ͷ������Ա*/
    private String handlername = "";
    /** ����HANDLERCOMCODE ����ṹID*/
    private String handlercomcode = "";
    /** ����COMPLAINTINFO Ͷ����Ϣ*/
    private String complaintinfo = "";
    /** ����COMPLAINTOPINION �������*/
    private String complaintopinion = "";
    /** ����TRANSACTORNAME ������Ա*/
    private String transactorname = "";
    /** ����TRANSACTORCODE ������ID*/
    private String transactorcode = "";
    /** ����HANDLERDATE Ͷ���ύʱ��*/
    private DateTime handlerdate = new DateTime();
    /** ����TRANSACTORDATE �����ύʱ��*/
    private DateTime transactordate = new DateTime();
    /** ����CLASSCODE ����*/
    private String classcode = "";
    /** ����STATE ״̬ (3������4�����ύ)*/
    private String state = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrplcomplaintDtoBase����
     */
    public PrplcomplaintDtoBase(){
    }

    /**
     * ��������COMPLAINTNO
     * @param complaintno �����õ�����COMPLAINTNO��ֵ
     */
    public void setComplaintno(String complaintno){
        this.complaintno = StringUtils.rightTrim(complaintno);
    }

    /**
     * ��ȡ����COMPLAINTNO
     * @return ����COMPLAINTNO��ֵ
     */
    public String getComplaintno(){
        return complaintno;
    }

    /**
     * ��������COMPLAINTDATE
     * @param complaintdate �����õ�����COMPLAINTDATE��ֵ
     */
    public void setComplaintdate(DateTime complaintdate){
        this.complaintdate = complaintdate;
    }

    /**
     * ��ȡ����COMPLAINTDATE
     * @return ����COMPLAINTDATE��ֵ
     */
    public DateTime getComplaintdate(){
        return complaintdate;
    }

    /**
     * ��������COMPLAINTTYPE
     * @param complainttype �����õ�����COMPLAINTTYPE��ֵ
     */
    public void setComplainttype(String complainttype){
        this.complainttype = StringUtils.rightTrim(complainttype);
    }

    /**
     * ��ȡ����COMPLAINTTYPE
     * @return ����COMPLAINTTYPE��ֵ
     */
    public String getComplainttype(){
        return complainttype;
    }

    /**
     * ��������BYCOMPLAINTCOMCODE
     * @param bycomplaintcomcode �����õ�����BYCOMPLAINTCOMCODE��ֵ
     */
    public void setBycomplaintcomcode(String bycomplaintcomcode){
        this.bycomplaintcomcode = StringUtils.rightTrim(bycomplaintcomcode);
    }

    /**
     * ��ȡ����BYCOMPLAINTCOMCODE
     * @return ����BYCOMPLAINTCOMCODE��ֵ
     */
    public String getBycomplaintcomcode(){
        return bycomplaintcomcode;
    }

    /**
     * ��������BYCOMPLAINTCODE
     * @param bycomplaintcode �����õ�����BYCOMPLAINTCODE��ֵ
     */
    public void setBycomplaintcode(String bycomplaintcode){
        this.bycomplaintcode = StringUtils.rightTrim(bycomplaintcode);
    }

    /**
     * ��ȡ����BYCOMPLAINTCODE
     * @return ����BYCOMPLAINTCODE��ֵ
     */
    public String getBycomplaintcode(){
        return bycomplaintcode;
    }

    /**
     * ��������COMPLAINTNAME
     * @param complaintname �����õ�����COMPLAINTNAME��ֵ
     */
    public void setComplaintname(String complaintname){
        this.complaintname = StringUtils.rightTrim(complaintname);
    }

    /**
     * ��ȡ����COMPLAINTNAME
     * @return ����COMPLAINTNAME��ֵ
     */
    public String getComplaintname(){
        return complaintname;
    }

    /**
     * ��������CALLNO
     * @param callno �����õ�����CALLNO��ֵ
     */
    public void setCallno(String callno){
        this.callno = StringUtils.rightTrim(callno);
    }

    /**
     * ��ȡ����CALLNO
     * @return ����CALLNO��ֵ
     */
    public String getCallno(){
        return callno;
    }

    /**
     * ��������TELEPHONE
     * @param telephone �����õ�����TELEPHONE��ֵ
     */
    public void setTelephone(String telephone){
        this.telephone = StringUtils.rightTrim(telephone);
    }

    /**
     * ��ȡ����TELEPHONE
     * @return ����TELEPHONE��ֵ
     */
    public String getTelephone(){
        return telephone;
    }

    /**
     * ��������COMPLAINTCAUSE
     * @param complaintcause �����õ�����COMPLAINTCAUSE��ֵ
     */
    public void setComplaintcause(String complaintcause){
        this.complaintcause = StringUtils.rightTrim(complaintcause);
    }

    /**
     * ��ȡ����COMPLAINTCAUSE
     * @return ����COMPLAINTCAUSE��ֵ
     */
    public String getComplaintcause(){
        return complaintcause;
    }

    /**
     * ��������DETAILEDCAUSE
     * @param detailedcause �����õ�����DETAILEDCAUSE��ֵ
     */
    public void setDetailedcause(String detailedcause){
        this.detailedcause = StringUtils.rightTrim(detailedcause);
    }

    /**
     * ��ȡ����DETAILEDCAUSE
     * @return ����DETAILEDCAUSE��ֵ
     */
    public String getDetailedcause(){
        return detailedcause;
    }

    /**
     * ��������WHETHERCOMPLAINT
     * @param whethercomplaint �����õ�����WHETHERCOMPLAINT��ֵ
     */
    public void setWhethercomplaint(String whethercomplaint){
        this.whethercomplaint = StringUtils.rightTrim(whethercomplaint);
    }

    /**
     * ��ȡ����WHETHERCOMPLAINT
     * @return ����WHETHERCOMPLAINT��ֵ
     */
    public String getWhethercomplaint(){
        return whethercomplaint;
    }

    /**
     * ��������WHETHERTRACK
     * @param whethertrack �����õ�����WHETHERTRACK��ֵ
     */
    public void setWhethertrack(String whethertrack){
        this.whethertrack = StringUtils.rightTrim(whethertrack);
    }

    /**
     * ��ȡ����WHETHERTRACK
     * @return ����WHETHERTRACK��ֵ
     */
    public String getWhethertrack(){
        return whethertrack;
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
     * ��������RECORDINGNO
     * @param recordingno �����õ�����RECORDINGNO��ֵ
     */
    public void setRecordingno(String recordingno){
        this.recordingno = StringUtils.rightTrim(recordingno);
    }

    /**
     * ��ȡ����RECORDINGNO
     * @return ����RECORDINGNO��ֵ
     */
    public String getRecordingno(){
        return recordingno;
    }

    /**
     * ��������HANDLERCODE
     * @param handlercode �����õ�����HANDLERCODE��ֵ
     */
    public void setHandlercode(String handlercode){
        this.handlercode = StringUtils.rightTrim(handlercode);
    }

    /**
     * ��ȡ����HANDLERCODE
     * @return ����HANDLERCODE��ֵ
     */
    public String getHandlercode(){
        return handlercode;
    }

    /**
     * ��������HANDLERNAME
     * @param handlername �����õ�����HANDLERNAME��ֵ
     */
    public void setHandlername(String handlername){
        this.handlername = StringUtils.rightTrim(handlername);
    }

    /**
     * ��ȡ����HANDLERNAME
     * @return ����HANDLERNAME��ֵ
     */
    public String getHandlername(){
        return handlername;
    }

    /**
     * ��������HANDLERCOMCODE
     * @param handlercomcode �����õ�����HANDLERCOMCODE��ֵ
     */
    public void setHandlercomcode(String handlercomcode){
        this.handlercomcode = StringUtils.rightTrim(handlercomcode);
    }

    /**
     * ��ȡ����HANDLERCOMCODE
     * @return ����HANDLERCOMCODE��ֵ
     */
    public String getHandlercomcode(){
        return handlercomcode;
    }

    /**
     * ��������COMPLAINTINFO
     * @param complaintinfo �����õ�����COMPLAINTINFO��ֵ
     */
    public void setComplaintinfo(String complaintinfo){
        this.complaintinfo = StringUtils.rightTrim(complaintinfo);
    }

    /**
     * ��ȡ����COMPLAINTINFO
     * @return ����COMPLAINTINFO��ֵ
     */
    public String getComplaintinfo(){
        return complaintinfo;
    }

    /**
     * ��������COMPLAINTOPINION
     * @param complaintopinion �����õ�����COMPLAINTOPINION��ֵ
     */
    public void setComplaintopinion(String complaintopinion){
        this.complaintopinion = StringUtils.rightTrim(complaintopinion);
    }

    /**
     * ��ȡ����COMPLAINTOPINION
     * @return ����COMPLAINTOPINION��ֵ
     */
    public String getComplaintopinion(){
        return complaintopinion;
    }

    /**
     * ��������TRANSACTORNAME
     * @param transactorname �����õ�����TRANSACTORNAME��ֵ
     */
    public void setTransactorname(String transactorname){
        this.transactorname = StringUtils.rightTrim(transactorname);
    }

    /**
     * ��ȡ����TRANSACTORNAME
     * @return ����TRANSACTORNAME��ֵ
     */
    public String getTransactorname(){
        return transactorname;
    }

    /**
     * ��������TRANSACTORCODE
     * @param transactorcode �����õ�����TRANSACTORCODE��ֵ
     */
    public void setTransactorcode(String transactorcode){
        this.transactorcode = StringUtils.rightTrim(transactorcode);
    }

    /**
     * ��ȡ����TRANSACTORCODE
     * @return ����TRANSACTORCODE��ֵ
     */
    public String getTransactorcode(){
        return transactorcode;
    }

    /**
     * ��������HANDLERDATE
     * @param handlerdate �����õ�����HANDLERDATE��ֵ
     */
    public void setHandlerdate(DateTime handlerdate){
        this.handlerdate = handlerdate;
    }

    /**
     * ��ȡ����HANDLERDATE
     * @return ����HANDLERDATE��ֵ
     */
    public DateTime getHandlerdate(){
        return handlerdate;
    }

    /**
     * ��������TRANSACTORDATE
     * @param transactordate �����õ�����TRANSACTORDATE��ֵ
     */
    public void setTransactordate(DateTime transactordate){
        this.transactordate = transactordate;
    }

    /**
     * ��ȡ����TRANSACTORDATE
     * @return ����TRANSACTORDATE��ֵ
     */
    public DateTime getTransactordate(){
        return transactordate;
    }

    /**
     * ��������CLASSCODE
     * @param classcode �����õ�����CLASSCODE��ֵ
     */
    public void setClasscode(String classcode){
        this.classcode = StringUtils.rightTrim(classcode);
    }

    /**
     * ��ȡ����CLASSCODE
     * @return ����CLASSCODE��ֵ
     */
    public String getClasscode(){
        return classcode;
    }

    /**
     * ��������STATE
     * @param state �����õ�����STATE��ֵ
     */
    public void setState(String state){
        this.state = StringUtils.rightTrim(state);
    }

    /**
     * ��ȡ����STATE
     * @return ����STATE��ֵ
     */
    public String getState(){
        return state;
    }
}
