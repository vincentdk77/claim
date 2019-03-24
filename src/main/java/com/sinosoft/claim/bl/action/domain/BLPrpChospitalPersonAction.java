package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpChospitalPersonDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpChospitalPerson的业务对象扩展类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpChospitalPersonAction extends BLPrpChospitalPersonActionBase{
    private static Log logger = LogFactory.getLog(BLPrpChospitalPersonAction.class);

    /**
     * 构造函数
     */
    public BLPrpChospitalPersonAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpChospitalPersonDto prpChospitalPersonDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpChospitalPersonDto prpChospitalPersonDto,String mode)
            throws Exception{
    }
}
