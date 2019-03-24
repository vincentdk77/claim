package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.MedicalsettlelistDto;
import java.math.BigDecimal;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是MedicalSETTLELIST的数据访问对象基类<br>
 */
public class DBMedicalsettlelistBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBMedicalsettlelistBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBMedicalsettlelistBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param MedicalsettlelistDto MedicalsettlelistDto
     * @throws Exception
     */
    public void insert(MedicalsettlelistDto MedicalsettlelistDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Medicalsettlelist (");
        buffer.append("Settlelistcode,");
        buffer.append("Classcode,");
        buffer.append("Riskcode,");
        buffer.append("Suminsured,");
        buffer.append("Medicalcard,");
		buffer.append("Medicalfamily,");
        buffer.append("Name,");
        buffer.append("Idcard,");
        buffer.append("Inusrelistcode,");
        buffer.append("Creditcard,");
        buffer.append("Settlesum,");
        buffer.append("Opcode,");
        buffer.append("Optime,");
        buffer.append("Remark,");
        buffer.append("Validity,");
        buffer.append("Settledate,");
        buffer.append("Nodetype,");
        buffer.append("Indexofsettle,");
        buffer.append("Phone,");
        buffer.append("Bank ");

        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(MedicalsettlelistDto.getSettlelistcode()).append("',");

            debugBuffer.append("'").append(MedicalsettlelistDto.getClasscode()).append("',");
            debugBuffer.append("'").append(MedicalsettlelistDto.getRiskcode()).append("',");
            debugBuffer.append("").append(MedicalsettlelistDto.getSuminsured()).append(",");
            debugBuffer.append("'").append(MedicalsettlelistDto.getMedicalcard()).append("',");
			debugBuffer.append("'").append(MedicalsettlelistDto.getMedicalfamily()).append("',");
            debugBuffer.append("'").append(MedicalsettlelistDto.getName()).append("',");
            debugBuffer.append("'").append(MedicalsettlelistDto.getIdcard()).append("',");
            debugBuffer.append("'").append(MedicalsettlelistDto.getInusrelistcode()).append("',");
            debugBuffer.append("'").append(MedicalsettlelistDto.getCreditcard()).append("',");
            debugBuffer.append("").append(MedicalsettlelistDto.getSettlesum()).append(",");
            debugBuffer.append("'").append(MedicalsettlelistDto.getOpcode()).append("',");
            debugBuffer.append("'").append(MedicalsettlelistDto.getOptime()).append("',");
            debugBuffer.append("'").append(MedicalsettlelistDto.getRemark()).append("',");
            debugBuffer.append("'").append(MedicalsettlelistDto.getValidity()).append("',");
            debugBuffer.append("'").append(MedicalsettlelistDto.getSettledate()).append("',");
            debugBuffer.append("'").append(MedicalsettlelistDto.getNodetype()).append("',");
            debugBuffer.append("").append(MedicalsettlelistDto.getIndexofsettle()).append(",");
            debugBuffer.append("'").append(MedicalsettlelistDto.getPhone()).append("',");
            debugBuffer.append("'").append(MedicalsettlelistDto.getBank()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,MedicalsettlelistDto.getSettlelistcode());
        dbManager.setString(2,MedicalsettlelistDto.getClasscode());
        dbManager.setString(3,MedicalsettlelistDto.getRiskcode());
        dbManager.setDouble(4,MedicalsettlelistDto.getSuminsured());
        dbManager.setString(5,MedicalsettlelistDto.getMedicalcard());
		dbManager.setString(6,MedicalsettlelistDto.getMedicalfamily());
        dbManager.setString(7,MedicalsettlelistDto.getName());
        dbManager.setString(8,MedicalsettlelistDto.getIdcard());
        dbManager.setString(9,MedicalsettlelistDto.getInusrelistcode());
        dbManager.setString(10,MedicalsettlelistDto.getCreditcard());
        dbManager.setDouble(11,MedicalsettlelistDto.getSettlesum());
        dbManager.setString(12,MedicalsettlelistDto.getOpcode());
        dbManager.setDateTime(13,MedicalsettlelistDto.getOptime());
        dbManager.setString(14,MedicalsettlelistDto.getRemark());
        dbManager.setString(15,MedicalsettlelistDto.getValidity());
        dbManager.setDateTime(16,MedicalsettlelistDto.getSettledate());
        dbManager.setString(17,MedicalsettlelistDto.getNodetype());
        dbManager.setInt(18,MedicalsettlelistDto.getIndexofsettle());
        dbManager.setString(19,MedicalsettlelistDto.getPhone());
        dbManager.setString(20,MedicalsettlelistDto.getBank());

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
        buffer.append("INSERT INTO Medicalsettlelist (");
        buffer.append("Settlelistcode,");
        buffer.append("Classcode,");
        buffer.append("Riskcode,");
        buffer.append("Suminsured,");
        buffer.append("Medicalcard,");
		buffer.append("Medicalfamily,");
        buffer.append("Name,");
        buffer.append("Idcard,");
        buffer.append("Inusrelistcode,");
        buffer.append("Creditcard,");
        buffer.append("Settlesum,");
        buffer.append("Opcode,");
        buffer.append("Optime,");
        buffer.append("Remark,");
        buffer.append("Validity,");
        buffer.append("Settledate,");
        buffer.append("Nodetype,");
        buffer.append("Indexofsettle,");
        buffer.append("Phone,");
        buffer.append("Bank ");

        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            MedicalsettlelistDto MedicalsettlelistDto = (MedicalsettlelistDto)i.next();

			dbManager.setString(1,MedicalsettlelistDto.getSettlelistcode());
			dbManager.setString(2,MedicalsettlelistDto.getClasscode());
			dbManager.setString(3,MedicalsettlelistDto.getRiskcode());
			dbManager.setDouble(4,MedicalsettlelistDto.getSuminsured());
			dbManager.setString(5,MedicalsettlelistDto.getMedicalcard());
			dbManager.setString(6,MedicalsettlelistDto.getMedicalfamily());
			dbManager.setString(7,MedicalsettlelistDto.getName());
			dbManager.setString(8,MedicalsettlelistDto.getIdcard());
			dbManager.setString(9,MedicalsettlelistDto.getInusrelistcode());
			dbManager.setString(10,MedicalsettlelistDto.getCreditcard());
			dbManager.setDouble(11,MedicalsettlelistDto.getSettlesum());
			dbManager.setString(12,MedicalsettlelistDto.getOpcode());
			dbManager.setDateTime(13,MedicalsettlelistDto.getOptime());
			dbManager.setString(14,MedicalsettlelistDto.getRemark());
			dbManager.setString(15,MedicalsettlelistDto.getValidity());
			dbManager.setDateTime(16,MedicalsettlelistDto.getSettledate());
			dbManager.setString(17,MedicalsettlelistDto.getNodetype());
			dbManager.setInt(18,MedicalsettlelistDto.getIndexofsettle());
			dbManager.setString(19,MedicalsettlelistDto.getPhone());
			dbManager.setString(20,MedicalsettlelistDto.getBank());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param settlelistcode SETTLELISTCODE
     * @param fcode FCODE
     * @param kindcode KINDCODE
     * @param nodetype NODETYPE
     * @param indexofsettle INDEXOFSETTLE
     * @throws Exception
     */
    public void delete(String settlelistcode,String idcard,String nodetype,int indexofsettle)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM Medicalsettlelist ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Settlelistcode=").append("'").append(settlelistcode).append("' AND ");
            debugBuffer.append("Idcard=").append("'").append(idcard).append("' AND ");
            debugBuffer.append("Nodetype=").append("'").append(nodetype).append("' AND ");
            debugBuffer.append("Indexofsettle=").append("").append(indexofsettle).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Settlelistcode = ? And ");
        buffer.append("Idcard = ? And ");
        buffer.append("Nodetype = ? And ");
        buffer.append("Indexofsettle = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,settlelistcode);
        dbManager.setString(2,idcard);
        dbManager.setString(3,nodetype);
        dbManager.setInt(4,indexofsettle);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param MedicalsettlelistDto MedicalsettlelistDto
     * @throws Exception
     */
    public void update(MedicalsettlelistDto MedicalsettlelistDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Medicalsettlelist SET ");
        buffer.append("Classcode = ?, ");
        buffer.append("Riskcode = ?, ");
        buffer.append("Suminsured = ?, ");
		buffer.append("Medicalcard = ?, ");
        buffer.append("Medicalfamily = ?, ");
        buffer.append("Name = ?, ");
        buffer.append("Inusrelistcode = ?, ");
        buffer.append("Creditcard = ?, ");
        buffer.append("Settlesum = ?, ");
        buffer.append("Opcode = ?, ");
        buffer.append("Optime = ?, ");
        buffer.append("Remark = ?, ");
        buffer.append("Validity = ?, ");
        buffer.append("Settledate = ?, ");
        buffer.append("Phone = ?, ");
        buffer.append("Phone,");
        buffer.append("Bank ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE Medicalsettlelist SET ");
            debugBuffer.append("Classcode = '" + MedicalsettlelistDto.getClasscode() + "', ");
            debugBuffer.append("Riskcode = '" + MedicalsettlelistDto.getRiskcode() + "', ");
            debugBuffer.append("Suminsured = " + MedicalsettlelistDto.getSuminsured() + ", ");
            debugBuffer.append("Medicalcard = '" + MedicalsettlelistDto.getMedicalcard() + "', ");
			debugBuffer.append("Medicalfamily = '" + MedicalsettlelistDto.getMedicalfamily() + "', ");
            debugBuffer.append("Name = '" + MedicalsettlelistDto.getName() + "', ");
            debugBuffer.append("Inusrelistcode = '" + MedicalsettlelistDto.getInusrelistcode() + "', ");
            debugBuffer.append("Creditcard = '" + MedicalsettlelistDto.getCreditcard() + "', ");
            debugBuffer.append("Settlesum = " + MedicalsettlelistDto.getSettlesum() + ", ");
            debugBuffer.append("Opcode = '" + MedicalsettlelistDto.getOpcode() + "', ");
            debugBuffer.append("Optime = '" + MedicalsettlelistDto.getOptime() + "', ");
            debugBuffer.append("Remark = '" + MedicalsettlelistDto.getRemark() + "', ");
            debugBuffer.append("Validity = '" + MedicalsettlelistDto.getValidity() + "', ");
            debugBuffer.append("Settledate = '" + MedicalsettlelistDto.getSettledate() + "', ");
            debugBuffer.append("Phone = '" + MedicalsettlelistDto.getPhone() + "', ");
            debugBuffer.append("Bank = '" + MedicalsettlelistDto.getBank() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Settlelistcode=").append("'").append(MedicalsettlelistDto.getSettlelistcode()).append("' AND ");
            debugBuffer.append("Idcard=").append("'").append(MedicalsettlelistDto.getIdcard()).append("' AND ");
            debugBuffer.append("Nodetype=").append("'").append(MedicalsettlelistDto.getNodetype()).append("' AND ");
            debugBuffer.append("Indexofsettle=").append("").append(MedicalsettlelistDto.getIndexofsettle()).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Settlelistcode = ? And ");
        buffer.append("Idcard = ? And ");
        buffer.append("Nodetype = ? And ");
        buffer.append("Indexofsettle = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
		
		dbManager.setString(1,MedicalsettlelistDto.getClasscode());
		dbManager.setString(2,MedicalsettlelistDto.getRiskcode());
		dbManager.setDouble(3,MedicalsettlelistDto.getSuminsured());
		dbManager.setString(4,MedicalsettlelistDto.getMedicalcard());
		dbManager.setString(5,MedicalsettlelistDto.getMedicalfamily());
		dbManager.setString(6,MedicalsettlelistDto.getName());

		dbManager.setString(7,MedicalsettlelistDto.getInusrelistcode());
		dbManager.setString(8,MedicalsettlelistDto.getCreditcard());
		dbManager.setDouble(9,MedicalsettlelistDto.getSettlesum());
		dbManager.setString(10,MedicalsettlelistDto.getOpcode());
		dbManager.setDateTime(11,MedicalsettlelistDto.getOptime());
		dbManager.setString(12,MedicalsettlelistDto.getRemark());
		dbManager.setString(13,MedicalsettlelistDto.getValidity());
		dbManager.setDateTime(14,MedicalsettlelistDto.getSettledate());
		dbManager.setString(15,MedicalsettlelistDto.getPhone());
		dbManager.setString(16,MedicalsettlelistDto.getBank());
		//设置条件字段
		dbManager.setString(17,MedicalsettlelistDto.getSettlelistcode());
		dbManager.setString(18,MedicalsettlelistDto.getIdcard());
		dbManager.setInt(19,MedicalsettlelistDto.getIndexofsettle());
        dbManager.setString(20,MedicalsettlelistDto.getNodetype());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param settlelistcode SETTLELISTCODE
     * @param fcode FCODE
     * @param kindcode KINDCODE
     * @param nodetype NODETYPE
     * @param indexofsettle INDEXOFSETTLE
     * @return MedicalsettlelistDto
     * @throws Exception
     */
    public MedicalsettlelistDto findByPrimaryKey(String settlelistcode,String idcard,String nodetype,int indexofsettle)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("Settlelistcode,");
        buffer.append("Classcode,");
        buffer.append("Riskcode,");
        buffer.append("Suminsured,");
        buffer.append("Medicalcard,");
		buffer.append("Medicalfamily,");
        buffer.append("Name,");
        buffer.append("Idcard,");
        buffer.append("Inusrelistcode,");
        buffer.append("Creditcard,");
        buffer.append("Settlesum,");
        buffer.append("Opcode,");
        buffer.append("Optime,");
        buffer.append("Remark,");
        buffer.append("Validity,");
        buffer.append("Settledate,");
        buffer.append("Nodetype,");
        buffer.append("Indexofsettle,");
        buffer.append("Phone,");
        buffer.append("Bank ");
        buffer.append("FROM Medicalsettlelist ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Settlelistcode=").append("'").append(settlelistcode).append("' AND ");
            debugBuffer.append("Idcard=").append("'").append(idcard).append("' AND ");
            debugBuffer.append("Nodetype=").append("'").append(nodetype).append("' AND ");
            debugBuffer.append("Indexofsettle=").append("").append(indexofsettle).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Settlelistcode = ? And ");
        buffer.append("Idcard = ? And ");
        buffer.append("Nodetype = ? And ");
        buffer.append("Indexofsettle = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,settlelistcode);
        dbManager.setString(2,idcard);
        dbManager.setString(3,nodetype);
        dbManager.setInt(4,indexofsettle);
        ResultSet resultSet = dbManager.executePreparedQuery();
        MedicalsettlelistDto MedicalsettlelistDto = null;
        if(resultSet.next()){
            MedicalsettlelistDto = new MedicalsettlelistDto();
            MedicalsettlelistDto.setSettlelistcode(dbManager.getString(resultSet,1));

            MedicalsettlelistDto.setClasscode(dbManager.getString(resultSet,2));
            MedicalsettlelistDto.setRiskcode(dbManager.getString(resultSet,3));

            MedicalsettlelistDto.setSuminsured(dbManager.getDouble(resultSet,4));
            MedicalsettlelistDto.setMedicalcard(dbManager.getString(resultSet,5));
			MedicalsettlelistDto.setMedicalfamily(dbManager.getString(resultSet,6));
            MedicalsettlelistDto.setName(dbManager.getString(resultSet,7));
            MedicalsettlelistDto.setIdcard(dbManager.getString(resultSet,8));
            MedicalsettlelistDto.setInusrelistcode(dbManager.getString(resultSet,9));
            MedicalsettlelistDto.setCreditcard(dbManager.getString(resultSet,10));
            MedicalsettlelistDto.setSettlesum(dbManager.getDouble(resultSet,11));
            MedicalsettlelistDto.setOpcode(dbManager.getString(resultSet,12));
            MedicalsettlelistDto.setOptime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,13));
            MedicalsettlelistDto.setRemark(dbManager.getString(resultSet,14));
            MedicalsettlelistDto.setValidity(dbManager.getString(resultSet,15));
            MedicalsettlelistDto.setSettledate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,16));
            MedicalsettlelistDto.setNodetype(dbManager.getString(resultSet,17));
            MedicalsettlelistDto.setIndexofsettle(dbManager.getInt(resultSet,18));
            MedicalsettlelistDto.setPhone(dbManager.getString(resultSet,19));
            MedicalsettlelistDto.setBank(dbManager.getString(resultSet,20));
        }
        resultSet.close();
        return MedicalsettlelistDto;
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
        buffer.append("Settlelistcode,");
        buffer.append("Classcode,");
        buffer.append("Riskcode,");
        buffer.append("Suminsured,");
        buffer.append("Medicalcard,");
		buffer.append("Medicalfamily,");
        buffer.append("Name,");
        buffer.append("Idcard,");
        buffer.append("Inusrelistcode,");
        buffer.append("Creditcard,");
        buffer.append("Settlesum,");
        buffer.append("Opcode,");
        buffer.append("Optime,");
        buffer.append("Remark,");
        buffer.append("Validity,");
        buffer.append("Settledate,");
        buffer.append("Nodetype,");
        buffer.append("Indexofsettle,");
        buffer.append("Phone,");
        buffer.append("Bank ");
        buffer.append("FROM Medicalsettlelist WHERE ");
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
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        int count=0;
        if(supportPaging==false && pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        //定义返回结果集合
        Collection collection = new ArrayList(rowsPerPage);
        MedicalsettlelistDto MedicalsettlelistDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            MedicalsettlelistDto = new MedicalsettlelistDto();
            MedicalsettlelistDto.setSettlelistcode(dbManager.getString(resultSet,"Settlelistcode"));
            MedicalsettlelistDto.setClasscode(dbManager.getString(resultSet,"Classcode"));
            MedicalsettlelistDto.setRiskcode(dbManager.getString(resultSet,"Riskcode"));
            MedicalsettlelistDto.setSuminsured(dbManager.getDouble(resultSet,"Suminsured"));
            MedicalsettlelistDto.setMedicalcard(dbManager.getString(resultSet,"Medicalcard"));
			MedicalsettlelistDto.setMedicalfamily(dbManager.getString(resultSet,"Medicalfamily"));
            MedicalsettlelistDto.setName(dbManager.getString(resultSet,"Name"));
            MedicalsettlelistDto.setIdcard(dbManager.getString(resultSet,"Idcard"));
            MedicalsettlelistDto.setInusrelistcode(dbManager.getString(resultSet,"Inusrelistcode"));
            MedicalsettlelistDto.setCreditcard(dbManager.getString(resultSet,"Creditcard"));
            MedicalsettlelistDto.setSettlesum(dbManager.getDouble(resultSet,"Settlesum"));
            MedicalsettlelistDto.setOpcode(dbManager.getString(resultSet,"Opcode"));
            MedicalsettlelistDto.setOptime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"Optime"));
            MedicalsettlelistDto.setRemark(dbManager.getString(resultSet,"Remark"));
            MedicalsettlelistDto.setValidity(dbManager.getString(resultSet,"Validity"));
            MedicalsettlelistDto.setSettledate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Settledate"));
            MedicalsettlelistDto.setNodetype(dbManager.getString(resultSet,"Nodetype"));
            MedicalsettlelistDto.setIndexofsettle(dbManager.getInt(resultSet,"Indexofsettle"));
            MedicalsettlelistDto.setPhone(dbManager.getString(resultSet,"Phone"));
            MedicalsettlelistDto.setBank(dbManager.getString(resultSet,"Bank"));
            collection.add(MedicalsettlelistDto);
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
        buffer.append("DELETE FROM Medicalsettlelist WHERE ");
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
        buffer.append("SELECT count(*) FROM Medicalsettlelist WHERE ");
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
     * 查询不同损失率的记录数
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getDistinctLossRateCount(String conditions) 
        throws Exception{
        int count = -1;
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("SELECT count(distinct(Lossrate)) FROM Medicalsettlelist WHERE ");
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
     * 统计户次
     * @param conditions conditions
     * @return  统计户次
     * @throws Exception
     */
    public double getDamageInsured(String conditions) 
        throws Exception{
        double count = 0.00;
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("SELECT count(distinct(Idcard)) FROM Medicalsettlelist WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        resultSet.next();
        count = dbManager.getDouble(resultSet,1);
        resultSet.close();
        return count;
    }
     /**
     * 查询满足模糊查询条件的记录数
     * @param conditions conditions
     * @param fieldName 字段名
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public BigDecimal getSum(String conditions, String fieldName)
        throws Exception{
    	BigDecimal sum =new BigDecimal(0);
    	if(null!=fieldName && !"".equals(fieldName)){
	        StringBuffer buffer = new StringBuffer(100);
	        buffer.append("SELECT sum("+fieldName+") FROM Medicalsettlelist WHERE ");
	        buffer.append(conditions);
	        if(logger.isDebugEnabled()){
	            logger.debug(buffer.toString());
	        }
	        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
	        while(resultSet.next()){
	        	sum = resultSet.getBigDecimal(1);

	        	continue;
	        }
	        resultSet.close();
    	}
        return sum;
    }
    /**
     * 查询满足模糊查询条件的记录数
     * @param conditions conditions
     * @param fieldName 字段名
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getMaxIndex(String conditions)
        throws Exception{
    	int max = 0;
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("SELECT max(INDEXOFSETTLE) FROM Medicalsettlelist WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        while(resultSet.next()){
	        max = dbManager.getInt(resultSet,1);
	        continue;
        }
        resultSet.close();
        return max;
    }
    
    /**
     * 将数据从临时表 MedicalSETTLELISTTEMP 存入正式表 MedicalSETTLELIST
     * @param settleListCode 正式表中的理赔清单号
     * @param indexOfSettle 正式表中的序号
     * @param whereCondition 临时表查询条件，决定将那些数据插入正式表。
     * @throws Exception
     */
    public void evaluate(String settleListCode, int indexOfSettle, String whereCondition) throws Exception{
    	StringBuffer stringBuffer = new StringBuffer();
    	stringBuffer.append("insert into MedicalSETTLELIST "+
    					"(SETTLELISTCODE,INDEXOFSETTLE,  CLASSCODE, RISKCODE,  "+ 
    					"SUMINSURED, MEDICALCARD,MEDICALFAMILY, NAME, IDCARD,  INUSRELISTCODE, CREDITCARD, "+ 
    					"SETTLESUM, OPCODE, OPTIME, REMARK, VALIDITY, SETTLEDATE, "+ 
    					" NODETYPE, PHONE, BANK )");
    	stringBuffer.append("select '"+ settleListCode +"', '"+indexOfSettle+"',CLASSCODE, RISKCODE, "+ 
    			  		"SUMINSURED, MEDICALCARD,MEDICALFAMILY, NAME, IDCARD, INUSRELISTCODE, CREDITCARD, "+
    			  		" SETTLESUM, OPCODE, OPTIME, REMARK, VALIDITY, SETTLEDATE, "+ 
    			  		" NODETYPE, PHONE, BANK "+ 
    			  		"from MedicalSETTLELISTTEMP where ");
    	stringBuffer.append(whereCondition);
    	if(logger.isDebugEnabled()){
            logger.debug(stringBuffer.toString());
        }
    	dbManager.prepareStatement(stringBuffer.toString());
    	dbManager.executePreparedUpdate();
    }
}
