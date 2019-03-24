package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.UtiPfieldDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是utipfield单证打印的数据访问对象类<br>
 * 创建于 2004-4-5 15:33:43<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBUtiPfieldBase{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBUtiPfieldBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBUtiPfieldBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param utiPfieldDto utiPfieldDto
     * @throws Exception
     */
    public void insert(UtiPfieldDto utiPfieldDto) throws Exception{
        String statement = " Insert Into UtiPfield(" + 
                           " FileName," + 
                           " LabelNo," + 
                           " FieldName," + 
                           " SelFlag," + 
                           " TabName," + 
                           " Flag) values(?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,utiPfieldDto.getFileName());
        dbManager.setString(2,utiPfieldDto.getLabelNo());
        dbManager.setString(3,utiPfieldDto.getFieldName());
        dbManager.setString(4,utiPfieldDto.getSelFlag());
        dbManager.setString(5,utiPfieldDto.getTabName());
        dbManager.setString(6,utiPfieldDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBUtiPfieldBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            UtiPfieldDto utiPfieldDto = (UtiPfieldDto)i.next();
            insert(utiPfieldDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param fileName 文件名称
     * @param labelNo 标号(格式标号)
     * @throws Exception
     */
    public void delete(String fileName,String labelNo) throws Exception{
        String statement = " Delete From UtiPfield Where " +
                           " FileName = ? And " + 
                           " LabelNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,fileName);
        dbManager.setString(2,labelNo);
        dbManager.executePreparedUpdate();
        log.info("DBUtiPfieldBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param utiPfieldDto utiPfieldDto
     * @throws Exception
     */
    public void update(UtiPfieldDto utiPfieldDto) throws Exception{
        String statement = " Update UtiPfield Set FieldName = ?," + 
                           " SelFlag = ?," + 
                           " TabName = ?," + 
                           " Flag = ? Where " +
                           " FileName = ? And " + 
                           " LabelNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,utiPfieldDto.getFieldName());
        dbManager.setString(2,utiPfieldDto.getSelFlag());
        dbManager.setString(3,utiPfieldDto.getTabName());
        dbManager.setString(4,utiPfieldDto.getFlag());
        //设置条件字段;
        dbManager.setString(5,utiPfieldDto.getFileName());
        dbManager.setString(6,utiPfieldDto.getLabelNo());
        dbManager.executePreparedUpdate();

        log.info("DBUtiPfieldBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param fileName 文件名称
     * @param labelNo 标号(格式标号)
     * @return UtiPfieldDto
     * @throws Exception
     */
    public UtiPfieldDto findByPrimaryKey(String fileName,String labelNo) throws Exception{
        String statement = " Select FileName," + 
                           " LabelNo," + 
                           " FieldName," + 
                           " SelFlag," + 
                           " TabName," + 
                           " Flag From UtiPfield Where " +
                           " FileName = ? And " + 
                           " LabelNo = ?";
        UtiPfieldDto utiPfieldDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,fileName);
        dbManager.setString(2,labelNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            utiPfieldDto = new UtiPfieldDto();
            utiPfieldDto.setFileName(dbManager.getString(resultSet,1));
            utiPfieldDto.setLabelNo(dbManager.getString(resultSet,2));
            utiPfieldDto.setFieldName(dbManager.getString(resultSet,3));
            utiPfieldDto.setSelFlag(dbManager.getString(resultSet,4));
            utiPfieldDto.setTabName(dbManager.getString(resultSet,5));
            utiPfieldDto.setFlag(dbManager.getString(resultSet,6));
        }
        resultSet.close();
        log.info("DBUtiPfieldBase.findByPrimaryKey() success!");
        return utiPfieldDto;
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
        String statement = "Select FileName," + 
                           " LabelNo," + 
                           " FieldName," + 
                           " SelFlag," + 
                           " TabName," + 
                           " Flag From UtiPfield Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        UtiPfieldDto utiPfieldDto = null;
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

            utiPfieldDto = new UtiPfieldDto();
            utiPfieldDto.setFileName(dbManager.getString(resultSet,1));
            utiPfieldDto.setLabelNo(dbManager.getString(resultSet,2));
            utiPfieldDto.setFieldName(dbManager.getString(resultSet,3));
            utiPfieldDto.setSelFlag(dbManager.getString(resultSet,4));
            utiPfieldDto.setTabName(dbManager.getString(resultSet,5));
            utiPfieldDto.setFlag(dbManager.getString(resultSet,6));
            collection.add(utiPfieldDto);
        }
        resultSet.close();
        log.info("DBUtiPfieldBase.findByConditions() success!");
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
        String statement = "Delete From UtiPfield Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBUtiPfieldBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from UtiPfield Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBUtiPfieldBase.getCount() success!");
        return count;
    }
}
