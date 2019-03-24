package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.Planting31PolicyListDto;

/**
 * 这是Planting31PolicyList的数据访问对象类<br>
 * 创建于 2012-06-11 11:04:16.437<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPlanting31PolicyList extends DBPlanting31PolicyListBase{
    private static Logger logger = Logger.getLogger(DBPlanting31PolicyList.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPlanting31PolicyList(DBManager dbManager){
        super(dbManager);
    }
}
