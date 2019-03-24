package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCopenCoverBalDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpcopencoverbal协议结算记录表的数据访问对象类<br>
 * 创建于 2004-4-5 15:32:10<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpCopenCoverBalBase{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpCopenCoverBalBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpCopenCoverBalBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpCopenCoverBalDto prpCopenCoverBalDto
     * @throws Exception
     */
    public void insert(PrpCopenCoverBalDto prpCopenCoverBalDto) throws Exception{
        String statement = " Insert Into PrpCopenCoverBal(" + 
                           " EndorseNo," + 
                           " PolicyNo," + 
                           " RiskCode," + 
                           " SerialNo," + 
                           " SendPremium," + 
                           " SendAmount," + 
                           " OneByOnePremium," + 
                           " OneByOneAmount," + 
                           " PaidPremium," + 
                           " PaidAmount," + 
                           " SffPremium," + 
                           " UnSffPremium," + 
                           " DuePremium," + 
                           " BalanceDate," + 
                           " Currency," + 
                           " BalancePremium," + 
                           " BalanceAmount," + 
                           " DomesticRate," + 
                           " DomesticPremium," + 
                           " ImportRate," + 
                           " ImportPremium," + 
                           " HkRate," + 
                           " HkPremium," + 
                           " OceanRate," + 
                           " OceanPremium," + 
                           " OperatorCode," + 
                           " ComCode," + 
                           " Flag) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpCopenCoverBalDto.getEndorseNo());
        dbManager.setString(2,prpCopenCoverBalDto.getPolicyNo());
        dbManager.setString(3,prpCopenCoverBalDto.getRiskCode());
        dbManager.setInt(4,prpCopenCoverBalDto.getSerialNo());
        dbManager.setDouble(5,prpCopenCoverBalDto.getSendPremium());
        dbManager.setDouble(6,prpCopenCoverBalDto.getSendAmount());
        dbManager.setDouble(7,prpCopenCoverBalDto.getOneByOnePremium());
        dbManager.setDouble(8,prpCopenCoverBalDto.getOneByOneAmount());
        dbManager.setDouble(9,prpCopenCoverBalDto.getPaidPremium());
        dbManager.setDouble(10,prpCopenCoverBalDto.getPaidAmount());
        dbManager.setDouble(11,prpCopenCoverBalDto.getSffPremium());
        dbManager.setDouble(12,prpCopenCoverBalDto.getUnSffPremium());
        dbManager.setDouble(13,prpCopenCoverBalDto.getDuePremium());
        dbManager.setDateTime(14,prpCopenCoverBalDto.getBalanceDate());
        dbManager.setString(15,prpCopenCoverBalDto.getCurrency());
        dbManager.setDouble(16,prpCopenCoverBalDto.getBalancePremium());
        dbManager.setDouble(17,prpCopenCoverBalDto.getBalanceAmount());
        dbManager.setDouble(18,prpCopenCoverBalDto.getDomesticRate());
        dbManager.setDouble(19,prpCopenCoverBalDto.getDomesticPremium());
        dbManager.setDouble(20,prpCopenCoverBalDto.getImportRate());
        dbManager.setDouble(21,prpCopenCoverBalDto.getImportPremium());
        dbManager.setDouble(22,prpCopenCoverBalDto.getHkRate());
        dbManager.setDouble(23,prpCopenCoverBalDto.getHkPremium());
        dbManager.setDouble(24,prpCopenCoverBalDto.getOceanRate());
        dbManager.setDouble(25,prpCopenCoverBalDto.getOceanPremium());
        dbManager.setString(26,prpCopenCoverBalDto.getOperatorCode());
        dbManager.setString(27,prpCopenCoverBalDto.getComCode());
        dbManager.setString(28,prpCopenCoverBalDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCopenCoverBalBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpCopenCoverBalDto prpCopenCoverBalDto = (PrpCopenCoverBalDto)i.next();
            insert(prpCopenCoverBalDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param policyNo 协议号
     * @param serialNo 顺序号
     * @throws Exception
     */
    public void delete(String policyNo,int serialNo) throws Exception{
        String statement = " Delete From PrpCopenCoverBal Where " +
                           " PolicyNo = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,policyNo);
        dbManager.setInt(2,serialNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpCopenCoverBalBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpCopenCoverBalDto prpCopenCoverBalDto
     * @throws Exception
     */
    public void update(PrpCopenCoverBalDto prpCopenCoverBalDto) throws Exception{
        String statement = " Update PrpCopenCoverBal Set EndorseNo = ?," + 
                           " RiskCode = ?," + 
                           " SendPremium = ?," + 
                           " SendAmount = ?," + 
                           " OneByOnePremium = ?," + 
                           " OneByOneAmount = ?," + 
                           " PaidPremium = ?," + 
                           " PaidAmount = ?," + 
                           " SffPremium = ?," + 
                           " UnSffPremium = ?," + 
                           " DuePremium = ?," + 
                           " BalanceDate = ?," + 
                           " Currency = ?," + 
                           " BalancePremium = ?," + 
                           " BalanceAmount = ?," + 
                           " DomesticRate = ?," + 
                           " DomesticPremium = ?," + 
                           " ImportRate = ?," + 
                           " ImportPremium = ?," + 
                           " HkRate = ?," + 
                           " HkPremium = ?," + 
                           " OceanRate = ?," + 
                           " OceanPremium = ?," + 
                           " OperatorCode = ?," + 
                           " ComCode = ?," + 
                           " Flag = ? Where " +
                           " PolicyNo = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpCopenCoverBalDto.getEndorseNo());
        dbManager.setString(2,prpCopenCoverBalDto.getRiskCode());
        dbManager.setDouble(3,prpCopenCoverBalDto.getSendPremium());
        dbManager.setDouble(4,prpCopenCoverBalDto.getSendAmount());
        dbManager.setDouble(5,prpCopenCoverBalDto.getOneByOnePremium());
        dbManager.setDouble(6,prpCopenCoverBalDto.getOneByOneAmount());
        dbManager.setDouble(7,prpCopenCoverBalDto.getPaidPremium());
        dbManager.setDouble(8,prpCopenCoverBalDto.getPaidAmount());
        dbManager.setDouble(9,prpCopenCoverBalDto.getSffPremium());
        dbManager.setDouble(10,prpCopenCoverBalDto.getUnSffPremium());
        dbManager.setDouble(11,prpCopenCoverBalDto.getDuePremium());
        dbManager.setDateTime(12,prpCopenCoverBalDto.getBalanceDate());
        dbManager.setString(13,prpCopenCoverBalDto.getCurrency());
        dbManager.setDouble(14,prpCopenCoverBalDto.getBalancePremium());
        dbManager.setDouble(15,prpCopenCoverBalDto.getBalanceAmount());
        dbManager.setDouble(16,prpCopenCoverBalDto.getDomesticRate());
        dbManager.setDouble(17,prpCopenCoverBalDto.getDomesticPremium());
        dbManager.setDouble(18,prpCopenCoverBalDto.getImportRate());
        dbManager.setDouble(19,prpCopenCoverBalDto.getImportPremium());
        dbManager.setDouble(20,prpCopenCoverBalDto.getHkRate());
        dbManager.setDouble(21,prpCopenCoverBalDto.getHkPremium());
        dbManager.setDouble(22,prpCopenCoverBalDto.getOceanRate());
        dbManager.setDouble(23,prpCopenCoverBalDto.getOceanPremium());
        dbManager.setString(24,prpCopenCoverBalDto.getOperatorCode());
        dbManager.setString(25,prpCopenCoverBalDto.getComCode());
        dbManager.setString(26,prpCopenCoverBalDto.getFlag());
        //设置条件字段;
        dbManager.setString(27,prpCopenCoverBalDto.getPolicyNo());
        dbManager.setInt(28,prpCopenCoverBalDto.getSerialNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCopenCoverBalBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param policyNo 协议号
     * @param serialNo 顺序号
     * @return PrpCopenCoverBalDto
     * @throws Exception
     */
    public PrpCopenCoverBalDto findByPrimaryKey(String policyNo,int serialNo) throws Exception{
        String statement = " Select EndorseNo," + 
                           " PolicyNo," + 
                           " RiskCode," + 
                           " SerialNo," + 
                           " SendPremium," + 
                           " SendAmount," + 
                           " OneByOnePremium," + 
                           " OneByOneAmount," + 
                           " PaidPremium," + 
                           " PaidAmount," + 
                           " SffPremium," + 
                           " UnSffPremium," + 
                           " DuePremium," + 
                           " BalanceDate," + 
                           " Currency," + 
                           " BalancePremium," + 
                           " BalanceAmount," + 
                           " DomesticRate," + 
                           " DomesticPremium," + 
                           " ImportRate," + 
                           " ImportPremium," + 
                           " HkRate," + 
                           " HkPremium," + 
                           " OceanRate," + 
                           " OceanPremium," + 
                           " OperatorCode," + 
                           " ComCode," + 
                           " Flag From PrpCopenCoverBal Where " +
                           " PolicyNo = ? And " + 
                           " SerialNo = ?";
        PrpCopenCoverBalDto prpCopenCoverBalDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,policyNo);
        dbManager.setInt(2,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpCopenCoverBalDto = new PrpCopenCoverBalDto();
            prpCopenCoverBalDto.setEndorseNo(dbManager.getString(resultSet,1));
            prpCopenCoverBalDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpCopenCoverBalDto.setRiskCode(dbManager.getString(resultSet,3));
            prpCopenCoverBalDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpCopenCoverBalDto.setSendPremium(dbManager.getDouble(resultSet,5));
            prpCopenCoverBalDto.setSendAmount(dbManager.getDouble(resultSet,6));
            prpCopenCoverBalDto.setOneByOnePremium(dbManager.getDouble(resultSet,7));
            prpCopenCoverBalDto.setOneByOneAmount(dbManager.getDouble(resultSet,8));
            prpCopenCoverBalDto.setPaidPremium(dbManager.getDouble(resultSet,9));
            prpCopenCoverBalDto.setPaidAmount(dbManager.getDouble(resultSet,10));
            prpCopenCoverBalDto.setSffPremium(dbManager.getDouble(resultSet,11));
            prpCopenCoverBalDto.setUnSffPremium(dbManager.getDouble(resultSet,12));
            prpCopenCoverBalDto.setDuePremium(dbManager.getDouble(resultSet,13));
            prpCopenCoverBalDto.setBalanceDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,14));
            prpCopenCoverBalDto.setCurrency(dbManager.getString(resultSet,15));
            prpCopenCoverBalDto.setBalancePremium(dbManager.getDouble(resultSet,16));
            prpCopenCoverBalDto.setBalanceAmount(dbManager.getDouble(resultSet,17));
            prpCopenCoverBalDto.setDomesticRate(dbManager.getDouble(resultSet,18));
            prpCopenCoverBalDto.setDomesticPremium(dbManager.getDouble(resultSet,19));
            prpCopenCoverBalDto.setImportRate(dbManager.getDouble(resultSet,20));
            prpCopenCoverBalDto.setImportPremium(dbManager.getDouble(resultSet,21));
            prpCopenCoverBalDto.setHkRate(dbManager.getDouble(resultSet,22));
            prpCopenCoverBalDto.setHkPremium(dbManager.getDouble(resultSet,23));
            prpCopenCoverBalDto.setOceanRate(dbManager.getDouble(resultSet,24));
            prpCopenCoverBalDto.setOceanPremium(dbManager.getDouble(resultSet,25));
            prpCopenCoverBalDto.setOperatorCode(dbManager.getString(resultSet,26));
            prpCopenCoverBalDto.setComCode(dbManager.getString(resultSet,27));
            prpCopenCoverBalDto.setFlag(dbManager.getString(resultSet,28));
        }
        resultSet.close();
        log.info("DBPrpCopenCoverBalBase.findByPrimaryKey() success!");
        return prpCopenCoverBalDto;
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
                           " RiskCode," + 
                           " SerialNo," + 
                           " SendPremium," + 
                           " SendAmount," + 
                           " OneByOnePremium," + 
                           " OneByOneAmount," + 
                           " PaidPremium," + 
                           " PaidAmount," + 
                           " SffPremium," + 
                           " UnSffPremium," + 
                           " DuePremium," + 
                           " BalanceDate," + 
                           " Currency," + 
                           " BalancePremium," + 
                           " BalanceAmount," + 
                           " DomesticRate," + 
                           " DomesticPremium," + 
                           " ImportRate," + 
                           " ImportPremium," + 
                           " HkRate," + 
                           " HkPremium," + 
                           " OceanRate," + 
                           " OceanPremium," + 
                           " OperatorCode," + 
                           " ComCode," + 
                           " Flag From PrpCopenCoverBal Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpCopenCoverBalDto prpCopenCoverBalDto = null;
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

            prpCopenCoverBalDto = new PrpCopenCoverBalDto();
            prpCopenCoverBalDto.setEndorseNo(dbManager.getString(resultSet,1));
            prpCopenCoverBalDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpCopenCoverBalDto.setRiskCode(dbManager.getString(resultSet,3));
            prpCopenCoverBalDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpCopenCoverBalDto.setSendPremium(dbManager.getDouble(resultSet,5));
            prpCopenCoverBalDto.setSendAmount(dbManager.getDouble(resultSet,6));
            prpCopenCoverBalDto.setOneByOnePremium(dbManager.getDouble(resultSet,7));
            prpCopenCoverBalDto.setOneByOneAmount(dbManager.getDouble(resultSet,8));
            prpCopenCoverBalDto.setPaidPremium(dbManager.getDouble(resultSet,9));
            prpCopenCoverBalDto.setPaidAmount(dbManager.getDouble(resultSet,10));
            prpCopenCoverBalDto.setSffPremium(dbManager.getDouble(resultSet,11));
            prpCopenCoverBalDto.setUnSffPremium(dbManager.getDouble(resultSet,12));
            prpCopenCoverBalDto.setDuePremium(dbManager.getDouble(resultSet,13));
            prpCopenCoverBalDto.setBalanceDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,14));
            prpCopenCoverBalDto.setCurrency(dbManager.getString(resultSet,15));
            prpCopenCoverBalDto.setBalancePremium(dbManager.getDouble(resultSet,16));
            prpCopenCoverBalDto.setBalanceAmount(dbManager.getDouble(resultSet,17));
            prpCopenCoverBalDto.setDomesticRate(dbManager.getDouble(resultSet,18));
            prpCopenCoverBalDto.setDomesticPremium(dbManager.getDouble(resultSet,19));
            prpCopenCoverBalDto.setImportRate(dbManager.getDouble(resultSet,20));
            prpCopenCoverBalDto.setImportPremium(dbManager.getDouble(resultSet,21));
            prpCopenCoverBalDto.setHkRate(dbManager.getDouble(resultSet,22));
            prpCopenCoverBalDto.setHkPremium(dbManager.getDouble(resultSet,23));
            prpCopenCoverBalDto.setOceanRate(dbManager.getDouble(resultSet,24));
            prpCopenCoverBalDto.setOceanPremium(dbManager.getDouble(resultSet,25));
            prpCopenCoverBalDto.setOperatorCode(dbManager.getString(resultSet,26));
            prpCopenCoverBalDto.setComCode(dbManager.getString(resultSet,27));
            prpCopenCoverBalDto.setFlag(dbManager.getString(resultSet,28));
            collection.add(prpCopenCoverBalDto);
        }
        resultSet.close();
        log.info("DBPrpCopenCoverBalBase.findByConditions() success!");
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
        String statement = "Delete From PrpCopenCoverBal Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpCopenCoverBalBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpCopenCoverBal Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpCopenCoverBalBase.getCount() success!");
        return count;
    }
}
