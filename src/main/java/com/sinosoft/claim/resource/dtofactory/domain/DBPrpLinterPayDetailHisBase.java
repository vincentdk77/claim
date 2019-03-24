package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterPayDetailHisDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是交互信息关联表------轨迹历史表的数据访问对象基类<br>
 */
public class DBPrpLinterPayDetailHisBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrpLinterPayDetailHisBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLinterPayDetailHisBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLinterPayDetailHisDto prpLinterPayDetailHisDto
     * @throws Exception
     */
    public void insert(PrpLinterPayDetailHisDto prpLinterPayDetailHisDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLinterPayDetailHis (");
        buffer.append("Id,");
        buffer.append("OutId,");
        buffer.append("PaymentNo,");
        buffer.append("PaySuccFlag,");
        buffer.append("VericSuccFlag,");
        buffer.append("InputDate ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLinterPayDetailHisDto.getId()).append("',");
            debugBuffer.append("'").append(prpLinterPayDetailHisDto.getOutId()).append("',");
            debugBuffer.append("'").append(prpLinterPayDetailHisDto.getPaymentNo()).append("',");
            debugBuffer.append("'").append(prpLinterPayDetailHisDto.getPaySuccFlag()).append("',");
            debugBuffer.append("'").append(prpLinterPayDetailHisDto.getVericSuccFlag()).append("',");
            debugBuffer.append("'").append(prpLinterPayDetailHisDto.getInputDate()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLinterPayDetailHisDto.getId());
        dbManager.setString(2,prpLinterPayDetailHisDto.getOutId());
        dbManager.setString(3,prpLinterPayDetailHisDto.getPaymentNo());
        dbManager.setString(4,prpLinterPayDetailHisDto.getPaySuccFlag());
        dbManager.setString(5,prpLinterPayDetailHisDto.getVericSuccFlag());
        dbManager.setDateTime(6,prpLinterPayDetailHisDto.getInputDate());
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
        buffer.append("INSERT INTO PrpLinterPayDetailHis (");
        buffer.append("Id,");
        buffer.append("OutId,");
        buffer.append("PaymentNo,");
        buffer.append("PaySuccFlag,");
        buffer.append("VericSuccFlag,");
        buffer.append("InputDate ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLinterPayDetailHisDto prpLinterPayDetailHisDto = (PrpLinterPayDetailHisDto)i.next();
            dbManager.setString(1,prpLinterPayDetailHisDto.getId());
            dbManager.setString(2,prpLinterPayDetailHisDto.getOutId());
            dbManager.setString(3,prpLinterPayDetailHisDto.getPaymentNo());
            dbManager.setString(4,prpLinterPayDetailHisDto.getPaySuccFlag());
            dbManager.setString(5,prpLinterPayDetailHisDto.getVericSuccFlag());
            dbManager.setDateTime(6,prpLinterPayDetailHisDto.getInputDate());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param id 主键pk
     * @throws Exception
     */
    public void delete(String id)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLinterPayDetailHis ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Id=").append("'").append(id).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Id = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,id);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLinterPayDetailHisDto prpLinterPayDetailHisDto
     * @throws Exception
     */
    public void update(PrpLinterPayDetailHisDto prpLinterPayDetailHisDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLinterPayDetailHis SET ");
        buffer.append("OutId = ?, ");
        buffer.append("PaymentNo = ?, ");
        buffer.append("PaySuccFlag = ?, ");
        buffer.append("VericSuccFlag = ?, ");
        buffer.append("InputDate = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLinterPayDetailHis SET ");
            debugBuffer.append("OutId = '" + prpLinterPayDetailHisDto.getOutId() + "', ");
            debugBuffer.append("PaymentNo = '" + prpLinterPayDetailHisDto.getPaymentNo() + "', ");
            debugBuffer.append("PaySuccFlag = '" + prpLinterPayDetailHisDto.getPaySuccFlag() + "', ");
            debugBuffer.append("VericSuccFlag = '" + prpLinterPayDetailHisDto.getVericSuccFlag() + "', ");
            debugBuffer.append("InputDate = '" + prpLinterPayDetailHisDto.getInputDate() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Id=").append("'").append(prpLinterPayDetailHisDto.getId()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Id = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prpLinterPayDetailHisDto.getOutId());
        dbManager.setString(2,prpLinterPayDetailHisDto.getPaymentNo());
        dbManager.setString(3,prpLinterPayDetailHisDto.getPaySuccFlag());
        dbManager.setString(4,prpLinterPayDetailHisDto.getVericSuccFlag());
        dbManager.setDateTime(5,prpLinterPayDetailHisDto.getInputDate());
        //设置条件字段;
        dbManager.setString(6,prpLinterPayDetailHisDto.getId());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param id 主键pk
     * @return PrpLinterPayDetailHisDto
     * @throws Exception
     */
    public PrpLinterPayDetailHisDto findByPrimaryKey(String id)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("Id,");
        buffer.append("OutId,");
        buffer.append("PaymentNo,");
        buffer.append("PaySuccFlag,");
        buffer.append("VericSuccFlag,");
        buffer.append("InputDate ");
        buffer.append("FROM PrpLinterPayDetailHis ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Id=").append("'").append(id).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Id = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,id);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLinterPayDetailHisDto prpLinterPayDetailHisDto = null;
        if(resultSet.next()){
            prpLinterPayDetailHisDto = new PrpLinterPayDetailHisDto();
            prpLinterPayDetailHisDto.setId(dbManager.getString(resultSet,1));
            prpLinterPayDetailHisDto.setOutId(dbManager.getString(resultSet,2));
            prpLinterPayDetailHisDto.setPaymentNo(dbManager.getString(resultSet,3));
            prpLinterPayDetailHisDto.setPaySuccFlag(dbManager.getString(resultSet,4));
            prpLinterPayDetailHisDto.setVericSuccFlag(dbManager.getString(resultSet,5));
            prpLinterPayDetailHisDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,6));
        }
        resultSet.close();
        return prpLinterPayDetailHisDto;
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
        buffer.append("Id,");
        buffer.append("OutId,");
        buffer.append("PaymentNo,");
        buffer.append("PaySuccFlag,");
        buffer.append("VericSuccFlag,");
        buffer.append("InputDate ");
        buffer.append("FROM PrpLinterPayDetailHis WHERE ");
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
        PrpLinterPayDetailHisDto prpLinterPayDetailHisDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLinterPayDetailHisDto = new PrpLinterPayDetailHisDto();
            prpLinterPayDetailHisDto.setId(dbManager.getString(resultSet,"Id"));
            prpLinterPayDetailHisDto.setOutId(dbManager.getString(resultSet,"OutId"));
            prpLinterPayDetailHisDto.setPaymentNo(dbManager.getString(resultSet,"PaymentNo"));
            prpLinterPayDetailHisDto.setPaySuccFlag(dbManager.getString(resultSet,"PaySuccFlag"));
            prpLinterPayDetailHisDto.setVericSuccFlag(dbManager.getString(resultSet,"VericSuccFlag"));
            prpLinterPayDetailHisDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"InputDate"));
            collection.add(prpLinterPayDetailHisDto);
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
        buffer.append("DELETE FROM PrpLinterPayDetailHis WHERE ");
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
        buffer.append("SELECT count(1) FROM PrpLinterPayDetailHis WHERE ");
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
