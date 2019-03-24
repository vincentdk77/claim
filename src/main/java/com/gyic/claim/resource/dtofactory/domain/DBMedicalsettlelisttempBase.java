package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.MedicalsettlelisttempDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是MedicalSETTLELISTTEMP的数据访问对象基类<br>
 */
public class DBMedicalsettlelisttempBase {
	/**
	 * 资源管理类的实例，处理数据库操作.
	 */
	protected DBManager dbManager = null;
	private static Logger logger = Logger
			.getLogger(DBMedicalsettlelisttempBase.class);

	/**
	 * 构造函数
	 * 
	 * @param dbManager
	 *            资源管理类
	 */
	public DBMedicalsettlelisttempBase(DBManager dbManager) {
		this.dbManager = dbManager;
	}

	/**
	 * 插入一条数据
	 * 
	 * @param MedicalsettlelisttempDto
	 *            MedicalsettlelisttempDto
	 * @throws Exception
	 */
	public void insert(MedicalsettlelisttempDto MedicalsettlelisttempDto)
			throws Exception {
		StringBuffer buffer = new StringBuffer(200);
		buffer.append("INSERT INTO Medicalsettlelisttemp (");
		buffer.append("Registcode,");
		buffer.append("Stringtimestamp, ");
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
		if (logger.isDebugEnabled()) {
			StringBuffer debugBuffer = new StringBuffer(buffer.length() * 4);
			debugBuffer.append(buffer.toString());
			debugBuffer.append("VALUES(");
			debugBuffer.append("'").append(
					MedicalsettlelisttempDto.getRegistcode()).append("',");
			debugBuffer.append("'").append(
					MedicalsettlelisttempDto.getStringtimestamp()).append("',");
			debugBuffer.append("'").append(
					MedicalsettlelisttempDto.getClasscode()).append("',");
			debugBuffer.append("'").append(
					MedicalsettlelisttempDto.getRiskcode()).append("',");
			debugBuffer.append("").append(
					MedicalsettlelisttempDto.getSuminsured()).append(",");
			debugBuffer.append("'").append(
					MedicalsettlelisttempDto.getMedicalcard()).append("',");
			debugBuffer.append("'").append(
					MedicalsettlelisttempDto.getMedicalfamily()).append("',");
			debugBuffer.append("'").append(MedicalsettlelisttempDto.getName())
					.append("',");
			debugBuffer.append("'")
					.append(MedicalsettlelisttempDto.getIdcard()).append("',");
			debugBuffer.append("'").append(
					MedicalsettlelisttempDto.getInusrelistcode()).append("',");
			debugBuffer.append("'").append(
					MedicalsettlelisttempDto.getCreditcard()).append("',");
			debugBuffer.append("").append(
					MedicalsettlelisttempDto.getSettlesum()).append(",");
			debugBuffer.append("'")
					.append(MedicalsettlelisttempDto.getOpcode()).append("',");
			debugBuffer.append("'")
					.append(MedicalsettlelisttempDto.getOptime()).append("',");
			debugBuffer.append("'")
					.append(MedicalsettlelisttempDto.getRemark()).append("',");
			debugBuffer.append("'").append(
					MedicalsettlelisttempDto.getValidity()).append("',");
			debugBuffer.append("'").append(
					MedicalsettlelisttempDto.getSettledate()).append("',");
			debugBuffer.append("'").append(
					MedicalsettlelisttempDto.getNodetype()).append("',");
			debugBuffer.append("").append(
					MedicalsettlelisttempDto.getIndexofsettle()).append(",");
			debugBuffer.append("'").append(MedicalsettlelisttempDto.getPhone())
					.append("',");
			debugBuffer.append("'").append(MedicalsettlelisttempDto.getBank())
					.append("')");

			logger.debug(debugBuffer.toString());
		}

		buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		dbManager.prepareStatement(buffer.toString());
		dbManager.setString(1, MedicalsettlelisttempDto.getRegistcode());
		dbManager.setString(2, MedicalsettlelisttempDto.getStringtimestamp());
		dbManager.setString(3, MedicalsettlelisttempDto.getClasscode());
		dbManager.setString(4, MedicalsettlelisttempDto.getRiskcode());
		dbManager.setDouble(5, MedicalsettlelisttempDto.getSuminsured());
		dbManager.setString(6, MedicalsettlelisttempDto.getMedicalcard());
		dbManager.setString(7, MedicalsettlelisttempDto.getMedicalfamily());
		dbManager.setString(8, MedicalsettlelisttempDto.getName());
		dbManager.setString(9, MedicalsettlelisttempDto.getIdcard());
		dbManager.setString(10, MedicalsettlelisttempDto.getInusrelistcode());
		dbManager.setString(11, MedicalsettlelisttempDto.getCreditcard());
		dbManager.setDouble(12, MedicalsettlelisttempDto.getSettlesum());
		dbManager.setString(13, MedicalsettlelisttempDto.getOpcode());
		dbManager.setDateTime(14, MedicalsettlelisttempDto.getOptime());
		dbManager.setString(15, MedicalsettlelisttempDto.getRemark());
		dbManager.setString(16, MedicalsettlelisttempDto.getValidity());
		dbManager.setDateTime(17, MedicalsettlelisttempDto.getSettledate());
		dbManager.setString(18, MedicalsettlelisttempDto.getNodetype());
		dbManager.setInt(19, MedicalsettlelisttempDto.getIndexofsettle());
		dbManager.setString(20, MedicalsettlelisttempDto.getPhone());
		dbManager.setString(21, MedicalsettlelisttempDto.getBank());

		dbManager.executePreparedUpdate();

	}

