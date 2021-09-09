package com.xsy.notebook.demo.basic.file;

import pdf.converter.PdfConverter;

import java.io.File;

/**
 * @author xushuyuan@zj.tech
 * @date 2021/8/27 18:33
 */
public class PDFConverter {

    public static void main(String[] args) {
        PdfConverter.convert(new File("/Users/xushuyuan/Desktop/电子书/重学Java设计模式·小傅哥(公众号：bugstack虫洞栈).pdf"))
                .intoEpub("1", new File("/Users/xushuyuan/Desktop/电子书/重学Java设计模式.epub"));
    }

}
