package com.sinosoft.function.power.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.function.power.dto.domain.PrpGrantDto;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLPrpGrantFacade��UI Command��<br>
 * ������ 2004-11-09 10:40:57.903<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpGrantInsertCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  ���췽��,����һ��PrpGrantInsertCommand����
     * @param prpGrantDto ����prpGrantDto
     * @throws Exception
     */
    public PrpGrantInsertCommand(PrpGrantDto prpGrantDto) throws Exception {
    		this.params = new Object[]{prpGrantDto };
    		this.paramTypes = new Class[]{PrpGrantDto.class };
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.function.power.bl.facade.BLPrpGrantFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("insert",paramTypes);
        return method.invoke(object,params);
    }
}
