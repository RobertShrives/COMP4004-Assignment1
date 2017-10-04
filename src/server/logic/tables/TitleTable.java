package server.logic.tables;

import java.util.ArrayList;
import java.util.List;



import server.logic.model.Title;



public class TitleTable {
	
	List<Title> titleList=new ArrayList<Title>();
    private static class TitleListHolder {
        private static final TitleTable INSTANCE = new TitleTable();
    }
    	
    public static final TitleTable getInstance() {
        return TitleListHolder.INSTANCE;
    }
	public Object createtitle(String string, String string2) {		
		boolean result=true;
		int flag=0;
		for(int i=0;i<titleList.size();i++){
			String ISBN=(titleList.get(i)).getISBN();
			if(ISBN.equalsIgnoreCase(string)){
				flag=flag+1;
			}else{
				flag=flag+0;	
			}
		}
		if(flag==0){
			Title newtitle=new Title(string,string2);
			result=titleList.add(newtitle);
			
		}else{
			result=false;
			
		}
		return result;	
	}
}
