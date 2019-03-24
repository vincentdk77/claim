package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpJrefPatchRecDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpjrefpatchrec批量付费登记表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpJrefPatchRecAction extends BLPrpJrefPatchRecActionBase{
    private static Log log = LogFactory.getLog(BLPrpJrefPatchRecAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpJrefPatchRecAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpJrefPatchRecDto prpJrefPatchRecDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpJrefPatchRecDto prpJrefPatchRecDto,String mode) throws Exception{
    }
}
