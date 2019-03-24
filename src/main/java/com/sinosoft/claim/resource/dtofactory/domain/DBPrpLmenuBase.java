package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLmenuDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLmenu-菜单表(新增)的数据访问对象基类<br>
 * 创建于 2005-05-08 15:15:52.953<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLmenuBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpLmenuBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLmenuBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLmenuDto prpLmenuDto
     * @throws Exception
     */
    public void insert(PrpLmenuDto prpLmenuDto) throws Exception{
        String mainStatement = " Insert Into PrpLmenu (" + 
                           " FuncID," + 
                           " FuncLevel," + 
                           " ParentID," + 
                           " FuncCName," + 
                           " FuncEName," + 
                           " FuncType," + 
                           " UseFlag," + 
                           " Image," + 
                           " ImageExpand," + 
                           " ImageCollapse," + 
                           " TaskCode," + 
                           " CheckCode," + 
                           " IconExpand," + 
                           " IconCollapse," + 
                           " Param," + 
                           " ModelName," + 
                           " SortNo," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLmenuDto.getFuncID() + "'," + 
                           "'" + prpLmenuDto.getFuncLevel() + "'," + 
                           "'" + prpLmenuDto.getParentID() + "'," + 
                           "'" + prpLmenuDto.getFuncCName() + "'," + 
                           "'" + prpLmenuDto.getFuncEName() + "'," + 
                           "'" + prpLmenuDto.getFuncType() + "'," + 
                           "'" + prpLmenuDto.getUseFlag() + "'," + 
                           "'" + prpLmenuDto.getImage() + "'," + 
                           "'" + prpLmenuDto.getImageExpand() + "'," + 
                           "'" + prpLmenuDto.getImageCollapse() + "'," + 
                           "'" + prpLmenuDto.getTaskCode() + "'," + 
                           "'" + prpLmenuDto.getCheckCode() + "'," + 
                           "'" + prpLmenuDto.getIconExpand() + "'," + 
                           "'" + prpLmenuDto.getIconCollapse() + "'," + 
                           "'" + prpLmenuDto.getParam() + "'," + 
                           "'" + prpLmenuDto.getModelName() + "'," + 
                           "" + prpLmenuDto.getSortNo() + "," + 
                           "'" + prpLmenuDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLmenuDto.getFuncID());
        dbManager.setString(2,prpLmenuDto.getFuncLevel());
        dbManager.setString(3,prpLmenuDto.getParentID());
        dbManager.setString(4,prpLmenuDto.getFuncCName());
        dbManager.setString(5,prpLmenuDto.getFuncEName());
        dbManager.setString(6,prpLmenuDto.getFuncType());
        dbManager.setString(7,prpLmenuDto.getUseFlag());
        dbManager.setString(8,prpLmenuDto.getImage());
        dbManager.setString(9,prpLmenuDto.getImageExpand());
        dbManager.setString(10,prpLmenuDto.getImageCollapse());
        dbManager.setString(11,prpLmenuDto.getTaskCode());
        dbManager.setString(12,prpLmenuDto.getCheckCode());
        dbManager.setString(13,prpLmenuDto.getIconExpand());
        dbManager.setString(14,prpLmenuDto.getIconCollapse());
        dbManager.setString(15,prpLmenuDto.getParam());
        dbManager.setString(16,prpLmenuDto.getModelName());
        dbManager.setInt(17,prpLmenuDto.getSortNo());
        dbManager.setString(18,prpLmenuDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLmenuBase.insert() success!");
    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLmenu (" + 
                           " FuncID," + 
                           " FuncLevel," + 
                           " ParentID," + 
                           " FuncCName," + 
                           " FuncEName," + 
                           " FuncType," + 
                           " UseFlag," + 
                           " Image," + 
                           " ImageExpand," + 
                           " ImageCollapse," + 
                           " TaskCode," + 
                           " CheckCode," + 
                           " IconExpand," + 
                           " IconCollapse," + 
                           " Param," + 
                           " ModelName," + 
                           " SortNo," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLmenuDto prpLmenuDto = (PrpLmenuDto)i.next();
            dbManager.setString(1,prpLmenuDto.getFuncID());
            dbManager.setString(2,prpLmenuDto.getFuncLevel());
            dbManager.setString(3,prpLmenuDto.getParentID());
            dbManager.setString(4,prpLmenuDto.getFuncCName());
            dbManager.setString(5,prpLmenuDto.getFuncEName());
            dbManager.setString(6,prpLmenuDto.getFuncType());
            dbManager.setString(7,prpLmenuDto.getUseFlag());
            dbManager.setString(8,prpLmenuDto.getImage());
            dbManager.setString(9,prpLmenuDto.getImageExpand());
            dbManager.setString(10,prpLmenuDto.getImageCollapse());
            dbManager.setString(11,prpLmenuDto.getTaskCode());
            dbManager.setString(12,prpLmenuDto.getCheckCode());
            dbManager.setString(13,prpLmenuDto.getIconExpand());
            dbManager.setString(14,prpLmenuDto.getIconCollapse());
            dbManager.setString(15,prpLmenuDto.getParam());
            dbManager.setString(16,prpLmenuDto.getModelName());
            dbManager.setInt(17,prpLmenuDto.getSortNo());
            dbManager.setString(18,prpLmenuDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLmenuBase.insertAll() success!");
    }

    /**
     * 按主键删除一条数据
     * @param funcID 菜单功能代码
     * @throws Exception
     */
    public void delete(String funcID) throws Exception{
        String statement = " Delete From PrpLmenu" + 
	            		   " Where " +
                           " FuncID = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLmenu Where " +
                           " FuncID = '" + funcID + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,funcID);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLmenuBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLmenuDto prpLmenuDto
     * @throws Exception
     */
    public void update(PrpLmenuDto prpLmenuDto) throws Exception{
        String statement = " Update PrpLmenu Set FuncLevel = ?," + 
                           " ParentID = ?," + 
                           " FuncCName = ?," + 
                           " FuncEName = ?," + 
                           " FuncType = ?," + 
                           " UseFlag = ?," + 
                           " Image = ?," + 
                           " ImageExpand = ?," + 
                           " ImageCollapse = ?," + 
                           " TaskCode = ?," + 
                           " CheckCode = ?," + 
                           " IconExpand = ?," + 
                           " IconCollapse = ?," + 
                           " Param = ?," + 
                           " ModelName = ?," + 
                           " SortNo = ?," + 
                           " Flag = ?" + 
	            		   " Where " +
                           " FuncID = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLmenu Set " + 
                           " FuncID = '" + prpLmenuDto.getFuncID() + "'," + 
                           " FuncLevel = '" + prpLmenuDto.getFuncLevel() + "'," + 
                           " ParentID = '" + prpLmenuDto.getParentID() + "'," + 
                           " FuncCName = '" + prpLmenuDto.getFuncCName() + "'," + 
                           " FuncEName = '" + prpLmenuDto.getFuncEName() + "'," + 
                           " FuncType = '" + prpLmenuDto.getFuncType() + "'," + 
                           " UseFlag = '" + prpLmenuDto.getUseFlag() + "'," + 
                           " Image = '" + prpLmenuDto.getImage() + "'," + 
                           " ImageExpand = '" + prpLmenuDto.getImageExpand() + "'," + 
                           " ImageCollapse = '" + prpLmenuDto.getImageCollapse() + "'," + 
                           " TaskCode = '" + prpLmenuDto.getTaskCode() + "'," + 
                           " CheckCode = '" + prpLmenuDto.getCheckCode() + "'," + 
                           " IconExpand = '" + prpLmenuDto.getIconExpand() + "'," + 
                           " IconCollapse = '" + prpLmenuDto.getIconCollapse() + "'," + 
                           " Param = '" + prpLmenuDto.getParam() + "'," + 
                           " ModelName = '" + prpLmenuDto.getModelName() + "'," + 
                           " SortNo = " + prpLmenuDto.getSortNo() + "," + 
                           " Flag = '" + prpLmenuDto.getFlag() + "'" + 
			               " Where " +
                           " FuncID = '" + prpLmenuDto.getFuncID() + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpLmenuDto.getFuncLevel());
        dbManager.setString(2,prpLmenuDto.getParentID());
        dbManager.setString(3,prpLmenuDto.getFuncCName());
        dbManager.setString(4,prpLmenuDto.getFuncEName());
        dbManager.setString(5,prpLmenuDto.getFuncType());
        dbManager.setString(6,prpLmenuDto.getUseFlag());
        dbManager.setString(7,prpLmenuDto.getImage());
        dbManager.setString(8,prpLmenuDto.getImageExpand());
        dbManager.setString(9,prpLmenuDto.getImageCollapse());
        dbManager.setString(10,prpLmenuDto.getTaskCode());
        dbManager.setString(11,prpLmenuDto.getCheckCode());
        dbManager.setString(12,prpLmenuDto.getIconExpand());
        dbManager.setString(13,prpLmenuDto.getIconCollapse());
        dbManager.setString(14,prpLmenuDto.getParam());
        dbManager.setString(15,prpLmenuDto.getModelName());
        dbManager.setInt(16,prpLmenuDto.getSortNo());
        dbManager.setString(17,prpLmenuDto.getFlag());
        //设置条件字段;
        dbManager.setString(18,prpLmenuDto.getFuncID());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLmenuBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param funcID 菜单功能代码
     * @return PrpLmenuDto
     * @throws Exception
     */
    public PrpLmenuDto findByPrimaryKey(String funcID) throws Exception{
        String mainStatement = " Select FuncID," + 
                           " FuncLevel," + 
                           " ParentID," + 
                           " FuncCName," + 
                           " FuncEName," + 
                           " FuncType," + 
                           " UseFlag," + 
                           " Image," + 
                           " ImageExpand," + 
                           " ImageCollapse," + 
                           " TaskCode," + 
                           " CheckCode," + 
                           " IconExpand," + 
                           " IconCollapse," + 
                           " Param," + 
                           " ModelName," + 
                           " SortNo," + 
                           " Flag From PrpLmenu";
        String statement = mainStatement + " Where " +
                           " FuncID = ?";
        PrpLmenuDto prpLmenuDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " FuncID = '" + funcID + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,funcID);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLmenuDto = new PrpLmenuDto();
            prpLmenuDto.setFuncID(dbManager.getString(resultSet,1));
            prpLmenuDto.setFuncLevel(dbManager.getString(resultSet,2));
            prpLmenuDto.setParentID(dbManager.getString(resultSet,3));
            prpLmenuDto.setFuncCName(dbManager.getString(resultSet,4));
            prpLmenuDto.setFuncEName(dbManager.getString(resultSet,5));
            prpLmenuDto.setFuncType(dbManager.getString(resultSet,6));
            prpLmenuDto.setUseFlag(dbManager.getString(resultSet,7));
            prpLmenuDto.setImage(dbManager.getString(resultSet,8));
            prpLmenuDto.setImageExpand(dbManager.getString(resultSet,9));
            prpLmenuDto.setImageCollapse(dbManager.getString(resultSet,10));
            prpLmenuDto.setTaskCode(dbManager.getString(resultSet,11));
            prpLmenuDto.setCheckCode(dbManager.getString(resultSet,12));
            prpLmenuDto.setIconExpand(dbManager.getString(resultSet,13));
            prpLmenuDto.setIconCollapse(dbManager.getString(resultSet,14));
            prpLmenuDto.setParam(dbManager.getString(resultSet,15));
            prpLmenuDto.setModelName(dbManager.getString(resultSet,16));
            prpLmenuDto.setSortNo(dbManager.getInt(resultSet,17));
            prpLmenuDto.setFlag(dbManager.getString(resultSet,18));
            logger.info("DBPrpLmenuBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLmenuBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLmenuDto;
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
        String statement = "Select FuncID," + 
                           " FuncLevel," + 
                           " ParentID," + 
                           " FuncCName," + 
                           " FuncEName," + 
                           " FuncType," + 
                           " UseFlag," + 
                           " Image," + 
                           " ImageExpand," + 
                           " ImageCollapse," + 
                           " TaskCode," + 
                           " CheckCode," + 
                           " IconExpand," + 
                           " IconCollapse," + 
                           " Param," + 
                           " ModelName," + 
                           " SortNo," + 
                           " Flag From PrpLmenu Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLmenuDto prpLmenuDto = null;
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

            prpLmenuDto = new PrpLmenuDto();
            prpLmenuDto.setFuncID(dbManager.getString(resultSet,1));
            prpLmenuDto.setFuncLevel(dbManager.getString(resultSet,2));
            prpLmenuDto.setParentID(dbManager.getString(resultSet,3));
            prpLmenuDto.setFuncCName(dbManager.getString(resultSet,4));
            prpLmenuDto.setFuncEName(dbManager.getString(resultSet,5));
            prpLmenuDto.setFuncType(dbManager.getString(resultSet,6));
            prpLmenuDto.setUseFlag(dbManager.getString(resultSet,7));
            prpLmenuDto.setImage(dbManager.getString(resultSet,8));
            prpLmenuDto.setImageExpand(dbManager.getString(resultSet,9));
            prpLmenuDto.setImageCollapse(dbManager.getString(resultSet,10));
            prpLmenuDto.setTaskCode(dbManager.getString(resultSet,11));
            prpLmenuDto.setCheckCode(dbManager.getString(resultSet,12));
            prpLmenuDto.setIconExpand(dbManager.getString(resultSet,13));
            prpLmenuDto.setIconCollapse(dbManager.getString(resultSet,14));
            prpLmenuDto.setParam(dbManager.getString(resultSet,15));
            prpLmenuDto.setModelName(dbManager.getString(resultSet,16));
            prpLmenuDto.setSortNo(dbManager.getInt(resultSet,17));
            prpLmenuDto.setFlag(dbManager.getString(resultSet,18));
            collection.add(prpLmenuDto);
        }
        resultSet.close();
        logger.info("DBPrpLmenuBase.findByConditions() success!");
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
        String statement = "Delete From PrpLmenu Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLmenuBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLmenu Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLmenuBase.getCount() success!");
        return count;
    }
}
