package in.Spotify_Clone.musifyApi.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {

//    #CLOUDINARY CONFIGURATION
//    cloudinary.cloud.name=dpoduaiza
//    cloudinary.api-key=447859555362688
//    cloudinary.api-secret=3UEBlwnTBvfQVWKuj1rZDSpxy9U

    @Value("${cloudinary.cloud.name}")
    private String cloudName;

    @Value("${cloudinary.api-key}")
    private String apiKey;

    @Value("${cloudinary.api-secret}")
    private String apiSecret;

    @Bean
    public Cloudinary  cloudinary()
    {
        return new Cloudinary(ObjectUtils.asMap("cloud_name",cloudName,"api_key",apiKey,"api_secret",apiSecret));
    }
}
