import static org.junit.Assert.*;
import java.util.Date;
import org.junit.Test;

public class TestingParkingMeter {

	@Test
	public void testBooking() { 
	     
		  // Test mit 1€ Münze
		  int[] parkCoins = {0,1,0}; 	//Einwurf: 0x0.5€, 1x1€, 0x2€		Bestand Ausgangslage: 5x0.5€, 5x1€, 5x2€
		   
		  // Überprüfung der Ausgangslage - jeweils 5 Stück der jeweiligen Münze 
		  assertEquals(ParkingMeter.coinsParkingMeter[0], 5); 
		  assertEquals(ParkingMeter.coinsParkingMeter[1], 5); 
		  assertEquals(ParkingMeter.coinsParkingMeter[2], 5); 
		     
		  // die eingeworfene(n) Münze(n) werden dem Bestand hinzugefügt - in dem Fall +1 für den 1€-Bestand 
		  ParkingMeter.bookParkingCoins(parkCoins); 
		     
		  // Anzahl der 1€ Münzen sollte nun 6 Stück sein  
		  assertEquals(ParkingMeter.coinsParkingMeter[0], 5); 
		  assertEquals(ParkingMeter.coinsParkingMeter[1], 6); 
		  assertEquals(ParkingMeter.coinsParkingMeter[2], 5); 
		} 
	
	@Test
	public void testprintCustomerReceipt() {
		
		//angenommen der Anwender hat einen Betrag von insgesamt 1.50€ eingeworfen
		double money = 2.0;
		Date t = new Date ();
		
		//die Beleg-Methode wird aufgerufen
		String beleg = ParkingMeter.printCustomerReceipt(money, t);
		System.out.println(beleg);
		
		//im "beleg" sollten nun alle Informationen für den Druck vorhanden sein
		assertTrue(beleg.contains("Beleg Parkhaus")); 
	}
}
