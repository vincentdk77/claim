package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.NyxuploadinsurancelistDto;

/**
 * 这是NYXUPLOADINSURANCELIST的数据访问对象类<br>
 * 创建于 2015-09-09 11:06:42.095<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBNyxuploadinsurancelist extends DBNyxuploadinsurancelistBase{
    private static Logger logger = Logger.getLogger(DBNyxuploadinsurancelist.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBNyxuploadinsurancelist(DBManager dbManager){
        super(dbManager);
    }
}
