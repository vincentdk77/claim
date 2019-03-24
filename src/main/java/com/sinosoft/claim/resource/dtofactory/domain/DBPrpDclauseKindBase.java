package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDclauseKindDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdclausekind条款险别关系表的数据访问对象类<br>
 * 创建于 2004-4-5 15:33:43<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDclauseKindBase{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpDclauseKindBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpDclauseKindBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpDclauseKindDto prpDclauseKindDto
     * @throws Exception
     */
    public void insert(PrpDclauseKindDto prpDclauseKindDto) throws Exception{
        String statement = " Insert Into PrpDclauseKind(" + 
                           " RiskCode," + 
                           " ClauseType," + 
                           " KindCode," + 
                           " RelateKindCode," + 
                           " Flag) values(?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpDclauseKindDto.getRiskCode());
        dbManager.setString(2,prpDclauseKindDto.getClauseType());
        dbManager.setString(3,prpDclauseKindDto.getKindCode());
        dbManager.setString(4,prpDclauseKindDto.getRelateKindCode());
        dbManager.setString(5,prpDclauseKindDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDclauseKindBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpDclauseKindDto prpDclauseKindDto = (PrpDclauseKindDto)i.next();
            insert(prpDclauseKindDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param riskCode 险种代码
     * @param clauseType 条款类别
     * @param kindCode 险别代码
     * @param relateKindCode 关联险别代码
     * @throws Exception
     */
    public void delete(String riskCode,String clauseType,String kindCode,String relateKindCode) throws Exception{
        String statement = " Delete From PrpDclauseKind Where " +
                           " RiskCode = ? And " + 
                           " ClauseType = ? And " + 
                           " KindCode = ? And " + 
                           " RelateKindCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,riskCode);
        dbManager.setString(2,clauseType);
        dbManager.setString(3,kindCode);
        dbManager.setString(4,relateKindCode);
        dbManager.executePreparedUpdate();
        log.info("DBPrpDclauseKindBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpDclauseKindDto prpDclauseKindDto
     * @throws Exception
     */
    public void update(PrpDclauseKindDto prpDclauseKindDto) throws Exception{
        String statement = " Update PrpDclauseKind Set Flag = ? Where " +
                           " RiskCode = ? And " + 
                           " ClauseType = ? And " + 
                           " KindCode = ? And " + 
                           " RelateKindCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpDclauseKindDto.getFlag());
        //设置条件字段;
        dbManager.setString(2,prpDclauseKindDto.getRiskCode());
        dbManager.setString(3,prpDclauseKindDto.getClauseType());
        dbManager.setString(4,prpDclauseKindDto.getKindCode());
        dbManager.setString(5,prpDclauseKindDto.getRelateKindCode());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDclauseKindBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param riskCode 险种代码
     * @param clauseType 条款类别
     * @param kindCode 险别代码
     * @param relateKindCode 关联险别代码
     * @return PrpDclauseKindDto
     * @throws Exception
     */
    public PrpDclauseKindDto findByPrimaryKey(String riskCode,String clauseType,String kindCode,String relateKindCode) throws Exception{
        String statement = " Select RiskCode," + 
                           " ClauseType," + 
                           " KindCode," + 
                           " RelateKindCode," + 
                           " Flag From PrpDclauseKind Where " +
                           " RiskCode = ? And " + 
                           " ClauseType = ? And " + 
                           " KindCode = ? And " + 
                           " RelateKindCode = ?";
        PrpDclauseKindDto prpDclauseKindDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,riskCode);
        dbManager.setString(2,clauseType);
        dbManager.setString(3,kindCode);
        dbManager.setString(4,relateKindCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpDclauseKindDto = new PrpDclauseKindDto();
            prpDclauseKindDto.setRiskCode(dbManager.getString(resultSet,1));
            prpDclauseKindDto.setClauseType(dbManager.getString(resultSet,2));
            prpDclauseKindDto.setKindCode(dbManager.getString(resultSet,3));
            prpDclauseKindDto.setRelateKindCode(dbManager.getString(resultSet,4));
            prpDclauseKindDto.setFlag(dbManager.getString(resultSet,5));
        }
        resultSet.close();
        log.info("DBPrpDclauseKindBase.findByPrimaryKey() success!");
        return prpDclauseKindDto;
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
                           " ClauseType," + 
                           " KindCode," + 
                           " RelateKindCode," + 
                           " Flag From PrpDclauseKind Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpDclauseKindDto prpDclauseKindDto = null;
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

            prpDclauseKindDto = new PrpDclauseKindDto();
            prpDclauseKindDto.setRiskCode(dbManager.getString(resultSet,1));
            prpDclauseKindDto.setClauseType(dbManager.getString(resultSet,2));
            prpDclauseKindDto.setKindCode(dbManager.getString(resultSet,3));
            prpDclauseKindDto.setRelateKindCode(dbManager.getString(resultSet,4));
            prpDclauseKindDto.setFlag(dbManager.getString(resultSet,5));
            collection.add(prpDclauseKindDto);
        }
        resultSet.close();
        log.info("DBPrpDclauseKindBase.findByConditions() success!");
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
        String statement = "Delete From PrpDclauseKind Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpDclauseKindBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpDclauseKind Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpDclauseKindBase.getCount() success!");
        return count;
    }
}
