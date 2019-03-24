package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplcompensatehousetgDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplcompensatehouse;

/**
 * 这是PRPLCOMPENSATEHOUSE的业务对象扩展类<br>
 * 创建于 JToolpad(3.0.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrplcompensatehousetgAction extends BLPrplcompensatehousetgActionBase{
    private static Logger logger = Logger.getLogger(BLPrplcompensatehousetgAction.class);

    /**
     * 构造函数
     */
    public BLPrplcompensatehousetgAction(){
        super();
    }

    /**
     * 转换tgDto
     * @param dbManager dbManager
     * @param prplcompensatehousetgDto prplcompensatehousetgDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrplcompensatehousetgDto prplcompensatehousetgDto,String mode)
            throws Exception{
    }
}
