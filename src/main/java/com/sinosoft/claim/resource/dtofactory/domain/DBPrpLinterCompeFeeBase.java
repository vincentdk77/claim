package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterCompeFeeDto;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ���Ǽ����������Ϣ�����ݷ��ʶ������<br>
 */
public class DBPrpLinterCompeFeeBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrpLinterCompeFeeBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLinterCompeFeeBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpLinterCompeFeeDto prpLinterCompeFeeDto
     * @throws Exception
     */
    public void insert(PrpLinterCompeFeeDto prpLinterCompeFeeDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLinterCompeFee (");
        buffer.append("Id,");
        buffer.append("SerialNo,");
        buffer.append("ItemKindNo,");
        buffer.append("KindCode,");
        buffer.append("KindName,");
        buffer.append("Currency,");
        buffer.append("SumLoss,");
        buffer.append("SumRest,");
        buffer.append("Deductible,");
        buffer.append("ClaimRete,");
        buffer.append("SumRealPay,");
        buffer.append("Remark ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLinterCompeFeeDto.getId()).append("',");
            debugBuffer.append("").append(prpLinterCompeFeeDto.getSerialNo()).append(",");
            debugBuffer.append("").append(prpLinterCompeFeeDto.getItemKindNo()).append(",");
            debugBuffer.append("'").append(prpLinterCompeFeeDto.getKindCode()).append("',");
            debugBuffer.append("'").append(prpLinterCompeFeeDto.getKindName()).append("',");
            debugBuffer.append("'").append(prpLinterCompeFeeDto.getCurrency()).append("',");
            debugBuffer.append("").append(prpLinterCompeFeeDto.getSumLoss()).append(",");
            debugBuffer.append("").append(prpLinterCompeFeeDto.getSumRest()).append(",");
            debugBuffer.append("").append(prpLinterCompeFeeDto.getDeductible()).append(",");
            debugBuffer.append("").append(prpLinterCompeFeeDto.getClaimRete()).append(",");
            debugBuffer.append("").append(prpLinterCompeFeeDto.getSumRealPay()).append(",");
            debugBuffer.append("'").append(prpLinterCompeFeeDto.getRemark()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLinterCompeFeeDto.getId());
        dbManager.setInt(2,prpLinterCompeFeeDto.getSerialNo());
        dbManager.setLong(3,prpLinterCompeFeeDto.getItemKindNo());
        dbManager.setString(4,prpLinterCompeFeeDto.getKindCode());
        dbManager.setString(5,prpLinterCompeFeeDto.getKindName());
        dbManager.setString(6,prpLinterCompeFeeDto.getCurrency());
        dbManager.setDouble(7,prpLinterCompeFeeDto.getSumLoss());
        dbManager.setDouble(8,prpLinterCompeFeeDto.getSumRest());
        dbManager.setDouble(9,prpLinterCompeFeeDto.getDeductible());
        dbManager.setDouble(10,prpLinterCompeFeeDto.getClaimRete());
        dbManager.setDouble(11,prpLinterCompeFeeDto.getSumRealPay());
        dbManager.setString(12,prpLinterCompeFeeDto.getRemark());
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
        buffer.append("INSERT INTO PrpLinterCompeFee (");
        buffer.append("Id,");
        buffer.append("SerialNo,");
        buffer.append("ItemKindNo,");
        buffer.append("KindCode,");
        buffer.append("KindName,");
        buffer.append("Currency,");
        buffer.append("SumLoss,");
        buffer.append("SumRest,");
        buffer.append("Deductible,");
        buffer.append("ClaimRete,");
        buffer.append("SumRealPay,");
        buffer.append("Remark ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLinterCompeFeeDto prpLinterCompeFeeDto = (PrpLinterCompeFeeDto)i.next();
            dbManager.setString(1,prpLinterCompeFeeDto.getId());
            dbManager.setInt(2,prpLinterCompeFeeDto.getSerialNo());
            dbManager.setLong(3,prpLinterCompeFeeDto.getItemKindNo());
            dbManager.setString(4,prpLinterCompeFeeDto.getKindCode());
            dbManager.setString(5,prpLinterCompeFeeDto.getKindName());
            dbManager.setString(6,prpLinterCompeFeeDto.getCurrency());
            dbManager.setDouble(7,prpLinterCompeFeeDto.getSumLoss());
            dbManager.setDouble(8,prpLinterCompeFeeDto.getSumRest());
            dbManager.setDouble(9,prpLinterCompeFeeDto.getDeductible());
            dbManager.setDouble(10,prpLinterCompeFeeDto.getClaimRete());
            dbManager.setDouble(11,prpLinterCompeFeeDto.getSumRealPay());
            dbManager.setString(12,prpLinterCompeFeeDto.getRemark());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param id ����pk
     * @param serialNo �������pk
     * @throws Exception
     */
    public void delete(String id,int serialNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLinterCompeFee ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Id=").append("'").append(id).append("' AND ");
            debugBuffer.append("SerialNo=").append("").append(serialNo).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Id = ? And ");
        buffer.append("SerialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,id);
        dbManager.setInt(2,serialNo);
        dbManager.executePreparedUpdate();
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpLinterCompeFeeDto prpLinterCompeFeeDto
     * @throws Exception
     */
    public void update(PrpLinterCompeFeeDto prpLinterCompeFeeDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLinterCompeFee SET ");
        buffer.append("ItemKindNo = ?, ");
        buffer.append("KindCode = ?, ");
        buffer.append("KindName = ?, ");
        buffer.append("Currency = ?, ");
        buffer.append("SumLoss = ?, ");
        buffer.append("SumRest = ?, ");
        buffer.append("Deductible = ?, ");
        buffer.append("ClaimRete = ?, ");
        buffer.append("SumRealPay = ?, ");
        buffer.append("Remark = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLinterCompeFee SET ");
            debugBuffer.append("ItemKindNo = " + prpLinterCompeFeeDto.getItemKindNo() + ", ");
            debugBuffer.append("KindCode = '" + prpLinterCompeFeeDto.getKindCode() + "', ");
            debugBuffer.append("KindName = '" + prpLinterCompeFeeDto.getKindName() + "', ");
            debugBuffer.append("Currency = '" + prpLinterCompeFeeDto.getCurrency() + "', ");
            debugBuffer.append("SumLoss = " + prpLinterCompeFeeDto.getSumLoss() + ", ");
            debugBuffer.append("SumRest = " + prpLinterCompeFeeDto.getSumRest() + ", ");
            debugBuffer.append("Deductible = " + prpLinterCompeFeeDto.getDeductible() + ", ");
            debugBuffer.append("ClaimRete = " + prpLinterCompeFeeDto.getClaimRete() + ", ");
            debugBuffer.append("SumRealPay = " + prpLinterCompeFeeDto.getSumRealPay() + ", ");
            debugBuffer.append("Remark = '" + prpLinterCompeFeeDto.getRemark() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Id=").append("'").append(prpLinterCompeFeeDto.getId()).append("' AND ");
            debugBuffer.append("SerialNo=").append("").append(prpLinterCompeFeeDto.getSerialNo()).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Id = ? And ");
        buffer.append("SerialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setLong(1,prpLinterCompeFeeDto.getItemKindNo());
        dbManager.setString(2,prpLinterCompeFeeDto.getKindCode());
        dbManager.setString(3,prpLinterCompeFeeDto.getKindName());
        dbManager.setString(4,prpLinterCompeFeeDto.getCurrency());
        dbManager.setDouble(5,prpLinterCompeFeeDto.getSumLoss());
        dbManager.setDouble(6,prpLinterCompeFeeDto.getSumRest());
        dbManager.setDouble(7,prpLinterCompeFeeDto.getDeductible());
        dbManager.setDouble(8,prpLinterCompeFeeDto.getClaimRete());
        dbManager.setDouble(9,prpLinterCompeFeeDto.getSumRealPay());
        dbManager.setString(10,prpLinterCompeFeeDto.getRemark());
        //���������ֶ�;
        dbManager.setString(11,prpLinterCompeFeeDto.getId());
        dbManager.setInt(12,prpLinterCompeFeeDto.getSerialNo());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param id ����pk
     * @param serialNo �������pk
     * @return PrpLinterCompeFeeDto
     * @throws Exception
     */
    public PrpLinterCompeFeeDto findByPrimaryKey(String id,int serialNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("Id,");
        buffer.append("SerialNo,");
        buffer.append("ItemKindNo,");
        buffer.append("KindCode,");
        buffer.append("KindName,");
        buffer.append("Currency,");
        buffer.append("SumLoss,");
        buffer.append("SumRest,");
        buffer.append("Deductible,");
        buffer.append("ClaimRete,");
        buffer.append("SumRealPay,");
        buffer.append("Remark ");
        buffer.append("FROM PrpLinterCompeFee ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Id=").append("'").append(id).append("' AND ");
            debugBuffer.append("SerialNo=").append("").append(serialNo).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Id = ? And ");
        buffer.append("SerialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,id);
        dbManager.setInt(2,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLinterCompeFeeDto prpLinterCompeFeeDto = null;
        if(resultSet.next()){
            prpLinterCompeFeeDto = new PrpLinterCompeFeeDto();
            prpLinterCompeFeeDto.setId(dbManager.getString(resultSet,1));
            prpLinterCompeFeeDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpLinterCompeFeeDto.setItemKindNo(dbManager.getLong(resultSet,3));
            prpLinterCompeFeeDto.setKindCode(dbManager.getString(resultSet,4));
            prpLinterCompeFeeDto.setKindName(dbManager.getString(resultSet,5));
            prpLinterCompeFeeDto.setCurrency(dbManager.getString(resultSet,6));
            prpLinterCompeFeeDto.setSumLoss(dbManager.getDouble(resultSet,7));
            prpLinterCompeFeeDto.setSumRest(dbManager.getDouble(resultSet,8));
            prpLinterCompeFeeDto.setDeductible(dbManager.getDouble(resultSet,9));
            prpLinterCompeFeeDto.setClaimRete(dbManager.getDouble(resultSet,10));
            prpLinterCompeFeeDto.setSumRealPay(dbManager.getDouble(resultSet,11));
            prpLinterCompeFeeDto.setRemark(dbManager.getString(resultSet,12));
        }
        resultSet.close();
        return prpLinterCompeFeeDto;
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
        buffer.append("ItemKindNo,");
        buffer.append("KindCode,");
        buffer.append("KindName,");
        buffer.append("Currency,");
        buffer.append("SumLoss,");
        buffer.append("SumRest,");
        buffer.append("Deductible,");
        buffer.append("ClaimRete,");
        buffer.append("SumRealPay,");
        buffer.append("Remark ");
        buffer.append("FROM PrpLinterCompeFee WHERE ");
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
        PrpLinterCompeFeeDto prpLinterCompeFeeDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLinterCompeFeeDto = new PrpLinterCompeFeeDto();
            prpLinterCompeFeeDto.setId(dbManager.getString(resultSet,"Id"));
            prpLinterCompeFeeDto.setSerialNo(dbManager.getInt(resultSet,"SerialNo"));
            prpLinterCompeFeeDto.setItemKindNo(dbManager.getLong(resultSet,"ItemKindNo"));
            prpLinterCompeFeeDto.setKindCode(dbManager.getString(resultSet,"KindCode"));
            prpLinterCompeFeeDto.setKindName(dbManager.getString(resultSet,"KindName"));
            prpLinterCompeFeeDto.setCurrency(dbManager.getString(resultSet,"Currency"));
            prpLinterCompeFeeDto.setSumLoss(dbManager.getDouble(resultSet,"SumLoss"));
            prpLinterCompeFeeDto.setSumRest(dbManager.getDouble(resultSet,"SumRest"));
            prpLinterCompeFeeDto.setDeductible(dbManager.getDouble(resultSet,"Deductible"));
            prpLinterCompeFeeDto.setClaimRete(dbManager.getDouble(resultSet,"ClaimRete"));
            prpLinterCompeFeeDto.setSumRealPay(dbManager.getDouble(resultSet,"SumRealPay"));
            prpLinterCompeFeeDto.setRemark(dbManager.getString(resultSet,"Remark"));
            collection.add(prpLinterCompeFeeDto);
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
        buffer.append("DELETE FROM PrpLinterCompeFee WHERE ");
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
        buffer.append("SELECT count(1) FROM PrpLinterCompeFee WHERE ");
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
