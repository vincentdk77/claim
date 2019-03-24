package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ���ǹ�����������������ݴ���������<br>
 * ������ 2005-04-05 10:45:00.265<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class SwfNotionDtoBase implements Serializable{
    /** ���Թ�����ID */
    private String flowID = "";
    /** ������־��� */
    private int logNo = 0;
    /** �����к� */
    private int lineNo = 0;
    /** ���Դ������ */
    private String handleText = "";
    /** ���Ա��ñ�־ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�SwfNotionDtoBase����
     */
    public SwfNotionDtoBase(){
    }

    /**
     * �������Թ�����ID
     * @param flowID �����õ����Թ�����ID��ֵ
     */
    public void setFlowID(String flowID){
        this.flowID = StringUtils.rightTrim(flowID);
    }

    /**
     * ��ȡ���Թ�����ID
     * @return ���Թ�����ID��ֵ
     */
    public String getFlowID(){
        return flowID;
    }

    /**
     * ����������־���
     * @param logNo �����õ�������־��ŵ�ֵ
     */
    public void setLogNo(int logNo){
        this.logNo = logNo;
    }

    /**
     * ��ȡ������־���
     * @return ������־��ŵ�ֵ
     */
    public int getLogNo(){
        return logNo;
    }

    /**
     * ���������к�
     * @param lineNo �����õ������кŵ�ֵ
     */
    public void setLineNo(int lineNo){
        this.lineNo = lineNo;
    }

    /**
     * ��ȡ�����к�
     * @return �����кŵ�ֵ
     */
    public int getLineNo(){
        return lineNo;
    }

    /**
     * �������Դ������
     * @param handleText �����õ����Դ��������ֵ
     */
    public void setHandleText(String handleText){
        this.handleText = StringUtils.rightTrim(handleText);
    }

    /**
     * ��ȡ���Դ������
     * @return ���Դ��������ֵ
     */
    public String getHandleText(){
        return handleText;
    }

    /**
     * �������Ա��ñ�־
     * @param flag �����õ����Ա��ñ�־��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ���Ա��ñ�־
     * @return ���Ա��ñ�־��ֵ
     */
    public String getFlag(){
        return flag;
    }
}
