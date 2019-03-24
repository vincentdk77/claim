package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.UtiKeyDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是utikey键值信息表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiKeyAction extends BLUtiKeyActionBase{
    private static Log log = LogFactory.getLog(BLUtiKeyAction.class.getName());

    /**
     * 构造函数
     */
    public BLUtiKeyAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param utiKeyDto utiKeyDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,UtiKeyDto utiKeyDto,String mode) throws Exception{
    }
}
