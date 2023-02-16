
 public class SmartCamera extends SmartObject implements MotionControl,Comparable<SmartCamera>{
	 private boolean status;
	 private int batteryLife;
	 private boolean nightVision;
	 	public SmartCamera() {
	 		
	 	}
	 	public SmartCamera(String alias,String macId,boolean nightVision,int batteryLife) {
	 		super(alias,macId,nightVision,batteryLife);
	 	}
	 	public void recordOn(boolean isDay) {
	 	if(isConnectionStatus()==true) {
	 		 if(isDay==true&&status==false) {
	 		      setStatus(true);
	 		      System.out.println("Smart Camera - "+super.getAlias()+" is turned on now");
	 		      }
	 		      else if(isDay==false&&nightVision==true&&status==false) {
	 		      setStatus(true);
	 		      System.out.println("Smart Camera - "+super.getAlias()+" is turned on now");
	 		      }
	 		      else if(status==true) {
	 		      System.out.println("Smart Camera - "+super.getAlias()+" has been already turned on");
	 		      }
	 		      else if(isDay==false&&nightVision==false) {
	 		      setStatus(false);
	 		      System.out.println("Sorry! Smart Camera - "+super.getAlias()+" does not have night vision feature.");
	 		      }
}
	 	}
	 	public void recordOff() {
	 		if(super.isConnectionStatus()==true) {
	 			if(status==true) {
	 			System.out.println("Smart Camera - "+super.getAlias()+" is turned off now");
	 		status=false;
	 			}
	 		else {
	 			System.out.println("Smart Camera - "+super.getAlias()+" has been already turned off");
	 		}
	 		}
	 	}
	 	public boolean testObject() {
	 		if(super.isConnectionStatus()==true) {
	 			  SmartObjectToString();
	 			  System.out.println("Test is starting for SmartCamera day time");
	 			  recordOn(true);
	 			  recordOff();
	 			 System.out.println("Test is starting for SmartCamera night time");
	 			  recordOn(true);
	 			  recordOff();
	 			  System.out.println("Test completed for SmartCamera");
	 			  return true;
	 			  }
	 			  else
	 				  return false;
	 			  }
	 	public boolean shutDownObject() {
	 		if(super.isConnectionStatus()==true){
	 			SmartObjectToString();
	 			status=false;
	 			return true;
	 		}
	 		else {
	 			return false;
	 		}
	 	}
	 	public boolean controlMotion(boolean hasMotion,boolean isDay) {
	 		if(hasMotion==false) 
	 			System.out.println("Motion not detected!");
	 		else
	 			System.out.println("Motion detected!");
	 		if(isDay==true) {
	 			recordOn(true);
	 			return true;
	 		}
	 		else if(isDay==false&&nightVision==true) {
	 			recordOn(false);
	 			return true;}
	 		else
	 		return false;
	 	}
	 	public int compareTo(SmartCamera smartCamera) {
	 		if(batteryLife>smartCamera.batteryLife)
	 			return 1;
	 		else if(batteryLife>smartCamera.batteryLife)
	 			return 0;
	 		else
	 			return -1;
	 	}
	 	public String toString() {
	 	return "SmartCamera -> Child Room Cam's battery life is 30 status is recording" ;
	 	}
		public boolean isStatus() {
			return status;
		}
		public void setStatus(boolean status) {
			this.status = status;
		}
		public int getBatteryLife() {
			return batteryLife;
		}
		public void setBatteryLife(int batteryLife) {
			this.batteryLife = batteryLife;
		}
		public boolean isNightVision() {
			return nightVision;
		}
		public void setNightVision(boolean nightVision) {
			this.nightVision = nightVision;
		}
	 	
 }
