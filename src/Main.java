import external.KeyClass;
import external.ValueClass;
import org.openjdk.jol.info.GraphLayout;

import java.util.concurrent.ConcurrentHashMap;

public class Main {
  public static void main(String[] args) {
    final int HASHMAP_SIZE = 45_000, PAYLOAD_SIZE = 10_000;

    ConcurrentHashMap<KeyClass, ValueClass> hashMap = new ConcurrentHashMap<>();

    populate(hashMap, HASHMAP_SIZE, PAYLOAD_SIZE);

    System.out.println(GraphLayout.parseInstance(hashMap).toFootprint());
    System.out.println("Total Size (B): "+ GraphLayout.parseInstance(hashMap).totalSize());
  }

  private static void populate(ConcurrentHashMap<KeyClass, ValueClass> hashMap, int hashMapSize, int payloadSize) {
    for (int i = 0; i < hashMapSize; i++) {
      hashMap.putIfAbsent(new KeyClass(i), new ValueClass(i, payloadSize));
    }
  }
}