package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLbackVisitTextDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLbackVisitText--回访备注表的数据访问对象基类<br>
 * 创建于 2005-03-23 09:00:36.671<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLbackVisitTextBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpLbackVisitTextBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLbackVisitTextBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLbackVisitTextDto prpLbackVisitTextDto
     * @throws Exception
     */
    public void insert(PrpLbackVisitTextDto prpLbackVisitTextDto) throws Exception{
        String mainStatement = " Insert Into PrpLbackVisitText (" + 
                           " BackVisitID," + 
                           " RegistNo," + 
                           " BackVisitType," + 
                           " LineNo," + 
                           " OperatorCode," + 
                           " Content," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "" + prpLbackVisitTextDto.getBackVisitID() + "," + 
                           "'" + prpLbackVisitTextDto.getRegistNo() + "'," + 
                           "'" + prpLbackVisitTextDto.getBackVisitType() + "'," + 
                           "" + prpLbackVisitTextDto.getLineNo() + "," + 
                           "'" + prpLbackVisitTextDto.getOperatorCode() + "'," + 
                           "'" + prpLbackVisitTextDto.getContent() + "'," + 
                           "'" + prpLbackVisitTextDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setInt(1,prpLbackVisitTextDto.getBackVisitID());
        dbManager.setString(2,prpLbackVisitTextDto.getRegistNo());
        dbManager.setString(3,prpLbackVisitTextDto.getBackVisitType());
        dbManager.setInt(4,prpLbackVisitTextDto.getLineNo());
        dbManager.setString(5,prpLbackVisitTextDto.getOperatorCode());
        dbManager.setString(6,prpLbackVisitTextDto.getContent());
        dbManager.setString(7,prpLbackVisitTextDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLbackVisitTextBase.insert() success!");
    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLbackVisitText (" + 
                           " BackVisitID," + 
                           " RegistNo," + 
                           " BackVisitType," + 
                           " LineNo," + 
                           " OperatorCode," + 
                           " Content," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLbackVisitTextDto prpLbackVisitTextDto = (PrpLbackVisitTextDto)i.next();
            dbManager.setInt(1,prpLbackVisitTextDto.getBackVisitID());
            dbManager.setString(2,prpLbackVisitTextDto.getRegistNo());
            dbManager.setString(3,prpLbackVisitTextDto.getBackVisitType());
            dbManager.setInt(4,prpLbackVisitTextDto.getLineNo());
            dbManager.setString(5,prpLbackVisitTextDto.getOperatorCode());
            dbManager.setString(6,prpLbackVisitTextDto.getContent());
            dbManager.setString(7,prpLbackVisitTextDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLbackVisitTextBase.insertAll() success!");
    }

    /**
     * 按主键删除一条数据
     * @param backVisitID 客户回访记录ID
     * @param registNo 报案号码
     * @param backVisitType 业务类型
     * @param lineNo 行序号
     * @throws Exception
     */
    public void delete(int backVisitID,String registNo,String backVisitType,int lineNo) throws Exception{
        String statement = " Delete From PrpLbackVisitText" + 
	            		   " Where " +
                           " BackVisitID = ? And " + 
                           " RegistNo = ? And " + 
                           " BackVisitType = ? And " + 
                           " LineNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLbackVisitText Where " +
                           " BackVisitID = " + backVisitID + " And " + 
                           " RegistNo = '" + registNo + "' And " + 
                           " BackVisitType = '" + backVisitType + "' And " + 
                           " LineNo = " + lineNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setInt(1,backVisitID);
        dbManager.setString(2,registNo);
        dbManager.setString(3,backVisitType);
        dbManager.setInt(4,lineNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLbackVisitTextBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLbackVisitTextDto prpLbackVisitTextDto
     * @throws Exception
     */
    public void update(PrpLbackVisitTextDto prpLbackVisitTextDto) throws Exception{
        String statement = " Update PrpLbackVisitText Set OperatorCode = ?," + 
                           " Content = ?," + 
                           " Flag = ?" + 
	            		   " Where " +
                           " BackVisitID = ? And " + 
                           " RegistNo = ? And " + 
                           " BackVisitType = ? And " + 
                           " LineNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLbackVisitText Set " + 
                           " BackVisitID = " + prpLbackVisitTextDto.getBackVisitID() + "," + 
                           " RegistNo = '" + prpLbackVisitTextDto.getRegistNo() + "'," + 
                           " BackVisitType = '" + prpLbackVisitTextDto.getBackVisitType() + "'," + 
                           " LineNo = " + prpLbackVisitTextDto.getLineNo() + "," + 
                           " OperatorCode = '" + prpLbackVisitTextDto.getOperatorCode() + "'," + 
                           " Content = '" + prpLbackVisitTextDto.getContent() + "'," + 
                           " Flag = '" + prpLbackVisitTextDto.getFlag() + "'" + 
			               " Where " +
                           " BackVisitID = " + prpLbackVisitTextDto.getBackVisitID() + " And " + 
                           " RegistNo = '" + prpLbackVisitTextDto.getRegistNo() + "' And " + 
                           " BackVisitType = '" + prpLbackVisitTextDto.getBackVisitType() + "' And " + 
                           " LineNo = " + prpLbackVisitTextDto.getLineNo() + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpLbackVisitTextDto.getOperatorCode());
        dbManager.setString(2,prpLbackVisitTextDto.getContent());
        dbManager.setString(3,prpLbackVisitTextDto.getFlag());
        //设置条件字段;
        dbManager.setInt(4,prpLbackVisitTextDto.getBackVisitID());
        dbManager.setString(5,prpLbackVisitTextDto.getRegistNo());
        dbManager.setString(6,prpLbackVisitTextDto.getBackVisitType());
        dbManager.setInt(7,prpLbackVisitTextDto.getLineNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLbackVisitTextBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param backVisitID 客户回访记录ID
     * @param registNo 报案号码
     * @param backVisitType 业务类型
     * @param lineNo 行序号
     * @return PrpLbackVisitTextDto
     * @throws Exception
     */
    public PrpLbackVisitTextDto findByPrimaryKey(int backVisitID,String registNo,String backVisitType,int lineNo) throws Exception{
        String mainStatement = " Select BackVisitID," + 
                           " RegistNo," + 
                           " BackVisitType," + 
                           " LineNo," + 
                           " OperatorCode," + 
                           " Content," + 
                           " Flag From PrpLbackVisitText";
        String statement = mainStatement + " Where " +
                           " BackVisitID = ? And " + 
                           " RegistNo = ? And " + 
                           " BackVisitType = ? And " + 
                           " LineNo = ?";
        PrpLbackVisitTextDto prpLbackVisitTextDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " BackVisitID = " + backVisitID + " And " + 
                           " RegistNo = '" + registNo + "' And " + 
                           " BackVisitType = '" + backVisitType + "' And " + 
                           " LineNo = " + lineNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setInt(1,backVisitID);
        dbManager.setString(2,registNo);
        dbManager.setString(3,backVisitType);
        dbManager.setInt(4,lineNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLbackVisitTextDto = new PrpLbackVisitTextDto();
            prpLbackVisitTextDto.setBackVisitID(dbManager.getInt(resultSet,1));
            prpLbackVisitTextDto.setRegistNo(dbManager.getString(resultSet,2));
            prpLbackVisitTextDto.setBackVisitType(dbManager.getString(resultSet,3));
            prpLbackVisitTextDto.setLineNo(dbManager.getInt(resultSet,4));
            prpLbackVisitTextDto.setOperatorCode(dbManager.getString(resultSet,5));
            prpLbackVisitTextDto.setContent(dbManager.getString(resultSet,6));
            prpLbackVisitTextDto.setFlag(dbManager.getString(resultSet,7));
            logger.info("DBPrpLbackVisitTextBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLbackVisitTextBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLbackVisitTextDto;
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
        String statement = "Select BackVisitID," + 
                           " RegistNo," + 
                           " BackVisitType," + 
                           " LineNo," + 
                           " OperatorCode," + 
                           " Content," + 
                           " Flag From PrpLbackVisitText Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLbackVisitTextDto prpLbackVisitTextDto = null;
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

            prpLbackVisitTextDto = new PrpLbackVisitTextDto();
            prpLbackVisitTextDto.setBackVisitID(dbManager.getInt(resultSet,1));
            prpLbackVisitTextDto.setRegistNo(dbManager.getString(resultSet,2));
            prpLbackVisitTextDto.setBackVisitType(dbManager.getString(resultSet,3));
            prpLbackVisitTextDto.setLineNo(dbManager.getInt(resultSet,4));
            prpLbackVisitTextDto.setOperatorCode(dbManager.getString(resultSet,5));
            prpLbackVisitTextDto.setContent(dbManager.getString(resultSet,6));
            prpLbackVisitTextDto.setFlag(dbManager.getString(resultSet,7));
            collection.add(prpLbackVisitTextDto);
        }
        resultSet.close();
        logger.info("DBPrpLbackVisitTextBase.findByConditions() success!");
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
        String statement = "Delete From PrpLbackVisitText Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLbackVisitTextBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpLbackVisitText Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLbackVisitTextBase.getCount() success!");
        return count;
    }
}
