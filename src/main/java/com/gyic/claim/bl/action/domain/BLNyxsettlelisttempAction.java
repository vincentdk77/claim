package com.gyic.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.NyxsettlelisttempDto;
import com.gyic.claim.resource.dtofactory.domain.DBNyxsettlelisttemp;

/**
 * ����NYXSETTLELISTTEMP��ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLNyxsettlelisttempAction extends BLNyxsettlelisttempActionBase{
    private static Logger logger = Logger.getLogger(BLNyxsettlelisttempAction.class);

    /**
     * ���캯��
     */
    public BLNyxsettlelisttempAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param nyxsettlelisttempDto nyxsettlelisttempDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,NyxsettlelisttempDto nyxsettlelisttempDto,String mode)
            throws Exception{
    }
}
