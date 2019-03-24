package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpJthirdBankMappingDto;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpJthirdBankMapping�����ݷ��ʶ������<br>
 * ������ 2014-08-18 19:51:22.968<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpJthirdBankMappingBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrpJthirdBankMappingBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpJthirdBankMappingBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpJthirdBankMappingDto prpJthirdBankMappingDto
     * @throws Exception
     */
    public void insert(PrpJthirdBankMappingDto prpJthirdBankMappingDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpJthirdBankMapping (");
        buffer.append("thirdType,");
        buffer.append("thirdbank,");
        buffer.append("gyBank,");
        buffer.append("validstatus,");
        buffer.append("reMark,");
        buffer.append("gyBankCode ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpJthirdBankMappingDto.getThirdType()).append("',");
            debugBuffer.append("'").append(prpJthirdBankMappingDto.getThirdbank()).append("',");
            debugBuffer.append("'").append(prpJthirdBankMappingDto.getGyBank()).append("',");
            debugBuffer.append("'").append(prpJthirdBankMappingDto.getValidstatus()).append("',");
            debugBuffer.append("'").append(prpJthirdBankMappingDto.getReMark()).append("',");
            debugBuffer.append("'").append(prpJthirdBankMappingDto.getGyBankCode()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpJthirdBankMappingDto.getThirdType());
        dbManager.setString(2,prpJthirdBankMappingDto.getThirdbank());
        dbManager.setString(3,prpJthirdBankMappingDto.getGyBank());
        dbManager.setString(4,prpJthirdBankMappingDto.getValidstatus());
        dbManager.setString(5,prpJthirdBankMappingDto.getReMark());
        dbManager.setString(6,prpJthirdBankMappingDto.getGyBankCode());
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
        buffer.append("INSERT INTO PrpJthirdBankMapping (");
        buffer.append("thirdType,");
        buffer.append("thirdbank,");
        buffer.append("gyBank,");
        buffer.append("validstatus,");
        buffer.append("reMark,");
        buffer.append("gyBankCode ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpJthirdBankMappingDto prpJthirdBankMappingDto = (PrpJthirdBankMappingDto)i.next();
            dbManager.setString(1,prpJthirdBankMappingDto.getThirdType());
            dbManager.setString(2,prpJthirdBankMappingDto.getThirdbank());
            dbManager.setString(3,prpJthirdBankMappingDto.getGyBank());
            dbManager.setString(4,prpJthirdBankMappingDto.getValidstatus());
            dbManager.setString(5,prpJthirdBankMappingDto.getReMark());
            dbManager.setString(6,prpJthirdBankMappingDto.getGyBankCode());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param thirdType thirdType
     * @throws Exception
     */
    public void delete(String thirdType)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpJthirdBankMapping ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("thirdType=").append("'").append(thirdType).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("thirdType = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,thirdType);
        dbManager.executePreparedUpdate();
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpJthirdBankMappingDto prpJthirdBankMappingDto
     * @throws Exception
     */
    public void update(PrpJthirdBankMappingDto prpJthirdBankMappingDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpJthirdBankMapping SET ");
        buffer.append("thirdbank = ?, ");
        buffer.append("gyBank = ?, ");
        buffer.append("validstatus = ?, ");
        buffer.append("reMark = ?, ");
        buffer.append("gyBankCode = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpJthirdBankMapping SET ");
            debugBuffer.append("thirdbank = '" + prpJthirdBankMappingDto.getThirdbank() + "', ");
            debugBuffer.append("gyBank = '" + prpJthirdBankMappingDto.getGyBank() + "', ");
            debugBuffer.append("validstatus = '" + prpJthirdBankMappingDto.getValidstatus() + "', ");
            debugBuffer.append("reMark = '" + prpJthirdBankMappingDto.getReMark() + "', ");
            debugBuffer.append("gyBankCode = '" + prpJthirdBankMappingDto.getGyBankCode() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("thirdType=").append("'").append(prpJthirdBankMappingDto.getThirdType()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("thirdType = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setString(1,prpJthirdBankMappingDto.getThirdbank());
        dbManager.setString(2,prpJthirdBankMappingDto.getGyBank());
        dbManager.setString(3,prpJthirdBankMappingDto.getValidstatus());
        dbManager.setString(4,prpJthirdBankMappingDto.getReMark());
        dbManager.setString(5,prpJthirdBankMappingDto.getGyBankCode());
        //���������ֶ�;
        dbManager.setString(6,prpJthirdBankMappingDto.getThirdType());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param thirdType thirdType
     * @return PrpJthirdBankMappingDto
     * @throws Exception
     */
    public PrpJthirdBankMappingDto findByPrimaryKey(String thirdType)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("thirdType,");
        buffer.append("thirdbank,");
        buffer.append("gyBank,");
        buffer.append("validstatus,");
        buffer.append("reMark,");
        buffer.append("gyBankCode ");
        buffer.append("FROM PrpJthirdBankMapping ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("thirdType=").append("'").append(thirdType).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("thirdType = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,thirdType);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpJthirdBankMappingDto prpJthirdBankMappingDto = null;
        if(resultSet.next()){
            prpJthirdBankMappingDto = new PrpJthirdBankMappingDto();
            prpJthirdBankMappingDto.setThirdType(dbManager.getString(resultSet,1));
            prpJthirdBankMappingDto.setThirdbank(dbManager.getString(resultSet,2));
            prpJthirdBankMappingDto.setGyBank(dbManager.getString(resultSet,3));
            prpJthirdBankMappingDto.setValidstatus(dbManager.getString(resultSet,4));
            prpJthirdBankMappingDto.setReMark(dbManager.getString(resultSet,5));
            prpJthirdBankMappingDto.setGyBankCode(dbManager.getString(resultSet,6));
        }
        resultSet.close();
        return prpJthirdBankMappingDto;
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
        buffer.append("thirdType,");
        buffer.append("thirdbank,");
        buffer.append("gyBank,");
        buffer.append("validstatus,");
        buffer.append("reMark,");
        buffer.append("gyBankCode ");
        buffer.append("FROM PrpJthirdBankMapping WHERE ");
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
        PrpJthirdBankMappingDto prpJthirdBankMappingDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpJthirdBankMappingDto = new PrpJthirdBankMappingDto();
            prpJthirdBankMappingDto.setThirdType(dbManager.getString(resultSet,1));
            prpJthirdBankMappingDto.setThirdbank(dbManager.getString(resultSet,2));
            prpJthirdBankMappingDto.setGyBank(dbManager.getString(resultSet,3));
            prpJthirdBankMappingDto.setValidstatus(dbManager.getString(resultSet,4));
            prpJthirdBankMappingDto.setReMark(dbManager.getString(resultSet,5));
            prpJthirdBankMappingDto.setGyBankCode(dbManager.getString(resultSet,6));
            collection.add(prpJthirdBankMappingDto);
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
        buffer.append("DELETE FROM PrpJthirdBankMapping WHERE ");
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
        buffer.append("SELECT count(1) FROM PrpJthirdBankMapping WHERE ");
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
