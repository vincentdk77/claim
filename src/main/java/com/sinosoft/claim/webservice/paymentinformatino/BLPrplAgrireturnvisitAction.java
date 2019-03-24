package com.sinosoft.claim.webservice.paymentinformatino;

import com.sinosoft.claim.bl.action.domain.BLPrplreturnvisitAction;
import com.sinosoft.claim.bl.action.domain.BLPrplreturnvisitActionBase;
import com.sinosoft.claim.dto.domain.PrplreturnvisitDto;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PRPLAGRIRETURNVISIT的业务对象扩展类<br>
 * @author Administrator
 *
 */
public class BLPrplAgrireturnvisitAction extends BLPrplAgrireturnvisitActionBase{
    private static Logger logger = Logger.getLogger(BLPrplAgrireturnvisitAction.class);

    /**
     * 构造函数
     */
    public BLPrplAgrireturnvisitAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prplreturnvisitDto prplreturnvisitDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrplagrireturnvisitDto prplagrireturnvisitDto,String mode)
            throws Exception{
    }
}

