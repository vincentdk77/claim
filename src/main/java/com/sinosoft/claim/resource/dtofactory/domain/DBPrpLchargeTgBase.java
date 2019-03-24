package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.sinosoft.claim.dto.domain.PrpLchargeDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLcharge－赔款费用信息表的数据访问对象基类<br>
 * 创建于 2006-08-04 09:20:23.400<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLchargeTgBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpLchargeTgBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLchargeTgBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLchargeDto prpLchargeDto
     * @throws Exception
     */
    public void insert(PrpLchargeDto prpLchargeDto) throws Exception{
        String mainStatement = " Insert Into PrpLchargeTg (" + 
                           " CompensateNo," + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " SerialNo," + 
                           " KindCode," + 
                           " ChargeCode," + 
                           " ChargeName," + 
                           " Currency," + 
                           " ChargeAmount," + 
                           " SumRealPay," + 
                           " ChargeReport," + 
                           " Flag," + 
                           " InputDate," + 
                           " ChangeFlag," + 
                           " PayObjectType," + 
                           " PayObjectCode," + 
                           " PayObjectName," + 
                           " itemkindno," + 
                           " preChargeAmount," + 
                           " checkDeptCode," + 
                           " checkDeptName)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLchargeDto.getCompensateNo() + "'," + 
                           "'" + prpLchargeDto.getRiskCode() + "'," + 
                           "'" + prpLchargeDto.getPolicyNo() + "'," + 
                           "" + prpLchargeDto.getSerialNo() + "," + 
                           "'" + prpLchargeDto.getKindCode() + "'," + 
                           "'" + prpLchargeDto.getChargeCode() + "'," + 
                           "'" + prpLchargeDto.getChargeName() + "'," + 
                           "'" + prpLchargeDto.getCurrency() + "'," + 
                           "'" + prpLchargeDto.getChargeAmount() + "'," + 
                           "'" + prpLchargeDto.getSumRealPay() + "'," + 
                           "'" + prpLchargeDto.getChargeReport() + "'," + 
                           "'" + prpLchargeDto.getFlag() + "'," + 
                           "'" + prpLchargeDto.getInputDate() + "'," + 
                           "'" + prpLchargeDto.getChangeFlag() + "'," + 
                           "'" + prpLchargeDto.getPayObjectType() + "'," + 
                           "'" + prpLchargeDto.getPayObjectCode() + "'," + 
                           "'" + prpLchargeDto.getPayObjectName() + "'," + 
                           "'" + prpLchargeDto.getItemkindno() + "'," + 
                           "'" + prpLchargeDto.getPreChargeAmount() + "'," + 
                           "'" + prpLchargeDto.getCheckDeptCode() + "'," + 
                           "'" + prpLchargeDto.getCheckDeptName() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLchargeDto.getCompensateNo());
        dbManager.setString(2,prpLchargeDto.getRiskCode());
        dbManager.setString(3,prpLchargeDto.getPolicyNo());
        dbManager.setInt(4,prpLchargeDto.getSerialNo());
        dbManager.setString(5,prpLchargeDto.getKindCode());
        dbManager.setString(6,prpLchargeDto.getChargeCode());
        dbManager.setString(7,prpLchargeDto.getChargeName());
        dbManager.setString(8,prpLchargeDto.getCurrency());
        dbManager.setDouble(9,prpLchargeDto.getChargeAmount());
        dbManager.setDouble(10,prpLchargeDto.getSumRealPay());
        dbManager.setDouble(11,prpLchargeDto.getChargeReport());
        dbManager.setString(12,prpLchargeDto.getFlag());
        dbManager.setDateTime(13,prpLchargeDto.getInputDate());
        dbManager.setString(14,prpLchargeDto.getChangeFlag());
        dbManager.setString(15,prpLchargeDto.getPayObjectType());
        dbManager.setString(16,prpLchargeDto.getPayObjectCode());
        dbManager.setString(17,prpLchargeDto.getPayObjectName());
        dbManager.setInt(18,prpLchargeDto.getItemkindno());
        dbManager.setDouble(19, prpLchargeDto.getPreChargeAmount());
        dbManager.setString(20,prpLchargeDto.getCheckDeptCode());
        dbManager.setString(21,prpLchargeDto.getCheckDeptName());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLchargeBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpLchargeDto prpLchargeDto = (PrpLchargeDto)i.next();
            insert(prpLchargeDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param compensateNo 赔款计算书号
     * @param serialNo 序号
     * @throws Exception
     */
    public void delete(String compensateNo,int serialNo) throws Exception{
        String statement = " Delete From PrpLchargeTg" + 
	            		   " Where " +
                           " CompensateNo = ? And " + 
                           " SerialNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLchargeTg Where " +
                           " CompensateNo = '" + compensateNo + "' And " + 
                           " SerialNo = " + serialNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,compensateNo);
        dbManager.setInt(2,serialNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLchargeBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLchargeDto prpLchargeDto
     * @throws Exception
     */
    public void update(PrpLchargeDto prpLchargeDto) throws Exception{
        String statement = " Update PrpLchargeTg Set RiskCode = ?," + 
                           " PolicyNo = ?," + 
                           " KindCode = ?," + 
                           " ChargeCode = ?," + 
                           " ChargeName = ?," + 
                           " Currency = ?," + 
                           " ChargeAmount = ?," + 
                           " SumRealPay = ?," + 
                           " ChargeReport = ?," + 
                           " Flag = ?," + 
                           " InputDate = ?," + 
                           " ChangeFlag = ?," + 
                           " PayObjectType = ?," + 
                           " PayObjectCode = ?," + 
                           " PayObjectName = ?," + 
                           " itemkindno = ?," + 
                           " preChargeAmount = ?," + 
                           " checkDeptCode = ?," + 
                           " checkDeptName = ?" + 
	            		   " Where " +
                           " CompensateNo = ? And " + 
                           " SerialNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLchargeTg Set " + 
                           " CompensateNo = '" + prpLchargeDto.getCompensateNo() + "'," + 
                           " RiskCode = '" + prpLchargeDto.getRiskCode() + "'," + 
                           " PolicyNo = '" + prpLchargeDto.getPolicyNo() + "'," + 
                           " SerialNo = " + prpLchargeDto.getSerialNo() + "," + 
                           " KindCode = '" + prpLchargeDto.getKindCode() + "'," + 
                           " ChargeCode = '" + prpLchargeDto.getChargeCode() + "'," + 
                           " ChargeName = '" + prpLchargeDto.getChargeName() + "'," + 
                           " Currency = '" + prpLchargeDto.getCurrency() + "'," + 
                           " ChargeAmount = '" + prpLchargeDto.getChargeAmount() + "'," + 
                           " SumRealPay = '" + prpLchargeDto.getSumRealPay() + "'," + 
                           " ChargeReport = '" + prpLchargeDto.getChargeReport() + "'," + 
                           " Flag = '" + prpLchargeDto.getFlag() + "'," + 
                           " InputDate = '" + prpLchargeDto.getInputDate() + "'," + 
                           " ChangeFlag = '" + prpLchargeDto.getChangeFlag() + "'," + 
                           " PayObjectType = '" + prpLchargeDto.getPayObjectType() + "'," + 
                           " PayObjectCode = '" + prpLchargeDto.getPayObjectCode() + "'," + 
                           " PayObjectName = '" + prpLchargeDto.getPayObjectName() + "'," + 
                           " itemkindno = '" + prpLchargeDto.getItemkindno() + "'," + 
                           " preChargeAmount = '" + prpLchargeDto.getPreChargeAmount() + "'," + 
                           " checkDeptCode = '" + prpLchargeDto.getCheckDeptCode() + "'," + 
                           " checkDeptName = '" + prpLchargeDto.getCheckDeptName() + "'" + 
			               " Where " +
                           " CompensateNo = '" + prpLchargeDto.getCompensateNo() + "' And " + 
                           " SerialNo = " + prpLchargeDto.getSerialNo() + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpLchargeDto.getRiskCode());
        dbManager.setString(2,prpLchargeDto.getPolicyNo());
        dbManager.setString(3,prpLchargeDto.getKindCode());
        dbManager.setString(4,prpLchargeDto.getChargeCode());
        dbManager.setString(5,prpLchargeDto.getChargeName());
        dbManager.setString(6,prpLchargeDto.getCurrency());
        dbManager.setDouble(7,prpLchargeDto.getChargeAmount());
        dbManager.setDouble(8,prpLchargeDto.getSumRealPay());
        dbManager.setDouble(9,prpLchargeDto.getChargeReport());
        dbManager.setString(10,prpLchargeDto.getFlag());
        dbManager.setDateTime(11,prpLchargeDto.getInputDate());
        dbManager.setString(12,prpLchargeDto.getChangeFlag());
        dbManager.setString(13,prpLchargeDto.getPayObjectType());
        dbManager.setString(14,prpLchargeDto.getPayObjectCode());
        dbManager.setString(15,prpLchargeDto.getPayObjectName());
        dbManager.setInt(16,prpLchargeDto.getItemkindno());
        dbManager.setDouble(17, prpLchargeDto.getPreChargeAmount());
        dbManager.setString(18,prpLchargeDto.getCheckDeptCode());
        dbManager.setString(19,prpLchargeDto.getCheckDeptName());
        //设置条件字段;
        dbManager.setString(20,prpLchargeDto.getCompensateNo());
        dbManager.setInt(21,prpLchargeDto.getSerialNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLchargeBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param compensateNo 赔款计算书号
     * @param serialNo 序号
     * @return PrpLchargeDto
     * @throws Exception
     */
    public PrpLchargeDto findByPrimaryKey(String compensateNo,int serialNo) throws Exception{
        String mainStatement = " Select CompensateNo," + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " SerialNo," + 
                           " KindCode," + 
                           " ChargeCode," + 
                           " ChargeName," + 
                           " Currency," + 
                           " ChargeAmount," + 
                           " SumRealPay," + 
                           " ChargeReport," + 
                           " Flag," + 
                           " InputDate," + 
                           " ChangeFlag," + 
                           " PayObjectType," + 
                           " PayObjectCode," + 
                           " PayObjectName," + 
                           " itemkindno," +
                           " itemkindno," +
                           " preChargeAmount," +
                           " checkDeptName  From PrpLchargeTg";
        String statement = mainStatement + " Where " +
                           " CompensateNo = ? And " + 
                           " SerialNo = ?";
        PrpLchargeDto prpLchargeDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " CompensateNo = '" + compensateNo + "' And " + 
                           " SerialNo = " + serialNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,compensateNo);
        dbManager.setInt(2,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLchargeDto = new PrpLchargeDto();
            prpLchargeDto.setCompensateNo(dbManager.getString(resultSet,1));
            prpLchargeDto.setRiskCode(dbManager.getString(resultSet,2));
            prpLchargeDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpLchargeDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpLchargeDto.setKindCode(dbManager.getString(resultSet,5));
            prpLchargeDto.setChargeCode(dbManager.getString(resultSet,6));
            prpLchargeDto.setChargeName(dbManager.getString(resultSet,7));
            prpLchargeDto.setCurrency(dbManager.getString(resultSet,8));
            prpLchargeDto.setChargeAmount(dbManager.getDouble(resultSet,9));
            prpLchargeDto.setSumRealPay(dbManager.getDouble(resultSet,10));
            prpLchargeDto.setChargeReport(dbManager.getDouble(resultSet,11));
            prpLchargeDto.setFlag(dbManager.getString(resultSet,12));
            prpLchargeDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,13));
            prpLchargeDto.setChangeFlag(dbManager.getString(resultSet,14));
            prpLchargeDto.setPayObjectType(dbManager.getString(resultSet,15));
            prpLchargeDto.setPayObjectCode(dbManager.getString(resultSet,16));
            prpLchargeDto.setPayObjectName(dbManager.getString(resultSet,17));
            prpLchargeDto.setItemkindno(dbManager.getInt(resultSet,18));
            prpLchargeDto.setPreChargeAmount(dbManager.getDouble(resultSet, 19));
            prpLchargeDto.setCheckDeptCode(dbManager.getString(resultSet,20));
            prpLchargeDto.setCheckDeptName(dbManager.getString(resultSet,21));
        }
        resultSet.close();
        logger.info("DBPrpLchargeBase.findByPrimaryKey() success!");
        return prpLchargeDto;
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
        String statement = "Select CompensateNo," + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " SerialNo," + 
                           " KindCode," + 
                           " ChargeCode," + 
                           " ChargeName," + 
                           " Currency," + 
                           " ChargeAmount," + 
                           " SumRealPay," + 
                           " ChargeReport," + 
                           " Flag," + 
                           " InputDate," + 
                           " ChangeFlag," + 
                           " PayObjectType," + 
                           " PayObjectCode," + 
                           " PayObjectName," + 
                           " itemkindno," +
                           " preChargeAmount," +
                           " checkDeptCode," +
                           " checkDeptName From PrpLchargeTg Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLchargeDto prpLchargeDto = null;
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

            prpLchargeDto = new PrpLchargeDto();
            prpLchargeDto.setCompensateNo(dbManager.getString(resultSet,1));
            prpLchargeDto.setRiskCode(dbManager.getString(resultSet,2));
            prpLchargeDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpLchargeDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpLchargeDto.setKindCode(dbManager.getString(resultSet,5));
            prpLchargeDto.setChargeCode(dbManager.getString(resultSet,6));
            prpLchargeDto.setChargeName(dbManager.getString(resultSet,7));
            prpLchargeDto.setCurrency(dbManager.getString(resultSet,8));
            prpLchargeDto.setChargeAmount(dbManager.getDouble(resultSet,9));
            prpLchargeDto.setSumRealPay(dbManager.getDouble(resultSet,10));
            prpLchargeDto.setChargeReport(dbManager.getDouble(resultSet,11));
            prpLchargeDto.setFlag(dbManager.getString(resultSet,12));
            prpLchargeDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,13));
            prpLchargeDto.setChangeFlag(dbManager.getString(resultSet,14));
            prpLchargeDto.setPayObjectType(dbManager.getString(resultSet,15));
            prpLchargeDto.setPayObjectCode(dbManager.getString(resultSet,16));
            prpLchargeDto.setPayObjectName(dbManager.getString(resultSet,17));
            prpLchargeDto.setItemkindno(dbManager.getInt(resultSet,18));
            prpLchargeDto.setPreChargeAmount(dbManager.getDouble(resultSet, 19));
            prpLchargeDto.setCheckDeptCode(dbManager.getString(resultSet,20));
            prpLchargeDto.setCheckDeptName(dbManager.getString(resultSet,21));
            collection.add(prpLchargeDto);
        }
        resultSet.close();
        logger.info("DBPrpLchargeBase.findByConditions() success!");
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
        String statement = "Delete From PrpLchargeTg Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLchargeBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLchargeTg Where " + conditions;
        statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLchargeBase.getCount() success!");
        return count;
    }
    
    public int getMaxSerialNo(String conditions) 
    throws Exception{
    int count = -1;
    String statement = "Select max(SerialNo) from PrpLchargeTg Where " + conditions;
    statement = SqlUtils.getWherePartForGetCount(statement);
    logger.debug(statement);
    ResultSet resultSet = dbManager.executeQuery(statement);
    resultSet.next();
    count = dbManager.getInt(resultSet,1);
    resultSet.close();
    logger.info("DBPrpLchargeBase.getCount() success!");
    return count;
}
}
