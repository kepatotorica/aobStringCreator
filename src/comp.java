import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class comp {

	public static void main(String[] args) throws FileNotFoundException {
		
//		Scanner fileScan = new Scanner(System.in);
//		System.out.println("type the full path to your text file, or the relative path");
//		String fileStr = fileScan.nextLine();
//		File file = new File(fileStr);
		File file = new File("strings");
//		../aobFind/src/
//		fileScan.close();
		Scanner scan = new Scanner(file);
		
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
		String mask = new String();
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
		System.out.println(result);
		System.out.println(resultWithSlashes);
		System.out.println(mask);
	}
}
