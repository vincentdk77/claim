package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.ArrayList;

import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.*;

/**
 * 这是PRPLJOBMANAGER的数据传输对象类<br>
 */
public class PrpljobmanagerDto extends PrpljobmanagerDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
        
    private ArrayList<PrpljobmanagertimeDto> prpljobmanagertimeDtoListAm = null;
    private ArrayList<PrpljobmanagertimeDto> prpljobmanagertimeDtoListPm = null;
    
    private TurnPageDto turnPageDto = null;
    
    /** 班次名称 */
    private String datetype = "";
    
    /** 作业区域 */
    private String areaName = "";
    
    /** 联系电话 */
    private String tel = "";
    
    /** 查勘数 */
    private String checkCount = "";
    
    /** 状态 判断页面显示 班表角色 是否允许修改 yes可以 no 不可以*/
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
     *  默认构造方法,构造一个默认的PrpljobmanagerDto对象
     */
    public PrpljobmanagerDto(){
    }
}
