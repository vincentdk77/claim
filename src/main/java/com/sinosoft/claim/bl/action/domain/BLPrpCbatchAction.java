package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCbatchDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpcbatch�������������ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCbatchAction extends BLPrpCbatchActionBase{
    private static Log log = LogFactory.getLog(BLPrpCbatchAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpCbatchAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpCbatchDto prpCbatchDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpCbatchDto prpCbatchDto,String mode) throws Exception{
    }
}
