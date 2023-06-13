package org.example;

import org.example.collection.City;

import java.util.Comparator;

public class Animator {
    private static Animator instance;

    private Animator() {
    }

    public static Animator getInstance() {
        if (instance == null) instance = new Animator();
        return instance;
    }

    public String animate(Response aResponse) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        if (aResponse.getStatus().equals(TypeOfAnswer.SUCCESSFUL)) {
            if (aResponse.getInformation() != null){
                return aResponse.getInformation();
            }
            if (aResponse.getInformationMap() != null) {
                if (aResponse.getInformationMap().get("1") == null) {
                    aResponse.getInformationMap().
                            forEach((key, value) -> sb.append("\t")
                                    .append(key)
                                    .append(" : ")
                                    .append(value.toUpperCase())
                                    .append("\n\n"));
                } else {
                    aResponse.getInformationMap()
                            .keySet()
                            .stream()
                            .map(Integer::parseInt)
                            .sorted(Integer::compareTo)
                            .map(String::valueOf)
                            .forEach(key -> sb.append("\t")
                                    .append(key)
                                    .append(" : ")
                                    .append(aResponse.getInformationMap().get(key).toUpperCase())
                                    .append("\n\n"));
                }
            }
            if (aResponse.getCollection() != null) {
                aResponse.getCollection().stream()
                        .sorted(Comparator.comparing(City::getName))
                        .forEach(sg -> sb.append(sg).append("\n\n"));
            }
            if (aResponse.getCity() != null) {
                sb.append(aResponse.getCity().toString())
                        .append("\n");
            }

            if (sb.toString().equals("\n")) return ("\n\tAction processed successful!\n");
        } else {
            switch (aResponse.getStatus()) {
                case OBJECTNOTEXIST:
                    return ("\n\tNo object with such parameters was found!\n");
                case DUPLICATESDETECTED:
                    return ("\tThis element probably duplicates " +
                            "existing one and can't be added\n");
                case ISNTMAX:
                    return ("\n\tCity isn't max!\n");
                case ISNTMIN:
                    return ("\n\tCity isn't min!\n");
                case PERMISSIONDENIED:
                    return ("\n\tPermission denied!\n");
                case SQLPROBLEM:
                    return ("\n\tSome problem's with database on server!\n");
                case EMPTYCOLLECTION:
                    return ("\n\tCollection is empty!\n");
                case ALREADYREGISTERED:
                    return ("\n\tThis account already registered!\n");
                case NOTMATCH:
                    return ("\n\tAccount with this parameters doesn't exist!\n");
                case NOGREATER:
                    return ("\n\tNo collection greater!");
                case NOLOWER:
                    return ("\n\tNo collection lower!");
            }

        }
        return sb.toString();
    }
}
