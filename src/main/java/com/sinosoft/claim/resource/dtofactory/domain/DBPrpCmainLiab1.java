package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCmainLiabDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PRPTMAINLIAB-�����ձ�����Ϣ�����ݷ��ʶ�����<br>
 * ������ 2005-06-28 15:26:08.093<br>
 * JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpCmainLiab1 extends DBPrpCmainLiabBase{
    private static Log logger = LogFactory.getLog(DBPrpCmainLiab1.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpCmainLiab1(DBManager dbManager){
        super(dbManager);
    }
    public DateTime findByPrimaryKeyStartDate(String policyNo) throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");       
        buffer.append("BkWardStartDate ");
        buffer.append("FROM PrpCmainLiab ");
      
        buffer.append("WHERE ");
        buffer.append(policyNo);
        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpCmainLiabDto prpCmainLiabDto = null;
        if(resultSet.next()){
            prpCmainLiabDto = new PrpCmainLiabDto();
            prpCmainLiabDto.setBkWardStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,1));
        }else{
            logger.info("DBPrpCmainLiabBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        DateTime bkWardStartDate = new DateTime();
        if(prpCmainLiabDto!=null){
        	bkWardStartDate = prpCmainLiabDto.getBkWardStartDate();
        }     
        return bkWardStartDate;
    }
}
