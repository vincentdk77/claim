package com.sinosoft.function.insutil.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.UtiGroupDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是utigroup的业务对象扩展类<br>
 * 创建于 2004-4-5 15:16:32<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiGroupAction extends BLUtiGroupActionBase{
    private static Log log = LogFactory.getLog(BLUtiGroupAction.class.getName());

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
