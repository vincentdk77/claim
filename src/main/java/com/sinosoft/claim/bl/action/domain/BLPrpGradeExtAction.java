package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpGradeExtDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpgradeext岗位扩展表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpGradeExtAction extends BLPrpGradeExtActionBase{
    private static Log log = LogFactory.getLog(BLPrpGradeExtAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpGradeExtAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpGradeExtDto prpGradeExtDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpGradeExtDto prpGradeExtDto,String mode) throws Exception{
    }
}
