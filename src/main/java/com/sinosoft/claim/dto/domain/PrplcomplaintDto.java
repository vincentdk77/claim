package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PRPLCOMPLAINT�����ݴ��������<br>
 */
public class PrplcomplaintDto extends PrplcomplaintDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private TurnPageDto turnPageDto = null;
    /** ����BYCOMPLAINTCOMCODE ��Ͷ�߻�������*/
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
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrplcomplaintDto����
     */
    public PrplcomplaintDto(){
    }
}
