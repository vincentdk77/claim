package com.sinosoft.function.insutil.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDriskDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdrisk的数据访问对象类<br>
 * 创建于 2004-4-6 16:07:46<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDriskBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpDriskBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpDriskBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpDriskDto prpDriskDto
     * @throws Exception
     */
    public void insert(PrpDriskDto prpDriskDto) throws Exception{
        String statement = " Insert Into PrpDrisk(" + 
                           " RiskCode," + 
                           " RiskCName," + 
                           " RiskEName," + 
                           " ClassCode," + 
                           " Calculator," + 
                           " EndDateFlag," + 
                           " RiskFlag," + 
                           " StartHour," + 
                           " NewRiskCode," + 
                           " ValidStatus," + 
                           " ArticleCode," + 
                           " ManageFlag," + 
                           " SettleType," + 
                           " Flag) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpDriskDto.getRiskCode());
        dbManager.setString(2,prpDriskDto.getRiskCName());
        dbManager.setString(3,prpDriskDto.getRiskEName());
        dbManager.setString(4,prpDriskDto.getClassCode());
        dbManager.setInt(5,prpDriskDto.getCalculator());
        dbManager.setString(6,prpDriskDto.getEndDateFlag());
        dbManager.setString(7,prpDriskDto.getRiskFlag());
        dbManager.setInt(8,prpDriskDto.getStartHour());
        dbManager.setString(9,prpDriskDto.getNewRiskCode());
        dbManager.setString(10,prpDriskDto.getValidStatus());
        dbManager.setString(11,prpDriskDto.getArticleCode());
        dbManager.setString(12,prpDriskDto.getManageFlag());
        dbManager.setString(13,prpDriskDto.getSettleType());
        dbManager.setString(14,prpDriskDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDriskBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpDriskDto prpDriskDto = (PrpDriskDto)i.next();
            insert(prpDriskDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param riskCode riskcode
     * @throws Exception
     */
    public void delete(String riskCode) throws Exception{
        String statement = " Delete From PrpDrisk Where " +
                           " RiskCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,riskCode);
        dbManager.executePreparedUpdate();
        log.info("DBPrpDriskBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpDriskDto prpDriskDto
     * @throws Exception
     */
    public void update(PrpDriskDto prpDriskDto) throws Exception{
        String statement = " Update PrpDrisk Set RiskCName = ?," + 
                           " RiskEName = ?," + 
                           " ClassCode = ?," + 
                           " Calculator = ?," + 
                           " EndDateFlag = ?," + 
                           " RiskFlag = ?," + 
                           " StartHour = ?," + 
                           " NewRiskCode = ?," + 
                           " ValidStatus = ?," + 
                           " ArticleCode = ?," + 
                           " ManageFlag = ?," + 
                           " SettleType = ?," + 
                           " Flag = ? Where " +
                           " RiskCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpDriskDto.getRiskCName());
        dbManager.setString(2,prpDriskDto.getRiskEName());
        dbManager.setString(3,prpDriskDto.getClassCode());
        dbManager.setInt(4,prpDriskDto.getCalculator());
        dbManager.setString(5,prpDriskDto.getEndDateFlag());
        dbManager.setString(6,prpDriskDto.getRiskFlag());
        dbManager.setInt(7,prpDriskDto.getStartHour());
        dbManager.setString(8,prpDriskDto.getNewRiskCode());
        dbManager.setString(9,prpDriskDto.getValidStatus());
        dbManager.setString(10,prpDriskDto.getArticleCode());
        dbManager.setString(11,prpDriskDto.getManageFlag());
        dbManager.setString(12,prpDriskDto.getSettleType());
        dbManager.setString(13,prpDriskDto.getFlag());
        //设置条件字段;
        dbManager.setString(14,prpDriskDto.getRiskCode());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDriskBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param riskCode riskcode
     * @return PrpDriskDto
     * @throws Exception
     */
    public PrpDriskDto findByPrimaryKey(String riskCode) throws Exception{
        String statement = " Select RiskCode," + 
                           " RiskCName," + 
                           " RiskEName," + 
                           " ClassCode," + 
                           " Calculator," + 
                           " EndDateFlag," + 
                           " RiskFlag," + 
                           " StartHour," + 
                           " NewRiskCode," + 
                           " ValidStatus," + 
                           " ArticleCode," + 
                           " ManageFlag," + 
                           " SettleType," + 
                           " Flag From PrpDrisk Where " +
                           " RiskCode = ?";
        PrpDriskDto prpDriskDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,riskCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpDriskDto = new PrpDriskDto();
            prpDriskDto.setRiskCode(dbManager.getString(resultSet,1));
            prpDriskDto.setRiskCName(dbManager.getString(resultSet,2));
            prpDriskDto.setRiskEName(dbManager.getString(resultSet,3));
            prpDriskDto.setClassCode(dbManager.getString(resultSet,4));
            prpDriskDto.setCalculator(dbManager.getInt(resultSet,5));
            prpDriskDto.setEndDateFlag(dbManager.getString(resultSet,6));
            prpDriskDto.setRiskFlag(dbManager.getString(resultSet,7));
            prpDriskDto.setStartHour(dbManager.getInt(resultSet,8));
            prpDriskDto.setNewRiskCode(dbManager.getString(resultSet,9));
            prpDriskDto.setValidStatus(dbManager.getString(resultSet,10));
            prpDriskDto.setArticleCode(dbManager.getString(resultSet,11));
            prpDriskDto.setManageFlag(dbManager.getString(resultSet,12));
            prpDriskDto.setSettleType(dbManager.getString(resultSet,13));
            prpDriskDto.setFlag(dbManager.getString(resultSet,14));
        }
        resultSet.close();
        log.info("DBPrpDriskBase.findByPrimaryKey() success!");
        return prpDriskDto;
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
                           " RiskCName," + 
                           " RiskEName," + 
                           " ClassCode," + 
                           " Calculator," + 
                           " EndDateFlag," + 
                           " RiskFlag," + 
                           " StartHour," + 
                           " NewRiskCode," + 
                           " ValidStatus," + 
                           " ArticleCode," + 
                           " ManageFlag," + 
                           " SettleType," + 
                           " Flag From PrpDrisk Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpDriskDto prpDriskDto = null;
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

            prpDriskDto = new PrpDriskDto();
            prpDriskDto.setRiskCode(dbManager.getString(resultSet,1));
            prpDriskDto.setRiskCName(dbManager.getString(resultSet,2));
            prpDriskDto.setRiskEName(dbManager.getString(resultSet,3));
            prpDriskDto.setClassCode(dbManager.getString(resultSet,4));
            prpDriskDto.setCalculator(dbManager.getInt(resultSet,5));
            prpDriskDto.setEndDateFlag(dbManager.getString(resultSet,6));
            prpDriskDto.setRiskFlag(dbManager.getString(resultSet,7));
            prpDriskDto.setStartHour(dbManager.getInt(resultSet,8));
            prpDriskDto.setNewRiskCode(dbManager.getString(resultSet,9));
            prpDriskDto.setValidStatus(dbManager.getString(resultSet,10));
            prpDriskDto.setArticleCode(dbManager.getString(resultSet,11));
            prpDriskDto.setManageFlag(dbManager.getString(resultSet,12));
            prpDriskDto.setSettleType(dbManager.getString(resultSet,13));
            prpDriskDto.setFlag(dbManager.getString(resultSet,14));
            collection.add(prpDriskDto);
        }
        resultSet.close();
        log.info("DBPrpDriskBase.findByConditions() success!");
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
        String statement = "Delete From PrpDrisk Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpDriskBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpDrisk Where " + conditions;
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpDriskBase.getCount() success!");
        return count;
    }
}
