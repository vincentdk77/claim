package com.sinosoft.NXCaseUp.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.NXCaseUp.dto.domain.CasefarmerDto;

/**
 * 这是CASEFARMER的数据访问对象类<br>
 * 创建于 2015-09-25 12:30:11.546<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBCasefarmer extends DBCasefarmerBase{
    private static Logger logger = Logger.getLogger(DBCasefarmer.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBCasefarmer(DBManager dbManager){
        super(dbManager);
    }
}
