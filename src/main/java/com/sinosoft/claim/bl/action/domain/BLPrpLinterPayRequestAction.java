package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterPayRequestDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterPayRequest;

/**
 * 这是传入参数主表的业务对象扩展类<br>
 * 创建于 JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLinterPayRequestAction extends BLPrpLinterPayRequestActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterPayRequestAction.class);

    /**
     * 构造函数
     */
    public BLPrpLinterPayRequestAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLinterPayRequestDto prpLinterPayRequestDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLinterPayRequestDto prpLinterPayRequestDto,String mode)
            throws Exception{
    }
}
