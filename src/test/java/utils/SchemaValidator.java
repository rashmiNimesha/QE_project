package utils;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;

import java.io.File;
import java.util.Set;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class SchemaValidator {

    public static void validate(String responseBody, String schemaPath) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        JsonNode jsonNode = mapper.readTree(responseBody);
        JsonNode schemaNode = mapper.readTree(new File(schemaPath));

        JsonSchemaFactory factory =
                JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V4);

        JsonSchema schema = factory.getSchema(schemaNode);

        Set<ValidationMessage> errors = schema.validate(jsonNode);

        if (!errors.isEmpty()) {
            throw new RuntimeException(errors.toString());
        }
    }
}
