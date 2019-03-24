package com.sinosoft.function.insutil.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDpersonPayDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdpersonpay的数据访问对象类<br>
 * 创建于 2004-4-6 16:07:47<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDpersonPayBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpDpersonPayBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpDpersonPayBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpDpersonPayDto prpDpersonPayDto
     * @throws Exception
     */
    public void insert(PrpDpersonPayDto prpDpersonPayDto) throws Exception{
        String statement = " Insert Into PrpDpersonPay(" + 
                           " SerialNo," + 
                           " PayItemCode," + 
                           " DamageAreaCode," + 
                           " BusinessSource," + 
                           " StandardFee," + 
                           " IssueDate," + 
                           " Flag) values(?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setInt(1,prpDpersonPayDto.getSerialNo());
        dbManager.setString(2,prpDpersonPayDto.getPayItemCode());
        dbManager.setString(3,prpDpersonPayDto.getDamageAreaCode());
        dbManager.setString(4,prpDpersonPayDto.getBusinessSource());
        dbManager.setDouble(5,prpDpersonPayDto.getStandardFee());
        dbManager.setDateTime(6,prpDpersonPayDto.getIssueDate());
        dbManager.setString(7,prpDpersonPayDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDpersonPayBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpDpersonPayDto prpDpersonPayDto = (PrpDpersonPayDto)i.next();
            insert(prpDpersonPayDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param serialNo serialno
     * @throws Exception
     */
    public void delete(int serialNo) throws Exception{
        String statement = " Delete From PrpDpersonPay Where " +
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setInt(1,serialNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpDpersonPayBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpDpersonPayDto prpDpersonPayDto
     * @throws Exception
     */
    public void update(PrpDpersonPayDto prpDpersonPayDto) throws Exception{
        String statement = " Update PrpDpersonPay Set PayItemCode = ?," + 
                           " DamageAreaCode = ?," + 
                           " BusinessSource = ?," + 
                           " StandardFee = ?," + 
                           " IssueDate = ?," + 
                           " Flag = ? Where " +
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpDpersonPayDto.getPayItemCode());
        dbManager.setString(2,prpDpersonPayDto.getDamageAreaCode());
        dbManager.setString(3,prpDpersonPayDto.getBusinessSource());
        dbManager.setDouble(4,prpDpersonPayDto.getStandardFee());
        dbManager.setDateTime(5,prpDpersonPayDto.getIssueDate());
        dbManager.setString(6,prpDpersonPayDto.getFlag());
        //设置条件字段;
        dbManager.setInt(7,prpDpersonPayDto.getSerialNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDpersonPayBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param serialNo serialno
     * @return PrpDpersonPayDto
     * @throws Exception
     */
    public PrpDpersonPayDto findByPrimaryKey(int serialNo) throws Exception{
        String statement = " Select SerialNo," + 
                           " PayItemCode," + 
                           " DamageAreaCode," + 
                           " BusinessSource," + 
                           " StandardFee," + 
                           " IssueDate," + 
                           " Flag From PrpDpersonPay Where " +
                           " SerialNo = ?";
        PrpDpersonPayDto prpDpersonPayDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setInt(1,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpDpersonPayDto = new PrpDpersonPayDto();
            prpDpersonPayDto.setSerialNo(dbManager.getInt(resultSet,1));
            prpDpersonPayDto.setPayItemCode(dbManager.getString(resultSet,2));
            prpDpersonPayDto.setDamageAreaCode(dbManager.getString(resultSet,3));
            prpDpersonPayDto.setBusinessSource(dbManager.getString(resultSet,4));
            prpDpersonPayDto.setStandardFee(dbManager.getDouble(resultSet,5));
            prpDpersonPayDto.setIssueDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,6));
            prpDpersonPayDto.setFlag(dbManager.getString(resultSet,7));
        }
        resultSet.close();
        log.info("DBPrpDpersonPayBase.findByPrimaryKey() success!");
        return prpDpersonPayDto;
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
        String statement = "Select SerialNo," + 
                           " PayItemCode," + 
                           " DamageAreaCode," + 
                           " BusinessSource," + 
                           " StandardFee," + 
                           " IssueDate," + 
                           " Flag From PrpDpersonPay Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpDpersonPayDto prpDpersonPayDto = null;
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

            prpDpersonPayDto = new PrpDpersonPayDto();
            prpDpersonPayDto.setSerialNo(dbManager.getInt(resultSet,1));
            prpDpersonPayDto.setPayItemCode(dbManager.getString(resultSet,2));
            prpDpersonPayDto.setDamageAreaCode(dbManager.getString(resultSet,3));
            prpDpersonPayDto.setBusinessSource(dbManager.getString(resultSet,4));
            prpDpersonPayDto.setStandardFee(dbManager.getDouble(resultSet,5));
            prpDpersonPayDto.setIssueDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,6));
            prpDpersonPayDto.setFlag(dbManager.getString(resultSet,7));
            collection.add(prpDpersonPayDto);
        }
        resultSet.close();
        log.info("DBPrpDpersonPayBase.findByConditions() success!");
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
        String statement = "Delete From PrpDpersonPay Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpDpersonPayBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpDpersonPay Where " + conditions;
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpDpersonPayBase.getCount() success!");
        return count;
    }
}
