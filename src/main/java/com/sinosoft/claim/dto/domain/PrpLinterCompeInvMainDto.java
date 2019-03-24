package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

/**
 * 这是大病医疗接口参数中间表子表计算书清单信息表的数据传输对象类<br>
 */
public class PrpLinterCompeInvMainDto extends PrpLinterCompeInvMainDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    
    /** 属性计算书理算清单信息 */
	private PrpLinterCompeInvDetailDto[] prpLinterCompeInvDetailDto;
    
    /**
     *  默认构造方法,构造一个默认的PrpLinterCompeInvMainDto对象
     */
    public PrpLinterCompeInvMainDto(){
    }
    

	/**
	 * 设置属性计算书赔款费用信息
	 * 
	 * @param compePayFeeInfoDto
	 *            待设置的属性计算书赔款费用信息的值
	 */
	public void setPrpLinterCompeInvDetailDto(PrpLinterCompeInvDetailDto[] prpLinterCompeInvDetailDto) {
		this.prpLinterCompeInvDetailDto = prpLinterCompeInvDetailDto;
	}

	/**
	 * 获取属性计算书赔款费用信息
	 * 
	 * @return 属性计算书赔款费用信息的值
	 */
	public PrpLinterCompeInvDetailDto[] getPrpLinterCompeInvDetailDto() {
		return prpLinterCompeInvDetailDto;
	}
}
