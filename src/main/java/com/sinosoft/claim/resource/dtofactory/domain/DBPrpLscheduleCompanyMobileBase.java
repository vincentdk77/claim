package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLscheduleCompanyMobileDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLscheduleCompanyMobile--调度中心电话表的数据访问对象基类<br>
 * 创建于 2005-09-22 17:24:40.828<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLscheduleCompanyMobileBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpLscheduleCompanyMobileBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLscheduleCompanyMobileBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLscheduleCompanyMobileDto prpLscheduleCompanyMobileDto
     * @throws Exception
     */
    public void insert(PrpLscheduleCompanyMobileDto prpLscheduleCompanyMobileDto) throws Exception{
        String mainStatement = " Insert Into PrpLscheduleCompanyMobile (" + 
                           " ComCode," + 
                           " SerialNo," + 
                           " MobileNo," + 
                           " LinkerName," + 
                           " Remark," + 
                           " Flag," + 
                           " OnDutyDay)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLscheduleCompanyMobileDto.getComCode() + "'," + 
                           "" + prpLscheduleCompanyMobileDto.getSerialNo() + "," + 
                           "'" + prpLscheduleCompanyMobileDto.getMobileNo() + "'," + 
                           "'" + prpLscheduleCompanyMobileDto.getLinkerName() + "'," + 
                           "'" + prpLscheduleCompanyMobileDto.getRemark() + "'," + 
                           "'" + prpLscheduleCompanyMobileDto.getFlag() + "'," + 
                           "'" + prpLscheduleCompanyMobileDto.getOnDutyDay() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLscheduleCompanyMobileDto.getComCode());
        dbManager.setInt(2,prpLscheduleCompanyMobileDto.getSerialNo());
        dbManager.setString(3,prpLscheduleCompanyMobileDto.getMobileNo());
        dbManager.setString(4,prpLscheduleCompanyMobileDto.getLinkerName());
        dbManager.setString(5,prpLscheduleCompanyMobileDto.getRemark());
        dbManager.setString(6,prpLscheduleCompanyMobileDto.getFlag());
        dbManager.setString(7,prpLscheduleCompanyMobileDto.getOnDutyDay());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLscheduleCompanyMobileBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpLscheduleCompanyMobileDto prpLscheduleCompanyMobileDto = (PrpLscheduleCompanyMobileDto)i.next();
            insert(prpLscheduleCompanyMobileDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param comCode 调度中心机构代码
     * @throws Exception
     */
    public void delete(String comCode) throws Exception{
        String statement = " Delete From PrpLscheduleCompanyMobile" + 
	            		   " Where " +
                           " ComCode = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLscheduleCompanyMobile Where " +
                           " ComCode = '" + comCode + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,comCode);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLscheduleCompanyMobileBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLscheduleCompanyMobileDto prpLscheduleCompanyMobileDto
     * @throws Exception
     */
    public void update(PrpLscheduleCompanyMobileDto prpLscheduleCompanyMobileDto) throws Exception{
        String statement = " Update PrpLscheduleCompanyMobile Set SerialNo = ?," + 
                           " MobileNo = ?," + 
                           " LinkerName = ?," + 
                           " Remark = ?," + 
                           " Flag = ?," + 
                           " OnDutyDay = ?" + 
	            		   " Where " +
                           " ComCode = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLscheduleCompanyMobile Set " + 
                           " ComCode = '" + prpLscheduleCompanyMobileDto.getComCode() + "'," + 
                           " SerialNo = " + prpLscheduleCompanyMobileDto.getSerialNo() + "," + 
                           " MobileNo = '" + prpLscheduleCompanyMobileDto.getMobileNo() + "'," + 
                           " LinkerName = '" + prpLscheduleCompanyMobileDto.getLinkerName() + "'," + 
                           " Remark = '" + prpLscheduleCompanyMobileDto.getRemark() + "'," + 
                           " Flag = '" + prpLscheduleCompanyMobileDto.getFlag() + "'," + 
                           " OnDutyDay = '" + prpLscheduleCompanyMobileDto.getOnDutyDay() + "'" + 
			               " Where " +
                           " ComCode = '" + prpLscheduleCompanyMobileDto.getComCode() + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setInt(1,prpLscheduleCompanyMobileDto.getSerialNo());
        dbManager.setString(2,prpLscheduleCompanyMobileDto.getMobileNo());
        dbManager.setString(3,prpLscheduleCompanyMobileDto.getLinkerName());
        dbManager.setString(4,prpLscheduleCompanyMobileDto.getRemark());
        dbManager.setString(5,prpLscheduleCompanyMobileDto.getFlag());
        dbManager.setString(6,prpLscheduleCompanyMobileDto.getOnDutyDay());
        //设置条件字段;
        dbManager.setString(7,prpLscheduleCompanyMobileDto.getComCode());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLscheduleCompanyMobileBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param comCode 调度中心机构代码
     * @return PrpLscheduleCompanyMobileDto
     * @throws Exception
     */
    public PrpLscheduleCompanyMobileDto findByPrimaryKey(String comCode) throws Exception{
        String mainStatement = " Select ComCode," + 
                           " SerialNo," + 
                           " MobileNo," + 
                           " LinkerName," + 
                           " Remark," + 
                           " Flag," + 
                           " OnDutyDay From PrpLscheduleCompanyMobile";
        String statement = mainStatement + " Where " +
                           " ComCode = ?";
        PrpLscheduleCompanyMobileDto prpLscheduleCompanyMobileDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " ComCode = '" + comCode + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,comCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLscheduleCompanyMobileDto = new PrpLscheduleCompanyMobileDto();
            prpLscheduleCompanyMobileDto.setComCode(dbManager.getString(resultSet,1));
            prpLscheduleCompanyMobileDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpLscheduleCompanyMobileDto.setMobileNo(dbManager.getString(resultSet,3));
            prpLscheduleCompanyMobileDto.setLinkerName(dbManager.getString(resultSet,4));
            prpLscheduleCompanyMobileDto.setRemark(dbManager.getString(resultSet,5));
            prpLscheduleCompanyMobileDto.setFlag(dbManager.getString(resultSet,6));
            prpLscheduleCompanyMobileDto.setOnDutyDay(dbManager.getString(resultSet,7));
        }
        resultSet.close();
        logger.info("DBPrpLscheduleCompanyMobileBase.findByPrimaryKey() success!");
        return prpLscheduleCompanyMobileDto;
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
        String statement = "Select ComCode," + 
                           " SerialNo," + 
                           " MobileNo," + 
                           " LinkerName," + 
                           " Remark," + 
                           " Flag," + 
                           " OnDutyDay From PrpLscheduleCompanyMobile Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLscheduleCompanyMobileDto prpLscheduleCompanyMobileDto = null;
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

            prpLscheduleCompanyMobileDto = new PrpLscheduleCompanyMobileDto();
            prpLscheduleCompanyMobileDto.setComCode(dbManager.getString(resultSet,1));
            prpLscheduleCompanyMobileDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpLscheduleCompanyMobileDto.setMobileNo(dbManager.getString(resultSet,3));
            prpLscheduleCompanyMobileDto.setLinkerName(dbManager.getString(resultSet,4));
            prpLscheduleCompanyMobileDto.setRemark(dbManager.getString(resultSet,5));
            prpLscheduleCompanyMobileDto.setFlag(dbManager.getString(resultSet,6));
            prpLscheduleCompanyMobileDto.setOnDutyDay(dbManager.getString(resultSet,7));
            collection.add(prpLscheduleCompanyMobileDto);
        }
        resultSet.close();
        logger.info("DBPrpLscheduleCompanyMobileBase.findByConditions() success!");
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
        String statement = "Delete From PrpLscheduleCompanyMobile Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLscheduleCompanyMobileBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLscheduleCompanyMobile Where " + conditions;
           statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLscheduleCompanyMobileBase.getCount() success!");
        return count;
    }
}
