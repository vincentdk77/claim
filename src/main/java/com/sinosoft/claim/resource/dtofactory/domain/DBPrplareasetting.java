package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplareasettingDto;
import com.sinosoft.claim.dto.domain.PrpljobmanagerDto;

/**
 * ����PRPLAREASETTING�����ݷ��ʶ�����<br>
 * ������ 2011-11-30 11:31:19.609<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrplareasetting extends DBPrplareasettingBase{
    private static Logger logger = Logger.getLogger(DBPrplareasetting.class);
    private static Log log = LogFactory.getLog(DBPrpLclaim.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrplareasetting(DBManager dbManager){
        super(dbManager);
    }
    
    /**
     * �������ӱ�prpljobmanager���в�ѯ��������
     * @param conditions String
     * @param pageNo int
     * @param rowsPerPage int
     * @throws Exception
     * @return Collection
     * Modify By sunhao 2004-08-24 Reason:���ӳ��ƺţ�����״̬������ʱ���ѯ�������ڲ�ѯ��������Ӱ���״̬
     */
    public Collection findByQueryConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
       String statement = "Select id,"+
                           "Handlercode, "+
                           "Handledept, "+
                           "handlername, "+
                           "Area," +
                           "Tel, "+
                           "Operator, "+
                           "Operatorid, "+
						   "Flowintime," +
						   "Modifytime," +
						   "classcode" +
						   " From Prplareasetting where " + conditions+"   order by flowintime desc" ;
       
        
        StringBuffer statementsql =new StringBuffer(statement);
        boolean supportPaging = false;//���ݿ��Ƿ�֧�ַ�ҳ
        if (pageNo > 0){
            //��Oracle�Ż�
     	   if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("Oracle")){
     		   statementsql.insert(0, "SELECT * FROM ( SELECT row_.*, rownum rownum_ FROM (");
     		   statementsql.append(") row_ WHERE rownum <= "+rowsPerPage * pageNo+") WHERE rownum_ > "+rowsPerPage * (pageNo - 1));
     		   supportPaging = true;//���ݿ��Ƿ�֧�ַ�ҳ
     		   statement =statementsql.toString();
     	   }
        }
        
        log.debug(statement);
        Collection collection = new ArrayList();
        PrplareasettingDto prplareasettingDto = null;
        ResultSet resultSet = dbManager.executeQuery(statement);
        int count=0; 
        if(supportPaging==false&&pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                        break;
                } 
            }
            prplareasettingDto = new PrplareasettingDto();
            prplareasettingDto.setId(dbManager.getString(resultSet,1));
            prplareasettingDto.setHandlercode(dbManager.getString(resultSet,2));
            prplareasettingDto.setHandledept(dbManager.getString(resultSet,3));
            prplareasettingDto.setHandlername(dbManager.getString(resultSet,4));
            prplareasettingDto.setArea(dbManager.getString(resultSet,5));
            prplareasettingDto.setTel(dbManager.getString(resultSet,6));
            prplareasettingDto.setOperator(dbManager.getString(resultSet,7));
            prplareasettingDto.setOperatorid(dbManager.getString(resultSet,8));
            prplareasettingDto.setFlowintime(dbManager.getString(resultSet, 9));
            prplareasettingDto.setModifytime(dbManager.getString(resultSet, 10));
            prplareasettingDto.setClasscode(dbManager.getString(resultSet, 11));

            collection.add(prplareasettingDto);
        }
        resultSet.close();
        log.info("DBPrpljobmanager.findByQueryConditions() success!");
        return collection;
    }
}
