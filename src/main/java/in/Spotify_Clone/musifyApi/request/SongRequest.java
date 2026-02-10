package in.Spotify_Clone.musifyApi.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SongRequest {

    private String name;

    private String desc;

    private String album;

    private MultipartFile audioFile;

    private MultipartFile imageFile;
}
