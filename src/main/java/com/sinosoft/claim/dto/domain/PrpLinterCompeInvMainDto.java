package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

/**
 * ���Ǵ�ҽ�ƽӿڲ����м���ӱ�������嵥��Ϣ������ݴ��������<br>
 */
public class PrpLinterCompeInvMainDto extends PrpLinterCompeInvMainDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    
    /** ���Լ����������嵥��Ϣ */
	private PrpLinterCompeInvDetailDto[] prpLinterCompeInvDetailDto;
    
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLinterCompeInvMainDto����
     */
    public PrpLinterCompeInvMainDto(){
    }
    

	/**
	 * �������Լ�������������Ϣ
	 * 
	 * @param compePayFeeInfoDto
	 *            �����õ����Լ�������������Ϣ��ֵ
	 */
	public void setPrpLinterCompeInvDetailDto(PrpLinterCompeInvDetailDto[] prpLinterCompeInvDetailDto) {
		this.prpLinterCompeInvDetailDto = prpLinterCompeInvDetailDto;
	}

	/**
	 * ��ȡ���Լ�������������Ϣ
	 * 
	 * @return ���Լ�������������Ϣ��ֵ
	 */
	public PrpLinterCompeInvDetailDto[] getPrpLinterCompeInvDetailDto() {
		return prpLinterCompeInvDetailDto;
	}
}
