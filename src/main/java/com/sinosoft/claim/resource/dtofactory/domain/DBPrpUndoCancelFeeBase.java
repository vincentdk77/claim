package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpUndoCancelFeeDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpUndoCancelFee作废或删除操作轨迹附表的数据访问对象类<br>
 * 创建于 2004-4-5 15:32:11<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpUndoCancelFeeBase{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpUndoCancelFeeBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpUndoCancelFeeBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpUndoCancelFeeDto prpUndoCancelFeeDto
     * @throws Exception
     */
    public void insert(PrpUndoCancelFeeDto prpUndoCancelFeeDto) throws Exception{
        String statement = " Insert Into PrpUndoCancelFee(" + 
                           " OperateTypeCode," + 
                           " CertiNo," + 
                           " SerialNo," + 
                           " Currency," + 
                           " Amount," + 
                           " Premium," + 
                           " Flag) values(?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpUndoCancelFeeDto.getOperateTypeCode());
        dbManager.setString(2,prpUndoCancelFeeDto.getCertiNo());
        dbManager.setInt(3,prpUndoCancelFeeDto.getSerialNo());
        dbManager.setString(4,prpUndoCancelFeeDto.getCurrency());
        dbManager.setDouble(5,prpUndoCancelFeeDto.getAmount());
        dbManager.setDouble(6,prpUndoCancelFeeDto.getPremium());
        dbManager.setString(7,prpUndoCancelFeeDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpUndoCancelFeeBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpUndoCancelFeeDto prpUndoCancelFeeDto = (PrpUndoCancelFeeDto)i.next();
            insert(prpUndoCancelFeeDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param operateTypeCode 操作类型代码
     * @param certiNo 单证号
     * @param serialNo 序号
     * @param currency 币别代码
     * @throws Exception
     */
    public void delete(String operateTypeCode,String certiNo,int serialNo,String currency) throws Exception{
        String statement = " Delete From PrpUndoCancelFee Where " +
                           " OperateTypeCode = ? And " + 
                           " CertiNo = ? And " + 
                           " SerialNo = ? And " + 
                           " Currency = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,operateTypeCode);
        dbManager.setString(2,certiNo);
        dbManager.setInt(3,serialNo);
        dbManager.setString(4,currency);
        dbManager.executePreparedUpdate();
        log.info("DBPrpUndoCancelFeeBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpUndoCancelFeeDto prpUndoCancelFeeDto
     * @throws Exception
     */
    public void update(PrpUndoCancelFeeDto prpUndoCancelFeeDto) throws Exception{
        String statement = " Update PrpUndoCancelFee Set Amount = ?," + 
                           " Premium = ?," + 
                           " Flag = ? Where " +
                           " OperateTypeCode = ? And " + 
                           " CertiNo = ? And " + 
                           " SerialNo = ? And " + 
                           " Currency = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setDouble(1,prpUndoCancelFeeDto.getAmount());
        dbManager.setDouble(2,prpUndoCancelFeeDto.getPremium());
        dbManager.setString(3,prpUndoCancelFeeDto.getFlag());
        //设置条件字段;
        dbManager.setString(4,prpUndoCancelFeeDto.getOperateTypeCode());
        dbManager.setString(5,prpUndoCancelFeeDto.getCertiNo());
        dbManager.setInt(6,prpUndoCancelFeeDto.getSerialNo());
        dbManager.setString(7,prpUndoCancelFeeDto.getCurrency());
        dbManager.executePreparedUpdate();

        log.info("DBPrpUndoCancelFeeBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param operateTypeCode 操作类型代码
     * @param certiNo 单证号
     * @param serialNo 序号
     * @param currency 币别代码
     * @return PrpUndoCancelFeeDto
     * @throws Exception
     */
    public PrpUndoCancelFeeDto findByPrimaryKey(String operateTypeCode,String certiNo,int serialNo,String currency) throws Exception{
        String statement = " Select OperateTypeCode," + 
                           " CertiNo," + 
                           " SerialNo," + 
                           " Currency," + 
                           " Amount," + 
                           " Premium," + 
                           " Flag From PrpUndoCancelFee Where " +
                           " OperateTypeCode = ? And " + 
                           " CertiNo = ? And " + 
                           " SerialNo = ? And " + 
                           " Currency = ?";
        PrpUndoCancelFeeDto prpUndoCancelFeeDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,operateTypeCode);
        dbManager.setString(2,certiNo);
        dbManager.setInt(3,serialNo);
        dbManager.setString(4,currency);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpUndoCancelFeeDto = new PrpUndoCancelFeeDto();
            prpUndoCancelFeeDto.setOperateTypeCode(dbManager.getString(resultSet,1));
            prpUndoCancelFeeDto.setCertiNo(dbManager.getString(resultSet,2));
            prpUndoCancelFeeDto.setSerialNo(dbManager.getInt(resultSet,3));
            prpUndoCancelFeeDto.setCurrency(dbManager.getString(resultSet,4));
            prpUndoCancelFeeDto.setAmount(dbManager.getDouble(resultSet,5));
            prpUndoCancelFeeDto.setPremium(dbManager.getDouble(resultSet,6));
            prpUndoCancelFeeDto.setFlag(dbManager.getString(resultSet,7));
        }
        resultSet.close();
        log.info("DBPrpUndoCancelFeeBase.findByPrimaryKey() success!");
        return prpUndoCancelFeeDto;
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
        String statement = "Select OperateTypeCode," + 
                           " CertiNo," + 
                           " SerialNo," + 
                           " Currency," + 
                           " Amount," + 
                           " Premium," + 
                           " Flag From PrpUndoCancelFee Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpUndoCancelFeeDto prpUndoCancelFeeDto = null;
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

            prpUndoCancelFeeDto = new PrpUndoCancelFeeDto();
            prpUndoCancelFeeDto.setOperateTypeCode(dbManager.getString(resultSet,1));
            prpUndoCancelFeeDto.setCertiNo(dbManager.getString(resultSet,2));
            prpUndoCancelFeeDto.setSerialNo(dbManager.getInt(resultSet,3));
            prpUndoCancelFeeDto.setCurrency(dbManager.getString(resultSet,4));
            prpUndoCancelFeeDto.setAmount(dbManager.getDouble(resultSet,5));
            prpUndoCancelFeeDto.setPremium(dbManager.getDouble(resultSet,6));
            prpUndoCancelFeeDto.setFlag(dbManager.getString(resultSet,7));
            collection.add(prpUndoCancelFeeDto);
        }
        resultSet.close();
        log.info("DBPrpUndoCancelFeeBase.findByConditions() success!");
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
        String statement = "Delete From PrpUndoCancelFee Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpUndoCancelFeeBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpUndoCancelFee Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpUndoCancelFeeBase.getCount() success!");
        return count;
    }
}
