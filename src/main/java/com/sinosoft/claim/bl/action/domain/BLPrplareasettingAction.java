package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplareasettingDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplareasetting;

/**
 * 这是PRPLAREASETTING的业务对象扩展类<br>
 * 创建于 JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrplareasettingAction extends BLPrplareasettingActionBase{
    private static Logger logger = Logger.getLogger(BLPrplareasettingAction.class);

    /**
     * 构造函数
     */
    public BLPrplareasettingAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prplareasettingDto prplareasettingDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrplareasettingDto prplareasettingDto,String mode)
            throws Exception{
    }
}
