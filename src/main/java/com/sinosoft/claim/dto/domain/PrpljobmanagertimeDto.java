package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.*;

/**
 * 这是PRPLJOBMANAGERTIME的数据传输对象类<br>
 */
public class PrpljobmanagertimeDto extends PrpljobmanagertimeDtoBase implements Serializable{
	
	/** 修改时 判断是否被选中时间 */
    private String states = "";
    private TurnPageDto turnPageDto = null;
    
    

    private static final long serialVersionUID = 1L;
    /**
     *  默认构造方法,构造一个默认的PrpljobmanagertimeDto对象
     */
    public PrpljobmanagertimeDto(){
    }
	public String getStates() {
		return states;
	}
	public void setStates(String states) {
		this.states = states;
	}
	public TurnPageDto getTurnPageDto() {
		return turnPageDto;
	}
	public void setTurnPageDto(TurnPageDto turnPageDto) {
		this.turnPageDto = turnPageDto;
	}
	
}
