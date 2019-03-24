package com.sinosoft.claim.ui.control.action;

import java.sql.SQLException;
import java.util.Collection;

import com.sinosoft.claim.dto.custom.AcciCheckDto;
import com.sinosoft.claim.dto.custom.CaseRelateNodeDto;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.ui.model.AcciCheckFindByConCommand;
import com.sinosoft.claim.ui.model.PrpLacciCheckFindByConditionsCommand;
import com.sinosoft.claim.ui.model.PrpLregistFindByConCommand;
import com.sinosoft.claim.ui.model.PrpLregistFindforWorkFlowCommand;
import com.sinosoft.claim.ui.model.RegistDeleteCommand;
import com.sinosoft.claim.ui.model.RegistIsExistCommand;
import com.sinosoft.claim.ui.model.RegistQueryCommand;
import com.sinosoft.claim.ui.model.RegistSaveCommand;
import com.sinosoft.claim.ui.model.RelateNodeFindByConCommand;
import com.sinosoft.claim.ui.model.SamePolicyRegistFindByConCommand;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * 报案对象Regist
 * <p>Title: 车险理赔样本报案action  </p>
 * <p>Description: 车险理赔样本报案action</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author weishixin
 * @version 1.0
 */
public class UIAcciCheckAction
{
  /**
   * 保存报案
   * @param RegistDto：报案对象DTO
   * @throws Exception
   */
  public void save(RegistDto registDto) throws SQLException,Exception
  {
  	RegistSaveCommand registSaveCommand = new RegistSaveCommand(registDto);
  	registSaveCommand.execute();
  }


   /**
   * 保存报案带工作流
   * @param RegistDto：报案对象DTO
   * @throws Exception
   */
  public void save(RegistDto registDto,WorkFlowDto workFlowDto) throws SQLException,Exception
  {
  	RegistSaveCommand registSaveCommand = new RegistSaveCommand(registDto,workFlowDto);
  	registSaveCommand.execute();
  }
  /**
   * 删除报案
   * @param registNo：报案号
   * @throws Exception
   */
  public void delete(String registNo) throws SQLException,Exception
  {
    RegistDeleteCommand registDeleteCommand = new RegistDeleteCommand(registNo);
  	registDeleteCommand.execute();
  }

  /**
   * 获得报案信息
   * @param  registNo：报案号
   * @return 意键险调查对象
   * @throws Exception
   */
  public AcciCheckDto findByPrimaryKey(String registNo) throws SQLException,UserException,Exception
  {
  	AcciCheckFindByConCommand acciCheckFindByConCommand = new AcciCheckFindByConCommand(registNo);
  	AcciCheckDto acciCheckDto = (AcciCheckDto)acciCheckFindByConCommand.execute();

    if (acciCheckDto == null)
    {
      throw new UserException(-98,-1000,this.getClass().getName()+".findByPrimaryKey("+registNo+")");
    }
    return acciCheckDto;
  }

  /**
   * 判断报案号是否存在
   * @param registNo:报案号
   * @return 是/否
   * @throws Exception
   */
  public boolean isExist(String registNo) throws SQLException,Exception
  {
  	RegistIsExistCommand registIsExistCommand = new RegistIsExistCommand(registNo);
  	return ((Boolean)registIsExistCommand.execute()).booleanValue();
  }
  /**
  * 获得报案信息
  * @param  conditions：查询条件
  * @return 报案对象
  * @throws Exception
  */

  public Collection findByConditions(String conditions) throws SQLException,Exception
  {
     PrpLregistFindByConCommand prpLregistFindByConCommand = new PrpLregistFindByConCommand(conditions);

     return (Collection)prpLregistFindByConCommand.execute();
  }

  /**
  * 获得报案查询信息
  * @param  conditions：查询条件
  * @return 报案对象
  * @throws Exception
  * Add By sunhao 2004-08-24 Reason:增加新的查询条件
  */

  public Collection findByQueryConditions(String conditions) throws SQLException,Exception
  {
     RegistQueryCommand registQueryCommand = new RegistQueryCommand(conditions);

     return (Collection)registQueryCommand.executeCommand();
  }

  public Collection findSamePolicyRegist(String policyNo) throws Exception {
    String conditions = " prplregist.policyNo ='" + policyNo + "' order by registNo";

    SamePolicyRegistFindByConCommand SamePolicyRegistFindByConCommand = new
        SamePolicyRegistFindByConCommand(conditions);

    return (Collection) SamePolicyRegistFindByConCommand.execute();
  }
  /**
  * 获得报案信息
  * @param  conditions：查询条件
  * @return 报案对象
  * @throws Exception
  */
  public Collection getWorkFlowList(String conditions) throws SQLException,Exception
  {
     PrpLregistFindforWorkFlowCommand prpLregistFindforWorkFlowCommand = new PrpLregistFindforWorkFlowCommand(conditions);

     return (Collection)prpLregistFindforWorkFlowCommand.execute();
  }
  /**
   * 获得相关的节点信息
   * @param  registNo：报案号
   * @return 报案对象
   * @throws Exception
   */
  public CaseRelateNodeDto relateNode(String registNo) throws SQLException,UserException,Exception
  {
    RelateNodeFindByConCommand relateNodeFindByConCommand = new RelateNodeFindByConCommand(registNo);
    CaseRelateNodeDto caseRelateNodeDto = (CaseRelateNodeDto)relateNodeFindByConCommand.execute();
    return caseRelateNodeDto;
  }
  
  /**
   * 获得一个案件的所有调查信息(意健险独有的方法)
   * @param conditions 查询条件
   * @return 调查表对象集合
   * @throws Exception
   * */
  public Collection findByConditionsAcciCheck(String conditions) throws SQLException, Exception {
  	  PrpLacciCheckFindByConditionsCommand prpLacciCheckFindConditionsCommand = new PrpLacciCheckFindByConditionsCommand(conditions);
  	  return (Collection) prpLacciCheckFindConditionsCommand.executeCommand();
  }

}
