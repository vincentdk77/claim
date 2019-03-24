package com.gyic.claim.bl.facade;

import java.util.*;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.bl.action.domain.BLPrplcompensateearAction;
import com.gyic.claim.dto.domain.PrplcompensateearDto;

/**
 * ����PRPLCOMPENSATEEAR��ҵ�����Facade��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrplcompensateearFacade extends BLPrplcompensateearFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrplcompensateearFacade.class);

    /**
     * ���캯��
     */
    public BLPrplcompensateearFacade(){
        super();
    }
    
    
   
	public ArrayList getPrpLCompensateEarDtos(String registno,String nodeType,String businessno) throws Exception {
		ArrayList prplCompensateEarDtoList = new ArrayList();//�����嵥�б�
		String condition = "registno = '"+ registno.trim() + "' and nodetype = '" + nodeType  + "' and businessno = '" + businessno + "'";
		prplCompensateEarDtoList = (ArrayList)findByConditions(condition);
		return prplCompensateEarDtoList;
	}
}
