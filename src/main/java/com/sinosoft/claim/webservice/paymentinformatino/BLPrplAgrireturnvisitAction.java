package com.sinosoft.claim.webservice.paymentinformatino;

import com.sinosoft.claim.bl.action.domain.BLPrplreturnvisitAction;
import com.sinosoft.claim.bl.action.domain.BLPrplreturnvisitActionBase;
import com.sinosoft.claim.dto.domain.PrplreturnvisitDto;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PRPLAGRIRETURNVISIT��ҵ�������չ��<br>
 * @author Administrator
 *
 */
public class BLPrplAgrireturnvisitAction extends BLPrplAgrireturnvisitActionBase{
    private static Logger logger = Logger.getLogger(BLPrplAgrireturnvisitAction.class);

    /**
     * ���캯��
     */
    public BLPrplAgrireturnvisitAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prplreturnvisitDto prplreturnvisitDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrplagrireturnvisitDto prplagrireturnvisitDto,String mode)
            throws Exception{
    }
}

