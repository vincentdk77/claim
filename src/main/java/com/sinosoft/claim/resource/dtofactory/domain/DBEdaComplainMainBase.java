package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.EdaComplainMainDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是EdaComplainMain投诉信息表的数据访问对象基类<br>
 * 创建于 2005-08-20 17:56:00.904<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBEdaComplainMainBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBEdaComplainMainBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBEdaComplainMainBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param edaComplainMainDto edaComplainMainDto
     * @throws Exception
     */
    public void insert(EdaComplainMainDto edaComplainMainDto) throws Exception{
        String mainStatement = " Insert Into EdaComplainMain (" + 
                           " AcceptNo," + 
                           " CustomerCode," + 
                           " CustomerType," + 
                           " CustomerName," + 
                           " ComCode," + 
                           " ComName," + 
                           " UserCode," + 
                           " UserName," + 
                           " LinkerName," + 
                           " PostAddress," + 
                           " PostCode," + 
                           " PhoneNumber," + 
                           " Mobile," + 
                           " Email," + 
                           " TransType," + 
                           " VoiceFile," + 
                           " HandleUnit," + 
                           " HandlerCode," + 
                           " HandlerName," + 
                           " HandleDate," + 
                           " HandleTime," + 
                           " HandleStatus," + 
                           " ListenDate," + 
                           " ListenTime," + 
                           " ListenAgent," + 
                           " ListenStatus," + 
                           " CleanDate," + 
                           " CleanTime," + 
                           " CleanAgent," + 
                           " Remark," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "" + edaComplainMainDto.getAcceptNo() + "," + 
                           "'" + edaComplainMainDto.getCustomerCode() + "'," + 
                           "'" + edaComplainMainDto.getCustomerType() + "'," + 
                           "'" + edaComplainMainDto.getCustomerName() + "'," + 
                           "'" + edaComplainMainDto.getComCode() + "'," + 
                           "'" + edaComplainMainDto.getComName() + "'," + 
                           "'" + edaComplainMainDto.getUserCode() + "'," + 
                           "'" + edaComplainMainDto.getUserName() + "'," + 
                           "'" + edaComplainMainDto.getLinkerName() + "'," + 
                           "'" + edaComplainMainDto.getPostAddress() + "'," + 
                           "'" + edaComplainMainDto.getPostCode() + "'," + 
                           "'" + edaComplainMainDto.getPhoneNumber() + "'," + 
                           "'" + edaComplainMainDto.getMobile() + "'," + 
                           "'" + edaComplainMainDto.getEmail() + "'," + 
                           "'" + edaComplainMainDto.getTransType() + "'," + 
                           "'" + edaComplainMainDto.getVoiceFile() + "'," + 
                           "'" + edaComplainMainDto.getHandleUnit() + "'," + 
                           "'" + edaComplainMainDto.getHandlerCode() + "'," + 
                           "'" + edaComplainMainDto.getHandlerName() + "'," + 
                           "'" + edaComplainMainDto.getHandleDate() + "'," + 
                           "'" + edaComplainMainDto.getHandleTime() + "'," + 
                           "'" + edaComplainMainDto.getHandleStatus() + "'," + 
                           "'" + edaComplainMainDto.getListenDate() + "'," + 
                           "'" + edaComplainMainDto.getListenTime() + "'," + 
                           "'" + edaComplainMainDto.getListenAgent() + "'," + 
                           "'" + edaComplainMainDto.getListenStatus() + "'," + 
                           "'" + edaComplainMainDto.getCleanDate() + "'," + 
                           "'" + edaComplainMainDto.getCleanTime() + "'," + 
                           "'" + edaComplainMainDto.getCleanAgent() + "'," + 
                           "'" + edaComplainMainDto.getRemark() + "'," + 
                           "'" + edaComplainMainDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setInt(1,edaComplainMainDto.getAcceptNo());
        dbManager.setString(2,edaComplainMainDto.getCustomerCode());
        dbManager.setString(3,edaComplainMainDto.getCustomerType());
        dbManager.setString(4,edaComplainMainDto.getCustomerName());
        dbManager.setString(5,edaComplainMainDto.getComCode());
        dbManager.setString(6,edaComplainMainDto.getComName());
        dbManager.setString(7,edaComplainMainDto.getUserCode());
        dbManager.setString(8,edaComplainMainDto.getUserName());
        dbManager.setString(9,edaComplainMainDto.getLinkerName());
        dbManager.setString(10,edaComplainMainDto.getPostAddress());
        dbManager.setString(11,edaComplainMainDto.getPostCode());
        dbManager.setString(12,edaComplainMainDto.getPhoneNumber());
        dbManager.setString(13,edaComplainMainDto.getMobile());
        dbManager.setString(14,edaComplainMainDto.getEmail());
        dbManager.setString(15,edaComplainMainDto.getTransType());
        dbManager.setString(16,edaComplainMainDto.getVoiceFile());
        dbManager.setString(17,edaComplainMainDto.getHandleUnit());
        dbManager.setString(18,edaComplainMainDto.getHandlerCode());
        dbManager.setString(19,edaComplainMainDto.getHandlerName());
        dbManager.setDateTime(20,edaComplainMainDto.getHandleDate());
        dbManager.setString(21,edaComplainMainDto.getHandleTime());
        dbManager.setString(22,edaComplainMainDto.getHandleStatus());
        dbManager.setDateTime(23,edaComplainMainDto.getListenDate());
        dbManager.setString(24,edaComplainMainDto.getListenTime());
        dbManager.setString(25,edaComplainMainDto.getListenAgent());
        dbManager.setString(26,edaComplainMainDto.getListenStatus());
        dbManager.setDateTime(27,edaComplainMainDto.getCleanDate());
        dbManager.setString(28,edaComplainMainDto.getCleanTime());
        dbManager.setString(29,edaComplainMainDto.getCleanAgent());
        dbManager.setString(30,edaComplainMainDto.getRemark());
        dbManager.setString(31,edaComplainMainDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBEdaComplainMainBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            EdaComplainMainDto edaComplainMainDto = (EdaComplainMainDto)i.next();
            insert(edaComplainMainDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param acceptNo 投诉登记号
     * @throws Exception
     */
    public void delete(int acceptNo) throws Exception{
        String statement = " Delete From EdaComplainMain" + 
	            		   " Where " +
                           " AcceptNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From EdaComplainMain Where " +
                           " AcceptNo = " + acceptNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setInt(1,acceptNo);
        dbManager.executePreparedUpdate();
        logger.info("DBEdaComplainMainBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param edaComplainMainDto edaComplainMainDto
     * @throws Exception
     */
    public void update(EdaComplainMainDto edaComplainMainDto) throws Exception{
        String statement = " Update EdaComplainMain Set CustomerCode = ?," + 
                           " CustomerType = ?," + 
                           " CustomerName = ?," + 
                           " ComCode = ?," + 
                           " ComName = ?," + 
                           " UserCode = ?," + 
                           " UserName = ?," + 
                           " LinkerName = ?," + 
                           " PostAddress = ?," + 
                           " PostCode = ?," + 
                           " PhoneNumber = ?," + 
                           " Mobile = ?," + 
                           " Email = ?," + 
                           " TransType = ?," + 
                           " VoiceFile = ?," + 
                           " HandleUnit = ?," + 
                           " HandlerCode = ?," + 
                           " HandlerName = ?," + 
                           " HandleDate = ?," + 
                           " HandleTime = ?," + 
                           " HandleStatus = ?," + 
                           " ListenDate = ?," + 
                           " ListenTime = ?," + 
                           " ListenAgent = ?," + 
                           " ListenStatus = ?," + 
                           " CleanDate = ?," + 
                           " CleanTime = ?," + 
                           " CleanAgent = ?," + 
                           " Remark = ?," + 
                           " Flag = ?" + 
	            		   " Where " +
                           " AcceptNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update EdaComplainMain Set " + 
                           " AcceptNo = " + edaComplainMainDto.getAcceptNo() + "," + 
                           " CustomerCode = '" + edaComplainMainDto.getCustomerCode() + "'," + 
                           " CustomerType = '" + edaComplainMainDto.getCustomerType() + "'," + 
                           " CustomerName = '" + edaComplainMainDto.getCustomerName() + "'," + 
                           " ComCode = '" + edaComplainMainDto.getComCode() + "'," + 
                           " ComName = '" + edaComplainMainDto.getComName() + "'," + 
                           " UserCode = '" + edaComplainMainDto.getUserCode() + "'," + 
                           " UserName = '" + edaComplainMainDto.getUserName() + "'," + 
                           " LinkerName = '" + edaComplainMainDto.getLinkerName() + "'," + 
                           " PostAddress = '" + edaComplainMainDto.getPostAddress() + "'," + 
                           " PostCode = '" + edaComplainMainDto.getPostCode() + "'," + 
                           " PhoneNumber = '" + edaComplainMainDto.getPhoneNumber() + "'," + 
                           " Mobile = '" + edaComplainMainDto.getMobile() + "'," + 
                           " Email = '" + edaComplainMainDto.getEmail() + "'," + 
                           " TransType = '" + edaComplainMainDto.getTransType() + "'," + 
                           " VoiceFile = '" + edaComplainMainDto.getVoiceFile() + "'," + 
                           " HandleUnit = '" + edaComplainMainDto.getHandleUnit() + "'," + 
                           " HandlerCode = '" + edaComplainMainDto.getHandlerCode() + "'," + 
                           " HandlerName = '" + edaComplainMainDto.getHandlerName() + "'," + 
                           " HandleDate = '" + edaComplainMainDto.getHandleDate() + "'," + 
                           " HandleTime = '" + edaComplainMainDto.getHandleTime() + "'," + 
                           " HandleStatus = '" + edaComplainMainDto.getHandleStatus() + "'," + 
                           " ListenDate = '" + edaComplainMainDto.getListenDate() + "'," + 
                           " ListenTime = '" + edaComplainMainDto.getListenTime() + "'," + 
                           " ListenAgent = '" + edaComplainMainDto.getListenAgent() + "'," + 
                           " ListenStatus = '" + edaComplainMainDto.getListenStatus() + "'," + 
                           " CleanDate = '" + edaComplainMainDto.getCleanDate() + "'," + 
                           " CleanTime = '" + edaComplainMainDto.getCleanTime() + "'," + 
                           " CleanAgent = '" + edaComplainMainDto.getCleanAgent() + "'," + 
                           " Remark = '" + edaComplainMainDto.getRemark() + "'," + 
                           " Flag = '" + edaComplainMainDto.getFlag() + "'" + 
			               " Where " +
                           " AcceptNo = " + edaComplainMainDto.getAcceptNo() + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,edaComplainMainDto.getCustomerCode());
        dbManager.setString(2,edaComplainMainDto.getCustomerType());
        dbManager.setString(3,edaComplainMainDto.getCustomerName());
        dbManager.setString(4,edaComplainMainDto.getComCode());
        dbManager.setString(5,edaComplainMainDto.getComName());
        dbManager.setString(6,edaComplainMainDto.getUserCode());
        dbManager.setString(7,edaComplainMainDto.getUserName());
        dbManager.setString(8,edaComplainMainDto.getLinkerName());
        dbManager.setString(9,edaComplainMainDto.getPostAddress());
        dbManager.setString(10,edaComplainMainDto.getPostCode());
        dbManager.setString(11,edaComplainMainDto.getPhoneNumber());
        dbManager.setString(12,edaComplainMainDto.getMobile());
        dbManager.setString(13,edaComplainMainDto.getEmail());
        dbManager.setString(14,edaComplainMainDto.getTransType());
        dbManager.setString(15,edaComplainMainDto.getVoiceFile());
        dbManager.setString(16,edaComplainMainDto.getHandleUnit());
        dbManager.setString(17,edaComplainMainDto.getHandlerCode());
        dbManager.setString(18,edaComplainMainDto.getHandlerName());
        dbManager.setDateTime(19,edaComplainMainDto.getHandleDate());
        dbManager.setString(20,edaComplainMainDto.getHandleTime());
        dbManager.setString(21,edaComplainMainDto.getHandleStatus());
        dbManager.setDateTime(22,edaComplainMainDto.getListenDate());
        dbManager.setString(23,edaComplainMainDto.getListenTime());
        dbManager.setString(24,edaComplainMainDto.getListenAgent());
        dbManager.setString(25,edaComplainMainDto.getListenStatus());
        dbManager.setDateTime(26,edaComplainMainDto.getCleanDate());
        dbManager.setString(27,edaComplainMainDto.getCleanTime());
        dbManager.setString(28,edaComplainMainDto.getCleanAgent());
        dbManager.setString(29,edaComplainMainDto.getRemark());
        dbManager.setString(30,edaComplainMainDto.getFlag());
        //设置条件字段;
        dbManager.setInt(31,edaComplainMainDto.getAcceptNo());
        dbManager.executePreparedUpdate();

        logger.info("DBEdaComplainMainBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param acceptNo 投诉登记号
     * @return EdaComplainMainDto
     * @throws Exception
     */
    public EdaComplainMainDto findByPrimaryKey(int acceptNo) throws Exception{
        String mainStatement = " Select AcceptNo," + 
                           " CustomerCode," + 
                           " CustomerType," + 
                           " CustomerName," + 
                           " ComCode," + 
                           " ComName," + 
                           " UserCode," + 
                           " UserName," + 
                           " LinkerName," + 
                           " PostAddress," + 
                           " PostCode," + 
                           " PhoneNumber," + 
                           " Mobile," + 
                           " Email," + 
                           " TransType," + 
                           " VoiceFile," + 
                           " HandleUnit," + 
                           " HandlerCode," + 
                           " HandlerName," + 
                           " HandleDate," + 
                           " HandleTime," + 
                           " HandleStatus," + 
                           " ListenDate," + 
                           " ListenTime," + 
                           " ListenAgent," + 
                           " ListenStatus," + 
                           " CleanDate," + 
                           " CleanTime," + 
                           " CleanAgent," + 
                           " Remark," + 
                           " Flag From EdaComplainMain";
        String statement = mainStatement + " Where " +
                           " AcceptNo = ?";
        EdaComplainMainDto edaComplainMainDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " AcceptNo = " + acceptNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setInt(1,acceptNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            edaComplainMainDto = new EdaComplainMainDto();
            edaComplainMainDto.setAcceptNo(dbManager.getInt(resultSet,1));
            edaComplainMainDto.setCustomerCode(dbManager.getString(resultSet,2));
            edaComplainMainDto.setCustomerType(dbManager.getString(resultSet,3));
            edaComplainMainDto.setCustomerName(dbManager.getString(resultSet,4));
            edaComplainMainDto.setComCode(dbManager.getString(resultSet,5));
            edaComplainMainDto.setComName(dbManager.getString(resultSet,6));
            edaComplainMainDto.setUserCode(dbManager.getString(resultSet,7));
            edaComplainMainDto.setUserName(dbManager.getString(resultSet,8));
            edaComplainMainDto.setLinkerName(dbManager.getString(resultSet,9));
            edaComplainMainDto.setPostAddress(dbManager.getString(resultSet,10));
            edaComplainMainDto.setPostCode(dbManager.getString(resultSet,11));
            edaComplainMainDto.setPhoneNumber(dbManager.getString(resultSet,12));
            edaComplainMainDto.setMobile(dbManager.getString(resultSet,13));
            edaComplainMainDto.setEmail(dbManager.getString(resultSet,14));
            edaComplainMainDto.setTransType(dbManager.getString(resultSet,15));
            edaComplainMainDto.setVoiceFile(dbManager.getString(resultSet,16));
            edaComplainMainDto.setHandleUnit(dbManager.getString(resultSet,17));
            edaComplainMainDto.setHandlerCode(dbManager.getString(resultSet,18));
            edaComplainMainDto.setHandlerName(dbManager.getString(resultSet,19));
            edaComplainMainDto.setHandleDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,20));
            edaComplainMainDto.setHandleTime(dbManager.getString(resultSet,21));
            edaComplainMainDto.setHandleStatus(dbManager.getString(resultSet,22));
            edaComplainMainDto.setListenDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,23));
            edaComplainMainDto.setListenTime(dbManager.getString(resultSet,24));
            edaComplainMainDto.setListenAgent(dbManager.getString(resultSet,25));
            edaComplainMainDto.setListenStatus(dbManager.getString(resultSet,26));
            edaComplainMainDto.setCleanDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,27));
            edaComplainMainDto.setCleanTime(dbManager.getString(resultSet,28));
            edaComplainMainDto.setCleanAgent(dbManager.getString(resultSet,29));
            edaComplainMainDto.setRemark(dbManager.getString(resultSet,30));
            edaComplainMainDto.setFlag(dbManager.getString(resultSet,31));
        }
        resultSet.close();
        logger.info("DBEdaComplainMainBase.findByPrimaryKey() success!");
        return edaComplainMainDto;
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
        String statement = "Select AcceptNo," + 
                           " CustomerCode," + 
                           " CustomerType," + 
                           " CustomerName," + 
                           " ComCode," + 
                           " ComName," + 
                           " UserCode," + 
                           " UserName," + 
                           " LinkerName," + 
                           " PostAddress," + 
                           " PostCode," + 
                           " PhoneNumber," + 
                           " Mobile," + 
                           " Email," + 
                           " TransType," + 
                           " VoiceFile," + 
                           " HandleUnit," + 
                           " HandlerCode," + 
                           " HandlerName," + 
                           " HandleDate," + 
                           " HandleTime," + 
                           " HandleStatus," + 
                           " ListenDate," + 
                           " ListenTime," + 
                           " ListenAgent," + 
                           " ListenStatus," + 
                           " CleanDate," + 
                           " CleanTime," + 
                           " CleanAgent," + 
                           " Remark," + 
                           " Flag From EdaComplainMain Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        EdaComplainMainDto edaComplainMainDto = null;
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

            edaComplainMainDto = new EdaComplainMainDto();
            edaComplainMainDto.setAcceptNo(dbManager.getInt(resultSet,1));
            edaComplainMainDto.setCustomerCode(dbManager.getString(resultSet,2));
            edaComplainMainDto.setCustomerType(dbManager.getString(resultSet,3));
            edaComplainMainDto.setCustomerName(dbManager.getString(resultSet,4));
            edaComplainMainDto.setComCode(dbManager.getString(resultSet,5));
            edaComplainMainDto.setComName(dbManager.getString(resultSet,6));
            edaComplainMainDto.setUserCode(dbManager.getString(resultSet,7));
            edaComplainMainDto.setUserName(dbManager.getString(resultSet,8));
            edaComplainMainDto.setLinkerName(dbManager.getString(resultSet,9));
            edaComplainMainDto.setPostAddress(dbManager.getString(resultSet,10));
            edaComplainMainDto.setPostCode(dbManager.getString(resultSet,11));
            edaComplainMainDto.setPhoneNumber(dbManager.getString(resultSet,12));
            edaComplainMainDto.setMobile(dbManager.getString(resultSet,13));
            edaComplainMainDto.setEmail(dbManager.getString(resultSet,14));
            edaComplainMainDto.setTransType(dbManager.getString(resultSet,15));
            edaComplainMainDto.setVoiceFile(dbManager.getString(resultSet,16));
            edaComplainMainDto.setHandleUnit(dbManager.getString(resultSet,17));
            edaComplainMainDto.setHandlerCode(dbManager.getString(resultSet,18));
            edaComplainMainDto.setHandlerName(dbManager.getString(resultSet,19));
            edaComplainMainDto.setHandleDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,20));
            edaComplainMainDto.setHandleTime(dbManager.getString(resultSet,21));
            edaComplainMainDto.setHandleStatus(dbManager.getString(resultSet,22));
            edaComplainMainDto.setListenDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,23));
            edaComplainMainDto.setListenTime(dbManager.getString(resultSet,24));
            edaComplainMainDto.setListenAgent(dbManager.getString(resultSet,25));
            edaComplainMainDto.setListenStatus(dbManager.getString(resultSet,26));
            edaComplainMainDto.setCleanDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,27));
            edaComplainMainDto.setCleanTime(dbManager.getString(resultSet,28));
            edaComplainMainDto.setCleanAgent(dbManager.getString(resultSet,29));
            edaComplainMainDto.setRemark(dbManager.getString(resultSet,30));
            edaComplainMainDto.setFlag(dbManager.getString(resultSet,31));
            collection.add(edaComplainMainDto);
        }
        resultSet.close();
        logger.info("DBEdaComplainMainBase.findByConditions() success!");
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
        String statement = "Delete From EdaComplainMain Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBEdaComplainMainBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from EdaComplainMain Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBEdaComplainMainBase.getCount() success!");
        return count;
    }
}
