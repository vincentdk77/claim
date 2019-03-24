package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimGradetgDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLclaimGrade--理赔业务权限表(新增)的业务对象扩展类<br>
 * 创建于 2005-04-19 09:24:22.453<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLclaimGradetgAction extends BLPrpLclaimGradetgActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLclaimGradetgAction.class);

    /**
     * 构造函数
     */
    public BLPrpLclaimGradetgAction(){
        super();
    }

    /**
     * 转换tgDto
     * @param dbManager dbManager
     * @param prpLclaimGradetgDto prpLclaimGradetgDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLclaimGradetgDto prpLclaimGradetgDto,String mode) throws Exception{
    }
}
