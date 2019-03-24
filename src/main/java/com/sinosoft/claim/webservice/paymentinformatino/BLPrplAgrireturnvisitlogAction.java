package com.sinosoft.claim.webservice.paymentinformatino;

import com.sinosoft.claim.bl.action.domain.BLPrplreturnvisitswflogAction;
import com.sinosoft.claim.dto.domain.PrplreturnvisitswflogDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplreturnvisitswflog;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PRPLAGRIRETURNVISITLOG的业务对象扩展类<br>
 * @author Administrator
 *
 */
public class BLPrplAgrireturnvisitlogAction extends BLPrplAgrireturnvisitlogActionBase{
	private static Logger logger = Logger.getLogger(BLPrplAgrireturnvisitlogAction.class);

    /**
     * 构造函数
     */
    public BLPrplAgrireturnvisitlogAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prplreturnvisitswflogDto prplreturnvisitswflogDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrplAgrireturnvisitlogDto prplAgrireturnvisitlogDto,String mode)
            throws Exception{
    }

	public Double findSumprepaidBySQL(DBManager dbManager, String sql) throws Exception{
        DBPrplagrireturnvisitlog dbPrplagrireturnvisitlog = new DBPrplagrireturnvisitlog(dbManager);
        //插入记录
        Double sumprepaid = dbPrplagrireturnvisitlog.findSumprepaidBySQL(sql);
        return sumprepaid;
    }
}
