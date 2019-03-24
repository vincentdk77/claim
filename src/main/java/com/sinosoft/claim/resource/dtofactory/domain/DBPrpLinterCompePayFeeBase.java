package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterCompePayFeeDto;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ���Ǽ�������������Ϣ�����ݷ��ʶ������<br>
 */
public class DBPrpLinterCompePayFeeBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrpLinterCompePayFeeBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLinterCompePayFeeBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpLinterCompePayFeeDto prpLinterCompePayFeeDto
     * @throws Exception
     */
    public void insert(PrpLinterCompePayFeeDto prpLinterCompePayFeeDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLinterCompePayFee (");
        buffer.append("Id,");
        buffer.append("SerialNo,");
        buffer.append("ItemKindNo,");
        buffer.append("CodeCode,");
        buffer.append("CodeCName,");
        buffer.append("KindCode,");
        buffer.append("KindName,");
        buffer.append("CheckDeptName,");
        buffer.append("Currency,");
        buffer.append("CurrencyName,");
        buffer.append("ChargeAmount,");
        buffer.append("PreChargeAmount,");
        buffer.append("SumRealPay,");
        buffer.append("CheckDeptCode ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLinterCompePayFeeDto.getId()).append("',");
            debugBuffer.append("").append(prpLinterCompePayFeeDto.getSerialNo()).append(",");
            debugBuffer.append("").append(prpLinterCompePayFeeDto.getItemKindNo()).append(",");
            debugBuffer.append("'").append(prpLinterCompePayFeeDto.getCodeCode()).append("',");
            debugBuffer.append("'").append(prpLinterCompePayFeeDto.getCodeCName()).append("',");
            debugBuffer.append("'").append(prpLinterCompePayFeeDto.getKindCode()).append("',");
            debugBuffer.append("'").append(prpLinterCompePayFeeDto.getKindName()).append("',");
            debugBuffer.append("'").append(prpLinterCompePayFeeDto.getCheckDeptName()).append("',");
            debugBuffer.append("'").append(prpLinterCompePayFeeDto.getCurrency()).append("',");
            debugBuffer.append("'").append(prpLinterCompePayFeeDto.getCurrencyName()).append("',");
            debugBuffer.append("").append(prpLinterCompePayFeeDto.getChargeAmount()).append(",");
            debugBuffer.append("").append(prpLinterCompePayFeeDto.getPreChargeAmount()).append(",");
            debugBuffer.append("").append(prpLinterCompePayFeeDto.getSumRealPay()).append(",");
            debugBuffer.append("'").append(prpLinterCompePayFeeDto.getCheckDeptCode()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLinterCompePayFeeDto.getId());
        dbManager.setInt(2,prpLinterCompePayFeeDto.getSerialNo());
        dbManager.setInt(3,prpLinterCompePayFeeDto.getItemKindNo());
        dbManager.setString(4,prpLinterCompePayFeeDto.getCodeCode());
        dbManager.setString(5,prpLinterCompePayFeeDto.getCodeCName());
        dbManager.setString(6,prpLinterCompePayFeeDto.getKindCode());
        dbManager.setString(7,prpLinterCompePayFeeDto.getKindName());
        dbManager.setString(8,prpLinterCompePayFeeDto.getCheckDeptName());
        dbManager.setString(9,prpLinterCompePayFeeDto.getCurrency());
        dbManager.setString(10,prpLinterCompePayFeeDto.getCurrencyName());
        dbManager.setDouble(11,prpLinterCompePayFeeDto.getChargeAmount());
        dbManager.setDouble(12,prpLinterCompePayFeeDto.getPreChargeAmount());
        dbManager.setDouble(13,prpLinterCompePayFeeDto.getSumRealPay());
        dbManager.setString(14,prpLinterCompePayFeeDto.getCheckDeptCode());
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
        buffer.append("INSERT INTO PrpLinterCompePayFee (");
        buffer.append("Id,");
        buffer.append("SerialNo,");
        buffer.append("ItemKindNo,");
        buffer.append("CodeCode,");
        buffer.append("CodeCName,");
        buffer.append("KindCode,");
        buffer.append("KindName,");
        buffer.append("CheckDeptName,");
        buffer.append("Currency,");
        buffer.append("CurrencyName,");
        buffer.append("ChargeAmount,");
        buffer.append("PreChargeAmount,");
        buffer.append("SumRealPay,");
        buffer.append("CheckDeptCode ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLinterCompePayFeeDto prpLinterCompePayFeeDto = (PrpLinterCompePayFeeDto)i.next();
            dbManager.setString(1,prpLinterCompePayFeeDto.getId());
            dbManager.setInt(2,prpLinterCompePayFeeDto.getSerialNo());
            dbManager.setInt(3,prpLinterCompePayFeeDto.getItemKindNo());
            dbManager.setString(4,prpLinterCompePayFeeDto.getCodeCode());
            dbManager.setString(5,prpLinterCompePayFeeDto.getCodeCName());
            dbManager.setString(6,prpLinterCompePayFeeDto.getKindCode());
            dbManager.setString(7,prpLinterCompePayFeeDto.getKindName());
            dbManager.setString(8,prpLinterCompePayFeeDto.getCheckDeptName());
            dbManager.setString(9,prpLinterCompePayFeeDto.getCurrency());
            dbManager.setString(10,prpLinterCompePayFeeDto.getCurrencyName());
            dbManager.setDouble(11,prpLinterCompePayFeeDto.getChargeAmount());
            dbManager.setDouble(12,prpLinterCompePayFeeDto.getPreChargeAmount());
            dbManager.setDouble(13,prpLinterCompePayFeeDto.getSumRealPay());
            dbManager.setString(14,prpLinterCompePayFeeDto.getCheckDeptCode());
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
        buffer.append("DELETE FROM PrpLinterCompePayFee ");
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
     * @param prpLinterCompePayFeeDto prpLinterCompePayFeeDto
     * @throws Exception
     */
    public void update(PrpLinterCompePayFeeDto prpLinterCompePayFeeDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLinterCompePayFee SET ");
        buffer.append("ItemKindNo = ?, ");
        buffer.append("CodeCode = ?, ");
        buffer.append("CodeCName = ?, ");
        buffer.append("KindCode = ?, ");
        buffer.append("KindName = ?, ");
        buffer.append("CheckDeptName = ?, ");
        buffer.append("Currency = ?, ");
        buffer.append("CurrencyName = ?, ");
        buffer.append("ChargeAmount = ?, ");
        buffer.append("PreChargeAmount = ?, ");
        buffer.append("SumRealPay = ?, ");
        buffer.append("CheckDeptCode = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLinterCompePayFee SET ");
            debugBuffer.append("ItemKindNo = " + prpLinterCompePayFeeDto.getItemKindNo() + ", ");
            debugBuffer.append("CodeCode = '" + prpLinterCompePayFeeDto.getCodeCode() + "', ");
            debugBuffer.append("CodeCName = '" + prpLinterCompePayFeeDto.getCodeCName() + "', ");
            debugBuffer.append("KindCode = '" + prpLinterCompePayFeeDto.getKindCode() + "', ");
            debugBuffer.append("KindName = '" + prpLinterCompePayFeeDto.getKindName() + "', ");
            debugBuffer.append("CheckDeptName = '" + prpLinterCompePayFeeDto.getCheckDeptName() + "', ");
            debugBuffer.append("Currency = '" + prpLinterCompePayFeeDto.getCurrency() + "', ");
            debugBuffer.append("CurrencyName = '" + prpLinterCompePayFeeDto.getCurrencyName() + "', ");
            debugBuffer.append("ChargeAmount = " + prpLinterCompePayFeeDto.getChargeAmount() + ", ");
            debugBuffer.append("PreChargeAmount = " + prpLinterCompePayFeeDto.getPreChargeAmount() + ", ");
            debugBuffer.append("SumRealPay = " + prpLinterCompePayFeeDto.getSumRealPay() + ", ");
            debugBuffer.append("CheckDeptCode = '" + prpLinterCompePayFeeDto.getCheckDeptCode() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Id=").append("'").append(prpLinterCompePayFeeDto.getId()).append("' AND ");
            debugBuffer.append("SerialNo=").append("").append(prpLinterCompePayFeeDto.getSerialNo()).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Id = ? And ");
        buffer.append("SerialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setInt(1,prpLinterCompePayFeeDto.getItemKindNo());
        dbManager.setString(2,prpLinterCompePayFeeDto.getCodeCode());
        dbManager.setString(3,prpLinterCompePayFeeDto.getCodeCName());
        dbManager.setString(4,prpLinterCompePayFeeDto.getKindCode());
        dbManager.setString(5,prpLinterCompePayFeeDto.getKindName());
        dbManager.setString(6,prpLinterCompePayFeeDto.getCheckDeptName());
        dbManager.setString(7,prpLinterCompePayFeeDto.getCurrency());
        dbManager.setString(8,prpLinterCompePayFeeDto.getCurrencyName());
        dbManager.setDouble(9,prpLinterCompePayFeeDto.getChargeAmount());
        dbManager.setDouble(10,prpLinterCompePayFeeDto.getPreChargeAmount());
        dbManager.setDouble(11,prpLinterCompePayFeeDto.getSumRealPay());
        dbManager.setString(12,prpLinterCompePayFeeDto.getCheckDeptCode());
        //���������ֶ�;
        dbManager.setString(13,prpLinterCompePayFeeDto.getId());
        dbManager.setInt(14,prpLinterCompePayFeeDto.getSerialNo());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param id ����pk
     * @param serialNo �������pk
     * @return PrpLinterCompePayFeeDto
     * @throws Exception
     */
    public PrpLinterCompePayFeeDto findByPrimaryKey(String id,int serialNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("Id,");
        buffer.append("SerialNo,");
        buffer.append("ItemKindNo,");
        buffer.append("CodeCode,");
        buffer.append("CodeCName,");
        buffer.append("KindCode,");
        buffer.append("KindName,");
        buffer.append("CheckDeptName,");
        buffer.append("Currency,");
        buffer.append("CurrencyName,");
        buffer.append("ChargeAmount,");
        buffer.append("PreChargeAmount,");
        buffer.append("SumRealPay,");
        buffer.append("CheckDeptCode ");
        buffer.append("FROM PrpLinterCompePayFee ");
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
        PrpLinterCompePayFeeDto prpLinterCompePayFeeDto = null;
        if(resultSet.next()){
            prpLinterCompePayFeeDto = new PrpLinterCompePayFeeDto();
            prpLinterCompePayFeeDto.setId(dbManager.getString(resultSet,1));
            prpLinterCompePayFeeDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpLinterCompePayFeeDto.setItemKindNo(dbManager.getInt(resultSet,3));
            prpLinterCompePayFeeDto.setCodeCode(dbManager.getString(resultSet,4));
            prpLinterCompePayFeeDto.setCodeCName(dbManager.getString(resultSet,5));
            prpLinterCompePayFeeDto.setKindCode(dbManager.getString(resultSet,6));
            prpLinterCompePayFeeDto.setKindName(dbManager.getString(resultSet,7));
            prpLinterCompePayFeeDto.setCheckDeptName(dbManager.getString(resultSet,8));
            prpLinterCompePayFeeDto.setCurrency(dbManager.getString(resultSet,9));
            prpLinterCompePayFeeDto.setCurrencyName(dbManager.getString(resultSet,10));
            prpLinterCompePayFeeDto.setChargeAmount(dbManager.getDouble(resultSet,11));
            prpLinterCompePayFeeDto.setPreChargeAmount(dbManager.getDouble(resultSet,12));
            prpLinterCompePayFeeDto.setSumRealPay(dbManager.getDouble(resultSet,13));
            prpLinterCompePayFeeDto.setCheckDeptCode(dbManager.getString(resultSet,14));
        }
        resultSet.close();
        return prpLinterCompePayFeeDto;
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
        buffer.append("CodeCode,");
        buffer.append("CodeCName,");
        buffer.append("KindCode,");
        buffer.append("KindName,");
        buffer.append("CheckDeptName,");
        buffer.append("Currency,");
        buffer.append("CurrencyName,");
        buffer.append("ChargeAmount,");
        buffer.append("PreChargeAmount,");
        buffer.append("SumRealPay,");
        buffer.append("CheckDeptCode ");
        buffer.append("FROM PrpLinterCompePayFee WHERE ");
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
        PrpLinterCompePayFeeDto prpLinterCompePayFeeDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLinterCompePayFeeDto = new PrpLinterCompePayFeeDto();
            prpLinterCompePayFeeDto.setId(dbManager.getString(resultSet,"Id"));
            prpLinterCompePayFeeDto.setSerialNo(dbManager.getInt(resultSet,"SerialNo"));
            prpLinterCompePayFeeDto.setItemKindNo(dbManager.getInt(resultSet,"ItemKindNo"));
            prpLinterCompePayFeeDto.setCodeCode(dbManager.getString(resultSet,"CodeCode"));
            prpLinterCompePayFeeDto.setCodeCName(dbManager.getString(resultSet,"CodeCName"));
            prpLinterCompePayFeeDto.setKindCode(dbManager.getString(resultSet,"KindCode"));
            prpLinterCompePayFeeDto.setKindName(dbManager.getString(resultSet,"KindName"));
            prpLinterCompePayFeeDto.setCheckDeptName(dbManager.getString(resultSet,"CheckDeptName"));
            prpLinterCompePayFeeDto.setCurrency(dbManager.getString(resultSet,"Currency"));
            prpLinterCompePayFeeDto.setCurrencyName(dbManager.getString(resultSet,"CurrencyName"));
            prpLinterCompePayFeeDto.setChargeAmount(dbManager.getDouble(resultSet,"ChargeAmount"));
            prpLinterCompePayFeeDto.setPreChargeAmount(dbManager.getDouble(resultSet,"PreChargeAmount"));
            prpLinterCompePayFeeDto.setSumRealPay(dbManager.getDouble(resultSet,"SumRealPay"));
            prpLinterCompePayFeeDto.setCheckDeptCode(dbManager.getString(resultSet,"CheckDeptCode"));
            collection.add(prpLinterCompePayFeeDto);
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
        buffer.append("DELETE FROM PrpLinterCompePayFee WHERE ");
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
        buffer.append("SELECT count(1) FROM PrpLinterCompePayFee WHERE ");
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
