package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplfiscalpaymainDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPLFISCALpaymain的数据访问对象基类<br>
 */
public class DBPrplfiscalpaymainBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrplfiscalpaymainBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrplfiscalpaymainBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prplfiscalpaymainDto prplfiscalpaymainDto
     * @throws Exception
     */
    public void insert(PrplfiscalpaymainDto prplfiscalpaymainDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Prplfiscalpaymain (");
        buffer.append("Fiscalno,");
        buffer.append("Registno,");
        buffer.append("Sumamount,");
        buffer.append("Operatorcode,");
        buffer.append("Inputdate,");
        buffer.append("Operatorcomcode,");
        buffer.append("Vflag,");
        buffer.append("Status, ");
        buffer.append("paymenttype ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prplfiscalpaymainDto.getFiscalno()).append("',");
            debugBuffer.append("'").append(prplfiscalpaymainDto.getRegistno()).append("',");
            debugBuffer.append("").append(prplfiscalpaymainDto.getSumamount()).append(",");
            debugBuffer.append("'").append(prplfiscalpaymainDto.getOperatorcode()).append("',");
            debugBuffer.append("'").append(prplfiscalpaymainDto.getInputdate()).append("',");
            debugBuffer.append("'").append(prplfiscalpaymainDto.getOperatorcomcode()).append("',");
            debugBuffer.append("'").append(prplfiscalpaymainDto.getVflag()).append("',");
            debugBuffer.append("'").append(prplfiscalpaymainDto.getStatus()).append("',");
            debugBuffer.append("'").append(prplfiscalpaymainDto.getPaymenttype()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prplfiscalpaymainDto.getFiscalno());
        dbManager.setString(2,prplfiscalpaymainDto.getRegistno());
        dbManager.setDouble(3,prplfiscalpaymainDto.getSumamount());
        dbManager.setString(4,prplfiscalpaymainDto.getOperatorcode());
        dbManager.setDateTime(5,prplfiscalpaymainDto.getInputdate());
        dbManager.setString(6,prplfiscalpaymainDto.getOperatorcomcode());
        dbManager.setString(7,prplfiscalpaymainDto.getVflag());
        dbManager.setString(8,prplfiscalpaymainDto.getStatus());
        dbManager.setString(9,prplfiscalpaymainDto.getPaymenttype());
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
        buffer.append("INSERT INTO Prplfiscalpaymain (");
        buffer.append("Fiscalno,");
        buffer.append("Registno,");
        buffer.append("Sumamount,");
        buffer.append("Operatorcode,");
        buffer.append("Inputdate,");
        buffer.append("Operatorcomcode,");
        buffer.append("Vflag,");
        buffer.append("Status, ");
        buffer.append("paymenttype ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrplfiscalpaymainDto prplfiscalpaymainDto = (PrplfiscalpaymainDto)i.next();
            dbManager.setString(1,prplfiscalpaymainDto.getFiscalno());
            dbManager.setString(2,prplfiscalpaymainDto.getRegistno());
            dbManager.setDouble(3,prplfiscalpaymainDto.getSumamount());
            dbManager.setString(4,prplfiscalpaymainDto.getOperatorcode());
            dbManager.setDateTime(5,prplfiscalpaymainDto.getInputdate());
            dbManager.setString(6,prplfiscalpaymainDto.getOperatorcomcode());
            dbManager.setString(7,prplfiscalpaymainDto.getVflag());
            dbManager.setString(8,prplfiscalpaymainDto.getStatus());
            dbManager.setString(9,prplfiscalpaymainDto.getPaymenttype());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param fiscalno 支付清单号
     * @throws Exception
     */
    public void delete(String fiscalno)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM Prplfiscalpaymain ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Fiscalno=").append("'").append(fiscalno).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Fiscalno = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,fiscalno);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prplfiscalpaymainDto prplfiscalpaymainDto
     * @throws Exception
     */
    public void update(PrplfiscalpaymainDto prplfiscalpaymainDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Prplfiscalpaymain SET ");
        buffer.append("Registno = ?, ");
        buffer.append("Sumamount = ?, ");
        buffer.append("Operatorcode = ?, ");
        buffer.append("Inputdate = ?, ");
        buffer.append("Operatorcomcode = ?, ");
        buffer.append("Vflag = ?, ");
        buffer.append("Status = ?, ");
        buffer.append("Paymenttype = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE Prplfiscalpaymain SET ");
            debugBuffer.append("Registno = '" + prplfiscalpaymainDto.getRegistno() + "', ");
            debugBuffer.append("Sumamount = " + prplfiscalpaymainDto.getSumamount() + ", ");
            debugBuffer.append("Operatorcode = '" + prplfiscalpaymainDto.getOperatorcode() + "', ");
            debugBuffer.append("Inputdate = '" + prplfiscalpaymainDto.getInputdate() + "', ");
            debugBuffer.append("Operatorcomcode = '" + prplfiscalpaymainDto.getOperatorcomcode() + "', ");
            debugBuffer.append("Vflag = '" + prplfiscalpaymainDto.getVflag() + "', ");
            debugBuffer.append("Status = '" + prplfiscalpaymainDto.getStatus() + "', ");
            debugBuffer.append("Paymenttype = '" + prplfiscalpaymainDto.getPaymenttype() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Fiscalno=").append("'").append(prplfiscalpaymainDto.getFiscalno()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Fiscalno = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prplfiscalpaymainDto.getRegistno());
        dbManager.setDouble(2,prplfiscalpaymainDto.getSumamount());
        dbManager.setString(3,prplfiscalpaymainDto.getOperatorcode());
        dbManager.setDateTime(4,prplfiscalpaymainDto.getInputdate());
        dbManager.setString(5,prplfiscalpaymainDto.getOperatorcomcode());
        dbManager.setString(6,prplfiscalpaymainDto.getVflag());
        dbManager.setString(7,prplfiscalpaymainDto.getStatus());
        dbManager.setString(8,prplfiscalpaymainDto.getPaymenttype());
        //设置条件字段;
        dbManager.setString(9,prplfiscalpaymainDto.getFiscalno());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param fiscalno 支付清单号
     * @return PrplfiscalpaymainDto
     * @throws Exception
     */
    public PrplfiscalpaymainDto findByPrimaryKey(String fiscalno)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("Fiscalno,");
        buffer.append("Registno,");
        buffer.append("Sumamount,");
        buffer.append("Operatorcode,");
        buffer.append("Inputdate,");
        buffer.append("Operatorcomcode,");
        buffer.append("Vflag,");
        buffer.append("Status, ");
        buffer.append("Paymenttype ");
        buffer.append("FROM Prplfiscalpaymain ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Fiscalno=").append("'").append(fiscalno).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Fiscalno = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,fiscalno);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrplfiscalpaymainDto prplfiscalpaymainDto = null;
        if(resultSet.next()){
            prplfiscalpaymainDto = new PrplfiscalpaymainDto();
            prplfiscalpaymainDto.setFiscalno(dbManager.getString(resultSet,1));
            prplfiscalpaymainDto.setRegistno(dbManager.getString(resultSet,2));
            prplfiscalpaymainDto.setSumamount(dbManager.getDouble(resultSet,3));
            prplfiscalpaymainDto.setOperatorcode(dbManager.getString(resultSet,4));
            prplfiscalpaymainDto.setInputdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,5));
            prplfiscalpaymainDto.setOperatorcomcode(dbManager.getString(resultSet,6));
            prplfiscalpaymainDto.setVflag(dbManager.getString(resultSet,7));
            prplfiscalpaymainDto.setStatus(dbManager.getString(resultSet,8));
            prplfiscalpaymainDto.setPaymenttype(dbManager.getString(resultSet,9));
        }
        resultSet.close();
        return prplfiscalpaymainDto;
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
        buffer.append("Fiscalno,");
        buffer.append("Registno,");
        buffer.append("Sumamount,");
        buffer.append("Operatorcode,");
        buffer.append("Inputdate,");
        buffer.append("Operatorcomcode,");
        buffer.append("Vflag,");
        buffer.append("Status, ");
        buffer.append("Paymenttype ");
        buffer.append("FROM Prplfiscalpaymain WHERE ");
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
        PrplfiscalpaymainDto prplfiscalpaymainDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            prplfiscalpaymainDto = new PrplfiscalpaymainDto();
            prplfiscalpaymainDto.setFiscalno(dbManager.getString(resultSet,"Fiscalno"));
            prplfiscalpaymainDto.setRegistno(dbManager.getString(resultSet,"Registno"));
            prplfiscalpaymainDto.setSumamount(dbManager.getDouble(resultSet,"Sumamount"));
            prplfiscalpaymainDto.setOperatorcode(dbManager.getString(resultSet,"Operatorcode"));
            prplfiscalpaymainDto.setInputdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Inputdate"));
            prplfiscalpaymainDto.setOperatorcomcode(dbManager.getString(resultSet,"Operatorcomcode"));
            prplfiscalpaymainDto.setVflag(dbManager.getString(resultSet,"Vflag"));
            prplfiscalpaymainDto.setStatus(dbManager.getString(resultSet,"Status"));
            prplfiscalpaymainDto.setPaymenttype(dbManager.getString(resultSet,"Paymenttype"));
            collection.add(prplfiscalpaymainDto);
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
        buffer.append("DELETE FROM Prplfiscalpaymain WHERE ");
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
        buffer.append("SELECT count(1) FROM Prplfiscalpaymain WHERE ");
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
