package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.claim.dto.domain.PrpLthirdPropDto;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLPrpLthirdPropFacade��UI Command��<br>
 * ������ 2005-04-12 11:37:57.140<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLthirdPropInsertCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  ���췽��,����һ��PrpLthirdPropInsertCommand����
     * @param prpLthirdPropDto ����prpLthirdPropDto
     * @throws Exception
     */
    public PrpLthirdPropInsertCommand(PrpLthirdPropDto prpLthirdPropDto) throws Exception {
    		this.params = new Object[]{prpLthirdPropDto };
    		this.paramTypes = new Class[]{PrpLthirdPropDto.class };
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLPrpLthirdPropFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("insert",paramTypes);
        return method.invoke(object,params);
    }
}
