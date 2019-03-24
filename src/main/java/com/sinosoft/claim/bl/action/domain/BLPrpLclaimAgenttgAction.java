package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimAgenttgDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prplclaimagent代理赔保单信息表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLclaimAgenttgAction extends BLPrpLclaimAgenttgActionBase{
    private static Log log = LogFactory.getLog(BLPrpLclaimAgenttgAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpLclaimAgenttgAction(){
        super();
    }

    /**
     * 转换tgDto
     * @param dbManager dbManager
     * @param prpLclaimAgenttgDto prpLclaimAgenttgDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLclaimAgenttgDto prpLclaimAgenttgDto,String mode) throws Exception{
    }
}