	/**
	 * 采用批方式插入多条数据
	 * 
	 * @param collection
	 *            collection
	 * @throws Exception
	 */
	public void insertAll(Collection collection) throws Exception {
		StringBuffer buffer = new StringBuffer(200);
		buffer.append("INSERT INTO Medicalsettlelisttemp (");
		buffer.append("Registcode,");
		buffer.append("Stringtimestamp, ");
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
		buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		if (logger.isDebugEnabled()) {
			logger.debug(buffer.toString());
		}
		dbManager.prepareStatement(buffer.toString());
		for (Iterator i = collection.iterator(); i.hasNext();) {
			MedicalsettlelisttempDto MedicalsettlelisttempDto = (MedicalsettlelisttempDto) i
					.next();
			dbManager.setString(1, MedicalsettlelisttempDto.getRegistcode());
			dbManager.setString(2, MedicalsettlelisttempDto
					.getStringtimestamp());
			dbManager.setString(3, MedicalsettlelisttempDto.getClasscode());
			dbManager.setString(4, MedicalsettlelisttempDto.getRiskcode());
			dbManager.setDouble(5, MedicalsettlelisttempDto.getSuminsured());
			dbManager.setString(6, MedicalsettlelisttempDto.getMedicalcard());
			dbManager.setString(7, MedicalsettlelisttempDto.getMedicalfamily());
			dbManager.setString(8, MedicalsettlelisttempDto.getName());
			dbManager.setString(9, MedicalsettlelisttempDto.getIdcard());
			dbManager.setString(10, MedicalsettlelisttempDto
					.getInusrelistcode());
			dbManager.setString(11, MedicalsettlelisttempDto.getCreditcard());
			dbManager.setDouble(12, MedicalsettlelisttempDto.getSettlesum());
			dbManager.setString(13, MedicalsettlelisttempDto.getOpcode());
			dbManager.setDateTime(14, MedicalsettlelisttempDto.getOptime());
			dbManager.setString(15, MedicalsettlelisttempDto.getRemark());
			dbManager.setString(16, MedicalsettlelisttempDto.getValidity());
			dbManager.setDateTime(17, MedicalsettlelisttempDto.getSettledate());
			dbManager.setString(18, MedicalsettlelisttempDto.getNodetype());
			dbManager.setInt(19, MedicalsettlelisttempDto.getIndexofsettle());
			dbManager.setString(20, MedicalsettlelisttempDto.getPhone());
			dbManager.setString(21, MedicalsettlelisttempDto.getBank());

			dbManager.addBatch();
		}
		dbManager.executePreparedUpdateBatch();
	}

