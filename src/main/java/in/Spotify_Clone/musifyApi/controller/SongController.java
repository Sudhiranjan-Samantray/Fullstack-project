package in.Spotify_Clone.musifyApi.controller;

import in.Spotify_Clone.musifyApi.request.SongRequest;
import in.Spotify_Clone.musifyApi.responce.SongResponce;
import in.Spotify_Clone.musifyApi.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;

@RestController
@RequestMapping("/api/songs")
public class SongController {

    @Autowired
    private SongService songService;

    @PostMapping
    public ResponseEntity<?>addSong(@RequestPart("request") String request,
                                    @RequestPart("audio")MultipartFile audioFile, @RequestPart("image") MultipartFile image) throws IOException {
        ObjectMapper  objectMapper=new ObjectMapper();
       SongRequest songRequest= objectMapper.readValue(request,SongRequest.class);
       songRequest.setAudioFile(audioFile);
       songRequest.setImageFile(image);
        SongResponce songResponce=songService.addSong(songRequest);
        if(songResponce!=null)
        {
            return ResponseEntity.status(HttpStatus.CREATED).body(songResponce);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

    }

}
