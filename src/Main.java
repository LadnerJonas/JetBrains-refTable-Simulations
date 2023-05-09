import external.KeyClass;
import external.ValueClass;
import org.openjdk.jol.info.GraphLayout;

import java.util.concurrent.ConcurrentHashMap;

public class Main {
  final static int HASHMAP_SIZE = 45_000, PAYLOAD_SIZE = 10_000;

  public static void main(String[] args) {
    ConcurrentHashMap<KeyClass, ValueClass> hashMapWithoutPayload = new ConcurrentHashMap<>();

    populate(hashMapWithoutPayload);

    System.out.println("HashMap Size with no additional Payload:");
    System.out.println("Total Size (B): " + GraphLayout.parseInstance(hashMapWithoutPayload).totalSize());


    ConcurrentHashMap<KeyClass, ValueClass> hashMapWithPayload = new ConcurrentHashMap<>();

    populateWithPayload(hashMapWithPayload, PAYLOAD_SIZE);

    System.out.println("HashMap Size with additional Payload ("+PAYLOAD_SIZE+" Integers):");
    System.out.println("Total Size (B): " + GraphLayout.parseInstance(hashMapWithPayload).totalSize());
  }

  private static void populate(ConcurrentHashMap<KeyClass, ValueClass> hashMap) {
    populateWithPayload(hashMap, 0);
  }

  private static void populateWithPayload(ConcurrentHashMap<KeyClass, ValueClass> hashMap, int payloadSize) {
    for (int i = 0; i < HASHMAP_SIZE; i++) {
      hashMap.putIfAbsent(new KeyClass(i), new ValueClass(i, payloadSize));
    }
  }
}