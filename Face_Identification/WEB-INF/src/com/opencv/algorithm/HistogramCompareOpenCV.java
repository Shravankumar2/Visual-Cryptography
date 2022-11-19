package com.opencv.algorithm;


import java.util.Vector;


import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfFloat;
import org.opencv.core.MatOfInt;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;



public class HistogramCompareOpenCV {
	
	
    public double compare(String img1,String img2)
{
   
    
    
    	System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	

    Mat H1 = histogram(img1,"histo_test1.jpg");
    
    Mat H2 = histogram(img2,"histo_test2.jpg");
    double text = Imgproc.compareHist(H1, H2, Imgproc.CV_COMP_BHATTACHARYYA);
    if(text<0.2)
    {
    	System.out.println("val :"+text);
    	System.out.println("less than 0.2");
    }
    else 
    {
    	System.out.println("val :"+text);
    	System.out.println("grater than 0.2");
    }
	return text;
}
public Mat histogram(String filenameIn,String filenameOut)
{
    Mat img = Highgui.imread(filenameIn);
    Mat src = new Mat(img.height(), img.width(), CvType.CV_8UC2);
    Imgproc.cvtColor(img, src, Imgproc.COLOR_RGB2GRAY);
    Vector<Mat> bgr_planes = new Vector<Mat>();                                                                                                                                                                                 
    Core.split(src, bgr_planes);
    MatOfInt histSize = new MatOfInt(256);
    final MatOfFloat histRange = new MatOfFloat(0f, 256f);
    boolean accumulate = false;
    Mat b_hist = new  Mat();
    Imgproc.calcHist(bgr_planes, new MatOfInt(0),new Mat(), b_hist, histSize, histRange, accumulate);
    Highgui.imwrite(filenameOut, b_hist);
    return b_hist;
}
public static void main(String[] args) {
	HistogramCompareOpenCV compare=new HistogramCompareOpenCV();
	compare.compare("","");
}

}
