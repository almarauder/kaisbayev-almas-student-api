package com.student.api;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.info.BuildProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class InfoController {
    private final ObjectProvider<BuildProperties> buildProperties;

    public InfoController(ObjectProvider<BuildProperties> buildProperties) {
        this.buildProperties = buildProperties;
    }

    @GetMapping("/api/info")
    public Map<String, String> info() {
        BuildProperties bp = buildProperties.getIfAvailable();
        Map<String, String> m = new LinkedHashMap<>();
        m.put("student", "Kaisbayev Almas");
        m.put("application", "kaisbayev-almas-student-api");
        m.put("version", bp == null ? "dev" : bp.getVersion());
        return m;
    }
}
