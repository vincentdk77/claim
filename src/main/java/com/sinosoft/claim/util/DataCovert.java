package com.sinosoft.claim.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.sinosoft.claim.dto.custom.DTreeDto;
import com.sinosoft.claim.dto.domain.PrpDcompanyDto;

/**
 * 数据转换公共类
 * @author Administrator
 *
 */
public class DataCovert{
	/**
	 * 把业务数据对象转化为树型结构对象
	 * @param colls 原数据
	 * @param codeType 代码类型
	 * @return
	 */
	public static Collection collectionToTree(Collection colls,String codeType){
		Collection trees = new ArrayList();
		if("ComCode".equals(codeType)){
			Iterator it = colls.iterator();
			while(it.hasNext()){
				DTreeDto dTreeDto = new DTreeDto();
				PrpDcompanyDto prpDcompanyDto = (PrpDcompanyDto)it.next();
				dTreeDto.setId(prpDcompanyDto.getComCode());
				dTreeDto.setParentId(prpDcompanyDto.getUpperComCode());
				dTreeDto.setName(prpDcompanyDto.getComCName());
				trees.add(dTreeDto);
			}
			
		}else if("jobComCode".equals(codeType)){
			Iterator it = colls.iterator();
			while(it.hasNext()){
				DTreeDto dTreeDto = new DTreeDto();
				PrpDcompanyDto prpDcompanyDto = (PrpDcompanyDto)it.next();
				dTreeDto.setId(prpDcompanyDto.getComCode());
				dTreeDto.setParentId(prpDcompanyDto.getUpperComCode());
				dTreeDto.setName(prpDcompanyDto.getComCName());
				trees.add(dTreeDto);
			}
		}
		return trees;
	}
}
