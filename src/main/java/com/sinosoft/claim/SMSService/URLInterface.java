package com.sinosoft.claim.SMSService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class URLInterface {
	private String urlPath = "";
	private Map map = null;
	
	public URLInterface(String urlPath){
		this.urlPath = urlPath;
	}
	
	public URLInterface(String urlPath,Map paramMap){
		this.urlPath = urlPath;
		this.map = paramMap;
	}
	
	/**发送
	 * @throws IOException */
	public String send() throws IOException{
		String rtnStr = "";
		String param = this.doParamMap();
		BufferedReader br = null;
		
		try{
			URL url = new URL(this.urlPath+param);
			URLConnection conn = url.openConnection();
			conn.setDoInput(true);
			br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = br.readLine();
    		while(line != null){
    			rtnStr += line;
    			line = br.readLine();
    		}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(br != null) br.close();
		}
		return rtnStr;
	}
	
	/**发送*/
	public String send(Map paramMap){
		String rtnStr = "";
		this.map = paramMap;
		String param = this.doParamMap();
		try{
			URL url = new URL(this.urlPath+param);
			URLConnection conn = url.openConnection();
			conn.setDoInput(true);
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = br.readLine();
    		while(line != null){
    			rtnStr += line;
    			line = br.readLine();
    		}
		}catch(Exception e){
			e.printStackTrace();
		}
		return rtnStr;
	}
	/**编码参数*/
	private String doParamMap() {
		StringBuffer sbStr = new StringBuffer("");
		if(this.map !=null){
			Iterator itr = map.entrySet().iterator();
			while(itr.hasNext()){
				Map.Entry entry = (Map.Entry)itr.next();
				String key = (String)entry.getKey();
				Object value = entry.getValue();
				if(value instanceof Collection){
					for(Iterator it = ((Collection)value).iterator();it.hasNext();){
						sbStr.append("&").append(key).append("=").append(it.next());
					}
				}else{
					sbStr.append("&").append(key).append("=").append(value);
				}
			}
			int point = sbStr.indexOf("&");
			if(point>-1){
				sbStr.replace(point, point+1, "?");
			}
		}
		return sbStr.toString();
	}
	
}
