package com.sinosoft.communication.resource.dtofactory.custom;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.communication.dto.custom.PrplCommunicatOpinionDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����DBPrplCommunicatOpinionBase-��ͨ��������ݷ��ʶ������<br>
 * ������ 2013-02-19
 * 
 */
public class DBPrplCommunicatOpinionBase {
	private DBManager dbManager = null; //��Դ������
	private static Log log = LogFactory.getLog(DBPrplCommunicatOpinionBase.class
			.getName());

	/**
	 * ���캯��
	 * @param dbManager ��Դ������
	 */
	public DBPrplCommunicatOpinionBase(DBManager dbManager) {
		this.dbManager = dbManager;
	}

	/**
	 * ����һ������
	 * @param prplCommunicationDto prplCommunicationDto
	 * @throws Exception
	 */
	public void insert(PrplCommunicatOpinionDto prplCommunicatOpinionDto)
			throws Exception {
		String mainStatement = "Insert Into prplcommunicatOpinion ("
								+ " communicationNo," 
								+ " opinionno,"
								+ " personno," 
								+ " comcode,"
								+ " comcname,"
								+ " usercode,"
								+ " username," 
								+ " handleRole,"
								+ " handleTime," 
								+ " direction," 
								+ " aboveTime,"
								+ "handleOpinion)";
		String statement = mainStatement + " values (?,?,?,?,?,?,?,?,?,?,?,?)";
		if (log.isDebugEnabled()) {
			String debugStatement = mainStatement + " values(" 
					+ "'"+ prplCommunicatOpinionDto.getCommunicationNo() + "'," 
					+ "'"+ prplCommunicatOpinionDto.getOpinionNo() + "'," 
					+ "'"+ prplCommunicatOpinionDto.getPersonNo() + "'," 
					+ "'"+ prplCommunicatOpinionDto.getComCode() + "'," 
					+ "'"+ prplCommunicatOpinionDto.getComCName() + "'," 
					+ "'"+ prplCommunicatOpinionDto.getUserCode() + "',"
					+ "'"+ prplCommunicatOpinionDto.getUserName() + "'," 
					+ "'"+ prplCommunicatOpinionDto.getHandleRole() + "',"
					+ "'"+ prplCommunicatOpinionDto.getHandleTime() + "'," 
					+ "'"+ prplCommunicatOpinionDto.getDirection() + "'," 
					+ "'"+ prplCommunicatOpinionDto.getAboveTime() + "'," 
					+ "'"+ prplCommunicatOpinionDto.getHandleOpinion() + "')";
			log.debug(debugStatement);
		}
		dbManager.prepareStatement(statement);
		dbManager.setString(1, prplCommunicatOpinionDto.getCommunicationNo());
		dbManager.setString(2, prplCommunicatOpinionDto.getOpinionNo());
		dbManager.setString(3, prplCommunicatOpinionDto.getPersonNo());
		dbManager.setString(4, prplCommunicatOpinionDto.getComCode());
		dbManager.setString(5, prplCommunicatOpinionDto.getComCName());
		dbManager.setString(6, prplCommunicatOpinionDto.getUserCode());
		dbManager.setString(7, prplCommunicatOpinionDto.getUserName());
		dbManager.setString(8, prplCommunicatOpinionDto.getHandleRole());
		dbManager.setDateTime(9, prplCommunicatOpinionDto.getHandleTime());
		dbManager.setString(10, prplCommunicatOpinionDto.getDirection());
		dbManager.setString(11, prplCommunicatOpinionDto.getAboveTime());
		dbManager.setString(12, prplCommunicatOpinionDto.getHandleOpinion());
		dbManager.executePreparedUpdate();
		log.info("DBPrplCommunicatOpinionBase.insert() success!");
	}

