package com.java.executers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableClass {
    public static void main(String[] args) {
        CallableTest callableTest = new CallableTest("sarita");
        CallableTest callableTest1 = new CallableTest("sari");
        CallableTest callableTest2 = new CallableTest("rita");
        ExecutorService service = Executors.newFixedThreadPool(1);
        List<CallableTest> tests = new ArrayList<>();
        tests.add(callableTest);
        tests.add(callableTest1);
        tests.add(callableTest2);
        try {
          List<Future<String>> list=  service.invokeAll(tests);
            for (Future<String> future:list) {
                System.out.println(future.get());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


//        for (int i = 0; i < 10; i++) {
//            Future<String> future = service.submit(callableTest);
//            System.out.println("future obj will store the return types in future");
//            try {
//                String result = future.get();
//                System.out.println(result);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
//        }
        service.shutdown();
    }
}

class CallableTest implements Callable<String> {
    String name;

    public CallableTest(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        return "hello" + name;
    }
}
