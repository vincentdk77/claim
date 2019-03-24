package com.sinosoft.claimciplatform.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claimciplatform.dto.domain.CIClaimUploadRegistDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是理赔信息平台上传注册表的业务对象扩展类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCIClaimUploadRegistAction extends BLCIClaimUploadRegistActionBase{
    private static Log logger = LogFactory.getLog(BLCIClaimUploadRegistAction.class);

    /**
     * 构造函数
     */
    public BLCIClaimUploadRegistAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param cIClaimUploadRegistDto cIClaimUploadRegistDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,CIClaimUploadRegistDto cIClaimUploadRegistDto,String mode)
            throws Exception{
    }
}
