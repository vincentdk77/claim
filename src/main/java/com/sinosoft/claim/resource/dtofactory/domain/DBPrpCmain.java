package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCmainDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpcmain保单基本信息表的数据访问对象扩展类<br>
 * 创建于 2004-4-5 15:32:10<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpCmain extends DBPrpCmainBase{
    private static Log log = LogFactory.getLog(DBPrpCmain.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpCmain(DBManager dbManager){
        super(dbManager);
    }

    /**
     * 按条件从prpcmain表和prpcitemcar表中查询多条数据
     * @param conditions String
     * @param pageNo int
     * @param rowsPerPage int
     * @throws Exception
     * @return Collection
     */
    public Collection findForRegistConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
    	String statement = "Select a.PolicyNo, " +
                           "b.LicenseNo, "+
                           "a.InsuredName, "+
                           "a.StartDate, "+
                           "a.EndDate,b.BrandName, " +
                           "a.OthFlag," +
                           "a.riskcode," +
                           "a.classcode," +
                           "a.sumquantity," +
                           "a.flag," +
                           "a.underwriteflag, " +
                           "b.licenseno, " +
                           "a.comcode, "+
                           "a.handler1code, "+
                           "a.sumamount, "+
                           "a.starthour, "+
                           "a.endhour "+
                           "From PrpCmain a LEFT JOIN PrpCitemcar b ON a.PolicyNo = b.PolicyNo ," +
                           "uticodetransfer c " +
                           "where " + conditions ;
                           
       
//    	String statement = "Select a.PolicyNo,b.LicenseNo,a.InsuredName, a.StartDate, a.EndDate,b.BrandName" +
//                           " From PrpCmain a,PrpCitemcar b,Prpcinsured c where a.policyno = c .policyno and  a.PolicyNo =b.PolicyNo(+) " +
//                           " AND " + conditions;
    	
						  
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpCmainDto prpCmainDto = null;
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

            prpCmainDto = new PrpCmainDto();
            prpCmainDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCmainDto.setLicenseNo(dbManager.getString(resultSet,2));
            prpCmainDto.setInsuredName(dbManager.getString(resultSet,3));
            prpCmainDto.setStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,4));
            prpCmainDto.setEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,5));
            prpCmainDto.setBrandName(dbManager.getString(resultSet,6));
             //添加保单是否已经注销标志
            prpCmainDto.setOthFlag(dbManager.getString(resultSet,7));
            prpCmainDto.setRiskCode( dbManager.getString(resultSet,8));
            prpCmainDto.setClassCode( dbManager.getString(resultSet,9));
            
            
             //add by guolei  20070519 增加团单
            if(dbManager.getString(resultSet,11).length()>=2){
            	prpCmainDto.setInsuredName(dbManager.getString(resultSet,3)+"等"+dbManager.getString(resultSet,10)+"人");	
            }
            //添加见费出单的标志
            prpCmainDto.setUnderWriteFlag(dbManager.getString(resultSet, 12));
            //增加车牌号码
            prpCmainDto.setLicenseNo(dbManager.getString(resultSet, 13));
            prpCmainDto.setComCode(dbManager.getString(resultSet, 14));
            prpCmainDto.setHandler1Code(dbManager.getString(resultSet, 15));
            prpCmainDto.setSumAmount(dbManager.getDouble(resultSet, 16));
            prpCmainDto.setStartHour(dbManager.getInt(resultSet, 17));
            prpCmainDto.setEndHour(dbManager.getInt(resultSet, 18));
            collection.add(prpCmainDto);
        }
        resultSet.close();
        log.info("DBPrpCmain.findForRegistConditions() success!");
        return collection;
    }

    /**
     * 查询满足模糊查询条件的记录数
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getCount1(String conditions)
        throws Exception{
        int count = -1;
        String statement = "Select count(1) from PrpCmain a LEFT JOIN PrpCitemcar b ON a.PolicyNo = b.PolicyNo,uticodetransfer c  Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1); 
        resultSet.close();
        log.info("DBPrpCmainBase.getCount1() success!");
        return count;
    }
    
    /**
     * 更新一条数据(让表prpcmain中的字段claimstatus加1)
     * @param 
     * @throws Exception
     */
    public void updateClaimTimesAdd1(String policyNo) throws Exception{
        String statement = " update prpcmain set claimtimes=claimtimes+1" +
                           " Where " +
                           " PolicyNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1, policyNo);
        dbManager.executePreparedUpdate();

        log.info("DBPrpCmain.update() success!");
    }
}
