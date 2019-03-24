package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.MedicalPolicyListDto;;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是MedicalGPOLICYLIST的数据访问对象基类<br>
 */
public class DBMedicalPolicyListBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBMedicalPolicyListBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBMedicalPolicyListBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param medicalPolicyList medicalPolicyList
     * @throws Exception
     */
    public void insert(MedicalPolicyListDto medicalPolicyList)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Medicalpolicylist (");
        buffer.append("Inusrelistcode,");
        buffer.append("Kindcode,");
        buffer.append("Indexcode,");
        buffer.append("Phone,");
        buffer.append("Name,");
        buffer.append("Idcard,");
        buffer.append("Age,");
        buffer.append("BscAmount,");
        buffer.append("OptAmount,");
        buffer.append("Rate,");
        buffer.append("Shortrateflag,");
        buffer.append("Shortrate,");
        buffer.append("SumAmount,");
        buffer.append("SumPremium,");
        buffer.append("Startdate,");
        buffer.append("Enddate,");
        buffer.append("Calculateflag,");
        buffer.append("Opcode,");
        buffer.append("Optime,");
        buffer.append("Validity,");
        buffer.append("Remark ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(medicalPolicyList.getInusreListCode()).append("',");
            debugBuffer.append("'").append(medicalPolicyList.getKindCode()).append("',");
            debugBuffer.append("'").append(medicalPolicyList.getIndexCode()).append("',");
            debugBuffer.append("'").append(medicalPolicyList.getPhone()).append("',");
            debugBuffer.append("'").append(medicalPolicyList.getName()).append("',");
            debugBuffer.append("'").append(medicalPolicyList.getIdCard()).append("',");
            debugBuffer.append("'").append(medicalPolicyList.getAge()).append("',");
            debugBuffer.append("").append(medicalPolicyList.getBscAmount()).append(",");
            debugBuffer.append("").append(medicalPolicyList.getOptAmount()).append(",");
            debugBuffer.append("").append(medicalPolicyList.getRate()).append(",");
            debugBuffer.append("'").append(medicalPolicyList.getShortRateFlag()).append("',");
            debugBuffer.append("").append(medicalPolicyList.getShortRate()).append(",");
            debugBuffer.append("").append(medicalPolicyList.getSumAmount()).append(",");
            debugBuffer.append("").append(medicalPolicyList.getSumPremium()).append(",");
            debugBuffer.append("'").append(medicalPolicyList.getStartDate()).append("',");
            debugBuffer.append("'").append(medicalPolicyList.getEndDate()).append("',");
            debugBuffer.append("'").append(medicalPolicyList.getCalculateFlag()).append("',");
            debugBuffer.append("'").append(medicalPolicyList.getOpCode()).append("',");
            debugBuffer.append("'").append(medicalPolicyList.getOpTime()).append("',");
            debugBuffer.append("'").append(medicalPolicyList.getValidity()).append("',");
			debugBuffer.append("'").append(medicalPolicyList.getReMark()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,medicalPolicyList.getInusreListCode());
        dbManager.setString(2,medicalPolicyList.getKindCode());
        dbManager.setString(3,medicalPolicyList.getIndexCode());
        dbManager.setString(4,medicalPolicyList.getPhone());
        dbManager.setString(5,medicalPolicyList.getName());
        dbManager.setString(6,medicalPolicyList.getIdCard());
        dbManager.setString(7,medicalPolicyList.getAge());
        dbManager.setDouble(8,medicalPolicyList.getBscAmount());
        dbManager.setDouble(9,medicalPolicyList.getOptAmount());
        dbManager.setDouble(10,medicalPolicyList.getRate());
        dbManager.setString(11,medicalPolicyList.getShortRateFlag());
        dbManager.setDouble(12,medicalPolicyList.getShortRate());
        dbManager.setDouble(13,medicalPolicyList.getSumAmount());
        dbManager.setDouble(14,medicalPolicyList.getSumPremium());
        dbManager.setDateTime(15,medicalPolicyList.getStartDate());
        dbManager.setDateTime(16,medicalPolicyList.getEndDate());
        dbManager.setString(17,medicalPolicyList.getCalculateFlag());
        dbManager.setString(18,medicalPolicyList.getOpCode());
        dbManager.setDateTime(19,medicalPolicyList.getOpTime());
        dbManager.setString(20,medicalPolicyList.getValidity());
        dbManager.setString(21,medicalPolicyList.getReMark());
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
        buffer.append("INSERT INTO Medicalpolicylist (");
        buffer.append("Inusrelistcode,");
        buffer.append("Kindcode,");
        buffer.append("Indexcode,");
        buffer.append("Phone,");
        buffer.append("Name,");
        buffer.append("Idcard,");
        buffer.append("Age,");
        buffer.append("BscAmount,");
        buffer.append("OptAmount,");
        buffer.append("Rate,");
        buffer.append("Shortrateflag,");
        buffer.append("Shortrate,");
        buffer.append("SumAmount,");
        buffer.append("SumPremium,");
        buffer.append("Startdate,");
        buffer.append("Enddate,");
        buffer.append("Calculateflag,");
        buffer.append("Opcode,");
        buffer.append("Optime,");
        buffer.append("Validity,");
        buffer.append("Remark ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            MedicalPolicyListDto medicalPolicyList = (MedicalPolicyListDto)i.next();
			dbManager.setString(1,medicalPolicyList.getInusreListCode());
			dbManager.setString(2,medicalPolicyList.getKindCode());
			dbManager.setString(3,medicalPolicyList.getIndexCode());
			dbManager.setString(4,medicalPolicyList.getPhone());
			dbManager.setString(5,medicalPolicyList.getName());
			dbManager.setString(6,medicalPolicyList.getIdCard());
			dbManager.setString(7,medicalPolicyList.getAge());
			dbManager.setDouble(8,medicalPolicyList.getBscAmount());
			dbManager.setDouble(9,medicalPolicyList.getOptAmount());
			dbManager.setDouble(10,medicalPolicyList.getRate());
			dbManager.setString(11,medicalPolicyList.getShortRateFlag());
			dbManager.setDouble(12,medicalPolicyList.getShortRate());
			dbManager.setDouble(13,medicalPolicyList.getSumAmount());
			dbManager.setDouble(14,medicalPolicyList.getSumPremium());
			dbManager.setDateTime(15,medicalPolicyList.getStartDate());
			dbManager.setDateTime(16,medicalPolicyList.getEndDate());
			dbManager.setString(17,medicalPolicyList.getCalculateFlag());
			dbManager.setString(18,medicalPolicyList.getOpCode());
			dbManager.setDateTime(19,medicalPolicyList.getOpTime());
			dbManager.setString(20,medicalPolicyList.getValidity());
			dbManager.setString(21,medicalPolicyList.getReMark());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param inusrelistcode INUSRELISTCODE
     * @param fcode FCODE
     * @throws Exception
     */
    public void delete(String inusrelistcode,String idcard)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM Medicalpolicylist ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Inusrelistcode=").append("'").append(inusrelistcode).append("' AND ");
            debugBuffer.append("Idcard=").append("'").append(idcard).append("'");
            //debugBuffer.append("Kindcode=").append("'").append(kindcode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Inusrelistcode = ? And ");
        buffer.append("Idcard = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,inusrelistcode);
        dbManager.setString(2,idcard);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param medicalPolicyList medicalPolicyList
     * @throws Exception
     */
    public void update(MedicalPolicyListDto medicalPolicyList)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Medicalpolicylist SET ");
		buffer.append("KindCode = ?, ");
        buffer.append("Indexcode = ?, ");
        buffer.append("Phone = ?, ");
        buffer.append("Name = ?, ");
        buffer.append("Age = ?, ");
        buffer.append("BscAmount = ?, ");
        buffer.append("OptAmount = ?, ");
        buffer.append("Rate = ?, ");
        buffer.append("Shortrateflag = ?, ");
        buffer.append("Shortrate = ?, ");
        buffer.append("Sumamount = ?, ");
        buffer.append("Sumpremium = ?, ");
        buffer.append("Startdate = ?, ");
        buffer.append("Enddate = ?, ");
        buffer.append("Calculateflag = ?, ");
        buffer.append("Opcode = ?, ");
        buffer.append("Optime = ?, ");
        buffer.append("Validity = ?, ");
        buffer.append("ReMark = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE Medicalpolicylist SET ");
			debugBuffer.append("KindCode = '" + medicalPolicyList.getKindCode() + "', ");
            debugBuffer.append("Indexcode = '" + medicalPolicyList.getIndexCode() + "', ");
            debugBuffer.append("Phone = '" + medicalPolicyList.getPhone() + "', ");
            debugBuffer.append("Name = '" + medicalPolicyList.getName() + "', ");
            debugBuffer.append("Age = '" + medicalPolicyList.getAge() + "', ");
            debugBuffer.append("BscAmount = " + medicalPolicyList.getBscAmount() + ", ");
            debugBuffer.append("OptAmount = " + medicalPolicyList.getOptAmount() + ", ");
            debugBuffer.append("Rate = " + medicalPolicyList.getRate() + ", ");
            debugBuffer.append("Shortrateflag = '" + medicalPolicyList.getShortRateFlag() + "', ");
            debugBuffer.append("Shortrate = " + medicalPolicyList.getShortRate() + ", ");
            debugBuffer.append("Sumamount = " + medicalPolicyList.getSumAmount() + ", ");
            debugBuffer.append("Sumpremium = " + medicalPolicyList.getSumPremium() + ", ");
            debugBuffer.append("Startdate = '" + medicalPolicyList.getStartDate() + "', ");
            debugBuffer.append("Enddate = '" + medicalPolicyList.getEndDate() + "', ");
            debugBuffer.append("Calculateflag = '" + medicalPolicyList.getCalculateFlag() + "', ");
            debugBuffer.append("Opcode = '" + medicalPolicyList.getOpCode() + "', ");
            debugBuffer.append("Optime = '" + medicalPolicyList.getOpTime() + "', ");
            debugBuffer.append("Validity = '" + medicalPolicyList.getValidity() + "', ");
            debugBuffer.append("Remark = '" + medicalPolicyList.getReMark() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Inusrelistcode=").append("'").append(medicalPolicyList.getInusreListCode()).append("' AND ");
            debugBuffer.append("Idcard=").append("'").append(medicalPolicyList.getIdCard()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Inusrelistcode = ? And ");
        buffer.append("Idcard = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
		dbManager.setString(1,medicalPolicyList.getKindCode());
		dbManager.setString(2,medicalPolicyList.getIndexCode());
		dbManager.setString(3,medicalPolicyList.getPhone());
		dbManager.setString(4,medicalPolicyList.getName());
		dbManager.setString(5,medicalPolicyList.getAge());
		dbManager.setDouble(6,medicalPolicyList.getBscAmount());
		dbManager.setDouble(7,medicalPolicyList.getOptAmount());
		dbManager.setDouble(8,medicalPolicyList.getRate());
		dbManager.setString(9,medicalPolicyList.getShortRateFlag());
		dbManager.setDouble(10,medicalPolicyList.getShortRate());
		dbManager.setDouble(11,medicalPolicyList.getSumAmount());
		dbManager.setDouble(12,medicalPolicyList.getSumPremium());
		dbManager.setDateTime(13,medicalPolicyList.getStartDate());
		dbManager.setDateTime(14,medicalPolicyList.getEndDate());
		dbManager.setString(15,medicalPolicyList.getCalculateFlag());
		dbManager.setString(16,medicalPolicyList.getOpCode());
		dbManager.setDateTime(17,medicalPolicyList.getOpTime());
		dbManager.setString(18,medicalPolicyList.getValidity());
		dbManager.setString(19,medicalPolicyList.getReMark());
        //设置条件字段;
        dbManager.setString(20,medicalPolicyList.getInusreListCode());
        dbManager.setString(21,medicalPolicyList.getIdCard());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param inusrelistcode INUSRELISTCODE
     * @param fcode FCODE
     * @param kindcode KINDCODE
     * @return MedicalPolicyList
     * @throws Exception
     */
    public MedicalPolicyListDto findByPrimaryKey(String inusrelistcode,String idcard)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("Inusrelistcode,");
        buffer.append("Kindcode,");
        buffer.append("Indexcode,");
        buffer.append("Phone,");
        buffer.append("Name,");
        buffer.append("Idcard,");
        buffer.append("Age,");
        buffer.append("BscAmount,");
        buffer.append("OptAmount,");
        buffer.append("Rate,");
        buffer.append("Shortrateflag,");
        buffer.append("Shortrate,");
        buffer.append("SumAmount,");
        buffer.append("SumPremium,");
        buffer.append("Startdate,");
        buffer.append("Enddate,");
        buffer.append("Calculateflag,");
        buffer.append("Opcode,");
        buffer.append("Optime,");
        buffer.append("Validity,");
        buffer.append("Remark ");
        buffer.append("FROM Medicalpolicylist ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Inusrelistcode=").append("'").append(inusrelistcode).append("' AND ");
            debugBuffer.append("Idcard=").append("'").append(idcard).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Inusrelistcode = ? And ");
        buffer.append("Idcard = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,inusrelistcode);
        dbManager.setString(2,idcard);
        ResultSet resultSet = dbManager.executePreparedQuery();
        MedicalPolicyListDto medicalPolicyList = null;
        if(resultSet.next()){
            medicalPolicyList = new MedicalPolicyListDto();
            medicalPolicyList.setInusreListCode(dbManager.getString(resultSet,1));
            medicalPolicyList.setKindCode(dbManager.getString(resultSet,2));
            medicalPolicyList.setIndexCode(dbManager.getString(resultSet,3));
            medicalPolicyList.setPhone(dbManager.getString(resultSet,4));
            medicalPolicyList.setName(dbManager.getString(resultSet,5));
            medicalPolicyList.setIdCard(dbManager.getString(resultSet,6));
            medicalPolicyList.setAge(dbManager.getString(resultSet,7));
            medicalPolicyList.setBscAmount(dbManager.getDouble(resultSet,8));
            medicalPolicyList.setOptAmount(dbManager.getDouble(resultSet,9));
            medicalPolicyList.setRate(dbManager.getDouble(resultSet,10));
            medicalPolicyList.setShortRateFlag(dbManager.getString(resultSet,11));
            medicalPolicyList.setShortRate(dbManager.getDouble(resultSet,12));
            medicalPolicyList.setSumAmount(dbManager.getDouble(resultSet,13));
            medicalPolicyList.setSumPremium(dbManager.getDouble(resultSet,14));
            medicalPolicyList.setStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,15));
            medicalPolicyList.setEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,16));
            medicalPolicyList.setCalculateFlag(dbManager.getString(resultSet,17));
            medicalPolicyList.setOpCode(dbManager.getString(resultSet,18));
            medicalPolicyList.setOpTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_MILLISECOND,19));
            medicalPolicyList.setValidity(dbManager.getString(resultSet,20));
            medicalPolicyList.setReMark(dbManager.getString(resultSet,21));

        }
        resultSet.close();
        return medicalPolicyList;
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
        buffer.append("Inusrelistcode,");
        buffer.append("Kindcode,");
        buffer.append("Indexcode,");
        buffer.append("Phone,");
        buffer.append("Name,");
        buffer.append("Idcard,");
        buffer.append("Age,");
        buffer.append("BscAmount,");
        buffer.append("OptAmount,");
        buffer.append("Rate,");
        buffer.append("Shortrateflag,");
        buffer.append("Shortrate,");
        buffer.append("SumAmount,");
        buffer.append("SumPremium,");
        buffer.append("Startdate,");
        buffer.append("Enddate,");
        buffer.append("Calculateflag,");
        buffer.append("Opcode,");
        buffer.append("Optime,");
        buffer.append("Validity,");
        buffer.append("Remark ");
        buffer.append("FROM Medicalpolicylist WHERE ");
        buffer.append(conditions);
        boolean supportPaging = false;//数据库是否支持分页
        if (pageNo > 0){
            //对Oracle优化
            if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("Oracle")){
                buffer.insert(0,"SELECT * FROM ( SELECT row_.*, rownum rownum_ FROM (");
                buffer.append(") row_ WHERE rownum <= "+rowsPerPage * pageNo+") WHERE rownum_ > "+rowsPerPage * (pageNo - 1));
                supportPaging=true;
            }
            else if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("DB2")){
                String sql = buffer.toString();
                buffer.setLength(0);
                buffer.append("select * from ( select rownumber() over(");
                int orderByIndex = sql.toLowerCase().indexOf("order by");
                if ( orderByIndex>0 ) {
                   buffer.append( sql.substring(orderByIndex) );
                }
                buffer.append(") as rownumber_,");
                buffer.append(sql.substring( 6 ));
                buffer.append(" ) as temp_ where rownumber_");
                buffer.append(" between "+ (rowsPerPage * (pageNo - 1) + 1) +" and "+rowsPerPage * pageNo);
                supportPaging=true;
            }
        }
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        //System.err.println("dbManager查询条件：" + buffer.toString());
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        //System.err.println("dbManager查询完毕");
        
        int count=0;
        if(supportPaging==false && pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }
        //System.err.println("dbManager定位完毕");

        //定义返回结果集合
        Collection collection = new ArrayList(rowsPerPage);
        MedicalPolicyListDto medicalPolicyList = null;
        boolean isNullResult = true;
        
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            medicalPolicyList = new MedicalPolicyListDto();
            medicalPolicyList.setInusreListCode(dbManager.getString(resultSet,"Inusrelistcode"));
            //System.err.println("Inusrelistcode：" + dbManager.getString(resultSet,"Inusrelistcode"));
            medicalPolicyList.setKindCode(dbManager.getString(resultSet,"Kindcode"));
            medicalPolicyList.setIndexCode(dbManager.getString(resultSet,"Indexcode"));
            medicalPolicyList.setPhone(dbManager.getString(resultSet,"Phone"));
            //System.err.println("Name：" + dbManager.getString(resultSet,"Name"));
            medicalPolicyList.setName(dbManager.getString(resultSet,"Name"));
            
            medicalPolicyList.setIdCard(dbManager.getString(resultSet,"Idcard"));
            medicalPolicyList.setAge(dbManager.getString(resultSet,"Age"));
            medicalPolicyList.setBscAmount(dbManager.getDouble(resultSet,"BscAmount"));
            medicalPolicyList.setOptAmount(dbManager.getDouble(resultSet,"OptAmount"));
            //System.err.println("Rate：" + dbManager.getString(resultSet,"Rate"));
            medicalPolicyList.setRate(dbManager.getDouble(resultSet,"Rate"));
            medicalPolicyList.setShortRateFlag(dbManager.getString(resultSet,"Shortrateflag"));
            medicalPolicyList.setShortRate(dbManager.getDouble(resultSet,"Shortrate"));
            medicalPolicyList.setSumAmount(dbManager.getDouble(resultSet,"Sumamount"));
            medicalPolicyList.setSumPremium(dbManager.getDouble(resultSet,"Sumpremium"));
            medicalPolicyList.setStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Startdate"));
            medicalPolicyList.setEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Enddate"));
            
            medicalPolicyList.setCalculateFlag(dbManager.getString(resultSet,"Calculateflag"));
            medicalPolicyList.setOpCode(dbManager.getString(resultSet,"Opcode"));
            medicalPolicyList.setOpTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_MILLISECOND,"Optime"));
            medicalPolicyList.setValidity(dbManager.getString(resultSet,"Validity"));
            
            medicalPolicyList.setReMark(dbManager.getString(resultSet,"Remark"));
            collection.add(medicalPolicyList);
            isNullResult = false;
        }
        System.err.println("isNullResult：" + isNullResult);
        
        if(isNullResult){
        	//collection = findByConditionsInStoreTable(conditions, pageNo, rowsPerPage);
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
        buffer.append("DELETE FROM Medicalpolicylist WHERE ");
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
        buffer.append("SELECT count(*) FROM Medicalpolicylist WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        //if(count <= 0)
        	//count = getCountInStoreTable(conditions);
        return count;
    }
    /**
     * 查询满足模糊查询条件的记录数
     * @param conditions conditions
     * @param fieldName 字段名
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public double getSum(String conditions, String fieldName)
        throws Exception{
    	double sum = 0;
    	if(null!=fieldName && !"".equals(fieldName)){
	        StringBuffer buffer = new StringBuffer(100);
	        buffer.append("SELECT sum("+fieldName+") FROM Medicalpolicylist WHERE ");
	        buffer.append(conditions);
	        if(logger.isDebugEnabled()){
	            logger.debug(buffer.toString());
	        }
	        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
	        resultSet.next();
	        sum = dbManager.getDouble(resultSet,1);
	        resultSet.close();
    	}
        //if(sum == 0)
        	//sum = getSumInStoreTable(conditions, fieldName);
        return sum;
    }
    
  







}
