/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author HP
 */
public class ImageLogic {

   private byte[] convertImageToBinary(String imagePath) throws IOException {
        File file = new File(imagePath);
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] imageData = new byte[(int) file.length()];
        fileInputStream.read(imageData);
        fileInputStream.close();
        return imageData;
    }
}
