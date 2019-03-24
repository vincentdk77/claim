package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.SaBankBranchDto;

/**
 * 这是SaBankBranch的数据访问对象类<br>
 * 创建于 2014-06-08 15:30:26.562<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBSaBankBranch extends DBSaBankBranchBase{
    private static Logger logger = Logger.getLogger(DBSaBankBranch.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBSaBankBranch(DBManager dbManager){
        super(dbManager);
    }
}
