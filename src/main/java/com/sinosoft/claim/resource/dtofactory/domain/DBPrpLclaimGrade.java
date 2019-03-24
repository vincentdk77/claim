package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLclaimGrade--理赔业务权限表(新增)的数据访问对象类<br>
 * 创建于 2005-04-19 09:24:20.703<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLclaimGrade extends DBPrpLclaimGradeBase{
    private static Log logger = LogFactory.getLog(DBPrpLclaimGrade.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLclaimGrade(DBManager dbManager){
        super(dbManager);
    }
}
