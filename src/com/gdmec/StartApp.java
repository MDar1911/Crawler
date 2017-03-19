package com.gdmec;

import java.io.UnsupportedEncodingException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class StartApp {
	
	
	public static void main(String[] args) {
		//for(int a=0;a<=3;a++){

		String[] city={"Java开发工程师","android开发工程师","微信开发工程师","前端开发工程师"};
		try {
			String nameStr=new String(java.net.URLEncoder.encode(city[3],"utf-8").getBytes());
			//System.out.println(nameStr);
			for(int i=1;i<=150;i++){
				String url="http://search.51job.com/jobsearch/search_result.php?fromJs=1&jobarea=180200%2C00&district=000000&funtype=0000&industrytype=00&issuedate=9&providesalary=99&keyword="+nameStr+"&keywordtype=2&curr_page="+i +
						"&lang=c&stype=1&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&lonlat=0%2C0&radius=-1&ord_field=0&list_type=0&fromType=14&dibiaoid=0&confirmdate=9";

				try {
					String result=HttpUtils.doGet(url);
					Document doc=Jsoup.parse(result);
					//System.out.println(result);
					Elements links=doc.select("div.dw_table div.el");
					for(Element works:links){
						//System.out.println(works);

							getit(works);
							
						
					}
					//System.out.println("#########");
					
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
	//}		
	}
	
	public static void getit(Element works){
		String workname="";
		String company="";
		String dizhi="";
		String salary="";
		
		Elements it=works.select(".t1");
		if(it!=null&&it.size()>0){
			workname=it.get(0).text();
		}
		
		it=works.select(".t2");
		if(it!=null&&it.size()>0){
			company=it.get(0).text();
		}
		
		it=works.select(".t3");
		if(it!=null&&it.size()>0){
			dizhi=it.get(0).text();
		}
		
		it=works.select(".t4");
		if(it!=null&&it.size()>0){
			salary=it.get(0).text();
		}
		
		if(!workname.equals("职位名")){
			System.out.println(workname+";"+company+";"+dizhi+";"+salary);
		}
		
		
	}

}
