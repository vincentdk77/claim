package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLFirstVeriOpinionDto;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ���ǳ������������ݷ��ʶ������<br>
 * ������ 2013-07-25 15:19:04.633<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLFirstVeriOpinionBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrpLFirstVeriOpinionBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLFirstVeriOpinionBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpLFirstVeriOpinionDto prpLFirstVeriOpinionDto
     * @throws Exception
     */
    public void insert(PrpLFirstVeriOpinionDto prpLFirstVeriOpinionDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLFirstVeriOpinion (");
        buffer.append("RegistNo,");
        buffer.append("CompensateBz,");
        buffer.append("CompensateBi,");
        buffer.append("AccidentType,");
        buffer.append("OccReason,");
        buffer.append("AccommodType,");
        buffer.append("RecoveryType,");
        buffer.append("PeifuFlag,");
        buffer.append("PeifuType,");
        buffer.append("LingjieAnFlag,");
        buffer.append("LingjieAnType,");
        buffer.append("SuggestionType,");
        buffer.append("NodeType,");
        buffer.append("PeifuIns, ");
        buffer.append("fraudLogo, ");
        buffer.append("fraudRecoverAmount, ");
        buffer.append("fraudType ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLFirstVeriOpinionDto.getRegistNo()).append("',");
            debugBuffer.append("'").append(prpLFirstVeriOpinionDto.getCompensateBz()).append("',");
            debugBuffer.append("'").append(prpLFirstVeriOpinionDto.getCompensateBi()).append("',");
            debugBuffer.append("'").append(prpLFirstVeriOpinionDto.getAccidentType()).append("',");
            debugBuffer.append("'").append(prpLFirstVeriOpinionDto.getOccReason()).append("',");
            debugBuffer.append("'").append(prpLFirstVeriOpinionDto.getAccommodType()).append("',");
            debugBuffer.append("'").append(prpLFirstVeriOpinionDto.getRecoveryType()).append("',");
            debugBuffer.append("'").append(prpLFirstVeriOpinionDto.getPeifuFlag()).append("',");
            debugBuffer.append("'").append(prpLFirstVeriOpinionDto.getPeifuType()).append("',");
            debugBuffer.append("'").append(prpLFirstVeriOpinionDto.getLingjieAnFlag()).append("',");
            debugBuffer.append("'").append(prpLFirstVeriOpinionDto.getLingjieAnType()).append("',");
            debugBuffer.append("'").append(prpLFirstVeriOpinionDto.getSuggestionType()).append("',");
            debugBuffer.append("'").append(prpLFirstVeriOpinionDto.getNodeType()).append("',");
            debugBuffer.append("'").append(prpLFirstVeriOpinionDto.getPeifuIns()).append("',");
            debugBuffer.append("'").append(prpLFirstVeriOpinionDto.getFraudLogo()).append("',");
            debugBuffer.append("'").append(prpLFirstVeriOpinionDto.getFraudRecoverAmount()).append("',");
            debugBuffer.append("'").append(prpLFirstVeriOpinionDto.getFraudType()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLFirstVeriOpinionDto.getRegistNo());
        dbManager.setString(2,prpLFirstVeriOpinionDto.getCompensateBz());
        dbManager.setString(3,prpLFirstVeriOpinionDto.getCompensateBi());
        dbManager.setString(4,prpLFirstVeriOpinionDto.getAccidentType());
        dbManager.setString(5,prpLFirstVeriOpinionDto.getOccReason());
        dbManager.setString(6,prpLFirstVeriOpinionDto.getAccommodType());
        dbManager.setString(7,prpLFirstVeriOpinionDto.getRecoveryType());
        dbManager.setString(8,prpLFirstVeriOpinionDto.getPeifuFlag());
        dbManager.setString(9,prpLFirstVeriOpinionDto.getPeifuType());
        dbManager.setString(10,prpLFirstVeriOpinionDto.getLingjieAnFlag());
        dbManager.setString(11,prpLFirstVeriOpinionDto.getLingjieAnType());
        dbManager.setString(12,prpLFirstVeriOpinionDto.getSuggestionType());
        dbManager.setString(13,prpLFirstVeriOpinionDto.getNodeType());
        dbManager.setString(14,prpLFirstVeriOpinionDto.getPeifuIns());
        dbManager.setString(15,prpLFirstVeriOpinionDto.getFraudLogo());
        dbManager.setDouble(16,prpLFirstVeriOpinionDto.getFraudRecoverAmount());
        dbManager.setString(17,prpLFirstVeriOpinionDto.getFraudType());
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
        buffer.append("INSERT INTO PrpLFirstVeriOpinion (");
        buffer.append("RegistNo,");
        buffer.append("CompensateBz,");
        buffer.append("CompensateBi,");
        buffer.append("AccidentType,");
        buffer.append("OccReason,");
        buffer.append("AccommodType,");
        buffer.append("RecoveryType,");
        buffer.append("PeifuFlag,");
        buffer.append("PeifuType,");
        buffer.append("LingjieAnFlag,");
        buffer.append("LingjieAnType,");
        buffer.append("SuggestionType,");
        buffer.append("NodeType,");
        buffer.append("PeifuIns, ");
        buffer.append("fraudLogo, ");
        buffer.append("fraudRecoverAmount, ");
        buffer.append("fraudType ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLFirstVeriOpinionDto prpLFirstVeriOpinionDto = (PrpLFirstVeriOpinionDto)i.next();
            dbManager.setString(1,prpLFirstVeriOpinionDto.getRegistNo());
            dbManager.setString(2,prpLFirstVeriOpinionDto.getCompensateBz());
            dbManager.setString(3,prpLFirstVeriOpinionDto.getCompensateBi());
            dbManager.setString(4,prpLFirstVeriOpinionDto.getAccidentType());
            dbManager.setString(5,prpLFirstVeriOpinionDto.getOccReason());
            dbManager.setString(6,prpLFirstVeriOpinionDto.getAccommodType());
            dbManager.setString(7,prpLFirstVeriOpinionDto.getRecoveryType());
            dbManager.setString(8,prpLFirstVeriOpinionDto.getPeifuFlag());
            dbManager.setString(9,prpLFirstVeriOpinionDto.getPeifuType());
            dbManager.setString(10,prpLFirstVeriOpinionDto.getLingjieAnFlag());
            dbManager.setString(11,prpLFirstVeriOpinionDto.getLingjieAnType());
            dbManager.setString(12,prpLFirstVeriOpinionDto.getSuggestionType());
            dbManager.setString(13,prpLFirstVeriOpinionDto.getNodeType());
            dbManager.setString(14,prpLFirstVeriOpinionDto.getPeifuIns());
            dbManager.setString(15,prpLFirstVeriOpinionDto.getFraudLogo());
            dbManager.setDouble(16,prpLFirstVeriOpinionDto.getFraudRecoverAmount());
            dbManager.setString(17,prpLFirstVeriOpinionDto.getFraudType());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param registNo ������
     * @throws Exception
     */
    public void delete(String registNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLFirstVeriOpinion ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("RegistNo=").append("'").append(registNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("RegistNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,registNo);
        dbManager.executePreparedUpdate();
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpLFirstVeriOpinionDto prpLFirstVeriOpinionDto
     * @throws Exception
     */
    public void update(PrpLFirstVeriOpinionDto prpLFirstVeriOpinionDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLFirstVeriOpinion SET ");
        buffer.append("CompensateBz = ?, ");
        buffer.append("CompensateBi = ?, ");
        buffer.append("AccidentType = ?, ");
        buffer.append("OccReason = ?, ");
        buffer.append("AccommodType = ?, ");
        buffer.append("RecoveryType = ?, ");
        buffer.append("PeifuFlag = ?, ");
        buffer.append("PeifuType = ?, ");
        buffer.append("LingjieAnFlag = ?, ");
        buffer.append("LingjieAnType = ?, ");
        buffer.append("SuggestionType = ?, ");
        buffer.append("NodeType = ?, ");
        buffer.append("PeifuIns = ?, ");
        buffer.append("fraudLogo = ?, ");
        buffer.append("fraudRecoverAmount = ?, ");
        buffer.append("fraudType = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLFirstVeriOpinion SET ");
            debugBuffer.append("CompensateBz = '" + prpLFirstVeriOpinionDto.getCompensateBz() + "', ");
            debugBuffer.append("CompensateBi = '" + prpLFirstVeriOpinionDto.getCompensateBi() + "', ");
            debugBuffer.append("AccidentType = '" + prpLFirstVeriOpinionDto.getAccidentType() + "', ");
            debugBuffer.append("OccReason = '" + prpLFirstVeriOpinionDto.getOccReason() + "', ");
            debugBuffer.append("AccommodType = '" + prpLFirstVeriOpinionDto.getAccommodType() + "', ");
            debugBuffer.append("RecoveryType = '" + prpLFirstVeriOpinionDto.getRecoveryType() + "', ");
            debugBuffer.append("PeifuFlag = '" + prpLFirstVeriOpinionDto.getPeifuFlag() + "', ");
            debugBuffer.append("PeifuType = '" + prpLFirstVeriOpinionDto.getPeifuType() + "', ");
            debugBuffer.append("LingjieAnFlag = '" + prpLFirstVeriOpinionDto.getLingjieAnFlag() + "', ");
            debugBuffer.append("LingjieAnType = '" + prpLFirstVeriOpinionDto.getLingjieAnType() + "', ");
            debugBuffer.append("SuggestionType = '" + prpLFirstVeriOpinionDto.getSuggestionType() + "', ");
            debugBuffer.append("NodeType = '" + prpLFirstVeriOpinionDto.getNodeType() + "', ");
            debugBuffer.append("PeifuIns = '" + prpLFirstVeriOpinionDto.getPeifuIns() + "', ");
            debugBuffer.append("fraudLogo = '" + prpLFirstVeriOpinionDto.getFraudLogo() + "', ");
            debugBuffer.append("fraudRecoverAmount = " + prpLFirstVeriOpinionDto.getFraudRecoverAmount() + ", ");
            debugBuffer.append("fraudType = '" + prpLFirstVeriOpinionDto.getFraudType() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("RegistNo=").append("'").append(prpLFirstVeriOpinionDto.getRegistNo()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("RegistNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setString(1,prpLFirstVeriOpinionDto.getCompensateBz());
        dbManager.setString(2,prpLFirstVeriOpinionDto.getCompensateBi());
        dbManager.setString(3,prpLFirstVeriOpinionDto.getAccidentType());
        dbManager.setString(4,prpLFirstVeriOpinionDto.getOccReason());
        dbManager.setString(5,prpLFirstVeriOpinionDto.getAccommodType());
        dbManager.setString(6,prpLFirstVeriOpinionDto.getRecoveryType());
        dbManager.setString(7,prpLFirstVeriOpinionDto.getPeifuFlag());
        dbManager.setString(8,prpLFirstVeriOpinionDto.getPeifuType());
        dbManager.setString(9,prpLFirstVeriOpinionDto.getLingjieAnFlag());
        dbManager.setString(10,prpLFirstVeriOpinionDto.getLingjieAnType());
        dbManager.setString(11,prpLFirstVeriOpinionDto.getSuggestionType());
        dbManager.setString(12,prpLFirstVeriOpinionDto.getNodeType());
        dbManager.setString(13,prpLFirstVeriOpinionDto.getPeifuIns());
        dbManager.setString(14,prpLFirstVeriOpinionDto.getFraudLogo());
        dbManager.setDouble(15,prpLFirstVeriOpinionDto.getFraudRecoverAmount());
        dbManager.setString(16,prpLFirstVeriOpinionDto.getFraudType());
        //���������ֶ�;
        dbManager.setString(17,prpLFirstVeriOpinionDto.getRegistNo());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param registNo ������
     * @return PrpLFirstVeriOpinionDto
     * @throws Exception
     */
    public PrpLFirstVeriOpinionDto findByPrimaryKey(String registNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("RegistNo,");
        buffer.append("CompensateBz,");
        buffer.append("CompensateBi,");
        buffer.append("AccidentType,");
        buffer.append("OccReason,");
        buffer.append("AccommodType,");
        buffer.append("RecoveryType,");
        buffer.append("PeifuFlag,");
        buffer.append("PeifuType,");
        buffer.append("LingjieAnFlag,");
        buffer.append("LingjieAnType,");
        buffer.append("SuggestionType,");
        buffer.append("nodeType,");
        buffer.append("PeifuIns,");
        buffer.append("fraudlogo,");
        buffer.append("fraudRecoverAmount,");
        buffer.append("fraudType ");
        buffer.append("FROM PrpLFirstVeriOpinion ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("RegistNo=").append("'").append(registNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("RegistNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,registNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLFirstVeriOpinionDto prpLFirstVeriOpinionDto = null;
        if(resultSet.next()){
            prpLFirstVeriOpinionDto = new PrpLFirstVeriOpinionDto();
            prpLFirstVeriOpinionDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLFirstVeriOpinionDto.setCompensateBz(dbManager.getString(resultSet,2));
            prpLFirstVeriOpinionDto.setCompensateBi(dbManager.getString(resultSet,3));
            prpLFirstVeriOpinionDto.setAccidentType(dbManager.getString(resultSet,4));
            prpLFirstVeriOpinionDto.setOccReason(dbManager.getString(resultSet,5));
            prpLFirstVeriOpinionDto.setAccommodType(dbManager.getString(resultSet,6));
            prpLFirstVeriOpinionDto.setRecoveryType(dbManager.getString(resultSet,7));
            prpLFirstVeriOpinionDto.setPeifuFlag(dbManager.getString(resultSet,8));
            prpLFirstVeriOpinionDto.setPeifuType(dbManager.getString(resultSet,9));
            prpLFirstVeriOpinionDto.setLingjieAnFlag(dbManager.getString(resultSet,10));
            prpLFirstVeriOpinionDto.setLingjieAnType(dbManager.getString(resultSet,11));
            prpLFirstVeriOpinionDto.setSuggestionType(dbManager.getString(resultSet,12));
            prpLFirstVeriOpinionDto.setNodeType(dbManager.getString(resultSet,13));
            prpLFirstVeriOpinionDto.setPeifuIns(dbManager.getString(resultSet,14));
            prpLFirstVeriOpinionDto.setFraudLogo(dbManager.getString(resultSet,15));
            prpLFirstVeriOpinionDto.setFraudRecoverAmount(dbManager.getDouble(resultSet,16));
            prpLFirstVeriOpinionDto.setFraudType(dbManager.getString(resultSet,17));
        }
        resultSet.close();
        return prpLFirstVeriOpinionDto;
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
        buffer.append("RegistNo,");
        buffer.append("CompensateBz,");
        buffer.append("CompensateBi,");
        buffer.append("AccidentType,");
        buffer.append("OccReason,");
        buffer.append("AccommodType,");
        buffer.append("RecoveryType,");
        buffer.append("PeifuFlag,");
        buffer.append("PeifuType,");
        buffer.append("LingjieAnFlag,");
        buffer.append("LingjieAnType,");
        buffer.append("SuggestionType,");
        buffer.append("nodeType,");
        buffer.append("PeifuIns,");
        buffer.append("fraudlogo,");
        buffer.append("fraudRecoverAmount,");
        buffer.append("fraudType ");
        buffer.append("FROM PrpLFirstVeriOpinion WHERE ");
        buffer.append(conditions);
        boolean supportPaging = false;//���ݿ��Ƿ�֧�ַ�ҳ
        if (pageNo > 0){
            //Ŀǰֻ��Oracle�Ż�
            if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("Oracle")){
                buffer.insert(0,"SELECT * FROM ( SELECT row_.*, rownum rownum_ FROM (");
                buffer.append(") row_ WHERE rownum <= "+rowsPerPage * pageNo+") WHERE rownum_ > "+rowsPerPage * (pageNo - 1));
                supportPaging=true;
            }
        }
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        int count=0;
        if(supportPaging==false && pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        //���巵�ؽ������
        Collection collection = new ArrayList(rowsPerPage);
        PrpLFirstVeriOpinionDto prpLFirstVeriOpinionDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLFirstVeriOpinionDto = new PrpLFirstVeriOpinionDto();
            prpLFirstVeriOpinionDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLFirstVeriOpinionDto.setCompensateBz(dbManager.getString(resultSet,2));
            prpLFirstVeriOpinionDto.setCompensateBi(dbManager.getString(resultSet,3));
            prpLFirstVeriOpinionDto.setAccidentType(dbManager.getString(resultSet,4));
            prpLFirstVeriOpinionDto.setOccReason(dbManager.getString(resultSet,5));
            prpLFirstVeriOpinionDto.setAccommodType(dbManager.getString(resultSet,6));
            prpLFirstVeriOpinionDto.setRecoveryType(dbManager.getString(resultSet,7));
            prpLFirstVeriOpinionDto.setPeifuFlag(dbManager.getString(resultSet,8));
            prpLFirstVeriOpinionDto.setPeifuType(dbManager.getString(resultSet,9));
            prpLFirstVeriOpinionDto.setLingjieAnFlag(dbManager.getString(resultSet,10));
            prpLFirstVeriOpinionDto.setLingjieAnType(dbManager.getString(resultSet,11));
            prpLFirstVeriOpinionDto.setSuggestionType(dbManager.getString(resultSet,12));
            prpLFirstVeriOpinionDto.setNodeType(dbManager.getString(resultSet,13));
            prpLFirstVeriOpinionDto.setPeifuIns(dbManager.getString(resultSet,14));
            prpLFirstVeriOpinionDto.setFraudLogo(dbManager.getString(resultSet,15));
            prpLFirstVeriOpinionDto.setFraudRecoverAmount(dbManager.getDouble(resultSet,16));
            prpLFirstVeriOpinionDto.setFraudType(dbManager.getString(resultSet,17));
            collection.add(prpLFirstVeriOpinionDto);
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
        buffer.append("DELETE FROM PrpLFirstVeriOpinion WHERE ");
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
        buffer.append("SELECT count(1) FROM (SELECT * FROM PrpLFirstVeriOpinion WHERE ");
        buffer.append(conditions);
        buffer.append(")");
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
