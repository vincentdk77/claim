package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.TemblorpolicylistDto;

/**
 * 这是TEMBLORPOLICYLIST的数据访问对象类<br>
 * 创建于 2016-06-21 14:52:56.418<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBTemblorpolicylist extends DBTemblorpolicylistBase{
    private static Logger logger = Logger.getLogger(DBTemblorpolicylist.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBTemblorpolicylist(DBManager dbManager){
        super(dbManager);
    }
}
