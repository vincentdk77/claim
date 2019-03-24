package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLreplevyDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLreplevy-权益转让及追偿信息的数据访问对象基类<br>
 * 创建于 2005-03-18 17:53:37.125<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLreplevyBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpLreplevyBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLreplevyBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLreplevyDto prpLreplevyDto
     * @throws Exception
     */
    public void insert(PrpLreplevyDto prpLreplevyDto) throws Exception{
        String mainStatement = " Insert Into PrpLreplevy (" + 
                           " ClaimNo," + 
                           " Times," + 
                           " PolicyNo," + 
                           " ReplevyTypeCode," + 
                           " RightTransferDate," + 
                           " RepleviedName," + 
                           " ReplevyReason," + 
                           " ReplevyWay," + 
                           " ReclaimDate," + 
                           " ValidDate," + 
                           " Currency," + 
                           " SumReplevyFee," + 
                           " SumValidFee," + 
                           " AmortizeWay," + 
                           " MakeCom," + 
                           " ComCode," + 
                           " ApproverCode," + 
                           " HandlerCode," + 
                           " Handler1Code," + 
                           " StatisticsYM," + 
                           " OperatorCode," + 
                           " InputDate," + 
                           " EndCaseDate," + 
                           " EndCaseCode," + 
                           " CancelDate," + 
                           " CancelReason," + 
                           " DealerCode," + 
                           " Note," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLreplevyDto.getClaimNo() + "'," + 
                           "" + prpLreplevyDto.getTimes() + "," + 
                           "'" + prpLreplevyDto.getPolicyNo() + "'," + 
                           "'" + prpLreplevyDto.getReplevyTypeCode() + "'," + 
                           "'" + prpLreplevyDto.getRightTransferDate() + "'," + 
                           "'" + prpLreplevyDto.getRepleviedName() + "'," + 
                           "'" + prpLreplevyDto.getReplevyReason() + "'," + 
                           "'" + prpLreplevyDto.getReplevyWay() + "'," + 
                           "'" + prpLreplevyDto.getReclaimDate() + "'," + 
                           "'" + prpLreplevyDto.getValidDate() + "'," + 
                           "'" + prpLreplevyDto.getCurrency() + "'," + 
                           "'" + prpLreplevyDto.getSumReplevyFee() + "'," + 
                           "'" + prpLreplevyDto.getSumValidFee() + "'," + 
                           "'" + prpLreplevyDto.getAmortizeWay() + "'," + 
                           "'" + prpLreplevyDto.getMakeCom() + "'," + 
                           "'" + prpLreplevyDto.getComCode() + "'," + 
                           "'" + prpLreplevyDto.getApproverCode() + "'," + 
                           "'" + prpLreplevyDto.getHandlerCode() + "'," + 
                           "'" + prpLreplevyDto.getHandler1Code() + "'," + 
                           "'" + prpLreplevyDto.getStatisticsYM() + "'," + 
                           "'" + prpLreplevyDto.getOperatorCode() + "'," + 
                           "'" + prpLreplevyDto.getInputDate() + "'," + 
                           "'" + prpLreplevyDto.getEndCaseDate() + "'," + 
                           "'" + prpLreplevyDto.getEndCaseCode() + "'," + 
                           "'" + prpLreplevyDto.getCancelDate() + "'," + 
                           "'" + prpLreplevyDto.getCancelReason() + "'," + 
                           "'" + prpLreplevyDto.getDealerCode() + "'," + 
                           "'" + prpLreplevyDto.getNote() + "'," + 
                           "'" + prpLreplevyDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLreplevyDto.getClaimNo());
        dbManager.setInt(2,prpLreplevyDto.getTimes());
        dbManager.setString(3,prpLreplevyDto.getPolicyNo());
        dbManager.setString(4,prpLreplevyDto.getReplevyTypeCode());
        dbManager.setDateTime(5,prpLreplevyDto.getRightTransferDate());
        dbManager.setString(6,prpLreplevyDto.getRepleviedName());
        dbManager.setString(7,prpLreplevyDto.getReplevyReason());
        dbManager.setString(8,prpLreplevyDto.getReplevyWay());
        dbManager.setDateTime(9,prpLreplevyDto.getReclaimDate());
        dbManager.setDateTime(10,prpLreplevyDto.getValidDate());
        dbManager.setString(11,prpLreplevyDto.getCurrency());
        dbManager.setDouble(12,prpLreplevyDto.getSumReplevyFee());
        dbManager.setDouble(13,prpLreplevyDto.getSumValidFee());
        dbManager.setString(14,prpLreplevyDto.getAmortizeWay());
        dbManager.setString(15,prpLreplevyDto.getMakeCom());
        dbManager.setString(16,prpLreplevyDto.getComCode());
        dbManager.setString(17,prpLreplevyDto.getApproverCode());
        dbManager.setString(18,prpLreplevyDto.getHandlerCode());
        dbManager.setString(19,prpLreplevyDto.getHandler1Code());
        dbManager.setDateTime(20,prpLreplevyDto.getStatisticsYM());
        dbManager.setString(21,prpLreplevyDto.getOperatorCode());
        dbManager.setDateTime(22,prpLreplevyDto.getInputDate());
        dbManager.setDateTime(23,prpLreplevyDto.getEndCaseDate());
        dbManager.setString(24,prpLreplevyDto.getEndCaseCode());
        dbManager.setDateTime(25,prpLreplevyDto.getCancelDate());
        dbManager.setString(26,prpLreplevyDto.getCancelReason());
        dbManager.setString(27,prpLreplevyDto.getDealerCode());
        dbManager.setString(28,prpLreplevyDto.getNote());
        dbManager.setString(29,prpLreplevyDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLreplevyBase.insert() success!");
    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLreplevy (" + 
                           " ClaimNo," + 
                           " Times," + 
                           " PolicyNo," + 
                           " ReplevyTypeCode," + 
                           " RightTransferDate," + 
                           " RepleviedName," + 
                           " ReplevyReason," + 
                           " ReplevyWay," + 
                           " ReclaimDate," + 
                           " ValidDate," + 
                           " Currency," + 
                           " SumReplevyFee," + 
                           " SumValidFee," + 
                           " AmortizeWay," + 
                           " MakeCom," + 
                           " ComCode," + 
                           " ApproverCode," + 
                           " HandlerCode," + 
                           " Handler1Code," + 
                           " StatisticsYM," + 
                           " OperatorCode," + 
                           " InputDate," + 
                           " EndCaseDate," + 
                           " EndCaseCode," + 
                           " CancelDate," + 
                           " CancelReason," + 
                           " DealerCode," + 
                           " Note," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLreplevyDto prpLreplevyDto = (PrpLreplevyDto)i.next();
            dbManager.setString(1,prpLreplevyDto.getClaimNo());
            dbManager.setInt(2,prpLreplevyDto.getTimes());
            dbManager.setString(3,prpLreplevyDto.getPolicyNo());
            dbManager.setString(4,prpLreplevyDto.getReplevyTypeCode());
            dbManager.setDateTime(5,prpLreplevyDto.getRightTransferDate());
            dbManager.setString(6,prpLreplevyDto.getRepleviedName());
            dbManager.setString(7,prpLreplevyDto.getReplevyReason());
            dbManager.setString(8,prpLreplevyDto.getReplevyWay());
            dbManager.setDateTime(9,prpLreplevyDto.getReclaimDate());
            dbManager.setDateTime(10,prpLreplevyDto.getValidDate());
            dbManager.setString(11,prpLreplevyDto.getCurrency());
            dbManager.setDouble(12,prpLreplevyDto.getSumReplevyFee());
            dbManager.setDouble(13,prpLreplevyDto.getSumValidFee());
            dbManager.setString(14,prpLreplevyDto.getAmortizeWay());
            dbManager.setString(15,prpLreplevyDto.getMakeCom());
            dbManager.setString(16,prpLreplevyDto.getComCode());
            dbManager.setString(17,prpLreplevyDto.getApproverCode());
            dbManager.setString(18,prpLreplevyDto.getHandlerCode());
            dbManager.setString(19,prpLreplevyDto.getHandler1Code());
            dbManager.setDateTime(20,prpLreplevyDto.getStatisticsYM());
            dbManager.setString(21,prpLreplevyDto.getOperatorCode());
            dbManager.setDateTime(22,prpLreplevyDto.getInputDate());
            dbManager.setDateTime(23,prpLreplevyDto.getEndCaseDate());
            dbManager.setString(24,prpLreplevyDto.getEndCaseCode());
            dbManager.setDateTime(25,prpLreplevyDto.getCancelDate());
            dbManager.setString(26,prpLreplevyDto.getCancelReason());
            dbManager.setString(27,prpLreplevyDto.getDealerCode());
            dbManager.setString(28,prpLreplevyDto.getNote());
            dbManager.setString(29,prpLreplevyDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLreplevyBase.insertAll() success!");
    }

    /**
     * 按主键删除一条数据
     * @param claimNo 赔案号
     * @param times 次数
     * @throws Exception
     */
    public void delete(String claimNo,int times) throws Exception{
        String statement = " Delete From PrpLreplevy" + 
	            		   " Where " +
                           " ClaimNo = ? And " + 
                           " Times = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLreplevy Where " +
                           " ClaimNo = '" + claimNo + "' And " + 
                           " Times = " + times + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,claimNo);
        dbManager.setInt(2,times);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLreplevyBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLreplevyDto prpLreplevyDto
     * @throws Exception
     */
    public void update(PrpLreplevyDto prpLreplevyDto) throws Exception{
        String statement = " Update PrpLreplevy Set PolicyNo = ?," + 
                           " ReplevyTypeCode = ?," + 
                           " RightTransferDate = ?," + 
                           " RepleviedName = ?," + 
                           " ReplevyReason = ?," + 
                           " ReplevyWay = ?," + 
                           " ReclaimDate = ?," + 
                           " ValidDate = ?," + 
                           " Currency = ?," + 
                           " SumReplevyFee = ?," + 
                           " SumValidFee = ?," + 
                           " AmortizeWay = ?," + 
                           " MakeCom = ?," + 
                           " ComCode = ?," + 
                           " ApproverCode = ?," + 
                           " HandlerCode = ?," + 
                           " Handler1Code = ?," + 
                           " StatisticsYM = ?," + 
                           " OperatorCode = ?," + 
                           " InputDate = ?," + 
                           " EndCaseDate = ?," + 
                           " EndCaseCode = ?," + 
                           " CancelDate = ?," + 
                           " CancelReason = ?," + 
                           " DealerCode = ?," + 
                           " Note = ?," + 
                           " Flag = ?" + 
	            		   " Where " +
                           " ClaimNo = ? And " + 
                           " Times = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLreplevy Set " + 
                           " ClaimNo = '" + prpLreplevyDto.getClaimNo() + "'," + 
                           " Times = " + prpLreplevyDto.getTimes() + "," + 
                           " PolicyNo = '" + prpLreplevyDto.getPolicyNo() + "'," + 
                           " ReplevyTypeCode = '" + prpLreplevyDto.getReplevyTypeCode() + "'," + 
                           " RightTransferDate = '" + prpLreplevyDto.getRightTransferDate() + "'," + 
                           " RepleviedName = '" + prpLreplevyDto.getRepleviedName() + "'," + 
                           " ReplevyReason = '" + prpLreplevyDto.getReplevyReason() + "'," + 
                           " ReplevyWay = '" + prpLreplevyDto.getReplevyWay() + "'," + 
                           " ReclaimDate = '" + prpLreplevyDto.getReclaimDate() + "'," + 
                           " ValidDate = '" + prpLreplevyDto.getValidDate() + "'," + 
                           " Currency = '" + prpLreplevyDto.getCurrency() + "'," + 
                           " SumReplevyFee = '" + prpLreplevyDto.getSumReplevyFee() + "'," + 
                           " SumValidFee = '" + prpLreplevyDto.getSumValidFee() + "'," + 
                           " AmortizeWay = '" + prpLreplevyDto.getAmortizeWay() + "'," + 
                           " MakeCom = '" + prpLreplevyDto.getMakeCom() + "'," + 
                           " ComCode = '" + prpLreplevyDto.getComCode() + "'," + 
                           " ApproverCode = '" + prpLreplevyDto.getApproverCode() + "'," + 
                           " HandlerCode = '" + prpLreplevyDto.getHandlerCode() + "'," + 
                           " Handler1Code = '" + prpLreplevyDto.getHandler1Code() + "'," + 
                           " StatisticsYM = '" + prpLreplevyDto.getStatisticsYM() + "'," + 
                           " OperatorCode = '" + prpLreplevyDto.getOperatorCode() + "'," + 
                           " InputDate = '" + prpLreplevyDto.getInputDate() + "'," + 
                           " EndCaseDate = '" + prpLreplevyDto.getEndCaseDate() + "'," + 
                           " EndCaseCode = '" + prpLreplevyDto.getEndCaseCode() + "'," + 
                           " CancelDate = '" + prpLreplevyDto.getCancelDate() + "'," + 
                           " CancelReason = '" + prpLreplevyDto.getCancelReason() + "'," + 
                           " DealerCode = '" + prpLreplevyDto.getDealerCode() + "'," + 
                           " Note = '" + prpLreplevyDto.getNote() + "'," + 
                           " Flag = '" + prpLreplevyDto.getFlag() + "'" + 
			               " Where " +
                           " ClaimNo = '" + prpLreplevyDto.getClaimNo() + "' And " + 
                           " Times = " + prpLreplevyDto.getTimes() + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpLreplevyDto.getPolicyNo());
        dbManager.setString(2,prpLreplevyDto.getReplevyTypeCode());
        dbManager.setDateTime(3,prpLreplevyDto.getRightTransferDate());
        dbManager.setString(4,prpLreplevyDto.getRepleviedName());
        dbManager.setString(5,prpLreplevyDto.getReplevyReason());
        dbManager.setString(6,prpLreplevyDto.getReplevyWay());
        dbManager.setDateTime(7,prpLreplevyDto.getReclaimDate());
        dbManager.setDateTime(8,prpLreplevyDto.getValidDate());
        dbManager.setString(9,prpLreplevyDto.getCurrency());
        dbManager.setDouble(10,prpLreplevyDto.getSumReplevyFee());
        dbManager.setDouble(11,prpLreplevyDto.getSumValidFee());
        dbManager.setString(12,prpLreplevyDto.getAmortizeWay());
        dbManager.setString(13,prpLreplevyDto.getMakeCom());
        dbManager.setString(14,prpLreplevyDto.getComCode());
        dbManager.setString(15,prpLreplevyDto.getApproverCode());
        dbManager.setString(16,prpLreplevyDto.getHandlerCode());
        dbManager.setString(17,prpLreplevyDto.getHandler1Code());
        dbManager.setDateTime(18,prpLreplevyDto.getStatisticsYM());
        dbManager.setString(19,prpLreplevyDto.getOperatorCode());
        dbManager.setDateTime(20,prpLreplevyDto.getInputDate());
        dbManager.setDateTime(21,prpLreplevyDto.getEndCaseDate());
        dbManager.setString(22,prpLreplevyDto.getEndCaseCode());
        dbManager.setDateTime(23,prpLreplevyDto.getCancelDate());
        dbManager.setString(24,prpLreplevyDto.getCancelReason());
        dbManager.setString(25,prpLreplevyDto.getDealerCode());
        dbManager.setString(26,prpLreplevyDto.getNote());
        dbManager.setString(27,prpLreplevyDto.getFlag());
        //设置条件字段;
        dbManager.setString(28,prpLreplevyDto.getClaimNo());
        dbManager.setInt(29,prpLreplevyDto.getTimes());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLreplevyBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param claimNo 赔案号
     * @param times 次数
     * @return PrpLreplevyDto
     * @throws Exception
     */
    public PrpLreplevyDto findByPrimaryKey(String claimNo,int times) throws Exception{
        String mainStatement = " Select ClaimNo," + 
                           " Times," + 
                           " PolicyNo," + 
                           " ReplevyTypeCode," + 
                           " RightTransferDate," + 
                           " RepleviedName," + 
                           " ReplevyReason," + 
                           " ReplevyWay," + 
                           " ReclaimDate," + 
                           " ValidDate," + 
                           " Currency," + 
                           " SumReplevyFee," + 
                           " SumValidFee," + 
                           " AmortizeWay," + 
                           " MakeCom," + 
                           " ComCode," + 
                           " ApproverCode," + 
                           " HandlerCode," + 
                           " Handler1Code," + 
                           " StatisticsYM," + 
                           " OperatorCode," + 
                           " InputDate," + 
                           " EndCaseDate," + 
                           " EndCaseCode," + 
                           " CancelDate," + 
                           " CancelReason," + 
                           " DealerCode," + 
                           " Note," + 
                           " Flag From PrpLreplevy";
        String statement = mainStatement + " Where " +
                           " ClaimNo = ? And " + 
                           " Times = ?";
        PrpLreplevyDto prpLreplevyDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " ClaimNo = '" + claimNo + "' And " + 
                           " Times = " + times + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,claimNo);
        dbManager.setInt(2,times);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLreplevyDto = new PrpLreplevyDto();
            prpLreplevyDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLreplevyDto.setTimes(dbManager.getInt(resultSet,2));
            prpLreplevyDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpLreplevyDto.setReplevyTypeCode(dbManager.getString(resultSet,4));
            prpLreplevyDto.setRightTransferDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,5));
            prpLreplevyDto.setRepleviedName(dbManager.getString(resultSet,6));
            prpLreplevyDto.setReplevyReason(dbManager.getString(resultSet,7));
            prpLreplevyDto.setReplevyWay(dbManager.getString(resultSet,8));
            prpLreplevyDto.setReclaimDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,9));
            prpLreplevyDto.setValidDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,10));
            prpLreplevyDto.setCurrency(dbManager.getString(resultSet,11));
            prpLreplevyDto.setSumReplevyFee(dbManager.getDouble(resultSet,12));
            prpLreplevyDto.setSumValidFee(dbManager.getDouble(resultSet,13));
            prpLreplevyDto.setAmortizeWay(dbManager.getString(resultSet,14));
            prpLreplevyDto.setMakeCom(dbManager.getString(resultSet,15));
            prpLreplevyDto.setComCode(dbManager.getString(resultSet,16));
            prpLreplevyDto.setApproverCode(dbManager.getString(resultSet,17));
            prpLreplevyDto.setHandlerCode(dbManager.getString(resultSet,18));
            prpLreplevyDto.setHandler1Code(dbManager.getString(resultSet,19));
            prpLreplevyDto.setStatisticsYM(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,20));
            prpLreplevyDto.setOperatorCode(dbManager.getString(resultSet,21));
            prpLreplevyDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,22));
            prpLreplevyDto.setEndCaseDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,23));
            prpLreplevyDto.setEndCaseCode(dbManager.getString(resultSet,24));
            prpLreplevyDto.setCancelDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,25));
            prpLreplevyDto.setCancelReason(dbManager.getString(resultSet,26));
            prpLreplevyDto.setDealerCode(dbManager.getString(resultSet,27));
            prpLreplevyDto.setNote(dbManager.getString(resultSet,28));
            prpLreplevyDto.setFlag(dbManager.getString(resultSet,29));
            logger.info("DBPrpLreplevyBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLreplevyBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLreplevyDto;
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
                           " Times," + 
                           " PolicyNo," + 
                           " ReplevyTypeCode," + 
                           " RightTransferDate," + 
                           " RepleviedName," + 
                           " ReplevyReason," + 
                           " ReplevyWay," + 
                           " ReclaimDate," + 
                           " ValidDate," + 
                           " Currency," + 
                           " SumReplevyFee," + 
                           " SumValidFee," + 
                           " AmortizeWay," + 
                           " MakeCom," + 
                           " ComCode," + 
                           " ApproverCode," + 
                           " HandlerCode," + 
                           " Handler1Code," + 
                           " StatisticsYM," + 
                           " OperatorCode," + 
                           " InputDate," + 
                           " EndCaseDate," + 
                           " EndCaseCode," + 
                           " CancelDate," + 
                           " CancelReason," + 
                           " DealerCode," + 
                           " Note," + 
                           " Flag From PrpLreplevy Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLreplevyDto prpLreplevyDto = null;
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

            prpLreplevyDto = new PrpLreplevyDto();
            prpLreplevyDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLreplevyDto.setTimes(dbManager.getInt(resultSet,2));
            prpLreplevyDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpLreplevyDto.setReplevyTypeCode(dbManager.getString(resultSet,4));
            prpLreplevyDto.setRightTransferDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,5));
            prpLreplevyDto.setRepleviedName(dbManager.getString(resultSet,6));
            prpLreplevyDto.setReplevyReason(dbManager.getString(resultSet,7));
            prpLreplevyDto.setReplevyWay(dbManager.getString(resultSet,8));
            prpLreplevyDto.setReclaimDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,9));
            prpLreplevyDto.setValidDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,10));
            prpLreplevyDto.setCurrency(dbManager.getString(resultSet,11));
            prpLreplevyDto.setSumReplevyFee(dbManager.getDouble(resultSet,12));
            prpLreplevyDto.setSumValidFee(dbManager.getDouble(resultSet,13));
            prpLreplevyDto.setAmortizeWay(dbManager.getString(resultSet,14));
            prpLreplevyDto.setMakeCom(dbManager.getString(resultSet,15));
            prpLreplevyDto.setComCode(dbManager.getString(resultSet,16));
            prpLreplevyDto.setApproverCode(dbManager.getString(resultSet,17));
            prpLreplevyDto.setHandlerCode(dbManager.getString(resultSet,18));
            prpLreplevyDto.setHandler1Code(dbManager.getString(resultSet,19));
            prpLreplevyDto.setStatisticsYM(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,20));
            prpLreplevyDto.setOperatorCode(dbManager.getString(resultSet,21));
            prpLreplevyDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,22));
            prpLreplevyDto.setEndCaseDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,23));
            prpLreplevyDto.setEndCaseCode(dbManager.getString(resultSet,24));
            prpLreplevyDto.setCancelDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,25));
            prpLreplevyDto.setCancelReason(dbManager.getString(resultSet,26));
            prpLreplevyDto.setDealerCode(dbManager.getString(resultSet,27));
            prpLreplevyDto.setNote(dbManager.getString(resultSet,28));
            prpLreplevyDto.setFlag(dbManager.getString(resultSet,29));
            collection.add(prpLreplevyDto);
        }
        resultSet.close();
        logger.info("DBPrpLreplevyBase.findByConditions() success!");
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
        String statement = "Delete From PrpLreplevy Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLreplevyBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLreplevy Where " + conditions;
           statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLreplevyBase.getCount() success!");
        return count;
    }
}
