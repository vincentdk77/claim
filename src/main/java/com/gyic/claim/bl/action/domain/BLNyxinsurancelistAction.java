package com.gyic.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.NyxinsurancelistDto;
import com.gyic.claim.resource.dtofactory.domain.DBNyxinsurancelist;

/**
 * ����NYXINSURANCELIST��ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLNyxinsurancelistAction extends BLNyxinsurancelistActionBase{
    private static Logger logger = Logger.getLogger(BLNyxinsurancelistAction.class);

    /**
     * ���캯��
     */
    public BLNyxinsurancelistAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param nyxinsurancelistDto nyxinsurancelistDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,NyxinsurancelistDto nyxinsurancelistDto,String mode)
            throws Exception{
    }
}
