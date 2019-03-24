package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDitemDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpditem标的项目代码表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDitemAction extends BLPrpDitemActionBase{
    private static Log log = LogFactory.getLog(BLPrpDitemAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpDitemAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpDitemDto prpDitemDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDitemDto prpDitemDto,String mode) throws Exception{
    }
}
