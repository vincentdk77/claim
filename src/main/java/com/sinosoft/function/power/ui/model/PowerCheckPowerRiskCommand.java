package com.sinosoft.function.power.ui.model;

import com.sinosoft.function.power.bl.facade.BLPowerFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * ����CheckPowerȨ�޵�(�������й�)UI Command��<br>
 * ������ 2004-11-09 10:40:57.883<br>
 * @author weishixin
 */
public class PowerCheckPowerRiskCommand extends BaseCommand{
    private String   userCode  ="" ;
    private String   groupCode = "" ;
    private String   taskCode  = "" ;
    private String   checkCode = "" ;
    /**
     *  ���췽��,����һ��PrpDriskDeleteByConditionsCommand����
     * @param conditions ����conditions
     * @throws Exception
     */
    public PowerCheckPowerRiskCommand(String userCode,String groupCode,String taskCode,String checkCode) throws Exception {
        this.userCode = userCode;
        this.groupCode = groupCode;
        this.taskCode  = taskCode;
        this.checkCode = checkCode;

    }
    /**
     *  ִ�з���
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        boolean checkResult = false;
        BLPowerFacade blPowerFacade = new BLPowerFacade();
        checkResult = blPowerFacade.checkPower(this.userCode,this.groupCode,this.taskCode,this.checkCode) ;
        return new Boolean(checkResult);
    }
}
