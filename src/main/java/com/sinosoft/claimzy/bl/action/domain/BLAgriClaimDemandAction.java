package com.sinosoft.claimzy.bl.action.domain;

import com.sinosoft.claimzy.dto.domain.AgriClaimDemandDto;
import com.sinosoft.claimzy.dto.domain.AgriClaimUploadLogDto;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����BLAgriClaimDemandAction��ҵ�������չ��<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLAgriClaimDemandAction extends BLAgriClaimDemandActionBase{
	private static Logger logger = Logger.getLogger(BLAgriClaimDemandAction.class);

    /**
     * ���캯��
     */
    public BLAgriClaimDemandAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param aGRICLAIMUPLOADLOGDto aGRICLAIMUPLOADLOGDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,AgriClaimDemandDto agriClaimDemandDto,String mode)
            throws Exception{
    }
}