	/**
	 * ��������ʽ�����������
	 * @param collection collection
	 * @throws Exception
	 */
	public void insertAll(Collection collection) throws Exception {
		String mainStatement = "Insert Into prplCommunicatOpinion ("
								+ " communicationNo," 
								+ "opinionno,"
								+ "personno," 
								+ " comcode,"
								+ " comcname,"
								+ "usercode,"
								+ "username," 
								+ "handleRole,"
								+ "handleTime,"
								+ "direction,"
								+ " aboveTime,"
								+ "handleOpinion)";
		String statement = mainStatement + " values (?,?,?,?,?,?,?,?,?,?,?)";
		log.debug(statement);
		dbManager.prepareStatement(statement);
		for (Iterator i = collection.iterator(); i.hasNext();) {
			PrplCommunicatOpinionDto prplCommunicatOpinionDto = (PrplCommunicatOpinionDto) i.next();
			dbManager.setString(1, prplCommunicatOpinionDto.getCommunicationNo());
			dbManager.setString(2, prplCommunicatOpinionDto.getOpinionNo());
			dbManager.setString(3, prplCommunicatOpinionDto.getPersonNo());
			dbManager.setString(4, prplCommunicatOpinionDto.getComCode());
			dbManager.setString(5, prplCommunicatOpinionDto.getComCName());
			dbManager.setString(6, prplCommunicatOpinionDto.getUserCode());
			dbManager.setString(7, prplCommunicatOpinionDto.getUserName());
			dbManager.setString(8, prplCommunicatOpinionDto.getHandleRole());
			dbManager.setDateTime(9, prplCommunicatOpinionDto.getHandleTime());
			dbManager.setString(10, prplCommunicatOpinionDto.getDirection());
			dbManager.setString(11, prplCommunicatOpinionDto.getAboveTime());
			dbManager.setString(12, prplCommunicatOpinionDto.getHandleOpinion());
			dbManager.addBatch();
		}
		dbManager.executePreparedUpdateBatch();
		log.info("DBPrplCommunicatOpinionBase.insertAll() success!");
	}
	
	/**
	 * ������ɾ��һ������
	 * @param CommunicationNo ��ͨID
	 * @throws Exception
	 */
	public void delete(String CommunicationNo) throws Exception {
		String statement = " Delete From prplCommunicatOpinion" + " Where "
				+ " CommunicationNo = ? ";
		if (log.isDebugEnabled()) {
			String debugStatement = "Delete From prplCommunicatOpinion Where CommunicationNo = "
					+ CommunicationNo;
			log.debug(debugStatement);
		}
		dbManager.prepareStatement(statement);
		//���������ֶ�;
		dbManager.setString(1, CommunicationNo);
		dbManager.executePreparedUpdate();
		log.info("DBPrplCommunicatOpinionBase.delete() success!");
	}

	
	/**
	 * ������ɾ��һ������
	 * @param CommunicationNo ��ͨID
	 * @param opinionNo ��ͨ�������
	 * @throws Exception
	 */
	public void delete(String communicationNo,String opinionNo) throws Exception {
		String statement = " Delete From prplCommunicatOpinion" + " Where "
				+ " CommunicationNo = ? and opinionNo = ?";
		if (log.isDebugEnabled()) {
			String debugStatement = "Delete From prplCommunicatOpinion Where CommunicationNo = "
					+ communicationNo +" and opinionno =  " + opinionNo;
			log.debug(debugStatement);
		}
		dbManager.prepareStatement(statement);
		//���������ֶ�;
		dbManager.setString(1, communicationNo);
		dbManager.setString(2, opinionNo);
		dbManager.executePreparedUpdate();
		log.info("DBPrplCommunicatOpinionBase.delete() success!");
	}

