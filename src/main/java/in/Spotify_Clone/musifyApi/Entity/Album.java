package in.Spotify_Clone.musifyApi.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "Albums")
public class Album {

    @Id
    @JsonProperty("_id")
    private String id;

    private String name;

    private String desc;

    private String bgColour;

    private String imageUrl;

}


