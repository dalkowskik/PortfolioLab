package pl.coderslab.charity.conwerters;

import org.springframework.core.convert.converter.Converter;
import pl.coderslab.charity.entities.Institution;
import pl.coderslab.charity.repositories.InstitutionRepo;

public class InstitutionConverter implements Converter<String, Institution> {

    private InstitutionRepo institutionRepo;

    public InstitutionConverter(InstitutionRepo institutionRepo) {
        this.institutionRepo = institutionRepo;
    }


    @Override
    public Institution convert(String s) {
        return institutionRepo.findById(Long.parseLong(s)).get();
    }
}
