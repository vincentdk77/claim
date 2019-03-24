package com.sinosoft.claimzy.bl.action.domain;




import com.sinosoft.claimzy.dto.domain.AgriClaimUploadLogDto;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是BLAgriClaimUploadLogAction的业务对象扩展类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLAgriClaimUploadLogAction extends BLAgriClaimUploadLogActionBase {
	private static Logger logger = Logger.getLogger(BLAgriClaimUploadLogAction.class);

    /**
     * 构造函数
     */
    public BLAgriClaimUploadLogAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param aGRICLAIMUPLOADLOGDto aGRICLAIMUPLOADLOGDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,AgriClaimUploadLogDto agriClaimUploadLogDto,String mode)
            throws Exception{
    }
}
