package com.gyic.claim.bl.facade;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.sinosoft.claim.webservice.FindAppFarmerInfoList;
import com.sinosoft.claim.webservice.ResidentAppInforList;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.utility.database.DbPool;
import com.sinosoft.utility.error.UserException;
import com.gyic.claim.bl.action.domain.BLHerdsettlelistAction;
import com.gyic.claim.dto.domain.HerdsettlelistDto;

/**
 * 这是HERDSETTLELIST的业务对象Facade类<br>
 * 创建于 JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLHerdsettlelistFacade extends BLHerdsettlelistFacadeBase{
    private static Logger logger = Logger.getLogger(BLHerdsettlelistFacade.class);

    /**
     * 构造函数
     */
    public BLHerdsettlelistFacade(){
        super();
    }
    
    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @return Collection 包含herdsettlelistDto的集合
     * @throws Exception
     */
    public Collection findAccountByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLHerdsettlelistAction blHerdsettlelistAction = new BLHerdsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            collection = blHerdsettlelistAction.findAccountByConditions(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return collection;
    }
    
    /**
     * 驻点员App养殖险理赔农户清单查询
     * @param iWherePart
     * @param intPageNum
     * @param intPageCount
     * @return
     * @throws UserException
     * @throws Exception
     */
    public ArrayList<FindAppFarmerInfoList> query(String iWherePart, int intPageNum, int intPageCount) throws UserException,Exception
    {
    	String strSqlStatement = "";
		int intStartNum = 0;
		int intEndNum = 0;

		intStartNum = (intPageNum - 1) * intPageCount;
		intEndNum = intPageNum * intPageCount;

		ArrayList<FindAppFarmerInfoList> collection = new ArrayList<FindAppFarmerInfoList>();
		//and m.VALIDITY='2' and  p.VALIDITY in ('1','9')养殖险理赔清单这两个字段是不存值的
		strSqlStatement = " SELECT fCode,fName,fIdcard,earlabel,REPORTCODE,REGISTERCODE,SETTLELISTCODE,breedingAreaname,bankName,bankaccount,deadNumber,cullnumber,settleAmount " +
		" FROM ( "+ "Select RowNum As LineNum,T.* From ( select p.fCode as fCode,p.fName as fName,p.fIdcard as fIdcard,p.earlabel as earlabel,m.REPORTCODE as REPORTCODE,m.REGISTERCODE as REGISTERCODE,p.SETTLELISTCODE as SETTLELISTCODE,p.breedingareaname as breedingAreaname,p.bankname as bankName,p.bankaccount as bankAccount,p.deadnumber as deadNumber,p.cullnumber as cullNumber,p.settleamount as settleAmount from  settlemainlist m, herdsettlelist p where m.settlelistcode=p.settlelistcode "
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
	        FindAppFarmerInfoList findAppFarmerInfoList = null;
	        while(resultSet.next()){
	        	findAppFarmerInfoList = new FindAppFarmerInfoList();
	        	if(resultSet.getString(1) != null){
	        		findAppFarmerInfoList.setFCode(resultSet.getString(1));
	        	}
	        	if(resultSet.getString(2) != null){
	        		findAppFarmerInfoList.setFName(resultSet.getString(2));
	        	}
	        	if(resultSet.getString(3) != null){
	        		findAppFarmerInfoList.setFIdcard(resultSet.getString(3));
	        	}
	        	if(resultSet.getString(4) != null){
	        		findAppFarmerInfoList.setEarlable(resultSet.getString(4));
	        	}
	        	if(resultSet.getString(5) != null){
	        		findAppFarmerInfoList.setRegistNo(resultSet.getString(5));
	        	}
	        	if(resultSet.getString(6) != null){
	        		findAppFarmerInfoList.setClaimNo(resultSet.getString(6));
	        	}
	        	if(resultSet.getString(7) != null){
	        		findAppFarmerInfoList.setSettleListCode(resultSet.getString(7));
	        	}
	        	if(resultSet.getString(8) != null){
	        		findAppFarmerInfoList.setBreedingArea(resultSet.getString(8));
	        	}
	        	if(resultSet.getString(9) != null){
	        		findAppFarmerInfoList.setBankName(resultSet.getString(9));
	        	}
	        	if(resultSet.getString(10) != null){
	        		findAppFarmerInfoList.setBankAccount(resultSet.getString(10));
	        	}
	        	if(resultSet.getString(11) != null){
	        		findAppFarmerInfoList.setDeadnumber(resultSet.getString(11));
	        	}
	        	if(resultSet.getString(12) !=null){
	        		findAppFarmerInfoList.setKillNumber(resultSet.getString(12));
	        	}
	        	if(resultSet.getString(13) !=null){
	        		findAppFarmerInfoList.setSettleAmount(resultSet.getString(13));
	        	}
	        	collection.add(findAppFarmerInfoList);
	        }
	    }
	    catch(SQLException sqlException){
	        dbpool.close();
	        //throw sqlException;
	        sqlException.printStackTrace();
	    }
	    finally{
	        if(resultSet!=null){
	          resultSet.close();
	        }
	        dbpool.close();
	    }
	    return collection;
	    
    }

    /**
     * 驻点员App3224险种,3228险种理赔农户清单查询
     * @param iWherePart
     * @param intPageNum
     * @param intPageCount
     * @return
     * @throws UserException
     * @throws Exception
     */
    public ArrayList<FindAppFarmerInfoList> HerdSpeciquery(String iWherePart, String riskCode, int intPageNum, int intPageCount) throws UserException,Exception
    {
    	String strSqlStatement = "";
		int intStartNum = 0;
		int intEndNum = 0;

		intStartNum = (intPageNum - 1) * intPageCount;
		intEndNum = intPageNum * intPageCount;

		ArrayList<FindAppFarmerInfoList> collection = new ArrayList<FindAppFarmerInfoList>();
		if(riskCode!=null && riskCode.trim().equals("3224")){//3224险种走的查询SQL
			strSqlStatement = " SELECT fCode,fName,fIdcard,phone,REPORTCODE,REGISTERCODE,SETTLELISTCODE,insureArea,amount,settleArea,settleSum,breedingArea,bankAccount " +
			" FROM ( "+ "Select RowNum As LineNum,T.* From ( select p.fCode as fCode,p.fName as fName,p.fIdcard as fIdcard,p.phone as phone,m.REPORTCODE,m.REGISTERCODE as REGISTERCODE,p.SETTLELISTCODE as SETTLELISTCODE,p.insureArea as insureArea,p.SUMINSURED as amount,p.settleArea as settleArea,p.settleSum as settleSum,p.atarea||p.littleareaname as breedingArea,p.zhibuka as bankAccount  from  settlemainlist m, nyxsettlelist p where m.settlelistcode=p.settlelistcode and m.VALIDITY='2' and  p.VALIDITY in ('1','9') "
			+ iWherePart
			+ ") T Where RowNum<=" + intEndNum + ") Where LineNum>"
			+ intStartNum ;
		}
		//if(riskCode!=null && riskCode.trim().equals("3228")){//3228险种走的查询SQL
		//	strSqlStatement = " SELECT fCode,fName,fIdcard,phone,REPORTCODE,REGISTERCODE,SETTLELISTCODE,insureArea,amount,settleArea,settleSum,breedingArea,bankAccount " +
		//	" FROM ( "+ "Select RowNum As LineNum,T.* From ( select p.fCode as fCode,p.fName as fName,p.fIdcard as fIdcard,p.phone as phone,m.REPORTCODE,m.REGISTERCODE as REGISTERCODE,p.SETTLELISTCODE as SETTLELISTCODE,p.insureArea as insureArea,p.SUMINSURED as amount,p.settleArea as settleArea,p.settleSum as settleSum,p.atarea as breedingArea,p.zhibuka as bankAccount  from  settlemainlist m, plantingsettlelist p where m.settlelistcode=p.settlelistcode and m.VALIDITY='2' and  p.VALIDITY in ('1','9') "
		//	+ iWherePart
		//	+ ") T Where RowNum<=" + intEndNum + ") Where LineNum>"
		//	+ intStartNum ;
		//}
		DbPool dbpool = new DbPool();
		ResultSet resultSet = null;
	    //打开数据库，开始事务
		//System.err.println("strSqlStatement:" + strSqlStatement);
		
		dbpool.open("NXDADataSource");
		//System.out.println(strSqlStatement);
	    try{
	        resultSet = dbpool.query(strSqlStatement);
	        FindAppFarmerInfoList findAppFarmerInfoList = null;
	        while(resultSet.next()){
	        	findAppFarmerInfoList = new FindAppFarmerInfoList();
	        	
	        	if(resultSet.getString(1) != null){
	        		findAppFarmerInfoList.setFCode(resultSet.getString(1));
	        	}
	        	if(resultSet.getString(2) != null){
	        		findAppFarmerInfoList.setFName(resultSet.getString(2));
	        	}
	        	if(resultSet.getString(3) != null){
	        		findAppFarmerInfoList.setFIdcard(resultSet.getString(3));
	        	}
	        	if(resultSet.getString(4) != null){
	        		findAppFarmerInfoList.setPhone(resultSet.getString(4));
	        	}
	        	if(resultSet.getString(5) != null){
	        		findAppFarmerInfoList.setRegistNo(resultSet.getString(5));
	        	}
	        	if(resultSet.getString(6) != null){
	        		findAppFarmerInfoList.setClaimNo(resultSet.getString(6));
	        	}
	        	if(resultSet.getString(7) != null){
	        		findAppFarmerInfoList.setSettleListCode(resultSet.getString(7));
	        	}
	        	if(resultSet.getString(8) != null){
	        		findAppFarmerInfoList.setInsureArea(resultSet.getString(8));
	        	}
	        	if(resultSet.getString(9) != null){
	        		findAppFarmerInfoList.setAmount(resultSet.getString(9));
	        	}
	        	if(resultSet.getString(10) != null){
	        		findAppFarmerInfoList.setSettleArea(resultSet.getString(10));
	        	}
	        	if(resultSet.getString(11) != null){
	        		findAppFarmerInfoList.setSettleAmount(resultSet.getString(11));
	        	}
	        	if(resultSet.getString(12) != null){
	        		findAppFarmerInfoList.setBreedingArea(resultSet.getString(12));
	        	}
	        	if(resultSet.getString(13) != null){
	        		findAppFarmerInfoList.setBankAccount(resultSet.getString(13));
	        	}
	        	
	        	
	        	collection.add(findAppFarmerInfoList);
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
