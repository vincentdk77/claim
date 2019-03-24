package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.SwfLogStoreDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBSwfLog;
import com.sinosoft.claim.resource.dtofactory.domain.DBSwfLogStore;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是SwfLogStore的业务对象扩展类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLSwfLogStoreAction extends BLSwfLogStoreActionBase{
    private static Log logger = LogFactory.getLog(BLSwfLogStoreAction.class);

    /**
     * 构造函数
     */
    public BLSwfLogStoreAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param swfLogStoreDto swfLogStoreDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,SwfLogStoreDto swfLogStoreDto,String mode)
            throws Exception{
    }
    
    /**
     * 查询flowID的最大logno的值
     * @param dbManager DB管理器
     * @param conditions 模糊查询条件
     * @return flowID
     * @throws Exception
     */
    public int getMaxLogNo(DBManager dbManager, String flowID) throws Exception {
        DBSwfLogStore dbSwfLogStore = new DBSwfLogStore(dbManager);
        
        int logNo = dbSwfLogStore.getMaxLogNo(flowID);
        return logNo;
    }
    
    /**
     * 查询flowID的最大logno的值
     * @param dbManager DB管理器
     * @param conditions 模糊查询条件
     * @return flowID
     * @throws Exception
     */
    public int getMaxNodeLogNo(DBManager dbManager, String flowID,String nodeType,String businessNo) throws Exception {
    	DBSwfLogStore dbSwfLogStore = new DBSwfLogStore(dbManager);

        int logNo = dbSwfLogStore.getMaxNodeLogNo(flowID,nodeType,businessNo);
        return logNo;
    }
}
