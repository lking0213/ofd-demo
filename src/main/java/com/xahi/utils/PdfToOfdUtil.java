package com.xahi.utils;

import com.spire.pdf.FileFormat;
import com.spire.pdf.PdfDocument;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * @author: liwq
 * @create: 2022-06-22 11:13
 * @description:
 */
public class PdfToOfdUtil {
    public static void main(String[] args) {
        pdfToOfd("G:\\DemoProject\\odf-demo\\src\\main\\resources\\static\\测试pdf转ofd.pdf",
                "G:\\DemoProject\\odf-demo\\src\\main\\resources\\static\\test.ofd");
    }

    /**
     * pdf转ofd
     *
     * @param resourceFilePath PDF源文件地址
     * @param targetFilePath   需要输出ofd的目标地址
     */
    public static void pdfToOfd(String resourceFilePath, String targetFilePath) {
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile(resourceFilePath);
        pdf.saveToFile(targetFilePath, FileFormat.OFD);
    }

    /**
     * pdf转ofd
     *
     * @param pdfFile pdf文件二进制数组
     * @return 返回输入流
     */
    public static InputStream pdfToOfd(byte[] pdfFile) {
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromBytes(pdfFile);
        ByteArrayOutputStream[] byteArrayOutputStreams = pdf.saveToStream(FileFormat.OFD);
        if (byteArrayOutputStreams == null || byteArrayOutputStreams.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = byteArrayOutputStreams[0];
        InputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        return byteArrayInputStream;
    }

    /**
     * pdf转ofd
     *
     * @param fileIns pdf文件输入流
     * @return 返回输入流
     */
    public static InputStream pdfToOfd(InputStream fileIns) {
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromStream(fileIns);
        ByteArrayOutputStream[] byteArrayOutputStreams = pdf.saveToStream(FileFormat.OFD);
        if (byteArrayOutputStreams == null || byteArrayOutputStreams.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = byteArrayOutputStreams[0];
        InputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        return byteArrayInputStream;
    }

    /**
     * pdf转ofd
     *
     * @param pdfFile pdf文件二进制数组
     * @return 返回二进制数组输出流
     */
    public static ByteArrayOutputStream pdfToOfdOus(byte[] pdfFile) {
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromBytes(pdfFile);
        ByteArrayOutputStream[] byteArrayOutputStreams = pdf.saveToStream(FileFormat.OFD);
        if (byteArrayOutputStreams == null || byteArrayOutputStreams.length == 0) {
            return null;
        }
        return byteArrayOutputStreams[0];
    }

}
