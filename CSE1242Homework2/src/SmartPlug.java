import java.text.SimpleDateFormat;
import java.util.Calendar;
 public class SmartPlug extends SmartObject implements Programmable{
	 private boolean status;
	 private Calendar programTime;
	 private boolean programAction;
	 	public SmartPlug() {
	 		
	 	}
	 	public SmartPlug(String alias,String macId){
	 		super(alias,macId);
	 	}
	 	public String currentTime() {
	 		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
			String date = simpleDateFormat.format(Calendar.getInstance().getTime());
			return "(Current time: " + date + ")";
		
	 	}
		public void turnOn() {
	 		  if(super.isConnectionStatus()) {
				  if(!isStatus()) {
					  System.out.println("Smart Plug - " + super.getAlias() + " is turned on now " + currentTime());
			            status = true;  
				        }
				  else {
					  System.out.println("Smart Plug - " + super.getAlias() + "has been already turned on");
				        }
		  }
	 		}
		public void turnOff() {
			  if(super.isConnectionStatus()==true) {
				  if(status==false) {
				        System.out.println("Smart Plug - " + super.getAlias() + "has been already turned off");
				        }
				        else {
				            System.out.println("Smart Plug - " + super.getAlias() + " is turned off now " + currentTime());
				            status= false;
				        }
		  }
		  }
	 	public boolean testObject() {
	 		if(super.isConnectionStatus()==true) {
	 			  SmartObjectToString();
	 			  turnOn();
	 			  turnOff();
	 			  System.out.println("Test completed for SmartPlug");
	 			  return true;
	 			  }
	 			  else
	 				  return false;
	 			  }
	 	public boolean shutDownObject() {
	 		if(super.isConnectionStatus()==true) {
				  SmartObjectToString();
				  setConnectionStatus(false);
				 return true;
			  }
				  else 
					  return false;
	 	}
	 	public void setTimer(int seconds) {
	 		 if(super.isConnectionStatus()==true) {
				  programTime=Calendar.getInstance();
				  programTime.add(Calendar.SECOND, seconds);
				  if(status==true) {
				  System.out.print("Smart plug - "+super.getAlias()+"will be turned on "+seconds+" seconds later!");
				  System.out.println("(Current time: "+Calendar.getInstance().get(Calendar.MINUTE)+":"+Calendar.getInstance().get(Calendar.SECOND)+")");
				  }
				  else{
					 System.out.print("Smart plug - "+super.getAlias()+" will be turned off "+seconds+" seconds later!"); 
					 System.out.println("(Current time: "+Calendar.getInstance().get(Calendar.HOUR)+":"+Calendar.getInstance().get(Calendar.MINUTE)+":"+Calendar.getInstance().get(Calendar.SECOND)+")");
				  }
				  }
				  }
	 	public void cancelTimer() {
	 		 if(super.isConnectionStatus()) {
		            programTime = null;
		        }
	 	}
	 	public void runProgram() {
	 		if(super.isConnectionStatus()) {
				  if(programTime!=null) {
					if(programTime.get(Calendar.SECOND)==(Calendar.getInstance().get(Calendar.SECOND))){
						if(status==true) {
							status=false;
							setProgramAction(false);
							System.out.println("RunProgram -> Smart Plug - "+super.getAlias());
							System.out.println("Smart Plug - "+super.getAlias()+"is turned on now (Current time:"+Calendar.getInstance().get(Calendar.HOUR)+":"+Calendar.getInstance().get(Calendar.MINUTE)+":"+Calendar.getInstance().get(Calendar.SECOND)+")");
						}
						else {
							status=true;
							setProgramAction(true);
							System.out.println("RunProgram -> Smart Plug - "+super.getAlias());
							System.out.println("Smart Plug - "+super.getAlias()+" is turned off now (Current time:"+Calendar.getInstance().get(Calendar.HOUR)+":"+Calendar.getInstance().get(Calendar.MINUTE)+":"+Calendar.getInstance().get(Calendar.SECOND)+")");
						}
					programTime=null;
					}
				  }
			  }
		  }		public boolean isStatus() {
			return status;
		}
		public void setStatus(boolean status) {
			this.status = status;
		}
		public Calendar getProgramTime() {
			return programTime;
		}
		public void setProgramTime(Calendar programTime) {
			this.programTime = programTime;
		}
		public boolean isProgramAction() {
			return programAction;
		}
		public void setProgramAction(boolean programAction) {
			this.programAction = programAction;
		}
	 	
}
