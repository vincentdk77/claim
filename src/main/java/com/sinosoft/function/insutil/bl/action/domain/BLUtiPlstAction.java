package com.sinosoft.function.insutil.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.UtiPlstDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是utiplst的业务对象扩展类<br>
 * 创建于 2004-4-5 15:16:33<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiPlstAction extends BLUtiPlstActionBase{
    private static Log log = LogFactory.getLog(BLUtiPlstAction.class.getName());

    /**
     * 构造函数
     */
    public BLUtiPlstAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param utiPlstDto utiPlstDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,UtiPlstDto utiPlstDto,String mode) throws Exception{
    }
}
