package com.sinosoft.function.power.ui.model;
import com.sinosoft.function.power.bl.facade.BLPowerFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是增加附加权限的(与险组号无关)UI Command类<br>
 * 创建于 2004-11-09 10:40:57.883<br>
 * @author weishixin
 */
public class PowerGetLocalComCommand extends BaseCommand{
    private String   userCode  ="" ;
    private String   tableName = "" ;
    /**
     *  构造方法,构造一个PowerGetLocalComCommand对象
     * @param conditions 参数conditions
     * @throws Exception
     */
    public PowerGetLocalComCommand(String userCode,String tableName) throws Exception {
        this.userCode = userCode;
        this.tableName = tableName;
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        String conditions = "";
        BLPowerFacade blPowerFacade = new BLPowerFacade();
        conditions = blPowerFacade.getLocalCom(this.userCode,this.tableName) ;
        return conditions;
    }
}
