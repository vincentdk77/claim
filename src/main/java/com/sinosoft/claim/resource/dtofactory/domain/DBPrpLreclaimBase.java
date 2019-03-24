package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLreclaimDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLreclaim-损余回收信息表的数据访问对象基类<br>
 * 创建于 2005-03-18 17:53:36.812<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLreclaimBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpLreclaimBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLreclaimBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLreclaimDto prpLreclaimDto
     * @throws Exception
     */
    public void insert(PrpLreclaimDto prpLreclaimDto) throws Exception{
        String mainStatement = " Insert Into PrpLreclaim (" + 
                           " ClaimNo," + 
                           " PolicyNo," + 
                           " SerialNo," + 
                           " ItemCode," + 
                           " ItemName," + 
                           " GuarantyName," + 
                           " DealWay," + 
                           " Currency," + 
                           " ReclaimCount," + 
                           " LossFee," + 
                           " BargainFee," + 
                           " PropProtectName," + 
                           " PropProtectFee," + 
                           " ReclaimFee," + 
                           " ReclaimDate," + 
                           " AmortizeWay," + 
                           " HandlerCode," + 
                           " OperatorCode," + 
                           " InputDate," + 
                           " DealType," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLreclaimDto.getClaimNo() + "'," + 
                           "'" + prpLreclaimDto.getPolicyNo() + "'," + 
                           "" + prpLreclaimDto.getSerialNo() + "," + 
                           "'" + prpLreclaimDto.getItemCode() + "'," + 
                           "'" + prpLreclaimDto.getItemName() + "'," + 
                           "'" + prpLreclaimDto.getGuarantyName() + "'," + 
                           "'" + prpLreclaimDto.getDealWay() + "'," + 
                           "'" + prpLreclaimDto.getCurrency() + "'," + 
                           "" + prpLreclaimDto.getReclaimCount() + "," + 
                           "'" + prpLreclaimDto.getLossFee() + "'," + 
                           "'" + prpLreclaimDto.getBargainFee() + "'," + 
                           "'" + prpLreclaimDto.getPropProtectName() + "'," + 
                           "'" + prpLreclaimDto.getPropProtectFee() + "'," + 
                           "'" + prpLreclaimDto.getReclaimFee() + "'," + 
                           "'" + prpLreclaimDto.getReclaimDate() + "'," + 
                           "'" + prpLreclaimDto.getAmortizeWay() + "'," + 
                           "'" + prpLreclaimDto.getHandlerCode() + "'," + 
                           "'" + prpLreclaimDto.getOperatorCode() + "'," + 
                           "'" + prpLreclaimDto.getInputDate() + "'," + 
                           "'" + prpLreclaimDto.getDealType() + "'," + 
                           "'" + prpLreclaimDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLreclaimDto.getClaimNo());
        dbManager.setString(2,prpLreclaimDto.getPolicyNo());
        dbManager.setInt(3,prpLreclaimDto.getSerialNo());
        dbManager.setString(4,prpLreclaimDto.getItemCode());
        dbManager.setString(5,prpLreclaimDto.getItemName());
        dbManager.setString(6,prpLreclaimDto.getGuarantyName());
        dbManager.setString(7,prpLreclaimDto.getDealWay());
        dbManager.setString(8,prpLreclaimDto.getCurrency());
        dbManager.setInt(9,prpLreclaimDto.getReclaimCount());
        dbManager.setDouble(10,prpLreclaimDto.getLossFee());
        dbManager.setDouble(11,prpLreclaimDto.getBargainFee());
        dbManager.setString(12,prpLreclaimDto.getPropProtectName());
        dbManager.setDouble(13,prpLreclaimDto.getPropProtectFee());
        dbManager.setDouble(14,prpLreclaimDto.getReclaimFee());
        dbManager.setDateTime(15,prpLreclaimDto.getReclaimDate());
        dbManager.setString(16,prpLreclaimDto.getAmortizeWay());
        dbManager.setString(17,prpLreclaimDto.getHandlerCode());
        dbManager.setString(18,prpLreclaimDto.getOperatorCode());
        dbManager.setDateTime(19,prpLreclaimDto.getInputDate());
        dbManager.setString(20,prpLreclaimDto.getDealType());
        dbManager.setString(21,prpLreclaimDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLreclaimBase.insert() success!");
    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLreclaim (" + 
                           " ClaimNo," + 
                           " PolicyNo," + 
                           " SerialNo," + 
                           " ItemCode," + 
                           " ItemName," + 
                           " GuarantyName," + 
                           " DealWay," + 
                           " Currency," + 
                           " ReclaimCount," + 
                           " LossFee," + 
                           " BargainFee," + 
                           " PropProtectName," + 
                           " PropProtectFee," + 
                           " ReclaimFee," + 
                           " ReclaimDate," + 
                           " AmortizeWay," + 
                           " HandlerCode," + 
                           " OperatorCode," + 
                           " InputDate," + 
                           " DealType," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLreclaimDto prpLreclaimDto = (PrpLreclaimDto)i.next();
            dbManager.setString(1,prpLreclaimDto.getClaimNo());
            dbManager.setString(2,prpLreclaimDto.getPolicyNo());
            dbManager.setInt(3,prpLreclaimDto.getSerialNo());
            dbManager.setString(4,prpLreclaimDto.getItemCode());
            dbManager.setString(5,prpLreclaimDto.getItemName());
            dbManager.setString(6,prpLreclaimDto.getGuarantyName());
            dbManager.setString(7,prpLreclaimDto.getDealWay());
            dbManager.setString(8,prpLreclaimDto.getCurrency());
            dbManager.setInt(9,prpLreclaimDto.getReclaimCount());
            dbManager.setDouble(10,prpLreclaimDto.getLossFee());
            dbManager.setDouble(11,prpLreclaimDto.getBargainFee());
            dbManager.setString(12,prpLreclaimDto.getPropProtectName());
            dbManager.setDouble(13,prpLreclaimDto.getPropProtectFee());
            dbManager.setDouble(14,prpLreclaimDto.getReclaimFee());
            dbManager.setDateTime(15,prpLreclaimDto.getReclaimDate());
            dbManager.setString(16,prpLreclaimDto.getAmortizeWay());
            dbManager.setString(17,prpLreclaimDto.getHandlerCode());
            dbManager.setString(18,prpLreclaimDto.getOperatorCode());
            dbManager.setDateTime(19,prpLreclaimDto.getInputDate());
            dbManager.setString(20,prpLreclaimDto.getDealType());
            dbManager.setString(21,prpLreclaimDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLreclaimBase.insertAll() success!");
    }

    /**
     * 按主键删除一条数据
     * @param claimNo 赔案号码
     * @param serialNo 序号
     * @throws Exception
     */
    public void delete(String claimNo,int serialNo) throws Exception{
        String statement = " Delete From PrpLreclaim" + 
	            		   " Where " +
                           " ClaimNo = ? And " + 
                           " SerialNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLreclaim Where " +
                           " ClaimNo = '" + claimNo + "' And " + 
                           " SerialNo = " + serialNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,claimNo);
        dbManager.setInt(2,serialNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLreclaimBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLreclaimDto prpLreclaimDto
     * @throws Exception
     */
    public void update(PrpLreclaimDto prpLreclaimDto) throws Exception{
        String statement = " Update PrpLreclaim Set PolicyNo = ?," + 
                           " ItemCode = ?," + 
                           " ItemName = ?," + 
                           " GuarantyName = ?," + 
                           " DealWay = ?," + 
                           " Currency = ?," + 
                           " ReclaimCount = ?," + 
                           " LossFee = ?," + 
                           " BargainFee = ?," + 
                           " PropProtectName = ?," + 
                           " PropProtectFee = ?," + 
                           " ReclaimFee = ?," + 
                           " ReclaimDate = ?," + 
                           " AmortizeWay = ?," + 
                           " HandlerCode = ?," + 
                           " OperatorCode = ?," + 
                           " InputDate = ?," + 
                           " DealType = ?," + 
                           " Flag = ?" + 
	            		   " Where " +
                           " ClaimNo = ? And " + 
                           " SerialNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLreclaim Set " + 
                           " ClaimNo = '" + prpLreclaimDto.getClaimNo() + "'," + 
                           " PolicyNo = '" + prpLreclaimDto.getPolicyNo() + "'," + 
                           " SerialNo = " + prpLreclaimDto.getSerialNo() + "," + 
                           " ItemCode = '" + prpLreclaimDto.getItemCode() + "'," + 
                           " ItemName = '" + prpLreclaimDto.getItemName() + "'," + 
                           " GuarantyName = '" + prpLreclaimDto.getGuarantyName() + "'," + 
                           " DealWay = '" + prpLreclaimDto.getDealWay() + "'," + 
                           " Currency = '" + prpLreclaimDto.getCurrency() + "'," + 
                           " ReclaimCount = " + prpLreclaimDto.getReclaimCount() + "," + 
                           " LossFee = '" + prpLreclaimDto.getLossFee() + "'," + 
                           " BargainFee = '" + prpLreclaimDto.getBargainFee() + "'," + 
                           " PropProtectName = '" + prpLreclaimDto.getPropProtectName() + "'," + 
                           " PropProtectFee = '" + prpLreclaimDto.getPropProtectFee() + "'," + 
                           " ReclaimFee = '" + prpLreclaimDto.getReclaimFee() + "'," + 
                           " ReclaimDate = '" + prpLreclaimDto.getReclaimDate() + "'," + 
                           " AmortizeWay = '" + prpLreclaimDto.getAmortizeWay() + "'," + 
                           " HandlerCode = '" + prpLreclaimDto.getHandlerCode() + "'," + 
                           " OperatorCode = '" + prpLreclaimDto.getOperatorCode() + "'," + 
                           " InputDate = '" + prpLreclaimDto.getInputDate() + "'," + 
                           " DealType = '" + prpLreclaimDto.getDealType() + "'," + 
                           " Flag = '" + prpLreclaimDto.getFlag() + "'" + 
			               " Where " +
                           " ClaimNo = '" + prpLreclaimDto.getClaimNo() + "' And " + 
                           " SerialNo = " + prpLreclaimDto.getSerialNo() + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpLreclaimDto.getPolicyNo());
        dbManager.setString(2,prpLreclaimDto.getItemCode());
        dbManager.setString(3,prpLreclaimDto.getItemName());
        dbManager.setString(4,prpLreclaimDto.getGuarantyName());
        dbManager.setString(5,prpLreclaimDto.getDealWay());
        dbManager.setString(6,prpLreclaimDto.getCurrency());
        dbManager.setInt(7,prpLreclaimDto.getReclaimCount());
        dbManager.setDouble(8,prpLreclaimDto.getLossFee());
        dbManager.setDouble(9,prpLreclaimDto.getBargainFee());
        dbManager.setString(10,prpLreclaimDto.getPropProtectName());
        dbManager.setDouble(11,prpLreclaimDto.getPropProtectFee());
        dbManager.setDouble(12,prpLreclaimDto.getReclaimFee());
        dbManager.setDateTime(13,prpLreclaimDto.getReclaimDate());
        dbManager.setString(14,prpLreclaimDto.getAmortizeWay());
        dbManager.setString(15,prpLreclaimDto.getHandlerCode());
        dbManager.setString(16,prpLreclaimDto.getOperatorCode());
        dbManager.setDateTime(17,prpLreclaimDto.getInputDate());
        dbManager.setString(18,prpLreclaimDto.getDealType());
        dbManager.setString(19,prpLreclaimDto.getFlag());
        //设置条件字段;
        dbManager.setString(20,prpLreclaimDto.getClaimNo());
        dbManager.setInt(21,prpLreclaimDto.getSerialNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLreclaimBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param claimNo 赔案号码
     * @param serialNo 序号
     * @return PrpLreclaimDto
     * @throws Exception
     */
    public PrpLreclaimDto findByPrimaryKey(String claimNo,int serialNo) throws Exception{
        String mainStatement = " Select ClaimNo," + 
                           " PolicyNo," + 
                           " SerialNo," + 
                           " ItemCode," + 
                           " ItemName," + 
                           " GuarantyName," + 
                           " DealWay," + 
                           " Currency," + 
                           " ReclaimCount," + 
                           " LossFee," + 
                           " BargainFee," + 
                           " PropProtectName," + 
                           " PropProtectFee," + 
                           " ReclaimFee," + 
                           " ReclaimDate," + 
                           " AmortizeWay," + 
                           " HandlerCode," + 
                           " OperatorCode," + 
                           " InputDate," + 
                           " DealType," + 
                           " Flag From PrpLreclaim";
        String statement = mainStatement + " Where " +
                           " ClaimNo = ? And " + 
                           " SerialNo = ?";
        PrpLreclaimDto prpLreclaimDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " ClaimNo = '" + claimNo + "' And " + 
                           " SerialNo = " + serialNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,claimNo);
        dbManager.setInt(2,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLreclaimDto = new PrpLreclaimDto();
            prpLreclaimDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLreclaimDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpLreclaimDto.setSerialNo(dbManager.getInt(resultSet,3));
            prpLreclaimDto.setItemCode(dbManager.getString(resultSet,4));
            prpLreclaimDto.setItemName(dbManager.getString(resultSet,5));
            prpLreclaimDto.setGuarantyName(dbManager.getString(resultSet,6));
            prpLreclaimDto.setDealWay(dbManager.getString(resultSet,7));
            prpLreclaimDto.setCurrency(dbManager.getString(resultSet,8));
            prpLreclaimDto.setReclaimCount(dbManager.getInt(resultSet,9));
            prpLreclaimDto.setLossFee(dbManager.getDouble(resultSet,10));
            prpLreclaimDto.setBargainFee(dbManager.getDouble(resultSet,11));
            prpLreclaimDto.setPropProtectName(dbManager.getString(resultSet,12));
            prpLreclaimDto.setPropProtectFee(dbManager.getDouble(resultSet,13));
            prpLreclaimDto.setReclaimFee(dbManager.getDouble(resultSet,14));
            prpLreclaimDto.setReclaimDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,15));
            prpLreclaimDto.setAmortizeWay(dbManager.getString(resultSet,16));
            prpLreclaimDto.setHandlerCode(dbManager.getString(resultSet,17));
            prpLreclaimDto.setOperatorCode(dbManager.getString(resultSet,18));
            prpLreclaimDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,19));
            prpLreclaimDto.setDealType(dbManager.getString(resultSet,20));
            prpLreclaimDto.setFlag(dbManager.getString(resultSet,21));
            logger.info("DBPrpLreclaimBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLreclaimBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLreclaimDto;
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
        String statement = "Select ClaimNo," + 
                           " PolicyNo," + 
                           " SerialNo," + 
                           " ItemCode," + 
                           " ItemName," + 
                           " GuarantyName," + 
                           " DealWay," + 
                           " Currency," + 
                           " ReclaimCount," + 
                           " LossFee," + 
                           " BargainFee," + 
                           " PropProtectName," + 
                           " PropProtectFee," + 
                           " ReclaimFee," + 
                           " ReclaimDate," + 
                           " AmortizeWay," + 
                           " HandlerCode," + 
                           " OperatorCode," + 
                           " InputDate," + 
                           " DealType," + 
                           " Flag From PrpLreclaim Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLreclaimDto prpLreclaimDto = null;
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

            prpLreclaimDto = new PrpLreclaimDto();
            prpLreclaimDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLreclaimDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpLreclaimDto.setSerialNo(dbManager.getInt(resultSet,3));
            prpLreclaimDto.setItemCode(dbManager.getString(resultSet,4));
            prpLreclaimDto.setItemName(dbManager.getString(resultSet,5));
            prpLreclaimDto.setGuarantyName(dbManager.getString(resultSet,6));
            prpLreclaimDto.setDealWay(dbManager.getString(resultSet,7));
            prpLreclaimDto.setCurrency(dbManager.getString(resultSet,8));
            prpLreclaimDto.setReclaimCount(dbManager.getInt(resultSet,9));
            prpLreclaimDto.setLossFee(dbManager.getDouble(resultSet,10));
            prpLreclaimDto.setBargainFee(dbManager.getDouble(resultSet,11));
            prpLreclaimDto.setPropProtectName(dbManager.getString(resultSet,12));
            prpLreclaimDto.setPropProtectFee(dbManager.getDouble(resultSet,13));
            prpLreclaimDto.setReclaimFee(dbManager.getDouble(resultSet,14));
            prpLreclaimDto.setReclaimDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,15));
            prpLreclaimDto.setAmortizeWay(dbManager.getString(resultSet,16));
            prpLreclaimDto.setHandlerCode(dbManager.getString(resultSet,17));
            prpLreclaimDto.setOperatorCode(dbManager.getString(resultSet,18));
            prpLreclaimDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,19));
            prpLreclaimDto.setDealType(dbManager.getString(resultSet,20));
            prpLreclaimDto.setFlag(dbManager.getString(resultSet,21));
            collection.add(prpLreclaimDto);
        }
        resultSet.close();
        logger.info("DBPrpLreclaimBase.findByConditions() success!");
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
        String statement = "Delete From PrpLreclaim Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLreclaimBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLreclaim Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLreclaimBase.getCount() success!");
        return count;
    }
}
