package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpJpremAllocDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpjpremalloc长期险业务保费分摊表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpJpremAllocAction extends BLPrpJpremAllocActionBase{
    private static Log log = LogFactory.getLog(BLPrpJpremAllocAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpJpremAllocAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpJpremAllocDto prpJpremAllocDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpJpremAllocDto prpJpremAllocDto,String mode) throws Exception{
    }
}
