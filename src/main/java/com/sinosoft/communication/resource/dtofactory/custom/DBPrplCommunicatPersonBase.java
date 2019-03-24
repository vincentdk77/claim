package com.sinosoft.communication.resource.dtofactory.custom;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.communication.dto.custom.PrplCommunicatPersonDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是DBPrplCommunicatPersonBase-沟通人员的数据访问对象基类<br>
 * 创建于 2013-02-19
 * 
 */
public class DBPrplCommunicatPersonBase {
	private DBManager dbManager = null; //资源管理类
	private static Log log = LogFactory.getLog(DBPrplCommunicatPersonBase.class
			.getName());

	/**
	 * 构造函数
	 * @param dbManager 资源管理类
	 */
	public DBPrplCommunicatPersonBase(DBManager dbManager) {
		this.dbManager = dbManager;
	}

	/**
	 * 插入一条数据
	 * @param prplCommunicationDto prplCommunicationDto
	 * @throws Exception
	 */
	public void insert(PrplCommunicatPersonDto prplCommunicatPersonDto)
			throws Exception {
		String mainStatement = "Insert Into prplcommunicatperson ("
								+ " communicationNo," 
								+ "personno," 
								+ "comcode," 
								+ "usercode,"
								+ "username," 
								+ "createTime," 
								+ "validata," 
								+ "communicationFlag )";
		String statement = mainStatement + " values (?,?,?,?,?,?,?,?)";
		if (log.isDebugEnabled()) {
			String debugStatement = mainStatement + " values(" + ""
					+ prplCommunicatPersonDto.getCommunicationNo() + "," + "'"
					+ prplCommunicatPersonDto.getPersonNo() + "'," + ""
					+ prplCommunicatPersonDto.getComCode() + "," + "'"
					+ prplCommunicatPersonDto.getUserCode() + "'," + "'"
					+ prplCommunicatPersonDto.getUserName() + "'," + "'"
					+ prplCommunicatPersonDto.getCreateTime() + "'," + "'"
					+ prplCommunicatPersonDto.getValidata() + "'," + "'"
					+ prplCommunicatPersonDto.getCommunicationFlag() + "')";
			log.debug(debugStatement);
		}
		dbManager.prepareStatement(statement);
		dbManager.setString(1, prplCommunicatPersonDto.getCommunicationNo());
		dbManager.setString(2, prplCommunicatPersonDto.getPersonNo());
		dbManager.setString(3, prplCommunicatPersonDto.getComCode());
		dbManager.setString(4, prplCommunicatPersonDto.getUserCode());
		dbManager.setString(5, prplCommunicatPersonDto.getUserName());
		dbManager.setDateTime(6, prplCommunicatPersonDto.getCreateTime());
		dbManager.setString(7, prplCommunicatPersonDto.getValidata());
		dbManager.setString(8, prplCommunicatPersonDto.getCommunicationFlag());
		dbManager.executePreparedUpdate();
		log.info("DBPrplCommunicatPersonBase.insert() success!");
	}

	/**
	 * 采用批方式插入多条数据
	 * @param collection collection
	 * @throws Exception
	 */
	public void insertAll(Collection collection) throws Exception {
		String mainStatement = "Insert Into prplCommunicatPerson ("
								+ " communicationNo," 
								+ "personno," 
								+ "comcode," 
								+ "usercode,"
								+ "username," 
								+ "createTime,"
								+ "validata," 
								+ "communicationFlag )";
		String statement = mainStatement + " values (?,?,?,?,?,?,?,?)";
		log.debug(statement);
		dbManager.prepareStatement(statement);
		for (Iterator i = collection.iterator(); i.hasNext();) {
			PrplCommunicatPersonDto prplCommunicatPersonDto = (PrplCommunicatPersonDto) i.next();
			dbManager.setString(1, prplCommunicatPersonDto.getCommunicationNo());
			dbManager.setString(2, prplCommunicatPersonDto.getPersonNo());
			dbManager.setString(3, prplCommunicatPersonDto.getComCode());
			dbManager.setString(4, prplCommunicatPersonDto.getUserCode());
			dbManager.setString(5, prplCommunicatPersonDto.getUserName());
			dbManager.setDateTime(6, prplCommunicatPersonDto.getCreateTime());
			dbManager.setString(7, prplCommunicatPersonDto.getValidata());
			dbManager.setString(8, prplCommunicatPersonDto.getCommunicationFlag());
			dbManager.addBatch();
		}
		dbManager.executePreparedUpdateBatch();
		log.info("DBPrplCommunicatPersonBase.insertAll() success!");
	}
	
