package com.sinosoft.claim.ui.control.action;
import java.sql.SQLException;
import java.util.Collection;

import com.sinosoft.claim.dto.custom.WorkFlowModelDto;
import com.sinosoft.claim.dto.domain.SwfConditionDto;
import com.sinosoft.claim.dto.domain.SwfModelUseDto;
import com.sinosoft.claim.ui.model.SwfConditionFindByConditionsCommand;
import com.sinosoft.claim.ui.model.SwfConditionInsertCommand;
import com.sinosoft.claim.ui.model.SwfModelMainFindByConditionsCommand;
import com.sinosoft.claim.ui.model.SwfModelUseFindByConditionsCommand;
import com.sinosoft.claim.ui.model.SwfModelUseInsertCommand;
import com.sinosoft.claim.ui.model.WorkFlowModelFindByConditionsCommand;
import com.sinosoft.claim.ui.model.WorkFlowModelFindByPrimaryKeyCommand;
import com.sinosoft.claim.ui.model.WorkFlowModelGetNoCommand;
import com.sinosoft.claim.ui.model.WorkFlowModelInsertCommand;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * 工作流操作逻辑
 * <p>Title: 车险理赔</p>
 * <p>Description: 车险理赔工作流接口程序</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author 项目组
 * @version 1.0
 */
public class UIWorkFlowModelAction
{
  public static String NODESTATUSSUBMIT = "04"; //节点状态 ，提交
  public static String CURRENCYCODE = "CurrencyCode"; //币别
  /**
   * 创建工作流程模板
   * @param formalPars：变量定义和内容
   * @throws Exception
   * @return String
   */
  public void createModel(WorkFlowModelDto workFlowModelDto) throws Exception {
    WorkFlowModelInsertCommand WorkFlowModelInsertCommand = new WorkFlowModelInsertCommand(workFlowModelDto);
    WorkFlowModelInsertCommand.execute() ;
    return ;
  }

  /**
   * 修改工作流程模板
   * @param formalPars：变量定义和内容
   * @throws Exception
   * @return String
   */
  public String updateModel() throws Exception {
    String ModelNo="";
    return ModelNo;
  }


  /**
   * 删除工作流程模板
   * @param formalPars：变量定义和内容
   * @throws Exception
   * @return String
   */
  public String deleteModel() throws Exception {
    String ModelNo="";
    return ModelNo;
  }

  /**
   * 得到模板号
   * @throws Exception
   * @return int
   */
  public int getModelNo() throws Exception
   {
     Integer modelNo = new Integer(0) ;//模板编号
     WorkFlowModelGetNoCommand workFlowModelGetNoCommand = new WorkFlowModelGetNoCommand();
     modelNo = (Integer)workFlowModelGetNoCommand.execute() ;
     return modelNo.intValue() ;
   }

   /**
    * 获得模板信息
    * @param  模板号
    * @return 模板对象
    * @throws Exception
    */
   public WorkFlowModelDto findByPrimaryKey(int modelNo) throws UserException, Exception
   {
           WorkFlowModelFindByPrimaryKeyCommand workFlowModelFindByPrimaryKeyCommand = new WorkFlowModelFindByPrimaryKeyCommand(modelNo);
           WorkFlowModelDto workFlowModelDto = (WorkFlowModelDto)workFlowModelFindByPrimaryKeyCommand.execute();

     if (workFlowModelDto == null)
     {
       throw new UserException(-98,-1000,this.getClass().getName()+".findByPrimaryKey("+modelNo+")");
     }
     return workFlowModelDto;
   }


   /**
   * 获取模板列表
   * @param  conditions：查询条件
   * @return 模板对象
   * @throws Exception
   */

   public Collection findByConditions(String conditions) throws SQLException,Exception
   {
      WorkFlowModelFindByConditionsCommand workFlowModelFindByConditionsCommand = new WorkFlowModelFindByConditionsCommand(conditions);

      return (Collection)workFlowModelFindByConditionsCommand.execute();
   }
   /**
    * 查询模板列表
    * @param conditions String
    * @throws SQLException
    * @throws Exception
    * @return Collection
    */
   public Collection findByModelMainConditions(String conditions) throws SQLException,Exception
   {
     SwfModelMainFindByConditionsCommand  swfModelMainFindByConditionsCommand = new SwfModelMainFindByConditionsCommand(conditions);

     return (Collection)swfModelMainFindByConditionsCommand.execute() ;

   }
   /**
    * 查询模板列表
    * @param conditions String
    * @throws SQLException
    * @throws Exception
    * @return Collection
    */
   public Collection findByWfConditionConditions(String conditions) throws SQLException,Exception
   {
     SwfConditionFindByConditionsCommand  WfConditionFindByConditionsCommand = new SwfConditionFindByConditionsCommand(conditions);

     return (Collection)WfConditionFindByConditionsCommand.execute() ;

   }
   /**
    * 保存模板条件
    * @param wfConditionDto WfConditionDto
    * @throws SQLException
    * @throws Exception
    */
   public void saveWfCondition(SwfConditionDto swfConditionDto) throws SQLException,Exception
   {
      SwfConditionInsertCommand swfConditionInsertCommand = new SwfConditionInsertCommand(swfConditionDto);
      swfConditionInsertCommand.execute() ;
      return ;
   }

   /**
    * 保存模板使用情况信息
    * @param wfModelUseDto WfModelUseDto
    * @throws SQLException
    * @throws Exception
    */
   public void saveWfModelUse(SwfModelUseDto swfModelUseDto) throws SQLException,Exception
   {
      SwfModelUseInsertCommand swfModelUseInsertCommand = new SwfModelUseInsertCommand(swfModelUseDto);
      swfModelUseInsertCommand.execute() ;
      return ;
   }

   /**
    * 查询模板使用情况列表
    * @param conditions String
    * @throws SQLException
    * @throws Exception
    * @return Collection
    */
   public Collection findByModelUseConditions(String conditions) throws SQLException,Exception
   {
     SwfModelUseFindByConditionsCommand  swfModelUseFindByConditionsCommand = new SwfModelUseFindByConditionsCommand(conditions);

     return (Collection)swfModelUseFindByConditionsCommand.execute() ;

   }
   


}
