package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimStatustgDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimStatustg;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLclaimStatus理赔节点状态表的业务对象扩展类<br>
 * 创建于 2004-05-09 11:07:44.551<br>
 * JToolpad(1.2.9) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLclaimStatustgAction extends BLPrpLclaimStatustgActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLclaimStatustgAction.class);

    /**
     * 构造函数
     */
    public BLPrpLclaimStatustgAction(){
        super();
    }

    /**
     * 转换tgDto
     * @param dbManager dbManager
     * @param prpLclaimStatustgDto prpLclaimStatustgDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLclaimStatustgDto prpLclaimStatustgDto,String mode) throws Exception{
    }


    /**
     * 按条件统计数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @throws Exception
     */
    public Collection getStatStatus(DBManager dbManager,String conditions) throws Exception{
        DBPrpLclaimStatustg dbPrpLclaimStatustg = new DBPrpLclaimStatustg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }
        return collection = dbPrpLclaimStatustg.getStatStatus(conditions);
    }
}
