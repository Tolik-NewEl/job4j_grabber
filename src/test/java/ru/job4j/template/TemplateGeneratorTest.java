package ru.job4j.template;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Disabled
class TemplateGeneratorTest {

    @Test
    public void whenCorrectInput() {
        Generator generator = new TemplateGenerator();
        String template = "I am a ${name}, Who are ${subject}? ";
        HashMap<String, String> hm = new HashMap<>();
        hm.put("name", "Petr Arsentev");
        hm.put("subject", "you");
        String rsl = generator.produce(template, hm);
        assertThat(rsl).isEqualTo("I am a Petr Arsentev, Who are you? ");
    }

    @Test
    public void whenKeysMoreThanNeed() {
        Generator generator = new TemplateGenerator();
        String template = "I am a ${name}, Who are ${subject}? ";
        HashMap<String, String> hm = new HashMap<>();
        hm.put("name", "Petr Arsentev");
        hm.put("subject", "you");
        hm.put("phone", "123456");
        assertThrows(IllegalArgumentException.class,
                () -> generator.produce(template, hm));
    }

    @Test
    public void whenKeysNotFromTemplate() {
        Generator generator = new TemplateGenerator();
        String template = "I am a ${name}, Who are ${subject}? Greetings ${person}";
        HashMap<String, String> hm = new HashMap<>();
        hm.put("name", "Petr Arsentev");
        hm.put("subject", "you");
        assertThrows(IllegalArgumentException.class,
                () -> generator.produce(template, hm));
    }
}