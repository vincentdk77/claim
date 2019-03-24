package com.sinosoft.function.power.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.power.dto.domain.PrpTaskDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpTask工作任务表的业务对象扩展类<br>
 * 创建于 2004-11-09 10:40:54.669<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpTaskAction extends BLPrpTaskActionBase{
    private static Log logger = LogFactory.getLog(BLPrpTaskAction.class);

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
