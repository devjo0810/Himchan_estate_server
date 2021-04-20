package site.himchan.estate.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "upload")
@Getter
@Setter
public class PropertyUploadConfig {
    private String path;
    private String separator;
}
