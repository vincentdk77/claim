package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLPrpDriskFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLPrpDriskFacade��UI Command��<br>
 * ������ 2004-08-25 16:51:31.656<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDriskFindByPrimaryKeyCommand extends BaseCommand{
    private String riskCode = "" ;  //����
    /**
     *  ���췽��,����һ��PrpDriskFindByConditionsCommand����
     * @param conditions ����conditions
     * @param pageNo ����pageNo
     * @param rowsPerPage ����rowsPerPage
     * @throws Exception
     */
    public PrpDriskFindByPrimaryKeyCommand(String riskCode) throws Exception {
    		this.riskCode = riskCode;
    }
    /**
     *  ���췽��,����һ��PrpDriskFindByConditionsCommand����
     * @param conditions ����conditions
     * @throws Exception
     */
    /*
    public PrpDriskFindByConditionsCommand(String conditions) throws Exception {
    		this.params = new Object[]{conditions };
    		this.paramTypes = new Class[]{String.class };
    }*/
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{

        BLPrpDriskFacade blPrpDriskFacade = new BLPrpDriskFacade();
        return blPrpDriskFacade.findByPrimaryKey(this.riskCode) ;

      }
}
