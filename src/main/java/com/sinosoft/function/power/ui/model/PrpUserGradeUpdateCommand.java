package com.sinosoft.function.power.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.function.power.dto.domain.PrpUserGradeDto;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLPrpUserGradeFacade��UI Command��<br>
 * ������ 2004-11-09 10:41:01.208<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpUserGradeUpdateCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  ���췽��,����һ��PrpUserGradeUpdateCommand����
     * @param prpUserGradeDto ����prpUserGradeDto
     * @throws Exception
     */
    public PrpUserGradeUpdateCommand(PrpUserGradeDto prpUserGradeDto) throws Exception {
    		this.params = new Object[]{prpUserGradeDto };
    		this.paramTypes = new Class[]{PrpUserGradeDto.class };
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.function.power.bl.facade.BLPrpUserGradeFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("update",paramTypes);
        return method.invoke(object,params);
    }
}
