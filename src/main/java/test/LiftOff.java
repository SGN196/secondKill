package test;

/**
 * @author SGN196
 * @date 2019/3/27 13:19
 */

public class LiftOff implements Runnable
{
    protected  int countDown = 1000000;
    private static int taskCount = 0;
    private final int id = taskCount++;
    public LiftOff(){

    }
    public LiftOff(int countDown){
        this.countDown = countDown;
    }

    @Override
    public void run()
    {
        System.out.println(System.currentTimeMillis() - start);

        while(countDown-- > 0){
//            System.out.println(id + " " + countDown);
            Thread.yield();
        }

    }

    public static long start;
    public static void main(String[] args)
    {
        LiftOff liftOff = new LiftOff();

        Thread t1 = new Thread(liftOff);
        start = System.currentTimeMillis();
        t1.start();

    }
}
