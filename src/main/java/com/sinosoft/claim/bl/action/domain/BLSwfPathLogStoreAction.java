package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.SwfPathLogStoreDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是SwfPathLogStore的业务对象扩展类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLSwfPathLogStoreAction extends BLSwfPathLogStoreActionBase{
    private static Log logger = LogFactory.getLog(BLSwfPathLogStoreAction.class);

    /**
     * 构造函数
     */
    public BLSwfPathLogStoreAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param swfPathLogStoreDto swfPathLogStoreDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,SwfPathLogStoreDto swfPathLogStoreDto,String mode)
            throws Exception{
    }
}
