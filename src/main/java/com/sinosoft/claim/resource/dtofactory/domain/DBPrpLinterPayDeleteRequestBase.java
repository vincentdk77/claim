package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterPayDeleteRequestDto;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLINTERPAYDELETEQUEST�����ݷ��ʶ������<br>
 * ������ 2015-08-25 10:04:44.593<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLinterPayDeleteRequestBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrpLinterPayDeleteRequestBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLinterPayDeleteRequestBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param pRPLINTERPAYDELETEQUESTDto pRPLINTERPAYDELETEQUESTDto
     * @throws Exception
     */
    public void insert(PrpLinterPayDeleteRequestDto pRPLINTERPAYDELETEQUESTDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PRPLINTERPAYDELETEQUEST (");
        buffer.append("outId,");
        buffer.append("operatorCode,");
        buffer.append("operatorName,");
        buffer.append("makeCom,");
        buffer.append("makeComName,");
        buffer.append("operatorDate,");
        buffer.append("handleText, ");
        buffer.append("autoFlag ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(pRPLINTERPAYDELETEQUESTDto.getOutId()).append("',");
            debugBuffer.append("'").append(pRPLINTERPAYDELETEQUESTDto.getOperatorCode()).append("',");
            debugBuffer.append("'").append(pRPLINTERPAYDELETEQUESTDto.getOperatorName()).append("',");
            debugBuffer.append("'").append(pRPLINTERPAYDELETEQUESTDto.getMakeCom()).append("',");
            debugBuffer.append("'").append(pRPLINTERPAYDELETEQUESTDto.getMakeComName()).append("',");
            debugBuffer.append("'").append(pRPLINTERPAYDELETEQUESTDto.getOperatorDate()).append("',");
            debugBuffer.append("'").append(pRPLINTERPAYDELETEQUESTDto.getHandleText()).append("',");
            debugBuffer.append("'").append(pRPLINTERPAYDELETEQUESTDto.getAutoFlag()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,pRPLINTERPAYDELETEQUESTDto.getOutId());
        dbManager.setString(2,pRPLINTERPAYDELETEQUESTDto.getOperatorCode());
        dbManager.setString(3,pRPLINTERPAYDELETEQUESTDto.getOperatorName());
        dbManager.setString(4,pRPLINTERPAYDELETEQUESTDto.getMakeCom());
        dbManager.setString(5,pRPLINTERPAYDELETEQUESTDto.getMakeComName());
        dbManager.setDateTime(6,pRPLINTERPAYDELETEQUESTDto.getOperatorDate());
        dbManager.setString(7,pRPLINTERPAYDELETEQUESTDto.getHandleText());
        dbManager.setString(8,pRPLINTERPAYDELETEQUESTDto.getAutoFlag());
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
        buffer.append("INSERT INTO PRPLINTERPAYDELETEQUEST (");
        buffer.append("outId,");
        buffer.append("operatorCode,");
        buffer.append("operatorName,");
        buffer.append("makeCom,");
        buffer.append("makeComName,");
        buffer.append("operatorDate,");
        buffer.append("handleText, ");
        buffer.append("autoFlag ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLinterPayDeleteRequestDto pRPLINTERPAYDELETEQUESTDto = (PrpLinterPayDeleteRequestDto)i.next();
            dbManager.setString(1,pRPLINTERPAYDELETEQUESTDto.getOutId());
            dbManager.setString(2,pRPLINTERPAYDELETEQUESTDto.getOperatorCode());
            dbManager.setString(3,pRPLINTERPAYDELETEQUESTDto.getOperatorName());
            dbManager.setString(4,pRPLINTERPAYDELETEQUESTDto.getMakeCom());
            dbManager.setString(5,pRPLINTERPAYDELETEQUESTDto.getMakeComName());
            dbManager.setDateTime(6,pRPLINTERPAYDELETEQUESTDto.getOperatorDate());
            dbManager.setString(7,pRPLINTERPAYDELETEQUESTDto.getHandleText());
            dbManager.setString(8,pRPLINTERPAYDELETEQUESTDto.getAutoFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param outId �ͻ�������
     * @throws Exception
     */
    public void delete(String outId)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PRPLINTERPAYDELETEQUEST ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("outId=").append("'").append(outId).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("outId = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,outId);
        dbManager.executePreparedUpdate();
    }

    /**
     * ����������һ������(���������޷����)
     * @param pRPLINTERPAYDELETEQUESTDto pRPLINTERPAYDELETEQUESTDto
     * @throws Exception
     */
    public void update(PrpLinterPayDeleteRequestDto pRPLINTERPAYDELETEQUESTDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PRPLINTERPAYDELETEQUEST SET ");
        buffer.append("operatorCode = ?, ");
        buffer.append("operatorName = ?, ");
        buffer.append("makeCom = ?, ");
        buffer.append("makeComName = ?, ");
        buffer.append("operatorDate = ?, ");
        buffer.append("handleText = ?, ");
        buffer.append("autoFlag = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PRPLINTERPAYDELETEQUEST SET ");
            debugBuffer.append("operatorCode = '" + pRPLINTERPAYDELETEQUESTDto.getOperatorCode() + "', ");
            debugBuffer.append("operatorName = '" + pRPLINTERPAYDELETEQUESTDto.getOperatorName() + "', ");
            debugBuffer.append("makeCom = '" + pRPLINTERPAYDELETEQUESTDto.getMakeCom() + "', ");
            debugBuffer.append("makeComName = '" + pRPLINTERPAYDELETEQUESTDto.getMakeComName() + "', ");
            debugBuffer.append("operatorDate = '" + pRPLINTERPAYDELETEQUESTDto.getOperatorDate() + "', ");
            debugBuffer.append("handleText = '" + pRPLINTERPAYDELETEQUESTDto.getHandleText() + "', ");
            debugBuffer.append("autoFlag = '" + pRPLINTERPAYDELETEQUESTDto.getAutoFlag() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("outId=").append("'").append(pRPLINTERPAYDELETEQUESTDto.getOutId()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("outId = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setString(1,pRPLINTERPAYDELETEQUESTDto.getOperatorCode());
        dbManager.setString(2,pRPLINTERPAYDELETEQUESTDto.getOperatorName());
        dbManager.setString(3,pRPLINTERPAYDELETEQUESTDto.getMakeCom());
        dbManager.setString(4,pRPLINTERPAYDELETEQUESTDto.getMakeComName());
        dbManager.setDateTime(5,pRPLINTERPAYDELETEQUESTDto.getOperatorDate());
        dbManager.setString(6,pRPLINTERPAYDELETEQUESTDto.getHandleText());
        dbManager.setString(7,pRPLINTERPAYDELETEQUESTDto.getAutoFlag());
        //���������ֶ�;
        dbManager.setString(8,pRPLINTERPAYDELETEQUESTDto.getOutId());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param outId �ͻ�������
     * @return PRPLINTERPAYDELETEQUESTDto
     * @throws Exception
     */
    public PrpLinterPayDeleteRequestDto findByPrimaryKey(String outId)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("outId,");
        buffer.append("operatorCode,");
        buffer.append("operatorName,");
        buffer.append("makeCom,");
        buffer.append("makeComName,");
        buffer.append("operatorDate,");
        buffer.append("handleText, ");
        buffer.append("autoflag ");
        buffer.append("FROM PRPLINTERPAYDELETEQUEST ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("outId=").append("'").append(outId).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("outId = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,outId);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLinterPayDeleteRequestDto pRPLINTERPAYDELETEQUESTDto = null;
        if(resultSet.next()){
            pRPLINTERPAYDELETEQUESTDto = new PrpLinterPayDeleteRequestDto();
            pRPLINTERPAYDELETEQUESTDto.setOutId(dbManager.getString(resultSet,1));
            pRPLINTERPAYDELETEQUESTDto.setOperatorCode(dbManager.getString(resultSet,2));
            pRPLINTERPAYDELETEQUESTDto.setOperatorName(dbManager.getString(resultSet,3));
            pRPLINTERPAYDELETEQUESTDto.setMakeCom(dbManager.getString(resultSet,4));
            pRPLINTERPAYDELETEQUESTDto.setMakeComName(dbManager.getString(resultSet,5));
            pRPLINTERPAYDELETEQUESTDto.setOperatorDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,6));
            pRPLINTERPAYDELETEQUESTDto.setHandleText(dbManager.getString(resultSet,7));
            pRPLINTERPAYDELETEQUESTDto.setAutoFlag(dbManager.getString(resultSet,8));
        }
        resultSet.close();
        return pRPLINTERPAYDELETEQUESTDto;
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
        buffer.append("outId,");
        buffer.append("operatorCode,");
        buffer.append("operatorName,");
        buffer.append("makeCom,");
        buffer.append("makeComName,");
        buffer.append("operatorDate,");
        buffer.append("handleText, ");
        buffer.append("autoFlag ");
        buffer.append("FROM PRPLINTERPAYDELETEQUEST WHERE ");
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
        PrpLinterPayDeleteRequestDto pRPLINTERPAYDELETEQUESTDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            pRPLINTERPAYDELETEQUESTDto = new PrpLinterPayDeleteRequestDto();
            pRPLINTERPAYDELETEQUESTDto.setOutId(dbManager.getString(resultSet,1));
            pRPLINTERPAYDELETEQUESTDto.setOperatorCode(dbManager.getString(resultSet,2));
            pRPLINTERPAYDELETEQUESTDto.setOperatorName(dbManager.getString(resultSet,3));
            pRPLINTERPAYDELETEQUESTDto.setMakeCom(dbManager.getString(resultSet,4));
            pRPLINTERPAYDELETEQUESTDto.setMakeComName(dbManager.getString(resultSet,5));
            pRPLINTERPAYDELETEQUESTDto.setOperatorDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,6));
            pRPLINTERPAYDELETEQUESTDto.setHandleText(dbManager.getString(resultSet,7));
            pRPLINTERPAYDELETEQUESTDto.setAutoFlag(dbManager.getString(resultSet,8));
            collection.add(pRPLINTERPAYDELETEQUESTDto);
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
        buffer.append("DELETE FROM PRPLINTERPAYDELETEQUEST WHERE ");
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
        buffer.append("SELECT count(1) FROM PRPLINTERPAYDELETEQUEST WHERE ");
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
