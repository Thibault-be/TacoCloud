package tacos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tacos.data.IngredientRepository;
import tacos.data.TacoRepository;

import java.util.Arrays;

@SpringBootApplication
public class TacoCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(TacoCloudApplication.class, args);
    }


/*	@Bean
	public CommandLineRunner dataLoader(IngredientRepository repo) {
		return args -> {
			repo.deleteAll(); // TODO: Quick hack to avoid tests from stepping on each other with constraint violations
			repo.save(new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP));
			repo.save(new Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP));
			repo.save(new Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN));
			repo.save(new Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN));
			repo.save(new Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES));
			repo.save(new Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES));
			repo.save(new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE));
			repo.save(new Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE));
			repo.save(new Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE));
			repo.save(new Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE));
		};
	}*/

    @Bean
    public CommandLineRunner dataLoader(
            IngredientRepository repo,
            TacoRepository tacoRepo) {
        return args -> {
            Ingredient flourTortilla = new Ingredient(
                    "FLTO", "Flour Tortilla", Ingredient.Type.WRAP);
            Ingredient cornTortilla = new Ingredient(
                    "COTO", "Corn Tortilla", Ingredient.Type.WRAP);
            Ingredient groundBeef = new Ingredient(
                    "GRBF", "Ground Beef", Ingredient.Type.PROTEIN);
            Ingredient carnitas = new Ingredient(
                    "CARN", "Carnitas", Ingredient.Type.PROTEIN);
            Ingredient tomatoes = new Ingredient(
                    "TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES);
            Ingredient lettuce = new Ingredient(
                    "LETC", "Lettuce", Ingredient.Type.VEGGIES);
            Ingredient cheddar = new Ingredient(
                    "CHED", "Cheddar", Ingredient.Type.CHEESE);
            Ingredient jack = new Ingredient(
                    "JACK", "Monterrey Jack", Ingredient.Type.CHEESE);
            Ingredient salsa = new Ingredient(
                    "SLSA", "Salsa", Ingredient.Type.SAUCE);
            Ingredient sourCream = new Ingredient(
                    "SRCR", "Sour Cream", Ingredient.Type.SAUCE);
            repo.save(flourTortilla);
            repo.save(cornTortilla);
            repo.save(groundBeef);
            repo.save(carnitas);
            repo.save(tomatoes);
            repo.save(lettuce);
            repo.save(cheddar);
            repo.save(jack);
            repo.save(salsa);
            repo.save(sourCream);

            Taco taco1 = new Taco();
            taco1.setName("Carnivore");
            taco1.setIngredients(Arrays.asList(
                    flourTortilla, groundBeef, carnitas,
                    sourCream, salsa, cheddar));
            tacoRepo.save(taco1);
            Taco taco2 = new Taco();
            taco2.setName("Bovine Bounty");
            taco2.setIngredients(Arrays.asList(
                    cornTortilla, groundBeef, cheddar,
                    jack, sourCream));
            tacoRepo.save(taco2);
            Taco taco3 = new Taco();
            taco3.setName("Veg-Out");
            taco3.setIngredients(Arrays.asList(
                    flourTortilla, cornTortilla, tomatoes,
                    lettuce, salsa));
            tacoRepo.save(taco3);
        };
    }
}
