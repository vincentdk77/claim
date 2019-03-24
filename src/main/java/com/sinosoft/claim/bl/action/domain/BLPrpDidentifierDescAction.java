package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDidentifierDescDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdidentifierdesc检验人文本描述表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDidentifierDescAction extends BLPrpDidentifierDescActionBase{
    private static Log log = LogFactory.getLog(BLPrpDidentifierDescAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpDidentifierDescAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpDidentifierDescDto prpDidentifierDescDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDidentifierDescDto prpDidentifierDescDto,String mode) throws Exception{
    }
}
