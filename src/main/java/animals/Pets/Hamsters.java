package animals.Pets;

import animals.Pet;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class Hamsters extends Pet {
    public Hamsters(String name, String birthday, ArrayList skills) throws ParseException {
        super(name, "Хомяк", birthday, skills);
    }
}