package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLextDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLext的数据访问对象基类<br>
 * 创建于 JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLextBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpLextBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLextBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLextDto prpLextDto
     * @throws Exception
     */
    public void insert(PrpLextDto prpLextDto) throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLext (");
        buffer.append("CertiNo,");
        buffer.append("CertiType,");
        buffer.append("PersonDeathB,");
        buffer.append("PersonDeathD1,");
        buffer.append("PersonInjureB,");
        buffer.append("PersonInjureD1,");
        buffer.append("Carrier,");
        buffer.append("SailStartDate,");
        buffer.append("UnloadDate,");
        buffer.append("AppliCheckDate,");
        buffer.append("AppliPhone,");
        buffer.append("InsuredPhone,");
        buffer.append("CargoLossCheckCom,");
        buffer.append("CargoLossType,");
        buffer.append("ShareClaimer,");
        buffer.append("Salvor,");
        buffer.append("GuaranteeFlag,");
        buffer.append("Currency,");
        buffer.append("CargoValue,");
        buffer.append("SalvaGuarantAmount,");
        buffer.append("RestQuantity,");
        buffer.append("Guarantor,");
        buffer.append("Value1,");
        buffer.append("Value2,");
        buffer.append("Value3,");
        buffer.append("Remark,");
        buffer.append("Flag ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer);
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLextDto.getCertiNo()).append("',");
            debugBuffer.append("'").append(prpLextDto.getCertiType()).append("',");
            debugBuffer.append("").append(prpLextDto.getPersonDeathB()).append(",");
            debugBuffer.append("").append(prpLextDto.getPersonDeathD1()).append(",");
            debugBuffer.append("").append(prpLextDto.getPersonInjureB()).append(",");
            debugBuffer.append("").append(prpLextDto.getPersonInjureD1()).append(",");
            debugBuffer.append("'").append(prpLextDto.getCarrier()).append("',");
            debugBuffer.append("'").append(prpLextDto.getSailStartDate()).append("',");
            debugBuffer.append("'").append(prpLextDto.getUnloadDate()).append("',");
            debugBuffer.append("'").append(prpLextDto.getAppliCheckDate()).append("',");
            debugBuffer.append("").append(prpLextDto.getAppliPhone()).append(",");
            debugBuffer.append("").append(prpLextDto.getInsuredPhone()).append(",");
            debugBuffer.append("'").append(prpLextDto.getCargoLossCheckCom()).append("',");
            debugBuffer.append("'").append(prpLextDto.getCargoLossType()).append("',");
            debugBuffer.append("'").append(prpLextDto.getShareClaimer()).append("',");
            debugBuffer.append("'").append(prpLextDto.getSalvor()).append("',");
            debugBuffer.append("'").append(prpLextDto.getGuaranteeFlag()).append("',");
            debugBuffer.append("'").append(prpLextDto.getCurrency()).append("',");
            debugBuffer.append("").append(prpLextDto.getCargoValue()).append(",");
            debugBuffer.append("").append(prpLextDto.getSalvaGuarantAmount()).append(",");
            debugBuffer.append("").append(prpLextDto.getRestQuantity()).append(",");
            debugBuffer.append("'").append(prpLextDto.getGuarantor()).append("',");
            debugBuffer.append("'").append(prpLextDto.getValue1()).append("',");
            debugBuffer.append("'").append(prpLextDto.getValue2()).append("',");
            debugBuffer.append("'").append(prpLextDto.getValue3()).append("',");
            debugBuffer.append("'").append(prpLextDto.getRemark()).append("',");
            debugBuffer.append("'").append(prpLextDto.getFlag()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLextDto.getCertiNo());
        dbManager.setString(2,prpLextDto.getCertiType());
        dbManager.setLong(3,prpLextDto.getPersonDeathB());
        dbManager.setLong(4,prpLextDto.getPersonDeathD1());
        dbManager.setLong(5,prpLextDto.getPersonInjureB());
        dbManager.setLong(6,prpLextDto.getPersonInjureD1());
        dbManager.setString(7,prpLextDto.getCarrier());
        dbManager.setDateTime(8,prpLextDto.getSailStartDate());
        dbManager.setDateTime(9,prpLextDto.getUnloadDate());
        dbManager.setDateTime(10,prpLextDto.getAppliCheckDate());
        dbManager.setString(11,prpLextDto.getAppliPhone());
        dbManager.setString(12,prpLextDto.getInsuredPhone());
        dbManager.setString(13,prpLextDto.getCargoLossCheckCom());
        dbManager.setString(14,prpLextDto.getCargoLossType());
        dbManager.setString(15,prpLextDto.getShareClaimer());
        dbManager.setString(16,prpLextDto.getSalvor());
        dbManager.setString(17,prpLextDto.getGuaranteeFlag());
        dbManager.setString(18,prpLextDto.getCurrency());
        dbManager.setDouble(19,prpLextDto.getCargoValue());
        dbManager.setDouble(20,prpLextDto.getSalvaGuarantAmount());
        dbManager.setInt(21,prpLextDto.getRestQuantity());
        dbManager.setString(22,prpLextDto.getGuarantor());
        dbManager.setString(23,prpLextDto.getValue1());
        dbManager.setString(24,prpLextDto.getValue2());
        dbManager.setString(25,prpLextDto.getValue3());
        dbManager.setString(26,prpLextDto.getRemark());
        dbManager.setString(27,prpLextDto.getFlag());
        dbManager.executePreparedUpdate();

    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLext (");
        buffer.append("CertiNo,");
        buffer.append("CertiType,");
        buffer.append("PersonDeathB,");
        buffer.append("PersonDeathD1,");
        buffer.append("PersonInjureB,");
        buffer.append("PersonInjureD1,");
        buffer.append("Carrier,");
        buffer.append("SailStartDate,");
        buffer.append("UnloadDate,");
        buffer.append("AppliCheckDate,");
        buffer.append("AppliPhone,");
        buffer.append("InsuredPhone,");
        buffer.append("CargoLossCheckCom,");
        buffer.append("CargoLossType,");
        buffer.append("ShareClaimer,");
        buffer.append("Salvor,");
        buffer.append("GuaranteeFlag,");
        buffer.append("Currency,");
        buffer.append("CargoValue,");
        buffer.append("SalvaGuarantAmount,");
        buffer.append("RestQuantity,");
        buffer.append("Guarantor,");
        buffer.append("Value1,");
        buffer.append("Value2,");
        buffer.append("Value3,");
        buffer.append("Remark,");
        buffer.append("Flag ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLextDto prpLextDto = (PrpLextDto)i.next();
            dbManager.setString(1,prpLextDto.getCertiNo());
            dbManager.setString(2,prpLextDto.getCertiType());
            dbManager.setLong(3,prpLextDto.getPersonDeathB());
            dbManager.setLong(4,prpLextDto.getPersonDeathD1());
            dbManager.setLong(5,prpLextDto.getPersonInjureB());
            dbManager.setLong(6,prpLextDto.getPersonInjureD1());
            dbManager.setString(7,prpLextDto.getCarrier());
            dbManager.setDateTime(8,prpLextDto.getSailStartDate());
            dbManager.setDateTime(9,prpLextDto.getUnloadDate());
            dbManager.setDateTime(10,prpLextDto.getAppliCheckDate());
            dbManager.setString(11,prpLextDto.getAppliPhone());
            dbManager.setString(12,prpLextDto.getInsuredPhone());
            dbManager.setString(13,prpLextDto.getCargoLossCheckCom());
            dbManager.setString(14,prpLextDto.getCargoLossType());
            dbManager.setString(15,prpLextDto.getShareClaimer());
            dbManager.setString(16,prpLextDto.getSalvor());
            dbManager.setString(17,prpLextDto.getGuaranteeFlag());
            dbManager.setString(18,prpLextDto.getCurrency());
            dbManager.setDouble(19,prpLextDto.getCargoValue());
            dbManager.setDouble(20,prpLextDto.getSalvaGuarantAmount());
            dbManager.setInt(21,prpLextDto.getRestQuantity());
            dbManager.setString(22,prpLextDto.getGuarantor());
            dbManager.setString(23,prpLextDto.getValue1());
            dbManager.setString(24,prpLextDto.getValue2());
            dbManager.setString(25,prpLextDto.getValue3());
            dbManager.setString(26,prpLextDto.getRemark());
            dbManager.setString(27,prpLextDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param certiNo 单号
     * @param certiType 单号类型
     * @throws Exception
     */
    public void delete(String certiNo,String certiType) throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLext ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer);
            debugBuffer.append("WHERE ");
            debugBuffer.append("CertiNo=").append("'").append(certiNo).append("' AND ");
            debugBuffer.append("CertiType=").append("'").append(certiType).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("CertiNo = ? And ");
        buffer.append("CertiType = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,certiNo);
        dbManager.setString(2,certiType);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLextDto prpLextDto
     * @throws Exception
     */
    public void update(PrpLextDto prpLextDto) throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLext SET ");
        buffer.append("PersonDeathB = ?, ");
        buffer.append("PersonDeathD1 = ?, ");
        buffer.append("PersonInjureB = ?, ");
        buffer.append("PersonInjureD1 = ?, ");
        buffer.append("Carrier = ?, ");
        buffer.append("SailStartDate = ?, ");
        buffer.append("UnloadDate = ?, ");
        buffer.append("AppliCheckDate = ?, ");
        buffer.append("AppliPhone = ?, ");
        buffer.append("InsuredPhone = ?, ");
        buffer.append("CargoLossCheckCom = ?, ");
        buffer.append("CargoLossType = ?, ");
        buffer.append("ShareClaimer = ?, ");
        buffer.append("Salvor = ?, ");
        buffer.append("GuaranteeFlag = ?, ");
        buffer.append("Currency = ?, ");
        buffer.append("CargoValue = ?, ");
        buffer.append("SalvaGuarantAmount = ?, ");
        buffer.append("RestQuantity = ?, ");
        buffer.append("Guarantor = ?, ");
        buffer.append("Value1 = ?, ");
        buffer.append("Value2 = ?, ");
        buffer.append("Value3 = ?, ");
        buffer.append("Remark = ?, ");
        buffer.append("Flag = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer);
            debugBuffer.append("WHERE ");
            debugBuffer.append("CertiNo=").append("'").append(prpLextDto.getCertiNo()).append("' AND ");
            debugBuffer.append("CertiType=").append("'").append(prpLextDto.getCertiType()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("CertiNo = ? And ");
        buffer.append("CertiType = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setLong(1,prpLextDto.getPersonDeathB());
        dbManager.setLong(2,prpLextDto.getPersonDeathD1());
        dbManager.setLong(3,prpLextDto.getPersonInjureB());
        dbManager.setLong(4,prpLextDto.getPersonInjureD1());
        dbManager.setString(5,prpLextDto.getCarrier());
        dbManager.setDateTime(6,prpLextDto.getSailStartDate());
        dbManager.setDateTime(7,prpLextDto.getUnloadDate());
        dbManager.setDateTime(8,prpLextDto.getAppliCheckDate());
        dbManager.setString(9,prpLextDto.getAppliPhone());
        dbManager.setString(10,prpLextDto.getInsuredPhone());
        dbManager.setString(11,prpLextDto.getCargoLossCheckCom());
        dbManager.setString(12,prpLextDto.getCargoLossType());
        dbManager.setString(13,prpLextDto.getShareClaimer());
        dbManager.setString(14,prpLextDto.getSalvor());
        dbManager.setString(15,prpLextDto.getGuaranteeFlag());
        dbManager.setString(16,prpLextDto.getCurrency());
        dbManager.setDouble(17,prpLextDto.getCargoValue());
        dbManager.setDouble(18,prpLextDto.getSalvaGuarantAmount());
        dbManager.setInt(19,prpLextDto.getRestQuantity());
        dbManager.setString(20,prpLextDto.getGuarantor());
        dbManager.setString(21,prpLextDto.getValue1());
        dbManager.setString(22,prpLextDto.getValue2());
        dbManager.setString(23,prpLextDto.getValue3());
        dbManager.setString(24,prpLextDto.getRemark());
        dbManager.setString(25,prpLextDto.getFlag());
        //设置条件字段;
        dbManager.setString(26,prpLextDto.getCertiNo());
        dbManager.setString(27,prpLextDto.getCertiType());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param certiNo 单号
     * @param certiType 单号类型
     * @return PrpLextDto
     * @throws Exception
     */
    public PrpLextDto findByPrimaryKey(String certiNo,String certiType) throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("CertiNo,");
        buffer.append("CertiType,");
        buffer.append("PersonDeathB,");
        buffer.append("PersonDeathD1,");
        buffer.append("PersonInjureB,");
        buffer.append("PersonInjureD1,");
        buffer.append("Carrier,");
        buffer.append("SailStartDate,");
        buffer.append("UnloadDate,");
        buffer.append("AppliCheckDate,");
        buffer.append("AppliPhone,");
        buffer.append("InsuredPhone,");
        buffer.append("CargoLossCheckCom,");
        buffer.append("CargoLossType,");
        buffer.append("ShareClaimer,");
        buffer.append("Salvor,");
        buffer.append("GuaranteeFlag,");
        buffer.append("Currency,");
        buffer.append("CargoValue,");
        buffer.append("SalvaGuarantAmount,");
        buffer.append("RestQuantity,");
        buffer.append("Guarantor,");
        buffer.append("Value1,");
        buffer.append("Value2,");
        buffer.append("Value3,");
        buffer.append("Remark,");
        buffer.append("Flag ");
        buffer.append("FROM PrpLext ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer);
            debugBuffer.append("WHERE ");
            debugBuffer.append("CertiNo=").append("'").append(certiNo).append("' AND ");
            debugBuffer.append("CertiType=").append("'").append(certiType).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("CertiNo = ? And ");
        buffer.append("CertiType = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,certiNo);
        dbManager.setString(2,certiType);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLextDto prpLextDto = null;
        if(resultSet.next()){
            prpLextDto = new PrpLextDto();
            prpLextDto.setCertiNo(dbManager.getString(resultSet,1));
            prpLextDto.setCertiType(dbManager.getString(resultSet,2));
            prpLextDto.setPersonDeathB(dbManager.getLong(resultSet,3));
            prpLextDto.setPersonDeathD1(dbManager.getLong(resultSet,4));
            prpLextDto.setPersonInjureB(dbManager.getLong(resultSet,5));
            prpLextDto.setPersonInjureD1(dbManager.getLong(resultSet,6));
            prpLextDto.setCarrier(dbManager.getString(resultSet,7));
            prpLextDto.setSailStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,8));
            prpLextDto.setUnloadDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,9));
            prpLextDto.setAppliCheckDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,10));
            prpLextDto.setAppliPhone(dbManager.getString(resultSet,11));
            prpLextDto.setInsuredPhone(dbManager.getString(resultSet,12));
            prpLextDto.setCargoLossCheckCom(dbManager.getString(resultSet,13));
            prpLextDto.setCargoLossType(dbManager.getString(resultSet,14));
            prpLextDto.setShareClaimer(dbManager.getString(resultSet,15));
            prpLextDto.setSalvor(dbManager.getString(resultSet,16));
            prpLextDto.setGuaranteeFlag(dbManager.getString(resultSet,17));
            prpLextDto.setCurrency(dbManager.getString(resultSet,18));
            prpLextDto.setCargoValue(dbManager.getDouble(resultSet,19));
            prpLextDto.setSalvaGuarantAmount(dbManager.getDouble(resultSet,20));
            prpLextDto.setRestQuantity(dbManager.getInt(resultSet,21));
            prpLextDto.setGuarantor(dbManager.getString(resultSet,22));
            prpLextDto.setValue1(dbManager.getString(resultSet,23));
            prpLextDto.setValue2(dbManager.getString(resultSet,24));
            prpLextDto.setValue3(dbManager.getString(resultSet,25));
            prpLextDto.setRemark(dbManager.getString(resultSet,26));
            prpLextDto.setFlag(dbManager.getString(resultSet,27));
        }else{
            logger.info("DBPrpLextBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLextDto;
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
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("CertiNo,");
        buffer.append("CertiType,");
        buffer.append("PersonDeathB,");
        buffer.append("PersonDeathD1,");
        buffer.append("PersonInjureB,");
        buffer.append("PersonInjureD1,");
        buffer.append("Carrier,");
        buffer.append("SailStartDate,");
        buffer.append("UnloadDate,");
        buffer.append("AppliCheckDate,");
        buffer.append("AppliPhone,");
        buffer.append("InsuredPhone,");
        buffer.append("CargoLossCheckCom,");
        buffer.append("CargoLossType,");
        buffer.append("ShareClaimer,");
        buffer.append("Salvor,");
        buffer.append("GuaranteeFlag,");
        buffer.append("Currency,");
        buffer.append("CargoValue,");
        buffer.append("SalvaGuarantAmount,");
        buffer.append("RestQuantity,");
        buffer.append("Guarantor,");
        buffer.append("Value1,");
        buffer.append("Value2,");
        buffer.append("Value3,");
        buffer.append("Remark,");
        buffer.append("Flag ");
        buffer.append("FROM PrpLext WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        int count=0;
        if(pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        //定义返回结果集合
        Collection collection = new ArrayList(rowsPerPage);
        PrpLextDto prpLextDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                	break;
                }
            }

            prpLextDto = new PrpLextDto();
            prpLextDto.setCertiNo(dbManager.getString(resultSet,1));
            prpLextDto.setCertiType(dbManager.getString(resultSet,2));
            prpLextDto.setPersonDeathB(dbManager.getLong(resultSet,3));
            prpLextDto.setPersonDeathD1(dbManager.getLong(resultSet,4));
            prpLextDto.setPersonInjureB(dbManager.getLong(resultSet,5));
            prpLextDto.setPersonInjureD1(dbManager.getLong(resultSet,6));
            prpLextDto.setCarrier(dbManager.getString(resultSet,7));
            prpLextDto.setSailStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,8));
            prpLextDto.setUnloadDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,9));
            prpLextDto.setAppliCheckDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,10));
            prpLextDto.setAppliPhone(dbManager.getString(resultSet,11));
            prpLextDto.setInsuredPhone(dbManager.getString(resultSet,12));
            prpLextDto.setCargoLossCheckCom(dbManager.getString(resultSet,13));
            prpLextDto.setCargoLossType(dbManager.getString(resultSet,14));
            prpLextDto.setShareClaimer(dbManager.getString(resultSet,15));
            prpLextDto.setSalvor(dbManager.getString(resultSet,16));
            prpLextDto.setGuaranteeFlag(dbManager.getString(resultSet,17));
            prpLextDto.setCurrency(dbManager.getString(resultSet,18));
            prpLextDto.setCargoValue(dbManager.getDouble(resultSet,19));
            prpLextDto.setSalvaGuarantAmount(dbManager.getDouble(resultSet,20));
            prpLextDto.setRestQuantity(dbManager.getInt(resultSet,21));
            prpLextDto.setGuarantor(dbManager.getString(resultSet,22));
            prpLextDto.setValue1(dbManager.getString(resultSet,23));
            prpLextDto.setValue2(dbManager.getString(resultSet,24));
            prpLextDto.setValue3(dbManager.getString(resultSet,25));
            prpLextDto.setRemark(dbManager.getString(resultSet,26));
            prpLextDto.setFlag(dbManager.getString(resultSet,27));
            collection.add(prpLextDto);
        }
        resultSet.close();
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
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLext WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        int count = dbManager.executeUpdate(buffer.toString());
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
        StringBuffer buffer = new StringBuffer(100);
  String statement ;
  statement = "SELECT count(1) FROM PrpLext WHERE ";
   statement = SqlUtils.getWherePartForGetCount(statement);
        buffer.append(statement);
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        return count;
    }
}
