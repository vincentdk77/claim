package com.sinosoft.function.power.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.function.power.dto.domain.PrpUserGradeDto;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLPrpUserGradeFacade的UI Command类<br>
 * 创建于 2004-11-09 10:41:01.168<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpUserGradeInsertCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  构造方法,构造一个PrpUserGradeInsertCommand对象
     * @param prpUserGradeDto 参数prpUserGradeDto
     * @throws Exception
     */
    public PrpUserGradeInsertCommand(PrpUserGradeDto prpUserGradeDto) throws Exception {
    		this.params = new Object[]{prpUserGradeDto };
    		this.paramTypes = new Class[]{PrpUserGradeDto.class };
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.function.power.bl.facade.BLPrpUserGradeFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("insert",paramTypes);
        return method.invoke(object,params);
    }
}
