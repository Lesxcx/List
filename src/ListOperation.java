import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ListOperation {
    private Random random = new Random();
    private List<Integer> table = new ArrayList<>();
    private List<Integer> list = new LinkedList<>();
    private final int iteration;

    public ListOperation(int n, int iteration) {
        this.iteration = iteration;
        for(int i = 0; i < n; i++) {
            table.add(random.nextInt());
            list.add(random.nextInt());
        }
    }

    public void testAdd(){
        long listTime = testAddEnd(list);
        long tableTime = testAddEnd(table);
        console(listTime, tableTime);
    }

    public void testInsert(){
        long listTime = testAddEnd(list);
        long tableTime = testAddEnd(table);
        console(listTime, tableTime);
    }
    private void console(long listTime, long tableTime){
        System.out.println("Czas dla implementacji listowej: " + listTime);
        System.out.println("Czas dla implementacji tablicowej: " + tableTime);
        long diff = listTime - tableTime;
        String winner = diff > 0 ? "tablica" : "lista";
        System.out.printf("Wygrał: %s, różnica %d", winner, Math.abs(diff));
        System.out.println();
    }
    private long testAddEnd(List<Integer> list){
        long start = System.nanoTime();
        for (int i = 0; i<iteration; i++)  list.add(3);

        long stop = System.nanoTime();
        return stop - start;
    }

    private long testInsert(List<Integer> list){
        long start = System.nanoTime();
        for(int i = 0; i < iteration; i++) {
            int index = random.nextInt(list.size()  );
            list.add(index,7);
        }
        long stop = System.nanoTime();
        return stop - start;
    }

}
