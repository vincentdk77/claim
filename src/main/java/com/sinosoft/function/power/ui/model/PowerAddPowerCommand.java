package com.sinosoft.function.power.ui.model;
import com.sinosoft.function.power.bl.facade.BLPowerFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * �������Ӹ���Ȩ�޵�(��������޹�)UI Command��<br>
 * ������ 2004-11-09 10:40:57.883<br>
 * @author weishixin
 */
public class PowerAddPowerCommand extends BaseCommand{
    private String   userCode  ="" ;
    private String   riskCode  ="" ;
    private String   tableName = "" ;
    private String   taskCode  = "" ;
    /**
     *  ���췽��,����һ��PrpDriskDeleteByConditionsCommand����
     * @param conditions ����conditions
     * @throws Exception
     */
    public PowerAddPowerCommand(String userCode,String riskCode,String taskCode,String tableName) throws Exception {
        this.userCode = userCode;
        this.riskCode = riskCode;
        this.tableName = tableName;
        this.taskCode  = taskCode;
    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        String checkResult = "";
        BLPowerFacade blPowerFacade = new BLPowerFacade();
        checkResult = blPowerFacade.addPower(this.userCode,this.riskCode,this.taskCode,this.tableName) ;
        return checkResult;
    }
}
