package com.sinosoft.function.insutil.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDcodeDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdcode的数据访问对象类<br>
 * 创建于 2004-4-6 16:07:46<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDcodeBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpDcodeBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpDcodeBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpDcodeDto prpDcodeDto
     * @throws Exception
     */
    public void insert(PrpDcodeDto prpDcodeDto) throws Exception{
        String statement = " Insert Into PrpDcode(" + 
                           " CodeType," + 
                           " CodeCode," + 
                           " CodeCName," + 
                           " CodeEName," + 
                           " NewCodeCode," + 
                           " ValidStatus," + 
                           " Flag) values(?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpDcodeDto.getCodeType());
        dbManager.setString(2,prpDcodeDto.getCodeCode());
        dbManager.setString(3,prpDcodeDto.getCodeCName());
        dbManager.setString(4,prpDcodeDto.getCodeEName());
        dbManager.setString(5,prpDcodeDto.getNewCodeCode());
        dbManager.setString(6,prpDcodeDto.getValidStatus());
        dbManager.setString(7,prpDcodeDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDcodeBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpDcodeDto prpDcodeDto = (PrpDcodeDto)i.next();
            insert(prpDcodeDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param codeType codetype
     * @param codeCode codecode
     * @throws Exception
     */
    public void delete(String codeType,String codeCode) throws Exception{
        String statement = " Delete From PrpDcode Where " +
                           " CodeType = ? And " + 
                           " CodeCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,codeType);
        dbManager.setString(2,codeCode);
        dbManager.executePreparedUpdate();
        log.info("DBPrpDcodeBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpDcodeDto prpDcodeDto
     * @throws Exception
     */
    public void update(PrpDcodeDto prpDcodeDto) throws Exception{
        String statement = " Update PrpDcode Set CodeCName = ?," + 
                           " CodeEName = ?," + 
                           " NewCodeCode = ?," + 
                           " ValidStatus = ?," + 
                           " Flag = ? Where " +
                           " CodeType = ? And " + 
                           " CodeCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpDcodeDto.getCodeCName());
        dbManager.setString(2,prpDcodeDto.getCodeEName());
        dbManager.setString(3,prpDcodeDto.getNewCodeCode());
        dbManager.setString(4,prpDcodeDto.getValidStatus());
        dbManager.setString(5,prpDcodeDto.getFlag());
        //设置条件字段;
        dbManager.setString(6,prpDcodeDto.getCodeType());
        dbManager.setString(7,prpDcodeDto.getCodeCode());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDcodeBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param codeType codetype
     * @param codeCode codecode
     * @return PrpDcodeDto
     * @throws Exception
     */
    public PrpDcodeDto findByPrimaryKey(String codeType,String codeCode) throws Exception{
        String statement = " Select CodeType," + 
                           " CodeCode," + 
                           " CodeCName," + 
                           " CodeEName," + 
                           " NewCodeCode," + 
                           " ValidStatus," + 
                           " Flag From PrpDcode Where " +
                           " CodeType = ? And " + 
                           " CodeCode = ?";
        PrpDcodeDto prpDcodeDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,codeType);
        dbManager.setString(2,codeCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpDcodeDto = new PrpDcodeDto();
            prpDcodeDto.setCodeType(dbManager.getString(resultSet,1));
            prpDcodeDto.setCodeCode(dbManager.getString(resultSet,2));
            prpDcodeDto.setCodeCName(dbManager.getString(resultSet,3));
            prpDcodeDto.setCodeEName(dbManager.getString(resultSet,4));
            prpDcodeDto.setNewCodeCode(dbManager.getString(resultSet,5));
            prpDcodeDto.setValidStatus(dbManager.getString(resultSet,6));
            prpDcodeDto.setFlag(dbManager.getString(resultSet,7));
        }
        resultSet.close();
        log.info("DBPrpDcodeBase.findByPrimaryKey() success!");
        return prpDcodeDto;
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
        String statement = "Select CodeType," + 
                           " CodeCode," + 
                           " CodeCName," + 
                           " CodeEName," + 
                           " NewCodeCode," + 
                           " ValidStatus," + 
                           " Flag From PrpDcode Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpDcodeDto prpDcodeDto = null;
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

            prpDcodeDto = new PrpDcodeDto();
            prpDcodeDto.setCodeType(dbManager.getString(resultSet,1));
            prpDcodeDto.setCodeCode(dbManager.getString(resultSet,2));
            prpDcodeDto.setCodeCName(dbManager.getString(resultSet,3));
            prpDcodeDto.setCodeEName(dbManager.getString(resultSet,4));
            prpDcodeDto.setNewCodeCode(dbManager.getString(resultSet,5));
            prpDcodeDto.setValidStatus(dbManager.getString(resultSet,6));
            prpDcodeDto.setFlag(dbManager.getString(resultSet,7));
            collection.add(prpDcodeDto);
        }
        resultSet.close();
        log.info("DBPrpDcodeBase.findByConditions() success!");
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
        String statement = "Delete From PrpDcode Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpDcodeBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpDcode Where " + conditions;
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpDcodeBase.getCount() success!");
        return count;
    }
}
