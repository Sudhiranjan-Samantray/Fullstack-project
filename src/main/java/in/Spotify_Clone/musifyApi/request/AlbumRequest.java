package in.Spotify_Clone.musifyApi.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlbumRequest {

    private String name;

    private String desc;

    private String bgColour;

    private MultipartFile imageFile;
}
