package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.*;

/**
 * ���ǳ������������ݴ��������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLFirstVeriOpinionDto extends PrpLFirstVeriOpinionDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����ԭ�� */
    private String occReasonName = "";
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLFirstVeriOpinionDto����
     */
    public PrpLFirstVeriOpinionDto(){
    }
    /** ����ԭ�� */
	public String getOccReasonName() {
		return occReasonName;
	}
    /** ����ԭ�� */
	public void setOccReasonName(String occReasonName) {
		this.occReasonName = occReasonName;
	}
    
}
