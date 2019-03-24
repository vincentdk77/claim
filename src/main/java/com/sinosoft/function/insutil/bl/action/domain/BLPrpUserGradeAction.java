package com.sinosoft.function.insutil.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpUserGradeDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpusergrade的业务对象扩展类<br>
 * 创建于 2004-4-5 15:16:32<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpUserGradeAction extends BLPrpUserGradeActionBase{
    private static Log log = LogFactory.getLog(BLPrpUserGradeAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpUserGradeAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpUserGradeDto prpUserGradeDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpUserGradeDto prpUserGradeDto,String mode) throws Exception{
    }
}
