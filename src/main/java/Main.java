import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        divisorsCallWithoutThreads();
        divisorsCallUsingThreads();
    }
    public static void divisorsCallWithoutThreads(){
        System.out.println("Number with the largest number of divisors without threads");
        Divisors divisors = new Divisors();
        System.out.println(divisors.numberWithTheLargestNumberOfDivisors());
    }
    public static  void divisorsCallUsingThreads(){
        System.out.println("Number with the largest number of divisors using threads");
        ExecutorService es = Executors.newFixedThreadPool(10);
        for (int threadNumber = 0; threadNumber < 10; threadNumber++) {
            Divisors numberDivisors = new Divisors(threadNumber);
            es.submit(numberDivisors);
        }

        try {
            es.shutdown();
            es.awaitTermination(60, TimeUnit.SECONDS);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
