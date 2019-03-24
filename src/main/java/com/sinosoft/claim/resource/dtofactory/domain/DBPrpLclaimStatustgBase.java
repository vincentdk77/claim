package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLclaimStatus-理赔节点状态表(新增)的数据访问对象基类<br>
 * 创建于 2005-03-18 17:53:37.640<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLclaimStatustgBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpLclaimStatustgBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLclaimStatustgBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLclaimStatustgDto prpLclaimStatustgDto
     * @throws Exception
     */
    public void insert(PrpLclaimStatusDto prpLclaimStatustgDto) throws Exception{
        String mainStatement = " Insert Into PrpLclaimStatustg (" + 
                           " BusinessNo," + 
                           " PolicyNo," + 
                           " NodeType," + 
                           " SerialNo," + 
                           " RiskCode," + 
                           " Status," + 
                           " FlowID," + 
                           " HandlerCode," + 
                           " InputDate," + 
                           " OperateDate," + 
                           " TypeFlag," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLclaimStatustgDto.getBusinessNo() + "'," + 
                           "'" + prpLclaimStatustgDto.getPolicyNo() + "'," + 
                           "'" + prpLclaimStatustgDto.getNodeType() + "'," + 
                           "" + prpLclaimStatustgDto.getSerialNo() + "," + 
                           "'" + prpLclaimStatustgDto.getRiskCode() + "'," + 
                           "'" + prpLclaimStatustgDto.getStatus() + "'," + 
                           "'" + prpLclaimStatustgDto.getFlowID() + "'," + 
                           "'" + prpLclaimStatustgDto.getHandlerCode() + "'," + 
                           "'" + prpLclaimStatustgDto.getInputDate() + "'," + 
                           "'" + prpLclaimStatustgDto.getOperateDate() + "'," + 
                           "'" + prpLclaimStatustgDto.getTypeFlag() + "'," + 
                           "'" + prpLclaimStatustgDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLclaimStatustgDto.getBusinessNo());
        dbManager.setString(2,prpLclaimStatustgDto.getPolicyNo());
        dbManager.setString(3,prpLclaimStatustgDto.getNodeType());
        dbManager.setInt(4,prpLclaimStatustgDto.getSerialNo());
        dbManager.setString(5,prpLclaimStatustgDto.getRiskCode());
        dbManager.setString(6,prpLclaimStatustgDto.getStatus());
        dbManager.setString(7,prpLclaimStatustgDto.getFlowID());
        dbManager.setString(8,prpLclaimStatustgDto.getHandlerCode());
        dbManager.setDateTime(9,prpLclaimStatustgDto.getInputDate());
        dbManager.setDateTime(10,prpLclaimStatustgDto.getOperateDate());
        dbManager.setString(11,prpLclaimStatustgDto.getTypeFlag());
        dbManager.setString(12,prpLclaimStatustgDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLclaimStatustgBase.insert() success!");
    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLclaimStatustg (" + 
                           " BusinessNo," + 
                           " PolicyNo," + 
                           " NodeType," + 
                           " SerialNo," + 
                           " RiskCode," + 
                           " Status," + 
                           " FlowID," + 
                           " HandlerCode," + 
                           " InputDate," + 
                           " OperateDate," + 
                           " TypeFlag," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLclaimStatusDto prpLclaimStatustgDto = (PrpLclaimStatusDto)i.next();
            dbManager.setString(1,prpLclaimStatustgDto.getBusinessNo());
            dbManager.setString(2,prpLclaimStatustgDto.getPolicyNo());
            dbManager.setString(3,prpLclaimStatustgDto.getNodeType());
            dbManager.setInt(4,prpLclaimStatustgDto.getSerialNo());
            dbManager.setString(5,prpLclaimStatustgDto.getRiskCode());
            dbManager.setString(6,prpLclaimStatustgDto.getStatus());
            dbManager.setString(7,prpLclaimStatustgDto.getFlowID());
            dbManager.setString(8,prpLclaimStatustgDto.getHandlerCode());
            dbManager.setDateTime(9,prpLclaimStatustgDto.getInputDate());
            dbManager.setDateTime(10,prpLclaimStatustgDto.getOperateDate());
            dbManager.setString(11,prpLclaimStatustgDto.getTypeFlag());
            dbManager.setString(12,prpLclaimStatustgDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLclaimStatustgBase.insertAll() success!");
    }

    /**
     * 按主键删除一条数据
     * @param businessNo 业务号
     * @param nodeType 节点种类
     * @param serialNo 序列号码
     * @throws Exception
     */
    public void delete(String businessNo,String nodeType,int serialNo) throws Exception{
        String statement = " Delete From PrpLclaimStatustg" + 
	            		   " Where " +
                           " BusinessNo = ? And " + 
                           " NodeType = ? And " + 
                           " SerialNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLclaimStatustg Where " +
                           " BusinessNo = '" + businessNo + "' And " + 
                           " NodeType = '" + nodeType + "' And " + 
                           " SerialNo = " + serialNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,businessNo);
        dbManager.setString(2,nodeType);
        dbManager.setInt(3,serialNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLclaimStatustgBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLclaimStatustgDto prpLclaimStatustgDto
     * @throws Exception
     */
    public void update(PrpLclaimStatusDto prpLclaimStatustgDto) throws Exception{
        String statement = " Update PrpLclaimStatustg Set PolicyNo = ?," + 
                           " RiskCode = ?," + 
                           " Status = ?," + 
                           " FlowID = ?," + 
                           " HandlerCode = ?," + 
                           " InputDate = ?," + 
                           " OperateDate = ?," + 
                           " TypeFlag = ?," + 
                           " Flag = ?" + 
	            		   " Where " +
                           " BusinessNo = ? And " + 
                           " NodeType = ? And " + 
                           " SerialNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLclaimStatustg Set " + 
                           " BusinessNo = '" + prpLclaimStatustgDto.getBusinessNo() + "'," + 
                           " PolicyNo = '" + prpLclaimStatustgDto.getPolicyNo() + "'," + 
                           " NodeType = '" + prpLclaimStatustgDto.getNodeType() + "'," + 
                           " SerialNo = " + prpLclaimStatustgDto.getSerialNo() + "," + 
                           " RiskCode = '" + prpLclaimStatustgDto.getRiskCode() + "'," + 
                           " Status = '" + prpLclaimStatustgDto.getStatus() + "'," + 
                           " FlowID = '" + prpLclaimStatustgDto.getFlowID() + "'," + 
                           " HandlerCode = '" + prpLclaimStatustgDto.getHandlerCode() + "'," + 
                           " InputDate = '" + prpLclaimStatustgDto.getInputDate() + "'," + 
                           " OperateDate = '" + prpLclaimStatustgDto.getOperateDate() + "'," + 
                           " TypeFlag = '" + prpLclaimStatustgDto.getTypeFlag() + "'," + 
                           " Flag = '" + prpLclaimStatustgDto.getFlag() + "'" + 
			               " Where " +
                           " BusinessNo = '" + prpLclaimStatustgDto.getBusinessNo() + "' And " + 
                           " NodeType = '" + prpLclaimStatustgDto.getNodeType() + "' And " + 
                           " SerialNo = " + prpLclaimStatustgDto.getSerialNo() + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpLclaimStatustgDto.getPolicyNo());
        dbManager.setString(2,prpLclaimStatustgDto.getRiskCode());
        dbManager.setString(3,prpLclaimStatustgDto.getStatus());
        dbManager.setString(4,prpLclaimStatustgDto.getFlowID());
        dbManager.setString(5,prpLclaimStatustgDto.getHandlerCode());
        dbManager.setDateTime(6,prpLclaimStatustgDto.getInputDate());
        dbManager.setDateTime(7,prpLclaimStatustgDto.getOperateDate());
        dbManager.setString(8,prpLclaimStatustgDto.getTypeFlag());
        dbManager.setString(9,prpLclaimStatustgDto.getFlag());
        //设置条件字段;
        dbManager.setString(10,prpLclaimStatustgDto.getBusinessNo());
        dbManager.setString(11,prpLclaimStatustgDto.getNodeType());
        dbManager.setInt(12,prpLclaimStatustgDto.getSerialNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLclaimStatustgBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param businessNo 业务号
     * @param nodeType 节点种类
     * @param serialNo 序列号码
     * @return PrpLclaimStatusDto
     * @throws Exception
     */
    public PrpLclaimStatusDto findByPrimaryKey(String businessNo,String nodeType,int serialNo) throws Exception{
        String mainStatement = " Select BusinessNo," + 
                           " PolicyNo," + 
                           " NodeType," + 
                           " SerialNo," + 
                           " RiskCode," + 
                           " Status," + 
                           " FlowID," + 
                           " HandlerCode," + 
                           " InputDate," + 
                           " OperateDate," + 
                           " TypeFlag," + 
                           " Flag From PrpLclaimStatustg";
        String statement = mainStatement + " Where " +
                           " BusinessNo = ? And " + 
                           " NodeType = ? And " + 
                           " SerialNo = ?";
        PrpLclaimStatusDto prpLclaimStatustgDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " BusinessNo = '" + businessNo + "' And " + 
                           " NodeType = '" + nodeType + "' And " + 
                           " SerialNo = " + serialNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,businessNo);
        dbManager.setString(2,nodeType);
        dbManager.setInt(3,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLclaimStatustgDto = new PrpLclaimStatusDto();
            prpLclaimStatustgDto.setBusinessNo(dbManager.getString(resultSet,1));
            prpLclaimStatustgDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpLclaimStatustgDto.setNodeType(dbManager.getString(resultSet,3));
            prpLclaimStatustgDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpLclaimStatustgDto.setRiskCode(dbManager.getString(resultSet,5));
            prpLclaimStatustgDto.setStatus(dbManager.getString(resultSet,6));
            prpLclaimStatustgDto.setFlowID(dbManager.getString(resultSet,7));
            prpLclaimStatustgDto.setHandlerCode(dbManager.getString(resultSet,8));
            prpLclaimStatustgDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,9));
            prpLclaimStatustgDto.setOperateDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,10));
            prpLclaimStatustgDto.setTypeFlag(dbManager.getString(resultSet,11));
            prpLclaimStatustgDto.setFlag(dbManager.getString(resultSet,12));
            logger.info("DBPrpLclaimStatustgBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLclaimStatustgBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLclaimStatustgDto;
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
        String statement = "Select BusinessNo," + 
                           " PolicyNo," + 
                           " NodeType," + 
                           " SerialNo," + 
                           " RiskCode," + 
                           " Status," + 
                           " FlowID," + 
                           " HandlerCode," + 
                           " InputDate," + 
                           " OperateDate," + 
                           " TypeFlag," + 
                           " Flag From PrpLclaimStatustg Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLclaimStatusDto prpLclaimStatustgDto = null;
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

            prpLclaimStatustgDto = new PrpLclaimStatusDto();
            prpLclaimStatustgDto.setBusinessNo(dbManager.getString(resultSet,1));
            prpLclaimStatustgDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpLclaimStatustgDto.setNodeType(dbManager.getString(resultSet,3));
            prpLclaimStatustgDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpLclaimStatustgDto.setRiskCode(dbManager.getString(resultSet,5));
            prpLclaimStatustgDto.setStatus(dbManager.getString(resultSet,6));
            prpLclaimStatustgDto.setFlowID(dbManager.getString(resultSet,7));
            prpLclaimStatustgDto.setHandlerCode(dbManager.getString(resultSet,8));
            prpLclaimStatustgDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,9));
            prpLclaimStatustgDto.setOperateDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,10));
            prpLclaimStatustgDto.setTypeFlag(dbManager.getString(resultSet,11));
            prpLclaimStatustgDto.setFlag(dbManager.getString(resultSet,12));
            collection.add(prpLclaimStatustgDto);
        }
        resultSet.close();
        logger.info("DBPrpLclaimStatustgBase.findByConditions() success!");
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
        String statement = "Delete From PrpLclaimStatustg Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLclaimStatustgBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLclaimStatustg Where " + conditions;
        statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLclaimStatustgBase.getCount() success!");
        return count;
    }
}
