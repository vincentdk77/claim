package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.claim.dto.domain.PrpLrecaseDto;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLPrpLclaimGradeFacade��UI Command��<br>
 * ������ 2005-04-19 09:24:27.562<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLrecaseUpdateCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  ���췽��,����һ��PrpLclaimGradeUpdateCommand����
     * @param prpLclaimGradeDto ����prpLclaimGradeDto
     * @throws Exception
     */
    public PrpLrecaseUpdateCommand(PrpLrecaseDto prpLrecaseDto) throws Exception {
    		this.params = new Object[]{prpLrecaseDto };
    		this.paramTypes = new Class[]{PrpLrecaseDto.class };
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLPrpLrecaseFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("update",paramTypes);
        return method.invoke(object,params);
    }
}
