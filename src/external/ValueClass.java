package external;

import java.util.ArrayList;
import java.util.List;

public class ValueClass {
  public int value;
  public List<Integer> payload;
  public ValueClass(int value, int payloadSize) {
    this.value = value;
    payload = new ArrayList<>(payloadSize);
  }

}
