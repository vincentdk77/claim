package com.gyic.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.NyxuploadinsurancelistDto;
import com.gyic.claim.resource.dtofactory.domain.DBNyxuploadinsurancelist;

/**
 * ����NYXUPLOADINSURANCELIST��ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLNyxuploadinsurancelistAction extends BLNyxuploadinsurancelistActionBase{
    private static Logger logger = Logger.getLogger(BLNyxuploadinsurancelistAction.class);

    /**
     * ���캯��
     */
    public BLNyxuploadinsurancelistAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param nyxuploadinsurancelistDto nyxuploadinsurancelistDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,NyxuploadinsurancelistDto nyxuploadinsurancelistDto,String mode)
            throws Exception{
    }
}
