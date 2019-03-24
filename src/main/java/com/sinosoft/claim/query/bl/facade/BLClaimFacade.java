package com.sinosoft.claim.query.bl.facade;

import java.sql.SQLException;
import java.util.*;

import com.sinosoft.reins.out.bl.facade.BLPrpLdangerUnitFacade;
import com.sinosoft.reins.out.bl.facade.BLPrpLreinsTrialFacade;
import com.sinosoft.reins.out.bl.facade.BLRepayFacade;
import com.sinosoft.reins.out.dto.domain.PrpLdangerUnitDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.*;
import com.sinosoft.claim.bl.action.custom.BLClaimAction;
import com.sinosoft.claim.dto.custom.ClaimDto;
import com.sinosoft.claim.dto.domain.PrpCmainDto;
import com.sinosoft.claim.dto.domain.PrpLclaimLossDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.bl.action.domain.BLPrpCmainAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLclaimAction;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.query.util.Constant;
import com.sinosoft.claim.ui.control.action.UIReinsTrialAction;
import com.sinosoft.claim.bl.action.custom.BLWorkFlowAction;

/**
 *  立案逻辑分发
 * <p>Title: 车险理赔立案</p>
 * <p>Description: 车险理赔立案facade</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author lijiyuan
 * @version 1.0
 */
public class BLClaimFacade
{
  /**
   * 保存立案
   * @param claimDto：自定义立案对象
   * @throws SQLException
   * @throws Exception
   */
  public void save(ClaimDto claimDto) throws SQLException,Exception
  {
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //开始事务
    dbManager.beginTransaction();
    try
    {
      new BLClaimAction().save(dbManager,claimDto);
      //提交事务
      dbManager.commitTransaction();
    }
    catch(SQLException sqle)
    {
      //回滚事务
      dbManager.rollbackTransaction();
      throw sqle;
    }
    catch(Exception ex)
    {
      //回滚事务
      dbManager.rollbackTransaction();
      throw ex;
    }
    finally
    {
      //关闭数据库连接
      dbManager.close();
    }
  }
  /**
   * 保存立案带工作流
   * @param claimDto：自定义立案对象
   * @throws SQLException
   * @throws Exception
   */
  public void save(ClaimDto claimDto,WorkFlowDto workFlowDto) throws SQLException,Exception
  {
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //开始事务
    dbManager.beginTransaction();
    try
    {
      new BLClaimAction().save(dbManager,claimDto);
      if(workFlowDto!=null){
        new BLWorkFlowAction().deal(dbManager,workFlowDto);
      }
      //提交事务
      dbManager.commitTransaction();
    }
    catch(SQLException sqle)
    {
      //回滚事务
      dbManager.rollbackTransaction();
      throw sqle;
    }
    catch(Exception ex)
    {
      //回滚事务
      dbManager.rollbackTransaction();
      throw ex;
    }
    finally
    {
      //关闭数据库连接
      dbManager.close();
    }
  }
  /**
   * 保存立案带工作流
   * @param claimDto：自定义立案对象
   * @throws SQLException
   * @throws Exception
   */
  public void save(ArrayList claimDtoList,ArrayList workFlowDtoList,String comCode,String userCode) throws SQLException,Exception
  {
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //开始事务
    dbManager.beginTransaction();
    try
    {for(int i=0;i<claimDtoList.size();i++){
    	ClaimDto claimDto = (ClaimDto)claimDtoList.get(i);
      new BLClaimAction().save(dbManager,claimDto);
      Collection dangerTrial = new BLPrpLreinsTrialFacade().findByConditions("certiNo = '" + claimDto.getPrpLclaimDto().getClaimNo() + "'");
  	//如果没有分摊试算，首先进行分摊试算
  	if (dangerTrial == null || dangerTrial.size() == 0) {
  		new UIReinsTrialAction().simulateRepayByDangerNo(claimDto.getPrpLclaimDto().getClaimNo(),claimDto.getPrpLclaimDto().getClaimNo());
  	}
  	Collection dangerUnit = new BLPrpLdangerUnitFacade().findByConditions("certiNo = '" + claimDto.getPrpLclaimDto().getClaimNo() + "'");
  	if (dangerUnit != null) {
  		Iterator iter = dangerUnit.iterator();
  		while (iter.hasNext()) {
  			PrpLdangerUnitDto prpLdangerUnitDto = (PrpLdangerUnitDto) iter.next();
  			 String newRepayNo = new BLRepayFacade().genRepay(
  					claimDto.getPrpLclaimDto().getClaimNo(), 
  					prpLdangerUnitDto.getDangerNo(),
  					comCode, 
  					userCode,
  					0
  					);
  			if (!newRepayNo.equals("")) {
  				new BLRepayFacade().checkRepay(newRepayNo, userCode);
  			}
  		}
      }
    }
    for(int i=0;i<workFlowDtoList.size();i++){
      if(workFlowDtoList.get(i)!=null){
        new BLWorkFlowAction().deal(dbManager,(WorkFlowDto)workFlowDtoList.get(i));}
      }

	 //add by dongyanqi end 20050827生成分赔案
      //提交事务
      dbManager.commitTransaction();
    }
    catch(SQLException sqle)
    {
      //回滚事务
      dbManager.rollbackTransaction();
      throw sqle;
    }
    catch(Exception ex)
    {
      //回滚事务
      dbManager.rollbackTransaction();
      throw ex;
    }
    finally
    {
      //关闭数据库连接
      dbManager.close();
    }
  }

