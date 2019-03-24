package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimStatus;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLclaimStatus理赔节点状态表的业务对象扩展类<br>
 * 创建于 2004-05-09 11:07:44.551<br>
 * JToolpad(1.2.9) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLclaimStatusAction extends BLPrpLclaimStatusActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLclaimStatusAction.class);

    /**
     * 构造函数
     */
    public BLPrpLclaimStatusAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLclaimStatusDto prpLclaimStatusDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLclaimStatusDto prpLclaimStatusDto,String mode) throws Exception{
    }


    /**
     * 按条件统计数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @throws Exception
     */
    public Collection getStatStatus(DBManager dbManager,String conditions) throws Exception{
        DBPrpLclaimStatus dbPrpLclaimStatus = new DBPrpLclaimStatus(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }
        return collection = dbPrpLclaimStatus.getStatStatus(conditions);
    }
}
