package projetFinal.salleDeConcert;

import java.time.LocalDate;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import projetFinal.salleDeConcert.entities.Admin;
import projetFinal.salleDeConcert.entities.Client;
import projetFinal.salleDeConcert.services.CompteService;

@SpringBootTest
class CompteTest {

	@Autowired
	CompteService compteSrv;
 
	
	@Test
//	@Disabled
	void test() {
		compteSrv.createAdmin(new Admin("admin","admin"));
		compteSrv.createClient(new Client("client","client","nom","prenom","123456",LocalDate.parse("2023-02-02")));
	}

}
