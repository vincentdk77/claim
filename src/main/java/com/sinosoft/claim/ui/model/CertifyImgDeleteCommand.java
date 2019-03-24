package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.claim.dto.domain.PrpLcertifyImgDto;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLPrpLcertifyImgFacade��UI Command��<br>
 * ������ 2005-04-06 09:29:35.140<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class CertifyImgDeleteCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  ���췽��,����һ��PrpLcertifyImgDeleteCommand����
     * @param businessNo ����businessNo
     * @param serialNo ����serialNo
     * @param lossItemCode ����lossItemCode
     * @throws Exception
     */
    public CertifyImgDeleteCommand(PrpLcertifyImgDto prpLcertifyImgDto ) throws Exception {
    		this.params = new Object[]{prpLcertifyImgDto  };
    		this.paramTypes = new Class[]{PrpLcertifyImgDto.class};
    }
    /** 
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLCertifyImgFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("delete",paramTypes);
        return method.invoke(object,params);
    }
}
