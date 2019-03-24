package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpJrefRecDetailDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpjrefrecdetail付费登记明细表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpJrefRecDetailAction extends BLPrpJrefRecDetailActionBase{
    private static Log log = LogFactory.getLog(BLPrpJrefRecDetailAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpJrefRecDetailAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpJrefRecDetailDto prpJrefRecDetailDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpJrefRecDetailDto prpJrefRecDetailDto,String mode) throws Exception{
    }
}
