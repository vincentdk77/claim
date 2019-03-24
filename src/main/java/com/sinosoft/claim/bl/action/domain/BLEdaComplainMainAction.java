package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.EdaComplainMainDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是EdaComplainMain投诉信息表的业务对象扩展类<br>
 * 创建于 2005-08-20 17:41:17.193<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLEdaComplainMainAction extends BLEdaComplainMainActionBase{
    private static Log logger = LogFactory.getLog(BLEdaComplainMainAction.class);

    /**
     * 构造函数
     */
    public BLEdaComplainMainAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param edaComplainMainDto edaComplainMainDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,EdaComplainMainDto edaComplainMainDto,String mode) throws Exception{
    }
}
