package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.*;

/**
 * ����prpLnodutyLoss�����ݴ��������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLnodutyLossDto extends PrpLnodutyLossDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    
    /** ������ʾ�б�*/
    private Collection prpLnodutyLossList;
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLnodutyLossDto����
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
