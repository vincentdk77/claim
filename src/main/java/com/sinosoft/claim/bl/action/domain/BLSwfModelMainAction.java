package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.SwfModelMainDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是WfModelMain模板主表的业务对象扩展类<br>
 * 创建于 2004-08-09 19:54:54.986<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLSwfModelMainAction extends BLSwfModelMainActionBase{
    private static Log logger = LogFactory.getLog(BLSwfModelMainAction.class);

    /**
     * 构造函数
     */
    public BLSwfModelMainAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param wfModelMainDto wfModelMainDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,SwfModelMainDto swfModelMainDto,String mode) throws Exception{
    }
}
