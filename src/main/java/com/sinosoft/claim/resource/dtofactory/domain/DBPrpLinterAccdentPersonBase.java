package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterAccdentPersonDto;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ��������ӿ��¹�����Ϣ�����ݷ��ʶ������<br>
 */
public class DBPrpLinterAccdentPersonBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrpLinterAccdentPersonBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLinterAccdentPersonBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpLinterAccdentPersonDto prpLinterAccdentPersonDto
     * @throws Exception
     */
    public void insert(PrpLinterAccdentPersonDto prpLinterAccdentPersonDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLinterAccdentPerson (");
        buffer.append("Id,");
        buffer.append("SerialNo,");
        buffer.append("AcciCode,");
        buffer.append("AcciName,");
        buffer.append("Sex,");
        buffer.append("Age,");
        buffer.append("IdentifyNumber,");
        buffer.append("PerilContext,");
        buffer.append("BeneRiskContext ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLinterAccdentPersonDto.getId()).append("',");
            debugBuffer.append("").append(prpLinterAccdentPersonDto.getSerialNo()).append(",");
            debugBuffer.append("'").append(prpLinterAccdentPersonDto.getAcciCode()).append("',");
            debugBuffer.append("'").append(prpLinterAccdentPersonDto.getAcciName()).append("',");
            debugBuffer.append("'").append(prpLinterAccdentPersonDto.getSex()).append("',");
            debugBuffer.append("").append(prpLinterAccdentPersonDto.getAge()).append(",");
            debugBuffer.append("'").append(prpLinterAccdentPersonDto.getIdentifyNumber()).append("',");
            debugBuffer.append("'").append(prpLinterAccdentPersonDto.getPerilContext()).append("',");
            debugBuffer.append("'").append(prpLinterAccdentPersonDto.getBeneRiskContext()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLinterAccdentPersonDto.getId());
        dbManager.setInt(2,prpLinterAccdentPersonDto.getSerialNo());
        dbManager.setString(3,prpLinterAccdentPersonDto.getAcciCode());
        dbManager.setString(4,prpLinterAccdentPersonDto.getAcciName());
        dbManager.setString(5,prpLinterAccdentPersonDto.getSex());
        dbManager.setInt(6,prpLinterAccdentPersonDto.getAge());
        dbManager.setString(7,prpLinterAccdentPersonDto.getIdentifyNumber());
        dbManager.setString(8,prpLinterAccdentPersonDto.getPerilContext());
        dbManager.setString(9,prpLinterAccdentPersonDto.getBeneRiskContext());
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
        buffer.append("INSERT INTO PrpLinterAccdentPerson (");
        buffer.append("Id,");
        buffer.append("SerialNo,");
        buffer.append("AcciCode,");
        buffer.append("AcciName,");
        buffer.append("Sex,");
        buffer.append("Age,");
        buffer.append("IdentifyNumber,");
        buffer.append("PerilContext,");
        buffer.append("BeneRiskContext ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLinterAccdentPersonDto prpLinterAccdentPersonDto = (PrpLinterAccdentPersonDto)i.next();
            dbManager.setString(1,prpLinterAccdentPersonDto.getId());
            dbManager.setInt(2,prpLinterAccdentPersonDto.getSerialNo());
            dbManager.setString(3,prpLinterAccdentPersonDto.getAcciCode());
            dbManager.setString(4,prpLinterAccdentPersonDto.getAcciName());
            dbManager.setString(5,prpLinterAccdentPersonDto.getSex());
            dbManager.setInt(6,prpLinterAccdentPersonDto.getAge());
            dbManager.setString(7,prpLinterAccdentPersonDto.getIdentifyNumber());
            dbManager.setString(8,prpLinterAccdentPersonDto.getPerilContext());
            dbManager.setString(9,prpLinterAccdentPersonDto.getBeneRiskContext());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param id ����id PK
     * @throws Exception
     */
    public void delete(String id)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLinterAccdentPerson ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Id=").append("'").append(id).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Id = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,id);
        dbManager.executePreparedUpdate();
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpLinterAccdentPersonDto prpLinterAccdentPersonDto
     * @throws Exception
     */
    public void update(PrpLinterAccdentPersonDto prpLinterAccdentPersonDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLinterAccdentPerson SET ");
        buffer.append("SerialNo = ?, ");
        buffer.append("AcciCode = ?, ");
        buffer.append("AcciName = ?, ");
        buffer.append("Sex = ?, ");
        buffer.append("Age = ?, ");
        buffer.append("IdentifyNumber = ?, ");
        buffer.append("PerilContext = ?, ");
        buffer.append("BeneRiskContext = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLinterAccdentPerson SET ");
            debugBuffer.append("SerialNo = " + prpLinterAccdentPersonDto.getSerialNo() + ", ");
            debugBuffer.append("AcciCode = '" + prpLinterAccdentPersonDto.getAcciCode() + "', ");
            debugBuffer.append("AcciName = '" + prpLinterAccdentPersonDto.getAcciName() + "', ");
            debugBuffer.append("Sex = '" + prpLinterAccdentPersonDto.getSex() + "', ");
            debugBuffer.append("Age = " + prpLinterAccdentPersonDto.getAge() + ", ");
            debugBuffer.append("IdentifyNumber = '" + prpLinterAccdentPersonDto.getIdentifyNumber() + "', ");
            debugBuffer.append("PerilContext = '" + prpLinterAccdentPersonDto.getPerilContext() + "', ");
            debugBuffer.append("BeneRiskContext = '" + prpLinterAccdentPersonDto.getBeneRiskContext() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Id=").append("'").append(prpLinterAccdentPersonDto.getId()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Id = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setInt(1,prpLinterAccdentPersonDto.getSerialNo());
        dbManager.setString(2,prpLinterAccdentPersonDto.getAcciCode());
        dbManager.setString(3,prpLinterAccdentPersonDto.getAcciName());
        dbManager.setString(4,prpLinterAccdentPersonDto.getSex());
        dbManager.setInt(5,prpLinterAccdentPersonDto.getAge());
        dbManager.setString(6,prpLinterAccdentPersonDto.getIdentifyNumber());
        dbManager.setString(7,prpLinterAccdentPersonDto.getPerilContext());
        dbManager.setString(8,prpLinterAccdentPersonDto.getBeneRiskContext());
        //���������ֶ�;
        dbManager.setString(9,prpLinterAccdentPersonDto.getId());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param id ����id PK
     * @return PrpLinterAccdentPersonDto
     * @throws Exception
     */
    public PrpLinterAccdentPersonDto findByPrimaryKey(String id)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("Id,");
        buffer.append("SerialNo,");
        buffer.append("AcciCode,");
        buffer.append("AcciName,");
        buffer.append("Sex,");
        buffer.append("Age,");
        buffer.append("IdentifyNumber,");
        buffer.append("PerilContext,");
        buffer.append("BeneRiskContext ");
        buffer.append("FROM PrpLinterAccdentPerson ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Id=").append("'").append(id).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Id = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,id);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLinterAccdentPersonDto prpLinterAccdentPersonDto = null;
        if(resultSet.next()){
            prpLinterAccdentPersonDto = new PrpLinterAccdentPersonDto();
            prpLinterAccdentPersonDto.setId(dbManager.getString(resultSet,1));
            prpLinterAccdentPersonDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpLinterAccdentPersonDto.setAcciCode(dbManager.getString(resultSet,3));
            prpLinterAccdentPersonDto.setAcciName(dbManager.getString(resultSet,4));
            prpLinterAccdentPersonDto.setSex(dbManager.getString(resultSet,5));
            prpLinterAccdentPersonDto.setAge(dbManager.getInt(resultSet,6));
            prpLinterAccdentPersonDto.setIdentifyNumber(dbManager.getString(resultSet,7));
            prpLinterAccdentPersonDto.setPerilContext(dbManager.getString(resultSet,8));
            prpLinterAccdentPersonDto.setBeneRiskContext(dbManager.getString(resultSet,9));
        }
        resultSet.close();
        return prpLinterAccdentPersonDto;
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
        buffer.append("Id,");
        buffer.append("SerialNo,");
        buffer.append("AcciCode,");
        buffer.append("AcciName,");
        buffer.append("Sex,");
        buffer.append("Age,");
        buffer.append("IdentifyNumber,");
        buffer.append("PerilContext,");
        buffer.append("BeneRiskContext ");
        buffer.append("FROM PrpLinterAccdentPerson WHERE ");
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
        PrpLinterAccdentPersonDto prpLinterAccdentPersonDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLinterAccdentPersonDto = new PrpLinterAccdentPersonDto();
            prpLinterAccdentPersonDto.setId(dbManager.getString(resultSet,"Id"));
            prpLinterAccdentPersonDto.setSerialNo(dbManager.getInt(resultSet,"SerialNo"));
            prpLinterAccdentPersonDto.setAcciCode(dbManager.getString(resultSet,"AcciCode"));
            prpLinterAccdentPersonDto.setAcciName(dbManager.getString(resultSet,"AcciName"));
            prpLinterAccdentPersonDto.setSex(dbManager.getString(resultSet,"Sex"));
            prpLinterAccdentPersonDto.setAge(dbManager.getInt(resultSet,"Age"));
            prpLinterAccdentPersonDto.setIdentifyNumber(dbManager.getString(resultSet,"IdentifyNumber"));
            prpLinterAccdentPersonDto.setPerilContext(dbManager.getString(resultSet,"PerilContext"));
            prpLinterAccdentPersonDto.setBeneRiskContext(dbManager.getString(resultSet,"BeneRiskContext"));
            collection.add(prpLinterAccdentPersonDto);
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
        buffer.append("DELETE FROM PrpLinterAccdentPerson WHERE ");
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
        buffer.append("SELECT count(1) FROM PrpLinterAccdentPerson WHERE ");
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