	/**
	 * 按主键删除一条数据
	 * 
	 * @param registcode
	 *            REGISTCODE
	 * @param indexofsettle
	 *            INDEXOFSETTLE
	 * @param stringtimestamp
	 *            STRINGTIMESTAMP
	 * @throws Exception
	 */
	public void delete(String registcode, int indexofsettle,
			String stringtimestamp) throws Exception {
		StringBuffer buffer = new StringBuffer(100);
		buffer.append("DELETE FROM Medicalsettlelisttemp ");
		if (logger.isDebugEnabled()) {
			StringBuffer debugBuffer = new StringBuffer(buffer.length() * 4);
			debugBuffer.append(buffer.toString());
			debugBuffer.append("WHERE ");
			debugBuffer.append("Registcode=").append("'").append(registcode)
					.append("' AND ");
			debugBuffer.append("Indexofsettle=").append("").append(
					indexofsettle).append(" AND ");
			debugBuffer.append("Stringtimestamp=").append("'").append(
					stringtimestamp).append("'");
			logger.debug(debugBuffer.toString());
		}

		buffer.append("WHERE ");
		buffer.append("Registcode = ? And ");
		buffer.append("Indexofsettle = ? And ");
		buffer.append("Stringtimestamp = ?");

		dbManager.prepareStatement(buffer.toString());
		// 设置条件字段;
		dbManager.setString(1, registcode);
		dbManager.setInt(2, indexofsettle);
		dbManager.setString(3, stringtimestamp);
		dbManager.executePreparedUpdate();
	}

