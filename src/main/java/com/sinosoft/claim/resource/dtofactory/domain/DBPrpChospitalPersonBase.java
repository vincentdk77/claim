package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpChospitalPersonDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpChospitalPerson的数据访问对象基类<br>
 * 创建于 2007-05-21 14:11:14.984<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpChospitalPersonBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Log logger = LogFactory.getLog(DBPrpChospitalPersonBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpChospitalPersonBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpChospitalPersonDto prpChospitalPersonDto
     * @throws Exception
     */
    public void insert(PrpChospitalPersonDto prpChospitalPersonDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpChospitalPerson (");
        buffer.append("PolicyNo,");
        buffer.append("RiskCode,");
        buffer.append("SerialNo,");
        buffer.append("InsuredType,");
        buffer.append("InsuredCode,");
        buffer.append("InsuredName,");
        buffer.append("Sex,");
        buffer.append("Age,");
        buffer.append("TownName,");
        buffer.append("TownCode,");
        buffer.append("InsuredAddress,");
        buffer.append("InsuredNature,");
        buffer.append("InsuredFlag,");
        buffer.append("HospitalNumber,");
        buffer.append("IdentifyNumber,");
        buffer.append("Bank,");
        buffer.append("AccountName,");
        buffer.append("Account,");
        buffer.append("LinkerName,");
        buffer.append("PostAddress,");
        buffer.append("PostCode,");
        buffer.append("PhoneNumber,");
        buffer.append("Mobile,");
        buffer.append("Email,");
        buffer.append("Flag ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpChospitalPersonDto.getPolicyNo()).append("',");
            debugBuffer.append("'").append(prpChospitalPersonDto.getRiskCode()).append("',");
            debugBuffer.append("").append(prpChospitalPersonDto.getSerialNo()).append(",");
            debugBuffer.append("'").append(prpChospitalPersonDto.getInsuredType()).append("',");
            debugBuffer.append("'").append(prpChospitalPersonDto.getInsuredCode()).append("',");
            debugBuffer.append("'").append(prpChospitalPersonDto.getInsuredName()).append("',");
            debugBuffer.append("'").append(prpChospitalPersonDto.getSex()).append("',");
            debugBuffer.append("'").append(prpChospitalPersonDto.getAge()).append("',");
            debugBuffer.append("'").append(prpChospitalPersonDto.getTownName()).append("',");
            debugBuffer.append("'").append(prpChospitalPersonDto.getTownCode()).append("',");
            debugBuffer.append("'").append(prpChospitalPersonDto.getInsuredAddress()).append("',");
            debugBuffer.append("'").append(prpChospitalPersonDto.getInsuredNature()).append("',");
            debugBuffer.append("'").append(prpChospitalPersonDto.getInsuredFlag()).append("',");
            debugBuffer.append("'").append(prpChospitalPersonDto.getHospitalNumber()).append("',");
            debugBuffer.append("'").append(prpChospitalPersonDto.getIdentifyNumber()).append("',");
            debugBuffer.append("'").append(prpChospitalPersonDto.getBank()).append("',");
            debugBuffer.append("'").append(prpChospitalPersonDto.getAccountName()).append("',");
            debugBuffer.append("'").append(prpChospitalPersonDto.getAccount()).append("',");
            debugBuffer.append("'").append(prpChospitalPersonDto.getLinkerName()).append("',");
            debugBuffer.append("'").append(prpChospitalPersonDto.getPostAddress()).append("',");
            debugBuffer.append("'").append(prpChospitalPersonDto.getPostCode()).append("',");
            debugBuffer.append("'").append(prpChospitalPersonDto.getPhoneNumber()).append("',");
            debugBuffer.append("'").append(prpChospitalPersonDto.getMobile()).append("',");
            debugBuffer.append("'").append(prpChospitalPersonDto.getEmail()).append("',");
            debugBuffer.append("'").append(prpChospitalPersonDto.getFlag()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpChospitalPersonDto.getPolicyNo());
        dbManager.setString(2,prpChospitalPersonDto.getRiskCode());
        dbManager.setLong(3,prpChospitalPersonDto.getSerialNo());
        dbManager.setString(4,prpChospitalPersonDto.getInsuredType());
        dbManager.setString(5,prpChospitalPersonDto.getInsuredCode());
        dbManager.setString(6,prpChospitalPersonDto.getInsuredName());
        dbManager.setString(7,prpChospitalPersonDto.getSex());
        dbManager.setString(8,prpChospitalPersonDto.getAge());
        dbManager.setString(9,prpChospitalPersonDto.getTownName());
        dbManager.setString(10,prpChospitalPersonDto.getTownCode());
        dbManager.setString(11,prpChospitalPersonDto.getInsuredAddress());
        dbManager.setString(12,prpChospitalPersonDto.getInsuredNature());
        dbManager.setString(13,prpChospitalPersonDto.getInsuredFlag());
        dbManager.setString(14,prpChospitalPersonDto.getHospitalNumber());
        dbManager.setString(15,prpChospitalPersonDto.getIdentifyNumber());
        dbManager.setString(16,prpChospitalPersonDto.getBank());
        dbManager.setString(17,prpChospitalPersonDto.getAccountName());
        dbManager.setString(18,prpChospitalPersonDto.getAccount());
        dbManager.setString(19,prpChospitalPersonDto.getLinkerName());
        dbManager.setString(20,prpChospitalPersonDto.getPostAddress());
        dbManager.setString(21,prpChospitalPersonDto.getPostCode());
        dbManager.setString(22,prpChospitalPersonDto.getPhoneNumber());
        dbManager.setString(23,prpChospitalPersonDto.getMobile());
        dbManager.setString(24,prpChospitalPersonDto.getEmail());
        dbManager.setString(25,prpChospitalPersonDto.getFlag());
        dbManager.executePreparedUpdate();

    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpChospitalPerson (");
        buffer.append("PolicyNo,");
        buffer.append("RiskCode,");
        buffer.append("SerialNo,");
        buffer.append("InsuredType,");
        buffer.append("InsuredCode,");
        buffer.append("InsuredName,");
        buffer.append("Sex,");
        buffer.append("Age,");
        buffer.append("TownName,");
        buffer.append("TownCode,");
        buffer.append("InsuredAddress,");
        buffer.append("InsuredNature,");
        buffer.append("InsuredFlag,");
        buffer.append("HospitalNumber,");
        buffer.append("IdentifyNumber,");
        buffer.append("Bank,");
        buffer.append("AccountName,");
        buffer.append("Account,");
        buffer.append("LinkerName,");
        buffer.append("PostAddress,");
        buffer.append("PostCode,");
        buffer.append("PhoneNumber,");
        buffer.append("Mobile,");
        buffer.append("Email,");
        buffer.append("Flag ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpChospitalPersonDto prpChospitalPersonDto = (PrpChospitalPersonDto)i.next();
            dbManager.setString(1,prpChospitalPersonDto.getPolicyNo());
            dbManager.setString(2,prpChospitalPersonDto.getRiskCode());
            dbManager.setLong(3,prpChospitalPersonDto.getSerialNo());
            dbManager.setString(4,prpChospitalPersonDto.getInsuredType());
            dbManager.setString(5,prpChospitalPersonDto.getInsuredCode());
            dbManager.setString(6,prpChospitalPersonDto.getInsuredName());
            dbManager.setString(7,prpChospitalPersonDto.getSex());
            dbManager.setString(8,prpChospitalPersonDto.getAge());
            dbManager.setString(9,prpChospitalPersonDto.getTownName());
            dbManager.setString(10,prpChospitalPersonDto.getTownCode());
            dbManager.setString(11,prpChospitalPersonDto.getInsuredAddress());
            dbManager.setString(12,prpChospitalPersonDto.getInsuredNature());
            dbManager.setString(13,prpChospitalPersonDto.getInsuredFlag());
            dbManager.setString(14,prpChospitalPersonDto.getHospitalNumber());
            dbManager.setString(15,prpChospitalPersonDto.getIdentifyNumber());
            dbManager.setString(16,prpChospitalPersonDto.getBank());
            dbManager.setString(17,prpChospitalPersonDto.getAccountName());
            dbManager.setString(18,prpChospitalPersonDto.getAccount());
            dbManager.setString(19,prpChospitalPersonDto.getLinkerName());
            dbManager.setString(20,prpChospitalPersonDto.getPostAddress());
            dbManager.setString(21,prpChospitalPersonDto.getPostCode());
            dbManager.setString(22,prpChospitalPersonDto.getPhoneNumber());
            dbManager.setString(23,prpChospitalPersonDto.getMobile());
            dbManager.setString(24,prpChospitalPersonDto.getEmail());
            dbManager.setString(25,prpChospitalPersonDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param policyNo PolicyNo
     * @param hospitalNumber HospitalNumber
     * @throws Exception
     */
    public void delete(String policyNo,String hospitalNumber)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpChospitalPerson ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("PolicyNo=").append("'").append(policyNo).append("' AND ");
            debugBuffer.append("HospitalNumber=").append("'").append(hospitalNumber).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("PolicyNo = ? And ");
        buffer.append("HospitalNumber = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,policyNo);
        dbManager.setString(2,hospitalNumber);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpChospitalPersonDto prpChospitalPersonDto
     * @throws Exception
     */
    public void update(PrpChospitalPersonDto prpChospitalPersonDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpChospitalPerson SET ");
        buffer.append("RiskCode = ?, ");
        buffer.append("SerialNo = ?, ");
        buffer.append("InsuredType = ?, ");
        buffer.append("InsuredCode = ?, ");
        buffer.append("InsuredName = ?, ");
        buffer.append("Sex = ?, ");
        buffer.append("Age = ?, ");
        buffer.append("TownName = ?, ");
        buffer.append("TownCode = ?, ");
        buffer.append("InsuredAddress = ?, ");
        buffer.append("InsuredNature = ?, ");
        buffer.append("InsuredFlag = ?, ");
        buffer.append("IdentifyNumber = ?, ");
        buffer.append("Bank = ?, ");
        buffer.append("AccountName = ?, ");
        buffer.append("Account = ?, ");
        buffer.append("LinkerName = ?, ");
        buffer.append("PostAddress = ?, ");
        buffer.append("PostCode = ?, ");
        buffer.append("PhoneNumber = ?, ");
        buffer.append("Mobile = ?, ");
        buffer.append("Email = ?, ");
        buffer.append("Flag = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpChospitalPerson SET ");
            debugBuffer.append("RiskCode = '" + prpChospitalPersonDto.getRiskCode() + "', ");
            debugBuffer.append("SerialNo = " + prpChospitalPersonDto.getSerialNo() + ", ");
            debugBuffer.append("InsuredType = '" + prpChospitalPersonDto.getInsuredType() + "', ");
            debugBuffer.append("InsuredCode = '" + prpChospitalPersonDto.getInsuredCode() + "', ");
            debugBuffer.append("InsuredName = '" + prpChospitalPersonDto.getInsuredName() + "', ");
            debugBuffer.append("Sex = '" + prpChospitalPersonDto.getSex() + "', ");
            debugBuffer.append("Age = '" + prpChospitalPersonDto.getAge() + "', ");
            debugBuffer.append("TownName = '" + prpChospitalPersonDto.getTownName() + "', ");
            debugBuffer.append("TownCode = '" + prpChospitalPersonDto.getTownCode() + "', ");
            debugBuffer.append("InsuredAddress = '" + prpChospitalPersonDto.getInsuredAddress() + "', ");
            debugBuffer.append("InsuredNature = '" + prpChospitalPersonDto.getInsuredNature() + "', ");
            debugBuffer.append("InsuredFlag = '" + prpChospitalPersonDto.getInsuredFlag() + "', ");
            debugBuffer.append("IdentifyNumber = '" + prpChospitalPersonDto.getIdentifyNumber() + "', ");
            debugBuffer.append("Bank = '" + prpChospitalPersonDto.getBank() + "', ");
            debugBuffer.append("AccountName = '" + prpChospitalPersonDto.getAccountName() + "', ");
            debugBuffer.append("Account = '" + prpChospitalPersonDto.getAccount() + "', ");
            debugBuffer.append("LinkerName = '" + prpChospitalPersonDto.getLinkerName() + "', ");
            debugBuffer.append("PostAddress = '" + prpChospitalPersonDto.getPostAddress() + "', ");
            debugBuffer.append("PostCode = '" + prpChospitalPersonDto.getPostCode() + "', ");
            debugBuffer.append("PhoneNumber = '" + prpChospitalPersonDto.getPhoneNumber() + "', ");
            debugBuffer.append("Mobile = '" + prpChospitalPersonDto.getMobile() + "', ");
            debugBuffer.append("Email = '" + prpChospitalPersonDto.getEmail() + "', ");
            debugBuffer.append("Flag = '" + prpChospitalPersonDto.getFlag() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("PolicyNo=").append("'").append(prpChospitalPersonDto.getPolicyNo()).append("' AND ");
            debugBuffer.append("HospitalNumber=").append("'").append(prpChospitalPersonDto.getHospitalNumber()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("PolicyNo = ? And ");
        buffer.append("HospitalNumber = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prpChospitalPersonDto.getRiskCode());
        dbManager.setLong(2,prpChospitalPersonDto.getSerialNo());
        dbManager.setString(3,prpChospitalPersonDto.getInsuredType());
        dbManager.setString(4,prpChospitalPersonDto.getInsuredCode());
        dbManager.setString(5,prpChospitalPersonDto.getInsuredName());
        dbManager.setString(6,prpChospitalPersonDto.getSex());
        dbManager.setString(7,prpChospitalPersonDto.getAge());
        dbManager.setString(8,prpChospitalPersonDto.getTownName());
        dbManager.setString(9,prpChospitalPersonDto.getTownCode());
        dbManager.setString(10,prpChospitalPersonDto.getInsuredAddress());
        dbManager.setString(11,prpChospitalPersonDto.getInsuredNature());
        dbManager.setString(12,prpChospitalPersonDto.getInsuredFlag());
        dbManager.setString(13,prpChospitalPersonDto.getIdentifyNumber());
        dbManager.setString(14,prpChospitalPersonDto.getBank());
        dbManager.setString(15,prpChospitalPersonDto.getAccountName());
        dbManager.setString(16,prpChospitalPersonDto.getAccount());
        dbManager.setString(17,prpChospitalPersonDto.getLinkerName());
        dbManager.setString(18,prpChospitalPersonDto.getPostAddress());
        dbManager.setString(19,prpChospitalPersonDto.getPostCode());
        dbManager.setString(20,prpChospitalPersonDto.getPhoneNumber());
        dbManager.setString(21,prpChospitalPersonDto.getMobile());
        dbManager.setString(22,prpChospitalPersonDto.getEmail());
        dbManager.setString(23,prpChospitalPersonDto.getFlag());
        //设置条件字段;
        dbManager.setString(24,prpChospitalPersonDto.getPolicyNo());
        dbManager.setString(25,prpChospitalPersonDto.getHospitalNumber());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param policyNo PolicyNo
     * @param hospitalNumber HospitalNumber
     * @return PrpChospitalPersonDto
     * @throws Exception
     */
    public PrpChospitalPersonDto findByPrimaryKey(String policyNo,String hospitalNumber)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("PolicyNo,");
        buffer.append("RiskCode,");
        buffer.append("SerialNo,");
        buffer.append("InsuredType,");
        buffer.append("InsuredCode,");
        buffer.append("InsuredName,");
        buffer.append("Sex,");
        buffer.append("Age,");
        buffer.append("TownName,");
        buffer.append("TownCode,");
        buffer.append("InsuredAddress,");
        buffer.append("InsuredNature,");
        buffer.append("InsuredFlag,");
        buffer.append("HospitalNumber,");
        buffer.append("IdentifyNumber,");
        buffer.append("Bank,");
        buffer.append("AccountName,");
        buffer.append("Account,");
        buffer.append("LinkerName,");
        buffer.append("PostAddress,");
        buffer.append("PostCode,");
        buffer.append("PhoneNumber,");
        buffer.append("Mobile,");
        buffer.append("Email,");
        buffer.append("Flag ");
        buffer.append("FROM PrpChospitalPerson ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("PolicyNo=").append("'").append(policyNo).append("' AND ");
            debugBuffer.append("HospitalNumber=").append("'").append(hospitalNumber).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("PolicyNo = ? And ");
        buffer.append("HospitalNumber = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,policyNo);
        dbManager.setString(2,hospitalNumber);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpChospitalPersonDto prpChospitalPersonDto = null;
        if(resultSet.next()){
            prpChospitalPersonDto = new PrpChospitalPersonDto();
            prpChospitalPersonDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpChospitalPersonDto.setRiskCode(dbManager.getString(resultSet,2));
            prpChospitalPersonDto.setSerialNo(dbManager.getLong(resultSet,3));
            prpChospitalPersonDto.setInsuredType(dbManager.getString(resultSet,4));
            prpChospitalPersonDto.setInsuredCode(dbManager.getString(resultSet,5));
            prpChospitalPersonDto.setInsuredName(dbManager.getString(resultSet,6));
            prpChospitalPersonDto.setSex(dbManager.getString(resultSet,7));
            prpChospitalPersonDto.setAge(dbManager.getString(resultSet,8));
            prpChospitalPersonDto.setTownName(dbManager.getString(resultSet,9));
            prpChospitalPersonDto.setTownCode(dbManager.getString(resultSet,10));
            prpChospitalPersonDto.setInsuredAddress(dbManager.getString(resultSet,11));
            prpChospitalPersonDto.setInsuredNature(dbManager.getString(resultSet,12));
            prpChospitalPersonDto.setInsuredFlag(dbManager.getString(resultSet,13));
            prpChospitalPersonDto.setHospitalNumber(dbManager.getString(resultSet,14));
            prpChospitalPersonDto.setIdentifyNumber(dbManager.getString(resultSet,15));
            prpChospitalPersonDto.setBank(dbManager.getString(resultSet,16));
            prpChospitalPersonDto.setAccountName(dbManager.getString(resultSet,17));
            prpChospitalPersonDto.setAccount(dbManager.getString(resultSet,18));
            prpChospitalPersonDto.setLinkerName(dbManager.getString(resultSet,19));
            prpChospitalPersonDto.setPostAddress(dbManager.getString(resultSet,20));
            prpChospitalPersonDto.setPostCode(dbManager.getString(resultSet,21));
            prpChospitalPersonDto.setPhoneNumber(dbManager.getString(resultSet,22));
            prpChospitalPersonDto.setMobile(dbManager.getString(resultSet,23));
            prpChospitalPersonDto.setEmail(dbManager.getString(resultSet,24));
            prpChospitalPersonDto.setFlag(dbManager.getString(resultSet,25));
        }
        resultSet.close();
        return prpChospitalPersonDto;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("PolicyNo,");
        buffer.append("RiskCode,");
        buffer.append("SerialNo,");
        buffer.append("InsuredType,");
        buffer.append("InsuredCode,");
        buffer.append("InsuredName,");
        buffer.append("Sex,");
        buffer.append("Age,");
        buffer.append("TownName,");
        buffer.append("TownCode,");
        buffer.append("InsuredAddress,");
        buffer.append("InsuredNature,");
        buffer.append("InsuredFlag,");
        buffer.append("HospitalNumber,");
        buffer.append("IdentifyNumber,");
        buffer.append("Bank,");
        buffer.append("AccountName,");
        buffer.append("Account,");
        buffer.append("LinkerName,");
        buffer.append("PostAddress,");
        buffer.append("PostCode,");
        buffer.append("PhoneNumber,");
        buffer.append("Mobile,");
        buffer.append("Email,");
        buffer.append("Flag ");
        buffer.append("FROM PrpChospitalPerson WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        int count=0;
        if(pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        //定义返回结果集合
        Collection collection = new ArrayList(rowsPerPage);
        PrpChospitalPersonDto prpChospitalPersonDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpChospitalPersonDto = new PrpChospitalPersonDto();
            prpChospitalPersonDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpChospitalPersonDto.setRiskCode(dbManager.getString(resultSet,2));
            prpChospitalPersonDto.setSerialNo(dbManager.getLong(resultSet,3));
            prpChospitalPersonDto.setInsuredType(dbManager.getString(resultSet,4));
            prpChospitalPersonDto.setInsuredCode(dbManager.getString(resultSet,5));
            prpChospitalPersonDto.setInsuredName(dbManager.getString(resultSet,6));
            prpChospitalPersonDto.setSex(dbManager.getString(resultSet,7));
            prpChospitalPersonDto.setAge(dbManager.getString(resultSet,8));
            prpChospitalPersonDto.setTownName(dbManager.getString(resultSet,9));
            prpChospitalPersonDto.setTownCode(dbManager.getString(resultSet,10));
            prpChospitalPersonDto.setInsuredAddress(dbManager.getString(resultSet,11));
            prpChospitalPersonDto.setInsuredNature(dbManager.getString(resultSet,12));
            prpChospitalPersonDto.setInsuredFlag(dbManager.getString(resultSet,13));
            prpChospitalPersonDto.setHospitalNumber(dbManager.getString(resultSet,14));
            prpChospitalPersonDto.setIdentifyNumber(dbManager.getString(resultSet,15));
            prpChospitalPersonDto.setBank(dbManager.getString(resultSet,16));
            prpChospitalPersonDto.setAccountName(dbManager.getString(resultSet,17));
            prpChospitalPersonDto.setAccount(dbManager.getString(resultSet,18));
            prpChospitalPersonDto.setLinkerName(dbManager.getString(resultSet,19));
            prpChospitalPersonDto.setPostAddress(dbManager.getString(resultSet,20));
            prpChospitalPersonDto.setPostCode(dbManager.getString(resultSet,21));
            prpChospitalPersonDto.setPhoneNumber(dbManager.getString(resultSet,22));
            prpChospitalPersonDto.setMobile(dbManager.getString(resultSet,23));
            prpChospitalPersonDto.setEmail(dbManager.getString(resultSet,24));
            prpChospitalPersonDto.setFlag(dbManager.getString(resultSet,25));
            collection.add(prpChospitalPersonDto);
        }
        resultSet.close();
        return collection;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
            throws Exception{
        return findByConditions(conditions,0,0);
    }

    /**
     * 按条件删除数据
     * @param conditions 查询条件
     * @return 删除的行数
     * @throws Exception
     */
    public int deleteByConditions(String conditions)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpChospitalPerson WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        int count = dbManager.executeUpdate(buffer.toString());
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
        StringBuffer buffer = new StringBuffer(100);
        String statement;
        statement = "SELECT count(1) FROM PrpChospitalPerson WHERE ";
        statement = SqlUtils.getWherePartForGetCount(statement);
        buffer.append(statement);
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        return count;
    }
}
