import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Challenge:John keeps a backup of his old personal phone book as a text file.
 * On each line of the file he can find the phone number
 * (formated as +X-abc-def-ghij where X stands for one or two digits),
 * the corresponding name between < and > and the address.
 *
 * Unfortunately everything is mixed, things are not always in the same order;
 * parts of lines are cluttered with non-alpha-numeric characters
 * (except inside phone number and name).
 *
 * Examples:
 * s = "/+1-541-754-3010 156 Alphand_St. <J Steeve>\n 133, Green, Rd. <E Kustur> NY-56423 ;+1-541-914-3010!\n"
 * phone(s, "1-541-754-3010") should return "Phone => 1-541-754-3010, Name => J Steeve, Address => 156 Alphand St."
 */

class Pair {
    private String name, adress;

    public Pair(String name, String adress){
        this.name = name;
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }
}

public class Phone_directory {
    public static  String phone(String strng, String num) {
        String splited_list[] = strng.split("\n");
        Map<String, Pair> map = new HashMap<>();
        String phone_regex = "\\d{1,2}-\\d{3}-\\d{3}-\\d{4}";
        String name_regex = "<([^<>]+)>";
        String name = "", adress = "", phone = "";


        for (String value: splited_list){
            Pattern phone_pattern = Pattern.compile(phone_regex);
            Matcher phone_matcher = phone_pattern.matcher(value);
            Pattern name_pattern = Pattern.compile(name_regex);
            Matcher name_matcher = name_pattern.matcher(value);

            if (phone_matcher.find()){
                phone = phone_matcher.group();
            }
            if (name_matcher.find()){
                name = name_matcher.group(1);
            }

            adress = value.replaceAll(name_regex, "");
            adress = adress.replaceAll(phone_regex, "");
            adress = adress.replaceAll("[!*/+,?$:;]", "");
            adress = adress.replaceAll("[_]", " ");
            adress = adress.replaceAll("\\s+", " ");

            if (map.containsKey(phone)){
                map.put(phone, new Pair("to_many_people_error", ""));
            }
            else{
                map.put(phone, new Pair(name, adress));
            }
        }

        if (map.containsKey(num)){
            if (map.get(num).getName() == "to_many_people_error"){
                return "Error => Too many people: num";
            }
            else{
                return "Phone => " + num +", Name => " +map.get(num).getName() +", Address => " +map.get(num).getAdress();
            }
        }
        else {
            return "Error => Not found: num";
        }
    }

    public static void main(String[] args) {

        String dr = "/+1-541-754-3010 156 Alphand_St. <J Steeve>\n 133, Green, Rd. <E Kustur> NY-56423 ;+1-541-914-3010\n"
                + "+1-541-984-3012 <P Reed> /PO Box 530; Pollocksville, NC-28573\n :+1-321-512-2222 <Paul Dive> Sequoia Alley PQ-67209\n"
                + "+1-741-984-3090 <Peter Reedgrave> _Chicago\n :+1-921-333-2222 <Anna Stevens> Haramburu_Street AA-67209\n"
                + "+1-111-544-8973 <Peter Pan> LA\n +1-921-512-2222 <Wilfrid Stevens> Wild Street AA-67209\n"
                + "<Peter Gone> LA ?+1-121-544-8974 \n <R Steell> Quora Street AB-47209 +1-481-512-2222\n"
                + "<Arthur Clarke> San Antonio $+1-121-504-8974 TT-45120\n <Ray Chandler> Teliman Pk. !+1-681-512-2222! AB-47209,\n"
                + "<Sophia Loren> +1-421-674-8974 Bern TP-46017\n <Peter O'Brien> High Street +1-908-512-2222; CC-47209\n"
                + "<Anastasia> +48-421-674-8974 Via Quirinal Roma\n <P Salinger> Main Street, +1-098-512-2222, Denver\n"
                + "<C Powel> *+19-421-674-8974 Chateau des Fosses Strasbourg F-68000\n <Bernard Deltheil> +1-498-512-2222; Mount Av.  Eldorado\n"
                + "+1-099-500-8000 <Peter Crush> Labrador Bd.\n +1-931-512-4855 <William Saurin> Bison Street CQ-23071\n"
                + "<P Salinge> Main Street, +1-098-512-2222, Denve\n"+ "<P Salinge> Main Street, +1-098-512-2222, Denve\n";
        System.out.println(phone(dr, "48-421-674-8974"));

    }
}
