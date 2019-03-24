package com.sinosoft.claim.webservice.paymentinformatino;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.sinosoft.claim.dto.domain.PrplreturnvisitDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplreturnvisitBase;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PRPLAGRIRETURNVISIT的数据访问对象基类<br>
 * @author Administrator
 *
 */
public class DBPrplAgrireturnvisitBase {
	 /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrplAgrireturnvisitBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrplAgrireturnvisitBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prplreturnvisitDto prplreturnvisitDto
     * @throws Exception
     */
    public void insert(PrplagrireturnvisitDto prplagrireturnvisitDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Prplagrireturnvisit (");
        buffer.append("BusinessNo,");
        buffer.append("Serialno,");
        buffer.append("Contact,");
        buffer.append("Recorderno,");
        buffer.append("Service,");
        buffer.append("Existissue,");
        buffer.append("Visitsuccess,");
        buffer.append("Visitnocause,");
        buffer.append("Visitopinion,");
        buffer.append("Enteringcode,");
        buffer.append("Enteringname,");
        buffer.append("Enteringcomcode,");
        buffer.append("Enteringtime");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prplagrireturnvisitDto.getBusinessNo()).append("',");
            debugBuffer.append("'").append(prplagrireturnvisitDto.getSerialno()).append("',");
            debugBuffer.append("'").append(prplagrireturnvisitDto.getContact()).append("',");
            debugBuffer.append("'").append(prplagrireturnvisitDto.getRecorderno()).append("',");
            debugBuffer.append("'").append(prplagrireturnvisitDto.getService()).append("',");
            debugBuffer.append("'").append(prplagrireturnvisitDto.getExistissue()).append("',");
            debugBuffer.append("'").append(prplagrireturnvisitDto.getVisitsuccess()).append("',");
            debugBuffer.append("'").append(prplagrireturnvisitDto.getVisitnocause()).append("',");
            debugBuffer.append("'").append(prplagrireturnvisitDto.getVisitopinion()).append("',");
            debugBuffer.append("'").append(prplagrireturnvisitDto.getEnteringcode()).append("',");
            debugBuffer.append("'").append(prplagrireturnvisitDto.getEnteringname()).append("',");
            debugBuffer.append("'").append(prplagrireturnvisitDto.getEnteringcomcode()).append("',");
            debugBuffer.append("'").append(prplagrireturnvisitDto.getEnteringtime()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prplagrireturnvisitDto.getBusinessNo());
        dbManager.setString(2,prplagrireturnvisitDto.getSerialno());
        dbManager.setString(3,prplagrireturnvisitDto.getContact());
        dbManager.setString(4,prplagrireturnvisitDto.getRecorderno());
        dbManager.setString(5,prplagrireturnvisitDto.getService());
        dbManager.setString(6,prplagrireturnvisitDto.getExistissue());
        dbManager.setString(7,prplagrireturnvisitDto.getVisitsuccess());
        dbManager.setString(8,prplagrireturnvisitDto.getVisitnocause());
        dbManager.setString(9,prplagrireturnvisitDto.getVisitopinion());
        dbManager.setString(10,prplagrireturnvisitDto.getEnteringcode());
        dbManager.setString(11,prplagrireturnvisitDto.getEnteringname());
        dbManager.setString(12,prplagrireturnvisitDto.getEnteringcomcode());
        dbManager.setDateTime(13,prplagrireturnvisitDto.getEnteringtime());
        dbManager.executePreparedUpdate();

    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Prplagrireturnvisit (");
        buffer.append("BusinessNo,");
        buffer.append("Serialno,");
        buffer.append("Contact,");
        buffer.append("Recorderno,");
        buffer.append("Service,");
        buffer.append("Existissue,");
        buffer.append("Visitsuccess,");
        buffer.append("Visitnocause,");
        buffer.append("Visitopinion,");
        buffer.append("Enteringcode,");
        buffer.append("Enteringname,");
        buffer.append("Enteringcomcode,");
        buffer.append("Enteringtime ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
        	PrplagrireturnvisitDto prplagrireturnvisitDto = (PrplagrireturnvisitDto)i.next();
            dbManager.setString(1,prplagrireturnvisitDto.getBusinessNo());
            dbManager.setString(2,prplagrireturnvisitDto.getSerialno());
            dbManager.setString(3,prplagrireturnvisitDto.getContact());
            dbManager.setString(4,prplagrireturnvisitDto.getRecorderno());
            dbManager.setString(5,prplagrireturnvisitDto.getService());
            dbManager.setString(6,prplagrireturnvisitDto.getExistissue());
            dbManager.setString(7,prplagrireturnvisitDto.getVisitsuccess());
            dbManager.setString(8,prplagrireturnvisitDto.getVisitnocause());
            dbManager.setString(9,prplagrireturnvisitDto.getVisitopinion());
            dbManager.setString(10,prplagrireturnvisitDto.getEnteringcode());
            dbManager.setString(11,prplagrireturnvisitDto.getEnteringname());
            dbManager.setString(12,prplagrireturnvisitDto.getEnteringcomcode());
            dbManager.setDateTime(13,prplagrireturnvisitDto.getEnteringtime());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param registno REGISTNO
     * @param serialno SERIALNO
     * @throws Exception
     */
    public void delete(String registno,String serialno)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM Prplagrireturnvisit ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("BusinessNo=").append("'").append(registno).append("' AND ");
            debugBuffer.append("Serialno=").append("'").append(serialno).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("BusinessNo = ? And ");
        buffer.append("Serialno = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,registno);
        dbManager.setString(2,serialno);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prplreturnvisitDto prplreturnvisitDto
     * @throws Exception
     */
    public void update(PrplagrireturnvisitDto prplagrireturnvisitDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Prplagrireturnvisit SET ");
        buffer.append("Contact = ?, ");
        buffer.append("Recorderno = ?, ");
        buffer.append("Service = ?, ");
        buffer.append("Existissue = ?, ");
        buffer.append("Visitsuccess = ?, ");
        buffer.append("Visitnocause = ?, ");
        buffer.append("Visitopinion = ?, ");
        buffer.append("Enteringcode = ?, ");
        buffer.append("Enteringname = ?, ");
        buffer.append("Enteringcomcode = ?, ");
        buffer.append("Enteringtime = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE Prplagrireturnvisit SET ");
            debugBuffer.append("Contact = '" + prplagrireturnvisitDto.getContact() + "', ");
            debugBuffer.append("Recorderno = '" + prplagrireturnvisitDto.getRecorderno() + "', ");
            debugBuffer.append("Service = '" + prplagrireturnvisitDto.getService() + "', ");
            debugBuffer.append("Existissue = '" + prplagrireturnvisitDto.getExistissue() + "', ");
            debugBuffer.append("Visitsuccess = '" + prplagrireturnvisitDto.getVisitsuccess() + "', ");
            debugBuffer.append("Visitnocause = '" + prplagrireturnvisitDto.getVisitnocause() + "', ");
            debugBuffer.append("Visitopinion = '" + prplagrireturnvisitDto.getVisitopinion() + "', ");
            debugBuffer.append("Enteringcode = '" + prplagrireturnvisitDto.getEnteringcode() + "', ");
            debugBuffer.append("Enteringname = '" + prplagrireturnvisitDto.getEnteringname() + "', ");
            debugBuffer.append("Enteringcomcode = '" + prplagrireturnvisitDto.getEnteringcomcode() + "', ");
            debugBuffer.append("Enteringtime = '" + prplagrireturnvisitDto.getEnteringtime() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("BusinessNo=").append("'").append(prplagrireturnvisitDto.getBusinessNo()).append("' AND ");
            debugBuffer.append("Serialno=").append("'").append(prplagrireturnvisitDto.getSerialno()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("BusinessNo = ? And ");
        buffer.append("Serialno = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prplagrireturnvisitDto.getContact());
        dbManager.setString(2,prplagrireturnvisitDto.getRecorderno());
        dbManager.setString(3,prplagrireturnvisitDto.getService());
        dbManager.setString(4,prplagrireturnvisitDto.getExistissue());
        dbManager.setString(5,prplagrireturnvisitDto.getVisitsuccess());
        dbManager.setString(6,prplagrireturnvisitDto.getVisitnocause());
        dbManager.setString(7,prplagrireturnvisitDto.getVisitopinion());
        dbManager.setString(8,prplagrireturnvisitDto.getEnteringcode());
        dbManager.setString(9,prplagrireturnvisitDto.getEnteringname());
        dbManager.setString(10,prplagrireturnvisitDto.getEnteringcomcode());
        dbManager.setDateTime(11,prplagrireturnvisitDto.getEnteringtime());
        //设置条件字段;
        dbManager.setString(12,prplagrireturnvisitDto.getBusinessNo());
        dbManager.setString(13,prplagrireturnvisitDto.getSerialno());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param registno REGISTNO
     * @param serialno SERIALNO
     * @return PrplreturnvisitDto
     * @throws Exception
     */
    public PrplagrireturnvisitDto findByPrimaryKey(String registno,String serialno)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("BusinessNo,");
        buffer.append("Serialno,");
        buffer.append("Contact,");
        buffer.append("Recorderno,");
        buffer.append("Service,");
        buffer.append("Existissue,");
        buffer.append("Visitsuccess,");
        buffer.append("Visitnocause,");
        buffer.append("Visitopinion,");
        buffer.append("Enteringcode,");
        buffer.append("Enteringname,");
        buffer.append("Enteringcomcode,");
        buffer.append("Enteringtime ");
        buffer.append("FROM Prplagrireturnvisit ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Registno=").append("'").append(registno).append("' AND ");
            debugBuffer.append("Serialno=").append("'").append(serialno).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Registno = ? And ");
        buffer.append("Serialno = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,registno);
        dbManager.setString(2,serialno);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrplagrireturnvisitDto prplagrireturnvisitDto = null;
        if(resultSet.next()){
        	prplagrireturnvisitDto = new PrplagrireturnvisitDto();
        	prplagrireturnvisitDto.setBusinessNo(dbManager.getString(resultSet,1));
        	prplagrireturnvisitDto.setSerialno(dbManager.getString(resultSet,2));
        	prplagrireturnvisitDto.setContact(dbManager.getString(resultSet,3));
            prplagrireturnvisitDto.setRecorderno(dbManager.getString(resultSet,4));
            prplagrireturnvisitDto.setService(dbManager.getString(resultSet,5));
            prplagrireturnvisitDto.setExistissue(dbManager.getString(resultSet,6));
            prplagrireturnvisitDto.setVisitsuccess(dbManager.getString(resultSet,7));
            prplagrireturnvisitDto.setVisitnocause(dbManager.getString(resultSet,8));
            prplagrireturnvisitDto.setVisitopinion(dbManager.getString(resultSet,9));
            prplagrireturnvisitDto.setEnteringcode(dbManager.getString(resultSet,10));
            prplagrireturnvisitDto.setEnteringname(dbManager.getString(resultSet,11));
            prplagrireturnvisitDto.setEnteringcomcode(dbManager.getString(resultSet,12));
            prplagrireturnvisitDto.setEnteringtime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,13));
        }
        resultSet.close();
        return prplagrireturnvisitDto;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("BusinessNo,");
        buffer.append("Serialno,");
        buffer.append("Contact,");
        buffer.append("Recorderno,");
        buffer.append("Service,");
        buffer.append("Existissue,");
        buffer.append("Visitsuccess,");
        buffer.append("Visitnocause,");
        buffer.append("Visitopinion,");
        buffer.append("Enteringcode,");
        buffer.append("Enteringname,");
        buffer.append("Enteringcomcode,");
        buffer.append("Enteringtime ");
        buffer.append("FROM Prplagrireturnvisit WHERE ");
        buffer.append(conditions);
        boolean supportPaging = false;//数据库是否支持分页
        if (pageNo > 0){
            //对Oracle优化
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
        System.err.println(buffer);
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        int count=0;
        if(supportPaging==false && pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        //定义返回结果集合
        Collection collection = new ArrayList(rowsPerPage);
        PrplagrireturnvisitDto prplagrireturnvisitDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            prplagrireturnvisitDto = new PrplagrireturnvisitDto();
            prplagrireturnvisitDto.setBusinessNo(dbManager.getString(resultSet,"BusinessNo"));
            prplagrireturnvisitDto.setSerialno(dbManager.getString(resultSet,"Serialno"));
            prplagrireturnvisitDto.setContact(dbManager.getString(resultSet,"Contact"));
            prplagrireturnvisitDto.setRecorderno(dbManager.getString(resultSet,"Recorderno"));
            prplagrireturnvisitDto.setService(dbManager.getString(resultSet,"Service"));
            prplagrireturnvisitDto.setExistissue(dbManager.getString(resultSet,"Existissue"));
            prplagrireturnvisitDto.setVisitsuccess(dbManager.getString(resultSet,"Visitsuccess"));
            prplagrireturnvisitDto.setVisitnocause(dbManager.getString(resultSet,"Visitnocause"));
            prplagrireturnvisitDto.setVisitopinion(dbManager.getString(resultSet,"Visitopinion"));
            prplagrireturnvisitDto.setEnteringcode(dbManager.getString(resultSet,"Enteringcode"));
            prplagrireturnvisitDto.setEnteringname(dbManager.getString(resultSet,"Enteringname"));
            prplagrireturnvisitDto.setEnteringcomcode(dbManager.getString(resultSet,"Enteringcomcode"));
            prplagrireturnvisitDto.setEnteringtime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"Enteringtime"));
            collection.add(prplagrireturnvisitDto);
        }
        resultSet.close();
        return collection;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
            throws Exception{
        return findByConditions(conditions,0,0);
    }

    /**
     * 按条件删除数据
     * @param conditions 查询条件
     * @return 删除的行数
     * @throws Exception
     */
    public int deleteByConditions(String conditions)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM Prplagrireturnvisit WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        System.err.println(buffer);
        int count = dbManager.executeUpdate(buffer.toString());
        return count;
    }

    /**
     * 查询满足模糊查询条件的记录数
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getCount(String conditions) 
        throws Exception{
        int count = -1;
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("SELECT count(1) FROM Prplagrireturnvisit WHERE ");
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
