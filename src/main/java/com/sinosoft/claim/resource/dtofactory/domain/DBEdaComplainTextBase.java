package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.EdaComplainTextDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是EdaComplainText投诉文字表的数据访问对象基类<br>
 * 创建于 2005-08-20 17:56:00.944<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBEdaComplainTextBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBEdaComplainTextBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBEdaComplainTextBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param edaComplainTextDto edaComplainTextDto
     * @throws Exception
     */
    public void insert(EdaComplainTextDto edaComplainTextDto) throws Exception{
        String mainStatement = " Insert Into EdaComplainText (" + 
                           " AcceptNo," + 
                           " TextType," + 
                           " SerialNo," + 
                           " LineNo," + 
                           " InputDate," + 
                           " Context," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + edaComplainTextDto.getAcceptNo() + "'," + 
                           "'" + edaComplainTextDto.getTextType() + "'," + 
                           "'" + edaComplainTextDto.getSerialNo() + "'," + 
                           "'" + edaComplainTextDto.getLineNo() + "'," + 
                           "'" + edaComplainTextDto.getInputDate() + "'," + 
                           "'" + edaComplainTextDto.getContext() + "'," + 
                           "'" + edaComplainTextDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setDouble(1,edaComplainTextDto.getAcceptNo());
        dbManager.setString(2,edaComplainTextDto.getTextType());
        dbManager.setDouble(3,edaComplainTextDto.getSerialNo());
        dbManager.setDouble(4,edaComplainTextDto.getLineNo());
        dbManager.setDateTime(5,edaComplainTextDto.getInputDate());
        dbManager.setString(6,edaComplainTextDto.getContext());
        dbManager.setString(7,edaComplainTextDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBEdaComplainTextBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            EdaComplainTextDto edaComplainTextDto = (EdaComplainTextDto)i.next();
            insert(edaComplainTextDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param acceptNo 投诉登记号
     * @param textType 文本类型
     * @param serialNo 序号
     * @param lineNo 行号
     * @throws Exception
     */
    public void delete(double acceptNo,String textType,double serialNo,double lineNo) throws Exception{
        String statement = " Delete From EdaComplainText" + 
	            		   " Where " +
                           " AcceptNo = ? And " + 
                           " TextType = ? And " + 
                           " SerialNo = ? And " + 
                           " LineNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From EdaComplainText Where " +
                           " AcceptNo = '" + acceptNo + "' And " + 
                           " TextType = '" + textType + "' And " + 
                           " SerialNo = '" + serialNo + "' And " + 
                           " LineNo = '" + lineNo + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setDouble(1,acceptNo);
        dbManager.setString(2,textType);
        dbManager.setDouble(3,serialNo);
        dbManager.setDouble(4,lineNo);
        dbManager.executePreparedUpdate();
        logger.info("DBEdaComplainTextBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param edaComplainTextDto edaComplainTextDto
     * @throws Exception
     */
    public void update(EdaComplainTextDto edaComplainTextDto) throws Exception{
        String statement = " Update EdaComplainText Set InputDate = ?," + 
                           " Context = ?," + 
                           " Flag = ?" + 
	            		   " Where " +
                           " AcceptNo = ? And " + 
                           " TextType = ? And " + 
                           " SerialNo = ? And " + 
                           " LineNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update EdaComplainText Set " + 
                           " AcceptNo = '" + edaComplainTextDto.getAcceptNo() + "'," + 
                           " TextType = '" + edaComplainTextDto.getTextType() + "'," + 
                           " SerialNo = '" + edaComplainTextDto.getSerialNo() + "'," + 
                           " LineNo = '" + edaComplainTextDto.getLineNo() + "'," + 
                           " InputDate = '" + edaComplainTextDto.getInputDate() + "'," + 
                           " Context = '" + edaComplainTextDto.getContext() + "'," + 
                           " Flag = '" + edaComplainTextDto.getFlag() + "'" + 
			               " Where " +
                           " AcceptNo = '" + edaComplainTextDto.getAcceptNo() + "' And " + 
                           " TextType = '" + edaComplainTextDto.getTextType() + "' And " + 
                           " SerialNo = '" + edaComplainTextDto.getSerialNo() + "' And " + 
                           " LineNo = '" + edaComplainTextDto.getLineNo() + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setDateTime(1,edaComplainTextDto.getInputDate());
        dbManager.setString(2,edaComplainTextDto.getContext());
        dbManager.setString(3,edaComplainTextDto.getFlag());
        //设置条件字段;
        dbManager.setDouble(4,edaComplainTextDto.getAcceptNo());
        dbManager.setString(5,edaComplainTextDto.getTextType());
        dbManager.setDouble(6,edaComplainTextDto.getSerialNo());
        dbManager.setDouble(7,edaComplainTextDto.getLineNo());
        dbManager.executePreparedUpdate();

        logger.info("DBEdaComplainTextBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param acceptNo 投诉登记号
     * @param textType 文本类型
     * @param serialNo 序号
     * @param lineNo 行号
     * @return EdaComplainTextDto
     * @throws Exception
     */
    public EdaComplainTextDto findByPrimaryKey(double acceptNo,String textType,double serialNo,double lineNo) throws Exception{
        String mainStatement = " Select AcceptNo," + 
                           " TextType," + 
                           " SerialNo," + 
                           " LineNo," + 
                           " InputDate," + 
                           " Context," + 
                           " Flag From EdaComplainText";
        String statement = mainStatement + " Where " +
                           " AcceptNo = ? And " + 
                           " TextType = ? And " + 
                           " SerialNo = ? And " + 
                           " LineNo = ?";
        EdaComplainTextDto edaComplainTextDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " AcceptNo = '" + acceptNo + "' And " + 
                           " TextType = '" + textType + "' And " + 
                           " SerialNo = '" + serialNo + "' And " + 
                           " LineNo = '" + lineNo + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setDouble(1,acceptNo);
        dbManager.setString(2,textType);
        dbManager.setDouble(3,serialNo);
        dbManager.setDouble(4,lineNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            edaComplainTextDto = new EdaComplainTextDto();
            edaComplainTextDto.setAcceptNo(dbManager.getDouble(resultSet,1));
            edaComplainTextDto.setTextType(dbManager.getString(resultSet,2));
            edaComplainTextDto.setSerialNo(dbManager.getDouble(resultSet,3));
            edaComplainTextDto.setLineNo(dbManager.getDouble(resultSet,4));
            edaComplainTextDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,5));
            edaComplainTextDto.setContext(dbManager.getString(resultSet,6));
            edaComplainTextDto.setFlag(dbManager.getString(resultSet,7));
        }
        resultSet.close();
        logger.info("DBEdaComplainTextBase.findByPrimaryKey() success!");
        return edaComplainTextDto;
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
                           " TextType," + 
                           " SerialNo," + 
                           " LineNo," + 
                           " InputDate," + 
                           " Context," + 
                           " Flag From EdaComplainText Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        EdaComplainTextDto edaComplainTextDto = null;
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

            edaComplainTextDto = new EdaComplainTextDto();
            edaComplainTextDto.setAcceptNo(dbManager.getDouble(resultSet,1));
            edaComplainTextDto.setTextType(dbManager.getString(resultSet,2));
            edaComplainTextDto.setSerialNo(dbManager.getDouble(resultSet,3));
            edaComplainTextDto.setLineNo(dbManager.getDouble(resultSet,4));
            edaComplainTextDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,5));
            edaComplainTextDto.setContext(dbManager.getString(resultSet,6));
            edaComplainTextDto.setFlag(dbManager.getString(resultSet,7));
            collection.add(edaComplainTextDto);
        }
        resultSet.close();
        logger.info("DBEdaComplainTextBase.findByConditions() success!");
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
        String statement = "Delete From EdaComplainText Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBEdaComplainTextBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from EdaComplainText Where " + conditions;
        statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBEdaComplainTextBase.getCount() success!");
        return count;
    }
}
