package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.*;

/**
 * ����PRPLPENDTRACKRS�����ݴ��������<br>
 */
public class PrplpendtrackrsDto extends PrplpendtrackrsDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    
    /** ����KINDCODE �漰�ձ�����*/
    private String kindName = "";
    
    public String getKindName() {
		return kindName;
	}

	public void setKindName(String kindName) {
		this.kindName = kindName;
	}

	/**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrplpendtrackrsDto����
     */
    public PrplpendtrackrsDto(){
    }
}
