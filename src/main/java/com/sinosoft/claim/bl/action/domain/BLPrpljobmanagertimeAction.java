package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpljobmanagertimeDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpljobmanagertime;

/**
 * 这是PRPLJOBMANAGERTIME的业务对象扩展类<br>
 * 创建于 JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpljobmanagertimeAction extends BLPrpljobmanagertimeActionBase{
    private static Logger logger = Logger.getLogger(BLPrpljobmanagertimeAction.class);

    /**
     * 构造函数
     */
    public BLPrpljobmanagertimeAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpljobmanagertimeDto prpljobmanagertimeDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpljobmanagertimeDto prpljobmanagertimeDto,String mode)
            throws Exception{
    }
}
