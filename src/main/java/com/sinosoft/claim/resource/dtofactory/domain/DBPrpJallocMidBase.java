package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpJallocMidDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpjallocmid长期险业务保费分摊中间表的数据访问对象类<br>
 * 创建于 2004-4-5 15:32:11<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpJallocMidBase{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpJallocMidBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpJallocMidBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpJallocMidDto prpJallocMidDto
     * @throws Exception
     */
    public void insert(PrpJallocMidDto prpJallocMidDto) throws Exception{
        String statement = " Insert Into PrpJallocMid(" + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " AllocNo," + 
                           " CertiNo," + 
                           " SerialNo," + 
                           " AllocSerialNo," + 
                           " StartDate," + 
                           " EndDate," + 
                           " ComCode," + 
                           " MakeCom," + 
                           " InsuredCode," + 
                           " InsuredName," + 
                           " AgentCode," + 
                           " HandlerCode," + 
                           " OperatorCode," + 
                           " Currency," + 
                           " AllocType," + 
                           " EndorType," + 
                           " Limityear," + 
                           " PassYear," + 
                           " AllocYear," + 
                           " SumFee," + 
                           " Prefee," + 
                           " AllocFee," + 
                           " ValueFee," + 
                           " AllocDate," + 
                           " InputDate," + 
                           " Olddate," + 
                           " DealFlag," + 
                           " Tcol1," + 
                           " Tcol2," + 
                           " Tcol3) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpJallocMidDto.getRiskCode());
        dbManager.setString(2,prpJallocMidDto.getPolicyNo());
        dbManager.setString(3,prpJallocMidDto.getAllocNo());
        dbManager.setString(4,prpJallocMidDto.getCertiNo());
        dbManager.setInt(5,prpJallocMidDto.getSerialNo());
        dbManager.setInt(6,prpJallocMidDto.getAllocSerialNo());
        dbManager.setDateTime(7,prpJallocMidDto.getStartDate());
        dbManager.setDateTime(8,prpJallocMidDto.getEndDate());
        dbManager.setString(9,prpJallocMidDto.getComCode());
        dbManager.setString(10,prpJallocMidDto.getMakeCom());
        dbManager.setString(11,prpJallocMidDto.getInsuredCode());
        dbManager.setString(12,prpJallocMidDto.getInsuredName());
        dbManager.setString(13,prpJallocMidDto.getAgentCode());
        dbManager.setString(14,prpJallocMidDto.getHandlerCode());
        dbManager.setString(15,prpJallocMidDto.getOperatorCode());
        dbManager.setString(16,prpJallocMidDto.getCurrency());
        dbManager.setString(17,prpJallocMidDto.getAllocType());
        dbManager.setString(18,prpJallocMidDto.getEndorType());
        dbManager.setInt(19,prpJallocMidDto.getLimityear());
        dbManager.setInt(20,prpJallocMidDto.getPassYear());
        dbManager.setInt(21,prpJallocMidDto.getAllocYear());
        dbManager.setDouble(22,prpJallocMidDto.getSumFee());
        dbManager.setDouble(23,prpJallocMidDto.getPrefee());
        dbManager.setDouble(24,prpJallocMidDto.getAllocFee());
        dbManager.setDouble(25,prpJallocMidDto.getValueFee());
        dbManager.setDateTime(26,prpJallocMidDto.getAllocDate());
        dbManager.setDateTime(27,prpJallocMidDto.getInputDate());
        dbManager.setDateTime(28,prpJallocMidDto.getOlddate());
        dbManager.setString(29,prpJallocMidDto.getDealFlag());
        dbManager.setString(30,prpJallocMidDto.getTcol1());
        dbManager.setInt(31,prpJallocMidDto.getTcol2());
        dbManager.setInt(32,prpJallocMidDto.getTcol3());
        dbManager.executePreparedUpdate();

        log.info("DBPrpJallocMidBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpJallocMidDto prpJallocMidDto = (PrpJallocMidDto)i.next();
            insert(prpJallocMidDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param policyNo 保单号
     * @param serialNo 序号
     * @throws Exception
     */
    public void delete(String policyNo,int serialNo) throws Exception{
        String statement = " Delete From PrpJallocMid Where " +
                           " PolicyNo = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,policyNo);
        dbManager.setInt(2,serialNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpJallocMidBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpJallocMidDto prpJallocMidDto
     * @throws Exception
     */
    public void update(PrpJallocMidDto prpJallocMidDto) throws Exception{
        String statement = " Update PrpJallocMid Set RiskCode = ?," + 
                           " AllocNo = ?," + 
                           " CertiNo = ?," + 
                           " AllocSerialNo = ?," + 
                           " StartDate = ?," + 
                           " EndDate = ?," + 
                           " ComCode = ?," + 
                           " MakeCom = ?," + 
                           " InsuredCode = ?," + 
                           " InsuredName = ?," + 
                           " AgentCode = ?," + 
                           " HandlerCode = ?," + 
                           " OperatorCode = ?," + 
                           " Currency = ?," + 
                           " AllocType = ?," + 
                           " EndorType = ?," + 
                           " Limityear = ?," + 
                           " PassYear = ?," + 
                           " AllocYear = ?," + 
                           " SumFee = ?," + 
                           " Prefee = ?," + 
                           " AllocFee = ?," + 
                           " ValueFee = ?," + 
                           " AllocDate = ?," + 
                           " InputDate = ?," + 
                           " Olddate = ?," + 
                           " DealFlag = ?," + 
                           " Tcol1 = ?," + 
                           " Tcol2 = ?," + 
                           " Tcol3 = ? Where " +
                           " PolicyNo = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpJallocMidDto.getRiskCode());
        dbManager.setString(2,prpJallocMidDto.getAllocNo());
        dbManager.setString(3,prpJallocMidDto.getCertiNo());
        dbManager.setInt(4,prpJallocMidDto.getAllocSerialNo());
        dbManager.setDateTime(5,prpJallocMidDto.getStartDate());
        dbManager.setDateTime(6,prpJallocMidDto.getEndDate());
        dbManager.setString(7,prpJallocMidDto.getComCode());
        dbManager.setString(8,prpJallocMidDto.getMakeCom());
        dbManager.setString(9,prpJallocMidDto.getInsuredCode());
        dbManager.setString(10,prpJallocMidDto.getInsuredName());
        dbManager.setString(11,prpJallocMidDto.getAgentCode());
        dbManager.setString(12,prpJallocMidDto.getHandlerCode());
        dbManager.setString(13,prpJallocMidDto.getOperatorCode());
        dbManager.setString(14,prpJallocMidDto.getCurrency());
        dbManager.setString(15,prpJallocMidDto.getAllocType());
        dbManager.setString(16,prpJallocMidDto.getEndorType());
        dbManager.setInt(17,prpJallocMidDto.getLimityear());
        dbManager.setInt(18,prpJallocMidDto.getPassYear());
        dbManager.setInt(19,prpJallocMidDto.getAllocYear());
        dbManager.setDouble(20,prpJallocMidDto.getSumFee());
        dbManager.setDouble(21,prpJallocMidDto.getPrefee());
        dbManager.setDouble(22,prpJallocMidDto.getAllocFee());
        dbManager.setDouble(23,prpJallocMidDto.getValueFee());
        dbManager.setDateTime(24,prpJallocMidDto.getAllocDate());
        dbManager.setDateTime(25,prpJallocMidDto.getInputDate());
        dbManager.setDateTime(26,prpJallocMidDto.getOlddate());
        dbManager.setString(27,prpJallocMidDto.getDealFlag());
        dbManager.setString(28,prpJallocMidDto.getTcol1());
        dbManager.setInt(29,prpJallocMidDto.getTcol2());
        dbManager.setInt(30,prpJallocMidDto.getTcol3());
        //设置条件字段;
        dbManager.setString(31,prpJallocMidDto.getPolicyNo());
        dbManager.setInt(32,prpJallocMidDto.getSerialNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpJallocMidBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param policyNo 保单号
     * @param serialNo 序号
     * @return PrpJallocMidDto
     * @throws Exception
     */
    public PrpJallocMidDto findByPrimaryKey(String policyNo,int serialNo) throws Exception{
        String statement = " Select RiskCode," + 
                           " PolicyNo," + 
                           " AllocNo," + 
                           " CertiNo," + 
                           " SerialNo," + 
                           " AllocSerialNo," + 
                           " StartDate," + 
                           " EndDate," + 
                           " ComCode," + 
                           " MakeCom," + 
                           " InsuredCode," + 
                           " InsuredName," + 
                           " AgentCode," + 
                           " HandlerCode," + 
                           " OperatorCode," + 
                           " Currency," + 
                           " AllocType," + 
                           " EndorType," + 
                           " Limityear," + 
                           " PassYear," + 
                           " AllocYear," + 
                           " SumFee," + 
                           " Prefee," + 
                           " AllocFee," + 
                           " ValueFee," + 
                           " AllocDate," + 
                           " InputDate," + 
                           " Olddate," + 
                           " DealFlag," + 
                           " Tcol1," + 
                           " Tcol2," + 
                           " Tcol3 From PrpJallocMid Where " +
                           " PolicyNo = ? And " + 
                           " SerialNo = ?";
        PrpJallocMidDto prpJallocMidDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,policyNo);
        dbManager.setInt(2,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpJallocMidDto = new PrpJallocMidDto();
            prpJallocMidDto.setRiskCode(dbManager.getString(resultSet,1));
            prpJallocMidDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpJallocMidDto.setAllocNo(dbManager.getString(resultSet,3));
            prpJallocMidDto.setCertiNo(dbManager.getString(resultSet,4));
            prpJallocMidDto.setSerialNo(dbManager.getInt(resultSet,5));
            prpJallocMidDto.setAllocSerialNo(dbManager.getInt(resultSet,6));
            prpJallocMidDto.setStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,7));
            prpJallocMidDto.setEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,8));
            prpJallocMidDto.setComCode(dbManager.getString(resultSet,9));
            prpJallocMidDto.setMakeCom(dbManager.getString(resultSet,10));
            prpJallocMidDto.setInsuredCode(dbManager.getString(resultSet,11));
            prpJallocMidDto.setInsuredName(dbManager.getString(resultSet,12));
            prpJallocMidDto.setAgentCode(dbManager.getString(resultSet,13));
            prpJallocMidDto.setHandlerCode(dbManager.getString(resultSet,14));
            prpJallocMidDto.setOperatorCode(dbManager.getString(resultSet,15));
            prpJallocMidDto.setCurrency(dbManager.getString(resultSet,16));
            prpJallocMidDto.setAllocType(dbManager.getString(resultSet,17));
            prpJallocMidDto.setEndorType(dbManager.getString(resultSet,18));
            prpJallocMidDto.setLimityear(dbManager.getInt(resultSet,19));
            prpJallocMidDto.setPassYear(dbManager.getInt(resultSet,20));
            prpJallocMidDto.setAllocYear(dbManager.getInt(resultSet,21));
            prpJallocMidDto.setSumFee(dbManager.getDouble(resultSet,22));
            prpJallocMidDto.setPrefee(dbManager.getDouble(resultSet,23));
            prpJallocMidDto.setAllocFee(dbManager.getDouble(resultSet,24));
            prpJallocMidDto.setValueFee(dbManager.getDouble(resultSet,25));
            prpJallocMidDto.setAllocDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,26));
            prpJallocMidDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,27));
            prpJallocMidDto.setOlddate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,28));
            prpJallocMidDto.setDealFlag(dbManager.getString(resultSet,29));
            prpJallocMidDto.setTcol1(dbManager.getString(resultSet,30));
            prpJallocMidDto.setTcol2(dbManager.getInt(resultSet,31));
            prpJallocMidDto.setTcol3(dbManager.getInt(resultSet,32));
        }
        resultSet.close();
        log.info("DBPrpJallocMidBase.findByPrimaryKey() success!");
        return prpJallocMidDto;
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
        String statement = "Select RiskCode," + 
                           " PolicyNo," + 
                           " AllocNo," + 
                           " CertiNo," + 
                           " SerialNo," + 
                           " AllocSerialNo," + 
                           " StartDate," + 
                           " EndDate," + 
                           " ComCode," + 
                           " MakeCom," + 
                           " InsuredCode," + 
                           " InsuredName," + 
                           " AgentCode," + 
                           " HandlerCode," + 
                           " OperatorCode," + 
                           " Currency," + 
                           " AllocType," + 
                           " EndorType," + 
                           " Limityear," + 
                           " PassYear," + 
                           " AllocYear," + 
                           " SumFee," + 
                           " Prefee," + 
                           " AllocFee," + 
                           " ValueFee," + 
                           " AllocDate," + 
                           " InputDate," + 
                           " Olddate," + 
                           " DealFlag," + 
                           " Tcol1," + 
                           " Tcol2," + 
                           " Tcol3 From PrpJallocMid Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpJallocMidDto prpJallocMidDto = null;
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

            prpJallocMidDto = new PrpJallocMidDto();
            prpJallocMidDto.setRiskCode(dbManager.getString(resultSet,1));
            prpJallocMidDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpJallocMidDto.setAllocNo(dbManager.getString(resultSet,3));
            prpJallocMidDto.setCertiNo(dbManager.getString(resultSet,4));
            prpJallocMidDto.setSerialNo(dbManager.getInt(resultSet,5));
            prpJallocMidDto.setAllocSerialNo(dbManager.getInt(resultSet,6));
            prpJallocMidDto.setStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,7));
            prpJallocMidDto.setEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,8));
            prpJallocMidDto.setComCode(dbManager.getString(resultSet,9));
            prpJallocMidDto.setMakeCom(dbManager.getString(resultSet,10));
            prpJallocMidDto.setInsuredCode(dbManager.getString(resultSet,11));
            prpJallocMidDto.setInsuredName(dbManager.getString(resultSet,12));
            prpJallocMidDto.setAgentCode(dbManager.getString(resultSet,13));
            prpJallocMidDto.setHandlerCode(dbManager.getString(resultSet,14));
            prpJallocMidDto.setOperatorCode(dbManager.getString(resultSet,15));
            prpJallocMidDto.setCurrency(dbManager.getString(resultSet,16));
            prpJallocMidDto.setAllocType(dbManager.getString(resultSet,17));
            prpJallocMidDto.setEndorType(dbManager.getString(resultSet,18));
            prpJallocMidDto.setLimityear(dbManager.getInt(resultSet,19));
            prpJallocMidDto.setPassYear(dbManager.getInt(resultSet,20));
            prpJallocMidDto.setAllocYear(dbManager.getInt(resultSet,21));
            prpJallocMidDto.setSumFee(dbManager.getDouble(resultSet,22));
            prpJallocMidDto.setPrefee(dbManager.getDouble(resultSet,23));
            prpJallocMidDto.setAllocFee(dbManager.getDouble(resultSet,24));
            prpJallocMidDto.setValueFee(dbManager.getDouble(resultSet,25));
            prpJallocMidDto.setAllocDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,26));
            prpJallocMidDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,27));
            prpJallocMidDto.setOlddate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,28));
            prpJallocMidDto.setDealFlag(dbManager.getString(resultSet,29));
            prpJallocMidDto.setTcol1(dbManager.getString(resultSet,30));
            prpJallocMidDto.setTcol2(dbManager.getInt(resultSet,31));
            prpJallocMidDto.setTcol3(dbManager.getInt(resultSet,32));
            collection.add(prpJallocMidDto);
        }
        resultSet.close();
        log.info("DBPrpJallocMidBase.findByConditions() success!");
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
        String statement = "Delete From PrpJallocMid Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpJallocMidBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpJallocMid Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpJallocMidBase.getCount() success!");
        return count;
    }
}
