package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.MedicalInsuremainlistDto;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����Ͷ���嵥ͷ������ݷ��ʶ������<br>
 */
public class DBMedicalInsuremainlistBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBInsuremainlistBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBMedicalInsuremainlistBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param medicalInsuremainlistDto medicalInsuremainlistDto
     * @throws Exception
     */
    public void insert(MedicalInsuremainlistDto medicalInsuremainlistDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO MedicalInsuremainlist (");
        buffer.append("Inusrelistcode,");
        buffer.append("Classcode,");
        buffer.append("Riskcode,");
        buffer.append("Proposalno,");
        buffer.append("Policyno,");
        buffer.append("Validity,");
        buffer.append("Updatecode,");
        buffer.append("Updatedate,");
        buffer.append("Opcode,");
        buffer.append("Remark,");
        buffer.append("Starttime,");
        buffer.append("Endtime ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(medicalInsuremainlistDto.getInusreListCode()).append("',");
            debugBuffer.append("'").append(medicalInsuremainlistDto.getClassCode()).append("',");
            debugBuffer.append("'").append(medicalInsuremainlistDto.getRiskCode()).append("',");
            debugBuffer.append("'").append(medicalInsuremainlistDto.getProposalNo()).append("',");
            debugBuffer.append("'").append(medicalInsuremainlistDto.getPolicyNo()).append("',");
            debugBuffer.append("'").append(medicalInsuremainlistDto.getValidity()).append("',");
            debugBuffer.append("'").append(medicalInsuremainlistDto.getUpdateCode()).append("',");
            debugBuffer.append("'").append(medicalInsuremainlistDto.getUpdateDate()).append("',");
            debugBuffer.append("'").append(medicalInsuremainlistDto.getOpCode()).append("',");
            debugBuffer.append("'").append(medicalInsuremainlistDto.getReMark()).append("',");
            debugBuffer.append("'").append(medicalInsuremainlistDto.getStartTime()).append("',");
            debugBuffer.append("'").append(medicalInsuremainlistDto.getEndTime()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,medicalInsuremainlistDto.getInusreListCode());
        dbManager.setString(2,medicalInsuremainlistDto.getClassCode());
        dbManager.setString(3,medicalInsuremainlistDto.getRiskCode());
        dbManager.setString(4,medicalInsuremainlistDto.getProposalNo());
        dbManager.setString(5,medicalInsuremainlistDto.getPolicyNo());
        dbManager.setString(6,medicalInsuremainlistDto.getValidity());
        dbManager.setString(7,medicalInsuremainlistDto.getUpdateCode());
        dbManager.setDateTime(8,medicalInsuremainlistDto.getUpdateDate());
        dbManager.setString(9,medicalInsuremainlistDto.getOpCode());
        dbManager.setString(10,medicalInsuremainlistDto.getReMark());
        dbManager.setDateTime(11,medicalInsuremainlistDto.getStartTime());
        dbManager.setDateTime(12,medicalInsuremainlistDto.getEndTime());
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
        buffer.append("INSERT INTO MedicalInsuremainlist (");
        buffer.append("Inusrelistcode,");
        buffer.append("Classcode,");
        buffer.append("Riskcode,");
        buffer.append("Proposalno,");
        buffer.append("Policyno,");
        buffer.append("Validity,");
        buffer.append("Updatecode,");
        buffer.append("Updatedate,");
        buffer.append("Opcode,");
        buffer.append("Remark,");
        buffer.append("Starttime,");
        buffer.append("Endtime ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            MedicalInsuremainlistDto medicalInsuremainlistDto = (MedicalInsuremainlistDto)i.next();
            dbManager.setString(1,medicalInsuremainlistDto.getInusreListCode());
            dbManager.setString(2,medicalInsuremainlistDto.getClassCode());
            dbManager.setString(3,medicalInsuremainlistDto.getRiskCode());
            dbManager.setString(4,medicalInsuremainlistDto.getProposalNo());
            dbManager.setString(5,medicalInsuremainlistDto.getPolicyNo());
            dbManager.setString(6,medicalInsuremainlistDto.getValidity());
            dbManager.setString(7,medicalInsuremainlistDto.getUpdateCode());
            dbManager.setDateTime(8,medicalInsuremainlistDto.getUpdateDate());
            dbManager.setString(9,medicalInsuremainlistDto.getOpCode());
            dbManager.setString(10,medicalInsuremainlistDto.getReMark());
            dbManager.setDateTime(11,medicalInsuremainlistDto.getStartTime());
            dbManager.setDateTime(12,medicalInsuremainlistDto.getEndTime());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param inusrelistcode Ͷ���嵥���
     * @throws Exception
     */
    public void delete(String inusrelistcode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM MedicalInsuremainlist ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Inusrelistcode=").append("'").append(inusrelistcode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Inusrelistcode = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,inusrelistcode);
        dbManager.executePreparedUpdate();
    }

    /**
     * ����������һ������(���������޷����)
     * @param medicalInsuremainlistDto medicalInsuremainlistDto
     * @throws Exception
     */
    public void update(MedicalInsuremainlistDto medicalInsuremainlistDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE MedicalInsuremainlist SET ");
        buffer.append("Classcode = ?, ");
        buffer.append("Riskcode = ?, ");
        buffer.append("Proposalno = ?, ");
        buffer.append("Policyno = ?, ");
        buffer.append("Validity = ?, ");
        buffer.append("Updatecode = ?, ");
        buffer.append("Updatedate = ?, ");
        buffer.append("Opcode = ?, ");
        buffer.append("Remark = ?, ");
        buffer.append("Starttime = ?, ");
        buffer.append("Endtime = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE MedicalInsuremainlist SET ");
            debugBuffer.append("Classcode = '" + medicalInsuremainlistDto.getClassCode() + "', ");
            debugBuffer.append("Riskcode = '" + medicalInsuremainlistDto.getRiskCode() + "', ");
            debugBuffer.append("Proposalno = '" + medicalInsuremainlistDto.getProposalNo() + "', ");
            debugBuffer.append("Policyno = '" + medicalInsuremainlistDto.getPolicyNo() + "', ");
            debugBuffer.append("Validity = '" + medicalInsuremainlistDto.getValidity() + "', ");
            debugBuffer.append("Updatecode = '" + medicalInsuremainlistDto.getUpdateCode() + "', ");
            debugBuffer.append("Updatedate = '" + medicalInsuremainlistDto.getUpdateDate() + "', ");
            debugBuffer.append("Opcode = '" + medicalInsuremainlistDto.getOpCode() + "', ");
            debugBuffer.append("Remark = '" + medicalInsuremainlistDto.getReMark() + "', ");
            debugBuffer.append("Starttime = '" + medicalInsuremainlistDto.getStartTime() + "', ");
            debugBuffer.append("Endtime = '" + medicalInsuremainlistDto.getEndTime() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Inusrelistcode=").append("'").append(medicalInsuremainlistDto.getInusreListCode()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Inusrelistcode = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setString(1,medicalInsuremainlistDto.getClassCode());
        dbManager.setString(2,medicalInsuremainlistDto.getRiskCode());
        dbManager.setString(3,medicalInsuremainlistDto.getProposalNo());
        dbManager.setString(4,medicalInsuremainlistDto.getPolicyNo());
        dbManager.setString(5,medicalInsuremainlistDto.getValidity());
        dbManager.setString(6,medicalInsuremainlistDto.getUpdateCode());
        dbManager.setDateTime(7,medicalInsuremainlistDto.getUpdateDate());
        dbManager.setString(8,medicalInsuremainlistDto.getOpCode());
        dbManager.setString(9,medicalInsuremainlistDto.getReMark());
        dbManager.setDateTime(10,medicalInsuremainlistDto.getStartTime());
        dbManager.setDateTime(11,medicalInsuremainlistDto.getEndTime());
        //���������ֶ�;
        dbManager.setString(12,medicalInsuremainlistDto.getInusreListCode());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param inusrelistcode Ͷ���嵥���
     * @return MedicalInsuremainlistDto
     * @throws Exception
     */
    public MedicalInsuremainlistDto findByPrimaryKey(String inusrelistcode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("Inusrelistcode,");
        buffer.append("Classcode,");
        buffer.append("Riskcode,");
        buffer.append("Proposalno,");
        buffer.append("Policyno,");
        buffer.append("Validity,");
        buffer.append("Updatecode,");
        buffer.append("Updatedate,");
        buffer.append("Opcode,");
        buffer.append("Remark,");
        buffer.append("Starttime,");
        buffer.append("Endtime ");
        buffer.append("FROM MedicalInsuremainlist ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Inusrelistcode=").append("'").append(inusrelistcode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Inusrelistcode = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,inusrelistcode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        MedicalInsuremainlistDto medicalInsuremainlistDto = null;
        if(resultSet.next()){
            medicalInsuremainlistDto = new MedicalInsuremainlistDto();
            medicalInsuremainlistDto.setInusreListCode(dbManager.getString(resultSet,1));
            medicalInsuremainlistDto.setClassCode(dbManager.getString(resultSet,2));
            medicalInsuremainlistDto.setRiskCode(dbManager.getString(resultSet,3));
            medicalInsuremainlistDto.setProposalNo(dbManager.getString(resultSet,4));
            medicalInsuremainlistDto.setPolicyNo(dbManager.getString(resultSet,5));
            medicalInsuremainlistDto.setValidity(dbManager.getString(resultSet,6));
            medicalInsuremainlistDto.setUpdateCode(dbManager.getString(resultSet,7));
            medicalInsuremainlistDto.setUpdateDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,8));
            medicalInsuremainlistDto.setOpCode(dbManager.getString(resultSet,9));
            medicalInsuremainlistDto.setReMark(dbManager.getString(resultSet,10));
            medicalInsuremainlistDto.setStartTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,11));
            medicalInsuremainlistDto.setEndTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,12));
        }
        resultSet.close();
        return medicalInsuremainlistDto;
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
        buffer.append("Inusrelistcode,");
        buffer.append("Classcode,");
        buffer.append("Riskcode,");
        buffer.append("Proposalno,");
        buffer.append("Policyno,");
        buffer.append("Validity,");
        buffer.append("Updatecode,");
        buffer.append("Updatedate,");
        buffer.append("Opcode,");
        buffer.append("Remark,");
        buffer.append("Starttime,");
        buffer.append("Endtime ");
        buffer.append("FROM MedicalInsuremainlist WHERE ");
        buffer.append(conditions);
        boolean supportPaging = false;//���ݿ��Ƿ�֧�ַ�ҳ
        if (pageNo > 0){
            //��Oracle�Ż�
            if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("Oracle")){
                buffer.insert(0,"SELECT * FROM ( SELECT row_.*, rownum rownum_ FROM (");
                buffer.append(") row_ WHERE rownum <= "+rowsPerPage * pageNo+") WHERE rownum_ > "+rowsPerPage * (pageNo - 1));
                supportPaging=true;
            }
            else if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("DB2")){
                String sql = buffer.toString();
                buffer.setLength(0);
                buffer.append("select * from ( select rownumber() over(");
                int orderByIndex = sql.toLowerCase().indexOf("order by");
                if ( orderByIndex>0 ) {
                   buffer.append( sql.substring(orderByIndex) );
                }
                buffer.append(") as rownumber_,");
                buffer.append(sql.substring( 6 ));
                buffer.append(" ) as temp_ where rownumber_");
                buffer.append(" between "+ (rowsPerPage * (pageNo - 1) + 1) +" and "+rowsPerPage * pageNo);
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
        MedicalInsuremainlistDto medicalInsuremainlistDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            medicalInsuremainlistDto = new MedicalInsuremainlistDto();
            medicalInsuremainlistDto.setInusreListCode(dbManager.getString(resultSet,"Inusrelistcode"));
            medicalInsuremainlistDto.setClassCode(dbManager.getString(resultSet,"Classcode"));
            medicalInsuremainlistDto.setRiskCode(dbManager.getString(resultSet,"Riskcode"));
            medicalInsuremainlistDto.setProposalNo(dbManager.getString(resultSet,"Proposalno"));
            medicalInsuremainlistDto.setPolicyNo(dbManager.getString(resultSet,"Policyno"));
            medicalInsuremainlistDto.setValidity(dbManager.getString(resultSet,"Validity"));
            medicalInsuremainlistDto.setUpdateCode(dbManager.getString(resultSet,"Updatecode"));
            medicalInsuremainlistDto.setUpdateDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"Updatedate"));
            medicalInsuremainlistDto.setOpCode(dbManager.getString(resultSet,"Opcode"));
            medicalInsuremainlistDto.setReMark(dbManager.getString(resultSet,"Remark"));
            medicalInsuremainlistDto.setStartTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Starttime"));
            medicalInsuremainlistDto.setEndTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Endtime"));
            collection.add(medicalInsuremainlistDto);
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
        buffer.append("DELETE FROM MedicalInsuremainlist WHERE ");
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
        buffer.append("SELECT count(*) FROM MedicalInsuremainlist WHERE ");
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
