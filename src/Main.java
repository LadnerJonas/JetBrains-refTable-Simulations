import external.KeyClass;
import external.ValueClass;
import org.openjdk.jol.info.GraphLayout;

import java.util.concurrent.ConcurrentHashMap;

public class Main {
  final static int HASHMAP_SIZE = 45_000, PAYLOAD_SIZE = 10_000;
  public static void main(String[] args) {

    ConcurrentHashMap<KeyClass, ValueClass> hashMap = new ConcurrentHashMap<>();

    populate(hashMap);

    System.out.println(GraphLayout.parseInstance(hashMap).toFootprint());
    System.out.println("Total Size (B): "+ GraphLayout.parseInstance(hashMap).totalSize());
  }

  private static void populate(ConcurrentHashMap<KeyClass, ValueClass> hashMap) {
    for (int i = 0; i < HASHMAP_SIZE; i++) {
      hashMap.putIfAbsent(new KeyClass(i), new ValueClass(i, PAYLOAD_SIZE));
    }
  }
}