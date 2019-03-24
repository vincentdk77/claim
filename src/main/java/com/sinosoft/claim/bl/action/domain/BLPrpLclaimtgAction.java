package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimtgDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prplclaim立案基本信息表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLclaimtgAction extends BLPrpLclaimtgActionBase{
    private static Log log = LogFactory.getLog(BLPrpLclaimtgAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpLclaimtgAction(){
        super();
    }

    /**
     * 转换tgDto
     * @param dbManager dbManager
     * @param prpLclaimtgDto prpLclaimtgDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLclaimtgDto prpLclaimtgDto,String mode) throws Exception{
    }
}
