package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.Planting31SettleListTempDto;

/**
 * 这是Planting31SettleListTemp的数据访问对象类<br>
 * 创建于 2012-06-08 16:30:11.781<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPlanting31SettleListTemp extends DBPlanting31SettleListTempBase{
    private static Logger logger = Logger.getLogger(DBPlanting31SettleListTemp.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPlanting31SettleListTemp(DBManager dbManager){
        super(dbManager);
    }
}
