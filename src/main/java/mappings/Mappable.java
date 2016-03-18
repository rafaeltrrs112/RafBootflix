package mappings;

import com.google.gson.JsonObject;

/**
 * Mappable interface for ORMs.
 */
public interface Mappable {
    JsonObject toJson();
}
