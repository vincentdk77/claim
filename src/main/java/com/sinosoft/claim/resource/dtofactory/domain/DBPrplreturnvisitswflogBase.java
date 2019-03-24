package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplreturnvisitswflogDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPLRETURNVISITSWFLOG的数据访问对象基类<br>
 */
public class DBPrplreturnvisitswflogBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrplreturnvisitswflogBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrplreturnvisitswflogBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prplreturnvisitswflogDto prplreturnvisitswflogDto
     * @throws Exception
     */
    public void insert(PrplreturnvisitswflogDto prplreturnvisitswflogDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Prplreturnvisitswflog (");
        buffer.append("Businessno,");
        buffer.append("Nodetype,");
        buffer.append("Registno,");
        buffer.append("Policyno,");
        buffer.append("Comcode,");
        buffer.append("Comcodename,");
        buffer.append("Insuredname,");
        buffer.append("Reportdate,");
        buffer.append("Ceasedate,");
        buffer.append("Licenseno,");
        buffer.append("Handlercode,");
        buffer.append("Handlername,");
        buffer.append("Handlercomcode,");
        buffer.append("Flowintotime,");
        buffer.append("Ceasetime,");
        buffer.append("Classcode,");
        buffer.append("State, ");
        buffer.append("riskCode ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prplreturnvisitswflogDto.getBusinessno()).append("',");
            debugBuffer.append("'").append(prplreturnvisitswflogDto.getNodetype()).append("',");
            debugBuffer.append("'").append(prplreturnvisitswflogDto.getRegistno()).append("',");
            debugBuffer.append("'").append(prplreturnvisitswflogDto.getPolicyno()).append("',");
            debugBuffer.append("'").append(prplreturnvisitswflogDto.getComcode()).append("',");
            debugBuffer.append("'").append(prplreturnvisitswflogDto.getComcodename()).append("',");
            debugBuffer.append("'").append(prplreturnvisitswflogDto.getInsuredname()).append("',");
            debugBuffer.append("'").append(prplreturnvisitswflogDto.getReportdate()).append("',");
            debugBuffer.append("'").append(prplreturnvisitswflogDto.getCeasedate()).append("',");
            debugBuffer.append("'").append(prplreturnvisitswflogDto.getLicenseno()).append("',");
            debugBuffer.append("'").append(prplreturnvisitswflogDto.getHandlercode()).append("',");
            debugBuffer.append("'").append(prplreturnvisitswflogDto.getHandlername()).append("',");
            debugBuffer.append("'").append(prplreturnvisitswflogDto.getHandlercomcode()).append("',");
            debugBuffer.append("'").append(prplreturnvisitswflogDto.getFlowintotime()).append("',");
            debugBuffer.append("'").append(prplreturnvisitswflogDto.getCeasetime()).append("',");
            debugBuffer.append("'").append(prplreturnvisitswflogDto.getClasscode()).append("',");
            debugBuffer.append("'").append(prplreturnvisitswflogDto.getState()).append("')");
            debugBuffer.append("'").append(prplreturnvisitswflogDto.getRiskCode()).append("')");
            logger.debug(debugBuffer.toString());
        }
        
        System.err.println(buffer);
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prplreturnvisitswflogDto.getBusinessno());
        dbManager.setString(2,prplreturnvisitswflogDto.getNodetype());
        dbManager.setString(3,prplreturnvisitswflogDto.getRegistno());
        dbManager.setString(4,prplreturnvisitswflogDto.getPolicyno());
        dbManager.setString(5,prplreturnvisitswflogDto.getComcode());
        dbManager.setString(6,prplreturnvisitswflogDto.getComcodename());
        dbManager.setString(7,prplreturnvisitswflogDto.getInsuredname());
        dbManager.setDateTime(8,prplreturnvisitswflogDto.getReportdate());
        dbManager.setDateTime(9,prplreturnvisitswflogDto.getCeasedate());
        dbManager.setString(10,prplreturnvisitswflogDto.getLicenseno());
        dbManager.setString(11,prplreturnvisitswflogDto.getHandlercode());
        dbManager.setString(12,prplreturnvisitswflogDto.getHandlername());
        dbManager.setString(13,prplreturnvisitswflogDto.getHandlercomcode());
        dbManager.setDateTime(14,prplreturnvisitswflogDto.getFlowintotime());
        dbManager.setDateTime(15,prplreturnvisitswflogDto.getCeasetime());
        dbManager.setString(16,prplreturnvisitswflogDto.getClasscode());
        dbManager.setString(17,prplreturnvisitswflogDto.getState());
        dbManager.setString(18,prplreturnvisitswflogDto.getRiskCode());
        dbManager.executePreparedUpdate();

    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Prplreturnvisitswflog (");
        buffer.append("Businessno,");
        buffer.append("Nodetype,");
        buffer.append("Registno,");
        buffer.append("Policyno,");
        buffer.append("Comcode,");
        buffer.append("Comcodename,");
        buffer.append("Insuredname,");
        buffer.append("Reportdate,");
        buffer.append("Ceasedate,");
        buffer.append("Licenseno,");
        buffer.append("Handlercode,");
        buffer.append("Handlername,");
        buffer.append("Handlercomcode,");
        buffer.append("Flowintotime,");
        buffer.append("Ceasetime,");
        buffer.append("Classcode,");
        buffer.append("State, ");
        buffer.append("riskCode ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrplreturnvisitswflogDto prplreturnvisitswflogDto = (PrplreturnvisitswflogDto)i.next();
            dbManager.setString(1,prplreturnvisitswflogDto.getBusinessno());
            dbManager.setString(2,prplreturnvisitswflogDto.getNodetype());
            dbManager.setString(3,prplreturnvisitswflogDto.getRegistno());
            dbManager.setString(4,prplreturnvisitswflogDto.getPolicyno());
            dbManager.setString(5,prplreturnvisitswflogDto.getComcode());
            dbManager.setString(6,prplreturnvisitswflogDto.getComcodename());
            dbManager.setString(7,prplreturnvisitswflogDto.getInsuredname());
            dbManager.setDateTime(8,prplreturnvisitswflogDto.getReportdate());
            dbManager.setDateTime(9,prplreturnvisitswflogDto.getCeasedate());
            dbManager.setString(10,prplreturnvisitswflogDto.getLicenseno());
            dbManager.setString(11,prplreturnvisitswflogDto.getHandlercode());
            dbManager.setString(12,prplreturnvisitswflogDto.getHandlername());
            dbManager.setString(13,prplreturnvisitswflogDto.getHandlercomcode());
            dbManager.setDateTime(14,prplreturnvisitswflogDto.getFlowintotime());
            dbManager.setDateTime(15,prplreturnvisitswflogDto.getCeasetime());
            dbManager.setString(16,prplreturnvisitswflogDto.getClasscode());
            dbManager.setString(17,prplreturnvisitswflogDto.getState());
            dbManager.setString(18,prplreturnvisitswflogDto.getRiskCode());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param businessno BUSINESSNO
     * @param nodetype NODETYPE
     * @throws Exception
     */
    public void delete(String businessno,String nodetype)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM Prplreturnvisitswflog ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Businessno=").append("'").append(businessno).append("' AND ");
            debugBuffer.append("Nodetype=").append("'").append(nodetype).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Businessno = ? And ");
        buffer.append("Nodetype = ?");
        System.err.println(buffer);
        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,businessno);
        dbManager.setString(2,nodetype);
        
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prplreturnvisitswflogDto prplreturnvisitswflogDto
     * @throws Exception
     */
    public void update(PrplreturnvisitswflogDto prplreturnvisitswflogDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Prplreturnvisitswflog SET ");
        buffer.append("Registno = ?, ");
        buffer.append("Policyno = ?, ");
        buffer.append("Comcode = ?, ");
        buffer.append("Comcodename = ?, ");
        buffer.append("Insuredname = ?, ");
        buffer.append("Reportdate = ?, ");
        buffer.append("Ceasedate = ?, ");
        buffer.append("Licenseno = ?, ");
        buffer.append("Handlercode = ?, ");
        buffer.append("Handlername = ?, ");
        buffer.append("Handlercomcode = ?, ");
        buffer.append("Flowintotime = ?, ");
        buffer.append("Ceasetime = ?, ");
        buffer.append("Classcode = ?, ");
        buffer.append("State = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE Prplreturnvisitswflog SET ");
            debugBuffer.append("Registno = '" + prplreturnvisitswflogDto.getRegistno() + "', ");
            debugBuffer.append("Policyno = '" + prplreturnvisitswflogDto.getPolicyno() + "', ");
            debugBuffer.append("Comcode = '" + prplreturnvisitswflogDto.getComcode() + "', ");
            debugBuffer.append("Comcodename = '" + prplreturnvisitswflogDto.getComcodename() + "', ");
            debugBuffer.append("Insuredname = '" + prplreturnvisitswflogDto.getInsuredname() + "', ");
            debugBuffer.append("Reportdate = '" + prplreturnvisitswflogDto.getReportdate() + "', ");
            debugBuffer.append("Ceasedate = '" + prplreturnvisitswflogDto.getCeasedate() + "', ");
            debugBuffer.append("Licenseno = '" + prplreturnvisitswflogDto.getLicenseno() + "', ");
            debugBuffer.append("Handlercode = '" + prplreturnvisitswflogDto.getHandlercode() + "', ");
            debugBuffer.append("Handlername = '" + prplreturnvisitswflogDto.getHandlername() + "', ");
            debugBuffer.append("Handlercomcode = '" + prplreturnvisitswflogDto.getHandlercomcode() + "', ");
            debugBuffer.append("Flowintotime = '" + prplreturnvisitswflogDto.getFlowintotime() + "', ");
            debugBuffer.append("Ceasetime = '" + prplreturnvisitswflogDto.getCeasetime() + "', ");
            debugBuffer.append("Classcode = '" + prplreturnvisitswflogDto.getClasscode() + "', ");
            debugBuffer.append("State = '" + prplreturnvisitswflogDto.getState() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Businessno=").append("'").append(prplreturnvisitswflogDto.getBusinessno()).append("' AND ");
            debugBuffer.append("Nodetype=").append("'").append(prplreturnvisitswflogDto.getNodetype()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Businessno = ? And ");
        buffer.append("Nodetype = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prplreturnvisitswflogDto.getRegistno());
        dbManager.setString(2,prplreturnvisitswflogDto.getPolicyno());
        dbManager.setString(3,prplreturnvisitswflogDto.getComcode());
        dbManager.setString(4,prplreturnvisitswflogDto.getComcodename());
        dbManager.setString(5,prplreturnvisitswflogDto.getInsuredname());
        dbManager.setDateTime(6,prplreturnvisitswflogDto.getReportdate());
        dbManager.setDateTime(7,prplreturnvisitswflogDto.getCeasedate());
        dbManager.setString(8,prplreturnvisitswflogDto.getLicenseno());
        dbManager.setString(9,prplreturnvisitswflogDto.getHandlercode());
        dbManager.setString(10,prplreturnvisitswflogDto.getHandlername());
        dbManager.setString(11,prplreturnvisitswflogDto.getHandlercomcode());
        dbManager.setDateTime(12,prplreturnvisitswflogDto.getFlowintotime());
        dbManager.setDateTime(13,prplreturnvisitswflogDto.getCeasetime());
        dbManager.setString(14,prplreturnvisitswflogDto.getClasscode());
        dbManager.setString(15,prplreturnvisitswflogDto.getState());
        //设置条件字段;
        dbManager.setString(16,prplreturnvisitswflogDto.getBusinessno());
        dbManager.setString(17,prplreturnvisitswflogDto.getNodetype());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param businessno BUSINESSNO
     * @param nodetype NODETYPE
     * @return PrplreturnvisitswflogDto
     * @throws Exception
     */
    public PrplreturnvisitswflogDto findByPrimaryKey(String businessno,String nodetype)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("Businessno,");
        buffer.append("Nodetype,");
        buffer.append("Registno,");
        buffer.append("Policyno,");
        buffer.append("Comcode,");
        buffer.append("Comcodename,");
        buffer.append("Insuredname,");
        buffer.append("Reportdate,");
        buffer.append("Ceasedate,");
        buffer.append("Licenseno,");
        buffer.append("Handlercode,");
        buffer.append("Handlername,");
        buffer.append("Handlercomcode,");
        buffer.append("Flowintotime,");
        buffer.append("Ceasetime,");
        buffer.append("Classcode,");
        buffer.append("State, ");
        buffer.append("riskCode ");
        buffer.append("FROM Prplreturnvisitswflog ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Businessno=").append("'").append(businessno).append("' AND ");
            debugBuffer.append("Nodetype=").append("'").append(nodetype).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Businessno = ? And ");
        buffer.append("Nodetype = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,businessno);
        dbManager.setString(2,nodetype);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrplreturnvisitswflogDto prplreturnvisitswflogDto = null;
        if(resultSet.next()){
            prplreturnvisitswflogDto = new PrplreturnvisitswflogDto();
            prplreturnvisitswflogDto.setBusinessno(dbManager.getString(resultSet,1));
            prplreturnvisitswflogDto.setNodetype(dbManager.getString(resultSet,2));
            prplreturnvisitswflogDto.setRegistno(dbManager.getString(resultSet,3));
            prplreturnvisitswflogDto.setPolicyno(dbManager.getString(resultSet,4));
            prplreturnvisitswflogDto.setComcode(dbManager.getString(resultSet,5));
            prplreturnvisitswflogDto.setComcodename(dbManager.getString(resultSet,6));
            prplreturnvisitswflogDto.setInsuredname(dbManager.getString(resultSet,7));
            prplreturnvisitswflogDto.setReportdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,8));
            prplreturnvisitswflogDto.setCeasedate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,9));
            prplreturnvisitswflogDto.setLicenseno(dbManager.getString(resultSet,10));
            prplreturnvisitswflogDto.setHandlercode(dbManager.getString(resultSet,11));
            prplreturnvisitswflogDto.setHandlername(dbManager.getString(resultSet,12));
            prplreturnvisitswflogDto.setHandlercomcode(dbManager.getString(resultSet,13));
            prplreturnvisitswflogDto.setFlowintotime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,14));
            prplreturnvisitswflogDto.setCeasetime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,15));
            prplreturnvisitswflogDto.setClasscode(dbManager.getString(resultSet,16));
            prplreturnvisitswflogDto.setState(dbManager.getString(resultSet,17));
            prplreturnvisitswflogDto.setRiskCode(dbManager.getString(resultSet,18));
        }
        resultSet.close();
        return prplreturnvisitswflogDto;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("Businessno,");
        buffer.append("Nodetype,");
        buffer.append("Registno,");
        buffer.append("Policyno,");
        buffer.append("Comcode,");
        buffer.append("Comcodename,");
        buffer.append("Insuredname,");
        buffer.append("Reportdate,");
        buffer.append("Ceasedate,");
        buffer.append("Licenseno,");
        buffer.append("Handlercode,");
        buffer.append("Handlername,");
        buffer.append("Handlercomcode,");
        buffer.append("Flowintotime,");
        buffer.append("Ceasetime,");
        buffer.append("Classcode,");
        buffer.append("State ");
        buffer.append("FROM Prplreturnvisitswflog WHERE ");
        buffer.append(conditions);
        boolean supportPaging = false;//数据库是否支持分页
        if (pageNo > 0){
            //对Oracle优化
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

        //定义返回结果集合
        Collection collection = new ArrayList(rowsPerPage);
        PrplreturnvisitswflogDto prplreturnvisitswflogDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            prplreturnvisitswflogDto = new PrplreturnvisitswflogDto();
            prplreturnvisitswflogDto.setBusinessno(dbManager.getString(resultSet,"Businessno"));
            prplreturnvisitswflogDto.setNodetype(dbManager.getString(resultSet,"Nodetype"));
            prplreturnvisitswflogDto.setRegistno(dbManager.getString(resultSet,"Registno"));
            prplreturnvisitswflogDto.setPolicyno(dbManager.getString(resultSet,"Policyno"));
            prplreturnvisitswflogDto.setComcode(dbManager.getString(resultSet,"Comcode"));
            prplreturnvisitswflogDto.setComcodename(dbManager.getString(resultSet,"Comcodename"));
            prplreturnvisitswflogDto.setInsuredname(dbManager.getString(resultSet,"Insuredname"));
            prplreturnvisitswflogDto.setReportdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"Reportdate"));
            prplreturnvisitswflogDto.setCeasedate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"Ceasedate"));
            prplreturnvisitswflogDto.setLicenseno(dbManager.getString(resultSet,"Licenseno"));
            prplreturnvisitswflogDto.setHandlercode(dbManager.getString(resultSet,"Handlercode"));
            prplreturnvisitswflogDto.setHandlername(dbManager.getString(resultSet,"Handlername"));
            prplreturnvisitswflogDto.setHandlercomcode(dbManager.getString(resultSet,"Handlercomcode"));
            prplreturnvisitswflogDto.setFlowintotime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"Flowintotime"));
            prplreturnvisitswflogDto.setCeasetime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"Ceasetime"));
            prplreturnvisitswflogDto.setClasscode(dbManager.getString(resultSet,"Classcode"));
            prplreturnvisitswflogDto.setState(dbManager.getString(resultSet,"State"));
            collection.add(prplreturnvisitswflogDto);
        }
        resultSet.close();
        return collection;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
            throws Exception{
        return findByConditions(conditions,0,0);
    }

    /**
     * 按条件删除数据
     * @param conditions 查询条件
     * @return 删除的行数
     * @throws Exception
     */
    public int deleteByConditions(String conditions)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM Prplreturnvisitswflog WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        int count = dbManager.executeUpdate(buffer.toString());
        return count;
    }

    /**
     * 查询满足模糊查询条件的记录数
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getCount(String conditions) 
        throws Exception{
        int count = -1;
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("SELECT count(*) FROM Prplreturnvisitswflog WHERE ");
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
}
