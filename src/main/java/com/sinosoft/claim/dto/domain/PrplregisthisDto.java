package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.ArrayList;

import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.*;

/**
 * 这是PRPLREGISTHIS的数据传输对象类<br>
 */
public class PrplregisthisDto extends PrplregisthisDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    private ArrayList<PrplregisthisDto> prplregistHisDtoList = new ArrayList<PrplregisthisDto>();
    private String comCodeName="";
    
    public ArrayList<PrplregisthisDto> getPrplregistHisDtoList() {
		return prplregistHisDtoList;
	}

	public void setPrplregistHisDtoList(
			ArrayList<PrplregisthisDto> prplregistHisDtoList) {
		this.prplregistHisDtoList = prplregistHisDtoList;
	}
	
	public String getComCodeName() {
		return comCodeName;
	}

	public void setComCodeName(String comCodeName) {
		this.comCodeName = comCodeName;
	}

	/**
     *  默认构造方法,构造一个默认的PrplregisthisDto对象
     */
    public PrplregisthisDto(){
    }
}
