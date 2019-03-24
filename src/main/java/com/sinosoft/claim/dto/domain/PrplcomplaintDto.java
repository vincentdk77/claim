package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PRPLCOMPLAINT的数据传输对象类<br>
 */
public class PrplcomplaintDto extends PrplcomplaintDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private TurnPageDto turnPageDto = null;
    /** 属性BYCOMPLAINTCOMCODE 被投诉机构名称*/
    private String bycomplaintcomcodeName = "";
    
    
    public String getBycomplaintcomcodeName() {
		return bycomplaintcomcodeName;
	}


	public void setBycomplaintcomcodeName(String bycomplaintcomcodeName) {
		this.bycomplaintcomcodeName = bycomplaintcomcodeName;
	}


	public TurnPageDto getTurnPageDto() {
		return turnPageDto;
	}


	public void setTurnPageDto(TurnPageDto turnPageDto) {
		this.turnPageDto = turnPageDto;
	}


	/**
     *  默认构造方法,构造一个默认的PrplcomplaintDto对象
     */
    public PrplcomplaintDto(){
    }
}
