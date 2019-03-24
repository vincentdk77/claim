package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.claim.dto.domain.SwfPathLogDto;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����BLSwfPathLogFacade��UI Command��<br>
 * ������ 2004-08-09 19:54:56.418<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class SwfPathLogInsertCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  ���췽��,����һ��SwfPathLogInsertCommand����
     * @param wfPathLogDto ����wfPathLogDto
     * @throws Exception
     */
    public SwfPathLogInsertCommand(SwfPathLogDto swfPathLogDto) throws Exception {
    		this.params = new Object[]{swfPathLogDto };
    		this.paramTypes = new Class[]{SwfPathLogDto.class };
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLSwfPathLogFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("insert",paramTypes);
        return method.invoke(object,params);
    }
}
