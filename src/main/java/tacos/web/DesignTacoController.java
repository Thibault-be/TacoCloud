package tacos.web;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import tacos.Ingredient;
import tacos.Taco;
import tacos.TacoOrder;
import tacos.data.IngredientRepository;
import tacos.data.JdbcIngredientRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
@RequiredArgsConstructor
public class DesignTacoController {

    private final IngredientRepository ingredientRepository;


    @ModelAttribute
    public void addIngredientsToModel(Model model) {

        Iterable<Ingredient> ingredients = ingredientRepository.findAll();

        List<Ingredient> ingredientsList = StreamSupport.stream(ingredients.spliterator(), false)
                .toList();


        Ingredient.Type[] types = Ingredient.Type.values();
        for (Ingredient.Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredientsList, type));
        }
    }

    @ModelAttribute(name = "tacoOrder")
    public TacoOrder order() {
        return new TacoOrder();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    @GetMapping
    public String showDesignForm() {
        return "design";
    }

    @PostMapping
    public String processTaco(@Valid Taco taco,
                              Errors errors,
                              @ModelAttribute TacoOrder tacoOrder) {

        if (errors.hasErrors()) {
            return "design";
        }

        tacoOrder.addTaco(taco);
        log.info("Processing taco: {}", taco);

        return "redirect:/orders/current";
    }


    private Iterable<Ingredient> filterByType(
            List<Ingredient> ingredients, Ingredient.Type type) {


        return ingredients.stream()
                .filter(item -> item.getType().equals(type))
                .collect(Collectors.toList());
    }
}
