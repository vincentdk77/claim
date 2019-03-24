package com.sinosoft.claimciplatform.bl.action.domain;

import com.sinosoft.claimciplatform.dto.domain.CIInsureValidDto;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是投保确认主表-CIInsureValid的业务对象扩展类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCIInsureValidAction extends BLCIInsureValidActionBase{
    private static Log logger = LogFactory.getLog(BLCIInsureValidAction.class);

    /**
     * 构造函数
     */
    public BLCIInsureValidAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param cIInsureValidDto cIInsureValidDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,CIInsureValidDto cIInsureValidDto,String mode)
            throws Exception{
    }
}
