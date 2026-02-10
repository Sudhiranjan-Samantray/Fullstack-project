package in.Spotify_Clone.musifyApi.controller;

import in.Spotify_Clone.musifyApi.request.AlbumRequest;
import in.Spotify_Clone.musifyApi.responce.AlbumResponce;
import in.Spotify_Clone.musifyApi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/albums")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @PostMapping
    public ResponseEntity<?>addAlbum(@RequestPart("request") String request,
                                     @RequestPart("file")MultipartFile file) throws IOException {
        try {
            ObjectMapper objectMapper=new ObjectMapper();
            AlbumRequest albumRequest=objectMapper.readValue(request,AlbumRequest.class);
            albumRequest.setImageFile(file);
            AlbumResponce  albumResponce=albumService.addAlbum(albumRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(albumResponce);
        }
        catch (Exception e)
        {
           return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<AlbumResponce>>getAlbumList()
    {
        List<AlbumResponce>albumResponces=albumService.getAllAlbums();
        if (albumResponces!=null)
        {
            return new ResponseEntity<>(albumResponces,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping
    public ResponseEntity<String> removeAlbum(@RequestParam Long id) {
        boolean removed = albumService.removeAlbumById(id);
        if (removed) {
            return ResponseEntity.ok("Album deleted successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Album not found");
    }

}
