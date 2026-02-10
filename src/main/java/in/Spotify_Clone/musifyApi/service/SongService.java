package in.Spotify_Clone.musifyApi.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import in.Spotify_Clone.musifyApi.Entity.Song;
import in.Spotify_Clone.musifyApi.repository.SongRepository;
import in.Spotify_Clone.musifyApi.request.SongRequest;
import in.Spotify_Clone.musifyApi.responce.SongResponce;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
public class SongService {

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private Cloudinary cloudinary;

    public SongResponce addSong(SongRequest songRequest) throws IOException {
       Map<String,Object>audioUploadResult=cloudinary.uploader().upload(songRequest.getAudioFile().getBytes(), ObjectUtils.asMap("resource_type","video"));
       Map<String,Object>imageUploadResult=cloudinary.uploader().upload(songRequest.getImageFile().getBytes(),ObjectUtils.asMap("resource_type","image"));

        Double durationSeconds=(Double)audioUploadResult.get("duration");

        String duration=formatDuration(durationSeconds);
        Song newsong=Song.builder().name(songRequest.getName())
                .desc(songRequest.getDesc())
                .album(songRequest.getAlbum())
                .image(imageUploadResult.get("secure_url").toString())
                .file(audioUploadResult.get("secure_url").toString())
                .build();
        Song song=songRepository.save(newsong);

        SongResponce songResponce=new SongResponce();
        BeanUtils.copyProperties(song,songResponce);
        return songResponce;
    }

    private String formatDuration(Double durationSeconds)
    {
        if(durationSeconds==null)
        {
            return "0.00";
        }
        int minutes=(int)(durationSeconds/60);
        int seconds=(int)(durationSeconds%60);

        return String.format("%d:%02d",minutes,seconds);
    }
}
