package com.sinosoft.claim.bl.action;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplregisthisDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplregisthis;

/**
 * 这是PRPLREGISTHIS的业务对象扩展类<br>
 * 创建于 JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrplregisthisAction extends BLPrplregisthisActionBase{
    private static Logger logger = Logger.getLogger(BLPrplregisthisAction.class);

    /**
     * 构造函数
     */
    public BLPrplregisthisAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prplregisthisDto prplregisthisDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrplregisthisDto prplregisthisDto,String mode)
            throws Exception{
    }
}
