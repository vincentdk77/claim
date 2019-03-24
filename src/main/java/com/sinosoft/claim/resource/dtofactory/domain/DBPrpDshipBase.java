package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDshipDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdship船舶代码的数据访问对象类<br>
 * 创建于 2004-4-5 15:33:42<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDshipBase{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpDshipBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpDshipBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpDshipDto prpDshipDto
     * @throws Exception
     */
    public void insert(PrpDshipDto prpDshipDto) throws Exception{
        String statement = " Insert Into PrpDship(" + 
                           " ShipCode," + 
                           " ShipCName," + 
                           " ShipEName," + 
                           " OldShipName," + 
                           " ShipOwner," + 
                           " OldShipOwner," + 
                           " Associate," + 
                           " MakeYearMonth," + 
                           " CountryCode," + 
                           " MakeFactory," + 
                           " MakeDock," + 
                           " StepHull," + 
                           " OldStepHull," + 
                           " ShipFlag," + 
                           " ShipType," + 
                           " UseNature," + 
                           " ShipUsage," + 
                           " ShipStruct," + 
                           " RegistrySite," + 
                           " TonCount," + 
                           " NetTonCount," + 
                           " HorsePower," + 
                           " PowerUnit," + 
                           " SeatCount," + 
                           " LoadTon," + 
                           " ShipLength," + 
                           " ShipWidth," + 
                           " ShipDepth," + 
                           " ShipValue," + 
                           " CertificateOwner," + 
                           " ActualOwner," + 
                           " ProprietorName," + 
                           " ManageType," + 
                           " ManageStartDate," + 
                           " ManageEndDate," + 
                           " CheckStartDate," + 
                           " CheckEndDate," + 
                           " DebtAmount," + 
                           " Pledge," + 
                           " RebuildCompany," + 
                           " RebuildDate," + 
                           " NewShipCode," + 
                           " ValidStatus," + 
                           " Flag) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpDshipDto.getShipCode());
        dbManager.setString(2,prpDshipDto.getShipCName());
        dbManager.setString(3,prpDshipDto.getShipEName());
        dbManager.setString(4,prpDshipDto.getOldShipName());
        dbManager.setString(5,prpDshipDto.getShipOwner());
        dbManager.setString(6,prpDshipDto.getOldShipOwner());
        dbManager.setString(7,prpDshipDto.getAssociate());
        dbManager.setDateTime(8,prpDshipDto.getMakeYearMonth());
        dbManager.setString(9,prpDshipDto.getCountryCode());
        dbManager.setString(10,prpDshipDto.getMakeFactory());
        dbManager.setString(11,prpDshipDto.getMakeDock());
        dbManager.setString(12,prpDshipDto.getStepHull());
        dbManager.setString(13,prpDshipDto.getOldStepHull());
        dbManager.setString(14,prpDshipDto.getShipFlag());
        dbManager.setString(15,prpDshipDto.getShipType());
        dbManager.setString(16,prpDshipDto.getUseNature());
        dbManager.setString(17,prpDshipDto.getShipUsage());
        dbManager.setString(18,prpDshipDto.getShipStruct());
        dbManager.setString(19,prpDshipDto.getRegistrySite());
        dbManager.setDouble(20,prpDshipDto.getTonCount());
        dbManager.setDouble(21,prpDshipDto.getNetTonCount());
        dbManager.setDouble(22,prpDshipDto.getHorsePower());
        dbManager.setString(23,prpDshipDto.getPowerUnit());
        dbManager.setInt(24,prpDshipDto.getSeatCount());
        dbManager.setDouble(25,prpDshipDto.getLoadTon());
        dbManager.setDouble(26,prpDshipDto.getShipLength());
        dbManager.setDouble(27,prpDshipDto.getShipWidth());
        dbManager.setDouble(28,prpDshipDto.getShipDepth());
        dbManager.setDouble(29,prpDshipDto.getShipValue());
        dbManager.setString(30,prpDshipDto.getCertificateOwner());
        dbManager.setString(31,prpDshipDto.getActualOwner());
        dbManager.setString(32,prpDshipDto.getProprietorName());
        dbManager.setString(33,prpDshipDto.getManageType());
        dbManager.setDateTime(34,prpDshipDto.getManageStartDate());
        dbManager.setDateTime(35,prpDshipDto.getManageEndDate());
        dbManager.setDateTime(36,prpDshipDto.getCheckStartDate());
        dbManager.setDateTime(37,prpDshipDto.getCheckEndDate());
        dbManager.setInt(38,prpDshipDto.getDebtAmount());
        dbManager.setString(39,prpDshipDto.getPledge());
        dbManager.setString(40,prpDshipDto.getRebuildCompany());
        dbManager.setDateTime(41,prpDshipDto.getRebuildDate());
        dbManager.setString(42,prpDshipDto.getNewShipCode());
        dbManager.setString(43,prpDshipDto.getValidStatus());
        dbManager.setString(44,prpDshipDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDshipBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpDshipDto prpDshipDto = (PrpDshipDto)i.next();
            insert(prpDshipDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param shipCode 船舶代码
     * @throws Exception
     */
    public void delete(String shipCode) throws Exception{
        String statement = " Delete From PrpDship Where " +
                           " ShipCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,shipCode);
        dbManager.executePreparedUpdate();
        log.info("DBPrpDshipBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpDshipDto prpDshipDto
     * @throws Exception
     */
    public void update(PrpDshipDto prpDshipDto) throws Exception{
        String statement = " Update PrpDship Set ShipCName = ?," + 
                           " ShipEName = ?," + 
                           " OldShipName = ?," + 
                           " ShipOwner = ?," + 
                           " OldShipOwner = ?," + 
                           " Associate = ?," + 
                           " MakeYearMonth = ?," + 
                           " CountryCode = ?," + 
                           " MakeFactory = ?," + 
                           " MakeDock = ?," + 
                           " StepHull = ?," + 
                           " OldStepHull = ?," + 
                           " ShipFlag = ?," + 
                           " ShipType = ?," + 
                           " UseNature = ?," + 
                           " ShipUsage = ?," + 
                           " ShipStruct = ?," + 
                           " RegistrySite = ?," + 
                           " TonCount = ?," + 
                           " NetTonCount = ?," + 
                           " HorsePower = ?," + 
                           " PowerUnit = ?," + 
                           " SeatCount = ?," + 
                           " LoadTon = ?," + 
                           " ShipLength = ?," + 
                           " ShipWidth = ?," + 
                           " ShipDepth = ?," + 
                           " ShipValue = ?," + 
                           " CertificateOwner = ?," + 
                           " ActualOwner = ?," + 
                           " ProprietorName = ?," + 
                           " ManageType = ?," + 
                           " ManageStartDate = ?," + 
                           " ManageEndDate = ?," + 
                           " CheckStartDate = ?," + 
                           " CheckEndDate = ?," + 
                           " DebtAmount = ?," + 
                           " Pledge = ?," + 
                           " RebuildCompany = ?," + 
                           " RebuildDate = ?," + 
                           " NewShipCode = ?," + 
                           " ValidStatus = ?," + 
                           " Flag = ? Where " +
                           " ShipCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpDshipDto.getShipCName());
        dbManager.setString(2,prpDshipDto.getShipEName());
        dbManager.setString(3,prpDshipDto.getOldShipName());
        dbManager.setString(4,prpDshipDto.getShipOwner());
        dbManager.setString(5,prpDshipDto.getOldShipOwner());
        dbManager.setString(6,prpDshipDto.getAssociate());
        dbManager.setDateTime(7,prpDshipDto.getMakeYearMonth());
        dbManager.setString(8,prpDshipDto.getCountryCode());
        dbManager.setString(9,prpDshipDto.getMakeFactory());
        dbManager.setString(10,prpDshipDto.getMakeDock());
        dbManager.setString(11,prpDshipDto.getStepHull());
        dbManager.setString(12,prpDshipDto.getOldStepHull());
        dbManager.setString(13,prpDshipDto.getShipFlag());
        dbManager.setString(14,prpDshipDto.getShipType());
        dbManager.setString(15,prpDshipDto.getUseNature());
        dbManager.setString(16,prpDshipDto.getShipUsage());
        dbManager.setString(17,prpDshipDto.getShipStruct());
        dbManager.setString(18,prpDshipDto.getRegistrySite());
        dbManager.setDouble(19,prpDshipDto.getTonCount());
        dbManager.setDouble(20,prpDshipDto.getNetTonCount());
        dbManager.setDouble(21,prpDshipDto.getHorsePower());
        dbManager.setString(22,prpDshipDto.getPowerUnit());
        dbManager.setInt(23,prpDshipDto.getSeatCount());
        dbManager.setDouble(24,prpDshipDto.getLoadTon());
        dbManager.setDouble(25,prpDshipDto.getShipLength());
        dbManager.setDouble(26,prpDshipDto.getShipWidth());
        dbManager.setDouble(27,prpDshipDto.getShipDepth());
        dbManager.setDouble(28,prpDshipDto.getShipValue());
        dbManager.setString(29,prpDshipDto.getCertificateOwner());
        dbManager.setString(30,prpDshipDto.getActualOwner());
        dbManager.setString(31,prpDshipDto.getProprietorName());
        dbManager.setString(32,prpDshipDto.getManageType());
        dbManager.setDateTime(33,prpDshipDto.getManageStartDate());
        dbManager.setDateTime(34,prpDshipDto.getManageEndDate());
        dbManager.setDateTime(35,prpDshipDto.getCheckStartDate());
        dbManager.setDateTime(36,prpDshipDto.getCheckEndDate());
        dbManager.setInt(37,prpDshipDto.getDebtAmount());
        dbManager.setString(38,prpDshipDto.getPledge());
        dbManager.setString(39,prpDshipDto.getRebuildCompany());
        dbManager.setDateTime(40,prpDshipDto.getRebuildDate());
        dbManager.setString(41,prpDshipDto.getNewShipCode());
        dbManager.setString(42,prpDshipDto.getValidStatus());
        dbManager.setString(43,prpDshipDto.getFlag());
        //设置条件字段;
        dbManager.setString(44,prpDshipDto.getShipCode());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDshipBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param shipCode 船舶代码
     * @return PrpDshipDto
     * @throws Exception
     */
    public PrpDshipDto findByPrimaryKey(String shipCode) throws Exception{
        String statement = " Select ShipCode," + 
                           " ShipCName," + 
                           " ShipEName," + 
                           " OldShipName," + 
                           " ShipOwner," + 
                           " OldShipOwner," + 
                           " Associate," + 
                           " MakeYearMonth," + 
                           " CountryCode," + 
                           " MakeFactory," + 
                           " MakeDock," + 
                           " StepHull," + 
                           " OldStepHull," + 
                           " ShipFlag," + 
                           " ShipType," + 
                           " UseNature," + 
                           " ShipUsage," + 
                           " ShipStruct," + 
                           " RegistrySite," + 
                           " TonCount," + 
                           " NetTonCount," + 
                           " HorsePower," + 
                           " PowerUnit," + 
                           " SeatCount," + 
                           " LoadTon," + 
                           " ShipLength," + 
                           " ShipWidth," + 
                           " ShipDepth," + 
                           " ShipValue," + 
                           " CertificateOwner," + 
                           " ActualOwner," + 
                           " ProprietorName," + 
                           " ManageType," + 
                           " ManageStartDate," + 
                           " ManageEndDate," + 
                           " CheckStartDate," + 
                           " CheckEndDate," + 
                           " DebtAmount," + 
                           " Pledge," + 
                           " RebuildCompany," + 
                           " RebuildDate," + 
                           " NewShipCode," + 
                           " ValidStatus," + 
                           " Flag From PrpDship Where " +
                           " ShipCode = ?";
        PrpDshipDto prpDshipDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,shipCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpDshipDto = new PrpDshipDto();
            prpDshipDto.setShipCode(dbManager.getString(resultSet,1));
            prpDshipDto.setShipCName(dbManager.getString(resultSet,2));
            prpDshipDto.setShipEName(dbManager.getString(resultSet,3));
            prpDshipDto.setOldShipName(dbManager.getString(resultSet,4));
            prpDshipDto.setShipOwner(dbManager.getString(resultSet,5));
            prpDshipDto.setOldShipOwner(dbManager.getString(resultSet,6));
            prpDshipDto.setAssociate(dbManager.getString(resultSet,7));
            prpDshipDto.setMakeYearMonth(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,8));
            prpDshipDto.setCountryCode(dbManager.getString(resultSet,9));
            prpDshipDto.setMakeFactory(dbManager.getString(resultSet,10));
            prpDshipDto.setMakeDock(dbManager.getString(resultSet,11));
            prpDshipDto.setStepHull(dbManager.getString(resultSet,12));
            prpDshipDto.setOldStepHull(dbManager.getString(resultSet,13));
            prpDshipDto.setShipFlag(dbManager.getString(resultSet,14));
            prpDshipDto.setShipType(dbManager.getString(resultSet,15));
            prpDshipDto.setUseNature(dbManager.getString(resultSet,16));
            prpDshipDto.setShipUsage(dbManager.getString(resultSet,17));
            prpDshipDto.setShipStruct(dbManager.getString(resultSet,18));
            prpDshipDto.setRegistrySite(dbManager.getString(resultSet,19));
            prpDshipDto.setTonCount(dbManager.getDouble(resultSet,20));
            prpDshipDto.setNetTonCount(dbManager.getDouble(resultSet,21));
            prpDshipDto.setHorsePower(dbManager.getDouble(resultSet,22));
            prpDshipDto.setPowerUnit(dbManager.getString(resultSet,23));
            prpDshipDto.setSeatCount(dbManager.getInt(resultSet,24));
            prpDshipDto.setLoadTon(dbManager.getDouble(resultSet,25));
            prpDshipDto.setShipLength(dbManager.getDouble(resultSet,26));
            prpDshipDto.setShipWidth(dbManager.getDouble(resultSet,27));
            prpDshipDto.setShipDepth(dbManager.getDouble(resultSet,28));
            prpDshipDto.setShipValue(dbManager.getDouble(resultSet,29));
            prpDshipDto.setCertificateOwner(dbManager.getString(resultSet,30));
            prpDshipDto.setActualOwner(dbManager.getString(resultSet,31));
            prpDshipDto.setProprietorName(dbManager.getString(resultSet,32));
            prpDshipDto.setManageType(dbManager.getString(resultSet,33));
            prpDshipDto.setManageStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,34));
            prpDshipDto.setManageEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,35));
            prpDshipDto.setCheckStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,36));
            prpDshipDto.setCheckEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,37));
            prpDshipDto.setDebtAmount(dbManager.getInt(resultSet,38));
            prpDshipDto.setPledge(dbManager.getString(resultSet,39));
            prpDshipDto.setRebuildCompany(dbManager.getString(resultSet,40));
            prpDshipDto.setRebuildDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,41));
            prpDshipDto.setNewShipCode(dbManager.getString(resultSet,42));
            prpDshipDto.setValidStatus(dbManager.getString(resultSet,43));
            prpDshipDto.setFlag(dbManager.getString(resultSet,44));
        }
        resultSet.close();
        log.info("DBPrpDshipBase.findByPrimaryKey() success!");
        return prpDshipDto;
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
        String statement = "Select ShipCode," + 
                           " ShipCName," + 
                           " ShipEName," + 
                           " OldShipName," + 
                           " ShipOwner," + 
                           " OldShipOwner," + 
                           " Associate," + 
                           " MakeYearMonth," + 
                           " CountryCode," + 
                           " MakeFactory," + 
                           " MakeDock," + 
                           " StepHull," + 
                           " OldStepHull," + 
                           " ShipFlag," + 
                           " ShipType," + 
                           " UseNature," + 
                           " ShipUsage," + 
                           " ShipStruct," + 
                           " RegistrySite," + 
                           " TonCount," + 
                           " NetTonCount," + 
                           " HorsePower," + 
                           " PowerUnit," + 
                           " SeatCount," + 
                           " LoadTon," + 
                           " ShipLength," + 
                           " ShipWidth," + 
                           " ShipDepth," + 
                           " ShipValue," + 
                           " CertificateOwner," + 
                           " ActualOwner," + 
                           " ProprietorName," + 
                           " ManageType," + 
                           " ManageStartDate," + 
                           " ManageEndDate," + 
                           " CheckStartDate," + 
                           " CheckEndDate," + 
                           " DebtAmount," + 
                           " Pledge," + 
                           " RebuildCompany," + 
                           " RebuildDate," + 
                           " NewShipCode," + 
                           " ValidStatus," + 
                           " Flag From PrpDship Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpDshipDto prpDshipDto = null;
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

            prpDshipDto = new PrpDshipDto();
            prpDshipDto.setShipCode(dbManager.getString(resultSet,1));
            prpDshipDto.setShipCName(dbManager.getString(resultSet,2));
            prpDshipDto.setShipEName(dbManager.getString(resultSet,3));
            prpDshipDto.setOldShipName(dbManager.getString(resultSet,4));
            prpDshipDto.setShipOwner(dbManager.getString(resultSet,5));
            prpDshipDto.setOldShipOwner(dbManager.getString(resultSet,6));
            prpDshipDto.setAssociate(dbManager.getString(resultSet,7));
            prpDshipDto.setMakeYearMonth(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,8));
            prpDshipDto.setCountryCode(dbManager.getString(resultSet,9));
            prpDshipDto.setMakeFactory(dbManager.getString(resultSet,10));
            prpDshipDto.setMakeDock(dbManager.getString(resultSet,11));
            prpDshipDto.setStepHull(dbManager.getString(resultSet,12));
            prpDshipDto.setOldStepHull(dbManager.getString(resultSet,13));
            prpDshipDto.setShipFlag(dbManager.getString(resultSet,14));
            prpDshipDto.setShipType(dbManager.getString(resultSet,15));
            prpDshipDto.setUseNature(dbManager.getString(resultSet,16));
            prpDshipDto.setShipUsage(dbManager.getString(resultSet,17));
            prpDshipDto.setShipStruct(dbManager.getString(resultSet,18));
            prpDshipDto.setRegistrySite(dbManager.getString(resultSet,19));
            prpDshipDto.setTonCount(dbManager.getDouble(resultSet,20));
            prpDshipDto.setNetTonCount(dbManager.getDouble(resultSet,21));
            prpDshipDto.setHorsePower(dbManager.getDouble(resultSet,22));
            prpDshipDto.setPowerUnit(dbManager.getString(resultSet,23));
            prpDshipDto.setSeatCount(dbManager.getInt(resultSet,24));
            prpDshipDto.setLoadTon(dbManager.getDouble(resultSet,25));
            prpDshipDto.setShipLength(dbManager.getDouble(resultSet,26));
            prpDshipDto.setShipWidth(dbManager.getDouble(resultSet,27));
            prpDshipDto.setShipDepth(dbManager.getDouble(resultSet,28));
            prpDshipDto.setShipValue(dbManager.getDouble(resultSet,29));
            prpDshipDto.setCertificateOwner(dbManager.getString(resultSet,30));
            prpDshipDto.setActualOwner(dbManager.getString(resultSet,31));
            prpDshipDto.setProprietorName(dbManager.getString(resultSet,32));
            prpDshipDto.setManageType(dbManager.getString(resultSet,33));
            prpDshipDto.setManageStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,34));
            prpDshipDto.setManageEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,35));
            prpDshipDto.setCheckStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,36));
            prpDshipDto.setCheckEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,37));
            prpDshipDto.setDebtAmount(dbManager.getInt(resultSet,38));
            prpDshipDto.setPledge(dbManager.getString(resultSet,39));
            prpDshipDto.setRebuildCompany(dbManager.getString(resultSet,40));
            prpDshipDto.setRebuildDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,41));
            prpDshipDto.setNewShipCode(dbManager.getString(resultSet,42));
            prpDshipDto.setValidStatus(dbManager.getString(resultSet,43));
            prpDshipDto.setFlag(dbManager.getString(resultSet,44));
            collection.add(prpDshipDto);
        }
        resultSet.close();
        log.info("DBPrpDshipBase.findByConditions() success!");
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
        String statement = "Delete From PrpDship Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpDshipBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpDship Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpDshipBase.getCount() success!");
        return count;
    }
}
