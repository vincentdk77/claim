package com.sinosoft.servlet.accisd.bl.action.domain;

import com.sinosoft.servlet.accisd.dto.domain.PrpLAcciBaseInfoSDDto;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PRPLACCIBASEINFOSD��ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLAcciBaseInfoSDAction extends BLPrpLAcciBaseInfoSDActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLAcciBaseInfoSDAction.class);

    /**
     * ���캯��
     */
    public BLPrpLAcciBaseInfoSDAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prplaccibaseinfosdDto prplaccibaseinfosdDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLAcciBaseInfoSDDto prplaccibaseinfosdDto,String mode)
            throws Exception{
    }
}
