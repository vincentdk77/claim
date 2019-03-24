package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCrenewalDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpcrenewal续保信息表的数据访问对象类<br>
 * 创建于 2004-4-5 15:32:10<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpCrenewalBase{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpCrenewalBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpCrenewalBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpCrenewalDto prpCrenewalDto
     * @throws Exception
     */
    public void insert(PrpCrenewalDto prpCrenewalDto) throws Exception{
        String statement = " Insert Into PrpCrenewal(" + 
                           " PolicyNo," + 
                           " OldPolicyNo," + 
                           " Flag) values(?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpCrenewalDto.getPolicyNo());
        dbManager.setString(2,prpCrenewalDto.getOldPolicyNo());
        dbManager.setString(3,prpCrenewalDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCrenewalBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpCrenewalDto prpCrenewalDto = (PrpCrenewalDto)i.next();
            insert(prpCrenewalDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param policyNo 保单号码
     * @throws Exception
     */
    public void delete(String policyNo) throws Exception{
        String statement = " Delete From PrpCrenewal Where " +
                           " PolicyNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,policyNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpCrenewalBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpCrenewalDto prpCrenewalDto
     * @throws Exception
     */
    public void update(PrpCrenewalDto prpCrenewalDto) throws Exception{
        String statement = " Update PrpCrenewal Set OldPolicyNo = ?," + 
                           " Flag = ? Where " +
                           " PolicyNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpCrenewalDto.getOldPolicyNo());
        dbManager.setString(2,prpCrenewalDto.getFlag());
        //设置条件字段;
        dbManager.setString(3,prpCrenewalDto.getPolicyNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCrenewalBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param policyNo 保单号码
     * @return PrpCrenewalDto
     * @throws Exception
     */
    public PrpCrenewalDto findByPrimaryKey(String policyNo) throws Exception{
        String statement = " Select PolicyNo," + 
                           " OldPolicyNo," + 
                           " Flag From PrpCrenewal Where " +
                           " PolicyNo = ?";
        PrpCrenewalDto prpCrenewalDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,policyNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpCrenewalDto = new PrpCrenewalDto();
            prpCrenewalDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCrenewalDto.setOldPolicyNo(dbManager.getString(resultSet,2));
            prpCrenewalDto.setFlag(dbManager.getString(resultSet,3));
        }
        resultSet.close();
        log.info("DBPrpCrenewalBase.findByPrimaryKey() success!");
        return prpCrenewalDto;
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
        String statement = "Select PolicyNo," + 
                           " OldPolicyNo," + 
                           " Flag From PrpCrenewal Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpCrenewalDto prpCrenewalDto = null;
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

            prpCrenewalDto = new PrpCrenewalDto();
            prpCrenewalDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCrenewalDto.setOldPolicyNo(dbManager.getString(resultSet,2));
            prpCrenewalDto.setFlag(dbManager.getString(resultSet,3));
            collection.add(prpCrenewalDto);
        }
        resultSet.close();
        log.info("DBPrpCrenewalBase.findByConditions() success!");
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
        String statement = "Delete From PrpCrenewal Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpCrenewalBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpCrenewal Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpCrenewalBase.getCount() success!");
        return count;
    }
}
