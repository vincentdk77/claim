package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.claim.bl.action.domain.PrpLinterInjuryPersonDto;

/**
 * 这是理赔接口交互中间表的数据传输对象类<br>
 */
public class PrpLinterRequestDto extends PrpLinterRequestDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    
    /**关联投报案号码**/
    private String relationRegistNo = "";
    
    /**重开赔案标识，默认false正常案件*/
    private boolean recaseFlag  = false;
    
    /**报案注销标识，默认false不走报案注销*/
    private boolean cancelFlag  = false;
    
    /** 属性事故者信息 */
	private PrpLinterAccdentPersonDto[] prpLinterAccdentPersonDto;
	/** 属性调度补充说明信息 */
	private PrpLinterSchedExtDto[] prpLinterSchedExtDto;
	/** 属性立案索赔申请人信息 */
	private PrpLinterClaimAppDto[] prpLinterClaimAppDto;
	/** 属性立案险别估损金额信息 */
	private PrpLinterClaimKindDto[] prpLinterClaimKindDto;
	/** 属性费用信息 */
	private PrpLinterPrepayFeeDto[] prpLinterPrepayFeeDto;
	/** 属性单证信息 */
	private PrpLinterCertifyDto[] prpLinterCertifyDto;
	/** 属性计算书费用信息 */
	private PrpLinterCompeFeeDto[] prpLinterCompeFeeDto;
	/** 属性计算书赔款费用信息 */
	private PrpLinterCompePayFeeDto[] prpLinterCompePayFeeDto;
	/** 属性计算书理算清单信息 */
	private PrpLinterCompeInvMainDto[] prpLinterCompeInvMainDto;
	/** 属性流程轨迹表信息 */
	private PrplinterAutoClaimDetailDto prplinterAutoClaimDetailDto;
	/** 具体出险人表信息 */
	private PrpLinterInjuryPersonDto prpLinterInjuryPersonDto;
	/**具体出险人信息组*/
	private PrpLinterInjuryPersonDto[] prpLinterInjuryPersonArrayDto;
	private PrpLinterRecaseDetailDto prpLinterRecaseDetailDto;
    /**
     *  默认构造方法,构造一个默认的PrpLinterRequestDto对象
     */
    public PrpLinterRequestDto(){
    }
    
	/**
	 * 设置属性事故者信息
	 * 
	 * @param prpLinterAccdentPersonDto
	 *            待设置的属性事故者信息的值
	 */
	public void setPrpLinterAccdentPersonDto(PrpLinterAccdentPersonDto[] prpLinterAccdentPersonDto) {
		this.prpLinterAccdentPersonDto = prpLinterAccdentPersonDto;
	}

	/**
	 * 获取属性事故者信息
	 * 
	 * @return 属性事故者信息的值
	 */
	public PrpLinterAccdentPersonDto[] getPrpLinterAccdentPersonDto() {
		return prpLinterAccdentPersonDto;
	}

	/**
	 * 设置属性调度补充说明信息
	 * 
	 * @param prpLinterSchedExtDto
	 *            待设置的属性调度补充说明信息的值
	 */
	public void setPrpLinterSchedExtDto(PrpLinterSchedExtDto[] prpLinterSchedExtDto) {
		this.prpLinterSchedExtDto = prpLinterSchedExtDto;
	}

	/**
	 * 获取属性调度补充说明信息
	 * 
	 * @return 属性调度补充说明信息的值
	 */
	public PrpLinterSchedExtDto[] getPrpLinterSchedExtDto() {
		return prpLinterSchedExtDto;
	}

	/**
	 * 设置属性立案索赔申请人信息
	 * 
	 * @param prpLinterClaimAppDto
	 *            待设置的属性立案索赔申请人信息的值
	 */
	public void setPrpLinterClaimAppDto(PrpLinterClaimAppDto[] prpLinterClaimAppDto) {
		this.prpLinterClaimAppDto = prpLinterClaimAppDto;
	}

	/**
	 * 获取属性立案索赔申请人信息
	 * 
	 * @return 属性立案索赔申请人信息的值
	 */
	public PrpLinterClaimAppDto[] getPrpLinterClaimAppDto() {
		return prpLinterClaimAppDto;
	}

	/**
	 * 设置属性立案险别估损金额信
	 * 
	 * @param prpLinterClaimKindDto
	 *            待设置的属性立案险别估损金额信的值
	 */
	public void setPrpLinterClaimKindDto(PrpLinterClaimKindDto[] prpLinterClaimKindDto) {
		this.prpLinterClaimKindDto = prpLinterClaimKindDto;
	}

	/**
	 * 获取属性立案险别估损金额信
	 * 
	 * @return 属性立案险别估损金额信的值
	 */
	public PrpLinterClaimKindDto[] getPrpLinterClaimKindDto() {
		return prpLinterClaimKindDto;
	}

	/**
	 * 设置属性费用信息
	 * 
	 * @param prpLinterPrepayFeeDto
	 *            待设置的属性费用信息的值
	 */
	public void setPrpLinterPrepayFeeDto(PrpLinterPrepayFeeDto[] prpLinterPrepayFeeDto) {
		this.prpLinterPrepayFeeDto = prpLinterPrepayFeeDto;
	}

	/**
	 * 获取属性费用信息
	 * 
	 * @return 属性费用信息的值
	 */
	public PrpLinterPrepayFeeDto[] getPrpLinterPrepayFeeDto() {
		return prpLinterPrepayFeeDto;
	}

	/**
	 * 设置属性单证信息
	 * 
	 * @param prpLinterCertifyDto
	 *            待设置的属性单证信息的值
	 */
	public void setPrpLinterCertifyDto(PrpLinterCertifyDto[] prpLinterCertifyDto) {
		this.prpLinterCertifyDto = prpLinterCertifyDto;
	}

	/**
	 * 获取属性单证信息
	 * 
	 * @return 属性单证信息的值
	 */
	public PrpLinterCertifyDto[] getPrpLinterCertifyDto() {
		return prpLinterCertifyDto;
	}

	/**
	 * 设置属性计算书费用信息
	 * 
	 * @param prpLinterCompeFeeDto
	 *            待设置的属性计算书费用信息的值
	 */
	public void setPrpLinterCompeFeeDto(PrpLinterCompeFeeDto[] prpLinterCompeFeeDto) {
		this.prpLinterCompeFeeDto = prpLinterCompeFeeDto;
	}

	/**
	 * 获取属性计算书费用信息
	 * 
	 * @return 属性计算书费用信息的值
	 */
	public PrpLinterCompeFeeDto[] getPrpLinterCompeFeeDto() {
		return prpLinterCompeFeeDto;
	}

	/**
	 * 设置属性计算书赔款费用信息
	 * 
	 * @param prpLinterCompePayFeeDto
	 *            待设置的属性计算书赔款费用信息的值
	 */
	public void setPrpLinterCompePayFeeDto(PrpLinterCompePayFeeDto[] prpLinterCompePayFeeDto) {
		this.prpLinterCompePayFeeDto = prpLinterCompePayFeeDto;
	}

	/**
	 * 获取属性计算书赔款费用信息
	 * 
	 * @return 属性计算书赔款费用信息的值
	 */
	public PrpLinterCompePayFeeDto[] getPrpLinterCompePayFeeDto() {
		return prpLinterCompePayFeeDto;
	}

	/**
	 * 设置属性计算书赔款费用信息
	 * 
	 * @param prpLinterCompeInvMainDto
	 *            待设置的属性计算书赔款费用信息的值
	 */
	public void setPrpLinterCompeInvMainDto(PrpLinterCompeInvMainDto[] prpLinterCompeInvMainDto) {
		this.prpLinterCompeInvMainDto = prpLinterCompeInvMainDto;
	}

	/**
	 * 获取属性计算书赔款费用信息
	 * 
	 * @return 属性计算书赔款费用信息的值
	 */
	public PrpLinterCompeInvMainDto[] getPrpLinterCompeInvMainDto() {
		return prpLinterCompeInvMainDto;
	}
	
	/**
	 * 设置属性流程轨迹
	 * 
	 * @param prplinterAutoClaimDetailDto
	 *            待设置的属性流程轨迹的值
	 */
	public void setPrplinterAutoClaimDetailDto(PrplinterAutoClaimDetailDto prplinterAutoClaimDetailDto) {
		this.prplinterAutoClaimDetailDto = prplinterAutoClaimDetailDto;
	}

	/**
	 * 获取属性流程轨迹信息
	 * 
	 * @return 属性流程轨迹的值
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
