package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCinsuredExtDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpcinsuredext关系人扩展信息表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCinsuredExtAction extends BLPrpCinsuredExtActionBase{
    private static Log log = LogFactory.getLog(BLPrpCinsuredExtAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpCinsuredExtAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpCinsuredExtDto prpCinsuredExtDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpCinsuredExtDto prpCinsuredExtDto,String mode) throws Exception{
    }
}
