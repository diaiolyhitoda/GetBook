package edu.neepu;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainClass {


    @Test
    public void test12() throws IOException {

        File file;//创建文件夹
        FileOutputStream stream = null;//new文件流


        for (int i = 1; i <=120; i++) {
            Document document = Jsoup.connect("http://www.shicimingju.com/book/sanguoyanyi/"+i+".html").header("Accept-language", "zh-cn").get();
            Elements elements = document.select(".layui-col-md8");
            for (Element element : elements) {
                Element a = element.select(".www-main-container").first();


                try {
                    file = new File("C:/Users/Administrator/Desktop/Aa.txt");
                    stream = new FileOutputStream (file);//将文件夹放在文件流中
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    byte[] contentInBytes = a.text().getBytes();//转化成字节形
                    stream.write(contentInBytes);//写入
                    stream.flush(); //写完之后刷新
                    stream.close();//关闭流
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }

        }

    }

}



