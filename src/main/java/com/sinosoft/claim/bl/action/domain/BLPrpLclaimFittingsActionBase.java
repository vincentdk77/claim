package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimFittingsDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimFittings;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLclaimFittings-赔款计算书表的业务逻辑对象类<br>
 * 创建于 2005-03-18 17:53:37.968<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLclaimFittingsActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLclaimFittingsActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLclaimFittingsActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLclaimFittingsDto prpLclaimFittingsDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLclaimFittingsDto prpLclaimFittingsDto) throws Exception{
        DBPrpLclaimFittings dbPrpLclaimFittings = new DBPrpLclaimFittings(dbManager);
        //插入记录
        dbPrpLclaimFittings.insert(prpLclaimFittingsDto);
    }
   
    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLclaimFittings dbPrpLclaimFittings = new DBPrpLclaimFittings(dbManager);
        //按条件删除记录
        dbPrpLclaimFittings.deleteByConditions(conditions);
    }
}
