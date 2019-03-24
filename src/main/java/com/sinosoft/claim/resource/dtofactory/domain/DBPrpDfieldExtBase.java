package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDfieldExtDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdfieldext扩展字段的数据访问对象类<br>
 * 创建于 2004-4-5 15:33:42<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDfieldExtBase{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpDfieldExtBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpDfieldExtBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpDfieldExtDto prpDfieldExtDto
     * @throws Exception
     */
    public void insert(PrpDfieldExtDto prpDfieldExtDto) throws Exception{
        String statement = " Insert Into PrpDfieldExt(" + 
                           " CodeType," + 
                           " RiskCode," + 
                           " CodeCode," + 
                           " CodeCName," + 
                           " ColumnName," + 
                           " DisplayName," + 
                           " KeyFlag," + 
                           " Flag) values(?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpDfieldExtDto.getCodeType());
        dbManager.setString(2,prpDfieldExtDto.getRiskCode());
        dbManager.setString(3,prpDfieldExtDto.getCodeCode());
        dbManager.setString(4,prpDfieldExtDto.getCodeCName());
        dbManager.setString(5,prpDfieldExtDto.getColumnName());
        dbManager.setString(6,prpDfieldExtDto.getDisplayName());
        dbManager.setString(7,prpDfieldExtDto.getKeyFlag());
        dbManager.setString(8,prpDfieldExtDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDfieldExtBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpDfieldExtDto prpDfieldExtDto = (PrpDfieldExtDto)i.next();
            insert(prpDfieldExtDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param codeType 代码类型
     * @param riskCode 险种代码
     * @param codeCode 业务代码
     * @param columnName 扩充字段名
     * @throws Exception
     */
    public void delete(String codeType,String riskCode,String codeCode,String columnName) throws Exception{
        String statement = " Delete From PrpDfieldExt Where " +
                           " CodeType = ? And " + 
                           " RiskCode = ? And " + 
                           " CodeCode = ? And " + 
                           " ColumnName = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,codeType);
        dbManager.setString(2,riskCode);
        dbManager.setString(3,codeCode);
        dbManager.setString(4,columnName);
        dbManager.executePreparedUpdate();
        log.info("DBPrpDfieldExtBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpDfieldExtDto prpDfieldExtDto
     * @throws Exception
     */
    public void update(PrpDfieldExtDto prpDfieldExtDto) throws Exception{
        String statement = " Update PrpDfieldExt Set CodeCName = ?," + 
                           " DisplayName = ?," + 
                           " KeyFlag = ?," + 
                           " Flag = ? Where " +
                           " CodeType = ? And " + 
                           " RiskCode = ? And " + 
                           " CodeCode = ? And " + 
                           " ColumnName = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpDfieldExtDto.getCodeCName());
        dbManager.setString(2,prpDfieldExtDto.getDisplayName());
        dbManager.setString(3,prpDfieldExtDto.getKeyFlag());
        dbManager.setString(4,prpDfieldExtDto.getFlag());
        //设置条件字段;
        dbManager.setString(5,prpDfieldExtDto.getCodeType());
        dbManager.setString(6,prpDfieldExtDto.getRiskCode());
        dbManager.setString(7,prpDfieldExtDto.getCodeCode());
        dbManager.setString(8,prpDfieldExtDto.getColumnName());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDfieldExtBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param codeType 代码类型
     * @param riskCode 险种代码
     * @param codeCode 业务代码
     * @param columnName 扩充字段名
     * @return PrpDfieldExtDto
     * @throws Exception
     */
    public PrpDfieldExtDto findByPrimaryKey(String codeType,String riskCode,String codeCode,String columnName) throws Exception{
        String statement = " Select CodeType," + 
                           " RiskCode," + 
                           " CodeCode," + 
                           " CodeCName," + 
                           " ColumnName," + 
                           " DisplayName," + 
                           " KeyFlag," + 
                           " Flag From PrpDfieldExt Where " +
                           " CodeType = ? And " + 
                           " RiskCode = ? And " + 
                           " CodeCode = ? And " + 
                           " ColumnName = ?";
        PrpDfieldExtDto prpDfieldExtDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,codeType);
        dbManager.setString(2,riskCode);
        dbManager.setString(3,codeCode);
        dbManager.setString(4,columnName);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpDfieldExtDto = new PrpDfieldExtDto();
            prpDfieldExtDto.setCodeType(dbManager.getString(resultSet,1));
            prpDfieldExtDto.setRiskCode(dbManager.getString(resultSet,2));
            prpDfieldExtDto.setCodeCode(dbManager.getString(resultSet,3));
            prpDfieldExtDto.setCodeCName(dbManager.getString(resultSet,4));
            prpDfieldExtDto.setColumnName(dbManager.getString(resultSet,5));
            prpDfieldExtDto.setDisplayName(dbManager.getString(resultSet,6));
            prpDfieldExtDto.setKeyFlag(dbManager.getString(resultSet,7));
            prpDfieldExtDto.setFlag(dbManager.getString(resultSet,8));
        }
        resultSet.close();
        log.info("DBPrpDfieldExtBase.findByPrimaryKey() success!");
        return prpDfieldExtDto;
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
                           " ColumnName," + 
                           " DisplayName," + 
                           " KeyFlag," + 
                           " Flag From PrpDfieldExt Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpDfieldExtDto prpDfieldExtDto = null;
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

            prpDfieldExtDto = new PrpDfieldExtDto();
            prpDfieldExtDto.setCodeType(dbManager.getString(resultSet,1));
            prpDfieldExtDto.setRiskCode(dbManager.getString(resultSet,2));
            prpDfieldExtDto.setCodeCode(dbManager.getString(resultSet,3));
            prpDfieldExtDto.setCodeCName(dbManager.getString(resultSet,4));
            prpDfieldExtDto.setColumnName(dbManager.getString(resultSet,5));
            prpDfieldExtDto.setDisplayName(dbManager.getString(resultSet,6));
            prpDfieldExtDto.setKeyFlag(dbManager.getString(resultSet,7));
            prpDfieldExtDto.setFlag(dbManager.getString(resultSet,8));
            collection.add(prpDfieldExtDto);
        }
        resultSet.close();
        log.info("DBPrpDfieldExtBase.findByConditions() success!");
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
        String statement = "Delete From PrpDfieldExt Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpDfieldExtBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpDfieldExt Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpDfieldExtBase.getCount() success!");
        return count;
    }
}
