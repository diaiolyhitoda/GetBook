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
    // 诗词名句网URL
    private final static String URL = "http://www.shicimingju.com";
    // 古典名著URL 前缀
    private final static String PREFIX = "sanguoyanyi";  //网站书名前缀
    private String DIRECTORY;
    private String CHAPTER ;     //章节目录名





    @Test
    public void test3 () throws IOException {//此方法用来获取书籍名中文列表（用来创建书名）
        Document document = Jsoup.connect("http://www.shicimingju.com/book/index.html").header("Accept-language", "zh-cn").get();
        Elements elements = document.select("h2");
        Elements li = document.select("li");
        for (Element element : elements) {
            Element a = element.select("a").first();
            if (a != null) {
                System.out.println(a.attr("abs:href"));
            }
        }
        File file;//创建文件夹
        FileOutputStream stream = null;//new文件流
        for (Element element : elements) {
            Element a = element.select("a").first();
            String DIRECTORY=a.text() ;  //文件目录名
            try {
                file = new File("C:/Users/Administrator/Desktop/个人空间/workspace/小说/"+DIRECTORY+"/"+CHAPTER+".txt");

                if (!file.getParentFile().exists()&&!file.isDirectory()){
                    file.getParentFile().mkdirs();
                    file.createNewFile();
                } else {
                    file.createNewFile();
                }

                byte[] contentInBytes = a.text().getBytes();//转化成字节形
                stream = new FileOutputStream(file);//将文件夹放在文件流中
                stream.write(contentInBytes);//写入
                stream.flush(); //写完之后刷新
                stream.close();//关闭流
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


        }

    }


}




