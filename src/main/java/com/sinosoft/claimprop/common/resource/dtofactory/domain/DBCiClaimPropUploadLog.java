package com.sinosoft.claimprop.common.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claimprop.common.dto.domain.CiClaimPropUploadLogDto;

/**
 * 这是CiClaimPropUploadLog的数据访问对象类<br>
 * 创建于 2017-01-24 15:00:05.687<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBCiClaimPropUploadLog extends DBCiClaimPropUploadLogBase{
    private static Logger logger = Logger.getLogger(DBCiClaimPropUploadLog.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBCiClaimPropUploadLog(DBManager dbManager){
        super(dbManager);
    }
}