	/**
	 * 按主键更新一条数据(主键本身无法变更)
	 * 
	 * @param MedicalsettlelisttempDto
	 *            MedicalsettlelisttempDto
	 * @throws Exception
	 */
	public void update(MedicalsettlelisttempDto MedicalsettlelisttempDto)
			throws Exception {
		StringBuffer buffer = new StringBuffer(200);
		buffer.append("UPDATE Medicalsettlelisttemp SET ");
		// buffer.append("Registcode,");
		// buffer.append("Stringtimestamp, ");
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
		// buffer.append("Indexofsettle,");
		buffer.append("Phone,");
		buffer.append("Bank ");

		if (logger.isDebugEnabled()) {
			StringBuffer debugBuffer = new StringBuffer(buffer.length() * 4);
			debugBuffer.append("UPDATE Medicalsettlelisttemp SET ");
			debugBuffer.append("Classcode = '"
					+ MedicalsettlelisttempDto.getClasscode() + "', ");
			debugBuffer.append("Riskcode = '"
					+ MedicalsettlelisttempDto.getRiskcode() + "', ");
			debugBuffer.append("Suminsured = "
					+ MedicalsettlelisttempDto.getSuminsured() + ", ");
			debugBuffer.append("Medicalcard = '"
					+ MedicalsettlelisttempDto.getMedicalcard() + "', ");
			debugBuffer.append("Medicalfamily = '"
					+ MedicalsettlelisttempDto.getMedicalfamily() + "', ");
			debugBuffer.append("Name = '" + MedicalsettlelisttempDto.getName()
					+ "', ");
			debugBuffer.append("Idcard = '"
					+ MedicalsettlelisttempDto.getIdcard() + "', ");
			debugBuffer.append("Inusrelistcode = '"
					+ MedicalsettlelisttempDto.getInusrelistcode() + "', ");
			debugBuffer.append("Creditcard = "
					+ MedicalsettlelisttempDto.getCreditcard() + ", ");
			debugBuffer.append("Settlesum = "
					+ MedicalsettlelisttempDto.getSettlesum() + ", ");
			debugBuffer.append("Opcode = '"
					+ MedicalsettlelisttempDto.getOpcode() + "', ");
			debugBuffer.append("Optime = '"
					+ MedicalsettlelisttempDto.getOptime() + "', ");
			debugBuffer.append("Remark = '"
					+ MedicalsettlelisttempDto.getRemark() + "', ");
			debugBuffer.append("Validity = '"
					+ MedicalsettlelisttempDto.getValidity() + "', ");
			debugBuffer.append("Settledate = '"
					+ MedicalsettlelisttempDto.getSettledate() + "', ");
			debugBuffer.append("Nodetype = '"
					+ MedicalsettlelisttempDto.getNodetype() + "', ");
			debugBuffer.append("Phone = '"
					+ MedicalsettlelisttempDto.getPhone() + "', ");
			debugBuffer.append("Bank = '" + MedicalsettlelisttempDto.getBank()
					+ "' ");

			debugBuffer.append("WHERE ");
			debugBuffer.append("Registcode=").append("'").append(
					MedicalsettlelisttempDto.getRegistcode()).append("' AND ");
			debugBuffer.append("Indexofsettle=").append("").append(
					MedicalsettlelisttempDto.getIndexofsettle())
					.append(" AND ");
			debugBuffer.append("Stringtimestamp=").append("'").append(
					MedicalsettlelisttempDto.getStringtimestamp()).append("'");
			logger.debug(debugBuffer.toString());
		}

		buffer.append("WHERE ");
		buffer.append("Registcode = ? And ");
		buffer.append("Indexofsettle = ? And ");
		buffer.append("Stringtimestamp = ?");

		dbManager.prepareStatement(buffer.toString());
		// 设置更新字段;

		dbManager.setString(1, MedicalsettlelisttempDto.getClasscode());
		dbManager.setString(2, MedicalsettlelisttempDto.getRiskcode());
		dbManager.setDouble(3, MedicalsettlelisttempDto.getSuminsured());
		dbManager.setString(4, MedicalsettlelisttempDto.getMedicalcard());
		dbManager.setString(5, MedicalsettlelisttempDto.getMedicalfamily());
		dbManager.setString(6, MedicalsettlelisttempDto.getName());
		dbManager.setString(7, MedicalsettlelisttempDto.getIdcard());
		dbManager.setString(8, MedicalsettlelisttempDto.getInusrelistcode());
		dbManager.setString(9, MedicalsettlelisttempDto.getCreditcard());
		dbManager.setDouble(10, MedicalsettlelisttempDto.getSettlesum());
		dbManager.setString(11, MedicalsettlelisttempDto.getOpcode());
		dbManager.setDateTime(12, MedicalsettlelisttempDto.getOptime());
		dbManager.setString(13, MedicalsettlelisttempDto.getRemark());
		dbManager.setString(14, MedicalsettlelisttempDto.getValidity());
		dbManager.setDateTime(15, MedicalsettlelisttempDto.getSettledate());
		dbManager.setString(16, MedicalsettlelisttempDto.getNodetype());
		dbManager.setString(17, MedicalsettlelisttempDto.getPhone());
		dbManager.setString(18, MedicalsettlelisttempDto.getBank());

		// 设置条件字段;
		dbManager.setString(19, MedicalsettlelisttempDto.getRegistcode());
		dbManager.setInt(20, MedicalsettlelisttempDto.getIndexofsettle());
		dbManager.setString(21, MedicalsettlelisttempDto.getStringtimestamp());
		dbManager.executePreparedUpdate();

	}

