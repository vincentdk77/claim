package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLJOBMANAGERTIME�����ݴ���������<br>
 */
public class PrpljobmanagertimeDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����FID */
    private String fid = "";
    /** ����DATETYPE */
    private String datetype = "";
    /** ����TIME */
    private String time = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpljobmanagertimeDtoBase����
     */
    public PrpljobmanagertimeDtoBase(){
    }

    /**
     * ��������FID
     * @param fid �����õ�����FID��ֵ
     */
    public void setFid(String fid){
        this.fid = StringUtils.rightTrim(fid);
    }

    /**
     * ��ȡ����FID
     * @return ����FID��ֵ
     */
    public String getFid(){
        return fid;
    }

    /**
     * ��������DATETYPE
     * @param datetype �����õ�����DATETYPE��ֵ
     */
    public void setDatetype(String datetype){
        this.datetype = StringUtils.rightTrim(datetype);
    }

    /**
     * ��ȡ����DATETYPE
     * @return ����DATETYPE��ֵ
     */
    public String getDatetype(){
        return datetype;
    }

    /**
     * ��������TIME
     * @param time �����õ�����TIME��ֵ
     */
    public void setTime(String time){
        this.time = StringUtils.rightTrim(time);
    }

    /**
     * ��ȡ����TIME
     * @return ����TIME��ֵ
     */
    public String getTime(){
        return time;
    }
}
