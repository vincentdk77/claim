package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.TemblorendorheadDto;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����TEMBLORENDORHEAD�����ݷ��ʶ������<br>
 */
public class DBTemblorendorheadBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBTemblorendorheadBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBTemblorendorheadBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param temblorendorheadDto temblorendorheadDto
     * @throws Exception
     */
    public void insert(TemblorendorheadDto temblorendorheadDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Temblorendorhead (");
        buffer.append("Inusrelistcode,");
        buffer.append("Endorseno,");
        buffer.append("Policyno,");
        buffer.append("Riskcode,");
        buffer.append("Listflag,");
        buffer.append("Endorflag ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(temblorendorheadDto.getInusrelistcode()).append("',");
            debugBuffer.append("'").append(temblorendorheadDto.getEndorseno()).append("',");
            debugBuffer.append("'").append(temblorendorheadDto.getPolicyno()).append("',");
            debugBuffer.append("'").append(temblorendorheadDto.getRiskcode()).append("',");
            debugBuffer.append("'").append(temblorendorheadDto.getListflag()).append("',");
            debugBuffer.append("'").append(temblorendorheadDto.getEndorflag()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,temblorendorheadDto.getInusrelistcode());
        dbManager.setString(2,temblorendorheadDto.getEndorseno());
        dbManager.setString(3,temblorendorheadDto.getPolicyno());
        dbManager.setString(4,temblorendorheadDto.getRiskcode());
        dbManager.setString(5,temblorendorheadDto.getListflag());
        dbManager.setString(6,temblorendorheadDto.getEndorflag());
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
        buffer.append("INSERT INTO Temblorendorhead (");
        buffer.append("Inusrelistcode,");
        buffer.append("Endorseno,");
        buffer.append("Policyno,");
        buffer.append("Riskcode,");
        buffer.append("Listflag,");
        buffer.append("Endorflag ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            TemblorendorheadDto temblorendorheadDto = (TemblorendorheadDto)i.next();
            dbManager.setString(1,temblorendorheadDto.getInusrelistcode());
            dbManager.setString(2,temblorendorheadDto.getEndorseno());
            dbManager.setString(3,temblorendorheadDto.getPolicyno());
            dbManager.setString(4,temblorendorheadDto.getRiskcode());
            dbManager.setString(5,temblorendorheadDto.getListflag());
            dbManager.setString(6,temblorendorheadDto.getEndorflag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param endorseno ENDORSENO
     * @throws Exception
     */
    public void delete(String endorseno)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM Temblorendorhead ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Endorseno=").append("'").append(endorseno).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Endorseno = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,endorseno);
        dbManager.executePreparedUpdate();
    }

    /**
     * ����������һ������(���������޷����)
     * @param temblorendorheadDto temblorendorheadDto
     * @throws Exception
     */
    public void update(TemblorendorheadDto temblorendorheadDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Temblorendorhead SET ");
        buffer.append("Inusrelistcode = ?, ");
        buffer.append("Policyno = ?, ");
        buffer.append("Riskcode = ?, ");
        buffer.append("Listflag = ?, ");
        buffer.append("Endorflag = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE Temblorendorhead SET ");
            debugBuffer.append("Inusrelistcode = '" + temblorendorheadDto.getInusrelistcode() + "', ");
            debugBuffer.append("Policyno = '" + temblorendorheadDto.getPolicyno() + "', ");
            debugBuffer.append("Riskcode = '" + temblorendorheadDto.getRiskcode() + "', ");
            debugBuffer.append("Listflag = '" + temblorendorheadDto.getListflag() + "', ");
            debugBuffer.append("Endorflag = '" + temblorendorheadDto.getEndorflag() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Endorseno=").append("'").append(temblorendorheadDto.getEndorseno()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Endorseno = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setString(1,temblorendorheadDto.getInusrelistcode());
        dbManager.setString(2,temblorendorheadDto.getPolicyno());
        dbManager.setString(3,temblorendorheadDto.getRiskcode());
        dbManager.setString(4,temblorendorheadDto.getListflag());
        dbManager.setString(5,temblorendorheadDto.getEndorflag());
        //���������ֶ�;
        dbManager.setString(6,temblorendorheadDto.getEndorseno());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param endorseno ENDORSENO
     * @return TemblorendorheadDto
     * @throws Exception
     */
    public TemblorendorheadDto findByPrimaryKey(String endorseno)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("Inusrelistcode,");
        buffer.append("Endorseno,");
        buffer.append("Policyno,");
        buffer.append("Riskcode,");
        buffer.append("Listflag,");
        buffer.append("Endorflag ");
        buffer.append("FROM Temblorendorhead ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Endorseno=").append("'").append(endorseno).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Endorseno = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,endorseno);
        ResultSet resultSet = dbManager.executePreparedQuery();
        TemblorendorheadDto temblorendorheadDto = null;
        if(resultSet.next()){
            temblorendorheadDto = new TemblorendorheadDto();
            temblorendorheadDto.setInusrelistcode(dbManager.getString(resultSet,1));
            temblorendorheadDto.setEndorseno(dbManager.getString(resultSet,2));
            temblorendorheadDto.setPolicyno(dbManager.getString(resultSet,3));
            temblorendorheadDto.setRiskcode(dbManager.getString(resultSet,4));
            temblorendorheadDto.setListflag(dbManager.getString(resultSet,5));
            temblorendorheadDto.setEndorflag(dbManager.getString(resultSet,6));
        }
        resultSet.close();
        return temblorendorheadDto;
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
        buffer.append("Endorseno,");
        buffer.append("Policyno,");
        buffer.append("Riskcode,");
        buffer.append("Listflag,");
        buffer.append("Endorflag ");
        buffer.append("FROM Temblorendorhead WHERE ");
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
        TemblorendorheadDto temblorendorheadDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            temblorendorheadDto = new TemblorendorheadDto();
            temblorendorheadDto.setInusrelistcode(dbManager.getString(resultSet,"Inusrelistcode"));
            temblorendorheadDto.setEndorseno(dbManager.getString(resultSet,"Endorseno"));
            temblorendorheadDto.setPolicyno(dbManager.getString(resultSet,"Policyno"));
            temblorendorheadDto.setRiskcode(dbManager.getString(resultSet,"Riskcode"));
            temblorendorheadDto.setListflag(dbManager.getString(resultSet,"Listflag"));
            temblorendorheadDto.setEndorflag(dbManager.getString(resultSet,"Endorflag"));
            collection.add(temblorendorheadDto);
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
        buffer.append("DELETE FROM Temblorendorhead WHERE ");
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
        buffer.append("SELECT count(*) FROM Temblorendorhead WHERE ");
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
