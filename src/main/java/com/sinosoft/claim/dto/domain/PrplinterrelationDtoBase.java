package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * �����м����������ŵ����ݴ���������<br>
 */
public class PrplinterrelationDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ��������id */
    private String id = "";
    /** ���Կͻ������� */
    private String outId = "";
    /** ��������ʱ�� */
    private DateTime inputDate = new DateTime();
    /** ���Ժ���ͬ����ʾ */
    private String synchronFlag = "";
    /** ���Թ����������� */
    private String relationRegistNo = "";
    /** ���Կͻ��˱�����ˮ�� */
    private String outRigstNo = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrplinterrelationDtoBase����
     */
    public PrplinterrelationDtoBase(){
    }

    /**
     * ������������id
     * @param id �����õ���������id��ֵ
     */
    public void setId(String id){
        this.id = StringUtils.rightTrim(id);
    }

    /**
     * ��ȡ��������id
     * @return ��������id��ֵ
     */
    public String getId(){
        return id;
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
     * ������������ʱ��
     * @param inputDate �����õ���������ʱ���ֵ
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * ��ȡ��������ʱ��
     * @return ��������ʱ���ֵ
     */
    public DateTime getInputDate(){
        return inputDate;
    }

    /**
     * �������Ժ���ͬ����ʾ
     * @param synchronFlag �����õ����Ժ���ͬ����ʾ��ֵ
     */
    public void setSynchronFlag(String synchronFlag){
        this.synchronFlag = StringUtils.rightTrim(synchronFlag);
    }

    /**
     * ��ȡ���Ժ���ͬ����ʾ
     * @return ���Ժ���ͬ����ʾ��ֵ
     */
    public String getSynchronFlag(){
        return synchronFlag;
    }

    /**
     * �������Թ�����������
     * @param relationRegistNo �����õ����Թ������������ֵ
     */
    public void setRelationRegistNo(String relationRegistNo){
        this.relationRegistNo = StringUtils.rightTrim(relationRegistNo);
    }

    /**
     * ��ȡ���Թ�����������
     * @return ���Թ������������ֵ
     */
    public String getRelationRegistNo(){
        return relationRegistNo;
    }

	public String getOutRigstNo() {
		return outRigstNo;
	}

	public void setOutRigstNo(String outRigstNo) {
		this.outRigstNo = outRigstNo;
	}
}
