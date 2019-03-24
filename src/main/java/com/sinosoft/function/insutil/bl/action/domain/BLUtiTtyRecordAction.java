package com.sinosoft.function.insutil.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.UtiTtyRecordDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是utittyrecord的业务对象扩展类<br>
 * 创建于 2004-4-5 15:16:34<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiTtyRecordAction extends BLUtiTtyRecordActionBase{
    private static Log log = LogFactory.getLog(BLUtiTtyRecordAction.class.getName());

    /**
     * 构造函数
     */
    public BLUtiTtyRecordAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param utiTtyRecordDto utiTtyRecordDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,UtiTtyRecordDto utiTtyRecordDto,String mode) throws Exception{
    }
}
