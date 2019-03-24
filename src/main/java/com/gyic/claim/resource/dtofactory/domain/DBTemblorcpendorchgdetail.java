package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.TemblorcpendorchgdetailDto;

/**
 * 这是TEMBLORCPENDORCHGDETAIL的数据访问对象类<br>
 * 创建于 2016-06-21 14:52:53.528<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBTemblorcpendorchgdetail extends DBTemblorcpendorchgdetailBase{
    private static Logger logger = Logger.getLogger(DBTemblorcpendorchgdetail.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBTemblorcpendorchgdetail(DBManager dbManager){
        super(dbManager);
    }
}
