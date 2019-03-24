package com.sinosoft.workrove.util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.sinosoft.claim.dto.domain.PrpDcompanyDto;
import com.sinosoft.platform.dto.domain.PrpDcodeDto;
import com.sinosoft.workrove.dto.domain.PrplclaimdcompanyDto;

/**
 * ����ת��������
 * @author Administrator
 *
 */
public class DataCovert{ 
	/**
	 * ��ҵ�����ݶ���ת��Ϊ���ͽṹ����
	 * @param colls ԭ����
	 * @param codeType ��������
	 * @return
	 */
	public static Collection collectionToTree(Collection colls,String codeType){
		Collection trees = new ArrayList();
		if("ComCode".equals(codeType)){
			Iterator it = colls.iterator();
			while(it.hasNext()){
				DTreeDto dTreeDto = new DTreeDto();
				 PrplclaimdcompanyDto prplclaimdcompanyDto = (PrplclaimdcompanyDto)it.next();
				//PrpclaimDcompanyDto prpDcompanyDto = (PrpDcompanyDto)it.next();
				dTreeDto.setId(prplclaimdcompanyDto.getComcode());
				if(prplclaimdcompanyDto.getUppercomcode().equals(prplclaimdcompanyDto.getComcode())){
					dTreeDto.setParentId("10");
				}else{
					dTreeDto.setParentId(prplclaimdcompanyDto.getUppercomcode());
				}
				dTreeDto.setName(prplclaimdcompanyDto.getComname());
				trees.add(dTreeDto);
			}
			
		}
		
		System.out.println(trees.size());
		return trees;
	}
}
