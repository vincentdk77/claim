package com.sinosoft.claimzy.bl.action.domain;




import com.sinosoft.claimzy.dto.domain.AgriClaimUploadLogDto;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����BLAgriClaimUploadLogAction��ҵ�������չ��<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLAgriClaimUploadLogAction extends BLAgriClaimUploadLogActionBase {
	private static Logger logger = Logger.getLogger(BLAgriClaimUploadLogAction.class);

    /**
     * ���캯��
     */
    public BLAgriClaimUploadLogAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param aGRICLAIMUPLOADLOGDto aGRICLAIMUPLOADLOGDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,AgriClaimUploadLogDto agriClaimUploadLogDto,String mode)
            throws Exception{
    }
}
