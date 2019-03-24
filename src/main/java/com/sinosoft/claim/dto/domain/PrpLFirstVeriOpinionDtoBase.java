package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ���ǳ������������ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLFirstVeriOpinionDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ���Ա����� */
    private String registNo = "";
    /** ���Խ�ǿ��������� */
    private String compensateBz = "";
    /** ������ҵ��������� */
    private String compensateBi = "";
    /** �����¹����� */
    private String accidentType = "";
    /** ���Գ���ԭ�� */
    private String occReason = "";
    /** ����ͨ������ */
    private String accommodType = "";
    /** ����׷������ */
    private String recoveryType = "";
    /** �����Ƿ��⸶ */
    private String peifuFlag = "";
    /** �����⸶���� */
    private String peifuType = "";
    /** �����Ƿ���᰸ */
    private String lingjieAnFlag = "";
    /** ������᰸���� */
    private String lingjieAnType = "";
    /** ���Դ��������1 �ؼ�ͨ�� 2 �߷��տͻ� 3 �漰���� 4 ���ȫ�� 5 �貹������ */
    private String suggestionType = "";
    /** �����⸶˵�� */
    private String peifuIns = "";
    /** ���Խڵ� */
    private String nodeType = "";
    /** ������թ��־ */
    private String fraudLogo = "";
    /** ������թ�����ʧ��� */
    private double fraudRecoverAmount = 0.0;
    /** ������թ���� */
    private String fraudType = "";
    

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLFirstVeriOpinionDtoBase����
     */
    public PrpLFirstVeriOpinionDtoBase(){
    }

    /**
     * �������Ա�����
     * @param registNo �����õ����Ա����ŵ�ֵ
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * ��ȡ���Ա�����
     * @return ���Ա����ŵ�ֵ
     */
    public String getRegistNo(){
        return registNo;
    }

    /**
     * �������Խ�ǿ���������
     * @param compensateBz �����õ����Խ�ǿ��������ŵ�ֵ
     */
    public void setCompensateBz(String compensateBz){
        this.compensateBz = StringUtils.rightTrim(compensateBz);
    }

    /**
     * ��ȡ���Խ�ǿ���������
     * @return ���Խ�ǿ��������ŵ�ֵ
     */
    public String getCompensateBz(){
        return compensateBz;
    }

    /**
     * ����������ҵ���������
     * @param compensateBi �����õ�������ҵ��������ŵ�ֵ
     */
    public void setCompensateBi(String compensateBi){
        this.compensateBi = StringUtils.rightTrim(compensateBi);
    }

    /**
     * ��ȡ������ҵ���������
     * @return ������ҵ��������ŵ�ֵ
     */
    public String getCompensateBi(){
        return compensateBi;
    }

    /**
     * ���������¹�����
     * @param accidentType �����õ������¹����͵�ֵ
     */
    public void setAccidentType(String accidentType){
        this.accidentType = StringUtils.rightTrim(accidentType);
    }

    /**
     * ��ȡ�����¹�����
     * @return �����¹����͵�ֵ
     */
    public String getAccidentType(){
        return accidentType;
    }

    /**
     * �������Գ���ԭ��
     * @param occReason �����õ����Գ���ԭ���ֵ
     */
    public void setOccReason(String occReason){
        this.occReason = StringUtils.rightTrim(occReason);
    }

    /**
     * ��ȡ���Գ���ԭ��
     * @return ���Գ���ԭ���ֵ
     */
    public String getOccReason(){
        return occReason;
    }

    /**
     * ��������ͨ������
     * @param accommodType �����õ�����ͨ�����͵�ֵ
     */
    public void setAccommodType(String accommodType){
        this.accommodType = StringUtils.rightTrim(accommodType);
    }

    /**
     * ��ȡ����ͨ������
     * @return ����ͨ�����͵�ֵ
     */
    public String getAccommodType(){
        return accommodType;
    }

    /**
     * ��������׷������
     * @param recoveryType �����õ�����׷�����͵�ֵ
     */
    public void setRecoveryType(String recoveryType){
        this.recoveryType = StringUtils.rightTrim(recoveryType);
    }

    /**
     * ��ȡ����׷������
     * @return ����׷�����͵�ֵ
     */
    public String getRecoveryType(){
        return recoveryType;
    }

    /**
     * ���������Ƿ��⸶
     * @param peifuFlag �����õ������Ƿ��⸶��ֵ
     */
    public void setPeifuFlag(String peifuFlag){
        this.peifuFlag = StringUtils.rightTrim(peifuFlag);
    }

    /**
     * ��ȡ�����Ƿ��⸶
     * @return �����Ƿ��⸶��ֵ
     */
    public String getPeifuFlag(){
        return peifuFlag;
    }

    /**
     * ���������⸶����
     * @param peifuType �����õ������⸶���͵�ֵ
     */
    public void setPeifuType(String peifuType){
        this.peifuType = StringUtils.rightTrim(peifuType);
    }

    /**
     * ��ȡ�����⸶����
     * @return �����⸶���͵�ֵ
     */
    public String getPeifuType(){
        return peifuType;
    }

    /**
     * ���������Ƿ���᰸
     * @param lingjieAnFlag �����õ������Ƿ���᰸��ֵ
     */
    public void setLingjieAnFlag(String lingjieAnFlag){
        this.lingjieAnFlag = StringUtils.rightTrim(lingjieAnFlag);
    }

    /**
     * ��ȡ�����Ƿ���᰸
     * @return �����Ƿ���᰸��ֵ
     */
    public String getLingjieAnFlag(){
        return lingjieAnFlag;
    }

    /**
     * ����������᰸����
     * @param lingjieAnType �����õ�������᰸���͵�ֵ
     */
    public void setLingjieAnType(String lingjieAnType){
        this.lingjieAnType = StringUtils.rightTrim(lingjieAnType);
    }

    /**
     * ��ȡ������᰸����
     * @return ������᰸���͵�ֵ
     */
    public String getLingjieAnType(){
        return lingjieAnType;
    }

    /**
     * �������Դ��������1 �ؼ�ͨ�� 2 �߷��տͻ� 3 �漰���� 4 ���ȫ�� 5 �貹������
     * @param suggestionType �����õ����Դ��������1 �ؼ�ͨ�� 2 �߷��տͻ� 3 �漰���� 4 ���ȫ�� 5 �貹�����ϵ�ֵ
     */
    public void setSuggestionType(String suggestionType){
        this.suggestionType = StringUtils.rightTrim(suggestionType);
    }

    /**
     * ��ȡ���Դ��������1 �ؼ�ͨ�� 2 �߷��տͻ� 3 �漰���� 4 ���ȫ�� 5 �貹������
     * @return ���Դ��������1 �ؼ�ͨ�� 2 �߷��տͻ� 3 �漰���� 4 ���ȫ�� 5 �貹�����ϵ�ֵ
     */
    public String getSuggestionType(){
        return suggestionType;
    }

    /**
     * ���������⸶˵��
     * @param peifuIns �����õ������⸶˵����ֵ
     */
    public void setPeifuIns(String peifuIns){
        this.peifuIns = StringUtils.rightTrim(peifuIns);
    }

    /**
     * ��ȡ�����⸶˵��
     * @return �����⸶˵����ֵ
     */
    public String getPeifuIns(){
        return peifuIns;
    }

	public String getNodeType() {
		return nodeType;
	}

	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}

	public String getFraudLogo() {
		return fraudLogo;
	}

	public void setFraudLogo(String fraudLogo) {
		this.fraudLogo = fraudLogo;
	}

	public double getFraudRecoverAmount() {
		return fraudRecoverAmount;
	}

	public void setFraudRecoverAmount(double fraudRecoverAmount) {
		this.fraudRecoverAmount = fraudRecoverAmount;
	}

	public String getFraudType() {
		return fraudType;
	}

	public void setFraudType(String fraudType) {
		this.fraudType = fraudType;
	}
	
}
