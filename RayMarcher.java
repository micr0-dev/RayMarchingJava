import java.util.ArrayList;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Color;

public class RayMarcher {
    
    static int resolution = 1080;
    
    static Vector3 CamPos = new Vector3(0,-20,0);
    static double FOV = 90d;
    static double clipEnd = 50d;

    
    public static void main(String[] args)
    {
        ArrayList<Shape> world = new ArrayList<Shape>(0);

        world.add(new Sphere(Vector3.forward().multiply(30), 15));
        world.add(new Sphere(new Vector3(4,10,4), 2));
        world.add(new Plane(new Vector3(0,0,-6)));
        // world.add(new Cube(new Vector3(4,10,4),new Vector3(0.5d,0.5d,0.5d)));

        double[][] image = render(world);

        double imageMax = getMaxValue(image);

        BufferedImage img = new BufferedImage(resolution, resolution, BufferedImage.TYPE_INT_RGB );

        float tempVal;
        int y = resolution-1;
        int x = 0;
        for (double[] yVal: image) {
            x = 0;
            for (double xVal: yVal) {
                tempVal = (float)(-(xVal/imageMax)+1);
                img.setRGB(x, y, new Color(tempVal,tempVal,tempVal).getRGB());
                x++;
            }
            y--;
        }

        File f = new File("Render.png");
        try {
            ImageIO.write(img, "PNG", f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static double[][] render(ArrayList<Shape> world){
        double RayXOffset = FOV/resolution;
        double RayYOffset = FOV/resolution;

        double[][] image = new double[resolution][resolution];
        
        Ray tempRay;
        double tempDist;

        int y = 0;
        int x = 0;
        for (double[] yVal: image) {
            x = 0;
            for (double xVal: yVal) {
                tempRay = new Ray((x*RayXOffset)-(FOV/2d),(y*RayYOffset)-(FOV/2d));
                while (true){
                    tempDist = closestDist(tempRay.getPos(), world);
                    if (tempDist < 0.001d){
                        image[y][x] = tempRay.length();
                        break;
                    }
                    tempRay.traverseRay(tempDist);
                    if (tempRay.length() >= clipEnd){
                        image[y][x] = clipEnd;
                        break;
                    }
                }
                x++;
            }
            y++;
        }
        return image;
    }

    private static double closestDist(Vector3 pos, ArrayList<Shape> world){
        double min = Double.MAX_VALUE;
        for (Shape shape: world){
            double temp = shape.dist(pos);
            if (temp < min) {min = temp;}
        }
        return min;
    }  

    public static double getMaxValue(double[][] numbers) {
        double maxValue = numbers[0][0];
        for (int j = 0; j < numbers.length; j++) {
            for (int i = 0; i < numbers[j].length; i++) {
                if (numbers[j][i] > maxValue) {
                    maxValue = numbers[j][i];
                }
            }
        }
        return maxValue;
    }



}

