package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.claim.dto.domain.PrpLcertifyImgDto;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLPrpLcertifyImgFacade的UI Command类<br>
 * 创建于 2005-04-06 09:29:35.125<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class CertifyImgInsertCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  构造方法,构造一个PrpLcertifyImgInsertCommand对象
     * @param prpLcertifyImgDto 参数prpLcertifyImgDto
     * @throws Exception 
     */
    public CertifyImgInsertCommand(PrpLcertifyImgDto prpLcertifyImgDto) throws Exception {
    		this.params = new Object[]{prpLcertifyImgDto };
    		this.paramTypes = new Class[]{PrpLcertifyImgDto.class };
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{ 
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLCertifyImgFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("save",paramTypes);
        return method.invoke(object,params);
    }
}