	/**
	 * 按主键查找一条数据
	 * 
	 * @param registcode
	 *            REGISTCODE
	 * @param indexofsettle
	 *            INDEXOFSETTLE
	 * @param stringtimestamp
	 *            STRINGTIMESTAMP
	 * @return MedicalsettlelisttempDto
	 * @throws Exception
	 */
	public MedicalsettlelisttempDto findByPrimaryKey(String registcode,
			int indexofsettle, String stringtimestamp) throws Exception {
		StringBuffer buffer = new StringBuffer(200);
		// 拼SQL语句
		buffer.append("SELECT ");
		buffer.append("Registcode,");
		buffer.append("Stringtimestamp, ");
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

		buffer.append("FROM Medicalsettlelisttemp ");
		if (logger.isDebugEnabled()) {
			StringBuffer debugBuffer = new StringBuffer(buffer.length() * 4);
			debugBuffer.append(buffer.toString());
			debugBuffer.append("WHERE ");
			debugBuffer.append("Registcode=").append("'").append(registcode)
					.append("' AND ");
			debugBuffer.append("Indexofsettle=").append("").append(
					indexofsettle).append(" AND ");
			debugBuffer.append("Stringtimestamp=").append("'").append(
					stringtimestamp).append("'");
			logger.debug(debugBuffer.toString());
		}

		buffer.append("WHERE ");
		buffer.append("Registcode = ? And ");
		buffer.append("Indexofsettle = ? And ");
		buffer.append("Stringtimestamp = ?");

		dbManager.prepareStatement(buffer.toString());
		// 设置条件字段;
		dbManager.setString(1, registcode);
		dbManager.setInt(2, indexofsettle);
		dbManager.setString(3, stringtimestamp);
		ResultSet resultSet = dbManager.executePreparedQuery();
		MedicalsettlelisttempDto MedicalsettlelisttempDto = null;
		if (resultSet.next()) {
			MedicalsettlelisttempDto = new MedicalsettlelisttempDto();
			MedicalsettlelisttempDto.setRegistcode(dbManager.getString(
					resultSet, 1));
			MedicalsettlelisttempDto.setStringtimestamp(dbManager.getString(
					resultSet, 2));
			MedicalsettlelisttempDto.setClasscode(dbManager.getString(
					resultSet, 3));
			MedicalsettlelisttempDto.setRiskcode(dbManager.getString(resultSet,
					4));
			MedicalsettlelisttempDto.setSuminsured(dbManager.getDouble(
					resultSet, 5));
			MedicalsettlelisttempDto.setMedicalcard(dbManager.getString(
					resultSet, 6));
			MedicalsettlelisttempDto.setMedicalfamily(dbManager.getString(
					resultSet, 7));
			MedicalsettlelisttempDto.setName(dbManager.getString(resultSet, 8));
			MedicalsettlelisttempDto.setIdcard(dbManager
					.getString(resultSet, 9));
			MedicalsettlelisttempDto.setInusrelistcode(dbManager.getString(
					resultSet, 10));
			MedicalsettlelisttempDto.setCreditcard(dbManager.getString(
					resultSet, 11));
			MedicalsettlelisttempDto.setSettlesum(dbManager.getDouble(
					resultSet, 12));
			MedicalsettlelisttempDto.setOpcode(dbManager.getString(resultSet,
					13));
			MedicalsettlelisttempDto.setOptime(dbManager.getDateTime(resultSet,
					DateTime.YEAR_TO_SECOND, 14));
			MedicalsettlelisttempDto.setRemark(dbManager.getString(resultSet,
					15));
			MedicalsettlelisttempDto.setValidity(dbManager.getString(resultSet,
					16));
			MedicalsettlelisttempDto.setSettledate(dbManager.getDateTime(
					resultSet, DateTime.YEAR_TO_DAY, 17));
			MedicalsettlelisttempDto.setNodetype(dbManager.getString(resultSet,
					18));
			MedicalsettlelisttempDto.setIndexofsettle(dbManager.getInt(
					resultSet, 19));
			MedicalsettlelisttempDto.setPhone(dbManager
					.getString(resultSet, 20));
			MedicalsettlelisttempDto
					.setBank(dbManager.getString(resultSet, 21));

		}
		resultSet.close();
		return MedicalsettlelisttempDto;
	}

