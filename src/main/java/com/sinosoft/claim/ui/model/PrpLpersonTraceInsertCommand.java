package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.claim.dto.domain.PrpLpersonTraceDto;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLPrpLpersonTraceFacade��UI Command��<br>
 * ������ 2005-02-18 10:47:33.843<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLpersonTraceInsertCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  ���췽��,����һ��PrpLpersonTraceInsertCommand����
     * @param prpLpersonTraceDto ����prpLpersonTraceDto
     * @throws Exception
     */
    public PrpLpersonTraceInsertCommand(PrpLpersonTraceDto prpLpersonTraceDto) throws Exception {
    		this.params = new Object[]{prpLpersonTraceDto };
    		this.paramTypes = new Class[]{PrpLpersonTraceDto.class };
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLPrpLpersonTraceFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("insert",paramTypes);
        return method.invoke(object,params);
    }
}
