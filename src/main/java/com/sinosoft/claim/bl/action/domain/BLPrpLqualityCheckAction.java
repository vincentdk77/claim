package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLqualityCheckDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLqualityCheck-�����������ݱ��ҵ�������չ��<br>
 * ������ 2005-04-14 15:56:47.453<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLqualityCheckAction extends BLPrpLqualityCheckActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLqualityCheckAction.class);

    /**
     * ���캯��
     */
    public BLPrpLqualityCheckAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLqualityCheckDto prpLqualityCheckDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLqualityCheckDto prpLqualityCheckDto,String mode) throws Exception{
    }
}
