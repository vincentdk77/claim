package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.EdaUserDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是EdaUser-座席员信息表的业务对象扩展类<br>
 * 创建于 2005-06-22 14:56:46.226<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLEdaUserAction extends BLEdaUserActionBase{
    private static Log logger = LogFactory.getLog(BLEdaUserAction.class);

    /**
     * 构造函数
     */
    public BLEdaUserAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param edaUserDto edaUserDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,EdaUserDto edaUserDto,String mode) throws Exception{
    }
}
