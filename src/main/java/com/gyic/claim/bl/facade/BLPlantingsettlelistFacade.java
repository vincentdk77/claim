package com.gyic.claim.bl.facade;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.utility.database.DbPool;
import com.sinosoft.utility.error.UserException;
import com.gyic.claim.bl.action.domain.BLPlantingsettlelistAction;
import com.gyic.claim.dto.domain.PlantingsettlelistDto;
import com.sinosoft.claim.webservice.ResidentAppInforList;

/**
 * 这是PLANTINGSETTLELIST的业务对象Facade类<br>
 * 创建于 JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPlantingsettlelistFacade extends BLPlantingsettlelistFacadeBase{
    private static Logger logger = Logger.getLogger(BLPlantingsettlelistFacade.class);

    /**
     * 构造函数
     */
    public BLPlantingsettlelistFacade(){
        super();
    }
    
    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @return Collection 包含plantingsettlelistDto的集合
     * @throws Exception
     */
    public Collection findAccountByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPlantingsettlelistAction blPlantingsettlelistAction = new BLPlantingsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            collection = blPlantingsettlelistAction.findAccountByConditions(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return collection;
    }
    
    public ArrayList<ResidentAppInforList> query(String iWherePart, int intPageNum, int intPageCount) throws UserException,Exception
    {
    	String strSqlStatement = "";
		int intStartNum = 0;
		int intEndNum = 0;

		intStartNum = (intPageNum - 1) * intPageCount;
		intEndNum = intPageNum * intPageCount;

		ArrayList<ResidentAppInforList> collection = new ArrayList<ResidentAppInforList>(intPageCount);
		
		strSqlStatement = " SELECT fCode,fName,fIdcard,phone,REPORTCODE,REGISTERCODE,SETTLELISTCODE,insureArea,amount,kindCode,fieldSource,claimRate,settleArea,lossRate,settleSum,REMARK " +
		" FROM ( "+ "Select RowNum As LineNum,T.* From ( select p.fCode as fCode,p.fName as fName,p.fIdcard as fIdcard,p.phone as phone,m.REPORTCODE,m.REGISTERCODE as REGISTERCODE,p.SETTLELISTCODE as SETTLELISTCODE,p.insureArea as insureArea,p.SUMINSURED as amount,p.kindCode as kindCode,p.fieldSource as fieldSource,p.claimRate as claimRate,p.settleArea as settleArea,p.lossRate as lossRate,p.settleSum as settleSum,p.REMARK as REMARK from  settlemainlist m, plantingsettlelist p where m.settlelistcode=p.settlelistcode  and m.VALIDITY='2' and  p.VALIDITY in ('1','9') "
		+ iWherePart
		+ ") T Where RowNum<=" + intEndNum + ") Where LineNum>"
		+ intStartNum ;
		

		DbPool dbpool = new DbPool();
		ResultSet resultSet = null;
	    //打开数据库，开始事务
		//System.err.println("strSqlStatement:" + strSqlStatement);
		
		dbpool.open("NXDADataSource");
		//System.out.println(strSqlStatement);
	    try{
	        resultSet = dbpool.query(strSqlStatement);
	        while(resultSet.next()){
	        	ResidentAppInforList residentAppInforList = new ResidentAppInforList();
	        	
	        	if(resultSet.getString(1) != null){
	        		residentAppInforList.setFCode(resultSet.getString(1));
	        	}
	        	if(resultSet.getString(2) != null){
	        		residentAppInforList.setFName(resultSet.getString(2));
	        	}
	        	if(resultSet.getString(3) != null){
	        		residentAppInforList.setFIdcard(resultSet.getString(3));
	        	}
	        	if(resultSet.getString(4) != null){
	        		residentAppInforList.setPhone(resultSet.getString(4));
	        	}
	        	if(resultSet.getString(5) != null){
	        		residentAppInforList.setRegistNo(resultSet.getString(5));
	        	}
	        	if(resultSet.getString(6) != null){
	        		residentAppInforList.setClaimNo(resultSet.getString(6));
	        	}
	        	if(resultSet.getString(7) != null){
	        		residentAppInforList.setSettleListCode(resultSet.getString(7));
	        	}
	        	if(resultSet.getString(8) != null){
	        		residentAppInforList.setInsureArea(resultSet.getString(8));
	        	}
	        	if(resultSet.getString(9) != null){
	        		residentAppInforList.setAmount(resultSet.getString(9));
	        	}
	        	if(resultSet.getString(10) != null){
	        		residentAppInforList.setKindCode(resultSet.getString(10));
	        	}
	        	if(resultSet.getString(11) != null){
	        		residentAppInforList.setFieldSource(resultSet.getString(11));
	        	}
	        	if(resultSet.getString(12) != null){
	        		residentAppInforList.setClaimRate(resultSet.getString(12));
	        	}
	        	if(resultSet.getString(13) != null){
	        		residentAppInforList.setSettleArea(resultSet.getString(13));
	        	}
	        	if(resultSet.getString(14) != null){
	        		residentAppInforList.setLossRate(resultSet.getString(14));
	        	}
	        	if(resultSet.getString(15) != null){
	        		residentAppInforList.setSettleSum(resultSet.getString(15));
	        	}
	        	if(resultSet.getString(16) != null){
	        		residentAppInforList.setReMark(resultSet.getString(16));
	        	}
	        	
	        	
	        	collection.add(residentAppInforList);
	        }
	    }
	    catch(SQLException sqlException){
	        dbpool.close();
	        throw sqlException;
	    }
	    finally{
	    	if(resultSet!=null){
	          resultSet.close();
	        }
	        dbpool.close();
	    }
	    return collection;
	    
    }
    
    
}
