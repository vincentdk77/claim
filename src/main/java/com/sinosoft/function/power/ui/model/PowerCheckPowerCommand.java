package com.sinosoft.function.power.ui.model;

import com.sinosoft.function.power.bl.facade.BLPowerFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是CheckPower权限的(与险种无关)UI Command类<br>
 * 创建于 2004-11-09 10:40:57.883<br>
 * @author weishixin
 */
public class PowerCheckPowerCommand extends BaseCommand{
    private String   userCode  ="" ;
    private String   riskCode  ="" ;
    private String   groupCode = "" ;
    private String   taskCode  = "" ;
    private String   checkCode = "" ;
    /**
     *  构造方法,构造一个PrpDriskDeleteByConditionsCommand对象
     * @param conditions 参数conditions
     * @throws Exception
     */
    public PowerCheckPowerCommand(String userCode,String riskCode,String groupCode,String taskCode,String checkCode) throws Exception {
        this.userCode = userCode;
        this.riskCode = riskCode;
        this.groupCode = groupCode;
        this.taskCode  = taskCode;
        this.checkCode = checkCode;

    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        boolean checkResult = false;
        BLPowerFacade blPowerFacade = new BLPowerFacade();
        checkResult = blPowerFacade.checkPower(this.userCode,this.riskCode,this.groupCode,this.taskCode,this.checkCode) ;
        return new Boolean(checkResult);
    }
}
