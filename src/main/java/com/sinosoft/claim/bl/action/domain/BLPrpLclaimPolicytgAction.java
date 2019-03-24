package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimPolicytgDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prplclaimpolicy立案保单清单表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLclaimPolicytgAction extends BLPrpLclaimPolicytgActionBase{
    private static Log log = LogFactory.getLog(BLPrpLclaimPolicytgAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpLclaimPolicytgAction(){
        super();
    }

    /**
     * 转换tgDto
     * @param dbManager dbManager
     * @param prpLclaimPolicytgDto prpLclaimPolicytgDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLclaimPolicytgDto prpLclaimPolicytgDto,String mode) throws Exception{
    }
}
