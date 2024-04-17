package com.harjoitustyo.Neuletyot;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import com.harjoitustyo.Neuletyot.model.Category;
import com.harjoitustyo.Neuletyot.model.CategoryRepository;
import com.harjoitustyo.Neuletyot.model.Neuletyot;
import com.harjoitustyo.Neuletyot.model.NeuletyotRepository;

@SpringBootTest(classes = NeuletyotApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class NeuletyotRepositoryTest {

    @Autowired
    private NeuletyotRepository repository;
    @Autowired
    private CategoryRepository carepository;

    @Test
    public void findByCategoryNameReturnsNeule(){

        List<Neuletyot> neuletyot = repository.findByNeuleTitle("Variety");
        
        assertThat(neuletyot).hasSize(1);
        assertThat(neuletyot.get(0).getNeuleInfo()).isEqualTo("Ihastuttava neule ja kuvion tekeminen ei ollut niin haastavaa kuin aluksi luulin.");
    }


    @Test
    public void createNewNeule() {
        Category category = new Category("Villasukat");
        carepository.save(category);
        Neuletyot neuletyot = new Neuletyot("Suffeli", "Varresta tuli liian isot, muuten hauskat", "Fazeri.fi", "Novita", category);
        repository.save(neuletyot);
    }
    
    @Test
    public void editNeuletyotInfo() {
        Category category = new Category("Villasukat");
        carepository.save(category);
        Neuletyot neuletyot = new Neuletyot("Suffeli", "Varresta tuli liian isot, muuten hauskat", "Fazeri.fi", "Novita", category);
        repository.save(neuletyot);
        neuletyot.setNeuleInfo("Suffeli");
        repository.save(neuletyot);
        Neuletyot updatedNeuletyot = repository.findById(neuletyot.getNeuleId()).orElse(null);
        assertThat(updatedNeuletyot).isNotNull();
        assertThat(updatedNeuletyot.getNeuleInfo()).isEqualTo("Suffeli");
    }    

    @Test
    public void createNewNeuleAndDelet() {
        Category category = new Category("Villasukat");
        carepository.save(category);
        Neuletyot neuletyot = new Neuletyot("Suffeli", "Varresta tuli liian isot, muuten hauskat", "Fazeri.fi", "Novita", category);
        repository.save(neuletyot);
        assertThat(neuletyot.getNeuleId()).isNotNull();
        repository.delete(neuletyot);
    }


}
