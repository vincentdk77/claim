package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpMaxNoDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpmaxno��֤�ű��ҵ�������չ��<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpMaxNoAction extends BLPrpMaxNoActionBase{
    private static Log log = LogFactory.getLog(BLPrpMaxNoAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpMaxNoAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpMaxNoDto prpMaxNoDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpMaxNoDto prpMaxNoDto,String mode) throws Exception{
    }
}
