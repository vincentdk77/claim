package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.claim.bl.action.domain.PrpLinterInjuryPersonDto;

/**
 * ��������ӿڽ����м������ݴ��������<br>
 */
public class PrpLinterRequestDto extends PrpLinterRequestDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    
    /**����Ͷ��������**/
    private String relationRegistNo = "";
    
    /**�ؿ��ⰸ��ʶ��Ĭ��false��������*/
    private boolean recaseFlag  = false;
    
    /**����ע����ʶ��Ĭ��false���߱���ע��*/
    private boolean cancelFlag  = false;
    
    /** �����¹�����Ϣ */
	private PrpLinterAccdentPersonDto[] prpLinterAccdentPersonDto;
	/** ���Ե��Ȳ���˵����Ϣ */
	private PrpLinterSchedExtDto[] prpLinterSchedExtDto;
	/** ��������������������Ϣ */
	private PrpLinterClaimAppDto[] prpLinterClaimAppDto;
	/** ���������ձ��������Ϣ */
	private PrpLinterClaimKindDto[] prpLinterClaimKindDto;
	/** ���Է�����Ϣ */
	private PrpLinterPrepayFeeDto[] prpLinterPrepayFeeDto;
	/** ���Ե�֤��Ϣ */
	private PrpLinterCertifyDto[] prpLinterCertifyDto;
	/** ���Լ����������Ϣ */
	private PrpLinterCompeFeeDto[] prpLinterCompeFeeDto;
	/** ���Լ�������������Ϣ */
	private PrpLinterCompePayFeeDto[] prpLinterCompePayFeeDto;
	/** ���Լ����������嵥��Ϣ */
	private PrpLinterCompeInvMainDto[] prpLinterCompeInvMainDto;
	/** �������̹켣����Ϣ */
	private PrplinterAutoClaimDetailDto prplinterAutoClaimDetailDto;
	/** ��������˱���Ϣ */
	private PrpLinterInjuryPersonDto prpLinterInjuryPersonDto;
	/**�����������Ϣ��*/
	private PrpLinterInjuryPersonDto[] prpLinterInjuryPersonArrayDto;
	private PrpLinterRecaseDetailDto prpLinterRecaseDetailDto;
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLinterRequestDto����
     */
    public PrpLinterRequestDto(){
    }
    
	/**
	 * ���������¹�����Ϣ
	 * 
	 * @param prpLinterAccdentPersonDto
	 *            �����õ������¹�����Ϣ��ֵ
	 */
	public void setPrpLinterAccdentPersonDto(PrpLinterAccdentPersonDto[] prpLinterAccdentPersonDto) {
		this.prpLinterAccdentPersonDto = prpLinterAccdentPersonDto;
	}

	/**
	 * ��ȡ�����¹�����Ϣ
	 * 
	 * @return �����¹�����Ϣ��ֵ
	 */
	public PrpLinterAccdentPersonDto[] getPrpLinterAccdentPersonDto() {
		return prpLinterAccdentPersonDto;
	}

	/**
	 * �������Ե��Ȳ���˵����Ϣ
	 * 
	 * @param prpLinterSchedExtDto
	 *            �����õ����Ե��Ȳ���˵����Ϣ��ֵ
	 */
	public void setPrpLinterSchedExtDto(PrpLinterSchedExtDto[] prpLinterSchedExtDto) {
		this.prpLinterSchedExtDto = prpLinterSchedExtDto;
	}

	/**
	 * ��ȡ���Ե��Ȳ���˵����Ϣ
	 * 
	 * @return ���Ե��Ȳ���˵����Ϣ��ֵ
	 */
	public PrpLinterSchedExtDto[] getPrpLinterSchedExtDto() {
		return prpLinterSchedExtDto;
	}

	/**
	 * ������������������������Ϣ
	 * 
	 * @param prpLinterClaimAppDto
	 *            �����õ���������������������Ϣ��ֵ
	 */
	public void setPrpLinterClaimAppDto(PrpLinterClaimAppDto[] prpLinterClaimAppDto) {
		this.prpLinterClaimAppDto = prpLinterClaimAppDto;
	}

	/**
	 * ��ȡ��������������������Ϣ
	 * 
	 * @return ��������������������Ϣ��ֵ
	 */
	public PrpLinterClaimAppDto[] getPrpLinterClaimAppDto() {
		return prpLinterClaimAppDto;
	}

	/**
	 * �������������ձ��������
	 * 
	 * @param prpLinterClaimKindDto
	 *            �����õ����������ձ�������ŵ�ֵ
	 */
	public void setPrpLinterClaimKindDto(PrpLinterClaimKindDto[] prpLinterClaimKindDto) {
		this.prpLinterClaimKindDto = prpLinterClaimKindDto;
	}

	/**
	 * ��ȡ���������ձ��������
	 * 
	 * @return ���������ձ�������ŵ�ֵ
	 */
	public PrpLinterClaimKindDto[] getPrpLinterClaimKindDto() {
		return prpLinterClaimKindDto;
	}

	/**
	 * �������Է�����Ϣ
	 * 
	 * @param prpLinterPrepayFeeDto
	 *            �����õ����Է�����Ϣ��ֵ
	 */
	public void setPrpLinterPrepayFeeDto(PrpLinterPrepayFeeDto[] prpLinterPrepayFeeDto) {
		this.prpLinterPrepayFeeDto = prpLinterPrepayFeeDto;
	}

	/**
	 * ��ȡ���Է�����Ϣ
	 * 
	 * @return ���Է�����Ϣ��ֵ
	 */
	public PrpLinterPrepayFeeDto[] getPrpLinterPrepayFeeDto() {
		return prpLinterPrepayFeeDto;
	}

	/**
	 * �������Ե�֤��Ϣ
	 * 
	 * @param prpLinterCertifyDto
	 *            �����õ����Ե�֤��Ϣ��ֵ
	 */
	public void setPrpLinterCertifyDto(PrpLinterCertifyDto[] prpLinterCertifyDto) {
		this.prpLinterCertifyDto = prpLinterCertifyDto;
	}

	/**
	 * ��ȡ���Ե�֤��Ϣ
	 * 
	 * @return ���Ե�֤��Ϣ��ֵ
	 */
	public PrpLinterCertifyDto[] getPrpLinterCertifyDto() {
		return prpLinterCertifyDto;
	}

	/**
	 * �������Լ����������Ϣ
	 * 
	 * @param prpLinterCompeFeeDto
	 *            �����õ����Լ����������Ϣ��ֵ
	 */
	public void setPrpLinterCompeFeeDto(PrpLinterCompeFeeDto[] prpLinterCompeFeeDto) {
		this.prpLinterCompeFeeDto = prpLinterCompeFeeDto;
	}

	/**
	 * ��ȡ���Լ����������Ϣ
	 * 
	 * @return ���Լ����������Ϣ��ֵ
	 */
	public PrpLinterCompeFeeDto[] getPrpLinterCompeFeeDto() {
		return prpLinterCompeFeeDto;
	}

	/**
	 * �������Լ�������������Ϣ
	 * 
	 * @param prpLinterCompePayFeeDto
	 *            �����õ����Լ�������������Ϣ��ֵ
	 */
	public void setPrpLinterCompePayFeeDto(PrpLinterCompePayFeeDto[] prpLinterCompePayFeeDto) {
		this.prpLinterCompePayFeeDto = prpLinterCompePayFeeDto;
	}

	/**
	 * ��ȡ���Լ�������������Ϣ
	 * 
	 * @return ���Լ�������������Ϣ��ֵ
	 */
	public PrpLinterCompePayFeeDto[] getPrpLinterCompePayFeeDto() {
		return prpLinterCompePayFeeDto;
	}

	/**
	 * �������Լ�������������Ϣ
	 * 
	 * @param prpLinterCompeInvMainDto
	 *            �����õ����Լ�������������Ϣ��ֵ
	 */
	public void setPrpLinterCompeInvMainDto(PrpLinterCompeInvMainDto[] prpLinterCompeInvMainDto) {
		this.prpLinterCompeInvMainDto = prpLinterCompeInvMainDto;
	}

	/**
	 * ��ȡ���Լ�������������Ϣ
	 * 
	 * @return ���Լ�������������Ϣ��ֵ
	 */
	public PrpLinterCompeInvMainDto[] getPrpLinterCompeInvMainDto() {
		return prpLinterCompeInvMainDto;
	}
	
	/**
	 * �����������̹켣
	 * 
	 * @param prplinterAutoClaimDetailDto
	 *            �����õ��������̹켣��ֵ
	 */
	public void setPrplinterAutoClaimDetailDto(PrplinterAutoClaimDetailDto prplinterAutoClaimDetailDto) {
		this.prplinterAutoClaimDetailDto = prplinterAutoClaimDetailDto;
	}

	/**
	 * ��ȡ�������̹켣��Ϣ
	 * 
	 * @return �������̹켣��ֵ
	 */
	public PrplinterAutoClaimDetailDto getPrplinterAutoClaimDetailDto() {
		return prplinterAutoClaimDetailDto;
	}

	public String getRelationRegistNo() {
		return relationRegistNo;
	}

	public void setRelationRegistNo(String relationRegistNo) {
		this.relationRegistNo = relationRegistNo;
	}

	public boolean isRecaseFlag() {
		return recaseFlag;
	}

	public void setRecaseFlag(boolean recaseFlag) {
		this.recaseFlag = recaseFlag;
	}

	public PrpLinterRecaseDetailDto getPrpLinterRecaseDetailDto() {
		return prpLinterRecaseDetailDto;
	}

	public void setPrpLinterRecaseDetailDto(
			PrpLinterRecaseDetailDto prpLinterRecaseDetailDto) {
		this.prpLinterRecaseDetailDto = prpLinterRecaseDetailDto;
	}

	public boolean isCancelFlag() {
		return cancelFlag;
	}

	public void setCancelFlag(boolean cancelFlag) {
		this.cancelFlag = cancelFlag;
	}


	public PrpLinterInjuryPersonDto getPrpLinterInjuryPersonDto() {
		return prpLinterInjuryPersonDto;
	}

	public void setPrpLinterInjuryPersonDto(
			PrpLinterInjuryPersonDto prpLinterInjuryPersonDto) {
		this.prpLinterInjuryPersonDto = prpLinterInjuryPersonDto;
	}

	public PrpLinterInjuryPersonDto[] getPrpLinterInjuryPersonArrayDto() {
		return prpLinterInjuryPersonArrayDto;
	}

	public void setPrpLinterInjuryPersonArrayDto(
			PrpLinterInjuryPersonDto[] prpLinterInjuryPersonArrayDto) {
		this.prpLinterInjuryPersonArrayDto = prpLinterInjuryPersonArrayDto;
	}
	
}
