package com.sinosoft.function.insutil.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDuserDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpduser的数据访问对象类<br>
 * 创建于 2004-4-6 16:07:46<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDuserBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpDuserBase.class.getName());

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
        String statement = " Insert Into PrpDuser(" + 
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
                           " Flag) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
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

        log.info("DBPrpDuserBase.insert() success!");
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
     * @param userCode usercode
     * @throws Exception
     */
    public void delete(String userCode) throws Exception{
        String statement = " Delete From PrpDuser Where " +
                           " UserCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,userCode);
        dbManager.executePreparedUpdate();
        log.info("DBPrpDuserBase.delete() success!");
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
                           " Flag = ? Where " +
                           " UserCode = ?";
        log.debug(statement);
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

        log.info("DBPrpDuserBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param userCode usercode
     * @return PrpDuserDto
     * @throws Exception
     */
    public PrpDuserDto findByPrimaryKey(String userCode) throws Exception{
        String statement = " Select UserCode," + 
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
                           " Flag From PrpDuser Where " +
                           " UserCode = ?";
        PrpDuserDto prpDuserDto = null;
        log.debug(statement);
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
        log.info("DBPrpDuserBase.findByPrimaryKey() success!");
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
        log.debug(statement);
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
        log.info("DBPrpDuserBase.findByConditions() success!");
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
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpDuserBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpDuser Where " + conditions;
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpDuserBase.getCount() success!");
        return count;
    }
}
