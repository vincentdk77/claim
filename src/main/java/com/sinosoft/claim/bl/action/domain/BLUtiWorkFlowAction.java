package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.UtiWorkFlowDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是utiworkflow工作流表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiWorkFlowAction extends BLUtiWorkFlowActionBase{
    private static Log log = LogFactory.getLog(BLUtiWorkFlowAction.class.getName());

    /**
     * 构造函数
     */
    public BLUtiWorkFlowAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param utiWorkFlowDto utiWorkFlowDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,UtiWorkFlowDto utiWorkFlowDto,String mode) throws Exception{
    }
}
