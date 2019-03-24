package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLdealinfoDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpldealinfo的数据访问对象类<br>
 * 创建于 2004-4-5 15:32:11<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLdealinfoBase{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpLdealinfoBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLdealinfoBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLdealinfoDto prpLdealinfoDto
     * @throws Exception
     */
    public void insert(PrpLdealinfoDto prpLdealinfoDto) throws Exception{
        String statement = " Insert Into PrpLdealinfo(" + 
                           " RegistNo," + 
                           " ReportName," + 
                           " SerialNo," + 
                           " ItemName," + 
                           " ComCode," + 
                           " DealDate," + 
                           " DealHour," + 
                           " ReportDate," + 
                           " InsurePhoneNumber," + 
                           " AcceptName," + 
                           " SeatNo," + 
                           " DefLossName," + 
                           " CheckPhoneNumber," + 
                           " CheckStartDate," + 
                           " CheckStartHour," + 
                           " DealStatus," + 
                           " Flag) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLdealinfoDto.getRegistNo());
        dbManager.setString(2,prpLdealinfoDto.getReportName());
        dbManager.setInt(3,prpLdealinfoDto.getSerialNo());
        dbManager.setString(4,prpLdealinfoDto.getItemName());
        dbManager.setString(5,prpLdealinfoDto.getComCode());
        dbManager.setDateTime(6,prpLdealinfoDto.getDealDate());
        dbManager.setInt(7,prpLdealinfoDto.getDealHour());
        dbManager.setDateTime(8,prpLdealinfoDto.getReportDate());
        dbManager.setString(9,prpLdealinfoDto.getInsurePhoneNumber());
        dbManager.setString(10,prpLdealinfoDto.getAcceptName());
        dbManager.setString(11,prpLdealinfoDto.getSeatNo());
        dbManager.setString(12,prpLdealinfoDto.getDefLossName());
        dbManager.setString(13,prpLdealinfoDto.getCheckPhoneNumber());
        dbManager.setDateTime(14,prpLdealinfoDto.getCheckStartDate());
        dbManager.setInt(15,prpLdealinfoDto.getCheckStartHour());
        dbManager.setString(16,prpLdealinfoDto.getDealStatus());
        dbManager.setString(17,prpLdealinfoDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpLdealinfoBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpLdealinfoDto prpLdealinfoDto = (PrpLdealinfoDto)i.next();
            insert(prpLdealinfoDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param registNo 报案号
     * @throws Exception
     */
    public void delete(String registNo) throws Exception{
        String statement = " Delete From PrpLdealinfo Where " +
                           " RegistNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,registNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpLdealinfoBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLdealinfoDto prpLdealinfoDto
     * @throws Exception
     */
    public void update(PrpLdealinfoDto prpLdealinfoDto) throws Exception{
        String statement = " Update PrpLdealinfo Set ReportName = ?," + 
                           " SerialNo = ?," + 
                           " ItemName = ?," + 
                           " ComCode = ?," + 
                           " DealDate = ?," + 
                           " DealHour = ?," + 
                           " ReportDate = ?," + 
                           " InsurePhoneNumber = ?," + 
                           " AcceptName = ?," + 
                           " SeatNo = ?," + 
                           " DefLossName = ?," + 
                           " CheckPhoneNumber = ?," + 
                           " CheckStartDate = ?," + 
                           " CheckStartHour = ?," + 
                           " DealStatus = ?," + 
                           " Flag = ? Where " +
                           " RegistNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpLdealinfoDto.getReportName());
        dbManager.setInt(2,prpLdealinfoDto.getSerialNo());
        dbManager.setString(3,prpLdealinfoDto.getItemName());
        dbManager.setString(4,prpLdealinfoDto.getComCode());
        dbManager.setDateTime(5,prpLdealinfoDto.getDealDate());
        dbManager.setInt(6,prpLdealinfoDto.getDealHour());
        dbManager.setDateTime(7,prpLdealinfoDto.getReportDate());
        dbManager.setString(8,prpLdealinfoDto.getInsurePhoneNumber());
        dbManager.setString(9,prpLdealinfoDto.getAcceptName());
        dbManager.setString(10,prpLdealinfoDto.getSeatNo());
        dbManager.setString(11,prpLdealinfoDto.getDefLossName());
        dbManager.setString(12,prpLdealinfoDto.getCheckPhoneNumber());
        dbManager.setDateTime(13,prpLdealinfoDto.getCheckStartDate());
        dbManager.setInt(14,prpLdealinfoDto.getCheckStartHour());
        dbManager.setString(15,prpLdealinfoDto.getDealStatus());
        dbManager.setString(16,prpLdealinfoDto.getFlag());
        //设置条件字段;
        dbManager.setString(17,prpLdealinfoDto.getRegistNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpLdealinfoBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param registNo 报案号
     * @return PrpLdealinfoDto
     * @throws Exception
     */
    public PrpLdealinfoDto findByPrimaryKey(String registNo) throws Exception{
        String statement = " Select RegistNo," + 
                           " ReportName," + 
                           " SerialNo," + 
                           " ItemName," + 
                           " ComCode," + 
                           " DealDate," + 
                           " DealHour," + 
                           " ReportDate," + 
                           " InsurePhoneNumber," + 
                           " AcceptName," + 
                           " SeatNo," + 
                           " DefLossName," + 
                           " CheckPhoneNumber," + 
                           " CheckStartDate," + 
                           " CheckStartHour," + 
                           " DealStatus," + 
                           " Flag From PrpLdealinfo Where " +
                           " RegistNo = ?";
        PrpLdealinfoDto prpLdealinfoDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,registNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLdealinfoDto = new PrpLdealinfoDto();
            prpLdealinfoDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLdealinfoDto.setReportName(dbManager.getString(resultSet,2));
            prpLdealinfoDto.setSerialNo(dbManager.getInt(resultSet,3));
            prpLdealinfoDto.setItemName(dbManager.getString(resultSet,4));
            prpLdealinfoDto.setComCode(dbManager.getString(resultSet,5));
            prpLdealinfoDto.setDealDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,6));
            prpLdealinfoDto.setDealHour(dbManager.getInt(resultSet,7));
            prpLdealinfoDto.setReportDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,8));
            prpLdealinfoDto.setInsurePhoneNumber(dbManager.getString(resultSet,9));
            prpLdealinfoDto.setAcceptName(dbManager.getString(resultSet,10));
            prpLdealinfoDto.setSeatNo(dbManager.getString(resultSet,11));
            prpLdealinfoDto.setDefLossName(dbManager.getString(resultSet,12));
            prpLdealinfoDto.setCheckPhoneNumber(dbManager.getString(resultSet,13));
            prpLdealinfoDto.setCheckStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,14));
            prpLdealinfoDto.setCheckStartHour(dbManager.getInt(resultSet,15));
            prpLdealinfoDto.setDealStatus(dbManager.getString(resultSet,16));
            prpLdealinfoDto.setFlag(dbManager.getString(resultSet,17));
        }
        resultSet.close();
        log.info("DBPrpLdealinfoBase.findByPrimaryKey() success!");
        return prpLdealinfoDto;
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
        String statement = "Select RegistNo," + 
                           " ReportName," + 
                           " SerialNo," + 
                           " ItemName," + 
                           " ComCode," + 
                           " DealDate," + 
                           " DealHour," + 
                           " ReportDate," + 
                           " InsurePhoneNumber," + 
                           " AcceptName," + 
                           " SeatNo," + 
                           " DefLossName," + 
                           " CheckPhoneNumber," + 
                           " CheckStartDate," + 
                           " CheckStartHour," + 
                           " DealStatus," + 
                           " Flag From PrpLdealinfo Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpLdealinfoDto prpLdealinfoDto = null;
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

            prpLdealinfoDto = new PrpLdealinfoDto();
            prpLdealinfoDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLdealinfoDto.setReportName(dbManager.getString(resultSet,2));
            prpLdealinfoDto.setSerialNo(dbManager.getInt(resultSet,3));
            prpLdealinfoDto.setItemName(dbManager.getString(resultSet,4));
            prpLdealinfoDto.setComCode(dbManager.getString(resultSet,5));
            prpLdealinfoDto.setDealDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,6));
            prpLdealinfoDto.setDealHour(dbManager.getInt(resultSet,7));
            prpLdealinfoDto.setReportDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,8));
            prpLdealinfoDto.setInsurePhoneNumber(dbManager.getString(resultSet,9));
            prpLdealinfoDto.setAcceptName(dbManager.getString(resultSet,10));
            prpLdealinfoDto.setSeatNo(dbManager.getString(resultSet,11));
            prpLdealinfoDto.setDefLossName(dbManager.getString(resultSet,12));
            prpLdealinfoDto.setCheckPhoneNumber(dbManager.getString(resultSet,13));
            prpLdealinfoDto.setCheckStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,14));
            prpLdealinfoDto.setCheckStartHour(dbManager.getInt(resultSet,15));
            prpLdealinfoDto.setDealStatus(dbManager.getString(resultSet,16));
            prpLdealinfoDto.setFlag(dbManager.getString(resultSet,17));
            collection.add(prpLdealinfoDto);
        }
        resultSet.close();
        log.info("DBPrpLdealinfoBase.findByConditions() success!");
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
        String statement = "Delete From PrpLdealinfo Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpLdealinfoBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLdealinfo Where " + conditions;
        statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpLdealinfoBase.getCount() success!");
        return count;
    }
}
