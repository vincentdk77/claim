package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpGradeDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpgrade岗位定义表的数据访问对象类<br>
 * 创建于 2004-4-5 15:33:42<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpGradeBase{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpGradeBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpGradeBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpGradeDto prpGradeDto
     * @throws Exception
     */
    public void insert(PrpGradeDto prpGradeDto) throws Exception{
        String statement = " Insert Into PrpGrade(" + 
                           " GradeCode," + 
                           " GradeName," + 
                           " Power," + 
                           " Flag) values(?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpGradeDto.getGradeCode());
        dbManager.setString(2,prpGradeDto.getGradeName());
        dbManager.setString(3,prpGradeDto.getPower());
        dbManager.setString(4,prpGradeDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpGradeBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpGradeDto prpGradeDto = (PrpGradeDto)i.next();
            insert(prpGradeDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param gradeCode 岗位代码
     * @throws Exception
     */
    public void delete(String gradeCode) throws Exception{
        String statement = " Delete From PrpGrade Where " +
                           " GradeCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,gradeCode);
        dbManager.executePreparedUpdate();
        log.info("DBPrpGradeBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpGradeDto prpGradeDto
     * @throws Exception
     */
    public void update(PrpGradeDto prpGradeDto) throws Exception{
        String statement = " Update PrpGrade Set GradeName = ?," + 
                           " Power = ?," + 
                           " Flag = ? Where " +
                           " GradeCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpGradeDto.getGradeName());
        dbManager.setString(2,prpGradeDto.getPower());
        dbManager.setString(3,prpGradeDto.getFlag());
        //设置条件字段;
        dbManager.setString(4,prpGradeDto.getGradeCode());
        dbManager.executePreparedUpdate();

        log.info("DBPrpGradeBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param gradeCode 岗位代码
     * @return PrpGradeDto
     * @throws Exception
     */
    public PrpGradeDto findByPrimaryKey(String gradeCode) throws Exception{
        String statement = " Select GradeCode," + 
                           " GradeName," + 
                           " Power," + 
                           " Flag From PrpGrade Where " +
                           " GradeCode = ?";
        PrpGradeDto prpGradeDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,gradeCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpGradeDto = new PrpGradeDto();
            prpGradeDto.setGradeCode(dbManager.getString(resultSet,1));
            prpGradeDto.setGradeName(dbManager.getString(resultSet,2));
            prpGradeDto.setPower(dbManager.getString(resultSet,3));
            prpGradeDto.setFlag(dbManager.getString(resultSet,4));
        }
        resultSet.close();
        log.info("DBPrpGradeBase.findByPrimaryKey() success!");
        return prpGradeDto;
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
        String statement = "Select GradeCode," + 
                           " GradeName," + 
                           " Power," + 
                           " Flag From PrpGrade Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpGradeDto prpGradeDto = null;
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

            prpGradeDto = new PrpGradeDto();
            prpGradeDto.setGradeCode(dbManager.getString(resultSet,1));
            prpGradeDto.setGradeName(dbManager.getString(resultSet,2));
            prpGradeDto.setPower(dbManager.getString(resultSet,3));
            prpGradeDto.setFlag(dbManager.getString(resultSet,4));
            collection.add(prpGradeDto);
        }
        resultSet.close();
        log.info("DBPrpGradeBase.findByConditions() success!");
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
        String statement = "Delete From PrpGrade Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpGradeBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpGrade Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpGradeBase.getCount() success!");
        return count;
    }
}
