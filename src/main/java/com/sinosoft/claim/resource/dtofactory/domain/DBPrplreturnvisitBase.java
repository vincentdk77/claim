package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplreturnvisitDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPLRETURNVISIT的数据访问对象基类<br>
 */
public class DBPrplreturnvisitBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrplreturnvisitBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrplreturnvisitBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prplreturnvisitDto prplreturnvisitDto
     * @throws Exception
     */
    public void insert(PrplreturnvisitDto prplreturnvisitDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Prplreturnvisit (");
        buffer.append("BusinessNo,");
        buffer.append("Nodetype,");
        buffer.append("Serialno,");
        buffer.append("Visitname,");
        buffer.append("Contact,");
        buffer.append("Recorderno,");
        buffer.append("Service,");
        buffer.append("Existissue,");
        buffer.append("Visitsuccess,");
        buffer.append("Visitnocause,");
        buffer.append("Visitopinion,");
        buffer.append("Enteringcode,");
        buffer.append("Enteringname,");
        buffer.append("Enteringcomcode,");
        buffer.append("Enteringtime,");
        buffer.append("Classcode ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prplreturnvisitDto.getBusinessNo()).append("',");
            debugBuffer.append("'").append(prplreturnvisitDto.getNodetype()).append("',");
            debugBuffer.append("'").append(prplreturnvisitDto.getSerialno()).append("',");
            debugBuffer.append("'").append(prplreturnvisitDto.getVisitname()).append("',");
            debugBuffer.append("'").append(prplreturnvisitDto.getContact()).append("',");
            debugBuffer.append("'").append(prplreturnvisitDto.getRecorderno()).append("',");
            debugBuffer.append("'").append(prplreturnvisitDto.getService()).append("',");
            debugBuffer.append("'").append(prplreturnvisitDto.getExistissue()).append("',");
            debugBuffer.append("'").append(prplreturnvisitDto.getVisitsuccess()).append("',");
            debugBuffer.append("'").append(prplreturnvisitDto.getVisitnocause()).append("',");
            debugBuffer.append("'").append(prplreturnvisitDto.getVisitopinion()).append("',");
            debugBuffer.append("'").append(prplreturnvisitDto.getEnteringcode()).append("',");
            debugBuffer.append("'").append(prplreturnvisitDto.getEnteringname()).append("',");
            debugBuffer.append("'").append(prplreturnvisitDto.getEnteringcomcode()).append("',");
            debugBuffer.append("'").append(prplreturnvisitDto.getEnteringtime()).append("',");
            debugBuffer.append("'").append(prplreturnvisitDto.getClasscode()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prplreturnvisitDto.getBusinessNo());
        dbManager.setString(2,prplreturnvisitDto.getNodetype());
        dbManager.setString(3,prplreturnvisitDto.getSerialno());
        dbManager.setString(4,prplreturnvisitDto.getVisitname());
        dbManager.setString(5,prplreturnvisitDto.getContact());
        dbManager.setString(6,prplreturnvisitDto.getRecorderno());
        dbManager.setString(7,prplreturnvisitDto.getService());
        dbManager.setString(8,prplreturnvisitDto.getExistissue());
        dbManager.setString(9,prplreturnvisitDto.getVisitsuccess());
        dbManager.setString(10,prplreturnvisitDto.getVisitnocause());
        dbManager.setString(11,prplreturnvisitDto.getVisitopinion());
        dbManager.setString(12,prplreturnvisitDto.getEnteringcode());
        dbManager.setString(13,prplreturnvisitDto.getEnteringname());
        dbManager.setString(14,prplreturnvisitDto.getEnteringcomcode());
        dbManager.setDateTime(15,prplreturnvisitDto.getEnteringtime());
        dbManager.setString(16,prplreturnvisitDto.getClasscode());
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
        buffer.append("INSERT INTO Prplreturnvisit (");
        buffer.append("BusinessNo,");
        buffer.append("Nodetype,");
        buffer.append("Serialno,");
        buffer.append("Visitname,");
        buffer.append("Contact,");
        buffer.append("Recorderno,");
        buffer.append("Service,");
        buffer.append("Existissue,");
        buffer.append("Visitsuccess,");
        buffer.append("Visitnocause,");
        buffer.append("Visitopinion,");
        buffer.append("Enteringcode,");
        buffer.append("Enteringname,");
        buffer.append("Enteringcomcode,");
        buffer.append("Enteringtime,");
        buffer.append("Classcode ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrplreturnvisitDto prplreturnvisitDto = (PrplreturnvisitDto)i.next();
            dbManager.setString(1,prplreturnvisitDto.getBusinessNo());
            dbManager.setString(2,prplreturnvisitDto.getNodetype());
            dbManager.setString(3,prplreturnvisitDto.getSerialno());
            dbManager.setString(4,prplreturnvisitDto.getVisitname());
            dbManager.setString(5,prplreturnvisitDto.getContact());
            dbManager.setString(6,prplreturnvisitDto.getRecorderno());
            dbManager.setString(7,prplreturnvisitDto.getService());
            dbManager.setString(8,prplreturnvisitDto.getExistissue());
            dbManager.setString(9,prplreturnvisitDto.getVisitsuccess());
            dbManager.setString(10,prplreturnvisitDto.getVisitnocause());
            dbManager.setString(11,prplreturnvisitDto.getVisitopinion());
            dbManager.setString(12,prplreturnvisitDto.getEnteringcode());
            dbManager.setString(13,prplreturnvisitDto.getEnteringname());
            dbManager.setString(14,prplreturnvisitDto.getEnteringcomcode());
            dbManager.setDateTime(15,prplreturnvisitDto.getEnteringtime());
            dbManager.setString(16,prplreturnvisitDto.getClasscode());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param registno REGISTNO
     * @param serialno SERIALNO
     * @throws Exception
     */
    public void delete(String registno,String serialno)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM Prplreturnvisit ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("BusinessNo=").append("'").append(registno).append("' AND ");
            debugBuffer.append("Serialno=").append("'").append(serialno).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("BusinessNo = ? And ");
        buffer.append("Serialno = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,registno);
        dbManager.setString(2,serialno);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prplreturnvisitDto prplreturnvisitDto
     * @throws Exception
     */
    public void update(PrplreturnvisitDto prplreturnvisitDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Prplreturnvisit SET ");
        buffer.append("Nodetype = ?, ");
        buffer.append("Visitname = ?, ");
        buffer.append("Contact = ?, ");
        buffer.append("Recorderno = ?, ");
        buffer.append("Service = ?, ");
        buffer.append("Existissue = ?, ");
        buffer.append("Visitsuccess = ?, ");
        buffer.append("Visitnocause = ?, ");
        buffer.append("Visitopinion = ?, ");
        buffer.append("Enteringcode = ?, ");
        buffer.append("Enteringname = ?, ");
        buffer.append("Enteringcomcode = ?, ");
        buffer.append("Enteringtime = ?, ");
        buffer.append("Classcode = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE Prplreturnvisit SET ");
            debugBuffer.append("Nodetype = '" + prplreturnvisitDto.getNodetype() + "', ");
            debugBuffer.append("Visitname = '" + prplreturnvisitDto.getVisitname() + "', ");
            debugBuffer.append("Contact = '" + prplreturnvisitDto.getContact() + "', ");
            debugBuffer.append("Recorderno = '" + prplreturnvisitDto.getRecorderno() + "', ");
            debugBuffer.append("Service = '" + prplreturnvisitDto.getService() + "', ");
            debugBuffer.append("Existissue = '" + prplreturnvisitDto.getExistissue() + "', ");
            debugBuffer.append("Visitsuccess = '" + prplreturnvisitDto.getVisitsuccess() + "', ");
            debugBuffer.append("Visitnocause = '" + prplreturnvisitDto.getVisitnocause() + "', ");
            debugBuffer.append("Visitopinion = '" + prplreturnvisitDto.getVisitopinion() + "', ");
            debugBuffer.append("Enteringcode = '" + prplreturnvisitDto.getEnteringcode() + "', ");
            debugBuffer.append("Enteringname = '" + prplreturnvisitDto.getEnteringname() + "', ");
            debugBuffer.append("Enteringcomcode = '" + prplreturnvisitDto.getEnteringcomcode() + "', ");
            debugBuffer.append("Enteringtime = '" + prplreturnvisitDto.getEnteringtime() + "', ");
            debugBuffer.append("Classcode = '" + prplreturnvisitDto.getClasscode() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("BusinessNo=").append("'").append(prplreturnvisitDto.getBusinessNo()).append("' AND ");
            debugBuffer.append("Serialno=").append("'").append(prplreturnvisitDto.getSerialno()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("BusinessNo = ? And ");
        buffer.append("Serialno = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prplreturnvisitDto.getNodetype());
        dbManager.setString(2,prplreturnvisitDto.getVisitname());
        dbManager.setString(3,prplreturnvisitDto.getContact());
        dbManager.setString(4,prplreturnvisitDto.getRecorderno());
        dbManager.setString(5,prplreturnvisitDto.getService());
        dbManager.setString(6,prplreturnvisitDto.getExistissue());
        dbManager.setString(7,prplreturnvisitDto.getVisitsuccess());
        dbManager.setString(8,prplreturnvisitDto.getVisitnocause());
        dbManager.setString(9,prplreturnvisitDto.getVisitopinion());
        dbManager.setString(10,prplreturnvisitDto.getEnteringcode());
        dbManager.setString(11,prplreturnvisitDto.getEnteringname());
        dbManager.setString(12,prplreturnvisitDto.getEnteringcomcode());
        dbManager.setDateTime(13,prplreturnvisitDto.getEnteringtime());
        dbManager.setString(14,prplreturnvisitDto.getClasscode());
        //设置条件字段;
        dbManager.setString(15,prplreturnvisitDto.getBusinessNo());
        dbManager.setString(16,prplreturnvisitDto.getSerialno());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param registno REGISTNO
     * @param serialno SERIALNO
     * @return PrplreturnvisitDto
     * @throws Exception
     */
    public PrplreturnvisitDto findByPrimaryKey(String registno,String serialno)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("BusinessNo,");
        buffer.append("Nodetype,");
        buffer.append("Serialno,");
        buffer.append("Visitname,");
        buffer.append("Contact,");
        buffer.append("Recorderno,");
        buffer.append("Service,");
        buffer.append("Existissue,");
        buffer.append("Visitsuccess,");
        buffer.append("Visitnocause,");
        buffer.append("Visitopinion,");
        buffer.append("Enteringcode,");
        buffer.append("Enteringname,");
        buffer.append("Enteringcomcode,");
        buffer.append("Enteringtime,");
        buffer.append("Classcode ");
        buffer.append("FROM Prplreturnvisit ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Registno=").append("'").append(registno).append("' AND ");
            debugBuffer.append("Serialno=").append("'").append(serialno).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Registno = ? And ");
        buffer.append("Serialno = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,registno);
        dbManager.setString(2,serialno);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrplreturnvisitDto prplreturnvisitDto = null;
        if(resultSet.next()){
            prplreturnvisitDto = new PrplreturnvisitDto();
            prplreturnvisitDto.setBusinessNo(dbManager.getString(resultSet,1));
            prplreturnvisitDto.setNodetype(dbManager.getString(resultSet,2));
            prplreturnvisitDto.setSerialno(dbManager.getString(resultSet,3));
            prplreturnvisitDto.setVisitname(dbManager.getString(resultSet,4));
            prplreturnvisitDto.setContact(dbManager.getString(resultSet,5));
            prplreturnvisitDto.setRecorderno(dbManager.getString(resultSet,6));
            prplreturnvisitDto.setService(dbManager.getString(resultSet,7));
            prplreturnvisitDto.setExistissue(dbManager.getString(resultSet,8));
            prplreturnvisitDto.setVisitsuccess(dbManager.getString(resultSet,9));
            prplreturnvisitDto.setVisitnocause(dbManager.getString(resultSet,10));
            prplreturnvisitDto.setVisitopinion(dbManager.getString(resultSet,11));
            prplreturnvisitDto.setEnteringcode(dbManager.getString(resultSet,12));
            prplreturnvisitDto.setEnteringname(dbManager.getString(resultSet,13));
            prplreturnvisitDto.setEnteringcomcode(dbManager.getString(resultSet,14));
            prplreturnvisitDto.setEnteringtime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,15));
            prplreturnvisitDto.setClasscode(dbManager.getString(resultSet,16));
        }
        resultSet.close();
        return prplreturnvisitDto;
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
        buffer.append("BusinessNo,");
        buffer.append("Nodetype,");
        buffer.append("Serialno,");
        buffer.append("Visitname,");
        buffer.append("Contact,");
        buffer.append("Recorderno,");
        buffer.append("Service,");
        buffer.append("Existissue,");
        buffer.append("Visitsuccess,");
        buffer.append("Visitnocause,");
        buffer.append("Visitopinion,");
        buffer.append("Enteringcode,");
        buffer.append("Enteringname,");
        buffer.append("Enteringcomcode,");
        buffer.append("Enteringtime,");
        buffer.append("Classcode ");
        buffer.append("FROM Prplreturnvisit WHERE ");
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
        PrplreturnvisitDto prplreturnvisitDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            prplreturnvisitDto = new PrplreturnvisitDto();
            prplreturnvisitDto.setBusinessNo(dbManager.getString(resultSet,"BusinessNo"));
            prplreturnvisitDto.setNodetype(dbManager.getString(resultSet,"Nodetype"));
            prplreturnvisitDto.setSerialno(dbManager.getString(resultSet,"Serialno"));
            prplreturnvisitDto.setVisitname(dbManager.getString(resultSet,"Visitname"));
            prplreturnvisitDto.setContact(dbManager.getString(resultSet,"Contact"));
            prplreturnvisitDto.setRecorderno(dbManager.getString(resultSet,"Recorderno"));
            prplreturnvisitDto.setService(dbManager.getString(resultSet,"Service"));
            prplreturnvisitDto.setExistissue(dbManager.getString(resultSet,"Existissue"));
            prplreturnvisitDto.setVisitsuccess(dbManager.getString(resultSet,"Visitsuccess"));
            prplreturnvisitDto.setVisitnocause(dbManager.getString(resultSet,"Visitnocause"));
            prplreturnvisitDto.setVisitopinion(dbManager.getString(resultSet,"Visitopinion"));
            prplreturnvisitDto.setEnteringcode(dbManager.getString(resultSet,"Enteringcode"));
            prplreturnvisitDto.setEnteringname(dbManager.getString(resultSet,"Enteringname"));
            prplreturnvisitDto.setEnteringcomcode(dbManager.getString(resultSet,"Enteringcomcode"));
            prplreturnvisitDto.setEnteringtime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"Enteringtime"));
            prplreturnvisitDto.setClasscode(dbManager.getString(resultSet,"Classcode"));
            collection.add(prplreturnvisitDto);
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
        buffer.append("DELETE FROM Prplreturnvisit WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        System.err.println(buffer);
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
        buffer.append("SELECT count(1) FROM Prplreturnvisit WHERE ");
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
