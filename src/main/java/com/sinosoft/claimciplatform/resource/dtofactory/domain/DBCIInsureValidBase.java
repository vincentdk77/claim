package com.sinosoft.claimciplatform.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.sinosoft.claimciplatform.dto.domain.CIInsureValidDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是投保确认主表-CIInsureValid的数据访问对象基类<br>
 * 创建于 2006-06-21 17:31:50.562<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBCIInsureValidBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Log logger = LogFactory.getLog(DBCIInsureValidBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBCIInsureValidBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param cIInsureValidDto cIInsureValidDto
     * @throws Exception
     */
    public void insert(CIInsureValidDto cIInsureValidDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO CIInsureValid (");
        buffer.append("ValidNo,");
        buffer.append("DemandNo,");
        buffer.append("ProposalNo,");
        buffer.append("PolicyNo,");
        buffer.append("InsureMarkNo,");
        buffer.append("BussinessNature,");
        buffer.append("OperateDate,");
        buffer.append("Clauses,");
        buffer.append("HandlerName,");
        buffer.append("OperatorName,");
        buffer.append("Currency,");
        buffer.append("Premium,");
        buffer.append("ChangeReason,");
        buffer.append("ChangeDetail,");
        buffer.append("ComCode,");
        buffer.append("ValidTime,");
        buffer.append("Remark,");
        buffer.append("Flag ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(cIInsureValidDto.getValidNo()).append("',");
            debugBuffer.append("'").append(cIInsureValidDto.getDemandNo()).append("',");
            debugBuffer.append("'").append(cIInsureValidDto.getProposalNo()).append("',");
            debugBuffer.append("'").append(cIInsureValidDto.getPolicyNo()).append("',");
            debugBuffer.append("'").append(cIInsureValidDto.getInsureMarkNo()).append("',");
            debugBuffer.append("'").append(cIInsureValidDto.getBussinessNature()).append("',");
            debugBuffer.append("'").append(cIInsureValidDto.getOperateDate()).append("',");
            debugBuffer.append("'").append(cIInsureValidDto.getClauses()).append("',");
            debugBuffer.append("'").append(cIInsureValidDto.getHandlerName()).append("',");
            debugBuffer.append("'").append(cIInsureValidDto.getOperatorName()).append("',");
            debugBuffer.append("'").append(cIInsureValidDto.getCurrency()).append("',");
            debugBuffer.append("").append(cIInsureValidDto.getPremium()).append(",");
            debugBuffer.append("'").append(cIInsureValidDto.getChangeReason()).append("',");
            debugBuffer.append("'").append(cIInsureValidDto.getChangeDetail()).append("',");
            debugBuffer.append("'").append(cIInsureValidDto.getComCode()).append("',");
            debugBuffer.append("'").append(cIInsureValidDto.getValidTime()).append("',");
            debugBuffer.append("'").append(cIInsureValidDto.getRemark()).append("',");
            debugBuffer.append("'").append(cIInsureValidDto.getFlag()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,cIInsureValidDto.getValidNo());
        dbManager.setString(2,cIInsureValidDto.getDemandNo());
        dbManager.setString(3,cIInsureValidDto.getProposalNo());
        dbManager.setString(4,cIInsureValidDto.getPolicyNo());
        dbManager.setString(5,cIInsureValidDto.getInsureMarkNo());
        dbManager.setString(6,cIInsureValidDto.getBussinessNature());
        dbManager.setDateTime(7,cIInsureValidDto.getOperateDate());
        dbManager.setString(8,cIInsureValidDto.getClauses());
        dbManager.setString(9,cIInsureValidDto.getHandlerName());
        dbManager.setString(10,cIInsureValidDto.getOperatorName());
        dbManager.setString(11,cIInsureValidDto.getCurrency());
        dbManager.setDouble(12,cIInsureValidDto.getPremium());
        dbManager.setString(13,cIInsureValidDto.getChangeReason());
        dbManager.setString(14,cIInsureValidDto.getChangeDetail());
        dbManager.setString(15,cIInsureValidDto.getComCode());
        dbManager.setDateTime(16,cIInsureValidDto.getValidTime());
        dbManager.setString(17,cIInsureValidDto.getRemark());
        dbManager.setString(18,cIInsureValidDto.getFlag());
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
        buffer.append("INSERT INTO CIInsureValid (");
        buffer.append("ValidNo,");
        buffer.append("DemandNo,");
        buffer.append("ProposalNo,");
        buffer.append("PolicyNo,");
        buffer.append("InsureMarkNo,");
        buffer.append("BussinessNature,");
        buffer.append("OperateDate,");
        buffer.append("Clauses,");
        buffer.append("HandlerName,");
        buffer.append("OperatorName,");
        buffer.append("Currency,");
        buffer.append("Premium,");
        buffer.append("ChangeReason,");
        buffer.append("ChangeDetail,");
        buffer.append("ComCode,");
        buffer.append("ValidTime,");
        buffer.append("Remark,");
        buffer.append("Flag ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            CIInsureValidDto cIInsureValidDto = (CIInsureValidDto)i.next();
            dbManager.setString(1,cIInsureValidDto.getValidNo());
            dbManager.setString(2,cIInsureValidDto.getDemandNo());
            dbManager.setString(3,cIInsureValidDto.getProposalNo());
            dbManager.setString(4,cIInsureValidDto.getPolicyNo());
            dbManager.setString(5,cIInsureValidDto.getInsureMarkNo());
            dbManager.setString(6,cIInsureValidDto.getBussinessNature());
            dbManager.setDateTime(7,cIInsureValidDto.getOperateDate());
            dbManager.setString(8,cIInsureValidDto.getClauses());
            dbManager.setString(9,cIInsureValidDto.getHandlerName());
            dbManager.setString(10,cIInsureValidDto.getOperatorName());
            dbManager.setString(11,cIInsureValidDto.getCurrency());
            dbManager.setDouble(12,cIInsureValidDto.getPremium());
            dbManager.setString(13,cIInsureValidDto.getChangeReason());
            dbManager.setString(14,cIInsureValidDto.getChangeDetail());
            dbManager.setString(15,cIInsureValidDto.getComCode());
            dbManager.setDateTime(16,cIInsureValidDto.getValidTime());
            dbManager.setString(17,cIInsureValidDto.getRemark());
            dbManager.setString(18,cIInsureValidDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param validNo 确认码
     * @throws Exception
     */
    public void delete(String validNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM CIInsureValid ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("ValidNo=").append("'").append(validNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("ValidNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,validNo);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param cIInsureValidDto cIInsureValidDto
     * @throws Exception
     */
    public void update(CIInsureValidDto cIInsureValidDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE CIInsureValid SET ");
        buffer.append("DemandNo = ?, ");
        buffer.append("ProposalNo = ?, ");
        buffer.append("PolicyNo = ?, ");
        buffer.append("InsureMarkNo = ?, ");
        buffer.append("BussinessNature = ?, ");
        buffer.append("OperateDate = ?, ");
        buffer.append("Clauses = ?, ");
        buffer.append("HandlerName = ?, ");
        buffer.append("OperatorName = ?, ");
        buffer.append("Currency = ?, ");
        buffer.append("Premium = ?, ");
        buffer.append("ChangeReason = ?, ");
        buffer.append("ChangeDetail = ?, ");
        buffer.append("ComCode = ?, ");
        buffer.append("ValidTime = ?, ");
        buffer.append("Remark = ?, ");
        buffer.append("Flag = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE CIInsureValid SET ");
            debugBuffer.append("DemandNo = '" + cIInsureValidDto.getDemandNo() + "', ");
            debugBuffer.append("ProposalNo = '" + cIInsureValidDto.getProposalNo() + "', ");
            debugBuffer.append("PolicyNo = '" + cIInsureValidDto.getPolicyNo() + "', ");
            debugBuffer.append("InsureMarkNo = '" + cIInsureValidDto.getInsureMarkNo() + "', ");
            debugBuffer.append("BussinessNature = '" + cIInsureValidDto.getBussinessNature() + "', ");
            debugBuffer.append("OperateDate = '" + cIInsureValidDto.getOperateDate() + "', ");
            debugBuffer.append("Clauses = '" + cIInsureValidDto.getClauses() + "', ");
            debugBuffer.append("HandlerName = '" + cIInsureValidDto.getHandlerName() + "', ");
            debugBuffer.append("OperatorName = '" + cIInsureValidDto.getOperatorName() + "', ");
            debugBuffer.append("Currency = '" + cIInsureValidDto.getCurrency() + "', ");
            debugBuffer.append("Premium = " + cIInsureValidDto.getPremium() + ", ");
            debugBuffer.append("ChangeReason = '" + cIInsureValidDto.getChangeReason() + "', ");
            debugBuffer.append("ChangeDetail = '" + cIInsureValidDto.getChangeDetail() + "', ");
            debugBuffer.append("ComCode = '" + cIInsureValidDto.getComCode() + "', ");
            debugBuffer.append("ValidTime = '" + cIInsureValidDto.getValidTime() + "', ");
            debugBuffer.append("Remark = '" + cIInsureValidDto.getRemark() + "', ");
            debugBuffer.append("Flag = '" + cIInsureValidDto.getFlag() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("ValidNo=").append("'").append(cIInsureValidDto.getValidNo()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("ValidNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,cIInsureValidDto.getDemandNo());
        dbManager.setString(2,cIInsureValidDto.getProposalNo());
        dbManager.setString(3,cIInsureValidDto.getPolicyNo());
        dbManager.setString(4,cIInsureValidDto.getInsureMarkNo());
        dbManager.setString(5,cIInsureValidDto.getBussinessNature());
        dbManager.setDateTime(6,cIInsureValidDto.getOperateDate());
        dbManager.setString(7,cIInsureValidDto.getClauses());
        dbManager.setString(8,cIInsureValidDto.getHandlerName());
        dbManager.setString(9,cIInsureValidDto.getOperatorName());
        dbManager.setString(10,cIInsureValidDto.getCurrency());
        dbManager.setDouble(11,cIInsureValidDto.getPremium());
        dbManager.setString(12,cIInsureValidDto.getChangeReason());
        dbManager.setString(13,cIInsureValidDto.getChangeDetail());
        dbManager.setString(14,cIInsureValidDto.getComCode());
        dbManager.setDateTime(15,cIInsureValidDto.getValidTime());
        dbManager.setString(16,cIInsureValidDto.getRemark());
        dbManager.setString(17,cIInsureValidDto.getFlag());
        //设置条件字段;
        dbManager.setString(18,cIInsureValidDto.getValidNo());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param validNo 确认码
     * @return CIInsureValidDto
     * @throws Exception
     */
    public CIInsureValidDto findByPrimaryKey(String validNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("ValidNo,");
        buffer.append("DemandNo,");
        buffer.append("ProposalNo,");
        buffer.append("PolicyNo,");
        buffer.append("InsureMarkNo,");
        buffer.append("BussinessNature,");
        buffer.append("OperateDate,");
        buffer.append("Clauses,");
        buffer.append("HandlerName,");
        buffer.append("OperatorName,");
        buffer.append("Currency,");
        buffer.append("Premium,");
        buffer.append("ChangeReason,");
        buffer.append("ChangeDetail,");
        buffer.append("ComCode,");
        buffer.append("ValidTime,");
        buffer.append("Remark,");
        buffer.append("Flag ");
        buffer.append("FROM CIInsureValid ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("ValidNo=").append("'").append(validNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("ValidNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,validNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        CIInsureValidDto cIInsureValidDto = null;
        if(resultSet.next()){
            cIInsureValidDto = new CIInsureValidDto();
            cIInsureValidDto.setValidNo(dbManager.getString(resultSet,1));
            cIInsureValidDto.setDemandNo(dbManager.getString(resultSet,2));
            cIInsureValidDto.setProposalNo(dbManager.getString(resultSet,3));
            cIInsureValidDto.setPolicyNo(dbManager.getString(resultSet,4));
            cIInsureValidDto.setInsureMarkNo(dbManager.getString(resultSet,5));
            cIInsureValidDto.setBussinessNature(dbManager.getString(resultSet,6));
            cIInsureValidDto.setOperateDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,7));
            cIInsureValidDto.setClauses(dbManager.getString(resultSet,8));
            cIInsureValidDto.setHandlerName(dbManager.getString(resultSet,9));
            cIInsureValidDto.setOperatorName(dbManager.getString(resultSet,10));
            cIInsureValidDto.setCurrency(dbManager.getString(resultSet,11));
            cIInsureValidDto.setPremium(dbManager.getDouble(resultSet,12));
            cIInsureValidDto.setChangeReason(dbManager.getString(resultSet,13));
            cIInsureValidDto.setChangeDetail(dbManager.getString(resultSet,14));
            cIInsureValidDto.setComCode(dbManager.getString(resultSet,15));
            cIInsureValidDto.setValidTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,16));
            cIInsureValidDto.setRemark(dbManager.getString(resultSet,17));
            cIInsureValidDto.setFlag(dbManager.getString(resultSet,18));
        }
        resultSet.close();
        return cIInsureValidDto;
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
        buffer.append("ValidNo,");
        buffer.append("DemandNo,");
        buffer.append("ProposalNo,");
        buffer.append("PolicyNo,");
        buffer.append("InsureMarkNo,");
        buffer.append("BussinessNature,");
        buffer.append("OperateDate,");
        buffer.append("Clauses,");
        buffer.append("HandlerName,");
        buffer.append("OperatorName,");
        buffer.append("Currency,");
        buffer.append("Premium,");
        buffer.append("ChangeReason,");
        buffer.append("ChangeDetail,");
        buffer.append("ComCode,");
        buffer.append("ValidTime,");
        buffer.append("Remark,");
        buffer.append("Flag ");
        buffer.append("FROM CIInsureValid WHERE ");
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
        CIInsureValidDto cIInsureValidDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            cIInsureValidDto = new CIInsureValidDto();
            cIInsureValidDto.setValidNo(dbManager.getString(resultSet,1));
            cIInsureValidDto.setDemandNo(dbManager.getString(resultSet,2));
            cIInsureValidDto.setProposalNo(dbManager.getString(resultSet,3));
            cIInsureValidDto.setPolicyNo(dbManager.getString(resultSet,4));
            cIInsureValidDto.setInsureMarkNo(dbManager.getString(resultSet,5));
            cIInsureValidDto.setBussinessNature(dbManager.getString(resultSet,6));
            cIInsureValidDto.setOperateDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,7));
            cIInsureValidDto.setClauses(dbManager.getString(resultSet,8));
            cIInsureValidDto.setHandlerName(dbManager.getString(resultSet,9));
            cIInsureValidDto.setOperatorName(dbManager.getString(resultSet,10));
            cIInsureValidDto.setCurrency(dbManager.getString(resultSet,11));
            cIInsureValidDto.setPremium(dbManager.getDouble(resultSet,12));
            cIInsureValidDto.setChangeReason(dbManager.getString(resultSet,13));
            cIInsureValidDto.setChangeDetail(dbManager.getString(resultSet,14));
            cIInsureValidDto.setComCode(dbManager.getString(resultSet,15));
            cIInsureValidDto.setValidTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,16));
            cIInsureValidDto.setRemark(dbManager.getString(resultSet,17));
            cIInsureValidDto.setFlag(dbManager.getString(resultSet,18));
            collection.add(cIInsureValidDto);
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
        buffer.append("DELETE FROM CIInsureValid WHERE ");
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
        buffer.append("SELECT count(*) FROM CIInsureValid WHERE ");
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
