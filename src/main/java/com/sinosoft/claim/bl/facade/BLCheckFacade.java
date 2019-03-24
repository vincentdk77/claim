package com.sinosoft.claim.bl.facade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.sinosoft.claim.bl.action.custom.BLCertainLossAction;
import com.sinosoft.claim.bl.action.custom.BLCheckAction;
import com.sinosoft.claim.bl.action.custom.BLWorkFlowAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLcheckAction;
import com.sinosoft.claim.dto.custom.CertainLossDto;
import com.sinosoft.claim.dto.custom.CheckDto;
import com.sinosoft.claim.dto.custom.ScheduleDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpLcheckDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLclaimLossDto;
import com.sinosoft.claim.dto.domain.PrpLpropDto;
import com.sinosoft.function.insutil.dto.domain.PrpXPcolDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 *  查勘逻辑分发
 * <p>Title: 车险理赔查勘</p>
 * <p>Description: 车险理赔查勘facade</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class BLCheckFacade
{
  /**
   * 保存查勘
   * @param checkDto：自定义查勘对象
   * @throws SQLException
   * @throws Exception
   */
  public void save(CheckDto checkDto,CertainLossDto certainLossDto) throws SQLException,Exception
  {
    //创建数据库管理对象   
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //开始事务
    dbManager.beginTransaction();
    try
    { new BLCheckAction().save(dbManager,checkDto);
      new BLCertainLossAction().save(dbManager,certainLossDto);
      //提交事务
      dbManager.commitTransaction();
    }
    catch(SQLException sqle)
    {
        sqle.printStackTrace();
      //回滚事务
      dbManager.rollbackTransaction();
      throw sqle;
    }
    catch(Exception ex)
    {
        ex.printStackTrace();
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
   * 保存查勘
   * @param checkDto：自定义查勘对象
   * @throws SQLException
   * @throws Exception
   */
  public void save(ArrayList checkDtoList,ArrayList certainLossDtoList) throws SQLException,Exception
  {
    //创建数据库管理对象   
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //开始事务
    dbManager.beginTransaction();
    try
    { 
    	for(int i=0;i<checkDtoList.size();i++){
    	new BLCheckAction().save(dbManager,(CheckDto)checkDtoList.get(i));}
    	for(int i=0;i<certainLossDtoList.size();i++){
      new BLCertainLossAction().save(dbManager,(CertainLossDto)certainLossDtoList.get(i));}
      //提交事务
      dbManager.commitTransaction();
    }
    catch(SQLException sqle)
    {
        sqle.printStackTrace();
      //回滚事务
      dbManager.rollbackTransaction();
      throw sqle;
    }
    catch(Exception ex)
    {
        ex.printStackTrace();
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
   * 保存查勘/带工作流
   * @param checkDto：自定义查勘对象
   * @throws SQLException
   * @throws Exception
   */
  public void save(CheckDto checkDto,CertainLossDto certainLossDto,WorkFlowDto workFlowDto) throws SQLException,Exception
  {  
  	 //创建数据库管理对象
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //开始事务
    dbManager.beginTransaction();
    try 
    {
      new BLCheckAction().save(dbManager,checkDto);
     if (certainLossDto.getPrpLverifyLossDto()!=null&&
	 	(certainLossDto.getPrpLverifyLossDto().getRegistNo()!=null
	 	&&!certainLossDto.getPrpLverifyLossDto().getRegistNo().trim().equals("")
		)){
      new BLCertainLossAction().save(dbManager,certainLossDto);
      	}
       if(workFlowDto!=null){
        new BLWorkFlowAction().deal(dbManager,workFlowDto);
      }
     
      
      //提交事务
      dbManager.commitTransaction();
    }
    catch(SQLException sqle)
    {
        sqle.printStackTrace();
      //回滚事务
      dbManager.rollbackTransaction();
      throw sqle;
    }
    catch(Exception ex)
    {
        ex.printStackTrace();
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
   * 保存查勘/带工作流
   * @param checkDto：自定义查勘对象
   * @throws SQLException
   * @throws Exception
   */
  public void save(ArrayList checkDtoList,ArrayList certainLossDtoList,ArrayList workFlowDtoList) throws SQLException,Exception
  {  
  	 //创建数据库管理对象
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //开始事务
    dbManager.beginTransaction();
    try 
    {
    	for(int i=0;i<checkDtoList.size();i++){
      new BLCheckAction().save(dbManager,(CheckDto)checkDtoList.get(i));}
    	for(int i=0;i<certainLossDtoList.size();i++){
     if (((CertainLossDto)certainLossDtoList.get(i)).getPrpLverifyLossDto()!=null&&
	 	(((CertainLossDto)certainLossDtoList.get(i)).getPrpLverifyLossDto().getRegistNo()!=null
	 	&&!((CertainLossDto)certainLossDtoList.get(i)).getPrpLverifyLossDto().getRegistNo().trim().equals("")
		)){
      new BLCertainLossAction().save(dbManager,((CertainLossDto)certainLossDtoList.get(i)));
      	}
    	}
    	for(int i=0;i<workFlowDtoList.size();i++){
       if((WorkFlowDto)workFlowDtoList.get(i)!=null){
        new BLWorkFlowAction().deal(dbManager,(WorkFlowDto)workFlowDtoList.get(i));
      }
    	}
      
      //提交事务
      dbManager.commitTransaction();
    }
    catch(SQLException sqle)
    {
        sqle.printStackTrace();
      //回滚事务
      dbManager.rollbackTransaction();
      throw sqle;
    }
    catch(Exception ex)
    {
        ex.printStackTrace();
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
   * 删除查勘
   * @param  checkNo
   * @param dbManager  数据连接
   * @throws SQLException
   * @throws Exception
   */
  public void delete(String checkNo) throws SQLException,Exception
  {
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //开始事务
    dbManager.beginTransaction();
    try
    {
      new BLCheckAction().delete(dbManager,checkNo);
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
   * 获得查勘
   * @param  checkNo
   * @param dbManager  数据连接
   * @return 自定义查勘对象
   * @throws SQLException
   * @throws Exception
   */
  public CheckDto findByPrimaryKey(String checkNo) throws SQLException,Exception
  {
    CheckDto checkDto = null;
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    try
    {
      checkDto = new BLCheckAction().findByPrimaryKey(dbManager,checkNo);
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
    return checkDto;
  }

  /**
   * 判断查勘通知号是否存在
   * @param checkNo
   * @param dbManager  数据连接
   * @return 是/否
   * @throws SQLException
   * @throws Exception
   */
  public boolean isExist(String checkNo) throws SQLException,Exception
  {

    boolean exist = false ;
    //创建数据库管理对象
     DBManager dbManager = new DBManager();
     dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    try
    {
      exist = new BLCheckAction().isExist(dbManager,checkNo);
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

  /**
   * 根据条件查询查勘主表信息
   * @param conditions String
   * @throws Exception
   * @return Collection
   */
  public Collection findByConditions(String conditions) throws Exception
  {
     DBManager dbManager = new DBManager();
     PrpLcheckDto prpLcheckDto = null;
     Collection checkList = new ArrayList();
     try
     {
       dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
       BLPrpLcheckAction blPrpLcheckAction = new BLPrpLcheckAction(); 
       checkList = (Collection)blPrpLcheckAction.findByConditions(dbManager,conditions);
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
     return checkList;
  }


  /**
   * 获得需要查勘的调度过来的任务
   * @param conditions String
   * @throws Exception
   * @return Collection
   */
  public Collection findNewScheduleTaskList(String conditions) throws Exception
  {
     DBManager dbManager = new DBManager();
     Collection checkScheduleList = new ArrayList();
     try
     {
       dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
       BLCheckAction blCheckAction = new BLCheckAction();
       checkScheduleList = (Collection)blCheckAction.findNewScheduleTaskList(dbManager,conditions);
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
     return checkScheduleList;
  }

  /**
     * 保存查勘调度
     * @param checkDto：自定义查勘调度对象
     * @throws SQLException
     * @throws Exception
     */
    public void saveSchedule(ScheduleDto scheduleDto) throws SQLException,Exception
    {
      //创建数据库管理对象
      DBManager dbManager = new DBManager();
      dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
      //开始事务
      dbManager.beginTransaction();
      try
      {
        new BLCheckAction().saveSchedule(dbManager,scheduleDto);
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
   * 根据条件查询报案主表信息
   * @param conditions String
   * @throws Exception
   * @return Collection
   * Add By sunhao 2004-08-24 Reason:增加新的查询方法
   */
  public Collection findByQueryConditions(String conditions) throws Exception
  {
     DBManager dbManager = new DBManager();
     PrpLcheckDto prpLcheckDto = null;
     Collection checkList = new ArrayList();
     try
     {

       dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
      // BLPrpLregistAction blPrpLregistAction = new BLPrpLregistAction();
       BLCheckAction blCheckAction = new BLCheckAction();
       checkList = (Collection)blCheckAction.findByQueryConditions(dbManager,conditions,0,0);
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
     return checkList;
  }

  /**
   * 根据条件查询报案主表信息
   * @param conditions String
   * @throws Exception
   * @return Collection
   * Add By sunhao 2004-08-24 Reason:增加新的查询方法
   */
  public Collection findByQueryConditionsAcci(String conditions) throws Exception
  {
     DBManager dbManager = new DBManager();
     PrpLcheckDto prpLcheckDto = null;
     Collection checkList = new ArrayList();
     try
     {

       dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
      // BLPrpLregistAction blPrpLregistAction = new BLPrpLregistAction();
       BLCheckAction blCheckAction = new BLCheckAction();
       checkList = (Collection)blCheckAction.findByQueryConditionsAcci(dbManager,conditions,0,0);
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
     return checkList;
  }
  
  //add by zhaolu 20060802 start
  public PageRecord findByQueryConditions(String conditions,int pageNo,int recordPerPage) throws Exception
  {
	  DBManager dbManager = new DBManager();
		//PrpLpolicyDto prpLpolicyDto = null;
		PageRecord pageRecord = null;
		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			 BLCheckAction blCheckAction = new BLCheckAction();
			pageRecord = (PageRecord) blCheckAction.findByConditions(
					dbManager, conditions,pageNo,recordPerPage);
		} catch (SQLException sqle) {
			throw sqle;
		} catch (Exception ex) {
			throw ex;
		} finally {
			dbManager.close();
		}
		return pageRecord;
  }
  
  
  public PageRecord findByQueryConditionsAcci(String conditions,int pageNo,int recordPerPage) throws Exception
  {
	  DBManager dbManager = new DBManager();
		//PrpLpolicyDto prpLpolicyDto = null;
		PageRecord pageRecord = null;
		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			BLCheckAction blCheckAction = new BLCheckAction();
			pageRecord = (PageRecord) blCheckAction.findByConditionsAcci(
					dbManager, conditions,pageNo,recordPerPage);
		} catch (SQLException sqle) {
			throw sqle;
		} catch (Exception ex) {
			throw ex;
		} finally {
			dbManager.close();
		}
		return pageRecord;
  }
  //add b yzhaolu 20060802 end
  
  public void saveClaimLoss(PrpLclaimDto prpLclaimDto,
			ArrayList prpLpropDtoList) throws Exception {
	    // 总定损金额
	    double sumLoss = 0.0;
	    // 保存立案估损信息(先删除后插入)
	  	BLPrpLclaimLossFacade blPrpLclaimLossFacade = new BLPrpLclaimLossFacade();
	  	blPrpLclaimLossFacade.deleteByConditions("claimNo = '" + prpLclaimDto.getClaimNo() + "'"); // 删除立案估损信息
		for (int i = 0; i < prpLpropDtoList.size(); i++) {
			PrpLclaimLossDto prpLclaimLossDto = new PrpLclaimLossDto();
			PrpLpropDto prpLpropDto = (PrpLpropDto) prpLpropDtoList.get(i);
		
			sumLoss += prpLpropDto.getSumLoss();
			prpLclaimLossDto.setClaimNo(prpLclaimDto.getClaimNo());
			prpLclaimLossDto.setRiskCode(prpLclaimDto.getRiskCode());
			prpLclaimLossDto.setSerialNo(prpLpropDto.getSerialNo()); // 分户序号
			prpLclaimLossDto.setItemKindNo(prpLpropDto.getItemKindNo());//标的子险序号
			prpLclaimLossDto.setKindCode(prpLpropDto.getKindCode());//险别代码
			prpLclaimLossDto.setItemCode(prpLpropDto.getItemCode());//保单标的项目代码
			prpLclaimLossDto.setCurrency(prpLpropDto.getCurrency());//币别
			prpLclaimLossDto.setInputDate(prpLpropDto.getBuyDate());//输入日期
			prpLclaimLossDto.setLossFeeType("p");//要分别出赔款还是直接理赔费用
			prpLclaimLossDto.setFamilyNo(prpLpropDto.getFamilyNo());
			prpLclaimLossDto.setFamilyName(prpLpropDto.getFamilyName());
			prpLclaimLossDto.setSumClaim(sumLoss);//估损金额
			prpLclaimLossDto.setKindLoss(prpLpropDto.getSumDefLoss());//险别损失
			prpLclaimLossDto.setItemDetailName(prpLpropDto.getLossItemName());//标的项目明细名称	
			//prpLclaimLossDto.setItemCode(prpLpropDto.getLossItemCode());//标的项目明细序号
		    blPrpLclaimLossFacade.insert(prpLclaimLossDto);
		}
		
		
		// 修改立案总估损金额
		prpLclaimDto.setSumClaim(sumLoss);
		BLPrpLclaimFacade blPrpLclaimFacade = new BLPrpLclaimFacade();
		blPrpLclaimFacade.update(prpLclaimDto);
	}
}
