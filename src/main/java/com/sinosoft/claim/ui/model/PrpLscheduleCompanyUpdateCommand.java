package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.claim.dto.domain.PrpLscheduleCompanyDto;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLPrpLscheduleCompanyFacade��UI Command��<br>
 * ������ 2005-08-20 17:56:04.119<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLscheduleCompanyUpdateCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  ���췽��,����һ��PrpLscheduleCompanyUpdateCommand����
     * @param prpLscheduleCompanyDto ����prpLscheduleCompanyDto
     * @throws Exception
     */
    public PrpLscheduleCompanyUpdateCommand(PrpLscheduleCompanyDto prpLscheduleCompanyDto) throws Exception {
    		this.params = new Object[]{prpLscheduleCompanyDto };
    		this.paramTypes = new Class[]{PrpLscheduleCompanyDto.class };
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLPrpLscheduleCompanyFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("update",paramTypes);
        return method.invoke(object,params);
    }
}
