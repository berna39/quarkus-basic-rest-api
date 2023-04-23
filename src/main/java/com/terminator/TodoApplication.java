package com.terminator;

import javax.ws.rs.core.Application;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;

@OpenAPIDefinition(
    info = @Info(
        title = "Todos application",
        description = "This is a funny Todo REST API",
        version = "1.0.0",
        license = @License(
            name = "MIT",
            url = "http://localhost:8080"
        )
    )
)
public class TodoApplication extends Application{
    
}
