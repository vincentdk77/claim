package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.*;

/**
 * ����PRPLJOBMANAGERTIME�����ݴ��������<br>
 */
public class PrpljobmanagertimeDto extends PrpljobmanagertimeDtoBase implements Serializable{
	
	/** �޸�ʱ �ж��Ƿ�ѡ��ʱ�� */
    private String states = "";
    private TurnPageDto turnPageDto = null;
    
    

    private static final long serialVersionUID = 1L;
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpljobmanagertimeDto����
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
