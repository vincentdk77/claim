package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpIDCodeDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpidcode接口代码表的数据访问对象类<br>
 * 创建于 2004-4-5 15:33:42<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpIDCodeBase{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpIDCodeBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpIDCodeBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpIDCodeDto prpIDCodeDto
     * @throws Exception
     */
    public void insert(PrpIDCodeDto prpIDCodeDto) throws Exception{
        String statement = " Insert Into PrpIDCode(" + 
                           " CodeType," + 
                           " RiskCode," + 
                           " CodeCode," + 
                           " CodeCName," + 
                           " CodeEName," + 
                           " Excodecode) values(?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpIDCodeDto.getCodeType());
        dbManager.setString(2,prpIDCodeDto.getRiskCode());
        dbManager.setString(3,prpIDCodeDto.getCodeCode());
        dbManager.setString(4,prpIDCodeDto.getCodeCName());
        dbManager.setString(5,prpIDCodeDto.getCodeEName());
        dbManager.setString(6,prpIDCodeDto.getExcodecode());
        dbManager.executePreparedUpdate();

        log.info("DBPrpIDCodeBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpIDCodeDto prpIDCodeDto = (PrpIDCodeDto)i.next();
            insert(prpIDCodeDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param codeType 接口代码类型
     * @param riskCode 险种代码
     * @param codeCode 代码
     * @throws Exception
     */
    public void delete(String codeType,String riskCode,String codeCode) throws Exception{
        String statement = " Delete From PrpIDCode Where " +
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
        log.info("DBPrpIDCodeBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpIDCodeDto prpIDCodeDto
     * @throws Exception
     */
    public void update(PrpIDCodeDto prpIDCodeDto) throws Exception{
        String statement = " Update PrpIDCode Set CodeCName = ?," + 
                           " CodeEName = ?," + 
                           " Excodecode = ? Where " +
                           " CodeType = ? And " + 
                           " RiskCode = ? And " + 
                           " CodeCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpIDCodeDto.getCodeCName());
        dbManager.setString(2,prpIDCodeDto.getCodeEName());
        dbManager.setString(3,prpIDCodeDto.getExcodecode());
        //设置条件字段;
        dbManager.setString(4,prpIDCodeDto.getCodeType());
        dbManager.setString(5,prpIDCodeDto.getRiskCode());
        dbManager.setString(6,prpIDCodeDto.getCodeCode());
        dbManager.executePreparedUpdate();

        log.info("DBPrpIDCodeBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param codeType 接口代码类型
     * @param riskCode 险种代码
     * @param codeCode 代码
     * @return PrpIDCodeDto
     * @throws Exception
     */
    public PrpIDCodeDto findByPrimaryKey(String codeType,String riskCode,String codeCode) throws Exception{
        String statement = " Select CodeType," + 
                           " RiskCode," + 
                           " CodeCode," + 
                           " CodeCName," + 
                           " CodeEName," + 
                           " Excodecode From PrpIDCode Where " +
                           " CodeType = ? And " + 
                           " RiskCode = ? And " + 
                           " CodeCode = ?";
        PrpIDCodeDto prpIDCodeDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,codeType);
        dbManager.setString(2,riskCode);
        dbManager.setString(3,codeCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpIDCodeDto = new PrpIDCodeDto();
            prpIDCodeDto.setCodeType(dbManager.getString(resultSet,1));
            prpIDCodeDto.setRiskCode(dbManager.getString(resultSet,2));
            prpIDCodeDto.setCodeCode(dbManager.getString(resultSet,3));
            prpIDCodeDto.setCodeCName(dbManager.getString(resultSet,4));
            prpIDCodeDto.setCodeEName(dbManager.getString(resultSet,5));
            prpIDCodeDto.setExcodecode(dbManager.getString(resultSet,6));
        }
        resultSet.close();
        log.info("DBPrpIDCodeBase.findByPrimaryKey() success!");
        return prpIDCodeDto;
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
                           " Excodecode From PrpIDCode Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpIDCodeDto prpIDCodeDto = null;
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

            prpIDCodeDto = new PrpIDCodeDto();
            prpIDCodeDto.setCodeType(dbManager.getString(resultSet,1));
            prpIDCodeDto.setRiskCode(dbManager.getString(resultSet,2));
            prpIDCodeDto.setCodeCode(dbManager.getString(resultSet,3));
            prpIDCodeDto.setCodeCName(dbManager.getString(resultSet,4));
            prpIDCodeDto.setCodeEName(dbManager.getString(resultSet,5));
            prpIDCodeDto.setExcodecode(dbManager.getString(resultSet,6));
            collection.add(prpIDCodeDto);
        }
        resultSet.close();
        log.info("DBPrpIDCodeBase.findByConditions() success!");
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
        String statement = "Delete From PrpIDCode Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpIDCodeBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpIDCode Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpIDCodeBase.getCount() success!");
        return count;
    }
}
