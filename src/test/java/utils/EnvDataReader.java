package utils;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import lombok.experimental.UtilityClass;
import models.EnvData;

@UtilityClass
public class EnvDataReader extends JsonReader{
    private final String ENVIRONMENT_PATH = RESOURCES_PATH + "environment/";
    private final ISettingsFile ENVIRONMENT_CONFIG = new JsonSettingsFile("env.json");

    private String getCurrentEnvironment() {
        return ENVIRONMENT_CONFIG.getValue("/env").toString();
    }

    public EnvData getEnvData() {
        String envConfigPath = "%s%s.json".formatted(ENVIRONMENT_PATH, getCurrentEnvironment());
        return deserializeJson(envConfigPath, EnvData.class);
    }
}