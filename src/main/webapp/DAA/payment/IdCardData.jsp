<%@page import="com.sinosoft.sysframework.reference.AppConfig"%>
<%@page import="java.io.ByteArrayOutputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.net.HttpURLConnection"%>
<%@page import="java.net.MalformedURLException"%>
<%@page import="java.net.URL"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.InputStreamReader"%>
<% 
try {
    String fileName=request.getParameter("fileName");
    String filePath=AppConfig.get("sysconst.OCR_URL");
	String jsonString = "";
	String urlString="";
	File file = new File(filePath+"/"+fileName);
	System.out.println(file);
	urlString=AppConfig.get("sysconst.BANK_ADDRESS");
	URL url = new URL(urlString);
	HttpURLConnection con = (HttpURLConnection) url.openConnection();
	con.setDoOutput(true);
	con.setDoInput(true);
	con.setRequestMethod("POST");
	OutputStream os = con.getOutputStream();
	FileInputStream inputStream = new FileInputStream(file);
	byte[] data = new byte[2048];
	int len = 0;
	int sum = 0;
	while ((len = inputStream.read(data))!= -1) {
		os.write(data, 0, len);
		sum = len + sum;
	}
	System.out.println("upload size="+sum);
	os.flush();
	inputStream.close();
	os.close();
	
	int code = con.getResponseCode();
	System.out.println("code="+code+ " url="+url);
	if (code==200) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
		String line;
		
		while ((line = reader.readLine()) != null) {
			jsonString = jsonString + line;
		}
		reader.close();
		System.out.println("result ="+jsonString);		
	}
	con.disconnect();
	response.getWriter().write(jsonString);
	   if(file.isFile()){
	file.delete();
	}  
} catch (MalformedURLException e) {
	e.printStackTrace();
} catch (IOException e) {
	e.printStackTrace();
}

%>

