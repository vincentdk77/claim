package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.*;

/**
 * 这是PRPLPENDTRACKRS的数据传输对象类<br>
 */
public class PrplpendtrackrsDto extends PrplpendtrackrsDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    
    /** 属性KINDCODE 涉及险别名称*/
    private String kindName = "";
    
    public String getKindName() {
		return kindName;
	}

	public void setKindName(String kindName) {
		this.kindName = kindName;
	}

	/**
     *  默认构造方法,构造一个默认的PrplpendtrackrsDto对象
     */
    public PrplpendtrackrsDto(){
    }
}