	/**
	 * 按条件删除一条数据
	 * @param CommunicationNo 沟通ID
	 * @throws Exception
	 */
	public void delete(String CommunicationNo) throws Exception {
		String statement = " Delete From prplCommunicatPerson" + " Where "
				+ " CommunicationNo = ? ";
		if (log.isDebugEnabled()) {
			String debugStatement = "Delete From prplCommunicatPerson Where CommunicationNo = "
					+ CommunicationNo;
			log.debug(debugStatement);
		}
		dbManager.prepareStatement(statement);
		//设置条件字段;
		dbManager.setString(1, CommunicationNo);
		dbManager.executePreparedUpdate();
		log.info("DBPrplCommunicatPersonBase.delete() success!");
	}

	/**
	 * 按主键删除一条数据
	 * @param CommunicationNo 沟通ID
	 * @param personNo 沟通人号码
	 * @throws Exception
	 */
	public void delete(String CommunicationNo,String personNo) throws Exception {
		String statement = " Delete From prplCommunicatPerson" + " Where "
				+ " CommunicationNo = ? and personno = ? ";
		if (log.isDebugEnabled()) {
			String debugStatement = "Delete From prplCommunicatPerson Where CommunicationNo = "
					+ CommunicationNo+" CommunicationNo = "+personNo;
			log.debug(debugStatement);
		}
		dbManager.prepareStatement(statement);
		//设置条件字段;
		dbManager.setString(1, CommunicationNo);
		dbManager.setString(2, personNo);
		dbManager.executePreparedUpdate();
		log.info("DBPrplCommunicatPersonBase.delete() success!");
	}

	/**
	 * 按主键更新一条数据(主键本身无法变更)
	 * @param prplCommunicatPersonDto 
	 * @throws Exception
	 */
	public void update(PrplCommunicatPersonDto prplCommunicatPersonDto)
			throws Exception {
		String statement = " Update prplCommunicatPerson Set "+ 
							" comcode=?,"+ 
							" usercode=?," + 
							" username=?," + 
							" createTime=?," + 
							" validata=?," + 
							" communicationFlag=?"+ 
							" where communicationNo = ? and personno = ?";
		if (log.isDebugEnabled()) {
			String debugStatement = " Update prplCommunicatPerson Set "
					+ " comcode="+ prplCommunicatPersonDto.getComCode()+ ","
					+ " usercode="+ prplCommunicatPersonDto.getUserCode()+ ","
					+ " username="+ prplCommunicatPersonDto.getUserName()+ ","
					+ " createTime="+ prplCommunicatPersonDto.getCreateTime()+ ","
					+ " validata="+ prplCommunicatPersonDto.getValidata()+ ","
					+ " communicationFlag="+ prplCommunicatPersonDto.getCommunicationFlag()+ ""
					+ " where communicationNo = "+ prplCommunicatPersonDto.getCommunicationNo()
					+ " and personno = " + prplCommunicatPersonDto.getPersonNo();
			log.debug(debugStatement);
		}
		dbManager.prepareStatement(statement);
		//设置更新字段;
		dbManager.setString(1, prplCommunicatPersonDto.getComCode());
		dbManager.setString(2, prplCommunicatPersonDto.getUserCode());
		dbManager.setString(3, prplCommunicatPersonDto.getUserName());
		dbManager.setDateTime(4, prplCommunicatPersonDto.getCreateTime());
		dbManager.setString(5, prplCommunicatPersonDto.getValidata());
		dbManager.setString(6, prplCommunicatPersonDto.getCommunicationFlag());
		dbManager.setString(7, prplCommunicatPersonDto.getCommunicationNo());
		dbManager.setString(8, prplCommunicatPersonDto.getPersonNo());
		dbManager.executePreparedUpdate();
		log.info("DBPrplCommunicatPersonBase.update() success!");
	}
	
