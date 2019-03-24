package com.sinosoft.function.power.ui.model;
import com.sinosoft.function.power.bl.facade.BLPowerFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * �������Ӹ���Ȩ�޵�(��������޹�)UI Command��<br>
 * ������ 2004-11-09 10:40:57.883<br>
 * @author weishixin
 */
public class PowerGetLocalComCommand extends BaseCommand{
    private String   userCode  ="" ;
    private String   tableName = "" ;
    /**
     *  ���췽��,����һ��PowerGetLocalComCommand����
     * @param conditions ����conditions
     * @throws Exception
     */
    public PowerGetLocalComCommand(String userCode,String tableName) throws Exception {
        this.userCode = userCode;
        this.tableName = tableName;
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        String conditions = "";
        BLPowerFacade blPowerFacade = new BLPowerFacade();
        conditions = blPowerFacade.getLocalCom(this.userCode,this.tableName) ;
        return conditions;
    }
}
