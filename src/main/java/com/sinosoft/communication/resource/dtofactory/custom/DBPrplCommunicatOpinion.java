package com.sinosoft.communication.resource.dtofactory.custom;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是DBPrplCommunicatOpinion理赔沟通的沟通意见表的数据访问对象类<br>
 * 创建于 2013-02-19<br>
 */
public class DBPrplCommunicatOpinion extends DBPrplCommunicatOpinionBase {
	private static Log logger = LogFactory.getLog(DBPrplCommunicatOpinion.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrplCommunicatOpinion(DBManager dbManager){
        super(dbManager);
    }
}
