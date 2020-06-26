import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StreamPractice {
    public static void main(String[] args) {

        List<String> simbaErrors = new ArrayList<>();
        List<String> setSimbaErrors = new ArrayList<>(simbaErrors);

        simbaErrors.add("contas.txt");
        simbaErrors.add("agencia.txt");
        for(int i = 1; i < 5; i++){
            simbaErrors.add("Arquivo: AGENCIA, linha: "+i+", erro: deu ruim");
        }
        simbaErrors.add("origem.txt");
        simbaErrors.add("contas.txt");
        simbaErrors.add("Arquivo: CONTAS, linha: -1, erro: deu ruim");
        for(int i = 1; i < 5; i++){
            simbaErrors.add("Arquivo: CONTAS, linha: "+i+", erro: deu ruim");
        }

        setSimbaErrors.addAll(simbaErrors);
        simbaErrors.stream().forEach(e -> {
            String res = String.join("\n", setSimbaErrors);

            //getting just archives with errors
            Pattern archiveNameWithErrors = Pattern.compile("\\w+.txt(?=(\\n.+(.txt|.TXT))|$)");
            Matcher matcherArchiveNameWithErrors = archiveNameWithErrors.matcher(res);
            if (matcherArchiveNameWithErrors.find() && e != null) setSimbaErrors.remove(matcherArchiveNameWithErrors.group());

            Pattern noNegativeLines = Pattern.compile("Arquivo: \\w+, linha: \\-\\d+, .+");
            Matcher matcherNoNegativeLines = noNegativeLines.matcher(res);
            if (matcherNoNegativeLines.find())
                setSimbaErrors.remove(matcherNoNegativeLines.group());

        });

        simbaErrors.clear();
        simbaErrors.addAll(setSimbaErrors);

        System.out.println(simbaErrors);
    }
}
