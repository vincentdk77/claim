package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLQsListDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLQs_list清算中心通赔结算明细清单的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:24<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLQsListAction extends BLPrpLQsListActionBase{
    private static Log log = LogFactory.getLog(BLPrpLQsListAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpLQsListAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLQs_listDto prpLQs_listDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLQsListDto prpLQs_listDto,String mode) throws Exception{
    }
}
