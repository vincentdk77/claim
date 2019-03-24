package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCcarDeviceDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpccardevice投保机动车新增设备信息表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCcarDeviceAction extends BLPrpCcarDeviceActionBase{
    private static Log log = LogFactory.getLog(BLPrpCcarDeviceAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpCcarDeviceAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpCcarDeviceDto prpCcarDeviceDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpCcarDeviceDto prpCcarDeviceDto,String mode) throws Exception{
    }
}
