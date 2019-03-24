package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.claim.dto.domain.PrpLbackVisitTextDto;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLPrpLbackVisitTextFacade��UI Command��<br>
 * ������ 2005-03-23 09:00:42.640<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLbackVisitTextUpdateCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  ���췽��,����һ��PrpLbackVisitTextUpdateCommand����
     * @param prpLbackVisitTextDto ����prpLbackVisitTextDto
     * @throws Exception
     */
    public PrpLbackVisitTextUpdateCommand(PrpLbackVisitTextDto prpLbackVisitTextDto) throws Exception {
    		this.params = new Object[]{prpLbackVisitTextDto };
    		this.paramTypes = new Class[]{PrpLbackVisitTextDto.class };
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLPrpLbackVisitTextFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("update",paramTypes);
        return method.invoke(object,params);
    }
}