  /**
   * 删除立案
   * @param  claimNo
   * @param dbManager  数据连接
   * @throws SQLException
   * @throws Exception
   */
  public void delete(String claimNo) throws SQLException,Exception
  {
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //开始事务
    dbManager.beginTransaction();
    try
    {
      new BLClaimAction().delete(dbManager,claimNo);
      //提交事务
      dbManager.commitTransaction();
    }
    catch(SQLException sqle)
    {
      //回滚事务
      dbManager.rollbackTransaction();
      throw sqle;
    }
    catch(Exception ex)
    {
      //回滚事务
      dbManager.rollbackTransaction();
      throw ex;
    }
    finally
    {
      //关闭数据库连接
      dbManager.close();
    }

  }

  /**
   * 删除立案(带删除工作流节点)
   * @param  claimNo
   * @param dbManager  数据连接
   * @throws SQLException
   * @throws Exception
   */
  public void delete(String claimNo, WorkFlowDto workFlowDto) throws SQLException,Exception
  {
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //开始事务
    dbManager.beginTransaction();
    try
    {
      new BLClaimAction().delete(dbManager,claimNo);
      //如果删除的话，会有其他问题
      new BLWorkFlowAction().deal(dbManager,workFlowDto);
      //提交事务
      dbManager.commitTransaction();
    }
    catch(SQLException sqle)
    {
      //回滚事务
      dbManager.rollbackTransaction();
      throw sqle;
    }
    catch(Exception ex)
    {
      //回滚事务
      dbManager.rollbackTransaction();
      throw ex;
    }
    finally
    {
      //关闭数据库连接
      dbManager.close();
    }

  }

  /**
   * 获得立案
   * @param  claimNo
   * @param dbManager  数据连接
   * @return 自定义立案对象
   * @throws SQLException
   * @throws Exception
   */
  public ClaimDto findByPrimaryKey(String claimNo) throws SQLException,Exception
  {
    ClaimDto claimDto = null;
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    //dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    dbManager.open(Constant.QUERY_DATA_SOURCE) ;
    try
    {
      claimDto = new BLClaimAction().findByPrimaryKey(dbManager,claimNo);
    }
    catch(SQLException sqle)
    {
      throw sqle;
    }
    catch(Exception ex)
    {
      throw ex;
    }
    finally
    {
      //关闭数据库连接
      dbManager.close();
    }
    return claimDto;
  }

