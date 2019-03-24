package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLPrpLbackVisitTextFacade��UI Command��<br>
 * ������ 2005-03-23 09:00:42.640<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLbackVisitTextFindByPrimaryKeyCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  ���췽��,����һ��PrpLbackVisitTextFindByPrimaryKeyCommand����
     * @param backVisitID ����backVisitID
     * @param registNo ����registNo
     * @param backVisitType ����backVisitType
     * @param lineNo ����lineNo
     * @throws Exception
     */
    public PrpLbackVisitTextFindByPrimaryKeyCommand(int backVisitID ,String registNo ,String backVisitType ,int lineNo) throws Exception {
    		this.params = new Object[]{new Integer(backVisitID)  ,registNo  ,backVisitType  ,new Integer(lineNo) };
    		this.paramTypes = new Class[]{int.class  ,String.class  ,String.class  ,int.class };
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLPrpLbackVisitTextFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("findByPrimaryKey",paramTypes);
        return method.invoke(object,params);
    }
}
