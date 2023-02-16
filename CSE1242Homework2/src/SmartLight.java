
import java.text.SimpleDateFormat;
import java.util.Calendar;
 public class SmartLight extends SmartObject implements LocationControl,Programmable {
	 private boolean hasLightTurned;
	 private Calendar programTime;
	 private boolean programAction;
	 
	 public SmartLight() {
		 
	 }
	 public String currentTime() {
	 		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
			String date = simpleDateFormat.format(Calendar.getInstance().getTime());
			return "(Current time: " + date + ")";
	 	}
	  public SmartLight(String alias,String macId) {
		super(alias,macId);
	  }
	  

		public void turnOnLight() {
	 		  if(super.isConnectionStatus()) {
				  if(!isHasLightTurned()) {
					  System.out.println("Smart Light - " + super.getAlias() + " is turned on now "+currentTime());
			            hasLightTurned = true;  
				        }
				  else {
					  System.out.println("Smart Light - " + super.getAlias() + "has been already turned on");
				        }
		  }
	 		}
		public void turnOffLight() {
			  if(super.isConnectionStatus()==true) {
				  if(isHasLightTurned()==false) {
				        System.out.println("Smart Light - " + super.getAlias() + "has been already turned off");
				        }
				        else {
				            System.out.println("Smart Light - " + super.getAlias() + " is turned off now " + currentTime());
				            hasLightTurned= false;
				        }
		  }
		  }
	  public boolean testObject() {
		  if(super.isConnectionStatus()==true) {
		  SmartObjectToString();
		  turnOnLight();
		  turnOffLight();
		  System.out.println("Test completed for SmartLight");
		  return true;
		  }
		  else
			  return false;
		  }
	  public boolean shutDownObject() {
		  if(super.isConnectionStatus()==true) {
			  if(hasLightTurned==true) {
			  SmartObjectToString();
			  setConnectionStatus(false);
		  }
			  return true;
		  }
			  else 
				  return false;
	  }
	  public void onLeave() {
		  if(super.isConnectionStatus()==true)
			  if(hasLightTurned==true) {
			  hasLightTurned=false;
		  	  System.out.println("On Leave -> - "+getAlias().getClass().getName()+" - "+"Living Room Light");
			  System.out.println(getAlias().getClass().getName()+" - "+"Living Room Light is turned off now (Current time:"+Calendar.getInstance().get(Calendar.HOUR)+":"+Calendar.getInstance().get(Calendar.MINUTE)+":"+Calendar.getInstance().get(Calendar.SECOND)+")");
			  }
	  }
	  public void onCome() {
		  if(super.isConnectionStatus()==false)
			  hasLightTurned=true;
		  System.out.println("On Come -> - "+getAlias().getClass().getName()+" - "+"Living Room Light");
		  System.out.println(getAlias().getClass().getName()+" - "+"Living Room Light is turned on now (Current time:"+Calendar.getInstance().get(Calendar.HOUR)+":"+Calendar.getInstance().get(Calendar.MINUTE)+":"+Calendar.getInstance().get(Calendar.SECOND)+")");
	  }
	  public void setTimer(int seconds) {
		  if(super.isConnectionStatus()==true) {
			  programTime=Calendar.getInstance();
			  programTime.add(Calendar.SECOND, seconds);
			  if(hasLightTurned==true) {
			  System.out.print("SmartLight - "+super.getAlias()+"will be turned on "+seconds+" seconds later!");
			  System.out.println("(Current time: "+Calendar.getInstance().get(Calendar.MINUTE)+":"+Calendar.getInstance().get(Calendar.SECOND)+")");
			  }
			  else{
				 System.out.print("Smart light - "+super.getAlias()+" will be turned off "+seconds+" seconds later!"); 
				 System.out.println("(Current time: "+Calendar.getInstance().get(Calendar.HOUR)+":"+Calendar.getInstance().get(Calendar.MINUTE)+":"+Calendar.getInstance().getInstance().get(Calendar.SECOND)+")");
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
					if(hasLightTurned==true) {
						hasLightTurned=false;
						setProgramAction(false);
						System.out.println("RunProgram -> Smart Light - "+super.getAlias());
						System.out.println("Smart Light - "+super.getAlias()+"is turned on now (Current time:"+Calendar.getInstance().get(Calendar.HOUR)+":"+Calendar.getInstance().get(Calendar.MINUTE)+":"+Calendar.getInstance().get(Calendar.SECOND)+")");
					}
					else {
						hasLightTurned=true;
						setProgramAction(true);
						System.out.println("RunProgram -> SmartLight - "+super.getAlias());
						System.out.println("Smart Light - "+super.getAlias()+" is turned off now (Current time:"+Calendar.getInstance().get(Calendar.HOUR)+":"+Calendar.getInstance().get(Calendar.MINUTE)+":"+Calendar.getInstance().get(Calendar.SECOND)+")");
					}
				programTime=null;
				}
			  }
		  }
	  }
	  public boolean isHasLightTurned() {
		return hasLightTurned;
	}
	  public void setHasLightTurned(boolean hasLightTurned) {
		  this.hasLightTurned = hasLightTurned;
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
