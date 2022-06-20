import java.util.concurrent.Callable;

public class Divisors implements Runnable {
    private int thread;
    public Divisors(int thread){
        this.thread=thread;
    }
    public Divisors(){}

    public void run(){
        int result = numberWithTheLargestNumberOfDivisors();
        System.out.println("Thread nr. " + thread + " : " + result);
    }

    public int numberWithTheLargestNumberOfDivisors(){
        int max=-1;
        int result=0;
        for(int i = 1; i <= 100000; i++){
            int numberOfDivisorsForI = numberOfDivisors(i);
            if(numberOfDivisorsForI > max){
                max = numberOfDivisorsForI;
                result = i;
            }
        }
        return result;
    }

    public int numberOfDivisors(int number){
        int counter = 0;
        for(int i = 1; i <= number; i++){
            if(number % i == 0){
                counter++;
            }
        }
        return counter;
    }

}
