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
 * 这是PrpLverifyLoss定核损主表的数据访问对象类<br>
 * 创建于 2004-07-19 14:23:57.222<br>
 * JToolpad(1.2.12-RC8) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLverifyLoss extends DBPrpLverifyLossBase{
    private static Log log = LogFactory.getLog(DBPrpLverifyLoss.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLverifyLoss(DBManager dbManager){
        super(dbManager);
    }

    /**
     * 按条件从prplverifyLoss表,prplregist表和prplclaimstatus表中查询多条数据
     * @param conditions String
     * @param nodeType String
     * @param pageNo int
     * @param rowsPerPage int
     * @throws Exception
     * @return Collection
     * Modify By sunhao 2004-08-24 Reason:增加车牌号，案件状态，操作时间查询条件，在查询结果中增加案件状态
     */
    public Collection findByQueryConditions(String conditions,String nodeType,int pageNo,int rowsPerPage) throws Exception{
    	//modify by caopeng start at 2005-12-20  Reason:在查询结果中增加核损完成日期
    	/*String statement = "Select DISTINCT a.RegistNo,"+
                           "a.PolicyNo, "+
                           "a.HandlerCode, "+
                           "a.DefLossDate, "+
                           "b.OperateDate, "+
                           "b.Status, "+
                           "a.lossItemCode, "+  
                           "b.RiskCode, "+
                           "c.LicenseNo From (select * from PrpLClaimStatus where NodeType='"+nodeType+"') b Right JOIN PrpLverifyLoss a ON a.RegistNo = b.BusinessNo LEFT JOIN prplregist c ON b.BusinessNo = c.RegistNo where"+conditions ;*/
    	//add by zhouliu start at 2006-6-9
		//reason:强三查询
    	//modify by zhaolu 20060808 start
		String statement = "Select DISTINCT a.RegistNo,"+
        "a.PolicyNo, "+
        "a.HandlerCode, " +       
        "a.DefLossDate, "+
        "b.OperateDate, "+
        "b.Status, "+
        "a.lossItemCode, "+  
        "b.RiskCode, "+
        "c.LicenseNo, "+
        "a.UnderWriteEndDate," +
        "a.underwritecode," +
        "a.underwritename"+
        " From (select * from PrpLClaimStatus where NodeType='"+nodeType+"') b Right JOIN PrpLverifyLoss a ON a.RegistNo = b.BusinessNo LEFT JOIN prplregist c ON b.BusinessNo = c.RegistNo,prplregistrpolicy d where a.RegistNo=d.RegistNo and cast(a.lossitemcode as integer) = b.serialNo and "+conditions ;
		//modify by zhaolu 20060808 end
        //add by zhouliu end at 2006-6-9
		//modify by caopeng end at 2005-12-20  Reason:在查询结果中增加核损完成日期
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
            prpLverifyLossDto.setOperateDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,5));
            prpLverifyLossDto.setStatus(dbManager.getString(resultSet,6));
            prpLverifyLossDto.setLossItemCode(dbManager.getString(resultSet,7));
            prpLverifyLossDto.setRiskCode(dbManager.getString(resultSet,8));
            //modify by caopeng start at 2005-12-20  Reason:在查询结果中增加核损完成日期
            prpLverifyLossDto.setUnderWriteEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,10));
            prpLverifyLossDto.setUnderWriteCode(dbManager.getString(resultSet,11));
            prpLverifyLossDto.setUnderWriteName(dbManager.getString(resultSet,12));
            //modify by caopeng end at 2005-12-20  Reason:在查询结果中增加核损完成日期
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
    public int getCount1(String conditions,String nodeType)
    throws Exception{
    int count = -1;
    //String statement = "Select count(DISTINCT a.RegistNo) from (select * from PrpLClaimStatus where NodeType='"+nodeType+"') b Right JOIN PrpLverifyLoss a ON a.RegistNo = b.BusinessNo LEFT JOIN prplregist c ON b.BusinessNo = c.RegistNo,prplregistrpolicy d where a.RegistNo=d.RegistNo and a.lossitemcode>0 and b.nodetype='"+nodeType+"' and"+conditions ;
    //modify by zhaolu 20060807 start
    String statement = "select Count(m.registno) from (Select DISTINCT a.RegistNo,a.PolicyNo,a.HandlerCode,a.DefLossDate,b.OperateDate,b.Status,a.lossItemCode,b.RiskCode,c.LicenseNo,a.UnderWriteEndDate From (select * from PrpLClaimStatus where NodeType='"+nodeType+"') b Right JOIN PrpLverifyLoss a ON a.RegistNo = b.BusinessNo LEFT JOIN prplregist c ON b.BusinessNo = c.RegistNo,prplregistrpolicy d where a.RegistNo=d.RegistNo and cast(a.lossitemcode as integer) = b.serialNo and "+conditions+") m" ;
    //modify by zhaolu 20060807 end
       statement = SqlUtils.getWherePartForGetCount(statement);
    log.debug(statement);
    ResultSet resultSet = dbManager.executeQuery(statement);
    resultSet.next(); 
    count = dbManager.getInt(resultSet,1); 
    resultSet.close();
    log.info("DBPrpLverifyLoss.getCount1() success!");
    return count;
}
    //add by zhaolu 20060803 end
    
    
}