	/**
	 * 按主键查找一条数据
	 * @param CommunicationNo 沟通ID
	 * @return collection
	 * @throws Exception
	 */
	public Collection findByCommunicationNo(String communicationNo)
			throws Exception {
		String mainStatement = " Select CommunicationNo,"
				+ " personno,"
				+ " comcode,"
				+ " usercode," 
				+ " username," 
				+ " createTime," 
				+ " validata," 
				+ " communicationFlag"
				+ " from prplCommunicatPerson";
		String statement = mainStatement + " Where CommunicationNo=? ";
		PrplCommunicatPersonDto prplCommunicatPersonDto = null;
		if (log.isDebugEnabled()) {
			String debugStatement = mainStatement
					+ " Where CommunicationNo = " + communicationNo ;
			log.debug(debugStatement);
		}
		dbManager.prepareStatement(statement);
		//设置条件字段;
		dbManager.setString(1, communicationNo);
		ResultSet resultSet = dbManager.executePreparedQuery();
		Collection collection = new ArrayList();
		while (resultSet.next()) {
			prplCommunicatPersonDto = new PrplCommunicatPersonDto();
			prplCommunicatPersonDto.setCommunicationNo(dbManager.getString(resultSet, 1));
			prplCommunicatPersonDto.setPersonNo(dbManager.getString(resultSet, 2));
			prplCommunicatPersonDto.setComCode(dbManager.getString(resultSet, 3));
			prplCommunicatPersonDto.setUserCode(dbManager.getString(resultSet,4));
			prplCommunicatPersonDto.setUserName(dbManager.getString(resultSet,5));
			//prplCommunicatPersonDto.setCreateTime(dbManager.getDateTime(resultSet, 6));
			prplCommunicatPersonDto.setCreateTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND, 6));
			prplCommunicatPersonDto.setValidata(dbManager.getString(resultSet,7));
			prplCommunicatPersonDto.setCommunicationFlag(dbManager.getString(resultSet,8));
			collection.add(prplCommunicatPersonDto);
		} 
		log.info("DBPrplCommunicatPersonBase.findByPrimaryKey() success!");
		resultSet.close();
		return collection;
	}

	/**
	 * 按主键查找一条数据
	 * @param CommunicationNo 沟通ID
	 * @param personNo 沟通人员序号
	 * @return PrplCommunicatPersonDto
	 * @throws Exception
	 */
	public PrplCommunicatPersonDto findByPrimaryKey(String communicationNo,String personNo)
			throws Exception {
		String mainStatement = " Select CommunicationNo,"
				+ " personno,"
				+ " comcode,"
				+ " usercode," 
				+ " username," 
				+ " createTime,"
				+ " validata,"
				+ " communicationFlag"
				+ " from prplCommunicatPerson";
		String statement = mainStatement + " Where CommunicationNo=? and personno = ?";
		PrplCommunicatPersonDto prplCommunicatPersonDto = null;
		if (log.isDebugEnabled()) {
			String debugStatement = mainStatement
					+ " Where CommunicationNo = " + communicationNo 
					+ " and personNo = " + personNo;
			log.debug(debugStatement);
		}
		dbManager.prepareStatement(statement);
		//设置条件字段;
		dbManager.setString(1, communicationNo);
		dbManager.setString(2, personNo);
		ResultSet resultSet = dbManager.executePreparedQuery();
		if (resultSet.next()) {
			prplCommunicatPersonDto = new PrplCommunicatPersonDto();
			prplCommunicatPersonDto.setCommunicationNo(dbManager.getString(resultSet, 1));
			prplCommunicatPersonDto.setPersonNo(dbManager.getString(resultSet, 2));
			prplCommunicatPersonDto.setComCode(dbManager.getString(resultSet, 3));
			prplCommunicatPersonDto.setUserCode(dbManager.getString(resultSet,4));
			prplCommunicatPersonDto.setUserName(dbManager.getString(resultSet,5));
			//prplCommunicatPersonDto.setCreateTime(dbManager.getDateTime(resultSet, 6));
			prplCommunicatPersonDto.setCreateTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND, 6));
			prplCommunicatPersonDto.setValidata(dbManager.getString(resultSet,7));
			prplCommunicatPersonDto.setCommunicationFlag(dbManager.getString(resultSet,8));
			log.info("DBPrplCommunicatPersonBase.findByPrimaryKey() success!");
		} else {
			log.info("DBPrplCommunicatPersonBase.findByPrimaryKey() failure!");
		}
		resultSet.close();
		return prplCommunicatPersonDto;
	}

	/**
	 * 按条件查询多条数据
	 * @param conditions 查询条件
	 * @param pageNo 页号
	 * @param rowsPerPage 每页的行数
	 * @return Collection
	 * @throws Exception
	 */
	public Collection findByConditions(String conditions, int pageNo,
			int rowsPerPage) throws Exception {
		String mainStatement = " Select CommunicationNo,"
								+ " personno," 
								+ " comcode,"
								+ " usercode," 
								+ " username," 
								+ " createTime," 
								+ " validata,"
								+ " communicationFlag"
								+ " from prplCommunicatPerson ";
		String statement = mainStatement + " Where " + conditions;
		log.debug(statement);
		Collection collection = new ArrayList();
		PrplCommunicatPersonDto prplCommunicatPersonDto = null;
		ResultSet resultSet = dbManager.executeQuery(statement);
		int count = 0;
		if (pageNo > 1) {
			dbManager.locate(resultSet, rowsPerPage * (pageNo - 1));
		}
		while (resultSet.next()) {
			count++;
			if (pageNo > 0) {
				if (count > rowsPerPage) {
					break;
				}
			}
			prplCommunicatPersonDto = new PrplCommunicatPersonDto();
			prplCommunicatPersonDto.setCommunicationNo(dbManager.getString(resultSet, 1));
			prplCommunicatPersonDto.setPersonNo(dbManager.getString(resultSet, 2));
			prplCommunicatPersonDto.setComCode(dbManager.getString(resultSet, 3));
			prplCommunicatPersonDto.setUserCode(dbManager.getString(resultSet,4));
			prplCommunicatPersonDto.setUserName(dbManager.getString(resultSet,5));
			//prplCommunicatPersonDto.setCreateTime(dbManager.getDateTime(resultSet, 6));
			prplCommunicatPersonDto.setCreateTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND, 6));
			prplCommunicatPersonDto.setValidata(dbManager.getString(resultSet,7));
			prplCommunicatPersonDto.setCommunicationFlag(dbManager.getString(resultSet,8));
			collection.add(prplCommunicatPersonDto);
		}
		resultSet.close();
		log.info("DBPrplCommunicatPersonBase.findByConditions() success!");
		return collection;
	}

	/**
	 * 按条件查询多条数据
	 * @param conditions 查询条件
	 * @return Collection
	 * @throws Exception
	 */
	public Collection findByConditions(String conditions) throws Exception {
		return findByConditions(conditions, 0, 0);
	}

	/**
	 * 查询满足模糊查询条件的记录数
	 * @param conditions conditions
	 * @return 满足模糊查询条件的记录数
	 * @throws Exception
	 */
	public int getCount(String conditions) throws Exception {
		int count = -1;
		String statement = "Select count(*) from prplCommunicatPerson Where "
				+ conditions;
		statement = SqlUtils.getWherePartForGetCount(statement);
		log.debug(statement);
		ResultSet resultSet = dbManager.executeQuery(statement);
		resultSet.next();
		count = dbManager.getInt(resultSet, 1);
		resultSet.close();
		log.info("DBPrplCommunicatPersonBase.getCount() success!");
		return count;
	}
}
