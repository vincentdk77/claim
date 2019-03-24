package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpljobmanagerDto;

/**
 * 这是PRPLJOBMANAGER的数据访问对象类<br>
 * 创建于 2011-11-14 11:45:25.546<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpljobmanager extends DBPrpljobmanagerBase{
    private static Logger logger = Logger.getLogger(DBPrpljobmanager.class);
    private static Log log = LogFactory.getLog(DBPrpLclaim.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpljobmanager(DBManager dbManager){
        super(dbManager);
    }
    
    
    /**
     * 按条件从表prpljobmanager表中查询多条数据
     * @param conditions String
     * @param pageNo int
     * @param rowsPerPage int
     * @throws Exception
     * @return Collection
     * Modify By sunhao 2004-08-24 Reason:增加车牌号，案件状态，操作时间查询条件，在查询结果中增加案件状态
     */
    public Collection findByQueryConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
       String statement = "Select id,"+
                           "jobrole, "+
                           "handlercode, "+
                           "handlername, "+
                           "handledept," +
                           "deptname, "+
                           "flowintime, "+
                           "modifytime, "+
						   "month," +
						   "operator," +
						   "operatorid," +
						   "systemCode," +
						   "classcode" +
						   " From prpljobmanager where " + conditions+"   order by flowintime desc" ;
//                             "b.Status,prplregist.LicenseNo  From (select * from PrpLClaimStatus where NodeType='check') b LEFT JOIN PrpLcheck a ON prplclaim.RegistNo = b.BusinessNo left join prplregist c on prplregist.registno=b.BusinessNo where"+conditions And Swflog.Nodetype ='claim'  and SwfLog.riskCode=prplclaim.riskcode ;LEFT JOIN swflog ON prplclaim.registNo = swflog.registNo 
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpljobmanagerDto prpljobmanagerDto = null;
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
            prpljobmanagerDto = new PrpljobmanagerDto();
            prpljobmanagerDto.setId(dbManager.getString(resultSet,1));
            prpljobmanagerDto.setJobrole(dbManager.getString(resultSet,2));
            prpljobmanagerDto.setHandlercode(dbManager.getString(resultSet,3));
            prpljobmanagerDto.setHandlername(dbManager.getString(resultSet,4));
            prpljobmanagerDto.setHandledept(dbManager.getString(resultSet,5));
            prpljobmanagerDto.setDeptname(dbManager.getString(resultSet,6));
            prpljobmanagerDto.setFlowintime(dbManager.getString(resultSet,7));
            prpljobmanagerDto.setModifytime(dbManager.getString(resultSet,8));
            prpljobmanagerDto.setMonth(dbManager.getString(resultSet,9));
            prpljobmanagerDto.setOperator(dbManager.getString(resultSet,10));
            prpljobmanagerDto.setOperatorid(dbManager.getString(resultSet, 11));
            prpljobmanagerDto.setSystemCode(dbManager.getString(resultSet, 12));
            prpljobmanagerDto.setClasscode(dbManager.getString(resultSet, 13));
/*
            if (prpLclaimDto.getStatus()==null||prpLclaimDto.getStatus().equals("") )
            {
               //	prpLclaimDto.setStatus("4");
               //过滤掉不能操作撤消的任务
               continue;
            }
*/ 
            collection.add(prpljobmanagerDto);
        }
        resultSet.close();
        log.info("DBPrpljobmanager.findByQueryConditions() success!");
        return collection;
    }
}
