package in.Spotify_Clone.musifyApi.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import in.Spotify_Clone.musifyApi.Entity.Album;
import in.Spotify_Clone.musifyApi.repository.AlbumRepository;
import in.Spotify_Clone.musifyApi.request.AlbumRequest;
import in.Spotify_Clone.musifyApi.responce.AlbumResponce;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private Cloudinary cloudinary;

    public AlbumResponce addAlbum(AlbumRequest albumRequest) throws IOException {
       Map<String,Object>imageUploadResult =cloudinary.uploader().upload(albumRequest.getImageFile().getBytes(), ObjectUtils.asMap("resource_type","image"));
       Album newAlbum=Album.builder()
               .name(albumRequest.getName())
               .desc(albumRequest.getDesc())
               .bgColour(albumRequest.getBgColour())
               .imageUrl(imageUploadResult.get("secure_url").toString())
               .build();
       Album album= albumRepository.save(newAlbum);
       AlbumResponce albumResponce=new AlbumResponce();
        BeanUtils.copyProperties(album,albumResponce);
        return albumResponce;
    }

    public List<AlbumResponce>getAllAlbums()
    {
        List<Album>albums=albumRepository.findAll();
        List<AlbumResponce>albumResponces=new ArrayList<>();
        for(Album album:albums)
        {
            AlbumResponce albumResponce=new AlbumResponce();
            BeanUtils.copyProperties(album,albumResponce);
            albumResponces.add(albumResponce);
        }
        return albumResponces;
    }

    public Boolean removeAlbumById(Long id)
    {
        Album exitingAlbum=albumRepository.findById(id).orElseThrow(()->new RuntimeException("Album Not found"));
        albumRepository.delete(exitingAlbum);
        return true;
    }
}
