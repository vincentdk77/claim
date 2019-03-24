package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.HerdsettlelistDto;

/**
 * ����HERDSETTLELIST�����ݷ��ʶ�����<br>
 * ������ 2011-08-23 11:04:33.328<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBHerdsettlelist extends DBHerdsettlelistBase{
    private static Logger logger = Logger.getLogger(DBHerdsettlelist.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBHerdsettlelist(DBManager dbManager){
        super(dbManager);
    }

	public Collection findAccountByConditions(String conditions) throws Exception {
		StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("Settlelistcode,");
        buffer.append("Fname,");
        buffer.append("Fidcard,");
        buffer.append("max(Fcode) as Fcode,");
        buffer.append("max(Bankname) as Bankname,");
        buffer.append("max(Bankaccount) as Bankaccount,");
        buffer.append("sum(Settleamount) as Settleamount ");
        buffer.append("FROM Herdsettlelist WHERE ");
        buffer.append(conditions);
        buffer.append("group by ");
        buffer.append("Settlelistcode,Fname,Fidcard ");
        boolean supportPaging = false;//���ݿ��Ƿ�֧�ַ�ҳ
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        int count=0;

        //���巵�ؽ������
        Collection collection = new ArrayList();
        HerdsettlelistDto herdsettlelistDto = null;
        while(resultSet.next()){
            herdsettlelistDto = new HerdsettlelistDto();
            herdsettlelistDto.setSettlelistcode(dbManager.getString(resultSet,"Settlelistcode"));
            herdsettlelistDto.setFname(dbManager.getString(resultSet,"Fname"));
            herdsettlelistDto.setFidcard(dbManager.getString(resultSet,"Fidcard"));
            herdsettlelistDto.setFcode(dbManager.getString(resultSet,"Fcode"));
            herdsettlelistDto.setBankname(dbManager.getString(resultSet,"Bankname"));
            herdsettlelistDto.setBankaccount(dbManager.getString(resultSet,"Bankaccount"));
            herdsettlelistDto.setSettleamount(dbManager.getInt(resultSet,"Settleamount"));
            collection.add(herdsettlelistDto);
        }
        resultSet.close();
        return collection;
	}
}
