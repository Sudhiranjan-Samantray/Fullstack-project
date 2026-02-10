package in.Spotify_Clone.musifyApi.dto;

import in.Spotify_Clone.musifyApi.Entity.Song;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SongListResponce {

    private Boolean success;

    private List<Song> songs;
}
