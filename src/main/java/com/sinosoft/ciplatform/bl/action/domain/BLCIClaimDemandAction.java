package com.sinosoft.ciplatform.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.ciplatform.dto.domain.CIClaimDemandDto;
import com.sinosoft.ciplatform.resource.dtofactory.domain.DBCIClaimDemand;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ��������ƽ̨��ѯ���ҵ�������չ��<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCIClaimDemandAction extends BLCIClaimDemandActionBase{
    private static Log logger = LogFactory.getLog(BLCIClaimDemandAction.class);

    /**
     * ���캯��
     */
    public BLCIClaimDemandAction(){
        super();
    }
    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param cIClaimDemandDto cIClaimDemandDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,CIClaimDemandDto cIClaimDemandDto,String mode)
            throws Exception{
    }
}
