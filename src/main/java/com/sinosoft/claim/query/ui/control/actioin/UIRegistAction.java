package com.sinosoft.claim.query.ui.control.actioin;

import java.sql.SQLException;
import java.util.Collection;

import com.sinosoft.claim.bl.facade.BLRegistFacade;
import com.sinosoft.claim.dto.custom.CaseRelateNodeDto;
import com.sinosoft.claim.dto.custom.CompensateFeeDto;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.ui.model.PolicyForRegistQueryCommand;
import com.sinosoft.claim.ui.model.PrpLregistFindByConCommand;
import com.sinosoft.claim.ui.model.PrpLregistFindforWorkFlowCommand;
import com.sinosoft.claim.ui.model.RegistCancelSaveCommand;
import com.sinosoft.claim.ui.model.RegistDeleteCommand;
import com.sinosoft.claim.query.ui.model.RegistFindByConCommand;
import com.sinosoft.claim.ui.model.RegistIsExistCommand;
import com.sinosoft.claim.ui.model.RegistQueryCommand;
import com.sinosoft.claim.ui.model.RegistSaveCommand;
import com.sinosoft.claim.ui.model.RelateNodeFindByConCommand;
import com.sinosoft.claim.ui.model.SamePolicyRegistFindByConCommand;
import com.sinosoft.sysframework.common.datatype.PageRecord;
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
public class UIRegistAction
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
   * @return 报案对象
   * @throws Exception
   */
  public RegistDto findByPrimaryKey(String registNo) throws SQLException,UserException,Exception
  {
  	RegistFindByConCommand registFindByConCommand = new RegistFindByConCommand(registNo);
  	RegistDto registDto = (RegistDto)registFindByConCommand.execute();

    if (registDto == null)
    {
      throw new UserException(-98,-1000,this.getClass().getName()+".findByPrimaryKey("+registNo+")");
    }
    return registDto;
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
   * 获得报案信息
   * @param  policyno 保单号
   * @return 报案对象集合
   * @throws Exception
   */

  public Collection findRegistsByPolicyno(String policyno) throws SQLException,Exception
  {
//	  //第一种方法
//	  return new BLRegistFacade().findByPolicyno(policyno);
	  
	  //第二种方法(建议使用第一种方法,将DB层的字段名封装到BL层)
	  String conditions = "policyno = '"+policyno+"' order by reportDate,reportHour";
	  PrpLregistFindByConCommand prpLregistFindByConCommand = new PrpLregistFindByConCommand(conditions);	  
	  return (Collection)prpLregistFindByConCommand.execute();
  }
  
  /**
   * 根据报案号获得该报案的已决未决金额
   * @param registNo
   * @return
 * @throws Exception 
   */
  public CompensateFeeDto getCompensateFeeByRegistNo(String registNo) throws Exception{
	  CompensateFeeDto compensateFeeDto = null;
	  UICodeAction uiCodeAction = new UICodeAction();
	  UICompensateAction uiCompensateAction = new UICompensateAction();
	  //根据报案号获得相应的立案号
	  String claimNo = uiCodeAction.translateBusinessCode(registNo ,true);
//	  if(claimNo!=null&&claimNo.trim().length()>0){
		  compensateFeeDto = uiCompensateAction.findCompensateFeeByClaimNo(claimNo);
//	  }
		  
	  return compensateFeeDto;
  }
  
  /**
   * 获得报案查询信息
   * @param  conditions：查询条件
   * @return 报案对象
   * @throws Exception
   * Add By sunhao 2004-08-24 Reason:增加新的查询条件
   */
   public PageRecord findByQueryConditions(String conditions,String pageNo,String recordPerPage) throws SQLException,Exception
   { 
      RegistQueryCommand registQueryCommand = new RegistQueryCommand(conditions,pageNo,recordPerPage);

      return (PageRecord)registQueryCommand.executeCommand();
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
   * 保存报案注销信息
   * @param RegistDto：报案对象DTO
   * @throws Exception
   */
  public void saveRegistCancel(RegistDto registDto) throws SQLException,Exception
  {
  	RegistCancelSaveCommand registCancelSaveCommand = new RegistCancelSaveCommand(registDto);
  	registCancelSaveCommand.execute();
  }
  
  /**
   * 保存报案注销信息带工作流
   * @param RegistDto：报案对象DTO
   * @param WorkFlowDto：工作流对象DTO
   * @throws Exception
   */
  public void saveRegistCancel(RegistDto registDto,WorkFlowDto workFlowDto) throws SQLException,Exception
  {
  	RegistCancelSaveCommand registCancelSaveCommand = new RegistCancelSaveCommand(registDto,workFlowDto);
  	registCancelSaveCommand.execute();
  }
	/**
	 * 获得点击保单号码,获取合适的报案列表
	 * 国元种植险个性化需求
	 * @param  conditions：查询条件
	 * @return 报案对象
	 * @throws Exception 
	 */
	
	public Collection findForRegistNoConditions(String strPolicyNo) throws SQLException,Exception
	{
		BLRegistFacade blRegistFacade = new BLRegistFacade();
		return blRegistFacade.findForPrpLclaimConditions(strPolicyNo);
	}

}
