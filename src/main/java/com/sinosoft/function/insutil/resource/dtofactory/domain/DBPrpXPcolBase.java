package com.sinosoft.function.insutil.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpXPcolDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpxpcol的数据访问对象类<br>
 * 创建于 2004-4-6 16:07:46<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpXPcolBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpXPcolBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpXPcolBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpXPcolDto prpXPcolDto
     * @throws Exception
     */
    public void insert(PrpXPcolDto prpXPcolDto) throws Exception{
        String statement = " Insert Into PrpXPcol(" + 
                           " RiskCode," + 
                           " TableName," + 
                           " ColSeq," + 
                           " ColName," + 
                           " DispSeq," + 
                           " ColCName," + 
                           " ColEName," + 
                           " Flag) values(?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpXPcolDto.getRiskCode());
        dbManager.setString(2,prpXPcolDto.getTableName());
        dbManager.setInt(3,prpXPcolDto.getColSeq());
        dbManager.setString(4,prpXPcolDto.getColName());
        dbManager.setInt(5,prpXPcolDto.getDispSeq());
        dbManager.setString(6,prpXPcolDto.getColCName());
        dbManager.setString(7,prpXPcolDto.getColEName());
        dbManager.setString(8,prpXPcolDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpXPcolBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpXPcolDto prpXPcolDto = (PrpXPcolDto)i.next();
            insert(prpXPcolDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param riskCode riskcode
     * @param tableName tablename
     * @param colSeq colseq
     * @param dispSeq dispseq
     * @throws Exception
     */
    public void delete(String riskCode,String tableName,int colSeq,int dispSeq) throws Exception{
        String statement = " Delete From PrpXPcol Where " +
                           " RiskCode = ? And " + 
                           " TableName = ? And " + 
                           " ColSeq = ? And " + 
                           " DispSeq = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,riskCode);
        dbManager.setString(2,tableName);
        dbManager.setInt(3,colSeq);
        dbManager.setInt(4,dispSeq);
        dbManager.executePreparedUpdate();
        log.info("DBPrpXPcolBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpXPcolDto prpXPcolDto
     * @throws Exception
     */
    public void update(PrpXPcolDto prpXPcolDto) throws Exception{
        String statement = " Update PrpXPcol Set ColName = ?," + 
                           " ColCName = ?," + 
                           " ColEName = ?," + 
                           " Flag = ? Where " +
                           " RiskCode = ? And " + 
                           " TableName = ? And " + 
                           " ColSeq = ? And " + 
                           " DispSeq = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpXPcolDto.getColName());
        dbManager.setString(2,prpXPcolDto.getColCName());
        dbManager.setString(3,prpXPcolDto.getColEName());
        dbManager.setString(4,prpXPcolDto.getFlag());
        //设置条件字段;
        dbManager.setString(5,prpXPcolDto.getRiskCode());
        dbManager.setString(6,prpXPcolDto.getTableName());
        dbManager.setInt(7,prpXPcolDto.getColSeq());
        dbManager.setInt(8,prpXPcolDto.getDispSeq());
        dbManager.executePreparedUpdate();

        log.info("DBPrpXPcolBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param riskCode riskcode
     * @param tableName tablename
     * @param colSeq colseq
     * @param dispSeq dispseq
     * @return PrpXPcolDto
     * @throws Exception
     */
    public PrpXPcolDto findByPrimaryKey(String riskCode,String tableName,int colSeq,int dispSeq) throws Exception{
        String statement = " Select RiskCode," + 
                           " TableName," + 
                           " ColSeq," + 
                           " ColName," + 
                           " DispSeq," + 
                           " ColCName," + 
                           " ColEName," + 
                           " Flag From PrpXPcol Where " +
                           " RiskCode = ? And " + 
                           " TableName = ? And " + 
                           " ColSeq = ? And " + 
                           " DispSeq = ?";
        PrpXPcolDto prpXPcolDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,riskCode);
        dbManager.setString(2,tableName);
        dbManager.setInt(3,colSeq);
        dbManager.setInt(4,dispSeq);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpXPcolDto = new PrpXPcolDto();
            prpXPcolDto.setRiskCode(dbManager.getString(resultSet,1));
            prpXPcolDto.setTableName(dbManager.getString(resultSet,2));
            prpXPcolDto.setColSeq(dbManager.getInt(resultSet,3));
            prpXPcolDto.setColName(dbManager.getString(resultSet,4));
            prpXPcolDto.setDispSeq(dbManager.getInt(resultSet,5));
            prpXPcolDto.setColCName(dbManager.getString(resultSet,6));
            prpXPcolDto.setColEName(dbManager.getString(resultSet,7));
            prpXPcolDto.setFlag(dbManager.getString(resultSet,8));
        }
        resultSet.close();
        log.info("DBPrpXPcolBase.findByPrimaryKey() success!");
        return prpXPcolDto;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
        String statement = "Select RiskCode," + 
                           " TableName," + 
                           " ColSeq," + 
                           " ColName," + 
                           " DispSeq," + 
                           " ColCName," + 
                           " ColEName," + 
                           " Flag From PrpXPcol Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpXPcolDto prpXPcolDto = null;
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

            prpXPcolDto = new PrpXPcolDto();
            prpXPcolDto.setRiskCode(dbManager.getString(resultSet,1));
            prpXPcolDto.setTableName(dbManager.getString(resultSet,2));
            prpXPcolDto.setColSeq(dbManager.getInt(resultSet,3));
            prpXPcolDto.setColName(dbManager.getString(resultSet,4));
            prpXPcolDto.setDispSeq(dbManager.getInt(resultSet,5));
            prpXPcolDto.setColCName(dbManager.getString(resultSet,6));
            prpXPcolDto.setColEName(dbManager.getString(resultSet,7));
            prpXPcolDto.setFlag(dbManager.getString(resultSet,8));
            collection.add(prpXPcolDto);
        }
        resultSet.close();
        log.info("DBPrpXPcolBase.findByConditions() success!");
        return collection;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        return findByConditions(conditions,0,0);
    }

    /**
     * 按条件删除数据
     * @param conditions 查询条件
     * @return 删除的行数
     * @throws Exception
     */
    public int deleteByConditions(String conditions) throws Exception{
        String statement = "Delete From PrpXPcol Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpXPcolBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpXPcol Where " + conditions;
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpXPcolBase.getCount() success!");
        return count;
    }
}
