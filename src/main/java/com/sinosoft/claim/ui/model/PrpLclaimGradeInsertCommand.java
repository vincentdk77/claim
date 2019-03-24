package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.claim.dto.domain.PrpLclaimGradeDto;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLPrpLclaimGradeFacade��UI Command��<br>
 * ������ 2005-04-19 09:24:27.546<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLclaimGradeInsertCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  ���췽��,����һ��PrpLclaimGradeInsertCommand����
     * @param prpLclaimGradeDto ����prpLclaimGradeDto
     * @throws Exception
     */
    public PrpLclaimGradeInsertCommand(PrpLclaimGradeDto prpLclaimGradeDto) throws Exception {
    		this.params = new Object[]{prpLclaimGradeDto };
    		this.paramTypes = new Class[]{PrpLclaimGradeDto.class };
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLPrpLclaimGradeFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("insert",paramTypes);
        return method.invoke(object,params);
    }
}
