package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterPayDeleteRequestDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterPayDeleteRequest;

/**
 * 这是PRPLINTERPAYDELETEQUEST的业务对象扩展类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLinterPayDeleteRequestAction extends BLPrpLinterPayDeleteRequestActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterPayDeleteRequestAction.class);

    /**
     * 构造函数
     */
    public BLPrpLinterPayDeleteRequestAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param pRPLINTERPAYDELETEQUESTDto pRPLINTERPAYDELETEQUESTDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLinterPayDeleteRequestDto pRPLINTERPAYDELETEQUESTDto,String mode)
            throws Exception{
    }
}
