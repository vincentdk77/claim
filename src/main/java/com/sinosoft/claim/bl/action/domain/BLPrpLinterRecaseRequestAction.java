package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterRecaseRequestDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterRecaseRequest;

/**
 * 这是大病医疗接口重开赔案参数中间表的业务对象扩展类<br>
 * 创建于 JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLinterRecaseRequestAction extends BLPrpLinterRecaseRequestActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterRecaseRequestAction.class);

    /**
     * 构造函数
     */
    public BLPrpLinterRecaseRequestAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLinterRecaseRequestDto prpLinterRecaseRequestDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLinterRecaseRequestDto prpLinterRecaseRequestDto,String mode)
            throws Exception{
    }
}
