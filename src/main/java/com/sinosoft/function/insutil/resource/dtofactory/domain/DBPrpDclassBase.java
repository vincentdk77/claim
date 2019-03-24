package com.sinosoft.function.insutil.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDclassDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdclass的数据访问对象类<br>
 * 创建于 2004-4-6 16:07:46<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDclassBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpDclassBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpDclassBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpDclassDto prpDclassDto
     * @throws Exception
     */
    public void insert(PrpDclassDto prpDclassDto) throws Exception{
        String statement = " Insert Into PrpDclass(" + 
                           " ClassCode," + 
                           " ClassName," + 
                           " ClassEName," + 
                           " AccCode," + 
                           " NewClassCode," + 
                           " ValidStatus," + 
                           " Flag) values(?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpDclassDto.getClassCode());
        dbManager.setString(2,prpDclassDto.getClassName());
        dbManager.setString(3,prpDclassDto.getClassEName());
        dbManager.setString(4,prpDclassDto.getAccCode());
        dbManager.setString(5,prpDclassDto.getNewClassCode());
        dbManager.setString(6,prpDclassDto.getValidStatus());
        dbManager.setString(7,prpDclassDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDclassBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpDclassDto prpDclassDto = (PrpDclassDto)i.next();
            insert(prpDclassDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param classCode classcode
     * @throws Exception
     */
    public void delete(String classCode) throws Exception{
        String statement = " Delete From PrpDclass Where " +
                           " ClassCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,classCode);
        dbManager.executePreparedUpdate();
        log.info("DBPrpDclassBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpDclassDto prpDclassDto
     * @throws Exception
     */
    public void update(PrpDclassDto prpDclassDto) throws Exception{
        String statement = " Update PrpDclass Set ClassName = ?," + 
                           " ClassEName = ?," + 
                           " AccCode = ?," + 
                           " NewClassCode = ?," + 
                           " ValidStatus = ?," + 
                           " Flag = ? Where " +
                           " ClassCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpDclassDto.getClassName());
        dbManager.setString(2,prpDclassDto.getClassEName());
        dbManager.setString(3,prpDclassDto.getAccCode());
        dbManager.setString(4,prpDclassDto.getNewClassCode());
        dbManager.setString(5,prpDclassDto.getValidStatus());
        dbManager.setString(6,prpDclassDto.getFlag());
        //设置条件字段;
        dbManager.setString(7,prpDclassDto.getClassCode());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDclassBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param classCode classcode
     * @return PrpDclassDto
     * @throws Exception
     */
    public PrpDclassDto findByPrimaryKey(String classCode) throws Exception{
        String statement = " Select ClassCode," + 
                           " ClassName," + 
                           " ClassEName," + 
                           " AccCode," + 
                           " NewClassCode," + 
                           " ValidStatus," + 
                           " Flag From PrpDclass Where " +
                           " ClassCode = ?";
        PrpDclassDto prpDclassDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,classCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpDclassDto = new PrpDclassDto();
            prpDclassDto.setClassCode(dbManager.getString(resultSet,1));
            prpDclassDto.setClassName(dbManager.getString(resultSet,2));
            prpDclassDto.setClassEName(dbManager.getString(resultSet,3));
            prpDclassDto.setAccCode(dbManager.getString(resultSet,4));
            prpDclassDto.setNewClassCode(dbManager.getString(resultSet,5));
            prpDclassDto.setValidStatus(dbManager.getString(resultSet,6));
            prpDclassDto.setFlag(dbManager.getString(resultSet,7));
        }
        resultSet.close();
        log.info("DBPrpDclassBase.findByPrimaryKey() success!");
        return prpDclassDto;
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
        String statement = "Select ClassCode," + 
                           " ClassName," + 
                           " ClassEName," + 
                           " AccCode," + 
                           " NewClassCode," + 
                           " ValidStatus," + 
                           " Flag From PrpDclass Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpDclassDto prpDclassDto = null;
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

            prpDclassDto = new PrpDclassDto();
            prpDclassDto.setClassCode(dbManager.getString(resultSet,1));
            prpDclassDto.setClassName(dbManager.getString(resultSet,2));
            prpDclassDto.setClassEName(dbManager.getString(resultSet,3));
            prpDclassDto.setAccCode(dbManager.getString(resultSet,4));
            prpDclassDto.setNewClassCode(dbManager.getString(resultSet,5));
            prpDclassDto.setValidStatus(dbManager.getString(resultSet,6));
            prpDclassDto.setFlag(dbManager.getString(resultSet,7));
            collection.add(prpDclassDto);
        }
        resultSet.close();
        log.info("DBPrpDclassBase.findByConditions() success!");
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
        String statement = "Delete From PrpDclass Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpDclassBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpDclass Where " + conditions;
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpDclassBase.getCount() success!");
        return count;
    }
}
