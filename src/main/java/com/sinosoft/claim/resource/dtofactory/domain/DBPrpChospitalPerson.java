package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpChospitalPerson的数据访问对象类<br>
 * 创建于 2007-05-19 11:21:24.890<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpChospitalPerson extends DBPrpChospitalPersonBase{
    private static Log logger = LogFactory.getLog(DBPrpChospitalPerson.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpChospitalPerson(DBManager dbManager){
        super(dbManager);
    }
}
