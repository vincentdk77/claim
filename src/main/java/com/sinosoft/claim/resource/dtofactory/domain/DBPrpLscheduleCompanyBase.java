package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLscheduleCompanyDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLscheduleCompany--调度中心提示信息设置表的数据访问对象基类<br>
 * 创建于 2005-11-07 11:10:41.578<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLscheduleCompanyBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpLscheduleCompanyBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLscheduleCompanyBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLscheduleCompanyDto prpLscheduleCompanyDto
     * @throws Exception
     */
    public void insert(PrpLscheduleCompanyDto prpLscheduleCompanyDto) throws Exception{
        String mainStatement = " Insert Into PrpLscheduleCompany (" + 
                           " ComCode," + 
                           " OnDutyTime," + 
                           " OffDutyTime," + 
                           " PromptContent," + 
                           " PhoneNo," + 
                           " LinkerName," + 
                           " MobileNo," + 
                           " ValidStatus," + 
                           " Remark," + 
                           " Flag," + 
                           " amNo)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLscheduleCompanyDto.getComCode() + "'," + 
                           "'" + prpLscheduleCompanyDto.getOnDutyTime() + "'," + 
                           "'" + prpLscheduleCompanyDto.getOffDutyTime() + "'," + 
                           "'" + prpLscheduleCompanyDto.getPromptContent() + "'," + 
                           "'" + prpLscheduleCompanyDto.getPhoneNo() + "'," + 
                           "'" + prpLscheduleCompanyDto.getLinkerName() + "'," + 
                           "'" + prpLscheduleCompanyDto.getMobileNo() + "'," + 
                           "'" + prpLscheduleCompanyDto.getValidStatus() + "'," + 
                           "'" + prpLscheduleCompanyDto.getRemark() + "'," + 
                           "'" + prpLscheduleCompanyDto.getFlag() + "'," + 
                           "'" + prpLscheduleCompanyDto.getAmNo() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLscheduleCompanyDto.getComCode());
        dbManager.setString(2,prpLscheduleCompanyDto.getOnDutyTime());
        dbManager.setString(3,prpLscheduleCompanyDto.getOffDutyTime());
        dbManager.setString(4,prpLscheduleCompanyDto.getPromptContent());
        dbManager.setString(5,prpLscheduleCompanyDto.getPhoneNo());
        dbManager.setString(6,prpLscheduleCompanyDto.getLinkerName());
        dbManager.setString(7,prpLscheduleCompanyDto.getMobileNo());
        dbManager.setString(8,prpLscheduleCompanyDto.getValidStatus());
        dbManager.setString(9,prpLscheduleCompanyDto.getRemark());
        dbManager.setString(10,prpLscheduleCompanyDto.getFlag());
        dbManager.setString(11,prpLscheduleCompanyDto.getAmNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLscheduleCompanyBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpLscheduleCompanyDto prpLscheduleCompanyDto = (PrpLscheduleCompanyDto)i.next();
            insert(prpLscheduleCompanyDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param comCode 调度中心机构代码
     * @throws Exception
     */
    public void delete(String comCode) throws Exception{
        String statement = " Delete From PrpLscheduleCompany" + 
	            		   " Where " +
                           " ComCode = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLscheduleCompany Where " +
                           " ComCode = '" + comCode + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,comCode);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLscheduleCompanyBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLscheduleCompanyDto prpLscheduleCompanyDto
     * @throws Exception
     */
    public void update(PrpLscheduleCompanyDto prpLscheduleCompanyDto) throws Exception{
        String statement = " Update PrpLscheduleCompany Set OnDutyTime = ?," + 
                           " OffDutyTime = ?," + 
                           " PromptContent = ?," + 
                           " PhoneNo = ?," + 
                           " LinkerName = ?," + 
                           " MobileNo = ?," + 
                           " ValidStatus = ?," + 
                           " Remark = ?," + 
                           " Flag = ?," + 
                           " amNo = ?" + 
	            		   " Where " +
                           " ComCode = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLscheduleCompany Set " + 
                           " ComCode = '" + prpLscheduleCompanyDto.getComCode() + "'," + 
                           " OnDutyTime = '" + prpLscheduleCompanyDto.getOnDutyTime() + "'," + 
                           " OffDutyTime = '" + prpLscheduleCompanyDto.getOffDutyTime() + "'," + 
                           " PromptContent = '" + prpLscheduleCompanyDto.getPromptContent() + "'," + 
                           " PhoneNo = '" + prpLscheduleCompanyDto.getPhoneNo() + "'," + 
                           " LinkerName = '" + prpLscheduleCompanyDto.getLinkerName() + "'," + 
                           " MobileNo = '" + prpLscheduleCompanyDto.getMobileNo() + "'," + 
                           " ValidStatus = '" + prpLscheduleCompanyDto.getValidStatus() + "'," + 
                           " Remark = '" + prpLscheduleCompanyDto.getRemark() + "'," + 
                           " Flag = '" + prpLscheduleCompanyDto.getFlag() + "'," + 
                           " amNo = '" + prpLscheduleCompanyDto.getAmNo() + "'" + 
			               " Where " +
                           " ComCode = '" + prpLscheduleCompanyDto.getComCode() + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpLscheduleCompanyDto.getOnDutyTime());
        dbManager.setString(2,prpLscheduleCompanyDto.getOffDutyTime());
        dbManager.setString(3,prpLscheduleCompanyDto.getPromptContent());
        dbManager.setString(4,prpLscheduleCompanyDto.getPhoneNo());
        dbManager.setString(5,prpLscheduleCompanyDto.getLinkerName());
        dbManager.setString(6,prpLscheduleCompanyDto.getMobileNo());
        dbManager.setString(7,prpLscheduleCompanyDto.getValidStatus());
        dbManager.setString(8,prpLscheduleCompanyDto.getRemark());
        dbManager.setString(9,prpLscheduleCompanyDto.getFlag());
        dbManager.setString(10,prpLscheduleCompanyDto.getAmNo());
        //设置条件字段;
        dbManager.setString(11,prpLscheduleCompanyDto.getComCode());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLscheduleCompanyBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param comCode 调度中心机构代码
     * @return PrpLscheduleCompanyDto
     * @throws Exception
     */
    public PrpLscheduleCompanyDto findByPrimaryKey(String comCode) throws Exception{
        String mainStatement = " Select ComCode," + 
                           " OnDutyTime," + 
                           " OffDutyTime," + 
                           " PromptContent," + 
                           " PhoneNo," + 
                           " LinkerName," + 
                           " MobileNo," + 
                           " ValidStatus," + 
                           " Remark," + 
                           " Flag," + 
                           " amNo From PrpLscheduleCompany";
        String statement = mainStatement + " Where " +
                           " ComCode = ?";
        PrpLscheduleCompanyDto prpLscheduleCompanyDto = null;
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
            prpLscheduleCompanyDto = new PrpLscheduleCompanyDto();
            prpLscheduleCompanyDto.setComCode(dbManager.getString(resultSet,1));
            prpLscheduleCompanyDto.setOnDutyTime(dbManager.getString(resultSet,2));
            prpLscheduleCompanyDto.setOffDutyTime(dbManager.getString(resultSet,3));
            prpLscheduleCompanyDto.setPromptContent(dbManager.getString(resultSet,4));
            prpLscheduleCompanyDto.setPhoneNo(dbManager.getString(resultSet,5));
            prpLscheduleCompanyDto.setLinkerName(dbManager.getString(resultSet,6));
            prpLscheduleCompanyDto.setMobileNo(dbManager.getString(resultSet,7));
            prpLscheduleCompanyDto.setValidStatus(dbManager.getString(resultSet,8));
            prpLscheduleCompanyDto.setRemark(dbManager.getString(resultSet,9));
            prpLscheduleCompanyDto.setFlag(dbManager.getString(resultSet,10));
            prpLscheduleCompanyDto.setAmNo(dbManager.getString(resultSet,11));
        }
        resultSet.close();
        logger.info("DBPrpLscheduleCompanyBase.findByPrimaryKey() success!");
        return prpLscheduleCompanyDto;
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
                           " OnDutyTime," + 
                           " OffDutyTime," + 
                           " PromptContent," + 
                           " PhoneNo," + 
                           " LinkerName," + 
                           " MobileNo," + 
                           " ValidStatus," + 
                           " Remark," + 
                           " Flag," + 
                           " amNo From PrpLscheduleCompany Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLscheduleCompanyDto prpLscheduleCompanyDto = null;
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

            prpLscheduleCompanyDto = new PrpLscheduleCompanyDto();
            prpLscheduleCompanyDto.setComCode(dbManager.getString(resultSet,1));
            prpLscheduleCompanyDto.setOnDutyTime(dbManager.getString(resultSet,2));
            prpLscheduleCompanyDto.setOffDutyTime(dbManager.getString(resultSet,3));
            prpLscheduleCompanyDto.setPromptContent(dbManager.getString(resultSet,4));
            prpLscheduleCompanyDto.setPhoneNo(dbManager.getString(resultSet,5));
            prpLscheduleCompanyDto.setLinkerName(dbManager.getString(resultSet,6));
            prpLscheduleCompanyDto.setMobileNo(dbManager.getString(resultSet,7));
            prpLscheduleCompanyDto.setValidStatus(dbManager.getString(resultSet,8));
            prpLscheduleCompanyDto.setRemark(dbManager.getString(resultSet,9));
            prpLscheduleCompanyDto.setFlag(dbManager.getString(resultSet,10));
            prpLscheduleCompanyDto.setAmNo(dbManager.getString(resultSet,11));
            collection.add(prpLscheduleCompanyDto);
        }
        resultSet.close();
        logger.info("DBPrpLscheduleCompanyBase.findByConditions() success!");
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
        String statement = "Delete From PrpLscheduleCompany Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLscheduleCompanyBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLscheduleCompany Where " + conditions;
           statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLscheduleCompanyBase.getCount() success!");
        return count;
    }
}
