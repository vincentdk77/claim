package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLCitemKindDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLCitemKind代赔保单投保险别表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLCitemKindAction extends BLPrpLCitemKindActionBase{
    private static Log log = LogFactory.getLog(BLPrpLCitemKindAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpLCitemKindAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLCitemKindDto prpLCitemKindDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLCitemKindDto prpLCitemKindDto,String mode) throws Exception{
    }
}
