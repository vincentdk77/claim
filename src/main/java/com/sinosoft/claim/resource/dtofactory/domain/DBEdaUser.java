package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是EdaUser-座席员信息表的数据访问对象类<br>
 * 创建于 2005-06-22 14:56:42.040<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBEdaUser extends DBEdaUserBase{
    private static Log logger = LogFactory.getLog(DBEdaUser.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBEdaUser(DBManager dbManager){
        super(dbManager);
    }
}
