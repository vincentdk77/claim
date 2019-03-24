package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Date;

import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLINTERPAYDELETEQUEST�����ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLinterPayDeleteRequestDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ���Կͻ������� */
    private String outId = "";
    /** ���Բ����˴��� */
    private String operatorCode = "";
    /** ���Բ��������� */
    private String operatorName = "";
    /** ���Բ����˻������� */
    private String makeCom = "";
    /** ���Բ����˻������� */
    private String makeComName = "";
    /** ���Բ���ʱ�� */
    private DateTime operatorDate = new DateTime();
    /** ����ɾ��ԭ�� */
    private String handleText = "";
    private String autoFlag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PRPLINTERPAYDELETEQUESTDtoBase����
     */
    public PrpLinterPayDeleteRequestDtoBase(){
    }

    /**
     * �������Կͻ�������
     * @param outId �����õ����Կͻ���������ֵ
     */
    public void setOutId(String outId){
        this.outId = StringUtils.rightTrim(outId);
    }

    /**
     * ��ȡ���Կͻ�������
     * @return ���Կͻ���������ֵ
     */
    public String getOutId(){
        return outId;
    }

    /**
     * �������Բ����˴���
     * @param operatorCode �����õ����Բ����˴����ֵ
     */
    public void setOperatorCode(String operatorCode){
        this.operatorCode = StringUtils.rightTrim(operatorCode);
    }

    /**
     * ��ȡ���Բ����˴���
     * @return ���Բ����˴����ֵ
     */
    public String getOperatorCode(){
        return operatorCode;
    }

    /**
     * �������Բ���������
     * @param operatorName �����õ����Բ��������Ƶ�ֵ
     */
    public void setOperatorName(String operatorName){
        this.operatorName = StringUtils.rightTrim(operatorName);
    }

    /**
     * ��ȡ���Բ���������
     * @return ���Բ��������Ƶ�ֵ
     */
    public String getOperatorName(){
        return operatorName;
    }

    /**
     * �������Բ����˻�������
     * @param makeCom �����õ����Բ����˻��������ֵ
     */
    public void setMakeCom(String makeCom){
        this.makeCom = StringUtils.rightTrim(makeCom);
    }

    /**
     * ��ȡ���Բ����˻�������
     * @return ���Բ����˻��������ֵ
     */
    public String getMakeCom(){
        return makeCom;
    }

    /**
     * �������Բ����˻�������
     * @param makeComName �����õ����Բ����˻������Ƶ�ֵ
     */
    public void setMakeComName(String makeComName){
        this.makeComName = StringUtils.rightTrim(makeComName);
    }

    /**
     * ��ȡ���Բ����˻�������
     * @return ���Բ����˻������Ƶ�ֵ
     */
    public String getMakeComName(){
        return makeComName;
    }

    /**
     * �������Բ���ʱ��
     * @param operatorDate �����õ����Բ���ʱ���ֵ
     */
    public void setOperatorDate(DateTime operatorDate){
        this.operatorDate = operatorDate;
    }

    /**
     * ��ȡ���Բ���ʱ��
     * @return ���Բ���ʱ���ֵ
     */
    public DateTime getOperatorDate(){
        return operatorDate;
    }

    /**
     * ��������ɾ��ԭ��
     * @param handleText �����õ�����ɾ��ԭ���ֵ
     */
    public void setHandleText(String handleText){
        this.handleText = StringUtils.rightTrim(handleText);
    }

    /**
     * ��ȡ����ɾ��ԭ��
     * @return ����ɾ��ԭ���ֵ
     */
    public String getHandleText(){
        return handleText;
    }

	public String getAutoFlag() {
		return autoFlag;
	}

	public void setAutoFlag(String autoFlag) {
		this.autoFlag = autoFlag;
	}
    
}
