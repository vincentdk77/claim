package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLpeds_PersonDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLpeds_Person人员伤亡明细信息表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:24<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLpeds_PersonAction extends BLPrpLpeds_PersonActionBase{
    private static Log log = LogFactory.getLog(BLPrpLpeds_PersonAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpLpeds_PersonAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLpeds_PersonDto prpLpeds_PersonDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLpeds_PersonDto prpLpeds_PersonDto,String mode) throws Exception{
    }
}
