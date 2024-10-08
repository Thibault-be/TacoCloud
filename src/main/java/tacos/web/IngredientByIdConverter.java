package tacos.web;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import tacos.Ingredient;
import tacos.data.JdbcIngredientRepository;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private final JdbcIngredientRepository ingredientRepository;

    @Override
    public Ingredient convert(String id){
        return ingredientRepository.findById(id).orElse(null);
    }
}