  /**
   * 判断立案通知号是否存在
   * @param claimNo
   * @param dbManager  数据连接
   * @return 是/否
   * @throws SQLException
   * @throws Exception
   */
  public boolean isExist(String claimNo) throws SQLException,Exception
  {

    boolean exist = false ;
    //创建数据库管理对象
     DBManager dbManager = new DBManager();
     dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    try
    {
      exist = new BLClaimAction().isExist(dbManager,claimNo);
    }
    catch(SQLException sqle)
    {
      throw sqle;
    }
    catch(Exception ex)
    {
      throw ex;
    }
    finally
    {
      //关闭数据库连接
      dbManager.close();
    }
    return exist;
  }
  //public Collection findByConditions(String conditions) throws Exception
  //{
     //return new BLClaimAction().findByConditions(conditions);
  //}
  /**
     * 根据条件查询报案主表信息
     * @param conditions String
     * @throws Exception
     * @return Collection
     */
    public Collection findByConditions(String conditions) throws Exception
    {
       DBManager dbManager = new DBManager();
       Collection claimList = new ArrayList();
       try
       {
         //dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    	   dbManager.open(Constant.QUERY_DATA_SOURCE) ;
         BLPrpLclaimAction blPrpLclaimAction = new BLPrpLclaimAction();
         claimList = (Collection)blPrpLclaimAction.findByConditions(dbManager,conditions);
       }
       catch(SQLException sqle)
       {
         throw sqle;
       }
       catch (Exception ex) {
         throw ex;
       }
       finally
       {
         dbManager.close();
       }
       return claimList;
    }

  /**
   * 根据条件查询报案主表信息
   * @param conditions String
   * @throws Exception
   * @return Collection
   * Add By sunhao 2004-08-24 Reason:增加新的查询方法
   */
  public Collection findByQueryConditions(String conditions) throws Exception
  {
     DBManager dbManager = new DBManager();
     Collection claimList = new ArrayList();
     try
     {

       dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
      // BLPrpLregistAction blPrpLregistAction = new BLPrpLregistAction();
       BLClaimAction blClaimAction = new BLClaimAction();
       claimList = (Collection)blClaimAction.findByQueryConditions(dbManager,conditions,0,0);
     }
     catch(SQLException sqle)
     {
       throw sqle;
     }
     catch (Exception ex) {
       throw ex;
     }
     finally
     {
       dbManager.close();
     }
     return claimList;
  }

  /**
   * 取得估损金额
   * @param  claimNo
   * @param dbManager  数据连接
   * @throws SQLException
   * @throws Exception
   */
  public PrpLclaimLossDto getClaimLoss(String claimNo) throws SQLException,Exception
  {
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    PrpLclaimLossDto prpLclaimLossDto = new PrpLclaimLossDto();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //开始事务
    dbManager.beginTransaction();
    try
    {
      prpLclaimLossDto = new BLClaimAction().getClaimLoss(dbManager,claimNo);
      //提交事务
      dbManager.commitTransaction();
    }
    catch(SQLException sqle)
    {
      //回滚事务
      dbManager.rollbackTransaction();
      throw sqle;
    }
    catch(Exception ex)
    {
      //回滚事务
      dbManager.rollbackTransaction();
      throw ex;
    }
    finally
    {
      //关闭数据库连接
      dbManager.close();
    }
    return prpLclaimLossDto;
  }

  /**
   * 根据条件取得未决查询列表
   *@param iWherePart 查询条件(不包括排序字句)
   *@param iOtherWherePart 附加查询条件
   *@throws UserException
   *@throws Exception
  */
  public Collection getNoEndCaseClaim(String iWherePart,String iOtherWherePart) throws Exception
  {
     DBManager dbManager = new DBManager();
     Collection noEndCaseClaimList = new ArrayList();
     try
     {

       dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
       BLClaimAction blClaimAction = new BLClaimAction();
       noEndCaseClaimList = (Collection)blClaimAction.getNoEndCaseClaim(dbManager,iWherePart,iOtherWherePart);
     }
     catch(SQLException sqle)
     {
       throw sqle;
     }
     catch (Exception ex) {
       throw ex;
     }
     finally
     {
       dbManager.close();
     }
     return noEndCaseClaimList;
  }

