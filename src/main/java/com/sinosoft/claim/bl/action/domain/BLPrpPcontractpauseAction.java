package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpPcontractpauseDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpPcontractpause��ֹ���պ�ͬ��Ϣ���ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpPcontractpauseAction extends BLPrpPcontractpauseActionBase{
    private static Log log = LogFactory.getLog(BLPrpPcontractpauseAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpPcontractpauseAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpPcontractpauseDto prpPcontractpauseDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpPcontractpauseDto prpPcontractpauseDto,String mode) throws Exception{
    }
}
