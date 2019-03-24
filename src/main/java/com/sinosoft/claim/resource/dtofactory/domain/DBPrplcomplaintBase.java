package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplcomplaintDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPLCOMPLAINT的数据访问对象基类<br>
 */
public class DBPrplcomplaintBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrplcomplaintBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrplcomplaintBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prplcomplaintDto prplcomplaintDto
     * @throws Exception
     */
    public void insert(PrplcomplaintDto prplcomplaintDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Prplcomplaint (");
        buffer.append("Complaintno,");
        buffer.append("Complaintdate,");
        buffer.append("Complainttype,");
        buffer.append("Bycomplaintcomcode,");
        buffer.append("Bycomplaintcode,");
        buffer.append("Complaintname,");
        buffer.append("Callno,");
        buffer.append("Telephone,");
        buffer.append("Complaintcause,");
        buffer.append("Detailedcause,");
        buffer.append("Whethercomplaint,");
        buffer.append("Whethertrack,");
        buffer.append("Registno,");
        buffer.append("Recordingno,");
        buffer.append("Handlercode,");
        buffer.append("Handlername,");
        buffer.append("Handlercomcode,");
        buffer.append("Complaintinfo,");
        buffer.append("Complaintopinion,");
        buffer.append("Transactorname,");
        buffer.append("Transactorcode,");
        buffer.append("Handlerdate,");
        buffer.append("Transactordate,");
        buffer.append("Classcode,");
        buffer.append("State ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prplcomplaintDto.getComplaintno()).append("',");
            debugBuffer.append("'").append(prplcomplaintDto.getComplaintdate()).append("',");
            debugBuffer.append("'").append(prplcomplaintDto.getComplainttype()).append("',");
            debugBuffer.append("'").append(prplcomplaintDto.getBycomplaintcomcode()).append("',");
            debugBuffer.append("'").append(prplcomplaintDto.getBycomplaintcode()).append("',");
            debugBuffer.append("'").append(prplcomplaintDto.getComplaintname()).append("',");
            debugBuffer.append("'").append(prplcomplaintDto.getCallno()).append("',");
            debugBuffer.append("'").append(prplcomplaintDto.getTelephone()).append("',");
            debugBuffer.append("'").append(prplcomplaintDto.getComplaintcause()).append("',");
            debugBuffer.append("'").append(prplcomplaintDto.getDetailedcause()).append("',");
            debugBuffer.append("'").append(prplcomplaintDto.getWhethercomplaint()).append("',");
            debugBuffer.append("'").append(prplcomplaintDto.getWhethertrack()).append("',");
            debugBuffer.append("'").append(prplcomplaintDto.getRegistno()).append("',");
            debugBuffer.append("'").append(prplcomplaintDto.getRecordingno()).append("',");
            debugBuffer.append("'").append(prplcomplaintDto.getHandlercode()).append("',");
            debugBuffer.append("'").append(prplcomplaintDto.getHandlername()).append("',");
            debugBuffer.append("'").append(prplcomplaintDto.getHandlercomcode()).append("',");
            debugBuffer.append("'").append(prplcomplaintDto.getComplaintinfo()).append("',");
            debugBuffer.append("'").append(prplcomplaintDto.getComplaintopinion()).append("',");
            debugBuffer.append("'").append(prplcomplaintDto.getTransactorname()).append("',");
            debugBuffer.append("'").append(prplcomplaintDto.getTransactorcode()).append("',");
            debugBuffer.append("'").append(prplcomplaintDto.getHandlerdate()).append("',");
            debugBuffer.append("'").append(prplcomplaintDto.getTransactordate()).append("',");
            debugBuffer.append("'").append(prplcomplaintDto.getClasscode()).append("',");
            debugBuffer.append("'").append(prplcomplaintDto.getState()).append("')");
            logger.debug(debugBuffer.toString());
        }
        
        System.err.println(buffer);
        
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prplcomplaintDto.getComplaintno());
        dbManager.setDateTime(2,prplcomplaintDto.getComplaintdate());
        dbManager.setString(3,prplcomplaintDto.getComplainttype());
        dbManager.setString(4,prplcomplaintDto.getBycomplaintcomcode());
        dbManager.setString(5,prplcomplaintDto.getBycomplaintcode());
        dbManager.setString(6,prplcomplaintDto.getComplaintname());
        dbManager.setString(7,prplcomplaintDto.getCallno());
        dbManager.setString(8,prplcomplaintDto.getTelephone());
        dbManager.setString(9,prplcomplaintDto.getComplaintcause());
        dbManager.setString(10,prplcomplaintDto.getDetailedcause());
        dbManager.setString(11,prplcomplaintDto.getWhethercomplaint());
        dbManager.setString(12,prplcomplaintDto.getWhethertrack());
        dbManager.setString(13,prplcomplaintDto.getRegistno());
        dbManager.setString(14,prplcomplaintDto.getRecordingno());
        dbManager.setString(15,prplcomplaintDto.getHandlercode());
        dbManager.setString(16,prplcomplaintDto.getHandlername());
        dbManager.setString(17,prplcomplaintDto.getHandlercomcode());
        dbManager.setString(18,prplcomplaintDto.getComplaintinfo());
        dbManager.setString(19,prplcomplaintDto.getComplaintopinion());
        dbManager.setString(20,prplcomplaintDto.getTransactorname());
        dbManager.setString(21,prplcomplaintDto.getTransactorcode());
        dbManager.setDateTime(22,prplcomplaintDto.getHandlerdate());
        dbManager.setDateTime(23,prplcomplaintDto.getTransactordate());
        dbManager.setString(24,prplcomplaintDto.getClasscode());
        dbManager.setString(25,prplcomplaintDto.getState());
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
        buffer.append("INSERT INTO Prplcomplaint (");
        buffer.append("Complaintno,");
        buffer.append("Complaintdate,");
        buffer.append("Complainttype,");
        buffer.append("Bycomplaintcomcode,");
        buffer.append("Bycomplaintcode,");
        buffer.append("Complaintname,");
        buffer.append("Callno,");
        buffer.append("Telephone,");
        buffer.append("Complaintcause,");
        buffer.append("Detailedcause,");
        buffer.append("Whethercomplaint,");
        buffer.append("Whethertrack,");
        buffer.append("Registno,");
        buffer.append("Recordingno,");
        buffer.append("Handlercode,");
        buffer.append("Handlername,");
        buffer.append("Handlercomcode,");
        buffer.append("Complaintinfo,");
        buffer.append("Complaintopinion,");
        buffer.append("Transactorname,");
        buffer.append("Transactorcode,");
        buffer.append("Handlerdate,");
        buffer.append("Transactordate,");
        buffer.append("Classcode,");
        buffer.append("State ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrplcomplaintDto prplcomplaintDto = (PrplcomplaintDto)i.next();
            dbManager.setString(1,prplcomplaintDto.getComplaintno());
            dbManager.setDateTime(2,prplcomplaintDto.getComplaintdate());
            dbManager.setString(3,prplcomplaintDto.getComplainttype());
            dbManager.setString(4,prplcomplaintDto.getBycomplaintcomcode());
            dbManager.setString(5,prplcomplaintDto.getBycomplaintcode());
            dbManager.setString(6,prplcomplaintDto.getComplaintname());
            dbManager.setString(7,prplcomplaintDto.getCallno());
            dbManager.setString(8,prplcomplaintDto.getTelephone());
            dbManager.setString(9,prplcomplaintDto.getComplaintcause());
            dbManager.setString(10,prplcomplaintDto.getDetailedcause());
            dbManager.setString(11,prplcomplaintDto.getWhethercomplaint());
            dbManager.setString(12,prplcomplaintDto.getWhethertrack());
            dbManager.setString(13,prplcomplaintDto.getRegistno());
            dbManager.setString(14,prplcomplaintDto.getRecordingno());
            dbManager.setString(15,prplcomplaintDto.getHandlercode());
            dbManager.setString(16,prplcomplaintDto.getHandlername());
            dbManager.setString(17,prplcomplaintDto.getHandlercomcode());
            dbManager.setString(18,prplcomplaintDto.getComplaintinfo());
            dbManager.setString(19,prplcomplaintDto.getComplaintopinion());
            dbManager.setString(20,prplcomplaintDto.getTransactorname());
            dbManager.setString(21,prplcomplaintDto.getTransactorcode());
            dbManager.setDateTime(22,prplcomplaintDto.getHandlerdate());
            dbManager.setDateTime(23,prplcomplaintDto.getTransactordate());
            dbManager.setString(24,prplcomplaintDto.getClasscode());
            dbManager.setString(25,prplcomplaintDto.getState());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param complaintno COMPLAINTNO
     * @throws Exception
     */
    public void delete(String complaintno)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM Prplcomplaint ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Complaintno=").append("'").append(complaintno).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Complaintno = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,complaintno);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prplcomplaintDto prplcomplaintDto
     * @throws Exception
     */
    public void update(PrplcomplaintDto prplcomplaintDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Prplcomplaint SET ");
        buffer.append("Complaintdate = ?, ");
        buffer.append("Complainttype = ?, ");
        buffer.append("Bycomplaintcomcode = ?, ");
        buffer.append("Bycomplaintcode = ?, ");
        buffer.append("Complaintname = ?, ");
        buffer.append("Callno = ?, ");
        buffer.append("Telephone = ?, ");
        buffer.append("Complaintcause = ?, ");
        buffer.append("Detailedcause = ?, ");
        buffer.append("Whethercomplaint = ?, ");
        buffer.append("Whethertrack = ?, ");
        buffer.append("Registno = ?, ");
        buffer.append("Recordingno = ?, ");
        buffer.append("Handlercode = ?, ");
        buffer.append("Handlername = ?, ");
        buffer.append("Handlercomcode = ?, ");
        buffer.append("Complaintinfo = ?, ");
        buffer.append("Complaintopinion = ?, ");
        buffer.append("Transactorname = ?, ");
        buffer.append("Transactorcode = ?, ");
        buffer.append("Handlerdate = ?, ");
        buffer.append("Transactordate = ?, ");
        buffer.append("Classcode = ?, ");
        buffer.append("State = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE Prplcomplaint SET ");
            debugBuffer.append("Complaintdate = '" + prplcomplaintDto.getComplaintdate() + "', ");
            debugBuffer.append("Complainttype = '" + prplcomplaintDto.getComplainttype() + "', ");
            debugBuffer.append("Bycomplaintcomcode = '" + prplcomplaintDto.getBycomplaintcomcode() + "', ");
            debugBuffer.append("Bycomplaintcode = '" + prplcomplaintDto.getBycomplaintcode() + "', ");
            debugBuffer.append("Complaintname = '" + prplcomplaintDto.getComplaintname() + "', ");
            debugBuffer.append("Callno = '" + prplcomplaintDto.getCallno() + "', ");
            debugBuffer.append("Telephone = '" + prplcomplaintDto.getTelephone() + "', ");
            debugBuffer.append("Complaintcause = '" + prplcomplaintDto.getComplaintcause() + "', ");
            debugBuffer.append("Detailedcause = '" + prplcomplaintDto.getDetailedcause() + "', ");
            debugBuffer.append("Whethercomplaint = '" + prplcomplaintDto.getWhethercomplaint() + "', ");
            debugBuffer.append("Whethertrack = '" + prplcomplaintDto.getWhethertrack() + "', ");
            debugBuffer.append("Registno = '" + prplcomplaintDto.getRegistno() + "', ");
            debugBuffer.append("Recordingno = '" + prplcomplaintDto.getRecordingno() + "', ");
            debugBuffer.append("Handlercode = '" + prplcomplaintDto.getHandlercode() + "', ");
            debugBuffer.append("Handlername = '" + prplcomplaintDto.getHandlername() + "', ");
            debugBuffer.append("Handlercomcode = '" + prplcomplaintDto.getHandlercomcode() + "', ");
            debugBuffer.append("Complaintinfo = '" + prplcomplaintDto.getComplaintinfo() + "', ");
            debugBuffer.append("Complaintopinion = '" + prplcomplaintDto.getComplaintopinion() + "', ");
            debugBuffer.append("Transactorname = '" + prplcomplaintDto.getTransactorname() + "', ");
            debugBuffer.append("Transactorcode = '" + prplcomplaintDto.getTransactorcode() + "', ");
            debugBuffer.append("Handlerdate = '" + prplcomplaintDto.getHandlerdate() + "', ");
            debugBuffer.append("Transactordate = '" + prplcomplaintDto.getTransactordate() + "', ");
            debugBuffer.append("Classcode = '" + prplcomplaintDto.getClasscode() + "', ");
            debugBuffer.append("State = '" + prplcomplaintDto.getState() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Complaintno=").append("'").append(prplcomplaintDto.getComplaintno()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Complaintno = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setDateTime(1,prplcomplaintDto.getComplaintdate());
        dbManager.setString(2,prplcomplaintDto.getComplainttype());
        dbManager.setString(3,prplcomplaintDto.getBycomplaintcomcode());
        dbManager.setString(4,prplcomplaintDto.getBycomplaintcode());
        dbManager.setString(5,prplcomplaintDto.getComplaintname());
        dbManager.setString(6,prplcomplaintDto.getCallno());
        dbManager.setString(7,prplcomplaintDto.getTelephone());
        dbManager.setString(8,prplcomplaintDto.getComplaintcause());
        dbManager.setString(9,prplcomplaintDto.getDetailedcause());
        dbManager.setString(10,prplcomplaintDto.getWhethercomplaint());
        dbManager.setString(11,prplcomplaintDto.getWhethertrack());
        dbManager.setString(12,prplcomplaintDto.getRegistno());
        dbManager.setString(13,prplcomplaintDto.getRecordingno());
        dbManager.setString(14,prplcomplaintDto.getHandlercode());
        dbManager.setString(15,prplcomplaintDto.getHandlername());
        dbManager.setString(16,prplcomplaintDto.getHandlercomcode());
        dbManager.setString(17,prplcomplaintDto.getComplaintinfo());
        dbManager.setString(18,prplcomplaintDto.getComplaintopinion());
        dbManager.setString(19,prplcomplaintDto.getTransactorname());
        dbManager.setString(20,prplcomplaintDto.getTransactorcode());
        dbManager.setDateTime(21,prplcomplaintDto.getHandlerdate());
        dbManager.setDateTime(22,prplcomplaintDto.getTransactordate());
        dbManager.setString(23,prplcomplaintDto.getClasscode());
        dbManager.setString(24,prplcomplaintDto.getState());
        //设置条件字段;
        dbManager.setString(25,prplcomplaintDto.getComplaintno());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param complaintno COMPLAINTNO
     * @return PrplcomplaintDto
     * @throws Exception
     */
    public PrplcomplaintDto findByPrimaryKey(String complaintno)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("Complaintno,");
        buffer.append("Complaintdate,");
        buffer.append("Complainttype,");
        buffer.append("Bycomplaintcomcode,");
        buffer.append("Bycomplaintcode,");
        buffer.append("Complaintname,");
        buffer.append("Callno,");
        buffer.append("Telephone,");
        buffer.append("Complaintcause,");
        buffer.append("Detailedcause,");
        buffer.append("Whethercomplaint,");
        buffer.append("Whethertrack,");
        buffer.append("Registno,");
        buffer.append("Recordingno,");
        buffer.append("Handlercode,");
        buffer.append("Handlername,");
        buffer.append("Handlercomcode,");
        buffer.append("Complaintinfo,");
        buffer.append("Complaintopinion,");
        buffer.append("Transactorname,");
        buffer.append("Transactorcode,");
        buffer.append("Handlerdate,");
        buffer.append("Transactordate,");
        buffer.append("Classcode,");
        buffer.append("State ");
        buffer.append("FROM Prplcomplaint ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Complaintno=").append("'").append(complaintno).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Complaintno = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,complaintno);
        System.err.println(buffer);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrplcomplaintDto prplcomplaintDto = null;
        if(resultSet.next()){
            prplcomplaintDto = new PrplcomplaintDto();
            prplcomplaintDto.setComplaintno(dbManager.getString(resultSet,1));
            prplcomplaintDto.setComplaintdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,2));
            prplcomplaintDto.setComplainttype(dbManager.getString(resultSet,3));
            prplcomplaintDto.setBycomplaintcomcode(dbManager.getString(resultSet,4));
            prplcomplaintDto.setBycomplaintcode(dbManager.getString(resultSet,5));
            prplcomplaintDto.setComplaintname(dbManager.getString(resultSet,6));
            prplcomplaintDto.setCallno(dbManager.getString(resultSet,7));
            prplcomplaintDto.setTelephone(dbManager.getString(resultSet,8));
            prplcomplaintDto.setComplaintcause(dbManager.getString(resultSet,9));
            prplcomplaintDto.setDetailedcause(dbManager.getString(resultSet,10));
            prplcomplaintDto.setWhethercomplaint(dbManager.getString(resultSet,11));
            prplcomplaintDto.setWhethertrack(dbManager.getString(resultSet,12));
            prplcomplaintDto.setRegistno(dbManager.getString(resultSet,13));
            prplcomplaintDto.setRecordingno(dbManager.getString(resultSet,14));
            prplcomplaintDto.setHandlercode(dbManager.getString(resultSet,15));
            prplcomplaintDto.setHandlername(dbManager.getString(resultSet,16));
            prplcomplaintDto.setHandlercomcode(dbManager.getString(resultSet,17));
            prplcomplaintDto.setComplaintinfo(dbManager.getString(resultSet,18));
            prplcomplaintDto.setComplaintopinion(dbManager.getString(resultSet,19));
            prplcomplaintDto.setTransactorname(dbManager.getString(resultSet,20));
            prplcomplaintDto.setTransactorcode(dbManager.getString(resultSet,21));
            prplcomplaintDto.setHandlerdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,22));
            prplcomplaintDto.setTransactordate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,23));
            prplcomplaintDto.setClasscode(dbManager.getString(resultSet,24));
            prplcomplaintDto.setState(dbManager.getString(resultSet,25));
        }
        resultSet.close();
        return prplcomplaintDto;
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
        buffer.append("Complaintno,");
        buffer.append("Complaintdate,");
        buffer.append("Complainttype,");
        buffer.append("Bycomplaintcomcode,");
        buffer.append("Bycomplaintcode,");
        buffer.append("Complaintname,");
        buffer.append("Callno,");
        buffer.append("Telephone,");
        buffer.append("Complaintcause,");
        buffer.append("Detailedcause,");
        buffer.append("Whethercomplaint,");
        buffer.append("Whethertrack,");
        buffer.append("Registno,");
        buffer.append("Recordingno,");
        buffer.append("Handlercode,");
        buffer.append("Handlername,");
        buffer.append("Handlercomcode,");
        buffer.append("Complaintinfo,");
        buffer.append("Complaintopinion,");
        buffer.append("Transactorname,");
        buffer.append("Transactorcode,");
        buffer.append("Handlerdate,");
        buffer.append("Transactordate,");
        buffer.append("Classcode,");
        buffer.append("State ");
        buffer.append("FROM Prplcomplaint WHERE ");
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
        System.err.println(buffer);
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        int count=0;
        if(supportPaging==false && pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        //定义返回结果集合
        Collection collection = new ArrayList(rowsPerPage);
        PrplcomplaintDto prplcomplaintDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            prplcomplaintDto = new PrplcomplaintDto();
            prplcomplaintDto.setComplaintno(dbManager.getString(resultSet,"Complaintno"));
            prplcomplaintDto.setComplaintdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Complaintdate"));
            prplcomplaintDto.setComplainttype(dbManager.getString(resultSet,"Complainttype"));
            prplcomplaintDto.setBycomplaintcomcode(dbManager.getString(resultSet,"Bycomplaintcomcode"));
            prplcomplaintDto.setBycomplaintcode(dbManager.getString(resultSet,"Bycomplaintcode"));
            prplcomplaintDto.setComplaintname(dbManager.getString(resultSet,"Complaintname"));
            prplcomplaintDto.setCallno(dbManager.getString(resultSet,"Callno"));
            prplcomplaintDto.setTelephone(dbManager.getString(resultSet,"Telephone"));
            prplcomplaintDto.setComplaintcause(dbManager.getString(resultSet,"Complaintcause"));
            prplcomplaintDto.setDetailedcause(dbManager.getString(resultSet,"Detailedcause"));
            prplcomplaintDto.setWhethercomplaint(dbManager.getString(resultSet,"Whethercomplaint"));
            prplcomplaintDto.setWhethertrack(dbManager.getString(resultSet,"Whethertrack"));
            prplcomplaintDto.setRegistno(dbManager.getString(resultSet,"Registno"));
            prplcomplaintDto.setRecordingno(dbManager.getString(resultSet,"Recordingno"));
            prplcomplaintDto.setHandlercode(dbManager.getString(resultSet,"Handlercode"));
            prplcomplaintDto.setHandlername(dbManager.getString(resultSet,"Handlername"));
            prplcomplaintDto.setHandlercomcode(dbManager.getString(resultSet,"Handlercomcode"));
            prplcomplaintDto.setComplaintinfo(dbManager.getString(resultSet,"Complaintinfo"));
            prplcomplaintDto.setComplaintopinion(dbManager.getString(resultSet,"Complaintopinion"));
            prplcomplaintDto.setTransactorname(dbManager.getString(resultSet,"Transactorname"));
            prplcomplaintDto.setTransactorcode(dbManager.getString(resultSet,"Transactorcode"));
            prplcomplaintDto.setHandlerdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"Handlerdate"));
            prplcomplaintDto.setTransactordate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"Transactordate"));
            prplcomplaintDto.setClasscode(dbManager.getString(resultSet,"Classcode"));
            prplcomplaintDto.setState(dbManager.getString(resultSet,"State"));
            collection.add(prplcomplaintDto);
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
        buffer.append("DELETE FROM Prplcomplaint WHERE ");
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
        buffer.append("SELECT count(1) FROM Prplcomplaint WHERE ");
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
