package com.sinosoft.function.insutil.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDidentifierDescDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdidentifierdesc的数据访问对象类<br>
 * 创建于 2004-4-6 16:07:47<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDidentifierDescBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpDidentifierDescBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpDidentifierDescBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpDidentifierDescDto prpDidentifierDescDto
     * @throws Exception
     */
    public void insert(PrpDidentifierDescDto prpDidentifierDescDto) throws Exception{
        String statement = " Insert Into PrpDidentifierDesc(" + 
                           " IdentifierCode," + 
                           " LineNo," + 
                           " Mark," + 
                           " Flag) values(?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpDidentifierDescDto.getIdentifierCode());
        dbManager.setInt(2,prpDidentifierDescDto.getLineNo());
        dbManager.setString(3,prpDidentifierDescDto.getMark());
        dbManager.setString(4,prpDidentifierDescDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDidentifierDescBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpDidentifierDescDto prpDidentifierDescDto = (PrpDidentifierDescDto)i.next();
            insert(prpDidentifierDescDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param identifierCode identifiercode
     * @param lineNo lineno
     * @throws Exception
     */
    public void delete(String identifierCode,int lineNo) throws Exception{
        String statement = " Delete From PrpDidentifierDesc Where " +
                           " IdentifierCode = ? And " + 
                           " LineNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,identifierCode);
        dbManager.setInt(2,lineNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpDidentifierDescBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpDidentifierDescDto prpDidentifierDescDto
     * @throws Exception
     */
    public void update(PrpDidentifierDescDto prpDidentifierDescDto) throws Exception{
        String statement = " Update PrpDidentifierDesc Set Mark = ?," + 
                           " Flag = ? Where " +
                           " IdentifierCode = ? And " + 
                           " LineNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpDidentifierDescDto.getMark());
        dbManager.setString(2,prpDidentifierDescDto.getFlag());
        //设置条件字段;
        dbManager.setString(3,prpDidentifierDescDto.getIdentifierCode());
        dbManager.setInt(4,prpDidentifierDescDto.getLineNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDidentifierDescBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param identifierCode identifiercode
     * @param lineNo lineno
     * @return PrpDidentifierDescDto
     * @throws Exception
     */
    public PrpDidentifierDescDto findByPrimaryKey(String identifierCode,int lineNo) throws Exception{
        String statement = " Select IdentifierCode," + 
                           " LineNo," + 
                           " Mark," + 
                           " Flag From PrpDidentifierDesc Where " +
                           " IdentifierCode = ? And " + 
                           " LineNo = ?";
        PrpDidentifierDescDto prpDidentifierDescDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,identifierCode);
        dbManager.setInt(2,lineNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpDidentifierDescDto = new PrpDidentifierDescDto();
            prpDidentifierDescDto.setIdentifierCode(dbManager.getString(resultSet,1));
            prpDidentifierDescDto.setLineNo(dbManager.getInt(resultSet,2));
            prpDidentifierDescDto.setMark(dbManager.getString(resultSet,3));
            prpDidentifierDescDto.setFlag(dbManager.getString(resultSet,4));
        }
        resultSet.close();
        log.info("DBPrpDidentifierDescBase.findByPrimaryKey() success!");
        return prpDidentifierDescDto;
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
        String statement = "Select IdentifierCode," + 
                           " LineNo," + 
                           " Mark," + 
                           " Flag From PrpDidentifierDesc Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpDidentifierDescDto prpDidentifierDescDto = null;
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

            prpDidentifierDescDto = new PrpDidentifierDescDto();
            prpDidentifierDescDto.setIdentifierCode(dbManager.getString(resultSet,1));
            prpDidentifierDescDto.setLineNo(dbManager.getInt(resultSet,2));
            prpDidentifierDescDto.setMark(dbManager.getString(resultSet,3));
            prpDidentifierDescDto.setFlag(dbManager.getString(resultSet,4));
            collection.add(prpDidentifierDescDto);
        }
        resultSet.close();
        log.info("DBPrpDidentifierDescBase.findByConditions() success!");
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
        String statement = "Delete From PrpDidentifierDesc Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpDidentifierDescBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpDidentifierDesc Where " + conditions;
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpDidentifierDescBase.getCount() success!");
        return count;
    }
}
