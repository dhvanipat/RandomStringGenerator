import java.util.ArrayList;

/* Generates a random string based on:
 * 
 *	default condition booleans below in main
 *	string length input as an argument
 *	custom special characters input as arguments
 *
 * Usage:
 *	Typically only used by passing arguments on the command line
 *	
 *		Default list of special characters
 *			java RandomStringGenerator [length]
 *		Custom special characters
 *			java RandomStringGenerator [length] [specialChar1] [specialChar2] [...]
 *	
 *	For further customization can change booleans found in main method below and recompile
 */
public class RandomStringGenerator {
	static ArrayList<String> chars = new ArrayList<String>();
	
	public static void main(String[] args){
		boolean specialCharacters	= 	true,
				upperCase			=	true,
				lowerCase			=	true,
				numbers				=	true,
				debug 				= 	false; //prints list of all characters in the pool for string generation
		
		if(upperCase){
			for(int i = 65; i <= 90; i++){
				chars.add(String.valueOf((char)i));
			}
		}
		if(lowerCase){
			for(int i = 97; i <= 122; i++){
				chars.add(String.valueOf((char)i));
			}
		}
		if(numbers){
			for(int i = 0; i <= 9; i++){
				chars.add(String.valueOf(i));
			}
		}
		if(args.length > 1){ //user has input custom special characters
			for(int i = 1; i < args.length; i++){
				if(args[i].length() > 1){
					System.err.println("ERROR: Invalid format please enter each character as a separate argument");
					return;
				}else if(chars.contains(args[i])){
					System.err.println("ERROR: Char already found: " + args[i]);
					return;
				}else{
					chars.add(args[i]);
				}					
			}
		}else if(specialCharacters){
			String specChar =  "!\"#$%&'()*+,-./:;<=>?@][\\^_`{|}~";
			for(int i = 0; i < specChar.length(); i++){
				chars.add(specChar.substring(i, i+1));
			}
		}
		
		
		
		
		
		
		if(debug){
			printChars();
		}
		System.out.println(buildString(Integer.parseInt(args[0])));
	}
	
	public static void printChars(){
		for(int i = 0; i < chars.size(); i++){
			System.out.println(chars.get(i));
		}		
	}
	
	public static String buildString(int stringL){
		String output = "";
		for(int i = 0; i < stringL; i++){
			int index = (int)(Math.random() * chars.size());
			output += chars.get(index);
		}
		return output;
	}
 }