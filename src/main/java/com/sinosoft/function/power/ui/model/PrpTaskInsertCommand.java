package com.sinosoft.function.power.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.function.power.dto.domain.PrpTaskDto;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLPrpTaskFacade��UI Command��<br>
 * ������ 2004-11-09 10:41:01.028<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpTaskInsertCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  ���췽��,����һ��PrpTaskInsertCommand����
     * @param prpTaskDto ����prpTaskDto
     * @throws Exception
     */
    public PrpTaskInsertCommand(PrpTaskDto prpTaskDto) throws Exception {
    		this.params = new Object[]{prpTaskDto };
    		this.paramTypes = new Class[]{PrpTaskDto.class };
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.function.power.bl.facade.BLPrpTaskFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("insert",paramTypes);
        return method.invoke(object,params);
    }
}
