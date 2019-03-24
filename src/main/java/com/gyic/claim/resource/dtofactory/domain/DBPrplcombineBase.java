package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;

import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.PrplcombineDto;

public class DBPrplcombineBase{

    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrplcombineBase.class);

    public DBPrplcombineBase(DBManager dbManager){
        this.dbManager = dbManager;
    }


    public void insert(PrplcombineDto prplcombineDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Prplcombine (");
        buffer.append("Policyno,");
        buffer.append("Registno,");
        buffer.append("Combineno ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prplcombineDto.getPolicyno()).append("',");
            debugBuffer.append("'").append(prplcombineDto.getRegistno()).append("',");
            debugBuffer.append("'").append(prplcombineDto.getCombineno()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prplcombineDto.getPolicyno());
        dbManager.setString(2,prplcombineDto.getRegistno());
        dbManager.setString(3,prplcombineDto.getCombineno());
        dbManager.executePreparedUpdate();

    }


    public void insertAll(Collection collection)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Prplcombine (");
        buffer.append("Policyno,");
        buffer.append("Registno,");
        buffer.append("Combineno ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrplcombineDto prplcombineDto = (PrplcombineDto)i.next();
            dbManager.setString(1,prplcombineDto.getPolicyno());
            dbManager.setString(2,prplcombineDto.getRegistno());
            dbManager.setString(3,prplcombineDto.getCombineno());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    public void delete(String registno)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM Prplcombine ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Registno=").append("'").append(registno).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Registno = ?");

        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,registno);
        dbManager.executePreparedUpdate();
    }


    public void update(PrplcombineDto prplcombineDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Prplcombine SET ");
        buffer.append("Policyno = ?, ");
        buffer.append("Combineno = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE Prplcombine SET ");
            debugBuffer.append("Policyno = '" + prplcombineDto.getPolicyno() + "', ");
            debugBuffer.append("Combineno = '" + prplcombineDto.getCombineno() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Registno=").append("'").append(prplcombineDto.getRegistno()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Registno = ?");

        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prplcombineDto.getPolicyno());
        dbManager.setString(2,prplcombineDto.getCombineno());
        dbManager.setString(3,prplcombineDto.getRegistno());
        dbManager.executePreparedUpdate();

    }

    public PrplcombineDto findByPrimaryKey(String registno)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("SELECT ");
        buffer.append("Policyno,");
        buffer.append("Registno,");
        buffer.append("Combineno ");
        buffer.append("FROM Prplcombine ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Registno=").append("'").append(registno).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Registno = ?");

        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,registno);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrplcombineDto prplcombineDto = null;
        if(resultSet.next()){
            prplcombineDto = new PrplcombineDto();
            prplcombineDto.setPolicyno(dbManager.getString(resultSet,1));
            prplcombineDto.setRegistno(dbManager.getString(resultSet,2));
            prplcombineDto.setCombineno(dbManager.getString(resultSet,3));
        }
        resultSet.close();
        return prplcombineDto;
    }
    public Collection findByConditions(String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("SELECT ");
        buffer.append("Policyno,");
        buffer.append("Registno,");
        buffer.append("Combineno ");
        buffer.append("FROM Prplcombine WHERE ");
        buffer.append(conditions);
        boolean supportPaging = false;
        if (pageNo > 0){
            if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("Oracle")){
                buffer.insert(0,"SELECT * FROM ( SELECT row_.*, rownum rownum_ FROM (");
                buffer.append(") row_ WHERE rownum <= "+rowsPerPage * pageNo+") WHERE rownum_ > "+rowsPerPage * (pageNo - 1));
                supportPaging=true;
            }
            else if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("DB2")){
                String sql = buffer.toString();
                buffer.setLength(0);
                buffer.append("select * from ( select rownumber() over(");
                int orderByIndex = sql.toLowerCase().indexOf("order by");
                if ( orderByIndex>0 ) {
                   buffer.append( sql.substring(orderByIndex) );
                }
                buffer.append(") as rownumber_,");
                buffer.append(sql.substring( 6 ));
                buffer.append(" ) as temp_ where rownumber_");
                buffer.append(" between "+ (rowsPerPage * (pageNo - 1) + 1) +" and "+rowsPerPage * pageNo);
                supportPaging=true;
            }
        }
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        int count=0;
        if(supportPaging==false && pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        Collection collection = new ArrayList(rowsPerPage);
        PrplcombineDto prplcombineDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            prplcombineDto = new PrplcombineDto();
            prplcombineDto.setPolicyno(dbManager.getString(resultSet,"Policyno"));
            prplcombineDto.setRegistno(dbManager.getString(resultSet,"Registno"));
            prplcombineDto.setCombineno(dbManager.getString(resultSet,"Combineno"));
            collection.add(prplcombineDto);
        }
        resultSet.close();
        return collection;
    }

    public Collection findByConditions(String conditions)
            throws Exception{
        return findByConditions(conditions,0,0);
    }
    public int deleteByConditions(String conditions)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM Prplcombine WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        int count = dbManager.executeUpdate(buffer.toString());
        return count;
    }

    public int getCount(String conditions) 
        throws Exception{
        int count = -1;
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("SELECT count(*) FROM Prplcombine WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        return count;
    }
    /**
     * 按报案号查找对应事故号下的数据
     * @param conditions conditions
     * @return 满足条件的记录数
     * @throws Exception
     * @author qianxiantao
     */
    public ArrayList findByComBineNo(String combineNo) throws Exception{
        String statement = "select l.registno from prplcombine l where combineNo='"+combineNo+"'";      
        logger.debug(statement);
        PrplcombineDto combineDto = null;
        ArrayList arrList=new ArrayList();
        ResultSet resultSet = dbManager.executeQuery(statement);
        while(resultSet.next()){
        	combineDto = new PrplcombineDto();
            combineDto.setRegistno((dbManager.getString(resultSet,1)));   
            arrList.add(combineDto.getPolicyno());
            logger.info("DBSwfLogBase.findByConditions() success!");       
        }
            resultSet.close();
            return arrList;
    }
}
