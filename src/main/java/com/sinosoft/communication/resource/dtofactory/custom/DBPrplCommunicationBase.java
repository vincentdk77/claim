package com.sinosoft.communication.resource.dtofactory.custom;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcheckItemDto;
import com.sinosoft.communication.dto.custom.PrplCommunicationDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

public class DBPrplCommunicationBase {
	 protected DBManager dbManager = null; //��Դ������
	 protected static Log log = LogFactory.getLog(DBPrplCommunicationBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrplCommunicationBase(DBManager dbManager){
        this.dbManager = dbManager;
    }
    /**
     * ����һ������
     * @param prplCommunicationDto prplCommunicationDto
     * @throws Exception
     */
    public void insert(PrplCommunicationDto prplCommunicationDto) throws Exception{
    	String mainStatement = "Insert Into prplCommunication ("+
    						"communicationNo,"+
    						"communicationtopic,"+
    						"registno,"+
    						"comcode,"+
    						"usercode,"+
    						"username,"+
    						"nodeCode,"+
    						"nodeName,"+
    						"createTime,"+
    						"closeTime,"+
    						"closeMode,"+
    						"validata,"+
    						"comName,"+
    						"taskType,"+
    						"taskName )";
    	String statement = mainStatement+" values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    	if(log.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "" + prplCommunicationDto.getCommunicationNo() + "," + 
                           "'" + prplCommunicationDto.getCommunicationTopic() + "'," + 
                           "" + prplCommunicationDto.getRegistNo() + "," + 
                           "'" + prplCommunicationDto.getComCode() + "'," + 
                           "'" + prplCommunicationDto.getUserCode() + "'," + 
                           "'" + prplCommunicationDto.getUserName() + "'," + 
                           "" + prplCommunicationDto.getNodeCode() + "," + 
                           "'" + prplCommunicationDto.getNodeName() + "'," + 
                           "'" + prplCommunicationDto.getCreateTime() + "'," + 
                           "'" + prplCommunicationDto.getCloseTime() + "'," + 
                           "'" + prplCommunicationDto.getCloseMode() + "'," + 
                           "'" + prplCommunicationDto.getValidata() + "'," + 
                           "'" + prplCommunicationDto.getComName() + "'," + 
                           "'" + prplCommunicationDto.getTaskType() + "'," + 
                           "'" + prplCommunicationDto.getTaskName() + "')";
            log.debug(debugStatement);
        }
    	dbManager.prepareStatement(statement);
        dbManager.setString(1,prplCommunicationDto.getCommunicationNo());
        dbManager.setString(2,prplCommunicationDto.getCommunicationTopic());
        dbManager.setString(3,prplCommunicationDto.getRegistNo());
        dbManager.setString(4,prplCommunicationDto.getComCode());
        dbManager.setString(5,prplCommunicationDto.getUserCode());
        dbManager.setString(6,prplCommunicationDto.getUserName());
        dbManager.setString(7,prplCommunicationDto.getNodeCode());
        dbManager.setString(8,prplCommunicationDto.getNodeName());
        dbManager.setDateTime(9,prplCommunicationDto.getCreateTime());
        dbManager.setDateTime(10,prplCommunicationDto.getCloseTime());
        dbManager.setString(11,prplCommunicationDto.getCloseMode());
        dbManager.setString(12,prplCommunicationDto.getValidata());
        dbManager.setString(13,prplCommunicationDto.getComName());
        dbManager.setString(14,prplCommunicationDto.getTaskType());
        dbManager.setString(15,prplCommunicationDto.getTaskName());
        dbManager.executePreparedUpdate();
        log.info("DBPrplCommunicationBase.insert() success!");
    }
    /**
     * ��������ʽ�����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
    	String mainStatement = "Insert Into prplCommunication ("+
								"communicationNo,"+
								"communicationtopic,"+
								"registno,"+
								"comcode,"+
								"usercode,"+
								"username,"+
								"nodeCode,"+
								"nodeName,"+
								"createTime,"+
								"closeTime,"+
								"closeMode,"+
	    						"validata,"+
	    						"comName,"+
	    						"taskType,"+
	    						"taskName )";
    	String statement = mainStatement+" values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    	log.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
        	PrplCommunicationDto prplCommunicationDto = (PrplCommunicationDto)i.next();
        	dbManager.setString(1,prplCommunicationDto.getCommunicationNo());
            dbManager.setString(2,prplCommunicationDto.getCommunicationTopic());
            dbManager.setString(3,prplCommunicationDto.getRegistNo());
            dbManager.setString(4,prplCommunicationDto.getComCode());
            dbManager.setString(5,prplCommunicationDto.getUserCode());
            dbManager.setString(6,prplCommunicationDto.getUserName());
            dbManager.setString(7,prplCommunicationDto.getNodeCode());
            dbManager.setString(8,prplCommunicationDto.getNodeName());
            dbManager.setDateTime(9,prplCommunicationDto.getCreateTime());
            dbManager.setDateTime(10,prplCommunicationDto.getCloseTime());
            dbManager.setString(11,prplCommunicationDto.getCloseMode());
            dbManager.setString(12,prplCommunicationDto.getValidata());
            dbManager.setString(13,prplCommunicationDto.getComName());
            dbManager.setString(14,prplCommunicationDto.getTaskType());
            dbManager.setString(15,prplCommunicationDto.getTaskName());
        	dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        log.info("DBPrplCommunicationBase.insertAll() success!");
    }
    /**
     * ������ɾ��һ������
     * @param communicationNo ��ͨID
     * @throws Exception
     */
    public void delete(String communicationNo) throws Exception{
    	String statement = " Delete From prplCommunication" + 
		   					" Where " + 
		   					" communicationNo = ?";
    	if(log.isDebugEnabled()){
            String debugStatement = "Delete From prplCommunication Where communicationNo = "+ communicationNo;
            log.debug(debugStatement);
        }
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,communicationNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrplCommunicationBase.delete() success!");
    }
    /**
     * ����������һ������(���������޷����)
     * @param prpLcheckItemDto prpLcheckItemDto
     * @throws Exception
     */
    public void update(PrplCommunicationDto prplCommunicationDto) throws Exception{
    	 String statement = " Update prplCommunication Set " +
				    	 	" communicationtopic=?,"+
							" registno=?,"+
							" comcode=?,"+
							" usercode=?,"+
							" username=?,"+
							" nodeCode=?,"+
							" nodeName=?,"+
							" createTime=?,"+
							" closeTime=?,"+
							" closeMode=?,"+
							" validata=?,"+ 
							" comName=?,"+ 
							" taskType=?,"+ 
							" taskName=?"+ 
    	 					" where communicationNo = ? ";
    	 if(log.isDebugEnabled()){
             String debugStatement =" Update prplCommunication Set " +
						    	 	" communicationtopic="+prplCommunicationDto.getCommunicationTopic()+","+
									" registno="+prplCommunicationDto.getRegistNo()+","+
									" comcode="+prplCommunicationDto.getComCode()+","+
									" usercode="+prplCommunicationDto.getUserCode()+","+
									" username="+prplCommunicationDto.getUserName()+","+
									" nodeCode="+prplCommunicationDto.getNodeCode()+","+
									" nodeName="+prplCommunicationDto.getNodeName()+","+
									" createTime="+prplCommunicationDto.getCreateTime()+","+
									" closeTime="+prplCommunicationDto.getCloseTime()+","+
									" closeMode="+prplCommunicationDto.getCloseMode()+","+
									" validata="+prplCommunicationDto.getValidata()+","+ 
									" comName="+prplCommunicationDto.getComName()+","+ 
									" taskType="+prplCommunicationDto.getTaskType()+","+ 
									" taskName="+prplCommunicationDto.getTaskName()+""+ 
									" where communicationNo = "+prplCommunicationDto.getCommunicationNo();
             log.debug(debugStatement);
         }
         dbManager.prepareStatement(statement);
       //���ø����ֶ�;
         dbManager.setString(1,prplCommunicationDto.getCommunicationTopic());
         dbManager.setString(2,prplCommunicationDto.getRegistNo());
         dbManager.setString(3,prplCommunicationDto.getComCode());
         dbManager.setString(4,prplCommunicationDto.getUserCode());
         dbManager.setString(5,prplCommunicationDto.getUserName());
         dbManager.setString(6,prplCommunicationDto.getNodeCode());
         dbManager.setString(7,prplCommunicationDto.getNodeName());
         dbManager.setDateTime(8,prplCommunicationDto.getCreateTime());
         dbManager.setDateTime(9,prplCommunicationDto.getCloseTime());
         dbManager.setString(10,prplCommunicationDto.getCloseMode());
         dbManager.setString(11,prplCommunicationDto.getValidata());
         dbManager.setString(12,prplCommunicationDto.getComName());
         dbManager.setString(13,prplCommunicationDto.getTaskType());
         dbManager.setString(14,prplCommunicationDto.getTaskName());
         dbManager.setString(15,prplCommunicationDto.getCommunicationNo());
         dbManager.executePreparedUpdate();
         log.info("DBPrplCommunicationBase.update() success!");
    }
    /**
     * ����������һ������
     * @param communicationNo ��ͨID
     * @return PrplCommunicationDto
     * @throws Exception
     */
    public PrplCommunicationDto findByPrimaryKey(String communicationNo) throws Exception{
    	String mainStatement = " Select communicationNo," + 
						    	" communicationtopic,"+
								" registno,"+
								" comcode,"+
								" usercode,"+
								" username,"+
								" nodeCode,"+
								" nodeName,"+
								" createTime,"+
								" closeTime,"+
								" closeMode,"+
								" validata,"+
								" comName,"+
								" taskType,"+
								" taskName"+
								" from prplCommunication";
		String statement = mainStatement + " Where communicationNo=?" ;
		PrplCommunicationDto prplCommunicationDto = null;
		if(log.isDebugEnabled()){
            String debugStatement = mainStatement + " Where communicationNo = " +communicationNo ;
            log.debug(debugStatement);
        }
		dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,communicationNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
        	prplCommunicationDto = new PrplCommunicationDto();
        	prplCommunicationDto.setCommunicationNo(dbManager.getString(resultSet, 1));
        	prplCommunicationDto.setCommunicationTopic(dbManager.getString(resultSet, 2));
        	prplCommunicationDto.setRegistNo(dbManager.getString(resultSet, 3));
        	prplCommunicationDto.setComCode(dbManager.getString(resultSet, 4));
        	prplCommunicationDto.setUserCode(dbManager.getString(resultSet, 5));
        	prplCommunicationDto.setUserName(dbManager.getString(resultSet, 6));
        	prplCommunicationDto.setNodeCode(dbManager.getString(resultSet, 7));
        	prplCommunicationDto.setNodeName(dbManager.getString(resultSet, 8));
        	//prplCommunicationDto.setCreateTime(dbManager.getDateTime(resultSet, 9));
        	prplCommunicationDto.setCreateTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND, 9));
        	//prplCommunicationDto.setCloseTime(dbManager.getDateTime(resultSet, 10));
        	prplCommunicationDto.setCloseTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND, 10));
        	prplCommunicationDto.setCloseMode(dbManager.getString(resultSet, 11));
        	prplCommunicationDto.setValidata(dbManager.getString(resultSet, 12));
        	prplCommunicationDto.setComName(dbManager.getString(resultSet, 13));
        	prplCommunicationDto.setTaskType(dbManager.getString(resultSet, 14));
        	prplCommunicationDto.setTaskName(dbManager.getString(resultSet, 15));
        	
            log.info("DBPrplCommunicationBase.findByPrimaryKey() success!");
        }else{
            log.info("DBPrplCommunicationBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
		return prplCommunicationDto;
    }
    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
    	String mainStatement = " Select communicationNo," + 
						    	" communicationtopic,"+
								" registno,"+
								" comcode,"+
								" usercode,"+
								" username,"+
								" nodeCode,"+
								" nodeName,"+
								" createTime,"+
								" closeTime,"+
								" closeMode,"+
								" validata,"+
								" comName,"+
								" taskType,"+
								" taskName"+
								" from prplCommunication ";
		String statement = mainStatement + " Where " +conditions;
		log.debug(statement);
        Collection collection = new ArrayList();
        PrplCommunicationDto prplCommunicationDto = null;
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
            prplCommunicationDto = new PrplCommunicationDto();
        	prplCommunicationDto.setCommunicationNo(dbManager.getString(resultSet, 1));
        	prplCommunicationDto.setCommunicationTopic(dbManager.getString(resultSet, 2));
        	prplCommunicationDto.setRegistNo(dbManager.getString(resultSet, 3));
        	prplCommunicationDto.setComCode(dbManager.getString(resultSet, 4));
        	prplCommunicationDto.setUserCode(dbManager.getString(resultSet, 5));
        	prplCommunicationDto.setUserName(dbManager.getString(resultSet, 6));
        	prplCommunicationDto.setNodeCode(dbManager.getString(resultSet, 7));
        	prplCommunicationDto.setNodeName(dbManager.getString(resultSet, 8));
        	prplCommunicationDto.setCreateTime(dbManager.getDateTime(resultSet, 9));
        	prplCommunicationDto.setCreateTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND, 9));
        	//prplCommunicationDto.setCloseTime(dbManager.getDateTime(resultSet, 10));
        	prplCommunicationDto.setCloseTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND, 10));
        	prplCommunicationDto.setCloseMode(dbManager.getString(resultSet, 11));
        	prplCommunicationDto.setValidata(dbManager.getString(resultSet, 12));
        	prplCommunicationDto.setComName(dbManager.getString(resultSet, 13));
        	prplCommunicationDto.setTaskType(dbManager.getString(resultSet, 14));
        	prplCommunicationDto.setTaskName(dbManager.getString(resultSet, 15));
        	collection.add(prplCommunicationDto);
        }
        resultSet.close();
        log.info("DBPrplCommunicationBase.findByConditions() success!");
        return collection;
    }
    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        return findByConditions(conditions,0,0);
    }
    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param conditions conditions
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getCount(String conditions) 
        throws Exception{
        int count = -1;
        String statement = "Select count(*) from prplCommunication  c Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrplCommunicationBase.getCount() success!");
        return count;
    }
}
