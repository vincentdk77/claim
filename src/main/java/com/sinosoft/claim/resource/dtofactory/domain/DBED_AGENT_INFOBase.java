package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.ED_AGENT_INFODto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ������ϯԱ����Ϣ������ݷ��ʶ������<br>
 * ������ 2005-07-19 09:58:57.598<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBED_AGENT_INFOBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log logger = LogFactory.getLog(DBED_AGENT_INFOBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBED_AGENT_INFOBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param eD_AGENT_INFODto eD_AGENT_INFODto
     * @throws Exception
     */
    public void insert(ED_AGENT_INFODto eD_AGENT_INFODto) throws Exception{
        String mainStatement = " Insert Into ED_AGENT_INFO (" + 
                           " AGENTID," + 
                           " AGENTPSWD," + 
                           " AGENTTYPE," + 
                           " AGENTACD," + 
                           " AGENTNAME," + 
                           " GENDER," + 
                           " DEPT," + 
                           " MANAGEQUEUES)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + eD_AGENT_INFODto.getAGENTID() + "'," + 
                           "'" + eD_AGENT_INFODto.getAGENTPSWD() + "'," + 
                           "'" + eD_AGENT_INFODto.getAGENTTYPE() + "'," + 
                           "'" + eD_AGENT_INFODto.getAGENTACD() + "'," + 
                           "'" + eD_AGENT_INFODto.getAGENTNAME() + "'," + 
                           "'" + eD_AGENT_INFODto.getGENDER() + "'," + 
                           "'" + eD_AGENT_INFODto.getDEPT() + "'," + 
                           "'" + eD_AGENT_INFODto.getMANAGEQUEUES() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,eD_AGENT_INFODto.getAGENTID());
        dbManager.setString(2,eD_AGENT_INFODto.getAGENTPSWD());
        dbManager.setString(3,eD_AGENT_INFODto.getAGENTTYPE());
        dbManager.setString(4,eD_AGENT_INFODto.getAGENTACD());
        dbManager.setString(5,eD_AGENT_INFODto.getAGENTNAME());
        dbManager.setString(6,eD_AGENT_INFODto.getGENDER());
        dbManager.setString(7,eD_AGENT_INFODto.getDEPT());
        dbManager.setString(8,eD_AGENT_INFODto.getMANAGEQUEUES());
        dbManager.executePreparedUpdate();

        logger.info("DBED_AGENT_INFOBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            ED_AGENT_INFODto eD_AGENT_INFODto = (ED_AGENT_INFODto)i.next();
            insert(eD_AGENT_INFODto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param aGENTID ��ϯ����
     * @throws Exception
     */
    public void delete(String aGENTID) throws Exception{
        String statement = " Delete From ED_AGENT_INFO" + 
	            		   " Where " +
                           " AGENTID = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From ED_AGENT_INFO Where " +
                           " AGENTID = '" + aGENTID + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,aGENTID);
        dbManager.executePreparedUpdate();
        logger.info("DBED_AGENT_INFOBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param eD_AGENT_INFODto eD_AGENT_INFODto
     * @throws Exception
     */
    public void update(ED_AGENT_INFODto eD_AGENT_INFODto) throws Exception{
        String statement = " Update ED_AGENT_INFO Set AGENTPSWD = ?," + 
                           " AGENTTYPE = ?," + 
                           " AGENTACD = ?," + 
                           " AGENTNAME = ?," + 
                           " GENDER = ?," + 
                           " DEPT = ?," + 
                           " MANAGEQUEUES = ?" + 
	            		   " Where " +
                           " AGENTID = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update ED_AGENT_INFO Set " + 
                           " AGENTID = '" + eD_AGENT_INFODto.getAGENTID() + "'," + 
                           " AGENTPSWD = '" + eD_AGENT_INFODto.getAGENTPSWD() + "'," + 
                           " AGENTTYPE = '" + eD_AGENT_INFODto.getAGENTTYPE() + "'," + 
                           " AGENTACD = '" + eD_AGENT_INFODto.getAGENTACD() + "'," + 
                           " AGENTNAME = '" + eD_AGENT_INFODto.getAGENTNAME() + "'," + 
                           " GENDER = '" + eD_AGENT_INFODto.getGENDER() + "'," + 
                           " DEPT = '" + eD_AGENT_INFODto.getDEPT() + "'," + 
                           " MANAGEQUEUES = '" + eD_AGENT_INFODto.getMANAGEQUEUES() + "'" + 
			               " Where " +
                           " AGENTID = '" + eD_AGENT_INFODto.getAGENTID() + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,eD_AGENT_INFODto.getAGENTPSWD());
        dbManager.setString(2,eD_AGENT_INFODto.getAGENTTYPE());
        dbManager.setString(3,eD_AGENT_INFODto.getAGENTACD());
        dbManager.setString(4,eD_AGENT_INFODto.getAGENTNAME());
        dbManager.setString(5,eD_AGENT_INFODto.getGENDER());
        dbManager.setString(6,eD_AGENT_INFODto.getDEPT());
        dbManager.setString(7,eD_AGENT_INFODto.getMANAGEQUEUES());
        //���������ֶ�;
        dbManager.setString(8,eD_AGENT_INFODto.getAGENTID());
        dbManager.executePreparedUpdate();

        logger.info("DBED_AGENT_INFOBase.update() success!");
    }

    /**
     * ����������һ������
     * @param aGENTID ��ϯ����
     * @return ED_AGENT_INFODto
     * @throws Exception
     */
    public ED_AGENT_INFODto findByPrimaryKey(String aGENTID) throws Exception{
        String mainStatement = " Select AGENTID," + 
                           " AGENTPSWD," + 
                           " AGENTTYPE," + 
                           " AGENTACD," + 
                           " AGENTNAME," + 
                           " GENDER," + 
                           " DEPT," + 
                           " MANAGEQUEUES From ED_AGENT_INFO";
        String statement = mainStatement + " Where " +
                           " AGENTID = ?";
        ED_AGENT_INFODto eD_AGENT_INFODto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " AGENTID = '" + aGENTID + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,aGENTID);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            eD_AGENT_INFODto = new ED_AGENT_INFODto();
            eD_AGENT_INFODto.setAGENTID(dbManager.getString(resultSet,1));
            eD_AGENT_INFODto.setAGENTPSWD(dbManager.getString(resultSet,2));
            eD_AGENT_INFODto.setAGENTTYPE(dbManager.getString(resultSet,3));
            eD_AGENT_INFODto.setAGENTACD(dbManager.getString(resultSet,4));
            eD_AGENT_INFODto.setAGENTNAME(dbManager.getString(resultSet,5));
            eD_AGENT_INFODto.setGENDER(dbManager.getString(resultSet,6));
            eD_AGENT_INFODto.setDEPT(dbManager.getString(resultSet,7));
            eD_AGENT_INFODto.setMANAGEQUEUES(dbManager.getString(resultSet,8));
        }
        resultSet.close();
        logger.info("DBED_AGENT_INFOBase.findByPrimaryKey() success!");
        return eD_AGENT_INFODto;
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
        String statement = "Select AGENTID," + 
                           " AGENTPSWD," + 
                           " AGENTTYPE," + 
                           " AGENTACD," + 
                           " AGENTNAME," + 
                           " GENDER," + 
                           " DEPT," + 
                           " MANAGEQUEUES From ED_AGENT_INFO Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        ED_AGENT_INFODto eD_AGENT_INFODto = null;
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

            eD_AGENT_INFODto = new ED_AGENT_INFODto();
            eD_AGENT_INFODto.setAGENTID(dbManager.getString(resultSet,1));
            eD_AGENT_INFODto.setAGENTPSWD(dbManager.getString(resultSet,2));
            eD_AGENT_INFODto.setAGENTTYPE(dbManager.getString(resultSet,3));
            eD_AGENT_INFODto.setAGENTACD(dbManager.getString(resultSet,4));
            eD_AGENT_INFODto.setAGENTNAME(dbManager.getString(resultSet,5));
            eD_AGENT_INFODto.setGENDER(dbManager.getString(resultSet,6));
            eD_AGENT_INFODto.setDEPT(dbManager.getString(resultSet,7));
            eD_AGENT_INFODto.setMANAGEQUEUES(dbManager.getString(resultSet,8));
            collection.add(eD_AGENT_INFODto);
        }
        resultSet.close();
        logger.info("DBED_AGENT_INFOBase.findByConditions() success!");
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
     * ������ɾ������
     * @param conditions ��ѯ����
     * @return ɾ��������
     * @throws Exception
     */
    public int deleteByConditions(String conditions) throws Exception{
        String statement = "Delete From ED_AGENT_INFO Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBED_AGENT_INFOBase.deleteByConditions() success!");
        return count;
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
        String statement = "Select count(*) from ED_AGENT_INFO Where " + conditions;
        statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBED_AGENT_INFOBase.getCount() success!");
        return count;
    }
}
