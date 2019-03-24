package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.NyxpolicylistDto;

/**
 * 这是NYXPOLICYLIST的数据访问对象类<br>
 * 创建于 2015-09-09 11:06:38.969<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBNyxpolicylist extends DBNyxpolicylistBase{
    private static Logger logger = Logger.getLogger(DBNyxpolicylist.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBNyxpolicylist(DBManager dbManager){
        super(dbManager);
    }
}