	/**
	 * ����������һ������(���������޷����)
	 * @param prplCommunicatOpinionDto 
	 * @throws Exception
	 */
	public void update(PrplCommunicatOpinionDto prplCommunicatOpinionDto)
			throws Exception {
		String statement = " Update prplCommunicatOpinion Set "+ 
							" personno=?," + 
							" usercode=?," + 
							" username=?," + 
							" comcode=?,"  +
							" comcname=?,"   +
							" handleRole=?," + 
							" handleTime=?," + 
							" direction=?," + 
							" aboveTime=?,"+
							" handleOpinion=?)"+
							" where CommunicatOpinionNo = ? and opinionno = ?";
		if (log.isDebugEnabled()) {
			String debugStatement = " Update prplCommunicatOpinion Set "
					+ " personno="+ prplCommunicatOpinionDto.getPersonNo()+ ","
					+ " usercode="+ prplCommunicatOpinionDto.getUserCode()+ ","
					+ " username="+ prplCommunicatOpinionDto.getUserName()+ ","
					+ " comcode="+ prplCommunicatOpinionDto.getComCode()+ ","
					+ " comcname="+ prplCommunicatOpinionDto.getComCName()+ ","
					+ " handleRole="+ prplCommunicatOpinionDto.getHandleRole()+ ","
					+ " handleTime="+ prplCommunicatOpinionDto.getHandleTime()+ ","
					+ " direction="+ prplCommunicatOpinionDto.getDirection()+ ","
					+ " aboveTime="+ prplCommunicatOpinionDto.getAboveTime()+ ","
					+ " handleOpinion="+ prplCommunicatOpinionDto.getHandleOpinion()+ ""
					+ " where CommunicatOpinionNo = "+ prplCommunicatOpinionDto.getCommunicationNo()
					+ " and opinionno = " + prplCommunicatOpinionDto.getOpinionNo();
			log.debug(debugStatement);
		}
		dbManager.prepareStatement(statement);
		//���ø����ֶ�;
		dbManager.setString(1, prplCommunicatOpinionDto.getPersonNo());
		dbManager.setString(2, prplCommunicatOpinionDto.getUserCode());
		dbManager.setString(3, prplCommunicatOpinionDto.getUserName());
		dbManager.setString(4, prplCommunicatOpinionDto.getComCode());
		dbManager.setString(5, prplCommunicatOpinionDto.getComCName());
		dbManager.setString(6, prplCommunicatOpinionDto.getHandleRole());
		dbManager.setDateTime(7, prplCommunicatOpinionDto.getHandleTime());
		dbManager.setString(8, prplCommunicatOpinionDto.getDirection());
		dbManager.setString(9, prplCommunicatOpinionDto.getAboveTime());
		dbManager.setString(10, prplCommunicatOpinionDto.getHandleOpinion());
		dbManager.setString(11, prplCommunicatOpinionDto.getCommunicationNo());
		dbManager.setString(12, prplCommunicatOpinionDto.getOpinionNo());
		dbManager.executePreparedUpdate();
		log.info("DBPrplCommunicatOpinionBase.update() success!");
	}
	
