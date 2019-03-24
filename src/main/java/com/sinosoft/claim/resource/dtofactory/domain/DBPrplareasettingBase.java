package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplareasettingDto;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLAREASETTING�����ݷ��ʶ������<br>
 */
public class DBPrplareasettingBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrplareasettingBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrplareasettingBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prplareasettingDto prplareasettingDto
     * @throws Exception
     */
    public void insert(PrplareasettingDto prplareasettingDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Prplareasetting (");
        buffer.append("Id,");
        buffer.append("Handlercode,");
        buffer.append("Handledept,");
        buffer.append("Handlername,");
        buffer.append("Area,");
        buffer.append("Tel,");
        buffer.append("Operator,");
        buffer.append("Operatorid,");
        buffer.append("Flowintime,");
        buffer.append("Modifytime,");
        buffer.append("Classcode ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prplareasettingDto.getId()).append("',");
            debugBuffer.append("'").append(prplareasettingDto.getHandlercode()).append("',");
            debugBuffer.append("'").append(prplareasettingDto.getHandledept()).append("',");
            debugBuffer.append("'").append(prplareasettingDto.getHandlername()).append("',");
            debugBuffer.append("'").append(prplareasettingDto.getArea()).append("',");
            debugBuffer.append("'").append(prplareasettingDto.getTel()).append("',");
            debugBuffer.append("'").append(prplareasettingDto.getOperator()).append("',");
            debugBuffer.append("'").append(prplareasettingDto.getOperatorid()).append("',");
            debugBuffer.append("'").append(prplareasettingDto.getFlowintime()).append("',");
            debugBuffer.append("'").append(prplareasettingDto.getModifytime()).append("',");
            debugBuffer.append("'").append(prplareasettingDto.getClasscode()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prplareasettingDto.getId());
        dbManager.setString(2,prplareasettingDto.getHandlercode());
        dbManager.setString(3,prplareasettingDto.getHandledept());
        dbManager.setString(4,prplareasettingDto.getHandlername());
        dbManager.setString(5,prplareasettingDto.getArea());
        dbManager.setString(6,prplareasettingDto.getTel());
        dbManager.setString(7,prplareasettingDto.getOperator());
        dbManager.setString(8,prplareasettingDto.getOperatorid());
        dbManager.setString(9,prplareasettingDto.getFlowintime());
        dbManager.setString(10,prplareasettingDto.getModifytime());
        dbManager.setString(11,prplareasettingDto.getClasscode());
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
        buffer.append("INSERT INTO Prplareasetting (");
        buffer.append("Id,");
        buffer.append("Handlercode,");
        buffer.append("Handledept,");
        buffer.append("Handlername,");
        buffer.append("Area,");
        buffer.append("Tel,");
        buffer.append("Operator,");
        buffer.append("Operatorid,");
        buffer.append("Flowintime,");
        buffer.append("Modifytime,");
        buffer.append("Classcode ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        
        
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrplareasettingDto prplareasettingDto = (PrplareasettingDto)i.next();
            if("".equals(prplareasettingDto.getId()) || prplareasettingDto.getId() == null){
            	ResultSet mrs=null; 
            	String bz= " "; 
            	int curral=0; 
            	mrs=dbManager.executeQuery( "select areaSettingSequence.Nextval from dual "); 
            	if(mrs.next()){ 
            		curral=mrs.getInt(1); 
            		prplareasettingDto.setId(String.valueOf(curral));
            	}
            }
            dbManager.setString(1,prplareasettingDto.getId());
            dbManager.setString(2,prplareasettingDto.getHandlercode());
            dbManager.setString(3,prplareasettingDto.getHandledept());
            dbManager.setString(4,prplareasettingDto.getHandlername());
            dbManager.setString(5,prplareasettingDto.getArea());
            dbManager.setString(6,prplareasettingDto.getTel());
            dbManager.setString(7,prplareasettingDto.getOperator());
            dbManager.setString(8,prplareasettingDto.getOperatorid());
            dbManager.setString(9,prplareasettingDto.getFlowintime());
            dbManager.setString(10,prplareasettingDto.getModifytime());
            dbManager.setString(11,prplareasettingDto.getClasscode());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param id ID
     * @throws Exception
     */
    public void delete(String id)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM Prplareasetting ");
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
     * @param prplareasettingDto prplareasettingDto
     * @throws Exception
     */
    public void update(PrplareasettingDto prplareasettingDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Prplareasetting SET ");
        buffer.append("Handlercode = ?, ");
        buffer.append("Handledept = ?, ");
        buffer.append("Handlername = ?, ");
        buffer.append("Area = ?, ");
        buffer.append("Tel = ?, ");
        buffer.append("Operator = ?, ");
        buffer.append("Operatorid = ?, ");
        buffer.append("Flowintime = ?, ");
        buffer.append("Modifytime = ?, ");
        buffer.append("Classcode = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE Prplareasetting SET ");
            debugBuffer.append("Handlercode = '" + prplareasettingDto.getHandlercode() + "', ");
            debugBuffer.append("Handledept = '" + prplareasettingDto.getHandledept() + "', ");
            debugBuffer.append("Handlername = '" + prplareasettingDto.getHandlername() + "', ");
            debugBuffer.append("Area = '" + prplareasettingDto.getArea() + "', ");
            debugBuffer.append("Tel = '" + prplareasettingDto.getTel() + "', ");
            debugBuffer.append("Operator = '" + prplareasettingDto.getOperator() + "', ");
            debugBuffer.append("Operatorid = '" + prplareasettingDto.getOperatorid() + "', ");
            debugBuffer.append("Flowintime = '" + prplareasettingDto.getFlowintime() + "', ");
            debugBuffer.append("Modifytime = '" + prplareasettingDto.getModifytime() + "', ");
            debugBuffer.append("Classcode = '" + prplareasettingDto.getClasscode() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Id=").append("'").append(prplareasettingDto.getId()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Id = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setString(1,prplareasettingDto.getHandlercode());
        dbManager.setString(2,prplareasettingDto.getHandledept());
        dbManager.setString(3,prplareasettingDto.getHandlername());
        dbManager.setString(4,prplareasettingDto.getArea());
        dbManager.setString(5,prplareasettingDto.getTel());
        dbManager.setString(6,prplareasettingDto.getOperator());
        dbManager.setString(7,prplareasettingDto.getOperatorid());
        dbManager.setString(8,prplareasettingDto.getFlowintime());
        dbManager.setString(9,prplareasettingDto.getModifytime());
        dbManager.setString(10,prplareasettingDto.getClasscode());
        //���������ֶ�;
        dbManager.setString(11,prplareasettingDto.getId());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param id ID
     * @return PrplareasettingDto
     * @throws Exception
     */
    public PrplareasettingDto findByPrimaryKey(String id)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("Id,");
        buffer.append("Handlercode,");
        buffer.append("Handledept,");
        buffer.append("Handlername,");
        buffer.append("Area,");
        buffer.append("Tel,");
        buffer.append("Operator,");
        buffer.append("Operatorid,");
        buffer.append("Flowintime,");
        buffer.append("Modifytime,");
        buffer.append("Classcode ");
        buffer.append("FROM Prplareasetting ");
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
        PrplareasettingDto prplareasettingDto = null;
        if(resultSet.next()){
            prplareasettingDto = new PrplareasettingDto();
            prplareasettingDto.setId(dbManager.getString(resultSet,1));
            prplareasettingDto.setHandlercode(dbManager.getString(resultSet,2));
            prplareasettingDto.setHandledept(dbManager.getString(resultSet,3));
            prplareasettingDto.setHandlername(dbManager.getString(resultSet,4));
            prplareasettingDto.setArea(dbManager.getString(resultSet,5));
            prplareasettingDto.setTel(dbManager.getString(resultSet,6));
            prplareasettingDto.setOperator(dbManager.getString(resultSet,7));
            prplareasettingDto.setOperatorid(dbManager.getString(resultSet,8));
            prplareasettingDto.setFlowintime(dbManager.getString(resultSet,9));
            prplareasettingDto.setModifytime(dbManager.getString(resultSet,10));
            prplareasettingDto.setClasscode(dbManager.getString(resultSet,11));
        }
        resultSet.close();
        return prplareasettingDto;
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
        buffer.append("Handlercode,");
        buffer.append("Handledept,");
        buffer.append("Handlername,");
        buffer.append("Area,");
        buffer.append("Tel,");
        buffer.append("Operator,");
        buffer.append("Operatorid,");
        buffer.append("Flowintime,");
        buffer.append("Modifytime,");
        buffer.append("Classcode ");
        buffer.append("FROM Prplareasetting WHERE ");
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
        PrplareasettingDto prplareasettingDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            prplareasettingDto = new PrplareasettingDto();
            prplareasettingDto.setId(dbManager.getString(resultSet,"Id"));
            prplareasettingDto.setHandlercode(dbManager.getString(resultSet,"Handlercode"));
            prplareasettingDto.setHandledept(dbManager.getString(resultSet,"Handledept"));
            prplareasettingDto.setHandlername(dbManager.getString(resultSet,"Handlername"));
            prplareasettingDto.setArea(dbManager.getString(resultSet,"Area"));
            prplareasettingDto.setTel(dbManager.getString(resultSet,"Tel"));
            prplareasettingDto.setOperator(dbManager.getString(resultSet,"Operator"));
            prplareasettingDto.setOperatorid(dbManager.getString(resultSet,"Operatorid"));
            prplareasettingDto.setFlowintime(dbManager.getString(resultSet,"Flowintime"));
            prplareasettingDto.setModifytime(dbManager.getString(resultSet,"Modifytime"));
            prplareasettingDto.setClasscode(dbManager.getString(resultSet,"Classcode"));
            collection.add(prplareasettingDto);
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
        buffer.append("DELETE FROM Prplareasetting WHERE ");
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
        buffer.append("SELECT count(*) FROM Prplareasetting WHERE ");
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
