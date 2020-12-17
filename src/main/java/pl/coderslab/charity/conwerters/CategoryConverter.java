package pl.coderslab.charity.conwerters;

import org.springframework.core.convert.converter.Converter;
import pl.coderslab.charity.entities.Category;
import pl.coderslab.charity.repositories.CategoryRepo;


import java.util.List;
import java.util.stream.Collectors;

public class CategoryConverter implements Converter<String, Category> {


    private CategoryRepo categoryRepo;

    public CategoryConverter(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }


    public List<Category> convertList(List<String> s) {
        return s.stream().map(e -> categoryRepo.findByName(e)).collect(Collectors.toList());
    }


    @Override
    public Category convert(String s) {
        return categoryRepo.findById(Long.parseLong(s)).get();
    }
}
