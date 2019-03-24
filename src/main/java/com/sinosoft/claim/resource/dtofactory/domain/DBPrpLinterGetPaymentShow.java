package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.dto.domain.PrpLinterPaymentShowDto;
import com.sinosoft.claim.dto.domain.PrpLinterPaymentInfoDto;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.DBManager;

public class DBPrpLinterGetPaymentShow{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrpLinterGetPaymentShow.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLinterGetPaymentShow(DBManager dbManager){
        this.dbManager = dbManager;
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
        buffer.append("ip.id as payId,");
        buffer.append("rl.outid as outId,");
        buffer.append("rl.relationregistno as registno,");
        buffer.append("cp.claimno,");
        buffer.append("cp.policyno,");
        buffer.append("cp.compensateno ");
        buffer.append("from prplinterpaymentinfo ip,prplinterrelation rl," +
        		"prplclaim cl,prplcompensate cp " +
        		"WHERE ip.relationoutid = rl.outid " +
//        		"and rl.id = ip.id " +
        		"and rl.relationregistno = cl.registno " +
        		"and cl.claimno = cp.claimno " +
        		"and cp.times = '1' ");
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
        PrpLinterPaymentShowDto prpLinterPayShowDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLinterPayShowDto = new PrpLinterPaymentShowDto();
            prpLinterPayShowDto.setPayId(dbManager.getString(resultSet,"payId"));
            prpLinterPayShowDto.setOutId(dbManager.getString(resultSet,"outId"));
            prpLinterPayShowDto.setRegistNo(dbManager.getString(resultSet,"registno"));
            prpLinterPayShowDto.setClaimNo(dbManager.getString(resultSet,"claimno"));
            prpLinterPayShowDto.setPolicyNo(dbManager.getString(resultSet,"policyno"));
            prpLinterPayShowDto.setCompensateNo(dbManager.getString(resultSet,"compensateno"));
            collection.add(prpLinterPayShowDto);
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

}
