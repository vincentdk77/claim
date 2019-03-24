package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLreplevyDetailDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLreplevyDetail-权益转让及追偿信息的数据访问对象基类<br>
 * 创建于 2005-03-18 17:53:37.109<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLreplevyDetailBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpLreplevyDetailBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLreplevyDetailBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLreplevyDetailDto prpLreplevyDetailDto
     * @throws Exception
     */
    public void insert(PrpLreplevyDetailDto prpLreplevyDetailDto) throws Exception{
        String mainStatement = " Insert Into PrpLreplevyDetail (" + 
                           " ClaimNo," + 
                           " PolicyNo," + 
                           " Times," + 
                           " SerialNo," + 
                           " ReplevyTypeCode," + 
                           " RightTransferDate," + 
                           " RepleviedName," + 
                           " ReplevyReason," + 
                           " ItemCode," + 
                           " ItemName," + 
                           " Currency," + 
                           " ReplevyFee," + 
                           " ValidFee," + 
                           " ReplevyCharge," + 
                           " ReclaimDate," + 
                           " HandlerCode," + 
                           " OperatorCode," + 
                           " InputDate," + 
                           " Note," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLreplevyDetailDto.getClaimNo() + "'," + 
                           "'" + prpLreplevyDetailDto.getPolicyNo() + "'," + 
                           "" + prpLreplevyDetailDto.getTimes() + "," + 
                           "" + prpLreplevyDetailDto.getSerialNo() + "," + 
                           "'" + prpLreplevyDetailDto.getReplevyTypeCode() + "'," + 
                           "'" + prpLreplevyDetailDto.getRightTransferDate() + "'," + 
                           "'" + prpLreplevyDetailDto.getRepleviedName() + "'," + 
                           "'" + prpLreplevyDetailDto.getReplevyReason() + "'," + 
                           "'" + prpLreplevyDetailDto.getItemCode() + "'," + 
                           "'" + prpLreplevyDetailDto.getItemName() + "'," + 
                           "'" + prpLreplevyDetailDto.getCurrency() + "'," + 
                           "'" + prpLreplevyDetailDto.getReplevyFee() + "'," + 
                           "'" + prpLreplevyDetailDto.getValidFee() + "'," + 
                           "'" + prpLreplevyDetailDto.getReplevyCharge() + "'," + 
                           "'" + prpLreplevyDetailDto.getReclaimDate() + "'," + 
                           "'" + prpLreplevyDetailDto.getHandlerCode() + "'," + 
                           "'" + prpLreplevyDetailDto.getOperatorCode() + "'," + 
                           "'" + prpLreplevyDetailDto.getInputDate() + "'," + 
                           "'" + prpLreplevyDetailDto.getNote() + "'," + 
                           "'" + prpLreplevyDetailDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLreplevyDetailDto.getClaimNo());
        dbManager.setString(2,prpLreplevyDetailDto.getPolicyNo());
        dbManager.setInt(3,prpLreplevyDetailDto.getTimes());
        dbManager.setInt(4,prpLreplevyDetailDto.getSerialNo());
        dbManager.setString(5,prpLreplevyDetailDto.getReplevyTypeCode());
        dbManager.setDateTime(6,prpLreplevyDetailDto.getRightTransferDate());
        dbManager.setString(7,prpLreplevyDetailDto.getRepleviedName());
        dbManager.setString(8,prpLreplevyDetailDto.getReplevyReason());
        dbManager.setString(9,prpLreplevyDetailDto.getItemCode());
        dbManager.setString(10,prpLreplevyDetailDto.getItemName());
        dbManager.setString(11,prpLreplevyDetailDto.getCurrency());
        dbManager.setDouble(12,prpLreplevyDetailDto.getReplevyFee());
        dbManager.setDouble(13,prpLreplevyDetailDto.getValidFee());
        dbManager.setDouble(14,prpLreplevyDetailDto.getReplevyCharge());
        dbManager.setDateTime(15,prpLreplevyDetailDto.getReclaimDate());
        dbManager.setString(16,prpLreplevyDetailDto.getHandlerCode());
        dbManager.setString(17,prpLreplevyDetailDto.getOperatorCode());
        dbManager.setDateTime(18,prpLreplevyDetailDto.getInputDate());
        dbManager.setString(19,prpLreplevyDetailDto.getNote());
        dbManager.setString(20,prpLreplevyDetailDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLreplevyDetailBase.insert() success!");
    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLreplevyDetail (" + 
                           " ClaimNo," + 
                           " PolicyNo," + 
                           " Times," + 
                           " SerialNo," + 
                           " ReplevyTypeCode," + 
                           " RightTransferDate," + 
                           " RepleviedName," + 
                           " ReplevyReason," + 
                           " ItemCode," + 
                           " ItemName," + 
                           " Currency," + 
                           " ReplevyFee," + 
                           " ValidFee," + 
                           " ReplevyCharge," + 
                           " ReclaimDate," + 
                           " HandlerCode," + 
                           " OperatorCode," + 
                           " InputDate," + 
                           " Note," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLreplevyDetailDto prpLreplevyDetailDto = (PrpLreplevyDetailDto)i.next();
            dbManager.setString(1,prpLreplevyDetailDto.getClaimNo());
            dbManager.setString(2,prpLreplevyDetailDto.getPolicyNo());
            dbManager.setInt(3,prpLreplevyDetailDto.getTimes());
            dbManager.setInt(4,prpLreplevyDetailDto.getSerialNo());
            dbManager.setString(5,prpLreplevyDetailDto.getReplevyTypeCode());
            dbManager.setDateTime(6,prpLreplevyDetailDto.getRightTransferDate());
            dbManager.setString(7,prpLreplevyDetailDto.getRepleviedName());
            dbManager.setString(8,prpLreplevyDetailDto.getReplevyReason());
            dbManager.setString(9,prpLreplevyDetailDto.getItemCode());
            dbManager.setString(10,prpLreplevyDetailDto.getItemName());
            dbManager.setString(11,prpLreplevyDetailDto.getCurrency());
            dbManager.setDouble(12,prpLreplevyDetailDto.getReplevyFee());
            dbManager.setDouble(13,prpLreplevyDetailDto.getValidFee());
            dbManager.setDouble(14,prpLreplevyDetailDto.getReplevyCharge());
            dbManager.setDateTime(15,prpLreplevyDetailDto.getReclaimDate());
            dbManager.setString(16,prpLreplevyDetailDto.getHandlerCode());
            dbManager.setString(17,prpLreplevyDetailDto.getOperatorCode());
            dbManager.setDateTime(18,prpLreplevyDetailDto.getInputDate());
            dbManager.setString(19,prpLreplevyDetailDto.getNote());
            dbManager.setString(20,prpLreplevyDetailDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLreplevyDetailBase.insertAll() success!");
    }

    /**
     * 按主键删除一条数据
     * @param claimNo 赔案号
     * @param serialNo 序号
     * @throws Exception
     */
    public void delete(String claimNo,int serialNo) throws Exception{
        String statement = " Delete From PrpLreplevyDetail" + 
	            		   " Where " +
                           " ClaimNo = ? And " + 
                           " SerialNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLreplevyDetail Where " +
                           " ClaimNo = '" + claimNo + "' And " + 
                           " SerialNo = " + serialNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,claimNo);
        dbManager.setInt(2,serialNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLreplevyDetailBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLreplevyDetailDto prpLreplevyDetailDto
     * @throws Exception
     */
    public void update(PrpLreplevyDetailDto prpLreplevyDetailDto) throws Exception{
        String statement = " Update PrpLreplevyDetail Set PolicyNo = ?," + 
                           " Times = ?," + 
                           " ReplevyTypeCode = ?," + 
                           " RightTransferDate = ?," + 
                           " RepleviedName = ?," + 
                           " ReplevyReason = ?," + 
                           " ItemCode = ?," + 
                           " ItemName = ?," + 
                           " Currency = ?," + 
                           " ReplevyFee = ?," + 
                           " ValidFee = ?," + 
                           " ReplevyCharge = ?," + 
                           " ReclaimDate = ?," + 
                           " HandlerCode = ?," + 
                           " OperatorCode = ?," + 
                           " InputDate = ?," + 
                           " Note = ?," + 
                           " Flag = ?" + 
	            		   " Where " +
                           " ClaimNo = ? And " + 
                           " SerialNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLreplevyDetail Set " + 
                           " ClaimNo = '" + prpLreplevyDetailDto.getClaimNo() + "'," + 
                           " PolicyNo = '" + prpLreplevyDetailDto.getPolicyNo() + "'," + 
                           " Times = " + prpLreplevyDetailDto.getTimes() + "," + 
                           " SerialNo = " + prpLreplevyDetailDto.getSerialNo() + "," + 
                           " ReplevyTypeCode = '" + prpLreplevyDetailDto.getReplevyTypeCode() + "'," + 
                           " RightTransferDate = '" + prpLreplevyDetailDto.getRightTransferDate() + "'," + 
                           " RepleviedName = '" + prpLreplevyDetailDto.getRepleviedName() + "'," + 
                           " ReplevyReason = '" + prpLreplevyDetailDto.getReplevyReason() + "'," + 
                           " ItemCode = '" + prpLreplevyDetailDto.getItemCode() + "'," + 
                           " ItemName = '" + prpLreplevyDetailDto.getItemName() + "'," + 
                           " Currency = '" + prpLreplevyDetailDto.getCurrency() + "'," + 
                           " ReplevyFee = '" + prpLreplevyDetailDto.getReplevyFee() + "'," + 
                           " ValidFee = '" + prpLreplevyDetailDto.getValidFee() + "'," + 
                           " ReplevyCharge = '" + prpLreplevyDetailDto.getReplevyCharge() + "'," + 
                           " ReclaimDate = '" + prpLreplevyDetailDto.getReclaimDate() + "'," + 
                           " HandlerCode = '" + prpLreplevyDetailDto.getHandlerCode() + "'," + 
                           " OperatorCode = '" + prpLreplevyDetailDto.getOperatorCode() + "'," + 
                           " InputDate = '" + prpLreplevyDetailDto.getInputDate() + "'," + 
                           " Note = '" + prpLreplevyDetailDto.getNote() + "'," + 
                           " Flag = '" + prpLreplevyDetailDto.getFlag() + "'" + 
			               " Where " +
                           " ClaimNo = '" + prpLreplevyDetailDto.getClaimNo() + "' And " + 
                           " SerialNo = " + prpLreplevyDetailDto.getSerialNo() + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpLreplevyDetailDto.getPolicyNo());
        dbManager.setInt(2,prpLreplevyDetailDto.getTimes());
        dbManager.setString(3,prpLreplevyDetailDto.getReplevyTypeCode());
        dbManager.setDateTime(4,prpLreplevyDetailDto.getRightTransferDate());
        dbManager.setString(5,prpLreplevyDetailDto.getRepleviedName());
        dbManager.setString(6,prpLreplevyDetailDto.getReplevyReason());
        dbManager.setString(7,prpLreplevyDetailDto.getItemCode());
        dbManager.setString(8,prpLreplevyDetailDto.getItemName());
        dbManager.setString(9,prpLreplevyDetailDto.getCurrency());
        dbManager.setDouble(10,prpLreplevyDetailDto.getReplevyFee());
        dbManager.setDouble(11,prpLreplevyDetailDto.getValidFee());
        dbManager.setDouble(12,prpLreplevyDetailDto.getReplevyCharge());
        dbManager.setDateTime(13,prpLreplevyDetailDto.getReclaimDate());
        dbManager.setString(14,prpLreplevyDetailDto.getHandlerCode());
        dbManager.setString(15,prpLreplevyDetailDto.getOperatorCode());
        dbManager.setDateTime(16,prpLreplevyDetailDto.getInputDate());
        dbManager.setString(17,prpLreplevyDetailDto.getNote());
        dbManager.setString(18,prpLreplevyDetailDto.getFlag());
        //设置条件字段;
        dbManager.setString(19,prpLreplevyDetailDto.getClaimNo());
        dbManager.setInt(20,prpLreplevyDetailDto.getSerialNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLreplevyDetailBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param claimNo 赔案号
     * @param serialNo 序号
     * @return PrpLreplevyDetailDto
     * @throws Exception
     */
    public PrpLreplevyDetailDto findByPrimaryKey(String claimNo,int serialNo) throws Exception{
        String mainStatement = " Select ClaimNo," + 
                           " PolicyNo," + 
                           " Times," + 
                           " SerialNo," + 
                           " ReplevyTypeCode," + 
                           " RightTransferDate," + 
                           " RepleviedName," + 
                           " ReplevyReason," + 
                           " ItemCode," + 
                           " ItemName," + 
                           " Currency," + 
                           " ReplevyFee," + 
                           " ValidFee," + 
                           " ReplevyCharge," + 
                           " ReclaimDate," + 
                           " HandlerCode," + 
                           " OperatorCode," + 
                           " InputDate," + 
                           " Note," + 
                           " Flag From PrpLreplevyDetail";
        String statement = mainStatement + " Where " +
                           " ClaimNo = ? And " + 
                           " SerialNo = ?";
        PrpLreplevyDetailDto prpLreplevyDetailDto = null;
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
            prpLreplevyDetailDto = new PrpLreplevyDetailDto();
            prpLreplevyDetailDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLreplevyDetailDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpLreplevyDetailDto.setTimes(dbManager.getInt(resultSet,3));
            prpLreplevyDetailDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpLreplevyDetailDto.setReplevyTypeCode(dbManager.getString(resultSet,5));
            prpLreplevyDetailDto.setRightTransferDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,6));
            prpLreplevyDetailDto.setRepleviedName(dbManager.getString(resultSet,7));
            prpLreplevyDetailDto.setReplevyReason(dbManager.getString(resultSet,8));
            prpLreplevyDetailDto.setItemCode(dbManager.getString(resultSet,9));
            prpLreplevyDetailDto.setItemName(dbManager.getString(resultSet,10));
            prpLreplevyDetailDto.setCurrency(dbManager.getString(resultSet,11));
            prpLreplevyDetailDto.setReplevyFee(dbManager.getDouble(resultSet,12));
            prpLreplevyDetailDto.setValidFee(dbManager.getDouble(resultSet,13));
            prpLreplevyDetailDto.setReplevyCharge(dbManager.getDouble(resultSet,14));
            prpLreplevyDetailDto.setReclaimDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,15));
            prpLreplevyDetailDto.setHandlerCode(dbManager.getString(resultSet,16));
            prpLreplevyDetailDto.setOperatorCode(dbManager.getString(resultSet,17));
            prpLreplevyDetailDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,18));
            prpLreplevyDetailDto.setNote(dbManager.getString(resultSet,19));
            prpLreplevyDetailDto.setFlag(dbManager.getString(resultSet,20));
            logger.info("DBPrpLreplevyDetailBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLreplevyDetailBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLreplevyDetailDto;
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
                           " Times," + 
                           " SerialNo," + 
                           " ReplevyTypeCode," + 
                           " RightTransferDate," + 
                           " RepleviedName," + 
                           " ReplevyReason," + 
                           " ItemCode," + 
                           " ItemName," + 
                           " Currency," + 
                           " ReplevyFee," + 
                           " ValidFee," + 
                           " ReplevyCharge," + 
                           " ReclaimDate," + 
                           " HandlerCode," + 
                           " OperatorCode," + 
                           " InputDate," + 
                           " Note," + 
                           " Flag From PrpLreplevyDetail Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLreplevyDetailDto prpLreplevyDetailDto = null;
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

            prpLreplevyDetailDto = new PrpLreplevyDetailDto();
            prpLreplevyDetailDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLreplevyDetailDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpLreplevyDetailDto.setTimes(dbManager.getInt(resultSet,3));
            prpLreplevyDetailDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpLreplevyDetailDto.setReplevyTypeCode(dbManager.getString(resultSet,5));
            prpLreplevyDetailDto.setRightTransferDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,6));
            prpLreplevyDetailDto.setRepleviedName(dbManager.getString(resultSet,7));
            prpLreplevyDetailDto.setReplevyReason(dbManager.getString(resultSet,8));
            prpLreplevyDetailDto.setItemCode(dbManager.getString(resultSet,9));
            prpLreplevyDetailDto.setItemName(dbManager.getString(resultSet,10));
            prpLreplevyDetailDto.setCurrency(dbManager.getString(resultSet,11));
            prpLreplevyDetailDto.setReplevyFee(dbManager.getDouble(resultSet,12));
            prpLreplevyDetailDto.setValidFee(dbManager.getDouble(resultSet,13));
            prpLreplevyDetailDto.setReplevyCharge(dbManager.getDouble(resultSet,14));
            prpLreplevyDetailDto.setReclaimDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,15));
            prpLreplevyDetailDto.setHandlerCode(dbManager.getString(resultSet,16));
            prpLreplevyDetailDto.setOperatorCode(dbManager.getString(resultSet,17));
            prpLreplevyDetailDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,18));
            prpLreplevyDetailDto.setNote(dbManager.getString(resultSet,19));
            prpLreplevyDetailDto.setFlag(dbManager.getString(resultSet,20));
            collection.add(prpLreplevyDetailDto);
        }
        resultSet.close();
        logger.info("DBPrpLreplevyDetailBase.findByConditions() success!");
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
        String statement = "Delete From PrpLreplevyDetail Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLreplevyDetailBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLreplevyDetail Where " + conditions;
           statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLreplevyDetailBase.getCount() success!");
        return count;
    }
}
