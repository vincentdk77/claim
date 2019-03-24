package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLltextDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLltext-立案文字表的数据访问对象基类<br>
 * 创建于 2005-03-18 17:53:36.437<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLltextBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpLltextBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLltextBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLltextDto prpLltextDto
     * @throws Exception
     */
    public void insert(PrpLltextDto prpLltextDto) throws Exception{
        String mainStatement = " Insert Into PrpLltext (" + 
                           " ClaimNo," + 
                           " TextType," + 
                           " LineNo," + 
                           " Context," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLltextDto.getClaimNo() + "'," + 
                           "'" + prpLltextDto.getTextType() + "'," + 
                           "" + prpLltextDto.getLineNo() + "," + 
                           "'" + prpLltextDto.getContext() + "'," + 
                           "'" + prpLltextDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLltextDto.getClaimNo());
        dbManager.setString(2,prpLltextDto.getTextType());
        dbManager.setInt(3,prpLltextDto.getLineNo());
        dbManager.setString(4,prpLltextDto.getContext());
        dbManager.setString(5,prpLltextDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLltextBase.insert() success!");
    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLltext (" + 
                           " ClaimNo," + 
                           " TextType," + 
                           " LineNo," + 
                           " Context," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLltextDto prpLltextDto = (PrpLltextDto)i.next();
            dbManager.setString(1,prpLltextDto.getClaimNo());
            dbManager.setString(2,prpLltextDto.getTextType());
            dbManager.setInt(3,prpLltextDto.getLineNo());
            dbManager.setString(4,prpLltextDto.getContext());
            dbManager.setString(5,prpLltextDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLltextBase.insertAll() success!");
    }

    /**
     * 按主键删除一条数据
     * @param claimNo 赔案号码
     * @param textType 文字说明类型 ▲
--** 出险摘要/查勘报告/结案报告
     * @param lineNo 行号
     * @throws Exception
     */
    public void delete(String claimNo,String textType,int lineNo) throws Exception{
        String statement = " Delete From PrpLltext" + 
	            		   " Where " +
                           " ClaimNo = ? And " + 
                           " TextType = ? And " + 
                           " LineNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLltext Where " +
                           " ClaimNo = '" + claimNo + "' And " + 
                           " TextType = '" + textType + "' And " + 
                           " LineNo = " + lineNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,claimNo);
        dbManager.setString(2,textType);
        dbManager.setInt(3,lineNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLltextBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLltextDto prpLltextDto
     * @throws Exception
     */
    public void update(PrpLltextDto prpLltextDto) throws Exception{
        String statement = " Update PrpLltext Set Context = ?," + 
                           " Flag = ?" + 
	            		   " Where " +
                           " ClaimNo = ? And " + 
                           " TextType = ? And " + 
                           " LineNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLltext Set " + 
                           " ClaimNo = '" + prpLltextDto.getClaimNo() + "'," + 
                           " TextType = '" + prpLltextDto.getTextType() + "'," + 
                           " LineNo = " + prpLltextDto.getLineNo() + "," + 
                           " Context = '" + prpLltextDto.getContext() + "'," + 
                           " Flag = '" + prpLltextDto.getFlag() + "'" + 
			               " Where " +
                           " ClaimNo = '" + prpLltextDto.getClaimNo() + "' And " + 
                           " TextType = '" + prpLltextDto.getTextType() + "' And " + 
                           " LineNo = " + prpLltextDto.getLineNo() + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpLltextDto.getContext());
        dbManager.setString(2,prpLltextDto.getFlag());
        //设置条件字段;
        dbManager.setString(3,prpLltextDto.getClaimNo());
        dbManager.setString(4,prpLltextDto.getTextType());
        dbManager.setInt(5,prpLltextDto.getLineNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLltextBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param claimNo 赔案号码
     * @param textType 文字说明类型 ▲
--** 出险摘要/查勘报告/结案报告
     * @param lineNo 行号
     * @return PrpLltextDto
     * @throws Exception
     */
    public PrpLltextDto findByPrimaryKey(String claimNo,String textType,int lineNo) throws Exception{
        String mainStatement = " Select ClaimNo," + 
                           " TextType," + 
                           " LineNo," + 
                           " Context," + 
                           " Flag From PrpLltext";
        String statement = mainStatement + " Where " +
                           " ClaimNo = ? And " + 
                           " TextType = ? And " + 
                           " LineNo = ?";
        PrpLltextDto prpLltextDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " ClaimNo = '" + claimNo + "' And " + 
                           " TextType = '" + textType + "' And " + 
                           " LineNo = " + lineNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,claimNo);
        dbManager.setString(2,textType);
        dbManager.setInt(3,lineNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLltextDto = new PrpLltextDto();
            prpLltextDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLltextDto.setTextType(dbManager.getString(resultSet,2));
            prpLltextDto.setLineNo(dbManager.getInt(resultSet,3));
            prpLltextDto.setContext(dbManager.getString(resultSet,4));
            prpLltextDto.setFlag(dbManager.getString(resultSet,5));
            logger.info("DBPrpLltextBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLltextBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLltextDto;
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
                           " LineNo," + 
                           " Context," + 
                           " Flag From PrpLltext Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLltextDto prpLltextDto = null;
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

            prpLltextDto = new PrpLltextDto();
            prpLltextDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLltextDto.setTextType(dbManager.getString(resultSet,2));
            prpLltextDto.setLineNo(dbManager.getInt(resultSet,3));
            prpLltextDto.setContext(dbManager.getString(resultSet,4));
            prpLltextDto.setFlag(dbManager.getString(resultSet,5));
            collection.add(prpLltextDto);
        }
        resultSet.close();
        logger.info("DBPrpLltextBase.findByConditions() success!");
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
        String statement = "Delete From PrpLltext Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLltextBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLltext Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLltextBase.getCount() success!");
        return count;
    }
}
