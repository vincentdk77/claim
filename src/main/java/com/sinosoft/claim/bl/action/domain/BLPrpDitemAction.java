package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDitemDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpditem�����Ŀ������ҵ�������չ��<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDitemAction extends BLPrpDitemActionBase{
    private static Log log = LogFactory.getLog(BLPrpDitemAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpDitemAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpDitemDto prpDitemDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDitemDto prpDitemDto,String mode) throws Exception{
    }
}
