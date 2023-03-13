package demo;

import java.util.ArrayList;
import java.util.List;

public class G1GcDemo {

    public static void main(String[] args) {
        System.out.println("Starting G1GCDemo...");

        // G1 GC 설정
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "8");
        System.setProperty("jdk.g1.maxpausemillis", "200");
        System.setProperty("jdk.g1.pauseless_parallelism", "true");
        System.setProperty("jdk.g1.heapregion.size", "1m");
        System.setProperty("jdk.g1.maxgcpausemillis", "1000");
        System.setProperty("jdk.g1.heapregion.size", "4m");

        List<TestObj> list = new ArrayList<>();
        // 메모리 사용
        for (int i = 0; i < 1000000; i++) {
            TestObj testObj = new TestObj();
            list.add(testObj);
        }

        // 메모리 사용이 끝난 후 명시적인 가비지 컬렉션을 수행
        System.gc();

        System.out.println("G1GCDemo finished.");
    }
}
