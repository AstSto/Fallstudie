import static org.junit.Assert.*;
import java.util.Date;
import org.junit.Test;

public class TestingParkingMeter {

	@Test
	public void testBooking() { 
	     
		  // Test mit 1� M�nze
		  int[] parkCoins = {0,1,0}; 	//Einwurf: 0x0.5�, 1x1�, 0x2�		Bestand Ausgangslage: 5x0.5�, 5x1�, 5x2�
		   
		  // �berpr�fung der Ausgangslage - jeweils 5 St�ck der jeweiligen M�nze 
		  assertEquals(ParkingMeter.coinsParkingMeter[0], 5); 
		  assertEquals(ParkingMeter.coinsParkingMeter[1], 5); 
		  assertEquals(ParkingMeter.coinsParkingMeter[2], 5); 
		     
		  // die eingeworfene(n) M�nze(n) werden dem Bestand hinzugef�gt - in dem Fall +1 f�r den 1�-Bestand 
		  ParkingMeter.bookParkingCoins(parkCoins); 
		     
		  // Anzahl der 1� M�nzen sollte nun 6 St�ck sein  
		  assertEquals(ParkingMeter.coinsParkingMeter[0], 5); 
		  assertEquals(ParkingMeter.coinsParkingMeter[1], 6); 
		  assertEquals(ParkingMeter.coinsParkingMeter[2], 5); 
		} 
	
	@Test
	public void testprintCustomerReceipt() {
		
		//angenommen der Anwender hat einen Betrag von insgesamt 1.50� eingeworfen
		double money = 2.0;
		Date t = new Date ();
		
		//die Beleg-Methode wird aufgerufen
		String beleg = ParkingMeter.printCustomerReceipt(money, t);
		System.out.println(beleg);
		
		//im "beleg" sollten nun alle Informationen f�r den Druck vorhanden sein
		assertTrue(beleg.contains("Beleg Parkhaus")); 
	}
}
