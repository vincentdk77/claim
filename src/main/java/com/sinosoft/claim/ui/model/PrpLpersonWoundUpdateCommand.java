package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.claim.dto.domain.PrpLpersonWoundDto;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLPrpLpersonWoundFacade��UI Command��<br>
 * ������ 2005-02-18 10:47:33.890<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLpersonWoundUpdateCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  ���췽��,����һ��PrpLpersonWoundUpdateCommand����
     * @param prpLpersonWoundDto ����prpLpersonWoundDto
     * @throws Exception
     */
    public PrpLpersonWoundUpdateCommand(PrpLpersonWoundDto prpLpersonWoundDto) throws Exception {
    		this.params = new Object[]{prpLpersonWoundDto };
    		this.paramTypes = new Class[]{PrpLpersonWoundDto.class };
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLPrpLpersonWoundFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("update",paramTypes);
        return method.invoke(object,params);
    }
}
