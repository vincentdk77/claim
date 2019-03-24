package com.sinosoft.function.power.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.power.dto.domain.UtiGroupDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是UtiGroup  权限组号表的业务对象扩展类<br>
 * 创建于 2004-11-09 10:40:54.648<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiGroupAction extends BLUtiGroupActionBase{
    private static Log logger = LogFactory.getLog(BLUtiGroupAction.class);

    /**
     * 构造函数
     */
    public BLUtiGroupAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param utiGroupDto utiGroupDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,UtiGroupDto utiGroupDto,String mode) throws Exception{
    }
}
