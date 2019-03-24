package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcertifyCollectDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpLcertifyCollect����֤�ռ������ݷ��ʶ������<br>
 * ������ 2006-06-06 08:45:59.531<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLcertifyCollectBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Log logger = LogFactory.getLog(DBPrpLcertifyCollectBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLcertifyCollectBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpLcertifyCollectDto prpLcertifyCollectDto
     * @throws Exception
     */
    public void insert(PrpLcertifyCollectDto prpLcertifyCollectDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLcertifyCollect (");
        buffer.append("BusinessNo,");
        buffer.append("LossItemCode,");
        buffer.append("LossItemName,");
        buffer.append("PicCount,");
        buffer.append("StartDate,");
        buffer.append("StartHour,");
        buffer.append("EndDate,");
        buffer.append("EndHour,");
        buffer.append("OperatorCode,");
        buffer.append("CollectFlag,");
        buffer.append("CltInsureCarFlag,");
        buffer.append("CltThirdCarFlag,");
        buffer.append("CltPersonFlag,");
        buffer.append("CltPropFlag,");
        buffer.append("CltCarLossFlag,");
        buffer.append("CltAllLossFlag,");
        buffer.append("CaseFlag,");
        buffer.append("Content,");
        buffer.append("Flag,");
        buffer.append("PolicyNo,");
        buffer.append("RiskCode,");
        buffer.append("UploadYear,");
        buffer.append("CompelFlag ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLcertifyCollectDto.getBusinessNo()).append("',");
            debugBuffer.append("'").append(prpLcertifyCollectDto.getLossItemCode()).append("',");
            debugBuffer.append("'").append(prpLcertifyCollectDto.getLossItemName()).append("',");
            debugBuffer.append("").append(prpLcertifyCollectDto.getPicCount()).append(",");
            debugBuffer.append("'").append(prpLcertifyCollectDto.getStartDate()).append("',");
            debugBuffer.append("'").append(prpLcertifyCollectDto.getStartHour()).append("',");
            debugBuffer.append("'").append(prpLcertifyCollectDto.getEndDate()).append("',");
            debugBuffer.append("'").append(prpLcertifyCollectDto.getEndHour()).append("',");
            debugBuffer.append("'").append(prpLcertifyCollectDto.getOperatorCode()).append("',");
            debugBuffer.append("'").append(prpLcertifyCollectDto.getCollectFlag()).append("',");
            debugBuffer.append("'").append(prpLcertifyCollectDto.getCltInsureCarFlag()).append("',");
            debugBuffer.append("'").append(prpLcertifyCollectDto.getCltThirdCarFlag()).append("',");
            debugBuffer.append("'").append(prpLcertifyCollectDto.getCltPersonFlag()).append("',");
            debugBuffer.append("'").append(prpLcertifyCollectDto.getCltPropFlag()).append("',");
            debugBuffer.append("'").append(prpLcertifyCollectDto.getCltCarLossFlag()).append("',");
            debugBuffer.append("'").append(prpLcertifyCollectDto.getCltAllLossFlag()).append("',");
            debugBuffer.append("'").append(prpLcertifyCollectDto.getCaseFlag()).append("',");
            debugBuffer.append("'").append(prpLcertifyCollectDto.getContent()).append("',");
            debugBuffer.append("'").append(prpLcertifyCollectDto.getFlag()).append("',");
            debugBuffer.append("'").append(prpLcertifyCollectDto.getPolicyNo()).append("',");
            debugBuffer.append("'").append(prpLcertifyCollectDto.getRiskCode()).append("',");
            debugBuffer.append("'").append(prpLcertifyCollectDto.getUploadYear()).append("',");
            debugBuffer.append("'").append(prpLcertifyCollectDto.getCompelFlag()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLcertifyCollectDto.getBusinessNo());
        dbManager.setString(2,prpLcertifyCollectDto.getLossItemCode());
        dbManager.setString(3,prpLcertifyCollectDto.getLossItemName());
        dbManager.setInt(4,prpLcertifyCollectDto.getPicCount());
        dbManager.setDateTime(5,prpLcertifyCollectDto.getStartDate());
        dbManager.setString(6,prpLcertifyCollectDto.getStartHour());
        dbManager.setDateTime(7,prpLcertifyCollectDto.getEndDate());
        dbManager.setString(8,prpLcertifyCollectDto.getEndHour());
        dbManager.setString(9,prpLcertifyCollectDto.getOperatorCode());
        dbManager.setString(10,prpLcertifyCollectDto.getCollectFlag());
        dbManager.setString(11,prpLcertifyCollectDto.getCltInsureCarFlag());
        dbManager.setString(12,prpLcertifyCollectDto.getCltThirdCarFlag());
        dbManager.setString(13,prpLcertifyCollectDto.getCltPersonFlag());
        dbManager.setString(14,prpLcertifyCollectDto.getCltPropFlag());
        dbManager.setString(15,prpLcertifyCollectDto.getCltCarLossFlag());
        dbManager.setString(16,prpLcertifyCollectDto.getCltAllLossFlag());
        dbManager.setString(17,prpLcertifyCollectDto.getCaseFlag());
        dbManager.setString(18,prpLcertifyCollectDto.getContent());
        dbManager.setString(19,prpLcertifyCollectDto.getFlag());
        dbManager.setString(20,prpLcertifyCollectDto.getPolicyNo());
        dbManager.setString(21,prpLcertifyCollectDto.getRiskCode());
        dbManager.setString(22,prpLcertifyCollectDto.getUploadYear());
        dbManager.setString(23,prpLcertifyCollectDto.getCompelFlag());
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
        buffer.append("INSERT INTO PrpLcertifyCollect (");
        buffer.append("BusinessNo,");
        buffer.append("LossItemCode,");
        buffer.append("LossItemName,");
        buffer.append("PicCount,");
        buffer.append("StartDate,");
        buffer.append("StartHour,");
        buffer.append("EndDate,");
        buffer.append("EndHour,");
        buffer.append("OperatorCode,");
        buffer.append("CollectFlag,");
        buffer.append("CltInsureCarFlag,");
        buffer.append("CltThirdCarFlag,");
        buffer.append("CltPersonFlag,");
        buffer.append("CltPropFlag,");
        buffer.append("CltCarLossFlag,");
        buffer.append("CltAllLossFlag,");
        buffer.append("CaseFlag,");
        buffer.append("Content,");
        buffer.append("Flag,");
        buffer.append("PolicyNo,");
        buffer.append("RiskCode,");
        buffer.append("UploadYear,");
        buffer.append("CompelFlag ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLcertifyCollectDto prpLcertifyCollectDto = (PrpLcertifyCollectDto)i.next();
            dbManager.setString(1,prpLcertifyCollectDto.getBusinessNo());
            dbManager.setString(2,prpLcertifyCollectDto.getLossItemCode());
            dbManager.setString(3,prpLcertifyCollectDto.getLossItemName());
            dbManager.setInt(4,prpLcertifyCollectDto.getPicCount());
            dbManager.setDateTime(5,prpLcertifyCollectDto.getStartDate());
            dbManager.setString(6,prpLcertifyCollectDto.getStartHour());
            dbManager.setDateTime(7,prpLcertifyCollectDto.getEndDate());
            dbManager.setString(8,prpLcertifyCollectDto.getEndHour());
            dbManager.setString(9,prpLcertifyCollectDto.getOperatorCode());
            dbManager.setString(10,prpLcertifyCollectDto.getCollectFlag());
            dbManager.setString(11,prpLcertifyCollectDto.getCltInsureCarFlag());
            dbManager.setString(12,prpLcertifyCollectDto.getCltThirdCarFlag());
            dbManager.setString(13,prpLcertifyCollectDto.getCltPersonFlag());
            dbManager.setString(14,prpLcertifyCollectDto.getCltPropFlag());
            dbManager.setString(15,prpLcertifyCollectDto.getCltCarLossFlag());
            dbManager.setString(16,prpLcertifyCollectDto.getCltAllLossFlag());
            dbManager.setString(17,prpLcertifyCollectDto.getCaseFlag());
            dbManager.setString(18,prpLcertifyCollectDto.getContent());
            dbManager.setString(19,prpLcertifyCollectDto.getFlag());
            dbManager.setString(20,prpLcertifyCollectDto.getPolicyNo());
            dbManager.setString(21,prpLcertifyCollectDto.getRiskCode());
            dbManager.setString(22,prpLcertifyCollectDto.getUploadYear());
            dbManager.setString(23,prpLcertifyCollectDto.getCompelFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param businessNo ҵ�����
     * @param lossItemCode ��Ĵ���
     * @throws Exception
     */
    public void delete(String businessNo,String lossItemCode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLcertifyCollect ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("BusinessNo=").append("'").append(businessNo).append("' AND ");
            debugBuffer.append("LossItemCode=").append("'").append(lossItemCode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("BusinessNo = ? And ");
        buffer.append("LossItemCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,businessNo);
        dbManager.setString(2,lossItemCode);
        dbManager.executePreparedUpdate();
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpLcertifyCollectDto prpLcertifyCollectDto
     * @throws Exception
     */
    public void update(PrpLcertifyCollectDto prpLcertifyCollectDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLcertifyCollect SET ");
        buffer.append("LossItemName = ?, ");
        buffer.append("PicCount = ?, ");
        buffer.append("StartDate = ?, ");
        buffer.append("StartHour = ?, ");
        buffer.append("EndDate = ?, ");
        buffer.append("EndHour = ?, ");
        buffer.append("OperatorCode = ?, ");
        buffer.append("CollectFlag = ?, ");
        buffer.append("CltInsureCarFlag = ?, ");
        buffer.append("CltThirdCarFlag = ?, ");
        buffer.append("CltPersonFlag = ?, ");
        buffer.append("CltPropFlag = ?, ");
        buffer.append("CltCarLossFlag = ?, ");
        buffer.append("CltAllLossFlag = ?, ");
        buffer.append("CaseFlag = ?, ");
        buffer.append("Content = ?, ");
        buffer.append("Flag = ?, ");
        buffer.append("PolicyNo = ?, ");
        buffer.append("RiskCode = ?, ");
        buffer.append("UploadYear = ?, ");
        buffer.append("CompelFlag = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLcertifyCollect SET ");
            debugBuffer.append("LossItemName = '" + prpLcertifyCollectDto.getLossItemName() + "', ");
            debugBuffer.append("PicCount = " + prpLcertifyCollectDto.getPicCount() + ", ");
            debugBuffer.append("StartDate = '" + prpLcertifyCollectDto.getStartDate() + "', ");
            debugBuffer.append("StartHour = '" + prpLcertifyCollectDto.getStartHour() + "', ");
            debugBuffer.append("EndDate = '" + prpLcertifyCollectDto.getEndDate() + "', ");
            debugBuffer.append("EndHour = '" + prpLcertifyCollectDto.getEndHour() + "', ");
            debugBuffer.append("OperatorCode = '" + prpLcertifyCollectDto.getOperatorCode() + "', ");
            debugBuffer.append("CollectFlag = '" + prpLcertifyCollectDto.getCollectFlag() + "', ");
            debugBuffer.append("CltInsureCarFlag = '" + prpLcertifyCollectDto.getCltInsureCarFlag() + "', ");
            debugBuffer.append("CltThirdCarFlag = '" + prpLcertifyCollectDto.getCltThirdCarFlag() + "', ");
            debugBuffer.append("CltPersonFlag = '" + prpLcertifyCollectDto.getCltPersonFlag() + "', ");
            debugBuffer.append("CltPropFlag = '" + prpLcertifyCollectDto.getCltPropFlag() + "', ");
            debugBuffer.append("CltCarLossFlag = '" + prpLcertifyCollectDto.getCltCarLossFlag() + "', ");
            debugBuffer.append("CltAllLossFlag = '" + prpLcertifyCollectDto.getCltAllLossFlag() + "', ");
            debugBuffer.append("CaseFlag = '" + prpLcertifyCollectDto.getCaseFlag() + "', ");
            debugBuffer.append("Content = '" + prpLcertifyCollectDto.getContent() + "', ");
            debugBuffer.append("Flag = '" + prpLcertifyCollectDto.getFlag() + "', ");
            debugBuffer.append("PolicyNo = '" + prpLcertifyCollectDto.getPolicyNo() + "', ");
            debugBuffer.append("RiskCode = '" + prpLcertifyCollectDto.getRiskCode() + "', ");
            debugBuffer.append("UploadYear = '" + prpLcertifyCollectDto.getUploadYear() + "', ");
            debugBuffer.append("CompelFlag = '" + prpLcertifyCollectDto.getCompelFlag() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("BusinessNo=").append("'").append(prpLcertifyCollectDto.getBusinessNo()).append("' AND ");
            debugBuffer.append("LossItemCode=").append("'").append(prpLcertifyCollectDto.getLossItemCode()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("BusinessNo = ? And ");
        buffer.append("LossItemCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setString(1,prpLcertifyCollectDto.getLossItemName());
        dbManager.setInt(2,prpLcertifyCollectDto.getPicCount());
        dbManager.setDateTime(3,prpLcertifyCollectDto.getStartDate());
        dbManager.setString(4,prpLcertifyCollectDto.getStartHour());
        dbManager.setDateTime(5,prpLcertifyCollectDto.getEndDate());
        dbManager.setString(6,prpLcertifyCollectDto.getEndHour());
        dbManager.setString(7,prpLcertifyCollectDto.getOperatorCode());
        dbManager.setString(8,prpLcertifyCollectDto.getCollectFlag());
        dbManager.setString(9,prpLcertifyCollectDto.getCltInsureCarFlag());
        dbManager.setString(10,prpLcertifyCollectDto.getCltThirdCarFlag());
        dbManager.setString(11,prpLcertifyCollectDto.getCltPersonFlag());
        dbManager.setString(12,prpLcertifyCollectDto.getCltPropFlag());
        dbManager.setString(13,prpLcertifyCollectDto.getCltCarLossFlag());
        dbManager.setString(14,prpLcertifyCollectDto.getCltAllLossFlag());
        dbManager.setString(15,prpLcertifyCollectDto.getCaseFlag());
        dbManager.setString(16,prpLcertifyCollectDto.getContent());
        dbManager.setString(17,prpLcertifyCollectDto.getFlag());
        dbManager.setString(18,prpLcertifyCollectDto.getPolicyNo());
        dbManager.setString(19,prpLcertifyCollectDto.getRiskCode());
        dbManager.setString(20,prpLcertifyCollectDto.getUploadYear());
        dbManager.setString(21,prpLcertifyCollectDto.getCompelFlag());
        //���������ֶ�;
        dbManager.setString(22,prpLcertifyCollectDto.getBusinessNo());
        dbManager.setString(23,prpLcertifyCollectDto.getLossItemCode());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param businessNo ҵ�����
     * @param lossItemCode ��Ĵ���
     * @return PrpLcertifyCollectDto
     * @throws Exception
     */
    public PrpLcertifyCollectDto findByPrimaryKey(String businessNo,String lossItemCode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("BusinessNo,");
        buffer.append("LossItemCode,");
        buffer.append("LossItemName,");
        buffer.append("PicCount,");
        buffer.append("StartDate,");
        buffer.append("StartHour,");
        buffer.append("EndDate,");
        buffer.append("EndHour,");
        buffer.append("OperatorCode,");
        buffer.append("CollectFlag,");
        buffer.append("CltInsureCarFlag,");
        buffer.append("CltThirdCarFlag,");
        buffer.append("CltPersonFlag,");
        buffer.append("CltPropFlag,");
        buffer.append("CltCarLossFlag,");
        buffer.append("CltAllLossFlag,");
        buffer.append("CaseFlag,");
        buffer.append("Content,");
        buffer.append("Flag,");
        buffer.append("PolicyNo,");
        buffer.append("RiskCode,");
        buffer.append("UploadYear,");
        buffer.append("CompelFlag ");
        buffer.append("FROM PrpLcertifyCollect ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("BusinessNo=").append("'").append(businessNo).append("' AND ");
            debugBuffer.append("LossItemCode=").append("'").append(lossItemCode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("BusinessNo = ? And ");
        buffer.append("LossItemCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,businessNo);
        dbManager.setString(2,lossItemCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLcertifyCollectDto prpLcertifyCollectDto = null;
        if(resultSet.next()){
            prpLcertifyCollectDto = new PrpLcertifyCollectDto();
            prpLcertifyCollectDto.setBusinessNo(dbManager.getString(resultSet,1));
            prpLcertifyCollectDto.setLossItemCode(dbManager.getString(resultSet,2));
            prpLcertifyCollectDto.setLossItemName(dbManager.getString(resultSet,3));
            prpLcertifyCollectDto.setPicCount(dbManager.getInt(resultSet,4));
            prpLcertifyCollectDto.setStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,5));
            prpLcertifyCollectDto.setStartHour(dbManager.getString(resultSet,6));
            prpLcertifyCollectDto.setEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,7));
            prpLcertifyCollectDto.setEndHour(dbManager.getString(resultSet,8));
            prpLcertifyCollectDto.setOperatorCode(dbManager.getString(resultSet,9));
            prpLcertifyCollectDto.setCollectFlag(dbManager.getString(resultSet,10));
            prpLcertifyCollectDto.setCltInsureCarFlag(dbManager.getString(resultSet,11));
            prpLcertifyCollectDto.setCltThirdCarFlag(dbManager.getString(resultSet,12));
            prpLcertifyCollectDto.setCltPersonFlag(dbManager.getString(resultSet,13));
            prpLcertifyCollectDto.setCltPropFlag(dbManager.getString(resultSet,14));
            prpLcertifyCollectDto.setCltCarLossFlag(dbManager.getString(resultSet,15));
            prpLcertifyCollectDto.setCltAllLossFlag(dbManager.getString(resultSet,16));
            prpLcertifyCollectDto.setCaseFlag(dbManager.getString(resultSet,17));
            prpLcertifyCollectDto.setContent(dbManager.getString(resultSet,18));
            prpLcertifyCollectDto.setFlag(dbManager.getString(resultSet,19));
            prpLcertifyCollectDto.setPolicyNo(dbManager.getString(resultSet,20));
            prpLcertifyCollectDto.setRiskCode(dbManager.getString(resultSet,21));
            prpLcertifyCollectDto.setUploadYear(dbManager.getString(resultSet,22));
            prpLcertifyCollectDto.setCompelFlag(dbManager.getString(resultSet,23));
        }
        resultSet.close();
        return prpLcertifyCollectDto;
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
        buffer.append("BusinessNo,");
        buffer.append("LossItemCode,");
        buffer.append("LossItemName,");
        buffer.append("PicCount,");
        buffer.append("StartDate,");
        buffer.append("StartHour,");
        buffer.append("EndDate,");
        buffer.append("EndHour,");
        buffer.append("OperatorCode,");
        buffer.append("CollectFlag,");
        buffer.append("CltInsureCarFlag,");
        buffer.append("CltThirdCarFlag,");
        buffer.append("CltPersonFlag,");
        buffer.append("CltPropFlag,");
        buffer.append("CltCarLossFlag,");
        buffer.append("CltAllLossFlag,");
        buffer.append("CaseFlag,");
        buffer.append("Content,");
        buffer.append("Flag,");
        buffer.append("PolicyNo,");
        buffer.append("RiskCode,");
        buffer.append("UploadYear,");
        buffer.append("CompelFlag ");
        buffer.append("FROM PrpLcertifyCollect WHERE ");
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
        PrpLcertifyCollectDto prpLcertifyCollectDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLcertifyCollectDto = new PrpLcertifyCollectDto();
            prpLcertifyCollectDto.setBusinessNo(dbManager.getString(resultSet,1));
            prpLcertifyCollectDto.setLossItemCode(dbManager.getString(resultSet,2));
            prpLcertifyCollectDto.setLossItemName(dbManager.getString(resultSet,3));
            prpLcertifyCollectDto.setPicCount(dbManager.getInt(resultSet,4));
            prpLcertifyCollectDto.setStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,5));
            prpLcertifyCollectDto.setStartHour(dbManager.getString(resultSet,6));
            prpLcertifyCollectDto.setEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,7));
            prpLcertifyCollectDto.setEndHour(dbManager.getString(resultSet,8));
            prpLcertifyCollectDto.setOperatorCode(dbManager.getString(resultSet,9));
            prpLcertifyCollectDto.setCollectFlag(dbManager.getString(resultSet,10));
            prpLcertifyCollectDto.setCltInsureCarFlag(dbManager.getString(resultSet,11));
            prpLcertifyCollectDto.setCltThirdCarFlag(dbManager.getString(resultSet,12));
            prpLcertifyCollectDto.setCltPersonFlag(dbManager.getString(resultSet,13));
            prpLcertifyCollectDto.setCltPropFlag(dbManager.getString(resultSet,14));
            prpLcertifyCollectDto.setCltCarLossFlag(dbManager.getString(resultSet,15));
            prpLcertifyCollectDto.setCltAllLossFlag(dbManager.getString(resultSet,16));
            prpLcertifyCollectDto.setCaseFlag(dbManager.getString(resultSet,17));
            prpLcertifyCollectDto.setContent(dbManager.getString(resultSet,18));
            prpLcertifyCollectDto.setFlag(dbManager.getString(resultSet,19));
            prpLcertifyCollectDto.setPolicyNo(dbManager.getString(resultSet,20));
            prpLcertifyCollectDto.setRiskCode(dbManager.getString(resultSet,21));
            prpLcertifyCollectDto.setUploadYear(dbManager.getString(resultSet,22));
            prpLcertifyCollectDto.setCompelFlag(dbManager.getString(resultSet,23));
            collection.add(prpLcertifyCollectDto);
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
        buffer.append("DELETE FROM PrpLcertifyCollect WHERE ");
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
          statement = "SELECT count(1) FROM PrpLcertifyCollect WHERE ";
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
