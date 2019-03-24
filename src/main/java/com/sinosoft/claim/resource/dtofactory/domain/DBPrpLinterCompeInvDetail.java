package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterCompeInvDetailDto;

/**
 * 这是大病医疗接口参数中间表子表计算书清单信息明细表的数据访问对象类<br>
 * 创建于 2014-04-03 09:14:38.228<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLinterCompeInvDetail extends DBPrpLinterCompeInvDetailBase{
    private static Logger logger = Logger.getLogger(DBPrpLinterCompeInvDetail.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLinterCompeInvDetail(DBManager dbManager){
        super(dbManager);
    }
}
