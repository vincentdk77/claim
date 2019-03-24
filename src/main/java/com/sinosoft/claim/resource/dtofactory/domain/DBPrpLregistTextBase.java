package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLregistTextDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLregistText-报案文字表的数据访问对象基类<br>
 * 创建于 2005-03-18 17:53:37.171<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLregistTextBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpLregistTextBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLregistTextBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLregistTextDto prpLregistTextDto
     * @throws Exception
     */
    public void insert(PrpLregistTextDto prpLregistTextDto) throws Exception{
        String mainStatement = " Insert Into PrpLregistText (" + 
                           " RegistNo," + 
                           " TextType," + 
                           " LineNo," + 
                           " Context," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLregistTextDto.getRegistNo() + "'," + 
                           "'" + prpLregistTextDto.getTextType() + "'," + 
                           "" + prpLregistTextDto.getLineNo() + "," + 
                           "'" + prpLregistTextDto.getContext() + "'," + 
                           "'" + prpLregistTextDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLregistTextDto.getRegistNo());
        dbManager.setString(2,prpLregistTextDto.getTextType());
        dbManager.setInt(3,prpLregistTextDto.getLineNo());
        dbManager.setString(4,prpLregistTextDto.getContext());
        dbManager.setString(5,prpLregistTextDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLregistTextBase.insert() success!");
    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLregistText (" + 
                           " RegistNo," + 
                           " TextType," + 
                           " LineNo," + 
                           " Context," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLregistTextDto prpLregistTextDto = (PrpLregistTextDto)i.next();
            dbManager.setString(1,prpLregistTextDto.getRegistNo());
            dbManager.setString(2,prpLregistTextDto.getTextType());
            dbManager.setInt(3,prpLregistTextDto.getLineNo());
            dbManager.setString(4,prpLregistTextDto.getContext());
            dbManager.setString(5,prpLregistTextDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLregistTextBase.insertAll() success!");
    }

    /**
     * 按主键删除一条数据
     * @param registNo 出险登记号
     * @param textType 文本类型
     * @param lineNo 行号
     * @throws Exception
     */
    public void delete(String registNo,String textType,int lineNo) throws Exception{
        String statement = " Delete From PrpLregistText" + 
	            		   " Where " +
                           " RegistNo = ? And " + 
                           " TextType = ? And " + 
                           " LineNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLregistText Where " +
                           " RegistNo = '" + registNo + "' And " + 
                           " TextType = '" + textType + "' And " + 
                           " LineNo = " + lineNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,registNo);
        dbManager.setString(2,textType);
        dbManager.setInt(3,lineNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLregistTextBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLregistTextDto prpLregistTextDto
     * @throws Exception
     */
    public void update(PrpLregistTextDto prpLregistTextDto) throws Exception{
        String statement = " Update PrpLregistText Set Context = ?," + 
                           " Flag = ?" + 
	            		   " Where " +
                           " RegistNo = ? And " + 
                           " TextType = ? And " + 
                           " LineNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLregistText Set " + 
                           " RegistNo = '" + prpLregistTextDto.getRegistNo() + "'," + 
                           " TextType = '" + prpLregistTextDto.getTextType() + "'," + 
                           " LineNo = " + prpLregistTextDto.getLineNo() + "," + 
                           " Context = '" + prpLregistTextDto.getContext() + "'," + 
                           " Flag = '" + prpLregistTextDto.getFlag() + "'" + 
			               " Where " +
                           " RegistNo = '" + prpLregistTextDto.getRegistNo() + "' And " + 
                           " TextType = '" + prpLregistTextDto.getTextType() + "' And " + 
                           " LineNo = " + prpLregistTextDto.getLineNo() + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpLregistTextDto.getContext());
        dbManager.setString(2,prpLregistTextDto.getFlag());
        //设置条件字段;
        dbManager.setString(3,prpLregistTextDto.getRegistNo());
        dbManager.setString(4,prpLregistTextDto.getTextType());
        dbManager.setInt(5,prpLregistTextDto.getLineNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLregistTextBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param registNo 出险登记号
     * @param textType 文本类型
     * @param lineNo 行号
     * @return PrpLregistTextDto
     * @throws Exception
     */
    public PrpLregistTextDto findByPrimaryKey(String registNo,String textType,int lineNo) throws Exception{
        String mainStatement = " Select RegistNo," + 
                           " TextType," + 
                           " LineNo," + 
                           " Context," + 
                           " Flag From PrpLregistText";
        String statement = mainStatement + " Where " +
                           " RegistNo = ? And " + 
                           " TextType = ? And " + 
                           " LineNo = ?";
        PrpLregistTextDto prpLregistTextDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " RegistNo = '" + registNo + "' And " + 
                           " TextType = '" + textType + "' And " + 
                           " LineNo = " + lineNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,registNo);
        dbManager.setString(2,textType);
        dbManager.setInt(3,lineNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLregistTextDto = new PrpLregistTextDto();
            prpLregistTextDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLregistTextDto.setTextType(dbManager.getString(resultSet,2));
            prpLregistTextDto.setLineNo(dbManager.getInt(resultSet,3));
            prpLregistTextDto.setContext(dbManager.getString(resultSet,4));
            prpLregistTextDto.setFlag(dbManager.getString(resultSet,5));
            logger.info("DBPrpLregistTextBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLregistTextBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLregistTextDto;
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
        String statement = "Select RegistNo," + 
                           " TextType," + 
                           " LineNo," + 
                           " Context," + 
                           " Flag From PrpLregistText Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLregistTextDto prpLregistTextDto = null;
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

            prpLregistTextDto = new PrpLregistTextDto();
            prpLregistTextDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLregistTextDto.setTextType(dbManager.getString(resultSet,2));
            prpLregistTextDto.setLineNo(dbManager.getInt(resultSet,3));
            prpLregistTextDto.setContext(dbManager.getString(resultSet,4));
            prpLregistTextDto.setFlag(dbManager.getString(resultSet,5));
            collection.add(prpLregistTextDto);
        }
        resultSet.close();
        logger.info("DBPrpLregistTextBase.findByConditions() success!");
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
        String statement = "Delete From PrpLregistText Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLregistTextBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLregistText Where " + conditions;
           statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLregistTextBase.getCount() success!");
        return count;
    }
}
