package com.sinosoft.function.power.ui.model;
import com.sinosoft.function.power.bl.facade.BLPowerFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;


public class PowerFindByTaskCommand extends BaseCommand{
    private String   conditions  ="" ;

    /**
     *  ���췽��,����һ��PowerFindByTaskCommand����
     * @param conditions ����conditions
     * @throws Exception
     */
    public PowerFindByTaskCommand(String conditions) throws Exception {
        this.conditions = conditions;
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        Object object = null;
        BLPowerFacade blPowerFacade = new BLPowerFacade();
        object = blPowerFacade.findByTask(this.conditions ) ;
        return object;
    }
}
