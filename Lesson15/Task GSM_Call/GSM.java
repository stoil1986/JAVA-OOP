package task2;

public class GSM {
	
	String model;
	boolean hasSimCard;
	String simMobileNumber;
	double outgoingCallsDuration;
	Call lastIncomingCall;
	Call lastOutgoingCall;	
		
	void insertSimCard(String simMobileNumber){
		if (simMobileNumber.startsWith("08") && simMobileNumber.length() == 10) {
			this.simMobileNumber = simMobileNumber;
			this.hasSimCard = true;			
		}
	}
	
	void removeSimCard(){
		this.hasSimCard = false;
		this.simMobileNumber = "";
	}
	
	void call(GSM receiver, double duration){
				
	
		if (duration >= 0 && !this.simMobileNumber.equals(receiver.simMobileNumber) 
			&& (this.hasSimCard && receiver.hasSimCard)) {
			
			Call call = new Call();
			call.caller = this;
			call.duration = duration;
			call.receiver = receiver;
			lastOutgoingCall = call;
			receiver.lastIncomingCall = call;
			
		    this.outgoingCallsDuration += duration;		    		   
		}else {
			System.out.println("This call in not possible!");
		}
	}

	double getSumForCall(){
		return this.outgoingCallsDuration*Call.priceForMinute;
	}
	
	void printInfoForTheLastOutgoingCall(){
		if (this.lastOutgoingCall != null) {
			System.out.println("Last outgoing call is to: " + this.lastOutgoingCall.receiver.simMobileNumber);
			System.out.println("Duration: " + this.lastOutgoingCall.duration);
		}else {
			System.out.println("No info");
		}
	}
	void printInfoForTheLastIncomingCall(){
		if (lastIncomingCall != null) {
			System.out.println("Last incoming call is from: " + lastIncomingCall.caller.simMobileNumber);
			System.out.println("Duration: " + lastIncomingCall.duration);
		}else {
			System.out.println("No info");
		}
	}	
}

