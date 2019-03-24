package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCprofitDetailDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpcprofitdetail优惠折扣明细表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCprofitDetailAction extends BLPrpCprofitDetailActionBase{
    private static Log log = LogFactory.getLog(BLPrpCprofitDetailAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpCprofitDetailAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpCprofitDetailDto prpCprofitDetailDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpCprofitDetailDto prpCprofitDetailDto,String mode) throws Exception{
    }
}