	/**
	 * 按条件查询多条数据
	 * 
	 * @param conditions
	 *            查询条件
	 * @param pageNo
	 *            页号
	 * @param rowsPerPage
	 *            每页的行数
	 * @return Collection
	 * @throws Exception
	 */
	public Collection findByConditions(String conditions, int pageNo,
			int rowsPerPage) throws Exception {
		StringBuffer buffer = new StringBuffer(200);
		// 拼SQL语句
		buffer.append("SELECT ");
		buffer.append("Registcode,");
		buffer.append("Stringtimestamp, ");
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

		buffer.append("FROM Medicalsettlelisttemp WHERE ");
		buffer.append(conditions);
		boolean supportPaging = false;// 数据库是否支持分页
		if (pageNo > 0) {
			// 对Oracle优化
			if (dbManager.getConnection().getMetaData()
					.getDatabaseProductName().equalsIgnoreCase("Oracle")) {
				buffer.insert(0,
						"SELECT * FROM ( SELECT row_.*, rownum rownum_ FROM (");
				buffer.append(") row_ WHERE rownum <= " + rowsPerPage * pageNo
						+ ") WHERE rownum_ > " + rowsPerPage * (pageNo - 1));
				supportPaging = true;
			} else if (dbManager.getConnection().getMetaData()
					.getDatabaseProductName().equalsIgnoreCase("DB2")) {
				String sql = buffer.toString();
				buffer.setLength(0);
				buffer.append("select * from ( select rownumber() over(");
				int orderByIndex = sql.toLowerCase().indexOf("order by");
				if (orderByIndex > 0) {
					buffer.append(sql.substring(orderByIndex));
				}
				buffer.append(") as rownumber_,");
				buffer.append(sql.substring(6));
				buffer.append(" ) as temp_ where rownumber_");
				buffer.append(" between " + (rowsPerPage * (pageNo - 1) + 1)
						+ " and " + rowsPerPage * pageNo);
				supportPaging = true;
			}
		}
		if (logger.isDebugEnabled()) {
			logger.debug(buffer.toString());
		}
		ResultSet resultSet = dbManager.executeQuery(buffer.toString());
		int count = 0;
		if (supportPaging == false && pageNo > 1) {
			dbManager.locate(resultSet, rowsPerPage * (pageNo - 1));
		}

		// 定义返回结果集合
		Collection collection = new ArrayList(rowsPerPage);
		MedicalsettlelisttempDto MedicalsettlelisttempDto = null;
		while (resultSet.next()) {
			if (supportPaging == false && pageNo > 0) {
				count++;
				if (count > rowsPerPage) {
					break;
				}
			}

			MedicalsettlelisttempDto = new MedicalsettlelisttempDto();
			MedicalsettlelisttempDto.setRegistcode(dbManager.getString(
					resultSet, "Registcode"));
			MedicalsettlelisttempDto.setStringtimestamp(dbManager.getString(
					resultSet, "Stringtimestamp"));
			MedicalsettlelisttempDto.setClasscode(dbManager.getString(
					resultSet, "Classcode"));
			MedicalsettlelisttempDto.setRiskcode(dbManager.getString(resultSet,
					"Riskcode"));
			MedicalsettlelisttempDto.setSuminsured(dbManager.getDouble(
					resultSet, "Suminsured"));
			MedicalsettlelisttempDto.setMedicalcard(dbManager.getString(
					resultSet, "Medicalcard"));
			MedicalsettlelisttempDto.setMedicalfamily(dbManager.getString(
					resultSet, "Medicalfamily"));
			MedicalsettlelisttempDto.setName(dbManager.getString(resultSet,
					"Name"));
			MedicalsettlelisttempDto.setIdcard(dbManager.getString(resultSet,
					"Idcard"));
			MedicalsettlelisttempDto.setInusrelistcode(dbManager.getString(
					resultSet, "Inusrelistcode"));
			MedicalsettlelisttempDto.setCreditcard(dbManager.getString(
					resultSet, "Creditcard"));
			MedicalsettlelisttempDto.setSettlesum(dbManager.getDouble(
					resultSet, "Settlesum"));
			MedicalsettlelisttempDto.setOpcode(dbManager.getString(resultSet,
					"Opcode"));
			MedicalsettlelisttempDto.setOptime(dbManager.getDateTime(resultSet,
					DateTime.YEAR_TO_SECOND, "Optime"));
			MedicalsettlelisttempDto.setRemark(dbManager.getString(resultSet,
					"Remark"));
			MedicalsettlelisttempDto.setValidity(dbManager.getString(resultSet,
					"Validity"));
			MedicalsettlelisttempDto.setSettledate(dbManager.getDateTime(
					resultSet, DateTime.YEAR_TO_DAY, "Settledate"));
			MedicalsettlelisttempDto.setNodetype(dbManager.getString(resultSet,
					"Nodetype"));
			MedicalsettlelisttempDto.setIndexofsettle(dbManager.getInt(
					resultSet, "Indexofsettle"));
			MedicalsettlelisttempDto.setPhone(dbManager.getString(resultSet,
					"Phone"));
			MedicalsettlelisttempDto.setBank(dbManager.getString(resultSet,
					"Bank"));
			collection.add(MedicalsettlelisttempDto);
		}
		resultSet.close();
		return collection;
	}

