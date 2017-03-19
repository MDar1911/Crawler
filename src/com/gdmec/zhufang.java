package com.gdmec;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class zhufang {

	public static void main(String[] args) {
		for(int i=1;i<=100;i++){
		String url="http://zu.wuhan.fang.com/house/i3"+i+"/";
		try {
			String result=HttpUtils.doGet(url);
			Document doc=Jsoup.parse(result);
			//System.out.println(result);
			Elements links=doc.select("dd.info");
			int a=0;
			for(Element works:links){
				a++;
				//System.out.println(works);

					getit(works,a);
				
			}
			
			
			
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		}

	}
	
	public static void getit(Element works,int a){
		String title="";
		String font16="";
		String dizhi="";
		String jiaotong="";
		String salary="";
		
		Elements it=works.select("p.title");
		if(it!=null&&it.size()>0){
			title=it.get(0).text();
		}
		
		it=works.select("p.font16");
		if(it!=null&&it.size()>0){
			font16=it.get(0).text();
		}
		
		it=works.select("#rentid_D09_"+a+"_07");
		if(it!=null&&it.size()>0){
			dizhi=it.get(0).text();
		}
		
		it=works.select("p.gray6");
		if(it!=null&&it.size()>0){
			jiaotong=it.get(0).text();
		}
		
		it=works.select("div.moreInfo");
		if(it!=null&&it.size()>0){
			salary=it.get(0).text();
		}
		
		if(!title.equals("职位名")){
			System.out.println(title+";"+font16+";"+jiaotong+";"+dizhi+";"+salary);
		}
	}
}
