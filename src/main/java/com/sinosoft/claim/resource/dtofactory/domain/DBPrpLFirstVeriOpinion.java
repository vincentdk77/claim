package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLFirstVeriOpinionDto;

/**
 * 这是初核意见表的数据访问对象类<br>
 * 创建于 2013-07-25 15:18:54.687<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLFirstVeriOpinion extends DBPrpLFirstVeriOpinionBase{
    private static Logger logger = Logger.getLogger(DBPrpLFirstVeriOpinion.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLFirstVeriOpinion(DBManager dbManager){
        super(dbManager);
    }
}
