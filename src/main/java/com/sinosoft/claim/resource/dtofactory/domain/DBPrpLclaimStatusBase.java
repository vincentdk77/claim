package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLclaimStatus-����ڵ�״̬��(����)�����ݷ��ʶ������<br>
 * ������ 2005-03-18 17:53:37.640<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLclaimStatusBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log logger = LogFactory.getLog(DBPrpLclaimStatusBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLclaimStatusBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpLclaimStatusDto prpLclaimStatusDto
     * @throws Exception
     */
    public void insert(PrpLclaimStatusDto prpLclaimStatusDto) throws Exception{
        String mainStatement = " Insert Into PrpLclaimStatus (" + 
                           " BusinessNo," + 
                           " PolicyNo," + 
                           " NodeType," + 
                           " SerialNo," + 
                           " RiskCode," + 
                           " Status," + 
                           " FlowID," + 
                           " HandlerCode," + 
                           " InputDate," + 
                           " OperateDate," + 
                           " TypeFlag," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLclaimStatusDto.getBusinessNo() + "'," + 
                           "'" + prpLclaimStatusDto.getPolicyNo() + "'," + 
                           "'" + prpLclaimStatusDto.getNodeType() + "'," + 
                           "" + prpLclaimStatusDto.getSerialNo() + "," + 
                           "'" + prpLclaimStatusDto.getRiskCode() + "'," + 
                           "'" + prpLclaimStatusDto.getStatus() + "'," + 
                           "'" + prpLclaimStatusDto.getFlowID() + "'," + 
                           "'" + prpLclaimStatusDto.getHandlerCode() + "'," + 
                           "'" + prpLclaimStatusDto.getInputDate() + "'," + 
                           "'" + prpLclaimStatusDto.getOperateDate() + "'," + 
                           "'" + prpLclaimStatusDto.getTypeFlag() + "'," + 
                           "'" + prpLclaimStatusDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLclaimStatusDto.getBusinessNo());
        dbManager.setString(2,prpLclaimStatusDto.getPolicyNo());
        dbManager.setString(3,prpLclaimStatusDto.getNodeType());
        dbManager.setInt(4,prpLclaimStatusDto.getSerialNo());
        dbManager.setString(5,prpLclaimStatusDto.getRiskCode());
        dbManager.setString(6,prpLclaimStatusDto.getStatus());
        dbManager.setString(7,prpLclaimStatusDto.getFlowID());
        dbManager.setString(8,prpLclaimStatusDto.getHandlerCode());
        dbManager.setDateTime(9,prpLclaimStatusDto.getInputDate());
        dbManager.setDateTime(10,prpLclaimStatusDto.getOperateDate());
        dbManager.setString(11,prpLclaimStatusDto.getTypeFlag());
        dbManager.setString(12,prpLclaimStatusDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLclaimStatusBase.insert() success!");
    }

    /**
     * ��������ʽ�����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLclaimStatus (" + 
                           " BusinessNo," + 
                           " PolicyNo," + 
                           " NodeType," + 
                           " SerialNo," + 
                           " RiskCode," + 
                           " Status," + 
                           " FlowID," + 
                           " HandlerCode," + 
                           " InputDate," + 
                           " OperateDate," + 
                           " TypeFlag," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLclaimStatusDto prpLclaimStatusDto = (PrpLclaimStatusDto)i.next();
            dbManager.setString(1,prpLclaimStatusDto.getBusinessNo());
            dbManager.setString(2,prpLclaimStatusDto.getPolicyNo());
            dbManager.setString(3,prpLclaimStatusDto.getNodeType());
            dbManager.setInt(4,prpLclaimStatusDto.getSerialNo());
            dbManager.setString(5,prpLclaimStatusDto.getRiskCode());
            dbManager.setString(6,prpLclaimStatusDto.getStatus());
            dbManager.setString(7,prpLclaimStatusDto.getFlowID());
            dbManager.setString(8,prpLclaimStatusDto.getHandlerCode());
            dbManager.setDateTime(9,prpLclaimStatusDto.getInputDate());
            dbManager.setDateTime(10,prpLclaimStatusDto.getOperateDate());
            dbManager.setString(11,prpLclaimStatusDto.getTypeFlag());
            dbManager.setString(12,prpLclaimStatusDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLclaimStatusBase.insertAll() success!");
    }

    /**
     * ������ɾ��һ������
     * @param businessNo ҵ���
     * @param nodeType �ڵ�����
     * @param serialNo ���к���
     * @throws Exception
     */
    public void delete(String businessNo,String nodeType,int serialNo) throws Exception{
        String statement = " Delete From PrpLclaimStatus" + 
	            		   " Where " +
                           " BusinessNo = ? And " + 
                           " NodeType = ? And " + 
                           " SerialNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLclaimStatus Where " +
                           " BusinessNo = '" + businessNo + "' And " + 
                           " NodeType = '" + nodeType + "' And " + 
                           " SerialNo = " + serialNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,businessNo);
        dbManager.setString(2,nodeType);
        dbManager.setInt(3,serialNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLclaimStatusBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpLclaimStatusDto prpLclaimStatusDto
     * @throws Exception
     */
    public void update(PrpLclaimStatusDto prpLclaimStatusDto) throws Exception{
        String statement = " Update PrpLclaimStatus Set PolicyNo = ?," + 
                           " RiskCode = ?," + 
                           " Status = ?," + 
                           " FlowID = ?," + 
                           " HandlerCode = ?," + 
                           " InputDate = ?," + 
                           " OperateDate = ?," + 
                           " TypeFlag = ?," + 
                           " Flag = ?" + 
	            		   " Where " +
                           " BusinessNo = ? And " + 
                           " NodeType = ? And " + 
                           " SerialNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLclaimStatus Set " + 
                           " BusinessNo = '" + prpLclaimStatusDto.getBusinessNo() + "'," + 
                           " PolicyNo = '" + prpLclaimStatusDto.getPolicyNo() + "'," + 
                           " NodeType = '" + prpLclaimStatusDto.getNodeType() + "'," + 
                           " SerialNo = " + prpLclaimStatusDto.getSerialNo() + "," + 
                           " RiskCode = '" + prpLclaimStatusDto.getRiskCode() + "'," + 
                           " Status = '" + prpLclaimStatusDto.getStatus() + "'," + 
                           " FlowID = '" + prpLclaimStatusDto.getFlowID() + "'," + 
                           " HandlerCode = '" + prpLclaimStatusDto.getHandlerCode() + "'," + 
                           " InputDate = '" + prpLclaimStatusDto.getInputDate() + "'," + 
                           " OperateDate = '" + prpLclaimStatusDto.getOperateDate() + "'," + 
                           " TypeFlag = '" + prpLclaimStatusDto.getTypeFlag() + "'," + 
                           " Flag = '" + prpLclaimStatusDto.getFlag() + "'" + 
			               " Where " +
                           " BusinessNo = '" + prpLclaimStatusDto.getBusinessNo() + "' And " + 
                           " NodeType = '" + prpLclaimStatusDto.getNodeType() + "' And " + 
                           " SerialNo = " + prpLclaimStatusDto.getSerialNo() + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpLclaimStatusDto.getPolicyNo());
        dbManager.setString(2,prpLclaimStatusDto.getRiskCode());
        dbManager.setString(3,prpLclaimStatusDto.getStatus());
        dbManager.setString(4,prpLclaimStatusDto.getFlowID());
        dbManager.setString(5,prpLclaimStatusDto.getHandlerCode());
        dbManager.setDateTime(6,prpLclaimStatusDto.getInputDate());
        dbManager.setDateTime(7,prpLclaimStatusDto.getOperateDate());
        dbManager.setString(8,prpLclaimStatusDto.getTypeFlag());
        dbManager.setString(9,prpLclaimStatusDto.getFlag());
        //���������ֶ�;
        dbManager.setString(10,prpLclaimStatusDto.getBusinessNo());
        dbManager.setString(11,prpLclaimStatusDto.getNodeType());
        dbManager.setInt(12,prpLclaimStatusDto.getSerialNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLclaimStatusBase.update() success!");
    }

    /**
     * ����������һ������
     * @param businessNo ҵ���
     * @param nodeType �ڵ�����
     * @param serialNo ���к���
     * @return PrpLclaimStatusDto
     * @throws Exception
     */
    public PrpLclaimStatusDto findByPrimaryKey(String businessNo,String nodeType,int serialNo) throws Exception{
        String mainStatement = " Select BusinessNo," + 
                           " PolicyNo," + 
                           " NodeType," + 
                           " SerialNo," + 
                           " RiskCode," + 
                           " Status," + 
                           " FlowID," + 
                           " HandlerCode," + 
                           " InputDate," + 
                           " OperateDate," + 
                           " TypeFlag," + 
                           " Flag From PrpLclaimStatus";
        String statement = mainStatement + " Where " +
                           " BusinessNo = ? And " + 
                           " NodeType = ? And " + 
                           " SerialNo = ?";
        PrpLclaimStatusDto prpLclaimStatusDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " BusinessNo = '" + businessNo + "' And " + 
                           " NodeType = '" + nodeType + "' And " + 
                           " SerialNo = " + serialNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,businessNo);
        dbManager.setString(2,nodeType);
        dbManager.setInt(3,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLclaimStatusDto = new PrpLclaimStatusDto();
            prpLclaimStatusDto.setBusinessNo(dbManager.getString(resultSet,1));
            prpLclaimStatusDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpLclaimStatusDto.setNodeType(dbManager.getString(resultSet,3));
            prpLclaimStatusDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpLclaimStatusDto.setRiskCode(dbManager.getString(resultSet,5));
            prpLclaimStatusDto.setStatus(dbManager.getString(resultSet,6));
            prpLclaimStatusDto.setFlowID(dbManager.getString(resultSet,7));
            prpLclaimStatusDto.setHandlerCode(dbManager.getString(resultSet,8));
            prpLclaimStatusDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,9));
            prpLclaimStatusDto.setOperateDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,10));
            prpLclaimStatusDto.setTypeFlag(dbManager.getString(resultSet,11));
            prpLclaimStatusDto.setFlag(dbManager.getString(resultSet,12));
            logger.info("DBPrpLclaimStatusBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLclaimStatusBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLclaimStatusDto;
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
        String statement = "Select BusinessNo," + 
                           " PolicyNo," + 
                           " NodeType," + 
                           " SerialNo," + 
                           " RiskCode," + 
                           " Status," + 
                           " FlowID," + 
                           " HandlerCode," + 
                           " InputDate," + 
                           " OperateDate," + 
                           " TypeFlag," + 
                           " Flag From PrpLclaimStatus Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLclaimStatusDto prpLclaimStatusDto = null;
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

            prpLclaimStatusDto = new PrpLclaimStatusDto();
            prpLclaimStatusDto.setBusinessNo(dbManager.getString(resultSet,1));
            prpLclaimStatusDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpLclaimStatusDto.setNodeType(dbManager.getString(resultSet,3));
            prpLclaimStatusDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpLclaimStatusDto.setRiskCode(dbManager.getString(resultSet,5));
            prpLclaimStatusDto.setStatus(dbManager.getString(resultSet,6));
            prpLclaimStatusDto.setFlowID(dbManager.getString(resultSet,7));
            prpLclaimStatusDto.setHandlerCode(dbManager.getString(resultSet,8));
            prpLclaimStatusDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,9));
            prpLclaimStatusDto.setOperateDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,10));
            prpLclaimStatusDto.setTypeFlag(dbManager.getString(resultSet,11));
            prpLclaimStatusDto.setFlag(dbManager.getString(resultSet,12));
            collection.add(prpLclaimStatusDto);
        }
        resultSet.close();
        logger.info("DBPrpLclaimStatusBase.findByConditions() success!");
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
        String statement = "Delete From PrpLclaimStatus Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLclaimStatusBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLclaimStatus Where " + conditions;
        statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLclaimStatusBase.getCount() success!");
        return count;
    }
}
