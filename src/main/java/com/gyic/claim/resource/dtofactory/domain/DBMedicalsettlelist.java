package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.MedicalsettlelistDto;

/**
 * ����MedicalSETTLELISTTEMP�����ݷ��ʶ�����<br>
 * ������ 2011-12-13 09:24:38.828<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBMedicalsettlelist extends DBMedicalsettlelistBase{
    private static Logger logger = Logger.getLogger(DBMedicalsettlelist.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBMedicalsettlelist(DBManager dbManager){
        super(dbManager);
    }
}
