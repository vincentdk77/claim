package com.sinosoft.function.insutil.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpTaskDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpTask的业务对象扩展类<br>
 * 创建于 2004-4-5 15:16:34<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpTaskAction extends BLPrpTaskActionBase{
    private static Log log = LogFactory.getLog(BLPrpTaskAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpTaskAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpTaskDto prpTaskDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpTaskDto prpTaskDto,String mode) throws Exception{
    }
}
