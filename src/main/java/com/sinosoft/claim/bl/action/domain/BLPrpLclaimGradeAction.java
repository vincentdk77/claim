package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimGradeDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLclaimGrade--理赔业务权限表(新增)的业务对象扩展类<br>
 * 创建于 2005-04-19 09:24:22.453<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLclaimGradeAction extends BLPrpLclaimGradeActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLclaimGradeAction.class);

    /**
     * 构造函数
     */
    public BLPrpLclaimGradeAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLclaimGradeDto prpLclaimGradeDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLclaimGradeDto prpLclaimGradeDto,String mode) throws Exception{
    }
}
