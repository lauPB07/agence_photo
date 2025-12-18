import com.example.gestionpojets.repository.UserRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserRepositoryTest {

    @Test
    void testWhenMethodegetNbPersonnesShouldReturn(){
        var result = UserRepository.getNbPersonnes();
        assertEquals(2,result);
    }

    @Test
    void testWhenMethodegetNbPersonnesAdminShouldReturn(){
        var result = UserRepository.getNbPersonnesAdmin();
        assertEquals(1,result);
    }

    @Test
    void testWhenMethodegetNbPersonnesChefProjetShouldReturn(){
        var result = UserRepository.getNbPersonnesChefProjet();
        assertEquals(1,result);
    }

    @Test
    void testWhenMethodegetNbPersonnesPersonnelShouldReturn(){
        var result = UserRepository.getNbPersonnesPersonnel();
        assertEquals(0,result);
    }
}
