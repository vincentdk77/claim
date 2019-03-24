package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����SwfPathLogStore�����ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class SwfPathLogStoreDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����flowID */
    private String flowID = "";
    /** ����pathNo */
    private int pathNo = 0;
    /** ����modelNo */
    private int modelNo = 0;
    /** ����pathName */
    private String pathName = "";
    /** ����startNodeNo */
    private int startNodeNo = 0;
    /** ����startNodeName */
    private String startNodeName = "";
    /** ����endNodeNo */
    private int endNodeNo = 0;
    /** ����endNodeName */
    private String endNodeName = "";
    /** ����flowInTime */
    private DateTime flowInTime = new DateTime();
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�SwfPathLogStoreDtoBase����
     */
    public SwfPathLogStoreDtoBase(){
    }

    /**
     * ��������flowID
     * @param flowID �����õ�����flowID��ֵ
     */
    public void setFlowID(String flowID){
        this.flowID = StringUtils.rightTrim(flowID);
    }

    /**
     * ��ȡ����flowID
     * @return ����flowID��ֵ
     */
    public String getFlowID(){
        return flowID;
    }

    /**
     * ��������pathNo
     * @param pathNo �����õ�����pathNo��ֵ
     */
    public void setPathNo(int pathNo){
        this.pathNo = pathNo;
    }

    /**
     * ��ȡ����pathNo
     * @return ����pathNo��ֵ
     */
    public int getPathNo(){
        return pathNo;
    }

    /**
     * ��������modelNo
     * @param modelNo �����õ�����modelNo��ֵ
     */
    public void setModelNo(int modelNo){
        this.modelNo = modelNo;
    }

    /**
     * ��ȡ����modelNo
     * @return ����modelNo��ֵ
     */
    public int getModelNo(){
        return modelNo;
    }

    /**
     * ��������pathName
     * @param pathName �����õ�����pathName��ֵ
     */
    public void setPathName(String pathName){
        this.pathName = StringUtils.rightTrim(pathName);
    }

    /**
     * ��ȡ����pathName
     * @return ����pathName��ֵ
     */
    public String getPathName(){
        return pathName;
    }

    /**
     * ��������startNodeNo
     * @param startNodeNo �����õ�����startNodeNo��ֵ
     */
    public void setStartNodeNo(int startNodeNo){
        this.startNodeNo = startNodeNo;
    }

    /**
     * ��ȡ����startNodeNo
     * @return ����startNodeNo��ֵ
     */
    public int getStartNodeNo(){
        return startNodeNo;
    }

    /**
     * ��������startNodeName
     * @param startNodeName �����õ�����startNodeName��ֵ
     */
    public void setStartNodeName(String startNodeName){
        this.startNodeName = StringUtils.rightTrim(startNodeName);
    }

    /**
     * ��ȡ����startNodeName
     * @return ����startNodeName��ֵ
     */
    public String getStartNodeName(){
        return startNodeName;
    }

    /**
     * ��������endNodeNo
     * @param endNodeNo �����õ�����endNodeNo��ֵ
     */
    public void setEndNodeNo(int endNodeNo){
        this.endNodeNo = endNodeNo;
    }

    /**
     * ��ȡ����endNodeNo
     * @return ����endNodeNo��ֵ
     */
    public int getEndNodeNo(){
        return endNodeNo;
    }

    /**
     * ��������endNodeName
     * @param endNodeName �����õ�����endNodeName��ֵ
     */
    public void setEndNodeName(String endNodeName){
        this.endNodeName = StringUtils.rightTrim(endNodeName);
    }

    /**
     * ��ȡ����endNodeName
     * @return ����endNodeName��ֵ
     */
    public String getEndNodeName(){
        return endNodeName;
    }

    /**
     * ��������flowInTime
     * @param flowInTime �����õ�����flowInTime��ֵ
     */
    public void setFlowInTime(DateTime flowInTime){
        this.flowInTime = flowInTime;
    }

    /**
     * ��ȡ����flowInTime
     * @return ����flowInTime��ֵ
     */
    public DateTime getFlowInTime(){
        return flowInTime;
    }

    /**
     * ��������flag
     * @param flag �����õ�����flag��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ����flag
     * @return ����flag��ֵ
     */
    public String getFlag(){
        return flag;
    }
}
