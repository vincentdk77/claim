package com.sinosoft.function.power.ui.action;
import java.util.*;
import com.sinosoft.function.power.ui.model.*;

/**
 * UI层权限校验
 * <p>Title: 理赔UI层权限校验</p>
 * <p>Description: 理赔UI层权限校验</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author weishixin
 * @version 1.0
 */

public class UIPowerAction {
  public UIPowerAction()
  {
  }
  /**
 * 根据外部传入的条件校验是否有权限,险种无关
 * <br>
 * <b>示例: </b>
 * <pre>
 * boolean successFlag = BLPowerFacade.checkPower("0000000000","DAA","01",
 *                        ,"tb",PowerConst.CHECKCODE_READ);
 * </pre>
 * @param  userCode    员工代码
 * @param  riskCode    险种代码
 * @param  groupCode   权限组号
 * @param  taskCode    任务代码
 * @param  checkCode   检验类型
 * @return true/false  true:有权限/false:无权限
 * @throws Exception
 */
  public boolean checkPower(String userCode,String riskCode,String groupCode,String taskCode,String checkCode) throws Exception
  {
     Boolean checkReturn = null;
     PowerCheckPowerCommand powerCheckPowerCommand = new PowerCheckPowerCommand(userCode,riskCode,groupCode,taskCode,checkCode);
     checkReturn = (Boolean)powerCheckPowerCommand.execute() ;
     return checkReturn.booleanValue() ;
  }
 
  /**
   * 根据外部传入的条件校验是否有权限,险种相关
   * <br>
   * <b>示例: </b>
   * <pre>
   * boolean successFlag = BLPowerFacade.checkPower("0000000000","DAA",
   *                        ,"tb",PowerConst.CHECKCODE_READ);
   * </pre>
   * @param  userCode    员工代码
   * @param  riskCode    险种代码
   * @param  taskCode    任务代码
   * @param  checkCode   检验类型
   * @return true/false  true:有权限/false:无权限
   * @throws UserException,Exception
   */

  public boolean checkPower(String userCode,String groupCode,String taskCode,String checkCode) throws Exception
  {
    Boolean checkReturn = null ;
    PowerCheckPowerRiskCommand powerCheckPowerRiskCommand = new PowerCheckPowerRiskCommand(userCode,groupCode,taskCode,checkCode);
     checkReturn = (Boolean)powerCheckPowerRiskCommand.execute() ;
     return checkReturn.booleanValue() ;

  }
  /**
   * 根据外部传入的员工代码+险种代码+任务代码+数据表名获取查询条件附加权限
   * @param  userCode String
   * @param  riskCode String
   * @param  taskCode String
   * @param  tableName String
   * @throws Exception
   * @return String
   */
  public String addPower(String userCode,String riskCode,String taskCode,String tableName) throws Exception
  {
     String powerReturn = null;
     PowerAddPowerCommand powerAddPowerCommand = new PowerAddPowerCommand(userCode,riskCode,taskCode,tableName);
     powerReturn = (String)powerAddPowerCommand.execute() ;
     return powerReturn;
  }
  /**
   * 根据岗位（任务）及险种，部门条件获得某岗位的人员权限
   * @param conditions String  条件
   * @throws Exception
   * @return Collection
   */
  public Collection findByTask(String conditions) throws Exception
  {
     Collection collection = new ArrayList();
     PowerFindByTaskCommand powerFindByTaskCommand = new PowerFindByTaskCommand(conditions);
     collection = (Collection)powerFindByTaskCommand.execute() ;
     return collection;

  }
}
