package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLpayNoticeListDto;

/**
 * 这是通知单关联表的数据访问对象类<br>
 * 创建于 2013-06-28 13:28:27.413<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLpayNoticeListtg extends DBPrpLpayNoticeListtgBase{
    private static Logger logger = Logger.getLogger(DBPrpLpayNoticeListtg.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLpayNoticeListtg(DBManager dbManager){
        super(dbManager);
    }
}
