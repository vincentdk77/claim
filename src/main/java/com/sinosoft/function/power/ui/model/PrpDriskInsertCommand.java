package com.sinosoft.function.power.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.function.power.dto.domain.PrpDriskDto;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLPrpDriskFacade��UI Command��<br>
 * ������ 2004-11-09 10:40:57.883<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDriskInsertCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  ���췽��,����һ��PrpDriskInsertCommand����
     * @param prpDriskDto ����prpDriskDto
     * @throws Exception
     */
    public PrpDriskInsertCommand(PrpDriskDto prpDriskDto) throws Exception {
    		this.params = new Object[]{prpDriskDto };
    		this.paramTypes = new Class[]{PrpDriskDto.class };
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.function.power.bl.facade.BLPrpDriskFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("insert",paramTypes);
        return method.invoke(object,params);
    }
}
