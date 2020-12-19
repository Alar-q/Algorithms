import java.io.*;
import java.util.*;

public class Text {
    public static void main(String[] args){
        Text text = new Text();
        String word = "балфм";
        int words_length = word.length();
        Map<String, Set<String>> sim_letters = new HashMap<>();
        text.loadMayBeLetters(sim_letters);

        List<String> similar_words = text.compare_From_Dictionary_By_Levenshtein("C:\\Users\\Pupochek\\IdeaProjects\\Algorithms\\assets\\kz_dict.txt", word);
        List<String> correct_words = new ArrayList<>();
        for(String s: similar_words){
            if(s.length()==words_length && text.isSimi(word, s, sim_letters)) {
                correct_words.add(s);
            }
        }
        if(correct_words.isEmpty()){
            correct_words.add(word);
        }
        System.out.println(correct_words);
    }

    private boolean isSimi(String word, String simi2, Map<String, Set<String>> dict_sim){
        boolean res = true;
        String[] w = word.split("");
        String[] str2 = simi2.split("");
        for(int i=0; i<word.length(); i++){
            if(!w[i].equals(str2[i])){
                if(!dict_sim.get(w[i]).contains(str2[i])){
                    res = false;
                }
            }
        }
        return res;
    }

    public List<String> compare_From_Dictionary_By_Levenshtein(String DictFileName, String str){
        List<String> words = new ArrayList<String>();
        if(str.isEmpty()) return words;

        String strLow = str.toLowerCase();

        try (BufferedReader reader = new BufferedReader(new FileReader(DictFileName))) {
            String line;
            int minDist = strLow.length();
            while ( (line = reader.readLine()) != null) {
                int dist = levenshtein(str, line);
                if(dist<minDist){
                    minDist=dist;
                    words.clear();
                    words.add(line);
                }
                else if(minDist == dist){
                    words.add(line);
                }
                else if(dist==0){
                    words.add(line);
                }
            }
            System.out.println(minDist);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }



    public static int levenshtein(String stringOne, String stringTwo) {
        // store length
        int m = stringOne.length(), n = stringTwo.length();

        // matrix to store differences
        int[][] deltaM = new int[m+1][n+1];

        for(int i = 1;i <= m; i++) {
            deltaM[i][0] = i;
        }

        for(int j = 1;j <= n; j++) {
            deltaM[0][j] = j;
        }

        for(int j=1;j<=n;j++) {
            for (int i = 1; i <= m; i++) {
                if (stringOne.charAt(i - 1) == stringTwo.charAt(j - 1)) {
                    deltaM[i][j] = deltaM[i - 1][j - 1];
                }
                else {
                    deltaM[i][j] = Math.min(deltaM[i - 1][j] + 1, Math.min(deltaM[i][j - 1] + 1, deltaM[i - 1][j - 1] + 1));
                }
            }
        }
        return deltaM[m][n];
    }

    private void loadMayBeLetters(Map<String, Set<String>> sim_letters){
        sim_letters.put("а", new HashSet<>(Arrays.asList()));
        sim_letters.put("ә", new HashSet<>(Arrays.asList()));
        sim_letters.put("б", new HashSet<>(Arrays.asList()));
        sim_letters.put("в", new HashSet<>(Arrays.asList()));
        sim_letters.put("г", new HashSet<>(Arrays.asList()));
        sim_letters.put("ғ", new HashSet<>(Arrays.asList()));
        sim_letters.put("д", new HashSet<>(Arrays.asList()));
        sim_letters.put("е", new HashSet<>(Arrays.asList()));
        sim_letters.put("ё", new HashSet<>(Arrays.asList()));
        sim_letters.put("ж", new HashSet<>(Arrays.asList()));
        sim_letters.put("з", new HashSet<>(Arrays.asList("в")));
        sim_letters.put("и", new HashSet<>(Arrays.asList()));
        sim_letters.put("й", new HashSet<>(Arrays.asList()));
        sim_letters.put("к", new HashSet<>(Arrays.asList("қ")));
        sim_letters.put("қ", new HashSet<>(Arrays.asList("к", "ң")));
        sim_letters.put("л", new HashSet<>(Arrays.asList()));
        sim_letters.put("м", new HashSet<>(Arrays.asList()));
        sim_letters.put("н", new HashSet<>(Arrays.asList( "ы", "п")));
        sim_letters.put("ң", new HashSet<>(Arrays.asList("қ", "н")));
        sim_letters.put("о", new HashSet<>(Arrays.asList()));
        sim_letters.put("ө", new HashSet<>(Arrays.asList()));
        sim_letters.put("с", new HashSet<>(Arrays.asList()));
        sim_letters.put("т", new HashSet<>(Arrays.asList()));
        sim_letters.put("у", new HashSet<>(Arrays.asList()));
        sim_letters.put("ұ", new HashSet<>(Arrays.asList()));
        sim_letters.put("ү", new HashSet<>(Arrays.asList()));
        sim_letters.put("ф", new HashSet<>(Arrays.asList()));
        sim_letters.put("х", new HashSet<>(Arrays.asList()));
        sim_letters.put("һ", new HashSet<>(Arrays.asList()));
        sim_letters.put("ц", new HashSet<>(Arrays.asList()));
        sim_letters.put("ч", new HashSet<>(Arrays.asList()));
        sim_letters.put("ш", new HashSet<>(Arrays.asList()));
        sim_letters.put("щ", new HashSet<>(Arrays.asList()));
        sim_letters.put("ъ", new HashSet<>(Arrays.asList()));
        sim_letters.put("ы", new HashSet<>(Arrays.asList("н")));
        sim_letters.put("і", new HashSet<>(Arrays.asList()));
        sim_letters.put("ь", new HashSet<>(Arrays.asList()));
        sim_letters.put("э", new HashSet<>(Arrays.asList()));
        sim_letters.put("ю", new HashSet<>(Arrays.asList()));
        sim_letters.put("я", new HashSet<>(Arrays.asList()));
    }
}
