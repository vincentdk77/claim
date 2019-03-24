package com.sinosoft.function.power.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.power.dto.domain.PrpUserGradeDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpUserGrade 员工权限表的业务对象扩展类<br>
 * 创建于 2004-11-09 10:40:54.658<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpUserGradeAction extends BLPrpUserGradeActionBase{
    private static Log logger = LogFactory.getLog(BLPrpUserGradeAction.class);

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
