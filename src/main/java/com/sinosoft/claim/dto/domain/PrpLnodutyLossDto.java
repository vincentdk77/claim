package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.*;

/**
 * 这是prpLnodutyLoss的数据传输对象类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLnodutyLossDto extends PrpLnodutyLossDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    
    /** 属性显示列表*/
    private Collection prpLnodutyLossList;
    /**
     *  默认构造方法,构造一个默认的PrpLnodutyLossDto对象
     */
    public PrpLnodutyLossDto(){
    }
    
    public void setPrpLnodutyLossList(Collection prpLnodutyLossList){
    	this.prpLnodutyLossList = prpLnodutyLossList;
    }
    public Collection getPrpLnodutyLossList()
    {
    	return prpLnodutyLossList;
    }
}
