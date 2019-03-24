package com.gyic.claim.bl.action.domain;

import com.gyic.claim.dto.domain.PrplcombineDto;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是理赔节点状态表与并案关联表联表的的业务对象扩展类<br>
 */
public class BLPrplcombineSwfLogAction extends BLPrplcombineSwfLogActionBase{
    private static Logger logger = Logger.getLogger(BLPrplcombineSwfLogAction.class);

    /**
     * 构造函数
     */
    public BLPrplcombineSwfLogAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param insuremainlistDto insuremainlistDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrplcombineDto prplcombineDto,String mode)
            throws Exception{
    }
}
