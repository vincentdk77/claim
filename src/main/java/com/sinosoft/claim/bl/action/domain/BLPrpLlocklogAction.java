package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;

import com.sinosoft.claim.dto.domain.PrpLlocklogDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLlocklog;

/**
 * 这是PRPLLOCKLOG的业务对象扩展类<br>
 * 创建于 JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLlocklogAction extends BLPrpLlocklogActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLlocklogAction.class);

    /**
     * 构造函数
     */
    public BLPrpLlocklogAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param PrpLlocklogDto prpLlocklogDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLlocklogDto prpLlocklogDto,String mode)
            throws Exception{
    }
}
