package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.ArrayList;

import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.*;

/**
 * ����PRPLJOBMANAGER�����ݴ��������<br>
 */
public class PrpljobmanagerDto extends PrpljobmanagerDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
        
    private ArrayList<PrpljobmanagertimeDto> prpljobmanagertimeDtoListAm = null;
    private ArrayList<PrpljobmanagertimeDto> prpljobmanagertimeDtoListPm = null;
    
    private TurnPageDto turnPageDto = null;
    
    /** ������� */
    private String datetype = "";
    
    /** ��ҵ���� */
    private String areaName = "";
    
    /** ��ϵ�绰 */
    private String tel = "";
    
    /** �鿱�� */
    private String checkCount = "";
    
    /** ״̬ �ж�ҳ����ʾ ����ɫ �Ƿ������޸� yes���� no ������*/
    private String state = "";	
    
    private String time = "";

	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public String getCheckCount() {
		return checkCount;
	}



	public void setCheckCount(String checkCount) {
		this.checkCount = checkCount;
	}



	public String getTel() {
		return tel;
	}



	public void setTel(String tel) {
		this.tel = tel;
	}



	public String getAreaName() {
		return areaName;
	}



	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}



	public String getDatetype() {
		return datetype;
	}



	public void setDatetype(String datetype) {
		this.datetype = datetype;
	}



	public TurnPageDto getTurnPageDto() {
		return turnPageDto;
	}



	public void setTurnPageDto(TurnPageDto turnPageDto) {
		this.turnPageDto = turnPageDto;
	}



	public ArrayList<PrpljobmanagertimeDto> getPrpljobmanagertimeDtoListAm() {
		return prpljobmanagertimeDtoListAm;
	}



	public ArrayList<PrpljobmanagertimeDto> getPrpljobmanagertimeDtoListPm() {
		return prpljobmanagertimeDtoListPm;
	}



	public void setPrpljobmanagertimeDtoListAm(
			ArrayList<PrpljobmanagertimeDto> prpljobmanagertimeDtoListAm) {
		this.prpljobmanagertimeDtoListAm = prpljobmanagertimeDtoListAm;
	}



	public void setPrpljobmanagertimeDtoListPm(
			ArrayList<PrpljobmanagertimeDto> prpljobmanagertimeDtoListPm) {
		this.prpljobmanagertimeDtoListPm = prpljobmanagertimeDtoListPm;
	}



	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

	/**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpljobmanagerDto����
     */
    public PrpljobmanagerDto(){
    }
}
