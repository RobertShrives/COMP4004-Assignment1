package server.logic.tables;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import server.logic.model.Fee;
import server.logic.model.Loan;
import utilities.Config;


public class FeeTable {
	List<Fee> feeList=new ArrayList<Fee>();
    private static class FeeListHolder {
        private static final FeeTable INSTANCE = new FeeTable();
    }
    private FeeTable(){
    	//set up the default list with some instances
    	Fee fee=new Fee(0,5);
    	feeList.add(fee);
    	Initialization();
    };
    
    public static final FeeTable getInstance() {
        return FeeListHolder.INSTANCE;
    }
    
	public boolean lookup(int j) {
		boolean result=true;
		int fee = 0;
		boolean user=FeeTable.getInstance().checkuser(j);
		if(user){
			for(int i=0;i<feeList.size();i++){
				int userid=(feeList.get(i)).getUserid();
				if(userid==j){
					fee=fee+feeList.get(i).getFee();
				}
			}	
		}else{
			fee=0;
		}
		if(fee!=0){
			result=false;
		}
		return result;
	}
	
	public void applyfee(int j, long time) {
		int flag=0;
		int index=0;
		for(int i = 0;i<feeList.size();i++){
			int userid=(feeList.get(i)).getUserid();
			if(userid==j){
				flag=flag+1;
				index=i;
			}
		}
		int a=(int) ((time/(Config.STIMULATED_DAY))-Config.OVERDUE);
		if(flag!=0){
			if(a>=0){
				feeList.get(index).setFee(a+feeList.get(index).getFee());
				feeList.get(index).setUserid(j);
				
			}else{
				feeList.get(index).setFee(feeList.get(index).getFee());
				feeList.get(index).setUserid(j);
				
			}
		}else{
			if(a>=0){
				Fee fee=new Fee(j,a);
				feeList.add(fee);
				
			}else{
				Fee fee=new Fee(j,0);
				feeList.add(fee);
				
			}
		}
	}
	
	public void Initialization(){
    	List<Loan> loanList=LoanTable.getInstance().getLoanTable();
    	for(int i=0;i<loanList.size();i++){
    		applyfee(loanList.get(i).getUserid(), new Date().getTime()-loanList.get(i).getDate().getTime());
    	}
    	
	}
	
	private boolean checkuser(int j) {
		boolean result=true;
		int fee = 0;
		for(int i=0;i<feeList.size();i++){
			int userid=(feeList.get(i)).getUserid();
			if(userid==j){
				fee=fee+1;
			}else{
				fee=fee+0;
			}
		}	
		if(fee==0){
			result=false;
		}
		return result;
	}
	
	public List<Fee> getFeeTable() {
		return feeList;
	}
	
	public Object lookupfee(int j) {
		int fee=0;
		boolean user=FeeTable.getInstance().checkuser(j);
		if(user){
		for(int i=0;i<feeList.size();i++){
			int userid=(feeList.get(i)).getUserid();
			if(userid==j){
				fee=fee+feeList.get(i).getFee();
			}
		}
		}else{
			fee=0;
		}
		return fee;
	}
	
	//payfine
}
