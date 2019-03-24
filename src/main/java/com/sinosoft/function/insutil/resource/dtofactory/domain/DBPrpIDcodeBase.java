package com.sinosoft.function.insutil.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpIDcodeDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpidcode的数据访问对象类<br>
 * 创建于 2004-4-6 16:07:46<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpIDcodeBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpIDcodeBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpIDcodeBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpIDcodeDto prpIDcodeDto
     * @throws Exception
     */
    public void insert(PrpIDcodeDto prpIDcodeDto) throws Exception{
        String statement = " Insert Into PrpIDcode(" + 
                           " CodeType," + 
                           " RiskCode," + 
                           " CodeCode," + 
                           " CodeCName," + 
                           " CodeEName," + 
                           " Excodecode) values(?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpIDcodeDto.getCodeType());
        dbManager.setString(2,prpIDcodeDto.getRiskCode());
        dbManager.setString(3,prpIDcodeDto.getCodeCode());
        dbManager.setString(4,prpIDcodeDto.getCodeCName());
        dbManager.setString(5,prpIDcodeDto.getCodeEName());
        dbManager.setString(6,prpIDcodeDto.getExcodecode());
        dbManager.executePreparedUpdate();

        log.info("DBPrpIDcodeBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpIDcodeDto prpIDcodeDto = (PrpIDcodeDto)i.next();
            insert(prpIDcodeDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param codeType codetype
     * @param riskCode riskcode
     * @param codeCode codecode
     * @throws Exception
     */
    public void delete(String codeType,String riskCode,String codeCode) throws Exception{
        String statement = " Delete From PrpIDcode Where " +
                           " CodeType = ? And " + 
                           " RiskCode = ? And " + 
                           " CodeCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,codeType);
        dbManager.setString(2,riskCode);
        dbManager.setString(3,codeCode);
        dbManager.executePreparedUpdate();
        log.info("DBPrpIDcodeBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpIDcodeDto prpIDcodeDto
     * @throws Exception
     */
    public void update(PrpIDcodeDto prpIDcodeDto) throws Exception{
        String statement = " Update PrpIDcode Set CodeCName = ?," + 
                           " CodeEName = ?," + 
                           " Excodecode = ? Where " +
                           " CodeType = ? And " + 
                           " RiskCode = ? And " + 
                           " CodeCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpIDcodeDto.getCodeCName());
        dbManager.setString(2,prpIDcodeDto.getCodeEName());
        dbManager.setString(3,prpIDcodeDto.getExcodecode());
        //设置条件字段;
        dbManager.setString(4,prpIDcodeDto.getCodeType());
        dbManager.setString(5,prpIDcodeDto.getRiskCode());
        dbManager.setString(6,prpIDcodeDto.getCodeCode());
        dbManager.executePreparedUpdate();

        log.info("DBPrpIDcodeBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param codeType codetype
     * @param riskCode riskcode
     * @param codeCode codecode
     * @return PrpIDcodeDto
     * @throws Exception
     */
    public PrpIDcodeDto findByPrimaryKey(String codeType,String riskCode,String codeCode) throws Exception{
        String statement = " Select CodeType," + 
                           " RiskCode," + 
                           " CodeCode," + 
                           " CodeCName," + 
                           " CodeEName," + 
                           " Excodecode From PrpIDcode Where " +
                           " CodeType = ? And " + 
                           " RiskCode = ? And " + 
                           " CodeCode = ?";
        PrpIDcodeDto prpIDcodeDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,codeType);
        dbManager.setString(2,riskCode);
        dbManager.setString(3,codeCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpIDcodeDto = new PrpIDcodeDto();
            prpIDcodeDto.setCodeType(dbManager.getString(resultSet,1));
            prpIDcodeDto.setRiskCode(dbManager.getString(resultSet,2));
            prpIDcodeDto.setCodeCode(dbManager.getString(resultSet,3));
            prpIDcodeDto.setCodeCName(dbManager.getString(resultSet,4));
            prpIDcodeDto.setCodeEName(dbManager.getString(resultSet,5));
            prpIDcodeDto.setExcodecode(dbManager.getString(resultSet,6));
        }
        resultSet.close();
        log.info("DBPrpIDcodeBase.findByPrimaryKey() success!");
        return prpIDcodeDto;
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
                           " RiskCode," + 
                           " CodeCode," + 
                           " CodeCName," + 
                           " CodeEName," + 
                           " Excodecode From PrpIDcode Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpIDcodeDto prpIDcodeDto = null;
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

            prpIDcodeDto = new PrpIDcodeDto();
            prpIDcodeDto.setCodeType(dbManager.getString(resultSet,1));
            prpIDcodeDto.setRiskCode(dbManager.getString(resultSet,2));
            prpIDcodeDto.setCodeCode(dbManager.getString(resultSet,3));
            prpIDcodeDto.setCodeCName(dbManager.getString(resultSet,4));
            prpIDcodeDto.setCodeEName(dbManager.getString(resultSet,5));
            prpIDcodeDto.setExcodecode(dbManager.getString(resultSet,6));
            collection.add(prpIDcodeDto);
        }
        resultSet.close();
        log.info("DBPrpIDcodeBase.findByConditions() success!");
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
        String statement = "Delete From PrpIDcode Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpIDcodeBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpIDcode Where " + conditions;
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpIDcodeBase.getCount() success!");
        return count;
    }
}
