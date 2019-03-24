package com.sinosoft.function.power.ui.model;
import com.sinosoft.function.power.bl.facade.BLPowerFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是增加附加权限的(与险组号无关)UI Command类<br>
 * 创建于 2004-11-09 10:40:57.883<br>
 * @author weishixin
 */
public class PowerAddPowerGroupNoCommand extends BaseCommand{
    private String   userCode  ="" ;
    private String   riskCode  ="" ;
    private String   tableName = "" ;
    private String   taskCode  = "" ;
    private String   groupCode = "";
    /**
     *  构造方法,构造一个PrpDriskDeleteByConditionsCommand对象
     * @param conditions 参数conditions
     * @throws Exception
     */
    public PowerAddPowerGroupNoCommand(String userCode,String riskCode,String groupCode,String taskCode,String tableName) throws Exception {
        this.userCode = userCode;
        this.riskCode = riskCode;
        this.tableName = tableName;
        this.taskCode  = taskCode;
        this.groupCode = groupCode;
    }
    /**
     *  执行方法
     *  @see com.sinosoft.sysframework.web.model.Command#executeCommand()
     */
    public Object executeCommand() throws Exception{
        String checkResult = "";
        BLPowerFacade blPowerFacade = new BLPowerFacade();
        checkResult = blPowerFacade.addPower(this.userCode,this.riskCode,this.groupCode,this.taskCode,this.tableName) ;
        return checkResult;
    }
}
