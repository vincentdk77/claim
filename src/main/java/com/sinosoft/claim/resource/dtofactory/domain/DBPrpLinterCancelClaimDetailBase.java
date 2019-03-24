package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterCancelClaimDetailDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是交互信息关联表的数据访问对象基类<br>
 */
public class DBPrpLinterCancelClaimDetailBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrpLinterCancelClaimDetailBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLinterCancelClaimDetailBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLinterCancelClaimDetailDto prpLinterCancelClaimDetailDto
     * @throws Exception
     */
    public void insert(PrpLinterCancelClaimDetailDto prpLinterCancelClaimDetailDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLinterCancelClaimDetail (");
        buffer.append("Id,");
        buffer.append("OutId,");
        buffer.append("PolicyNo,");
        buffer.append("RegistNo,");
        buffer.append("RegistSuccFlag,");
        buffer.append("CancelSuccFlag,");
        buffer.append("ClaimCancelFlag,");
        buffer.append("CancelApprovFlag,");
        buffer.append("Remark ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLinterCancelClaimDetailDto.getId()).append("',");
            debugBuffer.append("'").append(prpLinterCancelClaimDetailDto.getOutId()).append("',");
            debugBuffer.append("'").append(prpLinterCancelClaimDetailDto.getPolicyNo()).append("',");
            debugBuffer.append("'").append(prpLinterCancelClaimDetailDto.getRegistNo()).append("',");
            debugBuffer.append("'").append(prpLinterCancelClaimDetailDto.getRegistSuccFlag()).append("',");
            debugBuffer.append("'").append(prpLinterCancelClaimDetailDto.getCancelSuccFlag()).append("',");
            debugBuffer.append("'").append(prpLinterCancelClaimDetailDto.getClaimCancelFlag()).append("',");
            debugBuffer.append("'").append(prpLinterCancelClaimDetailDto.getCancelApprovFlag()).append("',");
            debugBuffer.append("'").append(prpLinterCancelClaimDetailDto.getRemark()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLinterCancelClaimDetailDto.getId());
        dbManager.setString(2,prpLinterCancelClaimDetailDto.getOutId());
        dbManager.setString(3,prpLinterCancelClaimDetailDto.getPolicyNo());
        dbManager.setString(4,prpLinterCancelClaimDetailDto.getRegistNo());
        dbManager.setString(5,prpLinterCancelClaimDetailDto.getRegistSuccFlag());
        dbManager.setString(6,prpLinterCancelClaimDetailDto.getCancelSuccFlag());
        dbManager.setString(7,prpLinterCancelClaimDetailDto.getClaimCancelFlag());
        dbManager.setString(8,prpLinterCancelClaimDetailDto.getCancelApprovFlag());
        dbManager.setString(9,prpLinterCancelClaimDetailDto.getRemark());
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
        buffer.append("INSERT INTO PrpLinterCancelClaimDetail (");
        buffer.append("Id,");
        buffer.append("OutId,");
        buffer.append("PolicyNo,");
        buffer.append("RegistNo,");
        buffer.append("RegistSuccFlag,");
        buffer.append("CancelSuccFlag,");
        buffer.append("ClaimCancelFlag,");
        buffer.append("CancelApprovFlag,");
        buffer.append("Remark ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLinterCancelClaimDetailDto prpLinterCancelClaimDetailDto = (PrpLinterCancelClaimDetailDto)i.next();
            dbManager.setString(1,prpLinterCancelClaimDetailDto.getId());
            dbManager.setString(2,prpLinterCancelClaimDetailDto.getOutId());
            dbManager.setString(3,prpLinterCancelClaimDetailDto.getPolicyNo());
            dbManager.setString(4,prpLinterCancelClaimDetailDto.getRegistNo());
            dbManager.setString(5,prpLinterCancelClaimDetailDto.getRegistSuccFlag());
            dbManager.setString(6,prpLinterCancelClaimDetailDto.getCancelSuccFlag());
            dbManager.setString(7,prpLinterCancelClaimDetailDto.getClaimCancelFlag());
            dbManager.setString(8,prpLinterCancelClaimDetailDto.getCancelApprovFlag());
            dbManager.setString(9,prpLinterCancelClaimDetailDto.getRemark());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param id 主键id PK
     * @throws Exception
     */
    public void delete(String id)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLinterCancelClaimDetail ");
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
     * @param prpLinterCancelClaimDetailDto prpLinterCancelClaimDetailDto
     * @throws Exception
     */
    public void update(PrpLinterCancelClaimDetailDto prpLinterCancelClaimDetailDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLinterCancelClaimDetail SET ");
        buffer.append("OutId = ?, ");
        buffer.append("PolicyNo = ?, ");
        buffer.append("RegistNo = ?, ");
        buffer.append("RegistSuccFlag = ?, ");
        buffer.append("CancelSuccFlag = ?, ");
        buffer.append("ClaimCancelFlag = ?, ");
        buffer.append("CancelApprovFlag = ?, ");
        buffer.append("Remark = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLinterCancelClaimDetail SET ");
            debugBuffer.append("OutId = '" + prpLinterCancelClaimDetailDto.getOutId() + "', ");
            debugBuffer.append("PolicyNo = '" + prpLinterCancelClaimDetailDto.getPolicyNo() + "', ");
            debugBuffer.append("RegistNo = '" + prpLinterCancelClaimDetailDto.getRegistNo() + "', ");
            debugBuffer.append("RegistSuccFlag = '" + prpLinterCancelClaimDetailDto.getRegistSuccFlag() + "', ");
            debugBuffer.append("CancelSuccFlag = '" + prpLinterCancelClaimDetailDto.getCancelSuccFlag() + "', ");
            debugBuffer.append("ClaimCancelFlag = '" + prpLinterCancelClaimDetailDto.getClaimCancelFlag() + "', ");
            debugBuffer.append("CancelApprovFlag = '" + prpLinterCancelClaimDetailDto.getCancelApprovFlag() + "', ");
            debugBuffer.append("Remark = '" + prpLinterCancelClaimDetailDto.getRemark() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Id=").append("'").append(prpLinterCancelClaimDetailDto.getId()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Id = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prpLinterCancelClaimDetailDto.getOutId());
        dbManager.setString(2,prpLinterCancelClaimDetailDto.getPolicyNo());
        dbManager.setString(3,prpLinterCancelClaimDetailDto.getRegistNo());
        dbManager.setString(4,prpLinterCancelClaimDetailDto.getRegistSuccFlag());
        dbManager.setString(5,prpLinterCancelClaimDetailDto.getCancelSuccFlag());
        dbManager.setString(6,prpLinterCancelClaimDetailDto.getClaimCancelFlag());
        dbManager.setString(7,prpLinterCancelClaimDetailDto.getCancelApprovFlag());
        dbManager.setString(8,prpLinterCancelClaimDetailDto.getRemark());
        //设置条件字段;
        dbManager.setString(9,prpLinterCancelClaimDetailDto.getId());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param id 主键id PK
     * @return PrpLinterCancelClaimDetailDto
     * @throws Exception
     */
    public PrpLinterCancelClaimDetailDto findByPrimaryKey(String id)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("Id,");
        buffer.append("OutId,");
        buffer.append("PolicyNo,");
        buffer.append("RegistNo,");
        buffer.append("RegistSuccFlag,");
        buffer.append("CancelSuccFlag,");
        buffer.append("ClaimCancelFlag,");
        buffer.append("CancelApprovFlag,");
        buffer.append("Remark ");
        buffer.append("FROM PrpLinterCancelClaimDetail ");
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
        PrpLinterCancelClaimDetailDto prpLinterCancelClaimDetailDto = null;
        if(resultSet.next()){
            prpLinterCancelClaimDetailDto = new PrpLinterCancelClaimDetailDto();
            prpLinterCancelClaimDetailDto.setId(dbManager.getString(resultSet,1));
            prpLinterCancelClaimDetailDto.setOutId(dbManager.getString(resultSet,2));
            prpLinterCancelClaimDetailDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpLinterCancelClaimDetailDto.setRegistNo(dbManager.getString(resultSet,4));
            prpLinterCancelClaimDetailDto.setRegistSuccFlag(dbManager.getString(resultSet,5));
            prpLinterCancelClaimDetailDto.setCancelSuccFlag(dbManager.getString(resultSet,6));
            prpLinterCancelClaimDetailDto.setClaimCancelFlag(dbManager.getString(resultSet,7));
            prpLinterCancelClaimDetailDto.setCancelApprovFlag(dbManager.getString(resultSet,8));
            prpLinterCancelClaimDetailDto.setRemark(dbManager.getString(resultSet,9));
        }
        resultSet.close();
        return prpLinterCancelClaimDetailDto;
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
        buffer.append("PolicyNo,");
        buffer.append("RegistNo,");
        buffer.append("RegistSuccFlag,");
        buffer.append("CancelSuccFlag,");
        buffer.append("ClaimCancelFlag,");
        buffer.append("CancelApprovFlag,");
        buffer.append("Remark ");
        buffer.append("FROM PrpLinterCancelClaimDetail WHERE ");
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
        PrpLinterCancelClaimDetailDto prpLinterCancelClaimDetailDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLinterCancelClaimDetailDto = new PrpLinterCancelClaimDetailDto();
            prpLinterCancelClaimDetailDto.setId(dbManager.getString(resultSet,"Id"));
            prpLinterCancelClaimDetailDto.setOutId(dbManager.getString(resultSet,"OutId"));
            prpLinterCancelClaimDetailDto.setPolicyNo(dbManager.getString(resultSet,"PolicyNo"));
            prpLinterCancelClaimDetailDto.setRegistNo(dbManager.getString(resultSet,"RegistNo"));
            prpLinterCancelClaimDetailDto.setRegistSuccFlag(dbManager.getString(resultSet,"RegistSuccFlag"));
            prpLinterCancelClaimDetailDto.setCancelSuccFlag(dbManager.getString(resultSet,"CancelSuccFlag"));
            prpLinterCancelClaimDetailDto.setClaimCancelFlag(dbManager.getString(resultSet,"ClaimCancelFlag"));
            prpLinterCancelClaimDetailDto.setCancelApprovFlag(dbManager.getString(resultSet,"CancelApprovFlag"));
            prpLinterCancelClaimDetailDto.setRemark(dbManager.getString(resultSet,"Remark"));
            collection.add(prpLinterCancelClaimDetailDto);
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
        buffer.append("DELETE FROM PrpLinterCancelClaimDetail WHERE ");
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
        buffer.append("SELECT count(1) FROM PrpLinterCancelClaimDetail WHERE ");
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
