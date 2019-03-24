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
 * 这是PRPLCOMPENSATEEAR的业务对象Facade类<br>
 * 创建于 JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrplcompensateearFacade extends BLPrplcompensateearFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrplcompensateearFacade.class);

    /**
     * 构造函数
     */
    public BLPrplcompensateearFacade(){
        super();
    }
    
    
   
	public ArrayList getPrpLCompensateEarDtos(String registno,String nodeType,String businessno) throws Exception {
		ArrayList prplCompensateEarDtoList = new ArrayList();//耳标清单列表
		String condition = "registno = '"+ registno.trim() + "' and nodetype = '" + nodeType  + "' and businessno = '" + businessno + "'";
		prplCompensateEarDtoList = (ArrayList)findByConditions(condition);
		return prplCompensateEarDtoList;
	}
}
