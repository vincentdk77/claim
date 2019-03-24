package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLmessageDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLmessage������ת�������Ա�����ݷ��ʶ������<br>
 * ������ 2005-03-18 17:53:37.671<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLmessageBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log logger = LogFactory.getLog(DBPrpLmessageBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLmessageBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpLmessageDto prpLmessageDto
     * @throws Exception
     */
    public void insert(PrpLmessageDto prpLmessageDto) throws Exception{
        String mainStatement = " Insert Into PrpLmessage (" + 
                           " RegistNo," + 
                           " SerialNo," + 
                           " LineNo," + 
                           " ClaimNo," + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " NodeType," + 
                           " InputDate," + 
                           " OperatorCode," + 
                           " OperatorName," + 
                           " Context," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLmessageDto.getRegistNo() + "'," + 
                           "" + prpLmessageDto.getSerialNo() + "," + 
                           "" + prpLmessageDto.getLineNo() + "," + 
                           "'" + prpLmessageDto.getClaimNo() + "'," + 
                           "'" + prpLmessageDto.getRiskCode() + "'," + 
                           "'" + prpLmessageDto.getPolicyNo() + "'," + 
                           "'" + prpLmessageDto.getNodeType() + "'," + 
                           "'" + prpLmessageDto.getInputDate() + "'," + 
                           "'" + prpLmessageDto.getOperatorCode() + "'," + 
                           "'" + prpLmessageDto.getOperatorName() + "'," + 
                           "'" + prpLmessageDto.getContext() + "'," + 
                           "'" + prpLmessageDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLmessageDto.getRegistNo());
        dbManager.setInt(2,prpLmessageDto.getSerialNo());
        dbManager.setInt(3,prpLmessageDto.getLineNo());
        dbManager.setString(4,prpLmessageDto.getClaimNo());
        dbManager.setString(5,prpLmessageDto.getRiskCode());
        dbManager.setString(6,prpLmessageDto.getPolicyNo());
        dbManager.setString(7,prpLmessageDto.getNodeType());
        dbManager.setDateTime(8,prpLmessageDto.getInputDate());
        dbManager.setString(9,prpLmessageDto.getOperatorCode());
        dbManager.setString(10,prpLmessageDto.getOperatorName());
        dbManager.setString(11,prpLmessageDto.getContext());
        dbManager.setString(12,prpLmessageDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLmessageBase.insert() success!");
    }

    /**
     * ��������ʽ�����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLmessage (" + 
                           " RegistNo," + 
                           " SerialNo," + 
                           " LineNo," + 
                           " ClaimNo," + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " NodeType," + 
                           " InputDate," + 
                           " OperatorCode," + 
                           " OperatorName," + 
                           " Context," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLmessageDto prpLmessageDto = (PrpLmessageDto)i.next();
            dbManager.setString(1,prpLmessageDto.getRegistNo());
            dbManager.setInt(2,prpLmessageDto.getSerialNo());
            dbManager.setInt(3,prpLmessageDto.getLineNo());
            dbManager.setString(4,prpLmessageDto.getClaimNo());
            dbManager.setString(5,prpLmessageDto.getRiskCode());
            dbManager.setString(6,prpLmessageDto.getPolicyNo());
            dbManager.setString(7,prpLmessageDto.getNodeType());
            dbManager.setDateTime(8,prpLmessageDto.getInputDate());
            dbManager.setString(9,prpLmessageDto.getOperatorCode());
            dbManager.setString(10,prpLmessageDto.getOperatorName());
            dbManager.setString(11,prpLmessageDto.getContext());
            dbManager.setString(12,prpLmessageDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLmessageBase.insertAll() success!");
    }

    /**
     * ������ɾ��һ������
     * @param registNo ��������
     * @param serialNo ���
     * @param lineNo �к�
     * @throws Exception
     */
    public void delete(String registNo,int serialNo,int lineNo) throws Exception{
        String statement = " Delete From PrpLmessage" + 
	            		   " Where " +
                           " RegistNo = ? And " + 
                           " SerialNo = ? And " + 
                           " LineNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLmessage Where " +
                           " RegistNo = '" + registNo + "' And " + 
                           " SerialNo = " + serialNo + " And " + 
                           " LineNo = " + lineNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,registNo);
        dbManager.setInt(2,serialNo);
        dbManager.setInt(3,lineNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLmessageBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpLmessageDto prpLmessageDto
     * @throws Exception
     */
    public void update(PrpLmessageDto prpLmessageDto) throws Exception{
        String statement = " Update PrpLmessage Set ClaimNo = ?," + 
                           " RiskCode = ?," + 
                           " PolicyNo = ?," + 
                           " NodeType = ?," + 
                           " InputDate = ?," + 
                           " OperatorCode = ?," + 
                           " OperatorName = ?," + 
                           " Context = ?," + 
                           " Flag = ?" + 
	            		   " Where " +
                           " RegistNo = ? And " + 
                           " SerialNo = ? And " + 
                           " LineNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLmessage Set " + 
                           " RegistNo = '" + prpLmessageDto.getRegistNo() + "'," + 
                           " SerialNo = " + prpLmessageDto.getSerialNo() + "," + 
                           " LineNo = " + prpLmessageDto.getLineNo() + "," + 
                           " ClaimNo = '" + prpLmessageDto.getClaimNo() + "'," + 
                           " RiskCode = '" + prpLmessageDto.getRiskCode() + "'," + 
                           " PolicyNo = '" + prpLmessageDto.getPolicyNo() + "'," + 
                           " NodeType = '" + prpLmessageDto.getNodeType() + "'," + 
                           " InputDate = '" + prpLmessageDto.getInputDate() + "'," + 
                           " OperatorCode = '" + prpLmessageDto.getOperatorCode() + "'," + 
                           " OperatorName = '" + prpLmessageDto.getOperatorName() + "'," + 
                           " Context = '" + prpLmessageDto.getContext() + "'," + 
                           " Flag = '" + prpLmessageDto.getFlag() + "'" + 
			               " Where " +
                           " RegistNo = '" + prpLmessageDto.getRegistNo() + "' And " + 
                           " SerialNo = " + prpLmessageDto.getSerialNo() + " And " + 
                           " LineNo = " + prpLmessageDto.getLineNo() + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpLmessageDto.getClaimNo());
        dbManager.setString(2,prpLmessageDto.getRiskCode());
        dbManager.setString(3,prpLmessageDto.getPolicyNo());
        dbManager.setString(4,prpLmessageDto.getNodeType());
        dbManager.setDateTime(5,prpLmessageDto.getInputDate());
        dbManager.setString(6,prpLmessageDto.getOperatorCode());
        dbManager.setString(7,prpLmessageDto.getOperatorName());
        dbManager.setString(8,prpLmessageDto.getContext());
        dbManager.setString(9,prpLmessageDto.getFlag());
        //���������ֶ�;
        dbManager.setString(10,prpLmessageDto.getRegistNo());
        dbManager.setInt(11,prpLmessageDto.getSerialNo());
        dbManager.setInt(12,prpLmessageDto.getLineNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLmessageBase.update() success!");
    }

    /**
     * ����������һ������
     * @param registNo ��������
     * @param serialNo ���
     * @param lineNo �к�
     * @return PrpLmessageDto
     * @throws Exception
     */
    public PrpLmessageDto findByPrimaryKey(String registNo,int serialNo,int lineNo) throws Exception{
        String mainStatement = " Select RegistNo," + 
                           " SerialNo," + 
                           " LineNo," + 
                           " ClaimNo," + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " NodeType," + 
                           " InputDate," + 
                           " OperatorCode," + 
                           " OperatorName," + 
                           " Context," + 
                           " Flag From PrpLmessage";
        String statement = mainStatement + " Where " +
                           " RegistNo = ? And " + 
                           " SerialNo = ? And " + 
                           " LineNo = ?";
        PrpLmessageDto prpLmessageDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " RegistNo = '" + registNo + "' And " + 
                           " SerialNo = " + serialNo + " And " + 
                           " LineNo = " + lineNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,registNo);
        dbManager.setInt(2,serialNo);
        dbManager.setInt(3,lineNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLmessageDto = new PrpLmessageDto();
            prpLmessageDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLmessageDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpLmessageDto.setLineNo(dbManager.getInt(resultSet,3));
            prpLmessageDto.setClaimNo(dbManager.getString(resultSet,4));
            prpLmessageDto.setRiskCode(dbManager.getString(resultSet,5));
            prpLmessageDto.setPolicyNo(dbManager.getString(resultSet,6));
            prpLmessageDto.setNodeType(dbManager.getString(resultSet,7));
            prpLmessageDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,8));
            prpLmessageDto.setOperatorCode(dbManager.getString(resultSet,9));
            prpLmessageDto.setOperatorName(dbManager.getString(resultSet,10));
            prpLmessageDto.setContext(dbManager.getString(resultSet,11));
            prpLmessageDto.setFlag(dbManager.getString(resultSet,12));
            logger.info("DBPrpLmessageBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLmessageBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLmessageDto;
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
        String statement = "Select RegistNo," + 
                           " SerialNo," + 
                           " LineNo," + 
                           " ClaimNo," + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " NodeType," + 
                           " InputDate," + 
                           " OperatorCode," + 
                           " OperatorName," + 
                           " Context," + 
                           " Flag From PrpLmessage Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLmessageDto prpLmessageDto = null;
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

            prpLmessageDto = new PrpLmessageDto();
            prpLmessageDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLmessageDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpLmessageDto.setLineNo(dbManager.getInt(resultSet,3));
            prpLmessageDto.setClaimNo(dbManager.getString(resultSet,4));
            prpLmessageDto.setRiskCode(dbManager.getString(resultSet,5));
            prpLmessageDto.setPolicyNo(dbManager.getString(resultSet,6));
            prpLmessageDto.setNodeType(dbManager.getString(resultSet,7));
            prpLmessageDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,8));
            prpLmessageDto.setOperatorCode(dbManager.getString(resultSet,9));
            prpLmessageDto.setOperatorName(dbManager.getString(resultSet,10));
            prpLmessageDto.setContext(dbManager.getString(resultSet,11));
            prpLmessageDto.setFlag(dbManager.getString(resultSet,12));
            collection.add(prpLmessageDto);
        }
        resultSet.close();
        logger.info("DBPrpLmessageBase.findByConditions() success!");
        return collection;
    }
    /**
     * ��������ѯ��������(�������Ľӿ�ʹ�ã�������������Ϊ(yyyy-mm-dd hh24:mi:ss))
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions1(String conditions,int pageNo,int rowsPerPage) throws Exception{
        String statement = "Select RegistNo," + 
                           " SerialNo," + 
                           " LineNo," + 
                           " ClaimNo," + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " NodeType," + 
                           " InputDate," + 
                           " OperatorCode," + 
                           " OperatorName," + 
                           " Context," + 
                           " Flag From PrpLmessage Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLmessageDto prpLmessageDto = null;
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

            prpLmessageDto = new PrpLmessageDto();
            prpLmessageDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLmessageDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpLmessageDto.setLineNo(dbManager.getInt(resultSet,3));
            prpLmessageDto.setClaimNo(dbManager.getString(resultSet,4));
            prpLmessageDto.setRiskCode(dbManager.getString(resultSet,5));
            prpLmessageDto.setPolicyNo(dbManager.getString(resultSet,6));
            prpLmessageDto.setNodeType(dbManager.getString(resultSet,7));
            prpLmessageDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,8));
            prpLmessageDto.setOperatorCode(dbManager.getString(resultSet,9));
            prpLmessageDto.setOperatorName(dbManager.getString(resultSet,10));
            prpLmessageDto.setContext(dbManager.getString(resultSet,11));
            prpLmessageDto.setFlag(dbManager.getString(resultSet,12));
            collection.add(prpLmessageDto);
        }
        resultSet.close();
        logger.info("DBPrpLmessageBase.findByConditions() success!");
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
     * ��������ѯ��������(�������Ľӿ�ʹ�ã�������������Ϊ(yyyy-mm-dd hh24:mi:ss))
     * @param conditions ��ѯ����
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions1(String conditions) throws Exception{
        return findByConditions1(conditions,0,0);
    }

    /**
     * ������ɾ������
     * @param conditions ��ѯ����
     * @return ɾ��������
     * @throws Exception
     */
    public int deleteByConditions(String conditions) throws Exception{
        String statement = "Delete From PrpLmessage Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLmessageBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLmessage Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLmessageBase.getCount() success!");
        return count;
    }
}
