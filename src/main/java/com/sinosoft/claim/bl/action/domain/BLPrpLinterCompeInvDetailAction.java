package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterCompeInvDetailDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterCompeInvDetail;

/**
 * ���Ǵ�ҽ�ƽӿڲ����м���ӱ�������嵥��Ϣ��ϸ���ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLinterCompeInvDetailAction extends BLPrpLinterCompeInvDetailActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterCompeInvDetailAction.class);

    /**
     * ���캯��
     */
    public BLPrpLinterCompeInvDetailAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLinterCompeInvDetailDto prpLinterCompeInvDetailDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLinterCompeInvDetailDto prpLinterCompeInvDetailDto,String mode)
            throws Exception{
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLinterCompeInvDetailDto[] prpLinterCompeInvDetailDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinterCompeInvDetailDto[] prpLinterCompeInvDetailDto)
            throws Exception{
        DBPrpLinterCompeInvDetail dbPrpLinterCompeInvDetail = new DBPrpLinterCompeInvDetail(dbManager);
        //�����¼
        for(int i=0;i<prpLinterCompeInvDetailDto.length;i++){
        	dbPrpLinterCompeInvDetail.insert(prpLinterCompeInvDetailDto[i]);
        }
    }
}
