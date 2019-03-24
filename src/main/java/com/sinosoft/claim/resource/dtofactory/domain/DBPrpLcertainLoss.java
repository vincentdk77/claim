package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLverifyLossDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLcertainLoss 定损主表的数据访问对象类<br>
 * 创建于 2004-07-15 11:00:25.464<br>
 * JToolpad(1.2.10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLcertainLoss extends DBPrpLcertainLossBase{
    private static Log log = LogFactory.getLog(DBPrpLcertainLoss.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLcertainLoss(DBManager dbManager){
        super(dbManager);
    }

    /**
     * 按条件从prplverifyLoss表,prplregist表和prplclaimstatus表中查询多条数据
     * @param conditions String
     * @param pageNo int
     * @param rowsPerPage int
     * @throws Exception
     * @return Collection
     * Modify By sunhao 2004-08-24 Reason:增加车牌号，案件状态，操作时间查询条件，在查询结果中增加案件状态
     * Modify by 
     */
    public Collection findByQueryConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
       /*String statement = "Select DISTINCT a.RegistNo,"+
                           "a.PolicyNo, "+
                           "a.HandlerCode, "+
                           "a.DefLossDate, "+
                           "a.LossitemCode, "+
                           "b.OperateDate, "+
                           "b.Status, "+   
                           "b.RiskCode, "+
                           "a.lossItemName From (select * from PrpLClaimStatus where NodeType='certa') b Right JOIN PrpLverifyLoss a ON a.RegistNo = b.BusinessNo where"+conditions ;*/
        //Modify by caopeng add begin 20051216 Reason:使每种查询时RiskCode值不会为空
       /*
    	String statement = "Select DISTINCT a.RegistNo,"+
       "a.PolicyNo, "+
       "a.HandlerCode, "+
       "a.DefLossDate, "+
       "a.LossitemCode, "+
       "b.OperateDate, "+
       "b.Status, "+   
       "a.RiskCode, "+
       "a.lossItemName From (select * from PrpLClaimStatus where NodeType='certa') b Right JOIN PrpLverifyLoss a ON a.RegistNo = b.BusinessNo where"+conditions ;
          */
        //Modify by caopeng add end 20051216 Reason:使每种查询时RiskCode值不会为空
       //Modify by hanliang add begin 20051223 Reason:使每种查询时HandlerCode值不会为空
		//add by zhouliu start at 2006-6-9
		//reason:强三查询
    	//modify by zhaolu 20060809 start
    	String statement = "Select DISTINCT a.RegistNo,"+
        "a.PolicyNo, "+
        "b.HandlerCode, "+
        "a.DefLossDate, "+
        "a.LossitemCode, "+
        "b.OperateDate, "+
        "b.Status, "+   
        "a.RiskCode, "+
        "a.lossItemName," +
        "a.handlername From (select * from PrpLClaimStatus where NodeType='certa') b Right JOIN PrpLverifyLoss a ON a.RegistNo = b.BusinessNo left join prplregist c on a.RegistNo = c.RegistNo,prplregistrpolicy d where a.RegistNo = d.RegistNo and cast(a.lossitemcode as int) = b.serialNo and"+conditions ;
    	//modify by zhaolu 20060809 end
		//add by zhouliu end at 2006-6-9
        //Modify by hanliang add end 20051223 Reason:使每种查询时HandlerCode值不会为空
 
       log.debug(statement);
        Collection collection = new ArrayList();
        PrpLverifyLossDto prpLverifyLossDto = null;
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
            prpLverifyLossDto = new PrpLverifyLossDto();
            prpLverifyLossDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLverifyLossDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpLverifyLossDto.setHandlerCode(dbManager.getString(resultSet,3));
            prpLverifyLossDto.setDefLossDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,4));
            prpLverifyLossDto.setLossItemCode(dbManager.getString(resultSet,5));
            
            prpLverifyLossDto.setOperateDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,6));
            prpLverifyLossDto.setStatus(dbManager.getString(resultSet,7));
            prpLverifyLossDto.setRiskCode(dbManager.getString(resultSet,8));
            prpLverifyLossDto.setLossItemName(dbManager.getString(resultSet,9));
            prpLverifyLossDto.setHandlerName(dbManager.getString(resultSet,10));
			//add by zhouliu start at 2006-6-9
			//reason:强三查询
            prpLverifyLossDto.setRelatepolicyNo(new TreeSet());
            //add by zhouliu end at 2006-6-9        
            collection.add(prpLverifyLossDto); 
        }
        resultSet.close();
			//add by zhouliu start at 2006-6-9
			//reason:强三查询
        for (Iterator it=collection.iterator(); it.hasNext();)
        {
        	prpLverifyLossDto=(PrpLverifyLossDto)it.next();
        	statement="select PolicyNo from prplregistrpolicy where RegistNo='"+prpLverifyLossDto.getRegistNo()+"'";
        	resultSet = dbManager.executeQuery(statement);
        	while (resultSet.next())
        	{
        		prpLverifyLossDto.getRelatepolicyNo().add(resultSet.getString("policyno"));
        	}
        	resultSet.close();
        }
			//add by zhouliu end at 2006-6-9
        log.info("DBPrpLverifyLoss.findByConditions() success!");
        return collection;
    }
    
    
    //add by zhaolu 20060803 start
    public int getCount1(String conditions)
    throws Exception{
    int count = -1;
    //modify by zhaolu 20060808 start
    String statement = "select Count(m.registno) from (Select DISTINCT a.RegistNo,a.PolicyNo,b.HandlerCode,a.DefLossDate,a.LossitemCode,b.OperateDate,b.Status,a.RiskCode,a.lossItemName From (select * from PrpLClaimStatus where NodeType='certa') b Right JOIN PrpLverifyLoss a ON a.RegistNo = b.BusinessNo left join prplregist c on a.RegistNo = c.RegistNo,prplregistrpolicy d where a.RegistNo = d.RegistNo and cast(a.lossitemcode as int) = b.serialNo and"+conditions+") m" ;
     statement = SqlUtils.getWherePartForGetCount(statement);
    //modify by zhaolu 20060808 end
    //String statement = "select Count (m.registno) from (Select DISTINCT a.RegistNo,a.LossitemCode,b.OperateDate From (select * from PrpLClaimStatus where NodeType='certa') b Right JOIN PrpLverifyLoss a ON a.RegistNo = b.BusinessNo left join prplregist c on a.RegistNo = c.RegistNo,prplregistrpolicy d where a.RegistNo = d.RegistNo and b.nodetype='certa' and"+conditions+") m" ;
    log.debug(statement);
    ResultSet resultSet = dbManager.executeQuery(statement);
    resultSet.next(); 
    count = dbManager.getInt(resultSet,1); 
    resultSet.close();
    log.info("DBPrpLcertainLoss.getCount1() success!");
    return count;
}
    //add by zhaolu 20060803 end

}
