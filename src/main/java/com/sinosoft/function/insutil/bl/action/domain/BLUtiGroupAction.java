package com.sinosoft.function.insutil.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.UtiGroupDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����utigroup��ҵ�������չ��<br>
 * ������ 2004-4-5 15:16:32<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiGroupAction extends BLUtiGroupActionBase{
    private static Log log = LogFactory.getLog(BLUtiGroupAction.class.getName());

    /**
     * ���캯��
     */
    public BLUtiGroupAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param utiGroupDto utiGroupDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,UtiGroupDto utiGroupDto,String mode) throws Exception{
    }
}
