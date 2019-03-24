package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.TemblorsettlelistDto;

/**
 * 这是TEMBLORSETTLELIST的数据访问对象类<br>
 * 创建于 2016-06-21 14:52:57.606<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBTemblorsettlelist extends DBTemblorsettlelistBase{
    private static Logger logger = Logger.getLogger(DBTemblorsettlelist.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBTemblorsettlelist(DBManager dbManager){
        super(dbManager);
    }
}
