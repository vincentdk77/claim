package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplinterPayBackDetailDto;

/**
 * 这是大病医疗接口支付退回流程轨迹表的数据访问对象类<br>
 * 创建于 2014-05-15 11:28:12.162<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrplinterPayBackDetail extends DBPrplinterPayBackDetailBase{
    private static Logger logger = Logger.getLogger(DBPrplinterPayBackDetail.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrplinterPayBackDetail(DBManager dbManager){
        super(dbManager);
    }
}
