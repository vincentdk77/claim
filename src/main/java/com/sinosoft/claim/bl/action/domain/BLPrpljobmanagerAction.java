package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpljobmanagerDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpljobmanager;

/**
 * 这是PRPLJOBMANAGER的业务对象扩展类<br>
 * 创建于 JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpljobmanagerAction extends BLPrpljobmanagerActionBase{
    private static Logger logger = Logger.getLogger(BLPrpljobmanagerAction.class);

    /**
     * 构造函数
     */
    public BLPrpljobmanagerAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpljobmanagerDto prpljobmanagerDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpljobmanagerDto prpljobmanagerDto,String mode)
            throws Exception{
    }
}
