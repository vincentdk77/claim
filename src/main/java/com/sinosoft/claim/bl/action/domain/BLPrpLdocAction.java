package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLdocDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpldoc索赔单证信息表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLdocAction extends BLPrpLdocActionBase{
    private static Log log = LogFactory.getLog(BLPrpLdocAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpLdocAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLdocDto prpLdocDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLdocDto prpLdocDto,String mode) throws Exception{
    }
}
