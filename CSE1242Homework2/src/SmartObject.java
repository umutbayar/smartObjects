/* Name= Umut   Surname=Bayar  Number= 150120043  
 * In this project, we produced smart objects, defined various properties and coded them to call them.
 * We also added their ip and macId properties.Thanks to the features we have added, we can control
 * whether it is connected to the internet and turn the device on and off accordingly. In addition, by 
 * setting a timer, we can compare the current time and the program time and make it turn on and off
 * in a few seconds.


 */
 public abstract class SmartObject {
	private String alias;
	private String macId;
    private String IP;
	private boolean connectionStatus;
	 
	 public SmartObject(){
	 }
	 public SmartObject(String alias,String macId) {
		 this.alias=alias;
		 this.macId=macId;
	 }
	 public SmartObject(String alias,String macId,boolean nightVision,int batteryLife) {
		 this.alias=alias;
		 this.macId=macId;
	 }
	 public boolean connect(String IP) {
		 setIP(IP);
	        setConnectionStatus(true);
	           System.out.println(getAlias()+" connection established");
	          return true;
	 }
	 public boolean disconnect() {
		 	setIP(IP);
		 	setConnectionStatus(false);
		 	return true;
	 }
	 public void SmartObjectToString() {
		  System.out.println("This is "+this.getClass().getName()+" device "+getAlias());
		 	System.out.println("\tMacId: "+getMacId());
		 	System.out.println("\tIP: "+getIP());
	 }
	 public boolean controlConnection() {
		 	if(connectionStatus==false) {
		 		System.out.println("This device is not connected. "+alias.getClass().getName()+"- >"+getAlias());
		 return false;
		 	}
		 	else {
		 		return true;
		 	}
	 }
	 public abstract boolean testObject() ;
	 
	 public abstract boolean shutDownObject() ;
	 
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getMacId() {
		return macId;
	}
	public void setMacId(String macId) {
		this.macId = macId;
	}
	public String getIP() {
		return IP;
	}
	public void setIP(String iP) {
		IP = iP;
	}
	public boolean isConnectionStatus() {
		return connectionStatus;
	}
	public void setConnectionStatus(boolean connectionStatus) {
		this.connectionStatus = connectionStatus;
	}
	 
 }
