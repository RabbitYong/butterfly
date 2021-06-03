package com.rbty;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

/**
 * @author tuzhiyong
 * @version 1.0
 * @description: TODO
 * @date 2021/5/25 19:01
 */
public class Test {
    String provincetr = "provincetr";
    String citytr = "citytr";
    String countytr = "countytr";
    String towntr = "towntr";
    String villagetr = "villagetr";
    List<String> arrayList = new ArrayList<>();


    String s = "0000000000";
    String root = "http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2020/";
    List<Area> list = new ArrayList<>();
    Deque<Area> deque = new LinkedList<>();

    public void init() throws IOException {
        arrayList.add(provincetr);
        arrayList.add(citytr);
        arrayList.add(countytr);
        arrayList.add(towntr);
        arrayList.add(villagetr);

        Document doc = Jsoup.connect(root).get();
        Elements elements = doc.getElementsByClass(arrayList.get(0)).select("td > a");
        for (Element element :
                elements) {
            String href = element.attr("href");
            String name = element.text().replaceAll("<br>","");
            Long code = Long.valueOf(href.split("\\.")[0] + s);
            String subLink = root+href;
            Area area = new Area(code,name,1,0L,subLink);
            deque.add(area);
            list.add(area);
        }
    }

    public static void main(String[] args) throws IOException {
        Test test = new Test();
        test.init();
        test.push();
        System.out.println(test.arrayList.size());
    }
    public void push() throws IOException {
        while(!deque.isEmpty()){
            Area area = deque.poll();
            String link = area.getLink();
            Document subDoc = Jsoup.connect(link).get();
            Elements subElements = subDoc.getElementsByClass(arrayList.get(area.getLevel())).select("td > a");
            for (Element element :
                    subElements) {
                String href = element.attr("href");
                String name = element.text().replaceAll("<br>","");
                Long code = Long.valueOf(element.text());
                String subLink = root+href;
                Area subArea = new Area(code,name,area.getLevel()+1, area.getCode(), subLink);
                deque.add(subArea);
                list.add(subArea);
            }
            if (deque.peekLast().getLevel() == 3){
                return;
            }
        }
    }
}
