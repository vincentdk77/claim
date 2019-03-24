package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLrtextDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLrtext-追偿损余文字说明的数据访问对象基类<br>
 * 创建于 2005-03-18 17:53:36.890<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLrtextBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpLrtextBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLrtextBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLrtextDto prpLrtextDto
     * @throws Exception
     */
    public void insert(PrpLrtextDto prpLrtextDto) throws Exception{
        String mainStatement = " Insert Into PrpLrtext (" + 
                           " ClaimNo," + 
                           " TextType," + 
                           " InputDate," + 
                           " SerialNo," + 
                           " LineNo," + 
                           " Context," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLrtextDto.getClaimNo() + "'," + 
                           "'" + prpLrtextDto.getTextType() + "'," + 
                           "'" + prpLrtextDto.getInputDate() + "'," + 
                           "" + prpLrtextDto.getSerialNo() + "," + 
                           "" + prpLrtextDto.getLineNo() + "," + 
                           "'" + prpLrtextDto.getContext() + "'," + 
                           "'" + prpLrtextDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLrtextDto.getClaimNo());
        dbManager.setString(2,prpLrtextDto.getTextType());
        dbManager.setDateTime(3,prpLrtextDto.getInputDate());
        dbManager.setInt(4,prpLrtextDto.getSerialNo());
        dbManager.setInt(5,prpLrtextDto.getLineNo());
        dbManager.setString(6,prpLrtextDto.getContext());
        dbManager.setString(7,prpLrtextDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLrtextBase.insert() success!");
    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLrtext (" + 
                           " ClaimNo," + 
                           " TextType," + 
                           " InputDate," + 
                           " SerialNo," + 
                           " LineNo," + 
                           " Context," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLrtextDto prpLrtextDto = (PrpLrtextDto)i.next();
            dbManager.setString(1,prpLrtextDto.getClaimNo());
            dbManager.setString(2,prpLrtextDto.getTextType());
            dbManager.setDateTime(3,prpLrtextDto.getInputDate());
            dbManager.setInt(4,prpLrtextDto.getSerialNo());
            dbManager.setInt(5,prpLrtextDto.getLineNo());
            dbManager.setString(6,prpLrtextDto.getContext());
            dbManager.setString(7,prpLrtextDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLrtextBase.insertAll() success!");
    }

    /**
     * 按主键删除一条数据
     * @param claimNo 赔案号码
     * @param textType 文字说明类型 ▲
--** 出险摘要/查勘报告/结案报告
     * @param serialNo 序号
     * @param lineNo 行号
     * @throws Exception
     */
    public void delete(String claimNo,String textType,int serialNo,int lineNo) throws Exception{
        String statement = " Delete From PrpLrtext" + 
	            		   " Where " +
                           " ClaimNo = ? And " + 
                           " TextType = ? And " + 
                           " SerialNo = ? And " + 
                           " LineNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLrtext Where " +
                           " ClaimNo = '" + claimNo + "' And " + 
                           " TextType = '" + textType + "' And " + 
                           " SerialNo = " + serialNo + " And " + 
                           " LineNo = " + lineNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,claimNo);
        dbManager.setString(2,textType);
        dbManager.setInt(3,serialNo);
        dbManager.setInt(4,lineNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLrtextBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLrtextDto prpLrtextDto
     * @throws Exception
     */
    public void update(PrpLrtextDto prpLrtextDto) throws Exception{
        String statement = " Update PrpLrtext Set InputDate = ?," + 
                           " Context = ?," + 
                           " Flag = ?" + 
	            		   " Where " +
                           " ClaimNo = ? And " + 
                           " TextType = ? And " + 
                           " SerialNo = ? And " + 
                           " LineNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLrtext Set " + 
                           " ClaimNo = '" + prpLrtextDto.getClaimNo() + "'," + 
                           " TextType = '" + prpLrtextDto.getTextType() + "'," + 
                           " InputDate = '" + prpLrtextDto.getInputDate() + "'," + 
                           " SerialNo = " + prpLrtextDto.getSerialNo() + "," + 
                           " LineNo = " + prpLrtextDto.getLineNo() + "," + 
                           " Context = '" + prpLrtextDto.getContext() + "'," + 
                           " Flag = '" + prpLrtextDto.getFlag() + "'" + 
			               " Where " +
                           " ClaimNo = '" + prpLrtextDto.getClaimNo() + "' And " + 
                           " TextType = '" + prpLrtextDto.getTextType() + "' And " + 
                           " SerialNo = " + prpLrtextDto.getSerialNo() + " And " + 
                           " LineNo = " + prpLrtextDto.getLineNo() + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setDateTime(1,prpLrtextDto.getInputDate());
        dbManager.setString(2,prpLrtextDto.getContext());
        dbManager.setString(3,prpLrtextDto.getFlag());
        //设置条件字段;
        dbManager.setString(4,prpLrtextDto.getClaimNo());
        dbManager.setString(5,prpLrtextDto.getTextType());
        dbManager.setInt(6,prpLrtextDto.getSerialNo());
        dbManager.setInt(7,prpLrtextDto.getLineNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLrtextBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param claimNo 赔案号码
     * @param textType 文字说明类型 ▲
--** 出险摘要/查勘报告/结案报告
     * @param serialNo 序号
     * @param lineNo 行号
     * @return PrpLrtextDto
     * @throws Exception
     */
    public PrpLrtextDto findByPrimaryKey(String claimNo,String textType,int serialNo,int lineNo) throws Exception{
        String mainStatement = " Select ClaimNo," + 
                           " TextType," + 
                           " InputDate," + 
                           " SerialNo," + 
                           " LineNo," + 
                           " Context," + 
                           " Flag From PrpLrtext";
        String statement = mainStatement + " Where " +
                           " ClaimNo = ? And " + 
                           " TextType = ? And " + 
                           " SerialNo = ? And " + 
                           " LineNo = ?";
        PrpLrtextDto prpLrtextDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " ClaimNo = '" + claimNo + "' And " + 
                           " TextType = '" + textType + "' And " + 
                           " SerialNo = " + serialNo + " And " + 
                           " LineNo = " + lineNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,claimNo);
        dbManager.setString(2,textType);
        dbManager.setInt(3,serialNo);
        dbManager.setInt(4,lineNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLrtextDto = new PrpLrtextDto();
            prpLrtextDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLrtextDto.setTextType(dbManager.getString(resultSet,2));
            prpLrtextDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,3));
            prpLrtextDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpLrtextDto.setLineNo(dbManager.getInt(resultSet,5));
            prpLrtextDto.setContext(dbManager.getString(resultSet,6));
            prpLrtextDto.setFlag(dbManager.getString(resultSet,7));
            logger.info("DBPrpLrtextBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLrtextBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLrtextDto;
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
                           " TextType," + 
                           " InputDate," + 
                           " SerialNo," + 
                           " LineNo," + 
                           " Context," + 
                           " Flag From PrpLrtext Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLrtextDto prpLrtextDto = null;
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

            prpLrtextDto = new PrpLrtextDto();
            prpLrtextDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLrtextDto.setTextType(dbManager.getString(resultSet,2));
            prpLrtextDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,3));
            prpLrtextDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpLrtextDto.setLineNo(dbManager.getInt(resultSet,5));
            prpLrtextDto.setContext(dbManager.getString(resultSet,6));
            prpLrtextDto.setFlag(dbManager.getString(resultSet,7));
            collection.add(prpLrtextDto);
        }
        resultSet.close();
        logger.info("DBPrpLrtextBase.findByConditions() success!");
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
        String statement = "Delete From PrpLrtext Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLrtextBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLrtext Where " + conditions;
           statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLrtextBase.getCount() success!");
        return count;
    }
}
