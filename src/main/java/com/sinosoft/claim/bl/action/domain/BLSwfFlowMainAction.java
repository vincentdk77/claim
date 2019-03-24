package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.SwfFlowMainDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是SwfFlowMain流程主表的业务对象扩展类<br>
 * 创建于 2004-08-09 19:54:55.006<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLSwfFlowMainAction extends BLSwfFlowMainActionBase{
    private static Log logger = LogFactory.getLog(BLSwfFlowMainAction.class);

    /**
     * 构造函数
     */
    public BLSwfFlowMainAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param swfFlowMainDto swfFlowMainDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,SwfFlowMainDto swfFlowMainDto,String mode) throws Exception{
    }
}
