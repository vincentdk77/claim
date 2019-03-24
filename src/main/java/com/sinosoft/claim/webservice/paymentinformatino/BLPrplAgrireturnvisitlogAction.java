package com.sinosoft.claim.webservice.paymentinformatino;

import com.sinosoft.claim.bl.action.domain.BLPrplreturnvisitswflogAction;
import com.sinosoft.claim.dto.domain.PrplreturnvisitswflogDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplreturnvisitswflog;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PRPLAGRIRETURNVISITLOG��ҵ�������չ��<br>
 * @author Administrator
 *
 */
public class BLPrplAgrireturnvisitlogAction extends BLPrplAgrireturnvisitlogActionBase{
	private static Logger logger = Logger.getLogger(BLPrplAgrireturnvisitlogAction.class);

    /**
     * ���캯��
     */
    public BLPrplAgrireturnvisitlogAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prplreturnvisitswflogDto prplreturnvisitswflogDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrplAgrireturnvisitlogDto prplAgrireturnvisitlogDto,String mode)
            throws Exception{
    }

	public Double findSumprepaidBySQL(DBManager dbManager, String sql) throws Exception{
        DBPrplagrireturnvisitlog dbPrplagrireturnvisitlog = new DBPrplagrireturnvisitlog(dbManager);
        //�����¼
        Double sumprepaid = dbPrplagrireturnvisitlog.findSumprepaidBySQL(sql);
        return sumprepaid;
    }
}
