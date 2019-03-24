package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.claim.dto.domain.PrpLclaimLossDto;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLPrpLclaimLossFacade��UI Command��<br>
 * ������ 2004-06-24 14:46:42.929<br>
 * JToolpad(1.2.12-RC8) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLclaimLossUpdateCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  ���췽��,����һ��PrpLclaimLossUpdateCommand����
     * @param prpLclaimLossDto ����prpLclaimLossDto
     * @throws Exception
     */
    public PrpLclaimLossUpdateCommand(PrpLclaimLossDto prpLclaimLossDto) throws Exception {
    		this.params = new Object[]{prpLclaimLossDto };
    		this.paramTypes = new Class[]{PrpLclaimLossDto.class };
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLPrpLclaimLossFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("update",paramTypes);
        return method.invoke(object,params);
    }
}
