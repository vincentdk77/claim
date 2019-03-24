package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLTripartiteComDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLTripartiteCom;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpDTripartiteEnterprise第三方数据维护 修理厂表的业务对象扩展类<br>
 * 创建于 2012/11/9
 */
public class BLPrpLTripartiteComAction extends
		BLPrpLTripartiteComActionBase {
	private static Log log = LogFactory.getLog(BLPrpLTripartiteComAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpLTripartiteComAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param PrpDTripartiteEnterpriseDto PrpDTripartiteEnterpriseDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLTripartiteComDto prpDTripartiteCom,String mode) throws Exception{
    }

	public Collection findSql(DBManager dbManager, String sql) throws Exception{
		DBPrpLTripartiteCom dbPrpLTripartiteCom = new DBPrpLTripartiteCom(dbManager);
		Collection collection = new ArrayList();
		collection = dbPrpLTripartiteCom.findSql(dbManager,sql);
		return collection;
	}
}
