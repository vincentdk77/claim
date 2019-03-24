package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.ArrayList;

import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.*;

/**
 * ����PRPLREGISTHIS�����ݴ��������<br>
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
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrplregisthisDto����
     */
    public PrplregisthisDto(){
    }
}
