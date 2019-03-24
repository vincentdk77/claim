package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.*;

/**
 * 这是传入参数主表的数据传输对象类<br>
 */
public class PrpLinterPayRequestDto extends PrpLinterPayRequestDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    
    /** 赔付信息(至少一条) */
	private PrpLinterPaymentInfoDto[] prpLinterPaymentInfoDto;
	/** 处理意见(零条或多条) */
	private PrpLinterPayExtDto[] prpLinterPayExtDto;
	/** 属性流程轨迹表信息 */
	private PrpLinterPayDetailDto prpLinterPayDetailDto;
    
    /**
     *  默认构造方法,构造一个默认的PrpLinterPayRequestDto对象
     */
    public PrpLinterPayRequestDto(){
    }

	public PrpLinterPaymentInfoDto[] getPrpLinterPaymentInfoDto() {
		return prpLinterPaymentInfoDto;
	}

	public void setPrpLinterPaymentInfoDto(
			PrpLinterPaymentInfoDto[] prpLinterPaymentInfoDto) {
		this.prpLinterPaymentInfoDto = prpLinterPaymentInfoDto;
	}

	public PrpLinterPayExtDto[] getPrpLinterPayExtDto() {
		return prpLinterPayExtDto;
	}

	public void setPrpLinterPayExtDto(PrpLinterPayExtDto[] prpLinterPayExtDto) {
		this.prpLinterPayExtDto = prpLinterPayExtDto;
	}

	public PrpLinterPayDetailDto getPrpLinterPayDetailDto() {
		return prpLinterPayDetailDto;
	}

	public void setPrpLinterPayDetailDto(PrpLinterPayDetailDto prpLinterPayDetailDto) {
		this.prpLinterPayDetailDto = prpLinterPayDetailDto;
	}
    
}
