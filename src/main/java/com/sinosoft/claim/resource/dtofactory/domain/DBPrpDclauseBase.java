package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDclauseDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdclause条款代码表的数据访问对象类<br>
 * 创建于 2004-4-5 15:33:42<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDclauseBase{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpDclauseBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpDclauseBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpDclauseDto prpDclauseDto
     * @throws Exception
     */
    public void insert(PrpDclauseDto prpDclauseDto) throws Exception{
        String statement = " Insert Into PrpDclause(" + 
                           " ClauseCode," + 
                           " ClauseName," + 
                           " Language," + 
                           " LineNo," + 
                           " Context," + 
                           " NewClauseCode," + 
                           " ValidStatus," + 
                           " Flag) values(?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpDclauseDto.getClauseCode());
        dbManager.setString(2,prpDclauseDto.getClauseName());
        dbManager.setString(3,prpDclauseDto.getLanguage());
        dbManager.setInt(4,prpDclauseDto.getLineNo());
        dbManager.setString(5,prpDclauseDto.getContext());
        dbManager.setString(6,prpDclauseDto.getNewClauseCode());
        dbManager.setString(7,prpDclauseDto.getValidStatus());
        dbManager.setString(8,prpDclauseDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDclauseBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpDclauseDto prpDclauseDto = (PrpDclauseDto)i.next();
            insert(prpDclauseDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param clauseCode 条款代码
     * @param lineNo 行号
     * @throws Exception
     */
    public void delete(String clauseCode,int lineNo) throws Exception{
        String statement = " Delete From PrpDclause Where " +
                           " ClauseCode = ? And " + 
                           " LineNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,clauseCode);
        dbManager.setInt(2,lineNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpDclauseBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpDclauseDto prpDclauseDto
     * @throws Exception
     */
    public void update(PrpDclauseDto prpDclauseDto) throws Exception{
        String statement = " Update PrpDclause Set ClauseName = ?," + 
                           " Language = ?," + 
                           " Context = ?," + 
                           " NewClauseCode = ?," + 
                           " ValidStatus = ?," + 
                           " Flag = ? Where " +
                           " ClauseCode = ? And " + 
                           " LineNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpDclauseDto.getClauseName());
        dbManager.setString(2,prpDclauseDto.getLanguage());
        dbManager.setString(3,prpDclauseDto.getContext());
        dbManager.setString(4,prpDclauseDto.getNewClauseCode());
        dbManager.setString(5,prpDclauseDto.getValidStatus());
        dbManager.setString(6,prpDclauseDto.getFlag());
        //设置条件字段;
        dbManager.setString(7,prpDclauseDto.getClauseCode());
        dbManager.setInt(8,prpDclauseDto.getLineNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDclauseBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param clauseCode 条款代码
     * @param lineNo 行号
     * @return PrpDclauseDto
     * @throws Exception
     */
    public PrpDclauseDto findByPrimaryKey(String clauseCode,int lineNo) throws Exception{
        String statement = " Select ClauseCode," + 
                           " ClauseName," + 
                           " Language," + 
                           " LineNo," + 
                           " Context," + 
                           " NewClauseCode," + 
                           " ValidStatus," + 
                           " Flag From PrpDclause Where " +
                           " ClauseCode = ? And " + 
                           " LineNo = ?";
        PrpDclauseDto prpDclauseDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,clauseCode);
        dbManager.setInt(2,lineNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpDclauseDto = new PrpDclauseDto();
            prpDclauseDto.setClauseCode(dbManager.getString(resultSet,1));
            prpDclauseDto.setClauseName(dbManager.getString(resultSet,2));
            prpDclauseDto.setLanguage(dbManager.getString(resultSet,3));
            prpDclauseDto.setLineNo(dbManager.getInt(resultSet,4));
            prpDclauseDto.setContext(dbManager.getString(resultSet,5));
            prpDclauseDto.setNewClauseCode(dbManager.getString(resultSet,6));
            prpDclauseDto.setValidStatus(dbManager.getString(resultSet,7));
            prpDclauseDto.setFlag(dbManager.getString(resultSet,8));
        }
        resultSet.close();
        log.info("DBPrpDclauseBase.findByPrimaryKey() success!");
        return prpDclauseDto;
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
        String statement = "Select ClauseCode," + 
                           " ClauseName," + 
                           " Language," + 
                           " LineNo," + 
                           " Context," + 
                           " NewClauseCode," + 
                           " ValidStatus," + 
                           " Flag From PrpDclause Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpDclauseDto prpDclauseDto = null;
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

            prpDclauseDto = new PrpDclauseDto();
            prpDclauseDto.setClauseCode(dbManager.getString(resultSet,1));
            prpDclauseDto.setClauseName(dbManager.getString(resultSet,2));
            prpDclauseDto.setLanguage(dbManager.getString(resultSet,3));
            prpDclauseDto.setLineNo(dbManager.getInt(resultSet,4));
            prpDclauseDto.setContext(dbManager.getString(resultSet,5));
            prpDclauseDto.setNewClauseCode(dbManager.getString(resultSet,6));
            prpDclauseDto.setValidStatus(dbManager.getString(resultSet,7));
            prpDclauseDto.setFlag(dbManager.getString(resultSet,8));
            collection.add(prpDclauseDto);
        }
        resultSet.close();
        log.info("DBPrpDclauseBase.findByConditions() success!");
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
        String statement = "Delete From PrpDclause Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpDclauseBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpDclause Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpDclauseBase.getCount() success!");
        return count;
    }
}
