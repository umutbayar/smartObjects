import java.util.*;

public class SmartHome {
	 private ArrayList<SmartObject>smartObjectList=new ArrayList<SmartObject>();
	 	public SmartHome() {	
	 	}
	 	
	 	public boolean addSmartObject(SmartObject smartObject) {
	 		smartObjectList.add(smartObject);
	 		System.out.println("--------------------------------------------------------------------------");
	 		System.out.println("--------------------------------------------------------------------------");
	 		System.out.println("Adding new SmartObject");
	 		System.out.println("--------------------------------------------------------------------------");
	 		smartObject.connect("10.0.0."+(99+smartObjectList.size()));
	 		System.out.println("Test is starting for "+smartObject.getClass().getName());
	 		smartObject.testObject();
	 		System.out.println("");
	 		return true;
	 	}
	 	public boolean removeSmartObject(SmartObject smartObject) {
	 		if(smartObjectList.contains(smartObject))
	 		return true;
	 		else
	 			return false;
	 	}
	 	public void controlLocation(boolean onCome) {
	 		System.out.println("--------------------------------------------------------------------------");
	 		System.out.println("--------------------------------------------------------------------------");
	 		System.out.println("LocationControl : OnCome");
	 		System.out.println("--------------------------------------------------------------------------");
	 		for(int i=0;i<smartObjectList.size();i++) {
	 		if(smartObjectList.get(i) instanceof LocationControl) {
	 			if(((SmartLight)smartObjectList.get(i)).isHasLightTurned()) {
	 				((SmartLight)smartObjectList.get(i)).onLeave();
	 			}
	 			else
	 				((SmartLight)smartObjectList.get(i)).onCome();
	 		}
	 		}
	 	}
	 	public void controlMotion(boolean hasMotion,boolean isDay) {
	 		System.out.println("--------------------------------------------------------------------------");
	 		System.out.println("--------------------------------------------------------------------------");
	 		System.out.println("MotionControl:HasMotion,isDay");
	 		System.out.println("--------------------------------------------------------------------------");
	 		
	 		for(int i=0;i<smartObjectList.size();i++) {
	 			if(smartObjectList.get(i)instanceof MotionControl) {
	 				((SmartCamera)smartObjectList.get(i)).controlMotion(hasMotion,isDay);
	 			}
	 		}
	 	}
	 	public void controlProgrammable() {
	 		System.out.println("--------------------------------------------------------------------------");
	 		System.out.println("--------------------------------------------------------------------------");
	 		System.out.println("Programmable:runProgram");
	 		System.out.println("--------------------------------------------------------------------------");
	 		
	 		for(int i=0;i<smartObjectList.size();i++) {
	 			if(smartObjectList.get(i) instanceof SmartPlug) {
	 				((SmartPlug)smartObjectList.get(i)).runProgram();	
				}
	 		}
	 	}
	 	public void controlTimer(int seconds) {
	 	    System.out.println("--------------------------------------------------------------------------");
	 	    System.out.println("--------------------------------------------------------------------------");
	 	        System.out.println("Programmable: runProgram");
	 	        System.out.println("--------------------------------------------------------------------------");
	 	    
	 	    if(seconds==0) {
	 	    for(int i=0;i<smartObjectList.size();i++) {
	 	    if(smartObjectList.get(i) instanceof SmartLight) {
	 	                       ((SmartLight)smartObjectList.get(i)).cancelTimer();
	 	                   }
	 	                   if(smartObjectList.get(i) instanceof SmartPlug) {
	 	                       ((SmartPlug)smartObjectList.get(i)).cancelTimer();
	 	                   }
	 	    }
	 	    
	 	    }
	 	    else if(seconds>0) {
	 	    for(int i=0;i<smartObjectList.size();i++) {
	 	    if(smartObjectList.get(i) instanceof SmartLight) {
	 	                       ((SmartLight)smartObjectList.get(i)).setTimer(seconds);
	 	                   }
	 	                   if(smartObjectList.get(i) instanceof SmartPlug) {
	 	                       ((SmartPlug)smartObjectList.get(i)).setTimer(seconds);
	 	                   }
	 	    }
	 	    }
	 	    
	 	    }
	 	    
	 	    public void controlTimerRandomly() {
	 	    System.out.println("--------------------------------------------------------------------------");
	 	    System.out.println("--------------------------------------------------------------------------");
	 	        System.out.println("Programmable: Timer = 0, 5 or 10 seconds randomly");
	 	        System.out.println("--------------------------------------------------------------------------");
	 	    for(int i=0;i<smartObjectList.size();i++) {
	 	    int second=((int)(Math.random()*3))*5; 
	 	    if(second>0) {
	 	    if(smartObjectList.get(i) instanceof SmartLight) {
	 	    ((SmartLight)smartObjectList.get(i)).setTimer(second);
	 	    }
	 	    if(smartObjectList.get(i) instanceof SmartPlug) {
	 	    ((SmartPlug)smartObjectList.get(i)).setTimer(second);
	 	    }
	 	    }
	 	    else if(second==0) {
	 	    if(smartObjectList.get(i) instanceof SmartLight) {
	 	    ((SmartLight)smartObjectList.get(i)).cancelTimer();
	 	    }
	 	    if(smartObjectList.get(i) instanceof SmartPlug) {
	 	    ((SmartPlug)smartObjectList.get(i)).cancelTimer();
	 	    }
	 	    }
	 	    }
	 	    }

	 	public void sortCameras() {
	 		System.out.println("--------------------------------------------------------------------------");
	 		System.out.println("--------------------------------------------------------------------------");
	 		System.out.println("Sort Smart Cameras");
	 		System.out.println("--------------------------------------------------------------------------");
	 		ArrayList<SmartCamera>smartCameraList=new ArrayList<SmartCamera>();
	 		for(int i=0;i<smartObjectList.size();i++) {
	 			if(smartObjectList.get(i)instanceof SmartCamera) {
	 				smartCameraList.add(((SmartCamera)smartObjectList.get(i)));
	 			}
	 		}
	 		Collections.sort(smartCameraList);
	 		for(int i=0;i<smartCameraList.size();i++) {
	 			System.out.println(smartCameraList.get(i).toString());
	 		}
	 	}
		public void setSmartObjectList(ArrayList<SmartObject> smartObjectList) {
			this.smartObjectList = smartObjectList;
		}
	 	
}
	