package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.SwfNodeDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是WfNode工作流节点定义表的业务对象扩展类<br>
 * 创建于 2004-08-09 19:54:54.996<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLSwfNodeAction extends BLSwfNodeActionBase{
    private static Log logger = LogFactory.getLog(BLSwfNodeAction.class);

    /**
     * 构造函数
     */
    public BLSwfNodeAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param wfNodeDto wfNodeDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,SwfNodeDto swfNodeDto,String mode) throws Exception{
    }
}
