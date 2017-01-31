package task2;

public class DemoCall {

	public static void main(String[] args) {
		
		GSM nokia = new GSM(); 
		nokia.model = "nokia";		
		nokia.insertSimCard("0883452535");

		GSM sony = new GSM();
		sony.model = "sony";
		sony.hasSimCard = true;
		sony.simMobileNumber = "0877123456";
		
		GSM samsung = new GSM();
		samsung.model = "samsung";
		samsung.hasSimCard = true;
		samsung.simMobileNumber = "0888654321";
		
		GSM acer = new GSM();
		acer.model = "acer";
		acer.simMobileNumber = "0777223344";
		acer.hasSimCard = true;
		
		acer.removeSimCard();
				
		samsung.call(acer, 0.05);
		nokia.call(sony, 4.40);
		nokia.call(samsung, 2.05);
		sony.call(nokia, 11.05);		 		
		
		System.out.println(nokia.outgoingCallsDuration);
		nokia.printInfoForTheLastOutgoingCall();
		nokia.printInfoForTheLastIncomingCall();
		samsung.printInfoForTheLastOutgoingCall();
		System.out.println(nokia.getSumForCall());		
	}
}
