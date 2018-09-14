import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class comp {

	public static void main(String[] args) throws FileNotFoundException {
		
		File file = null;
		String fileName = "";
		if(args.length > 0) {
//			Scanner fileScan = new Scanner(System.in);
			file = new File(args[0]);
			fileName = args[0];
			
		}else {
			Scanner fileScan = new Scanner(System.in);
			System.out.println("type the full, or relative path to your file. \nPressing enter will default to the strings file \nYou can also pass in an argument that is the file name");
			String fileStr = fileScan.nextLine();
			fileName = fileStr;
			
			if(fileStr.equals("")) {
				file = new File("strings");								
				fileName = "strings";
			}else {
				file = new File(fileStr);
			}

			fileScan.close();
		}

		Scanner scan = new Scanner(file);
//		../aobFind/src/


		
		ArrayList<String> stringList = new ArrayList();
		while(scan.hasNextLine()) {
			String mine = scan.nextLine();
			if(mine.length() != 0) {
				char comp = mine.charAt(0);
				if(comp == 'q') break;
				stringList.add(mine);
			}
		}
		scan.close();
		String result = new String();
		String resultWithSlashes = "\\x";
		String mask = "";
		char maskVal = 'x';
		boolean writeMask = true;
		
		
		for(int i = 0; i < stringList.get(0).length(); i++) {
			char comp = stringList.get(0).charAt(i);
			for(String s: stringList) {
				if(s.charAt(i) != comp || comp == '?' ) {
					comp = '?';
					maskVal = '?';
				}				
			}
			result += comp;
			if(comp == ' ') {
				mask += maskVal;
				maskVal = 'x';
				resultWithSlashes += "\\x";
			}else {
				if( comp == '?' ) {
					resultWithSlashes += 'a';//this doesn't matter because of the mask
				}else {
					resultWithSlashes += comp;
				}
			}
		}
		
//		"const char * " + fileName + "Pattern = "

		System.out.println(result);
		System.out.println(resultWithSlashes);
		System.out.println(mask);
		System.out.println("\n\nto paste into your prog");
		resultWithSlashes += "\"";
		mask += "\"";
		System.err.println("const char * " + fileName + "Pattern = \"" + resultWithSlashes + ";");
		System.err.println("const char * " + fileName + "Mask = \"" + mask + ";");
		
	}
}
