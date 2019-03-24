package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplcompensatehouseDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplcompensatehouse;

/**
 * 这是PRPLCOMPENSATEHOUSE的业务对象扩展类<br>
 * 创建于 JToolpad(3.0.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrplcompensatehouseAction extends BLPrplcompensatehouseActionBase{
    private static Logger logger = Logger.getLogger(BLPrplcompensatehouseAction.class);

    /**
     * 构造函数
     */
    public BLPrplcompensatehouseAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prplcompensatehouseDto prplcompensatehouseDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrplcompensatehouseDto prplcompensatehouseDto,String mode)
            throws Exception{
    }
}
