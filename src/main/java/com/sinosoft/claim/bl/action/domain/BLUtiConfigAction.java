package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.UtiConfigDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是uticonfig（无用数据表）的业务对象扩展类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiConfigAction extends BLUtiConfigActionBase{
    private static Log log = LogFactory.getLog(BLUtiConfigAction.class.getName());

    /**
     * 构造函数
     */
    public BLUtiConfigAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param utiConfigDto utiConfigDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,UtiConfigDto utiConfigDto,String mode) throws Exception{
    }
}
