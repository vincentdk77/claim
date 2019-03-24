package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.SwfPackageDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是SwfPackage工作流日志业务信息表（新增）的数据访问对象基类<br>
 * 创建于 2005-03-18 17:53:37.828<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBSwfPackageBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBSwfPackageBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBSwfPackageBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param swfPackageDto swfPackageDto
     * @throws Exception
     */
    public void insert(SwfPackageDto swfPackageDto) throws Exception{
        String mainStatement = " Insert Into SwfPackage (" + 
                           " PackageID," + 
                           " DetailNo," + 
                           " DetailContent," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + swfPackageDto.getPackageID() + "'," + 
                           "" + swfPackageDto.getDetailNo() + "," + 
                           "'" + swfPackageDto.getDetailContent() + "'," + 
                           "'" + swfPackageDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,swfPackageDto.getPackageID());
        dbManager.setInt(2,swfPackageDto.getDetailNo());
        dbManager.setString(3,swfPackageDto.getDetailContent());
        dbManager.setString(4,swfPackageDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBSwfPackageBase.insert() success!");
    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into SwfPackage (" + 
                           " PackageID," + 
                           " DetailNo," + 
                           " DetailContent," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            SwfPackageDto swfPackageDto = (SwfPackageDto)i.next();
            dbManager.setString(1,swfPackageDto.getPackageID());
            dbManager.setInt(2,swfPackageDto.getDetailNo());
            dbManager.setString(3,swfPackageDto.getDetailContent());
            dbManager.setString(4,swfPackageDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBSwfPackageBase.insertAll() success!");
    }

    /**
     * 按主键删除一条数据
     * @param packageID 工作流信息包ID
     * @param detailNo 明细项序号
     * @throws Exception
     */
    public void delete(String packageID,int detailNo) throws Exception{
        String statement = " Delete From SwfPackage" + 
	            		   " Where " +
                           " PackageID = ? And " + 
                           " DetailNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From SwfPackage Where " +
                           " PackageID = '" + packageID + "' And " + 
                           " DetailNo = " + detailNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,packageID);
        dbManager.setInt(2,detailNo);
        dbManager.executePreparedUpdate();
        logger.info("DBSwfPackageBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param swfPackageDto swfPackageDto
     * @throws Exception
     */
    public void update(SwfPackageDto swfPackageDto) throws Exception{
        String statement = " Update SwfPackage Set DetailContent = ?," + 
                           " Flag = ?" + 
	            		   " Where " +
                           " PackageID = ? And " + 
                           " DetailNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update SwfPackage Set " + 
                           " PackageID = '" + swfPackageDto.getPackageID() + "'," + 
                           " DetailNo = " + swfPackageDto.getDetailNo() + "," + 
                           " DetailContent = '" + swfPackageDto.getDetailContent() + "'," + 
                           " Flag = '" + swfPackageDto.getFlag() + "'" + 
			               " Where " +
                           " PackageID = '" + swfPackageDto.getPackageID() + "' And " + 
                           " DetailNo = " + swfPackageDto.getDetailNo() + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,swfPackageDto.getDetailContent());
        dbManager.setString(2,swfPackageDto.getFlag());
        //设置条件字段;
        dbManager.setString(3,swfPackageDto.getPackageID());
        dbManager.setInt(4,swfPackageDto.getDetailNo());
        dbManager.executePreparedUpdate();

        logger.info("DBSwfPackageBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param packageID 工作流信息包ID
     * @param detailNo 明细项序号
     * @return SwfPackageDto
     * @throws Exception
     */
    public SwfPackageDto findByPrimaryKey(String packageID,int detailNo) throws Exception{
        String mainStatement = " Select PackageID," + 
                           " DetailNo," + 
                           " DetailContent," + 
                           " Flag From SwfPackage";
        String statement = mainStatement + " Where " +
                           " PackageID = ? And " + 
                           " DetailNo = ?";
        SwfPackageDto swfPackageDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " PackageID = '" + packageID + "' And " + 
                           " DetailNo = " + detailNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,packageID);
        dbManager.setInt(2,detailNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            swfPackageDto = new SwfPackageDto();
            swfPackageDto.setPackageID(dbManager.getString(resultSet,1));
            swfPackageDto.setDetailNo(dbManager.getInt(resultSet,2));
            swfPackageDto.setDetailContent(dbManager.getString(resultSet,3));
            swfPackageDto.setFlag(dbManager.getString(resultSet,4));
            logger.info("DBSwfPackageBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBSwfPackageBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return swfPackageDto;
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
        String statement = "Select PackageID," + 
                           " DetailNo," + 
                           " DetailContent," + 
                           " Flag From SwfPackage Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        SwfPackageDto swfPackageDto = null;
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

            swfPackageDto = new SwfPackageDto();
            swfPackageDto.setPackageID(dbManager.getString(resultSet,1));
            swfPackageDto.setDetailNo(dbManager.getInt(resultSet,2));
            swfPackageDto.setDetailContent(dbManager.getString(resultSet,3));
            swfPackageDto.setFlag(dbManager.getString(resultSet,4));
            collection.add(swfPackageDto);
        }
        resultSet.close();
        logger.info("DBSwfPackageBase.findByConditions() success!");
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
        String statement = "Delete From SwfPackage Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBSwfPackageBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from SwfPackage Where " + conditions;
        statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBSwfPackageBase.getCount() success!");
        return count;
    }
}
