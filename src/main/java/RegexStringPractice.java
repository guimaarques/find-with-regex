import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexStringPractice {

    public static void main(String[] args) {

        List<String> simbaErrors = new ArrayList<>();

        simbaErrors.add("agencia.txt");
        for(int i = 1; i < 5; i++){
            simbaErrors.add("Arquivo: agencia.txt, linha: "+i+", erro: deu ruim");
        }
        simbaErrors.add("contas.txt");
        for(int i = 1; i < 5; i++){
            simbaErrors.add("Arquivo: contas.txt, linha: "+i+", erro: deu ruim");
        }

        List<String> agenciaErrors = new ArrayList<>();
        List<String> contaErrors = new ArrayList<>();

        simbaErrors.forEach(e -> {

            Pattern pattern = Pattern.compile("Arquivo: (agencia|AGENCIA).(txt|TXT),.+");
            Matcher matcher = pattern.matcher(e);

            if(matcher.find())
                agenciaErrors.add(matcher.group());

            Pattern patternConta = Pattern.compile("Arquivo: (contas|CONTAS).(txt|TXT),.+");
            Matcher matcherConta = patternConta.matcher(e);

            if(matcherConta.find())
                contaErrors.add(matcherConta.group());
        });

        System.out.println(agenciaErrors);
        System.out.println(contaErrors);
    }
}