	/**
	 * ����������һ������
	 * @param CommunicationNo ��ͨID
	 * @return PrplCommunicatOpinionDto
	 * @throws Exception
	 */
	public Collection findByCommunicationNo(String communicationNo)
			throws Exception {
		String mainStatement = " Select CommunicationNo,"
				+ " personno,"
				+ " opinionno,"
				+ " comcode,"
				+ " comcname,"
				+ " usercode," 
				+ " username," 
				+ " handleRole," 
				+ " handleTime,"
				+ " direction,"  
				+ " aboveTime,"
				+ "handleOpinion "
				+ " from prplCommunicatOpinion";
		String statement = mainStatement + " Where CommunicationNo=? ";
		Collection collection = new ArrayList();
		PrplCommunicatOpinionDto prplCommunicatOpinionDto = null;
		if (log.isDebugEnabled()) {
			String debugStatement = mainStatement
					+ " Where CommunicationNo = " + communicationNo ;
			log.debug(debugStatement);
		}
		dbManager.prepareStatement(statement);
		//���������ֶ�;
		dbManager.setString(1, communicationNo);
		ResultSet resultSet = dbManager.executePreparedQuery();
		while (resultSet.next()) {
			prplCommunicatOpinionDto = new PrplCommunicatOpinionDto();
			prplCommunicatOpinionDto.setCommunicationNo(dbManager.getString(resultSet, 1));
			prplCommunicatOpinionDto.setPersonNo(dbManager.getString(resultSet, 2));
			prplCommunicatOpinionDto.setOpinionNo(dbManager.getString(resultSet, 3));
			prplCommunicatOpinionDto.setComCode(dbManager.getString(resultSet, 4));
			prplCommunicatOpinionDto.setComCName(dbManager.getString(resultSet, 5));
			prplCommunicatOpinionDto.setUserCode(dbManager.getString(resultSet,6));
			prplCommunicatOpinionDto.setUserName(dbManager.getString(resultSet,7));
			prplCommunicatOpinionDto.setHandleRole(dbManager.getString(resultSet, 8));
			//prplCommunicatOpinionDto.setHandleTime(dbManager.getDateTime(resultSet, 9));
			prplCommunicatOpinionDto.setHandleTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,9));
			prplCommunicatOpinionDto.setDirection(dbManager.getString(resultSet,10));
			prplCommunicatOpinionDto.setAboveTime(dbManager.getString(resultSet,11));
			prplCommunicatOpinionDto.setHandleOpinion(dbManager.getString(resultSet,12));
			collection.add(prplCommunicatOpinionDto);
		} 
		log.info("DBPrplCommunicatOpinionBase.findByCommunicationNo() success!");
		resultSet.close();
		return collection;
	}

	/**
	 * ����������һ������
	 * @param CommunicationNo ��ͨID
	 * @param personNo ��ͨ��Ա���
	 * @return PrplCommunicatOpinionDto
	 * @throws Exception
	 */
	public PrplCommunicatOpinionDto findByPrimaryKey(String communicationNo,String opinionNo)
			throws Exception {
		String mainStatement = " Select CommunicationNo,"
								+ " personno,"
								+ " opinionno,"
								+ " comcode,"
								+ " comcname,"
								+ " usercode," 
								+ " username," 
								+ " handleRole," 
								+ " handleTime,"
								+ " direction,"  
								+ " aboveTime,"
								+ "handleOpinion "
								+ " from prplCommunicatOpinion";
		String statement = mainStatement + " Where CommunicationNo=? and opinionNo = ?";
		PrplCommunicatOpinionDto prplCommunicatOpinionDto = null;
		if (log.isDebugEnabled()) {
			String debugStatement = mainStatement
					+ " Where CommunicationNo = " + communicationNo 
					+ " and opinionNo = " + opinionNo;
			log.debug(debugStatement);
		}
		dbManager.prepareStatement(statement);
		//���������ֶ�;
		dbManager.setString(1, communicationNo);
		dbManager.setString(2, opinionNo);
		ResultSet resultSet = dbManager.executePreparedQuery();
		if (resultSet.next()) {
			prplCommunicatOpinionDto = new PrplCommunicatOpinionDto();
			prplCommunicatOpinionDto.setCommunicationNo(dbManager.getString(resultSet, 1));
			prplCommunicatOpinionDto.setPersonNo(dbManager.getString(resultSet, 2));
			prplCommunicatOpinionDto.setOpinionNo(dbManager.getString(resultSet, 3));
			prplCommunicatOpinionDto.setComCode(dbManager.getString(resultSet, 4));
			prplCommunicatOpinionDto.setComCName(dbManager.getString(resultSet, 5));
			prplCommunicatOpinionDto.setUserCode(dbManager.getString(resultSet,6));
			prplCommunicatOpinionDto.setUserName(dbManager.getString(resultSet,7));
			prplCommunicatOpinionDto.setHandleRole(dbManager.getString(resultSet, 8));
			//prplCommunicatOpinionDto.setHandleTime(dbManager.getDateTime(resultSet, 9));
			prplCommunicatOpinionDto.setHandleTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,9));
			prplCommunicatOpinionDto.setDirection(dbManager.getString(resultSet,10));
			prplCommunicatOpinionDto.setAboveTime(dbManager.getString(resultSet,11));
			prplCommunicatOpinionDto.setHandleOpinion(dbManager.getString(resultSet,12));
			log.info("DBPrplCommunicatOpinionBase.findByPrimaryKey() success!");
		} else {
			log.info("DBPrplCommunicatOpinionBase.findByPrimaryKey() failure!");
		}
		resultSet.close();
		return prplCommunicatOpinionDto;
	}

	/**
	 * ��������ѯ��������
	 * @param conditions ��ѯ����
	 * @param pageNo ҳ��
	 * @param rowsPerPage ÿҳ������
	 * @return Collection
	 * @throws Exception
	 */
	public Collection findByConditions(String conditions, int pageNo,
			int rowsPerPage) throws Exception {
		String mainStatement = " Select CommunicationNo,"
								+ " personno,"
								+ " opinionno,"
								+ " comcode,"
								+ " comcname,"
								+ " usercode," 
								+ " username," 
								+ " handleRole," 
								+ " handleTime,"
								+ " direction,"  
								+ " aboveTime,"
								+ "handleOpinion "
								+ " from prplCommunicatOpinion ";
		String statement = mainStatement + " Where " + conditions;
		log.debug(statement);
		Collection collection = new ArrayList();
		PrplCommunicatOpinionDto prplCommunicatOpinionDto = null;
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
			prplCommunicatOpinionDto = new PrplCommunicatOpinionDto();
			prplCommunicatOpinionDto = new PrplCommunicatOpinionDto();
			prplCommunicatOpinionDto.setCommunicationNo(dbManager.getString(resultSet, 1));
			prplCommunicatOpinionDto.setPersonNo(dbManager.getString(resultSet, 2));
			prplCommunicatOpinionDto.setOpinionNo(dbManager.getString(resultSet, 3));
			prplCommunicatOpinionDto.setComCode(dbManager.getString(resultSet, 4));
			prplCommunicatOpinionDto.setComCName(dbManager.getString(resultSet, 5));
			prplCommunicatOpinionDto.setUserCode(dbManager.getString(resultSet,6));
			prplCommunicatOpinionDto.setUserName(dbManager.getString(resultSet,7));
			prplCommunicatOpinionDto.setHandleRole(dbManager.getString(resultSet, 8));
			//prplCommunicatOpinionDto.setHandleTime(dbManager.getDateTime(resultSet, 9));
			prplCommunicatOpinionDto.setHandleTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,9));
			prplCommunicatOpinionDto.setDirection(dbManager.getString(resultSet,10));
			prplCommunicatOpinionDto.setAboveTime(dbManager.getString(resultSet,11));
			prplCommunicatOpinionDto.setHandleOpinion(dbManager.getString(resultSet,12));
			collection.add(prplCommunicatOpinionDto);
		}
		resultSet.close();
		log.info("DBPrplCommunicatOpinionBase.findByConditions() success!");
		return collection;
	}

	/**
	 * ��������ѯ��������
	 * @param conditions ��ѯ����
	 * @return Collection
	 * @throws Exception
	 */
	public Collection findByConditions(String conditions) throws Exception {
		return findByConditions(conditions, 0, 0);
	}

	/**
	 * ��ѯ����ģ����ѯ�����ļ�¼��
	 * @param conditions conditions
	 * @return ����ģ����ѯ�����ļ�¼��
	 * @throws Exception
	 */
	public int getCount(String conditions) throws Exception {
		int count = -1;
		String statement = "Select count(*) from prplCommunicatOpinion Where "
				+ conditions;
		statement = SqlUtils.getWherePartForGetCount(statement);
		log.debug(statement);
		ResultSet resultSet = dbManager.executeQuery(statement);
		resultSet.next();
		count = dbManager.getInt(resultSet, 1);
		resultSet.close();
		log.info("DBPrplCommunicatOpinionBase.getCount() success!");
		return count;
	}
}
