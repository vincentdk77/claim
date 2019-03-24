package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCreditAssureDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpCreditAssure风险预警确认函号表的数据访问对象类<br>
 * 创建于 2004-4-5 15:32:09<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpCreditAssureBase{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpCreditAssureBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpCreditAssureBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpCreditAssureDto prpCreditAssureDto
     * @throws Exception
     */
    public void insert(PrpCreditAssureDto prpCreditAssureDto) throws Exception{
        String statement = " Insert Into PrpCreditAssure(" + 
                           " ConfirmNo," + 
                           " InvestigateNo," + 
                           " Flag) values(?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpCreditAssureDto.getConfirmNo());
        dbManager.setString(2,prpCreditAssureDto.getInvestigateNo());
        dbManager.setString(3,prpCreditAssureDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCreditAssureBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpCreditAssureDto prpCreditAssureDto = (PrpCreditAssureDto)i.next();
            insert(prpCreditAssureDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param confirmNo 风险预警确认函号
     * @throws Exception
     */
    public void delete(String confirmNo) throws Exception{
        String statement = " Delete From PrpCreditAssure Where " +
                           " ConfirmNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,confirmNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpCreditAssureBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpCreditAssureDto prpCreditAssureDto
     * @throws Exception
     */
    public void update(PrpCreditAssureDto prpCreditAssureDto) throws Exception{
        String statement = " Update PrpCreditAssure Set InvestigateNo = ?," + 
                           " Flag = ? Where " +
                           " ConfirmNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpCreditAssureDto.getInvestigateNo());
        dbManager.setString(2,prpCreditAssureDto.getFlag());
        //设置条件字段;
        dbManager.setString(3,prpCreditAssureDto.getConfirmNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCreditAssureBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param confirmNo 风险预警确认函号
     * @return PrpCreditAssureDto
     * @throws Exception
     */
    public PrpCreditAssureDto findByPrimaryKey(String confirmNo) throws Exception{
        String statement = " Select ConfirmNo," + 
                           " InvestigateNo," + 
                           " Flag From PrpCreditAssure Where " +
                           " ConfirmNo = ?";
        PrpCreditAssureDto prpCreditAssureDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,confirmNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpCreditAssureDto = new PrpCreditAssureDto();
            prpCreditAssureDto.setConfirmNo(dbManager.getString(resultSet,1));
            prpCreditAssureDto.setInvestigateNo(dbManager.getString(resultSet,2));
            prpCreditAssureDto.setFlag(dbManager.getString(resultSet,3));
        }
        resultSet.close();
        log.info("DBPrpCreditAssureBase.findByPrimaryKey() success!");
        return prpCreditAssureDto;
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
        String statement = "Select ConfirmNo," + 
                           " InvestigateNo," + 
                           " Flag From PrpCreditAssure Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpCreditAssureDto prpCreditAssureDto = null;
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

            prpCreditAssureDto = new PrpCreditAssureDto();
            prpCreditAssureDto.setConfirmNo(dbManager.getString(resultSet,1));
            prpCreditAssureDto.setInvestigateNo(dbManager.getString(resultSet,2));
            prpCreditAssureDto.setFlag(dbManager.getString(resultSet,3));
            collection.add(prpCreditAssureDto);
        }
        resultSet.close();
        log.info("DBPrpCreditAssureBase.findByConditions() success!");
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
        String statement = "Delete From PrpCreditAssure Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpCreditAssureBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpCreditAssure Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpCreditAssureBase.getCount() success!");
        return count;
    }
}
