package com.harjoitustyo.Neuletyot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.harjoitustyo.Neuletyot.model.AppUser;
import com.harjoitustyo.Neuletyot.model.AppUserRepository;
import com.harjoitustyo.Neuletyot.model.Category;
import com.harjoitustyo.Neuletyot.model.CategoryRepository;
import com.harjoitustyo.Neuletyot.model.Neuletyot;
import com.harjoitustyo.Neuletyot.model.NeuletyotRepository;

@SpringBootApplication
public class NeuletyotApplication {
	private static final Logger log = LoggerFactory.getLogger(NeuletyotApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(NeuletyotApplication.class, args);
	}

	@Bean
	public CommandLineRunner neuletyot(NeuletyotRepository neuletyotRepository, CategoryRepository carepository, AppUserRepository urepository) {

		return (args) -> {

			log.info("save a couple of category");

			Category category1 = new Category("Villapaidat");
			Category category2 = new Category("Topit");
			Category category3 = new Category("Villasukat");

			carepository.save(category1);
			carepository.save(category2);
			carepository.save(category3);

			neuletyotRepository.save(new Neuletyot("Variety",
					"Ihastuttava neule ja kuvion tekeminen ei ollut niin haastavaa kuin aluksi luulin.",
					"https://www.garnstudio.com/pattern.php?id=10966&cid=11", "Lima by drops, väri vaaleansininen",
					category1));
			neuletyotRepository.save(new Neuletyot("Stay Up Till Dawn Sweater",
					"Sopii ihanasti hameiden kanssa viileille illoille. Villapaita on paksu ja lämmin. Crop top malli on ihana.",
					"https://www.kutovakika.com/shop/p/stay-up-till-dawn-sweater", "Wish by drops. väri valkoinen sumu", category1));
			neuletyotRepository.save(new Neuletyot("Echo Mountain Top",
					"En tiedä luinko ohjetta väärin, mutta jouduin itse pidentämään helmaa ettei olisi ihan jäännyt nakupaidaksi. Pidensin myös hihoja. Valitsemani väri ei sopinut ihonsävyyni, joten värjäsin neuleen punaisela väriaineella.",
					"https://www.garnstudio.com/pattern.php?id=10922&cid=11", "House Onni, väri lilac", category2));

			// Create users: admin/admin user/user
			AppUser user1 = new AppUser("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			AppUser user2 = new AppUser("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C",
					"ADMIN");
			urepository.save(user1);
			urepository.save(user2);

			log.info("fetch all neletyot");
			for (Neuletyot neuletyot : neuletyotRepository.findAll()) {
				log.info(neuletyot.toString());
			}

		};
	}

}
