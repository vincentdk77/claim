package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCrenewalDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpcrenewal续保信息表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:24<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCrenewalAction extends BLPrpCrenewalActionBase{
    private static Log log = LogFactory.getLog(BLPrpCrenewalAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpCrenewalAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpCrenewalDto prpCrenewalDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpCrenewalDto prpCrenewalDto,String mode) throws Exception{
    }
}
