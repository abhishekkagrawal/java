package com.cibil.crs.FileReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
	try {
	    String fileName = "D:\\projects\\crs\\crs_restructured\\crs-documentation\\documentation\\other-docs\\INt005_response\\1000560342_FJC.txt";

	    // read using InputStream, to read line by line
	    readUsingInputStream(fileName, StandardCharsets.UTF_8);

	    // using Java 7 Files class to process small files, get complete
	    // file data
	    readUsingFiles(fileName);

	    // using Scanner class for large files, to read line by line
	    readUsingScanner(fileName);

	    // read using BufferedReader, to read line by line
	    readUsingBufferedReader(fileName);
	    readUsingBufferedReaderJava7(fileName, StandardCharsets.UTF_8);
	    readUsingBufferedReader(fileName, StandardCharsets.UTF_8);

	    // read using FileReader, no encoding support, not efficient
	    readUsingFileReader(fileName);

	    readUsingRandomAccess(fileName);

	    readUsingFileUtils(fileName);

	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    private static void readUsingFileUtils(String fileName) {
	try {
	    File f = new File(fileName);

	    System.out.println("Reading files using Apache IO:");

	    List<String> lines = FileUtils.readLines(f, "UTF-8");

	    for (String line : lines) {
		System.out.println(line);
	    }
	} catch (IOException e) {
	    e.printStackTrace();
	}

    }

    private static void readUsingRandomAccess(String fileName) {
	RandomAccessFile file;
	try {
	    file = new RandomAccessFile(fileName, "r");

	    String str;

	    while ((str = file.readLine()) != null) {
		System.out.println(str);
	    }
	    file.close();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

    private static void readUsingInputStream(String fileName, Charset cs) {
	try {
	    File file = new File(fileName);
	    FileInputStream fis = new FileInputStream(file);
	    InputStreamReader isr = new InputStreamReader(fis, cs);
	    BufferedReader br = new BufferedReader(isr);

	    String line;
	    while ((line = br.readLine()) != null) {
		// process the line
		System.out.println(line);
	    }
	    br.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}

    }

    private static void readUsingFileReader(String fileName) throws IOException {
	File file = new File(fileName);
	FileReader fr = new FileReader(file);
	BufferedReader br = new BufferedReader(fr);
	String line;
	System.out.println("Reading text file using FileReader");
	while ((line = br.readLine()) != null) {
	    // process the line
	    System.out.println(line);
	}
	br.close();
	fr.close();

    }

    private static void readUsingBufferedReader(String fileName, Charset cs) throws IOException {
	File file = new File(fileName);
	FileInputStream fis = new FileInputStream(file);
	InputStreamReader isr = new InputStreamReader(fis, cs);
	BufferedReader br = new BufferedReader(isr);
	String line;
	System.out.println("Read text file using InputStreamReader");
	while ((line = br.readLine()) != null) {
	    // process the line
	    System.out.println(line);
	}
	br.close();

    }

    private static void readUsingBufferedReaderJava7(String fileName, Charset cs) throws IOException {
	Path path = Paths.get(fileName);
	BufferedReader br = Files.newBufferedReader(path, cs);
	String line;
	System.out.println("Read text file using BufferedReader Java 7 improvement");
	while ((line = br.readLine()) != null) {
	    // process the line
	    System.out.println(line);
	}
	br.close();
    }

    private static void readUsingBufferedReader(String fileName) throws IOException {
	File file = new File(fileName);
	FileReader fr = new FileReader(file);
	BufferedReader br = new BufferedReader(fr);
	String line;
	System.out.println("Read text file using BufferedReader");
	while ((line = br.readLine()) != null) {
	    // process the line
	    System.out.println(line);
	}
	// close resources
	br.close();
	fr.close();
    }

    private static void readUsingScanner(String fileName) throws IOException {
	Path path = Paths.get(fileName);
	Scanner scanner = new Scanner(path);
	System.out.println("Read text file using Scanner");
	// read line by line
	while (scanner.hasNextLine()) {
	    // process each line
	    String line = scanner.nextLine();
	    System.out.println(line);
	}
	scanner.close();
    }

    private static void readUsingFiles(String fileName) throws IOException {
	Path path = Paths.get(fileName);
	// read file to byte array
	byte[] bytes = Files.readAllBytes(path);
	System.out.println("Read text file using Files class");
	// read file to String list
	@SuppressWarnings("unused")
	List<String> allLines = Files.readAllLines(path, StandardCharsets.UTF_8);
	System.out.println(new String(bytes));
    }
}
