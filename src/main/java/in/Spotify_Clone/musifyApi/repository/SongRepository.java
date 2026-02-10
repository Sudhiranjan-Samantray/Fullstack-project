package in.Spotify_Clone.musifyApi.repository;

import in.Spotify_Clone.musifyApi.Entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song,Long> {
}
