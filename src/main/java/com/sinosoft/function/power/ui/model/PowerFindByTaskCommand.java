package com.sinosoft.function.power.ui.model;
import com.sinosoft.function.power.bl.facade.BLPowerFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;


public class PowerFindByTaskCommand extends BaseCommand{
    private String   conditions  ="" ;

    /**
     *  构造方法,构造一个PowerFindByTaskCommand对象
     * @param conditions 参数conditions
     * @throws Exception
     */
    public PowerFindByTaskCommand(String conditions) throws Exception {
        this.conditions = conditions;
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Object object = null;
        BLPowerFacade blPowerFacade = new BLPowerFacade();
        object = blPowerFacade.findByTask(this.conditions ) ;
        return object;
    }
}
