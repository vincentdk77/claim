package com.sinosoft.function.insutil.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDStatiTypeDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdstatitype的数据访问对象类<br>
 * 创建于 2004-4-6 16:07:47<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDStatiTypeBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpDStatiTypeBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpDStatiTypeBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpDStatiTypeDto prpDStatiTypeDto
     * @throws Exception
     */
    public void insert(PrpDStatiTypeDto prpDStatiTypeDto) throws Exception{
        String statement = " Insert Into PrpDStatiType(" + 
                           " RiskCode," + 
                           " KindCode," + 
                           " BelongType," + 
                           " ValidDate," + 
                           " Flag) values(?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpDStatiTypeDto.getRiskCode());
        dbManager.setString(2,prpDStatiTypeDto.getKindCode());
        dbManager.setString(3,prpDStatiTypeDto.getBelongType());
        dbManager.setDateTime(4,prpDStatiTypeDto.getValidDate());
        dbManager.setString(5,prpDStatiTypeDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDStatiTypeBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpDStatiTypeDto prpDStatiTypeDto = (PrpDStatiTypeDto)i.next();
            insert(prpDStatiTypeDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param riskCode riskcode
     * @param kindCode kindcode
     * @param belongType belongtype
     * @param validDate validdate
     * @throws Exception
     */
    public void delete(String riskCode,String kindCode,String belongType,DateTime validDate) throws Exception{
        String statement = " Delete From PrpDStatiType Where " +
                           " RiskCode = ? And " + 
                           " KindCode = ? And " + 
                           " BelongType = ? And " + 
                           " ValidDate = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,riskCode);
        dbManager.setString(2,kindCode);
        dbManager.setString(3,belongType);
        dbManager.setDateTime(4,validDate);
        dbManager.executePreparedUpdate();
        log.info("DBPrpDStatiTypeBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpDStatiTypeDto prpDStatiTypeDto
     * @throws Exception
     */
    public void update(PrpDStatiTypeDto prpDStatiTypeDto) throws Exception{
        String statement = " Update PrpDStatiType Set Flag = ? Where " +
                           " RiskCode = ? And " + 
                           " KindCode = ? And " + 
                           " BelongType = ? And " + 
                           " ValidDate = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpDStatiTypeDto.getFlag());
        //设置条件字段;
        dbManager.setString(2,prpDStatiTypeDto.getRiskCode());
        dbManager.setString(3,prpDStatiTypeDto.getKindCode());
        dbManager.setString(4,prpDStatiTypeDto.getBelongType());
        dbManager.setDateTime(5,prpDStatiTypeDto.getValidDate());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDStatiTypeBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param riskCode riskcode
     * @param kindCode kindcode
     * @param belongType belongtype
     * @param validDate validdate
     * @return PrpDStatiTypeDto
     * @throws Exception
     */
    public PrpDStatiTypeDto findByPrimaryKey(String riskCode,String kindCode,String belongType,DateTime validDate) throws Exception{
        String statement = " Select RiskCode," + 
                           " KindCode," + 
                           " BelongType," + 
                           " ValidDate," + 
                           " Flag From PrpDStatiType Where " +
                           " RiskCode = ? And " + 
                           " KindCode = ? And " + 
                           " BelongType = ? And " + 
                           " ValidDate = ?";
        PrpDStatiTypeDto prpDStatiTypeDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,riskCode);
        dbManager.setString(2,kindCode);
        dbManager.setString(3,belongType);
        dbManager.setDateTime(4,validDate);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpDStatiTypeDto = new PrpDStatiTypeDto();
            prpDStatiTypeDto.setRiskCode(dbManager.getString(resultSet,1));
            prpDStatiTypeDto.setKindCode(dbManager.getString(resultSet,2));
            prpDStatiTypeDto.setBelongType(dbManager.getString(resultSet,3));
            prpDStatiTypeDto.setValidDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,4));
            prpDStatiTypeDto.setFlag(dbManager.getString(resultSet,5));
        }
        resultSet.close();
        log.info("DBPrpDStatiTypeBase.findByPrimaryKey() success!");
        return prpDStatiTypeDto;
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
                           " KindCode," + 
                           " BelongType," + 
                           " ValidDate," + 
                           " Flag From PrpDStatiType Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpDStatiTypeDto prpDStatiTypeDto = null;
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

            prpDStatiTypeDto = new PrpDStatiTypeDto();
            prpDStatiTypeDto.setRiskCode(dbManager.getString(resultSet,1));
            prpDStatiTypeDto.setKindCode(dbManager.getString(resultSet,2));
            prpDStatiTypeDto.setBelongType(dbManager.getString(resultSet,3));
            prpDStatiTypeDto.setValidDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,4));
            prpDStatiTypeDto.setFlag(dbManager.getString(resultSet,5));
            collection.add(prpDStatiTypeDto);
        }
        resultSet.close();
        log.info("DBPrpDStatiTypeBase.findByConditions() success!");
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
        String statement = "Delete From PrpDStatiType Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpDStatiTypeBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpDStatiType Where " + conditions;
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpDStatiTypeBase.getCount() success!");
        return count;
    }
}
