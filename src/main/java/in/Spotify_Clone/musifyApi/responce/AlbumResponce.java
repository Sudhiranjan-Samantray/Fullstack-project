package in.Spotify_Clone.musifyApi.responce;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlbumResponce {


    private Long id;

    private String name;

    private String desc;

    private String bgColour;

    private String imageUrl;
}
