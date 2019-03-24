package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.dto.domain.PrpLpayHisDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpLpayHis�����ݷ��ʶ�����<br>
 * ������ 2013-10-25 10:55:44.093<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLpayHis extends DBPrpLpayHisBase{
    private static Logger logger = Logger.getLogger(DBPrpLpayHis.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLpayHis(DBManager dbManager){
        super(dbManager);
    }

	public Collection findByElement(String name, String registNo) throws Exception{
		StringBuffer buffer = new StringBuffer(200);
		buffer.append("select ");
		buffer.append(""+name+", ");
		buffer.append("max(editDate), ");
		buffer.append("operatorcode, ");
		buffer.append("operatorComCode ");
		buffer.append("from prplpayhis Where ");
		buffer.append("registno = '"+registNo+"' " );
		buffer.append("group by "+name+", operatorcode, operatorComCode ");
		buffer.append("order by max(editDate) ");System.err.println(buffer.toString());
		ResultSet resultSet = dbManager.executeQuery(buffer.toString());
		 //���巵�ؽ������
        Collection collection = new ArrayList();
		PrpLpayHisDto prpLpayHisDto = null;
		int count = 0;
		while(resultSet.next()){

            prpLpayHisDto = new PrpLpayHisDto();
            prpLpayHisDto.setSerialNo2(String.valueOf(++count));
            prpLpayHisDto.setPayreMark(dbManager.getString(resultSet,1));
            prpLpayHisDto.setEditDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,2));
            prpLpayHisDto.setOperatorCode(dbManager.getString(resultSet,3));
            prpLpayHisDto.setOperatorComCode(dbManager.getString(resultSet,4));
            collection.add(prpLpayHisDto);
        }
        resultSet.close();
        return collection;
	}
}
