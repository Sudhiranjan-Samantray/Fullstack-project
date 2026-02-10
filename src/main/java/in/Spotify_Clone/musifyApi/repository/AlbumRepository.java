package in.Spotify_Clone.musifyApi.repository;

import in.Spotify_Clone.musifyApi.Entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album,Long> {

}
