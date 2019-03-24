package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.*;

/**
 * 这是初核意见表的数据传输对象类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLFirstVeriOpinionDto extends PrpLFirstVeriOpinionDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 出险原因 */
    private String occReasonName = "";
    /**
     *  默认构造方法,构造一个默认的PrpLFirstVeriOpinionDto对象
     */
    public PrpLFirstVeriOpinionDto(){
    }
    /** 出险原因 */
	public String getOccReasonName() {
		return occReasonName;
	}
    /** 出险原因 */
	public void setOccReasonName(String occReasonName) {
		this.occReasonName = occReasonName;
	}
    
}
