package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCbatchDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpcbatch批量保单附表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCbatchAction extends BLPrpCbatchActionBase{
    private static Log log = LogFactory.getLog(BLPrpCbatchAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpCbatchAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpCbatchDto prpCbatchDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpCbatchDto prpCbatchDto,String mode) throws Exception{
    }
}
