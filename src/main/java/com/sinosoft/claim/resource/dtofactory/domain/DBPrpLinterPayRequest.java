package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterPayRequestDto;

/**
 * 这是传入参数主表的数据访问对象类<br>
 * 创建于 2014-04-23 09:27:00.063<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLinterPayRequest extends DBPrpLinterPayRequestBase{
    private static Logger logger = Logger.getLogger(DBPrpLinterPayRequest.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLinterPayRequest(DBManager dbManager){
        super(dbManager);
    }
}
