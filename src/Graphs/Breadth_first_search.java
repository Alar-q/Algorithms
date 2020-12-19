package Graphs;

import java.util.*;

public class Breadth_first_search {
    //Нужно реализовать алгоритм поиска человека определенной профессии, самый ближний к кому-то в друзьях
    //Можно искать в друзьях друзей и в друзьях их друзей до тех пор пока не найдешь человека нужной профессии
    //Такой человек имеет на конце имени "_p"
    Map<String, String[]> map = new HashMap<String, String[]>();

    public Breadth_first_search() {
        //Возможно стоит еще добавить массив с Именами всех чуваков, чтобы можно было заносить имена в цикле. Или писать типа 1 друг: 2, 4, 3
        //Либо сначала добавить Set а потом перенести все значения в массив
        String[] allNames = new String[]{"Alar", "Dina", "Madina", "Zamira", "Ria_p", "Alimzhan", "Dastan"};

        //так нужно расписать для каждого человека
        map.put("Alar", new String[]{"Dina", "Madina", "Zamira"});
        map.put("Madina", new String[]{"Dina", "Hui", "Zamira"});
        map.put("Hui", new String[]{"Dina", "Ria_p", "Zamira"});
        map.put("Ulan", new String[]{"Zamira", "Alimzhan", "Dastan"});

        System.out.println("map.size()" + map.size());

        System.out.println(search("Alar", "_p"));


    }

    public String search(String name, String addition){
        Set<String> was = new HashSet<String>();
        Queue<String> queue = new PriorityQueue<String>();

        add(queue, map.get(name));

        while(!queue.isEmpty()){
            String person = queue.poll();
            if(person!=null && !was.contains(person)){
                if(compare(person, addition)) {
                    return person;
                }
                else{
                    was.add(person);
                    if(map.containsKey(person))//если прописать всех людей в Map, то проверять не придется
                        add(queue, map.get(person));
                }
            }
        }
        return "not found";
    }

    private boolean compare(String person, String need){
        if(person.endsWith(need)) return true;
        else return false;
    }
    private void add(Queue<String> queue, String[] sArr){
        for(String s: sArr) queue.add(s);
    }
}
