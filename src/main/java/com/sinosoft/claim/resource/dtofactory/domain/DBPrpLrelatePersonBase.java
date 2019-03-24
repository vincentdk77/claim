package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLrelatePersonDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是联系人表PrpLrelatePerson的数据访问对象基类<br>
 * 创建于 2005-05-31 19:50:56.375<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLrelatePersonBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpLrelatePersonBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLrelatePersonBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLrelatePersonDto prpLrelatePersonDto
     * @throws Exception
     */
    public void insert(PrpLrelatePersonDto prpLrelatePersonDto) throws Exception{
        String mainStatement = " Insert Into PrpLrelatePerson (" + 
                           " RegistNo," + 
                           " PersonType," + 
                           " SerialNo," + 
                           " PersonCode," + 
                           " PersonName," + 
                           " PhoneNumber," + 
                           " Mobile," + 
                           " PolicyNo," + 
                           " Remark," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLrelatePersonDto.getRegistNo() + "'," + 
                           "'" + prpLrelatePersonDto.getPersonType() + "'," + 
                           "" + prpLrelatePersonDto.getSerialNo() + "," + 
                           "'" + prpLrelatePersonDto.getPersonCode() + "'," + 
                           "'" + prpLrelatePersonDto.getPersonName() + "'," + 
                           "'" + prpLrelatePersonDto.getPhoneNumber() + "'," + 
                           "'" + prpLrelatePersonDto.getMobile() + "'," + 
                           "'" + prpLrelatePersonDto.getPolicyNo() + "'," + 
                           "'" + prpLrelatePersonDto.getRemark() + "'," + 
                           "'" + prpLrelatePersonDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLrelatePersonDto.getRegistNo());
        dbManager.setString(2,prpLrelatePersonDto.getPersonType());
        dbManager.setInt(3,prpLrelatePersonDto.getSerialNo());
        dbManager.setString(4,prpLrelatePersonDto.getPersonCode());
        dbManager.setString(5,prpLrelatePersonDto.getPersonName());
        dbManager.setString(6,prpLrelatePersonDto.getPhoneNumber());
        dbManager.setString(7,prpLrelatePersonDto.getMobile());
        dbManager.setString(8,prpLrelatePersonDto.getPolicyNo());
        dbManager.setString(9,prpLrelatePersonDto.getRemark());
        dbManager.setString(10,prpLrelatePersonDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLrelatePersonBase.insert() success!");
    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLrelatePerson (" + 
                           " RegistNo," + 
                           " PersonType," + 
                           " SerialNo," + 
                           " PersonCode," + 
                           " PersonName," + 
                           " PhoneNumber," + 
                           " Mobile," + 
                           " PolicyNo," + 
                           " Remark," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLrelatePersonDto prpLrelatePersonDto = (PrpLrelatePersonDto)i.next();
            dbManager.setString(1,prpLrelatePersonDto.getRegistNo());
            dbManager.setString(2,prpLrelatePersonDto.getPersonType());
            dbManager.setInt(3,prpLrelatePersonDto.getSerialNo());
            dbManager.setString(4,prpLrelatePersonDto.getPersonCode());
            dbManager.setString(5,prpLrelatePersonDto.getPersonName());
            dbManager.setString(6,prpLrelatePersonDto.getPhoneNumber());
            dbManager.setString(7,prpLrelatePersonDto.getMobile());
            dbManager.setString(8,prpLrelatePersonDto.getPolicyNo());
            dbManager.setString(9,prpLrelatePersonDto.getRemark());
            dbManager.setString(10,prpLrelatePersonDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLrelatePersonBase.insertAll() success!");
    }

    /**
     * 按主键删除一条数据
     * @param registNo 出险登记号
     * @throws Exception
     */
    public void delete(String registNo) throws Exception{
        String statement = " Delete From PrpLrelatePerson" + 
	            		   " Where " +
                           " RegistNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLrelatePerson Where " +
                           " RegistNo = '" + registNo + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,registNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLrelatePersonBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLrelatePersonDto prpLrelatePersonDto
     * @throws Exception
     */
    public void update(PrpLrelatePersonDto prpLrelatePersonDto) throws Exception{
        String statement = " Update PrpLrelatePerson Set PersonType = ?," + 
                           " SerialNo = ?," + 
                           " PersonCode = ?," + 
                           " PersonName = ?," + 
                           " PhoneNumber = ?," + 
                           " Mobile = ?," + 
                           " PolicyNo = ?," + 
                           " Remark = ?," + 
                           " Flag = ?" + 
	            		   " Where " +
                           " RegistNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLrelatePerson Set " + 
                           " RegistNo = '" + prpLrelatePersonDto.getRegistNo() + "'," + 
                           " PersonType = '" + prpLrelatePersonDto.getPersonType() + "'," + 
                           " SerialNo = " + prpLrelatePersonDto.getSerialNo() + "," + 
                           " PersonCode = '" + prpLrelatePersonDto.getPersonCode() + "'," + 
                           " PersonName = '" + prpLrelatePersonDto.getPersonName() + "'," + 
                           " PhoneNumber = '" + prpLrelatePersonDto.getPhoneNumber() + "'," + 
                           " Mobile = '" + prpLrelatePersonDto.getMobile() + "'," + 
                           " PolicyNo = '" + prpLrelatePersonDto.getPolicyNo() + "'," + 
                           " Remark = '" + prpLrelatePersonDto.getRemark() + "'," + 
                           " Flag = '" + prpLrelatePersonDto.getFlag() + "'" + 
			               " Where " +
                           " RegistNo = '" + prpLrelatePersonDto.getRegistNo() + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpLrelatePersonDto.getPersonType());
        dbManager.setInt(2,prpLrelatePersonDto.getSerialNo());
        dbManager.setString(3,prpLrelatePersonDto.getPersonCode());
        dbManager.setString(4,prpLrelatePersonDto.getPersonName());
        dbManager.setString(5,prpLrelatePersonDto.getPhoneNumber());
        dbManager.setString(6,prpLrelatePersonDto.getMobile());
        dbManager.setString(7,prpLrelatePersonDto.getPolicyNo());
        dbManager.setString(8,prpLrelatePersonDto.getRemark());
        dbManager.setString(9,prpLrelatePersonDto.getFlag());
        //设置条件字段;
        dbManager.setString(10,prpLrelatePersonDto.getRegistNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLrelatePersonBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param registNo 出险登记号
     * @return PrpLrelatePersonDto
     * @throws Exception
     */
    public PrpLrelatePersonDto findByPrimaryKey(String registNo) throws Exception{
        String mainStatement = " Select RegistNo," + 
                           " PersonType," + 
                           " SerialNo," + 
                           " PersonCode," + 
                           " PersonName," + 
                           " PhoneNumber," + 
                           " Mobile," + 
                           " PolicyNo," + 
                           " Remark," + 
                           " Flag From PrpLrelatePerson";
        String statement = mainStatement + " Where " +
                           " RegistNo = ?";
        PrpLrelatePersonDto prpLrelatePersonDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " RegistNo = '" + registNo + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,registNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLrelatePersonDto = new PrpLrelatePersonDto();
            prpLrelatePersonDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLrelatePersonDto.setPersonType(dbManager.getString(resultSet,2));
            prpLrelatePersonDto.setSerialNo(dbManager.getInt(resultSet,3));
            prpLrelatePersonDto.setPersonCode(dbManager.getString(resultSet,4));
            prpLrelatePersonDto.setPersonName(dbManager.getString(resultSet,5));
            prpLrelatePersonDto.setPhoneNumber(dbManager.getString(resultSet,6));
            prpLrelatePersonDto.setMobile(dbManager.getString(resultSet,7));
            prpLrelatePersonDto.setPolicyNo(dbManager.getString(resultSet,8));
            prpLrelatePersonDto.setRemark(dbManager.getString(resultSet,9));
            prpLrelatePersonDto.setFlag(dbManager.getString(resultSet,10));
            logger.info("DBPrpLrelatePersonBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLrelatePersonBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLrelatePersonDto;
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
        String statement = "Select RegistNo," + 
                           " PersonType," + 
                           " SerialNo," + 
                           " PersonCode," + 
                           " PersonName," + 
                           " PhoneNumber," + 
                           " Mobile," + 
                           " PolicyNo," + 
                           " Remark," + 
                           " Flag From PrpLrelatePerson Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLrelatePersonDto prpLrelatePersonDto = null;
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

            prpLrelatePersonDto = new PrpLrelatePersonDto();
            prpLrelatePersonDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLrelatePersonDto.setPersonType(dbManager.getString(resultSet,2));
            prpLrelatePersonDto.setSerialNo(dbManager.getInt(resultSet,3));
            prpLrelatePersonDto.setPersonCode(dbManager.getString(resultSet,4));
            prpLrelatePersonDto.setPersonName(dbManager.getString(resultSet,5));
            prpLrelatePersonDto.setPhoneNumber(dbManager.getString(resultSet,6));
            prpLrelatePersonDto.setMobile(dbManager.getString(resultSet,7));
            prpLrelatePersonDto.setPolicyNo(dbManager.getString(resultSet,8));
            prpLrelatePersonDto.setRemark(dbManager.getString(resultSet,9));
            prpLrelatePersonDto.setFlag(dbManager.getString(resultSet,10));
            collection.add(prpLrelatePersonDto);
        }
        resultSet.close();
        logger.info("DBPrpLrelatePersonBase.findByConditions() success!");
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
        String statement = "Delete From PrpLrelatePerson Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLrelatePersonBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLrelatePerson Where " + conditions;
           statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLrelatePersonBase.getCount() success!");
        return count;
    }
}
