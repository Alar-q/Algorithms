package DynamicProgramming;

import java.io.PrintWriter;
import java.util.*;

/*3 4 2 1 1 1 3 5 ANSWER: MAXIMUM BENEFIT - 42, Best selection of items - [4, 3, 1, 0]*/
/*3 4 4 3 3 2 1 2*/
/*5 30 3 2 5 10 11 2 16 20 2 10*/

public class Knapsack_problem {

    int n, max_weight;
    Item[] list_Of_items;
    int[][] table;

    long startTime;

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in); PrintWriter out = new PrintWriter(System.out)) {
            new Knapsack_problem(in).solve(out);
        }
    }

    private class Item {
        int weight, price;
        Item(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }
    }

    private Knapsack_problem(Scanner in){
        if(in.hasNext())
            startTime = System.nanoTime();

        n = in.nextInt();
        max_weight = in.nextInt();

        list_Of_items = new Item[n];
        for(int i=0; i<n; i++)
            list_Of_items[i] = new Item(in.nextInt(), in.nextInt()); //Вводим данные о всех предметах


        table = new int[n+1][max_weight+1]; //строка - предмет (кроме нулевой), колонка - стоимость.

        for(int i=0; i<=max_weight ; i++)
            table[0][i] = 0; //Заполняем первую строку в таблице нулями

    }

    private void solve(PrintWriter out) {

        for(int itemID=0; itemID<n; itemID++){
            Item item = list_Of_items[itemID];

            int row = itemID+1; //Так потому что первая строка чисто нулевая
            int[] lastTable = table[row-1];
            int[] tableNow = table[row];

            for(int weight=0; weight<=max_weight; weight++){

                if(item.weight<weight){
                    int mbNewPrice = item.price + lastTable[weight-item.weight];

                    if(mbNewPrice > lastTable[weight]) {
                        tableNow[weight] = mbNewPrice;
                        continue;
                    }
                }
                else if(item.weight==weight && item.price > lastTable[weight]) {
                    tableNow[weight] = item.price;
                    continue;
                }

                tableNow[weight] = lastTable[weight];

            }
            //out.println("item " + itemID + ": " + Arrays.toString(table[row]));//таблица если нужна в отладке
        }

        List<Integer> chain = checkChain(table, list_Of_items);

        out.print("MAXIMUM BENEFIT = " + table[n][max_weight] + "; ");
        out.println("BEST SELECTION OF ITEMS = " + chain + ". ");

        out.println("TIME = " + countTime());
    }

    private List<Integer> checkChain(int[][] mat, Item[] list_Of_Items){
        List<Integer> result_list = new ArrayList<Integer>();
        for(int row=mat.length-1, col=mat[0].length-1; row>0 && col>0; row--) {
            // Иду с правого нижнего края ([ .] - начальная точка) ->
            // влево вверх ([' ] - конечная точка, но закончится может и просто если будет слева, то есть эта точка необязательно должная быть наверху)

            // Если верхняя стоимость не совпадает с нынешней, то значит мы использовали этот объект, вводим его (item, а точнее только его индекс)
            // После чего отнимаем от col(weight or price) - item.price. Повторяем
            // Кстати, если цены совпадают значит мы не использовали этот объект можно подниматься наверх(сменить объект или item)
            if (mat[row][col] != mat[row - 1][col]) {
                result_list.add(row - 1);
                col -= list_Of_Items[row - 1].weight;
            }
        }
        return result_list;
    }
    private float countTime(){
        float deltaTime =  ( System.nanoTime() - startTime) / 1000000000.0f ;
        return deltaTime;
    }
}
