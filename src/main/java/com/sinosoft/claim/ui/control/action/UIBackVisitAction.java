package com.sinosoft.claim.ui.control.action;


import java.sql.SQLException;
import java.util.Collection;

import com.sinosoft.claim.dto.custom.BackVisitDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.ui.model.BackVisitDeleteCommand;
import com.sinosoft.claim.ui.model.BackVisitFindByPrimaryKeyCommand;
import com.sinosoft.claim.ui.model.BackVisitSaveCommand;
import com.sinosoft.claim.ui.model.PrpLbackVisitGetCountCommand;
import com.sinosoft.claim.ui.model.SwfLogFindByConditionsCommand;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * 回访对象Claim
 * <p>Title: 车险理赔回访action  </p>
 * <p>Description: 车险理赔回访action</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: Sinosoft</p>
 * @author 理赔项目组
 * @version 1.0
 */
public class UIBackVisitAction
{
  /**
   * 保存回访对象
   * @param backVisitDto 回访对象对象DTO
   * @throws Exception
   */
  public void save(BackVisitDto backVisitDto) throws SQLException,Exception
  {
    BackVisitSaveCommand  backVisitSaveCommand = new BackVisitSaveCommand(backVisitDto);
    backVisitSaveCommand.execute();
  }

   /**
   * 保存回访对象带工作流
   * @param backVisitDto：回访对象对象DTO
   * @param workFlowDto
   * @throws Exception
   */
  public void save(BackVisitDto backVisitDto,WorkFlowDto workFlowDto) throws SQLException,Exception
  {
     BackVisitSaveCommand  backVisitSaveCommand = new BackVisitSaveCommand(backVisitDto,workFlowDto);
     backVisitSaveCommand.execute();
  }

  /**
   * 删除回访对象
   * @param backVisitNo
   * @param registNo
   * @param backVisitType
   * @throws Exception
   */
  public void delete(int  backVisitNo,String registNo,String backVisitType) throws SQLException,Exception
  {
    BackVisitDeleteCommand backVisitDeleteCommand = new BackVisitDeleteCommand(backVisitNo,registNo,backVisitType);
    backVisitDeleteCommand.execute();
  }

   /**
   * 删除回访对象(带工作流的)
   * @param backVisitNo
   * @param registNo
   * @param backVisitType
   * @param workFlowDto
   * @throws Exception
   */
  public void delete(int backVisitNo,String registNo,String backVisitType,WorkFlowDto workFlowDto) throws SQLException,Exception
  {
    BackVisitDeleteCommand backVisitDeleteCommand = new BackVisitDeleteCommand(backVisitNo,registNo,backVisitType,workFlowDto);
    backVisitDeleteCommand.execute();
  }

  /**
  * 获得回访对象
  * @param  claimNo：赔案号
  * @return 立案对象
  * @throws Exception
  */
 public BackVisitDto findByPrimaryKey(int backVisitNo,String registNo,String backVisitType) throws SQLException,UserException,Exception
 {
   BackVisitFindByPrimaryKeyCommand backVisitFindByPrimaryKeyCommand = new BackVisitFindByPrimaryKeyCommand(backVisitNo,registNo,backVisitType);
   BackVisitDto backVisitDto = (BackVisitDto)backVisitFindByPrimaryKeyCommand.execute();

   if (backVisitDto == null)
   {
     throw new UserException(-98,-1000,this.getClass().getName()+".findByPrimaryKey("+backVisitNo+","+registNo+","+backVisitType+")");
   }
   return backVisitDto;
 }

 /**
  *取得记录数
  *@param conditions 查询条件
  *@throws SQLException
  *@throws Exception
  */
 public int  getBackVisitCount(String conditions) throws SQLException,Exception 
 {
     Integer backVisitCount = new Integer(0) ;
     PrpLbackVisitGetCountCommand prpLbackVisitGetCountCommand = new PrpLbackVisitGetCountCommand(conditions);
     backVisitCount = (Integer)prpLbackVisitGetCountCommand.execute();
     return backVisitCount.intValue();
 }
 /**
  *取得回访ID号
  *@param conditions 查询条件
  *@throws SQLException
  *@throws Exception
  */

 public int getMaxNo(String conditions) throws Exception
 {
   int intCount = 0;
   intCount = getBackVisitCount(conditions);
   intCount = intCount +1;
   return intCount;
 }
  /**
  * 获得回访信息
  * @param  conditions：查询条件
  * @return 回访对象
  * @throws Exception 
  */

  public Collection findByConditions(String conditions) throws SQLException,Exception
  {
     SwfLogFindByConditionsCommand swfLogFindByConditionsCommand = new SwfLogFindByConditionsCommand(conditions);

     return (Collection)swfLogFindByConditionsCommand.execute();  
  } 
}
