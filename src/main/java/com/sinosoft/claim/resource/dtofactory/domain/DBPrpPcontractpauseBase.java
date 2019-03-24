package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpPcontractpauseDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpPcontractpause中止保险合同信息表的数据访问对象类<br>
 * 创建于 2004-4-5 15:32:11<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpPcontractpauseBase{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpPcontractpauseBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpPcontractpauseBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpPcontractpauseDto prpPcontractpauseDto
     * @throws Exception
     */
    public void insert(PrpPcontractpauseDto prpPcontractpauseDto) throws Exception{
        String statement = " Insert Into PrpPcontractpause(" + 
                           " EndorseNo," + 
                           " PolicyNo," + 
                           " StartDate," + 
                           " StartHour," + 
                           " EndDate," + 
                           " EndHour," + 
                           " InvalidStartDate," + 
                           " InvalidStartHour," + 
                           " InvalidEndDate," + 
                           " InvalidEndHour," + 
                           " flag) values(?,?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpPcontractpauseDto.getEndorseNo());
        dbManager.setString(2,prpPcontractpauseDto.getPolicyNo());
        dbManager.setDateTime(3,prpPcontractpauseDto.getStartDate());
        dbManager.setInt(4,prpPcontractpauseDto.getStartHour());
        dbManager.setDateTime(5,prpPcontractpauseDto.getEndDate());
        dbManager.setInt(6,prpPcontractpauseDto.getEndHour());
        dbManager.setDateTime(7,prpPcontractpauseDto.getInvalidStartDate());
        dbManager.setInt(8,prpPcontractpauseDto.getInvalidStartHour());
        dbManager.setDateTime(9,prpPcontractpauseDto.getInvalidEndDate());
        dbManager.setInt(10,prpPcontractpauseDto.getInvalidEndHour());
        dbManager.setString(11,prpPcontractpauseDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpPcontractpauseBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpPcontractpauseDto prpPcontractpauseDto = (PrpPcontractpauseDto)i.next();
            insert(prpPcontractpauseDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param endorseNo 批单号
     * @throws Exception
     */
    public void delete(String endorseNo) throws Exception{
        String statement = " Delete From PrpPcontractpause Where " +
                           " EndorseNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,endorseNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpPcontractpauseBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpPcontractpauseDto prpPcontractpauseDto
     * @throws Exception
     */
    public void update(PrpPcontractpauseDto prpPcontractpauseDto) throws Exception{
        String statement = " Update PrpPcontractpause Set PolicyNo = ?," + 
                           " StartDate = ?," + 
                           " StartHour = ?," + 
                           " EndDate = ?," + 
                           " EndHour = ?," + 
                           " InvalidStartDate = ?," + 
                           " InvalidStartHour = ?," + 
                           " InvalidEndDate = ?," + 
                           " InvalidEndHour = ?," + 
                           " flag = ? Where " +
                           " EndorseNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpPcontractpauseDto.getPolicyNo());
        dbManager.setDateTime(2,prpPcontractpauseDto.getStartDate());
        dbManager.setInt(3,prpPcontractpauseDto.getStartHour());
        dbManager.setDateTime(4,prpPcontractpauseDto.getEndDate());
        dbManager.setInt(5,prpPcontractpauseDto.getEndHour());
        dbManager.setDateTime(6,prpPcontractpauseDto.getInvalidStartDate());
        dbManager.setInt(7,prpPcontractpauseDto.getInvalidStartHour());
        dbManager.setDateTime(8,prpPcontractpauseDto.getInvalidEndDate());
        dbManager.setInt(9,prpPcontractpauseDto.getInvalidEndHour());
        dbManager.setString(10,prpPcontractpauseDto.getFlag());
        //设置条件字段;
        dbManager.setString(11,prpPcontractpauseDto.getEndorseNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpPcontractpauseBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param endorseNo 批单号
     * @return PrpPcontractpauseDto
     * @throws Exception
     */
    public PrpPcontractpauseDto findByPrimaryKey(String endorseNo) throws Exception{
        String statement = " Select EndorseNo," + 
                           " PolicyNo," + 
                           " StartDate," + 
                           " StartHour," + 
                           " EndDate," + 
                           " EndHour," + 
                           " InvalidStartDate," + 
                           " InvalidStartHour," + 
                           " InvalidEndDate," + 
                           " InvalidEndHour," + 
                           " flag From PrpPcontractpause Where " +
                           " EndorseNo = ?";
        PrpPcontractpauseDto prpPcontractpauseDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,endorseNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpPcontractpauseDto = new PrpPcontractpauseDto();
            prpPcontractpauseDto.setEndorseNo(dbManager.getString(resultSet,1));
            prpPcontractpauseDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpPcontractpauseDto.setStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,3));
            prpPcontractpauseDto.setStartHour(dbManager.getInt(resultSet,4));
            prpPcontractpauseDto.setEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,5));
            prpPcontractpauseDto.setEndHour(dbManager.getInt(resultSet,6));
            prpPcontractpauseDto.setInvalidStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,7));
            prpPcontractpauseDto.setInvalidStartHour(dbManager.getInt(resultSet,8));
            prpPcontractpauseDto.setInvalidEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,9));
            prpPcontractpauseDto.setInvalidEndHour(dbManager.getInt(resultSet,10));
            prpPcontractpauseDto.setFlag(dbManager.getString(resultSet,11));
        }
        resultSet.close();
        log.info("DBPrpPcontractpauseBase.findByPrimaryKey() success!");
        return prpPcontractpauseDto;
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
        String statement = "Select EndorseNo," + 
                           " PolicyNo," + 
                           " StartDate," + 
                           " StartHour," + 
                           " EndDate," + 
                           " EndHour," + 
                           " InvalidStartDate," + 
                           " InvalidStartHour," + 
                           " InvalidEndDate," + 
                           " InvalidEndHour," + 
                           " flag From PrpPcontractpause Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpPcontractpauseDto prpPcontractpauseDto = null;
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

            prpPcontractpauseDto = new PrpPcontractpauseDto();
            prpPcontractpauseDto.setEndorseNo(dbManager.getString(resultSet,1));
            prpPcontractpauseDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpPcontractpauseDto.setStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,3));
            prpPcontractpauseDto.setStartHour(dbManager.getInt(resultSet,4));
            prpPcontractpauseDto.setEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,5));
            prpPcontractpauseDto.setEndHour(dbManager.getInt(resultSet,6));
            prpPcontractpauseDto.setInvalidStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,7));
            prpPcontractpauseDto.setInvalidStartHour(dbManager.getInt(resultSet,8));
            prpPcontractpauseDto.setInvalidEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,9));
            prpPcontractpauseDto.setInvalidEndHour(dbManager.getInt(resultSet,10));
            prpPcontractpauseDto.setFlag(dbManager.getString(resultSet,11));
            collection.add(prpPcontractpauseDto);
        }
        resultSet.close();
        log.info("DBPrpPcontractpauseBase.findByConditions() success!");
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
        String statement = "Delete From PrpPcontractpause Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpPcontractpauseBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpPcontractpause Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpPcontractpauseBase.getCount() success!");
        return count;
    }
}
