package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplaccidangerclaimsdDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplaccidangerclaimsd;

/**
 * ����PRPLACCIDANGERCLAIMSD��ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrplaccidangerclaimsdAction extends BLPrplaccidangerclaimsdActionBase{
    private static Logger logger = Logger.getLogger(BLPrplaccidangerclaimsdAction.class);

    /**
     * ���캯��
     */
    public BLPrplaccidangerclaimsdAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prplaccidangerclaimsdDto prplaccidangerclaimsdDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrplaccidangerclaimsdDto prplaccidangerclaimsdDto,String mode)
            throws Exception{
    }
}
