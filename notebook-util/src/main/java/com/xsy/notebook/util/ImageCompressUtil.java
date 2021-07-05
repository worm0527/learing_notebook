package com.xsy.notebook.util;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 图片压缩工具
 */
public class ImageCompressUtil {

  /**
   * 流方式输入输出图片压缩
   *
   * @param src 文件输入流（单个）
   * @param target 压缩后文件输出流（单个）
   * @param quality 压缩质量
   */
  public static void compress(InputStream src, OutputStream target, float quality)
      throws IOException {
    Thumbnails.of(src).scale(1)
        .outputQuality(quality).toOutputStream(target);
  }

  /**
   * 流方式输入输出图片压缩
   *
   * @param src 文件输入流（单个）
   * @param target 压缩后文件输出流（单个）
   * @param quality 压缩质量
   */
  public static void compress(InputStream src, OutputStream target, float quality, String format)
      throws IOException {
    Thumbnails.of(src).scale(1)
        .outputFormat(format)//输出格式
        .outputQuality(quality).toOutputStream(target);
  }

  /**
   * 压缩并重置大小(流式)
   */
  public static void compressAndsize(InputStream src, OutputStream target, float quality, int width,
      int height) throws IOException {
    Thumbnails.of(src).size(width, height).keepAspectRatio(false).outputQuality(quality)
        .toOutputStream(target);
  }

  /**
   *
   */
  public static void compressAndsize(InputStream src, OutputStream target, float quality, int width,
      int height, String format) throws IOException {
    Thumbnails.of(src).size(width, height).keepAspectRatio(false)
        .outputFormat(format)//输出格式
        .outputQuality(quality).toOutputStream(target);
  }

  /**
   * 根据宽比例压缩(流式)
   */
  public static void compressAndsizeWidth(InputStream src, OutputStream target, float quality,
      int width) throws IOException {
    Thumbnails.of(src).width(width).keepAspectRatio(true).outputQuality(quality)
        .toOutputStream(target);
  }

  /**
   * 根据宽比例压缩(流式)
   */
  public static void compressAndsizeWidth(InputStream src, OutputStream target, float quality,
      int width, String format) throws IOException {
    Thumbnails.of(src).width(width).keepAspectRatio(true)
        .outputFormat(format)//输出格式
        .outputQuality(quality).toOutputStream(target);
  }


  /**
   * 根据宽比例压缩(流式)
   */
  public static void compressAndsizeHeight(InputStream src, OutputStream target, float quality,
      int height) throws IOException {
    Thumbnails.of(src).height(height).keepAspectRatio(true).outputQuality(quality)
        .toOutputStream(target);
  }

  /**
   * 根据宽比例压缩(流式)
   */
  public static void compressAndsizeHeight(InputStream src, OutputStream target, float quality,
      int height, String format) throws IOException {
    Thumbnails.of(src).height(height).keepAspectRatio(true)
        .outputFormat(format)//输出格式
        .outputQuality(quality).toOutputStream(target);
  }

  /**
   * 压缩并添加图片水印(流式)
   *
   * @param src 原图
   * @param target 输出图
   * @param mark 水印图片
   * @param position 水印位置
   * @param opacity 水印透明度 0.0f-1.0f
   * @param quality 图片质量 0-1
   */
  public static void compressAndWatermark(InputStream src, OutputStream target, InputStream mark,
      Positions position, float opacity, float quality) throws IOException {
    Thumbnails.of(src)
        .scale(1)
        .watermark(position, ImageIO.read(mark), opacity)
        .outputQuality(quality)
        .toOutputStream(target);
  }

  /**
   * 压缩并添加图片水印(流式)
   *
   * @param src 原图
   * @param target 输出图
   * @param mark 水印图片
   * @param position 水印位置
   * @param opacity 水印透明度 0.0f-1.0f
   * @param quality 图片质量 0-1
   */
  public static void compressAndWatermark(InputStream src, OutputStream target, InputStream mark,
      Positions position, float opacity, float quality, String format) throws IOException {
    Thumbnails.of(src).scale(1)
        .watermark(position, ImageIO.read(mark), opacity)
        .outputFormat(format)//输出格式
        .outputQuality(quality).toOutputStream(target);
  }

  public static void main(String[] args) {
    try {
      FileInputStream src = new FileInputStream(new File("/Users/xushuyuan/Desktop/image_test/有的有的.png"));

      OutputStream target = new FileOutputStream(new File("/Users/xushuyuan/Desktop/image_test/有的有的_80.jpg"));

//      compress(src, target, 0.8F);
//      compressAndWatermark(src, target, icon, Positions.BOTTOM_RIGHT, 1, 0.8f);
      compress(src, target, 0.8F, "jpg");
      src.close();
      target.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
