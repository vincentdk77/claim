package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDcodeRiskDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdcoderisk通用代码险种对照表的数据访问对象类<br>
 * 创建于 2004-4-5 15:33:42<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDcodeRiskBase{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpDcodeRiskBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpDcodeRiskBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpDcodeRiskDto prpDcodeRiskDto
     * @throws Exception
     */
    public void insert(PrpDcodeRiskDto prpDcodeRiskDto) throws Exception{
        String statement = " Insert Into PrpDcodeRisk(" + 
                           " CodeType," + 
                           " CodeCode," + 
                           " RiskCode) values(?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpDcodeRiskDto.getCodeType());
        dbManager.setString(2,prpDcodeRiskDto.getCodeCode());
        dbManager.setString(3,prpDcodeRiskDto.getRiskCode());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDcodeRiskBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpDcodeRiskDto prpDcodeRiskDto = (PrpDcodeRiskDto)i.next();
            insert(prpDcodeRiskDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param codeType 代码类型
     * @param codeCode 业务代码
     * @param riskCode 险种代码
     * @throws Exception
     */
    public void delete(String codeType,String codeCode,String riskCode) throws Exception{
        String statement = " Delete From PrpDcodeRisk Where " +
                           " CodeType = ? And " + 
                           " CodeCode = ? And " + 
                           " RiskCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,codeType);
        dbManager.setString(2,codeCode);
        dbManager.setString(3,riskCode);
        dbManager.executePreparedUpdate();
        log.info("DBPrpDcodeRiskBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpDcodeRiskDto prpDcodeRiskDto
     * @throws Exception
     */
    public void update(PrpDcodeRiskDto prpDcodeRiskDto) throws Exception{
        String statement = " Update PrpDcodeRisk Set  Where " +
                           " CodeType = ? And " + 
                           " CodeCode = ? And " + 
                           " RiskCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        //设置条件字段;
        dbManager.setString(1,prpDcodeRiskDto.getCodeType());
        dbManager.setString(2,prpDcodeRiskDto.getCodeCode());
        dbManager.setString(3,prpDcodeRiskDto.getRiskCode());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDcodeRiskBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param codeType 代码类型
     * @param codeCode 业务代码
     * @param riskCode 险种代码
     * @return PrpDcodeRiskDto
     * @throws Exception
     */
    public PrpDcodeRiskDto findByPrimaryKey(String codeType,String codeCode,String riskCode) throws Exception{
        String statement = " Select CodeType," + 
                           " CodeCode," + 
                           " RiskCode From PrpDcodeRisk Where " +
                           " CodeType = ? And " + 
                           " CodeCode = ? And " + 
                           " RiskCode = ?";
        PrpDcodeRiskDto prpDcodeRiskDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,codeType);
        dbManager.setString(2,codeCode);
        dbManager.setString(3,riskCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpDcodeRiskDto = new PrpDcodeRiskDto();
            prpDcodeRiskDto.setCodeType(dbManager.getString(resultSet,1));
            prpDcodeRiskDto.setCodeCode(dbManager.getString(resultSet,2));
            prpDcodeRiskDto.setRiskCode(dbManager.getString(resultSet,3));
        }
        resultSet.close();
        log.info("DBPrpDcodeRiskBase.findByPrimaryKey() success!");
        return prpDcodeRiskDto;
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
                           " RiskCode From PrpDcodeRisk Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpDcodeRiskDto prpDcodeRiskDto = null;
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

            prpDcodeRiskDto = new PrpDcodeRiskDto();
            prpDcodeRiskDto.setCodeType(dbManager.getString(resultSet,1));
            prpDcodeRiskDto.setCodeCode(dbManager.getString(resultSet,2));
            prpDcodeRiskDto.setRiskCode(dbManager.getString(resultSet,3));
            collection.add(prpDcodeRiskDto);
        }
        resultSet.close();
        log.info("DBPrpDcodeRiskBase.findByConditions() success!");
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
        String statement = "Delete From PrpDcodeRisk Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpDcodeRiskBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpDcodeRisk Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpDcodeRiskBase.getCount() success!");
        return count;
    }
}
