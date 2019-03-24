package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLPrpLbackVisitQueFacade��UI Command��<br>
 * ������ 2005-03-23 09:00:29.765<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLbackVisitQueFindByPrimaryKeyCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  ���췽��,����һ��PrpLbackVisitQueFindByPrimaryKeyCommand����
     * @param backVisitID ����backVisitID
     * @param registNo ����registNo
     * @param backVisitType ����backVisitType
     * @param questionCode ����questionCode
     * @throws Exception
     */
    public PrpLbackVisitQueFindByPrimaryKeyCommand(int backVisitID ,String registNo ,String backVisitType ,String questionCode) throws Exception {
    		this.params = new Object[]{new Integer(backVisitID)  ,registNo  ,backVisitType  ,questionCode };
    		this.paramTypes = new Class[]{int.class  ,String.class  ,String.class  ,String.class };
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLPrpLbackVisitQueFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("findByPrimaryKey",paramTypes);
        return method.invoke(object,params);
    }
}
