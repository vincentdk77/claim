package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcheckDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prplcheck查勘/代查勘信息表的数据访问对象扩展类<br>
 * 创建于 2004-4-5 15:32:10<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLcheck extends DBPrpLcheckBase{
    private static Log log = LogFactory.getLog(DBPrpLcheck.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLcheck(DBManager dbManager){
        super(dbManager);
    }

    /**
     * 按条件从prplcheck表,prplregist表和prplclaimstatus表中查询多条数据
     * @param conditions String
     * @param pageNo int
     * @param rowsPerPage int
     * @throws Exception
     * @return Collection
     * Modify By sunhao 2004-08-24 Reason:增加车牌号，案件状态，操作时间查询条件，在查询结果中增加案件状态
     */
    public Collection findByQueryConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
		//add by zhouliu start at 2006-6-9
		//reason:强三查询
    	String statement = "Select DISTINCT a.RegistNo,"+
        "a.PolicyNo, "+
        "a.Checker1, "+
        "a.Checker2, "+
        "a.CheckDate, "+                           
        "b.OperateDate, "+
        "b.RiskCode, "+
        "b.Status,c.LicenseNo  From (select * from PrpLClaimStatus where NodeType='check') b Right JOIN PrpLcheck a ON a.RegistNo = b.BusinessNo left join prplregist c on c.registno=b.BusinessNo,prplregistrpolicy d,swflog gg where (d.registno=a.registno) and b.nodetype='check' and gg.registno = d.registno and gg.nodetype='check' and "+conditions ;
        //add by zhouliu end at 2006-6-9
		log.debug(statement); 
        Collection collection = new ArrayList();
        PrpLcheckDto prpLcheckDto = null;
        ResultSet resultSet = dbManager.executeQuery(statement);
        int count=0;
        if(pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                        break;
                }
            }

            prpLcheckDto = new PrpLcheckDto();
            prpLcheckDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLcheckDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpLcheckDto.setChecker1(dbManager.getString(resultSet,3));
            prpLcheckDto.setChecker2(dbManager.getString(resultSet,4));
            prpLcheckDto.setCheckDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,5));
            prpLcheckDto.setOperateDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,6));
            prpLcheckDto.setRiskCode(dbManager.getString(resultSet,7));  
            prpLcheckDto.setStatus(dbManager.getString(resultSet,8));
			//add by zhouliu start at 2006-6-9
			//reason:强三查询
            prpLcheckDto.setRelatepolicyNo(new TreeSet());
			//add by zhouliu end at 2006-6-9
            collection.add(prpLcheckDto);
        }
        resultSet.close();
        	//add by zhouliu start at 2006-6-9
			//reason:强三查询
        for (Iterator it=collection.iterator(); it.hasNext();)
        {
        	prpLcheckDto=(PrpLcheckDto)it.next();
        	statement="select PolicyNo from prplregistrpolicy where RegistNo='"+prpLcheckDto.getRegistNo()+"'";
        	resultSet = dbManager.executeQuery(statement);
        	while (resultSet.next())
        	{
        		prpLcheckDto.getRelatepolicyNo().add(resultSet.getString("policyno"));
        		
        	}
        	resultSet.close();
        }
			//add by zhouliu end at 2006-6-9

        log.info("DBPrpLcheck.findByQueryConditions() success!");
        return collection;
    }
    
    //modify by wangwei add start 2005-06-18
    //原因：用于查询意键险信息
    /**
     * 按条件从prplcheck表,prplregist表和prplclaimstatus表中查询多条数据
     * @param conditions String
     * @param pageNo int
     * @param rowsPerPage int
     * @throws Exception
     * @return Collection
     * Modify By sunhao 2004-08-24 Reason:增加车牌号，案件状态，操作时间查询条件，在查询结果中增加案件状态
     */
    public Collection findByQueryConditionsAcci(String conditions,int pageNo,int rowsPerPage) throws Exception{
       String statement = "Select DISTINCT a.RegistNo,"+
                           "a.PolicyNo, "+
                           "a.CheckerCode, "+
                           "a.CheckObject, "+
                           "a.CheckDate, "+                           
                           "b.OperateDate, "+
                           "b.RiskCode, "+
                           "b.Status,c.LicenseNo  From (select * from PrpLClaimStatus where NodeType='check') b Right JOIN PrpLacciCheck a ON a.RegistNo = b.BusinessNo left join prplregist c on c.registno=b.BusinessNo where"+conditions ;
        log.debug(statement); 
        Collection collection = new ArrayList();
        PrpLcheckDto prpLcheckDto = null;
        ResultSet resultSet = dbManager.executeQuery(statement);
        int count=0;
        if(pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                        break;
                }
            }

            prpLcheckDto = new PrpLcheckDto();
            prpLcheckDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLcheckDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpLcheckDto.setChecker1(dbManager.getString(resultSet,3));
            prpLcheckDto.setChecker2(dbManager.getString(resultSet,4));
            prpLcheckDto.setCheckDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,5));
            prpLcheckDto.setOperateDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,6));
            prpLcheckDto.setRiskCode(dbManager.getString(resultSet,7));  
            prpLcheckDto.setStatus(dbManager.getString(resultSet,8));
            collection.add(prpLcheckDto);
        }
        resultSet.close();
        log.info("DBPrpLcheck.findByQueryConditions() success!");
        return collection;
    }
    //modify by wangwei add end 2005-06-18
    //add by zhaolu 20060802 start
    public int getCount1(String conditions) throws Exception
    {
    	int count = -1;
    	String statement = "select count (DISTINCT a.RegistNo) from (select * from PrpLClaimStatus where NodeType='check') b Right JOIN PrpLcheck a ON a.RegistNo = b.BusinessNo left join prplregist c on c.registno=b.BusinessNo,prplregistrpolicy d,swflog gg where (d.registno=a.registno) and b.nodetype='check' and gg.registno = d.registno and gg.nodetype='check' and "+conditions ;
    	log.debug(statement);
    	ResultSet resultSet = dbManager.executeQuery(statement);
    	resultSet.next();
    	count = dbManager.getInt(resultSet,1);
    	resultSet.close();
    	log.info("DBPrpLcheck.getCount1() success!");
        return count;
    }
    
    public int getCount2(String conditions) throws Exception
    {
    	int count = -1;
    	String statement = "select count (DISTINCT a.RegistNo) from (select * from PrpLClaimStatus where NodeType='check') b Right JOIN PrpLacciCheck a ON a.RegistNo = b.BusinessNo left join prplregist c on c.registno=b.BusinessNo where"+conditions ;
    	log.debug(statement);
    	ResultSet resultSet = dbManager.executeQuery(statement);
    	resultSet.next();
    	count = dbManager.getInt(resultSet,1);
    	resultSet.close();
    	log.info("DBPrpLcheck.getCount2() success!");
        return count;
    }
    //add by zhaolu 20060802 end
    
}
