package Graphs;

import java.util.*;

//https://www.youtube.com/watch?v=UA6aV1XJCGg&t=1085s - теория

public class Dijkstras_algorithm {

    Map<String, Map<String, Integer>> map;
    Map<String, Integer> storage_Of_values;

    public Dijkstras_algorithm(){
        map = new HashMap<>();
        putNeighbours();

        storage_Of_values = new HashMap<>();
        putStorageOfValues("X1", 0);

    }
    private void putStorageOfValues(String startKey, int startValue){
        storage_Of_values.put(startKey, startValue);
        //for(){}
        storage_Of_values.put("X2", Integer.MAX_VALUE);
        storage_Of_values.put("X3", Integer.MAX_VALUE);
        storage_Of_values.put("X4", Integer.MAX_VALUE);
    }

    public int min_Distance(){
        int result = -1;

        HashMap<String, String> nodeReturnParent = new HashMap<>();

        List<String> not_yet_verified = new ArrayList<String>();
        not_yet_verified.add("X1");

         do{
            String node = getMinIn(not_yet_verified, storage_Of_values);

            Map<String, Integer> neighbours = map.get(node);
            for (String neighbour : neighbours.keySet()) {
                int newValue = storage_Of_values.get(node) + neighbours.get(neighbour);
                System.out.println("storage_Of_values.get(" + node + ")+neighbours.get(" + neighbour + ")=" + (storage_Of_values.get(node) + neighbours.get(neighbour)));
                if (newValue < storage_Of_values.get(neighbour)) {
                    System.out.println("now min dist to " + neighbour + " = " + newValue);
                    nodeReturnParent.put(neighbour, node);
                    storage_Of_values.put(neighbour, newValue);
                    not_yet_verified.add(neighbour);
                }
            }
        }while(!not_yet_verified.isEmpty());

        for(String node1: map.keySet())
            System.out.println("minimum dist to "+node1+" = "+storage_Of_values.get(node1));

        return result;
    }

    private String getMinIn(List<String> list, Map<String, Integer> storage_Of_values){
        //Найти минимальный
        String res = null;
        int min_value = Integer.MAX_VALUE;
        for(String s: list){
            int may_be = storage_Of_values.get(s);
            if(may_be<min_value) {
                min_value = may_be;
                res = s;
            }
        }
        list.remove(res);
        return res;
    }

    private void putNeighbours(){
        Map<String, Integer> neighbours1 = new HashMap<>(),
                neighbours2 = new HashMap<>(),
                neighbours3 = new HashMap<>(),
                neighbours4 = new HashMap<>();

        neighbours1.put("X2", 5);
        neighbours1.put("X3", 3);
        map.put("X1", neighbours1);

        neighbours2.put("X4", 3);
        neighbours2.put("X3", 1);
        map.put("X2", neighbours2);

        neighbours3.put("X4", 2);
        neighbours3.put("X2", 1);
        map.put("X3", neighbours3);

        map.put("X4", neighbours4);
    }

}
