package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����EdAgentSysData�����ݴ���������<br>
 * ������ 2005-07-19 09:58:46.091<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class EdAgentSysDataDtoBase implements Serializable{
    /** ���Ժ��б�ʶ */
    private String cALLID = "";
    /** �������к��� */
    private String aNI = "";
    /** ����ҵ����� */
    private String bUSINESSNO = "";
    /** ������ϯ���� */
    private String aGENTID = "";
    /** ����������� */
    private String tASKCODE = "";
    /** ����¼����־ */
    private String rECORDFLAG = "";
    /** ����¼������ */
    private DateTime iNPUTDATE = new DateTime();
    /** ���Ա�־λ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�EdAgentSysDataDtoBase����
     */
    public EdAgentSysDataDtoBase(){
    }

    /**
     * �������Ժ��б�ʶ
     * @param cALLID �����õ����Ժ��б�ʶ��ֵ
     */
    public void setCALLID(String cALLID){
        this.cALLID = StringUtils.rightTrim(cALLID);
    }

    /**
     * ��ȡ���Ժ��б�ʶ
     * @return ���Ժ��б�ʶ��ֵ
     */
    public String getCALLID(){
        return cALLID;
    }

    /**
     * �����������к���
     * @param aNI �����õ��������к����ֵ
     */
    public void setANI(String aNI){
        this.aNI = StringUtils.rightTrim(aNI);
    }

    /**
     * ��ȡ�������к���
     * @return �������к����ֵ
     */
    public String getANI(){
        return aNI;
    }

    /**
     * ��������ҵ�����
     * @param bUSINESSNO �����õ�����ҵ������ֵ
     */
    public void setBUSINESSNO(String bUSINESSNO){
        this.bUSINESSNO = StringUtils.rightTrim(bUSINESSNO);
    }

    /**
     * ��ȡ����ҵ�����
     * @return ����ҵ������ֵ
     */
    public String getBUSINESSNO(){
        return bUSINESSNO;
    }

    /**
     * ����������ϯ����
     * @param aGENTID �����õ�������ϯ���ŵ�ֵ
     */
    public void setAGENTID(String aGENTID){
        this.aGENTID = StringUtils.rightTrim(aGENTID);
    }

    /**
     * ��ȡ������ϯ����
     * @return ������ϯ���ŵ�ֵ
     */
    public String getAGENTID(){
        return aGENTID;
    }

    /**
     * ���������������
     * @param tASKCODE �����õ�������������ֵ
     */
    public void setTASKCODE(String tASKCODE){
        this.tASKCODE = StringUtils.rightTrim(tASKCODE);
    }

    /**
     * ��ȡ�����������
     * @return ������������ֵ
     */
    public String getTASKCODE(){
        return tASKCODE;
    }

    /**
     * ��������¼����־
     * @param rECORDFLAG �����õ�����¼����־��ֵ
     */
    public void setRECORDFLAG(String rECORDFLAG){
        this.rECORDFLAG = StringUtils.rightTrim(rECORDFLAG);
    }

    /**
     * ��ȡ����¼����־
     * @return ����¼����־��ֵ
     */
    public String getRECORDFLAG(){
        return rECORDFLAG;
    }

    /**
     * ��������¼������
     * @param iNPUTDATE �����õ�����¼�����ڵ�ֵ
     */
    public void setINPUTDATE(DateTime iNPUTDATE){
        this.iNPUTDATE = iNPUTDATE;
    }

    /**
     * ��ȡ����¼������
     * @return ����¼�����ڵ�ֵ
     */
    public DateTime getINPUTDATE(){
        return iNPUTDATE;
    }

    /**
     * �������Ա�־λ
     * @param flag �����õ����Ա�־λ��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ���Ա�־λ
     * @return ���Ա�־λ��ֵ
     */
    public String getFlag(){
        return flag;
    }
}
