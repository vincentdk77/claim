package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimGradetgDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpLclaimGrade�����ݷ��ʶ������<br>
 * ������ 2006-03-07 16:50:47.953<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLclaimGradetgBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Log logger = LogFactory.getLog(DBPrpLclaimGradetgBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLclaimGradetgBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpLclaimGradetgDto prpLclaimGradetgDto
     * @throws Exception
     */
    public void insert(PrpLclaimGradetgDto prpLclaimGradetgDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLclaimGradetg (");
        buffer.append("UserCode,");
        buffer.append("UserName,");
        buffer.append("TaskCode,");
        buffer.append("ComCode,");
        buffer.append("ClaimLevel,");
        buffer.append("ValueLower,");
        buffer.append("ValueUpper,");
        buffer.append("Rate,");
        buffer.append("ValidStatus,");
        buffer.append("Flag,");
        buffer.append("ConfigPara,");
        buffer.append("ConfigDesc ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLclaimGradetgDto.getUserCode()).append("',");
            debugBuffer.append("'").append(prpLclaimGradetgDto.getUserName()).append("',");
            debugBuffer.append("'").append(prpLclaimGradetgDto.getTaskCode()).append("',");
            debugBuffer.append("'").append(prpLclaimGradetgDto.getComCode()).append("',");
            debugBuffer.append("'").append(prpLclaimGradetgDto.getClaimLevel()).append("',");
            debugBuffer.append("").append(prpLclaimGradetgDto.getValueLower()).append(",");
            debugBuffer.append("").append(prpLclaimGradetgDto.getValueUpper()).append(",");
            debugBuffer.append("").append(prpLclaimGradetgDto.getRate()).append(",");
            debugBuffer.append("'").append(prpLclaimGradetgDto.getValidStatus()).append("',");
            debugBuffer.append("'").append(prpLclaimGradetgDto.getFlag()).append("',");
            debugBuffer.append("'").append(prpLclaimGradetgDto.getConfigPara()).append("',");
            debugBuffer.append("'").append(prpLclaimGradetgDto.getConfigDesc()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLclaimGradetgDto.getUserCode());
        dbManager.setString(2,prpLclaimGradetgDto.getUserName());
        dbManager.setString(3,prpLclaimGradetgDto.getTaskCode());
        dbManager.setString(4,prpLclaimGradetgDto.getComCode());
        dbManager.setString(5,prpLclaimGradetgDto.getClaimLevel());
        dbManager.setDouble(6,prpLclaimGradetgDto.getValueLower());
        dbManager.setDouble(7,prpLclaimGradetgDto.getValueUpper());
        dbManager.setDouble(8,prpLclaimGradetgDto.getRate());
        dbManager.setString(9,prpLclaimGradetgDto.getValidStatus());
        dbManager.setString(10,prpLclaimGradetgDto.getFlag());
        dbManager.setString(11,prpLclaimGradetgDto.getConfigPara());
        dbManager.setString(12,prpLclaimGradetgDto.getConfigDesc());
        dbManager.executePreparedUpdate();

    }

    /**
     * ��������ʽ�����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLclaimGradetg (");
        buffer.append("UserCode,");
        buffer.append("UserName,");
        buffer.append("TaskCode,");
        buffer.append("ComCode,");
        buffer.append("ClaimLevel,");
        buffer.append("ValueLower,");
        buffer.append("ValueUpper,");
        buffer.append("Rate,");
        buffer.append("ValidStatus,");
        buffer.append("Flag,");
        buffer.append("ConfigPara,");
        buffer.append("ConfigDesc ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLclaimGradetgDto prpLclaimGradetgDto = (PrpLclaimGradetgDto)i.next();
            dbManager.setString(1,prpLclaimGradetgDto.getUserCode());
            dbManager.setString(2,prpLclaimGradetgDto.getUserName());
            dbManager.setString(3,prpLclaimGradetgDto.getTaskCode());
            dbManager.setString(4,prpLclaimGradetgDto.getComCode());
            dbManager.setString(5,prpLclaimGradetgDto.getClaimLevel());
            dbManager.setDouble(6,prpLclaimGradetgDto.getValueLower());
            dbManager.setDouble(7,prpLclaimGradetgDto.getValueUpper());
            dbManager.setDouble(8,prpLclaimGradetgDto.getRate());
            dbManager.setString(9,prpLclaimGradetgDto.getValidStatus());
            dbManager.setString(10,prpLclaimGradetgDto.getFlag());
            dbManager.setString(11,prpLclaimGradetgDto.getConfigPara());
            dbManager.setString(12,prpLclaimGradetgDto.getConfigDesc());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param userCode UserCode
     * @param taskCode TaskCode
     * @param configPara ConfigPara
     * @throws Exception
     */
    public void delete(String userCode,String taskCode,String configPara)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLclaimGradetg ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("UserCode=").append("'").append(userCode).append("' AND ");
            debugBuffer.append("TaskCode=").append("'").append(taskCode).append("' AND ");
            debugBuffer.append("ConfigPara=").append("'").append(configPara).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("UserCode = ? And ");
        buffer.append("TaskCode = ? And ");
        buffer.append("ConfigPara = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,userCode);
        dbManager.setString(2,taskCode);
        dbManager.setString(3,configPara);
        dbManager.executePreparedUpdate();
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpLclaimGradetgDto prpLclaimGradetgDto
     * @throws Exception
     */
    public void update(PrpLclaimGradetgDto prpLclaimGradetgDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLclaimGradetg SET ");
        buffer.append("UserName = ?, ");
        buffer.append("ComCode = ?, ");
        buffer.append("ClaimLevel = ?, ");
        buffer.append("ValueLower = ?, ");
        buffer.append("ValueUpper = ?, ");
        buffer.append("Rate = ?, ");
        buffer.append("ValidStatus = ?, ");
        buffer.append("Flag = ?, ");
        buffer.append("ConfigDesc = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLclaimGradetg SET ");
            debugBuffer.append("UserName = '" + prpLclaimGradetgDto.getUserName() + "', ");
            debugBuffer.append("ComCode = '" + prpLclaimGradetgDto.getComCode() + "', ");
            debugBuffer.append("ClaimLevel = '" + prpLclaimGradetgDto.getClaimLevel() + "', ");
            debugBuffer.append("ValueLower = " + prpLclaimGradetgDto.getValueLower() + ", ");
            debugBuffer.append("ValueUpper = " + prpLclaimGradetgDto.getValueUpper() + ", ");
            debugBuffer.append("Rate = " + prpLclaimGradetgDto.getRate() + ", ");
            debugBuffer.append("ValidStatus = '" + prpLclaimGradetgDto.getValidStatus() + "', ");
            debugBuffer.append("Flag = '" + prpLclaimGradetgDto.getFlag() + "', ");
            debugBuffer.append("ConfigDesc = '" + prpLclaimGradetgDto.getConfigDesc() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("UserCode=").append("'").append(prpLclaimGradetgDto.getUserCode()).append("' AND ");
            debugBuffer.append("TaskCode=").append("'").append(prpLclaimGradetgDto.getTaskCode()).append("' AND ");
            debugBuffer.append("ConfigPara=").append("'").append(prpLclaimGradetgDto.getConfigPara()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("UserCode = ? And ");
        buffer.append("TaskCode = ? And ");
        buffer.append("ConfigPara = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setString(1,prpLclaimGradetgDto.getUserName());
        dbManager.setString(2,prpLclaimGradetgDto.getComCode());
        dbManager.setString(3,prpLclaimGradetgDto.getClaimLevel());
        dbManager.setDouble(4,prpLclaimGradetgDto.getValueLower());
        dbManager.setDouble(5,prpLclaimGradetgDto.getValueUpper());
        dbManager.setDouble(6,prpLclaimGradetgDto.getRate());
        dbManager.setString(7,prpLclaimGradetgDto.getValidStatus());
        dbManager.setString(8,prpLclaimGradetgDto.getFlag());
        dbManager.setString(9,prpLclaimGradetgDto.getConfigDesc());
        //���������ֶ�;
        dbManager.setString(10,prpLclaimGradetgDto.getUserCode());
        dbManager.setString(11,prpLclaimGradetgDto.getTaskCode());
        dbManager.setString(12,prpLclaimGradetgDto.getConfigPara());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param userCode UserCode
     * @param taskCode TaskCode
     * @param configPara ConfigPara
     * @return PrpLclaimGradetgDto
     * @throws Exception
     */
    public PrpLclaimGradetgDto findByPrimaryKey(String userCode,String taskCode,String configPara)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("UserCode,");
        buffer.append("UserName,");
        buffer.append("TaskCode,");
        buffer.append("ComCode,");
        buffer.append("ClaimLevel,");
        buffer.append("ValueLower,");
        buffer.append("ValueUpper,");
        buffer.append("Rate,");
        buffer.append("ValidStatus,");
        buffer.append("Flag,");
        buffer.append("ConfigPara,");
        buffer.append("ConfigDesc ");
        buffer.append("FROM PrpLclaimGradetg ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("UserCode=").append("'").append(userCode).append("' AND ");
            debugBuffer.append("TaskCode=").append("'").append(taskCode).append("' AND ");
            debugBuffer.append("ConfigPara=").append("'").append(configPara).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("UserCode = ? And ");
        buffer.append("TaskCode = ? And ");
        buffer.append("ConfigPara = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,userCode);
        dbManager.setString(2,taskCode);
        dbManager.setString(3,configPara);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLclaimGradetgDto prpLclaimGradetgDto = null;
        if(resultSet.next()){
            prpLclaimGradetgDto = new PrpLclaimGradetgDto();
            prpLclaimGradetgDto.setUserCode(dbManager.getString(resultSet,1));
            prpLclaimGradetgDto.setUserName(dbManager.getString(resultSet,2));
            prpLclaimGradetgDto.setTaskCode(dbManager.getString(resultSet,3));
            prpLclaimGradetgDto.setComCode(dbManager.getString(resultSet,4));
            prpLclaimGradetgDto.setClaimLevel(dbManager.getString(resultSet,5));
            prpLclaimGradetgDto.setValueLower(dbManager.getDouble(resultSet,6));
            prpLclaimGradetgDto.setValueUpper(dbManager.getDouble(resultSet,7));
            prpLclaimGradetgDto.setRate(dbManager.getDouble(resultSet,8));
            prpLclaimGradetgDto.setValidStatus(dbManager.getString(resultSet,9));
            prpLclaimGradetgDto.setFlag(dbManager.getString(resultSet,10));
            prpLclaimGradetgDto.setConfigPara(dbManager.getString(resultSet,11));
            prpLclaimGradetgDto.setConfigDesc(dbManager.getString(resultSet,12));
        }
        resultSet.close();
        return prpLclaimGradetgDto;
    }

    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("UserCode,");
        buffer.append("UserName,");
        buffer.append("TaskCode,");
        buffer.append("ComCode,");
        buffer.append("ClaimLevel,");
        buffer.append("ValueLower,");
        buffer.append("ValueUpper,");
        buffer.append("Rate,");
        buffer.append("ValidStatus,");
        buffer.append("Flag,");
        buffer.append("ConfigPara,");
        buffer.append("ConfigDesc ");
        buffer.append("FROM PrpLclaimGradetg WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        int count=0;
        if(pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        //���巵�ؽ������
        Collection collection = new ArrayList(rowsPerPage);
        PrpLclaimGradetgDto prpLclaimGradetgDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLclaimGradetgDto = new PrpLclaimGradetgDto();
            prpLclaimGradetgDto.setUserCode(dbManager.getString(resultSet,1));
            prpLclaimGradetgDto.setUserName(dbManager.getString(resultSet,2));
            prpLclaimGradetgDto.setTaskCode(dbManager.getString(resultSet,3));
            prpLclaimGradetgDto.setComCode(dbManager.getString(resultSet,4));
            prpLclaimGradetgDto.setClaimLevel(dbManager.getString(resultSet,5));
            prpLclaimGradetgDto.setValueLower(dbManager.getDouble(resultSet,6));
            prpLclaimGradetgDto.setValueUpper(dbManager.getDouble(resultSet,7));
            prpLclaimGradetgDto.setRate(dbManager.getDouble(resultSet,8));
            prpLclaimGradetgDto.setValidStatus(dbManager.getString(resultSet,9));
            prpLclaimGradetgDto.setFlag(dbManager.getString(resultSet,10));
            prpLclaimGradetgDto.setConfigPara(dbManager.getString(resultSet,11));
            prpLclaimGradetgDto.setConfigDesc(dbManager.getString(resultSet,12));
            collection.add(prpLclaimGradetgDto);
        }
        resultSet.close();
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
            throws Exception{
        return findByConditions(conditions,0,0);
    }

    /**
     * ������ɾ������
     * @param conditions ��ѯ����
     * @return ɾ��������
     * @throws Exception
     */
    public int deleteByConditions(String conditions)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLclaimGradetg WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        int count = dbManager.executeUpdate(buffer.toString());
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
        StringBuffer buffer = new StringBuffer(100);
       String statement ;
          statement = "SELECT count(1) FROM PrpLclaimGradetg WHERE ";
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
