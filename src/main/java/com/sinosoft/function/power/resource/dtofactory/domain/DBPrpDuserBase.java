package com.sinosoft.function.power.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.power.dto.domain.PrpDuserDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpDuser 员工代码表的数据访问对象基类<br>
 * 创建于 2004-11-09 18:30:40.408<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDuserBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpDuserBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpDuserBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpDuserDto prpDuserDto
     * @throws Exception
     */
    public void insert(PrpDuserDto prpDuserDto) throws Exception{
        String mainStatement = " Insert Into PrpDuser (" +
                           " UserCode," +
                           " UserName," +
                           " UserEName," +
                           " Password," +
                           " Seal," +
                           " PasswordSetDate," +
                           " PasswordExpireDate," +
                           " ComCode," +
                           " MakeCom," +
                           " AccountCode," +
                           " Phone," +
                           " Mobile," +
                           " Address," +
                           " PostCode," +
                           " Email," +
                           " UserFlag," +
                           " LoginSystem," +
                           " NewUserCode," +
                           " ValidStatus," +
                           " ArticleCode," +
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" +
                           "'" + prpDuserDto.getUserCode() + "'," +
                           "'" + prpDuserDto.getUserName() + "'," +
                           "'" + prpDuserDto.getUserEName() + "'," +
                           "'" + prpDuserDto.getPassword() + "'," +
                           "'" + prpDuserDto.getSeal() + "'," +
                           "'" + prpDuserDto.getPasswordSetDate() + "'," +
                           "'" + prpDuserDto.getPasswordExpireDate() + "'," +
                           "'" + prpDuserDto.getComCode() + "'," +
                           "'" + prpDuserDto.getMakeCom() + "'," +
                           "'" + prpDuserDto.getAccountCode() + "'," +
                           "'" + prpDuserDto.getPhone() + "'," +
                           "'" + prpDuserDto.getMobile() + "'," +
                           "'" + prpDuserDto.getAddress() + "'," +
                           "'" + prpDuserDto.getPostCode() + "'," +
                           "'" + prpDuserDto.getEmail() + "'," +
                           "'" + prpDuserDto.getUserFlag() + "'," +
                           "'" + prpDuserDto.getLoginSystem() + "'," +
                           "'" + prpDuserDto.getNewUserCode() + "'," +
                           "'" + prpDuserDto.getValidStatus() + "'," +
                           "'" + prpDuserDto.getArticleCode() + "'," +
                           "'" + prpDuserDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpDuserDto.getUserCode());
        dbManager.setString(2,prpDuserDto.getUserName());
        dbManager.setString(3,prpDuserDto.getUserEName());
        dbManager.setString(4,prpDuserDto.getPassword());
        dbManager.setString(5,prpDuserDto.getSeal());
        dbManager.setDateTime(6,prpDuserDto.getPasswordSetDate());
        dbManager.setDateTime(7,prpDuserDto.getPasswordExpireDate());
        dbManager.setString(8,prpDuserDto.getComCode());
        dbManager.setString(9,prpDuserDto.getMakeCom());
        dbManager.setString(10,prpDuserDto.getAccountCode());
        dbManager.setString(11,prpDuserDto.getPhone());
        dbManager.setString(12,prpDuserDto.getMobile());
        dbManager.setString(13,prpDuserDto.getAddress());
        dbManager.setString(14,prpDuserDto.getPostCode());
        dbManager.setString(15,prpDuserDto.getEmail());
        dbManager.setString(16,prpDuserDto.getUserFlag());
        dbManager.setString(17,prpDuserDto.getLoginSystem());
        dbManager.setString(18,prpDuserDto.getNewUserCode());
        dbManager.setString(19,prpDuserDto.getValidStatus());
        dbManager.setString(20,prpDuserDto.getArticleCode());
        dbManager.setString(21,prpDuserDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpDuserBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpDuserDto prpDuserDto = (PrpDuserDto)i.next();
            insert(prpDuserDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param userCode 员工代码
     * @throws Exception
     */
    public void delete(String userCode) throws Exception{
        String statement = " Delete From PrpDuser" +
	            		   " Where " +
                           " UserCode = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpDuser Where " +
                           " UserCode = '" + userCode + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,userCode);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpDuserBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpDuserDto prpDuserDto
     * @throws Exception
     */
    public void update(PrpDuserDto prpDuserDto) throws Exception{
        String statement = " Update PrpDuser Set UserName = ?," +
                           " UserEName = ?," +
                           " Password = ?," +
                           " Seal = ?," +
                           " PasswordSetDate = ?," +
                           " PasswordExpireDate = ?," +
                           " ComCode = ?," +
                           " MakeCom = ?," +
                           " AccountCode = ?," +
                           " Phone = ?," +
                           " Mobile = ?," +
                           " Address = ?," +
                           " PostCode = ?," +
                           " Email = ?," +
                           " UserFlag = ?," +
                           " LoginSystem = ?," +
                           " NewUserCode = ?," +
                           " ValidStatus = ?," +
                           " ArticleCode = ?," +
                           " Flag = ?" +
	            		   " Where " +
                           " UserCode = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpDuser Set " +
                           " UserCode = '" + prpDuserDto.getUserCode() + "'," +
                           " UserName = '" + prpDuserDto.getUserName() + "'," +
                           " UserEName = '" + prpDuserDto.getUserEName() + "'," +
                           " Password = '" + prpDuserDto.getPassword() + "'," +
                           " Seal = '" + prpDuserDto.getSeal() + "'," +
                           " PasswordSetDate = '" + prpDuserDto.getPasswordSetDate() + "'," +
                           " PasswordExpireDate = '" + prpDuserDto.getPasswordExpireDate() + "'," +
                           " ComCode = '" + prpDuserDto.getComCode() + "'," +
                           " MakeCom = '" + prpDuserDto.getMakeCom() + "'," +
                           " AccountCode = '" + prpDuserDto.getAccountCode() + "'," +
                           " Phone = '" + prpDuserDto.getPhone() + "'," +
                           " Mobile = '" + prpDuserDto.getMobile() + "'," +
                           " Address = '" + prpDuserDto.getAddress() + "'," +
                           " PostCode = '" + prpDuserDto.getPostCode() + "'," +
                           " Email = '" + prpDuserDto.getEmail() + "'," +
                           " UserFlag = '" + prpDuserDto.getUserFlag() + "'," +
                           " LoginSystem = '" + prpDuserDto.getLoginSystem() + "'," +
                           " NewUserCode = '" + prpDuserDto.getNewUserCode() + "'," +
                           " ValidStatus = '" + prpDuserDto.getValidStatus() + "'," +
                           " ArticleCode = '" + prpDuserDto.getArticleCode() + "'," +
                           " Flag = '" + prpDuserDto.getFlag() + "'" +
			               " Where " +
                           " UserCode = '" + prpDuserDto.getUserCode() + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpDuserDto.getUserName());
        dbManager.setString(2,prpDuserDto.getUserEName());
        dbManager.setString(3,prpDuserDto.getPassword());
        dbManager.setString(4,prpDuserDto.getSeal());
        dbManager.setDateTime(5,prpDuserDto.getPasswordSetDate());
        dbManager.setDateTime(6,prpDuserDto.getPasswordExpireDate());
        dbManager.setString(7,prpDuserDto.getComCode());
        dbManager.setString(8,prpDuserDto.getMakeCom());
        dbManager.setString(9,prpDuserDto.getAccountCode());
        dbManager.setString(10,prpDuserDto.getPhone());
        dbManager.setString(11,prpDuserDto.getMobile());
        dbManager.setString(12,prpDuserDto.getAddress());
        dbManager.setString(13,prpDuserDto.getPostCode());
        dbManager.setString(14,prpDuserDto.getEmail());
        dbManager.setString(15,prpDuserDto.getUserFlag());
        dbManager.setString(16,prpDuserDto.getLoginSystem());
        dbManager.setString(17,prpDuserDto.getNewUserCode());
        dbManager.setString(18,prpDuserDto.getValidStatus());
        dbManager.setString(19,prpDuserDto.getArticleCode());
        dbManager.setString(20,prpDuserDto.getFlag());
        //设置条件字段;
        dbManager.setString(21,prpDuserDto.getUserCode());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpDuserBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param userCode 员工代码
     * @return PrpDuserDto
     * @throws Exception
     */
    public PrpDuserDto findByPrimaryKey(String userCode) throws Exception{
        String mainStatement = " Select UserCode," +
                           " UserName," +
                           " UserEName," +
                           " Password," +
                           " Seal," +
                           " PasswordSetDate," +
                           " PasswordExpireDate," +
                           " ComCode," +
                           " MakeCom," +
                           " AccountCode," +
                           " Phone," +
                           " Mobile," +
                           " Address," +
                           " PostCode," +
                           " Email," +
                           " UserFlag," +
                           " LoginSystem," +
                           " NewUserCode," +
                           " ValidStatus," +
                           " ArticleCode," +
                           " Flag From PrpDuser";
        String statement = mainStatement + " Where " +
                           " UserCode = ?";
        PrpDuserDto prpDuserDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " UserCode = '" + userCode + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,userCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpDuserDto = new PrpDuserDto();
            prpDuserDto.setUserCode(dbManager.getString(resultSet,1));
            prpDuserDto.setUserName(dbManager.getString(resultSet,2));
            prpDuserDto.setUserEName(dbManager.getString(resultSet,3));
            prpDuserDto.setPassword(dbManager.getString(resultSet,4));
            prpDuserDto.setSeal(dbManager.getString(resultSet,5));
            prpDuserDto.setPasswordSetDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,6));
            prpDuserDto.setPasswordExpireDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,7));
            prpDuserDto.setComCode(dbManager.getString(resultSet,8));
            prpDuserDto.setMakeCom(dbManager.getString(resultSet,9));
            prpDuserDto.setAccountCode(dbManager.getString(resultSet,10));
            prpDuserDto.setPhone(dbManager.getString(resultSet,11));
            prpDuserDto.setMobile(dbManager.getString(resultSet,12));
            prpDuserDto.setAddress(dbManager.getString(resultSet,13));
            prpDuserDto.setPostCode(dbManager.getString(resultSet,14));
            prpDuserDto.setEmail(dbManager.getString(resultSet,15));
            prpDuserDto.setUserFlag(dbManager.getString(resultSet,16));
            prpDuserDto.setLoginSystem(dbManager.getString(resultSet,17));
            prpDuserDto.setNewUserCode(dbManager.getString(resultSet,18));
            prpDuserDto.setValidStatus(dbManager.getString(resultSet,19));
            prpDuserDto.setArticleCode(dbManager.getString(resultSet,20));
            prpDuserDto.setFlag(dbManager.getString(resultSet,21));
        }
        resultSet.close();
        logger.info("DBPrpDuserBase.findByPrimaryKey() success!");
        return prpDuserDto;
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
        String statement = "Select UserCode," +
                           " UserName," +
                           " UserEName," +
                           " Password," +
                           " Seal," +
                           " PasswordSetDate," +
                           " PasswordExpireDate," +
                           " ComCode," +
                           " MakeCom," +
                           " AccountCode," +
                           " Phone," +
                           " Mobile," +
                           " Address," +
                           " PostCode," +
                           " Email," +
                           " UserFlag," +
                           " LoginSystem," +
                           " NewUserCode," +
                           " ValidStatus," +
                           " ArticleCode," +
                           " Flag From PrpDuser Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpDuserDto prpDuserDto = null;
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

            prpDuserDto = new PrpDuserDto();
            prpDuserDto.setUserCode(dbManager.getString(resultSet,1));
            prpDuserDto.setUserName(dbManager.getString(resultSet,2));
            prpDuserDto.setUserEName(dbManager.getString(resultSet,3));
            prpDuserDto.setPassword(dbManager.getString(resultSet,4));
            prpDuserDto.setSeal(dbManager.getString(resultSet,5));
            prpDuserDto.setPasswordSetDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,6));
            prpDuserDto.setPasswordExpireDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,7));
            prpDuserDto.setComCode(dbManager.getString(resultSet,8));
            prpDuserDto.setMakeCom(dbManager.getString(resultSet,9));
            prpDuserDto.setAccountCode(dbManager.getString(resultSet,10));
            prpDuserDto.setPhone(dbManager.getString(resultSet,11));
            prpDuserDto.setMobile(dbManager.getString(resultSet,12));
            prpDuserDto.setAddress(dbManager.getString(resultSet,13));
            prpDuserDto.setPostCode(dbManager.getString(resultSet,14));
            prpDuserDto.setEmail(dbManager.getString(resultSet,15));
            prpDuserDto.setUserFlag(dbManager.getString(resultSet,16));
            prpDuserDto.setLoginSystem(dbManager.getString(resultSet,17));
            prpDuserDto.setNewUserCode(dbManager.getString(resultSet,18));
            prpDuserDto.setValidStatus(dbManager.getString(resultSet,19));
            prpDuserDto.setArticleCode(dbManager.getString(resultSet,20));
            prpDuserDto.setFlag(dbManager.getString(resultSet,21));
            collection.add(prpDuserDto);
        }
        resultSet.close();
        logger.info("DBPrpDuserBase.findByConditions() success!");
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
        String statement = "Delete From PrpDuser Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpDuserBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpDuser Where " + conditions;
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpDuserBase.getCount() success!");
        return count;
    }
}
