package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLacciPersonDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLacciPerson的数据访问对象基类<br>
 * 创建于 2005-06-16 13:55:17.687<br>
 * JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLacciPersonBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpLacciPersonBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLacciPersonBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLacciPersonDto prpLacciPersonDto
     * @throws Exception
     */
    public void insert(PrpLacciPersonDto prpLacciPersonDto) throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLacciPerson (");
        buffer.append("CertiNo,");
        buffer.append("CertiType,");
        buffer.append("PolicyNo,");
        buffer.append("SerialNo,");
        buffer.append("FamilyNo,");
        buffer.append("AcciCode,");
        buffer.append("AcciName,");
        buffer.append("Sex,");
        buffer.append("Age,");
        buffer.append("IdentifyType,");
        buffer.append("IdentifyNumber,");
        buffer.append("Remark,");
        buffer.append("Flag,");
        buffer.append("Phone,");
        buffer.append("Address,");
        buffer.append("RelationCode,");
        buffer.append("RelationName");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLacciPersonDto.getCertiNo()).append("',");
            debugBuffer.append("'").append(prpLacciPersonDto.getCertiType()).append("',");
            debugBuffer.append("'").append(prpLacciPersonDto.getPolicyNo()).append("',");
            debugBuffer.append("").append(prpLacciPersonDto.getSerialNo()).append(",");
            debugBuffer.append("").append(prpLacciPersonDto.getFamilyNo()).append(",");
            debugBuffer.append("'").append(prpLacciPersonDto.getAcciCode()).append("',");
            debugBuffer.append("'").append(prpLacciPersonDto.getAcciName()).append("',");
            debugBuffer.append("'").append(prpLacciPersonDto.getSex()).append("',");
            debugBuffer.append("").append(prpLacciPersonDto.getAge()).append(",");
            debugBuffer.append("'").append(prpLacciPersonDto.getIdentifyType()).append("',");
            debugBuffer.append("'").append(prpLacciPersonDto.getIdentifyNumber()).append("',");
            debugBuffer.append("'").append(prpLacciPersonDto.getRemark()).append("',");
            debugBuffer.append("'").append(prpLacciPersonDto.getFlag()).append("',");
            debugBuffer.append("'").append(prpLacciPersonDto.getPhone()).append("',");
            debugBuffer.append("'").append(prpLacciPersonDto.getAddress()).append("',");
            debugBuffer.append("'").append(prpLacciPersonDto.getRelationCode()).append("',");
            debugBuffer.append("'").append(prpLacciPersonDto.getRelationName()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLacciPersonDto.getCertiNo());
        dbManager.setString(2,prpLacciPersonDto.getCertiType());
        dbManager.setString(3,prpLacciPersonDto.getPolicyNo());
        dbManager.setInt(4,prpLacciPersonDto.getSerialNo());
        dbManager.setInt(5,prpLacciPersonDto.getFamilyNo());
        dbManager.setString(6,prpLacciPersonDto.getAcciCode());
        dbManager.setString(7,prpLacciPersonDto.getAcciName());
        dbManager.setString(8,prpLacciPersonDto.getSex());
        dbManager.setInt(9,prpLacciPersonDto.getAge());
        dbManager.setString(10,prpLacciPersonDto.getIdentifyType());
        dbManager.setString(11,prpLacciPersonDto.getIdentifyNumber());
        dbManager.setString(12,prpLacciPersonDto.getRemark());
        dbManager.setString(13,prpLacciPersonDto.getFlag());
        dbManager.setString(14,prpLacciPersonDto.getPhone());
        dbManager.setString(15,prpLacciPersonDto.getAddress());
        dbManager.setString(16,prpLacciPersonDto.getRelationCode());
        dbManager.setString(17,prpLacciPersonDto.getRelationName());
        dbManager.executePreparedUpdate();

    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLacciPerson (");
        buffer.append("CertiNo,");
        buffer.append("CertiType,");
        buffer.append("PolicyNo,");
        buffer.append("SerialNo,");
        buffer.append("FamilyNo,");
        buffer.append("AcciCode,");
        buffer.append("AcciName,");
        buffer.append("Sex,");
        buffer.append("Age,");
        buffer.append("IdentifyType,");
        buffer.append("IdentifyNumber,");
        buffer.append("Remark,");
        buffer.append("Flag, ");
        buffer.append("Phone,");
        buffer.append("Address,");
        buffer.append("RelationCode,");
        buffer.append("RelationName");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLacciPersonDto prpLacciPersonDto = (PrpLacciPersonDto)i.next();
            dbManager.setString(1,prpLacciPersonDto.getCertiNo());
            dbManager.setString(2,prpLacciPersonDto.getCertiType());
            dbManager.setString(3,prpLacciPersonDto.getPolicyNo());
            dbManager.setInt(4,prpLacciPersonDto.getSerialNo());
            dbManager.setInt(5,prpLacciPersonDto.getFamilyNo());
            dbManager.setString(6,prpLacciPersonDto.getAcciCode());
            dbManager.setString(7,prpLacciPersonDto.getAcciName());
            dbManager.setString(8,prpLacciPersonDto.getSex());
            dbManager.setInt(9,prpLacciPersonDto.getAge());
            dbManager.setString(10,prpLacciPersonDto.getIdentifyType());
            dbManager.setString(11,prpLacciPersonDto.getIdentifyNumber());
            dbManager.setString(12,prpLacciPersonDto.getRemark());
            dbManager.setString(13,prpLacciPersonDto.getFlag());
            dbManager.setString(14,prpLacciPersonDto.getPhone());
            dbManager.setString(15,prpLacciPersonDto.getAddress());
            dbManager.setString(16,prpLacciPersonDto.getRelationCode());
            dbManager.setString(17,prpLacciPersonDto.getRelationName());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param certiNo CertiNo
     * @param certiType CertiType
     * @param serialNo SerialNo
     * @throws Exception
     */
    public void delete(String certiNo,String certiType,int serialNo) throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLacciPerson ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("CertiNo=").append("'").append(certiNo).append("' AND ");
            debugBuffer.append("CertiType=").append("'").append(certiType).append("' AND ");
            debugBuffer.append("SerialNo=").append("").append(serialNo).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("CertiNo = ? And ");
        buffer.append("CertiType = ? And ");
        buffer.append("SerialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,certiNo);
        dbManager.setString(2,certiType);
        dbManager.setInt(3,serialNo);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLacciPersonDto prpLacciPersonDto
     * @throws Exception
     */
    public void update(PrpLacciPersonDto prpLacciPersonDto) throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLacciPerson SET ");
        buffer.append("PolicyNo = ?, ");
        buffer.append("FamilyNo = ?, ");
        buffer.append("AcciCode = ?, ");
        buffer.append("AcciName = ?, ");
        buffer.append("Sex = ?, ");
        buffer.append("Age = ?, ");
        buffer.append("IdentifyType = ?, ");
        buffer.append("IdentifyNumber = ?, ");
        buffer.append("Remark = ?, ");
        buffer.append("Flag = ?, ");
        buffer.append("Phone = ?, ");
        buffer.append("Address = ?, ");
        buffer.append("RelationCode = ?, ");
        buffer.append("RelationName = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("CertiNo=").append("'").append(prpLacciPersonDto.getCertiNo()).append("' AND ");
            debugBuffer.append("CertiType=").append("'").append(prpLacciPersonDto.getCertiType()).append("' AND ");
            debugBuffer.append("SerialNo=").append("").append(prpLacciPersonDto.getSerialNo()).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("CertiNo = ? And ");
        buffer.append("CertiType = ? And ");
        buffer.append("SerialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prpLacciPersonDto.getPolicyNo());
        dbManager.setInt(2,prpLacciPersonDto.getFamilyNo());
        dbManager.setString(3,prpLacciPersonDto.getAcciCode());
        dbManager.setString(4,prpLacciPersonDto.getAcciName());
        dbManager.setString(5,prpLacciPersonDto.getSex());
        dbManager.setInt(6,prpLacciPersonDto.getAge());
        dbManager.setString(7,prpLacciPersonDto.getIdentifyType());
        dbManager.setString(8,prpLacciPersonDto.getIdentifyNumber());
        dbManager.setString(9,prpLacciPersonDto.getRemark());
        dbManager.setString(10,prpLacciPersonDto.getFlag());
        dbManager.setString(11,prpLacciPersonDto.getPhone());
        dbManager.setString(12,prpLacciPersonDto.getAddress());
        dbManager.setString(13,prpLacciPersonDto.getRelationCode());
        dbManager.setString(14,prpLacciPersonDto.getRelationName());
        //设置条件字段;
        dbManager.setString(15,prpLacciPersonDto.getCertiNo());
        dbManager.setString(16,prpLacciPersonDto.getCertiType());
        dbManager.setInt(17,prpLacciPersonDto.getSerialNo());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param certiNo CertiNo
     * @param certiType CertiType
     * @param serialNo SerialNo
     * @return PrpLacciPersonDto
     * @throws Exception
     */
    public PrpLacciPersonDto findByPrimaryKey(String certiNo,String certiType,int serialNo) throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("CertiNo,");
        buffer.append("CertiType,");
        buffer.append("PolicyNo,");
        buffer.append("SerialNo,");
        buffer.append("FamilyNo,");
        buffer.append("AcciCode,");
        buffer.append("AcciName,");
        buffer.append("Sex,");
        buffer.append("Age,");
        buffer.append("IdentifyType,");
        buffer.append("IdentifyNumber,");
        buffer.append("Remark,");
        buffer.append("Flag, ");
        buffer.append("Phone, ");
        buffer.append("Address, ");
        buffer.append("RelationCode, ");
        buffer.append("RelationName, ");
        buffer.append("FROM PrpLacciPerson ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("CertiNo=").append("'").append(certiNo).append("' AND ");
            debugBuffer.append("CertiType=").append("'").append(certiType).append("' AND ");
            debugBuffer.append("SerialNo=").append("").append(serialNo).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("CertiNo = ? And ");
        buffer.append("CertiType = ? And ");
        buffer.append("SerialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,certiNo);
        dbManager.setString(2,certiType);
        dbManager.setInt(3,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLacciPersonDto prpLacciPersonDto = null;
        if(resultSet.next()){
            prpLacciPersonDto = new PrpLacciPersonDto();
            prpLacciPersonDto.setCertiNo(dbManager.getString(resultSet,1));
            prpLacciPersonDto.setCertiType(dbManager.getString(resultSet,2));
            prpLacciPersonDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpLacciPersonDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpLacciPersonDto.setFamilyNo(dbManager.getInt(resultSet,5));
            prpLacciPersonDto.setAcciCode(dbManager.getString(resultSet,6));
            prpLacciPersonDto.setAcciName(dbManager.getString(resultSet,7));
            prpLacciPersonDto.setSex(dbManager.getString(resultSet,8));
            prpLacciPersonDto.setAge(dbManager.getInt(resultSet,9));
            prpLacciPersonDto.setIdentifyType(dbManager.getString(resultSet,10));
            prpLacciPersonDto.setIdentifyNumber(dbManager.getString(resultSet,11));
            prpLacciPersonDto.setRemark(dbManager.getString(resultSet,12));
            prpLacciPersonDto.setFlag(dbManager.getString(resultSet,13));
            prpLacciPersonDto.setPhone(dbManager.getString(resultSet,14));
            prpLacciPersonDto.setAddress(dbManager.getString(resultSet,15));
            prpLacciPersonDto.setRelationCode(dbManager.getString(resultSet,16));
            prpLacciPersonDto.setRelationName(dbManager.getString(resultSet,17));
            
        }else{
            logger.info("DBPrpLacciPersonBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLacciPersonDto;
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
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("CertiNo,");
        buffer.append("CertiType,");
        buffer.append("PolicyNo,");
        buffer.append("SerialNo,");
        buffer.append("FamilyNo,");
        buffer.append("AcciCode,");
        buffer.append("AcciName,");
        buffer.append("Sex,");
        buffer.append("Age,");
        buffer.append("IdentifyType,");
        buffer.append("IdentifyNumber,");
        buffer.append("Remark,");
        buffer.append("Flag, ");
        buffer.append("Phone,");
        buffer.append("Address, ");
        buffer.append("RelationCode,");
        buffer.append("RelationName  ");
        buffer.append("FROM PrpLacciPerson WHERE ");
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
        PrpLacciPersonDto prpLacciPersonDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                	break;
                }
            }

            prpLacciPersonDto = new PrpLacciPersonDto();
            prpLacciPersonDto.setCertiNo(dbManager.getString(resultSet,1));
            prpLacciPersonDto.setCertiType(dbManager.getString(resultSet,2));
            prpLacciPersonDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpLacciPersonDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpLacciPersonDto.setFamilyNo(dbManager.getInt(resultSet,5));
            prpLacciPersonDto.setAcciCode(dbManager.getString(resultSet,6));
            prpLacciPersonDto.setAcciName(dbManager.getString(resultSet,7));
            prpLacciPersonDto.setSex(dbManager.getString(resultSet,8));
            prpLacciPersonDto.setAge(dbManager.getInt(resultSet,9));
            prpLacciPersonDto.setIdentifyType(dbManager.getString(resultSet,10));
            prpLacciPersonDto.setIdentifyNumber(dbManager.getString(resultSet,11));
            prpLacciPersonDto.setRemark(dbManager.getString(resultSet,12));
            prpLacciPersonDto.setFlag(dbManager.getString(resultSet,13));
            prpLacciPersonDto.setPhone(dbManager.getString(resultSet,14));
            prpLacciPersonDto.setAddress(dbManager.getString(resultSet,15));
            prpLacciPersonDto.setRelationCode(dbManager.getString(resultSet,16));
            prpLacciPersonDto.setRelationName(dbManager.getString(resultSet,17));
            collection.add(prpLacciPersonDto);
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
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLacciPerson WHERE ");
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
         String  statement ;
                          statement = "SELECT count(1) FROM PrpLacciPerson WHERE ";
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
    
    /**
     * 集合删除
     * @param collection collection
     * @throws Exception
     */
    public void deleteAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLacciPersonDto prpLacciPersonDto = (PrpLacciPersonDto)i.next();
            StringBuffer buffer = new StringBuffer(200);
            buffer.append("DELETE FROM PrpLacciPerson ");
            //设置条件字段;
            buffer.append("WHERE ");
            buffer.append("CertiNo = ? And ");
            buffer.append("CertiType = ? And ");
            buffer.append("SerialNo = ?");
     
            dbManager.prepareStatement(buffer.toString());
            //设置条件字段;
            dbManager.setString(1,prpLacciPersonDto.getCertiNo());
            dbManager.setString(2,prpLacciPersonDto.getCertiType());
            dbManager.setInt(3,prpLacciPersonDto.getSerialNo());
            dbManager.executePreparedUpdate();

        }
    }
    
//    /**
//     * 山东意外险理赔风险查询方法
//     * @param conditions 查询条件
//     * @return Collection
//     * @throws Exception
//     */
//    public Collection findByConditionsOfSDacci(String registNo,String credentialType) throws Exception{
//        return findByConditionsOfSDacci(registNo,credentialType);
//    }
    
    /**
     * 山东意外险理赔风险查询方法
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditionsOfSDacci(String registNo,String credentialType) throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        int pageNo = 0;
        int rowsPerPage = 0;
        String credentialNo = "";
        String birthday = "";
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("CertiNo,");
        buffer.append("SerialNo,");
        buffer.append("AcciName,");
        buffer.append("Sex,");
        buffer.append("IdentifyType,");
        buffer.append("IdentifyNumber ");
        buffer.append("FROM PrpLacciPerson WHERE ");
        buffer.append(" certiNo='" + registNo + "' order by serialNo ");
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
        PrpLacciPersonDto prpLacciPersonDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                	break;
                }
            }

            prpLacciPersonDto = new PrpLacciPersonDto();
            prpLacciPersonDto.setCertiNo(dbManager.getString(resultSet,1));
            prpLacciPersonDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpLacciPersonDto.setAcciName(dbManager.getString(resultSet,3));
            prpLacciPersonDto.setSex(dbManager.getString(resultSet,4));
            prpLacciPersonDto.setIdentifyType(credentialType);
            credentialNo = dbManager.getString(resultSet,6);
		    if(credentialNo.length()==18){
		    	birthday = credentialNo.substring(6, 14);
		    }else if(credentialNo.length()==15){
		    	birthday = "19"+credentialNo.substring(6, 12);
		    }else{
		    	birthday = "19990101";
		    }
		    if("".equals(credentialNo) || credentialNo==null){
		    	credentialNo = "370102199901010015";
		    }
            prpLacciPersonDto.setIdentifyNumber(credentialNo);
            prpLacciPersonDto.setBirthday(birthday);
            collection.add(prpLacciPersonDto);
        }
        resultSet.close();
        return collection;
    }
}
    
    

