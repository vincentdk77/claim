package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpPcoinsDetailDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpPcoinsDetail的数据访问对象基类<br>
 * 创建于 2013-09-09 20:19:13.312<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpPcoinsDetailBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrpPcoinsDetailBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpPcoinsDetailBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpPcoinsDetailDto prpPcoinsDetailDto
     * @throws Exception
     */
    public void insert(PrpPcoinsDetailDto prpPcoinsDetailDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpPcoinsDetail (");
        buffer.append("endorseNo,");
        buffer.append("policyNo,");
        buffer.append("serialNo,");
        buffer.append("coinsCode,");
        buffer.append("coinsName,");
        buffer.append("currency,");
        buffer.append("coinsAmount,");
        buffer.append("coinsPremium,");
        buffer.append("agentFee,");
        buffer.append("operateFee,");
        buffer.append("chgCoinsAmount,");
        buffer.append("chgCoinsPremium,");
        buffer.append("chgAgentFee,");
        buffer.append("chgOperateFee,");
        buffer.append("middleCostFee,");
        buffer.append("chgMiddleCostFee,");
        buffer.append("flag ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpPcoinsDetailDto.getEndorseNo()).append("',");
            debugBuffer.append("'").append(prpPcoinsDetailDto.getPolicyNo()).append("',");
            debugBuffer.append("").append(prpPcoinsDetailDto.getSerialNo()).append(",");
            debugBuffer.append("'").append(prpPcoinsDetailDto.getCoinsCode()).append("',");
            debugBuffer.append("'").append(prpPcoinsDetailDto.getCoinsName()).append("',");
            debugBuffer.append("'").append(prpPcoinsDetailDto.getCurrency()).append("',");
            debugBuffer.append("").append(prpPcoinsDetailDto.getCoinsAmount()).append(",");
            debugBuffer.append("").append(prpPcoinsDetailDto.getCoinsPremium()).append(",");
            debugBuffer.append("").append(prpPcoinsDetailDto.getAgentFee()).append(",");
            debugBuffer.append("").append(prpPcoinsDetailDto.getOperateFee()).append(",");
            debugBuffer.append("").append(prpPcoinsDetailDto.getChgCoinsAmount()).append(",");
            debugBuffer.append("").append(prpPcoinsDetailDto.getChgCoinsPremium()).append(",");
            debugBuffer.append("").append(prpPcoinsDetailDto.getChgAgentFee()).append(",");
            debugBuffer.append("").append(prpPcoinsDetailDto.getChgOperateFee()).append(",");
            debugBuffer.append("").append(prpPcoinsDetailDto.getMiddleCostFee()).append(",");
            debugBuffer.append("").append(prpPcoinsDetailDto.getChgMiddleCostFee()).append(",");
            debugBuffer.append("'").append(prpPcoinsDetailDto.getFlag()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpPcoinsDetailDto.getEndorseNo());
        dbManager.setString(2,prpPcoinsDetailDto.getPolicyNo());
        dbManager.setLong(3,prpPcoinsDetailDto.getSerialNo());
        dbManager.setString(4,prpPcoinsDetailDto.getCoinsCode());
        dbManager.setString(5,prpPcoinsDetailDto.getCoinsName());
        dbManager.setString(6,prpPcoinsDetailDto.getCurrency());
        dbManager.setDouble(7,prpPcoinsDetailDto.getCoinsAmount());
        dbManager.setDouble(8,prpPcoinsDetailDto.getCoinsPremium());
        dbManager.setDouble(9,prpPcoinsDetailDto.getAgentFee());
        dbManager.setDouble(10,prpPcoinsDetailDto.getOperateFee());
        dbManager.setDouble(11,prpPcoinsDetailDto.getChgCoinsAmount());
        dbManager.setDouble(12,prpPcoinsDetailDto.getChgCoinsPremium());
        dbManager.setDouble(13,prpPcoinsDetailDto.getChgAgentFee());
        dbManager.setDouble(14,prpPcoinsDetailDto.getChgOperateFee());
        dbManager.setDouble(15,prpPcoinsDetailDto.getMiddleCostFee());
        dbManager.setDouble(16,prpPcoinsDetailDto.getChgMiddleCostFee());
        dbManager.setString(17,prpPcoinsDetailDto.getFlag());
        dbManager.executePreparedUpdate();

    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpPcoinsDetail (");
        buffer.append("endorseNo,");
        buffer.append("policyNo,");
        buffer.append("serialNo,");
        buffer.append("coinsCode,");
        buffer.append("coinsName,");
        buffer.append("currency,");
        buffer.append("coinsAmount,");
        buffer.append("coinsPremium,");
        buffer.append("agentFee,");
        buffer.append("operateFee,");
        buffer.append("chgCoinsAmount,");
        buffer.append("chgCoinsPremium,");
        buffer.append("chgAgentFee,");
        buffer.append("chgOperateFee,");
        buffer.append("middleCostFee,");
        buffer.append("chgMiddleCostFee,");
        buffer.append("flag ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpPcoinsDetailDto prpPcoinsDetailDto = (PrpPcoinsDetailDto)i.next();
            dbManager.setString(1,prpPcoinsDetailDto.getEndorseNo());
            dbManager.setString(2,prpPcoinsDetailDto.getPolicyNo());
            dbManager.setLong(3,prpPcoinsDetailDto.getSerialNo());
            dbManager.setString(4,prpPcoinsDetailDto.getCoinsCode());
            dbManager.setString(5,prpPcoinsDetailDto.getCoinsName());
            dbManager.setString(6,prpPcoinsDetailDto.getCurrency());
            dbManager.setDouble(7,prpPcoinsDetailDto.getCoinsAmount());
            dbManager.setDouble(8,prpPcoinsDetailDto.getCoinsPremium());
            dbManager.setDouble(9,prpPcoinsDetailDto.getAgentFee());
            dbManager.setDouble(10,prpPcoinsDetailDto.getOperateFee());
            dbManager.setDouble(11,prpPcoinsDetailDto.getChgCoinsAmount());
            dbManager.setDouble(12,prpPcoinsDetailDto.getChgCoinsPremium());
            dbManager.setDouble(13,prpPcoinsDetailDto.getChgAgentFee());
            dbManager.setDouble(14,prpPcoinsDetailDto.getChgOperateFee());
            dbManager.setDouble(15,prpPcoinsDetailDto.getMiddleCostFee());
            dbManager.setDouble(16,prpPcoinsDetailDto.getChgMiddleCostFee());
            dbManager.setString(17,prpPcoinsDetailDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param endorseNo endorseNo
     * @param serialNo serialNo
     * @param currency currency
     * @throws Exception
     */
    public void delete(String endorseNo,long serialNo,String currency)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpPcoinsDetail ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("endorseNo=").append("'").append(endorseNo).append("' AND ");
            debugBuffer.append("serialNo=").append("").append(serialNo).append(" AND ");
            debugBuffer.append("currency=").append("'").append(currency).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("endorseNo = ? And ");
        buffer.append("serialNo = ? And ");
        buffer.append("currency = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,endorseNo);
        dbManager.setLong(2,serialNo);
        dbManager.setString(3,currency);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpPcoinsDetailDto prpPcoinsDetailDto
     * @throws Exception
     */
    public void update(PrpPcoinsDetailDto prpPcoinsDetailDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpPcoinsDetail SET ");
        buffer.append("policyNo = ?, ");
        buffer.append("coinsCode = ?, ");
        buffer.append("coinsName = ?, ");
        buffer.append("coinsAmount = ?, ");
        buffer.append("coinsPremium = ?, ");
        buffer.append("agentFee = ?, ");
        buffer.append("operateFee = ?, ");
        buffer.append("chgCoinsAmount = ?, ");
        buffer.append("chgCoinsPremium = ?, ");
        buffer.append("chgAgentFee = ?, ");
        buffer.append("chgOperateFee = ?, ");
        buffer.append("middleCostFee = ?, ");
        buffer.append("chgMiddleCostFee = ?, ");
        buffer.append("flag = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpPcoinsDetail SET ");
            debugBuffer.append("policyNo = '" + prpPcoinsDetailDto.getPolicyNo() + "', ");
            debugBuffer.append("coinsCode = '" + prpPcoinsDetailDto.getCoinsCode() + "', ");
            debugBuffer.append("coinsName = '" + prpPcoinsDetailDto.getCoinsName() + "', ");
            debugBuffer.append("coinsAmount = " + prpPcoinsDetailDto.getCoinsAmount() + ", ");
            debugBuffer.append("coinsPremium = " + prpPcoinsDetailDto.getCoinsPremium() + ", ");
            debugBuffer.append("agentFee = " + prpPcoinsDetailDto.getAgentFee() + ", ");
            debugBuffer.append("operateFee = " + prpPcoinsDetailDto.getOperateFee() + ", ");
            debugBuffer.append("chgCoinsAmount = " + prpPcoinsDetailDto.getChgCoinsAmount() + ", ");
            debugBuffer.append("chgCoinsPremium = " + prpPcoinsDetailDto.getChgCoinsPremium() + ", ");
            debugBuffer.append("chgAgentFee = " + prpPcoinsDetailDto.getChgAgentFee() + ", ");
            debugBuffer.append("chgOperateFee = " + prpPcoinsDetailDto.getChgOperateFee() + ", ");
            debugBuffer.append("middleCostFee = " + prpPcoinsDetailDto.getMiddleCostFee() + ", ");
            debugBuffer.append("chgMiddleCostFee = " + prpPcoinsDetailDto.getChgMiddleCostFee() + ", ");
            debugBuffer.append("flag = '" + prpPcoinsDetailDto.getFlag() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("endorseNo=").append("'").append(prpPcoinsDetailDto.getEndorseNo()).append("' AND ");
            debugBuffer.append("serialNo=").append("").append(prpPcoinsDetailDto.getSerialNo()).append(" AND ");
            debugBuffer.append("currency=").append("'").append(prpPcoinsDetailDto.getCurrency()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("endorseNo = ? And ");
        buffer.append("serialNo = ? And ");
        buffer.append("currency = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prpPcoinsDetailDto.getPolicyNo());
        dbManager.setString(2,prpPcoinsDetailDto.getCoinsCode());
        dbManager.setString(3,prpPcoinsDetailDto.getCoinsName());
        dbManager.setDouble(4,prpPcoinsDetailDto.getCoinsAmount());
        dbManager.setDouble(5,prpPcoinsDetailDto.getCoinsPremium());
        dbManager.setDouble(6,prpPcoinsDetailDto.getAgentFee());
        dbManager.setDouble(7,prpPcoinsDetailDto.getOperateFee());
        dbManager.setDouble(8,prpPcoinsDetailDto.getChgCoinsAmount());
        dbManager.setDouble(9,prpPcoinsDetailDto.getChgCoinsPremium());
        dbManager.setDouble(10,prpPcoinsDetailDto.getChgAgentFee());
        dbManager.setDouble(11,prpPcoinsDetailDto.getChgOperateFee());
        dbManager.setDouble(12,prpPcoinsDetailDto.getMiddleCostFee());
        dbManager.setDouble(13,prpPcoinsDetailDto.getChgMiddleCostFee());
        dbManager.setString(14,prpPcoinsDetailDto.getFlag());
        //设置条件字段;
        dbManager.setString(15,prpPcoinsDetailDto.getEndorseNo());
        dbManager.setLong(16,prpPcoinsDetailDto.getSerialNo());
        dbManager.setString(17,prpPcoinsDetailDto.getCurrency());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param endorseNo endorseNo
     * @param serialNo serialNo
     * @param currency currency
     * @return PrpPcoinsDetailDto
     * @throws Exception
     */
    public PrpPcoinsDetailDto findByPrimaryKey(String endorseNo,long serialNo,String currency)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("endorseNo,");
        buffer.append("policyNo,");
        buffer.append("serialNo,");
        buffer.append("coinsCode,");
        buffer.append("coinsName,");
        buffer.append("currency,");
        buffer.append("coinsAmount,");
        buffer.append("coinsPremium,");
        buffer.append("agentFee,");
        buffer.append("operateFee,");
        buffer.append("chgCoinsAmount,");
        buffer.append("chgCoinsPremium,");
        buffer.append("chgAgentFee,");
        buffer.append("chgOperateFee,");
        buffer.append("middleCostFee,");
        buffer.append("chgMiddleCostFee,");
        buffer.append("flag ");
        buffer.append("FROM PrpPcoinsDetail ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("endorseNo=").append("'").append(endorseNo).append("' AND ");
            debugBuffer.append("serialNo=").append("").append(serialNo).append(" AND ");
            debugBuffer.append("currency=").append("'").append(currency).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("endorseNo = ? And ");
        buffer.append("serialNo = ? And ");
        buffer.append("currency = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,endorseNo);
        dbManager.setLong(2,serialNo);
        dbManager.setString(3,currency);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpPcoinsDetailDto prpPcoinsDetailDto = null;
        if(resultSet.next()){
            prpPcoinsDetailDto = new PrpPcoinsDetailDto();
            prpPcoinsDetailDto.setEndorseNo(dbManager.getString(resultSet,1));
            prpPcoinsDetailDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpPcoinsDetailDto.setSerialNo(dbManager.getLong(resultSet,3));
            prpPcoinsDetailDto.setCoinsCode(dbManager.getString(resultSet,4));
            prpPcoinsDetailDto.setCoinsName(dbManager.getString(resultSet,5));
            prpPcoinsDetailDto.setCurrency(dbManager.getString(resultSet,6));
            prpPcoinsDetailDto.setCoinsAmount(dbManager.getDouble(resultSet,7));
            prpPcoinsDetailDto.setCoinsPremium(dbManager.getDouble(resultSet,8));
            prpPcoinsDetailDto.setAgentFee(dbManager.getDouble(resultSet,9));
            prpPcoinsDetailDto.setOperateFee(dbManager.getDouble(resultSet,10));
            prpPcoinsDetailDto.setChgCoinsAmount(dbManager.getDouble(resultSet,11));
            prpPcoinsDetailDto.setChgCoinsPremium(dbManager.getDouble(resultSet,12));
            prpPcoinsDetailDto.setChgAgentFee(dbManager.getDouble(resultSet,13));
            prpPcoinsDetailDto.setChgOperateFee(dbManager.getDouble(resultSet,14));
            prpPcoinsDetailDto.setMiddleCostFee(dbManager.getDouble(resultSet,15));
            prpPcoinsDetailDto.setChgMiddleCostFee(dbManager.getDouble(resultSet,16));
            prpPcoinsDetailDto.setFlag(dbManager.getString(resultSet,17));
        }
        resultSet.close();
        return prpPcoinsDetailDto;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("endorseNo,");
        buffer.append("policyNo,");
        buffer.append("serialNo,");
        buffer.append("coinsCode,");
        buffer.append("coinsName,");
        buffer.append("currency,");
        buffer.append("coinsAmount,");
        buffer.append("coinsPremium,");
        buffer.append("agentFee,");
        buffer.append("operateFee,");
        buffer.append("chgCoinsAmount,");
        buffer.append("chgCoinsPremium,");
        buffer.append("chgAgentFee,");
        buffer.append("chgOperateFee,");
        buffer.append("middleCostFee,");
        buffer.append("chgMiddleCostFee,");
        buffer.append("flag ");
        buffer.append("FROM PrpPcoinsDetail WHERE ");
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
        PrpPcoinsDetailDto prpPcoinsDetailDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpPcoinsDetailDto = new PrpPcoinsDetailDto();
            prpPcoinsDetailDto.setEndorseNo(dbManager.getString(resultSet,1));
            prpPcoinsDetailDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpPcoinsDetailDto.setSerialNo(dbManager.getLong(resultSet,3));
            prpPcoinsDetailDto.setCoinsCode(dbManager.getString(resultSet,4));
            prpPcoinsDetailDto.setCoinsName(dbManager.getString(resultSet,5));
            prpPcoinsDetailDto.setCurrency(dbManager.getString(resultSet,6));
            prpPcoinsDetailDto.setCoinsAmount(dbManager.getDouble(resultSet,7));
            prpPcoinsDetailDto.setCoinsPremium(dbManager.getDouble(resultSet,8));
            prpPcoinsDetailDto.setAgentFee(dbManager.getDouble(resultSet,9));
            prpPcoinsDetailDto.setOperateFee(dbManager.getDouble(resultSet,10));
            prpPcoinsDetailDto.setChgCoinsAmount(dbManager.getDouble(resultSet,11));
            prpPcoinsDetailDto.setChgCoinsPremium(dbManager.getDouble(resultSet,12));
            prpPcoinsDetailDto.setChgAgentFee(dbManager.getDouble(resultSet,13));
            prpPcoinsDetailDto.setChgOperateFee(dbManager.getDouble(resultSet,14));
            prpPcoinsDetailDto.setMiddleCostFee(dbManager.getDouble(resultSet,15));
            prpPcoinsDetailDto.setChgMiddleCostFee(dbManager.getDouble(resultSet,16));
            prpPcoinsDetailDto.setFlag(dbManager.getString(resultSet,17));
            collection.add(prpPcoinsDetailDto);
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
    public Collection findByConditions(String conditions)
            throws Exception{
        return findByConditions(conditions,0,0);
    }

    /**
     * 按条件删除数据
     * @param conditions 查询条件
     * @return 删除的行数
     * @throws Exception
     */
    public int deleteByConditions(String conditions)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpPcoinsDetail WHERE ");
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
        buffer.append("SELECT count(1) FROM PrpPcoinsDetail WHERE ");
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
