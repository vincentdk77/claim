
package com.sinosoft.claim.resource.dtofactory.custom;

import java.sql.SQLException;

import com.sinosoft.claim.dto.custom.CheckDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcheckLoss;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLpersonTrace;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLscheduleItem;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLthirdCarLoss;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLthirdParty;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLthirdProp;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 *  新增定损调度数据库管理对象
 * <p>Title: 车险理赔新增定损调度数据管理</p>
 * <p>Description: 车险理赔新增定损调度数据管理</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: Sinosoft</p>
 * @author wangli
 * @version 1.0
 */
public class DBScheduleAddCertainLoss {
	

	/**
	   * 构造函数
	   * @param dbManager 资源管理类
	   */
	  public DBScheduleAddCertainLoss()
	  {

	  }

	  /**
	   * 新增定损调度保存方法
	   *@param checkDto 查勘对象
	   * @throws SQLException
	   * @throws Exception
	   *@return 无
	   */
	  public void insert(DBManager dbManager,CheckDto checkDto)
	    throws SQLException,Exception	
	  {
	  	
	    String registNo="";
	    registNo = checkDto.getPrpLcheckDto().getRegistNo();
	    //首先删除原来的相关数据
	    deleteSubInfo(dbManager,registNo,checkDto);
        //理赔车辆信息表
	    if(checkDto.getPrpLthirdPartyDtoList()!=null)
	    {
	       new DBPrpLthirdParty(dbManager).insertAll(checkDto.getPrpLthirdPartyDtoList());
	    }
        //调度任务标的表
	     if(checkDto.getPrpLscheduleItemDtoList() !=null)   {

	       new DBPrpLscheduleItem(dbManager).insertAll(checkDto.getPrpLscheduleItemDtoList()  );
	     }
	   //  else
         //损失部位表
	     if(checkDto.getPrpLthirdCarLossDtoList()!=null)
	     {
	       new DBPrpLthirdCarLoss(dbManager).insertAll(checkDto.getPrpLthirdCarLossDtoList());
	     }
	     
	     
	     if(checkDto.getPrpLpersonTraceDtoList()!=null)
	     {
	        new DBPrpLpersonTrace(dbManager).insertAll(checkDto.getPrpLpersonTraceDtoList());
	     }
	     
	     if(checkDto.getPrpLthirdPropDtoList()!=null)
	     {
	       new DBPrpLthirdProp(dbManager).insertAll(checkDto.getPrpLthirdPropDtoList());
	     }
	     
	     if(checkDto.getPrpLcheckLossDtoList()!=null)
	     {
	       new DBPrpLcheckLoss(dbManager).insertAll(checkDto.getPrpLcheckLossDtoList());
	     }


	  }
	  
	  
	  /**
	   * 新增定损调度删除子表信息
	   * @param checkNo
	   * @throws SQLException
	   * @throws Exception
	   */
	  private void deleteSubInfo(DBManager dbManager,String businessNo,CheckDto checkDto)
	    throws SQLException,Exception
	  {
	    String condition = " registNo = '" + StringUtils.rightTrim(businessNo) + "'";

	    String statement = ""; //示例未完成
	    
	    
	    if(checkDto.getPrpLthirdPartyDtoList() !=null)   {
	    statement = " DELETE FROM prpLthirdParty Where " + condition;
	    dbManager.executeUpdate(statement);
	    }

	    //modify by liyanjie 2005-12-17 改为在插入一条记录前,删除对应一条
	    //如果传过来的有scheduleITem的数据的话
	     // if(checkDto.getPrpLscheduleItemDtoList() !=null)   {
	     //   statement = " DELETE FROM PrpLscheduleItem Where " + condition;
	     //   dbManager.executeUpdate(statement);
	    //}
	    
	    if(checkDto.getPrpLthirdCarLossDtoList() !=null)   {
	    statement = " DELETE FROM prplThirdcarloss Where " + condition;
	    dbManager.executeUpdate(statement);
	    }
	    
	    if(checkDto.getPrpLcheckLossDtoList() !=null)   {
	    	//System.out.println("CheckLoss不是空的。。。");
		    statement = " DELETE FROM PrpLcheckLoss Where  " + condition;
		    dbManager.executeUpdate(statement);
		    }
	    
	    statement = " DELETE FROM prplThirdProp Where " + condition;
	    dbManager.executeUpdate(statement);
	    
	    statement =  " DELETE FROM prpLpersonTrace Where " + condition;
	    dbManager.executeUpdate(statement);


	  }



}
