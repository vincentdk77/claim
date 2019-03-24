package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDstatiTypeDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdstatitype险种统计分类表的数据访问对象类<br>
 * 创建于 2004-4-5 15:33:43<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDstatiTypeBase{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpDstatiTypeBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpDstatiTypeBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpDstatiTypeDto prpDstatiTypeDto
     * @throws Exception
     */
    public void insert(PrpDstatiTypeDto prpDstatiTypeDto) throws Exception{
        String statement = " Insert Into PrpDstatiType(" + 
                           " RiskCode," + 
                           " KindCode," + 
                           " BelongType," + 
                           " ValidDate," + 
                           " Flag) values(?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpDstatiTypeDto.getRiskCode());
        dbManager.setString(2,prpDstatiTypeDto.getKindCode());
        dbManager.setString(3,prpDstatiTypeDto.getBelongType());
        dbManager.setDateTime(4,prpDstatiTypeDto.getValidDate());
        dbManager.setString(5,prpDstatiTypeDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDstatiTypeBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpDstatiTypeDto prpDstatiTypeDto = (PrpDstatiTypeDto)i.next();
            insert(prpDstatiTypeDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param riskCode 险种
     * @param kindCode 险别
     * @param belongType 统计类型
     * @param validDate 生效日期
     * @throws Exception
     */
    public void delete(String riskCode,String kindCode,String belongType,DateTime validDate) throws Exception{
        String statement = " Delete From PrpDstatiType Where " +
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
        log.info("DBPrpDstatiTypeBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpDstatiTypeDto prpDstatiTypeDto
     * @throws Exception
     */
    public void update(PrpDstatiTypeDto prpDstatiTypeDto) throws Exception{
        String statement = " Update PrpDstatiType Set Flag = ? Where " +
                           " RiskCode = ? And " + 
                           " KindCode = ? And " + 
                           " BelongType = ? And " + 
                           " ValidDate = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpDstatiTypeDto.getFlag());
        //设置条件字段;
        dbManager.setString(2,prpDstatiTypeDto.getRiskCode());
        dbManager.setString(3,prpDstatiTypeDto.getKindCode());
        dbManager.setString(4,prpDstatiTypeDto.getBelongType());
        dbManager.setDateTime(5,prpDstatiTypeDto.getValidDate());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDstatiTypeBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param riskCode 险种
     * @param kindCode 险别
     * @param belongType 统计类型
     * @param validDate 生效日期
     * @return PrpDstatiTypeDto
     * @throws Exception
     */
    public PrpDstatiTypeDto findByPrimaryKey(String riskCode,String kindCode,String belongType,DateTime validDate) throws Exception{
        String statement = " Select RiskCode," + 
                           " KindCode," + 
                           " BelongType," + 
                           " ValidDate," + 
                           " Flag From PrpDstatiType Where " +
                           " RiskCode = ? And " + 
                           " KindCode = ? And " + 
                           " BelongType = ? And " + 
                           " ValidDate = ?";
        PrpDstatiTypeDto prpDstatiTypeDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,riskCode);
        dbManager.setString(2,kindCode);
        dbManager.setString(3,belongType);
        dbManager.setDateTime(4,validDate);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpDstatiTypeDto = new PrpDstatiTypeDto();
            prpDstatiTypeDto.setRiskCode(dbManager.getString(resultSet,1));
            prpDstatiTypeDto.setKindCode(dbManager.getString(resultSet,2));
            prpDstatiTypeDto.setBelongType(dbManager.getString(resultSet,3));
            prpDstatiTypeDto.setValidDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,4));
            prpDstatiTypeDto.setFlag(dbManager.getString(resultSet,5));
        }
        resultSet.close();
        log.info("DBPrpDstatiTypeBase.findByPrimaryKey() success!");
        return prpDstatiTypeDto;
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
                           " Flag From PrpDstatiType Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpDstatiTypeDto prpDstatiTypeDto = null;
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

            prpDstatiTypeDto = new PrpDstatiTypeDto();
            prpDstatiTypeDto.setRiskCode(dbManager.getString(resultSet,1));
            prpDstatiTypeDto.setKindCode(dbManager.getString(resultSet,2));
            prpDstatiTypeDto.setBelongType(dbManager.getString(resultSet,3));
            prpDstatiTypeDto.setValidDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,4));
            prpDstatiTypeDto.setFlag(dbManager.getString(resultSet,5));
            collection.add(prpDstatiTypeDto);
        }
        resultSet.close();
        log.info("DBPrpDstatiTypeBase.findByConditions() success!");
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
        String statement = "Delete From PrpDstatiType Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpDstatiTypeBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpDstatiType Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);        
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpDstatiTypeBase.getCount() success!");
        return count;
    }
}
