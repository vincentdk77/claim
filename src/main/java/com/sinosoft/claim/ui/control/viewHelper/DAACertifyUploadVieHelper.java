package com.sinosoft.claim.ui.control.viewHelper;

import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;

import com.sinosoft.claim.bl.facade.BLPrpLcertifyImgFacade;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpLcertifyImgDto;
import com.sinosoft.claim.util.FtpClient;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.AppConfig;



public class DAACertifyUploadVieHelper {
	public Map paramMap;
	public int uploadFile(HttpServletRequest request,FtpClient ftp){
		try{
			List imgDtos = new ArrayList();
			BLPrpLcertifyImgFacade imgFacade = new BLPrpLcertifyImgFacade();
			DiskFileUpload upload = new DiskFileUpload();
			upload.setSizeMax(100 * 1024 * 1024);
			upload.setSizeThreshold(2 * 1024 * 1024);
			List files = upload.parseRequest(request);
			initParam(files);
			List uppers = checkFileSize(files);
			if(uppers.size() > 0){
				request.setAttribute("uppers", uppers);
				return -2;
			}
			String policyNo = getParameter("policyNo");
			String businessNo = getParameter("businessNo");
			String riskCode = getParameter("riskCode");
			String nodeType = getParameter("nodeType");
			String lossItemCode = getParameter("lossItemCode");
			String lossItemName = getParameter("lossItemName");
			//String collectorName = getParameter("collectorName");
			
			UserDto user = (UserDto)request.getSession().getAttribute("user");
			String collectorName  = user.getUserCode();
			
			String[] imageType = getParameterValues("imageType");
			String[] fileDesc  = getParameterValues("fileDesc");
			
			String typeCode = null;
			String picName = null;
			String uploadYear = null;
			String uploadFileName = null;
			String remoteFileName = null;
			String fileExtName = null;
			String yearMonthDay   = null;
			DateTime signInDate = null;
			long fileSize = 0;
			
			String picPath = null;
			
			SimpleDateFormat sf1 = new SimpleDateFormat("yyyyMMdd");
			SimpleDateFormat sf2 = new SimpleDateFormat("yyyy-MM-dd");
			
			Calendar c = Calendar.getInstance();
			uploadYear = String.valueOf(c.get(Calendar.YEAR));
			yearMonthDay = sf1.format(c.getTime());
			//图片上传时间显示到时分
			signInDate   = DateTime.current();
			int maxSerialNo = 0;
			int maxTypeCodeNo = 0;
		
			maxSerialNo = imgFacade.getCount("policyNo='"+policyNo+"' and businessNo='"+businessNo+"'");
			Map typeMap = new HashMap();
			String [] types = null;
			for(int i = 0;i < imageType.length;i++){
				types = imageType[i].split("@@");
				if(typeMap.get(types[0]) == null){
					maxTypeCodeNo = imgFacade.getCount("policyNo='"+policyNo+"' and businessNo='"+businessNo+"' and typeCode='"+types[0]+"'");
					typeMap.put(types[0], maxTypeCodeNo);
				}
			}
			
			int index = 0;
			for(int i =0;i < files.size();i++){
				PrpLcertifyImgDto prpLcertifyImgDto = new PrpLcertifyImgDto();
				FileItem item = (FileItem)files.get(i);
				if(item.isFormField())
					continue;
				maxSerialNo++;
				maxTypeCodeNo++;
				
				types = imageType[index].split("@@");
				typeCode = types[0];
				picName  = types[1];
				uploadFileName = item.getName();
				
				fileSize       = item.getSize();
				uploadFileName = uploadFileName.replaceAll("\\\\", "/");
				int indexDisk  = uploadFileName.lastIndexOf("/");
				uploadFileName = uploadFileName.substring(indexDisk+1);
				int indexExt   = uploadFileName.lastIndexOf(".");
				fileExtName    = uploadFileName.substring(indexExt+1);
				remoteFileName = typeCode + "_" + getTypeCodeIndex(typeMap,typeCode) + "." +fileExtName;
				picPath ="/" + uploadYear + "/" + yearMonthDay + "/" + riskCode +
						 "/" + businessNo + "/" + typeCode+lossItemCode;
				ftp.mkdirs(picPath.substring(1));
				OutputStream out = ftp.getFileInputStream(ftp.pwd()+ picPath + "/" +remoteFileName);
				InputStream in = item.getInputStream();
				byte[] buff = new byte[1024];
				int len = 0;
				while((len = in.read(buff,0,buff.length)) != -1){
					out.write(buff, 0, len);
				}
				out.close();
				in.close();

				prpLcertifyImgDto.setPolicyNo(policyNo);
				prpLcertifyImgDto.setBusinessNo(businessNo);
				prpLcertifyImgDto.setSerialNo(maxSerialNo);
				prpLcertifyImgDto.setImgSize(fileSize);
				prpLcertifyImgDto.setLossItemCode(lossItemCode);
				prpLcertifyImgDto.setLossItemName(lossItemName);
				prpLcertifyImgDto.setPicName(typeCode + maxTypeCodeNo);
				prpLcertifyImgDto.setUploadFileName(uploadFileName);
				prpLcertifyImgDto.setDisplayName(fileDesc[index]);
				prpLcertifyImgDto.setImgFileName(remoteFileName);
				prpLcertifyImgDto.setPicName(picName);
				prpLcertifyImgDto.setPicPath(picPath);
				prpLcertifyImgDto.setTypeCode(typeCode);
				prpLcertifyImgDto.setUploadNodeFlag(nodeType);
				prpLcertifyImgDto.setThirdPartyCode("11111111");
				prpLcertifyImgDto.setReceiveStatus("11");
				prpLcertifyImgDto.setFlag("1");
				prpLcertifyImgDto.setCollectorName(collectorName);
				prpLcertifyImgDto.setValidStatus("1");
				prpLcertifyImgDto.setSignInDate(signInDate);
				imgDtos.add(prpLcertifyImgDto);
				index++;
			}
			imgFacade.insertAll(imgDtos);
			return 1;
			
		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}
	}
	public void initParam(List files)throws Exception{
		paramMap = new HashMap();
		for(int i =0;i < files.size();i++){
			FileItem item = (FileItem)files.get(i);
			if(item.isFormField()){
				String filedName = item.getFieldName();
				String filedContext = item.getString();
				filedName = new String(filedName.getBytes(),"GBK");
				filedContext = new String(filedContext.getBytes(),"GBK");
				putParam(paramMap,filedName,filedContext);
			}
		}
	}
	//控制车险上传照片大小在30K至150K之间 20110503 修改
	public List checkFileSize(List files){
		String riskCode = getParameter("riskCode");
		String classCode = riskCode.substring(0, 2);
		long maxLimit = 150 * 1024;
		long minLimit = 30 * 1024;
		String max = AppConfig.get("sysconst.MaxSize");
		String min = AppConfig.get("sysconst.MinSize");
		String info = null;
		List uppers =  new ArrayList();
		if(max != null && !max.equals("")){
			if("05".equals(classCode)){
				maxLimit = Integer.parseInt(max.trim()) * 1024;
			}else{
				maxLimit = 2 * 1024 * 1024;
			}
		}
		if(min != null && !"".equals(min)){
			minLimit = Integer.parseInt(min.trim()) * 1024;
		}
		for(int i =0;i < files.size();i++){
			FileItem item = (FileItem)files.get(i);
			if(!item.isFormField()){
				String fileName = item.getName();
				long fileSize = item.getSize();
				if("05".equals(classCode)){
					if(fileSize >= maxLimit || fileSize <= minLimit ){
						uppers.add(fileName);
					}
				}else{
					if(fileSize >= maxLimit){
						uppers.add(fileName);
					}
				}
			}
		}
		return uppers;
	}
	public void putParam(Map map,String name,String value){
		Object obj = map.get(name);
		if(obj == null){
			map.put(name, value);
		}
		else if(obj instanceof  List){
			List list = (List)obj;
			list.add(value);
		}
		else{
			List list = new ArrayList();
			list.add(obj);
			list.add(value);
			map.remove(name);
			map.put(name, list);
		}
	}
	public String getParameter(String name){
		Object obj = paramMap.get(name);
		String  value = null;
		if(obj == null){
			return null;
		}
		else if(obj instanceof String){
			value = (String)obj;
		}
		else{
			List list = (List)obj;
			value = (String)list.get(0);
		}
		
		return value;
	}
	public String[] getParameterValues(String name){
		Object obj = paramMap.get(name);
		String [] values = null;
		if(obj == null){
			return null;
		}
		else if(obj instanceof String){
			values = new String[1];
			values[0] = (String)obj;
		}
		else{
			List list = (List)obj;
			values = new String[list.size()];
			for(int i = 0;i<list.size();i++){
				values[i] = (String)list.get(i);
			}
		}
		
		return values;
	}
	public int getTypeCodeIndex(Map map,String typeCode){
		int value = (Integer)map.get(typeCode);
		map.remove(typeCode);
		map.put(typeCode, ++value);
		return value;
	}
}
