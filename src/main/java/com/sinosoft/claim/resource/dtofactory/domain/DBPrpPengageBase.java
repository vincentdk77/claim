package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpPengageDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prppengage特别约定表的数据访问对象基类<br>
 * 创建于 2004-11-22 15:24:17.750<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpPengageBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpPengageBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpPengageBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpPengageDto prpPengageDto
     * @throws Exception
     */
    public void insert(PrpPengageDto prpPengageDto) throws Exception{
        String mainStatement = " Insert Into PrpPengage (" +
                           " EndorseNo," +
                           " PolicyNo," +
                           " RiskCode," +
                           " SerialNo," +
                           " LineNo," +
                           " ClauseCode," +
                           " Clauses," +
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" +
                           "'" + prpPengageDto.getEndorseNo() + "'," +
                           "'" + prpPengageDto.getPolicyNo() + "'," +
                           "'" + prpPengageDto.getRiskCode() + "'," +
                           "" + prpPengageDto.getSerialNo() + "," +
                           "" + prpPengageDto.getLineNo() + "," +
                           "'" + prpPengageDto.getClauseCode() + "'," +
                           "'" + prpPengageDto.getClauses() + "'," +
                           "'" + prpPengageDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpPengageDto.getEndorseNo());
        dbManager.setString(2,prpPengageDto.getPolicyNo());
        dbManager.setString(3,prpPengageDto.getRiskCode());
        dbManager.setInt(4,prpPengageDto.getSerialNo());
        dbManager.setInt(5,prpPengageDto.getLineNo());
        dbManager.setString(6,prpPengageDto.getClauseCode());
        dbManager.setString(7,prpPengageDto.getClauses());
        dbManager.setString(8,prpPengageDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpPengageBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpPengageDto prpPengageDto = (PrpPengageDto)i.next();
            insert(prpPengageDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param endorseNo 批单号码
     * @param serialNo 序号
     * @param lineNo 行序号
     * @throws Exception
     */
    public void delete(String endorseNo,int serialNo,int lineNo) throws Exception{
        String statement = " Delete From PrpPengage" +
	            		   " Where " +
                           " EndorseNo = ? And " +
                           " SerialNo = ? And " +
                           " LineNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpPengage Where " +
                           " EndorseNo = '" + endorseNo + "' And " +
                           " SerialNo = " + serialNo + " And " +
                           " LineNo = " + lineNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,endorseNo);
        dbManager.setInt(2,serialNo);
        dbManager.setInt(3,lineNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpPengageBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpPengageDto prpPengageDto
     * @throws Exception
     */
    public void update(PrpPengageDto prpPengageDto) throws Exception{
        String statement = " Update PrpPengage Set PolicyNo = ?," +
                           " RiskCode = ?," +
                           " ClauseCode = ?," +
                           " Clauses = ?," +
                           " Flag = ?" +
	            		   " Where " +
                           " EndorseNo = ? And " +
                           " SerialNo = ? And " +
                           " LineNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpPengage Set " +
                           " EndorseNo = '" + prpPengageDto.getEndorseNo() + "'," +
                           " PolicyNo = '" + prpPengageDto.getPolicyNo() + "'," +
                           " RiskCode = '" + prpPengageDto.getRiskCode() + "'," +
                           " SerialNo = " + prpPengageDto.getSerialNo() + "," +
                           " LineNo = " + prpPengageDto.getLineNo() + "," +
                           " ClauseCode = '" + prpPengageDto.getClauseCode() + "'," +
                           " Clauses = '" + prpPengageDto.getClauses() + "'," +
                           " Flag = '" + prpPengageDto.getFlag() + "'" +
			               " Where " +
                           " EndorseNo = '" + prpPengageDto.getEndorseNo() + "' And " +
                           " SerialNo = " + prpPengageDto.getSerialNo() + " And " +
                           " LineNo = " + prpPengageDto.getLineNo() + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpPengageDto.getPolicyNo());
        dbManager.setString(2,prpPengageDto.getRiskCode());
        dbManager.setString(3,prpPengageDto.getClauseCode());
        dbManager.setString(4,prpPengageDto.getClauses());
        dbManager.setString(5,prpPengageDto.getFlag());
        //设置条件字段;
        dbManager.setString(6,prpPengageDto.getEndorseNo());
        dbManager.setInt(7,prpPengageDto.getSerialNo());
        dbManager.setInt(8,prpPengageDto.getLineNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpPengageBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param endorseNo 批单号码
     * @param serialNo 序号
     * @param lineNo 行序号
     * @return PrpPengageDto
     * @throws Exception
     */
    public PrpPengageDto findByPrimaryKey(String endorseNo,int serialNo,int lineNo) throws Exception{
        String mainStatement = " Select EndorseNo," +
                           " PolicyNo," +
                           " RiskCode," +
                           " SerialNo," +
                           " LineNo," +
                           " ClauseCode," +
                           " Clauses," +
                           " Flag From PrpPengage";
        String statement = mainStatement + " Where " +
                           " EndorseNo = ? And " +
                           " SerialNo = ? And " +
                           " LineNo = ?";
        PrpPengageDto prpPengageDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " EndorseNo = '" + endorseNo + "' And " +
                           " SerialNo = " + serialNo + " And " +
                           " LineNo = " + lineNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,endorseNo);
        dbManager.setInt(2,serialNo);
        dbManager.setInt(3,lineNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpPengageDto = new PrpPengageDto();
            prpPengageDto.setEndorseNo(dbManager.getString(resultSet,1));
            prpPengageDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpPengageDto.setRiskCode(dbManager.getString(resultSet,3));
            prpPengageDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpPengageDto.setLineNo(dbManager.getInt(resultSet,5));
            prpPengageDto.setClauseCode(dbManager.getString(resultSet,6));
            prpPengageDto.setClauses(dbManager.getString(resultSet,7));
            prpPengageDto.setFlag(dbManager.getString(resultSet,8));
        }
        resultSet.close();
        logger.info("DBPrpPengageBase.findByPrimaryKey() success!");
        return prpPengageDto;
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
                           " LineNo," +
                           " ClauseCode," +
                           " Clauses," +
                           " Flag From PrpPengage Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpPengageDto prpPengageDto = null;
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

            prpPengageDto = new PrpPengageDto();
            prpPengageDto.setEndorseNo(dbManager.getString(resultSet,1));
            prpPengageDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpPengageDto.setRiskCode(dbManager.getString(resultSet,3));
            prpPengageDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpPengageDto.setLineNo(dbManager.getInt(resultSet,5));
            prpPengageDto.setClauseCode(dbManager.getString(resultSet,6));
            prpPengageDto.setClauses(dbManager.getString(resultSet,7));
            prpPengageDto.setFlag(dbManager.getString(resultSet,8));
            collection.add(prpPengageDto);
        }
        resultSet.close();
        logger.info("DBPrpPengageBase.findByConditions() success!");
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
        String statement = "Delete From PrpPengage Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpPengageBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpPengage Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpPengageBase.getCount() success!");
        return count;
    }
}
