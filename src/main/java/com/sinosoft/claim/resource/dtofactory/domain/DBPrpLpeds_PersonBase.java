package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLpeds_PersonDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLpeds_Person人员伤亡明细信息表的数据访问对象类<br>
 * 创建于 2004-4-5 15:32:09<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLpeds_PersonBase{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpLpeds_PersonBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLpeds_PersonBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLpeds_PersonDto prpLpeds_PersonDto
     * @throws Exception
     */
    public void insert(PrpLpeds_PersonDto prpLpeds_PersonDto) throws Exception{
        String statement = " Insert Into PrpLpeds_Person(" + 
                           " RegistNo," + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " ItemKindNo," + 
                           " KindCode," + 
                           " SerialNo," + 
                           " AreaCode," + 
                           " FixedIncomeFlag," + 
                           " JobCode," + 
                           " JobName," + 
                           " PayPersonType," + 
                           " FeeTypeCode," + 
                           " FeeTypeName," + 
                           " PersonNo," + 
                           " PersonName," + 
                           " PersonSex," + 
                           " PersonAge," + 
                           " Currency," + 
                           " SumLoss," + 
                           " SumReject," + 
                           " RejectReason," + 
                           " LossRate," + 
                           " SumDefLoss," + 
                           " Remark," + 
                           " Flag) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLpeds_PersonDto.getRegistNo());
        dbManager.setString(2,prpLpeds_PersonDto.getRiskCode());
        dbManager.setString(3,prpLpeds_PersonDto.getPolicyNo());
        dbManager.setInt(4,prpLpeds_PersonDto.getItemKindNo());
        dbManager.setString(5,prpLpeds_PersonDto.getKindCode());
        dbManager.setInt(6,prpLpeds_PersonDto.getSerialNo());
        dbManager.setString(7,prpLpeds_PersonDto.getAreaCode());
        dbManager.setString(8,prpLpeds_PersonDto.getFixedIncomeFlag());
        dbManager.setString(9,prpLpeds_PersonDto.getJobCode());
        dbManager.setString(10,prpLpeds_PersonDto.getJobName());
        dbManager.setString(11,prpLpeds_PersonDto.getPayPersonType());
        dbManager.setString(12,prpLpeds_PersonDto.getFeeTypeCode());
        dbManager.setString(13,prpLpeds_PersonDto.getFeeTypeName());
        dbManager.setInt(14,prpLpeds_PersonDto.getPersonNo());
        dbManager.setString(15,prpLpeds_PersonDto.getPersonName());
        dbManager.setString(16,prpLpeds_PersonDto.getPersonSex());
        dbManager.setInt(17,prpLpeds_PersonDto.getPersonAge());
        dbManager.setString(18,prpLpeds_PersonDto.getCurrency());
        dbManager.setDouble(19,prpLpeds_PersonDto.getSumLoss());
        dbManager.setDouble(20,prpLpeds_PersonDto.getSumReject());
        dbManager.setString(21,prpLpeds_PersonDto.getRejectReason());
        dbManager.setDouble(22,prpLpeds_PersonDto.getLossRate());
        dbManager.setDouble(23,prpLpeds_PersonDto.getSumDefLoss());
        dbManager.setString(24,prpLpeds_PersonDto.getRemark());
        dbManager.setString(25,prpLpeds_PersonDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpLpeds_PersonBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpLpeds_PersonDto prpLpeds_PersonDto = (PrpLpeds_PersonDto)i.next();
            insert(prpLpeds_PersonDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param registNo 报案号
     * @param serialNo 序号
     * @throws Exception
     */
    public void delete(String registNo,int serialNo) throws Exception{
        String statement = " Delete From PrpLpeds_Person Where " +
                           " RegistNo = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,registNo);
        dbManager.setInt(2,serialNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpLpeds_PersonBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLpeds_PersonDto prpLpeds_PersonDto
     * @throws Exception
     */
    public void update(PrpLpeds_PersonDto prpLpeds_PersonDto) throws Exception{
        String statement = " Update PrpLpeds_Person Set RiskCode = ?," + 
                           " PolicyNo = ?," + 
                           " ItemKindNo = ?," + 
                           " KindCode = ?," + 
                           " AreaCode = ?," + 
                           " FixedIncomeFlag = ?," + 
                           " JobCode = ?," + 
                           " JobName = ?," + 
                           " PayPersonType = ?," + 
                           " FeeTypeCode = ?," + 
                           " FeeTypeName = ?," + 
                           " PersonNo = ?," + 
                           " PersonName = ?," + 
                           " PersonSex = ?," + 
                           " PersonAge = ?," + 
                           " Currency = ?," + 
                           " SumLoss = ?," + 
                           " SumReject = ?," + 
                           " RejectReason = ?," + 
                           " LossRate = ?," + 
                           " SumDefLoss = ?," + 
                           " Remark = ?," + 
                           " Flag = ? Where " +
                           " RegistNo = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpLpeds_PersonDto.getRiskCode());
        dbManager.setString(2,prpLpeds_PersonDto.getPolicyNo());
        dbManager.setInt(3,prpLpeds_PersonDto.getItemKindNo());
        dbManager.setString(4,prpLpeds_PersonDto.getKindCode());
        dbManager.setString(5,prpLpeds_PersonDto.getAreaCode());
        dbManager.setString(6,prpLpeds_PersonDto.getFixedIncomeFlag());
        dbManager.setString(7,prpLpeds_PersonDto.getJobCode());
        dbManager.setString(8,prpLpeds_PersonDto.getJobName());
        dbManager.setString(9,prpLpeds_PersonDto.getPayPersonType());
        dbManager.setString(10,prpLpeds_PersonDto.getFeeTypeCode());
        dbManager.setString(11,prpLpeds_PersonDto.getFeeTypeName());
        dbManager.setInt(12,prpLpeds_PersonDto.getPersonNo());
        dbManager.setString(13,prpLpeds_PersonDto.getPersonName());
        dbManager.setString(14,prpLpeds_PersonDto.getPersonSex());
        dbManager.setInt(15,prpLpeds_PersonDto.getPersonAge());
        dbManager.setString(16,prpLpeds_PersonDto.getCurrency());
        dbManager.setDouble(17,prpLpeds_PersonDto.getSumLoss());
        dbManager.setDouble(18,prpLpeds_PersonDto.getSumReject());
        dbManager.setString(19,prpLpeds_PersonDto.getRejectReason());
        dbManager.setDouble(20,prpLpeds_PersonDto.getLossRate());
        dbManager.setDouble(21,prpLpeds_PersonDto.getSumDefLoss());
        dbManager.setString(22,prpLpeds_PersonDto.getRemark());
        dbManager.setString(23,prpLpeds_PersonDto.getFlag());
        //设置条件字段;
        dbManager.setString(24,prpLpeds_PersonDto.getRegistNo());
        dbManager.setInt(25,prpLpeds_PersonDto.getSerialNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpLpeds_PersonBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param registNo 报案号
     * @param serialNo 序号
     * @return PrpLpeds_PersonDto
     * @throws Exception
     */
    public PrpLpeds_PersonDto findByPrimaryKey(String registNo,int serialNo) throws Exception{
        String statement = " Select RegistNo," + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " ItemKindNo," + 
                           " KindCode," + 
                           " SerialNo," + 
                           " AreaCode," + 
                           " FixedIncomeFlag," + 
                           " JobCode," + 
                           " JobName," + 
                           " PayPersonType," + 
                           " FeeTypeCode," + 
                           " FeeTypeName," + 
                           " PersonNo," + 
                           " PersonName," + 
                           " PersonSex," + 
                           " PersonAge," + 
                           " Currency," + 
                           " SumLoss," + 
                           " SumReject," + 
                           " RejectReason," + 
                           " LossRate," + 
                           " SumDefLoss," + 
                           " Remark," + 
                           " Flag From PrpLpeds_Person Where " +
                           " RegistNo = ? And " + 
                           " SerialNo = ?";
        PrpLpeds_PersonDto prpLpeds_PersonDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,registNo);
        dbManager.setInt(2,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLpeds_PersonDto = new PrpLpeds_PersonDto();
            prpLpeds_PersonDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLpeds_PersonDto.setRiskCode(dbManager.getString(resultSet,2));
            prpLpeds_PersonDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpLpeds_PersonDto.setItemKindNo(dbManager.getInt(resultSet,4));
            prpLpeds_PersonDto.setKindCode(dbManager.getString(resultSet,5));
            prpLpeds_PersonDto.setSerialNo(dbManager.getInt(resultSet,6));
            prpLpeds_PersonDto.setAreaCode(dbManager.getString(resultSet,7));
            prpLpeds_PersonDto.setFixedIncomeFlag(dbManager.getString(resultSet,8));
            prpLpeds_PersonDto.setJobCode(dbManager.getString(resultSet,9));
            prpLpeds_PersonDto.setJobName(dbManager.getString(resultSet,10));
            prpLpeds_PersonDto.setPayPersonType(dbManager.getString(resultSet,11));
            prpLpeds_PersonDto.setFeeTypeCode(dbManager.getString(resultSet,12));
            prpLpeds_PersonDto.setFeeTypeName(dbManager.getString(resultSet,13));
            prpLpeds_PersonDto.setPersonNo(dbManager.getInt(resultSet,14));
            prpLpeds_PersonDto.setPersonName(dbManager.getString(resultSet,15));
            prpLpeds_PersonDto.setPersonSex(dbManager.getString(resultSet,16));
            prpLpeds_PersonDto.setPersonAge(dbManager.getInt(resultSet,17));
            prpLpeds_PersonDto.setCurrency(dbManager.getString(resultSet,18));
            prpLpeds_PersonDto.setSumLoss(dbManager.getDouble(resultSet,19));
            prpLpeds_PersonDto.setSumReject(dbManager.getDouble(resultSet,20));
            prpLpeds_PersonDto.setRejectReason(dbManager.getString(resultSet,21));
            prpLpeds_PersonDto.setLossRate(dbManager.getDouble(resultSet,22));
            prpLpeds_PersonDto.setSumDefLoss(dbManager.getDouble(resultSet,23));
            prpLpeds_PersonDto.setRemark(dbManager.getString(resultSet,24));
            prpLpeds_PersonDto.setFlag(dbManager.getString(resultSet,25));
        }
        resultSet.close();
        log.info("DBPrpLpeds_PersonBase.findByPrimaryKey() success!");
        return prpLpeds_PersonDto;
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
                           " RiskCode," + 
                           " PolicyNo," + 
                           " ItemKindNo," + 
                           " KindCode," + 
                           " SerialNo," + 
                           " AreaCode," + 
                           " FixedIncomeFlag," + 
                           " JobCode," + 
                           " JobName," + 
                           " PayPersonType," + 
                           " FeeTypeCode," + 
                           " FeeTypeName," + 
                           " PersonNo," + 
                           " PersonName," + 
                           " PersonSex," + 
                           " PersonAge," + 
                           " Currency," + 
                           " SumLoss," + 
                           " SumReject," + 
                           " RejectReason," + 
                           " LossRate," + 
                           " SumDefLoss," + 
                           " Remark," + 
                           " Flag From PrpLpeds_Person Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpLpeds_PersonDto prpLpeds_PersonDto = null;
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

            prpLpeds_PersonDto = new PrpLpeds_PersonDto();
            prpLpeds_PersonDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLpeds_PersonDto.setRiskCode(dbManager.getString(resultSet,2));
            prpLpeds_PersonDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpLpeds_PersonDto.setItemKindNo(dbManager.getInt(resultSet,4));
            prpLpeds_PersonDto.setKindCode(dbManager.getString(resultSet,5));
            prpLpeds_PersonDto.setSerialNo(dbManager.getInt(resultSet,6));
            prpLpeds_PersonDto.setAreaCode(dbManager.getString(resultSet,7));
            prpLpeds_PersonDto.setFixedIncomeFlag(dbManager.getString(resultSet,8));
            prpLpeds_PersonDto.setJobCode(dbManager.getString(resultSet,9));
            prpLpeds_PersonDto.setJobName(dbManager.getString(resultSet,10));
            prpLpeds_PersonDto.setPayPersonType(dbManager.getString(resultSet,11));
            prpLpeds_PersonDto.setFeeTypeCode(dbManager.getString(resultSet,12));
            prpLpeds_PersonDto.setFeeTypeName(dbManager.getString(resultSet,13));
            prpLpeds_PersonDto.setPersonNo(dbManager.getInt(resultSet,14));
            prpLpeds_PersonDto.setPersonName(dbManager.getString(resultSet,15));
            prpLpeds_PersonDto.setPersonSex(dbManager.getString(resultSet,16));
            prpLpeds_PersonDto.setPersonAge(dbManager.getInt(resultSet,17));
            prpLpeds_PersonDto.setCurrency(dbManager.getString(resultSet,18));
            prpLpeds_PersonDto.setSumLoss(dbManager.getDouble(resultSet,19));
            prpLpeds_PersonDto.setSumReject(dbManager.getDouble(resultSet,20));
            prpLpeds_PersonDto.setRejectReason(dbManager.getString(resultSet,21));
            prpLpeds_PersonDto.setLossRate(dbManager.getDouble(resultSet,22));
            prpLpeds_PersonDto.setSumDefLoss(dbManager.getDouble(resultSet,23));
            prpLpeds_PersonDto.setRemark(dbManager.getString(resultSet,24));
            prpLpeds_PersonDto.setFlag(dbManager.getString(resultSet,25));
            collection.add(prpLpeds_PersonDto);
        }
        resultSet.close();
        log.info("DBPrpLpeds_PersonBase.findByConditions() success!");
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
        String statement = "Delete From PrpLpeds_Person Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpLpeds_PersonBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpLpeds_Person Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpLpeds_PersonBase.getCount() success!");
        return count;
    }
}
