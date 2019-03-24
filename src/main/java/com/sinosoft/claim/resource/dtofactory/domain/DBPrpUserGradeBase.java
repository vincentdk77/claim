package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpUserGradeDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpusergrade员工权限表的数据访问对象类<br>
 * 创建于 2004-4-5 15:33:42<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpUserGradeBase{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpUserGradeBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpUserGradeBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpUserGradeDto prpUserGradeDto
     * @throws Exception
     */
    public void insert(PrpUserGradeDto prpUserGradeDto) throws Exception{
        String statement = " Insert Into PrpUserGrade(" + 
                           " UserCode," + 
                           " Power," + 
                           " Flag) values(?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpUserGradeDto.getUserCode());
        dbManager.setString(2,prpUserGradeDto.getPower());
        dbManager.setString(3,prpUserGradeDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpUserGradeBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpUserGradeDto prpUserGradeDto = (PrpUserGradeDto)i.next();
            insert(prpUserGradeDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param userCode 员工代码
     * @throws Exception
     */
    public void delete(String userCode) throws Exception{
        String statement = " Delete From PrpUserGrade Where " +
                           " UserCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,userCode);
        dbManager.executePreparedUpdate();
        log.info("DBPrpUserGradeBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpUserGradeDto prpUserGradeDto
     * @throws Exception
     */
    public void update(PrpUserGradeDto prpUserGradeDto) throws Exception{
        String statement = " Update PrpUserGrade Set Power = ?," + 
                           " Flag = ? Where " +
                           " UserCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpUserGradeDto.getPower());
        dbManager.setString(2,prpUserGradeDto.getFlag());
        //设置条件字段;
        dbManager.setString(3,prpUserGradeDto.getUserCode());
        dbManager.executePreparedUpdate();

        log.info("DBPrpUserGradeBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param userCode 员工代码
     * @return PrpUserGradeDto
     * @throws Exception
     */
    public PrpUserGradeDto findByPrimaryKey(String userCode) throws Exception{
        String statement = " Select UserCode," + 
                           " Power," + 
                           " Flag From PrpUserGrade Where " +
                           " UserCode = ?";
        PrpUserGradeDto prpUserGradeDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,userCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpUserGradeDto = new PrpUserGradeDto();
            prpUserGradeDto.setUserCode(dbManager.getString(resultSet,1));
            prpUserGradeDto.setPower(dbManager.getString(resultSet,2));
            prpUserGradeDto.setFlag(dbManager.getString(resultSet,3));
        }
        resultSet.close();
        log.info("DBPrpUserGradeBase.findByPrimaryKey() success!");
        return prpUserGradeDto;
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
                           " Power," + 
                           " Flag From PrpUserGrade Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpUserGradeDto prpUserGradeDto = null;
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

            prpUserGradeDto = new PrpUserGradeDto();
            prpUserGradeDto.setUserCode(dbManager.getString(resultSet,1));
            prpUserGradeDto.setPower(dbManager.getString(resultSet,2));
            prpUserGradeDto.setFlag(dbManager.getString(resultSet,3));
            collection.add(prpUserGradeDto);
        }
        resultSet.close();
        log.info("DBPrpUserGradeBase.findByConditions() success!");
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
        String statement = "Delete From PrpUserGrade Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpUserGradeBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpUserGrade Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpUserGradeBase.getCount() success!");
        return count;
    }
}
