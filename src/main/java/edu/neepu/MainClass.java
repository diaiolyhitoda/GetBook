package edu.neepu;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class MainClass {


    @Test
    public void test12() throws IOException {
        for (int i = 1; i <=120; i++) {//初步实现对第一整本书籍的爬取
            Document document = Jsoup.connect("http://www.shicimingju.com/book/sanguoyanyi/"+i+".html").header("Accept-language", "zh-cn").get();
            Elements elements = document.select(".layui-col-md8");
            for (Element element : elements) {
                Element a = element.select(".www-main-container").first();
                if (a != null) {
                    System.out.println(a.text());
                }

                System.out.println("-----------------");
            }

        }

    }

}



