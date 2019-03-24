package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.*;

/**
 * 这是PRPLAREASETTING的数据传输对象类<br>
 */
public class PrplareasettingDto extends PrplareasettingDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private String handledeptName = "";
    
    private TurnPageDto turnPageDto = null;
    
    private String areaName = "";
    
    public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public TurnPageDto getTurnPageDto() {
		return turnPageDto;
	}
	public void setTurnPageDto(TurnPageDto turnPageDto) {
		this.turnPageDto = turnPageDto;
	}
	public String getHandledeptName() {
		return handledeptName;
	}
	public void setHandledeptName(String handledeptName) {
		this.handledeptName = handledeptName;
	}
	/**
     *  默认构造方法,构造一个默认的PrplareasettingDto对象
     */
    public PrplareasettingDto(){
    }
}
