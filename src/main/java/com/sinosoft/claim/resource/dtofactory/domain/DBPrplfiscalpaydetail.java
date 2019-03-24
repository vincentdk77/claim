package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplfiscalpaydetailDto;

/**
 * ����PRPLFISCALDETAILPAY�����ݷ��ʶ�����<br>
 * ������ 2014-07-18 09:09:47.984<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrplfiscalpaydetail extends DBPrplfiscalpaydetailBase{
    private static Logger logger = Logger.getLogger(DBPrplfiscalpaydetail.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrplfiscalpaydetail(DBManager dbManager){
        super(dbManager);
    }
    
    /**
     * ����֧����ǣ�
     * @param prplpayDto prplpayDto
     * @throws Exception
     */
    public void updateVFlag(String vflag,String fiscalno)
    throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Prplfiscalpaydetail SET ");
        buffer.append("vflag = ? ");
        buffer.append("WHERE ");
        //buffer.append("registno = ? And ");
        buffer.append("fiscalno = ? ");
        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setString(1,vflag);
        //���������ֶ�;
        dbManager.setString(2,fiscalno);
        dbManager.executePreparedUpdate();
        
    }
}
