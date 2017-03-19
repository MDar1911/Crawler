package com.gdmec;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class tianqi {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		for(int i=0;i<=80;i++){
		String[] a={"201101","201102","201103","201104","201105","201106","201107","201108","201109","201110","201111","201112",
				"201201","201202","201203","201204","201205","201206","201207","201208","201209","201210","201211","201212",
				"201301","201302","201303","201304","201305","201306","201307","201308","201309","201310","201311","201312",
				"201401","201402","201403","201404","201405","201406","201407","201408","201409","201410","201411","201412",
				"201501","201502","201503","201504","201505","201506","201507","201508","201509","201510","201511","201512",
				"201601","201602","201603","201604","201605","201606","201607","201608","201609","201610","201611","201612"};
		String url="http://lishi.tianqi.com/wuhan/"+a[i]+".html";
		try {
			String result=HttpUtils.doGet(url);
			Document doc=Jsoup.parse(result);
			//System.out.println(result);
			Elements links=doc.select("div.tqtongji2 ul");
			
			for(Element works:links){

				//System.out.println(works);

					getit(works);
				
			}
			
			
			
			
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		}
	}
	
	public static void getit(Element works){
		String workname="";
		String company="";
		String dizhi="";
		String salary="";
		String a="";
		
		Elements it=works.select("li");
		if(it!=null&&it.size()>5){
			workname=it.get(0).text();
			company=it.get(1).text();
			dizhi=it.get(2).text();
			dizhi=it.get(3).text();
			salary=it.get(4).text();
			a=it.get(5).text();
		}
		
		if(!workname.equals("日期")){
			System.out.println(workname+";"+company+";"+dizhi+";"+salary+";"+a);
		}
		
		
	}

}
