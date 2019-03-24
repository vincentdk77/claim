package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDrationDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdration定额保单标的险别代码表的数据访问对象类<br>
 * 创建于 2004-4-5 15:33:42<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDrationBase{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpDrationBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpDrationBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpDrationDto prpDrationDto
     * @throws Exception
     */
    public void insert(PrpDrationDto prpDrationDto) throws Exception{
        String statement = " Insert Into PrpDration(" + 
                           " RiskCode," + 
                           " RationType," + 
                           " RationName," + 
                           " ItemCode," + 
                           " KindCode," + 
                           " Currency," + 
                           " Amount," + 
                           " Rate," + 
                           " Premium," + 
                           " Flag) values(?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpDrationDto.getRiskCode());
        dbManager.setString(2,prpDrationDto.getRationType());
        dbManager.setString(3,prpDrationDto.getRationName());
        dbManager.setString(4,prpDrationDto.getItemCode());
        dbManager.setString(5,prpDrationDto.getKindCode());
        dbManager.setString(6,prpDrationDto.getCurrency());
        dbManager.setDouble(7,prpDrationDto.getAmount());
        dbManager.setDouble(8,prpDrationDto.getRate());
        dbManager.setDouble(9,prpDrationDto.getPremium());
        dbManager.setString(10,prpDrationDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDrationBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpDrationDto prpDrationDto = (PrpDrationDto)i.next();
            insert(prpDrationDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param riskCode 险种代码
     * @param rationType 定额类型代码
     * @param itemCode 标的类别
     * @param kindCode 险别代码
     * @throws Exception
     */
    public void delete(String riskCode,String rationType,String itemCode,String kindCode) throws Exception{
        String statement = " Delete From PrpDration Where " +
                           " RiskCode = ? And " + 
                           " RationType = ? And " + 
                           " ItemCode = ? And " + 
                           " KindCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,riskCode);
        dbManager.setString(2,rationType);
        dbManager.setString(3,itemCode);
        dbManager.setString(4,kindCode);
        dbManager.executePreparedUpdate();
        log.info("DBPrpDrationBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpDrationDto prpDrationDto
     * @throws Exception
     */
    public void update(PrpDrationDto prpDrationDto) throws Exception{
        String statement = " Update PrpDration Set RationName = ?," + 
                           " Currency = ?," + 
                           " Amount = ?," + 
                           " Rate = ?," + 
                           " Premium = ?," + 
                           " Flag = ? Where " +
                           " RiskCode = ? And " + 
                           " RationType = ? And " + 
                           " ItemCode = ? And " + 
                           " KindCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpDrationDto.getRationName());
        dbManager.setString(2,prpDrationDto.getCurrency());
        dbManager.setDouble(3,prpDrationDto.getAmount());
        dbManager.setDouble(4,prpDrationDto.getRate());
        dbManager.setDouble(5,prpDrationDto.getPremium());
        dbManager.setString(6,prpDrationDto.getFlag());
        //设置条件字段;
        dbManager.setString(7,prpDrationDto.getRiskCode());
        dbManager.setString(8,prpDrationDto.getRationType());
        dbManager.setString(9,prpDrationDto.getItemCode());
        dbManager.setString(10,prpDrationDto.getKindCode());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDrationBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param riskCode 险种代码
     * @param rationType 定额类型代码
     * @param itemCode 标的类别
     * @param kindCode 险别代码
     * @return PrpDrationDto
     * @throws Exception
     */
    public PrpDrationDto findByPrimaryKey(String riskCode,String rationType,String itemCode,String kindCode) throws Exception{
        String statement = " Select RiskCode," + 
                           " RationType," + 
                           " RationName," + 
                           " ItemCode," + 
                           " KindCode," + 
                           " Currency," + 
                           " Amount," + 
                           " Rate," + 
                           " Premium," + 
                           " Flag From PrpDration Where " +
                           " RiskCode = ? And " + 
                           " RationType = ? And " + 
                           " ItemCode = ? And " + 
                           " KindCode = ?";
        PrpDrationDto prpDrationDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,riskCode);
        dbManager.setString(2,rationType);
        dbManager.setString(3,itemCode);
        dbManager.setString(4,kindCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpDrationDto = new PrpDrationDto();
            prpDrationDto.setRiskCode(dbManager.getString(resultSet,1));
            prpDrationDto.setRationType(dbManager.getString(resultSet,2));
            prpDrationDto.setRationName(dbManager.getString(resultSet,3));
            prpDrationDto.setItemCode(dbManager.getString(resultSet,4));
            prpDrationDto.setKindCode(dbManager.getString(resultSet,5));
            prpDrationDto.setCurrency(dbManager.getString(resultSet,6));
            prpDrationDto.setAmount(dbManager.getDouble(resultSet,7));
            prpDrationDto.setRate(dbManager.getDouble(resultSet,8));
            prpDrationDto.setPremium(dbManager.getDouble(resultSet,9));
            prpDrationDto.setFlag(dbManager.getString(resultSet,10));
        }
        resultSet.close();
        log.info("DBPrpDrationBase.findByPrimaryKey() success!");
        return prpDrationDto;
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
                           " RationType," + 
                           " RationName," + 
                           " ItemCode," + 
                           " KindCode," + 
                           " Currency," + 
                           " Amount," + 
                           " Rate," + 
                           " Premium," + 
                           " Flag From PrpDration Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpDrationDto prpDrationDto = null;
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

            prpDrationDto = new PrpDrationDto();
            prpDrationDto.setRiskCode(dbManager.getString(resultSet,1));
            prpDrationDto.setRationType(dbManager.getString(resultSet,2));
            prpDrationDto.setRationName(dbManager.getString(resultSet,3));
            prpDrationDto.setItemCode(dbManager.getString(resultSet,4));
            prpDrationDto.setKindCode(dbManager.getString(resultSet,5));
            prpDrationDto.setCurrency(dbManager.getString(resultSet,6));
            prpDrationDto.setAmount(dbManager.getDouble(resultSet,7));
            prpDrationDto.setRate(dbManager.getDouble(resultSet,8));
            prpDrationDto.setPremium(dbManager.getDouble(resultSet,9));
            prpDrationDto.setFlag(dbManager.getString(resultSet,10));
            collection.add(prpDrationDto);
        }
        resultSet.close();
        log.info("DBPrpDrationBase.findByConditions() success!");
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
        String statement = "Delete From PrpDration Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpDrationBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpDration Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpDrationBase.getCount() success!");
        return count;
    }
}
