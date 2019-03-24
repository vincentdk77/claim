package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.SwfPathDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是WFPATH工作流路径定义表的业务对象扩展类<br>
 * 创建于 2004-08-09 19:54:54.996<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLSwfPathAction extends BLSwfPathActionBase{
    private static Log logger = LogFactory.getLog(BLSwfPathAction.class);

    /**
     * 构造函数
     */
    public BLSwfPathAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param swfPathDto swfPathDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,SwfPathDto swfPathDto,String mode) throws Exception{
    }
}
