package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLacciCheckTextDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLacciCheckText--调查文本信息表的数据访问对象基类<br>
 * 创建于 2005-06-17 18:16:56.877<br>
 * JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLacciCheckTextBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpLacciCheckTextBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLacciCheckTextBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLacciCheckTextDto prpLacciCheckTextDto
     * @throws Exception
     */
    public void insert(PrpLacciCheckTextDto prpLacciCheckTextDto) throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLacciCheckText (");
        buffer.append("CheckNo,");
        buffer.append("TextType,");
        buffer.append("LineNo,");
        buffer.append("Context,");
        buffer.append("Flag ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLacciCheckTextDto.getCheckNo()).append("',");
            debugBuffer.append("'").append(prpLacciCheckTextDto.getTextType()).append("',");
            debugBuffer.append("").append(prpLacciCheckTextDto.getLineNo()).append(",");
            debugBuffer.append("'").append(prpLacciCheckTextDto.getContext()).append("',");
            debugBuffer.append("'").append(prpLacciCheckTextDto.getFlag()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLacciCheckTextDto.getCheckNo());
        dbManager.setString(2,prpLacciCheckTextDto.getTextType());
        dbManager.setLong(3,prpLacciCheckTextDto.getLineNo());
        dbManager.setString(4,prpLacciCheckTextDto.getContext());
        dbManager.setString(5,prpLacciCheckTextDto.getFlag());
        dbManager.executePreparedUpdate();

    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLacciCheckText (");
        buffer.append("CheckNo,");
        buffer.append("TextType,");
        buffer.append("LineNo,");
        buffer.append("Context,");
        buffer.append("Flag ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLacciCheckTextDto prpLacciCheckTextDto = (PrpLacciCheckTextDto)i.next();
            dbManager.setString(1,prpLacciCheckTextDto.getCheckNo());
            dbManager.setString(2,prpLacciCheckTextDto.getTextType());
            dbManager.setLong(3,prpLacciCheckTextDto.getLineNo());
            dbManager.setString(4,prpLacciCheckTextDto.getContext());
            dbManager.setString(5,prpLacciCheckTextDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param checkNo 调查号
     * @param textType 文字说明类型
     * @param lineNo 行号
     * @throws Exception
     */
    public void delete(String checkNo,String textType,long lineNo) throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLacciCheckText ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("CheckNo=").append("'").append(checkNo).append("' AND ");
            debugBuffer.append("TextType=").append("'").append(textType).append("' AND ");
            debugBuffer.append("LineNo=").append("").append(lineNo).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("CheckNo = ? And ");
        buffer.append("TextType = ? And ");
        buffer.append("LineNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,checkNo);
        dbManager.setString(2,textType);
        dbManager.setLong(3,lineNo);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLacciCheckTextDto prpLacciCheckTextDto
     * @throws Exception
     */
    public void update(PrpLacciCheckTextDto prpLacciCheckTextDto) throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLacciCheckText SET ");
        buffer.append("Context = ?, ");
        buffer.append("Flag = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("CheckNo=").append("'").append(prpLacciCheckTextDto.getCheckNo()).append("' AND ");
            debugBuffer.append("TextType=").append("'").append(prpLacciCheckTextDto.getTextType()).append("' AND ");
            debugBuffer.append("LineNo=").append("").append(prpLacciCheckTextDto.getLineNo()).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("CheckNo = ? And ");
        buffer.append("TextType = ? And ");
        buffer.append("LineNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prpLacciCheckTextDto.getContext());
        dbManager.setString(2,prpLacciCheckTextDto.getFlag());
        //设置条件字段;
        dbManager.setString(3,prpLacciCheckTextDto.getCheckNo());
        dbManager.setString(4,prpLacciCheckTextDto.getTextType());
        dbManager.setLong(5,prpLacciCheckTextDto.getLineNo());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param checkNo 调查号
     * @param textType 文字说明类型
     * @param lineNo 行号
     * @return PrpLacciCheckTextDto
     * @throws Exception
     */
    public PrpLacciCheckTextDto findByPrimaryKey(String checkNo,String textType,long lineNo) throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("CheckNo,");
        buffer.append("TextType,");
        buffer.append("LineNo,");
        buffer.append("Context,");
        buffer.append("Flag ");
        buffer.append("FROM PrpLacciCheckText ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("CheckNo=").append("'").append(checkNo).append("' AND ");
            debugBuffer.append("TextType=").append("'").append(textType).append("' AND ");
            debugBuffer.append("LineNo=").append("").append(lineNo).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("CheckNo = ? And ");
        buffer.append("TextType = ? And ");
        buffer.append("LineNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,checkNo);
        dbManager.setString(2,textType);
        dbManager.setLong(3,lineNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLacciCheckTextDto prpLacciCheckTextDto = null;
        if(resultSet.next()){
            prpLacciCheckTextDto = new PrpLacciCheckTextDto();
            prpLacciCheckTextDto.setCheckNo(dbManager.getString(resultSet,1));
            prpLacciCheckTextDto.setTextType(dbManager.getString(resultSet,2));
            prpLacciCheckTextDto.setLineNo(dbManager.getLong(resultSet,3));
            prpLacciCheckTextDto.setContext(dbManager.getString(resultSet,4));
            prpLacciCheckTextDto.setFlag(dbManager.getString(resultSet,5));
        }else{
            logger.info("DBPrpLacciCheckTextBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLacciCheckTextDto;
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
        buffer.append("CheckNo,");
        buffer.append("TextType,");
        buffer.append("LineNo,");
        buffer.append("Context,");
        buffer.append("Flag ");
        buffer.append("FROM PrpLacciCheckText WHERE ");
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
        PrpLacciCheckTextDto prpLacciCheckTextDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                	break;
                }
            }

            prpLacciCheckTextDto = new PrpLacciCheckTextDto();
            prpLacciCheckTextDto.setCheckNo(dbManager.getString(resultSet,1));
            prpLacciCheckTextDto.setTextType(dbManager.getString(resultSet,2));
            prpLacciCheckTextDto.setLineNo(dbManager.getLong(resultSet,3));
            prpLacciCheckTextDto.setContext(dbManager.getString(resultSet,4));
            prpLacciCheckTextDto.setFlag(dbManager.getString(resultSet,5));
            collection.add(prpLacciCheckTextDto);
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
        buffer.append("DELETE FROM PrpLacciCheckText WHERE ");
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
        String  statement ;
                          statement = "SELECT count(1) FROM PrpLacciCheckText WHERE ";
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
