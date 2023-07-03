package fr.uga.l3miage.example.idgenerator;

import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

public class IdMetierMiahootGenerator {
    public static String generateIdMetier() {

        UUID uuid = UUID.randomUUID();

        String newIdMetier = "MH-" + uuid.toString();

        newIdMetier = StringUtils.substring(newIdMetier, 0, 8);

        return newIdMetier;
    }
}