 /**
   * 根据条件取得已决查询列表
   *@param iWherePart 查询条件(不包括排序字句)
   *@throws UserException
   *@throws Exception
  */
  public Collection querySumEndCase(String iWherePart) throws Exception
  {
     DBManager dbManager = new DBManager();
     Collection EndCaseClaimList = new ArrayList();
     try
     {

       dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
       BLClaimAction blClaimAction = new BLClaimAction();
       EndCaseClaimList = (Collection)blClaimAction.querySumEndCase(dbManager,iWherePart);
     }
     catch(SQLException sqle)
     {
       throw sqle;
     }
     catch (Exception ex) {
       throw ex;
     }
     finally
     {
       dbManager.close();
     }
     return EndCaseClaimList;
  }


  /**
   * 根据条件取得已决查询列表详细清单
   *@param iWherePart 查询条件(不包括排序字句)
   *@throws UserException
   *@throws Exception
  */
  public Collection querySumEndCaseDetail(String iWherePart) throws Exception
  {
     DBManager dbManager = new DBManager();
     Collection EndCaseClaimList = new ArrayList();
     try
     {

       dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
       BLClaimAction blClaimAction = new BLClaimAction();
       EndCaseClaimList = (Collection)blClaimAction.querySumEndCaseDetail(dbManager,iWherePart);
     }
     catch(SQLException sqle)
     {
       throw sqle;
     }
     catch (Exception ex) {
       throw ex;
     }
     finally
     {
       dbManager.close();
     }
     return EndCaseClaimList;
  }


    /**
     * @param claimNo
   * @param dbManager  数据连接
   * @return 是/否
   * @throws SQLException
   * @throws Exception
   */
  public void UpdCaseType(String claimNo) throws SQLException,Exception
  {

    //创建数据库管理对象
     DBManager dbManager = new DBManager();
     dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    try
    {
      new BLClaimAction().UpdCaseType(dbManager,claimNo);
    }
    catch(SQLException sqle)
    {
      throw sqle;
    }
    catch(Exception ex)
    {
      throw ex;
    }
    finally
    {
      //关闭数据库连接
      dbManager.close();
    }
}


  public void UpdSumClaim(ClaimDto claimDto,String claimNo,double sumClaim) throws SQLException,Exception
  {

    //创建数据库管理对象
     DBManager dbManager = new DBManager();
     dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    try
    {
      new BLClaimAction().UpdSumClaim(dbManager,claimDto, claimNo,sumClaim);
    }
    catch(SQLException sqle)
    {
      throw sqle;
    }
    catch(Exception ex)
    {
      throw ex;
    }
    finally
    {
      //关闭数据库连接
      dbManager.close();
    }
   }
  
  public Object findByPolicyNo(String policyNo) throws SQLException, Exception {
  	 Object prpClaimDtoList = null;
     //创建数据库管理对象
     DBManager dbManager = new DBManager();
     dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
     try
     {
     	prpClaimDtoList = new BLClaimAction().findByPolicyNo(dbManager,policyNo);
     }
     catch(SQLException sqle)
     {
       throw sqle;
     }
     catch(Exception ex)
     {
       throw ex;
     }
     finally
     {
       //关闭数据库连接
       dbManager.close();
     }
     return prpClaimDtoList;
  }
  
  public Object findByPolicyNo(String policyNo,String idcard) throws SQLException, Exception {
	  	 Object prpClaimDtoList = null;
	     //创建数据库管理对象
	     DBManager dbManager = new DBManager();
	     dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
	     try
	     {
	     	prpClaimDtoList = new BLClaimAction().findByPolicyNo(dbManager,policyNo,idcard);
	     }
	     catch(SQLException sqle)
	     {
	       throw sqle;
	     }
	     catch(Exception ex)
	     {
	       throw ex;
	     }
	     finally
	     {
	       //关闭数据库连接
	       dbManager.close();
	     }
	     return prpClaimDtoList;
	  }
	
  
  public PrpCmainDto findByPolicyNoKey(String policyNo) throws SQLException, Exception {
  	 PrpCmainDto prpCmainDto = null;
  	 DBManager dbManager = new DBManager();
     dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
     try
     {
     	prpCmainDto = new BLPrpCmainAction().findByPrimaryKey(dbManager,policyNo);
     }
     catch(SQLException sqle)
     {
       throw sqle;
     }
     catch(Exception ex)
     {
       throw ex;
     }
     finally
     {
       //关闭数据库连接
       dbManager.close();
     }
     return prpCmainDto;
  }
  
