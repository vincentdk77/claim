package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcertifyDirectDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLcertifyDirect-����ָ��(����)��ҵ�������չ��<br>
 * ������ 2005-03-22 17:21:39.781<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLcertifyDirectAction extends BLPrpLcertifyDirectActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLcertifyDirectAction.class);

    /**
     * ���캯��
     */
    public BLPrpLcertifyDirectAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLcertifyDirectDto prpLcertifyDirectDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLcertifyDirectDto prpLcertifyDirectDto,String mode) throws Exception{
    }
}
