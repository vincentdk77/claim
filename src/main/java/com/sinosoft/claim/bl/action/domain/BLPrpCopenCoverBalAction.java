package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCopenCoverBalDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpcopencoverbal协议结算记录表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCopenCoverBalAction extends BLPrpCopenCoverBalActionBase{
    private static Log log = LogFactory.getLog(BLPrpCopenCoverBalAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpCopenCoverBalAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpCopenCoverBalDto prpCopenCoverBalDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpCopenCoverBalDto prpCopenCoverBalDto,String mode) throws Exception{
    }
}
