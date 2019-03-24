package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.claim.dto.domain.PrpLbackVisitDto;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLPrpLbackVisitFacade��UI Command��<br>
 * ������ 2005-03-25 20:44:51.265<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLbackVisitInsertCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  ���췽��,����һ��PrpLbackVisitInsertCommand����
     * @param prpLbackVisitDto ����prpLbackVisitDto
     * @throws Exception
     */
    public PrpLbackVisitInsertCommand(PrpLbackVisitDto prpLbackVisitDto) throws Exception {
    		this.params = new Object[]{prpLbackVisitDto };
    		this.paramTypes = new Class[]{PrpLbackVisitDto.class };
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLPrpLbackVisitFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("insert",paramTypes);
        return method.invoke(object,params);
    }
}
