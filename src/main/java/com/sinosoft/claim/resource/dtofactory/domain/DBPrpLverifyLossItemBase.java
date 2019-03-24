package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLverifyLossItemDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLverifyLossItem定核损处理标的表的数据访问对象基类<br>
 * 创建于 2004-11-11 14:31:03.492<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLverifyLossItemBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpLverifyLossItemBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLverifyLossItemBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLverifyLossItemDto prpLverifyLossItemDto
     * @throws Exception
     */
    public void insert(PrpLverifyLossItemDto prpLverifyLossItemDto) throws Exception{
        String mainStatement = " Insert Into PrpLverifyLossItem (" +
                           " RegistNo," +
                           " ClaimNo," +
                           " SerialNo," +
                           " LossType," +
                           " RiskCode," +
                           " PolicyNo," +
                           " InsuredName," +
                           " LicenseNo," +
                           " LicenseColorcode," +
                           " CarKindCode," +
                           " Currency," +
                           " SumPreDefLoss," +
                           " SumDefLoss," +
                           " MakeCom," +
                           " ComCode," +
                           " HandlerCode," +
                           " HandlerName," +
                           " DefLossDate," +
                           " UnderWriteCode," +
                           " UnderWriteName," +
                           " UnderWriteEndDate," +
                           " UnderWriteFlag," +
                           " NodeType," +
                           " Remark," +
                           " VerifyRemark," +
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" +
                           "'" + prpLverifyLossItemDto.getRegistNo() + "'," +
                           "'" + prpLverifyLossItemDto.getClaimNo() + "'," +
                           "" + prpLverifyLossItemDto.getSerialNo() + "," +
                           "'" + prpLverifyLossItemDto.getLossType() + "'," +
                           "'" + prpLverifyLossItemDto.getRiskCode() + "'," +
                           "'" + prpLverifyLossItemDto.getPolicyNo() + "'," +
                           "'" + prpLverifyLossItemDto.getInsuredName() + "'," +
                           "'" + prpLverifyLossItemDto.getLicenseNo() + "'," +
                           "'" + prpLverifyLossItemDto.getLicenseColorcode() + "'," +
                           "'" + prpLverifyLossItemDto.getCarKindCode() + "'," +
                           "'" + prpLverifyLossItemDto.getCurrency() + "'," +
                           "'" + prpLverifyLossItemDto.getSumPreDefLoss() + "'," +
                           "'" + prpLverifyLossItemDto.getSumDefLoss() + "'," +
                           "'" + prpLverifyLossItemDto.getMakeCom() + "'," +
                           "'" + prpLverifyLossItemDto.getComCode() + "'," +
                           "'" + prpLverifyLossItemDto.getHandlerCode() + "'," +
                           "'" + prpLverifyLossItemDto.getHandlerName() + "'," +
                           "'" + prpLverifyLossItemDto.getDefLossDate() + "'," +
                           "'" + prpLverifyLossItemDto.getUnderWriteCode() + "'," +
                           "'" + prpLverifyLossItemDto.getUnderWriteName() + "'," +
                           "'" + prpLverifyLossItemDto.getUnderWriteEndDate() + "'," +
                           "'" + prpLverifyLossItemDto.getUnderWriteFlag() + "'," +
                           "'" + prpLverifyLossItemDto.getNodeType() + "'," +
                           "'" + prpLverifyLossItemDto.getRemark() + "'," +
                           "'" + prpLverifyLossItemDto.getVerifyRemark() + "'," +
                           "'" + prpLverifyLossItemDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLverifyLossItemDto.getRegistNo());
        dbManager.setString(2,prpLverifyLossItemDto.getClaimNo());
        dbManager.setInt(3,prpLverifyLossItemDto.getSerialNo());
        dbManager.setString(4,prpLverifyLossItemDto.getLossType());
        dbManager.setString(5,prpLverifyLossItemDto.getRiskCode());
        dbManager.setString(6,prpLverifyLossItemDto.getPolicyNo());
        dbManager.setString(7,prpLverifyLossItemDto.getInsuredName());
        dbManager.setString(8,prpLverifyLossItemDto.getLicenseNo());
        dbManager.setString(9,prpLverifyLossItemDto.getLicenseColorcode());
        dbManager.setString(10,prpLverifyLossItemDto.getCarKindCode());
        dbManager.setString(11,prpLverifyLossItemDto.getCurrency());
        dbManager.setDouble(12,prpLverifyLossItemDto.getSumPreDefLoss());
        dbManager.setDouble(13,prpLverifyLossItemDto.getSumDefLoss());
        dbManager.setString(14,prpLverifyLossItemDto.getMakeCom());
        dbManager.setString(15,prpLverifyLossItemDto.getComCode());
        dbManager.setString(16,prpLverifyLossItemDto.getHandlerCode());
        dbManager.setString(17,prpLverifyLossItemDto.getHandlerName());
        dbManager.setDateTime(18,prpLverifyLossItemDto.getDefLossDate());
        dbManager.setString(19,prpLverifyLossItemDto.getUnderWriteCode());
        dbManager.setString(20,prpLverifyLossItemDto.getUnderWriteName());
        dbManager.setDateTime(21,prpLverifyLossItemDto.getUnderWriteEndDate());
        dbManager.setString(22,prpLverifyLossItemDto.getUnderWriteFlag());
        dbManager.setString(23,prpLverifyLossItemDto.getNodeType());
        dbManager.setString(24,prpLverifyLossItemDto.getRemark());
        dbManager.setString(25,prpLverifyLossItemDto.getVerifyRemark());
        dbManager.setString(26,prpLverifyLossItemDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLverifyLossItemBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpLverifyLossItemDto prpLverifyLossItemDto = (PrpLverifyLossItemDto)i.next();
            insert(prpLverifyLossItemDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param registNo 报案号码
     * @param serialNo 序号
     * @throws Exception
     */
    public void delete(String registNo,int serialNo) throws Exception{
        String statement = " Delete From PrpLverifyLossItem" +
	            		   " Where " +
                           " RegistNo = ? And " +
                           " SerialNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLverifyLossItem Where " +
                           " RegistNo = '" + registNo + "' And " +
                           " SerialNo = " + serialNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,registNo);
        dbManager.setInt(2,serialNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLverifyLossItemBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLverifyLossItemDto prpLverifyLossItemDto
     * @throws Exception
     */
    public void update(PrpLverifyLossItemDto prpLverifyLossItemDto) throws Exception{
        String statement = " Update PrpLverifyLossItem Set ClaimNo = ?," +
                           " LossType = ?," +
                           " RiskCode = ?," +
                           " PolicyNo = ?," +
                           " InsuredName = ?," +
                           " LicenseNo = ?," +
                           " LicenseColorcode = ?," +
                           " CarKindCode = ?," +
                           " Currency = ?," +
                           " SumPreDefLoss = ?," +
                           " SumDefLoss = ?," +
                           " MakeCom = ?," +
                           " ComCode = ?," +
                           " HandlerCode = ?," +
                           " HandlerName = ?," +
                           " DefLossDate = ?," +
                           " UnderWriteCode = ?," +
                           " UnderWriteName = ?," +
                           " UnderWriteEndDate = ?," +
                           " UnderWriteFlag = ?," +
                           " NodeType = ?," +
                           " Remark = ?," +
                           " VerifyRemark = ?," +
                           " Flag = ?" +
	            		   " Where " +
                           " RegistNo = ? And " +
                           " SerialNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLverifyLossItem Set " +
                           " RegistNo = '" + prpLverifyLossItemDto.getRegistNo() + "'," +
                           " ClaimNo = '" + prpLverifyLossItemDto.getClaimNo() + "'," +
                           " SerialNo = " + prpLverifyLossItemDto.getSerialNo() + "," +
                           " LossType = '" + prpLverifyLossItemDto.getLossType() + "'," +
                           " RiskCode = '" + prpLverifyLossItemDto.getRiskCode() + "'," +
                           " PolicyNo = '" + prpLverifyLossItemDto.getPolicyNo() + "'," +
                           " InsuredName = '" + prpLverifyLossItemDto.getInsuredName() + "'," +
                           " LicenseNo = '" + prpLverifyLossItemDto.getLicenseNo() + "'," +
                           " LicenseColorcode = '" + prpLverifyLossItemDto.getLicenseColorcode() + "'," +
                           " CarKindCode = '" + prpLverifyLossItemDto.getCarKindCode() + "'," +
                           " Currency = '" + prpLverifyLossItemDto.getCurrency() + "'," +
                           " SumPreDefLoss = '" + prpLverifyLossItemDto.getSumPreDefLoss() + "'," +
                           " SumDefLoss = '" + prpLverifyLossItemDto.getSumDefLoss() + "'," +
                           " MakeCom = '" + prpLverifyLossItemDto.getMakeCom() + "'," +
                           " ComCode = '" + prpLverifyLossItemDto.getComCode() + "'," +
                           " HandlerCode = '" + prpLverifyLossItemDto.getHandlerCode() + "'," +
                           " HandlerName = '" + prpLverifyLossItemDto.getHandlerName() + "'," +
                           " DefLossDate = '" + prpLverifyLossItemDto.getDefLossDate() + "'," +
                           " UnderWriteCode = '" + prpLverifyLossItemDto.getUnderWriteCode() + "'," +
                           " UnderWriteName = '" + prpLverifyLossItemDto.getUnderWriteName() + "'," +
                           " UnderWriteEndDate = '" + prpLverifyLossItemDto.getUnderWriteEndDate() + "'," +
                           " UnderWriteFlag = '" + prpLverifyLossItemDto.getUnderWriteFlag() + "'," +
                           " NodeType = '" + prpLverifyLossItemDto.getNodeType() + "'," +
                           " Remark = '" + prpLverifyLossItemDto.getRemark() + "'," +
                           " VerifyRemark = '" + prpLverifyLossItemDto.getVerifyRemark() + "'," +
                           " Flag = '" + prpLverifyLossItemDto.getFlag() + "'" +
			               " Where " +
                           " RegistNo = '" + prpLverifyLossItemDto.getRegistNo() + "' And " +
                           " SerialNo = " + prpLverifyLossItemDto.getSerialNo() + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpLverifyLossItemDto.getClaimNo());
        dbManager.setString(2,prpLverifyLossItemDto.getLossType());
        dbManager.setString(3,prpLverifyLossItemDto.getRiskCode());
        dbManager.setString(4,prpLverifyLossItemDto.getPolicyNo());
        dbManager.setString(5,prpLverifyLossItemDto.getInsuredName());
        dbManager.setString(6,prpLverifyLossItemDto.getLicenseNo());
        dbManager.setString(7,prpLverifyLossItemDto.getLicenseColorcode());
        dbManager.setString(8,prpLverifyLossItemDto.getCarKindCode());
        dbManager.setString(9,prpLverifyLossItemDto.getCurrency());
        dbManager.setDouble(10,prpLverifyLossItemDto.getSumPreDefLoss());
        dbManager.setDouble(11,prpLverifyLossItemDto.getSumDefLoss());
        dbManager.setString(12,prpLverifyLossItemDto.getMakeCom());
        dbManager.setString(13,prpLverifyLossItemDto.getComCode());
        dbManager.setString(14,prpLverifyLossItemDto.getHandlerCode());
        dbManager.setString(15,prpLverifyLossItemDto.getHandlerName());
        dbManager.setDateTime(16,prpLverifyLossItemDto.getDefLossDate());
        dbManager.setString(17,prpLverifyLossItemDto.getUnderWriteCode());
        dbManager.setString(18,prpLverifyLossItemDto.getUnderWriteName());
        dbManager.setDateTime(19,prpLverifyLossItemDto.getUnderWriteEndDate());
        dbManager.setString(20,prpLverifyLossItemDto.getUnderWriteFlag());
        dbManager.setString(21,prpLverifyLossItemDto.getNodeType());
        dbManager.setString(22,prpLverifyLossItemDto.getRemark());
        dbManager.setString(23,prpLverifyLossItemDto.getVerifyRemark());
        dbManager.setString(24,prpLverifyLossItemDto.getFlag());
        //设置条件字段;
        dbManager.setString(25,prpLverifyLossItemDto.getRegistNo());
        dbManager.setInt(26,prpLverifyLossItemDto.getSerialNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLverifyLossItemBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param registNo 报案号码
     * @param serialNo 序号
     * @return PrpLverifyLossItemDto
     * @throws Exception
     */
    public PrpLverifyLossItemDto findByPrimaryKey(String registNo,int serialNo) throws Exception{
        String mainStatement = " Select RegistNo," +
                           " ClaimNo," +
                           " SerialNo," +
                           " LossType," +
                           " RiskCode," +
                           " PolicyNo," +
                           " InsuredName," +
                           " LicenseNo," +
                           " LicenseColorcode," +
                           " CarKindCode," +
                           " Currency," +
                           " SumPreDefLoss," +
                           " SumDefLoss," +
                           " MakeCom," +
                           " ComCode," +
                           " HandlerCode," +
                           " HandlerName," +
                           " DefLossDate," +
                           " UnderWriteCode," +
                           " UnderWriteName," +
                           " UnderWriteEndDate," +
                           " UnderWriteFlag," +
                           " NodeType," +
                           " Remark," +
                           " VerifyRemark," +
                           " Flag From PrpLverifyLossItem";
        String statement = mainStatement + " Where " +
                           " RegistNo = ? And " +
                           " SerialNo = ?";
        PrpLverifyLossItemDto prpLverifyLossItemDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " RegistNo = '" + registNo + "' And " +
                           " SerialNo = " + serialNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,registNo);
        dbManager.setInt(2,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLverifyLossItemDto = new PrpLverifyLossItemDto();
            prpLverifyLossItemDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLverifyLossItemDto.setClaimNo(dbManager.getString(resultSet,2));
            prpLverifyLossItemDto.setSerialNo(dbManager.getInt(resultSet,3));
            prpLverifyLossItemDto.setLossType(dbManager.getString(resultSet,4));
            prpLverifyLossItemDto.setRiskCode(dbManager.getString(resultSet,5));
            prpLverifyLossItemDto.setPolicyNo(dbManager.getString(resultSet,6));
            prpLverifyLossItemDto.setInsuredName(dbManager.getString(resultSet,7));
            prpLverifyLossItemDto.setLicenseNo(dbManager.getString(resultSet,8));
            prpLverifyLossItemDto.setLicenseColorcode(dbManager.getString(resultSet,9));
            prpLverifyLossItemDto.setCarKindCode(dbManager.getString(resultSet,10));
            prpLverifyLossItemDto.setCurrency(dbManager.getString(resultSet,11));
            prpLverifyLossItemDto.setSumPreDefLoss(dbManager.getDouble(resultSet,12));
            prpLverifyLossItemDto.setSumDefLoss(dbManager.getDouble(resultSet,13));
            prpLverifyLossItemDto.setMakeCom(dbManager.getString(resultSet,14));
            prpLverifyLossItemDto.setComCode(dbManager.getString(resultSet,15));
            prpLverifyLossItemDto.setHandlerCode(dbManager.getString(resultSet,16));
            prpLverifyLossItemDto.setHandlerName(dbManager.getString(resultSet,17));
            prpLverifyLossItemDto.setDefLossDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,18));
            prpLverifyLossItemDto.setUnderWriteCode(dbManager.getString(resultSet,19));
            prpLverifyLossItemDto.setUnderWriteName(dbManager.getString(resultSet,20));
            prpLverifyLossItemDto.setUnderWriteEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,21));
            prpLverifyLossItemDto.setUnderWriteFlag(dbManager.getString(resultSet,22));
            prpLverifyLossItemDto.setNodeType(dbManager.getString(resultSet,23));
            prpLverifyLossItemDto.setRemark(dbManager.getString(resultSet,24));
            prpLverifyLossItemDto.setVerifyRemark(dbManager.getString(resultSet,25));
            prpLverifyLossItemDto.setFlag(dbManager.getString(resultSet,26));
        }
        resultSet.close();
        logger.info("DBPrpLverifyLossItemBase.findByPrimaryKey() success!");
        return prpLverifyLossItemDto;
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
                           " ClaimNo," +
                           " SerialNo," +
                           " LossType," +
                           " RiskCode," +
                           " PolicyNo," +
                           " InsuredName," +
                           " LicenseNo," +
                           " LicenseColorcode," +
                           " CarKindCode," +
                           " Currency," +
                           " SumPreDefLoss," +
                           " SumDefLoss," +
                           " MakeCom," +
                           " ComCode," +
                           " HandlerCode," +
                           " HandlerName," +
                           " DefLossDate," +
                           " UnderWriteCode," +
                           " UnderWriteName," +
                           " UnderWriteEndDate," +
                           " UnderWriteFlag," +
                           " NodeType," +
                           " Remark," +
                           " VerifyRemark," +
                           " Flag From PrpLverifyLossItem Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLverifyLossItemDto prpLverifyLossItemDto = null;
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
            prpLverifyLossItemDto = new PrpLverifyLossItemDto();
            prpLverifyLossItemDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLverifyLossItemDto.setClaimNo(dbManager.getString(resultSet,2));
            prpLverifyLossItemDto.setSerialNo(dbManager.getInt(resultSet,3));
            prpLverifyLossItemDto.setLossType(dbManager.getString(resultSet,4));
            prpLverifyLossItemDto.setRiskCode(dbManager.getString(resultSet,5));
            prpLverifyLossItemDto.setPolicyNo(dbManager.getString(resultSet,6));
            prpLverifyLossItemDto.setInsuredName(dbManager.getString(resultSet,7));
            prpLverifyLossItemDto.setLicenseNo(dbManager.getString(resultSet,8));
            prpLverifyLossItemDto.setLicenseColorcode(dbManager.getString(resultSet,9));
            prpLverifyLossItemDto.setCarKindCode(dbManager.getString(resultSet,10));
            prpLverifyLossItemDto.setCurrency(dbManager.getString(resultSet,11));
            prpLverifyLossItemDto.setSumPreDefLoss(dbManager.getDouble(resultSet,12));
            prpLverifyLossItemDto.setSumDefLoss(dbManager.getDouble(resultSet,13));
            prpLverifyLossItemDto.setMakeCom(dbManager.getString(resultSet,14));
            prpLverifyLossItemDto.setComCode(dbManager.getString(resultSet,15));
            prpLverifyLossItemDto.setHandlerCode(dbManager.getString(resultSet,16));
            prpLverifyLossItemDto.setHandlerName(dbManager.getString(resultSet,17));
            prpLverifyLossItemDto.setDefLossDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,18));
            prpLverifyLossItemDto.setUnderWriteCode(dbManager.getString(resultSet,19));
            prpLverifyLossItemDto.setUnderWriteName(dbManager.getString(resultSet,20));
            prpLverifyLossItemDto.setUnderWriteEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,21));
            prpLverifyLossItemDto.setUnderWriteFlag(dbManager.getString(resultSet,22));
            prpLverifyLossItemDto.setNodeType(dbManager.getString(resultSet,23));
            prpLverifyLossItemDto.setRemark(dbManager.getString(resultSet,24));
            prpLverifyLossItemDto.setVerifyRemark(dbManager.getString(resultSet,25));
            prpLverifyLossItemDto.setFlag(dbManager.getString(resultSet,26));
            collection.add(prpLverifyLossItemDto);
        }
        resultSet.close();
        logger.info("DBPrpLverifyLossItemBase.findByConditions() success!");
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
        String statement = "Delete From PrpLverifyLossItem Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLverifyLossItemBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLverifyLossItem Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLverifyLossItemBase.getCount() success!");
        return count;
    }
}
