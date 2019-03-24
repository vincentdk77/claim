package com.sinosoft.communication.resource.dtofactory.custom;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是DBPrplCommunicatPerson理赔沟通的沟通人员表的数据访问对象类<br>
 * 创建于 2013-02-19<br>
 */
public class DBPrplCommunicatPerson extends DBPrplCommunicatPersonBase {
	private static Log logger = LogFactory.getLog(DBPrplCommunicatPerson.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrplCommunicatPerson(DBManager dbManager){
        super(dbManager);
    }
}
