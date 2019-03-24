package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.claim.dto.domain.PrpLregistExtDto;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLPrpLregistExtFacade��UI Command��<br>
 * ������ 2005-03-11 11:11:52.531<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLregistExtInsertCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  ���췽��,����һ��PrpLregistExtInsertCommand����
     * @param prpLregistExtDto ����prpLregistExtDto
     * @throws Exception
     */
    public PrpLregistExtInsertCommand(PrpLregistExtDto prpLregistExtDto) throws Exception {
    		this.params = new Object[]{prpLregistExtDto };
    		this.paramTypes = new Class[]{PrpLregistExtDto.class };
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLPrpLregistExtFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("insert",paramTypes);
        return method.invoke(object,params);
    }
}
