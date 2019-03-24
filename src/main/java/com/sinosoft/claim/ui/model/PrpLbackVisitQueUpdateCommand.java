package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.claim.dto.domain.PrpLbackVisitQueDto;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLPrpLbackVisitQueFacade��UI Command��<br>
 * ������ 2005-03-23 09:00:29.765<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLbackVisitQueUpdateCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  ���췽��,����һ��PrpLbackVisitQueUpdateCommand����
     * @param prpLbackVisitQueDto ����prpLbackVisitQueDto
     * @throws Exception
     */
    public PrpLbackVisitQueUpdateCommand(PrpLbackVisitQueDto prpLbackVisitQueDto) throws Exception {
    		this.params = new Object[]{prpLbackVisitQueDto };
    		this.paramTypes = new Class[]{PrpLbackVisitQueDto.class };
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLPrpLbackVisitQueFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("update",paramTypes);
        return method.invoke(object,params);
    }
}
