package com.sinosoft.claimzy.ui.model;

import java.io.*;
import java.util.*;
import java.lang.reflect.Method;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.claim.dto.domain.*;
import com.sinosoft.claimzy.dto.domain.AgriClaimUploadLogDto;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是BLAGRICLAIMUPLOADLOGFacade的UI Command类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class AgriClaimUploadLogInsertCommand extends BaseCommand{
    private Class[] paramTypes;
    private Object[] params;
    /**
     *  构造方法,构造一个AGRICLAIMUPLOADLOGInsertCommand对象
     * @param aGRICLAIMUPLOADLOGDto 参数aGRICLAIMUPLOADLOGDto
     * @throws Exception
     */
    public AgriClaimUploadLogInsertCommand(AgriClaimUploadLogDto agriClaimUploadLogDto)
            throws Exception{
    		this.params = new Object[]{agriClaimUploadLogDto };
    		this.paramTypes = new Class[]{AgriClaimUploadLogDto.class };
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Thread.currentThread().setContextClassLoader(myClassLoader);
        Class loaderClass = myClassLoader.loadClass("com.sinosoft.claimzy.bl.facade.BLAgriClaimUploadLogFacade");
        Object object = loaderClass.newInstance();
        Method method = loaderClass.getMethod("insert",paramTypes);
        return method.invoke(object,params);
    }
}
