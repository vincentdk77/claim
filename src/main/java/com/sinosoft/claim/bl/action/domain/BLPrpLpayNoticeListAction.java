package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLpayNoticeListDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLpayNoticeList;

/**
 * 这是通知单关联表的业务对象扩展类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLpayNoticeListAction extends BLPrpLpayNoticeListActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLpayNoticeListAction.class);

    /**
     * 构造函数
     */
    public BLPrpLpayNoticeListAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLpayNoticeListDto prpLpayNoticeListDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLpayNoticeListDto prpLpayNoticeListDto,String mode)
            throws Exception{
    }
}