 //modify by liuyanmei add 20051102 start 
  public void updateEndCaseDate(String claimNo,Date endCaseDate) throws SQLException,Exception
  {
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //开始事务
    dbManager.beginTransaction();
    try
    {
      new BLClaimAction().updateEndCaseDate(dbManager,claimNo,endCaseDate);
      //提交事务
      dbManager.commitTransaction();
    }
    catch(SQLException sqle)
    {
      //回滚事务
      dbManager.rollbackTransaction();
      throw sqle;
    }
    catch(Exception ex)
    {
      //回滚事务
      dbManager.rollbackTransaction();
      throw ex;
    }
    finally
    {
      //关闭数据库连接
      dbManager.close();
    }

  }
  
  //modify by liuyanmei add 20051102 end 
  
  
  //add by zhaolu 20060802 start
  
  public PageRecord findByQueryConditions(String conditions,int pageNo,int recordPerPage) throws Exception
  {
     DBManager dbManager = new DBManager();
     PageRecord pageRecord = null;
     try
     {

       dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
      // BLPrpLregistAction blPrpLregistAction = new BLPrpLregistAction();
       BLClaimAction blClaimAction = new BLClaimAction();
       pageRecord = (PageRecord)blClaimAction.findByConditions(dbManager,conditions,pageNo,recordPerPage);
     }
     catch(SQLException sqle)
     {
       throw sqle;
     }
     catch (Exception ex) {
       throw ex;
     }
     finally
     {
       dbManager.close();
     }
     return pageRecord;
  }
  //add by zhaolu 20060802 end
  
  //add by zhaolu 20060803 start
  //结案分页查询
  public PageRecord findByConditions(String conditions,int pageNo,int recordPerPage) throws Exception
  {
     DBManager dbManager = new DBManager();
     PageRecord pageRecord = null;
     try
     {

       //dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    	 dbManager.open(Constant.QUERY_DATA_SOURCE) ;
      // BLPrpLregistAction blPrpLregistAction = new BLPrpLregistAction();
       BLPrpLclaimAction blPrpLclaimAction = new BLPrpLclaimAction();
       pageRecord = (PageRecord)blPrpLclaimAction.findByConditions(dbManager,conditions,pageNo,recordPerPage);
     }
     catch(SQLException sqle)
     {
       throw sqle;
     }
     catch (Exception ex) {
       throw ex;
     }
     finally
     {
       dbManager.close();
     }
     return pageRecord;
  }
  //add by zhaolu 20060803 end
  
  /**
   * 在立案保存或者提交的时候对查勘和定损环节的处理状态进行判断仅仅对养殖险进行处理
   * @param swfLogFlowID 流程编号
   * add 国元项目组 冯雷 2008-06-04 
   */
  public void checkNodeStatus(String swfLogFlowID) throws Exception {
		String nodeStatus = "";
		BLSwfLogFacade blSwfLogFacade = new BLSwfLogFacade();
		String conditions = "flowid='" + swfLogFlowID
				+ "' and nodetype in ('check','certa')";
		ArrayList blSwfLogList = new ArrayList();
		blSwfLogList = (ArrayList) blSwfLogFacade.findByConditions(conditions);
		Iterator it = blSwfLogList.iterator();
		while (it.hasNext()) {
			SwfLogDto swfLogDto = (SwfLogDto) it.next();
			nodeStatus = swfLogDto.getNodeStatus();
			if (!"4".equals(nodeStatus)) {
				//错误信息处理
				throw new UserException(1, 3, "1000", "查勘或定损节点未提交,不能立案保存!");
			}
		}
	}
}
