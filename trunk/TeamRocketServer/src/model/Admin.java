package model;
/**
 * Admin class model
 * @author Wesley
 * @author Ian
 *
 */
public class Admin {
	static String name = "admin";
	static String pwd = "password";
	static String key = null;

	public Admin(){
	}

	public void setKey(String key){
		this.key = key;
	}

	public boolean signIn(String n, String p){
		if(name.equals(n) && pwd.equals(p)){
			return true;
		}
		else {
			return false;
		}
	}

	public boolean verify(String k){
		if(k.equals(this.key)){
			return true;
		}
		else{
			return false;
		}
	}

}