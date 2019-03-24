package com.sinosoft.servlet.accisd.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.sinosoft.servlet.accisd.dto.domain.PrpLAcciClaimInfoSDDto;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLACCICLAIMINFOSD�����ݷ��ʶ������<br>
 */
public class DBPrpLAcciClaimInfoSDBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrpLAcciClaimInfoSDBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLAcciClaimInfoSDBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prplacciclaiminfosdDto prplacciclaiminfosdDto
     * @throws Exception
     */
    public void insert(PrpLAcciClaimInfoSDDto prplacciclaiminfosdDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Prplacciclaiminfosd (");
        buffer.append("Name,");
        buffer.append("Credentialtype,");
        buffer.append("Credentialno,");
        buffer.append("Claimno,");
        buffer.append("Companycode,");
        buffer.append("Claimdate,");
        buffer.append("Lossdate,");
        buffer.append("Lossresult ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prplacciclaiminfosdDto.getName()).append("',");
            debugBuffer.append("'").append(prplacciclaiminfosdDto.getCredentialType()).append("',");
            debugBuffer.append("'").append(prplacciclaiminfosdDto.getCredentialNo()).append("',");
            debugBuffer.append("'").append(prplacciclaiminfosdDto.getClaimNo()).append("',");
            debugBuffer.append("'").append(prplacciclaiminfosdDto.getCompanyCode()).append("',");
            debugBuffer.append("'").append(prplacciclaiminfosdDto.getClaimDate()).append("',");
            debugBuffer.append("'").append(prplacciclaiminfosdDto.getLossDate()).append("',");
            debugBuffer.append("'").append(prplacciclaiminfosdDto.getLossResult()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prplacciclaiminfosdDto.getName());
        dbManager.setString(2,prplacciclaiminfosdDto.getCredentialType());
        dbManager.setString(3,prplacciclaiminfosdDto.getCredentialNo());
        dbManager.setString(4,prplacciclaiminfosdDto.getClaimNo());
        dbManager.setString(5,prplacciclaiminfosdDto.getCompanyCode());
        dbManager.setString(6,prplacciclaiminfosdDto.getClaimDate());
        dbManager.setString(7,prplacciclaiminfosdDto.getLossDate());
        dbManager.setString(8,prplacciclaiminfosdDto.getLossResult());
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
        buffer.append("INSERT INTO Prplacciclaiminfosd (");
        buffer.append("Name,");
        buffer.append("Credentialtype,");
        buffer.append("Credentialno,");
        buffer.append("Claimno,");
        buffer.append("Companycode,");
        buffer.append("Claimdate,");
        buffer.append("Lossdate,");
        buffer.append("Lossresult ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLAcciClaimInfoSDDto prplacciclaiminfosdDto = (PrpLAcciClaimInfoSDDto)i.next();
            dbManager.setString(1,prplacciclaiminfosdDto.getName());
            dbManager.setString(2,prplacciclaiminfosdDto.getCredentialType());
            dbManager.setString(3,prplacciclaiminfosdDto.getCredentialNo());
            dbManager.setString(4,prplacciclaiminfosdDto.getClaimNo());
            dbManager.setString(5,prplacciclaiminfosdDto.getCompanyCode());
            dbManager.setString(6,prplacciclaiminfosdDto.getClaimDate());
            dbManager.setString(7,prplacciclaiminfosdDto.getLossDate());
            dbManager.setString(8,prplacciclaiminfosdDto.getLossResult());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param name NAME
     * @throws Exception
     */
    public void delete(String name,String credentialType,String credentialNo,String claimNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM Prplacciclaiminfosd ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Name=").append("'").append(name).append("' AND ");
            debugBuffer.append("credentialType=").append("'").append(credentialType).append("' AND ");
            debugBuffer.append("credentialNo=").append("'").append(credentialNo).append("' AND ");
            debugBuffer.append("claimNo=").append("'").append(claimNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Name = ? AND ");
        buffer.append("credentialType = ? AND ");
        buffer.append("credentialNo = ? AND ");
        buffer.append("claimNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,name);
        dbManager.setString(2,credentialType);
        dbManager.setString(3,credentialNo);
        dbManager.setString(4,claimNo);
        dbManager.executePreparedUpdate();
    }

    /**
     * ����������һ������(���������޷����)
     * @param prplacciclaiminfosdDto prplacciclaiminfosdDto
     * @throws Exception
     */
    public void update(PrpLAcciClaimInfoSDDto prplacciclaiminfosdDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Prplacciclaiminfosd SET ");
        buffer.append("Credentialtype = ?, ");
        buffer.append("Credentialno = ?, ");
        buffer.append("Claimno = ?, ");
        buffer.append("Companycode = ?, ");
        buffer.append("Claimdate = ?, ");
        buffer.append("Lossdate = ?, ");
        buffer.append("Lossresult = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE Prplacciclaiminfosd SET ");
            debugBuffer.append("Credentialtype = '" + prplacciclaiminfosdDto.getCredentialType() + "', ");
            debugBuffer.append("Credentialno = '" + prplacciclaiminfosdDto.getCredentialNo() + "', ");
            debugBuffer.append("Claimno = '" + prplacciclaiminfosdDto.getClaimNo() + "', ");
            debugBuffer.append("Companycode = '" + prplacciclaiminfosdDto.getCompanyCode() + "', ");
            debugBuffer.append("Claimdate = '" + prplacciclaiminfosdDto.getClaimDate() + "', ");
            debugBuffer.append("Lossdate = '" + prplacciclaiminfosdDto.getLossDate() + "', ");
            debugBuffer.append("Lossresult = '" + prplacciclaiminfosdDto.getLossResult() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Name=").append("'").append(prplacciclaiminfosdDto.getName()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Name = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setString(1,prplacciclaiminfosdDto.getCredentialType());
        dbManager.setString(2,prplacciclaiminfosdDto.getCredentialNo());
        dbManager.setString(3,prplacciclaiminfosdDto.getClaimNo());
        dbManager.setString(4,prplacciclaiminfosdDto.getCompanyCode());
        dbManager.setString(5,prplacciclaiminfosdDto.getClaimDate());
        dbManager.setString(6,prplacciclaiminfosdDto.getLossDate());
        dbManager.setString(7,prplacciclaiminfosdDto.getLossResult());
        //���������ֶ�;
        dbManager.setString(8,prplacciclaiminfosdDto.getName());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param name NAME
     * @return PrpLAcciClaimInfoSDDto
     * @throws Exception
     */
    public PrpLAcciClaimInfoSDDto findByPrimaryKey(String name,String credentialType,String credentialNo,String claimNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("Name,");
        buffer.append("Credentialtype,");
        buffer.append("Credentialno,");
        buffer.append("Claimno,");
        buffer.append("Companycode,");
        buffer.append("Claimdate,");
        buffer.append("Lossdate,");
        buffer.append("Lossresult ");
        buffer.append("FROM Prplacciclaiminfosd ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Name=").append("'").append(name).append("' AND ");
            debugBuffer.append("credentialType=").append("'").append(credentialType).append("' AND ");
            debugBuffer.append("credentialNo=").append("'").append(credentialNo).append("' AND ");
            debugBuffer.append("claimNo=").append("'").append(claimNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Name = ? AND ");
        buffer.append("credentialType = ? AND ");
        buffer.append("credentialNo = ? AND ");
        buffer.append("claimNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,name);
        dbManager.setString(2,credentialType);
        dbManager.setString(3,credentialNo);
        dbManager.setString(4,claimNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLAcciClaimInfoSDDto prplacciclaiminfosdDto = null;
        if(resultSet.next()){
            prplacciclaiminfosdDto = new PrpLAcciClaimInfoSDDto();
            prplacciclaiminfosdDto.setName(dbManager.getString(resultSet,1));
            prplacciclaiminfosdDto.setCredentialType(dbManager.getString(resultSet,2));
            prplacciclaiminfosdDto.setCredentialNo(dbManager.getString(resultSet,3));
            prplacciclaiminfosdDto.setClaimNo(dbManager.getString(resultSet,4));
            prplacciclaiminfosdDto.setCompanyCode(dbManager.getString(resultSet,5));
            prplacciclaiminfosdDto.setClaimDate(dbManager.getString(resultSet,6));
            prplacciclaiminfosdDto.setLossDate(dbManager.getString(resultSet,7));
            prplacciclaiminfosdDto.setLossResult(dbManager.getString(resultSet,8));
        }
        resultSet.close();
        return prplacciclaiminfosdDto;
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
        buffer.append("Name,");
        buffer.append("Credentialtype,");
        buffer.append("Credentialno,");
        buffer.append("Claimno,");
        buffer.append("Companycode,");
        buffer.append("Claimdate,");
        buffer.append("Lossdate,");
        buffer.append("Lossresult ");
        buffer.append("FROM Prplacciclaiminfosd WHERE ");
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
        PrpLAcciClaimInfoSDDto prplacciclaiminfosdDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            prplacciclaiminfosdDto = new PrpLAcciClaimInfoSDDto();
            prplacciclaiminfosdDto.setName(dbManager.getString(resultSet,"Name"));
            prplacciclaiminfosdDto.setCredentialType(dbManager.getString(resultSet,"Credentialtype"));
            prplacciclaiminfosdDto.setCredentialNo(dbManager.getString(resultSet,"Credentialno"));
            prplacciclaiminfosdDto.setClaimNo(dbManager.getString(resultSet,"Claimno"));
            prplacciclaiminfosdDto.setCompanyCode(dbManager.getString(resultSet,"Companycode"));
            prplacciclaiminfosdDto.setClaimDate(dbManager.getString(resultSet,"Claimdate"));
            prplacciclaiminfosdDto.setLossDate(dbManager.getString(resultSet,"Lossdate"));
            prplacciclaiminfosdDto.setLossResult(dbManager.getString(resultSet,"Lossresult"));
            collection.add(prplacciclaiminfosdDto);
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
        buffer.append("DELETE FROM Prplacciclaiminfosd WHERE ");
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
        buffer.append("SELECT count(*) FROM Prplacciclaiminfosd WHERE ");
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
