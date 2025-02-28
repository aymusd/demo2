package com.example;

import java.util.HashMap;
import java.util.Map;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

@LambdaHandler(
    lambdaName = "hello_world",
	roleName = "hello_world-role",
	isPublishVersion = true,
	aliasName = "${lambdas_alias_name}",
	logsExpiration = RetentionSetting.SYNDICATE_ALIASES_SPECIFIED
)

public class HelloWorld implements RequestHandler<Map<String, Object>, Map<String, Object>> {

    @Override
    public Map<String, Object> handleRequest(Map<String, Object> input, Context context) {
        Map<String, Object> response = new HashMap<>();
        response.put("statusCode", 200);
        response.put("message", "Hello from Lambda");
        return response;
    }
}
