package com.example.xerces;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class XercesDemo {
    public static void main(String[] args) {
        try {
            DOMParser parser = new DOMParser();  // tạo đối tượng dùng để phân tích xml

            // lấy nguồn xml
            InputSource inputSource=new InputSource("xerces\\src\\main\\resources\\data.xml");

            //bắt đầu phân tích xml
            parser.parse(inputSource);



            // lấy đối tượng đã được phân tích từ document
            Document document = parser.getDocument();


            // Truy xuất các phần tử có thẻ <book> và lưu chúng vào nodelist
            NodeList nodeList = document.getElementsByTagName("book");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) //kiểm tra xem có phải là thẻ xml không
                {
                    org.w3c.dom.Element element = (org.w3c.dom.Element) node;
                    String title = element.getElementsByTagName("title").item(0).getTextContent();
                    String author = element.getElementsByTagName("author").item(0).getTextContent();
                    String year = element.getElementsByTagName("year").item(0).getTextContent();
                    String price = element.getElementsByTagName("price").item(0).getTextContent();

                    System.out.println("Title: " + title);
                    System.out.println("Author: " + author);
                    System.out.println("Year: " + year);
                    System.out.println("Price: " + price);
                    System.out.println("-----------------------------");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

