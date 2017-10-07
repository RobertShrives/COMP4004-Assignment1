package server.logic.tables;

import java.util.ArrayList;
import java.util.List;

import server.logic.model.User;

public class UserTable {
	
	List<User> userList=new ArrayList<User>();
    private static class UserListHolder {
        private static final UserTable INSTANCE = new UserTable();
    }
    private UserTable(){
    	//set up the default list with some instances
    	String[] passwordList=new String[]{"Rob","Jenny","Alice","John","Gail"};
    	String[] usernameList=new String[]{"Rob@carleton.ca","Jenny@carleton.ca","Alice@carleton.ca","John@carleton.ca","Gail@carleton.ca"};
    	for(int i=0;i<usernameList.length;i++){
			User deuser=new User(i,usernameList[i],passwordList[i]);
			userList.add(deuser);
		}
    	
    };
    public static final UserTable getInstance() {
        return UserListHolder.INSTANCE;
    }
    
	public Object createuser(String string, String string2) {		
		boolean result=true;
		int flag=0;
		for(int i=0;i<userList.size();i++){
			String email=(userList.get(i)).getUsername();
			if(email.equalsIgnoreCase(string)){
				flag=flag+1;
			}else{
				flag=flag+0;	
			}
		}
		if(flag==0){
			User newuser=new User(userList.size(),string,string2);
			result=userList.add(newuser);
		}else{
			result=false;
		}
		return result;	
	}
		
	public boolean lookup(int j) {
		boolean result=true;
		int flag=0;
		for(int i=0;i<userList.size();i++){
			int userid=(userList.get(i)).getUserid();
			if(userid==j){
				flag=flag+1;
			}else{
				flag=flag+0;	
			}
		}
		if(flag==0){
			result=false;
		}
		return result;
	}
	
	public List<User> getUserTable() {
		return userList;
	}
	
	public Object delete(int i) {
		//Since the userid in "User Creation" is automatically assigned to the user,upon its creation.
		//Each user has a unique userid.Even it is deleted,its userid can not be assigned to other user.
		//To maintain the correctness of the data,here instead delete index from the List.
		//I choose to remove the user's information instead the whole index.Keep its userid as reference.
		String result="";
		boolean loan=LoanTable.getInstance().checkUser(i);
		int flag=0;
		int index=0;
		for(int j=0;j<userList.size();j++){
			if(userList.get(j).getUserid()==i){
				index=j;
				flag=flag+1;
			}else{
				flag=flag+0;
			}
		}
		
		if(flag==0){
			result="The User Does Not Exist";
		}else{
			boolean fee=FeeTable.getInstance().lookup(i);
			String string=userList.get(index).getUsername();
			String string2=userList.get(index).getPassword();
			if(fee && loan){
				userList.get(index).setUserid(i);
				userList.get(index).setPassword("N/A");
				userList.get(index).setUsername("N/A");
				result="success";
			}else if(fee==false){
				result="Outstanding Fee Exists";
			}else if(loan==false){
				result="Active Loan Exists";
			}
		}
    
		return result;

	}
	
}
