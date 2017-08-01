package com.eeit95.her.model.img.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

public class ImageToBytes {

	
	public static byte[] imgIn(String rpath) {
			File f = new File(rpath);
			byte[] b = new byte[(int)f.length()];
			FileInputStream fis = null;

			Blob blob = null;
			try {
				fis = new FileInputStream(f);
				fis.read(b);
				blob = new SerialBlob(b);
				
//				OutputStream os = new FileOutputStream(dpath);
////				byte[] data = b.getBytes(1, (int) b.length());
//				os.write(b, 0, b.length);
//				os.close();
				
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				System.out.println("找不到檔案");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (SerialException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				if(fis != null) {
					try {
						fis.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			System.out.println(blob);
		
		return b;
	}
}
