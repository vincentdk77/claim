package com.sinosoft.claimciplatform.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是理赔信息平台上传注册表的数据访问对象类<br>
 * 创建于 2006-06-21 20:29:13.609<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBCIClaimUploadRegist extends DBCIClaimUploadRegistBase{
    private static Log logger = LogFactory.getLog(DBCIClaimUploadRegist.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBCIClaimUploadRegist(DBManager dbManager){
        super(dbManager);
    }
}