	/**
	 * 按条件查询多条数据
	 * 
	 * @param conditions
	 *            查询条件
	 * @return Collection
	 * @throws Exception
	 */
	public Collection findByConditions(String conditions) throws Exception {
		return findByConditions(conditions, 0, 0);
	}

	/**
	 * 按条件删除数据
	 * 
	 * @param conditions
	 *            查询条件
	 * @return 删除的行数
	 * @throws Exception
	 */
	public int deleteByConditions(String conditions) throws Exception {
		StringBuffer buffer = new StringBuffer(100);
		buffer.append("DELETE FROM Medicalsettlelisttemp WHERE ");
		buffer.append(conditions);
		if (logger.isDebugEnabled()) {
			logger.debug(buffer.toString());
		}
		int count = dbManager.executeUpdate(buffer.toString());
		return count;
	}

	/**
	 * 查询满足模糊查询条件的记录数
	 * 
	 * @param conditions
	 *            conditions
	 * @return 满足模糊查询条件的记录数
	 * @throws Exception
	 */
	public int getCount(String conditions) throws Exception {
		int count = -1;
		StringBuffer buffer = new StringBuffer(100);
		buffer.append("SELECT count(*) FROM Medicalsettlelisttemp WHERE ");
		buffer.append(conditions);
		if (logger.isDebugEnabled()) {
			logger.debug(buffer.toString());
		}
		ResultSet resultSet = dbManager.executeQuery(buffer.toString());
		resultSet.next();
		count = dbManager.getInt(resultSet, 1);
		resultSet.close();
		return count;
	}

	/**
	 * 查询满足模糊查询条件的记录数
	 * 
	 * @param conditions
	 *            conditions
	 * @param fieldName
	 *            字段名
	 * @return 满足模糊查询条件的记录数
	 * @throws Exception
	 */
	public double getSum(String conditions, String fieldName) throws Exception {
		double sum = 0;
		if (null != fieldName && !"".equals(fieldName)) {
			StringBuffer buffer = new StringBuffer(100);
			buffer.append("SELECT sum(" + fieldName
					+ ") FROM Medicalsettlelisttemp WHERE ");
			buffer.append(conditions);
			if (logger.isDebugEnabled()) {
				logger.debug(buffer.toString());
			}
			ResultSet resultSet = dbManager.executeQuery(buffer.toString());
			while (resultSet.next()) {
				sum = dbManager.getDouble(resultSet, 1);
				continue;
			}
			resultSet.close();
		}
		return sum;
	}
}
